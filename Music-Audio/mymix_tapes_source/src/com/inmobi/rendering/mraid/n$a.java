// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.rendering.mraid;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.rendering.RenderView;
import java.lang.ref.WeakReference;

// Referenced classes of package com.inmobi.rendering.mraid:
//            n

static final class it> extends Handler
{

    private static final String a = com/inmobi/rendering/mraid/n$a.getSimpleName();
    private WeakReference b;

    public void handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 1 1: default 24
    //                   1 36;
           goto _L1 _L2
_L1:
        Logger.a(com.inmobi.commons.core.utilities.er.InternalLogLevel.INTERNAL, a, "Unknown message type. Ignoring ...");
_L4:
        return;
_L2:
        message = (String)message.obj;
        RenderView renderview = (RenderView)b.get();
        if (renderview != null)
        {
            renderview.a(message, "broadcastEvent('vibrateComplete');");
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }


    public (Looper looper, RenderView renderview)
    {
        super(looper);
        b = new WeakReference(renderview);
    }
}
