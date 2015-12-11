// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm.processor;

import io.realm.processor.javawriter.JavaWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RealmJsonTypeHelper
{
    private static interface JsonToRealmTypeConverter
    {

        public abstract void emitStreamTypeConversion(String s, String s1, String s2, JavaWriter javawriter)
            throws IOException;

        public abstract void emitTypeConversion(String s, String s1, String s2, JavaWriter javawriter)
            throws IOException;
    }

    private static class SimpleTypeConverter
        implements JsonToRealmTypeConverter
    {

        private final String castType;
        private final String jsonType;

        public void emitStreamTypeConversion(String s, String s1, String s2, JavaWriter javawriter)
            throws IOException
        {
            javawriter.emitStatement("obj.%s((%s) reader.next%s())", new Object[] {
                s, castType, jsonType
            });
        }

        public void emitTypeConversion(String s, String s1, String s2, JavaWriter javawriter)
            throws IOException
        {
            javawriter.beginControlFlow("if (!json.isNull(\"%s\"))", new Object[] {
                s1
            }).emitStatement("obj.%s((%s) json.get%s(\"%s\"))", new Object[] {
                s, castType, jsonType, s1
            }).endControlFlow();
        }

        private SimpleTypeConverter(String s, String s1)
        {
            castType = s;
            jsonType = s1;
        }

    }


    private static final Map JAVA_TO_JSON_TYPES;

    public RealmJsonTypeHelper()
    {
    }

    public static void emitFillJavaTypeFromStream(String s, String s1, String s2, JavaWriter javawriter)
        throws IOException
    {
        if (JAVA_TO_JSON_TYPES.containsKey(s2))
        {
            ((JsonToRealmTypeConverter)JAVA_TO_JSON_TYPES.get(s2)).emitStreamTypeConversion(s, s1, s2, javawriter);
        }
    }

    public static void emitFillJavaTypeWithJsonValue(String s, String s1, String s2, JavaWriter javawriter)
        throws IOException
    {
        JsonToRealmTypeConverter jsontorealmtypeconverter = (JsonToRealmTypeConverter)JAVA_TO_JSON_TYPES.get(s2);
        if (jsontorealmtypeconverter != null)
        {
            jsontorealmtypeconverter.emitTypeConversion(s, s1, s2, javawriter);
        }
    }

    public static void emitFillRealmListFromStream(String s, String s1, String s2, String s3, JavaWriter javawriter)
        throws IOException
    {
        javawriter.emitStatement("reader.beginArray()", new Object[0]).beginControlFlow("while (reader.hasNext())", new Object[0]).emitStatement("%s item = %s.createUsingJsonStream(realm, reader)", new Object[] {
            s2, s3
        }).emitStatement("obj.%s().add(item)", new Object[] {
            s
        }).endControlFlow().emitStatement("reader.endArray()", new Object[0]);
    }

    public static void emitFillRealmListWithJsonValue(String s, String s1, String s2, String s3, String s4, JavaWriter javawriter)
        throws IOException
    {
        javawriter.beginControlFlow("if (!json.isNull(\"%s\"))", new Object[] {
            s2
        }).emitStatement("obj.%s().clear()", new Object[] {
            s
        }).emitStatement("JSONArray array = json.getJSONArray(\"%s\")", new Object[] {
            s2
        }).beginControlFlow("for (int i = 0; i < array.length(); i++)", new Object[0]).emitStatement("%s item = %s.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update)", new Object[] {
            s3, s4, s3
        }).emitStatement("obj.%s().add(item)", new Object[] {
            s
        }).endControlFlow().endControlFlow();
    }

    public static void emitFillRealmObjectFromStream(String s, String s1, String s2, String s3, JavaWriter javawriter)
        throws IOException
    {
        javawriter.emitStatement("%s %sObj = %s.createUsingJsonStream(realm, reader)", new Object[] {
            s2, s1, s3
        }).emitStatement("obj.%s(%sObj)", new Object[] {
            s, s1
        });
    }

    public static void emitFillRealmObjectWithJsonValue(String s, String s1, String s2, String s3, JavaWriter javawriter)
        throws IOException
    {
        javawriter.beginControlFlow("if (!json.isNull(\"%s\"))", new Object[] {
            s1
        }).emitStatement("%s %sObj = %s.createOrUpdateUsingJsonObject(realm, json.getJSONObject(\"%s\"), update)", new Object[] {
            s2, s1, s3, s1
        }).emitStatement("obj.%s(%sObj)", new Object[] {
            s, s1
        }).endControlFlow();
    }

    static 
    {
        JAVA_TO_JSON_TYPES = new HashMap();
        JAVA_TO_JSON_TYPES.put("byte", new SimpleTypeConverter("byte", "Int"));
        JAVA_TO_JSON_TYPES.put("short", new SimpleTypeConverter("short", "Int"));
        JAVA_TO_JSON_TYPES.put("int", new SimpleTypeConverter("int", "Int"));
        JAVA_TO_JSON_TYPES.put("long", new SimpleTypeConverter("long", "Long"));
        JAVA_TO_JSON_TYPES.put("float", new SimpleTypeConverter("float", "Double"));
        JAVA_TO_JSON_TYPES.put("double", new SimpleTypeConverter("double", "Double"));
        JAVA_TO_JSON_TYPES.put("boolean", new SimpleTypeConverter("boolean", "Boolean"));
        JAVA_TO_JSON_TYPES.put("Byte", new SimpleTypeConverter("Byte", "Int"));
        JAVA_TO_JSON_TYPES.put("Short", new SimpleTypeConverter("Short", "Int"));
        JAVA_TO_JSON_TYPES.put("Integer", new SimpleTypeConverter("Integer", "Int"));
        JAVA_TO_JSON_TYPES.put("Long", new SimpleTypeConverter("Long", "Long"));
        JAVA_TO_JSON_TYPES.put("Float", new SimpleTypeConverter("Float", "Double"));
        JAVA_TO_JSON_TYPES.put("Double", new SimpleTypeConverter("Double", "Double"));
        JAVA_TO_JSON_TYPES.put("Boolean", new SimpleTypeConverter("Boolean", "Boolean"));
        JAVA_TO_JSON_TYPES.put("java.lang.String", new SimpleTypeConverter("String", "String"));
        JAVA_TO_JSON_TYPES.put("java.util.Date", new JsonToRealmTypeConverter() {

            public void emitStreamTypeConversion(String s, String s1, String s2, JavaWriter javawriter)
                throws IOException
            {
                javawriter.beginControlFlow("if (reader.peek() == JsonToken.NUMBER)", new Object[0]).emitStatement("long timestamp = reader.nextLong()", new Object[] {
                    s1
                }).beginControlFlow("if (timestamp > -1)", new Object[0]).emitStatement("obj.%s(new Date(timestamp))", new Object[] {
                    s
                }).endControlFlow().nextControlFlow("else", new Object[0]).emitStatement("obj.%s(JsonUtils.stringToDate(reader.nextString()))", new Object[] {
                    s
                }).endControlFlow();
            }

            public void emitTypeConversion(String s, String s1, String s2, JavaWriter javawriter)
                throws IOException
            {
                javawriter.beginControlFlow("if (!json.isNull(\"%s\"))", new Object[] {
                    s1
                }).emitStatement("Object timestamp = json.get(\"%s\")", new Object[] {
                    s1
                }).beginControlFlow("if (timestamp instanceof String)", new Object[0]).emitStatement("obj.%s(JsonUtils.stringToDate((String) timestamp))", new Object[] {
                    s
                }).nextControlFlow("else", new Object[0]).emitStatement("obj.%s(new Date(json.getLong(\"%s\")))", new Object[] {
                    s, s1
                }).endControlFlow().endControlFlow();
            }

        });
        JAVA_TO_JSON_TYPES.put("byte[]", new JsonToRealmTypeConverter() {

            public void emitStreamTypeConversion(String s, String s1, String s2, JavaWriter javawriter)
                throws IOException
            {
                javawriter.emitStatement("obj.%s(JsonUtils.stringToBytes(reader.nextString()))", new Object[] {
                    s
                });
            }

            public void emitTypeConversion(String s, String s1, String s2, JavaWriter javawriter)
                throws IOException
            {
                javawriter.beginControlFlow("if (!json.isNull(\"%s\"))", new Object[] {
                    s1
                }).emitStatement("obj.%s(JsonUtils.stringToBytes(json.getString(\"%s\")))", new Object[] {
                    s, s1
                }).endControlFlow();
            }

        });
    }
}
