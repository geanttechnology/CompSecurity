// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.text.TextUtils;

public abstract class PdsItemAttribute
{

    protected static final int ATTRIBUTE_VALUE_INDEX = 0;
    protected static final int CATEGORY_ID_INDEX = 1;
    private static final int ITEM_ATTRIBUTE_DATA_COUNT = 2;
    public final String attributeValue;
    public final String categoryId;

    protected PdsItemAttribute(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("PdsItemAttribute must be constructed with a valid attributeValue and categoryId");
        }
        s = s.split(getSeparatorCharacter());
        if (s.length >= 2)
        {
            attributeValue = s[0];
            categoryId = s[1];
            return;
        } else
        {
            throw new IllegalArgumentException("PdsItemAttribute must be constructed with a valid attributeValue and categoryId");
        }
    }

    protected PdsItemAttribute(String s, String s1)
    {
        if (TextUtils.isEmpty(s) || TextUtils.isEmpty(s1))
        {
            throw new IllegalArgumentException("PdsItemAttribute must be constructed with a valid attributeValue and categoryId");
        } else
        {
            attributeValue = s;
            categoryId = s1;
            return;
        }
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj != null && obj.getClass() == getClass())
            {
                if (!attributeValue.equalsIgnoreCase(((PdsItemAttribute) (obj = (PdsItemAttribute)obj)).attributeValue) || !categoryId.equals(((PdsItemAttribute) (obj)).categoryId))
                {
                    return false;
                }
            } else
            {
                return false;
            }
        }
        return true;
    }

    public abstract String getSeparatorCharacter();
}
