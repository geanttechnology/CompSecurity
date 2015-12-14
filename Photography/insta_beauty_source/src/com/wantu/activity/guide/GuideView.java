// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.activity.guide;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import bih;
import bii;
import bij;

public class GuideView extends FrameLayout
{

    public int bgResourceId;
    public Button btnCheck;
    Button btnToPipcamera;
    FrameLayout customCtrlView;
    View div_view;
    View div_view_end;
    boolean hasFreshed;
    ImageView img_backgroundView;
    ImageView img_displayView;
    public bij lisener;

    public GuideView(Context context)
    {
        super(context);
        hasFreshed = false;
    }

    public GuideView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        hasFreshed = false;
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f03006a, this, true);
        img_backgroundView = (ImageView)findViewById(0x7f0d0237);
        div_view = findViewById(0x7f0d0238);
        div_view_end = findViewById(0x7f0d023b);
        customCtrlView = (FrameLayout)findViewById(0x7f0d023d);
        img_displayView = (ImageView)findViewById(0x7f0d012b);
        btnCheck = (Button)findViewById(0x7f0d023a);
        btnCheck.setSelected(true);
        btnCheck.setOnClickListener(new bih(this));
        btnToPipcamera = (Button)findViewById(0x7f0d023e);
        context = new android.widget.FrameLayout.LayoutParams(btnToPipcamera.getLayoutParams());
        context.gravity = 17;
        btnToPipcamera.setLayoutParams(context);
        btnToPipcamera.setOnClickListener(new bii(this));
    }

    private Bitmap getBitmap(int i)
    {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inPreferredConfig = android.graphics.Bitmap.Config.RGB_565;
        options.inPurgeable = true;
        options.inInputShareable = true;
        return BitmapFactory.decodeStream(getResources().openRawResource(i), null, options);
    }

    public void recycleBGResource()
    {
        hasFreshed = false;
        Bitmap bitmap;
        try
        {
            bitmap = ((BitmapDrawable)img_backgroundView.getBackground()).getBitmap();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return;
        }
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        if (!bitmap.isRecycled())
        {
            bitmap.recycle();
        }
        img_backgroundView.setBackgroundDrawable(null);
        Log.i("recyle memory", (new StringBuilder()).append("bitmap..").append(bgResourceId).toString());
        return;
    }

    public void refreshBgView()
    {
        if (hasFreshed)
        {
            return;
        } else
        {
            img_backgroundView.setBackgroundDrawable(new BitmapDrawable(getBitmap(bgResourceId)));
            hasFreshed = true;
            return;
        }
    }

    public void setBgImageView(int i)
    {
        bgResourceId = i;
    }

    public void setButtonVisible()
    {
        img_backgroundView.setVisibility(0);
        div_view_end.setVisibility(0);
        btnToPipcamera.setBackgroundDrawable(new BitmapDrawable(getBitmap(0x7f020321)));
        btnToPipcamera.setVisibility(0);
    }

    public void setCheckViewVisible(boolean flag)
    {
        div_view.setVisibility(0);
        btnCheck.setBackgroundDrawable(getContext().getResources().getDrawable(0x7f0203ac));
        btnCheck.setVisibility(0);
        btnCheck.setSelected(flag);
    }

    public void setLisener(bij bij)
    {
        lisener = bij;
    }
}
