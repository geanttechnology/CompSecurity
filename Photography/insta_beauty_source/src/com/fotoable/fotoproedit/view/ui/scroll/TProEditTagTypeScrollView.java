// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.view.ui.scroll;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import anh;
import com.instabeauty.application.InstaBeautyApplication;
import xn;

// Referenced classes of package com.fotoable.fotoproedit.view.ui.scroll:
//            TagItemView

public class TProEditTagTypeScrollView extends HorizontalScrollView
{

    private static final String TAG = "TTagListScrollView";
    private xn mCallback;
    private TagItemView mCurSelectedItem;
    private LinearLayout mLayout;

    public TProEditTagTypeScrollView(Context context)
    {
        super(context);
        init();
    }

    public TProEditTagTypeScrollView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init();
    }

    private void editNew(String s)
    {
        android.content.SharedPreferences.Editor editor = InstaBeautyApplication.a().b().getSharedPreferences("config", 0).edit();
        editor.putBoolean(s, true);
        editor.apply();
    }

    private final void init()
    {
        mLayout = new LinearLayout(getContext());
        mLayout.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-2, -1));
        mLayout.setOrientation(0);
        setHorizontalScrollBarEnabled(false);
        addView(mLayout);
        addItem(0x7f020457, "modern", "\u73B0\u4EE3");
        addItem(0x7f020467, "hoildays", "\u8282\u65E5");
        addItem(0x7f02045b, "location", "\u4F4D\u7F6E");
        addItem(0x7f020469, "pets", "\u5BA0\u7269");
        addItem(0x7f020457, "cool", "\u521B\u610F");
        addItem(0x7f020467, "foods", "\u7F8E\u98DF");
        addItem(0x7f02045b, "objects", "\u7269\u54C1");
    }

    private boolean isbtnNew(String s)
    {
        return InstaBeautyApplication.a().b().getSharedPreferences("config", 0).getBoolean(s, false);
    }

    public void addItem(int i, String s, String s1)
    {
        try
        {
            TagItemView tagitemview = new TagItemView(getContext(), null);
            tagitemview.setIconRes(i);
            tagitemview.setIconColor(-1);
            tagitemview.setTextColor(-1);
            tagitemview.setText(s1);
            tagitemview.setTag(s);
            tagitemview.setBackgroundDrawable(getResources().getDrawable(0x7f02037c));
            tagitemview.setClickable(true);
            tagitemview.setOnClickListener(new anh(this));
            mLayout.addView(tagitemview);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("TTagListScrollView", s.getMessage());
        }
    }

    public void setCallback(xn xn)
    {
        mCallback = xn;
    }



/*
    public static TagItemView access$002(TProEditTagTypeScrollView tproedittagtypescrollview, TagItemView tagitemview)
    {
        tproedittagtypescrollview.mCurSelectedItem = tagitemview;
        return tagitemview;
    }

*/

}
