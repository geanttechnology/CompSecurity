// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.socialin.android.picsart.profile.util.GalleryUtils;
import java.util.List;

// Referenced classes of package com.socialin.android.picsart.profile.activity:
//            BlogActivity

final class a extends ArrayAdapter
{

    final BlogActivity a;
    private int b;

    public a(BlogActivity blogactivity, Context context, List list)
    {
        a = blogactivity;
        super(context, 0, 0, list);
        a();
    }

    public final void a()
    {
        b = a.getResources().getDisplayMetrics().widthPixels;
    }

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        viewgroup = view;
        if (view == null)
        {
            viewgroup = ((Activity)getContext()).getLayoutInflater().inflate(0x7f0301eb, null);
        }
        view = (ImageView)viewgroup.findViewById(0x7f1008d4);
        view.getLayoutParams().width = b;
        view.getLayoutParams().height = (int)((double)b / 1.7D);
        com.socialin.android.apiv3.model.BlogsResponse.Blog blog = (com.socialin.android.apiv3.model.BlogsResponse.Blog)getItem(i);
        viewgroup.findViewById(0x7f1008d3).setOnClickListener(new _cls1(blog, view));
        if (blog.created != null)
        {
            String s = GalleryUtils.a(blog.created, getContext());
            if (s != null)
            {
                ((TextView)viewgroup.findViewById(0x7f1008d5)).setText(s);
            }
        }
        TextView textview = (TextView)viewgroup.findViewById(0x7f1008d6);
        if (textview != null)
        {
            if (!TextUtils.isEmpty(blog.title))
            {
                textview.setVisibility(0);
                textview.setText(blog.title.toUpperCase());
            } else
            {
                textview.setVisibility(8);
            }
        }
        BlogActivity.a(a, view, blog, BlogActivity.b());
        return viewgroup;
    }

    /* member class not found */
    class _cls1 {}

}
