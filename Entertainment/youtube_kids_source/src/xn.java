// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v7.app.MediaRouteButton;
import com.google.android.apps.youtube.kids.application.KidsApplication;
import java.util.List;

public class xn extends vq
    implements ajg
{

    private MediaRouteButton h;
    private ajf i;
    private ajd j;

    public xn()
    {
    }

    public final void a()
    {
        super.a();
        h = (MediaRouteButton)findViewById(0x7f1000c1);
        if (!((KidsApplication)getApplicationContext()).i() || h == null) goto _L2; else goto _L1
_L1:
        Object obj;
        i = c().n.e();
        i.a(this);
        obj = i.d;
        c().n.j();
        c().n.f();
        j = new ajd(this, ((ip) (obj)), new xd(c().n.j(), c().n.f()));
        obj = j;
        MediaRouteButton mediaroutebutton = h;
        mediaroutebutton.a(((ajd) (obj)).a);
        mediaroutebutton.a(((ajd) (obj)).d);
        ((ajd) (obj)).e.add(mediaroutebutton);
        h.setVisibility(0);
        obj = i;
        if (((ajf) (obj)).e != 0) goto _L4; else goto _L3
_L3:
        amd amd;
        ((ajf) (obj)).b.a(((ajf) (obj)).d, ((is) (obj)), 4);
        amd = ((ajf) (obj)).f;
        ir ir1 = ((ajf) (obj)).b;
        if (ais.a(ir.c())) goto _L6; else goto _L5
_L5:
        aiq aiq1;
        aiq1 = ((ajf) (obj)).a;
        ir ir2 = ((ajf) (obj)).b;
        if (!aiq1.a(ir.c())) goto _L7; else goto _L6
_L6:
        obj.f = ((ajf) (obj)).c;
_L9:
        if (amd != ((ajf) (obj)).f)
        {
            ((ajf) (obj)).a(false);
        }
_L4:
        obj.e = ((ajf) (obj)).e + 1;
        i.a(this);
        obj = j;
        ((ajd) (obj)).b.a(((ajd) (obj)).a, ((ajd) (obj)).c, 4);
_L2:
        return;
_L7:
        obj.f = null;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public final void a(amd amd)
    {
    }

    public final amd i()
    {
        if (c().n == null)
        {
            return null;
        } else
        {
            return c().n.d();
        }
    }

    protected void onStop()
    {
        if (i != null)
        {
            Object obj = i;
            obj.e = ((ajf) (obj)).e - 1;
            if (((ajf) (obj)).e == 0)
            {
                ((ajf) (obj)).b.a(((is) (obj)));
            }
            i.b(this);
            obj = j;
            ((ajd) (obj)).b.a(((ajd) (obj)).c);
            i = null;
        }
        super.onStop();
    }
}
