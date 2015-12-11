// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;

// Referenced classes of package com.amazon.device.ads:
//            WebRequest

interface AuthenticationPlatformAdapter
{

    public abstract String getAccountName();

    public abstract String getPreferredMarketplace();

    public abstract WebRequest makeAuthenticatedWebRequest(String s);

    public abstract AuthenticationPlatformAdapter setContext(Context context);
}
