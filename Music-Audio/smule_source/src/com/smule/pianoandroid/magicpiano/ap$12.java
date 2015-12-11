// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.view.ViewGroup;
import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ap

class a
    implements Observer
{

    final ap a;

    public void update(Observable observable, Object obj)
    {
        observable = a.findViewById("fb-login".hashCode());
        if (observable != null)
        {
            ((ViewGroup)a.findViewById(0x7f0a01ec)).removeView(observable);
        }
    }

    (ap ap1)
    {
        a = ap1;
        super();
    }
}
