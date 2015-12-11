// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ai;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.moodstocks.android.MoodstocksError;
import com.moodstocks.android.Result;
import com.moodstocks.android.Scanner;
import com.moodstocks.android.core.Loader;

public final class c extends Handler
{
    public static interface a
        extends b
    {
    }

    public static interface b
    {

        public abstract void a(Result result);
    }


    final Scanner a;
    boolean b;
    int c;
    int d;
    boolean e;
    private final b f;
    private boolean g;

    public c(Scanner scanner, b b1)
    {
        b = false;
        g = false;
        c = 0x80000000;
        d = 0;
        e = false;
        a = scanner;
        f = b1;
        if (b1 instanceof a)
        {
            e = true;
        }
    }

    public final void handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 0 1: default 28
    //                   0 59
    //                   1 71;
           goto _L1 _L2 _L3
_L1:
        Log.e("AutoScannerSession", (new StringBuilder("handleMessage: bad message received (")).append(message.what).append(")").toString());
_L5:
        return;
_L2:
        ((MoodstocksError)message.obj).getMessage();
        return;
_L3:
        Object obj = (Pair)message.obj;
        message = (Result)((Pair) (obj)).first;
        obj = ((Pair) (obj)).second;
        if (message != null && b && !g)
        {
            g = true;
            if (!e)
            {
                f.a(message);
                return;
            }
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    static 
    {
        Loader.load();
    }
}
