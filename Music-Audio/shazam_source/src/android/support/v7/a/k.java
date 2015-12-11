// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.a;

import android.content.Context;
import android.view.ActionMode;
import android.view.Window;

// Referenced classes of package android.support.v7.a:
//            j, g

final class k extends j
{
    final class a extends i.b
    {

        final k b;

        public final ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback)
        {
            if (b.n)
            {
                callback = new android.support.v7.internal.view.d.a(b.a, callback);
                android.support.v7.e.a a1 = b.a(callback);
                if (a1 != null)
                {
                    return callback.b(a1);
                } else
                {
                    return null;
                }
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


    boolean n;

    k(Context context, Window window, g g)
    {
        super(context, window, g);
        n = true;
    }

    final android.view.Window.Callback a(android.view.Window.Callback callback)
    {
        return new a(callback);
    }
}
