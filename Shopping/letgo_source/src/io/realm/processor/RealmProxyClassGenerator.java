// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm.processor;

import io.realm.processor.javawriter.JavaWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.JavaFileObject;

// Referenced classes of package io.realm.processor:
//            ClassMetaData, Utils, RealmJsonTypeHelper

public class RealmProxyClassGenerator
{

    private static final Map CASTING_TYPES;
    private static final Map JAVA_TO_COLUMN_TYPES;
    private static final Map JAVA_TO_REALM_TYPES;
    private static final Map NULLABLE_JAVA_TYPES;
    private final String className;
    private Elements elementUtils;
    private ClassMetaData metadata;
    private ProcessingEnvironment processingEnvironment;
    private DeclaredType realmList;
    private TypeMirror realmObject;
    private Types typeUtils;

    public RealmProxyClassGenerator(ProcessingEnvironment processingenvironment, ClassMetaData classmetadata)
    {
        processingEnvironment = processingenvironment;
        metadata = classmetadata;
        className = classmetadata.getSimpleClassName();
    }

    private void emitAccessors(JavaWriter javawriter)
        throws IOException
    {
        Iterator iterator = metadata.getFields().iterator();
        while (iterator.hasNext()) 
        {
            VariableElement variableelement = (VariableElement)iterator.next();
            String s = variableelement.getSimpleName().toString();
            String s1 = variableelement.asType().toString();
            if (JAVA_TO_REALM_TYPES.containsKey(s1))
            {
                String s2 = (String)JAVA_TO_REALM_TYPES.get(s1);
                String s4 = (String)CASTING_TYPES.get(s1);
                javawriter.emitAnnotation("Override");
                javawriter.beginMethod(s1, metadata.getGetter(s), EnumSet.of(Modifier.PUBLIC), new String[0]);
                javawriter.emitStatement("realm.checkIfValid()", new Object[0]);
                javawriter.emitStatement("return (%s) row.get%s(%s)", new Object[] {
                    s1, s2, staticFieldIndexVarName(variableelement)
                });
                javawriter.endMethod();
                javawriter.emitEmptyLine();
                javawriter.emitAnnotation("Override");
                javawriter.beginMethod("void", metadata.getSetter(s), EnumSet.of(Modifier.PUBLIC), new String[] {
                    s1, "value"
                });
                javawriter.emitStatement("realm.checkIfValid()", new Object[0]);
                javawriter.emitStatement("row.set%s(%s, (%s) value)", new Object[] {
                    s2, staticFieldIndexVarName(variableelement), s4
                });
                javawriter.endMethod();
            } else
            if (typeUtils.isAssignable(variableelement.asType(), realmObject))
            {
                javawriter.emitAnnotation("Override");
                javawriter.beginMethod(s1, metadata.getGetter(s), EnumSet.of(Modifier.PUBLIC), new String[0]);
                javawriter.beginControlFlow("if (row.isNullLink(%s))", new Object[] {
                    staticFieldIndexVarName(variableelement)
                });
                javawriter.emitStatement("return null", new Object[0]);
                javawriter.endControlFlow();
                javawriter.emitStatement("return realm.get(%s.class, row.getLink(%s))", new Object[] {
                    s1, staticFieldIndexVarName(variableelement)
                });
                javawriter.endMethod();
                javawriter.emitEmptyLine();
                javawriter.emitAnnotation("Override");
                javawriter.beginMethod("void", metadata.getSetter(s), EnumSet.of(Modifier.PUBLIC), new String[] {
                    s1, "value"
                });
                javawriter.beginControlFlow("if (value == null)", new Object[0]);
                javawriter.emitStatement("row.nullifyLink(%s)", new Object[] {
                    staticFieldIndexVarName(variableelement)
                });
                javawriter.emitStatement("return", new Object[0]);
                javawriter.endControlFlow();
                javawriter.emitStatement("row.setLink(%s, value.row.getIndex())", new Object[] {
                    staticFieldIndexVarName(variableelement)
                });
                javawriter.endMethod();
            } else
            if (typeUtils.isAssignable(variableelement.asType(), realmList))
            {
                String s3 = Utils.getGenericType(variableelement);
                javawriter.emitAnnotation("Override");
                javawriter.beginMethod(s1, metadata.getGetter(s), EnumSet.of(Modifier.PUBLIC), new String[0]);
                javawriter.emitStatement("return new RealmList<%s>(%s.class, row.getLinkList(%s), realm)", new Object[] {
                    s3, s3, staticFieldIndexVarName(variableelement)
                });
                javawriter.endMethod();
                javawriter.emitEmptyLine();
                javawriter.emitAnnotation("Override");
                javawriter.beginMethod("void", metadata.getSetter(s), EnumSet.of(Modifier.PUBLIC), new String[] {
                    s1, "value"
                });
                javawriter.emitStatement("LinkView links = row.getLinkList(%s)", new Object[] {
                    staticFieldIndexVarName(variableelement)
                });
                javawriter.beginControlFlow("if (value == null)", new Object[0]);
                javawriter.emitStatement("return", new Object[0]);
                javawriter.endControlFlow();
                javawriter.emitStatement("links.clear()", new Object[0]);
                javawriter.beginControlFlow("for (RealmObject linkedObject : (RealmList<? extends RealmObject>) value)", new Object[0]);
                javawriter.emitStatement("links.add(linkedObject.row.getIndex())", new Object[0]);
                javawriter.endControlFlow();
                javawriter.endMethod();
            } else
            {
                throw new UnsupportedOperationException(String.format("Type %s of field %s is not supported", new Object[] {
                    s1, s
                }));
            }
            javawriter.emitEmptyLine();
        }
    }

    private void emitClassFields(JavaWriter javawriter)
        throws IOException
    {
        for (Iterator iterator = metadata.getFields().iterator(); iterator.hasNext(); javawriter.emitField("long", staticFieldIndexVarName((VariableElement)iterator.next()), EnumSet.of(Modifier.PRIVATE, Modifier.STATIC))) { }
        javawriter.emitField("Map<String, Long>", "columnIndices", EnumSet.of(Modifier.PRIVATE, Modifier.STATIC));
        javawriter.emitField("List<String>", "FIELD_NAMES", EnumSet.of(Modifier.PRIVATE, Modifier.STATIC, Modifier.FINAL));
        javawriter.beginInitializer(true);
        javawriter.emitStatement("List<String> fieldNames = new ArrayList<String>()", new Object[0]);
        for (Iterator iterator1 = metadata.getFields().iterator(); iterator1.hasNext(); javawriter.emitStatement("fieldNames.add(\"%s\")", new Object[] {
    ((VariableElement)iterator1.next()).getSimpleName().toString()
})) { }
        javawriter.emitStatement("FIELD_NAMES = Collections.unmodifiableList(fieldNames)", new Object[0]);
        javawriter.endInitializer();
        javawriter.emitEmptyLine();
    }

