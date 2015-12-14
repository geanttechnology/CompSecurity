// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.controller.fragment.TopBarFragment;
import com.cyberlink.beautycircle.controller.fragment.x;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.CircleDetail;
import com.cyberlink.beautycircle.model.CircleType;
import com.cyberlink.beautycircle.model.network.NetworkCircle;
import com.cyberlink.beautycircle.model.network.d;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.cyberlink.beautycircle.utility.t;
import com.cyberlink.beautycircle.utility.v;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.e;
import java.util.ArrayList;

public class CircleEditorActivity extends BaseActivity
{

    private CircleDetail e;
    private CircleType f;
    private boolean g;
    private TextView h;
    private TextView i;
    private TextView j;
    private View k;
    private android.view.View.OnClickListener l;
    private android.view.View.OnClickListener m;
    private android.view.View.OnClickListener n;
    private android.view.View.OnClickListener o;
    private android.view.View.OnClickListener p;

    public CircleEditorActivity()
    {
        g = false;
        h = null;
        i = null;
        j = null;
        k = null;
        l = new android.view.View.OnClickListener() {

            final CircleEditorActivity a;

            public void onClick(View view)
            {
                com.cyberlink.beautycircle.c.a(a, 2, CircleEditorActivity.a(a));
            }

            
            {
                a = CircleEditorActivity.this;
                super();
            }
        };
        m = new android.view.View.OnClickListener() {

            final CircleEditorActivity a;

            public void onClick(View view)
            {
                com.cyberlink.beautycircle.c.a(a, 3, CircleEditorActivity.a(a));
            }

            
            {
                a = CircleEditorActivity.this;
                super();
            }
        };
        n = new android.view.View.OnClickListener() {

            final CircleEditorActivity a;

            public void onClick(View view)
            {
                long l2 = -1L;
                long l1 = l2;
                if (CircleEditorActivity.b(a) != null)
                {
                    l1 = l2;
                    if (CircleEditorActivity.b(a).id != null)
                    {
                        l1 = CircleEditorActivity.b(a).id.longValue();
                    }
                }
                com.cyberlink.beautycircle.c.a(a, l1);
            }

            
            {
                a = CircleEditorActivity.this;
                super();
            }
        };
        o = new android.view.View.OnClickListener() {

            final CircleEditorActivity a;

            public void onClick(View view)
            {
                if (com.cyberlink.beautycircle.controller.activity.CircleEditorActivity.d(a) != null)
                {
                    view = com.cyberlink.beautycircle.controller.activity.CircleEditorActivity.d(a);
                    boolean flag;
                    if (!com.cyberlink.beautycircle.controller.activity.CircleEditorActivity.d(a).isSelected())
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    view.setSelected(flag);
                    if (CircleEditorActivity.a(a) != null)
                    {
                        CircleEditorActivity.a(a).isSecret = Boolean.valueOf(com.cyberlink.beautycircle.controller.activity.CircleEditorActivity.d(a).isSelected());
                    }
                }
            }

            
            {
                a = CircleEditorActivity.this;
                super();
            }
        };
        p = new android.view.View.OnClickListener() {

            final CircleEditorActivity a;

            public void onClick(View view)
            {
                DialogUtils.a(a, null, a.getResources().getString(m.bc_edit_circle_delete_message), a.getResources().getString(m.bc_dialog_button_cancel), null, a.getResources().getString(m.bc_dialog_button_ok), new Runnable(this) {

                    final _cls6 a;

                    public void run()
                    {
                        a.a.k();
                        NetworkCircle.a(AccountManager.b(), CircleEditorActivity.a(a.a).id).a(new com.perfectcorp.utility.m(this) {

                            final _cls1 a;

                            protected void a()
                            {
                                Globals.a(a.a.a.getResources().getString(m.bc_user_circle_delete_fail));
                                a.a.a.l();
                            }

                            protected void a(int i1)
                            {
                                Globals.a(a.a.a.getResources().getString(m.bc_user_circle_delete_fail));
                                a.a.a.l();
                            }

                            protected void a(Void void1)
                            {
                                a.a.a.l();
                                t.a.a();
                                a.a.a.setResult(48257);
                                com.cyberlink.beautycircle.controller.activity.CircleEditorActivity.e(a.a.a);
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

            
            {
                a = _pcls6;
                super();
            }
                });
            }

            
            {
                a = CircleEditorActivity.this;
                super();
            }
        };
    }

    private View a(int i1, int j1, android.view.View.OnClickListener onclicklistener)
    {
        View view = findViewById(i1);
        if (onclicklistener != null)
        {
            view.setOnClickListener(onclicklistener);
        }
        ((TextView)view.findViewById(j.bc_selector_left_text)).setText(j1);
        return view;
    }

    static CircleDetail a(CircleEditorActivity circleeditoractivity)
    {
        return circleeditoractivity.e;
    }

    private TextView b(int i1, int j1, android.view.View.OnClickListener onclicklistener)
    {
        View view = findViewById(i1);
        if (onclicklistener != null)
        {
            view.setOnClickListener(onclicklistener);
        } else
        {
            view.findViewById(j.bc_goto_image).setVisibility(4);
        }
        ((TextView)view.findViewById(j.bc_goto_left_text)).setText(j1);
        return (TextView)view.findViewById(j.bc_goto_right_text);
    }

    static CircleType b(CircleEditorActivity circleeditoractivity)
    {
        return circleeditoractivity.f;
    }

    static TextView c(CircleEditorActivity circleeditoractivity)
    {
        return circleeditoractivity.j;
    }

    static View d(CircleEditorActivity circleeditoractivity)
    {
        return circleeditoractivity.k;
    }

    static boolean e(CircleEditorActivity circleeditoractivity)
    {
        return circleeditoractivity.BaseActivity.e();
    }

    static boolean f(CircleEditorActivity circleeditoractivity)
    {
        return circleeditoractivity.BaseActivity.e();
    }

    static boolean g(CircleEditorActivity circleeditoractivity)
    {
        return circleeditoractivity.BaseActivity.e();
    }

    static boolean h(CircleEditorActivity circleeditoractivity)
    {
        return circleeditoractivity.BaseActivity.e();
    }

    private void o()
    {
        if (f == null)
        {
            f = new CircleType();
        }
        if (e != null && e.circleTypeId != null)
        {
            CircleType.b().a(new com.perfectcorp.utility.m() {

                final CircleEditorActivity a;

                protected void a(d d1)
                {
                    if (d1 != null && d1.b != null && !d1.b.isEmpty()) goto _L2; else goto _L1
_L1:
                    return;
_L2:
                    int j1 = d1.b.size();
                    int i1 = 0;
                    do
                    {
                        if (i1 < j1)
                        {
label0:
                            {
                                CircleType circletype = (CircleType)d1.b.get(i1);
                                if (circletype == null || !CircleEditorActivity.a(a).circleTypeId.equals(circletype.id) || circletype.defaultType.equals("HOW-TO"))
                                {
                                    break label0;
                                }
                                CircleEditorActivity.b(a).circleTypeName = circletype.circleTypeName;
                                CircleEditorActivity.b(a).id = circletype.id;
                                if (com.cyberlink.beautycircle.controller.activity.CircleEditorActivity.c(a) != null && CircleEditorActivity.b(a) != null)
                                {
                                    com.cyberlink.beautycircle.controller.activity.CircleEditorActivity.c(a).setText(CircleEditorActivity.b(a).circleTypeName);
                                    return;
                                }
                            }
                        }
                        if (true)
                        {
                            continue;
                        }
                        i1++;
                    } while (true);
                    if (true) goto _L1; else goto _L3
_L3:
                }

                protected void b(Object obj)
                {
                    a((d)obj);
                }

            
            {
                a = CircleEditorActivity.this;
                super();
            }
            });
        }
        if (h != null && e != null)
        {
            h.setText(e.circleName);
        }
        if (i != null && e != null)
        {
            i.setText(e.description);
        }
        if (j != null && f != null)
        {
            j.setText(f.circleTypeName);
        }
        if (k != null && e != null && e.isSecret != null)
        {
            k.setSelected(e.isSecret.booleanValue());
        }
    }

    protected boolean e()
    {
        if (g)
        {
            return super.e();
        } else
        {
            DialogUtils.a(this, null, getResources().getString(m.bc_create_circle_cancel_desc), getResources().getString(m.bc_create_circle_cancel_nagtive_option), null, getResources().getString(m.bc_create_circle_cancel_postive_option), new Runnable() {

                final CircleEditorActivity a;

                public void run()
                {
                    a.setResult(0);
                    CircleEditorActivity.f(a);
                }

            
            {
                a = CircleEditorActivity.this;
                super();
            }
            });
            return true;
        }
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        if (j1 != -1) goto _L2; else goto _L1
_L1:
        i1;
        JVM INSTR tableswitch 48153 48155: default 40
    //                   48153 45
    //                   48154 40
    //                   48155 66;
           goto _L3 _L4 _L3 _L5
_L3:
        o();
_L2:
        return;
_L4:
        e = (CircleDetail)Model.a(com/cyberlink/beautycircle/model/CircleDetail, intent.getStringExtra("CircleDetail"));
        continue; /* Loop/switch isn't completed */
_L5:
        f = (CircleType)Model.a(com/cyberlink/beautycircle/model/CircleType, intent.getStringExtra("Category"));
        if (e != null && f != null)
        {
            e.circleTypeId = f.id;
        }
        if (true) goto _L3; else goto _L6
_L6:
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(k.bc_activity_edit_circle);
        bundle = getIntent();
        String s = bundle.getStringExtra("CircleDetail");
        g = bundle.getBooleanExtra("CircleEditorMode", false);
        if (s != null)
        {
            e = (CircleDetail)Model.a(com/cyberlink/beautycircle/model/CircleDetail, s);
        } else
        {
            e = new CircleDetail();
        }
        h = b(j.circle_name, m.bc_edit_circle_name, l);
        i = b(j.circle_description, m.bc_edit_circle_desc, m);
        j = b(j.circle_category, m.bc_edit_circle_category, n);
        k = a(j.circle_secret_circle, m.bc_edit_circle_secret, o);
        bundle = findViewById(j.circle_delete);
        bundle.setOnClickListener(p);
        if (g)
        {
            b(m.bc_edit_circle_title_edit);
            b().a(0xe4000000, x.a, x.d, 0);
            bundle.setVisibility(0);
        } else
        {
            b(m.bc_edit_circle_title);
            b().a(0xe4000000, x.a, x.g, 0);
            bundle.setVisibility(8);
        }
        o();
    }

    public void onRightBtnClick(View view)
    {
        view = AccountManager.b();
        if (e != null && e.circleName != null)
        {
            e.circleName = e.circleName.trim();
        }
        if (e == null || e.circleName == null || e.circleName.isEmpty())
        {
            DialogUtils.a(this, null, getResources().getString(m.bc_edit_circle_message_need_name), null, null, getResources().getString(m.bc_dialog_button_ok), null);
            return;
        }
        k();
        if (g)
        {
            NetworkCircle.a(view, e.id, e.circleName, e.description, e.circleTypeId, e.isSecret).a(new com.perfectcorp.utility.m() {

                final CircleEditorActivity a;

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
                        createcircleresult.putExtra("CircleDetail", CircleEditorActivity.a(a).toString());
                        a.setResult(-1, createcircleresult);
                        CircleEditorActivity.g(a);
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
                a = CircleEditorActivity.this;
                super();
            }
            });
            return;
        } else
        {
            NetworkCircle.a(view, e.circleName, e.description, e.circleTypeId, e.isSecret).a(new com.perfectcorp.utility.m() {

                final CircleEditorActivity a;

                protected void a()
                {
                    com.perfectcorp.utility.e.b(new Object[] {
                        "createCircle cancelled."
                    });
                    a.l();
                }

                protected void a(int i1)
                {
                    com.perfectcorp.utility.e.e(new Object[] {
                        "createCircle error:", Integer.valueOf(i1)
                    });
                    a.l();
                }

                protected void a(com.cyberlink.beautycircle.model.network.NetworkCircle.CreateCircleResult createcircleresult)
                {
                    if (createcircleresult != null)
                    {
                        com.perfectcorp.utility.e.b(new Object[] {
                            "createCircle done: ", createcircleresult.circleId
                        });
                        Globals.b((new StringBuilder()).append("createCircle done: ").append(createcircleresult.circleId).toString());
                        t.a.a();
                        CircleEditorActivity.h(a);
                    } else
                    {
                        com.perfectcorp.utility.e.b(new Object[] {
                            "createCircle done: null"
                        });
                        Globals.b("createCircle done: null");
                    }
                    a.l();
                }

                protected void b(Object obj)
                {
                    a((com.cyberlink.beautycircle.model.network.NetworkCircle.CreateCircleResult)obj);
                }

            
            {
                a = CircleEditorActivity.this;
                super();
            }
            });
            return;
        }
    }
}
