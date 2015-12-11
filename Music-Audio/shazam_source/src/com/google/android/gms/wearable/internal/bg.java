// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.g;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.c;
import com.google.android.gms.wearable.f;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;

// Referenced classes of package com.google.android.gms.wearable.internal:
//            aw, ao, ap, y, 
//            x, AddListenerRequest

public final class bg
    implements c
{
    private static final class a extends aw
    {

        private com.google.android.gms.wearable.c.b c;
        private IntentFilter d[];

        public final g a(Status status)
        {
            c = null;
            d = null;
            return status;
        }

        protected final void a(com.google.android.gms.common.api.a.b b1)
        {
            y y1;
            ao ao1;
            ap ap1;
            ao1 = (ao)b1;
            b1 = c;
            IntentFilter aintentfilter[] = d;
            y1 = ao1.g;
            ap1 = ap.a(b1, aintentfilter);
            Map map = y1.a;
            map;
            JVM INSTR monitorenter ;
            if (y1.a.get(b1) == null) goto _L2; else goto _L1
_L1:
            a(new Status(4001));
_L4:
            c = null;
            d = null;
            return;
_L2:
            y1.a.put(b1, ap1);
            ((x)ao1.m()).a(new y.a(y1.a, b1, this), new AddListenerRequest(ap1));
            map;
            JVM INSTR monitorexit ;
            if (true) goto _L4; else goto _L3
_L3:
            b1;
            map;
            JVM INSTR monitorexit ;
            throw b1;
            RemoteException remoteexception;
            remoteexception;
            y1.a.remove(b1);
            throw remoteexception;
        }

        private a(com.google.android.gms.common.api.c c1, com.google.android.gms.wearable.c.b b1)
        {
            super(c1);
            c = b1;
            d = null;
        }

        a(com.google.android.gms.common.api.c c1, com.google.android.gms.wearable.c.b b1, byte byte0)
        {
            this(c1, b1);
        }
    }

    public static final class b
        implements com.google.android.gms.wearable.c.a
    {

        private final Status a;
        private final f b;

        public final Status a()
        {
            return a;
        }

        public b(Status status, f f)
        {
            a = status;
            b = f;
        }
    }


    public bg()
    {
    }

    public final e a(com.google.android.gms.common.api.c c1, PutDataRequest putdatarequest)
    {
        return c1.a(new aw(c1, putdatarequest) {

            final PutDataRequest c;
            final bg d;

            public final g a(Status status)
            {
                return new b(status, null);
            }

            protected final void a(com.google.android.gms.common.api.a.b b1)
            {
                Object obj = (ao)b1;
                b1 = c;
                for (Iterator iterator = b1.a().entrySet().iterator(); iterator.hasNext();)
                {
                    Asset asset = (Asset)((java.util.Map.Entry)iterator.next()).getValue();
                    if (asset.b == null && asset.c == null && asset.d == null && asset.e == null)
                    {
                        throw new IllegalArgumentException((new StringBuilder("Put for ")).append(((PutDataRequest) (b1)).b).append(" contains invalid asset: ").append(asset).toString());
                    }
                }

                PutDataRequest putdatarequest1 = PutDataRequest.a(((PutDataRequest) (b1)).b);
                putdatarequest1.d = ((PutDataRequest) (b1)).d;
                ArrayList arraylist = new ArrayList();
                for (Iterator iterator1 = b1.a().entrySet().iterator(); iterator1.hasNext();)
                {
                    Object obj1 = (java.util.Map.Entry)iterator1.next();
                    Asset asset1 = (Asset)((java.util.Map.Entry) (obj1)).getValue();
                    if (asset1.b == null)
                    {
                        putdatarequest1.a((String)((java.util.Map.Entry) (obj1)).getKey(), (Asset)((java.util.Map.Entry) (obj1)).getValue());
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
                            throw new IllegalStateException((new StringBuilder("Unable to create ParcelFileDescriptor for asset in request: ")).append(b1).toString(), ((Throwable) (obj)));
                        }
                        if (Log.isLoggable("WearableClient", 3))
                        {
                            (new StringBuilder("processAssets: replacing data with FD in asset: ")).append(asset1).append(" read:").append(aparcelfiledescriptor[0]).append(" write:").append(aparcelfiledescriptor[1]);
                        }
                        putdatarequest1.a((String)((java.util.Map.Entry) (obj1)).getKey(), Asset.a(aparcelfiledescriptor[0]));
                        obj1 = new FutureTask(new ao._cls1(((ao) (obj)), aparcelfiledescriptor[1], asset1.b));
                        arraylist.add(obj1);
                        ((ao) (obj)).a.submit(((Runnable) (obj1)));
                    }
                }

                ((x)((ao) (obj)).m()).a(new an.d(this, arraylist), putdatarequest1);
            }

            
            {
                d = bg.this;
                c = putdatarequest;
                super(c1);
            }
        });
    }

    public final e a(com.google.android.gms.common.api.c c1, com.google.android.gms.wearable.c.b b1)
    {
        return c1.a(new a(c1, b1, (byte)0));
    }
}
