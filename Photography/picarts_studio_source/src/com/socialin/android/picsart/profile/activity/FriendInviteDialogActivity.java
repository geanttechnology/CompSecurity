// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.b;
import com.bumptech.glide.j;
import com.bumptech.glide.k;
import com.bumptech.glide.load.engine.l;
import com.bumptech.glide.request.e;
import com.facebook.share.widget.AppInviteDialog;
import com.socialin.android.apiv3.model.ImageItem;
import com.socialin.android.facebook.util.FacebookUtils;
import io.branch.referral.g;
import io.branch.referral.m;
import myobfuscated.cy.d;

// Referenced classes of package com.socialin.android.picsart.profile.activity:
//            BottomBaseActivity

public class FriendInviteDialogActivity extends BottomBaseActivity
    implements android.view.View.OnClickListener
{

    private Bundle a;

    public FriendInviteDialogActivity()
    {
    }

    public void onClick(View view)
    {
        if (view.getId() == 0x7f1004ff)
        {
            view = (ImageItem)a.getParcelable("item");
            long l1;
            if (view != null)
            {
                l1 = ((ImageItem) (view)).id;
            } else
            {
                l1 = -1L;
            }
            d.a(this, "facebook_invite", "facebook_app_invite", l1, new g(view) {

                private ImageItem a;
                private FriendInviteDialogActivity b;

                public final void a(String s, m m)
                {
                    FacebookUtils.openInviteFriendChooser(b, a, s);
                }

            
            {
                b = FriendInviteDialogActivity.this;
                a = imageitem;
                super();
            }
            });
        } else
        if (view.getId() == 0x7f1004fb || view.getId() == 0x7f1004fe)
        {
            a(this, 0x7f1004f9);
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0300f7);
        a = getIntent().getExtras();
        Object obj;
        String s;
        if (a != null)
        {
            bundle = (ImageItem)a.getParcelable("item");
        } else
        {
            bundle = null;
        }
        if (!AppInviteDialog.canShow() || a == null || !a.getBoolean("from_urls", false) || bundle == null)
        {
            finish();
            return;
        }
        obj = (TextView)findViewById(0x7f1004fa);
        s = a.getString("contest_item");
        if (TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        if (!"freetoedit.invite".equals(s)) goto _L4; else goto _L3
_L3:
        ((TextView) (obj)).setText(getString(0x7f08026e));
_L2:
        findViewById(0x7f1004ff).setOnClickListener(this);
        findViewById(0x7f1004fe).setOnClickListener(this);
        findViewById(0x7f1004fb).setOnClickListener(this);
        obj = (ImageView)findViewById(0x7f1004fc);
        b.a(this).i().a(0.1F).a(bundle.getMidleUrl()).a(e.b(l.e)).a(((ImageView) (obj)));
        a();
        return;
_L4:
        if ("contest.invite".equals(s))
        {
            ((TextView) (obj)).setText(getString(0x7f080268));
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (motionevent.getAction() == 4)
        {
            a(this, 0x7f1004f9);
        }
        return true;
    }
}
