// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.aspectj.runtime.reflect;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
import org.aspectj.lang.Signature;

// Referenced classes of package org.aspectj.runtime.reflect:
//            Factory, StringMaker

abstract class SignatureImpl
    implements Signature
{
    private static interface Cache
    {

        public abstract String get(int i);

        public abstract void set(int i, String s);
    }

    private static final class CacheImpl
        implements Cache
    {

        private SoftReference toStringCacheRef;

        private String[] array()
        {
            return (String[])(String[])toStringCacheRef.get();
        }

        private String[] makeCache()
        {
            String as[] = new String[3];
            toStringCacheRef = new SoftReference(as);
            return as;
        }

        public String get(int i)
        {
            String as[] = array();
            if (as == null)
            {
                return null;
            } else
            {
                return as[i];
            }
        }

        public void set(int i, String s)
        {
            String as1[] = array();
            String as[] = as1;
            if (as1 == null)
            {
                as = makeCache();
            }
            as[i] = s;
        }

        public CacheImpl()
        {
            makeCache();
        }
    }


    static Class EMPTY_CLASS_ARRAY[] = new Class[0];
    static String EMPTY_STRING_ARRAY[] = new String[0];
    private static boolean useCache = true;
    Class declaringType;
    String declaringTypeName;
    ClassLoader lookupClassLoader;
    int modifiers;
    String name;
    Cache stringCache;
    private String stringRep;

    SignatureImpl(int i, String s, Class class1)
    {
        modifiers = -1;
        lookupClassLoader = null;
        modifiers = i;
        name = s;
        declaringType = class1;
    }

    private ClassLoader getLookupClassLoader()
    {
        if (lookupClassLoader == null)
        {
            lookupClassLoader = getClass().getClassLoader();
        }
        return lookupClassLoader;
    }

    protected abstract String createToString(StringMaker stringmaker);

    int extractInt(int i)
    {
        return Integer.parseInt(extractString(i), 16);
    }

    String extractString(int i)
    {
        int j = 0;
        int l = stringRep.indexOf('-');
        int k = i;
        i = l;
        for (; k > 0; k--)
        {
            j = i + 1;
            i = stringRep.indexOf('-', j);
        }

        k = i;
        if (i == -1)
        {
            k = stringRep.length();
        }
        return stringRep.substring(j, k);
    }

    Class extractType(int i)
    {
        return Factory.makeClass(extractString(i), getLookupClassLoader());
    }

    Class[] extractTypes(int i)
    {
        StringTokenizer stringtokenizer = new StringTokenizer(extractString(i), ":");
        int j = stringtokenizer.countTokens();
        Class aclass[] = new Class[j];
        for (i = 0; i < j; i++)
        {
            aclass[i] = Factory.makeClass(stringtokenizer.nextToken(), getLookupClassLoader());
        }

        return aclass;
    }

    public Class getDeclaringType()
    {
        if (declaringType == null)
        {
            declaringType = extractType(2);
        }
        return declaringType;
    }

    public String getDeclaringTypeName()
    {
        if (declaringTypeName == null)
        {
            declaringTypeName = getDeclaringType().getName();
        }
        return declaringTypeName;
    }

    public int getModifiers()
    {
        if (modifiers == -1)
        {
            modifiers = extractInt(0);
        }
        return modifiers;
    }

    public String getName()
    {
        if (name == null)
        {
            name = extractString(1);
        }
        return name;
    }

    public final String toString()
    {
        return toString(StringMaker.middleStringMaker);
    }

    String toString(StringMaker stringmaker)
    {
        Object obj;
        Object obj1;
        obj1 = null;
        obj = obj1;
        if (!useCache) goto _L2; else goto _L1
_L1:
        if (stringCache != null) goto _L4; else goto _L3
_L3:
        try
        {
            stringCache = new CacheImpl();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            useCache = false;
            obj = obj1;
            continue; /* Loop/switch isn't completed */
        }
        obj = obj1;
_L2:
        obj1 = obj;
        if (obj == null)
        {
            obj1 = createToString(stringmaker);
        }
        if (useCache)
        {
            stringCache.set(stringmaker.cacheOffset, ((String) (obj1)));
        }
        return ((String) (obj1));
_L4:
        obj = stringCache.get(stringmaker.cacheOffset);
        if (true) goto _L2; else goto _L5
_L5:
    }

}
