// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import java.util.WeakHashMap;

class ef extends ee
{

    ef()
    {
    }

    public final ep f(View view)
    {
        if (a == null)
        {
            a = new WeakHashMap();
        }
        ep ep2 = (ep)a.get(view);
        ep ep1 = ep2;
        if (ep2 == null)
        {
            ep1 = new ep(view);
            a.put(view, ep1);
        }
        return ep1;
    }
}
