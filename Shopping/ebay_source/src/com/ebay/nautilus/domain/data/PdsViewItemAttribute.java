// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;


// Referenced classes of package com.ebay.nautilus.domain.data:
//            PdsItemAttribute

public class PdsViewItemAttribute extends PdsItemAttribute
{

    public static final String COLON_SEPARATOR = ":";
    public static final int ITEM_ATTRIBUTE_DATA_COUNT = 3;
    private static final String PDS_VIEW_ITEM_PREFIX = "PdsItemInfoAlias?0?";
    private static final int SITE_ID_INDEX = 2;
    public String siteId;

    public PdsViewItemAttribute(long l, long l1, String s)
    {
        super(String.valueOf(l), String.valueOf(l1));
        siteId = s;
    }

    public PdsViewItemAttribute(String s)
    {
        super(s);
        s = s.split(":");
        if (s.length == 3)
        {
            siteId = s[2];
            return;
        } else
        {
            throw new IllegalArgumentException("Format mismatch: check the attributes string format");
        }
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (super.equals(obj) && obj.getClass() == getClass())
        {
            obj = (PdsViewItemAttribute)obj;
            return siteId.equals(((PdsViewItemAttribute) (obj)).siteId);
        } else
        {
            return false;
        }
    }

    public String getSeparatorCharacter()
    {
        return ":";
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("PdsItemInfoAlias?0?");
        stringbuilder.append(attributeValue).append(":").append(categoryId).append(":").append(siteId);
        return stringbuilder.toString();
    }
}
