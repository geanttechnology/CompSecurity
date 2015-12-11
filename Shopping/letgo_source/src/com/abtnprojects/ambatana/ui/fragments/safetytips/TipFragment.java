// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.fragments.safetytips;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;

public class TipFragment extends Fragment
    implements TraceFieldInterface
{

    TextView message;
    TextView title;

    public TipFragment()
    {
    }

    public static TipFragment a(int i, int j)
    {
        TipFragment tipfragment = new TipFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("title", i);
        bundle.putInt("msg", j);
        tipfragment.g(bundle);
        return tipfragment;
    }

    private void b(int i)
    {
        if (i > -1)
        {
            message.setText(i);
        }
    }

    private void c(int i)
    {
        if (i > -1)
        {
            title.setText(i);
            title.setVisibility(0);
            return;
        } else
        {
            title.setVisibility(8);
            return;
        }
    }

    public View a(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f04003e, viewgroup, false);
        ButterKnife.bind(this, layoutinflater);
        viewgroup = i();
        if (viewgroup != null)
        {
            c(viewgroup.getInt("title"));
            b(viewgroup.getInt("msg"));
        }
        return layoutinflater;
    }

    public void g()
    {
        super.g();
        ButterKnife.unbind(this);
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
