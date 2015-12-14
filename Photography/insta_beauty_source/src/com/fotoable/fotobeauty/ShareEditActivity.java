// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotobeauty;

import acf;
import acg;
import ach;
import aci;
import acj;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import bka;
import com.wantu.service.net.ShareAsyncTask;
import java.io.File;
import java.util.Timer;

// Referenced classes of package com.fotoable.fotobeauty:
//            FullscreenActivity

public class ShareEditActivity extends FullscreenActivity
{

    private TextView a;
    private EditText b;
    private String c;
    private Button d;
    private CheckBox e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private String p;
    private Resources q;

    public ShareEditActivity()
    {
    }

    private int a(String s)
    {
        int i1 = 0;
        if (s == null)
        {
            return 0;
        }
        int k1 = s.length();
        int j1 = 0;
        while (j1 < k1) 
        {
            if (s.charAt(j1) > '\377')
            {
                i1 += 2;
            } else
            {
                i1++;
            }
            j1++;
        }
        return (int)Math.ceil(i1 / 2);
    }

    private void a()
    {
        showDialog(1);
    }

    public static void a(ShareEditActivity shareeditactivity)
    {
        shareeditactivity.g();
    }

    private void a(Boolean boolean1)
    {
    }

    public static String b(ShareEditActivity shareeditactivity)
    {
        return shareeditactivity.i;
    }

    private void b()
    {
        removeDialog(1);
    }

    public static EditText c(ShareEditActivity shareeditactivity)
    {
        return shareeditactivity.b;
    }

    private void c()
    {
        q = getResources();
        f = q.getString(0x7f060240);
        g = q.getString(0x7f06023f);
        h = q.getString(0x7f06023e);
        i = q.getString(0x7f06023d);
        j = q.getString(0x7f06023c);
        k = q.getString(0x7f06023b);
        l = q.getString(0x7f06023a);
        m = q.getString(0x7f060239);
        n = q.getString(0x7f060238);
        o = q.getString(0x7f060237);
        p = (new StringBuilder()).append("  ").append(q.getString(0x7f060236)).toString();
    }

    public static String d(ShareEditActivity shareeditactivity)
    {
        return shareeditactivity.n;
    }

    private void d()
    {
        (new ach(this, this)).execute(new String[0]);
    }

    public static String e(ShareEditActivity shareeditactivity)
    {
        return shareeditactivity.o;
    }

    private void e()
    {
        (new acj(this, this)).execute(new String[0]);
    }

    public static String f(ShareEditActivity shareeditactivity)
    {
        return shareeditactivity.j;
    }

    private void f()
    {
        (new aci(this, this)).execute(new String[0]);
        (new ShareAsyncTask(this, com.wantu.service.net.ShareAsyncTask.Target.tencent, com.wantu.service.net.ShareAsyncTask.Type.gif)).execute(new String[0]);
    }

    public static String g(ShareEditActivity shareeditactivity)
    {
        return shareeditactivity.k;
    }

    private void g()
    {
        int i1 = a(b.getText().toString());
        if (i1 > 140) goto _L2; else goto _L1
_L1:
        int j1 = 140 - i1;
        i1 = j1;
        if (!d.isEnabled())
        {
            d.setEnabled(true);
            i1 = j1;
        }
_L4:
        a.setText(String.valueOf(i1));
        return;
_L2:
        int k1 = i1 - 140;
        a.setTextColor(0xffff0000);
        i1 = k1;
        if (d.isEnabled())
        {
            d.setEnabled(false);
            i1 = k1;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static void h(ShareEditActivity shareeditactivity)
    {
        shareeditactivity.b();
    }

    public static void i(ShareEditActivity shareeditactivity)
    {
        shareeditactivity.a();
    }

    public static Resources j(ShareEditActivity shareeditactivity)
    {
        return shareeditactivity.q;
    }

    public void backBtnClicked(View view)
    {
        finish();
    }

    public void nextBtnClicked(View view)
    {
        if (c.compareTo("renren") == 0)
        {
            a(Boolean.valueOf(e.isChecked()));
        }
        if (c.compareTo("sina") == 0)
        {
            e();
        }
        if (c.compareTo("qq") == 0)
        {
            f();
        }
        if (c.compareTo("facebook") == 0)
        {
            d();
        }
    }

    public void onChickBoxClicked(View view)
    {
        if (e.isChecked())
        {
            Toast.makeText(this, "\u82E5\u56FE\u7247\u4E0D\u7B26\u5408\u4EBA\u4EBA\u5934\u50CF\u89C4\u5B9A\uFF0C\u8BF7\u5173\u95ED\u8BE5\u9879", 0).show();
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0300c2);
        c();
        b = (EditText)findViewById(0x7f0d0315);
        bundle = getIntent();
        c = bundle.getStringExtra("com.wantu.android.weibo");
        d = (Button)findViewById(0x7f0d010b);
        d.setText(getResources().getString(0x7f060101));
        e = (CheckBox)findViewById(0x7f0d0312);
        if (c.compareTo("renren") == 0)
        {
            e.setVisibility(0);
        }
        if (bundle != null)
        {
            bundle = bundle.getStringExtra("share_tag");
            if (bundle != null && bundle.length() > 0)
            {
                p = bundle;
            }
        }
        int i1;
        long l1;
        try
        {
            bundle = bka.a();
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            Toast.makeText(getApplicationContext(), "Really Sorry, Share Data Exception!", 1).show();
            finish();
            return;
        }
        l1 = 0L;
        if (!bundle.d()) goto _L2; else goto _L1
_L1:
        l1 = bundle.b().length;
_L5:
        i1 = (int)l1 / 1000;
        ((TextView)findViewById(0x7f0d0311)).setText((new StringBuilder()).append(String.valueOf(i1)).append("k").toString());
        bundle = (TextView)findViewById(0x7f0d0034);
        if (c.compareTo("renren") != 0) goto _L4; else goto _L3
_L3:
        bundle.setText(g);
_L8:
        if (c.compareTo("facebook") == 0)
        {
            bundle.setText(getResources().getString(0x7f0602bc));
        }
        a = (TextView)findViewById(0x7f0d0314);
        b.setText(p);
        b.setSelection(1);
        g();
        b.addTextChangedListener(new acf(this));
        (new Timer()).schedule(new acg(this), 1000L);
        return;
_L2:
        bundle = new File(bundle.c());
        if (bundle.exists())
        {
            l1 = bundle.length();
        }
          goto _L5
_L4:
        if (c.compareTo("sina") != 0) goto _L7; else goto _L6
_L6:
        bundle.setText(f);
          goto _L8
_L7:
        if (c.compareTo("qq") != 0) goto _L8; else goto _L9
_L9:
        bundle.setText(h);
          goto _L8
    }

    protected Dialog onCreateDialog(int i1)
    {
        ProgressDialog progressdialog;
        switch (i1)
        {
        default:
            return null;

        case 1: // '\001'
            progressdialog = new ProgressDialog(this);
            break;
        }
        progressdialog.setMessage(i);
        progressdialog.setIndeterminate(true);
        progressdialog.setCancelable(false);
        return progressdialog;
    }
}
