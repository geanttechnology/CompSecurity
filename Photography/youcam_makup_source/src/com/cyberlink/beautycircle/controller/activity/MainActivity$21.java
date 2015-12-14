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
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.g;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.a;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            MainActivity

class a
    implements android.view.ener
{

    final MainActivity a;

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
            final MainActivity._cls21 c;

            public void onItemClick(AdapterView adapterview, View view1, int i, long l)
            {
                a.dismiss();
                Globals.a();
                com.cyberlink.beautycircle.controller.activity.MainActivity.a(c.a, true);
                adapterview = (a)b.getItem(i);
                if (((a) (adapterview)).b == m.bc_register_fb)
                {
                    com.cyberlink.beautycircle.c.a(c.a, 0, 1, 0);
                } else
                {
                    if (((a) (adapterview)).b == m.bc_register_twitter)
                    {
                        com.cyberlink.beautycircle.c.a(c.a, 0, 3, 0);
                        return;
                    }
                    if (((a) (adapterview)).b == m.bc_register_weibo)
                    {
                        com.cyberlink.beautycircle.c.a(c.a, 0, 2, 0);
                        return;
                    }
                    if (((a) (adapterview)).b == m.bc_register_qq)
                    {
                        com.cyberlink.beautycircle.c.a(c.a, 0, 4, 0);
                        return;
                    }
                    if (((a) (adapterview)).b == m.bc_register_wechat)
                    {
                        com.cyberlink.beautycircle.c.a(c.a, 0, 5, 0);
                        return;
                    }
                }
            }

            
            {
                c = MainActivity._cls21.this;
                a = dialog;
                b = j1;
                super();
            }
        });
        view.getWindow().setBackgroundDrawableResource(g.bc_color_transparent);
        view.show();
    }

    _cls1.b(MainActivity mainactivity)
    {
        a = mainactivity;
        super();
    }
}
