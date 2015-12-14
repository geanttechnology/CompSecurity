// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.guide;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.crashlytics.android.Crashlytics;
import sk;

public class GuideView extends FrameLayout
{

    int bgResourceId;
    Button btnCheck;
    Button btnToPipcamera;
    View div_view;
    View div_view_end;
    boolean hasFreshed;
    ImageView img_backgroundView;
    ImageView img_displayView;
    sk lisener;

    public GuideView(Context context)
    {
        super(context);
        hasFreshed = false;
    }

    public GuideView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        hasFreshed = false;
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f030041, this, true);
        img_backgroundView = (ImageView)findViewById(0x7f0c0130);
        div_view = findViewById(0x7f0c0131);
        div_view_end = findViewById(0x7f0c0134);
        img_displayView = (ImageView)findViewById(0x7f0c00af);
        btnCheck = (Button)findViewById(0x7f0c0133);
        btnCheck.setSelected(true);
        btnCheck.setOnClickListener(new android.view.View.OnClickListener() {

            final GuideView a;

            public void onClick(View view)
            {
                view = a.btnCheck;
                boolean flag;
                if (!a.btnCheck.isSelected())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                view.setSelected(flag);
                if (a.lisener != null)
                {
                    a.lisener.a(a.btnCheck.isSelected());
                }
            }

            
            {
                a = GuideView.this;
                super();
            }
        });
        btnToPipcamera = (Button)findViewById(0x7f0c0137);
        btnToPipcamera.setOnClickListener(new android.view.View.OnClickListener() {

            final GuideView a;

            public void onClick(View view)
            {
                if (a.lisener != null)
                {
                    a.lisener.a();
                }
            }

            
            {
                a = GuideView.this;
                super();
            }
        });
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
            Crashlytics.logException(exception);
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
        btnToPipcamera.setBackgroundDrawable(new BitmapDrawable(getBitmap(0x7f0201e2)));
        btnToPipcamera.setVisibility(0);
    }

    public void setCheckViewVisible(boolean flag)
    {
        div_view.setVisibility(0);
        btnCheck.setBackgroundDrawable(getContext().getResources().getDrawable(0x7f020239));
        btnCheck.setVisibility(0);
        btnCheck.setSelected(flag);
    }

    public void setLisener(sk sk)
    {
        lisener = sk;
    }
}
