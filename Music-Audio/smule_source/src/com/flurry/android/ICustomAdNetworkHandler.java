// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.Context;

// Referenced classes of package com.flurry.android:
//            AdCreative, AdNetworkView

public interface ICustomAdNetworkHandler
{

    public abstract AdNetworkView getAdFromNetwork(Context context, AdCreative adcreative, String s);
}
