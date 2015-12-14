// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.aspectj.runtime.reflect;

import java.util.Hashtable;
import java.util.StringTokenizer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.aspectj.lang.reflect.SourceLocation;

// Referenced classes of package org.aspectj.runtime.reflect:
//            JoinPointImpl, MethodSignatureImpl, SourceLocationImpl

public final class Factory
{

    private static Object NO_ARGS[] = new Object[0];
    static Class class$java$lang$ClassNotFoundException;
    static Hashtable prims;
    int count;
    String filename;
    Class lexicalClass;
    ClassLoader lookupClassLoader;

    public Factory(String s, Class class1)
    {
        filename = s;
        lexicalClass = class1;
        count = 0;
        lookupClassLoader = class1.getClassLoader();
    }

    static Class _mthclass$(String s)
    {
        try
        {
            s = Class.forName(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new NoClassDefFoundError(s.getMessage());
        }
        return s;
    }

    static Class makeClass(String s, ClassLoader classloader)
    {
        if (!s.equals("*")) goto _L2; else goto _L1
_L1:
        Class class1 = null;
_L4:
        return class1;
_L2:
        Class class2;
        class2 = (Class)prims.get(s);
        class1 = class2;
        if (class2 != null) goto _L4; else goto _L3
_L3:
        if (classloader != null)
        {
            break MISSING_BLOCK_LABEL_39;
        }
        return Class.forName(s);
        s = Class.forName(s, false, classloader);
        return s;
        s;
        if (class$java$lang$ClassNotFoundException == null)
        {
            s = _mthclass$("java.lang.ClassNotFoundException");
            class$java$lang$ClassNotFoundException = s;
        } else
        {
            s = class$java$lang$ClassNotFoundException;
        }
        return s;
    }

    public static JoinPoint makeJP(org.aspectj.lang.JoinPoint.StaticPart staticpart, Object obj, Object obj1)
    {
        return new JoinPointImpl(staticpart, obj, obj1, NO_ARGS);
    }

    public static JoinPoint makeJP(org.aspectj.lang.JoinPoint.StaticPart staticpart, Object obj, Object obj1, Object obj2)
    {
        return new JoinPointImpl(staticpart, obj, obj1, new Object[] {
            obj2
        });
    }

    public static JoinPoint makeJP(org.aspectj.lang.JoinPoint.StaticPart staticpart, Object obj, Object obj1, Object aobj[])
    {
        return new JoinPointImpl(staticpart, obj, obj1, aobj);
    }

    public MethodSignature makeMethodSig(String s, String s1, String s2, String s3, String s4, String s5, String s6)
    {
        int l = Integer.parseInt(s, 16);
        s = makeClass(s2, lookupClassLoader);
        s3 = new StringTokenizer(s3, ":");
        int i1 = s3.countTokens();
        s2 = new Class[i1];
        for (int i = 0; i < i1; i++)
        {
            s2[i] = makeClass(s3.nextToken(), lookupClassLoader);
        }

        s4 = new StringTokenizer(s4, ":");
        i1 = s4.countTokens();
        s3 = new String[i1];
        for (int j = 0; j < i1; j++)
        {
            s3[j] = s4.nextToken();
        }

        s4 = new StringTokenizer(s5, ":");
        i1 = s4.countTokens();
        s5 = new Class[i1];
        for (int k = 0; k < i1; k++)
        {
            s5[k] = makeClass(s4.nextToken(), lookupClassLoader);
        }

        return new MethodSignatureImpl(l, s1, s, s2, s3, s5, makeClass(s6, lookupClassLoader));
    }

    public org.aspectj.lang.JoinPoint.StaticPart makeSJP(String s, Signature signature, int i)
    {
        int j = count;
        count = j + 1;
        return new JoinPointImpl.StaticPartImpl(j, s, signature, makeSourceLoc(i, -1));
    }

    public SourceLocation makeSourceLoc(int i, int j)
    {
        return new SourceLocationImpl(lexicalClass, filename, i);
    }

    static 
    {
        prims = new Hashtable();
        prims.put("void", Void.TYPE);
        prims.put("boolean", Boolean.TYPE);
        prims.put("byte", Byte.TYPE);
        prims.put("char", Character.TYPE);
        prims.put("short", Short.TYPE);
        prims.put("int", Integer.TYPE);
        prims.put("long", Long.TYPE);
        prims.put("float", Float.TYPE);
        prims.put("double", Double.TYPE);
    }
}
