// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm.processor;

import io.realm.annotations.internal.RealmModule;
import io.realm.processor.javawriter.JavaWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.tools.JavaFileObject;

// Referenced classes of package io.realm.processor:
//            ClassMetaData

public class RealmProxyMediatorGenerator
{
    private static interface ProxySwitchStatement
    {

        public abstract void emitStatement(int i, JavaWriter javawriter)
            throws IOException;
    }


    private static final String REALM_PACKAGE_NAME = "io.realm";
    private final String className;
    private ProcessingEnvironment processingEnvironment;
    private List proxyClasses;
    private List qualifiedModelClasses;
    private List simpleModelClasses;

    public RealmProxyMediatorGenerator(ProcessingEnvironment processingenvironment, String s, Set set)
    {
        qualifiedModelClasses = new ArrayList();
        simpleModelClasses = new ArrayList();
        proxyClasses = new ArrayList();
        processingEnvironment = processingenvironment;
        className = s;
        for (processingenvironment = set.iterator(); processingenvironment.hasNext(); proxyClasses.add(getProxyClassName(set)))
        {
            s = (ClassMetaData)processingenvironment.next();
            set = s.getSimpleClassName();
            qualifiedModelClasses.add(s.getFullyQualifiedClassName());
            simpleModelClasses.add(set);
        }

    }

    private void emitCopyToRealmMethod(JavaWriter javawriter)
        throws IOException
    {
        javawriter.emitAnnotation("Override");
        javawriter.beginMethod("<E extends RealmObject> E", "copyOrUpdate", EnumSet.of(Modifier.PUBLIC), new String[] {
            "Realm", "realm", "E", "obj", "boolean", "update", "Map<RealmObject, RealmObjectProxy>", "cache"
        });
        javawriter.emitStatement("Class<E> clazz = (Class<E>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass())", new Object[0]);
        javawriter.emitEmptyLine();
        emitMediatorSwitch(new ProxySwitchStatement() {

            final RealmProxyMediatorGenerator this$0;

            public void emitStatement(int i, JavaWriter javawriter1)
                throws IOException
            {
                javawriter1.emitStatement("return (E) %s.copyOrUpdate(realm, (%s) obj, update, cache)", new Object[] {
                    proxyClasses.get(i), simpleModelClasses.get(i)
                });
            }

            
            {
                this$0 = RealmProxyMediatorGenerator.this;
                super();
            }
        }, javawriter, false);
        javawriter.endMethod();
        javawriter.emitEmptyLine();
    }

    private void emitCreateTableMethod(JavaWriter javawriter)
        throws IOException
    {
        javawriter.emitAnnotation("Override");
        javawriter.beginMethod("Table", "createTable", EnumSet.of(Modifier.PUBLIC), new String[] {
            "Class<? extends RealmObject>", "clazz", "ImplicitTransaction", "transaction"
        });
        emitMediatorSwitch(new ProxySwitchStatement() {

            final RealmProxyMediatorGenerator this$0;

            public void emitStatement(int i, JavaWriter javawriter1)
                throws IOException
            {
                javawriter1.emitStatement("return %s.initTable(transaction)", new Object[] {
                    proxyClasses.get(i)
                });
            }

            
            {
                this$0 = RealmProxyMediatorGenerator.this;
                super();
            }
        }, javawriter);
        javawriter.endMethod();
        javawriter.emitEmptyLine();
    }

    private void emitCreateUsingJsonStream(JavaWriter javawriter)
        throws IOException
    {
        javawriter.emitAnnotation("Override");
        javawriter.beginMethod("<E extends RealmObject> E", "createUsingJsonStream", EnumSet.of(Modifier.PUBLIC), Arrays.asList(new String[] {
            "Class<E>", "clazz", "Realm", "realm", "JsonReader", "reader"
        }), Arrays.asList(new String[] {
            "java.io.IOException"
        }));
        emitMediatorSwitch(new ProxySwitchStatement() {

            final RealmProxyMediatorGenerator this$0;

            public void emitStatement(int i, JavaWriter javawriter1)
                throws IOException
            {
                javawriter1.emitStatement("return (E) %s.createUsingJsonStream(realm, reader)", new Object[] {
                    proxyClasses.get(i)
                });
            }

            
            {
                this$0 = RealmProxyMediatorGenerator.this;
                super();
            }
        }, javawriter);
        javawriter.endMethod();
        javawriter.emitEmptyLine();
    }

