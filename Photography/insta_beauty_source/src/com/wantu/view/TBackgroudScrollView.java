// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import bpq;
import bpr;
import bps;
import com.flurry.android.FlurryAgent;
import com.wantu.model.res.TFrameItemInfo;
import java.util.ArrayList;
import java.util.List;
import yo;

public class TBackgroudScrollView extends HorizontalScrollView
{

    private static final String TAG = "TGridStyleScrollView";
    private List bmList;
    private bps mCallback;
    private View mCurSelectedItem;
    private LinearLayout mLayout;

    public TBackgroudScrollView(Context context)
    {
        super(context);
        bmList = new ArrayList();
        init();
    }

    public TBackgroudScrollView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        bmList = new ArrayList();
        init();
    }

    private Bitmap getBitmapByColor(int i, int j, int k)
    {
        Bitmap bitmap = Bitmap.createBitmap(j, k, android.graphics.Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        RectF rectf = new RectF(new Rect(0, 0, j, k));
        paint.setAntiAlias(true);
        canvas.drawARGB(Color.alpha(i), Color.red(i), Color.green(i), Color.blue(i));
        paint.setColor(i);
        canvas.drawRoundRect(rectf, 0.0F, 0.0F, paint);
        return bitmap;
    }

    private final void init()
    {
        mLayout = new LinearLayout(getContext());
        mLayout.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-2, -1));
        mLayout.setOrientation(0);
        addView(mLayout);
    }

    public void addItem(TFrameItemInfo tframeiteminfo)
    {
        View view;
        ImageButton imagebutton;
        view = LayoutInflater.from(getContext()).inflate(0x7f03004a, null);
        imagebutton = (ImageButton)view.findViewById(0x7f0d01c1);
        imagebutton.setTag(tframeiteminfo);
        imagebutton.setOnClickListener(new bpr(this));
        if (tframeiteminfo.imageURL == null || tframeiteminfo.imageURL.length() <= 0) goto _L2; else goto _L1
_L1:
        tframeiteminfo = yo.a(tframeiteminfo.getIconBitmap(), 15F);
        bmList.add(tframeiteminfo);
        imagebutton.setImageBitmap(tframeiteminfo);
_L4:
        mLayout.addView(view);
        return;
_L2:
        try
        {
            tframeiteminfo = getBitmapByColor(tframeiteminfo.bgColor, 100, 100);
        }
        // Misplaced declaration of an exception variable
        catch (TFrameItemInfo tframeiteminfo)
        {
            Log.e("TGridStyleScrollView", tframeiteminfo.getMessage());
            return;
        }
        if (tframeiteminfo == null) goto _L4; else goto _L3
_L3:
        Bitmap bitmap = yo.a(tframeiteminfo, 15F);
        bmList.add(bitmap);
        tframeiteminfo.recycle();
        imagebutton.setImageBitmap(bitmap);
          goto _L4
    }

    public void clear()
    {
        int j = mLayout.getChildCount();
        for (int i = 0; i < j; i++)
        {
            ImageButton imagebutton = (ImageButton)mLayout.getChildAt(i).findViewById(0x7f0d01c1);
            Bitmap bitmap = (Bitmap)bmList.get(i);
            imagebutton.setImageBitmap(null);
            if (bitmap != null && !bitmap.isRecycled())
            {
                bitmap.recycle();
            }
        }

        mLayout.removeAllViews();
        bmList.clear();
    }

    public int getIndex(TFrameItemInfo tframeiteminfo)
    {
        int j = mLayout.getChildCount();
        for (int i = 0; i < j; i++)
        {
            if (((TFrameItemInfo)((ImageButton)mLayout.getChildAt(i).findViewById(0x7f0d01c1)).getTag()).getName().compareTo(tframeiteminfo.getName()) == 0)
            {
                return i;
            }
        }

        return 0;
    }

    public void removeAllItems()
    {
        mLayout.removeAllViews();
    }

    public void scrollTo(int i)
    {
        if (i < mLayout.getChildCount())
        {
            if (i < 0)
            {
                FlurryAgent.logEvent("scrollToIndexError");
            }
            (new Handler()).postDelayed(new bpq(this, i), 0L);
        }
    }

    public void setCallback(bps bps)
    {
        mCallback = bps;
    }

    public void setItemSelected(int i, Boolean boolean1)
    {
        if (i < mLayout.getChildCount())
        {
            View view = mLayout.getChildAt(i);
            view.setSelected(boolean1.booleanValue());
            mCurSelectedItem = view;
        }
    }




/*
    public static View access$102(TBackgroudScrollView tbackgroudscrollview, View view)
    {
        tbackgroudscrollview.mCurSelectedItem = view;
        return view;
    }

*/

}
