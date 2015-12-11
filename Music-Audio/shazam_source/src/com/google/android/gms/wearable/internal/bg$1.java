// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wearable.internal;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.g;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.PutDataRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;

// Referenced classes of package com.google.android.gms.wearable.internal:
//            aw, bg, ao, x

final class nit> extends aw
{

    final PutDataRequest c;
    final bg d;

    public final g a(Status status)
    {
        return new <init>(status, null);
    }

    protected final void a(com.google.android.gms.common.api._cls1 _pcls1)
    {
        Object obj = (ao)_pcls1;
        _pcls1 = c;
        for (Iterator iterator = _pcls1.a().entrySet().iterator(); iterator.hasNext();)
        {
            Asset asset = (Asset)((java.util.ntry)iterator.next()).getValue();
            if (asset.b == null && asset.c == null && asset.d == null && asset.e == null)
            {
                throw new IllegalArgumentException((new StringBuilder("Put for ")).append(((PutDataRequest) (_pcls1)).b).append(" contains invalid asset: ").append(asset).toString());
            }
        }

        PutDataRequest putdatarequest = PutDataRequest.a(((PutDataRequest) (_pcls1)).b);
        putdatarequest.d = ((PutDataRequest) (_pcls1)).d;
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator1 = _pcls1.a().entrySet().iterator(); iterator1.hasNext();)
        {
            Object obj1 = (java.util.ntry)iterator1.next();
            Asset asset1 = (Asset)((java.util.ntry) (obj1)).getValue();
            if (asset1.b == null)
            {
                putdatarequest.a((String)((java.util.ntry) (obj1)).getKey(), (Asset)((java.util.ntry) (obj1)).getValue());
            } else
            {
                ParcelFileDescriptor aparcelfiledescriptor[];
                try
                {
                    aparcelfiledescriptor = ParcelFileDescriptor.createPipe();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    throw new IllegalStateException((new StringBuilder("Unable to create ParcelFileDescriptor for asset in request: ")).append(_pcls1).toString(), ((Throwable) (obj)));
                }
                if (Log.isLoggable("WearableClient", 3))
                {
                    (new StringBuilder("processAssets: replacing data with FD in asset: ")).append(asset1).append(" read:").append(aparcelfiledescriptor[0]).append(" write:").append(aparcelfiledescriptor[1]);
                }
                putdatarequest.a((String)((java.util.ntry) (obj1)).getKey(), Asset.a(aparcelfiledescriptor[0]));
                obj1 = new FutureTask(new <init>(((ao) (obj)), aparcelfiledescriptor[1], asset1.b));
                arraylist.add(obj1);
                ((ao) (obj)).a.submit(((Runnable) (obj1)));
            }
        }

        ((x)((ao) (obj)).m()).a(new <init>(this, arraylist), putdatarequest);
    }

    (bg bg1, c c1, PutDataRequest putdatarequest)
    {
        d = bg1;
        c = putdatarequest;
        super(c1);
    }
}
