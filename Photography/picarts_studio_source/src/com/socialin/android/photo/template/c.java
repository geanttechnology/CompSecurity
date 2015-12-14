// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.template;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.picsart.collages.CollageCategoryItem;

// Referenced classes of package com.socialin.android.photo.template:
//            CustomTemplate, b

public final class c extends ArrayAdapter
{

    private b a;

    public c(b b1, Context context)
    {
        a = b1;
        super(context, 0);
    }

    public final int getCount()
    {
        return CustomTemplate.a.length;
    }

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        viewgroup = view;
        if (view == null)
        {
            viewgroup = LayoutInflater.from(a.getActivity()).inflate(0x7f03006b, null);
        }
        ((TextView)viewgroup.findViewById(0x7f10027b)).setText(((CollageCategoryItem)getItem(i)).a);
        if (b.a() == i)
        {
            viewgroup.setBackgroundResource(0x7f02055a);
            return viewgroup;
        } else
        {
            viewgroup.setBackgroundResource(0x7f02055b);
            return viewgroup;
        }
    }
}
