// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.msgpack.template;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtNewConstructor;
import javassist.CtNewMethod;
import javassist.NotFoundException;
import org.msgpack.AbstractTemplate;
import org.msgpack.MessagePackObject;
import org.msgpack.MessageTypeException;
import org.msgpack.Packer;
import org.msgpack.Template;
import org.msgpack.Unpacker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package org.msgpack.template:
//            TemplateBuilder, BooleanArrayTemplate, ShortArrayTemplate, IntArrayTemplate, 
//            LongArrayTemplate, FloatArrayTemplate, DoubleArrayTemplate, TemplateRegistry, 
//            TemplateBuildException

public class JavassistTemplateBuilder extends TemplateBuilder
{
    private static class BuildContext extends BuildContextBase
    {

        protected TemplateBuilder.FieldEntry entries[];
        protected int minimumArrayLength;
        protected Class origClass;
        protected String origName;
        protected Template templates[];

        protected void buildConstructor()
            throws CannotCompileException, NotFoundException
        {
            Object obj = director.getCtClass(java/lang/Class.getName());
            CtClass ctclass = director.getCtClass((new StringBuilder()).append(org/msgpack/Template.getName()).append("[]").toString());
            CtClass ctclass1 = tmplCtClass;
            obj = CtNewConstructor.make(new CtClass[] {
                obj, ctclass
            }, new CtClass[0], ctclass1);
            tmplCtClass.addConstructor(((javassist.CtConstructor) (obj)));
        }

        protected String buildConvertMethodBody()
        {
            resetStringBuilder();
            buildString("{ ");
            buildString("%s _$$_t;", new Object[] {
                origName
            });
            buildString("if($2 == null) {");
            buildString("  _$$_t = new %s();", new Object[] {
                origName
            });
            buildString("} else {");
            buildString("  _$$_t = (%s)$2;", new Object[] {
                origName
            });
            buildString("}");
            buildString("%s[] array = $1.asArray();", new Object[] {
                org/msgpack/MessagePackObject.getName()
            });
            buildString("int length = array.length;");
            buildString("if(length < %d) {", new Object[] {
                Integer.valueOf(minimumArrayLength)
            });
            buildString("  throw new %s();", new Object[] {
                org/msgpack/MessageTypeException.getName()
            });
            buildString("}");
            buildString("%s obj;", new Object[] {
                org/msgpack/MessagePackObject.getName()
            });
            int i = 0;
            do
            {
                int j = i;
                if (i < minimumArrayLength)
                {
                    TemplateBuilder.FieldEntry fieldentry = entries[i];
                    if (fieldentry.isAvailable())
                    {
                        buildString("obj = array[%d];", new Object[] {
                            Integer.valueOf(i)
                        });
                        buildString("if(obj.isNil()) {");
                        Class class1;
                        if (fieldentry.isRequired())
                        {
                            buildString("throw new %s();", new Object[] {
                                org/msgpack/MessageTypeException.getName()
                            });
                        } else
                        if (!fieldentry.isOptional())
                        {
                            buildString("_$$_t.%s = null;", new Object[] {
                                fieldentry.getName()
                            });
                        }
                        buildString("} else {");
                        class1 = fieldentry.getType();
                        if (class1.isPrimitive())
                        {
                            buildString("_$$_t.%s = obj.%s();", new Object[] {
                                fieldentry.getName(), primitiveConvertName(class1)
                            });
                        } else
                        {
                            buildString("_$$_t.%s = (%s)this.templates[%d].convert(obj, _$$_t.%s);", new Object[] {
                                fieldentry.getName(), fieldentry.getJavaTypeName(), Integer.valueOf(i), fieldentry.getName()
                            });
                        }
                        buildString("}");
                    }
                    i++;
                } else
                {
                    while (j < entries.length) 
                    {
                        buildString("if(length <= %d) { return _$$_t; }", new Object[] {
                            Integer.valueOf(j)
                        });
                        TemplateBuilder.FieldEntry fieldentry1 = entries[j];
                        if (fieldentry1.isAvailable())
                        {
                            buildString("obj = array[%d];", new Object[] {
                                Integer.valueOf(j)
                            });
                            buildString("if(obj.isNil()) {");
                            buildString("} else {");
                            Class class2 = fieldentry1.getType();
                            if (class2.isPrimitive())
                            {
                                buildString("_$$_t.%s = obj.%s();", new Object[] {
                                    fieldentry1.getName(), primitiveConvertName(class2)
                                });
                            } else
                            {
                                buildString("_$$_t.%s = (%s)this.templates[%d].convert(obj, _$$_t.%s);", new Object[] {
                                    fieldentry1.getName(), fieldentry1.getJavaTypeName(), Integer.valueOf(j), fieldentry1.getName()
                                });
                            }
                            buildString("}");
                        }
                        j++;
                    }
                    buildString("return _$$_t;");
                    buildString("}");
                    return getBuiltString();
                }
            } while (true);
        }

