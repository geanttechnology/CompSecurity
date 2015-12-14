// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.photoselector.MediaStoreScannerService;
import java.lang.ref.WeakReference;

public class are
    implements Runnable
{

    final MediaStoreScannerService a;

    public are(MediaStoreScannerService mediastorescannerservice)
    {
        a = mediastorescannerservice;
        super();
    }

    public void run()
    {
        arj arj1 = (arj)MediaStoreScannerService.a(a).get();
        if (arj1 != null)
        {
            arj1.a(true);
        }
    }
}
