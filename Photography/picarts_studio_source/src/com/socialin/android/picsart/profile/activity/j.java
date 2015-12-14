// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import android.text.TextUtils;
import com.socialin.android.util.Utils;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.d;

// Referenced classes of package com.socialin.android.picsart.profile.activity:
//            MemboxItemsActivity

final class j
    implements d
{

    private MemboxItemsActivity a;

    private j(MemboxItemsActivity memboxitemsactivity)
    {
        a = memboxitemsactivity;
        super();
    }

    j(MemboxItemsActivity memboxitemsactivity, byte byte0)
    {
        this(memboxitemsactivity);
    }

    public final volatile void onCancelRequest(Object obj, Request request)
    {
    }

    public final void onFailure(Exception exception, Request request)
    {
        request = exception.getLocalizedMessage();
        exception = request;
        if (TextUtils.isEmpty(request))
        {
            exception = a.getString(0x7f0805cb);
        }
        Utils.c(a, exception);
    }

    public final transient void onProgressUpdate(Integer ainteger[])
    {
    }

    public final void onSuccess(Object obj, Request request)
    {
        com.socialin.android.picsart.profile.activity.MemboxItemsActivity.d(a);
    }
}
