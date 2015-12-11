// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.meta_data;


// Referenced classes of package com.poshmark.utils.meta_data:
//            AvailabilityMetaData

static class AILABILITY_TYPE
{

    static final int $SwitchMap$com$poshmark$utils$meta_data$AvailabilityMetaData$AVAILABILITY_TYPE[];

    static 
    {
        $SwitchMap$com$poshmark$utils$meta_data$AvailabilityMetaData$AVAILABILITY_TYPE = new int[AILABILITY_TYPE.values().length];
        try
        {
            $SwitchMap$com$poshmark$utils$meta_data$AvailabilityMetaData$AVAILABILITY_TYPE[AILABILITY_TYPE.ALL.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$poshmark$utils$meta_data$AvailabilityMetaData$AVAILABILITY_TYPE[AILABILITY_TYPE.SOLD.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$poshmark$utils$meta_data$AvailabilityMetaData$AVAILABILITY_TYPE[AILABILITY_TYPE.UNSOLD.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
