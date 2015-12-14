// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity.mosaic;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import ig;
import java.io.InputStream;
import java.util.ArrayList;

// Referenced classes of package com.fotoable.fotoproedit.activity.mosaic:
//            MosaicIconItemView, MosaicInfo

public class MosaicIconScrollView extends HorizontalScrollView
{

    private ig callback;
    private View mCurSelectedItem;
    private LinearLayout mLayout;

    public MosaicIconScrollView(Context context)
    {
        super(context);
        init();
    }

    public MosaicIconScrollView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init();
    }

    private View addItem(MosaicInfo mosaicinfo, Bitmap bitmap)
    {
        MosaicIconItemView mosaiciconitemview = new MosaicIconItemView(getContext(), null);
        mosaiciconitemview.setTag(mosaicinfo);
        mosaiciconitemview.setClickable(true);
        mosaiciconitemview.setImage(bitmap);
        mosaiciconitemview.setOnClickListener(new android.view.View.OnClickListener() {

            final MosaicIconScrollView a;

            public void onClick(View view)
            {
                if (!view.isSelected())
                {
                    if (a.mCurSelectedItem != null)
                    {
                        a.mCurSelectedItem.setSelected(false);
                    }
                    a.mCurSelectedItem = view;
                    a.setStartScroll(view);
                    a.mCurSelectedItem.setSelected(true);
                    if (a.callback != null)
                    {
                        a.callback.a((MosaicInfo)view.getTag());
                        return;
                    }
                }
            }

            
            {
                a = MosaicIconScrollView.this;
                super();
            }
        });
        mLayout.addView(mosaiciconitemview);
        return mosaiciconitemview;
    }

    private Bitmap createAssertBitmap(String s)
    {
        Bitmap bitmap;
        try
        {
            s = getContext().getAssets().open(s);
            bitmap = BitmapFactory.decodeStream(s);
            s.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return null;
        }
        return bitmap;
    }

    private void init()
    {
        mLayout = new LinearLayout(getContext());
        mLayout.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-2, -1));
        mLayout.setOrientation(0);
        setSmoothScrollingEnabled(true);
        setScrollbarFadingEnabled(true);
        setHorizontalScrollBarEnabled(false);
        addView(mLayout);
    }

    private void setStartScroll(View view)
    {
        int i = getContext().getResources().getDisplayMetrics().widthPixels;
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

    public void fillIconScroll(ArrayList arraylist)
    {
        int i = 0;
        while (i < arraylist.size()) 
        {
            Object obj = (MosaicInfo)arraylist.get(i);
            Bitmap bitmap = createAssertBitmap(((MosaicInfo) (obj)).f);
            if (bitmap != null)
            {
                obj = addItem(((MosaicInfo) (obj)), bitmap);
                if (i == 0)
                {
                    ((View) (obj)).setSelected(true);
                    mCurSelectedItem = ((View) (obj));
                } else
                {
                    ((View) (obj)).setSelected(false);
                }
            }
            i++;
        }
    }

    public void setListener(ig ig)
    {
        callback = ig;
    }



/*
    static View access$002(MosaicIconScrollView mosaiciconscrollview, View view)
    {
        mosaiciconscrollview.mCurSelectedItem = view;
        return view;
    }

*/


}
