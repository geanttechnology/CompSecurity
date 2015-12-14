// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.cyberlink.you.database.StickerPackObj;
import com.cyberlink.you.database.n;
import com.cyberlink.you.o;
import com.cyberlink.you.p;
import com.cyberlink.you.r;
import com.cyberlink.you.utility.LoadImageUtils;
import java.util.List;

// Referenced classes of package com.cyberlink.you.activity:
//            w, u

class v extends ArrayAdapter
{

    final u a;

    public v(u u1, Context context, int i, List list)
    {
        a = u1;
        super(context, i, list);
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        StickerPackObj stickerpackobj;
        if (view == null)
        {
            view = ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(p.u_sticker_shop_item, viewgroup, false);
            viewgroup = new w(this, null);
            viewgroup.c = (TextView)view.findViewById(o.auther);
            viewgroup.d = (TextView)view.findViewById(o.name);
            viewgroup.e = (TextView)view.findViewById(o.text);
            viewgroup.a = (ImageView)view.findViewById(o.cover);
            viewgroup.b = (ImageView)view.findViewById(o.toDetail);
            viewgroup.f = view.findViewById(o.newIcon);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (w)view.getTag();
        }
        stickerpackobj = (StickerPackObj)getItem(i);
        if (stickerpackobj.i().b != null)
        {
            LoadImageUtils.a(getContext(), stickerpackobj, ((w) (viewgroup)).a, true, true);
        }
        ((w) (viewgroup)).c.setText(stickerpackobj.m());
        if (stickerpackobj.f() != null)
        {
            ((w) (viewgroup)).d.setText(stickerpackobj.f());
        }
        if (!stickerpackobj.e().equals("Free")) goto _L2; else goto _L1
_L1:
        ((w) (viewgroup)).e.setText(a.getResources().getString(r.u_free_tab));
_L4:
        ((w) (viewgroup)).b.setTag(stickerpackobj);
        if (u.a(a).equals("New"))
        {
            if (stickerpackobj.l() <= u.b())
            {
                break; /* Loop/switch isn't completed */
            }
            ((w) (viewgroup)).f.setVisibility(0);
        }
        return view;
_L2:
        if (stickerpackobj.e().equals("Share"))
        {
            ((w) (viewgroup)).e.setText(a.getResources().getString(r.u_menu_share));
        }
        if (true) goto _L4; else goto _L3
_L3:
        ((w) (viewgroup)).f.setVisibility(8);
        return view;
    }
}
