// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzk;
import com.google.android.gms.ads.internal.overlay.zzg;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.ads.internal.zzp;
import org.json.JSONObject;

// Referenced classes of package android.support.v7:
//            mq, un, ul, tp, 
//            um, mv, mc, ou, 
//            oz, pb, qv, ox, 
//            mu

public class ms
    implements mq
{

    private final ul a;

    public ms(Context context, VersionInfoParcel versioninfoparcel, mc mc)
    {
        a = zzp.zzby().a(context, new AdSizeParcel(), false, false, mc, versioninfoparcel);
        a.setWillNotDraw(true);
    }

    static ul a(ms ms1)
    {
        return ms1.a;
    }

    private void a(Runnable runnable)
    {
        if (zzk.zzcE().zzgI())
        {
            runnable.run();
            return;
        } else
        {
            tp.a.post(runnable);
            return;
        }
    }

    public void a()
    {
        a.destroy();
    }

    public void a(mq.a a1)
    {
        a.i().a(new um.a(a1) {

            final mq.a a;
            final ms b;

            public void zza(ul ul1, boolean flag)
            {
                a.a();
            }

            
            {
                b = ms.this;
                a = a1;
                super();
            }
        });
    }

    public void a(com.google.android.gms.ads.internal.client.zza zza1, zzg zzg, ou ou, zzn zzn, boolean flag, oz oz, pb pb, 
            zze zze1, qv qv)
    {
        a.i().a(zza1, zzg, ou, zzn, flag, oz, pb, new zze(false), qv);
    }

    public void a(String s)
    {
        a(new Runnable(String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", new Object[] {
            s
        })) {

            final String a;
            final ms b;

            public void run()
            {
                ms.a(b).loadData(a, "text/html", "UTF-8");
            }

            
            {
                b = ms.this;
                a = s;
                super();
            }
        });
    }

    public void a(String s, ox ox)
    {
        a.i().a(s, ox);
    }

    public void a(String s, String s1)
    {
        a(new Runnable(s, s1) {

            final String a;
            final String b;
            final ms c;

            public void run()
            {
                ms.a(c).a(a, b);
            }

            
            {
                c = ms.this;
                a = s;
                b = s1;
                super();
            }
        });
    }

    public void a(String s, JSONObject jsonobject)
    {
        a(new Runnable(s, jsonobject) {

            final String a;
            final JSONObject b;
            final ms c;

            public void run()
            {
                ms.a(c).b(a, b);
            }

            
            {
                c = ms.this;
                a = s;
                b = jsonobject;
                super();
            }
        });
    }

    public mu b()
    {
        return new mv(this);
    }

    public void b(String s)
    {
        a(new Runnable(s) {

            final String a;
            final ms b;

            public void run()
            {
                ms.a(b).loadUrl(a);
            }

            
            {
                b = ms.this;
                a = s;
                super();
            }
        });
    }

    public void b(String s, ox ox)
    {
        a.i().b(s, ox);
    }

    public void b(String s, JSONObject jsonobject)
    {
        a.a(s, jsonobject);
    }

    public void c(String s)
    {
        a(new Runnable(s) {

            final String a;
            final ms b;

            public void run()
            {
                ms.a(b).loadData(a, "text/html", "UTF-8");
            }

            
            {
                b = ms.this;
                a = s;
                super();
            }
        });
    }
}
