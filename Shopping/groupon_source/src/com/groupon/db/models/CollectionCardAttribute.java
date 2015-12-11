// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.groupon.db.models:
//            DealCollection

public class CollectionCardAttribute
{

    public static final String BACKGROUND_IMAGE = "backgroundImage";
    public static final String CALL_TO_ACTION_IMAGE = "callToActionImage";
    public static final String CALL_TO_ACTION_TEXT = "callToActionText";
    public static final String CALL_TO_ACTION_TEXT_COLOR = "callToActionTextColor";
    public static final String COLLECTION_SIZE_TEXT = "collectionSizeText";
    public static final String COLLECTION_SIZE_TEXT_COLOR = "collectionSizeTextColor";
    public static final String DEEP_LINK = "deepLink";
    public static final String FOREIGN_COLLECTION_FIELD = "parentCollection";
    public static final String ICON_IMAGE = "iconImage";
    public static final String MAX_DISCOUNT_TEXT = "maxDiscountText";
    public static final String MAX_DISCOUNT_TEXT_COLOR = "maxDiscountTextColor";
    public static final String PARENT_UUID = "parentUUID";
    public static final Set PRESERVABLE_CARD_ATTRIBUTES = new HashSet(Arrays.asList(new String[] {
        "deepLink", "titleText", "backgroundImage", "iconImage", "callToActionText", "collectionSizeText", "maxDiscountText", "titleTextColor", "collectionSizeTextColor", "maxDiscountTextColor", 
        "callToActionTextColor"
    }));
    public static final String TITLE_TEXT = "titleText";
    public static final String TITLE_TEXT_COLOR = "titleTextColor";
    public Integer id;
    public String name;
    public DealCollection parentCollection;
    public String parentUUID;
    public String value;

    public CollectionCardAttribute()
    {
    }

    public static CollectionCardAttribute create(String s, String s1, Object obj)
    {
        if (!PRESERVABLE_CARD_ATTRIBUTES.contains(s1))
        {
            return null;
        }
        CollectionCardAttribute collectioncardattribute = new CollectionCardAttribute();
        collectioncardattribute.parentUUID = s;
        collectioncardattribute.name = s1;
        if (obj == null)
        {
            s = "";
        } else
        {
            s = String.valueOf(obj);
        }
        collectioncardattribute.value = s;
        return collectioncardattribute;
    }

}
