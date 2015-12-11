// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.ads;


// Referenced classes of package com.comcast.playerplatform.primetime.android.ads:
//            VideoAdBreak

static class estrictionType
{

    static final int $SwitchMap$com$comcast$playerplatform$primetime$android$ads$AdRestriction$RestrictionType[];

    static 
    {
        $SwitchMap$com$comcast$playerplatform$primetime$android$ads$AdRestriction$RestrictionType = new int[estrictionType.values().length];
        try
        {
            $SwitchMap$com$comcast$playerplatform$primetime$android$ads$AdRestriction$RestrictionType[estrictionType.SEEK.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$comcast$playerplatform$primetime$android$ads$AdRestriction$RestrictionType[estrictionType.PAUSE.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
