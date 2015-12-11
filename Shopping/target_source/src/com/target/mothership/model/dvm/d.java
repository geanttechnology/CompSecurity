// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.dvm;

import com.target.mothership.model.c;
import com.target.mothership.model.dvm.interfaces.DvmRemoteData;
import com.target.mothership.util.g;
import com.target.mothership.util.h;

// Referenced classes of package com.target.mothership.model.dvm:
//            a, b

public class d extends c
    implements a
{

    private b mDvmLiveDataSource;

    public d()
    {
        mDvmLiveDataSource = new b();
    }

    public void a(DvmRemoteData dvmremotedata, com.target.mothership.model.h h1)
    {
        if (a())
        {
            h1.a(h.NETWORK_ERROR);
        } else
        {
            a("fetch_dvm_mock_response.json");
        }
        mDvmLiveDataSource.a(g.FAKE_DVM_REMOTE_DATA, h1);
    }

    public void a(String s, com.target.mothership.model.h h1)
    {
        if (a())
        {
            h1.a(h.NETWORK_ERROR);
        } else
        {
            h1.a(null);
        }
        mDvmLiveDataSource.a(s, h1);
    }
}
