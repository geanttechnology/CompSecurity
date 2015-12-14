// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.Message;
import com.fotoable.comlib.util.AsyncTask;

public class ff extends Handler
{

    private ff()
    {
    }

    public ff(com.fotoable.comlib.util.AsyncTask._cls1 _pcls1)
    {
        this();
    }

    public void handleMessage(Message message)
    {
        fe fe1 = (fe)message.obj;
        switch (message.what)
        {
        default:
            return;

        case 1: // '\001'
            AsyncTask.access$600(fe1.a, fe1.b[0]);
            return;

        case 2: // '\002'
            fe1.a.onProgressUpdate(fe1.b);
            break;
        }
    }
}