    private void emitCreteOrUpdateUsingJsonObject(JavaWriter javawriter)
        throws IOException
    {
        javawriter.emitAnnotation("Override");
        javawriter.beginMethod("<E extends RealmObject> E", "createOrUpdateUsingJsonObject", EnumSet.of(Modifier.PUBLIC), Arrays.asList(new String[] {
            "Class<E>", "clazz", "Realm", "realm", "JSONObject", "json", "boolean", "update"
        }), Arrays.asList(new String[] {
            "JSONException"
        }));
        emitMediatorSwitch(new ProxySwitchStatement() {

            final RealmProxyMediatorGenerator this$0;

            public void emitStatement(int i, JavaWriter javawriter1)
                throws IOException
            {
                javawriter1.emitStatement("return (E) %s.createOrUpdateUsingJsonObject(realm, json, update)", new Object[] {
                    proxyClasses.get(i)
                });
            }

            
            {
                this$0 = RealmProxyMediatorGenerator.this;
                super();
            }
        }, javawriter);
        javawriter.endMethod();
        javawriter.emitEmptyLine();
    }

    private void emitFields(JavaWriter javawriter)
        throws IOException
    {
        javawriter.emitField("List<Class<? extends RealmObject>>", "MODEL_CLASSES", EnumSet.of(Modifier.PRIVATE, Modifier.STATIC, Modifier.FINAL));
        javawriter.beginInitializer(true);
        javawriter.emitStatement("List<Class<? extends RealmObject>> modelClasses = new ArrayList<Class<? extends RealmObject>>()", new Object[0]);
        for (Iterator iterator = simpleModelClasses.iterator(); iterator.hasNext(); javawriter.emitStatement("modelClasses.add(%s.class)", new Object[] {
    (String)iterator.next()
})) { }
        javawriter.emitStatement("MODEL_CLASSES = Collections.unmodifiableList(modelClasses)", new Object[0]);
        javawriter.endInitializer();
        javawriter.emitEmptyLine();
    }

    private void emitGetClassModelList(JavaWriter javawriter)
        throws IOException
    {
        javawriter.emitAnnotation("Override");
        javawriter.beginMethod("List<Class<? extends RealmObject>>", "getModelClasses", EnumSet.of(Modifier.PUBLIC), new String[0]);
        javawriter.emitStatement("return MODEL_CLASSES", new Object[0]);
        javawriter.endMethod();
        javawriter.emitEmptyLine();
    }

    private void emitGetColumnIndices(JavaWriter javawriter)
        throws IOException
    {
        javawriter.emitAnnotation("Override");
        javawriter.beginMethod("Map<String, Long>", "getColumnIndices", EnumSet.of(Modifier.PUBLIC), new String[] {
            "Class<? extends RealmObject>", "clazz"
        });
        emitMediatorSwitch(new ProxySwitchStatement() {

            final RealmProxyMediatorGenerator this$0;

            public void emitStatement(int i, JavaWriter javawriter1)
                throws IOException
            {
                javawriter1.emitStatement("return %s.getColumnIndices()", new Object[] {
                    proxyClasses.get(i)
                });
            }

            
            {
                this$0 = RealmProxyMediatorGenerator.this;
                super();
            }
        }, javawriter, true);
        javawriter.endMethod();
        javawriter.emitEmptyLine();
    }

    private void emitGetFieldNamesMethod(JavaWriter javawriter)
        throws IOException
    {
        javawriter.emitAnnotation("Override");
        javawriter.beginMethod("List<String>", "getFieldNames", EnumSet.of(Modifier.PUBLIC), new String[] {
            "Class<? extends RealmObject>", "clazz"
        });
        emitMediatorSwitch(new ProxySwitchStatement() {

            final RealmProxyMediatorGenerator this$0;

            public void emitStatement(int i, JavaWriter javawriter1)
                throws IOException
            {
                javawriter1.emitStatement("return %s.getFieldNames()", new Object[] {
                    proxyClasses.get(i)
                });
            }

            
            {
                this$0 = RealmProxyMediatorGenerator.this;
                super();
            }
        }, javawriter);
        javawriter.endMethod();
        javawriter.emitEmptyLine();
    }

    private void emitGetTableNameMethod(JavaWriter javawriter)
        throws IOException
    {
        javawriter.emitAnnotation("Override");
        javawriter.beginMethod("String", "getTableName", EnumSet.of(Modifier.PUBLIC), new String[] {
            "Class<? extends RealmObject>", "clazz"
        });
        emitMediatorSwitch(new ProxySwitchStatement() {

            final RealmProxyMediatorGenerator this$0;

            public void emitStatement(int i, JavaWriter javawriter1)
                throws IOException
            {
                javawriter1.emitStatement("return %s.getTableName()", new Object[] {
                    proxyClasses.get(i)
                });
            }

            
            {
                this$0 = RealmProxyMediatorGenerator.this;
                super();
            }
        }, javawriter);
        javawriter.endMethod();
        javawriter.emitEmptyLine();
    }

    private void emitMediatorSwitch(ProxySwitchStatement proxyswitchstatement, JavaWriter javawriter)
        throws IOException
    {
        emitMediatorSwitch(proxyswitchstatement, javawriter, true);
    }

