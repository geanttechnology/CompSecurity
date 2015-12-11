// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.media.DeniedByServerException;
import android.media.MediaDrm;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class ari extends Handler
{

    private arc a;

    public ari(arc arc1, Looper looper)
    {
        a = arc1;
        super(looper);
    }

    public final void handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 0 1: default 28
    //                   0 29
    //                   1 121;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        arc arc1;
        arc1 = a;
        message = ((Message) (message.obj));
        arc1.h = false;
        if (arc1.i != 2 && arc1.i != 3 && arc1.i != 4)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (message instanceof Exception)
        {
            arc1.b((Exception)message);
            return;
        }
        try
        {
            arc1.b.provideProvisionResponse((byte[])message);
            if (arc1.i == 2)
            {
                arc1.a(false);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Message message)
        {
            arc1.b(message);
            return;
        }
        arc1.f();
        return;
_L3:
        arc arc2 = a;
        message = ((Message) (message.obj));
        if (arc2.i == 3 || arc2.i == 4)
        {
            if (message instanceof Exception)
            {
                arc2.a((Exception)message);
                return;
            }
            try
            {
                arc2.b.provideKeyResponse(arc2.j, (byte[])message);
                arc2.i = 4;
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Message message)
            {
                arc2.a(message);
            }
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }
}
