// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.services.for;

import android.database.ContentObserver;
import android.os.Handler;
import android.os.Message;

// Referenced classes of package io.presage.services.for:
//            b

private final class rver extends ContentObserver
{

    final b a;

    public final void onChange(boolean flag)
    {
        super.onChange(flag);
        b.a(a).dispatchMessage(new Message());
    }

    public rver(b b1, Handler handler)
    {
        a = b1;
        super(handler);
    }
}
