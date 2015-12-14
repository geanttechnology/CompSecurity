// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bumptech.glide.b;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.request.e;
import com.picsart.studio.d;
import com.picsart.studio.utils.DynamicHeightImageView;
import com.socialin.android.apiv3.model.ImageItem;
import com.socialin.android.picsart.profile.util.z;
import java.util.List;
import myobfuscated.bw.a;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.picsart.profile.activity:
//            MemboxItemsActivity, g

public final class f extends android.support.v7.widget.RecyclerView.Adapter
{

    List a;
    final MemboxItemsActivity b;
    private ColorDrawable c;
    private ColorDrawable d;

    public f(MemboxItemsActivity memboxitemsactivity, List list)
    {
        b = memboxitemsactivity;
        super();
        c = new ColorDrawable(Color.parseColor("#EFEFEF"));
        d = new ColorDrawable(Color.parseColor("#DEDEDE"));
        a = list;
    }

    public final ImageItem a(int i)
    {
        return (ImageItem)a.get(i);
    }

    public final void a()
    {
        if (a != null)
        {
            a.clear();
            notifyDataSetChanged();
        }
    }

    public final void b()
    {
        com.bumptech.glide.b.a(b.getApplicationContext()).a();
    }

    public final int getItemCount()
    {
        return a.size();
    }

    public final void onBindViewHolder(android.support.v7.widget.RecyclerView.ViewHolder viewholder, int i)
    {
        g g1;
        Object obj;
label0:
        {
            g1 = (g)viewholder;
            obj = g1.a;
            boolean flag;
            if (i % 2 == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (MemboxItemsActivity.f(b) % 2 == 1)
            {
                if (flag)
                {
                    break label0;
                }
                viewholder = c;
            } else
            if ((i / MemboxItemsActivity.f(b)) % 2 == 0)
            {
                if (flag)
                {
                    break label0;
                }
                viewholder = c;
            } else
            {
                if (!flag)
                {
                    break label0;
                }
                viewholder = c;
            }
        }
_L1:
        ((DynamicHeightImageView) (obj)).setBackgroundDrawable(viewholder);
        obj = a(i);
        if (obj == null)
        {
            viewholder = "";
        } else
        {
            viewholder = ((ImageItem) (obj)).getMidleUrl();
        }
        g1.a.setHeightRatio((float)((ImageItem) (obj)).height / (float)((ImageItem) (obj)).width);
        if (TextUtils.isEmpty(viewholder))
        {
            g1.a.setBackgroundColor(b.getResources().getColor(0x7f0f0095));
        } else
        {
            com.socialin.android.picsart.profile.activity.MemboxItemsActivity.e(b).a(viewholder, g1.a, (e)e.c(com.socialin.android.picsart.profile.activity.MemboxItemsActivity.e(b).a).a(DownsampleStrategy.d), null);
        }
        g1.a.setClickable(true);
        g1.a.setOnClickListener(new _cls1(((ImageItem) (obj))));
        if (b.a != null)
        {
            m.f().a(g1.b, b.a.a);
            g1.b.setTag(a(i));
        }
        return;
        viewholder = d;
          goto _L1
    }

    public final android.support.v7.widget.RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i)
    {
        return new g(b.getLayoutInflater().inflate(0x7f030162, viewgroup, false));
    }

    /* member class not found */
    class _cls1 {}

}
