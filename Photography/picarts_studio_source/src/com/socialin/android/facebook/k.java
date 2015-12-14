// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.facebook;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.GraphRequest;
import com.facebook.HttpMethod;
import com.socialin.android.apiv3.controllers.BaseSocialinApiRequestController;
import com.socialin.android.apiv3.request.RequestParams;
import com.socialin.asyncnet.d;

// Referenced classes of package com.socialin.android.facebook:
//            h

public final class k extends BaseSocialinApiRequestController
{

    Class a;
    private com.facebook.GraphRequest.Callback b;

    public k()
    {
        b = new _cls1();
    }

    static d a(k k1)
    {
        return k1.listener;
    }

    static Class b(k k1)
    {
        return k1.a;
    }

    static d c(k k1)
    {
        return k1.listener;
    }

    static RequestParams d(k k1)
    {
        return k1.params;
    }

    static RequestParams e(k k1)
    {
        return k1.params;
    }

    static d f(k k1)
    {
        return k1.listener;
    }

    public final void doRequest(String s, RequestParams requestparams)
    {
        requestparams = (h)requestparams;
        params = requestparams;
        Bundle bundle = new Bundle();
        bundle.putAll(((h) (requestparams)).e);
        if (TextUtils.isEmpty(((h) (requestparams)).d))
        {
            bundle.putString("limit", String.valueOf(((h) (requestparams)).limit));
            if (!TextUtils.isEmpty(((h) (requestparams)).c))
            {
                bundle.putString("after", ((h) (requestparams)).c);
            }
            s = ((h) (requestparams)).a;
        } else
        {
            s = Uri.parse(((h) (requestparams)).d);
            s = (new StringBuilder()).append(s.getPath()).append("?").append(s.getEncodedQuery()).toString();
        }
        (new GraphRequest(((h) (requestparams)).b, s, bundle, HttpMethod.GET, b)).executeAsync();
    }

    /* member class not found */
    class _cls1 {}

}
