// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;

// Referenced classes of package android.support.v7:
//            tl, sv, sy, ss, 
//            qa, vn, sx, ll

public class st extends tl
    implements sv, sy
{

    private final te.a a;
    private final Context b;
    private final ss c;
    private final sy d;
    private final Object e = new Object();
    private final String f;
    private final String g;
    private final String h;
    private int i;
    private int j;

    public st(Context context, String s, String s1, String s2, te.a a1, ss ss1, sy sy1)
    {
        i = 0;
        j = 3;
        b = context;
        f = s;
        h = s1;
        g = s2;
        a = a1;
        c = ss1;
        d = sy1;
    }

    static String a(st st1)
    {
        return st1.g;
    }

    static String b(st st1)
    {
        return st1.f;
    }

    private void b(long l)
    {
_L1:
label0:
        {
            synchronized (e)
            {
                if (i == 0)
                {
                    break label0;
                }
            }
            return;
        }
        if (a(l))
        {
            break MISSING_BLOCK_LABEL_35;
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        obj;
        JVM INSTR monitorexit ;
          goto _L1
    }

    static Context c(st st1)
    {
        return st1.b;
    }

    static String d(st st1)
    {
        return st1.h;
    }

    public void a()
    {
        c.b();
        AdRequestParcel adrequestparcel = a.a.zzDy;
        qa qa1 = c.a();
        try
        {
            qa1.a(adrequestparcel, g);
            return;
        }
        catch (RemoteException remoteexception)
        {
            zzb.zzd("Fail to load ad from adapter.", remoteexception);
        }
        a(f, 0);
    }

    public void a(int k)
    {
        a(f, 0);
    }

    public void a(String s)
    {
        synchronized (e)
        {
            i = 1;
            e.notify();
        }
        return;
        exception;
        s;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void a(String s, int k)
    {
        synchronized (e)
        {
            i = 2;
            j = k;
            e.notify();
        }
        return;
        exception;
        s;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected boolean a(long l)
    {
        l = 20000L - (zzp.zzbB().b() - l);
        if (l <= 0L)
        {
            return false;
        }
        try
        {
            e.wait(l);
        }
        catch (InterruptedException interruptedexception)
        {
            return false;
        }
        return true;
    }

    public void onStop()
    {
    }

    public void zzdG()
    {
        sx sx1;
        AdRequestParcel adrequestparcel;
        qa qa1;
        if (c == null || c.b() == null || c.a() == null)
        {
            return;
        }
        sx1 = c.b();
        sx1.a(this);
        sx1.a(this);
        adrequestparcel = a.a.zzDy;
        qa1 = c.a();
        if (!qa1.g())
        {
            break MISSING_BLOCK_LABEL_135;
        }
        zza.zzIy.post(new Runnable(qa1, adrequestparcel) {

            final qa a;
            final AdRequestParcel b;
            final st c;

            public void run()
            {
                try
                {
                    a.a(b, st.a(c));
                    return;
                }
                catch (RemoteException remoteexception1)
                {
                    zzb.zzd("Fail to load ad from adapter.", remoteexception1);
                }
                c.a(st.b(c), 0);
            }

            
            {
                c = st.this;
                a = qa1;
                b = adrequestparcel;
                super();
            }
        });
_L1:
        b(zzp.zzbB().b());
        sx1.a(null);
        sx1.a(null);
        RemoteException remoteexception;
        if (i == 1)
        {
            d.a(f);
            return;
        } else
        {
            d.a(f, j);
            return;
        }
        try
        {
            zza.zzIy.post(new Runnable(qa1, adrequestparcel, sx1) {

                final qa a;
                final AdRequestParcel b;
                final sx c;
                final st d;

                public void run()
                {
                    try
                    {
                        a.a(ll.a(st.c(d)), b, st.d(d), c, st.a(d));
                        return;
                    }
                    catch (RemoteException remoteexception1)
                    {
                        zzb.zzd((new StringBuilder()).append("Fail to initialize adapter ").append(st.b(d)).toString(), remoteexception1);
                    }
                    d.a(st.b(d), 0);
                }

            
            {
                d = st.this;
                a = qa1;
                b = adrequestparcel;
                c = sx1;
                super();
            }
            });
        }
        // Misplaced declaration of an exception variable
        catch (RemoteException remoteexception)
        {
            zzb.zzd("Fail to check if adapter is initialized.", remoteexception);
            a(f, 0);
        }
          goto _L1
    }
}
