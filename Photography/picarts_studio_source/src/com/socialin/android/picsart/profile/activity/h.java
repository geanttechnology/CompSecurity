// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import com.socialin.android.apiv3.model.Stream;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.d;

// Referenced classes of package com.socialin.android.picsart.profile.activity:
//            MemboxItemsActivity

final class h
    implements d
{

    private MemboxItemsActivity a;

    private h(MemboxItemsActivity memboxitemsactivity)
    {
        a = memboxitemsactivity;
        super();
    }

    h(MemboxItemsActivity memboxitemsactivity, byte byte0)
    {
        this(memboxitemsactivity);
    }

    public final void onCancelRequest(Object obj, Request request)
    {
        MemboxItemsActivity.a(a, a.getString(0x7f0805cb));
    }

    public final void onFailure(Exception exception, Request request)
    {
        MemboxItemsActivity.a(a, a.getString(0x7f0805cb));
    }

    public final transient void onProgressUpdate(Integer ainteger[])
    {
        MemboxItemsActivity.a(a, a.getString(0x7f0805cb));
    }

    public final void onSuccess(Object obj, Request request)
    {
        obj = (Stream)obj;
        MemboxItemsActivity.a(a, ((Stream) (obj)));
    }
}
