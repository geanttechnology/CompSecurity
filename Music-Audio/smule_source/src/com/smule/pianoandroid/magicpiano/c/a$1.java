// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.c;

import com.smule.android.f.h;
import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.smule.pianoandroid.magicpiano.c:
//            a

class a
    implements Observer
{

    final a a;

    public void update(Observable observable, Object obj)
    {
        if (((String)obj).compareTo("LOGIN_TYPE_EXISTING") == 0)
        {
            com.smule.pianoandroid.magicpiano.c.a.a(a);
            h.a().b("USER_LOGGED_IN_EVENT", this);
        }
    }

    (a a1)
    {
        a = a1;
        super();
    }
}
