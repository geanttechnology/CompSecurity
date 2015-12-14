// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.bx;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import com.bumptech.glide.b;
import com.bumptech.glide.j;
import com.bumptech.glide.k;
import com.bumptech.glide.load.engine.l;
import com.bumptech.glide.request.e;
import com.socialin.android.instagram.c;
import java.util.List;

public final class a extends ArrayAdapter
{

    public Context a;
    public int b;
    public int c;
    private ColorDrawable d;
    private ColorDrawable e;
    private e f;
    private j g;
    private LayoutInflater h;

    public a(Context context, List list, int i)
    {
        super(context, 0x7f030138, list);
        a = null;
        c = 3;
        d = new ColorDrawable(Color.parseColor("#EFEFEF"));
        e = new ColorDrawable(Color.parseColor("#DEDEDE"));
        h = null;
        a = context;
        b = i;
        h = LayoutInflater.from(context);
        f = (e)((e)((e)com.bumptech.glide.request.e.c(context).a(l.a)).b()).a(android.graphics.Bitmap.CompressFormat.PNG);
        g = com.bumptech.glide.b.b(context).i().a(0.6F).a(f);
    }

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        ImageView imageview;
        if (view == null)
        {
            view = h.inflate(0x7f030138, viewgroup, false);
        }
        imageview = (ImageView)view.findViewById(0x7f100687);
        viewgroup = (android.widget.RelativeLayout.LayoutParams)imageview.getLayoutParams();
        viewgroup.width = b;
        viewgroup.height = b;
        imageview.setLayoutParams(viewgroup);
        if (c % 2 == 1)
        {
            if (i % 2 == 0)
            {
                viewgroup = e;
            } else
            {
                viewgroup = d;
            }
            imageview.setBackgroundDrawable(viewgroup);
        } else
        if ((i / c) % 2 == 0)
        {
            if (i % 2 == 0)
            {
                viewgroup = e;
            } else
            {
                viewgroup = d;
            }
            imageview.setBackgroundDrawable(viewgroup);
        } else
        {
            if (i % 2 == 0)
            {
                viewgroup = d;
            } else
            {
                viewgroup = e;
            }
            imageview.setBackgroundDrawable(viewgroup);
        }
        viewgroup = (c)getItem(i);
        g.a(((c) (viewgroup)).b).a(imageview);
        return view;
    }
}
