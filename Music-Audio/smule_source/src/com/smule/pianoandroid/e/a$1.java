// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.e;

import com.smule.android.network.core.o;
import java.io.IOException;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.smule.pianoandroid.e:
//            a

class a
    implements Observer
{

    final a a;

    public void update(Observable observable, Object obj)
    {
        observable = (Map)obj;
        try
        {
            com.smule.pianoandroid.e.a.a(a, (o)observable.get("game.data.param"), false);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Observable observable)
        {
            throw new RuntimeException("IO exception while updating achievement info.", observable);
        }
    }

    e.o(a a1)
    {
        a = a1;
        super();
    }
}
