// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

final class ckb extends HandlerThread
    implements android.os.Handler.Callback
{

    Handler a;
    private cjx b;

    public ckb(cjx cjx1)
    {
        super("YouTubePlayer.MediaPlayerThread");
        b = cjx1;
    }

    public final void a()
    {
        a.sendEmptyMessage(5);
    }

    public final void b()
    {
        this;
        JVM INSTR monitorenter ;
        a.removeMessages(1);
        if (b != null)
        {
            cjx.a(b);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final boolean handleMessage(Message message)
    {
        boolean flag = false;
        this;
        JVM INSTR monitorenter ;
        int i = message.what;
        i;
        JVM INSTR tableswitch 1 6: default 48
    //                   1 52
    //                   2 84
    //                   3 96
    //                   4 108
    //                   5 124
    //                   6 136;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        message = ((Message) ((Object[])message.obj));
        cjx.a(b, (cjv)message[0], (Uri)message[1]);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L3:
        cjx.b(b);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L4:
        cjx.c(b);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L5:
        cjx.a(b, message.arg1);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L6:
        cjx.a(b);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L7:
        cjx.a(b);
        getLooper().quit();
        a.removeCallbacksAndMessages(null);
        b = null;
        flag = true;
        if (true) goto _L1; else goto _L8
_L8:
        message;
        throw message;
    }

    public final boolean quit()
    {
        if (getLooper() != null)
        {
            a.sendEmptyMessage(6);
            return true;
        } else
        {
            return false;
        }
    }

    public final void start()
    {
        super.start();
        a = new Handler(getLooper(), this);
    }
}
