// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.socialin.android.apiv3.model.StreamsResponse;
import com.socialin.android.picsart.profile.adapter.ar;
import com.socialin.android.util.Utils;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.d;

// Referenced classes of package com.socialin.android.picsart.profile.fragment:
//            b

final class e
    implements d
{

    private b a;

    private e(b b1)
    {
        a = b1;
        super();
    }

    e(b b1, byte byte0)
    {
        this(b1);
    }

    public final volatile void onCancelRequest(Object obj, Request request)
    {
    }

    public final void onFailure(Exception exception, Request request)
    {
        Utils.c(b.c(a), exception.getLocalizedMessage());
        b.f(a).setVisibility(8);
    }

    public final transient void onProgressUpdate(Integer ainteger[])
    {
    }

    public final void onSuccess(Object obj, Request request)
    {
        obj = (StreamsResponse)obj;
        b.a(a, ((StreamsResponse) (obj)).items);
        b.a(a).notifyDataSetChanged();
        b.e(a).setVisibility(0);
        b.f(a).setVisibility(8);
        if (b.a(a).getItemCount() == 1)
        {
            b.b(a);
        }
    }
}
