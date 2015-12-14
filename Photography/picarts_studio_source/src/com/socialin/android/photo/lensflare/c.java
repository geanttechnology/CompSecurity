// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.lensflare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.l;
import com.bumptech.glide.request.e;
import com.picsart.studio.d;
import com.socialin.android.apiv3.SocialinV3;

// Referenced classes of package com.socialin.android.photo.lensflare:
//            LensFlareFactory

final class c extends BaseAdapter
{

    private d a;
    private Context b;

    public c(Context context)
    {
        b = context;
        a = new d(context.getApplicationContext());
    }

    public final int getCount()
    {
        return LensFlareFactory.a();
    }

    public final Object getItem(int i)
    {
        return null;
    }

    public final long getItemId(int i)
    {
        return (long)i;
    }

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        if (view == null)
        {
            view = LayoutInflater.from(b).inflate(0x7f03014e, viewgroup, false);
        }
        view = (ImageView)view;
        viewgroup = (new StringBuilder()).append(LensFlareFactory.a(i)).append("_thumb.jpg").toString();
        viewgroup = (new StringBuilder()).append(SocialinV3.RESOURCE_URL).append("lensflare/icons/").append(viewgroup).toString();
        a.a(viewgroup, view, (e)e.b(l.e).a(0x7f020567));
        return view;
    }
}
