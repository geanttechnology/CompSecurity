// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.advertising;

import android.os.Binder;

// Referenced classes of package com.medialets.advertising:
//            AdManagerService

public class a extends Binder
{

    private AdManagerService a;

    public AdManagerService getService()
    {
        return a;
    }

    public _cls9(AdManagerService admanagerservice)
    {
        a = admanagerservice;
        super();
    }
}
