// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.autoupdatesdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.autoupdatesdk.obf.ac;
import com.baidu.autoupdatesdk.obf.ag;

public class ConfirmDialoigActivity extends Activity
    implements android.view.View.OnClickListener
{

    public static final int ACTION_DOWNLOAD = 1;
    public static final int ACTION_DOWNLOAD_AS = 3;
    public static final int ACTION_INSTALL = 2;
    private static OnActionListener a;
    private TextView b;
    private TextView c;
    private TextView d;
    private Button e;
    private LinearLayout f;
    private TextView g;
    private TextView h;
    private int i;
    private String j;
    private String k;

    public ConfirmDialoigActivity()
    {
    }

    private void a()
    {
        b = (TextView)findViewById(ac.a(this, "txt_title"));
        c = (TextView)findViewById(ac.a(this, "txt_main_tip"));
        d = (TextView)findViewById(ac.a(this, "txt_minor_tip"));
        e = (Button)findViewById(ac.a(this, "btn_action_1"));
        f = (LinearLayout)findViewById(ac.a(this, "lin_other_btns"));
        g = (TextView)findViewById(ac.a(this, "txt_action_2"));
        h = (TextView)findViewById(ac.a(this, "txt_action_3"));
    }

    private void a(Configuration configuration)
    {
        int l = ag.f(this) - ag.a(this, 12F) * 2;
        if (configuration.orientation == 2)
        {
            configuration = getWindow().getAttributes();
            int i1 = ag.a(this, 80F);
            if (configuration == null)
            {
                configuration = new android.view.WindowManager.LayoutParams(l - i1 * 2, -2);
            } else
            {
                configuration.width = l - i1 * 2;
            }
            getWindow().setAttributes(configuration);
        } else
        if (configuration.orientation == 1)
        {
            configuration = getWindow().getAttributes();
            if (configuration == null)
            {
                configuration = new android.view.WindowManager.LayoutParams(l, -2);
            } else
            {
                configuration.width = l;
            }
            getWindow().setAttributes(configuration);
            return;
        }
    }

    private void b()
    {
        if (getIntent() != null)
        {
            i = getIntent().getIntExtra("intent_key_action", 0);
            j = getIntent().getStringExtra("intent_key_main_tip");
            k = getIntent().getStringExtra("intent_key_minor_tip");
        }
    }

    private void c()
    {
        if (i == 1)
        {
            b.setText(ac.b(this, "bdp_update_title_download"));
            e.setText(ac.b(this, "bdp_update_action_download"));
            f.setVisibility(0);
            g.setText(ac.b(this, "bdp_update_not_now"));
            h.setVisibility(0);
        } else
        if (i == 2)
        {
            b.setText(ac.b(this, "bdp_update_title_install"));
            e.setText(ac.b(this, "bdp_update_action_install"));
            f.setVisibility(8);
        } else
        if (i == 3)
        {
            b.setText(ac.b(this, "bdp_update_title_as"));
            e.setText(ac.b(this, "bdp_update_as_action_install"));
            f.setVisibility(0);
            g.setText(ac.b(this, "bdp_update_as_action_cancel"));
            h.setVisibility(8);
        } else
        {
            throw new RuntimeException((new StringBuilder()).append("Illegal Action: ").append(i).toString());
        }
        if (!TextUtils.isEmpty(j))
        {
            c.setText(j);
        }
        if (!TextUtils.isEmpty(k))
        {
            d.setText(Html.fromHtml(k));
        }
        e.setOnClickListener(this);
        g.setOnClickListener(this);
        h.setOnClickListener(this);
    }

    private void d()
    {
        if (a != null)
        {
            a.onClose();
        }
        finish();
    }

    public static void show(Context context, int l, String s, String s1, OnActionListener onactionlistener)
    {
        Intent intent = new Intent(context, com/baidu/autoupdatesdk/ConfirmDialoigActivity);
        intent.putExtra("intent_key_action", l);
        intent.putExtra("intent_key_main_tip", s);
        intent.putExtra("intent_key_minor_tip", s1);
        intent.setFlags(0x10000000);
        context.startActivity(intent);
        a = onactionlistener;
    }

    public void onBackPressed()
    {
        if (a != null)
        {
            a.onClose();
        }
        super.onBackPressed();
    }

    public void onClick(View view)
    {
        if (view == e)
        {
            if (a != null)
            {
                a.onAction();
            }
            d();
        } else
        {
            if (view == g)
            {
                d();
                return;
            }
            if (view == h)
            {
                if (a != null)
                {
                    a.onIgnoreUpdate();
                }
                d();
                return;
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        a(configuration);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            setFinishOnTouchOutside(false);
        }
        setContentView(ac.e(this, "bdp_update_activity_confirm_dialog"));
        a();
        b();
        c();
        a(getResources().getConfiguration());
    }

    private class OnActionListener
    {

        public abstract void onAction();

        public abstract void onClose();

        public abstract void onIgnoreUpdate();
    }

}