        protected Template buildInstance(Class class1)
            throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException
        {
            return (Template)class1.getConstructor(new Class[] {
                java/lang/Class, [Lorg/msgpack/Template;
            }).newInstance(new Object[] {
                origClass, templates
            });
        }

        protected void buildMethodInit()
        {
            minimumArrayLength = 0;
            for (int i = 0; i < entries.length; i++)
            {
                TemplateBuilder.FieldEntry fieldentry = entries[i];
                if (fieldentry.isRequired() || fieldentry.isNullable())
                {
                    minimumArrayLength = i + 1;
                }
            }

        }

        protected String buildPackMethodBody()
        {
            resetStringBuilder();
            buildString("{");
            buildString("%s _$$_t = (%s)$2;", new Object[] {
                origName, origName
            });
            buildString("$1.packArray(%d);", new Object[] {
                Integer.valueOf(entries.length)
            });
            int i = 0;
            do
            {
                if (i < entries.length)
                {
                    TemplateBuilder.FieldEntry fieldentry = entries[i];
                    if (!fieldentry.isAvailable())
                    {
                        buildString("$1.packNil();");
                    } else
                    {
                        Class class1 = fieldentry.getType();
                        if (class1.isPrimitive())
                        {
                            buildString("$1.%s(_$$_t.%s);", new Object[] {
                                primitivePackName(class1), fieldentry.getName()
                            });
                        } else
                        {
                            buildString("if(_$$_t.%s == null) {", new Object[] {
                                fieldentry.getName()
                            });
                            if (!fieldentry.isNullable() && !fieldentry.isOptional())
                            {
                                buildString("throw new %s();", new Object[] {
                                    org/msgpack/MessageTypeException.getName()
                                });
                            } else
                            {
                                buildString("$1.packNil();");
                            }
                            buildString("} else {");
                            buildString("  this.templates[%d].pack($1, _$$_t.%s);", new Object[] {
                                Integer.valueOf(i), fieldentry.getName()
                            });
                            buildString("}");
                        }
                    }
                } else
                {
                    buildString("}");
                    return getBuiltString();
                }
                i++;
            } while (true);
        }

        public Template buildTemplate(Class class1, TemplateBuilder.FieldEntry afieldentry[], Template atemplate[])
        {
            entries = afieldentry;
            templates = atemplate;
            origClass = class1;
            origName = origClass.getName();
            return build(origName);
        }

        protected String buildUnpackMethodBody()
        {
            resetStringBuilder();
            buildString("{ ");
            buildString("%s _$$_t;", new Object[] {
                origName
            });
            buildString("if($2 == null) {");
            buildString("  _$$_t = new %s();", new Object[] {
                origName
            });
            buildString("} else {");
            buildString("  _$$_t = (%s)$2;", new Object[] {
                origName
            });
            buildString("}");
            buildString("int length = $1.unpackArray();");
            buildString("if(length < %d) {", new Object[] {
                Integer.valueOf(minimumArrayLength)
            });
            buildString("  throw new %s();", new Object[] {
                org/msgpack/MessageTypeException.getName()
            });
            buildString("}");
            int i = 0;
            do
            {
                int j = i;
                if (i < minimumArrayLength)
                {
                    TemplateBuilder.FieldEntry fieldentry = entries[i];
                    if (!fieldentry.isAvailable())
                    {
                        buildString("$1.unpackObject();");
                    } else
                    {
                        buildString("if($1.tryUnpackNull()) {");
                        Class class1;
                        if (fieldentry.isRequired())
                        {
                            buildString("throw new %s();", new Object[] {
                                org/msgpack/MessageTypeException.getName()
                            });
                        } else
                        if (!fieldentry.isOptional())
                        {
                            buildString("_$$_t.%s = null;", new Object[] {
                                fieldentry.getName()
                            });
                        }
                        buildString("} else {");
                        class1 = fieldentry.getType();
                        if (class1.isPrimitive())
                        {
                            buildString("_$$_t.%s = $1.%s();", new Object[] {
                                fieldentry.getName(), primitiveUnpackName(class1)
                            });
                        } else
                        {
                            buildString("_$$_t.%s = (%s)this.templates[%d].unpack($1, _$$_t.%s);", new Object[] {
                                fieldentry.getName(), fieldentry.getJavaTypeName(), Integer.valueOf(i), fieldentry.getName()
                            });
                        }
                        buildString("}");
                    }
                    i++;
                } else
                {
                    while (j < entries.length) 
                    {
                        buildString("if(length <= %d) { return _$$_t; }", new Object[] {
                            Integer.valueOf(j)
                        });
                        TemplateBuilder.FieldEntry fieldentry1 = entries[j];
                        if (!fieldentry1.isAvailable())
                        {
                            buildString("$1.unpackObject();");
                        } else
                        {
                            buildString("if($1.tryUnpackNull()) {");
                            buildString("} else {");
                            Class class2 = fieldentry1.getType();
                            if (class2.isPrimitive())
                            {
                                buildString("_$$_t.%s = $1.%s();", new Object[] {
                                    fieldentry1.getName(), primitiveUnpackName(class2)
                                });
                            } else
                            {
                                buildString("_$$_t.%s = (%s)this.templates[%d].unpack($1, _$$_t.%s);", new Object[] {
                                    fieldentry1.getName(), fieldentry1.getJavaTypeName(), Integer.valueOf(j), fieldentry1.getName()
                                });
                            }
                            buildString("}");
                        }
                        j++;
                    }
                    buildString("for(int i=%d; i < length; i++) {", new Object[] {
                        Integer.valueOf(j)
                    });
                    buildString("  $1.unpackObject();");
                    buildString("}");
                    buildString("return _$$_t;");
                    buildString("}");
                    return getBuiltString();
                }
            } while (true);
        }

        protected String primitiveConvertName(Class class1)
        {
            if (class1 == Boolean.TYPE)
            {
                return "asBoolean";
            }
            if (class1 == Byte.TYPE)
            {
                return "asByte";
            }
            if (class1 == Short.TYPE)
            {
                return "asShort";
            }
            if (class1 == Integer.TYPE)
            {
                return "asInt";
            }
            if (class1 == Long.TYPE)
            {
                return "asLong";
            }
            if (class1 == Float.TYPE)
            {
                return "asFloat";
            }
            if (class1 == Double.TYPE)
            {
                return "asDouble";
            } else
            {
                return null;
            }
        }

        protected String primitivePackName(Class class1)
        {
            if (class1 == Boolean.TYPE)
            {
                return "packBoolean";
            }
            if (class1 == Byte.TYPE)
            {
                return "packByte";
            }
            if (class1 == Short.TYPE)
            {
                return "packShort";
            }
            if (class1 == Integer.TYPE)
            {
                return "packInt";
            }
            if (class1 == Long.TYPE)
            {
                return "packLong";
            }
            if (class1 == Float.TYPE)
            {
                return "packFloat";
            }
            if (class1 == Double.TYPE)
            {
                return "packDouble";
            } else
            {
                return null;
            }
        }

        protected String primitiveUnpackName(Class class1)
        {
            if (class1 == Boolean.TYPE)
            {
                return "unpackBoolean";
            }
            if (class1 == Byte.TYPE)
            {
                return "unpackByte";
            }
            if (class1 == Short.TYPE)
            {
                return "unpackShort";
            }
            if (class1 == Integer.TYPE)
            {
                return "unpackInt";
            }
            if (class1 == Long.TYPE)
            {
                return "unpackLong";
            }
            if (class1 == Float.TYPE)
            {
                return "unpackFloat";
            }
            if (class1 == Double.TYPE)
            {
                return "unpackDouble";
            } else
            {
                return null;
            }
        }

        protected void setSuperClass()
            throws CannotCompileException, NotFoundException
        {
            tmplCtClass.setSuperclass(director.getCtClass(org/msgpack/template/JavassistTemplateBuilder$JavassistTemplate.getName()));
        }

        public BuildContext(JavassistTemplateBuilder javassisttemplatebuilder)
        {
            super(javassisttemplatebuilder);
        }
    }

