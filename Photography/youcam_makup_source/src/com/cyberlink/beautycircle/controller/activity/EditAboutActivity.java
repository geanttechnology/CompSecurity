// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.controller.fragment.TopBarFragment;
import com.cyberlink.beautycircle.controller.fragment.x;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.model.network.NetworkUser;
import com.cyberlink.beautycircle.model.network.s;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.cyberlink.beautycircle.view.widgetpool.common.UICImageView;
import com.perfectcorp.utility.h;
import com.perfectcorp.utility.j;
import com.rockerhieu.emojicon.EmojiconEditText;
import java.io.File;
import java.util.ArrayList;

public class EditAboutActivity extends BaseActivity
{

    protected TextWatcher e;
    protected TextWatcher f;
    private int g;
    private UICImageView h;
    private EmojiconEditText i;
    private EmojiconEditText j;
    private EditText k;
    private TextView l;
    private String m;
    private String n;
    private android.view.View.OnClickListener o;
    private android.view.View.OnClickListener p;

    public EditAboutActivity()
    {
        g = 0;
        h = null;
        i = null;
        j = null;
        k = null;
        l = null;
        n = null;
        e = new TextWatcher() {

            final EditAboutActivity a;

            public void afterTextChanged(Editable editable)
            {
label0:
                {
                    if (com.cyberlink.beautycircle.controller.activity.EditAboutActivity.c(a) != null)
                    {
                        if (!com.cyberlink.beautycircle.controller.activity.EditAboutActivity.c(a).getText().toString().isEmpty())
                        {
                            break label0;
                        }
                        a.findViewById(com.cyberlink.beautycircle.j.edit_displayname_clear_button).setVisibility(4);
                    }
                    return;
                }
                a.findViewById(com.cyberlink.beautycircle.j.edit_displayname_clear_button).setVisibility(0);
            }

            public void beforeTextChanged(CharSequence charsequence, int i1, int j1, int k1)
            {
            }

            public void onTextChanged(CharSequence charsequence, int i1, int j1, int k1)
            {
            }

            
            {
                a = EditAboutActivity.this;
                super();
            }
        };
        o = new android.view.View.OnClickListener() {

            final EditAboutActivity a;

            public void onClick(View view)
            {
                EditAboutActivity.b(a, com.perfectcorp.utility.h.a(view.getContext()));
                DialogUtils.a(a, 48133, 48134, EditAboutActivity.g(a));
            }

            
            {
                a = EditAboutActivity.this;
                super();
            }
        };
        p = new android.view.View.OnClickListener() {

            final EditAboutActivity a;

            public void onClick(View view)
            {
                if (com.cyberlink.beautycircle.controller.activity.EditAboutActivity.c(a) != null)
                {
                    com.cyberlink.beautycircle.controller.activity.EditAboutActivity.c(a).setText("");
                }
            }

            
            {
                a = EditAboutActivity.this;
                super();
            }
        };
        f = new TextWatcher() {

            final EditAboutActivity a;

            public void afterTextChanged(Editable editable)
            {
                if (EditAboutActivity.d(a) != null && com.cyberlink.beautycircle.controller.activity.EditAboutActivity.h(a) != null)
                {
                    editable = EditAboutActivity.d(a).getText().toString();
                    com.cyberlink.beautycircle.controller.activity.EditAboutActivity.h(a).setText((new StringBuilder()).append(String.valueOf(editable.length())).append("/255").toString());
                }
            }

            public void beforeTextChanged(CharSequence charsequence, int i1, int j1, int k1)
            {
            }

            public void onTextChanged(CharSequence charsequence, int i1, int j1, int k1)
            {
            }

            
            {
                a = EditAboutActivity.this;
                super();
            }
        };
    }

    static int a(EditAboutActivity editaboutactivity)
    {
        return editaboutactivity.g;
    }

    static String a(EditAboutActivity editaboutactivity, String s)
    {
        editaboutactivity.n = s;
        return s;
    }

    private void a(int i1, String s, String s1, String s2, UserInfo userinfo)
    {
        if ((g == 1 || g == 8 || g == 6) && i1 != 48258)
        {
            (new LinearLayout(this)).setOrientation(1);
            (new android.widget.LinearLayout.LayoutParams(-1, -2)).setMargins(60, 0, 60, 0);
            DialogUtils.a(this, null, getResources().getString(m.bc_user_edit_cannot_go_back_message), getResources().getString(m.bc_dialog_button_skip), new Runnable(i1) {

                final int a;
                final EditAboutActivity b;

                public void run()
                {
                    Intent intent1 = new Intent();
                    b.setResult(a, intent1);
                    EditAboutActivity.i(b);
                    AccountManager.d(AccountManager.b());
                }

            
            {
                b = EditAboutActivity.this;
                a = i1;
                super();
            }
            }, getResources().getString(m.bc_dialog_button_continue), null);
            return;
        }
        Intent intent = new Intent();
        if (i1 == -1)
        {
            if (s != null)
            {
                intent.putExtra("UserDisplayName", s);
            }
            if (s1 != null)
            {
                intent.putExtra("UserAboutInfo", s1);
            }
            if (s2 != null)
            {
                intent.putExtra("UserWebSiteUrl", s2);
            }
            if (userinfo != null)
            {
                intent.putExtra("UserInfo", userinfo.toString());
            }
        }
        setResult(i1, intent);
        super.e();
    }

