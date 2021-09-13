package com.midashnt.taekwondo.generator;



import com.midashnt.taekwondo.util.MidasHnTStringUtil;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CodeGenerator {

    public static final String FILE_PATH    = "C:\\Users\\owner\\Desktop\\taekwondo";
    public static final String DELIMITER    = "_";
    public static final String DOT          = ".";
    public static final String TAB_STR      = "\t";
    public static final String LINE         = System.getProperty("line.separator");
    public static final String NEWLINE      = LINE.replace("\n", LINE);

    /************************ 변경 필요 변수 START ************************/

    public static final String PROJECT_ROOT         = "com.midashnt.taekwondo.app";

    public static final String TABLE_NAME           = "TB_WEIGHT_CLASS";
    public static final String CREATE_OBJECT_NAME   = "WeightClass";

    public static final String[] TABLE_COLUMN_ARR = new String[]{
            "WEIGHT_CLASS_INDEX",          // PK
            "EVENT_INDEX",    // FK(PARENT KEY) 없을 경우 NONE
            "WEIGHT_CLASS_NAME",
            "ROUND_CNT",

            "ROUND_ONE_GAME_TIME",
            "ROUND_ONE_BREAK_TIME",
            "ROUND_ONE_DOUBLE_TARGET_MITT_CNT",
            "ROUND_ONE_LARGE_MITT_CNT",

            "ROUND_TWO_GAME_TIME",
            "ROUND_TWO_BREAK_TIME",
            "ROUND_TWO_DOUBLE_TARGET_MITT_CNT",
            "ROUND_TWO_LARGE_MITT_CNT",

            "ROUND_TREE_GAME_TIME",
            "ROUND_TREE_BREAK_TIME",
            "ROUND_TREE_DOUBLE_TARGET_MITT_CNT",
            "ROUND_TREE_LARGE_MITT_CNT",

            "ROUND_FOUR_GAME_TIME",
            "ROUND_FOUR_BREAK_TIME",
            "ROUND_FOUR_DOUBLE_TARGET_MITT_CNT",
            "ROUND_FOUR_LARGE_MITT_CNT",

            "ROUND_FIVE_GAME_TIME",
            "ROUND_FIVE_BREAK_TIME",
            "ROUND_FIVE_DOUBLE_TARGET_MITT_CNT",
            "ROUND_FIVE_LARGE_MITT_CNT"
    };

    public static final Map<String, String> INTEGER_COLUMN_WORD = new HashMap<String, String>() {
        {
            put("index", "INDEX");
            put("cnt", "CNT");
            put("time", "TIME");
        }
    };

    /************************ 변경 필요 변수 END ************************/

    public static String[] FILE_ARR = new String[6];

    public static String DTO_ROOT           = "";
    public static String MAPPER_ROOT        = "";
    public static String SERVICE_ROOT       = "";
    public static String CONTROLLER_ROOT    = "";

    public static String CAMEL_OBJECT_NAME  = "";
    public static String PASCAL_OBJECT_NAME = "";

    public static void main(String[] args) {
        CodeGenerator codeGenerator = new CodeGenerator();

        codeGenerator.settingObjectValue();

        codeGenerator.createDTO();
        codeGenerator.createMapper();
        codeGenerator.createService();
        codeGenerator.createServiceImpl();
        codeGenerator.createController();
        codeGenerator.createSQLFile();

    }

    public void settingObjectValue() {

        // 생성 파일 이름
        FILE_ARR[0] = CREATE_OBJECT_NAME + DOT + "java";
        FILE_ARR[1] = CREATE_OBJECT_NAME + "Mapper" + DOT + "java";
        FILE_ARR[2] = CREATE_OBJECT_NAME + "Service" + DOT + "java";
        FILE_ARR[3] = CREATE_OBJECT_NAME + "ServiceImpl" + DOT + "java";
        FILE_ARR[4] = CREATE_OBJECT_NAME + "Controller" + DOT + "java";
        FILE_ARR[5] = CREATE_OBJECT_NAME + "_SQL" + DOT + "xml";

        // 객체 파스칼 케이스
        PASCAL_OBJECT_NAME = CREATE_OBJECT_NAME.substring(0, 1).toUpperCase() + CREATE_OBJECT_NAME.substring(1);

        // 객체 카멜 케이스
        CAMEL_OBJECT_NAME = CREATE_OBJECT_NAME.substring(0, 1).toLowerCase() + CREATE_OBJECT_NAME.substring(1);

        DTO_ROOT = PROJECT_ROOT + DOT + "dto";
        MAPPER_ROOT = PROJECT_ROOT + DOT + "mapper";
        SERVICE_ROOT = PROJECT_ROOT + DOT + "service";
        CONTROLLER_ROOT = PROJECT_ROOT + DOT + "controller";

    }

    public void createDTO() {
        File file = new File(FILE_PATH + File.separator + FILE_ARR[0]);

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

            writer.write("package " + DTO_ROOT + ";" + NEWLINE);

            writer.write("import org.springframework.stereotype.Component;" + NEWLINE);
            writer.write("@Component" + LINE);
            writer.write("public class " + PASCAL_OBJECT_NAME + " {" + NEWLINE);

            for (String column : TABLE_COLUMN_ARR) {
                if (!column.equals("NONE")) {
                    writer.write(TAB_STR + "public static final String COLUMN_NAME_" + column + " = \"" + column + "\";" + LINE);

                    String javaVariable = combineJavaVariable(column);

                    writer.write(TAB_STR + "public static final String KEY_" + column + " = \"" + javaVariable + "\";" + LINE);

                    String[] columnWordArr = MidasHnTStringUtil.getTokenizedStringsWithDelimiter(column, DELIMITER);

                    assert columnWordArr != null;
                    if (INTEGER_COLUMN_WORD.containsKey(columnWordArr[columnWordArr.length-1].toLowerCase())) {
                        writer.write(TAB_STR + "private int " + javaVariable + ";" + NEWLINE);
                    } else {
                        writer.write(TAB_STR + "private String " + javaVariable + ";" + NEWLINE);
                    }
                }
            }

            for (String column : TABLE_COLUMN_ARR) {
                if (!column.equals("NONE")) {
                    String javaVariable = combineJavaVariable(column);
                    String upperJavaVariable = javaVariable.substring(0, 1).toUpperCase() + javaVariable.substring(1);

                    String[] columnWordArr = MidasHnTStringUtil.getTokenizedStringsWithDelimiter(column, DELIMITER);

                    assert columnWordArr != null;
                    if (INTEGER_COLUMN_WORD.containsKey(columnWordArr[columnWordArr.length-1].toLowerCase())) {
                        writer.write(TAB_STR + "public int get" + upperJavaVariable + " () {" + LINE + TAB_STR + TAB_STR + "return " + javaVariable + ";" + LINE + TAB_STR +"}"  + NEWLINE);
                        writer.write(TAB_STR + "public void set" + upperJavaVariable + " (int " + javaVariable + ") {" + LINE + TAB_STR + TAB_STR + "this." + javaVariable + " = " + javaVariable + ";" + LINE + TAB_STR +"}"  + NEWLINE);
                    } else {
                        writer.write(TAB_STR + "public String get" + upperJavaVariable + " () {" + LINE + TAB_STR + TAB_STR + "return " + javaVariable + ";" + LINE + TAB_STR +"}"  + NEWLINE);
                        writer.write(TAB_STR + "public void set" + upperJavaVariable + " (String " + javaVariable + ") {" + LINE + TAB_STR + TAB_STR + "this." + javaVariable + " = " + javaVariable + ";" + LINE + TAB_STR +"}"  + NEWLINE);
                    }
                }
            }

            writer.write("}");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createMapper() {
        File file = new File(FILE_PATH + File.separator + FILE_ARR[1]);

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

            writer.write("package " + MAPPER_ROOT + ";" + NEWLINE);

            writer.write("import " + DTO_ROOT + DOT + PASCAL_OBJECT_NAME + ";" + LINE);
            writer.write("import org.apache.ibatis.annotations.Mapper;" + LINE);
            writer.write("import org.springframework.stereotype.Repository;" + NEWLINE);

            if (!TABLE_COLUMN_ARR[1].equals("NONE")) {
                writer.write("import java.util.List;" + NEWLINE);
            }

            writer.write("@Repository" + LINE);
            writer.write("@Mapper" + LINE);
            writer.write("public interface " + PASCAL_OBJECT_NAME + "Mapper {" + NEWLINE);

            // create
            writer.write(TAB_STR + "String create" + PASCAL_OBJECT_NAME + "(" + PASCAL_OBJECT_NAME + " " + CAMEL_OBJECT_NAME + ");" + NEWLINE);

            // update
            writer.write(TAB_STR + "void update" + PASCAL_OBJECT_NAME + "(" + PASCAL_OBJECT_NAME + " " + CAMEL_OBJECT_NAME + ");" + NEWLINE);

            // read(단건 - table index)
            writer.write(TAB_STR + PASCAL_OBJECT_NAME + " get" + PASCAL_OBJECT_NAME + "ByIndex(int " + combineJavaVariable(TABLE_COLUMN_ARR[0]) + ");" + NEWLINE);

            // read(다건 - Parent index)
            if (!TABLE_COLUMN_ARR[1].equals("NONE")) {
                writer.write(TAB_STR + "List<" + PASCAL_OBJECT_NAME + "> get" + PASCAL_OBJECT_NAME + "ListBy" + combineJavaVariable(TABLE_COLUMN_ARR[1]).substring(0, 1).toUpperCase() + combineJavaVariable(TABLE_COLUMN_ARR[1]).substring(1)
                        + "(int " + combineJavaVariable(TABLE_COLUMN_ARR[1]) + ");" + NEWLINE);
            }

            //delete
            writer.write(TAB_STR + "void delete" + PASCAL_OBJECT_NAME + "(int " + combineJavaVariable(TABLE_COLUMN_ARR[0]) + ");" + NEWLINE);

            writer.write("}");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createService() {
        File file = new File(FILE_PATH + File.separator + FILE_ARR[2]);

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

            writer.write("package " + SERVICE_ROOT + ";" + NEWLINE);

            writer.write("import " + DTO_ROOT + DOT + PASCAL_OBJECT_NAME + ";" + NEWLINE);

            if (!TABLE_COLUMN_ARR[1].equals("NONE")) {
                writer.write("import java.util.List;" + NEWLINE);
            }

            writer.write("public interface " + PASCAL_OBJECT_NAME + "Service {" + NEWLINE);

            // create
            writer.write(TAB_STR + "void create" + PASCAL_OBJECT_NAME + "(" + PASCAL_OBJECT_NAME + " " + CAMEL_OBJECT_NAME + ");" + NEWLINE);

            // update
            writer.write(TAB_STR + "void update" + PASCAL_OBJECT_NAME + "(" + PASCAL_OBJECT_NAME + " " + CAMEL_OBJECT_NAME + ");" + NEWLINE);

            // read(단건 - table index)
            writer.write(TAB_STR + PASCAL_OBJECT_NAME + " get" + PASCAL_OBJECT_NAME + "ByIndex(int " + combineJavaVariable(TABLE_COLUMN_ARR[0]) + ");" + NEWLINE);

            // read(다건 - Parent index)
            if (!TABLE_COLUMN_ARR[1].equals("NONE")) {
                writer.write(TAB_STR + "List<" + PASCAL_OBJECT_NAME + "> get" + PASCAL_OBJECT_NAME + "ListBy" + combineJavaVariable(TABLE_COLUMN_ARR[1]).substring(0, 1).toUpperCase() + combineJavaVariable(TABLE_COLUMN_ARR[1]).substring(1)
                        + "(int " + combineJavaVariable(TABLE_COLUMN_ARR[1]) + ");" + NEWLINE);
            }

            //delete
            writer.write(TAB_STR + "void delete" + PASCAL_OBJECT_NAME + "(int " + combineJavaVariable(TABLE_COLUMN_ARR[0]) + ");" + NEWLINE);

            writer.write("}");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createServiceImpl() {
        File file = new File(FILE_PATH + File.separator + FILE_ARR[3]);

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

            writer.write("package " + SERVICE_ROOT + ";" + NEWLINE);

            writer.write("import " + DTO_ROOT + DOT + PASCAL_OBJECT_NAME + ";" + LINE);
            writer.write("import " + MAPPER_ROOT + DOT + PASCAL_OBJECT_NAME + "Mapper;" + LINE);
            writer.write("import org.springframework.beans.factory.annotation.Autowired;" + LINE);
            writer.write("import org.springframework.stereotype.Service;" + LINE);
            writer.write("import org.springframework.transaction.annotation.Propagation;" + LINE);
            writer.write("import org.springframework.transaction.annotation.Transactional;" + NEWLINE);

            if (!TABLE_COLUMN_ARR[1].equals("NONE")) {
                writer.write("import java.util.List;" + NEWLINE);
            }

            writer.write("@Service" + LINE);
            writer.write("public class " + PASCAL_OBJECT_NAME + "ServiceImpl implements " + PASCAL_OBJECT_NAME + "Service {" + NEWLINE);

            writer.write(TAB_STR + "protected " + PASCAL_OBJECT_NAME + "Mapper " + CAMEL_OBJECT_NAME + "Mapper;" + NEWLINE);

            writer.write(TAB_STR + "@Autowired" + LINE);
            writer.write(TAB_STR + "public " + PASCAL_OBJECT_NAME + "ServiceImpl(" + PASCAL_OBJECT_NAME + "Mapper " + CAMEL_OBJECT_NAME + "Mapper) {" + LINE);
            writer.write(TAB_STR + TAB_STR + "this" + DOT + CAMEL_OBJECT_NAME + "Mapper = " + CAMEL_OBJECT_NAME + "Mapper;" + LINE);
            writer.write(TAB_STR + "}" + NEWLINE);

            // create
            writer.write(TAB_STR + "@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)" + LINE);
            writer.write(TAB_STR + "@Override" + LINE);
            writer.write(TAB_STR + "public void create" + PASCAL_OBJECT_NAME + "(" + PASCAL_OBJECT_NAME + " " + CAMEL_OBJECT_NAME + ") {" + LINE);
            writer.write(TAB_STR + TAB_STR + CAMEL_OBJECT_NAME + "Mapper" + DOT + "create" + PASCAL_OBJECT_NAME + "(" + CAMEL_OBJECT_NAME + ");" + LINE);
            writer.write(TAB_STR + "}" + NEWLINE);

            // update
            writer.write(TAB_STR + "@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)" + LINE);
            writer.write(TAB_STR + "@Override" + LINE);
            writer.write(TAB_STR + "public void update" + PASCAL_OBJECT_NAME + "(" + PASCAL_OBJECT_NAME + " " + CAMEL_OBJECT_NAME + ") {" + LINE);
            writer.write(TAB_STR + TAB_STR + CAMEL_OBJECT_NAME + "Mapper" + DOT + "update" + PASCAL_OBJECT_NAME + "(" + CAMEL_OBJECT_NAME + ");" + LINE);
            writer.write(TAB_STR + "}" + NEWLINE);

            // read(단건 - table index)
            writer.write(TAB_STR + "@Transactional(propagation = Propagation.REQUIRED, readOnly = true, rollbackFor = Exception.class)" + LINE);
            writer.write(TAB_STR + "@Override" + LINE);
            writer.write(TAB_STR + "public " + PASCAL_OBJECT_NAME + " get" + PASCAL_OBJECT_NAME + "ByIndex(int " + combineJavaVariable(TABLE_COLUMN_ARR[0]) + ") {" + LINE);
            writer.write(TAB_STR + TAB_STR + "return " + CAMEL_OBJECT_NAME + "Mapper" + DOT + "get" + PASCAL_OBJECT_NAME + "ByIndex(" + combineJavaVariable(TABLE_COLUMN_ARR[0]) + ");" + LINE);
            writer.write(TAB_STR + "}" + NEWLINE);

            // read(다건 - Parent index)
            if (!TABLE_COLUMN_ARR[1].equals("NONE")) {
                writer.write(TAB_STR + "@Transactional(propagation = Propagation.REQUIRED, readOnly = true, rollbackFor = Exception.class)" + LINE);
                writer.write(TAB_STR + "@Override" + LINE);
                writer.write(TAB_STR + "public List<" + PASCAL_OBJECT_NAME + "> get" + PASCAL_OBJECT_NAME + "ListBy" + combineJavaVariable(TABLE_COLUMN_ARR[1]).substring(0, 1).toUpperCase() + combineJavaVariable(TABLE_COLUMN_ARR[1]).substring(1)
                        + "(int " + combineJavaVariable(TABLE_COLUMN_ARR[1]) + ") {" + LINE);
                writer.write(TAB_STR + TAB_STR + "return " + CAMEL_OBJECT_NAME + "Mapper" + DOT + "get" + PASCAL_OBJECT_NAME + "ListBy"  + combineJavaVariable(TABLE_COLUMN_ARR[1]).substring(0, 1).toUpperCase() + combineJavaVariable(TABLE_COLUMN_ARR[1]).substring(1)
                        + "(" + combineJavaVariable(TABLE_COLUMN_ARR[1]) + ");" + LINE);
                writer.write(TAB_STR + "}" + NEWLINE);
            }

            //delete
            writer.write(TAB_STR + "@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)" + LINE);
            writer.write(TAB_STR + "@Override" + LINE);
            writer.write(TAB_STR + "public void delete" + PASCAL_OBJECT_NAME + "(int " + combineJavaVariable(TABLE_COLUMN_ARR[0]) + ") {" + LINE);
            writer.write(TAB_STR + TAB_STR + CAMEL_OBJECT_NAME + "Mapper" + DOT + "delete" + PASCAL_OBJECT_NAME + "(" + combineJavaVariable(TABLE_COLUMN_ARR[0]) + ");" + LINE);
            writer.write(TAB_STR + "}" + NEWLINE);

            writer.write("}");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createController() {
        File file = new File(FILE_PATH + File.separator + FILE_ARR[4]);

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

            writer.write("package " + CONTROLLER_ROOT + ";" + NEWLINE);

            writer.write("import com.google.gson.Gson;" + LINE);
            writer.write("import com.google.gson.JsonElement;" + LINE);
            writer.write("import com.google.gson.JsonObject;" + LINE);
            writer.write("import " + DTO_ROOT  + DOT + PASCAL_OBJECT_NAME + ";" + LINE);
            writer.write("import " + SERVICE_ROOT + DOT + PASCAL_OBJECT_NAME + "Service;" + LINE);
            writer.write("import org.springframework.beans.factory.annotation.Autowired;" + LINE);
            writer.write("import org.springframework.http.HttpStatus;" + LINE);
            writer.write("import org.springframework.web.bind.annotation.*;" + NEWLINE);

            writer.write("import javax.servlet.http.HttpServletResponse;" + LINE);
            writer.write("import java.util.*;" + NEWLINE);

            writer.write("@RestController" + LINE);
            writer.write("@RequestMapping(value = \"/v1/" + CAMEL_OBJECT_NAME + "\")" + LINE);
            writer.write("public class " + PASCAL_OBJECT_NAME + "Controller {" + NEWLINE);

            writer.write(TAB_STR + "protected " + PASCAL_OBJECT_NAME + "Service " + CAMEL_OBJECT_NAME + "Service;" + LINE);
            writer.write(TAB_STR + "protected Gson gson = new Gson();" + NEWLINE);

            writer.write(TAB_STR + "@Autowired" + LINE);
            writer.write(TAB_STR + "public " + PASCAL_OBJECT_NAME + "Controller(" + PASCAL_OBJECT_NAME + "Service " + CAMEL_OBJECT_NAME + "Service) {" + LINE);
            writer.write(TAB_STR + TAB_STR + "this" + DOT + CAMEL_OBJECT_NAME + "Service = " + CAMEL_OBJECT_NAME + "Service;" + LINE);
            writer.write(TAB_STR + "}" + NEWLINE);

            // create
            writer.write(TAB_STR + "@PostMapping(value = \"/create-" + CREATE_OBJECT_NAME.toLowerCase() + "\")" + LINE);
            writer.write(TAB_STR + "public String create" + PASCAL_OBJECT_NAME + "(@RequestParam Map<String, Object> data, HttpServletResponse response) {" + LINE);

            writeTryAndCreateObjectCode(writer, true);
            writer.write(TAB_STR + TAB_STR + TAB_STR + CAMEL_OBJECT_NAME + "Service" + DOT + "create" + PASCAL_OBJECT_NAME + "(" + CAMEL_OBJECT_NAME + ");" + LINE);
            writeCatchAndReturnCode(writer);

            // update
            writer.write(TAB_STR + "@PutMapping(value = \"/update-" + CREATE_OBJECT_NAME.toLowerCase() + "\")" + LINE);
            writer.write(TAB_STR + "public String update" + PASCAL_OBJECT_NAME + "(@RequestParam Map<String, Object> data, HttpServletResponse response) {" + LINE);

            writeTryAndCreateObjectCode(writer, true);
            writer.write(TAB_STR + TAB_STR + TAB_STR + CAMEL_OBJECT_NAME + "Service" + DOT + "update" + PASCAL_OBJECT_NAME + "(" + CAMEL_OBJECT_NAME + ");" + LINE);
            writeCatchAndReturnCode(writer);

            // read(다건 - Parent index)
            if (!TABLE_COLUMN_ARR[1].equals("NONE")) {
                String[] columnWordArr = MidasHnTStringUtil.getTokenizedStringsWithDelimiter(TABLE_COLUMN_ARR[1], DELIMITER);
                StringBuilder reqParentIndexStr = new StringBuilder();
                String parentIndex = combineJavaVariable(TABLE_COLUMN_ARR[1]);

                assert columnWordArr != null;
                for (int i = 0; i < columnWordArr.length; i++) {
                    reqParentIndexStr.append(columnWordArr[i].toLowerCase());
                    if(i != columnWordArr.length-1)
                        reqParentIndexStr.append("-");
                }

                writer.write(TAB_STR + "@GetMapping(value = \"/get-" + CREATE_OBJECT_NAME.toLowerCase() + "-list-by-" + reqParentIndexStr + "/{" + parentIndex + "}\")" + LINE);
                writer.write(TAB_STR + "public String get" + PASCAL_OBJECT_NAME + "ListBy" + parentIndex.substring(0, 1).toUpperCase() + parentIndex.substring(1) + "(@PathVariable(" + PASCAL_OBJECT_NAME + DOT + "KEY_" + TABLE_COLUMN_ARR[1] + ") int " + parentIndex + ", HttpServletResponse response) {" + LINE);

                writeTryAndCreateObjectCode(writer);
                writer.write(TAB_STR + TAB_STR + TAB_STR + "List<" + PASCAL_OBJECT_NAME + "> " + CAMEL_OBJECT_NAME + "List = "
                        + CAMEL_OBJECT_NAME + "Service" + DOT + "get" + PASCAL_OBJECT_NAME + "ListBy" + parentIndex.substring(0, 1).toUpperCase() + parentIndex.substring(1) + "(" + parentIndex + ");" + LINE);
                writer.write(TAB_STR + TAB_STR + TAB_STR + "JsonElement element = gson.toJsonTree(" + CAMEL_OBJECT_NAME + "List);" + LINE);
                writer.write(TAB_STR + TAB_STR + TAB_STR + "object = element.getAsJsonObject();" + LINE);

                writeCatchAndReturnCode(writer);
            }

            // delete
            writer.write(TAB_STR + "@DeleteMapping(value = \"/delete-" + CREATE_OBJECT_NAME.toLowerCase() + "/{" + combineJavaVariable(TABLE_COLUMN_ARR[0]) + "}\")" + LINE);
            writer.write(TAB_STR + "public String delete" + PASCAL_OBJECT_NAME + "(@PathVariable(" + PASCAL_OBJECT_NAME + DOT + "KEY_" + TABLE_COLUMN_ARR[0] + ") int " + combineJavaVariable(TABLE_COLUMN_ARR[0]) + ", HttpServletResponse response) {" + LINE);

            writeTryAndCreateObjectCode(writer);
            writer.write(TAB_STR + TAB_STR + TAB_STR + CAMEL_OBJECT_NAME + "Service" + DOT + "delete" + PASCAL_OBJECT_NAME + "(" + combineJavaVariable(TABLE_COLUMN_ARR[0]) + ");" + LINE);
            writeCatchAndReturnCode(writer);

            writer.write("}");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeTryAndCreateObjectCode(BufferedWriter writer) {
        writeTryAndCreateObjectCode(writer, false);
    }

    private void writeTryAndCreateObjectCode(BufferedWriter writer, boolean isCreateDTO) {
        try {
            writer.write(TAB_STR + TAB_STR + "JsonObject object = new JsonObject();" + NEWLINE);
            writer.write(TAB_STR + TAB_STR + "try {" + LINE);

            if(isCreateDTO) {
                writer.write(TAB_STR + TAB_STR + TAB_STR +  PASCAL_OBJECT_NAME + " " + CAMEL_OBJECT_NAME + " = new " + PASCAL_OBJECT_NAME + "();" + LINE);
                for (int i = 1; i < TABLE_COLUMN_ARR.length; i++) {
                    if (!TABLE_COLUMN_ARR[i].equals("NONE")) {
                        String javaVariable = combineJavaVariable(TABLE_COLUMN_ARR[i]);
                        String[] columnWordArr = MidasHnTStringUtil.getTokenizedStringsWithDelimiter(TABLE_COLUMN_ARR[i], DELIMITER);

                        assert columnWordArr != null;
                        if (INTEGER_COLUMN_WORD.containsKey(columnWordArr[columnWordArr.length-1].toLowerCase())) {
                            writer.write(TAB_STR + TAB_STR + TAB_STR + CAMEL_OBJECT_NAME + DOT + "set" + javaVariable.substring(0, 1).toUpperCase() + javaVariable.substring(1)
                                    + "(Integer.parseInt((String)data.get(" + PASCAL_OBJECT_NAME + DOT + "KEY_" + TABLE_COLUMN_ARR[i] + ")));" + LINE);
                        } else {
                            writer.write(TAB_STR + TAB_STR + TAB_STR + CAMEL_OBJECT_NAME + DOT + "set" + javaVariable.substring(0, 1).toUpperCase() + javaVariable.substring(1)
                                    + "((String)data.get(" + PASCAL_OBJECT_NAME + DOT + "KEY_" + TABLE_COLUMN_ARR[i] + "));" + LINE);
                        }
                    }
                }
                writer.write(LINE);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeCatchAndReturnCode(BufferedWriter writer) {
        try {
            writer.write(TAB_STR + TAB_STR + "} catch (Exception e) {" + LINE);
            writer.write(TAB_STR + TAB_STR + TAB_STR + "response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());" + LINE);
            writer.write(TAB_STR + TAB_STR + TAB_STR + "e.printStackTrace();" + LINE);
            writer.write(TAB_STR + TAB_STR + "}" + NEWLINE);

            writer.write(TAB_STR + TAB_STR + "return object.toString();" + LINE);
            writer.write(TAB_STR + "}" + NEWLINE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createSQLFile() {
        File file = new File(FILE_PATH + File.separator + FILE_ARR[5]);

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + LINE);
            writer.write("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">" + NEWLINE);
            writer.write("<mapper namespace=\"" + MAPPER_ROOT + DOT + PASCAL_OBJECT_NAME +"Mapper\">" + NEWLINE);

            // create
            writer.write(TAB_STR + "<insert id=\"create" + PASCAL_OBJECT_NAME + "\" parameterType= \"" +PASCAL_OBJECT_NAME+ "\">" + LINE);
            writer.write(TAB_STR + TAB_STR + "INSERT INTO " + TABLE_NAME + "(");

            int cnt = 0;
            for (int i = 1; i < TABLE_COLUMN_ARR.length; i++) {
                if (!TABLE_COLUMN_ARR[i].equals("NONE")) {
                    if (cnt == 0) {
                        writer.write(TABLE_COLUMN_ARR[i] + LINE);
                        cnt++;
                        continue;
                    }

                    if (i < TABLE_COLUMN_ARR.length - 1) {
                        writer.write(TAB_STR + TAB_STR + TAB_STR + TAB_STR + ", " + TABLE_COLUMN_ARR[i] + LINE);
                    } else {
                        writer.write(TAB_STR + TAB_STR + TAB_STR + TAB_STR + ", " + TABLE_COLUMN_ARR[i] + ")" + LINE);
                    }
                }
            }

            writer.write(TAB_STR + TAB_STR + "VALUE(#{");

            cnt = 0;
            for (int i = 1; i < TABLE_COLUMN_ARR.length; i++) {
                if (!TABLE_COLUMN_ARR[i].equals("NONE")) {
                    if (cnt == 0) {
                        writer.write(combineJavaVariable(TABLE_COLUMN_ARR[i]) + "}" + LINE);
                        cnt++;
                        continue;
                    }

                    if (i < TABLE_COLUMN_ARR.length - 1) {
                        writer.write(TAB_STR + TAB_STR + TAB_STR + ", #{" + combineJavaVariable(TABLE_COLUMN_ARR[i]) + "}" + LINE);
                    } else {
                        writer.write(TAB_STR + TAB_STR + TAB_STR + ", #{" + combineJavaVariable(TABLE_COLUMN_ARR[i]) + "})" + LINE);
                    }
                }
            }

            writer.write(TAB_STR + "</insert>" + NEWLINE);

            // update
            writer.write(TAB_STR + "<update id=\"update" + PASCAL_OBJECT_NAME + "\" parameterType= \"" +PASCAL_OBJECT_NAME+ "\">" + LINE);
            writer.write(TAB_STR + TAB_STR + "UPDATE " + TABLE_NAME + LINE);

            int startIndex = 2;

            if (TABLE_COLUMN_ARR[1].equals("NONE")) {
                startIndex = 3;
                writer.write(TAB_STR + TAB_STR + "SET " + TABLE_COLUMN_ARR[2] + " = #{" + combineJavaVariable(TABLE_COLUMN_ARR[2]) + "}" + LINE);
            } else {
                writer.write(TAB_STR + TAB_STR + "SET " + TABLE_COLUMN_ARR[1] + " = #{" + combineJavaVariable(TABLE_COLUMN_ARR[1]) + "}" + LINE);
            }

            for (int i = startIndex; i < TABLE_COLUMN_ARR.length; i++) {
                String[] columnWordArr = MidasHnTStringUtil.getTokenizedStringsWithDelimiter(TABLE_COLUMN_ARR[i], DELIMITER);

                assert columnWordArr != null;
                if (INTEGER_COLUMN_WORD.containsKey(columnWordArr[columnWordArr.length-1].toLowerCase())) {
                    writer.write(TAB_STR + TAB_STR + "<if test=\"" + combineJavaVariable(TABLE_COLUMN_ARR[i]) + " == 0 and " + combineJavaVariable(TABLE_COLUMN_ARR[i]) + " == 1" + "\">" + LINE);
                    writer.write(TAB_STR + TAB_STR + TAB_STR + ", " + TABLE_COLUMN_ARR[i] + " = #{" + combineJavaVariable(TABLE_COLUMN_ARR[i]) + "}" + LINE);
                    writer.write(TAB_STR + TAB_STR + "</if>" + LINE);
                } else {
                    writer.write(TAB_STR + TAB_STR + "<if test=\"" + combineJavaVariable(TABLE_COLUMN_ARR[i]) + " != null and !" + combineJavaVariable(TABLE_COLUMN_ARR[i]) + ".equals('')" + "\">" + LINE);
                    writer.write(TAB_STR + TAB_STR + TAB_STR + ", " + TABLE_COLUMN_ARR[i] + " = #{" + combineJavaVariable(TABLE_COLUMN_ARR[i]) + "}" + LINE);
                    writer.write(TAB_STR + TAB_STR + "</if>" + LINE);
                }
            }

            writer.write(TAB_STR + TAB_STR + "WHERE " + TABLE_COLUMN_ARR[0] + " = #{" + combineJavaVariable(TABLE_COLUMN_ARR[0]) + "}" + LINE);
            writer.write(TAB_STR + "</update>" + NEWLINE);

            // read(단건 - table index)
            writer.write(TAB_STR + "<select id=\"get" + PASCAL_OBJECT_NAME + "ByIndex\" parameterType= \"int\" resultType=\"" + PASCAL_OBJECT_NAME + "\">" + LINE);
            writer.write(TAB_STR + TAB_STR + "SELECT " + TABLE_COLUMN_ARR[0] + TAB_STR + TAB_STR + combineJavaVariable(TABLE_COLUMN_ARR[0]) + LINE);

            for (int i = 1; i < TABLE_COLUMN_ARR.length; i++) {
                if (!TABLE_COLUMN_ARR[i].equals("NONE")) {
                    writer.write(TAB_STR + TAB_STR + TAB_STR + ", " + TABLE_COLUMN_ARR[i] + TAB_STR + TAB_STR + combineJavaVariable(TABLE_COLUMN_ARR[i]) + LINE);
                }
            }

            writer.write(TAB_STR + TAB_STR + "FROM " + TABLE_NAME + LINE);
            writer.write(TAB_STR + TAB_STR + "WHERE " + TABLE_COLUMN_ARR[0] + " = #{" + combineJavaVariable(TABLE_COLUMN_ARR[0]) + "}" + LINE);
            writer.write(TAB_STR + "</select>" + NEWLINE);

            // read(다건 - Parent index)
            if (!TABLE_COLUMN_ARR[1].equals("NONE")) {
                writer.write(TAB_STR + "<select id=\"get" + PASCAL_OBJECT_NAME + "ListBy" + combineJavaVariable(TABLE_COLUMN_ARR[1]).substring(0, 1).toUpperCase() + combineJavaVariable(TABLE_COLUMN_ARR[1]).substring(1)
                        + "\" parameterType= \"int\" resultType=\"" + PASCAL_OBJECT_NAME + "\">" + LINE);
                writer.write(TAB_STR + TAB_STR + "SELECT " + TABLE_COLUMN_ARR[0] + TAB_STR + TAB_STR + combineJavaVariable(TABLE_COLUMN_ARR[0]) + LINE);

                for (int i = 1; i < TABLE_COLUMN_ARR.length; i++) {
                    if (!TABLE_COLUMN_ARR[i].equals("NONE")) {
                        writer.write(TAB_STR + TAB_STR + TAB_STR + ", " + TABLE_COLUMN_ARR[i] + TAB_STR + TAB_STR + combineJavaVariable(TABLE_COLUMN_ARR[i]) + LINE);
                    }
                }

                writer.write(TAB_STR + TAB_STR + "FROM " + TABLE_NAME + LINE);
                writer.write(TAB_STR + TAB_STR + "WHERE " + TABLE_COLUMN_ARR[1] + " = #{" + combineJavaVariable(TABLE_COLUMN_ARR[1]) + "}" + LINE);
                writer.write(TAB_STR + "</select>" + NEWLINE);
            }

            // delete
            writer.write(TAB_STR + "<delete id=\"delete" + PASCAL_OBJECT_NAME + "\" parameterType= \"int\">" + LINE);
            writer.write(TAB_STR + TAB_STR + "DELETE " + LINE);
            writer.write(TAB_STR + TAB_STR + "FROM " + TABLE_NAME + LINE);
            writer.write(TAB_STR + TAB_STR + "WHERE " + TABLE_COLUMN_ARR[0] + " = #{" + combineJavaVariable(TABLE_COLUMN_ARR[0]) + "}" + LINE);
            writer.write(TAB_STR + "</delete>" + NEWLINE);

            writer.write("</mapper>" + LINE);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String combineJavaVariable(String column) {
        String[] columnWordArr = MidasHnTStringUtil.getTokenizedStringsWithDelimiter(column, DELIMITER);

        StringBuilder javaVariable = new StringBuilder();

        assert columnWordArr != null;
        for (int j = 0; j < columnWordArr.length; j++) {
            if (j == 0) {
                javaVariable = new StringBuilder(columnWordArr[j].toLowerCase());
            } else {
                javaVariable.append((columnWordArr[j].toLowerCase()).substring(0, 1).toUpperCase()).append((columnWordArr[j].toLowerCase()).substring(1));
            }
        }

        return javaVariable.toString();
    }

}