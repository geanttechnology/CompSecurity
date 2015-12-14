// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.widget.TextView;
import com.fotoable.beautyui.SlideSwitch;

class sq
{

    final so a;
    private TextView b;
    private SlideSwitch c;

    private sq(so so)
    {
        a = so;
        super();
    }

    sq(so so, sp sp)
    {
        this(so);
    }

    static TextView a(sq sq1)
    {
        return sq1.b;
    }

    static TextView a(sq sq1, TextView textview)
    {
        sq1.b = textview;
        return textview;
    }

    static SlideSwitch a(sq sq1, SlideSwitch slideswitch)
    {
        sq1.c = slideswitch;
        return slideswitch;
    }

    static SlideSwitch b(sq sq1)
    {
        return sq1.c;
    }
}