    static void a(EditAboutActivity editaboutactivity, int i1)
    {
        editaboutactivity.c(i1);
    }

    static void a(EditAboutActivity editaboutactivity, int i1, String s, String s1, String s2, UserInfo userinfo)
    {
        editaboutactivity.a(i1, s, s1, s2, userinfo);
    }

    private void a(boolean flag, boolean flag1, boolean flag2)
    {
        (new AsyncTask(flag, flag1, flag2) {

            final boolean a;
            final boolean b;
            final boolean c;
            final EditAboutActivity d;

            protected transient UserInfo a(Void avoid[])
            {
                avoid = AccountManager.d();
                if (avoid != null)
                {
                    String s = ((UserInfo) (avoid)).displayName;
                    if (s == null || s.isEmpty())
                    {
                        String s1 = AccountManager.e();
                        if (s1 != null && !s1.isEmpty())
                        {
                            avoid.displayName = s1.split("@")[0];
                        }
                    }
                }
                return avoid;
            }

            protected void a(UserInfo userinfo)
            {
                String s;
                if (a)
                {
                    Object obj = d;
                    if (userinfo != null && userinfo.displayName != null)
                    {
                        s = userinfo.displayName;
                    } else
                    {
                        s = "";
                    }
                    EditAboutActivity.a(((EditAboutActivity) (obj)), s);
                    com.cyberlink.beautycircle.controller.activity.EditAboutActivity.c(d).setText(EditAboutActivity.b(d));
                    if (EditAboutActivity.b(d).length() > 0)
                    {
                        com.cyberlink.beautycircle.controller.activity.EditAboutActivity.c(d).setHint(EditAboutActivity.b(d));
                    }
                }
                if (b)
                {
                    obj = EditAboutActivity.d(d);
                    if (userinfo != null && userinfo.description != null)
                    {
                        s = userinfo.description;
                    } else
                    {
                        s = "";
                    }
                    ((EmojiconEditText) (obj)).setText(s);
                }
                if (c && userinfo != null && userinfo.avatarUrl != null)
                {
                    EditAboutActivity.e(d).setImageURI(userinfo.avatarUrl);
                }
                if (userinfo != null && userinfo.websiteUrl != null)
                {
                    EditAboutActivity.f(d).setText(userinfo.websiteUrl);
                }
            }

            protected Object doInBackground(Object aobj[])
            {
                return a((Void[])aobj);
            }

            protected void onPostExecute(Object obj)
            {
                a((UserInfo)obj);
            }

            
            {
                d = EditAboutActivity.this;
                a = flag;
                b = flag1;
                c = flag2;
                super();
            }
        }).executeOnExecutor(j.q, new Void[0]);
    }

    static String b(EditAboutActivity editaboutactivity)
    {
        return editaboutactivity.n;
    }

    static String b(EditAboutActivity editaboutactivity, String s)
    {
        editaboutactivity.m = s;
        return s;
    }

    static EmojiconEditText c(EditAboutActivity editaboutactivity)
    {
        return editaboutactivity.i;
    }

    private void c(int i1)
    {
        a(i1, null, null, null, null);
    }

    static EmojiconEditText d(EditAboutActivity editaboutactivity)
    {
        return editaboutactivity.j;
    }

    static UICImageView e(EditAboutActivity editaboutactivity)
    {
        return editaboutactivity.h;
    }

    static EditText f(EditAboutActivity editaboutactivity)
    {
        return editaboutactivity.k;
    }

    static String g(EditAboutActivity editaboutactivity)
    {
        return editaboutactivity.m;
    }

    static TextView h(EditAboutActivity editaboutactivity)
    {
        return editaboutactivity.l;
    }

    static boolean i(EditAboutActivity editaboutactivity)
    {
        return editaboutactivity.BaseActivity.e();
    }

