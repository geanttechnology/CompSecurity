// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui.newui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.crashlytics.android.Crashlytics;
import com.fotoable.beautyui.BeautyAdjutItemView;
import uz;
import va;

public class MNewProEditScrollView extends HorizontalScrollView
{

    private static final String TAG = "TSFilterListScrollView";
    private LinearLayout sLayout;
    private va sListener;

    public MNewProEditScrollView(Context context)
    {
        super(context);
        init();
    }

    public MNewProEditScrollView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init();
    }

    private final void init()
    {
        sLayout = new LinearLayout(getContext());
        sLayout.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-2, -1));
        sLayout.setOrientation(0);
        setScrollbarFadingEnabled(true);
        setHorizontalScrollBarEnabled(false);
        intialAdjustItems(true);
        addView(sLayout);
        setSmoothScrollingEnabled(true);
    }

    private void setStartScroll(View view)
    {
        int i = getWidth();
        int j = view.getLeft();
        int k = view.getWidth();
        int l = getScrollX();
        if (j - l > i - k * 2 && j - l < i + k)
        {
            smoothScrollTo((j - i) + k * 2, view.getTop());
        }
        if (j - l < k && j - l >= -view.getWidth())
        {
            smoothScrollTo(j - k, view.getTop());
        }
    }

    public View addItem(int i, int j, String s, int k, int l, SecondToolState secondtoolstate)
    {
        BeautyAdjutItemView beautyadjutitemview;
        try
        {
            beautyadjutitemview = new BeautyAdjutItemView(getContext());
            beautyadjutitemview.setResourceID(s, j, getResources().getColor(0x7f0c009d), getResources().getColor(0x7f0c002d));
            beautyadjutitemview.setTag(secondtoolstate);
            beautyadjutitemview.setClickable(true);
            beautyadjutitemview.setOnClickListener(new uz(this));
            sLayout.addView(beautyadjutitemview);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Crashlytics.logException(s);
            Log.e("TSFilterListScrollView", s.getMessage());
            return null;
        }
        return beautyadjutitemview;
    }

    public void intialAdjustItems(boolean flag)
    {
        if (sLayout.getChildCount() > 0)
        {
            sLayout.removeAllViews();
        }
        addItem(0x7f0202e9, 0x7f0202e9, getResources().getString(0x7f0602aa), 0x7f0c009d, 0x7f0c009d, SecondToolState.Tickers);
        addItem(0x7f020394, 0x7f020394, getResources().getString(0x7f06017f), 0x7f0c009d, 0x7f0c009d, SecondToolState.Mosaic);
        addItem(0x7f020307, 0x7f020307, getResources().getString(0x7f06029d), 0x7f0c009d, 0x7f0c009d, SecondToolState.Text);
        addItem(0x7f020455, 0x7f020455, getResources().getString(0x7f0600ee), 0x7f0c009d, 0x7f0c009d, SecondToolState.Editor);
        addItem(0x7f02003f, 0x7f02003f, getResources().getString(0x7f060069), 0x7f0c009d, 0x7f0c009d, SecondToolState.Adjust);
        addItem(0x7f020469, 0x7f020469, getResources().getString(0x7f060158), 0x7f0c009d, 0x7f0c009d, SecondToolState.Legs);
        addItem(0x7f0202ea, 0x7f0202ea, getResources().getString(0x7f060266), 0x7f0c009d, 0x7f0c009d, SecondToolState.Slim);
    }

    public void setCallback(va va)
    {
        sListener = va;
    }


    private class SecondToolState extends Enum
    {

        private static final SecondToolState $VALUES[];
        public static final SecondToolState Adjust;
        public static final SecondToolState Editor;
        public static final SecondToolState Legs;
        public static final SecondToolState Mosaic;
        public static final SecondToolState Slim;
        public static final SecondToolState Text;
        public static final SecondToolState Tickers;

        public static SecondToolState valueOf(String s)
        {
            return (SecondToolState)Enum.valueOf(com/fotoable/beautyui/newui/MNewProEditScrollView$SecondToolState, s);
        }

        public static SecondToolState[] values()
        {
            return (SecondToolState[])$VALUES.clone();
        }

        static 
        {
            Text = new SecondToolState("Text", 0);
            Editor = new SecondToolState("Editor", 1);
            Tickers = new SecondToolState("Tickers", 2);
            Mosaic = new SecondToolState("Mosaic", 3);
            Adjust = new SecondToolState("Adjust", 4);
            Legs = new SecondToolState("Legs", 5);
            Slim = new SecondToolState("Slim", 6);
            $VALUES = (new SecondToolState[] {
                Text, Editor, Tickers, Mosaic, Adjust, Legs, Slim
            });
        }

        private SecondToolState(String s, int i)
        {
            super(s, i);
        }
    }

}
