// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import bqj;
import bqk;
import bql;
import com.flurry.android.FlurryAgent;
import com.wantu.ResourceOnlineLibrary.EOnlineResType;
import com.wantu.ResourceOnlineLibrary.FileManager;
import com.wantu.imagelib.filter.TImageFilterInfo;
import com.wantu.model.res.EResType;
import java.util.ArrayList;
import java.util.List;
import yo;

public class TLightingScrollView extends HorizontalScrollView
{

    private static final String TAG = "TLightingScrollView";
    private List bmList;
    private bql mCallback;
    private View mCurSelectedItem;
    private LinearLayout mLayout;

    public TLightingScrollView(Context context)
    {
        super(context);
        bmList = new ArrayList();
        init();
    }

    public TLightingScrollView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        bmList = new ArrayList();
        init();
    }

    private final void init()
    {
        mLayout = new LinearLayout(getContext());
        mLayout.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-2, -1));
        mLayout.setOrientation(0);
        addView(mLayout);
    }

    public void addItem(TImageFilterInfo timagefilterinfo)
    {
        View view;
        ImageButton imagebutton;
        view = LayoutInflater.from(getContext()).inflate(0x7f03004a, null);
        imagebutton = (ImageButton)view.findViewById(0x7f0d01c1);
        imagebutton.setTag(timagefilterinfo);
        imagebutton.setOnClickListener(new bqk(this));
        if (timagefilterinfo.getResType() != EResType.NETWORK)
        {
            break MISSING_BLOCK_LABEL_119;
        }
        int i = timagefilterinfo.filterIconName.lastIndexOf("/");
        timagefilterinfo = timagefilterinfo.filterIconName.substring(i + 1);
        timagefilterinfo = yo.a(FileManager.getInstance().getOnlineBitmapRes(EOnlineResType.LIGHT_FILTER, timagefilterinfo), 15F);
_L1:
        if (timagefilterinfo != null)
        {
            try
            {
                imagebutton.setImageBitmap(timagefilterinfo);
                mLayout.addView(view);
                bmList.add(timagefilterinfo);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (TImageFilterInfo timagefilterinfo)
            {
                return;
            }
        }
        break MISSING_BLOCK_LABEL_132;
        timagefilterinfo = yo.a(timagefilterinfo.getAssetIconBitMap(), 15F);
          goto _L1
        Log.v("hedong_icon", "no bimap");
        return;
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

    public int getIndex(String s)
    {
        int j = mLayout.getChildCount();
        for (int i = 0; i < j; i++)
        {
            TImageFilterInfo timagefilterinfo = (TImageFilterInfo)((ImageButton)mLayout.getChildAt(i).findViewById(0x7f0d01c1)).getTag();
            if (timagefilterinfo != null && timagefilterinfo.filterName.compareTo(s) == 0)
            {
                return i;
            }
        }

        return 0;
    }

    public void scrollTo(int i)
    {
        if (i < mLayout.getChildCount())
        {
            if (i < 0)
            {
                FlurryAgent.logEvent("scrollToIndexError");
            }
            (new Handler()).postDelayed(new bqj(this, i), 0L);
        }
    }

    public void setCallback(bql bql)
    {
        mCallback = bql;
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
    public static View access$102(TLightingScrollView tlightingscrollview, View view)
    {
        tlightingscrollview.mCurSelectedItem = view;
        return view;
    }

*/

}
