// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.adbuttonlib;


class val.e1
    implements Runnable
{

    final val.e1 this$1;
    final Exception val$e1;

    public void run()
    {
        callback.downLoadedError(val$e1);
    }

    loadCallback()
    {
        this$1 = final_loadcallback;
        val$e1 = Exception.this;
        super();
    }
}
