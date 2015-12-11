// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import com.smule.android.f.h;
import com.smule.pianoandroid.e.e;
import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            b

class a
    implements Observer
{

    final b a;

    public void update(Observable observable, Object obj)
    {
        if ((Boolean)obj == Boolean.TRUE)
        {
            b.a(e.a().e());
            b.a(e.a().f());
            h.a().b("game.level.update", this);
        }
    }

    (b b1)
    {
        a = b1;
        super();
    }
}
