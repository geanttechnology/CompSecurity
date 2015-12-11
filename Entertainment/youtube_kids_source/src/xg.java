// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.google.android.apps.youtube.kids.application.KidsApplication;
import com.google.android.libraries.youtube.common.ui.YouTubeTextView;
import java.util.HashMap;
import java.util.Map;

final class xg extends aiy
{

    private ImageView d;
    private byc e;
    private YouTubeTextView f;
    private ImageView g;
    private YouTubeTextView h;
    private ImageButton i;
    private ImageButton j;
    private YouTubeTextView k;
    private YouTubeTextView l;
    private RelativeLayout m;
    private LinearLayout n;
    private String o;
    private acb p;
    private Handler q;
    private amd r;
    private Runnable s;
    private android.view.View.OnClickListener t;

    public xg(Context context, ajb ajb)
    {
        super(context, 0x7f0c0126, ajb);
        s = new xh(this);
        t = new xi(this);
    }

    static amd a(xg xg1)
    {
        return xg1.r;
    }

    private KidsApplication a()
    {
        return (KidsApplication)getContext().getApplicationContext();
    }

    private void a(btu btu, String s1, boolean flag)
    {
        byte byte0 = 8;
        int i1;
        int j1;
        if (btu != null)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (i1 != 0)
        {
            e.a(btu, null);
            l.setText(s1);
            m.setBackgroundResource(0x7f020240);
        } else
        {
            m.setBackgroundResource(0x7f020241);
            l.setText(0x7f0b01ff);
        }
        btu = n;
        if (i1 != 0)
        {
            j1 = 17;
        } else
        {
            j1 = 5;
        }
        btu.setGravity(j1);
        btu = d;
        if (i1 != 0)
        {
            j1 = 0;
        } else
        {
            j1 = 8;
        }
        btu.setVisibility(j1);
        btu = i;
        if (i1 != 0)
        {
            j1 = 0;
        } else
        {
            j1 = 8;
        }
        btu.setVisibility(j1);
        btu = j;
        if (i1 != 0)
        {
            j1 = 0;
        } else
        {
            j1 = 8;
        }
        btu.setVisibility(j1);
        btu = h;
        if (i1 != 0)
        {
            j1 = 0;
        } else
        {
            j1 = 8;
        }
        btu.setVisibility(j1);
        btu = g;
        if (i1 != 0)
        {
            j1 = 0;
        } else
        {
            j1 = 8;
        }
        btu.setVisibility(j1);
        btu = k;
        if (i1 != 0)
        {
            i1 = byte0;
        } else
        {
            i1 = 0;
        }
        btu.setVisibility(i1);
        btu = j;
        if (flag)
        {
            i1 = 0x7f020153;
        } else
        {
            i1 = 0x7f020158;
        }
        btu.setImageResource(i1);
    }

    static void a(xg xg1, btu btu, String s1, boolean flag)
    {
        xg1.a(btu, s1, flag);
    }

    private static boolean a(amb amb1)
    {
        switch (xe.a[amb1.ordinal()])
        {
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
        case 9: // '\t'
        case 10: // '\n'
        default:
            return true;

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
            return false;
        }
    }

    static boolean a(xg xg1, amb amb1)
    {
        return a(amb1);
    }

    static acb b(xg xg1)
    {
        return xg1.p;
    }

    static aco c(xg xg1)
    {
        HashMap hashmap = new HashMap();
        hashmap.put(eda, new xf());
        return new aco(hashmap, xg1.getOwnerActivity(), xg1.a().h().F());
    }

    private void handleSequencerStageEvent(csy csy1)
    {
        if (csy1.a.a(new cts[] {
    cts.b, cts.d, cts.e
}))
        {
            if (!r.i().a())
            {
                o = null;
                a(null, null, false);
                dismiss();
            } else
            if (csy1.b != null && !bxb.a(csy1.b.a).equals(o))
            {
                q.removeCallbacks(s);
                o = bxb.a(csy1.b.a);
                a(csy1.b.d(), csy1.b.c(), a(r.l()));
                return;
            }
        }
    }

    public final void handlVideoStageEvent(ctd ctd1)
    {
        if (ctd1.b == ctt.j)
        {
            q.postDelayed(s, 2000L);
            o = null;
        }
    }

    public final void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        LinearLayout linearlayout = (LinearLayout)findViewById(0x7f10014f);
        for (int i1 = 0; i1 < linearlayout.getChildCount(); i1++)
        {
            linearlayout.getChildAt(i1).setVisibility(8);
        }

        android.view.ViewGroup.LayoutParams layoutparams = linearlayout.getLayoutParams();
        layoutparams.height = 0;
        linearlayout.setLayoutParams(layoutparams);
    }

    protected final void onCreate(Bundle bundle)
    {
        requestWindowFeature(1);
        super.onCreate(bundle);
        r = a().h().n.d();
        bundle = (FrameLayout)findViewById(0x7f100151);
        bundle.addView((LinearLayout)LayoutInflater.from(getContext()).inflate(0x7f040042, null));
        bundle.setVisibility(0);
        f = (YouTubeTextView)findViewById(0x7f10013c);
        if (r.n() != null)
        {
            f.setText(r.n().b());
        }
        RelativeLayout relativelayout = (RelativeLayout)findViewById(0x7f10013d);
        i = (ImageButton)findViewById(0x7f100144);
        j = (ImageButton)findViewById(0x7f100145);
        ImageButton imagebutton = (ImageButton)findViewById(0x7f100146);
        k = (YouTubeTextView)findViewById(0x7f100147);
        g = (ImageView)findViewById(0x7f100140);
        h = (YouTubeTextView)findViewById(0x7f100141);
        l = (YouTubeTextView)findViewById(0x7f100142);
        m = (RelativeLayout)findViewById(0x7f10013e);
        n = (LinearLayout)findViewById(0x7f100143);
        findViewById(0x7f100152).setVisibility(8);
        d = (ImageView)bundle.findViewById(0x7f10013f);
        e = new byc(((nc) (a())).b.c(), d);
        p = a().h().L();
        relativelayout.setOnClickListener(new xj(this));
        a(p.a, p.b, a(r.l()));
        q = new Handler(Looper.myLooper());
        k.setOnClickListener(t);
        imagebutton.setOnClickListener(t);
        j.setOnClickListener(new xk(this));
        i.setOnClickListener(new xl(this));
    }

    protected final void onStart()
    {
        super.onStart();
        ((nc) (a())).a.d().a(this);
    }

    protected final void onStop()
    {
        super.onStop();
        ((nc) (a())).a.d().b(this);
    }
}