    private void emitCopyMethod(JavaWriter javawriter)
        throws IOException
    {
        javawriter.beginMethod(className, "copy", EnumSet.of(Modifier.PUBLIC, Modifier.STATIC), new String[] {
            "Realm", "realm", className, "newObject", "boolean", "update", "Map<RealmObject,RealmObjectProxy>", "cache"
        });
        if (metadata.hasPrimaryKey())
        {
            javawriter.emitStatement("%s realmObject = realm.createObject(%s.class, newObject.%s())", new Object[] {
                className, className, metadata.getPrimaryKeyGetter()
            });
        } else
        {
            javawriter.emitStatement("%s realmObject = realm.createObject(%s.class)", new Object[] {
                className, className
            });
        }
        javawriter.emitStatement("cache.put(newObject, (RealmObjectProxy) realmObject)", new Object[0]);
        for (Iterator iterator = metadata.getFields().iterator(); iterator.hasNext();)
        {
            VariableElement variableelement = (VariableElement)iterator.next();
            String s = variableelement.getSimpleName().toString();
            String s1 = variableelement.asType().toString();
            if (typeUtils.isAssignable(variableelement.asType(), realmObject))
            {
                javawriter.emitEmptyLine().emitStatement("%s %sObj = newObject.%s()", new Object[] {
                    s1, s, metadata.getGetter(s)
                }).beginControlFlow("if (%sObj != null)", new Object[] {
                    s
                }).emitStatement("%s cache%s = (%s) cache.get(%sObj)", new Object[] {
                    s1, s, s1, s
                }).beginControlFlow("if (cache%s != null)", new Object[] {
                    s
                }).emitStatement("realmObject.%s(cache%s)", new Object[] {
                    metadata.getSetter(s), s
                }).nextControlFlow("else", new Object[0]).emitStatement("realmObject.%s(%s.copyOrUpdate(realm, %sObj, update, cache))", new Object[] {
                    metadata.getSetter(s), Utils.getProxyClassSimpleName(variableelement), s
                }).endControlFlow().endControlFlow();
            } else
            if (typeUtils.isAssignable(variableelement.asType(), realmList))
            {
                javawriter.emitEmptyLine().emitStatement("RealmList<%s> %sList = newObject.%s()", new Object[] {
                    Utils.getGenericType(variableelement), s, metadata.getGetter(s)
                }).beginControlFlow("if (%sList != null)", new Object[] {
                    s
                }).emitStatement("RealmList<%s> %sRealmList = realmObject.%s()", new Object[] {
                    Utils.getGenericType(variableelement), s, metadata.getGetter(s)
                }).beginControlFlow("for (int i = 0; i < %sList.size(); i++)", new Object[] {
                    s
                }).emitStatement("%s %sItem = %sList.get(i)", new Object[] {
                    Utils.getGenericType(variableelement), s, s
                }).emitStatement("%s cache%s = (%s) cache.get(%sItem)", new Object[] {
                    Utils.getGenericType(variableelement), s, Utils.getGenericType(variableelement), s
                }).beginControlFlow("if (cache%s != null)", new Object[] {
                    s
                }).emitStatement("%sRealmList.add(cache%s)", new Object[] {
                    s, s
                }).nextControlFlow("else", new Object[0]).emitStatement("%sRealmList.add(%s.copyOrUpdate(realm, %sList.get(i), update, cache))", new Object[] {
                    s, Utils.getProxyClassSimpleName(variableelement), s
                }).endControlFlow().endControlFlow().endControlFlow().emitEmptyLine();
            } else
            if (NULLABLE_JAVA_TYPES.containsKey(s1))
            {
                javawriter.emitStatement("realmObject.%s(newObject.%s() != null ? newObject.%s() : %s)", new Object[] {
                    metadata.getSetter(s), metadata.getGetter(s), metadata.getGetter(s), NULLABLE_JAVA_TYPES.get(s1)
                });
            } else
            {
                javawriter.emitStatement("realmObject.%s(newObject.%s())", new Object[] {
                    metadata.getSetter(s), metadata.getGetter(s)
                });
            }
        }

        javawriter.emitStatement("return realmObject", new Object[0]);
        javawriter.endMethod();
        javawriter.emitEmptyLine();
    }

    private void emitCopyOrUpdateMethod(JavaWriter javawriter)
        throws IOException
    {
        javawriter.beginMethod(className, "copyOrUpdate", EnumSet.of(Modifier.PUBLIC, Modifier.STATIC), new String[] {
            "Realm", "realm", className, "object", "boolean", "update", "Map<RealmObject,RealmObjectProxy>", "cache"
        });
        javawriter.beginControlFlow("if (object.realm != null && object.realm.getPath().equals(realm.getPath()))", new Object[0]).emitStatement("return object", new Object[0]).endControlFlow();
        if (!metadata.hasPrimaryKey())
        {
            javawriter.emitStatement("return copy(realm, object, update, cache)", new Object[0]);
        } else
        {
            javawriter.emitStatement("%s realmObject = null", new Object[] {
                className
            }).emitStatement("boolean canUpdate = update", new Object[0]).beginControlFlow("if (canUpdate)", new Object[0]).emitStatement("Table table = realm.getTable(%s.class)", new Object[] {
                className
            }).emitStatement("long pkColumnIndex = table.getPrimaryKey()", new Object[0]);
            if (Utils.isString(metadata.getPrimaryKey()))
            {
                javawriter.beginControlFlow("if (object.%s() == null)", new Object[] {
                    metadata.getPrimaryKeyGetter()
                }).emitStatement("throw new IllegalArgumentException(\"Primary key value must not be null.\")", new Object[0]).endControlFlow().emitStatement("long rowIndex = table.findFirstString(pkColumnIndex, object.%s())", new Object[] {
                    metadata.getPrimaryKeyGetter()
                });
            } else
            {
                javawriter.emitStatement("long rowIndex = table.findFirstLong(pkColumnIndex, object.%s())", new Object[] {
                    metadata.getPrimaryKeyGetter()
                });
            }
            javawriter.beginControlFlow("if (rowIndex != TableOrView.NO_MATCH)", new Object[0]).emitStatement("realmObject = new %s()", new Object[] {
                Utils.getProxyClassName(className)
            }).emitStatement("realmObject.realm = realm", new Object[0]).emitStatement("realmObject.row = table.getRow(rowIndex)", new Object[0]).emitStatement("cache.put(object, (RealmObjectProxy) realmObject)", new Object[0]).nextControlFlow("else", new Object[0]).emitStatement("canUpdate = false", new Object[0]).endControlFlow();
            javawriter.endControlFlow();
            javawriter.emitEmptyLine().beginControlFlow("if (canUpdate)", new Object[0]).emitStatement("return update(realm, realmObject, object, cache)", new Object[0]).nextControlFlow("else", new Object[0]).emitStatement("return copy(realm, object, update, cache)", new Object[0]).endControlFlow();
        }
        javawriter.endMethod();
        javawriter.emitEmptyLine();
    }

