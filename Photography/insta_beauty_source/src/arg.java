// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.photoselector.MediaStoreScannerService;
import java.lang.ref.WeakReference;

public class arg
    implements Runnable
{

    ari a;
    final MediaStoreScannerService b;

    private arg(MediaStoreScannerService mediastorescannerservice)
    {
        b = mediastorescannerservice;
        super();
        a = new ari(b);
    }

    public arg(MediaStoreScannerService mediastorescannerservice, are are)
    {
        this(mediastorescannerservice);
    }

    public void a()
    {
        a.a();
    }

    public void run()
    {
        arj arj1 = (arj)MediaStoreScannerService.a(b).get();
        if (arj1 == null)
        {
            return;
        }
        if (a.b())
        {
            arj1.a(true);
            return;
        } else
        {
            arj1.a(false);
            return;
        }
    }
}
