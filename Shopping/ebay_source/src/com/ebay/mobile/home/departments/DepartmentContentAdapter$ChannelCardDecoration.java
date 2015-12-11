// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.departments;

import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import java.util.List;

// Referenced classes of package com.ebay.mobile.home.departments:
//            DepartmentContentAdapter

private class <init> extends android.support.v7.widget.ration
{

    final DepartmentContentAdapter this$0;

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerview, android.support.v7.widget.ration ration)
    {
        int i = recyclerview.getChildAdapterPosition(view);
        int j = DepartmentContentAdapter.access$100(DepartmentContentAdapter.this).getDimensionPixelSize(0x7f09007a);
        rect.left = j;
        rect.right = j;
        if (i == DepartmentContentAdapter.access$200(DepartmentContentAdapter.this).size() - 1)
        {
            rect.bottom = j;
        }
    }

    private ()
    {
        this$0 = DepartmentContentAdapter.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
