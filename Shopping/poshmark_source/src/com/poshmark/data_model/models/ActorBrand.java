// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models;

import java.util.List;

// Referenced classes of package com.poshmark.data_model.models:
//            Actor, Brand

public class ActorBrand extends Actor
{

    List data;

    public ActorBrand()
    {
    }

    public String getAvataar()
    {
        return ((Brand)data.get(0)).getBrandLogoThumbnail();
    }

    public int getDefaultAvataarImageId()
    {
        return 0x7f02006b;
    }

    public String getId()
    {
        return null;
    }

    public String getName()
    {
        return ((Brand)data.get(0)).getBrandCanonicalName();
    }
}
