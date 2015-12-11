// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import android.content.Context;
import android.support.v7.cd;
import android.view.ActionMode;
import android.view.Window;

// Referenced classes of package android.support.v7.app:
//            i, f

class j extends i
{
    class a extends h.b
    {

        final j b;

        final ActionMode a(android.view.ActionMode.Callback callback)
        {
            callback = new android.support.v7.cd.a(b.a, callback);
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

        public ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback)
        {
            if (j.a(b))
            {
                return a(callback);
            } else
            {
                return super.onWindowStartingActionMode(callback);
            }
        }

        a(android.view.Window.Callback callback)
        {
            b = j.this;
            super(j.this, callback);
        }
    }


    private boolean n;

    j(Context context, Window window, f f)
    {
        super(context, window, f);
        n = true;
    }

    static boolean a(j j1)
    {
        return j1.n;
    }

    android.view.Window.Callback a(android.view.Window.Callback callback)
    {
        return new a(callback);
    }
}
