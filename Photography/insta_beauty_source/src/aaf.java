// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.Message;
import com.fotoable.comlib.util.UgentAsyncTask;

public class aaf extends Handler
{

    private aaf()
    {
    }

    public aaf(aaa aaa)
    {
        this();
    }

    public void handleMessage(Message message)
    {
        aae aae1 = (aae)message.obj;
        switch (message.what)
        {
        default:
            return;

        case 1: // '\001'
            UgentAsyncTask.c(aae1.a, aae1.b[0]);
            return;

        case 2: // '\002'
            aae1.a.c(aae1.b);
            break;
        }
    }
}
