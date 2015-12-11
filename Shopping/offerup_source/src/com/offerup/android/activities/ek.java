// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import com.b.a.a.g;
import com.offerup.android.dto.ItemResponse;
import com.offerup.android.utils.n;
import com.offerup.android.utils.u;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.offerup.android.activities:
//            NewPostActivity

final class ek
    implements Callback
{

    private NewPostActivity a;

    ek(NewPostActivity newpostactivity)
    {
        a = newpostactivity;
        super();
    }

    public final void failure(RetrofitError retrofiterror)
    {
        a.i();
        retrofiterror = u.a(retrofiterror, NewPostActivity.e(a));
        n.a(a, 0x7f090132, retrofiterror);
    }

    public final void success(Object obj, Response response)
    {
        obj = (ItemResponse)obj;
        if (obj != null && ((ItemResponse) (obj)).getItem() != null)
        {
            NewPostActivity.a(a, ((ItemResponse) (obj)).getItem());
            return;
        } else
        {
            a.i();
            g.a(this, new Exception("unable to update item"));
            return;
        }
    }
}
