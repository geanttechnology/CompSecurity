// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.crashlytics.android.Crashlytics;
import com.fotoable.onLineImage.ImageButtonOnLine;
import com.wantu.ResourceOnlineLibrary.EOnlineResType;
import com.wantu.ResourceOnlineLibrary.FileManager;
import com.wantu.model.res.EResType;
import com.wantu.model.res.pip.TDFSceneInfo;
import ev;
import yv;

public class TPipListScrollView extends HorizontalScrollView
{

    private static final String TAG = "TPipListScrollView";
    private yv mCallback;
    private View mCurSelectedItem;
    private LinearLayout mLayout;
    int online_filter_num;

    public TPipListScrollView(Context context)
    {
        super(context);
        online_filter_num = 0;
        init();
    }

    public TPipListScrollView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        online_filter_num = 0;
        init();
    }

    private final void init()
    {
        mLayout = new LinearLayout(getContext());
        mLayout.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-2, -1));
        mLayout.setOrientation(0);
        addView(mLayout);
    }

    public void addPipItem(TDFSceneInfo tdfsceneinfo)
    {
        View view;
        ImageButtonOnLine imagebuttononline;
        view = LayoutInflater.from(getContext()).inflate(0x7f03003d, null);
        imagebuttononline = (ImageButtonOnLine)view.findViewById(0x7f0c0127);
        imagebuttononline.setTag(tdfsceneinfo);
        imagebuttononline.setOnClickListener(new android.view.View.OnClickListener() {

            final TPipListScrollView a;

            public void onClick(View view1)
            {
                if (a.mCurSelectedItem != view1)
                {
                    if (a.mCurSelectedItem != null)
                    {
                        a.mCurSelectedItem.setSelected(false);
                    }
                    a.mCurSelectedItem = view1;
                    view1.setSelected(true);
                    if (a.mCallback != null)
                    {
                        view1 = (TDFSceneInfo)view1.getTag();
                        a.mCallback.a(view1);
                        return;
                    }
                }
            }

            
            {
                a = TPipListScrollView.this;
                super();
            }
        });
        if (tdfsceneinfo.getResType() != EResType.ONLINE) goto _L2; else goto _L1
_L1:
        imagebuttononline.setImageBitmapFromUrl(tdfsceneinfo.icon);
        online_filter_num = online_filter_num + 1;
_L3:
        ((TextView)view.findViewById(0x7f0c0128)).setVisibility(4);
        mLayout.addView(view);
        return;
_L2:
        if (tdfsceneinfo.getResType() != EResType.NETWORK)
        {
            break MISSING_BLOCK_LABEL_168;
        }
        int i = tdfsceneinfo.icon.lastIndexOf("/");
        tdfsceneinfo = tdfsceneinfo.icon.substring(i + 1);
        tdfsceneinfo = FileManager.getInstance().getOnlineBitmapRes(EOnlineResType.PIP_SCENE, tdfsceneinfo);
_L4:
        if (tdfsceneinfo != null)
        {
            try
            {
                imagebuttononline.setImageBitmap(ev.a(tdfsceneinfo, 5F));
            }
            // Misplaced declaration of an exception variable
            catch (TDFSceneInfo tdfsceneinfo)
            {
                Log.e("TPipListScrollView", tdfsceneinfo.getMessage());
                Crashlytics.logException(tdfsceneinfo);
                return;
            }
        }
          goto _L3
        tdfsceneinfo = tdfsceneinfo.getIconBitmap();
          goto _L4
    }

    public void clear()
    {
        for (int i = 0; i < mLayout.getChildCount(); i++)
        {
            ImageButton imagebutton = (ImageButton)mLayout.getChildAt(i).findViewById(0x7f0c0127);
            if (imagebutton != null)
            {
                imagebutton.setImageBitmap(null);
            }
        }

        online_filter_num = 0;
    }

    public void removeAllItems()
    {
        mLayout.removeAllViewsInLayout();
        mCurSelectedItem = null;
    }

    public void setCallback(yv yv)
    {
        mCallback = yv;
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

    public void setItemSelected(String s, Boolean boolean1)
    {
        for (int i = 0; i < mLayout.getChildCount(); i++)
        {
            View view = mLayout.getChildAt(i);
            if (((TDFSceneInfo)((ImageButton)view.findViewById(0x7f0c0127)).getTag()).getName().compareToIgnoreCase(s) == 0)
            {
                view.setSelected(boolean1.booleanValue());
                mCurSelectedItem = view;
            }
        }

    }



/*
    static View access$002(TPipListScrollView tpiplistscrollview, View view)
    {
        tpiplistscrollview.mCurSelectedItem = view;
        return view;
    }

*/

}
