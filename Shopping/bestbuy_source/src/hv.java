// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.bestbuy.android.activities.blueassist.BlueAssistDepartmentSelectionActivity;

public class hv extends ka
{

    private Activity a;
    private String j;
    private String k;
    private String l;
    private Bundle m;
    private int n;

    public hv(Activity activity, String s, String s1, String s2, Bundle bundle)
    {
        n = 0;
        a = activity;
        j = s;
        k = s1;
        l = s2;
        m = bundle;
    }

    static int a(hv hv1)
    {
        int i = hv1.n;
        hv1.n = i + 1;
        return i;
    }

    static int a(hv hv1, int i)
    {
        hv1.n = i;
        return i;
    }

    static Activity b(hv hv1)
    {
        return hv1.a;
    }

    static String c(hv hv1)
    {
        return hv1.j;
    }

    static String d(hv hv1)
    {
        return hv1.k;
    }

    static String e(hv hv1)
    {
        return hv1.l;
    }

    static Bundle f(hv hv1)
    {
        return hv1.m;
    }

    public void a()
    {
        fs.a(j, k, l);
    }

    public void b()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        fq.b(l);
        Toast.makeText(a.getApplicationContext(), "Appointment cancelled", 0).show();
        Intent intent = new Intent(a.getApplicationContext(), com/bestbuy/android/activities/blueassist/BlueAssistDepartmentSelectionActivity);
        m.putBoolean("blueassist_update", false);
        intent.putExtras(m);
        intent.addFlags(0x4000000);
        a.startActivity(intent);
    }

    public void c()
    {
        if (g != null)
        {
            g.setVisibility(8);
        }
        nm.a(a, new no() {

            final hv a;

            public void a()
            {
                hv.a(a);
                new hv(hv.b(a), hv.c(a), hv.d(a), hv.e(a), hv.f(a));
            }

            
            {
                a = hv.this;
                super();
            }
        }, new nn() {

            final hv a;

            public void a()
            {
                hv.a(a, 0);
                hv.b(a).finish();
            }

            
            {
                a = hv.this;
                super();
            }
        }, e, n);
    }
}
