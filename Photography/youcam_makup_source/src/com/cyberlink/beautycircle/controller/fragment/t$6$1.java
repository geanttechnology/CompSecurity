// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.app.Dialog;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.controller.adapter.j;
import com.cyberlink.beautycircle.g;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.a;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            t

class b
    implements android.widget.rView.OnItemClickListener
{

    final Dialog a;
    final j b;
    final ctivity c;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        a.dismiss();
        adapterview = (a)b.getItem(i);
        if (((a) (adapterview)).b == m.bc_register_fb)
        {
            com.cyberlink.beautycircle.c.a(c.c.getActivity(), 0, 1, 0);
        } else
        {
            if (((a) (adapterview)).b == m.bc_register_twitter)
            {
                com.cyberlink.beautycircle.c.a(c.c.getActivity(), 0, 3, 0);
                return;
            }
            if (((a) (adapterview)).b == m.bc_register_weibo)
            {
                com.cyberlink.beautycircle.c.a(c.c.getActivity(), 0, 2, 0);
                return;
            }
            if (((a) (adapterview)).b == m.bc_register_qq)
            {
                com.cyberlink.beautycircle.c.a(c.c.getActivity(), 0, 4, 0);
                return;
            }
            if (((a) (adapterview)).b == m.bc_register_wechat)
            {
                com.cyberlink.beautycircle.c.a(c.c.getActivity(), 0, 5, 0);
                return;
            }
        }
    }

    ( , Dialog dialog, j j1)
    {
        c = ;
        a = dialog;
        b = j1;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/fragment/t$6

/* anonymous class */
    class t._cls6
        implements android.view.View.OnClickListener
    {

        final t a;

        public void onClick(View view)
        {
            view = new Dialog(a.getActivity());
            view.requestWindowFeature(1);
            view.setContentView(k.bc_dialog_share_to_opt);
            view.findViewById(com.cyberlink.beautycircle.j.itemMore).setVisibility(8);
            ((TextView)view.findViewById(com.cyberlink.beautycircle.j.bc_dialog_desc)).setText(m.bc_register_more);
            j j1 = new j(a.getActivity());
            ListView listview = (ListView)view.findViewById(com.cyberlink.beautycircle.j.content_list);
            listview.setAdapter(j1);
            listview.setOnItemClickListener(new t._cls6._cls1(this, view, j1));
            view.getWindow().setBackgroundDrawableResource(g.bc_color_transparent);
            view.show();
        }

            
            {
                a = t1;
                super();
            }
    }

}
