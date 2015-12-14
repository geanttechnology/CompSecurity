// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.controller.a.p;
import com.cyberlink.beautycircle.controller.fragment.TopBarFragment;
import com.cyberlink.beautycircle.controller.fragment.x;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.cyberlink.beautycircle.view.widgetpool.common.i;
import com.perfectcorp.a.b;
import com.perfectcorp.utility.e;
import com.rockerhieu.emojicon.EmojiconEditText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EditFeedbackActivity extends BaseActivity
{

    EmojiconEditText e;
    TextView f;
    View g;
    private int h;
    private com.cyberlink.beautycircle.model.network.NetworkFeedback.FeedbackConfig i;
    private ArrayList j;
    private android.view.View.OnClickListener k;

    public EditFeedbackActivity()
    {
        e = null;
        f = null;
        h = 0;
        j = new ArrayList();
        k = new android.view.View.OnClickListener() {

            final EditFeedbackActivity a;

            public void onClick(View view)
            {
                DialogUtils.a(a, null, 48138);
            }

            
            {
                a = EditFeedbackActivity.this;
                super();
            }
        };
    }

    public static boolean f(String s)
    {
        if (s == null || s.isEmpty())
        {
            return false;
        } else
        {
            Globals.D().edit().putString("FeedbackEmail", s).apply();
            return true;
        }
    }

    public static String o()
    {
        return Globals.D().getString("FeedbackEmail", null);
    }

    private i p()
    {
        i l = new i(this, false);
        j.add(l);
        ViewGroup viewgroup = (ViewGroup)findViewById(j.edit_feedback_image_panel);
        viewgroup.addView(l.a(LayoutInflater.from(this), viewgroup, null));
        return l;
    }

    protected void onActivityResult(int l, int i1, Intent intent)
    {
        super.onActivityResult(l, i1, intent);
        if (l != 48138) goto _L2; else goto _L1
_L1:
        if (i1 != -1) goto _L4; else goto _L3
_L3:
        intent = intent.getData();
        p().a(intent, true);
_L6:
        return;
_L4:
        com.perfectcorp.utility.e.a(new Object[] {
            "User canceled PickFromGallery"
        });
        return;
_L2:
        if (l == 48160 && i1 == -1)
        {
            setResult(-1);
            e();
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(k.bc_activity_edit_feedback);
        bundle = getIntent();
        i = (com.cyberlink.beautycircle.model.network.NetworkFeedback.FeedbackConfig)bundle.getSerializableExtra("FeedbackConfig");
        h = bundle.getIntExtra("TopBarStyle", 0);
        if (h != 0)
        {
            b().a(h);
        }
        b(m.bc_feedback_edit_title);
        b().a(0xe4000000, x.a, x.d, 0);
        e = (EmojiconEditText)findViewById(j.edit_feedback_text);
        f = (TextView)findViewById(j.edit_feedback_email);
        g = findViewById(j.edit_feedback_image_btn);
        if (e != null)
        {
            String s = getResources().getString(m.bc_feedback_hint);
            bundle = s;
            if (i != null)
            {
                bundle = s;
                if (!i.bNeedLog)
                {
                    bundle = getResources().getString(m.bc_feedback_hint2);
                }
            }
            if (bundle != null)
            {
                String s1 = getResources().getString(m.app_name);
                e.setHint(String.format(Locale.getDefault(), bundle, new Object[] {
                    s1
                }));
            }
        }
        if (f == null) goto _L2; else goto _L1
_L1:
        bundle = o();
        if (bundle == null || bundle.isEmpty()) goto _L4; else goto _L3
_L3:
        f.setText(bundle);
_L2:
        if (g != null)
        {
            g.setOnClickListener(k);
        }
        return;
_L4:
        bundle = AccountManager.d();
        if (bundle != null && ((UserInfo) (bundle)).email != null && ((UserInfo) (bundle)).email.length() > 0)
        {
            f.setText(((UserInfo) (bundle)).email);
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    protected void onResume()
    {
        b.a(new p("pageview_edit"));
        super.onResume();
    }

    public void onRightBtnClick(View view)
    {
        b.a(new p("click_send"));
        if (e != null)
        {
            String s = e.getText().toString();
            view = s;
            if (s.isEmpty())
            {
                DialogUtils.a(this, m.bc_feedback_dialog_missing_description);
                return;
            }
        } else
        {
            view = null;
        }
        String s1;
        Object obj;
        if (f != null)
        {
            s1 = f.getText().toString();
            if (s1.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(s1).matches())
            {
                DialogUtils.a(this, m.bc_feedback_dialog_missing_email);
                return;
            }
            f(s1);
        } else
        {
            s1 = null;
        }
        if (j != null && !j.isEmpty())
        {
            ArrayList arraylist = new ArrayList();
            Iterator iterator = j.iterator();
            do
            {
                obj = arraylist;
                if (!iterator.hasNext())
                {
                    break;
                }
                obj = (i)iterator.next();
                if (obj != null && ((i) (obj)).c() != null)
                {
                    arraylist.add(((i) (obj)).c());
                }
            } while (true);
        } else
        {
            obj = null;
        }
        c.a(this, i, view, s1, ((ArrayList) (obj)), h);
    }
}
