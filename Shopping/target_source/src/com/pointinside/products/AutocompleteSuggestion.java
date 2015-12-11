// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.products;

import com.pointinside.internal.utils.Objects;
import java.util.UUID;

public final class AutocompleteSuggestion
{

    final Boolean isBoosted;
    final transient UUID mUUID;
    final String suggestion;

    AutocompleteSuggestion()
    {
        suggestion = null;
        isBoosted = null;
        mUUID = UUID.randomUUID();
    }

    AutocompleteSuggestion(String s, boolean flag, UUID uuid)
    {
        suggestion = s;
        isBoosted = Boolean.valueOf(flag);
        mUUID = uuid;
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (!(obj instanceof AutocompleteSuggestion))
        {
            return false;
        } else
        {
            obj = (AutocompleteSuggestion)obj;
            return mUUID.equals(((AutocompleteSuggestion) (obj)).mUUID);
        }
    }

    public String getTerm()
    {
        return suggestion;
    }

    public int hashCode()
    {
        return Objects.hash(new Object[] {
            suggestion, isBoosted, mUUID
        });
    }

    public boolean isBoosted()
    {
        return isBoosted.booleanValue();
    }
}
