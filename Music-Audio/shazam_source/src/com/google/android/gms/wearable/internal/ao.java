// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wearable.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.l;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Referenced classes of package com.google.android.gms.wearable.internal:
//            y

public final class ao extends l
{

    final ExecutorService a = Executors.newCachedThreadPool();
    final y g = new y();
    private final y h = new y();
    private final y i = new y();
    private final y j = new y();
    private final y k = new y();
    private final y l = new y();
    private final y m = new y();
    private final Map n = new HashMap();

    public ao(Context context, Looper looper, com.google.android.gms.common.api.c.b b1, com.google.android.gms.common.api.c.c c, h h1)
    {
        super(context, looper, 14, h1, b1, c);
    }

    protected final IInterface a(IBinder ibinder)
    {
        return x.a.a(ibinder);
    }

    protected final String a()
    {
        return "com.google.android.gms.wearable.BIND";
    }

    protected final void a(int i1, IBinder ibinder, Bundle bundle, int j1)
    {
        if (i1 != 0) goto _L2; else goto _L1
_L1:
        h.a(ibinder);
        i.a(ibinder);
        g.a(ibinder);
        k.a(ibinder);
        l.a(ibinder);
        m.a(ibinder);
        Map map = n;
        map;
        JVM INSTR monitorenter ;
        for (Iterator iterator = n.values().iterator(); iterator.hasNext(); ((y)iterator.next()).a(ibinder)) { }
        break MISSING_BLOCK_LABEL_110;
        ibinder;
        map;
        JVM INSTR monitorexit ;
        throw ibinder;
        map;
        JVM INSTR monitorexit ;
_L2:
        super.a(i1, ibinder, bundle, j1);
        return;
    }

    protected final String b()
    {
        return "com.google.android.gms.wearable.internal.IWearableService";
    }

    public final void d()
    {
        h.a(this);
        i.a(this);
        g.a(this);
        k.a(this);
        l.a(this);
        m.a(this);
        Map map = n;
        map;
        JVM INSTR monitorenter ;
        for (Iterator iterator = n.values().iterator(); iterator.hasNext(); ((y)iterator.next()).a(this)) { }
        break MISSING_BLOCK_LABEL_100;
        Exception exception;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
        map;
        JVM INSTR monitorexit ;
        super.d();
        return;
    }

    // Unreferenced inner class com/google/android/gms/wearable/internal/ao$1

/* anonymous class */
    final class _cls1
        implements Callable
    {

        final ParcelFileDescriptor a;
        final byte b[];
        final ao c;

        private Boolean a()
        {
            android.os.ParcelFileDescriptor.AutoCloseOutputStream autocloseoutputstream;
            if (Log.isLoggable("WearableClient", 3))
            {
                (new StringBuilder("processAssets: writing data to FD : ")).append(a);
            }
            autocloseoutputstream = new android.os.ParcelFileDescriptor.AutoCloseOutputStream(a);
            Object obj;
            autocloseoutputstream.write(b);
            autocloseoutputstream.flush();
            if (Log.isLoggable("WearableClient", 3))
            {
                (new StringBuilder("processAssets: wrote data: ")).append(a);
            }
            obj = Boolean.valueOf(true);
            IOException ioexception;
            try
            {
                if (Log.isLoggable("WearableClient", 3))
                {
                    (new StringBuilder("processAssets: closing: ")).append(a);
                }
                autocloseoutputstream.close();
            }
            catch (IOException ioexception1)
            {
                return ((Boolean) (obj));
            }
            return ((Boolean) (obj));
            obj;
            (new StringBuilder("processAssets: writing data failed: ")).append(a);
            try
            {
                if (Log.isLoggable("WearableClient", 3))
                {
                    (new StringBuilder("processAssets: closing: ")).append(a);
                }
                autocloseoutputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (IOException ioexception) { }
            return Boolean.valueOf(false);
            obj;
            try
            {
                if (Log.isLoggable("WearableClient", 3))
                {
                    (new StringBuilder("processAssets: closing: ")).append(a);
                }
                autocloseoutputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (IOException ioexception) { }
            throw obj;
        }

        public final Object call()
        {
            return a();
        }

            
            {
                c = ao.this;
                a = parcelfiledescriptor;
                b = abyte0;
                super();
            }
    }

}
