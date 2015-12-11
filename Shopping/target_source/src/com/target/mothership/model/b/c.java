// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.b;

import com.target.mothership.b;
import com.target.mothership.common.params.GoogleNowSendCardParams;
import com.target.mothership.model.a;
import com.target.mothership.model.h;

// Referenced classes of package com.target.mothership.model.b:
//            d, b, a

public class c extends a
{

    private final com.target.mothership.model.b.a mGoogleNowDataSource;

    public c()
    {
        if (b.a().m())
        {
            mGoogleNowDataSource = new d();
            return;
        } else
        {
            mGoogleNowDataSource = new com.target.mothership.model.b.b();
            return;
        }
    }

    public void a(GoogleNowSendCardParams googlenowsendcardparams, h h)
    {
        mGoogleNowDataSource.a(googlenowsendcardparams, h);
    }

    public void a(GoogleNowSendCardParams googlenowsendcardparams, String s, h h)
    {
        mGoogleNowDataSource.a(googlenowsendcardparams, s, h);
    }

    public void a(String s, h h)
    {
        mGoogleNowDataSource.a(s, h);
    }
}