    private void emitMediatorSwitch(ProxySwitchStatement proxyswitchstatement, JavaWriter javawriter, boolean flag)
        throws IOException
    {
        if (flag)
        {
            javawriter.emitStatement("checkClass(clazz)", new Object[0]);
            javawriter.emitEmptyLine();
        }
        if (simpleModelClasses.size() == 0)
        {
            javawriter.emitStatement("throw getMissingProxyClassException(clazz)", new Object[0]);
            return;
        }
        javawriter.beginControlFlow("if (clazz.equals(%s.class))", new Object[] {
            simpleModelClasses.get(0)
        });
        proxyswitchstatement.emitStatement(0, javawriter);
        for (int i = 1; i < simpleModelClasses.size(); i++)
        {
            javawriter.nextControlFlow("else if (clazz.equals(%s.class))", new Object[] {
                simpleModelClasses.get(i)
            });
            proxyswitchstatement.emitStatement(i, javawriter);
        }

        javawriter.nextControlFlow("else", new Object[0]);
        javawriter.emitStatement("throw getMissingProxyClassException(clazz)", new Object[0]);
        javawriter.endControlFlow();
    }

    private void emitNewInstanceMethod(JavaWriter javawriter)
        throws IOException
    {
        javawriter.emitAnnotation("Override");
        javawriter.beginMethod("<E extends RealmObject> E", "newInstance", EnumSet.of(Modifier.PUBLIC), new String[] {
            "Class<E>", "clazz"
        });
        emitMediatorSwitch(new ProxySwitchStatement() {

            final RealmProxyMediatorGenerator this$0;

            public void emitStatement(int i, JavaWriter javawriter1)
                throws IOException
            {
                javawriter1.emitStatement("return (E) new %s()", new Object[] {
                    proxyClasses.get(i)
                });
            }

            
            {
                this$0 = RealmProxyMediatorGenerator.this;
                super();
            }
        }, javawriter);
        javawriter.endMethod();
        javawriter.emitEmptyLine();
    }

    private void emitValidateTableMethod(JavaWriter javawriter)
        throws IOException
    {
        javawriter.emitAnnotation("Override");
        javawriter.beginMethod("void", "validateTable", EnumSet.of(Modifier.PUBLIC), new String[] {
            "Class<? extends RealmObject>", "clazz", "ImplicitTransaction", "transaction"
        });
        emitMediatorSwitch(new ProxySwitchStatement() {

            final RealmProxyMediatorGenerator this$0;

            public void emitStatement(int i, JavaWriter javawriter1)
                throws IOException
            {
                javawriter1.emitStatement("%s.validateTable(transaction)", new Object[] {
                    proxyClasses.get(i)
                });
            }

            
            {
                this$0 = RealmProxyMediatorGenerator.this;
                super();
            }
        }, javawriter);
        javawriter.endMethod();
        javawriter.emitEmptyLine();
    }

    private String getProxyClassName(String s)
    {
        return (new StringBuilder()).append(s).append("RealmProxy").toString();
    }

    public void generate()
        throws IOException
    {
        String s = String.format("%s.%sMediator", new Object[] {
            "io.realm", className
        });
        JavaWriter javawriter = new JavaWriter(new BufferedWriter(processingEnvironment.getFiler().createSourceFile(s, new Element[0]).openWriter()));
        javawriter.setIndent("    ");
        javawriter.emitPackage("io.realm");
        javawriter.emitEmptyLine();
        javawriter.emitImports(new String[] {
            "android.util.JsonReader", "java.io.IOException", "java.util.ArrayList", "java.util.Collections", "java.util.List", "java.util.Map", "io.realm.exceptions.RealmException", "io.realm.internal.ImplicitTransaction", "io.realm.internal.RealmObjectProxy", "io.realm.internal.RealmProxyMediator", 
            "io.realm.internal.Table", "org.json.JSONException", "org.json.JSONObject"
        });
        javawriter.emitImports(qualifiedModelClasses);
        javawriter.emitEmptyLine();
        javawriter.emitAnnotation(io/realm/annotations/internal/RealmModule);
        javawriter.beginType(s, "class", Collections.emptySet(), "RealmProxyMediator", new String[0]);
        javawriter.emitEmptyLine();
        emitFields(javawriter);
        emitCreateTableMethod(javawriter);
        emitValidateTableMethod(javawriter);
        emitGetFieldNamesMethod(javawriter);
        emitGetTableNameMethod(javawriter);
        emitNewInstanceMethod(javawriter);
        emitGetClassModelList(javawriter);
        emitGetColumnIndices(javawriter);
        emitCopyToRealmMethod(javawriter);
        emitCreteOrUpdateUsingJsonObject(javawriter);
        emitCreateUsingJsonStream(javawriter);
        javawriter.endType();
        javawriter.close();
    }


}
