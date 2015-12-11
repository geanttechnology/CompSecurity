// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public final class adk
{

    final amd a;
    public final adn b;
    private ir c;

    public adk(amd amd1, adn adn1)
    {
        a = (amd)b.a(amd1);
        b = (adn)b.a(adn1);
        c = ir.a(adn1.getContext());
        b();
    }

    private String a()
    {
        return a.n().b();
    }

    private void b()
    {
        boolean flag = false;
        adn adn1;
        int i;
        if (a.i().a() || a.i() == amj.f)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        adn1 = b;
        if (i != 0)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 8;
        }
        adn1.setVisibility(i);
    }

    public final void handleMdxStateChangedEvent(amk amk1)
    {
        adm.a[amk1.a.ordinal()];
        JVM INSTR tableswitch 1 6: default 48
    //                   1 49
    //                   2 118
    //                   3 132
    //                   4 113
    //                   5 113
    //                   6 113;
           goto _L1 _L2 _L3 _L4 _L5 _L5 _L5
_L5:
        break; /* Loop/switch isn't completed */
_L1:
        return;
_L2:
        amk1 = c;
        Object obj = ir.c();
        amk1 = b;
        obj = ((iz) (obj)).c;
        ((adn) (amk1)).a.setBackgroundColor(amk1.getResources().getColor(0x7f09007e));
        ((adn) (amk1)).b.setText(amk1.getContext().getString(0x7f0b01fa, new Object[] {
            obj
        }));
        amk1.a(3);
_L6:
        b();
        return;
_L3:
        b.a(a());
        if (true) goto _L6; else goto _L4
_L4:
        Object obj1 = a.j();
        if (obj1 != null)
        {
            boolean flag = ((alu) (obj1)).k;
            amk1 = b;
            int i = ((alu) (obj1)).j;
            obj1 = new adl(this, ((alu) (obj1)), flag);
            ((adn) (amk1)).b.setText(amk1.getContext().getString(i));
            if (flag)
            {
                ((adn) (amk1)).c.setText(amk1.getContext().getString(0x7f0b00dd));
            } else
            {
                ((adn) (amk1)).c.setText(amk1.getContext().getString(0x7f0b00db));
            }
            ((adn) (amk1)).c.setOnClickListener(((android.view.View.OnClickListener) (obj1)));
            amk1.a(5);
        }
        b();
        return;
    }

    public final void handleVideoStageEvent(ctd ctd1)
    {
        while (!a.i().a() || !ctd1.b.a(ctt.b)) 
        {
            return;
        }
        switch (adm.b[ctd1.b.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            ctd1 = b;
            ((adn) (ctd1)).b.setText(ctd1.getContext().getString(0x7f0b01fd));
            ctd1.a(2);
            b();
            return;

        case 2: // '\002'
            ctd1 = b;
            String s = a();
            ((adn) (ctd1)).b.setText(ctd1.getContext().getString(0x7f0b01fc, new Object[] {
                s
            }));
            ctd1.a(4);
            b();
            return;

        case 3: // '\003'
            b.a(a());
            break;
        }
        b();
    }
}
