// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.store;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class StoreChooserNoLocationServicesView extends RelativeLayout
{
    public static interface a
    {

        public abstract void a();

        public abstract void b();
    }

    private static class b
    {

        View enterZipButton;
        LinearLayout placeholderContainer;
        View useLocationButton;

        public b(View view)
        {
            placeholderContainer = (LinearLayout)view.findViewById(0x7f1005b7);
            useLocationButton = view.findViewById(0x7f1005b9);
            enterZipButton = view.findViewById(0x7f1005ba);
        }
    }


    private a mListener;
    private b mViews;

    public StoreChooserNoLocationServicesView(Context context)
    {
        super(context);
        a();
    }

    public StoreChooserNoLocationServicesView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    public StoreChooserNoLocationServicesView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a();
    }

    static a a(StoreChooserNoLocationServicesView storechoosernolocationservicesview)
    {
        return storechoosernolocationservicesview.mListener;
    }

    private void a()
    {
        inflate(getContext(), 0x7f0301f6, this);
        mViews = new b(this);
        b();
    }

    private void b()
    {
        mViews.useLocationButton.setOnClickListener(new android.view.View.OnClickListener() {

            final StoreChooserNoLocationServicesView this$0;

            public void onClick(View view)
            {
                if (StoreChooserNoLocationServicesView.a(StoreChooserNoLocationServicesView.this) == null)
                {
                    return;
                } else
                {
                    StoreChooserNoLocationServicesView.a(StoreChooserNoLocationServicesView.this).a();
                    return;
                }
            }

            
            {
                this$0 = StoreChooserNoLocationServicesView.this;
                super();
            }
        });
        mViews.enterZipButton.setOnClickListener(new android.view.View.OnClickListener() {

            final StoreChooserNoLocationServicesView this$0;

            public void onClick(View view)
            {
                if (StoreChooserNoLocationServicesView.a(StoreChooserNoLocationServicesView.this) == null)
                {
                    return;
                } else
                {
                    StoreChooserNoLocationServicesView.a(StoreChooserNoLocationServicesView.this).b();
                    return;
                }
            }

            
            {
                this$0 = StoreChooserNoLocationServicesView.this;
                super();
            }
        });
    }

    public void setListener(a a1)
    {
        mListener = a1;
    }

    public void setPlaceholderView(com.target.ui.fragment.store.StoreChooserDialogFragment.d d)
    {
        static class _cls3
        {

            static final int $SwitchMap$com$target$ui$fragment$store$StoreChooserDialogFragment$StoreChooserType[];

            static 
            {
                $SwitchMap$com$target$ui$fragment$store$StoreChooserDialogFragment$StoreChooserType = new int[com.target.ui.fragment.store.StoreChooserDialogFragment.d.values().length];
                try
                {
                    $SwitchMap$com$target$ui$fragment$store$StoreChooserDialogFragment$StoreChooserType[com.target.ui.fragment.store.StoreChooserDialogFragment.d.NEARBY_STORES.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$ui$fragment$store$StoreChooserDialogFragment$StoreChooserType[com.target.ui.fragment.store.StoreChooserDialogFragment.d.FIATS.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$ui$fragment$store$StoreChooserDialogFragment$StoreChooserType[com.target.ui.fragment.store.StoreChooserDialogFragment.d.WEEKLY_AD.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls3..SwitchMap.com.target.ui.fragment.store.StoreChooserDialogFragment.StoreChooserType[d.ordinal()];
        JVM INSTR tableswitch 1 2: default 32
    //                   1 66
    //                   2 72;
           goto _L1 _L2 _L3
_L1:
        int i = 0x7f0301ff;
_L5:
        mViews.placeholderContainer.removeAllViews();
        LayoutInflater.from(getContext()).inflate(i, mViews.placeholderContainer, true);
        return;
_L2:
        i = 0x7f0301fe;
        continue; /* Loop/switch isn't completed */
_L3:
        i = 0x7f030162;
        if (true) goto _L5; else goto _L4
_L4:
    }
}
