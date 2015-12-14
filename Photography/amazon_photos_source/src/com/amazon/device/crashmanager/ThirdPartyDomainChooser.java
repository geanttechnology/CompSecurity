// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.crashmanager;

import android.content.pm.ApplicationInfo;

// Referenced classes of package com.amazon.device.crashmanager:
//            DomainChooser, Domain

class ThirdPartyDomainChooser
    implements DomainChooser
{

    private final boolean mAppIsDebuggable;

    ThirdPartyDomainChooser(ApplicationInfo applicationinfo)
    {
        boolean flag;
        if ((applicationinfo.flags & 2) == 0)
        {
            flag = false;
        } else
        {
            flag = true;
        }
        mAppIsDebuggable = flag;
    }

    public Domain chooseDomain()
    {
        if (!mAppIsDebuggable)
        {
            return Domain.PROD;
        } else
        {
            return Domain.BETA;
        }
    }
}
