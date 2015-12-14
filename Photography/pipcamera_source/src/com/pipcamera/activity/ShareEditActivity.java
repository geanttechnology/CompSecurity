// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.wantu.service.net.ShareAsyncTask;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;
import rz;
import sa;
import uz;

// Referenced classes of package com.pipcamera.activity:
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
    private ProgressDialog r;

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
        q = getResources();
        f = q.getString(0x7f060218);
        g = q.getString(0x7f060217);
        h = q.getString(0x7f060216);
        i = q.getString(0x7f060215);
        j = q.getString(0x7f060214);
        k = q.getString(0x7f060213);
        l = q.getString(0x7f060212);
        m = q.getString(0x7f060211);
        n = q.getString(0x7f060210);
        o = q.getString(0x7f06020f);
        p = (new StringBuilder()).append("  ").append(q.getString(0x7f06020e)).toString();
    }

    static void a(ShareEditActivity shareeditactivity)
    {
        shareeditactivity.e();
    }

    public static String b(ShareEditActivity shareeditactivity)
    {
        return shareeditactivity.i;
    }

    private void b()
    {
        (new rz(this, this)).execute(new String[0]);
    }

    public static EditText c(ShareEditActivity shareeditactivity)
    {
        return shareeditactivity.b;
    }

    private void c()
    {
        r = new ProgressDialog(this);
        r.requestWindowFeature(1);
        r.setMessage(i);
        r.show();
    }

    public static String d(ShareEditActivity shareeditactivity)
    {
        return shareeditactivity.n;
    }

    private void d()
    {
        (new sa(this, this)).execute(new String[0]);
        (new ShareAsyncTask(this, com.wantu.service.net.ShareAsyncTask.Target.tencent, com.wantu.service.net.ShareAsyncTask.Type.gif)).execute(new String[0]);
    }

    public static String e(ShareEditActivity shareeditactivity)
    {
        return shareeditactivity.o;
    }

    private void e()
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

    public void backBtnClicked(View view)
    {
        finish();
    }

    public void nextBtnClicked(View view)
    {
        if (c.compareTo("sina") == 0)
        {
            c();
        }
        if (c.compareTo("qq") == 0)
        {
            d();
        }
        if (c.compareTo("facebook") == 0)
        {
            b();
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
        setContentView(0x7f030083);
        a();
        b = (EditText)findViewById(0x7f0c024a);
        c = getIntent().getStringExtra("com.wantu.android.weibo");
        d = (Button)findViewById(0x7f0c0080);
        d.setText(getResources().getString(0x7f0600ef));
        e = (CheckBox)findViewById(0x7f0c0247);
        if (c.compareTo("renren") == 0)
        {
            e.setVisibility(0);
        }
        bundle = uz.a();
        long l1 = 0L;
        int i1;
        if (bundle.e())
        {
            l1 = bundle.c().length;
        } else
        {
            bundle = new File(bundle.d());
            if (bundle.exists())
            {
                l1 = bundle.length();
            }
        }
        i1 = (int)l1 / 1000;
        ((TextView)findViewById(0x7f0c0246)).setText((new StringBuilder()).append(String.valueOf(i1)).append("k").toString());
        bundle = (TextView)findViewById(0x7f0c002d);
        if (c.compareTo("renren") == 0)
        {
            bundle.setText(g);
        } else
        if (c.compareTo("sina") == 0)
        {
            bundle.setText(f);
        } else
        if (c.compareTo("qq") == 0)
        {
            bundle.setText(h);
        }
        if (c.compareTo("facebook") == 0)
        {
            bundle.setText(getResources().getString(0x7f060282));
        }
        a = (TextView)findViewById(0x7f0c0249);
        b.setText(p);
        b.setSelection(1);
        e();
        b.addTextChangedListener(new TextWatcher() {

            final ShareEditActivity a;

            public void afterTextChanged(Editable editable)
            {
            }

            public void beforeTextChanged(CharSequence charsequence, int j1, int k1, int i2)
            {
            }

            public void onTextChanged(CharSequence charsequence, int j1, int k1, int i2)
            {
                ShareEditActivity.a(a);
            }

            
            {
                a = ShareEditActivity.this;
                super();
            }
        });
        (new Timer()).schedule(new TimerTask() {

            final ShareEditActivity a;

            public void run()
            {
                ShareEditActivity shareeditactivity = a;
                ShareEditActivity shareeditactivity1 = a;
                ((InputMethodManager)shareeditactivity.getSystemService("input_method")).toggleSoftInput(0, 2);
            }

            
            {
                a = ShareEditActivity.this;
                super();
            }
        }, 1000L);
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

    protected void onStart()
    {
        super.onStart();
    }

    protected void onStop()
    {
        super.onStop();
    }
}
