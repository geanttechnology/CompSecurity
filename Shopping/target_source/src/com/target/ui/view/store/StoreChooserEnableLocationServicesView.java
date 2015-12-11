// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.store;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class StoreChooserEnableLocationServicesView extends LinearLayout
{
    public static interface a
    {

        public abstract void a();

        public abstract void b();
    }

    private static class b
    {

        View enableLocationServicesButton;
        View searchByZipButton;

        public b(View view)
        {
            enableLocationServicesButton = view.findViewById(0x7f10043b);
            searchByZipButton = view.findViewById(0x7f10043c);
        }
    }


    private a mListener;
    private b mViews;

    public StoreChooserEnableLocationServicesView(Context context)
    {
        super(context);
        a();
    }

    public StoreChooserEnableLocationServicesView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    public StoreChooserEnableLocationServicesView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a();
    }

    static a a(StoreChooserEnableLocationServicesView storechooserenablelocationservicesview)
    {
        return storechooserenablelocationservicesview.mListener;
    }

    private void a()
    {
        setOrientation(1);
        inflate(getContext(), 0x7f0301f5, this);
        mViews = new b(this);
        b();
    }

    private void b()
    {
        mViews.enableLocationServicesButton.setOnClickListener(new android.view.View.OnClickListener() {

            final StoreChooserEnableLocationServicesView this$0;

            public void onClick(View view)
            {
                if (StoreChooserEnableLocationServicesView.a(StoreChooserEnableLocationServicesView.this) == null)
                {
                    return;
                } else
                {
                    StoreChooserEnableLocationServicesView.a(StoreChooserEnableLocationServicesView.this).a();
                    return;
                }
            }

            
            {
                this$0 = StoreChooserEnableLocationServicesView.this;
                super();
            }
        });
        mViews.searchByZipButton.setOnClickListener(new android.view.View.OnClickListener() {

            final StoreChooserEnableLocationServicesView this$0;

            public void onClick(View view)
            {
                if (StoreChooserEnableLocationServicesView.a(StoreChooserEnableLocationServicesView.this) == null)
                {
                    return;
                } else
                {
                    StoreChooserEnableLocationServicesView.a(StoreChooserEnableLocationServicesView.this).b();
                    return;
                }
            }

            
            {
                this$0 = StoreChooserEnableLocationServicesView.this;
                super();
            }
        });
    }

    public void setListener(a a1)
    {
        mListener = a1;
    }
}
