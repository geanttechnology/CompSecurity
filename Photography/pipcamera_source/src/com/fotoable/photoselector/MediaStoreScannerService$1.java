// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photoselector;

import java.lang.ref.WeakReference;
import mz;

// Referenced classes of package com.fotoable.photoselector:
//            MediaStoreScannerService

public class a
    implements Runnable
{

    final MediaStoreScannerService a;

    public void run()
    {
        mz mz1 = (mz)MediaStoreScannerService.a(a).get();
        if (mz1 != null)
        {
            mz1.a_(true);
        }
    }

    (MediaStoreScannerService mediastorescannerservice)
    {
        a = mediastorescannerservice;
        super();
    }
}
