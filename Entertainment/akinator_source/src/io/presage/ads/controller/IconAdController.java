// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.ads.controller;

import android.content.Context;
import io.presage.ads.NewAd;
import io.presage.ads.NewAdViewerDescriptor;

// Referenced classes of package io.presage.ads.controller:
//            DefaultAdController

public class IconAdController extends DefaultAdController
{

    public IconAdController(Context context, NewAd newad, NewAdViewerDescriptor newadviewerdescriptor, int i)
    {
        super(context, newad, newadviewerdescriptor, i);
    }

    public String getAdHistorySource()
    {
        return "icon";
    }
}
