// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.model.Post;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.utility.p;
import com.cyberlink.beautycircle.view.widgetpool.common.UICImageView;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            v, u

class w
{

    public v a;
    public View b;
    final u c;
    private UICImageView d;
    private View e;
    private TextView f;
    private android.view.View.OnClickListener g;
    private android.view.View.OnClickListener h;

    public w(u u, Context context, ViewGroup viewgroup, v v1)
    {
        c = u;
        super();
        g = new android.view.View.OnClickListener() {

            final w a;

            public void onClick(View view)
            {
                if (a.a != null && a.a.a != null)
                {
                    com.cyberlink.beautycircle.c.a(a.c.getActivity(), a.a.a.id, com.cyberlink.beautycircle.model.MeTabItem.MeListMode.a);
                }
            }

            
            {
                a = w.this;
                super();
            }
        };
        h = new android.view.View.OnClickListener() {

            final w a;

            public void onClick(View view)
            {
                if (a.a != null && a.a.b != null)
                {
                    com.cyberlink.beautycircle.c.a(a.c.getActivity(), a.a.b.postId.longValue(), true, 0, null, null);
                }
            }

            
            {
                a = w.this;
                super();
            }
        };
        a = v1;
        b = ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(k.bc_view_master_item, viewgroup, false);
        b.setTag(Integer.valueOf(hashCode()));
        u = (TextView)b.findViewById(j.follow_text);
        p.a(u, u, v1.a, null);
        d = (UICImageView)b.findViewById(j.bc_master_cover);
        d.setOnClickListener(g);
        e = b.findViewById(j.bc_new_post_outter);
        f = (TextView)b.findViewById(j.bc_new_post);
        viewgroup.addView(b);
    }

    public void a()
    {
        if (a == null)
        {
            return;
        }
        if (a.a != null)
        {
            d.setImageURI(a.a.bgImageUrl);
        }
        if (a.b != null)
        {
            e.setVisibility(0);
            e.setOnClickListener(h);
            f.setText(a.b.title);
            return;
        } else
        {
            e.setVisibility(8);
            f.setText("");
            return;
        }
    }
}
