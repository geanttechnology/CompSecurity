// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.pip.fragment;

import android.util.Log;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.pipcamera.activity.pip.PipRealTimeCameraActivity;
import jw;
import org.apache.http.Header;
import org.json.JSONObject;

// Referenced classes of package com.pipcamera.activity.pip.fragment:
//            PipCameraFragment

class a extends JsonHttpResponseHandler
{

    final PipCameraFragment a;

    public void onFailure(int i, Header aheader[], Throwable throwable, JSONObject jsonobject)
    {
        Log.v("PipCameraFragment", (new StringBuilder()).append("PipCameraFragmentonFailure statusCode:").append(i).toString());
        if (jsonobject != null)
        {
            Log.v("PipCameraFragment", (new StringBuilder()).append("PipCameraFragmentonFailure errorResponse:").append(jsonobject.toString()).toString());
        }
        if (PipCameraFragment.d(a) != null)
        {
            PipCameraFragment.d(a).n();
        }
    }

    public void onSuccess(int i, Header aheader[], JSONObject jsonobject)
    {
        if (i == 200 && jsonobject != null)
        {
            if (PipCameraFragment.d(a) != null)
            {
                PipCameraFragment.d(a).n();
            }
            if (PipCameraFragment.a(a, jsonobject))
            {
                PipCameraFragment.d(a).j().c(PipCameraFragment.n(a));
                PipCameraFragment.d(a).j().a(PipCameraFragment.n(a), jsonobject, 300);
                PipCameraFragment.o(a);
            }
        }
    }

    (PipCameraFragment pipcamerafragment)
    {
        a = pipcamerafragment;
        super();
    }
}
