// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.PutDataRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class awc extends acy
{

    private final ExecutorService a = Executors.newCachedThreadPool();
    private final ave e = new avg();
    private final ave f = new avh();
    private final ave g = new avi();

    public awc(Context context, Looper looper, qo qo, qp qp)
    {
        super(context, looper, qo, qp, new String[0]);
    }

    private FutureTask a(ParcelFileDescriptor parcelfiledescriptor, byte abyte0[])
    {
        return new FutureTask(new Callable(parcelfiledescriptor, abyte0) {

            final ParcelFileDescriptor a;
            final byte b[];
            final awc c;

            public Boolean a()
            {
                android.os.ParcelFileDescriptor.AutoCloseOutputStream autocloseoutputstream;
                if (Log.isLoggable("WearableClient", 3))
                {
                    Log.d("WearableClient", (new StringBuilder()).append("processAssets: writing data to FD : ").append(a).toString());
                }
                autocloseoutputstream = new android.os.ParcelFileDescriptor.AutoCloseOutputStream(a);
                Object obj;
                autocloseoutputstream.write(b);
                autocloseoutputstream.flush();
                if (Log.isLoggable("WearableClient", 3))
                {
                    Log.d("WearableClient", (new StringBuilder()).append("processAssets: wrote data: ").append(a).toString());
                }
                obj = Boolean.valueOf(true);
                IOException ioexception;
                try
                {
                    if (Log.isLoggable("WearableClient", 3))
                    {
                        Log.d("WearableClient", (new StringBuilder()).append("processAssets: closing: ").append(a).toString());
                    }
                    autocloseoutputstream.close();
                }
                catch (IOException ioexception1)
                {
                    return ((Boolean) (obj));
                }
                return ((Boolean) (obj));
                obj;
                Log.w("WearableClient", (new StringBuilder()).append("processAssets: writing data failed: ").append(a).toString());
                try
                {
                    if (Log.isLoggable("WearableClient", 3))
                    {
                        Log.d("WearableClient", (new StringBuilder()).append("processAssets: closing: ").append(a).toString());
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
                        Log.d("WearableClient", (new StringBuilder()).append("processAssets: closing: ").append(a).toString());
                    }
                    autocloseoutputstream.close();
                }
                // Misplaced declaration of an exception variable
                catch (IOException ioexception) { }
                throw obj;
            }

            public Object call()
            {
                return a();
            }

            
            {
                c = awc.this;
                a = parcelfiledescriptor;
                b = abyte0;
                super();
            }
        });
    }

    protected avb a(IBinder ibinder)
    {
        return avc.a(ibinder);
    }

    protected void a(int i, IBinder ibinder, Bundle bundle)
    {
        if (Log.isLoggable("WearableClient", 2))
        {
            Log.d("WearableClient", (new StringBuilder()).append("onPostInitHandler: statusCode ").append(i).toString());
        }
        if (i == 0)
        {
            e.a(ibinder);
            f.a(ibinder);
            g.a(ibinder);
        }
        super.a(i, ibinder, bundle);
    }

    protected void a(adp adp1, adb adb)
    {
        adp1.e(adb, 0x648278, h().getPackageName());
    }

    public void a(qk qk)
    {
        ((avb)j()).d(new avy(qk));
    }

    public void a(qk qk, att att)
    {
        e.a(this, qk, att);
    }

    public void a(qk qk, att att, IntentFilter aintentfilter[])
    {
        e.a(this, qk, att, aintentfilter);
    }

    public void a(qk qk, Asset asset)
    {
        ((avb)j()).a(new avz(qk), asset);
    }

    public void a(qk qk, PutDataRequest putdatarequest)
    {
        for (Iterator iterator = putdatarequest.c().entrySet().iterator(); iterator.hasNext();)
        {
            Asset asset = (Asset)((java.util.Map.Entry)iterator.next()).getValue();
            if (asset.a() == null && asset.b() == null && asset.c() == null && asset.d() == null)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Put for ").append(putdatarequest.a()).append(" contains invalid asset: ").append(asset).toString());
            }
        }

        PutDataRequest putdatarequest1 = PutDataRequest.a(putdatarequest.a());
        putdatarequest1.a(putdatarequest.b());
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator1 = putdatarequest.c().entrySet().iterator(); iterator1.hasNext();)
        {
            Object obj = (java.util.Map.Entry)iterator1.next();
            Asset asset1 = (Asset)((java.util.Map.Entry) (obj)).getValue();
            if (asset1.a() == null)
            {
                putdatarequest1.a((String)((java.util.Map.Entry) (obj)).getKey(), (Asset)((java.util.Map.Entry) (obj)).getValue());
            } else
            {
                ParcelFileDescriptor aparcelfiledescriptor[];
                try
                {
                    aparcelfiledescriptor = ParcelFileDescriptor.createPipe();
                }
                // Misplaced declaration of an exception variable
                catch (qk qk)
                {
                    throw new IllegalStateException((new StringBuilder()).append("Unable to create ParcelFileDescriptor for asset in request: ").append(putdatarequest).toString(), qk);
                }
                if (Log.isLoggable("WearableClient", 3))
                {
                    Log.d("WearableClient", (new StringBuilder()).append("processAssets: replacing data with FD in asset: ").append(asset1).append(" read:").append(aparcelfiledescriptor[0]).append(" write:").append(aparcelfiledescriptor[1]).toString());
                }
                putdatarequest1.a((String)((java.util.Map.Entry) (obj)).getKey(), Asset.a(aparcelfiledescriptor[0]));
                obj = a(aparcelfiledescriptor[1], asset1.a());
                arraylist.add(obj);
                a.submit(((Runnable) (obj)));
            }
        }

        try
        {
            ((avb)j()).a(new awb(qk, arraylist), putdatarequest1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (qk qk)
        {
            throw new IllegalStateException((new StringBuilder()).append("Unable to putDataItem: ").append(putdatarequest).toString(), qk);
        }
    }

    protected IInterface b(IBinder ibinder)
    {
        return a(ibinder);
    }

    public void b()
    {
        e.a(this);
        f.a(this);
        g.a(this);
        super.b();
    }

    protected String d()
    {
        return "com.google.android.gms.wearable.BIND";
    }

    protected String e()
    {
        return "com.google.android.gms.wearable.internal.IWearableService";
    }
}
