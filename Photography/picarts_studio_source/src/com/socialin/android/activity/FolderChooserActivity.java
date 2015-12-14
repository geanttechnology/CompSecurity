// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Environment;
import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import com.socialin.android.d;
import com.socialin.android.dialog.a;
import com.socialin.android.dialog.b;
import com.socialin.android.util.Utils;
import com.socialin.android.views.PredicateLayout;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.activity:
//            BaseActivity, b, a

public class FolderChooserActivity extends BaseActivity
{

    private String currentRoot;
    private com.socialin.android.activity.b listAdapter;

    public FolderChooserActivity()
    {
        listAdapter = null;
        currentRoot = "";
    }

    private void chooseFolder(String s)
    {
        int i = 0;
        String s1 = s;
        if (s != null)
        {
            s1 = s;
            if (s.endsWith("/"))
            {
                s1 = s.substring(0, s.length() - 1);
            }
        }
        Object obj1 = null;
        s = obj1;
        if (s1 != null)
        {
            try
            {
                s = getSubFolders(s1);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                d.a(s.getMessage(), s);
                s = obj1;
            }
        }
        listAdapter.clear();
        if (s != null)
        {
            for (int j = s.length; i < j; i++)
            {
                Object obj = s[i];
                listAdapter.add(obj);
            }

        }
        listAdapter.notifyDataSetChanged();
    }

    private String[] getSubFolders(String s)
    {
        File file = new File(s);
        if (!file.canRead())
        {
            throw new IOException();
        }
        PredicateLayout predicatelayout = (PredicateLayout)findViewById(0x7f1008b3);
        predicatelayout.removeAllViews();
        Object obj;
        TextView textview1;
        int j;
        if (s.startsWith("/"))
        {
            obj = s.substring(1);
        } else
        {
            obj = s;
        }
        obj = ((String) (obj)).split("/");
        j = obj.length;
        if (j > 1)
        {
            for (int i = 0; i < j - 1; i++)
            {
                TextView textview = new TextView(getApplicationContext());
                textview.setText(Html.fromHtml((new StringBuilder("<u>")).append(obj[i]).append("</u>").toString()));
                predicatelayout.addView(textview);
                textview.setTextSize(20F);
                textview.setTextColor(getResources().getColor(0x7f0f0030));
                textview.setOnClickListener(new android.view.View.OnClickListener(i) {

                    private int a;
                    private FolderChooserActivity b;

                    public final void onClick(View view)
                    {
                        String as[] = b.currentRoot.split("/");
                        view = "";
                        for (int k = 0; k <= a + 1; k++)
                        {
                            view = (new StringBuilder()).append(view).append(as[k]).append("/").toString();
                        }

                        b.chooseFolder(view);
                    }

            
            {
                b = FolderChooserActivity.this;
                a = i;
                super();
            }
                });
                textview = new TextView(getApplicationContext());
                textview.setText("/");
                textview.setTextColor(getResources().getColor(0x7f0f0030));
                textview.setTextSize(20F);
                predicatelayout.addView(textview);
            }

        }
        textview1 = new TextView(getApplicationContext());
        textview1.setText(obj[j - 1]);
        predicatelayout.addView(textview1);
        textview1.setTextSize(20F);
        textview1.setTextColor(-1);
        obj = new TextView(getApplicationContext());
        ((TextView) (obj)).setText("/");
        ((TextView) (obj)).setTextSize(20F);
        predicatelayout.addView(((View) (obj)));
        predicatelayout.invalidate();
        currentRoot = s;
        s = file.list(new com.socialin.android.activity.a(this));
        if (s != null)
        {
            Arrays.sort(s, String.CASE_INSENSITIVE_ORDER);
            return s;
        } else
        {
            return new String[0];
        }
    }

