// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.bazaar_voice;

import com.target.mothership.common.params.c;
import com.target.mothership.model.a;
import com.target.mothership.model.h;

// Referenced classes of package com.target.mothership.model.bazaar_voice:
//            d, c, a

public class b extends a
    implements d
{

    private d mBazaarVoiceDataSource;

    public b()
    {
        if (com.target.mothership.b.a().m())
        {
            mBazaarVoiceDataSource = new com.target.mothership.model.bazaar_voice.c();
            return;
        } else
        {
            mBazaarVoiceDataSource = new com.target.mothership.model.bazaar_voice.a();
            return;
        }
    }

    public void a(c c1, h h)
    {
        mBazaarVoiceDataSource.a(c1, h);
    }
}
