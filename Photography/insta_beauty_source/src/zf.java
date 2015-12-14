// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.Message;
import com.fotoable.comlib.util.AsyncTask;

public class zf extends Handler
{

    private zf()
    {
    }

    public zf(za za)
    {
        this();
    }

    public void handleMessage(Message message)
    {
        ze ze1 = (ze)message.obj;
        switch (message.what)
        {
        default:
            return;

        case 1: // '\001'
            AsyncTask.access$600(ze1.a, ze1.b[0]);
            return;

        case 2: // '\002'
            ze1.a.onProgressUpdate(ze1.b);
            break;
        }
    }
}
