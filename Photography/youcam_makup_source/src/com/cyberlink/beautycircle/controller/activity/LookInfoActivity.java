// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.b;
import com.cyberlink.beautycircle.model.f;
import com.cyberlink.beautycircle.model.o;
import com.cyberlink.beautycircle.model.p;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.cyberlink.beautycircle.view.widgetpool.common.UICImageView;
import com.perfectcorp.model.c;
import com.perfectcorp.model.d;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.h;
import java.util.ArrayList;
import java.util.Iterator;

public class LookInfoActivity extends BaseActivity
{

    LayoutInflater e;
    private String f;
    private b g;
    private UICImageView h;

    public LookInfoActivity()
    {
        e = null;
        f = null;
        g = null;
        h = null;
    }

    private int a(d d1)
    {
        if (d1.a.equals("eye_shadow"))
        {
            return m.bc_looks_makeup_eye_shadow;
        }
        if (d1.a.equals("eye_line"))
        {
            return m.bc_looks_makeup_eye_line;
        }
        if (d1.a.equals("eye_lash"))
        {
            return m.bc_looks_makeup_eye_lash;
        }
        if (d1.a.equals("lipstick"))
        {
            return m.bc_looks_makeup_lipstick;
        }
        if (d1.a.equals("blush"))
        {
            return m.bc_looks_makeup_blush;
        }
        if (d1.a.equals("eye_brow"))
        {
            return m.bc_looks_makeup_eye_brow;
        }
        if (d1.a.equals("face_art"))
        {
            return m.bc_looks_makeup_face_art;
        }
        if (d1.a.equals("skin_toner"))
        {
            return m.bc_looks_makeup_skin_toner;
        }
        if (d1.a.equals("mustache"))
        {
            return m.bc_looks_makeup_mustache;
        } else
        {
            return m.bc_developer_looks_makeup_unknown;
        }
    }

    private void a(View view, f f1)
    {
        if (view != null && f1 != null)
        {
            ((TextView)view.findViewById(j.makeup_name)).setText(a(f1.c));
            ImageView imageview = (ImageView)view.findViewById(j.makeup_thumbnail);
            Object obj;
            if (imageview != null)
            {
                obj = f(f1.d.a);
                if (obj == null || ((o) (obj)).b == null || ((o) (obj)).b.a == null || ((o) (obj)).b.a.isEmpty())
                {
                    imageview.setVisibility(4);
                } else
                {
                    imageview.setImageURI(Uri.parse(com.perfectcorp.utility.h.a(new String[] {
                        f, ((o) (obj)).b.a
                    })));
                }
            } else
            {
                com.perfectcorp.utility.e.e(new Object[] {
                    "Fix the layout xml!! makeup_thumbnail not found!!!"
                });
            }
            view = (LinearLayout)view.findViewById(j.makeup_colors);
            if (view != null)
            {
                view.removeAllViews();
                int i = 0;
                while (i < f1.a.size()) 
                {
                    obj = (com.cyberlink.beautycircle.model.d)f1.a.get(i);
                    if (obj != null && ((com.cyberlink.beautycircle.model.d) (obj)).a != null)
                    {
                        View view1 = e.inflate(k.bc_view_item_look_makeup_colors, view, false);
                        view1.findViewById(j.makeup_color).setBackgroundColor(Integer.parseInt(((com.cyberlink.beautycircle.model.d) (obj)).a, 16) | 0xff000000);
                        if (f1.b != null && f1.b.size() > i)
                        {
                            com.cyberlink.beautycircle.model.e e1 = (com.cyberlink.beautycircle.model.e)f1.b.get(i);
                            TextView textview = (TextView)view1.findViewById(j.makeup_color_intensity);
                            if (e1 != null)
                            {
                                textview.setText(e1.a);
                            }
                        }
                        view.addView(view1);
                    }
                    i++;
                }
            } else
            {
                com.perfectcorp.utility.e.e(new Object[] {
                    "Fix the layout xml!! makeup_colors not found!!!"
                });
                return;
            }
        }
    }

    static boolean a(LookInfoActivity lookinfoactivity)
    {
        return lookinfoactivity.e();
    }

    static boolean b(LookInfoActivity lookinfoactivity)
    {
        return lookinfoactivity.e();
    }

    private o f(String s)
    {
        Iterator iterator = g.a().iterator();
        o o1;
label0:
        do
        {
            if (iterator.hasNext())
            {
                Object obj = (com.cyberlink.beautycircle.model.m)iterator.next();
                if (((com.cyberlink.beautycircle.model.m) (obj)).a == null)
                {
                    continue;
                }
                obj = ((com.cyberlink.beautycircle.model.m) (obj)).a.iterator();
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        continue label0;
                    }
                    o1 = (o)((Iterator) (obj)).next();
                } while (o1 == null || !o1.a.a.equals(s));
                break;
            } else
            {
                return null;
            }
        } while (true);
        return o1;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(k.bc_activity_look_info);
        bundle = getIntent();
        if (bundle != null)
        {
            f = bundle.getStringExtra("lookPath");
        }
        if (f == null || f.isEmpty())
        {
            DialogUtils.a(this, m.bc_dialog_title_warning, m.bc_looks_message_look_not_found, new Runnable() {

                final LookInfoActivity a;

                public void run()
                {
                    LookInfoActivity.a(a);
                }

            
            {
                a = LookInfoActivity.this;
                super();
            }
            });
            return;
        }
        g = (b)com.perfectcorp.model.b.a(com/cyberlink/beautycircle/model/b, com.perfectcorp.utility.h.c(com.perfectcorp.utility.h.a(new String[] {
            f, "makeup_template.xml"
        })));
        if (g == null || g.j == null || g.j.isEmpty())
        {
            DialogUtils.a(this, m.bc_dialog_title_warning, m.bc_looks_message_look_parse_fail, new Runnable() {

                final LookInfoActivity a;

                public void run()
                {
                    com.cyberlink.beautycircle.controller.activity.LookInfoActivity.b(a);
                }

            
            {
                a = LookInfoActivity.this;
                super();
            }
            });
            return;
        }
        e = (LayoutInflater)getSystemService("layout_inflater");
        h = (UICImageView)findViewById(j.look_thumbnail);
        h.setImageURI(Uri.parse((new StringBuilder()).append("file://").append(com.perfectcorp.utility.h.a(new String[] {
            f, ((p)g.j.get(0)).a.a
        })).toString()));
        Object obj = (p)g.j.get(0);
        bundle = (ViewGroup)findViewById(j.makeup_layout);
        bundle.removeAllViews();
        View view;
        for (obj = ((p) (obj)).b.iterator(); ((Iterator) (obj)).hasNext(); bundle.addView(view))
        {
            f f1 = (f)((Iterator) (obj)).next();
            view = e.inflate(k.bc_view_item_look_makeup, bundle, false);
            a(view, f1);
        }

        c();
    }
}
