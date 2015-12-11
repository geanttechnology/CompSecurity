// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.msgpack.template;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import javassist.CannotCompileException;
import javassist.CtClass;
import javassist.CtNewConstructor;
import javassist.NotFoundException;
import org.msgpack.MessagePackObject;
import org.msgpack.MessageTypeException;
import org.msgpack.Template;

// Referenced classes of package org.msgpack.template:
//            JavassistTemplateBuilder

private static class ase extends ase
{

    protected director entries[];
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
                tmplCtClass tmplctclass = entries[i];
                if (tmplctclass.())
                {
                    buildString("obj = array[%d];", new Object[] {
                        Integer.valueOf(i)
                    });
                    buildString("if(obj.isNil()) {");
                    Class class1;
                    if (tmplctclass.buildString())
                    {
                        buildString("throw new %s();", new Object[] {
                            org/msgpack/MessageTypeException.getName()
                        });
                    } else
                    if (!tmplctclass.buildString())
                    {
                        buildString("_$$_t.%s = null;", new Object[] {
                            tmplctclass.buildString()
                        });
                    }
                    buildString("} else {");
                    class1 = tmplctclass.buildString();
                    if (class1.isPrimitive())
                    {
                        buildString("_$$_t.%s = obj.%s();", new Object[] {
                            tmplctclass.buildString(), primitiveConvertName(class1)
                        });
                    } else
                    {
                        buildString("_$$_t.%s = (%s)this.templates[%d].convert(obj, _$$_t.%s);", new Object[] {
                            tmplctclass.buildString(), tmplctclass.Name(), Integer.valueOf(i), tmplctclass.Name()
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
                    tmplCtClass tmplctclass1 = entries[j];
                    if (tmplctclass1.())
                    {
                        buildString("obj = array[%d];", new Object[] {
                            Integer.valueOf(j)
                        });
                        buildString("if(obj.isNil()) {");
                        buildString("} else {");
                        Class class2 = tmplctclass1.buildString();
                        if (class2.isPrimitive())
                        {
                            buildString("_$$_t.%s = obj.%s();", new Object[] {
                                tmplctclass1.buildString(), primitiveConvertName(class2)
                            });
                        } else
                        {
                            buildString("_$$_t.%s = (%s)this.templates[%d].convert(obj, _$$_t.%s);", new Object[] {
                                tmplctclass1.buildString(), tmplctclass1.Name(), Integer.valueOf(j), tmplctclass1.Name()
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
            templates templates1 = entries[i];
            if (templates1.entries() || templates1.entries())
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
                minimumArrayLength minimumarraylength = entries[i];
                if (!minimumarraylength.())
                {
                    buildString("$1.packNil();");
                } else
                {
                    Class class1 = minimumarraylength.buildString();
                    if (class1.isPrimitive())
                    {
                        buildString("$1.%s(_$$_t.%s);", new Object[] {
                            primitivePackName(class1), minimumarraylength.primitivePackName()
                        });
                    } else
                    {
                        buildString("if(_$$_t.%s == null) {", new Object[] {
                            minimumarraylength.buildString()
                        });
                        if (!minimumarraylength.buildString() && !minimumarraylength.buildString())
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
                            Integer.valueOf(i), minimumarraylength.buildString()
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

    public Template buildTemplate(Class class1, getBuiltString agetbuiltstring[], Template atemplate[])
    {
        entries = agetbuiltstring;
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
                origName origname = entries[i];
                if (!origname.())
                {
                    buildString("$1.unpackObject();");
                } else
                {
                    buildString("if($1.tryUnpackNull()) {");
                    Class class1;
                    if (origname.buildString())
                    {
                        buildString("throw new %s();", new Object[] {
                            org/msgpack/MessageTypeException.getName()
                        });
                    } else
                    if (!origname.buildString())
                    {
                        buildString("_$$_t.%s = null;", new Object[] {
                            origname.buildString()
                        });
                    }
                    buildString("} else {");
                    class1 = origname.buildString();
                    if (class1.isPrimitive())
                    {
                        buildString("_$$_t.%s = $1.%s();", new Object[] {
                            origname.buildString(), primitiveUnpackName(class1)
                        });
                    } else
                    {
                        buildString("_$$_t.%s = (%s)this.templates[%d].unpack($1, _$$_t.%s);", new Object[] {
                            origname.buildString(), origname.Name(), Integer.valueOf(i), origname.Name()
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
                    origName origname1 = entries[j];
                    if (!origname1.())
                    {
                        buildString("$1.unpackObject();");
                    } else
                    {
                        buildString("if($1.tryUnpackNull()) {");
                        buildString("} else {");
                        Class class2 = origname1.buildString();
                        if (class2.isPrimitive())
                        {
                            buildString("_$$_t.%s = $1.%s();", new Object[] {
                                origname1.buildString(), primitiveUnpackName(class2)
                            });
                        } else
                        {
                            buildString("_$$_t.%s = (%s)this.templates[%d].unpack($1, _$$_t.%s);", new Object[] {
                                origname1.buildString(), origname1.Name(), Integer.valueOf(j), origname1.Name()
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

    public late(JavassistTemplateBuilder javassisttemplatebuilder)
    {
        super(javassisttemplatebuilder);
    }
}
