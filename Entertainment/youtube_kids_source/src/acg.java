// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.SharedPreferences;
import android.telephony.PhoneStateListener;

final class acg extends PhoneStateListener
{

    private acd a;

    acg(acd acd1)
    {
        a = acd1;
        super();
    }

    public final void onCallStateChanged(int i, String s)
    {
        if (1 != i) goto _L2; else goto _L1
_L1:
        s = a.f;
        if (((ack) (s)).a == 1) goto _L4; else goto _L3
_L3:
        if (((ack) (s)).a != 5) goto _L6; else goto _L5
_L5:
        s.b = true;
_L10:
        ((ack) (s)).f.e = false;
        if (((ack) (s)).a == 3)
        {
            s.a(4);
        }
_L4:
        return;
_L6:
        if (((ack) (s)).a == 6)
        {
            s.c = true;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (i != 0) goto _L4; else goto _L7
_L7:
        s = a.f;
        if (((ack) (s)).a == 1) goto _L4; else goto _L8
_L8:
        if (((ack) (s)).f.c.getBoolean("sound_effects", true))
        {
            ((ack) (s)).f.e = true;
        }
        if (!((ack) (s)).b && !((ack) (s)).c)
        {
            if (((ack) (s)).f.d && ((ack) (s)).d && !((ack) (s)).e)
            {
                s.a(3);
            } else
            {
                s.a(2);
            }
        }
        s.c = false;
        return;
        if (true) goto _L10; else goto _L9
_L9:
    }
}
