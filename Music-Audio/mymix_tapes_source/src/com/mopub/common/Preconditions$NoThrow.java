// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;


// Referenced classes of package com.mopub.common:
//            Preconditions

public static final class 
{

    private static volatile boolean sStrictMode = false;

    public static boolean checkArgument(boolean flag)
    {
        return Preconditions.access$000(flag, sStrictMode, "Illegal argument", new Object[] {
            ""
        });
    }

    public static boolean checkArgument(boolean flag, String s)
    {
        return Preconditions.access$000(flag, sStrictMode, s, new Object[] {
            ""
        });
    }

    public static transient boolean checkArgument(boolean flag, String s, Object aobj[])
    {
        return Preconditions.access$000(flag, sStrictMode, s, aobj);
    }

    public static boolean checkNotNull(Object obj)
    {
        return Preconditions.access$200(obj, sStrictMode, "Object can not be null.", new Object[] {
            ""
        });
    }

    public static boolean checkNotNull(Object obj, String s)
    {
        return Preconditions.access$200(obj, sStrictMode, s, new Object[] {
            ""
        });
    }

    public static transient boolean checkNotNull(Object obj, String s, Object aobj[])
    {
        return Preconditions.access$200(obj, sStrictMode, s, aobj);
    }

    public static boolean checkState(boolean flag)
    {
        return Preconditions.access$100(flag, sStrictMode, "Illegal state.", new Object[] {
            ""
        });
    }

    public static boolean checkState(boolean flag, String s)
    {
        return Preconditions.access$100(flag, sStrictMode, s, new Object[] {
            ""
        });
    }

    public static transient boolean checkState(boolean flag, String s, Object aobj[])
    {
        return Preconditions.access$100(flag, sStrictMode, s, aobj);
    }

    public static boolean checkUiThread()
    {
        return Preconditions.access$300(sStrictMode, "This method must be called from the UI thread.", new Object[] {
            ""
        });
    }

    public static boolean checkUiThread(String s)
    {
        return Preconditions.access$300(sStrictMode, s, new Object[] {
            ""
        });
    }

    public static transient boolean checkUiThread(String s, Object aobj[])
    {
        return Preconditions.access$300(false, s, aobj);
    }

    public static void setStrictMode(boolean flag)
    {
        sStrictMode = flag;
    }


    public ()
    {
    }
}
