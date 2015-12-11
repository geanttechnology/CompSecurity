// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.crashmanager;

import android.os.Build;

// Referenced classes of package com.amazon.device.crashmanager:
//            DomainChooser, Domain

public class DefaultDomainChooser
    implements DomainChooser
{

    public DefaultDomainChooser()
    {
    }

    public Domain chooseDomain()
    {
        if (Build.TYPE.equals("user") || Build.TYPE.equals("userdebug"))
        {
            return Domain.PROD;
        } else
        {
            return Domain.BETA;
        }
    }
}
