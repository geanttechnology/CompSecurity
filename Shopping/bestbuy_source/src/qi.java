// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;

public class qi extends Handler
{

    public qi()
    {
        this(Looper.getMainLooper());
    }

    public qi(Looper looper)
    {
        super(looper);
    }

    public void a()
    {
        removeMessages(2);
    }

    public void a(qu qu1, qt qt1)
    {
        sendMessage(obtainMessage(1, new Pair(qu1, qt1)));
    }

    protected void b(qu qu1, qt qt1)
    {
        try
        {
            qu1.onResult(qt1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (qu qu1)
        {
            qg.a(qt1);
        }
        throw qu1;
    }

    public void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            Log.wtf("GoogleApi", "Don't know how to handle this message.");
            return;

        case 1: // '\001'
            message = (Pair)message.obj;
            b((qu)((Pair) (message)).first, (qt)((Pair) (message)).second);
            return;

        case 2: // '\002'
            qh.a((qh)message.obj);
            break;
        }
    }
}
