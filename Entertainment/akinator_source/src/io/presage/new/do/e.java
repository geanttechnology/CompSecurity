// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.new.do;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import io.presage.new.b;

// Referenced classes of package io.presage.new.do:
//            b, a

final class e extends BroadcastReceiver
{

    final io.presage.new.do.b a;

    e(io.presage.new.do.b b1)
    {
        a = b1;
        super();
    }

    public final void onReceive(Context context, Intent intent)
    {
        if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(intent.getAction()) && "homekey".equals(intent.getStringExtra("reason")) && b.d(a).a() != null)
        {
            io.presage.utils.e.b(new String[] {
                io/presage/new/do/b.getName(), "Home key pressed from one of our activities"
            });
            b.e(a).a(b.d(a).a());
        }
    }
}
