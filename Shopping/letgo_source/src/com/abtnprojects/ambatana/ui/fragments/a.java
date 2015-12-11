// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.ew;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.abtnprojects.ambatana.ui.widgets.AmbatanaImageView;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;

public class a extends Fragment
    implements TraceFieldInterface
{

    private boolean a;
    private AmbatanaImageView b;
    private String c;
    private ew d;

    public a()
    {
        a = false;
        d = ew.a(0, null);
    }

    public static a a(String s)
    {
        a a1 = new a();
        Bundle bundle = new Bundle();
        bundle.putString("image_url", s);
        a1.g(bundle);
        return a1;
    }

    private void a()
    {
        if (c == null)
        {
            c = i().getString("image_url");
        }
        if (c != null && !c.equals(b.getTag()))
        {
            d.a(c, b, null);
        }
    }

    public View a(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f040037, null, false);
        a = true;
        b = (AmbatanaImageView)layoutinflater.findViewById(0x7f1000f4);
        a();
        return layoutinflater;
    }

    public void a(Bundle bundle)
    {
        super.a(bundle);
        d(false);
    }

    public void f(boolean flag)
    {
        super.f(flag);
        if (flag && p() && a)
        {
            a();
        }
    }

    public void g()
    {
        super.g();
        a = false;
    }

    protected void onStart()
    {
        super.onStart();
        ApplicationStateMonitor.getInstance().activityStarted();
    }

    protected void onStop()
    {
        super.onStop();
        ApplicationStateMonitor.getInstance().activityStopped();
    }
}