    private void o()
    {
        switch (g)
        {
        case 4: // '\004'
        case 7: // '\007'
        default:
            return;

        case 2: // '\002'
            findViewById(com.cyberlink.beautycircle.j.avatar_panel).setVisibility(8);
            findViewById(com.cyberlink.beautycircle.j.edit_about_text_title).setVisibility(8);
            findViewById(com.cyberlink.beautycircle.j.edit_about_text).setVisibility(8);
            findViewById(com.cyberlink.beautycircle.j.edit_displayname_title).setVisibility(8);
            findViewById(com.cyberlink.beautycircle.j.edit_about_text_count).setVisibility(8);
            findViewById(com.cyberlink.beautycircle.j.edit_displayname_text_count).setVisibility(8);
            findViewById(com.cyberlink.beautycircle.j.edit_displayname_text).requestFocus();
            b(m.bc_user_edit_display_name_title);
            b().a(0xe4000000, x.a, x.d, 0);
            return;

        case 3: // '\003'
            findViewById(com.cyberlink.beautycircle.j.avatar_panel).setVisibility(8);
            findViewById(com.cyberlink.beautycircle.j.edit_displayname_title).setVisibility(8);
            findViewById(com.cyberlink.beautycircle.j.edit_displayname_outter).setVisibility(8);
            findViewById(com.cyberlink.beautycircle.j.edit_displayname_text_count).setVisibility(8);
            findViewById(com.cyberlink.beautycircle.j.edit_website_title).setVisibility(0);
            findViewById(com.cyberlink.beautycircle.j.edit_website_text).setVisibility(0);
            findViewById(com.cyberlink.beautycircle.j.edit_about_text).requestFocus();
            b(m.bc_user_edit_about_only_title);
            b().a(0xe4000000, x.a, x.d, 0);
            return;

        case 0: // '\0'
        case 1: // '\001'
        case 5: // '\005'
        case 6: // '\006'
        case 8: // '\b'
            findViewById(com.cyberlink.beautycircle.j.edit_website_title).setVisibility(0);
            findViewById(com.cyberlink.beautycircle.j.edit_website_text).setVisibility(0);
            b(m.bc_about_title);
            b().a(0xe4000001, x.a, x.e, 0);
            return;
        }
    }

    protected boolean e()
    {
        c(0);
        return true;
    }

