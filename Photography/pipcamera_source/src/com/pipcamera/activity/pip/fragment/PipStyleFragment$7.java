// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.pip.fragment;

import android.util.Log;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.pipcamera.activity.pip.PipStyleActivity;
import jw;
import org.apache.http.Header;
import org.json.JSONObject;

// Referenced classes of package com.pipcamera.activity.pip.fragment:
//            PipStyleFragment

class a extends JsonHttpResponseHandler
{

    final PipStyleFragment a;

    public void onFailure(int i, Header aheader[], Throwable throwable, JSONObject jsonobject)
    {
        Log.v("PipStyleFragment", (new StringBuilder()).append("PipStyleFragmentonFailure statusCode:").append(i).toString());
        if (jsonobject != null)
        {
            Log.v("PipStyleFragment", (new StringBuilder()).append("PipStyleFragmentonFailure errorResponse:").append(jsonobject.toString()).toString());
        }
        if (PipStyleFragment.d(a) != null)
        {
            PipStyleFragment.d(a).n();
        }
    }

    public void onSuccess(int i, Header aheader[], JSONObject jsonobject)
    {
        if (i == 200 && jsonobject != null)
        {
            if (PipStyleFragment.d(a) != null)
            {
                PipStyleFragment.d(a).n();
            }
            if (PipStyleFragment.a(a, jsonobject))
            {
                PipStyleFragment.d(a).j().c(PipStyleFragment.o(a));
                PipStyleFragment.d(a).j().a(PipStyleFragment.o(a), jsonobject, 300);
                PipStyleFragment.p(a);
            }
        }
    }

    (PipStyleFragment pipstylefragment)
    {
        a = pipstylefragment;
        super();
    }
}
