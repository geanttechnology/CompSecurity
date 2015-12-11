// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mraid;


// Referenced classes of package com.mopub.mraid:
//            MraidJavascriptCommand, PlacementType

static final class nit> extends MraidJavascriptCommand
{

    boolean requiresClick(PlacementType placementtype)
    {
        return placementtype == PlacementType.INLINE;
    }

    (String s, int i, String s1)
    {
        super(s, i, s1, null);
    }
}
