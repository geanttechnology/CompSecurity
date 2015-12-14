// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.fragment;

import com.socialin.android.apiv3.model.ItemsResponse;
import com.socialin.android.picsart.profile.adapter.u;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.d;
import java.util.List;

// Referenced classes of package com.socialin.android.picsart.profile.fragment:
//            aa

final class af
    implements d
{

    private aa a;

    private af(aa aa1)
    {
        a = aa1;
        super();
    }

    af(aa aa1, byte byte0)
    {
        this(aa1);
    }

    public final volatile void onCancelRequest(Object obj, Request request)
    {
    }

    public final void onFailure(Exception exception, Request request)
    {
        com.socialin.android.d.c(new Object[] {
            aa.a, (new StringBuilder("items: onFailure: ")).append(exception).toString()
        });
    }

    public final transient void onProgressUpdate(Integer ainteger[])
    {
    }

    public final void onSuccess(Object obj, Request request)
    {
        obj = (ItemsResponse)obj;
        aa.n(a).addAll(((ItemsResponse) (obj)).items);
        aa.p(a).a(aa.n(a));
        aa.p(a).notifyDataSetChanged();
    }
}
