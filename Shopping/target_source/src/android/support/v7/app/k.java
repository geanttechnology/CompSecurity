// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import android.content.Context;
import android.support.v7.internal.view.d;
import android.view.ActionMode;
import android.view.Window;

// Referenced classes of package android.support.v7.app:
//            j, g

class k extends j
{
    class a extends i.b
    {

        final k b;

        final ActionMode a(android.view.ActionMode.Callback callback)
        {
            callback = new android.support.v7.internal.view.d.a(b.a, callback);
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

        public ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback)
        {
            if (k.a(b))
            {
                return a(callback);
            } else
            {
                return super.onWindowStartingActionMode(callback);
            }
        }

        a(android.view.Window.Callback callback)
        {
            b = k.this;
            super(k.this, callback);
        }
    }


    private boolean n;

    k(Context context, Window window, g g)
    {
        super(context, window, g);
        n = true;
    }

    static boolean a(k k1)
    {
        return k1.n;
    }

    android.view.Window.Callback a(android.view.Window.Callback callback)
    {
        return new a(callback);
    }
}
