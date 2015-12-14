// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.pipcamera.application.PIPCameraApplication;
import ew;
import java.util.ArrayList;
import java.util.List;
import ms;

// Referenced classes of package com.fotoable.fotoproedit.activity:
//            ItemView

public class TProEditMainScrollView extends HorizontalScrollView
{

    private static final String TAG = "TFilterListScrollView";
    private List bmList;
    private ms mCallback;
    private ItemView mCurSelectedItem;
    private LinearLayout mLayout;

    public TProEditMainScrollView(Context context)
    {
        super(context);
        bmList = new ArrayList();
        init();
    }

    public TProEditMainScrollView(Context context, AttributeSet attributeset)
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
        setHorizontalScrollBarEnabled(false);
        addView(mLayout);
        addItem(0x7f0202a4, "filter", getContext().getString(0x7f06029a));
        addItem(0x7f0201b4, "sketch", getContext().getString(0x7f0602a2));
        addItem(0x7f0202b0, "font", getContext().getString(0x7f06029b));
        addItem(0x7f0202a3, "crop", getContext().getString(0x7f0600dd));
        addItem(0x7f0202a6, "mosaic", getContext().getString(0x7f06029f));
        addItem(0x7f020040, "adjust", getContext().getString(0x7f060297));
        addItem(0x7f0202af, "stretch", getContext().getString(0x7f0602a3));
    }

    private void moveBtnNew(String s)
    {
        android.content.SharedPreferences.Editor editor = PIPCameraApplication.b().c().getSharedPreferences("config", 0).edit();
        editor.putBoolean(s, true);
        editor.commit();
    }

    private boolean setBtnNew(String s)
    {
        return PIPCameraApplication.b().c().getSharedPreferences("config", 0).getBoolean(s, false);
    }

    public void addItem(int i, String s, String s1)
    {
        try
        {
            ItemView itemview = new ItemView(getContext(), null);
            itemview.setIconRes(i);
            itemview.setIconColor(0xff3a3a3a);
            itemview.setTextColor(0xff3a3a3a);
            itemview.setText(s1);
            itemview.setTag(s);
            s = new android.widget.LinearLayout.LayoutParams(-1, -1);
            s.height = ew.a(getContext(), 56F);
            s.width = getResources().getDisplayMetrics().widthPixels / 6;
            itemview.setLayoutParams(s);
            itemview.setClickable(true);
            itemview.setOnTouchListener(new android.view.View.OnTouchListener(itemview) {

                final ItemView a;
                final TProEditMainScrollView b;

                public boolean onTouch(View view, MotionEvent motionevent)
                {
                    if (motionevent.getAction() == 0 || motionevent.getAction() == 2)
                    {
                        a.setIconColor(0xff007aff);
                        a.setTextColor(0xff007aff);
                    } else
                    {
                        a.setIconColor(0xff3a3a3a);
                        a.setTextColor(0xff3a3a3a);
                    }
                    return false;
                }

            
            {
                b = TProEditMainScrollView.this;
                a = itemview;
                super();
            }
            });
            itemview.setOnClickListener(new android.view.View.OnClickListener() {

                final TProEditMainScrollView a;

                public void onClick(View view)
                {
                    if (a.mCurSelectedItem != (ItemView)view)
                    {
                        if (a.mCurSelectedItem != null)
                        {
                            a.mCurSelectedItem.setSelected(false);
                        }
                        a.mCurSelectedItem = (ItemView)view;
                    }
                    view.setSelected(true);
                    if (a.mCallback != null)
                    {
                        a.mCallback.a((String)view.getTag(), a);
                    }
                }

            
            {
                a = TProEditMainScrollView.this;
                super();
            }
            });
            mLayout.addView(itemview);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("TFilterListScrollView", s.getMessage());
        }
    }

    public void setCallback(ms ms)
    {
        mCallback = ms;
    }



/*
    static ItemView access$002(TProEditMainScrollView tproeditmainscrollview, ItemView itemview)
    {
        tproeditmainscrollview.mCurSelectedItem = itemview;
        return itemview;
    }

*/

}
