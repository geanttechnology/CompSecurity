// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.msgpack.template;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import javassist.CannotCompileException;
import javassist.CtClass;
import javassist.CtNewMethod;
import javassist.NotFoundException;
import org.msgpack.MessagePackObject;
import org.msgpack.MessageTypeException;
import org.msgpack.Packer;
import org.msgpack.Template;
import org.msgpack.Unpacker;
import org.slf4j.Logger;

// Referenced classes of package org.msgpack.template:
//            JavassistTemplateBuilder, TemplateBuildException

private static abstract class director
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
                JavassistTemplateBuilder.access$000().error((new StringBuilder()).append("builder: ").append(stringBuilder.toString()).toString());
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

    public (JavassistTemplateBuilder javassisttemplatebuilder)
    {
        stringBuilder = null;
        director = javassisttemplatebuilder;
    }
}
