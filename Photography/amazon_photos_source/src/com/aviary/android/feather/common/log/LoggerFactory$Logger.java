// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.common.log;


// Referenced classes of package com.aviary.android.feather.common.log:
//            LoggerFactory

public static interface 
{

    public abstract void error(String s);

    public transient abstract void error(String s, Object aobj[]);

    public abstract void info(String s);

    public transient abstract void info(String s, Object aobj[]);

    public abstract void log(String s);

    public transient abstract void log(String s, Object aobj[]);

    public transient abstract void verbose(String s, Object aobj[]);

    public abstract void warn(String s);

    public transient abstract void warn(String s, Object aobj[]);
}
