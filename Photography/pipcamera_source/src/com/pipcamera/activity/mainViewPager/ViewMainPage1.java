// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.mainViewPager;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.fotoable.adbuttonlib.TAdButton;
import com.fotoable.adbuttonlib.TAdButtonGroup;
import com.fotoable.adbuttonlib.TAdItem;
import com.pipcamera.application.PIPCameraApplication;
import pb;
import sl;

public class ViewMainPage1 extends FrameLayout
    implements com.fotoable.adbuttonlib.TAdButton.TAdButtonLisener
{

    sl clickerListener;
    ImageView img_classic;
    ImageView img_collage;
    ImageView img_frame;
    ImageView img_freecollage;
    ImageView img_library;
    ImageView img_proedit;
    TAdButton item_adC01;
    TAdButton item_adC02;
    FrameLayout item_classic;
    FrameLayout item_collage;
    FrameLayout item_freecollage;
    FrameLayout item_proedit;
    int srcHeightDp;
    int srcWidthDp;
    TextView tx_ad01;
    TextView tx_ad02;
    TextView tx_classic;
    TextView tx_collage;
    TextView tx_freecollage;
    TextView tx_proedit;

    public ViewMainPage1(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        srcWidthDp = 320;
        srcHeightDp = 480;
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f0300c5, this, true);
        item_classic = (FrameLayout)findViewById(0x7f0c0301);
        item_freecollage = (FrameLayout)findViewById(0x7f0c0307);
        item_proedit = (FrameLayout)findViewById(0x7f0c030a);
        item_collage = (FrameLayout)findViewById(0x7f0c0304);
        item_adC01 = (TAdButton)findViewById(0x7f0c030e);
        item_adC01.setAdButtonLisener(0, this);
        item_adC02 = (TAdButton)findViewById(0x7f0c0311);
        item_adC02.setAdButtonLisener(1, this);
        tx_ad01 = (TextView)findViewById(0x7f0c030f);
        tx_ad02 = (TextView)findViewById(0x7f0c0312);
        img_proedit = (ImageView)findViewById(0x7f0c030b);
        img_classic = (ImageView)findViewById(0x7f0c0302);
        img_collage = (ImageView)findViewById(0x7f0c0305);
        img_freecollage = (ImageView)findViewById(0x7f0c0308);
        tx_freecollage = (TextView)findViewById(0x7f0c0309);
        tx_classic = (TextView)findViewById(0x7f0c0303);
        tx_collage = (TextView)findViewById(0x7f0c0306);
        tx_proedit = (TextView)findViewById(0x7f0c030c);
        tx_proedit.setTextColor(Color.argb(200, 0, 0, 0));
        tx_collage.setTextColor(Color.argb(200, 0, 0, 0));
        tx_freecollage.setTextColor(Color.argb(200, 0, 0, 0));
        tx_classic.setTextColor(Color.argb(200, 0, 0, 0));
        tx_ad01.setTextColor(Color.argb(200, 0, 0, 0));
        tx_ad02.setTextColor(Color.argb(200, 0, 0, 0));
        item_collage.setOnClickListener(new android.view.View.OnClickListener() {

            final ViewMainPage1 a;

            public void onClick(View view)
            {
                if (a.clickerListener != null)
                {
                    a.clickerListener.a(view, "item_collage");
                }
            }

            
            {
                a = ViewMainPage1.this;
                super();
            }
        });
        item_collage.setOnTouchListener(new android.view.View.OnTouchListener() {

            final ViewMainPage1 a;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                motionevent.getAction();
                JVM INSTR tableswitch 0 2: default 32
            //                           0 57
            //                           1 32
            //                           2 57;
                   goto _L1 _L2 _L1 _L2
_L1:
                a.img_collage.getBackground().clearColorFilter();
_L4:
                a.img_collage.invalidate();
                return false;
_L2:
                a.img_collage.getBackground().setColorFilter(0xff888888, android.graphics.PorterDuff.Mode.MULTIPLY);
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                a = ViewMainPage1.this;
                super();
            }
        });
        item_classic.setOnClickListener(new android.view.View.OnClickListener() {

            final ViewMainPage1 a;

            public void onClick(View view)
            {
                if (a.clickerListener != null)
                {
                    a.clickerListener.a(view, "item_classic");
                }
            }

            
            {
                a = ViewMainPage1.this;
                super();
            }
        });
        item_classic.setOnTouchListener(new android.view.View.OnTouchListener() {

            final ViewMainPage1 a;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                motionevent.getAction();
                JVM INSTR tableswitch 0 2: default 32
            //                           0 57
            //                           1 32
            //                           2 57;
                   goto _L1 _L2 _L1 _L2
_L1:
                a.img_classic.getBackground().clearColorFilter();
_L4:
                a.img_classic.invalidate();
                return false;
_L2:
                a.img_classic.getBackground().setColorFilter(0xff888888, android.graphics.PorterDuff.Mode.MULTIPLY);
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                a = ViewMainPage1.this;
                super();
            }
        });
        item_freecollage.setOnClickListener(new android.view.View.OnClickListener() {

            final ViewMainPage1 a;

            public void onClick(View view)
            {
                if (a.clickerListener != null)
                {
                    a.clickerListener.a(view, "item_freecollage");
                }
            }

            
            {
                a = ViewMainPage1.this;
                super();
            }
        });
        item_freecollage.setOnTouchListener(new android.view.View.OnTouchListener() {

            final ViewMainPage1 a;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                motionevent.getAction();
                JVM INSTR tableswitch 0 2: default 32
            //                           0 57
            //                           1 32
            //                           2 57;
                   goto _L1 _L2 _L1 _L2
_L1:
                a.img_freecollage.getBackground().clearColorFilter();
_L4:
                a.img_freecollage.invalidate();
                return false;
_L2:
                a.img_freecollage.getBackground().setColorFilter(0xff888888, android.graphics.PorterDuff.Mode.MULTIPLY);
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                a = ViewMainPage1.this;
                super();
            }
        });
        item_proedit.setOnClickListener(new android.view.View.OnClickListener() {

            final ViewMainPage1 a;

            public void onClick(View view)
            {
                if (a.clickerListener != null)
                {
                    a.clickerListener.a(view, "item_proedit");
                }
            }

            
            {
                a = ViewMainPage1.this;
                super();
            }
        });
        item_proedit.setOnTouchListener(new android.view.View.OnTouchListener() {

            final ViewMainPage1 a;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                motionevent.getAction();
                JVM INSTR tableswitch 0 2: default 32
            //                           0 57
            //                           1 32
            //                           2 57;
                   goto _L1 _L2 _L1 _L2
_L1:
                a.img_proedit.getBackground().clearColorFilter();
_L4:
                a.img_proedit.invalidate();
                return false;
_L2:
                a.img_proedit.getBackground().setColorFilter(0xff888888, android.graphics.PorterDuff.Mode.MULTIPLY);
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                a = ViewMainPage1.this;
                super();
            }
        });
        TAdButtonGroup.instance(PIPCameraApplication.b()).registerAdButton(item_adC01, 0);
        TAdButtonGroup.instance(PIPCameraApplication.b()).registerAdButton(item_adC02, 1);
        if (!PIPCameraApplication.a(PIPCameraApplication.a))
        {
            resize();
        }
    }

    private void resize()
    {
        int i = pb.b(getContext());
        int j = pb.a(getContext());
        float f = (float)i / (float)srcHeightDp;
        float f1 = (float)j / (float)srcWidthDp;
        if (f >= f1);
        pb.a(this, f1);
        requestLayout();
    }

    public View getClassicItem()
    {
        return item_classic;
    }

    public void onAdButtonDisplay(int i, TAdItem taditem)
    {
        if (i == 0)
        {
            if (tx_ad01 != null)
            {
                tx_ad01.setText(taditem.getDisplayName());
            }
        } else
        if (i == 1 && tx_ad02 != null)
        {
            tx_ad02.setText(taditem.getDisplayName());
            return;
        }
    }

    public void setHasMaterialNew(boolean flag)
    {
    }

    public void setOnClickListener(sl sl)
    {
        clickerListener = sl;
    }
}
