// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.a;

import android.database.ContentObserver;
import android.os.Handler;

// Referenced classes of package android.support.v4.a:
//            d

public final class  extends ContentObserver
{

    final d a;

    public final boolean deliverSelfNotifications()
    {
        return true;
    }

    public final void onChange(boolean flag)
    {
        a.i();
    }

    public bserver(d d1)
    {
        a = d1;
        super(new Handler());
    }
}
