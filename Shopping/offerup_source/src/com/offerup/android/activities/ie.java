// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import com.b.a.a.g;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.offerup.android.activities:
//            TruYouInitActivity

final class ie
    implements Callback
{

    private TruYouInitActivity a;

    ie(TruYouInitActivity truyouinitactivity)
    {
        a = truyouinitactivity;
        super();
    }

    public final void failure(RetrofitError retrofiterror)
    {
        a.i();
        g.a(this, retrofiterror);
        a.a(a.getString(0x7f09017d), a.getString(0x7f09017a));
    }

    public final void success(Object obj, Response response)
    {
        a.i();
        TruYouInitActivity.f(a);
        com.offerup.android.activities.TruYouInitActivity.g(a);
    }
}
