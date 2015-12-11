// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal.core;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package net.tsz.afinal.core:
//            AsyncTask

private static class <init> extends Handler
{

    public void handleMessage(Message message)
    {
        <init> <init>1 = (<init>)message.obj;
        switch (message.what)
        {
        default:
            return;

        case 1: // '\001'
            AsyncTask.access$0(<init>1.mTask, <init>1.mData[0]);
            return;

        case 2: // '\002'
            <init>1.mTask.onProgressUpdate(<init>1.mData);
            break;
        }
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
