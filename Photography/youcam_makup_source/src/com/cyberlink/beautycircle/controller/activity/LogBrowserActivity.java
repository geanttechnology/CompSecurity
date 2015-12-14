// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
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
import com.cyberlink.beautycircle.g;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.m;
import com.perfectcorp.utility.e;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LogBrowserActivity extends BaseActivity
{

    private Dialog e;
    private android.widget.AdapterView.OnItemClickListener f;

    public LogBrowserActivity()
    {
        e = null;
        f = new android.widget.AdapterView.OnItemClickListener() {

            final LogBrowserActivity a;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                view = new android.app.AlertDialog.Builder(a);
                String s = a.getResources().getString(m.bc_log_browser_dialog_email);
                String s1 = a.getResources().getString(m.bc_log_browser_dialog_local_browser);
                view.setTitle(m.bc_log_browser_dialog_title);
                adapterview = new android.content.DialogInterface.OnClickListener(this, adapterview, i) {

                    final AdapterView a;
                    final int b;
                    final _cls2 c;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        if (LogBrowserActivity.a(c.a) != null)
                        {
                            LogBrowserActivity.a(c.a).dismiss();
                            LogBrowserActivity.a(c.a, null);
                        }
                        if (i == 0)
                        {
                            LogBrowserActivity.a(c.a, a, b);
                        } else
                        if (i == 1)
                        {
                            LogBrowserActivity.b(c.a, a, b);
                            return;
                        }
                    }

            
            {
                c = _pcls2;
                a = adapterview;
                b = i;
                super();
            }
                };
                view.setSingleChoiceItems(new String[] {
                    s, s1
                }, -1, adapterview);
                LogBrowserActivity.a(a, view.show());
                Globals.a(LogBrowserActivity.a(a), a.getResources().getColor(g.bc_color_main_style));
            }

            
            {
                a = LogBrowserActivity.this;
                super();
            }
        };
    }

    static Dialog a(LogBrowserActivity logbrowseractivity)
    {
        return logbrowseractivity.e;
    }

    static Dialog a(LogBrowserActivity logbrowseractivity, Dialog dialog)
    {
        logbrowseractivity.e = dialog;
        return dialog;
    }

    private void a(AdapterView adapterview, int i)
    {
        try
        {
            adapterview = (File)adapterview.getItemAtPosition(i);
            ArrayList arraylist = new ArrayList();
            arraylist.add(adapterview);
            com.perfectcorp.utility.e.a(Globals.n(), arraylist);
            com.perfectcorp.utility.e.a(this);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (AdapterView adapterview)
        {
            return;
        }
    }

    static void a(LogBrowserActivity logbrowseractivity, AdapterView adapterview, int i)
    {
        logbrowseractivity.a(adapterview, i);
    }

    private void b(AdapterView adapterview, int i)
    {
        try
        {
            Intent intent = new Intent("android.intent.action.VIEW");
            adapterview = (File)adapterview.getItemAtPosition(i);
            File file = new File(com.perfectcorp.utility.e.a(false), adapterview.getName());
            b(adapterview.toString(), file.toString());
            MediaScannerConnection.scanFile(this, new String[] {
                file.toString()
            }, null, null);
            intent.setDataAndType(Uri.fromFile(file), "text/plain");
            startActivity(intent);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (AdapterView adapterview)
        {
            return;
        }
    }

    static void b(LogBrowserActivity logbrowseractivity, AdapterView adapterview, int i)
    {
        logbrowseractivity.b(adapterview, i);
    }

    public static boolean b(String s, String s1)
    {
        byte abyte0[];
        if (!Environment.getExternalStorageDirectory().canWrite())
        {
            break MISSING_BLOCK_LABEL_105;
        }
        s = new File(s);
        s1 = new File(s1);
        if (!s1.exists())
        {
            s1.createNewFile();
        }
        if (!s.exists())
        {
            break MISSING_BLOCK_LABEL_105;
        }
        s = new FileInputStream(s);
        s1 = new FileOutputStream(s1);
        abyte0 = new byte[1024];
_L1:
        int i = s.read(abyte0);
label0:
        {
            if (i <= 0)
            {
                break label0;
            }
            try
            {
                s1.write(abyte0, 0, i);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                return false;
            }
        }
          goto _L1
        s.close();
        s1.close();
        return true;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(k.bc_activity_log_browser);
        b(m.bc_developer_log_browser);
        bundle = (ListView)findViewById(j.bc_log_browser_list_view);
        File afile[] = (new File(com.perfectcorp.utility.e.a(true))).listFiles();
        Arrays.sort(afile, Collections.reverseOrder());
        bundle.setAdapter(new ArrayAdapter(this, 0x1090003, afile) {

            final LogBrowserActivity a;

            public View getView(int i, View view, ViewGroup viewgroup)
            {
                View view1;
                if (view == null)
                {
                    view1 = ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x1090003, new LinearLayout(getContext()));
                    view = (TextView)view1.findViewById(0x1020014);
                    view.setTextColor(a.getResources().getColor(g.bc_color_black));
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
        bundle.setOnItemClickListener(f);
    }
}
