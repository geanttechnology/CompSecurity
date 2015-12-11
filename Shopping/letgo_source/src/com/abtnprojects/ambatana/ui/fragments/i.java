// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.fragments;

import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.aqo;
import android.support.v7.fi;
import android.support.v7.iv;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.abtnprojects.ambatana.models.LatitudeLongitude;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;

// Referenced classes of package com.abtnprojects.ambatana.ui.fragments:
//            h

public class i extends h
{

    private static final String al = com/abtnprojects/ambatana/ui/fragments/i.getSimpleName();
    private fi am;
    private com.abtnprojects.ambatana.ui.activities.profile.UserProfileActivity.b an;
    private String ao;

    public i()
    {
    }

    private Bundle Y()
    {
        Bundle bundle = i();
        an = (com.abtnprojects.ambatana.ui.activities.profile.UserProfileActivity.b)bundle.getSerializable("tab_number");
        if (an == null)
        {
            an = com.abtnprojects.ambatana.ui.activities.profile.UserProfileActivity.b.a;
        }
        return bundle;
    }

    public static i a(com.abtnprojects.ambatana.ui.activities.profile.UserProfileActivity.b b, String s)
    {
        i j = new i();
        Bundle bundle = new Bundle();
        bundle.putSerializable("tab_number", b);
        bundle.putString("user_object_id", s);
        j.g(bundle);
        return j;
    }

    protected CharSequence Q()
    {
        return k().getString(0x7f09009c);
    }

    protected void U()
    {
        if (an == com.abtnprojects.ambatana.ui.activities.profile.UserProfileActivity.b.c)
        {
            return;
        } else
        {
            super.U();
            return;
        }
    }

    public void X()
    {
        aqo.a((new StringBuilder()).append("reset and reload all data ").append(an).append(" is resumed ").append(p()).toString(), new Object[0]);
        R();
        a(c, g);
    }

    public View a(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = super.a(layoutinflater, viewgroup, bundle);
        ao = Y().getString("user_object_id");
        aqo.a((new StringBuilder()).append("onCreateView ").append(an).toString(), new Object[0]);
        return layoutinflater;
    }

    void a(int j, LatitudeLongitude latitudelongitude)
    {
        Void avoid[];
label0:
        {
            aqo.a((new StringBuilder()).append("startNewTask ").append(an).toString(), new Object[0]);
            android.support.v4.app.g g = j();
            if (g != null)
            {
                a(((AsyncTask) (am)));
                V();
                if (h == null)
                {
                    h = iv.a(j());
                }
                am = new fi(this, j, d, b, g, this, an, ao, latitudelongitude, h);
                latitudelongitude = am;
                avoid = new Void[0];
                if (latitudelongitude instanceof AsyncTask)
                {
                    break label0;
                }
                latitudelongitude.execute(avoid);
            }
            return;
        }
        AsyncTaskInstrumentation.execute((AsyncTask)latitudelongitude, avoid);
    }

    public void f(boolean flag)
    {
        super.f(flag);
        aqo.a((new StringBuilder()).append("setUserVisibleHint ").append(an).append(" resumed ").append(p()).toString(), new Object[0]);
    }

    public void u()
    {
        super.u();
        if (an == null)
        {
            Y();
        }
        int j;
        if (an == null)
        {
            j = 0;
        } else
        {
            j = an.ordinal();
        }
        aj.postDelayed(new Runnable() {

            final i a;

            public void run()
            {
                a.X();
            }

            
            {
                a = i.this;
                super();
            }
        }, j * 10 + 10);
        aqo.a((new StringBuilder()).append("onResume ").append(an).toString(), new Object[0]);
    }

}
