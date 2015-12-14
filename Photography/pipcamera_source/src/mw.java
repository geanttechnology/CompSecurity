// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.photoselector.MediaStoreScannerService;
import java.lang.ref.WeakReference;

public class mw
    implements Runnable
{

    my a;
    final MediaStoreScannerService b;

    private mw(MediaStoreScannerService mediastorescannerservice)
    {
        b = mediastorescannerservice;
        super();
        a = new my(b);
    }

    public mw(MediaStoreScannerService mediastorescannerservice, com.fotoable.photoselector.MediaStoreScannerService._cls1 _pcls1)
    {
        this(mediastorescannerservice);
    }

    public void a()
    {
        a.a();
    }

    public void run()
    {
        mz mz1 = (mz)MediaStoreScannerService.a(b).get();
        if (mz1 == null)
        {
            return;
        }
        if (a.b())
        {
            mz1.a_(true);
            return;
        } else
        {
            mz1.a_(false);
            return;
        }
    }
}
