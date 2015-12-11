// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.home.pageconfiguration;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.home.pageconfiguration:
//            Image

public class ShortName
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private Image large;

    public ShortName()
    {
    }

    public Image getLarge()
    {
        return large;
    }

    public void setLarge(Image image)
    {
        large = image;
    }
}
