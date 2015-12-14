// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.crashlytics.android.Crashlytics;
import kl;
import km;

// Referenced classes of package com.fotoable.beautyui:
//            BeautyAdjutItemView

public class TBeautyAdjustScrollView extends HorizontalScrollView
{

    private static final String TAG = "TFilterListScrollView";
    private LinearLayout mLayout;
    private km mListener;

    public TBeautyAdjustScrollView(Context context)
    {
        super(context);
        init();
    }

    public TBeautyAdjustScrollView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init();
    }

    private final void init()
    {
        mLayout = new LinearLayout(getContext());
        mLayout.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-2, -1));
        mLayout.setOrientation(0);
        setScrollbarFadingEnabled(true);
        setHorizontalScrollBarEnabled(false);
        intialAdjustItems(true);
        addView(mLayout);
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

    public View addItem(int i, int j, String s, int k, int l, MainToolState maintoolstate)
    {
        BeautyAdjutItemView beautyadjutitemview;
        try
        {
            beautyadjutitemview = new BeautyAdjutItemView(getContext());
            beautyadjutitemview.setResourceID(s, j, getResources().getColor(0x7f0c009d), getResources().getColor(0x7f0c002d));
            beautyadjutitemview.setTag(maintoolstate);
            beautyadjutitemview.setClickable(true);
            beautyadjutitemview.setOnClickListener(new kl(this));
            mLayout.addView(beautyadjutitemview);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Crashlytics.logException(s);
            Log.e("TFilterListScrollView", s.getMessage());
            return null;
        }
        return beautyadjutitemview;
    }

    public void intialAdjustItems(boolean flag)
    {
        if (mLayout.getChildCount() > 0)
        {
            mLayout.removeAllViews();
        }
        addItem(0x7f0200d6, 0x7f0200d6, getResources().getString(0x7f060265), 0x7f0c009d, 0x7f0c009d, MainToolState.Soften);
        addItem(0x7f0200c3, 0x7f0200c2, getResources().getString(0x7f060036), 0x7f0c009d, 0x7f0c009d, MainToolState.QuBan);
        addItem(0x7f0200e6, 0x7f0200e5, getResources().getString(0x7f060267), 0x7f0c009d, 0x7f0c009d, MainToolState.SlimFace);
        addItem(0x7f0200c7, 0x7f0200c6, getResources().getString(0x7f060090), 0x7f0c009d, 0x7f0c009d, MainToolState.BigEye);
        addItem(0x7f0200d4, 0x7f0200d3, getResources().getString(0x7f0600fa), 0x7f0c009d, 0x7f0c009d, MainToolState.EyeBag);
        addItem(0x7f0200d2, 0x7f0200d1, getResources().getString(0x7f0600f3), 0x7f0c009d, 0x7f0c009d, MainToolState.EnhanceNose);
        addItem(0x7f0200df, 0x7f0200de, getResources().getString(0x7f060268), 0x7f0c009d, 0x7f0c009d, MainToolState.SlimNose);
        addItem(0x7f0200c9, 0x7f0200c8, getResources().getString(0x7f060039), 0x7f0c009d, 0x7f0c009d, MainToolState.ClearEye);
    }

    public void setCallback(km km)
    {
        mListener = km;
    }


    private class MainToolState extends Enum
    {

        private static final MainToolState $VALUES[];
        public static final MainToolState BigEye;
        public static final MainToolState ClearEye;
        public static final MainToolState Crop;
        public static final MainToolState EnhanceNose;
        public static final MainToolState EyeBag;
        public static final MainToolState OneKey;
        public static final MainToolState QuBan;
        public static final MainToolState SlimFace;
        public static final MainToolState SlimNose;
        public static final MainToolState Soften;

        public static MainToolState valueOf(String s)
        {
            return (MainToolState)Enum.valueOf(com/fotoable/beautyui/TBeautyAdjustScrollView$MainToolState, s);
        }

        public static MainToolState[] values()
        {
            return (MainToolState[])$VALUES.clone();
        }

        static 
        {
            OneKey = new MainToolState("OneKey", 0);
            Soften = new MainToolState("Soften", 1);
            QuBan = new MainToolState("QuBan", 2);
            SlimFace = new MainToolState("SlimFace", 3);
            BigEye = new MainToolState("BigEye", 4);
            EyeBag = new MainToolState("EyeBag", 5);
            EnhanceNose = new MainToolState("EnhanceNose", 6);
            SlimNose = new MainToolState("SlimNose", 7);
            ClearEye = new MainToolState("ClearEye", 8);
            Crop = new MainToolState("Crop", 9);
            $VALUES = (new MainToolState[] {
                OneKey, Soften, QuBan, SlimFace, BigEye, EyeBag, EnhanceNose, SlimNose, ClearEye, Crop
            });
        }

        private MainToolState(String s, int i)
        {
            super(s, i);
        }
    }

}