    private void showNewFolderNameDialog()
    {
        b b1 = new b();
        b1.a = getString(0x7f080600);
        b1.f = 0x7f030213;
        b1.a(new android.view.View.OnClickListener() {

            private FolderChooserActivity a;

            public final void onClick(View view)
            {
                view = ((EditText)view.getRootView().findViewById(0x7f1009a7)).getText().toString().trim();
                File file = new File((new StringBuilder()).append(a.currentRoot).append("/").append(view).toString());
                if (!file.exists() && !file.mkdir())
                {
                    Utils.a(a, 0x7f0804a0);
                    return;
                } else
                {
                    a.chooseFolder((new StringBuilder()).append(a.currentRoot).append("/").append(view).toString());
                    return;
                }
            }

            
            {
                a = FolderChooserActivity.this;
                super();
            }
        }).a().show(getFragmentManager(), null);
    }

    protected void onCreate(Bundle bundle)
    {
        TextView textview;
        ListView listview;
        super.onCreate(bundle);
        setContentView(0x7f0301e4);
        textview = m.a(this);
        if (textview != null)
        {
            textview.setText(0x7f080606);
        }
        listview = (ListView)findViewById(0x7f1008b4);
        listAdapter = new com.socialin.android.activity.b(this, 0x7f0301e5);
        currentRoot = Environment.getExternalStorageDirectory().getAbsolutePath();
        bundle = getIntent();
        if (bundle.hasExtra("currentPath"))
        {
            bundle = bundle.getStringExtra("currentPath");
            if ((new File(bundle)).isDirectory())
            {
                currentRoot = bundle;
            }
        }
        bundle = null;
        String as[] = getSubFolders(currentRoot);
        bundle = as;
_L2:
        if (bundle != null)
        {
            int j = bundle.length;
            for (int i = 0; i < j; i++)
            {
                Object obj = bundle[i];
                listAdapter.add(obj);
            }

        }
        break; /* Loop/switch isn't completed */
        IOException ioexception;
        ioexception;
        d.a(ioexception.getMessage(), ioexception);
        if (true) goto _L2; else goto _L1
_L1:
        listview.setAdapter(listAdapter);
        listview.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            private FolderChooserActivity a;

            public final void onItemClick(AdapterView adapterview, View view, int k, long l)
            {
                int i1;
                adapterview = a.getSubFolders((new StringBuilder()).append(a.currentRoot).append("/").append((String)a.listAdapter.getItem(k)).toString());
                a.listAdapter.clear();
                i1 = adapterview.length;
                k = 0;
_L2:
                if (k >= i1)
                {
                    break; /* Loop/switch isn't completed */
                }
                view = adapterview[k];
                a.listAdapter.add(view);
                k++;
                if (true) goto _L2; else goto _L1
_L1:
                try
                {
                    a.listAdapter.notifyDataSetChanged();
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (AdapterView adapterview)
                {
                    Utils.a(a, 0x7f080296);
                }
                return;
            }

            
            {
                a = FolderChooserActivity.this;
                super();
            }
        });
        findViewById(0x7f1008b7).setOnClickListener(new android.view.View.OnClickListener() {

            private FolderChooserActivity a;

            public final void onClick(View view)
            {
                a.showNewFolderNameDialog();
            }

            
            {
                a = FolderChooserActivity.this;
                super();
            }
        });
        findViewById(0x7f1008b8).setOnClickListener(new android.view.View.OnClickListener() {

            private FolderChooserActivity a;

            public final void onClick(View view)
            {
                view = new Intent();
                view.putExtra("path", a.currentRoot);
                a.setResult(-1, view);
                a.finish();
            }

            
            {
                a = FolderChooserActivity.this;
                super();
            }
        });
        findViewById(0x7f1008b6).setOnClickListener(new android.view.View.OnClickListener() {

            private FolderChooserActivity a;

            public final void onClick(View view)
            {
                a.setResult(0);
                a.finish();
            }

            
            {
                a = FolderChooserActivity.this;
                super();
            }
        });
        bundle = getIntent();
        if (bundle.hasExtra("actionName"))
        {
            textview.setText(bundle.getStringExtra("actionName"));
        }
        return;
    }





}
