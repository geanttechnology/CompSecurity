// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.os.Bundle;
import com.facebook.share.internal.a;
import com.facebook.share.internal.b;
import com.facebook.share.model.ShareContent;

// Referenced classes of package android.support.v7:
//            kf, ji

class c
    implements c
{

    final ji a;
    final ShareContent b;
    final boolean c;
    final hareContent d;

    public Bundle a()
    {
        return com.facebook.share.internal.b.a(a.c(), b, c);
    }

    public Bundle b()
    {
        return com.facebook.share.internal.a.a(a.c(), b, c);
    }

    hareContent(hareContent harecontent, ji ji1, ShareContent sharecontent, boolean flag)
    {
        d = harecontent;
        a = ji1;
        b = sharecontent;
        c = flag;
        super();
    }
}
