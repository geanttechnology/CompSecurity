// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.model.parentalcontrols;

import java.util.Collections;
import java.util.List;

// Referenced classes of package com.comcast.cim.model.parentalcontrols:
//            ParentalControlsPin

public class ParentalControlsSettings
{

    private final ParentalControlsPin parentalPin;
    private final List protectedNetworkIds;
    private final List protectedRatings;

    public ParentalControlsSettings(ParentalControlsPin parentalcontrolspin, List list, List list1)
    {
        parentalPin = parentalcontrolspin;
        protectedRatings = Collections.unmodifiableList(list);
        protectedNetworkIds = Collections.unmodifiableList(list1);
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (ParentalControlsSettings)obj;
            if (parentalPin == null ? ((ParentalControlsSettings) (obj)).parentalPin != null : !parentalPin.equals(((ParentalControlsSettings) (obj)).parentalPin))
            {
                return false;
            }
            if (protectedNetworkIds == null ? ((ParentalControlsSettings) (obj)).protectedNetworkIds != null : !protectedNetworkIds.equals(((ParentalControlsSettings) (obj)).protectedNetworkIds))
            {
                return false;
            }
            if (protectedRatings == null ? ((ParentalControlsSettings) (obj)).protectedRatings != null : !protectedRatings.equals(((ParentalControlsSettings) (obj)).protectedRatings))
            {
                return false;
            }
        }
        return true;
    }

    public ParentalControlsPin getParentalPin()
    {
        return parentalPin;
    }

    public List getProtectedNetworkIds()
    {
        return protectedNetworkIds;
    }

    public List getProtectedRatings()
    {
        return protectedRatings;
    }

    public int hashCode()
    {
        int k = 0;
        int i;
        int j;
        if (parentalPin != null)
        {
            i = parentalPin.hashCode();
        } else
        {
            i = 0;
        }
        if (protectedRatings != null)
        {
            j = protectedRatings.hashCode();
        } else
        {
            j = 0;
        }
        if (protectedNetworkIds != null)
        {
            k = protectedNetworkIds.hashCode();
        }
        return (i * 31 + j) * 31 + k;
    }
}
