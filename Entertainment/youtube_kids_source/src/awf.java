// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;

public final class awf extends Handler
{

    public awf()
    {
        this(Looper.getMainLooper());
    }

    public awf(Looper looper)
    {
        super(looper);
    }

    public final void a(awo awo1, awn awn1)
    {
        sendMessage(obtainMessage(1, new Pair(awo1, awn1)));
    }

    public final void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            Log.wtf("GoogleApi", "Don't know how to handle this message.");
            return;

        case 1: // '\001'
            Object obj = (Pair)message.obj;
            message = (awo)((Pair) (obj)).first;
            obj = (awn)((Pair) (obj)).second;
            try
            {
                message.a(((awn) (obj)));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Message message)
            {
                a.a(((awn) (obj)));
            }
            throw message;

        case 2: // '\002'
            awe.a((awe)message.obj);
            return;
        }
    }
}
