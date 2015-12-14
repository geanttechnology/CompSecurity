// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photocollage.view.compose2.frames;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.wantu.model.res.TResInfo;
import ew;
import mi;

// Referenced classes of package com.fotoable.photocollage.view.compose2.frames:
//            ModuleStyleOnePageViewLine

public class ModuleStyleOnePageView extends LinearLayout
{

    int displayHeight;
    ModuleStyleOnePageViewLine line1;
    ModuleStyleOnePageViewLine line2;
    View line_1_container;
    View line_2_container;
    mi listener;
    int perLine;

    public ModuleStyleOnePageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        perLine = 6;
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f0300a6, this, true);
        float f = (float)ew.a(getContext()) / 320F;
        line_1_container = findViewById(0x7f0c0288);
        line_2_container = findViewById(0x7f0c028a);
        line1 = (ModuleStyleOnePageViewLine)findViewById(0x7f0c0289);
        line2 = (ModuleStyleOnePageViewLine)findViewById(0x7f0c028b);
        line_1_container.getLayoutParams();
        context = (android.widget.FrameLayout.LayoutParams)line1.getLayoutParams();
        context = (android.widget.FrameLayout.LayoutParams)line_2_container.getLayoutParams();
        int i = ((android.widget.FrameLayout.LayoutParams) (context)).topMargin;
        displayHeight = ((android.widget.FrameLayout.LayoutParams) (context)).height + i;
    }

    public void clear()
    {
        line1.clear();
        line2.clear();
    }

    public int getDisplayHeight()
    {
        return displayHeight;
    }

    public void setItemData(int i, TResInfo tresinfo, boolean flag)
    {
        if (i < 6)
        {
            try
            {
                line1.setItemData(i, tresinfo, flag);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (TResInfo tresinfo)
            {
                return;
            }
        }
        line2.setItemData(i - 6, tresinfo, flag);
        return;
    }

    public void setItemSelect(TResInfo tresinfo, boolean flag)
    {
        line1.setItemSelect(tresinfo, flag);
        line2.setItemSelect(tresinfo, flag);
    }

    public void setItemSelectListener(mi mi)
    {
        listener = mi;
        line1.setItemSelectListener(mi);
        line2.setItemSelectListener(mi);
    }
}