    private static abstract class BuildContextBase
    {

        protected JavassistTemplateBuilder director;
        protected StringBuilder stringBuilder;
        protected CtClass tmplCtClass;
        protected String tmplName;

        protected Template build(String s)
        {
            try
            {
                reset(s);
                buildClass();
                buildConstructor();
                buildMethodInit();
                buildPackMethod();
                buildUnpackMethod();
                buildConvertMethod();
                s = buildInstance(createClass());
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                String s1 = getBuiltString();
                if (s1 != null)
                {
                    JavassistTemplateBuilder.LOG.error((new StringBuilder()).append("builder: ").append(stringBuilder.toString()).toString());
                }
                if (s1 != null)
                {
                    throw new TemplateBuildException((new StringBuilder()).append("cannot compile: ").append(s1).toString(), s);
                } else
                {
                    throw new TemplateBuildException(s);
                }
            }
            return s;
        }

        protected void buildClass()
            throws CannotCompileException, NotFoundException
        {
            setSuperClass();
            tmplCtClass.addInterface(director.getCtClass(org/msgpack/Template.getName()));
        }

        protected abstract void buildConstructor()
            throws CannotCompileException, NotFoundException;

        protected void buildConvertMethod()
            throws CannotCompileException, NotFoundException
        {
            Object obj = buildConvertMethodBody();
            CtClass ctclass = director.getCtClass(java/lang/Object.getName());
            CtClass ctclass1 = director.getCtClass(org/msgpack/MessagePackObject.getName());
            CtClass ctclass2 = director.getCtClass(java/lang/Object.getName());
            CtClass ctclass3 = director.getCtClass(org/msgpack/MessageTypeException.getName());
            CtClass ctclass4 = tmplCtClass;
            obj = CtNewMethod.make(1, ctclass, "convert", new CtClass[] {
                ctclass1, ctclass2
            }, new CtClass[] {
                ctclass3
            }, ((String) (obj)), ctclass4);
            tmplCtClass.addMethod(((javassist.CtMethod) (obj)));
        }

