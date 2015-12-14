// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Binder;
import com.fotoable.photoselector.MediaStoreScannerService;

public class arf extends Binder
{

    final MediaStoreScannerService a;

    public arf(MediaStoreScannerService mediastorescannerservice)
    {
        a = mediastorescannerservice;
        super();
    }

    public MediaStoreScannerService a()
    {
        return a;
    }
}
