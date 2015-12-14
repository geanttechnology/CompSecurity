// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.Message;
import com.fotoable.comlib.util.UgentAsyncTask;

public class fy extends Handler
{

    private fy()
    {
    }

    public fy(com.fotoable.comlib.util.UgentAsyncTask._cls1 _pcls1)
    {
        this();
    }

    public void handleMessage(Message message)
    {
        fx fx1 = (fx)message.obj;
        switch (message.what)
        {
        default:
            return;

        case 1: // '\001'
            UgentAsyncTask.c(fx1.a, fx1.b[0]);
            return;

        case 2: // '\002'
            fx1.a.c(fx1.b);
            break;
        }
    }
}
