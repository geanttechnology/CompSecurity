// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appstate;

import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.appstate:
//            AppStateClient

class jz
    implements com.google.android.gms.common.api.
{

    final AppStateClient jz;

    public void a(Status status)
    {
    }

    public volatile void a(Object obj)
    {
        a((Status)obj);
    }

    (AppStateClient appstateclient)
    {
        jz = appstateclient;
        super();
    }
}
