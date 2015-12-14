// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer;

import com.cyberlink.youcammakeup.utility.bw;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer:
//            k, h, ImageLoader

class j
    implements bw
{

    final ImageLoader a;

    j(ImageLoader imageloader)
    {
        a = imageloader;
        super();
    }

    public void a(Future future)
    {
        try
        {
            k k1 = (k)future.get();
            if (!future.isCancelled())
            {
                k1.a.a();
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Future future)
        {
            future.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Future future)
        {
            future.printStackTrace();
        }
    }
}
