// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3;

import android.database.ContentObserver;
import android.os.Handler;

// Referenced classes of package com.socialin.android.apiv3:
//            SocialinV3

final class b extends ContentObserver
{

    private SocialinV3 a;

    public b(SocialinV3 socialinv3, Handler handler)
    {
        a = socialinv3;
        super(handler);
    }

    public final void onChange(boolean flag)
    {
        super.onChange(flag);
        SocialinV3.access$200(a);
        a.updateInventory();
    }
}
