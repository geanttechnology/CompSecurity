// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.Message;
import com.example.android.bitmapfun.util.AsyncTask;

public class dz extends Handler
{

    private dz()
    {
    }

    public dz(com.example.android.bitmapfun.util.AsyncTask._cls1 _pcls1)
    {
        this();
    }

    public void handleMessage(Message message)
    {
        dy dy1 = (dy)message.obj;
        switch (message.what)
        {
        default:
            return;

        case 1: // '\001'
            AsyncTask.c(dy1.a, dy1.b[0]);
            return;

        case 2: // '\002'
            dy1.a.b(dy1.b);
            break;
        }
    }
}
