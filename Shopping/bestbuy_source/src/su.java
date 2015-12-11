// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.internal.ay;
import com.google.android.gms.internal.gs;
import com.google.android.gms.internal.gu;
import org.json.JSONObject;

public class su
    implements sr
{

    private final gu a;

    public su(Context context, gs gs)
    {
        a = gu.a(context, new ay(), false, false, null, gs);
    }

    static gu a(su su1)
    {
        return su1.a;
    }

    private void a(Runnable runnable)
    {
        if (aca.b())
        {
            runnable.run();
            return;
        } else
        {
            aca.a.post(runnable);
            return;
        }
    }

    public void a()
    {
        abq.a(a);
    }

    public void a(ahh ahh, xh xh, vb vb, xj xj, boolean flag, ve ve)
    {
        a.f().a(ahh, xh, vb, xj, flag, ve, new ahl(false));
    }

    public void a(String s)
    {
        a(new Runnable(s) {

            final String a;
            final su b;

            public void run()
            {
                su.a(b).loadUrl(a);
            }

            
            {
                b = su.this;
                a = s;
                super();
            }
        });
    }

    public void a(String s, JSONObject jsonobject)
    {
        a(new Runnable(s, jsonobject) {

            final String a;
            final JSONObject b;
            final su c;

            public void run()
            {
                su.a(c).a(a, b);
            }

            
            {
                c = su.this;
                a = s;
                b = jsonobject;
                super();
            }
        });
    }

    public void a(String s, vd vd)
    {
        a.f().a(s, vd);
    }

    public void a(ss ss)
    {
        a.f().a(new acf(ss) {

            final ss a;
            final su b;

            public void a(gu gu1)
            {
                a.a();
            }

            
            {
                b = su.this;
                a = ss1;
                super();
            }
        });
    }

    public void b()
    {
        abq.b(a);
    }

    public void b(String s)
    {
        a.f().a(s, null);
    }

    public void c()
    {
        a.destroy();
    }
}
