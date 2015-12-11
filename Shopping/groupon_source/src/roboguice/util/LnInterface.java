// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package roboguice.util;


public interface LnInterface
{

    public transient abstract int d(Object obj, Object aobj[]);

    public abstract int d(Throwable throwable);

    public transient abstract int d(Throwable throwable, Object obj, Object aobj[]);

    public transient abstract int e(Object obj, Object aobj[]);

    public abstract int e(Throwable throwable);

    public transient abstract int e(Throwable throwable, Object obj, Object aobj[]);

    public abstract int getLoggingLevel();

    public transient abstract int i(Object obj, Object aobj[]);

    public abstract int i(Throwable throwable);

    public transient abstract int i(Throwable throwable, Object obj, Object aobj[]);

    public abstract boolean isDebugEnabled();

    public abstract boolean isVerboseEnabled();

    public abstract String logLevelToString(int j);

    public abstract void setLoggingLevel(int j);

    public transient abstract int v(Object obj, Object aobj[]);

    public abstract int v(Throwable throwable);

    public abstract int v(Throwable throwable, Object obj, Object aobj[]);

    public transient abstract int w(Object obj, Object aobj[]);

    public abstract int w(Throwable throwable);

    public transient abstract int w(Throwable throwable, Object obj, Object aobj[]);
}
