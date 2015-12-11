// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.model.parentalcontrols;

import java.io.Serializable;
import org.apache.commons.lang3.Validate;

public class ParentalControlsPin
    implements Serializable
{

    private final String pin;

    public ParentalControlsPin(String s)
    {
        Validate.notBlank(s);
        pin = s;
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        } else
        {
            obj = (ParentalControlsPin)obj;
            return pin.equals(((ParentalControlsPin) (obj)).pin);
        }
    }

    public String getPin()
    {
        return pin;
    }

    public int hashCode()
    {
        return pin.hashCode();
    }

    public String toString()
    {
        return getPin();
    }
}
