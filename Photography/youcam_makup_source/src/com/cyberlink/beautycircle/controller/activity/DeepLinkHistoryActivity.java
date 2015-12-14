// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.m;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            DeepLinkActivity

public class DeepLinkHistoryActivity extends BaseActivity
{

    ArrayList e;

    public DeepLinkHistoryActivity()
    {
        e = null;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(k.bc_activity_history_deeplink);
        b(m.bc_developer_deeplink_history);
        bundle = (ListView)findViewById(j.bc_log_browser_list_view);
        ArrayList arraylist = DeepLinkActivity.e;
        bundle.setAdapter(new ArrayAdapter(this, k.bc_view_item_link_request, arraylist, arraylist) {

            final ArrayList a;
            final DeepLinkHistoryActivity b;

            public View getView(int i, View view, ViewGroup viewgroup)
            {
                viewgroup = view;
                if (view == null)
                {
                    viewgroup = ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(k.bc_view_item_link_request, new LinearLayout(getContext()));
                }
                ((TextView)viewgroup.findViewById(j.linkrequest_index)).setText((new StringBuilder()).append("#").append(i + 1).toString());
                view = (Uri)getItem(i);
                TextView textview = (TextView)viewgroup.findViewById(j.linkrequest_uri);
                if (textview != null)
                {
                    textview.setText(view.toString());
                }
                view = viewgroup.findViewById(j.linkrequest_panel);
                if (view != null)
                {
                    view.setTag(a.get(i));
                    view.setOnClickListener(new android.view.View.OnClickListener(this) {

                        final _cls1 a;

                        public void onClick(View view)
                        {
                            view = (Uri)view.getTag();
                            ((ClipboardManager)a.b.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, view.toString()));
                            Globals.a((new StringBuilder()).append("Copy DeepLink to Clipboard: ").append(view.toString()).toString());
                        }

            
            {
                a = _pcls1;
                super();
            }
                    });
                }
                return viewgroup;
            }

            
            {
                b = DeepLinkHistoryActivity.this;
                a = arraylist;
                super(context, i, list);
            }
        });
        bundle.setSelection(bundle.getCount() - 1);
    }
}
