// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.b;

import android.os.Bundle;
import com.b.a.a.g;
import com.b.a.a.j;
import com.offerup.android.d.e;
import com.offerup.android.dto.response.UserResponse;
import com.offerup.android.network.b;
import com.offerup.android.tracker.a;
import com.offerup.android.utils.as;
import com.offerup.android.utils.ba;
import com.offerup.android.utils.n;
import com.offerup.android.utils.u;
import com.offerup.android.utils.v;
import org.apache.commons.lang3.StringUtils;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.offerup.android.g.b:
//            z, af

public final class ae
    implements e
{

    private z a;

    public ae(z z1)
    {
        a = z1;
        super();
    }

    public final void a()
    {
        com.offerup.android.g.b.z.a(a, "", a.getString(0x7f09014b));
    }

    public final void a(int i)
    {
        switch (i)
        {
        default:
            return;

        case 15: // '\017'
            as.a(z.c(a), a.getString(0x7f09010b));
            return;

        case 11: // '\013'
            as.a(com.offerup.android.g.b.z.a(a), a.getString(0x7f09010a));
            return;

        case 12: // '\f'
            as.a(com.offerup.android.g.b.z.a(a), a.getString(0x7f09011e));
            return;

        case 13: // '\r'
            as.a(com.offerup.android.g.b.z.b(a), a.getString(0x7f09010c));
            return;

        case 14: // '\016'
            as.a(com.offerup.android.g.b.z.b(a), a.getString(0x7f09011f));
            return;
        }
    }

    public final void a(UserResponse userresponse)
    {
        com.offerup.android.tracker.a.b("Signup_Signup-Button_success");
        n.a(z.f(a));
        if (userresponse != null && userresponse.isSuccess())
        {
            ba.a(a.getContext(), userresponse.getUser());
            userresponse = new Bundle();
            userresponse.putString("fb_registration_method", "Email");
            v.a(a.getContext(), "fb_mobile_complete_registration", userresponse);
            if (StringUtils.isNotEmpty(com.offerup.android.g.b.z.g(a).l()))
            {
                b.a();
                a.dismiss();
            } else
            {
                g.a(this, new Throwable("Unable to get user token"));
                n.a(a.getActivity(), a.getString(0x7f0901f3), a.getString(0x7f09017b));
            }
        }
        if (z.h(a) != null)
        {
            z.h(a).e();
        }
    }

    public final void a(RetrofitError retrofiterror)
    {
        n.a(z.f(a));
        if (retrofiterror.getResponse() != null)
        {
            if (retrofiterror.getResponse().getStatus() == 409)
            {
                n.a(a.getActivity(), a.getString(0x7f0901f3), a.getString(0x7f0901f2));
                return;
            } else
            {
                n.a(a.getActivity(), a.getString(0x7f0901f3), u.a(retrofiterror, a.getString(0x7f09017b)));
                return;
            }
        } else
        {
            n.a(a.getActivity());
            return;
        }
    }
}