    private void emitCreateOrUpdateUsingJsonObject(JavaWriter javawriter)
        throws IOException
    {
        javawriter.beginMethod(className, "createOrUpdateUsingJsonObject", EnumSet.of(Modifier.PUBLIC, Modifier.STATIC), Arrays.asList(new String[] {
            "Realm", "realm", "JSONObject", "json", "boolean", "update"
        }), Arrays.asList(new String[] {
            "JSONException"
        }));
        Iterator iterator;
        if (!metadata.hasPrimaryKey())
        {
            javawriter.emitStatement("%s obj = realm.createObject(%s.class)", new Object[] {
                className, className
            });
        } else
        {
            String s;
            if (Utils.isString(metadata.getPrimaryKey()))
            {
                s = "String";
            } else
            {
                s = "Long";
            }
            javawriter.emitStatement("%s obj = null", new Object[] {
                className
            }).beginControlFlow("if (update)", new Object[0]).emitStatement("Table table = realm.getTable(%s.class)", new Object[] {
                className
            }).emitStatement("long pkColumnIndex = table.getPrimaryKey()", new Object[0]).beginControlFlow("if (!json.isNull(\"%s\"))", new Object[] {
                metadata.getPrimaryKey().getSimpleName()
            }).emitStatement("long rowIndex = table.findFirst%s(pkColumnIndex, json.get%s(\"%s\"))", new Object[] {
                s, s, metadata.getPrimaryKey().getSimpleName()
            }).beginControlFlow("if (rowIndex != TableOrView.NO_MATCH)", new Object[0]).emitStatement("obj = new %s()", new Object[] {
                Utils.getProxyClassName(className)
            }).emitStatement("obj.realm = realm", new Object[0]).emitStatement("obj.row = table.getRow(rowIndex)", new Object[0]).endControlFlow().endControlFlow().endControlFlow().beginControlFlow("if (obj == null)", new Object[0]).emitStatement("obj = realm.createObject(%s.class)", new Object[] {
                className
            }).endControlFlow();
        }
        for (iterator = metadata.getFields().iterator(); iterator.hasNext();)
        {
            VariableElement variableelement = (VariableElement)iterator.next();
            String s1 = variableelement.getSimpleName().toString();
            String s2 = variableelement.asType().toString();
            if (typeUtils.isAssignable(variableelement.asType(), realmObject))
            {
                RealmJsonTypeHelper.emitFillRealmObjectWithJsonValue(metadata.getSetter(s1), s1, s2, Utils.getProxyClassSimpleName(variableelement), javawriter);
            } else
            if (typeUtils.isAssignable(variableelement.asType(), realmList))
            {
                RealmJsonTypeHelper.emitFillRealmListWithJsonValue(metadata.getGetter(s1), metadata.getSetter(s1), s1, ((TypeMirror)((DeclaredType)variableelement.asType()).getTypeArguments().get(0)).toString(), Utils.getProxyClassSimpleName(variableelement), javawriter);
            } else
            {
                RealmJsonTypeHelper.emitFillJavaTypeWithJsonValue(metadata.getSetter(s1), s1, s2, javawriter);
            }
        }

        javawriter.emitStatement("return obj", new Object[0]);
        javawriter.endMethod();
        javawriter.emitEmptyLine();
    }

    private void emitCreateUsingJsonStream(JavaWriter javawriter)
        throws IOException
    {
        javawriter.beginMethod(className, "createUsingJsonStream", EnumSet.of(Modifier.PUBLIC, Modifier.STATIC), Arrays.asList(new String[] {
            "Realm", "realm", "JsonReader", "reader"
        }), Arrays.asList(new String[] {
            "IOException"
        }));
        javawriter.emitStatement("%s obj = realm.createObject(%s.class)", new Object[] {
            className, className
        });
        javawriter.emitStatement("reader.beginObject()", new Object[0]);
        javawriter.beginControlFlow("while (reader.hasNext())", new Object[0]);
        javawriter.emitStatement("String name = reader.nextName()", new Object[0]);
        List list = metadata.getFields();
        int i = 0;
        while (i < list.size()) 
        {
            VariableElement variableelement = (VariableElement)list.get(i);
            String s = variableelement.getSimpleName().toString();
            String s1 = variableelement.asType().toString();
            if (i == 0)
            {
                javawriter.beginControlFlow("if (name.equals(\"%s\") && reader.peek() != JsonToken.NULL)", new Object[] {
                    s
                });
            } else
            {
                javawriter.nextControlFlow("else if (name.equals(\"%s\")  && reader.peek() != JsonToken.NULL)", new Object[] {
                    s
                });
            }
            if (typeUtils.isAssignable(variableelement.asType(), realmObject))
            {
                RealmJsonTypeHelper.emitFillRealmObjectFromStream(metadata.getSetter(s), s, s1, Utils.getProxyClassSimpleName(variableelement), javawriter);
            } else
            if (typeUtils.isAssignable(variableelement.asType(), realmList))
            {
                RealmJsonTypeHelper.emitFillRealmListFromStream(metadata.getGetter(s), metadata.getSetter(s), ((TypeMirror)((DeclaredType)variableelement.asType()).getTypeArguments().get(0)).toString(), Utils.getProxyClassSimpleName(variableelement), javawriter);
            } else
            {
                RealmJsonTypeHelper.emitFillJavaTypeFromStream(metadata.getSetter(s), s, s1, javawriter);
            }
            i++;
        }
        if (list.size() > 0)
        {
            javawriter.nextControlFlow("else", new Object[0]);
            javawriter.emitStatement("reader.skipValue()", new Object[0]);
            javawriter.endControlFlow();
        }
        javawriter.endControlFlow();
        javawriter.emitStatement("reader.endObject()", new Object[0]);
        javawriter.emitStatement("return obj", new Object[0]);
        javawriter.endMethod();
        javawriter.emitEmptyLine();
    }

