// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.controller.fragment.TopBarFragment;
import com.cyberlink.beautycircle.controller.fragment.x;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.CircleDetail;
import com.cyberlink.beautycircle.model.network.NetworkCircle;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.cyberlink.beautycircle.utility.t;
import com.cyberlink.beautycircle.utility.v;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.e;
import com.rockerhieu.emojicon.EmojiconEditText;

public class EditCircleActivity extends BaseActivity
{

    protected TextWatcher e;
    protected TextWatcher f;
    private int g;
    private CircleDetail h;
    private EmojiconEditText i;
    private EmojiconEditText j;
    private TextView k;
    private TextView l;
    private android.view.View.OnClickListener m;

    public EditCircleActivity()
    {
        g = 0;
        i = null;
        j = null;
        k = null;
        l = null;
        m = new android.view.View.OnClickListener() {

            final EditCircleActivity a;

            public void onClick(View view)
            {
                if (EditCircleActivity.b(a) != null)
                {
                    EditCircleActivity.b(a).setText("");
                }
            }

            
            {
                a = EditCircleActivity.this;
                super();
            }
        };
        e = new TextWatcher() {

            final EditCircleActivity a;

            public void afterTextChanged(Editable editable)
            {
                if (EditCircleActivity.b(a) != null)
                {
                    editable = EditCircleActivity.b(a).getText().toString();
                    if (editable.isEmpty())
                    {
                        a.findViewById(j.edit_displayname_clear_button).setVisibility(4);
                    } else
                    {
                        a.findViewById(j.edit_displayname_clear_button).setVisibility(0);
                    }
                    if (EditCircleActivity.c(a) != null)
                    {
                        EditCircleActivity.c(a).setText((new StringBuilder()).append(String.valueOf(editable.length())).append("/").append(30).toString());
                    }
                }
            }

            public void beforeTextChanged(CharSequence charsequence, int i1, int j1, int k1)
            {
            }

            public void onTextChanged(CharSequence charsequence, int i1, int j1, int k1)
            {
            }

            
            {
                a = EditCircleActivity.this;
                super();
            }
        };
        f = new TextWatcher() {

            final EditCircleActivity a;

            public void afterTextChanged(Editable editable)
            {
                if (EditCircleActivity.d(a) != null)
                {
                    editable = EditCircleActivity.d(a).getText().toString();
                    if (com.cyberlink.beautycircle.controller.activity.EditCircleActivity.e(a) != null)
                    {
                        com.cyberlink.beautycircle.controller.activity.EditCircleActivity.e(a).setText((new StringBuilder()).append(String.valueOf(editable.length())).append("/").append(180).toString());
                    }
                }
            }

            public void beforeTextChanged(CharSequence charsequence, int i1, int j1, int k1)
            {
            }

            public void onTextChanged(CharSequence charsequence, int i1, int j1, int k1)
            {
            }

            
            {
                a = EditCircleActivity.this;
                super();
            }
        };
    }

    static CircleDetail a(EditCircleActivity editcircleactivity)
    {
        return editcircleactivity.h;
    }

    static EmojiconEditText b(EditCircleActivity editcircleactivity)
    {
        return editcircleactivity.i;
    }

    static TextView c(EditCircleActivity editcircleactivity)
    {
        return editcircleactivity.l;
    }

    static EmojiconEditText d(EditCircleActivity editcircleactivity)
    {
        return editcircleactivity.j;
    }

    static TextView e(EditCircleActivity editcircleactivity)
    {
        return editcircleactivity.k;
    }

    private void p()
    {
        findViewById(j.avatar_panel).setVisibility(8);
        findViewById(j.edit_about_text_title).setVisibility(8);
        findViewById(j.edit_about_text).setVisibility(8);
        findViewById(j.edit_displayname_outter).setVisibility(8);
        findViewById(j.edit_displayname_title).setVisibility(8);
        findViewById(j.edit_displayname_text_count).setVisibility(8);
        findViewById(j.edit_about_text_count).setVisibility(8);
        switch (g)
        {
        case 1: // '\001'
        default:
            return;

        case 2: // '\002'
            findViewById(j.edit_displayname_outter).setVisibility(0);
            findViewById(j.edit_displayname_text_count).setVisibility(0);
            findViewById(j.edit_displayname_text).requestFocus();
            b(m.bc_edit_circle_name_title);
            b().a(0xe4000000, x.a, x.d, 0);
            return;

        case 3: // '\003'
        case 4: // '\004'
            findViewById(j.edit_about_text).setVisibility(0);
            findViewById(j.edit_about_text_count).setVisibility(0);
            findViewById(j.edit_about_text).requestFocus();
            b(m.bc_edit_circle_desc_title);
            b().a(0xe4000000, x.a, x.d, 0);
            return;

        case 0: // '\0'
            b(m.bc_edit_circle_edit_title);
            b().a(0xe4000000, x.a, x.d, 0);
            return;
        }
    }

