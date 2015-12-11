// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.log;


// Referenced classes of package com.amazon.retailsearch.log:
//            MessageLogger

public interface MessageRecorder
{

    public abstract void log(MessageLogger messagelogger, int i, String s, Throwable throwable);
}
