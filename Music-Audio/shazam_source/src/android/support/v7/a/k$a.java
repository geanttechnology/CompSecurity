// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.a;

import android.view.ActionMode;

// Referenced classes of package android.support.v7.a:
//            k

final class ack extends ack
{

    final k b;

    public final ActionMode onWindowStartingActionMode(android.view.onMode.Callback callback)
    {
        if (b.n)
        {
            callback = new android.support.v7.internal.view.<init>(b.a, callback);
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

    ack(k k1, android.view.ow.Callback callback)
    {
        b = k1;
        super(k1, callback);
    }
}
