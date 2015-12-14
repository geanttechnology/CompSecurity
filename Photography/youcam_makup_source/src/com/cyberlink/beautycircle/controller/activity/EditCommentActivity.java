// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.controller.fragment.TopBarFragment;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.network.NetworkPost;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.b;
import com.cyberlink.beautycircle.view.widgetpool.common.UICImageView;
import com.perfectcorp.utility.e;
import com.rockerhieu.emojicon.EmojiconEditText;
import org.json.JSONObject;

public class EditCommentActivity extends BaseActivity
{

    protected TextWatcher e;
    private UICImageView f;
    private EmojiconEditText g;
    private View h;
    private View i;
    private Uri j;
    private Long k;
    private String l;
    private JSONObject m;
    private android.view.View.OnClickListener n;
    private android.view.View.OnClickListener o;

    public EditCommentActivity()
    {
        f = null;
        g = null;
        h = null;
        i = null;
        j = null;
        k = null;
        l = null;
        m = null;
        e = new TextWatcher() {

            final EditCommentActivity a;

            public void afterTextChanged(Editable editable)
            {
                if (EditCommentActivity.a(a).getText().toString().length() == 0)
                {
                    com.cyberlink.beautycircle.controller.activity.EditCommentActivity.b(a).setEnabled(false);
                    return;
                } else
                {
                    com.cyberlink.beautycircle.controller.activity.EditCommentActivity.b(a).setEnabled(true);
                    return;
                }
            }

            public void beforeTextChanged(CharSequence charsequence, int i1, int j1, int k1)
            {
            }

            public void onTextChanged(CharSequence charsequence, int i1, int j1, int k1)
            {
            }

            
            {
                a = EditCommentActivity.this;
                super();
            }
        };
        n = new android.view.View.OnClickListener() {

            final EditCommentActivity a;

            public void onClick(View view)
            {
                a.i();
                view = EditCommentActivity.a(a).getText().toString();
                AccountManager.a(a, new b(this, view) {

                    final String a;
                    final _cls2 b;

                    public void a()
                    {
                        Globals.b("getAccountToken Fail");
                    }

                    public void a(String s)
                    {
                        b.a.k();
                        NetworkPost.a(s, EditCommentActivity.d(b.a), a, com.cyberlink.beautycircle.controller.activity.EditCommentActivity.e(b.a)).a(new com.perfectcorp.utility.m(this) {

                            final _cls1 a;

                            protected void a(int i1)
                            {
                                if (i1 != 523) goto _L2; else goto _L1
_L1:
                                String s = a.b.a.getResources().getString(m.bc_post_comment_you_blocked_toast);
                                com.perfectcorp.utility.e.a(a.b.a, s);
_L4:
                                a.b.a.l();
                                Globals.a(a.b.a.getResources().getString(m.bc_server_connect_fail));
                                com.perfectcorp.utility.e.e(new Object[] {
                                    "updateComment error: ", Integer.valueOf(i1)
                                });
                                return;
_L2:
                                if (i1 == 524)
                                {
                                    String s1 = a.b.a.getResources().getString(m.bc_post_comment_blocked_you_toast);
                                    com.perfectcorp.utility.e.a(a.b.a, s1);
                                }
                                if (true) goto _L4; else goto _L3
_L3:
                            }

                            protected void a(Void void1)
                            {
                                a.b.a.l();
                                void1 = new Intent();
                                a.b.a.setResult(-1, void1);
                                EditCommentActivity.c(a.b.a);
                            }

                            protected void b(Object obj)
                            {
                                a((Void)obj);
                            }

            
            {
                a = _pcls1;
                super();
            }
                        });
                    }

                    public void b()
                    {
                        Globals.b("getAccountToken Cancel");
                    }

            
            {
                b = _pcls2;
                a = s;
                super();
            }
                });
            }

            
            {
                a = EditCommentActivity.this;
                super();
            }
        };
        o = new android.view.View.OnClickListener() {

            final EditCommentActivity a;

            public void onClick(View view)
            {
                a.e();
            }

            
            {
                a = EditCommentActivity.this;
                super();
            }
        };
    }

    static EmojiconEditText a(EditCommentActivity editcommentactivity)
    {
        return editcommentactivity.g;
    }

    static View b(EditCommentActivity editcommentactivity)
    {
        return editcommentactivity.h;
    }

    static boolean c(EditCommentActivity editcommentactivity)
    {
        return editcommentactivity.BaseActivity.e();
    }

    static Long d(EditCommentActivity editcommentactivity)
    {
        return editcommentactivity.k;
    }

    static JSONObject e(EditCommentActivity editcommentactivity)
    {
        return editcommentactivity.m;
    }

    protected boolean e()
    {
        i();
        return super.e();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(k.bc_activity_edit_comment);
        bundle = getIntent();
        j = (Uri)bundle.getParcelableExtra("UserAvatarUri");
        k = Long.valueOf(bundle.getLongExtra("UserCommentId", 0L));
        l = bundle.getStringExtra("UserComment");
        f = (UICImageView)findViewById(j.comment_avatar);
        if (f != null)
        {
            f.setImageURI(j);
        }
        g = (EmojiconEditText)findViewById(j.edit_comment_text);
        if (g != null && l != null)
        {
            g.setText(l);
            g.addTextChangedListener(e);
        }
        h = findViewById(j.bc_edit_update);
        if (h != null)
        {
            h.setOnClickListener(n);
        }
        i = findViewById(j.bc_edit_cancel);
        if (i != null)
        {
            i.setOnClickListener(o);
        }
        b(m.bc_post_comment_menu_edit);
        b().a();
        g.requestFocus();
        getWindow().setSoftInputMode(5);
    }
}
