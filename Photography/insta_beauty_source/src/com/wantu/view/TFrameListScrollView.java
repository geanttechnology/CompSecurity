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
import bqa;
import bqb;
import bqc;
import com.flurry.android.FlurryAgent;
import com.wantu.ResourceOnlineLibrary.EOnlineResType;
import com.wantu.ResourceOnlineLibrary.FileManager;
import com.wantu.model.res.EResType;
import com.wantu.model.res.TFrameItemInfo;
import java.util.ArrayList;
import java.util.List;
import yo;

public class TFrameListScrollView extends HorizontalScrollView
{

    private static final String TAG = "TFrameListScrollView";
    private List bmList;
    private bqc mCallback;
    private View mCurSelectedItem;
    private LinearLayout mLayout;

    public TFrameListScrollView(Context context)
    {
        super(context);
        bmList = new ArrayList();
        init();
    }

    public TFrameListScrollView(Context context, AttributeSet attributeset)
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

    public void addItem(TFrameItemInfo tframeiteminfo)
    {
        View view;
        ImageButton imagebutton;
        view = LayoutInflater.from(getContext()).inflate(0x7f03004a, null);
        imagebutton = (ImageButton)view.findViewById(0x7f0d01c1);
        imagebutton.setTag(tframeiteminfo);
        imagebutton.setOnClickListener(new bqb(this));
        if (tframeiteminfo.getResType() != EResType.NETWORK)
        {
            break MISSING_BLOCK_LABEL_119;
        }
        int i = tframeiteminfo.imageURL.lastIndexOf("/");
        tframeiteminfo = tframeiteminfo.imageURL.substring(i + 1);
        tframeiteminfo = yo.a(FileManager.getInstance().getOnlineBitmapRes(EOnlineResType.FILTER_FRAME, tframeiteminfo), 5F);
_L1:
        if (tframeiteminfo != null)
        {
            try
            {
                imagebutton.setImageBitmap(tframeiteminfo);
                mLayout.addView(view);
                bmList.add(tframeiteminfo);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (TFrameItemInfo tframeiteminfo)
            {
                return;
            }
        }
        break MISSING_BLOCK_LABEL_132;
        tframeiteminfo = yo.a(tframeiteminfo.getIconBitmap(), 5F);
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
            TFrameItemInfo tframeiteminfo = (TFrameItemInfo)((ImageButton)mLayout.getChildAt(i).findViewById(0x7f0d01c1)).getTag();
            if (tframeiteminfo != null && tframeiteminfo.name.equalsIgnoreCase(s))
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
            (new Handler()).postDelayed(new bqa(this, i), 0L);
        }
    }

    public void setCallback(bqc bqc)
    {
        mCallback = bqc;
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
    public static View access$102(TFrameListScrollView tframelistscrollview, View view)
    {
        tframelistscrollview.mCurSelectedItem = view;
        return view;
    }

*/

}
