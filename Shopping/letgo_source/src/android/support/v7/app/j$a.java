// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import android.support.v7.cd;
import android.view.ActionMode;

// Referenced classes of package android.support.v7.app:
//            j

class k extends k
{

    final j b;

    final ActionMode a(android.view.onMode.Callback callback)
    {
        callback = new android.support.v7.(b.a, callback);
        Object obj = b.b(callback);
        if (obj != null)
        {
            obj = new cd(b.a, ((android.support.v7.cj) (obj)));
            callback.a(((cd) (obj)));
            return ((ActionMode) (obj));
        } else
        {
            return null;
        }
    }

    public ActionMode onWindowStartingActionMode(android.view.onMode.Callback callback)
    {
        if (j.a(b))
        {
            return a(callback);
        } else
        {
            return super.onWindowStartingActionMode(callback);
        }
    }

    k(j j1, android.view.ow.Callback callback)
    {
        b = j1;
        super(j1, callback);
    }
}
