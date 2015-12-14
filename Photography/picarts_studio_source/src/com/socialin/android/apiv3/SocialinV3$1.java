// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3;

import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.d;

// Referenced classes of package com.socialin.android.apiv3:
//            SocialinV3

final class a
    implements d
{

    private SocialinV3 a;

    public final volatile void onCancelRequest(Object obj, Request request)
    {
    }

    public final void onFailure(Exception exception, Request request)
    {
    }

    public final transient void onProgressUpdate(Integer ainteger[])
    {
    }

    public final void onSuccess(Object obj, Request request)
    {
        SocialinV3.access$000(a);
    }

    (SocialinV3 socialinv3)
    {
        a = socialinv3;
        super();
    }
}
