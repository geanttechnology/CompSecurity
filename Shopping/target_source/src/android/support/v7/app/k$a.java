// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import android.support.v7.internal.view.d;
import android.view.ActionMode;

// Referenced classes of package android.support.v7.app:
//            k

class k extends k
{

    final k b;

    final ActionMode a(android.view.onMode.Callback callback)
    {
        callback = new android.support.v7.internal.view.<init>(b.a, callback);
        Object obj = b.b(callback);
        if (obj != null)
        {
            obj = new d(b.a, ((android.support.v7.d.a) (obj)));
            callback.a(((d) (obj)));
            return ((ActionMode) (obj));
        } else
        {
            return null;
        }
    }

    public ActionMode onWindowStartingActionMode(android.view.onMode.Callback callback)
    {
        if (k.a(b))
        {
            return a(callback);
        } else
        {
            return super.onWindowStartingActionMode(callback);
        }
    }

    k(k k1, android.view.ow.Callback callback)
    {
        b = k1;
        super(k1, callback);
    }
}
