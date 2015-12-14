// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.controller.a.ap;
import com.cyberlink.beautycircle.controller.fragment.TopBarFragment;
import com.cyberlink.beautycircle.controller.fragment.x;
import com.cyberlink.beautycircle.controller.fragment.y;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.view.widgetpool.common.PostContentTextView;
import com.cyberlink.beautycircle.view.widgetpool.common.UICImageView;
import com.perfectcorp.a.b;
import com.rockerhieu.emojicon.EmojiconTextView;
import java.util.Locale;

public class AboutInfoActivity extends BaseActivity
{

    private UICImageView e;
    private EmojiconTextView f;
    private PostContentTextView g;
    private TextView h;
    private Uri i;
    private String j;
    private String k;
    private String l;
    private boolean m;
    private long n;

    public AboutInfoActivity()
    {
        e = null;
        f = null;
        g = null;
        h = null;
        i = null;
        j = null;
        k = null;
        l = null;
        m = false;
        n = -1L;
    }

    static long a(AboutInfoActivity aboutinfoactivity)
    {
        return aboutinfoactivity.n;
    }

    static String b(AboutInfoActivity aboutinfoactivity)
    {
        return aboutinfoactivity.l;
    }

    private void o()
    {
        byte byte0 = 0;
        String s = getResources().getString(m.bc_dialog_me_about_me);
        if (f != null && j != null)
        {
            f.setText(String.format(Locale.getDefault(), s, new Object[] {
                j
            }));
        }
        if (g != null && k != null)
        {
            g.setTextViewHTML(k);
        }
        if (h != null && l != null)
        {
            TextView textview = h;
            if (l.isEmpty())
            {
                byte0 = 8;
            }
            textview.setVisibility(byte0);
        }
        a(j);
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        if (j1 == -1)
        {
            String s = intent.getStringExtra("UserDisplayName");
            String s1 = intent.getStringExtra("UserAboutInfo");
            intent = intent.getStringExtra("UserWebSiteUrl");
            if (s != null)
            {
                j = s;
            }
            if (s1 != null)
            {
                k = s1;
            }
            if (intent != null)
            {
                l = intent;
            }
            if (s != null || s1 != null || intent != null)
            {
                o();
            }
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(k.bc_activity_about_info);
        bundle = getIntent();
        i = (Uri)bundle.getParcelableExtra("UserAvatarUri");
        j = bundle.getStringExtra("UserDisplayName");
        k = bundle.getStringExtra("UserAboutInfo");
        l = bundle.getStringExtra("UserWebSiteUrl");
        m = bundle.getBooleanExtra("UserMyAbout", false);
        n = bundle.getLongExtra("UserId", -1L);
        e = (UICImageView)findViewById(j.about_avatar);
        if (e != null && i != null)
        {
            e.setImageURI(i);
        }
        f = (EmojiconTextView)findViewById(j.about_displayname);
        g = (PostContentTextView)findViewById(j.about_description);
        h = (TextView)findViewById(j.about_website);
        if (h != null)
        {
            h.setOnClickListener(new android.view.View.OnClickListener() {

                final AboutInfoActivity a;

                public void onClick(View view)
                {
                    view = AccountManager.c();
                    if (AboutInfoActivity.a(a) != -1L && (view == null || AboutInfoActivity.a(a) != view.longValue()))
                    {
                        com.perfectcorp.a.b.a(new ap("click_about_url", null, Long.toString(AboutInfoActivity.a(a))));
                    }
                    c.a(a, com.cyberlink.beautycircle.controller.activity.AboutInfoActivity.b(a), 2);
                }

            
            {
                a = AboutInfoActivity.this;
                super();
            }
            });
        }
        c();
        if (m)
        {
            b().a(0xe2000000, x.a, 0, y.c);
        } else
        {
            b().a();
        }
        o();
    }

    public void onResume()
    {
        Long long1 = AccountManager.c();
        if (n != -1L && (long1 == null || n != long1.longValue()))
        {
            com.perfectcorp.a.b.a(new ap("show", "pageview_about", Long.toString(n)));
        }
        super.onResume();
    }

    public void onRightBtnClick(View view)
    {
        c.a(this, 3);
    }
}
