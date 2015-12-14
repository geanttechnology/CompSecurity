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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.i;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.network.NetworkManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ConnectionHistoryActivity extends BaseActivity
{

    ArrayList e;
    private android.widget.AdapterView.OnItemClickListener f;

    public ConnectionHistoryActivity()
    {
        e = null;
        f = new android.widget.AdapterView.OnItemClickListener() {

            final ConnectionHistoryActivity a;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                adapterview = (com.cyberlink.beautycircle.model.network.m)adapterview.getItemAtPosition(i);
                c.a(a, ((com.cyberlink.beautycircle.model.network.m) (adapterview)).a);
            }

            
            {
                a = ConnectionHistoryActivity.this;
                super();
            }
        };
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(k.bc_activity_connection_history);
        b(m.bc_developer_web_request_history);
        bundle = (ListView)findViewById(j.bc_log_browser_list_view);
        ArrayList arraylist = new ArrayList(NetworkManager.a());
        bundle.setAdapter(new ArrayAdapter(this, k.bc_view_item_connection, arraylist) {

            final ConnectionHistoryActivity a;

            public View getView(int l, View view, ViewGroup viewgroup)
            {
                long l1;
label0:
                {
                    viewgroup = view;
                    if (view == null)
                    {
                        viewgroup = ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(k.bc_view_item_connection, new LinearLayout(getContext()));
                    }
                    ((TextView)viewgroup.findViewById(j.connection_number)).setText((new StringBuilder()).append("#").append(l + 1).toString());
                    view = ((com.cyberlink.beautycircle.model.network.m)getItem(l)).a;
                    Object obj = (TextView)viewgroup.findViewById(j.connection_path);
                    if (obj != null)
                    {
                        ((TextView) (obj)).setText(view.getPath());
                    }
                    obj = (TextView)viewgroup.findViewById(j.connection_uri);
                    if (obj != null)
                    {
                        ((TextView) (obj)).setText(view.toString());
                    }
                    int i1 = ((com.cyberlink.beautycircle.model.network.m)getItem(l)).b;
                    obj = (TextView)viewgroup.findViewById(j.connection_response);
                    if (obj != null)
                    {
                        if (i1 == -1)
                        {
                            ((TextView) (obj)).setText("BAD");
                        } else
                        {
                            ((TextView) (obj)).setText(String.format(Locale.getDefault(), "%d", new Object[] {
                                Integer.valueOf(i1)
                            }));
                        }
                        if (i1 == 200)
                        {
                            ((TextView) (obj)).setBackgroundResource(i.bc_general_radius_production_background);
                        } else
                        {
                            ((TextView) (obj)).setBackgroundResource(i.bc_general_radius_demo_background);
                        }
                    }
                    obj = viewgroup.findViewById(j.connection_leftpanel);
                    if (obj != null)
                    {
                        ((View) (obj)).setTag(view);
                        ((View) (obj)).setOnClickListener(new android.view.View.OnClickListener(this) {

                            final _cls1 a;

                            public void onClick(View view)
                            {
                                view = (Uri)view.getTag();
                                ((ClipboardManager)a.a.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, view.toString()));
                                Globals.a((new StringBuilder()).append("Copy DeepLink to Clipboard: ").append(view.toString()).toString());
                            }

            
            {
                a = _pcls1;
                super();
            }
                        });
                    }
                    l1 = ((com.cyberlink.beautycircle.model.network.m)getItem(l)).c;
                    view = (TextView)viewgroup.findViewById(j.connection_duration);
                    if (view != null)
                    {
                        if (l1 != -1L)
                        {
                            break label0;
                        }
                        view.setText("BAD");
                    }
                    return viewgroup;
                }
                view.setText(String.format(Locale.getDefault(), " %.2f sec ", new Object[] {
                    Float.valueOf((float)l1 / 1000F)
                }));
                if (l1 > 3000L)
                {
                    view.setBackgroundColor(-256);
                    return viewgroup;
                } else
                {
                    view.setBackgroundColor(0);
                    return viewgroup;
                }
            }

            
            {
                a = ConnectionHistoryActivity.this;
                super(context, l, list);
            }
        });
        bundle.setOnItemClickListener(f);
        bundle.setSelection(bundle.getCount() - 1);
    }
}