        protected abstract String buildConvertMethodBody();

        protected abstract Template buildInstance(Class class1)
            throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException;

        protected void buildMethodInit()
        {
        }

        protected void buildPackMethod()
            throws CannotCompileException, NotFoundException
        {
            Object obj = buildPackMethodBody();
            CtClass ctclass = CtClass.voidType;
            CtClass ctclass1 = director.getCtClass(org/msgpack/Packer.getName());
            CtClass ctclass2 = director.getCtClass(java/lang/Object.getName());
            CtClass ctclass3 = director.getCtClass(java/io/IOException.getName());
            CtClass ctclass4 = tmplCtClass;
            obj = CtNewMethod.make(1, ctclass, "pack", new CtClass[] {
                ctclass1, ctclass2
            }, new CtClass[] {
                ctclass3
            }, ((String) (obj)), ctclass4);
            tmplCtClass.addMethod(((javassist.CtMethod) (obj)));
        }

        protected abstract String buildPackMethodBody();

        protected void buildString(String s)
        {
            stringBuilder.append(s);
        }

        protected transient void buildString(String s, Object aobj[])
        {
            stringBuilder.append(String.format(s, aobj));
        }

        protected void buildUnpackMethod()
            throws CannotCompileException, NotFoundException
        {
            Object obj = buildUnpackMethodBody();
            CtClass ctclass = director.getCtClass(java/lang/Object.getName());
            CtClass ctclass1 = director.getCtClass(org/msgpack/Unpacker.getName());
            CtClass ctclass2 = director.getCtClass(java/lang/Object.getName());
            CtClass ctclass3 = director.getCtClass(org/msgpack/MessageTypeException.getName());
            CtClass ctclass4 = tmplCtClass;
            obj = CtNewMethod.make(1, ctclass, "unpack", new CtClass[] {
                ctclass1, ctclass2
            }, new CtClass[] {
                ctclass3
            }, ((String) (obj)), ctclass4);
            tmplCtClass.addMethod(((javassist.CtMethod) (obj)));
        }

        protected abstract String buildUnpackMethodBody();

        protected Class createClass()
            throws CannotCompileException
        {
            return tmplCtClass.toClass(null, null);
        }

        protected String getBuiltString()
        {
            if (stringBuilder == null)
            {
                return null;
            } else
            {
                return stringBuilder.toString();
            }
        }

