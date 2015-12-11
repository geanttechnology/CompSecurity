// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.images;

import com.google.android.gms.internal.ds;
import java.util.HashSet;
import java.util.Map;

// Referenced classes of package com.google.android.gms.common.images:
//            ImageManager, a

private final class on
    implements Runnable
{

    final ImageManager ol;
    private final a on;

    public void run()
    {
        ds.N("LoadImageRunnable must be executed on the main thread");
        ImageManager.a(ol, on);
        on on1 = on.op;
        if (on1.on == null)
        {
            on.b(ImageManager.a(ol), true);
            return;
        }
        Object obj = ImageManager.a(ol, on1);
        if (obj != null)
        {
            on.a(ImageManager.a(ol), ((android.graphics.Bitmap) (obj)), true);
            return;
        }
        on.r(ImageManager.a(ol));
        ageReceiver agereceiver = (ageReceiver)ImageManager.b(ol).get(on1.ol);
        obj = agereceiver;
        if (agereceiver == null)
        {
            obj = new ageReceiver(ol, on1.ol);
            ImageManager.b(ol).put(on1.ol, obj);
        }
        ((ageReceiver) (obj)).c(on);
        if (on.os != 1)
        {
            ImageManager.c(ol).put(on, obj);
        }
        synchronized (ImageManager.aZ())
        {
            if (!ImageManager.bA().contains(on1.))
            {
                ImageManager.bA().add(on1.);
                ((ageReceiver) (obj)).bB();
            }
        }
        return;
        exception;
        obj1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public ageReceiver(ImageManager imagemanager, a a1)
    {
        ol = imagemanager;
        super();
        on = a1;
    }
}
