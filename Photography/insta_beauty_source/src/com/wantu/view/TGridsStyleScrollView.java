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
import bqd;
import bqe;
import bqf;
import com.flurry.android.FlurryAgent;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import java.util.ArrayList;
import java.util.List;
import yo;

public class TGridsStyleScrollView extends HorizontalScrollView
{

    private static final String TAG = "TGridStyleScrollView";
    private List bmList;
    private bqf mCallback;
    private View mCurSelectedItem;
    private LinearLayout mLayout;

    public TGridsStyleScrollView(Context context)
    {
        super(context);
        bmList = new ArrayList();
        init();
    }

    public TGridsStyleScrollView(Context context, AttributeSet attributeset)
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

    public void addItem(TPhotoComposeInfo tphotocomposeinfo)
    {
        try
        {
            View view = LayoutInflater.from(getContext()).inflate(0x7f03004a, null);
            ImageButton imagebutton = (ImageButton)view.findViewById(0x7f0d01c1);
            imagebutton.setTag(tphotocomposeinfo);
            imagebutton.setOnClickListener(new bqe(this));
            tphotocomposeinfo = yo.a(tphotocomposeinfo.getIconBitmap(), 5F);
            imagebutton.setImageBitmap(tphotocomposeinfo);
            bmList.add(tphotocomposeinfo);
            mLayout.addView(view);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (TPhotoComposeInfo tphotocomposeinfo)
        {
            Log.e("TGridStyleScrollView", tphotocomposeinfo.getMessage());
        }
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

    public int getIndex(TPhotoComposeInfo tphotocomposeinfo)
    {
        int j = mLayout.getChildCount();
        for (int i = 0; i < j; i++)
        {
            if (((TPhotoComposeInfo)((ImageButton)mLayout.getChildAt(i).findViewById(0x7f0d01c1)).getTag()).name.compareTo(tphotocomposeinfo.name) == 0)
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
            (new Handler()).postDelayed(new bqd(this, i), 0L);
        }
    }

    public void setCallback(bqf bqf)
    {
        mCallback = bqf;
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
    public static View access$102(TGridsStyleScrollView tgridsstylescrollview, View view)
    {
        tgridsstylescrollview.mCurSelectedItem = view;
        return view;
    }

*/

}
