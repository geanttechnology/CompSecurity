// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.cyberlink.you.BaseActivity;
import com.cyberlink.you.l;
import com.cyberlink.you.o;
import com.cyberlink.you.p;
import com.cyberlink.you.utility.ULogUtility;
import com.cyberlink.you.utility.d;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;

public class LogBrowserActivity extends BaseActivity
{

    com.cyberlink.you.utility.ULogUtility.LogType a;
    String b;
    private android.view.View.OnClickListener c;
    private android.widget.AdapterView.OnItemClickListener d;

    public LogBrowserActivity()
    {
        a = com.cyberlink.you.utility.ULogUtility.LogType.a;
        b = null;
        c = new android.view.View.OnClickListener() {

            final LogBrowserActivity a;

            public void onClick(View view)
            {
                a.finish();
            }

            
            {
                a = LogBrowserActivity.this;
                super();
            }
        };
        d = new android.widget.AdapterView.OnItemClickListener() {

            final LogBrowserActivity a;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                File file;
                view = new Intent("android.intent.action.VIEW");
                file = (File)adapterview.getItemAtPosition(i);
                if (a.a != com.cyberlink.you.utility.ULogUtility.LogType.a) goto _L2; else goto _L1
_L1:
                adapterview = ULogUtility.j(false);
_L3:
                adapterview = new File(adapterview, file.getName());
                com.cyberlink.you.utility.d.a(file.toString(), adapterview.toString());
                MediaScannerConnection.scanFile(a.a(), new String[] {
                    adapterview.toString()
                }, null, null);
                view.setDataAndType(Uri.fromFile(adapterview), "text/plain");
                a.startActivity(view);
                return;
_L2:
label0:
                {
                    if (a.a != com.cyberlink.you.utility.ULogUtility.LogType.c)
                    {
                        break label0;
                    }
                    adapterview = ULogUtility.l(false);
                }
                  goto _L3
label1:
                {
                    if (a.a != com.cyberlink.you.utility.ULogUtility.LogType.d)
                    {
                        break label1;
                    }
                    adapterview = ULogUtility.m(false);
                }
                  goto _L3
label2:
                {
                    if (a.a != com.cyberlink.you.utility.ULogUtility.LogType.e)
                    {
                        break label2;
                    }
                    adapterview = ULogUtility.n(false);
                }
                  goto _L3
label3:
                {
                    if (a.a != com.cyberlink.you.utility.ULogUtility.LogType.f)
                    {
                        break label3;
                    }
                    adapterview = ULogUtility.o(false);
                }
                  goto _L3
label4:
                {
                    if (a.a != com.cyberlink.you.utility.ULogUtility.LogType.g)
                    {
                        break label4;
                    }
                    adapterview = ULogUtility.p(false);
                }
                  goto _L3
label5:
                {
                    if (a.a != com.cyberlink.you.utility.ULogUtility.LogType.i)
                    {
                        break label5;
                    }
                    adapterview = ULogUtility.r(false);
                }
                  goto _L3
                try
                {
                    adapterview = ULogUtility.k(false);
                }
                // Misplaced declaration of an exception variable
                catch (AdapterView adapterview)
                {
                    if (adapterview != null)
                    {
                        com.cyberlink.you.utility.d.a(a.a(), adapterview.toString());
                        adapterview.printStackTrace();
                    }
                    return;
                }
                  goto _L3
            }

            
            {
                a = LogBrowserActivity.this;
                super();
            }
        };
    }

    private void b()
    {
        File afile[];
        ListView listview;
        if (a == com.cyberlink.you.utility.ULogUtility.LogType.a)
        {
            b = ULogUtility.j();
        } else
        if (a == com.cyberlink.you.utility.ULogUtility.LogType.c)
        {
            b = ULogUtility.l();
        } else
        if (a == com.cyberlink.you.utility.ULogUtility.LogType.d)
        {
            b = ULogUtility.m();
        } else
        if (a == com.cyberlink.you.utility.ULogUtility.LogType.e)
        {
            b = ULogUtility.n();
        } else
        if (a == com.cyberlink.you.utility.ULogUtility.LogType.f)
        {
            b = ULogUtility.o();
        } else
        if (a == com.cyberlink.you.utility.ULogUtility.LogType.g)
        {
            b = ULogUtility.p();
        } else
        if (a == com.cyberlink.you.utility.ULogUtility.LogType.h)
        {
            b = ULogUtility.q();
        } else
        if (a == com.cyberlink.you.utility.ULogUtility.LogType.i)
        {
            b = ULogUtility.r();
        } else
        {
            b = ULogUtility.k();
        }
        afile = (new File(b)).listFiles();
        Arrays.sort(afile, Collections.reverseOrder());
        listview = (ListView)findViewById(o.LogBrowserFileListView);
        listview.setAdapter(new ArrayAdapter(a(), 0x1090003, afile) {

            final LogBrowserActivity a;

            public View getView(int i, View view, ViewGroup viewgroup)
            {
                View view1;
                if (view == null)
                {
                    view1 = ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x1090003, null);
                    view = (TextView)view1.findViewById(0x1020014);
                    view.setTextColor(a.a().getResources().getColor(l.you_color_normal));
                    view1.setTag(view);
                    viewgroup = view;
                } else
                {
                    viewgroup = (TextView)view.getTag();
                    view1 = view;
                }
                viewgroup.setText(((File)getItem(i)).getName());
                return view1;
            }

            
            {
                a = LogBrowserActivity.this;
                super(context, i, afile);
            }
        });
        listview.setOnItemClickListener(d);
    }

    public Activity a()
    {
        return this;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(p.u_activity_log_browser);
        findViewById(o.LogBrowserBackBtn).setOnClickListener(c);
        bundle = getIntent().getExtras();
        if (bundle != null)
        {
            bundle = bundle.getString("type");
            if (bundle != null)
            {
                a = com.cyberlink.you.utility.ULogUtility.LogType.valueOf(bundle);
                ((TextView)findViewById(o.LogBrowserTopBarTitle)).setText(bundle);
            }
        }
        b();
    }
}