    private void emitEqualsMethod(JavaWriter javawriter)
        throws IOException
    {
        String s = (new StringBuilder()).append(className).append("RealmProxy").toString();
        javawriter.emitAnnotation("Override");
        javawriter.beginMethod("boolean", "equals", EnumSet.of(Modifier.PUBLIC), new String[] {
            "Object", "o"
        });
        javawriter.emitStatement("if (this == o) return true", new Object[0]);
        javawriter.emitStatement("if (o == null || getClass() != o.getClass()) return false", new Object[0]);
        javawriter.emitStatement("%s a%s = (%s)o", new Object[] {
            s, className, s
        });
        javawriter.emitEmptyLine();
        javawriter.emitStatement("String path = realm.getPath()", new Object[0]);
        javawriter.emitStatement("String otherPath = a%s.realm.getPath()", new Object[] {
            className
        });
        javawriter.emitStatement("if (path != null ? !path.equals(otherPath) : otherPath != null) return false;", new Object[0]);
        javawriter.emitEmptyLine();
        javawriter.emitStatement("String tableName = row.getTable().getName()", new Object[0]);
        javawriter.emitStatement("String otherTableName = a%s.row.getTable().getName()", new Object[] {
            className
        });
        javawriter.emitStatement("if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false", new Object[0]);
        javawriter.emitEmptyLine();
        javawriter.emitStatement("if (row.getIndex() != a%s.row.getIndex()) return false", new Object[] {
            className
        });
        javawriter.emitEmptyLine();
        javawriter.emitStatement("return true", new Object[0]);
        javawriter.endMethod();
        javawriter.emitEmptyLine();
    }

    private void emitGetColumnIndicesMethod(JavaWriter javawriter)
        throws IOException
    {
        javawriter.beginMethod("Map<String,Long>", "getColumnIndices", EnumSet.of(Modifier.PUBLIC, Modifier.STATIC), new String[0]);
        javawriter.emitStatement("return columnIndices", new Object[0]);
        javawriter.endMethod();
        javawriter.emitEmptyLine();
    }

    private void emitGetFieldNamesMethod(JavaWriter javawriter)
        throws IOException
    {
        javawriter.beginMethod("List<String>", "getFieldNames", EnumSet.of(Modifier.PUBLIC, Modifier.STATIC), new String[0]);
        javawriter.emitStatement("return FIELD_NAMES", new Object[0]);
        javawriter.endMethod();
        javawriter.emitEmptyLine();
    }

    private void emitGetTableNameMethod(JavaWriter javawriter)
        throws IOException
    {
        javawriter.beginMethod("String", "getTableName", EnumSet.of(Modifier.PUBLIC, Modifier.STATIC), new String[0]);
        javawriter.emitStatement("return \"%s%s\"", new Object[] {
            "class_", className
        });
        javawriter.endMethod();
        javawriter.emitEmptyLine();
    }

    private void emitHashcodeMethod(JavaWriter javawriter)
        throws IOException
    {
        javawriter.emitAnnotation("Override");
        javawriter.beginMethod("int", "hashCode", EnumSet.of(Modifier.PUBLIC), new String[0]);
        javawriter.emitStatement("String realmName = realm.getPath()", new Object[0]);
        javawriter.emitStatement("String tableName = row.getTable().getName()", new Object[0]);
        javawriter.emitStatement("long rowIndex = row.getIndex()", new Object[0]);
        javawriter.emitEmptyLine();
        javawriter.emitStatement("int result = 17", new Object[0]);
        javawriter.emitStatement("result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0)", new Object[0]);
        javawriter.emitStatement("result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0)", new Object[0]);
        javawriter.emitStatement("result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32))", new Object[0]);
        javawriter.emitStatement("return result", new Object[0]);
        javawriter.endMethod();
        javawriter.emitEmptyLine();
    }

