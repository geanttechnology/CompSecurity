// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.groupon.models.category.Category;

// Referenced classes of package com.groupon.activity:
//            Categories

protected class Adapter extends Adapter
{

    final Categories this$0;

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        viewgroup = view;
        if (view == null)
        {
            viewgroup = inflater.inflate(0x7f03005f, null);
        }
        view = (TextView)viewgroup.findViewById(0x7f100188);
        Category category = getItem(i);
        if (category == null)
        {
            view.setText(0x7f08005e);
            return viewgroup;
        } else
        {
            view.setText(category.name);
            return viewgroup;
        }
    }

    public Adapter(Context context)
    {
        this$0 = Categories.this;
        super(Categories.this, context);
    }
}
