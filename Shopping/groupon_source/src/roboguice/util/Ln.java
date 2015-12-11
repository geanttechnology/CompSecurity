// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package roboguice.util;


// Referenced classes of package roboguice.util:
//            LnImpl, LnInterface

public final class Ln
{

    protected static LnInterface lnImpl = new LnImpl();

    private Ln()
    {
    }

    public static transient int d(Object obj, Object aobj[])
    {
        return lnImpl.d(obj, aobj);
    }

    public static int d(Throwable throwable)
    {
        return lnImpl.d(throwable);
    }

    public static transient int d(Throwable throwable, Object obj, Object aobj[])
    {
        return lnImpl.d(throwable, obj, aobj);
    }

    public static transient int e(Object obj, Object aobj[])
    {
        return lnImpl.e(obj, aobj);
    }

    public static int e(Throwable throwable)
    {
        return lnImpl.e(throwable);
    }

    public static transient int e(Throwable throwable, Object obj, Object aobj[])
    {
        return lnImpl.e(throwable, obj, aobj);
    }

    public static int getLoggingLevel()
    {
        return lnImpl.getLoggingLevel();
    }

    public static transient int i(Object obj, Object aobj[])
    {
        return lnImpl.i(obj, aobj);
    }

    public static int i(Throwable throwable)
    {
        return lnImpl.i(throwable);
    }

    public static transient int i(Throwable throwable, Object obj, Object aobj[])
    {
        return lnImpl.i(throwable, obj, aobj);
    }

    public static boolean isDebugEnabled()
    {
        return lnImpl.isDebugEnabled();
    }

    public static boolean isVerboseEnabled()
    {
        return lnImpl.isVerboseEnabled();
    }

    public static String logLevelToString(int j)
    {
        return lnImpl.logLevelToString(j);
    }

    public static void setLoggingLevel(int j)
    {
        lnImpl.setLoggingLevel(j);
    }

    public static transient int v(Object obj, Object aobj[])
    {
        return lnImpl.v(obj, aobj);
    }

    public static int v(Throwable throwable)
    {
        return lnImpl.v(throwable);
    }

    public static transient int v(Throwable throwable, Object obj, Object aobj[])
    {
        return lnImpl.v(throwable, obj, aobj);
    }

    public static transient int w(Object obj, Object aobj[])
    {
        return lnImpl.w(obj, aobj);
    }

    public static int w(Throwable throwable)
    {
        return lnImpl.w(throwable);
    }

    public static transient int w(Throwable throwable, Object obj, Object aobj[])
    {
        return lnImpl.w(throwable, obj, aobj);
    }

}