    private void emitInitTableMethod(JavaWriter javawriter)
        throws IOException
    {
        javawriter.beginMethod("Table", "initTable", EnumSet.of(Modifier.PUBLIC, Modifier.STATIC), new String[] {
            "ImplicitTransaction", "transaction"
        });
        javawriter.beginControlFlow((new StringBuilder()).append("if (!transaction.hasTable(\"class_").append(className).append("\"))").toString(), new Object[0]);
        javawriter.emitStatement("Table table = transaction.getTable(\"%s%s\")", new Object[] {
            "class_", className
        });
        Iterator iterator = metadata.getFields().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = (VariableElement)iterator.next();
            String s = ((VariableElement) (obj)).getSimpleName().toString();
            String s1 = ((VariableElement) (obj)).asType().toString();
            String s2 = Utils.getFieldTypeSimpleName(((VariableElement) (obj)));
            if (JAVA_TO_REALM_TYPES.containsKey(s1))
            {
                javawriter.emitStatement("table.addColumn(%s, \"%s\")", new Object[] {
                    JAVA_TO_COLUMN_TYPES.get(s1), s
                });
            } else
            if (typeUtils.isAssignable(((VariableElement) (obj)).asType(), realmObject))
            {
                javawriter.beginControlFlow("if (!transaction.hasTable(\"%s%s\"))", new Object[] {
                    "class_", s2
                });
                javawriter.emitStatement("%s%s.initTable(transaction)", new Object[] {
                    s2, "RealmProxy"
                });
                javawriter.endControlFlow();
                javawriter.emitStatement("table.addColumnLink(ColumnType.LINK, \"%s\", transaction.getTable(\"%s%s\"))", new Object[] {
                    s, "class_", s2
                });
            } else
            if (typeUtils.isAssignable(((VariableElement) (obj)).asType(), realmList))
            {
                obj = Utils.getGenericType(((VariableElement) (obj)));
                javawriter.beginControlFlow("if (!transaction.hasTable(\"%s%s\"))", new Object[] {
                    "class_", obj
                });
                javawriter.emitStatement("%s%s.initTable(transaction)", new Object[] {
                    obj, "RealmProxy"
                });
                javawriter.endControlFlow();
                javawriter.emitStatement("table.addColumnLink(ColumnType.LINK_LIST, \"%s\", transaction.getTable(\"%s%s\"))", new Object[] {
                    s, "class_", obj
                });
            }
        } while (true);
        for (Iterator iterator1 = metadata.getIndexedFields().iterator(); iterator1.hasNext(); javawriter.emitStatement("table.addSearchIndex(table.getColumnIndex(\"%s\"))", new Object[] {
    ((VariableElement)iterator1.next()).getSimpleName().toString()
})) { }
        if (metadata.hasPrimaryKey())
        {
            javawriter.emitStatement("table.setPrimaryKey(\"%s\")", new Object[] {
                metadata.getPrimaryKey().getSimpleName().toString()
            });
        } else
        {
            javawriter.emitStatement("table.setPrimaryKey(\"\")", new Object[0]);
        }
        javawriter.emitStatement("return table", new Object[0]);
        javawriter.endControlFlow();
        javawriter.emitStatement("return transaction.getTable(\"%s%s\")", new Object[] {
            "class_", className
        });
        javawriter.endMethod();
        javawriter.emitEmptyLine();
    }

    private void emitToStringMethod(JavaWriter javawriter)
        throws IOException
    {
        javawriter.emitAnnotation("Override");
        javawriter.beginMethod("String", "toString", EnumSet.of(Modifier.PUBLIC), new String[0]);
        javawriter.beginControlFlow("if (!isValid())", new Object[0]);
        javawriter.emitStatement("return \"Invalid object\"", new Object[0]);
        javawriter.endControlFlow();
        javawriter.emitStatement("StringBuilder stringBuilder = new StringBuilder(\"%s = [\")", new Object[] {
            className
        });
        List list = metadata.getFields();
        int i = 0;
        while (i < list.size()) 
        {
            Object obj = (VariableElement)list.get(i);
            String s = ((VariableElement) (obj)).getSimpleName().toString();
            javawriter.emitStatement("stringBuilder.append(\"{%s:\")", new Object[] {
                s
            });
            if (typeUtils.isAssignable(((VariableElement) (obj)).asType(), realmObject))
            {
                obj = Utils.getFieldTypeSimpleName(((VariableElement) (obj)));
                javawriter.emitStatement("stringBuilder.append(%s() != null ? \"%s\" : \"null\")", new Object[] {
                    metadata.getGetter(s), obj
                });
            } else
            if (typeUtils.isAssignable(((VariableElement) (obj)).asType(), realmList))
            {
                javawriter.emitStatement("stringBuilder.append(\"RealmList<%s>[\").append(%s().size()).append(\"]\")", new Object[] {
                    Utils.getGenericType(((VariableElement) (obj))), metadata.getGetter(s)
                });
            } else
            {
                javawriter.emitStatement("stringBuilder.append(%s())", new Object[] {
                    metadata.getGetter(s)
                });
            }
            javawriter.emitStatement("stringBuilder.append(\"}\")", new Object[0]);
            if (i < list.size() - 1)
            {
                javawriter.emitStatement("stringBuilder.append(\",\")", new Object[0]);
            }
            i++;
        }
        javawriter.emitStatement("stringBuilder.append(\"]\")", new Object[0]);
        javawriter.emitStatement("return stringBuilder.toString()", new Object[0]);
        javawriter.endMethod();
        javawriter.emitEmptyLine();
    }

    private void emitUpdateMethod(JavaWriter javawriter)
        throws IOException
    {
        javawriter.beginMethod(className, "update", EnumSet.of(Modifier.STATIC), new String[] {
            "Realm", "realm", className, "realmObject", className, "newObject", "Map<RealmObject, RealmObjectProxy>", "cache"
        });
        Iterator iterator = metadata.getFields().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = (VariableElement)iterator.next();
            String s = ((VariableElement) (obj)).getSimpleName().toString();
            if (typeUtils.isAssignable(((VariableElement) (obj)).asType(), realmObject))
            {
                javawriter.emitStatement("%s %sObj = newObject.%s()", new Object[] {
                    Utils.getFieldTypeSimpleName(((VariableElement) (obj))), s, metadata.getGetter(s)
                }).beginControlFlow("if (%sObj != null)", new Object[] {
                    s
                }).emitStatement("%s cache%s = (%s) cache.get(%sObj)", new Object[] {
                    Utils.getFieldTypeSimpleName(((VariableElement) (obj))), s, Utils.getFieldTypeSimpleName(((VariableElement) (obj))), s
                }).beginControlFlow("if (cache%s != null)", new Object[] {
                    s
                }).emitStatement("realmObject.%s(cache%s)", new Object[] {
                    metadata.getSetter(s), s
                }).nextControlFlow("else", new Object[0]).emitStatement("realmObject.%s(%s.copyOrUpdate(realm, %sObj, true, cache))", new Object[] {
                    metadata.getSetter(s), Utils.getProxyClassSimpleName(((VariableElement) (obj))), s, Utils.getFieldTypeSimpleName(((VariableElement) (obj)))
                }).endControlFlow().nextControlFlow("else", new Object[0]).emitStatement("realmObject.%s(null)", new Object[] {
                    metadata.getSetter(s)
                }).endControlFlow();
            } else
            if (typeUtils.isAssignable(((VariableElement) (obj)).asType(), realmList))
            {
                javawriter.emitStatement("RealmList<%s> %sList = newObject.%s()", new Object[] {
                    Utils.getGenericType(((VariableElement) (obj))), s, metadata.getGetter(s)
                }).emitStatement("RealmList<%s> %sRealmList = realmObject.%s()", new Object[] {
                    Utils.getGenericType(((VariableElement) (obj))), s, metadata.getGetter(s)
                }).emitStatement("%sRealmList.clear()", new Object[] {
                    s
                }).beginControlFlow("if (%sList != null)", new Object[] {
                    s
                }).beginControlFlow("for (int i = 0; i < %sList.size(); i++)", new Object[] {
                    s
                }).emitStatement("%s %sItem = %sList.get(i)", new Object[] {
                    Utils.getGenericType(((VariableElement) (obj))), s, s
                }).emitStatement("%s cache%s = (%s) cache.get(%sItem)", new Object[] {
                    Utils.getGenericType(((VariableElement) (obj))), s, Utils.getGenericType(((VariableElement) (obj))), s
                }).beginControlFlow("if (cache%s != null)", new Object[] {
                    s
                }).emitStatement("%sRealmList.add(cache%s)", new Object[] {
                    s, s
                }).nextControlFlow("else", new Object[0]).emitStatement("%sRealmList.add(%s.copyOrUpdate(realm, %sList.get(i), true, cache))", new Object[] {
                    s, Utils.getProxyClassSimpleName(((VariableElement) (obj))), s
                }).endControlFlow().endControlFlow().endControlFlow();
            } else
            if (obj != metadata.getPrimaryKey())
            {
                obj = ((VariableElement) (obj)).asType().toString();
                if (NULLABLE_JAVA_TYPES.containsKey(obj))
                {
                    javawriter.emitStatement("realmObject.%s(newObject.%s() != null ? newObject.%s() : %s)", new Object[] {
                        metadata.getSetter(s), metadata.getGetter(s), metadata.getGetter(s), NULLABLE_JAVA_TYPES.get(obj)
                    });
                } else
                {
                    javawriter.emitStatement("realmObject.%s(newObject.%s())", new Object[] {
                        metadata.getSetter(s), metadata.getGetter(s)
                    });
                }
            }
        } while (true);
        javawriter.emitStatement("return realmObject", new Object[0]);
        javawriter.endMethod();
        javawriter.emitEmptyLine();
    }

    private void emitValidateTableMethod(JavaWriter javawriter)
        throws IOException
    {
        javawriter.beginMethod("void", "validateTable", EnumSet.of(Modifier.PUBLIC, Modifier.STATIC), new String[] {
            "ImplicitTransaction", "transaction"
        });
        javawriter.beginControlFlow((new StringBuilder()).append("if (transaction.hasTable(\"class_").append(className).append("\"))").toString(), new Object[0]);
        javawriter.emitStatement("Table table = transaction.getTable(\"%s%s\")", new Object[] {
            "class_", className
        });
        javawriter.beginControlFlow((new StringBuilder()).append("if (table.getColumnCount() != ").append(metadata.getFields().size()).append(")").toString(), new Object[0]);
        javawriter.emitStatement("throw new RealmMigrationNeededException(transaction.getPath(), \"Field count does not match - expected %d but was \" + table.getColumnCount())", new Object[] {
            Integer.valueOf(metadata.getFields().size())
        });
        javawriter.endControlFlow();
        javawriter.emitStatement("Map<String, ColumnType> columnTypes = new HashMap<String, ColumnType>()", new Object[0]);
        javawriter.beginControlFlow((new StringBuilder()).append("for (long i = 0; i < ").append(metadata.getFields().size()).append("; i++)").toString(), new Object[0]);
        javawriter.emitStatement("columnTypes.put(table.getColumnName(i), table.getColumnType(i))", new Object[0]);
        javawriter.endControlFlow();
        javawriter.emitEmptyLine();
        javawriter.emitStatement("columnIndices = new HashMap<String, Long>()", new Object[0]);
        javawriter.beginControlFlow("for (String fieldName : getFieldNames())", new Object[0]).emitStatement("long index = table.getColumnIndex(fieldName)", new Object[0]).beginControlFlow("if (index == -1)", new Object[0]).emitStatement("throw new RealmMigrationNeededException(transaction.getPath(), \"Field '\" + fieldName + \"' not found for type %s\")", new Object[] {
            metadata.getSimpleClassName()
        }).endControlFlow().emitStatement("columnIndices.put(fieldName, index)", new Object[0]).endControlFlow();
        VariableElement variableelement;
        for (Iterator iterator = metadata.getFields().iterator(); iterator.hasNext(); javawriter.emitStatement("%s = table.getColumnIndex(\"%s\")", new Object[] {
    staticFieldIndexVarName(variableelement), variableelement.getSimpleName().toString()
}))
        {
            variableelement = (VariableElement)iterator.next();
        }

        javawriter.emitEmptyLine();
        Iterator iterator1 = metadata.getFields().iterator();
        long l = 0L;
        while (iterator1.hasNext()) 
        {
            VariableElement variableelement1 = (VariableElement)iterator1.next();
            String s = variableelement1.getSimpleName().toString();
            String s1 = variableelement1.asType().toString();
            String s3 = Utils.getFieldTypeSimpleName(variableelement1);
            if (JAVA_TO_REALM_TYPES.containsKey(s1))
            {
                javawriter.beginControlFlow("if (!columnTypes.containsKey(\"%s\"))", new Object[] {
                    s
                });
                javawriter.emitStatement("throw new RealmMigrationNeededException(transaction.getPath(), \"Missing field '%s'\")", new Object[] {
                    s
                });
                javawriter.endControlFlow();
                javawriter.beginControlFlow("if (columnTypes.get(\"%s\") != %s)", new Object[] {
                    s, JAVA_TO_COLUMN_TYPES.get(s1)
                });
                javawriter.emitStatement("throw new RealmMigrationNeededException(transaction.getPath(), \"Invalid type '%s' for field '%s'\")", new Object[] {
                    s3, s
                });
                javawriter.endControlFlow();
                if (variableelement1.equals(metadata.getPrimaryKey()))
                {
                    javawriter.beginControlFlow("if (table.getPrimaryKey() != table.getColumnIndex(\"%s\"))", new Object[] {
                        s
                    });
                    javawriter.emitStatement("throw new RealmMigrationNeededException(transaction.getPath(), \"Primary key not defined for field '%s'\")", new Object[] {
                        s
                    });
                    javawriter.endControlFlow();
                }
                if (metadata.getIndexedFields().contains(variableelement1))
                {
                    javawriter.beginControlFlow("if (!table.hasSearchIndex(table.getColumnIndex(\"%s\")))", new Object[] {
                        s
                    });
                    javawriter.emitStatement("throw new RealmMigrationNeededException(transaction.getPath(), \"Index not defined for field '%s'\")", new Object[] {
                        s
                    });
                    javawriter.endControlFlow();
                }
            } else
            if (typeUtils.isAssignable(variableelement1.asType(), realmObject))
            {
                javawriter.beginControlFlow("if (!columnTypes.containsKey(\"%s\"))", new Object[] {
                    s
                });
                javawriter.emitStatement("throw new RealmMigrationNeededException(transaction.getPath(), \"Missing field '%s'\")", new Object[] {
                    s
                });
                javawriter.endControlFlow();
                javawriter.beginControlFlow("if (columnTypes.get(\"%s\") != ColumnType.LINK)", new Object[] {
                    s
                });
                javawriter.emitStatement("throw new RealmMigrationNeededException(transaction.getPath(), \"Invalid type '%s' for field '%s'\")", new Object[] {
                    s3, s
                });
                javawriter.endControlFlow();
                javawriter.beginControlFlow("if (!transaction.hasTable(\"%s%s\"))", new Object[] {
                    "class_", s3
                });
                javawriter.emitStatement("throw new RealmMigrationNeededException(transaction.getPath(), \"Missing class '%s%s' for field '%s'\")", new Object[] {
                    "class_", s3, s
                });
                javawriter.endControlFlow();
                javawriter.emitStatement("Table table_%d = transaction.getTable(\"%s%s\")", new Object[] {
                    Long.valueOf(l), "class_", s3
                });
                javawriter.beginControlFlow("if (!table.getLinkTarget(%s).equals(table_%d))", new Object[] {
                    staticFieldIndexVarName(variableelement1), Long.valueOf(l)
                });
                javawriter.emitStatement("throw new RealmMigrationNeededException(transaction.getPath(), \"Invalid RealmObject for field '%s': '\" + table.getLinkTarget(%s).getName() + \"' expected - was '\" + table_%d.getName() + \"'\")", new Object[] {
                    s, staticFieldIndexVarName(variableelement1), Long.valueOf(l)
                });
                javawriter.endControlFlow();
            } else
            if (typeUtils.isAssignable(variableelement1.asType(), realmList))
            {
                String s2 = Utils.getGenericType(variableelement1);
                javawriter.beginControlFlow("if (!columnTypes.containsKey(\"%s\"))", new Object[] {
                    s
                });
                javawriter.emitStatement("throw new RealmMigrationNeededException(transaction.getPath(), \"Missing field '%s'\")", new Object[] {
                    s
                });
                javawriter.endControlFlow();
                javawriter.beginControlFlow("if (columnTypes.get(\"%s\") != ColumnType.LINK_LIST)", new Object[] {
                    s
                });
                javawriter.emitStatement("throw new RealmMigrationNeededException(transaction.getPath(), \"Invalid type '%s' for field '%s'\")", new Object[] {
                    s2, s
                });
                javawriter.endControlFlow();
                javawriter.beginControlFlow("if (!transaction.hasTable(\"%s%s\"))", new Object[] {
                    "class_", s2
                });
                javawriter.emitStatement("throw new RealmMigrationNeededException(transaction.getPath(), \"Missing class '%s%s' for field '%s'\")", new Object[] {
                    "class_", s2, s
                });
                javawriter.endControlFlow();
                javawriter.emitStatement("Table table_%d = transaction.getTable(\"%s%s\")", new Object[] {
                    Long.valueOf(l), "class_", s2
                });
                javawriter.beginControlFlow("if (!table.getLinkTarget(%s).equals(table_%d))", new Object[] {
                    staticFieldIndexVarName(variableelement1), Long.valueOf(l)
                });
                javawriter.emitStatement("throw new RealmMigrationNeededException(transaction.getPath(), \"Invalid RealmList type for field '%s': '\" + table.getLinkTarget(%s).getName() + \"' expected - was '\" + table_%d.getName() + \"'\")", new Object[] {
                    s, staticFieldIndexVarName(variableelement1), Long.valueOf(l)
                });
                javawriter.endControlFlow();
            }
            l = 1L + l;
        }
        javawriter.nextControlFlow("else", new Object[0]);
        javawriter.emitStatement("throw new RealmMigrationNeededException(transaction.getPath(), \"The %s class is missing from the schema for this Realm.\")", new Object[] {
            metadata.getSimpleClassName()
        });
        javawriter.endControlFlow();
        javawriter.endMethod();
        javawriter.emitEmptyLine();
    }

    private String staticFieldIndexVarName(VariableElement variableelement)
    {
        return (new StringBuilder()).append("INDEX_").append(variableelement.getSimpleName().toString().toUpperCase()).toString();
    }

    public void generate()
        throws IOException, UnsupportedOperationException
    {
        elementUtils = processingEnvironment.getElementUtils();
        typeUtils = processingEnvironment.getTypeUtils();
        realmObject = elementUtils.getTypeElement("io.realm.RealmObject").asType();
        realmList = typeUtils.getDeclaredType(elementUtils.getTypeElement("io.realm.RealmList"), new TypeMirror[] {
            typeUtils.getWildcardType(null, null)
        });
        String s = String.format("%s.%s", new Object[] {
            "io.realm", Utils.getProxyClassName(className)
        });
        JavaWriter javawriter = new JavaWriter(new BufferedWriter(processingEnvironment.getFiler().createSourceFile(s, new Element[0]).openWriter()));
        javawriter.setIndent("    ");
        javawriter.emitPackage("io.realm").emitEmptyLine();
        ArrayList arraylist = new ArrayList();
        arraylist.add("android.util.JsonReader");
        arraylist.add("android.util.JsonToken");
        arraylist.add("io.realm.RealmObject");
        arraylist.add("io.realm.exceptions.RealmException");
        arraylist.add("io.realm.exceptions.RealmMigrationNeededException");
        arraylist.add("io.realm.internal.ColumnType");
        arraylist.add("io.realm.internal.RealmObjectProxy");
        arraylist.add("io.realm.internal.Table");
        arraylist.add("io.realm.internal.TableOrView");
        arraylist.add("io.realm.internal.ImplicitTransaction");
        arraylist.add("io.realm.internal.LinkView");
        arraylist.add("io.realm.internal.android.JsonUtils");
        arraylist.add("java.io.IOException");
        arraylist.add("java.util.ArrayList");
        arraylist.add("java.util.Collections");
        arraylist.add("java.util.List");
        arraylist.add("java.util.Arrays");
        arraylist.add("java.util.Date");
        arraylist.add("java.util.Map");
        arraylist.add("java.util.HashMap");
        arraylist.add("org.json.JSONObject");
        arraylist.add("org.json.JSONException");
        arraylist.add("org.json.JSONArray");
        arraylist.add(metadata.getFullyQualifiedClassName());
        Iterator iterator = metadata.getFields().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = (VariableElement)iterator.next();
            if (typeUtils.isAssignable(((VariableElement) (obj)).asType(), realmObject))
            {
                obj = ((VariableElement) (obj)).asType().toString();
            } else
            if (typeUtils.isAssignable(((VariableElement) (obj)).asType(), realmList))
            {
                obj = ((TypeMirror)((DeclaredType)((VariableElement) (obj)).asType()).getTypeArguments().get(0)).toString();
            } else
            {
                obj = "";
            }
            if (!((String) (obj)).isEmpty() && !arraylist.contains(obj))
            {
                arraylist.add(obj);
            }
        } while (true);
        Collections.sort(arraylist);
        javawriter.emitImports(arraylist);
        javawriter.emitEmptyLine();
        javawriter.beginType(s, "class", EnumSet.of(Modifier.PUBLIC), className, new String[] {
            "RealmObjectProxy"
        }).emitEmptyLine();
        emitClassFields(javawriter);
        emitAccessors(javawriter);
        emitInitTableMethod(javawriter);
        emitValidateTableMethod(javawriter);
        emitGetTableNameMethod(javawriter);
        emitGetFieldNamesMethod(javawriter);
        emitGetColumnIndicesMethod(javawriter);
        emitCreateOrUpdateUsingJsonObject(javawriter);
        emitCreateUsingJsonStream(javawriter);
        emitCopyOrUpdateMethod(javawriter);
        emitCopyMethod(javawriter);
        emitUpdateMethod(javawriter);
        emitToStringMethod(javawriter);
        emitHashcodeMethod(javawriter);
        emitEqualsMethod(javawriter);
        javawriter.endType();
        javawriter.close();
    }

    static 
    {
        JAVA_TO_REALM_TYPES = new HashMap();
        JAVA_TO_REALM_TYPES.put("byte", "Long");
        JAVA_TO_REALM_TYPES.put("short", "Long");
        JAVA_TO_REALM_TYPES.put("int", "Long");
        JAVA_TO_REALM_TYPES.put("long", "Long");
        JAVA_TO_REALM_TYPES.put("float", "Float");
        JAVA_TO_REALM_TYPES.put("double", "Double");
        JAVA_TO_REALM_TYPES.put("boolean", "Boolean");
        JAVA_TO_REALM_TYPES.put("Byte", "Long");
        JAVA_TO_REALM_TYPES.put("Short", "Long");
        JAVA_TO_REALM_TYPES.put("Integer", "Long");
        JAVA_TO_REALM_TYPES.put("Long", "Long");
        JAVA_TO_REALM_TYPES.put("Float", "Float");
        JAVA_TO_REALM_TYPES.put("Double", "Double");
        JAVA_TO_REALM_TYPES.put("Boolean", "Boolean");
        JAVA_TO_REALM_TYPES.put("java.lang.String", "String");
        JAVA_TO_REALM_TYPES.put("java.util.Date", "Date");
        JAVA_TO_REALM_TYPES.put("byte[]", "BinaryByteArray");
        NULLABLE_JAVA_TYPES = new HashMap();
        NULLABLE_JAVA_TYPES.put("java.util.Date", "new Date(0)");
        NULLABLE_JAVA_TYPES.put("java.lang.String", "\"\"");
        NULLABLE_JAVA_TYPES.put("byte[]", "new byte[0]");
        JAVA_TO_COLUMN_TYPES = new HashMap();
        JAVA_TO_COLUMN_TYPES.put("byte", "ColumnType.INTEGER");
        JAVA_TO_COLUMN_TYPES.put("short", "ColumnType.INTEGER");
        JAVA_TO_COLUMN_TYPES.put("int", "ColumnType.INTEGER");
        JAVA_TO_COLUMN_TYPES.put("long", "ColumnType.INTEGER");
        JAVA_TO_COLUMN_TYPES.put("float", "ColumnType.FLOAT");
        JAVA_TO_COLUMN_TYPES.put("double", "ColumnType.DOUBLE");
        JAVA_TO_COLUMN_TYPES.put("boolean", "ColumnType.BOOLEAN");
        JAVA_TO_COLUMN_TYPES.put("Byte", "ColumnType.INTEGER");
        JAVA_TO_COLUMN_TYPES.put("Short", "ColumnType.INTEGER");
        JAVA_TO_COLUMN_TYPES.put("Integer", "ColumnType.INTEGER");
        JAVA_TO_COLUMN_TYPES.put("Long", "ColumnType.INTEGER");
        JAVA_TO_COLUMN_TYPES.put("Float", "ColumnType.FLOAT");
        JAVA_TO_COLUMN_TYPES.put("Double", "ColumnType.DOUBLE");
        JAVA_TO_COLUMN_TYPES.put("Boolean", "ColumnType.BOOLEAN");
        JAVA_TO_COLUMN_TYPES.put("java.lang.String", "ColumnType.STRING");
        JAVA_TO_COLUMN_TYPES.put("java.util.Date", "ColumnType.DATE");
        JAVA_TO_COLUMN_TYPES.put("byte[]", "ColumnType.BINARY");
        CASTING_TYPES = new HashMap();
        CASTING_TYPES.put("byte", "long");
        CASTING_TYPES.put("short", "long");
        CASTING_TYPES.put("int", "long");
        CASTING_TYPES.put("long", "long");
        CASTING_TYPES.put("float", "float");
        CASTING_TYPES.put("double", "double");
        CASTING_TYPES.put("boolean", "boolean");
        CASTING_TYPES.put("Byte", "long");
        CASTING_TYPES.put("Short", "long");
        CASTING_TYPES.put("Integer", "long");
        CASTING_TYPES.put("Long", "long");
        CASTING_TYPES.put("Float", "float");
        CASTING_TYPES.put("Double", "double");
        CASTING_TYPES.put("Boolean", "boolean");
        CASTING_TYPES.put("java.lang.String", "String");
        CASTING_TYPES.put("java.util.Date", "Date");
        CASTING_TYPES.put("byte[]", "byte[]");
    }
}