    public void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        i1;
        JVM INSTR tableswitch 48133 48141: default 60
    //                   48133 61
    //                   48134 108
    //                   48135 188
    //                   48136 60
    //                   48137 60
    //                   48138 60
    //                   48139 60
    //                   48140 60
    //                   48141 214;
           goto _L1 _L2 _L3 _L4 _L1 _L1 _L1 _L1 _L1 _L5
_L1:
        return;
_L2:
        if (j1 == -1 && intent != null)
        {
            ArrayList arraylist = new ArrayList();
            intent = intent.getData();
            if (intent != null)
            {
                arraylist.add(intent);
            }
            com.cyberlink.beautycircle.c.a(this, arraylist, com.cyberlink.beautycircle.Globals.CropSettings.Avatar, 48135);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (j1 == -1 && m != null)
        {
            MediaScannerConnection.scanFile(this, new String[] {
                m.toString()
            }, null, null);
            intent = new ArrayList();
            Uri uri = Uri.fromFile(new File(m));
            if (uri != null)
            {
                intent.add(uri);
            }
            com.cyberlink.beautycircle.c.a(this, intent, com.cyberlink.beautycircle.Globals.CropSettings.Avatar, 48135);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
        if (j1 == -1)
        {
            a(false, false, true);
            return;
        }
        if (j1 == 48258)
        {
            c(48258);
            return;
        }
        if (true) goto _L1; else goto _L5
_L5:
        if (j1 != 48256)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (g != 1 && g != 8 && g != 6) goto _L1; else goto _L6
_L6:
        super.e();
        return;
        if (j1 != 48258) goto _L1; else goto _L7
_L7:
        c(48258);
        return;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(k.bc_activity_edit_about);
        g = getIntent().getIntExtra("EditProfileMode", 0);
        o();
        h = (UICImageView)findViewById(com.cyberlink.beautycircle.j.edit_avatar);
        i = (EmojiconEditText)findViewById(com.cyberlink.beautycircle.j.edit_displayname_text);
        j = (EmojiconEditText)findViewById(com.cyberlink.beautycircle.j.edit_about_text);
        k = (EditText)findViewById(com.cyberlink.beautycircle.j.edit_website_text);
        l = (TextView)findViewById(com.cyberlink.beautycircle.j.edit_about_text_count);
        bundle = (ImageView)findViewById(com.cyberlink.beautycircle.j.edit_displayname_clear_button);
        if (h != null)
        {
            h.setOnClickListener(o);
        }
        if (j != null)
        {
            j.addTextChangedListener(f);
        }
        if (bundle != null)
        {
            bundle.setOnClickListener(p);
        }
        if (i != null)
        {
            i.addTextChangedListener(e);
        }
        a(true, true, true);
    }

    public void onRightBtnClick(View view)
    {
        view = i.getText().toString();
        String s;
        String s1;
        if (view.length() == 0 && n != null)
        {
            view = n;
        } else
        {
            view = view.trim();
        }
        s = j.getText().toString();
        s1 = k.getText().toString();
        if (view.length() == 0 || view.isEmpty())
        {
            (new LinearLayout(this)).setOrientation(1);
            (new android.widget.LinearLayout.LayoutParams(-1, -2)).setMargins(60, 0, 60, 0);
            DialogUtils.a(this, null, getResources().getString(m.bc_user_profile_display_name_warning_message), null, null, getResources().getString(m.bc_dialog_button_ok), null);
            return;
        } else
        {
            (new AsyncTask(view, s, s1) {

                final String a;
                final String b;
                final String c;
                final EditAboutActivity d;

                protected transient Void a(Void avoid[])
                {
                    avoid = AccountManager.d();
                    if (avoid == null)
                    {
                        return null;
                    }
                    if (((UserInfo) (avoid)).displayName != null && ((UserInfo) (avoid)).displayName.equals(a) && (((UserInfo) (avoid)).description != null && ((UserInfo) (avoid)).description.equals(b) || ((UserInfo) (avoid)).description == null && b.isEmpty()) && ((UserInfo) (avoid)).websiteUrl != null && ((UserInfo) (avoid)).websiteUrl.equals(c))
                    {
                        if (EditAboutActivity.a(d) == 1 || EditAboutActivity.a(d) == 5 || EditAboutActivity.a(d) == 8 || EditAboutActivity.a(d) == 6)
                        {
                            com.cyberlink.beautycircle.c.b(d, EditAboutActivity.a(d));
                            return null;
                        } else
                        {
                            d.runOnUiThread(new Runnable(this) {

                                final _cls1 a;

                                public void run()
                                {
                                    a.d.e();
                                }

            
            {
                a = _pcls1;
                super();
            }
                            });
                            return null;
                        }
                    } else
                    {
                        d.k();
                        NetworkUser.a(AccountManager.b(), a, null, null, b, null, null, null, null, null, null, null, null, c).a(new com.perfectcorp.utility.m(this) {

                            final _cls1 a;

                            protected void a(int i1)
                            {
                                String s1;
                                a.d.l();
                                s1 = (new StringBuilder()).append(a.d.getResources().getString(m.bc_register_error_unknown_error)).append(s.a(i1)).toString();
                                if (com.cyberlink.beautycircle.model.network.c.a()) goto _L2; else goto _L1
_L1:
                                s1 = (new StringBuilder()).append(a.d.getResources().getString(m.bc_register_error_network_unavailabe)).append(s.a(i1)).toString();
_L4:
                                DialogUtils.a(a.d, null, s1, null, null, a.d.getResources().getString(m.bc_dialog_button_ok), null);
                                return;
_L2:
                                if (i1 != 445)
                                {
                                    break; /* Loop/switch isn't completed */
                                }
                                s1 = (new StringBuilder()).append(a.d.getResources().getString(m.bc_user_profile_display_name_invalid)).append(s.a(i1)).toString();
                                if (true) goto _L4; else goto _L3
_L3:
                                if (i1 != 420) goto _L4; else goto _L5
_L5:
                                EditAboutActivity.a(a.d, 48258);
                                return;
                            }

                            protected void a(com.cyberlink.beautycircle.model.UserInfo.UpdateUserResponse updateuserresponse)
                            {
                                a.d.l();
                                updateuserresponse = AccountManager.b();
                                UserInfo userinfo = AccountManager.d();
                                userinfo.description = a.b;
                                userinfo.displayName = a.a;
                                userinfo.websiteUrl = a.c;
                                AccountManager.a(updateuserresponse, userinfo, false);
                                if (EditAboutActivity.a(a.d) == 1 || EditAboutActivity.a(a.d) == 5 || EditAboutActivity.a(a.d) == 8 || EditAboutActivity.a(a.d) == 6)
                                {
                                    com.cyberlink.beautycircle.c.b(a.d, EditAboutActivity.a(a.d));
                                    return;
                                } else
                                {
                                    EditAboutActivity.a(a.d, -1, a.a, a.b, a.c, userinfo);
                                    return;
                                }
                            }

                            protected void b(Object obj)
                            {
                                a((com.cyberlink.beautycircle.model.UserInfo.UpdateUserResponse)obj);
                            }

            
            {
                a = _pcls1;
                super();
            }
                        });
                        return null;
                    }
                }

                protected Object doInBackground(Object aobj[])
                {
                    return a((Void[])aobj);
                }

            
            {
                d = EditAboutActivity.this;
                a = s;
                b = s1;
                c = s2;
                super();
            }
            }).executeOnExecutor(j.q, new Void[0]);
            return;
        }
    }
}
