// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.amazon.retailsearch.android.ui.listadapter.ModelView;
import com.amazon.retailsearch.android.ui.listadapter.ViewBuilderEntry;
import com.amazon.retailsearch.android.ui.results.layout.BorderType;
import com.amazon.retailsearch.android.ui.results.layout.model.ContentRowModel;
import java.util.Collections;
import java.util.List;

public class ContentRow extends LinearLayout
    implements ModelView
{

    private ContentRowModel model;

    public ContentRow(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    private void add(ViewBuilderEntry viewbuilderentry, int i, int j, int k)
    {
        View view;
        View view1;
        android.widget.LinearLayout.LayoutParams layoutparams;
        view1 = null;
        layoutparams = new android.widget.LinearLayout.LayoutParams(0, -1, 1.0F);
        if (i == 0)
        {
            j = 0;
        }
        layoutparams.setMargins(j, 0, 0, 0);
        view = view1;
        if (model == null) goto _L2; else goto _L1
_L1:
        int l;
        l = Math.min(Math.min(model.getContent().size(), model.getColumns()), getChildCount());
        j = i;
_L7:
        view = view1;
        if (j >= l) goto _L2; else goto _L3
_L3:
        if (((ViewBuilderEntry)model.getContent().get(j)).getType() != viewbuilderentry.getType()) goto _L5; else goto _L4
_L4:
        view1 = getChildAt(j);
        view = view1;
        if (j > i)
        {
            removeViewAt(j);
            addView(view1, i, layoutparams);
            Collections.swap(model.getContent(), i, j);
            view = view1;
        }
_L2:
        view1 = view;
        if (view != null)
        {
            break MISSING_BLOCK_LABEL_194;
        }
        view1 = viewbuilderentry.createView(this);
        if (view1 == null)
        {
            return;
        }
        break; /* Loop/switch isn't completed */
_L5:
        j++;
        if (true) goto _L7; else goto _L6
_L6:
        addView(view1, i, layoutparams);
        BorderType bordertype;
        if (i < k - 1)
        {
            bordertype = BorderType.RIGHT;
        } else
        {
            bordertype = BorderType.NONE;
        }
        view1.setBackgroundResource(bordertype.getResourceId());
        viewbuilderentry.buildView(view1);
        return;
    }

    public void build(ContentRowModel contentrowmodel)
    {
        if (contentrowmodel == model)
        {
            return;
        }
        int j = Math.min(contentrowmodel.getContent().size(), contentrowmodel.getColumns());
        int i;
        for (i = 0; i < j; i++)
        {
            add((ViewBuilderEntry)contentrowmodel.getContent().get(i), i, contentrowmodel.getSpacing(), contentrowmodel.getColumns());
        }

        if (getChildCount() > i)
        {
            removeViews(i, getChildCount() - i);
        }
        int l = contentrowmodel.getColumns() - getChildCount();
        if (l > 0)
        {
            FrameLayout framelayout = new FrameLayout(getContext());
            android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(0, -1, l);
            int i1 = contentrowmodel.getSpacing();
            int k = l;
            if (i == 0)
            {
                k = l - 1;
            }
            layoutparams.setMargins(i1 * k, 0, 0, 0);
            addView(framelayout, layoutparams);
        }
        model = contentrowmodel;
    }

    public volatile void build(Object obj)
    {
        build((ContentRowModel)obj);
    }

    public boolean onKeyUp(int i, KeyEvent keyevent)
    {
        for (int j = 0; j < getChildCount(); j++)
        {
            getChildAt(j).onKeyUp(i, keyevent);
        }

        return super.onKeyUp(i, keyevent);
    }
}
