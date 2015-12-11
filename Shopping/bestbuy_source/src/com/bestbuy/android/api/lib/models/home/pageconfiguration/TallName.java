// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.home.pageconfiguration;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.home.pageconfiguration:
//            Image

public class TallName
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private Image large;
    private Image small;

    public TallName()
    {
    }

    public Image getLarge()
    {
        return large;
    }

    public Image getSmall()
    {
        return small;
    }

    public void setLarge(Image image)
    {
        large = image;
    }

    public void setSmall(Image image)
    {
        small = image;
    }
}