    private void q()
    {
        if (h != null)
        {
            if (i != null)
            {
                i.setText(h.circleName);
            }
            if (j != null)
            {
                j.setText(h.description);
                return;
            }
        }
    }

    public void o()
    {
        Intent intent = new Intent();
        intent.putExtra("CircleDetail", h.toString());
        setResult(-1, intent);
        super.e();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(k.bc_activity_edit_about);
        bundle = getIntent();
        g = bundle.getIntExtra("EditProfileMode", 0);
        h = (CircleDetail)Model.a(com/cyberlink/beautycircle/model/CircleDetail, bundle.getStringExtra("CircleDetail"));
        if (h == null)
        {
            h = new CircleDetail();
        }
        p();
        i = (EmojiconEditText)findViewById(j.edit_displayname_text);
        j = (EmojiconEditText)findViewById(j.edit_about_text);
        k = (TextView)findViewById(j.edit_about_text_count);
        l = (TextView)findViewById(j.edit_displayname_text_count);
        bundle = findViewById(j.edit_displayname_clear_button);
        if (i != null)
        {
            i.setHint(m.bc_edit_circle_name_hint);
            i.addTextChangedListener(e);
            android.text.InputFilter.LengthFilter lengthfilter = new android.text.InputFilter.LengthFilter(30);
            i.setFilters(new InputFilter[] {
                lengthfilter
            });
        }
        if (j != null)
        {
            j.setHint(m.bc_edit_circle_description_hint);
            j.addTextChangedListener(f);
            android.text.InputFilter.LengthFilter lengthfilter1 = new android.text.InputFilter.LengthFilter(180);
            j.setFilters(new InputFilter[] {
                lengthfilter1
            });
        }
        if (bundle != null)
        {
            bundle.setOnClickListener(m);
        }
        q();
    }

    public void onRightBtnClick(View view)
    {
        if (h == null)
        {
            com.perfectcorp.utility.e.e(new Object[] {
                "mCircle null"
            });
            return;
        }
        h.circleName = i.getText().toString().trim();
        h.description = j.getText().toString().trim();
        if ((g == 0 || g == 2) && h.circleName.isEmpty())
        {
            DialogUtils.a(this, m.bc_edit_circle_message_need_name);
            return;
        }
        if (g == 4)
        {
            NetworkCircle.a(AccountManager.b(), h.id, h.circleName, h.description, h.circleTypeId, h.isSecret).a(new com.perfectcorp.utility.m() {

                final EditCircleActivity a;

                protected void a()
                {
                    com.perfectcorp.utility.e.b(new Object[] {
                        "updateCircle cancelled."
                    });
                    a.l();
                }

                protected void a(int i1)
                {
                    com.perfectcorp.utility.e.e(new Object[] {
                        "updateCircle error:", Integer.valueOf(i1)
                    });
                    Globals.a(a.getResources().getString(m.bc_server_connect_fail));
                    a.l();
                }

                protected void a(com.cyberlink.beautycircle.model.network.NetworkCircle.CreateCircleResult createcircleresult)
                {
                    if (createcircleresult != null)
                    {
                        com.perfectcorp.utility.e.b(new Object[] {
                            "updateCircle done: ", createcircleresult.circleId
                        });
                        Globals.b((new StringBuilder()).append("updateCircle done: ").append(createcircleresult.circleId).toString());
                        t.a.a();
                        createcircleresult = new Intent();
                        createcircleresult.putExtra("CircleDetail", EditCircleActivity.a(a).toString());
                        a.setResult(-1, createcircleresult);
                        a.o();
                    } else
                    {
                        com.perfectcorp.utility.e.b(new Object[] {
                            "updateCircle done: null"
                        });
                        Globals.b("updateCircle done: null");
                    }
                    a.l();
                }

                protected void b(Object obj)
                {
                    a((com.cyberlink.beautycircle.model.network.NetworkCircle.CreateCircleResult)obj);
                }

            
            {
                a = EditCircleActivity.this;
                super();
            }
            });
            return;
        } else
        {
            o();
            return;
        }
    }
}
