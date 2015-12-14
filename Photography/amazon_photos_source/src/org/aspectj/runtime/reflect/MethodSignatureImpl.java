// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.aspectj.runtime.reflect;

import org.aspectj.lang.reflect.MethodSignature;

// Referenced classes of package org.aspectj.runtime.reflect:
//            CodeSignatureImpl, SignatureImpl, StringMaker

class MethodSignatureImpl extends CodeSignatureImpl
    implements MethodSignature
{

    Class returnType;

    MethodSignatureImpl(int i, String s, Class class1, Class aclass[], String as[], Class aclass1[], Class class2)
    {
        super(i, s, class1, aclass, as, aclass1);
        returnType = class2;
    }

    protected String createToString(StringMaker stringmaker)
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append(stringmaker.makeModifiersString(getModifiers()));
        if (stringmaker.includeArgs)
        {
            stringbuffer.append(stringmaker.makeTypeName(getReturnType()));
        }
        if (stringmaker.includeArgs)
        {
            stringbuffer.append(" ");
        }
        stringbuffer.append(stringmaker.makePrimaryTypeName(getDeclaringType(), getDeclaringTypeName()));
        stringbuffer.append(".");
        stringbuffer.append(getName());
        stringmaker.addSignature(stringbuffer, getParameterTypes());
        stringmaker.addThrows(stringbuffer, getExceptionTypes());
        return stringbuffer.toString();
    }

    public Class getReturnType()
    {
        if (returnType == null)
        {
            returnType = extractType(6);
        }
        return returnType;
    }
}
