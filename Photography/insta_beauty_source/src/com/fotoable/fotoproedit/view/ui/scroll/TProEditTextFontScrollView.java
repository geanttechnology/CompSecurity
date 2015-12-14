// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.view.ui.scroll;

import alq;
import ama;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import anm;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import yp;

// Referenced classes of package com.fotoable.fotoproedit.view.ui.scroll:
//            FontItemChildView

public class TProEditTextFontScrollView extends HorizontalScrollView
{

    private static final String TAG = "TProEditTextBubbleScrollView";
    private anm listener;
    private FontItemChildView mCurSelectedItem;
    private LinearLayout mLayout;

    public TProEditTextFontScrollView(Context context)
    {
        super(context);
        init();
    }

    public TProEditTextFontScrollView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init();
    }

    private final void init()
    {
        mLayout = new LinearLayout(getContext());
        mLayout.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-2, -1));
        mLayout.setOrientation(0);
        setHorizontalScrollBarEnabled(false);
        addView(mLayout);
        alq alq1 = new alq();
        Object obj = new ama();
        ((ama) (obj)).a(Typeface.create("sans", 0));
        ((ama) (obj)).a("sans");
        Object obj1 = new ama();
        ((ama) (obj1)).a(Typeface.create("serif", 0));
        ((ama) (obj1)).a("serif");
        addItem("sans", ((ama) (obj)), "serif", ((ama) (obj1)));
        obj = alq1.a();
        obj1 = alq1.b();
        if (obj != null)
        {
            Iterator iterator = ((Map) (obj)).keySet().iterator();
            if (yp.a())
            {
                for (int i = 0; i < ((List) (obj1)).size(); i++)
                {
                    String s1 = (String)iterator.next();
                    addItem("", (ama)((List) (obj1)).get(i), s1, (ama)((Map) (obj)).get(s1));
                }

            }
            while (iterator.hasNext()) 
            {
                String s = (String)iterator.next();
                if (iterator.hasNext())
                {
                    String s2 = (String)iterator.next();
                    addItem(s, (ama)((Map) (obj)).get(s), s2, (ama)((Map) (obj)).get(s2));
                } else
                {
                    addItem(s, (ama)((Map) (obj)).get(s), null, null);
                }
            }
        }
    }

    public void addItem(String s, ama ama1, String s1, ama ama2)
    {
    }

    public void setCallback(anm anm)
    {
        listener = anm;
    }

    public void setItemDownloaded()
    {
        mCurSelectedItem.hideDownloadTip();
    }
}
