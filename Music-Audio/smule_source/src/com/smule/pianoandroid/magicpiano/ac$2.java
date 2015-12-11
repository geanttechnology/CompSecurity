// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ac

class a
    implements Observer
{

    final ac a;

    public void update(Observable observable, Object obj)
    {
        int i = ((Integer)obj).intValue();
        ac.a().b("NOTIFICATION_ACHIEVEMENTS", i);
        ac.a().a("NOTIFICATION_CHALLENGE", 0);
    }

    (ac ac1)
    {
        a = ac1;
        super();
    }
}
