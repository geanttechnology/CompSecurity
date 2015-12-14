// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MotionEvent;
import com.cyberlink.beautycircle.BaseArcMenuActivity;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.controller.fragment.TopBarFragment;
import com.cyberlink.beautycircle.controller.fragment.e;
import com.cyberlink.beautycircle.controller.fragment.i;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.model.CircleDetail;
import com.perfectcorp.model.Model;
import java.util.Locale;

public class CircleActivity extends BaseArcMenuActivity
{

    private CircleDetail o;
    private Long p;

    public CircleActivity()
    {
        p = Long.valueOf(-1L);
    }

    private void a(boolean flag)
    {
        Object obj1 = null;
        if (flag && !Globals.b(this))
        {
            i l;
            Object obj;
            Intent intent;
            if (e != null)
            {
                l = (i)e;
            } else
            {
                l = null;
            }
            intent = new Intent();
            if (l != null)
            {
                obj = l.o();
            } else
            {
                obj = null;
            }
            if (obj != null)
            {
                intent.putExtra("CircleId", ((java.io.Serializable) (obj)));
            }
            if (l != null)
            {
                flag = l.n();
            } else
            {
                flag = false;
            }
            intent.putExtra("IsFollowed", flag);
            obj = obj1;
            if (l != null)
            {
                obj = l.p();
            }
            if (obj != null)
            {
                intent.putExtra("CircleDetail", ((CircleDetail) (obj)).toString());
            }
            setResult(-1, intent);
        }
        super.e();
    }

    public void a(CircleDetail circledetail)
    {
        o = circledetail;
        if (o != null)
        {
            circledetail = o.circleName;
        } else
        {
            circledetail = "";
        }
        a(((String) (circledetail)));
    }

    public boolean a(MotionEvent motionevent)
    {
        return ((i)e).a(motionevent);
    }

    public String d(String s)
    {
        if (e != null)
        {
            long l = Globals.a(((i)e).o());
            if (l > 0L)
            {
                return String.format(Locale.getDefault(), "ybc://circle/%d", new Object[] {
                    Long.valueOf(l)
                });
            }
        }
        return null;
    }

    protected boolean e()
    {
        a(true);
        return true;
    }

    public void onActivityResult(int l, int i1, Intent intent)
    {
        super.onActivityResult(l, i1, intent);
        if (e != null)
        {
            e.onActivityResult(l, i1, intent);
        }
        l;
        JVM INSTR tableswitch 48152 48152: default 44
    //                   48152 45;
           goto _L1 _L2
_L1:
        return;
_L2:
        if (i1 == 48257)
        {
            a(false);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(k.bc_activity_me);
        Object obj = getIntent();
        if (obj != null)
        {
            String s = ((Intent) (obj)).getStringExtra("CircleDetail");
            if (s != null && !s.isEmpty())
            {
                o = (CircleDetail)Model.a(com/cyberlink/beautycircle/model/CircleDetail, s);
            }
            p = Long.valueOf(((Intent) (obj)).getLongExtra("CircleId", -1L));
        } else
        if (o == null && p.longValue() == -1L)
        {
            com.perfectcorp.utility.e.e(new Object[] {
                "Bad intent"
            });
            Globals.b("Bad intent: no circle");
            return;
        }
        if (o != null)
        {
            obj = o.circleName;
        } else
        {
            obj = "";
        }
        b(((String) (obj)));
        b().a();
        if (bundle == null)
        {
            e = new i();
            getSupportFragmentManager().beginTransaction().add(j.fragment_main_panel, e).commit();
        }
        b(bundle);
    }
}
