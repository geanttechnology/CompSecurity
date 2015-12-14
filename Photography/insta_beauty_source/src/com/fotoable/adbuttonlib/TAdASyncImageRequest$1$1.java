// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.adbuttonlib;


class val.result
    implements Runnable
{

    final val.result this$1;
    final byte val$result[];

    public void run()
    {
        callback.downLoaded(url, val$result);
    }

    loadCallback()
    {
        this$1 = final_loadcallback;
        val$result = _5B_B.this;
        super();
    }
}
