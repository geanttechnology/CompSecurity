// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.lucasr.smoothie;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package org.lucasr.smoothie:
//            ItemManager

private static class <init> extends Handler
{

    public void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            return;

        case 1: // '\001'
            ItemManager.access$900((ItemManager)message.obj);
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
