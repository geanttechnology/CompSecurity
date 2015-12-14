// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.aspectj.runtime.reflect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.SourceLocation;
import org.aspectj.runtime.internal.AroundClosure;

// Referenced classes of package org.aspectj.runtime.reflect:
//            StringMaker, SignatureImpl

class JoinPointImpl
    implements ProceedingJoinPoint
{
    static class StaticPartImpl
        implements org.aspectj.lang.JoinPoint.StaticPart
    {

        private int id;
        String kind;
        Signature signature;
        SourceLocation sourceLocation;

        public String getKind()
        {
            return kind;
        }

        public Signature getSignature()
        {
            return signature;
        }

        public final String toString()
        {
            return toString(StringMaker.middleStringMaker);
        }

        String toString(StringMaker stringmaker)
        {
            StringBuffer stringbuffer = new StringBuffer();
            stringbuffer.append(stringmaker.makeKindName(getKind()));
            stringbuffer.append("(");
            stringbuffer.append(((SignatureImpl)getSignature()).toString(stringmaker));
            stringbuffer.append(")");
            return stringbuffer.toString();
        }

        public StaticPartImpl(int i, String s, Signature signature1, SourceLocation sourcelocation)
        {
            kind = s;
            signature = signature1;
            sourceLocation = sourcelocation;
            id = i;
        }
    }


    Object _this;
    private AroundClosure arc;
    Object args[];
    org.aspectj.lang.JoinPoint.StaticPart staticPart;
    Object target;

    public JoinPointImpl(org.aspectj.lang.JoinPoint.StaticPart staticpart, Object obj, Object obj1, Object aobj[])
    {
        staticPart = staticpart;
        _this = obj;
        target = obj1;
        args = aobj;
    }

    public Object[] getArgs()
    {
        if (args == null)
        {
            args = new Object[0];
        }
        Object aobj[] = new Object[args.length];
        System.arraycopy(((Object) (args)), 0, ((Object) (aobj)), 0, args.length);
        return aobj;
    }

    public Object getTarget()
    {
        return target;
    }

    public Object getThis()
    {
        return _this;
    }

    public Object proceed()
        throws Throwable
    {
        if (arc == null)
        {
            return null;
        } else
        {
            return arc.run(arc.getState());
        }
    }

    public void set$AroundClosure(AroundClosure aroundclosure)
    {
        arc = aroundclosure;
    }

    public final String toString()
    {
        return staticPart.toString();
    }
}