        protected void reset(String s)
        {
            tmplName = (new StringBuilder()).append(s).append("_$$_Template").append(director.nextSeqId()).toString();
            tmplCtClass = director.makeCtClass(tmplName);
        }

        protected void resetStringBuilder()
        {
            stringBuilder = new StringBuilder();
        }

        protected abstract void setSuperClass()
            throws CannotCompileException, NotFoundException;

        public BuildContextBase(JavassistTemplateBuilder javassisttemplatebuilder)
        {
            stringBuilder = null;
            director = javassisttemplatebuilder;
        }
    }

    static class JavassistOrdinalEnumTemplate extends ReflectionTemplateBuilder.ReflectionOrdinalEnumTemplate
    {

        JavassistOrdinalEnumTemplate(Enum aenum[])
        {
            super(aenum);
        }
    }

    public static abstract class JavassistTemplate extends AbstractTemplate
    {
    }


    private static Logger LOG = LoggerFactory.getLogger(org/msgpack/template/JavassistTemplateBuilder);
    private static JavassistTemplateBuilder instance;
    protected ClassPool pool;
    private int seqId;

    private JavassistTemplateBuilder()
    {
        seqId = 0;
        pool = ClassPool.getDefault();
    }

    public static JavassistTemplateBuilder getInstance()
    {
        org/msgpack/template/JavassistTemplateBuilder;
        JVM INSTR monitorenter ;
        JavassistTemplateBuilder javassisttemplatebuilder;
        if (instance == null)
        {
            instance = new JavassistTemplateBuilder();
        }
        javassisttemplatebuilder = instance;
        org/msgpack/template/JavassistTemplateBuilder;
        JVM INSTR monitorexit ;
        return javassisttemplatebuilder;
        Exception exception;
        exception;
        throw exception;
    }

    public Template buildArrayTemplate(Type type, Type type1, Class class1, int i)
    {
        if (i == 1)
        {
            if (class1 == Boolean.TYPE)
            {
                return BooleanArrayTemplate.getInstance();
            }
            if (class1 == Short.TYPE)
            {
                return ShortArrayTemplate.getInstance();
            }
            if (class1 == Integer.TYPE)
            {
                return IntArrayTemplate.getInstance();
            }
            if (class1 == Long.TYPE)
            {
                return LongArrayTemplate.getInstance();
            }
            if (class1 == Float.TYPE)
            {
                return FloatArrayTemplate.getInstance();
            }
            if (class1 == Double.TYPE)
            {
                return DoubleArrayTemplate.getInstance();
            } else
            {
                return new ReflectionTemplateBuilder.ReflectionObjectArrayTemplate(class1, TemplateRegistry.lookup(type1));
            }
        }
        if (i == 2)
        {
            return new ReflectionTemplateBuilder.ReflectionMultidimentionalArrayTemplate(Array.newInstance(class1, 0).getClass(), buildArrayTemplate(type, type1, class1, i - 1));
        } else
        {
            type = (ReflectionTemplateBuilder.ReflectionMultidimentionalArrayTemplate)buildArrayTemplate(type, type1, class1, i - 1);
            return new ReflectionTemplateBuilder.ReflectionMultidimentionalArrayTemplate(Array.newInstance(type.getComponentClass(), 0).getClass(), type);
        }
    }

    public Template buildOrdinalEnumTemplate(Class class1, Enum aenum[])
    {
        return new JavassistOrdinalEnumTemplate(aenum);
    }

    public Template buildTemplate(Class class1, TemplateBuilder.FieldEntry afieldentry[])
    {
        Template atemplate[] = new Template[afieldentry.length];
        int i = 0;
        while (i < afieldentry.length) 
        {
            TemplateBuilder.FieldEntry fieldentry = afieldentry[i];
            if (!fieldentry.isAvailable())
            {
                atemplate[i] = null;
            } else
            {
                atemplate[i] = TemplateRegistry.lookup(fieldentry.getGenericType(), true);
            }
            i++;
        }
        return (new BuildContext(this)).buildTemplate(class1, afieldentry, atemplate);
    }

    CtClass getCtClass(String s)
        throws NotFoundException
    {
        return pool.get(s);
    }

    CtClass makeCtClass(String s)
    {
        return pool.makeClass(s);
    }

    int nextSeqId()
    {
        int i = seqId;
        seqId = i + 1;
        return i;
    }


}
