// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.navigation;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.target.mothership.model.store.interfaces.RelevantStoreSummary;
import com.target.ui.util.ae;
import com.target.ui.util.al;
import com.target.ui.view.a;

public class NavigationStoreView extends FrameLayout
{
    static class Views extends a
    {

        TextView storeDescription;
        TextView storeLocation;

        Views(View view)
        {
            super(view);
        }
    }


    private Views mViews;

    public NavigationStoreView(Context context)
    {
        super(context);
        a();
    }

    public NavigationStoreView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    public NavigationStoreView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a();
    }

    private void a()
    {
        inflate(getContext(), 0x7f030174, this);
        mViews = new Views(this);
    }

    private void b()
    {
        mViews.storeDescription.setVisibility(8);
        mViews.storeLocation.setText(getResources().getText(0x7f090524));
    }

    public void setStore(RelevantStoreSummary relevantstoresummary)
    {
        if (relevantstoresummary == null)
        {
            b();
            return;
        }
        al.b(new View[] {
            mViews.storeDescription, mViews.storeLocation
        });
        setVisibility(0);
        String s;
        if (relevantstoresummary.a())
        {
            s = getResources().getString(0x7f09037d);
        } else
        {
            s = getResources().getString(0x7f09037c);
        }
        relevantstoresummary = ae.a(relevantstoresummary);
        mViews.storeDescription.setText(s);
        mViews.storeLocation.setText(relevantstoresummary);
    }
}
