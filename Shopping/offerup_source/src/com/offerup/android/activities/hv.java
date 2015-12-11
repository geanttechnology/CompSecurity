// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.app.AlertDialog;
import com.b.a.a.j;
import com.offerup.android.dto.response.TermsOfServiceResponse;
import com.offerup.android.utils.n;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.offerup.android.activities:
//            TermsOfServiceActivity, hw

final class hv
    implements Callback
{

    final TermsOfServiceActivity a;

    private hv(TermsOfServiceActivity termsofserviceactivity)
    {
        a = termsofserviceactivity;
        super();
    }

    hv(TermsOfServiceActivity termsofserviceactivity, byte byte0)
    {
        this(termsofserviceactivity);
    }

    public final void failure(RetrofitError retrofiterror)
    {
        TermsOfServiceActivity.b(a);
        n.c(a).setTitle("Error").setMessage("An error has occurred, please try again.").setPositiveButton("OK", new hw(this)).create().show();
    }

    public final void success(Object obj, Response response)
    {
        obj = (TermsOfServiceResponse)obj;
        TermsOfServiceActivity.b(a);
        j.a().g(((TermsOfServiceResponse) (obj)).hasTermsAccepted());
        a.finish();
    }
}
