// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.socialin.android.apiv3.model.ImageItem;
import com.socialin.android.constants.CommonConstants;
import com.socialin.android.facebook.p;
import com.socialin.android.facebook.util.FacebookUtils;
import com.socialin.android.picsart.profile.util.GalleryUtils;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.picsart.profile.activity:
//            BottomBaseActivity

public class ActionShareInfoActivity extends BottomBaseActivity
    implements android.view.View.OnClickListener, CommonConstants
{

    private SharedPreferences f;
    private ImageItem g;
    private String h;
    private String i;
    private String j;
    private String k;

    public ActionShareInfoActivity()
    {
    }

    static void a(ActionShareInfoActivity actionshareinfoactivity)
    {
        actionshareinfoactivity.b();
    }

    static String b(ActionShareInfoActivity actionshareinfoactivity)
    {
        return actionshareinfoactivity.i;
    }

    private void b()
    {
        if (f == null || f.getBoolean(i, true) && FacebookUtils.isSessionValid())
        {
            (new Thread() {

                private ActionShareInfoActivity a;

                public final void run()
                {
                    if (!"og.likes".equals(ActionShareInfoActivity.b(a)) || ActionShareInfoActivity.c(a) == null) goto _L2; else goto _L1
_L1:
                    ActionShareInfoActivity.d(a).edit().putBoolean("enable_fb_action_like", true).commit();
                    GalleryUtils.a(a, ActionShareInfoActivity.c(a), ActionShareInfoActivity.b(a));
_L4:
                    ActionShareInfoActivity.e(a);
                    return;
_L2:
                    if ("vote".equals(ActionShareInfoActivity.b(a)) && ActionShareInfoActivity.c(a) != null)
                    {
                        ActionShareInfoActivity.d(a).edit().putBoolean("enable_fb_action_vote", true).commit();
                        GalleryUtils.a(a, ActionShareInfoActivity.c(a), ActionShareInfoActivity.b(a));
                    }
                    if (true) goto _L4; else goto _L3
_L3:
                }

            
            {
                a = ActionShareInfoActivity.this;
                super();
            }
            }).start();
        }
    }

    static ImageItem c(ActionShareInfoActivity actionshareinfoactivity)
    {
        return actionshareinfoactivity.g;
    }

    private void c()
    {
        String s;
        byte byte0;
        s = i;
        byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 2: default 36
    //                   -1478067162: 61
    //                   3625706: 75;
           goto _L1 _L2 _L3
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_75;
_L4:
        switch (byte0)
        {
        default:
            return;

        case 0: // '\0'
            f.edit().putBoolean("like_accept", true).apply();
            return;

        case 1: // '\001'
            f.edit().putBoolean("vote_accept", true).apply();
            break;
        }
        break MISSING_BLOCK_LABEL_134;
_L2:
        if (s.equals("og.likes"))
        {
            byte0 = 0;
        }
          goto _L4
        if (s.equals("vote"))
        {
            byte0 = 1;
        }
          goto _L4
    }

    static SharedPreferences d(ActionShareInfoActivity actionshareinfoactivity)
    {
        return actionshareinfoactivity.f;
    }

    static void e(ActionShareInfoActivity actionshareinfoactivity)
    {
        actionshareinfoactivity.c();
    }

    public void onClick(View view)
    {
        int l = view.getId();
        if (l != 0x7f100125 || !"share_facebook".equals(h)) goto _L2; else goto _L1
_L1:
        if (!FacebookUtils.isSessionValid()) goto _L4; else goto _L3
_L3:
        if (!FacebookUtils.canIPost()) goto _L6; else goto _L5
_L5:
        b();
_L4:
        finish();
_L8:
        return;
_L6:
        FacebookUtils.approvePostAction(this, com.facebook.CallbackManager.Factory.create(), new p() {

            private ActionShareInfoActivity a;

            public final void a()
            {
                if (FacebookUtils.isSessionValid() && FacebookUtils.isUserConnected())
                {
                    ActionShareInfoActivity.a(a);
                    return;
                } else
                {
                    a.finish();
                    return;
                }
            }

            
            {
                a = ActionShareInfoActivity.this;
                super();
            }
        });
        return;
_L2:
        if (l == 0x7f100124 && "share_facebook".equals(h))
        {
            view = new Intent();
            view.setClassName(this, "com.socialin.android.preference.FBActionPreferencesActivity");
            view.putExtra("dialog_hide", true);
            startActivity(view);
            return;
        }
        if (l == 0x7f100122)
        {
            c();
            a(this, 0x7f100121);
            return;
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getIntent();
        if (bundle != null)
        {
            if (bundle.hasExtra("title"))
            {
                j = bundle.getStringExtra("title");
            }
            if (bundle.hasExtra("message"))
            {
                k = bundle.getStringExtra("message");
            }
            if (bundle.hasExtra("item"))
            {
                g = (ImageItem)bundle.getParcelableExtra("item");
            }
            if (bundle.hasExtra("send_to"))
            {
                h = bundle.getStringExtra("send_to");
            }
            if (bundle.hasExtra("action"))
            {
                i = bundle.getStringExtra("action");
            }
        }
        a();
        setContentView(0x7f03001a);
        f = getSharedPreferences((new StringBuilder("sinPref_")).append(getString(m.e(this, "app_name_short"))).toString(), 0);
        ((TextView)findViewById(0x7f1000f3)).setText(j);
        ((TextView)findViewById(0x7f100123)).setText(k);
        findViewById(0x7f100125).setOnClickListener(this);
        findViewById(0x7f100124).setOnClickListener(this);
        findViewById(0x7f100122).setOnClickListener(this);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (motionevent.getAction() == 4)
        {
            a(this, 0x7f100121);
        }
        return true;
    }
}
