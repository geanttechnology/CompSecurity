// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import bpp;
import bps;
import com.wantu.ResourceOnlineLibrary.EOnlineResType;
import com.wantu.ResourceOnlineLibrary.FileManager;
import com.wantu.model.res.EResType;
import com.wantu.model.res.TPhotoFreeComposeStyleInfo;
import yo;

public class TBackgroudFreeStyleScrollView extends HorizontalScrollView
{

    private static final String TAG = "TBackGroudFreeStyleScrollView";
    private bps mCallback;
    private View mCurSelectedItem;
    private LinearLayout mLayout;

    public TBackgroudFreeStyleScrollView(Context context)
    {
        super(context);
        init();
    }

    public TBackgroudFreeStyleScrollView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init();
    }

    private final void init()
    {
        mLayout = new LinearLayout(getContext());
        mLayout.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-2, -1));
        mLayout.setOrientation(0);
        addView(mLayout);
    }

    public void addItem(TPhotoFreeComposeStyleInfo tphotofreecomposestyleinfo)
    {
        View view;
        ImageButton imagebutton;
        view = LayoutInflater.from(getContext()).inflate(0x7f03004a, null);
        imagebutton = (ImageButton)view.findViewById(0x7f0d01c1);
        imagebutton.setTag(tphotofreecomposestyleinfo);
        imagebutton.setOnClickListener(new bpp(this));
        if (tphotofreecomposestyleinfo.getResType() != EResType.NETWORK)
        {
            break MISSING_BLOCK_LABEL_127;
        }
        int i = tphotofreecomposestyleinfo.icon.lastIndexOf("/");
        tphotofreecomposestyleinfo = tphotofreecomposestyleinfo.icon.substring(i + 1);
        tphotofreecomposestyleinfo = FileManager.getInstance().getOnlineBitmapRes(EOnlineResType.FREE_COLLAGE_STYLE, tphotofreecomposestyleinfo);
_L1:
        Bitmap bitmap;
        bitmap = yo.a(tphotofreecomposestyleinfo, 10F);
        imagebutton.setImageBitmap(bitmap);
        if (tphotofreecomposestyleinfo != null)
        {
            try
            {
                tphotofreecomposestyleinfo.recycle();
            }
            // Misplaced declaration of an exception variable
            catch (TPhotoFreeComposeStyleInfo tphotofreecomposestyleinfo)
            {
                Log.e("TBackGroudFreeStyleScrollView", tphotofreecomposestyleinfo.getMessage());
                return;
            }
        }
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_118;
        }
        imagebutton.setImageBitmap(bitmap);
        mLayout.addView(view);
        return;
        tphotofreecomposestyleinfo = tphotofreecomposestyleinfo.getIconBitmap();
          goto _L1
    }

    public void clearAllSelected()
    {
        int j = mLayout.getChildCount();
        for (int i = 0; i < j; i++)
        {
            mLayout.getChildAt(i).setSelected(false);
        }

    }

    public void onResume()
    {
        clearAllSelected();
        if (mCurSelectedItem != null)
        {
            mCurSelectedItem.setSelected(true);
        }
    }

    public void removeAllItems()
    {
        mLayout.removeAllViewsInLayout();
        mCurSelectedItem = null;
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
    public static View access$002(TBackgroudFreeStyleScrollView tbackgroudfreestylescrollview, View view)
    {
        tbackgroudfreestylescrollview.mCurSelectedItem = view;
        return view;
    }

*/

}
