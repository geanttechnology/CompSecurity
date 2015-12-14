// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.app.Dialog;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import com.cyberlink.beautycircle.g;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.a;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            RegisterActivity

class a
    implements android.view.
{

    final RegisterActivity a;

    public void onClick(View view)
    {
        view = new Dialog(a);
        view.requestWindowFeature(1);
        view.setContentView(k.bc_dialog_share_to_opt);
        view.findViewById(j.itemMore).setVisibility(8);
        ((TextView)view.findViewById(j.bc_dialog_desc)).setText(m.bc_register_more);
        com.cyberlink.beautycircle.controller.adapter.j j1 = new com.cyberlink.beautycircle.controller.adapter.j(a);
        ListView listview = (ListView)view.findViewById(j.content_list);
        listview.setAdapter(j1);
        listview.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener(view, j1) {

            final Dialog a;
            final com.cyberlink.beautycircle.controller.adapter.j b;
            final RegisterActivity._cls20 c;

            public void onItemClick(AdapterView adapterview, View view1, int i, long l)
            {
                a.dismiss();
                adapterview = (a)b.getItem(i);
                if (((a) (adapterview)).b == m.bc_register_fb)
                {
                    com.cyberlink.beautycircle.controller.activity.RegisterActivity.j(c.a).onClick(view1);
                } else
                {
                    if (((a) (adapterview)).b == m.bc_register_twitter)
                    {
                        com.cyberlink.beautycircle.controller.activity.RegisterActivity.k(c.a);
                        return;
                    }
                    if (((a) (adapterview)).b == m.bc_register_weibo)
                    {
                        com.cyberlink.beautycircle.controller.activity.RegisterActivity.a(c.a);
                        return;
                    }
                    if (((a) (adapterview)).b == m.bc_register_qq)
                    {
                        RegisterActivity.l(c.a);
                        return;
                    }
                    if (((a) (adapterview)).b == m.bc_register_wechat)
                    {
                        RegisterActivity.b(c.a);
                        return;
                    }
                }
            }

            
            {
                c = RegisterActivity._cls20.this;
                a = dialog;
                b = j1;
                super();
            }
        });
        view.getWindow().setBackgroundDrawableResource(g.bc_color_transparent);
        view.show();
    }

    _cls1.b(RegisterActivity registeractivity)
    {
        a = registeractivity;
        super();
    }
}
