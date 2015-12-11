// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps.model;


// Referenced classes of package com.pointinside.maps.model:
//            AnchorPoint

public class NearbyDef
{

    private AnchorPoint anchorPoint;

    public NearbyDef(AnchorPoint anchorpoint)
    {
        anchorPoint = anchorpoint;
    }

    public String toString()
    {
        return (new StringBuilder()).append("[anchorPoint = ").append(anchorPoint).append("]").toString();
    }
}
