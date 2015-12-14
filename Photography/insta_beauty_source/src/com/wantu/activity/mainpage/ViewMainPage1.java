// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.activity.mainpage;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import axw;
import biv;
import biw;
import bix;
import biy;
import biz;
import bja;
import bjb;
import com.fotoable.adbuttonlib.TAdButton;
import com.fotoable.adbuttonlib.TAdButtonGroup;
import com.fotoable.adbuttonlib.TAdItem;
import com.instabeauty.application.InstaBeautyApplication;

// Referenced classes of package com.wantu.activity.mainpage:
//            MainFontFitTextView

public class ViewMainPage1 extends FrameLayout
    implements com.fotoable.adbuttonlib.TAdButton.TAdButtonLisener
{

    public biv clickerListener;
    View item_ad1container;
    TAdButton item_adC00;
    TAdButton item_adC01;
    View item_adContainer;
    View item_continusCapture;
    View item_instamag;
    View item_material;
    MainFontFitTextView item_name00;
    MainFontFitTextView item_name01;
    View item_newcamera;
    View item_pip;
    View item_proedit;
    View item_video;
    View item_video_new;
    View layout_next_page;
    Context mContext;
    Button newInstaMageMaterialAlert_btn;
    Button newMaterialAlert_btn;
    int srcWidthDp;

    public ViewMainPage1(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        srcWidthDp = 320;
        mContext = context;
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f030111, this, true);
        initView();
    }

    public void initView()
    {
        item_instamag = findViewById(0x7f0d03f8);
        item_instamag.setOnClickListener(new biw(this));
        item_name00 = (MainFontFitTextView)findViewById(0x7f0d0400);
        item_adC00 = (TAdButton)findViewById(0x7f0d03ff);
        item_adC00.setAdButtonLisener(0, this);
        TAdButtonGroup.instance(InstaBeautyApplication.a()).registerAdButton(item_adC00, 0);
        item_name01 = (MainFontFitTextView)findViewById(0x7f0d03fe);
        item_adC01 = (TAdButton)findViewById(0x7f0d03fd);
        item_adC01.setAdButtonLisener(1, this);
        TAdButtonGroup.instance(InstaBeautyApplication.a()).registerAdButton(item_adC01, 1);
        item_proedit = findViewById(0x7f0d03f7);
        item_proedit.setOnClickListener(new bix(this));
        item_video = findViewById(0x7f0d0401);
        item_video.setOnClickListener(new biy(this));
        item_pip = findViewById(0x7f0d03f9);
        item_pip.setOnClickListener(new biz(this));
        item_continusCapture = findViewById(0x7f0d03fa);
        item_continusCapture.setOnClickListener(new bja(this));
        item_newcamera = findViewById(0x7f0d03fb);
        item_newcamera.setOnClickListener(new bjb(this));
        item_ad1container = findViewById(0x7f0d03fc);
        if (android.os.Build.VERSION.SDK_INT < 18)
        {
            item_video.setVisibility(8);
            item_ad1container.setVisibility(0);
            return;
        } else
        {
            item_video.setVisibility(0);
            item_ad1container.setVisibility(8);
            return;
        }
    }

    public void onAdButtonDisplay(int i, TAdItem taditem)
    {
        taditem.getDisplayName();
        if (i == 0 && item_name00 != null)
        {
            item_name00.setText(taditem.getDisplayName());
        }
        if (i == 1 && item_name01 != null)
        {
            item_name01.setText(taditem.getDisplayName());
        }
    }

    public void resetMainButtonSize()
    {
    }

    public void resize(int i, int j)
    {
        axw.a(this, (float)j / (float)srcWidthDp);
        requestLayout();
    }

    public void setOnClickListener(biv biv)
    {
        clickerListener = biv;
    }
}
