// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.preference;

import android.app.Activity;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.d;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.preference:
//            e

final class a
    implements d
{

    private e a;

    public final volatile void onCancelRequest(Object obj, Request request)
    {
    }

    public final void onFailure(Exception exception, Request request)
    {
        m.b(a.getActivity(), e.a(a));
        if (a.getActivity() != null)
        {
            a.getActivity().setResult(-1);
            a.getActivity().finish();
        }
    }

    public final transient void onProgressUpdate(Integer ainteger[])
    {
    }

    public final void onSuccess(Object obj, Request request)
    {
        m.b(a.getActivity(), e.a(a));
        if (a.getActivity() != null)
        {
            a.getActivity().setResult(-1);
            a.getActivity().finish();
        }
    }

    (e e1)
    {
        a = e1;
        super();
    }
}
