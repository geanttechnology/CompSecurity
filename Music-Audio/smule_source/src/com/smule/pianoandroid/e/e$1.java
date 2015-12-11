// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.e;

import com.smule.android.network.core.o;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.smule.pianoandroid.e:
//            e

class a
    implements Observer
{

    final e a;

    public void update(Observable observable, Object obj)
    {
        observable = (Map)obj;
        e.a(a, (o)observable.get("game.data.param"), false);
    }

    e.o(e e1)
    {
        a = e1;
        super();
    }
}
