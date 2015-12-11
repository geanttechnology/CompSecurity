// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;

import com.groupon.util.SortableCard;
import java.util.Arrays;
import roboguice.util.Strings;

public class Finder
    implements SortableCard
{
    public static class CardAttributes
    {

        public String callToActionText;
        public String callToActionTextColor;
        public String deepLink;
        public String maxDiscountText;
        public String maxDiscountTextColor;
        public String mobileBackgroundImage;
        public String mobileCallToActionImage;
        public String mobileIconImage;
        public String titleText;
        public String titleTextColor;

        public CardAttributes()
        {
            titleText = "";
            mobileBackgroundImage = "";
            titleTextColor = "";
            maxDiscountText = "";
            maxDiscountTextColor = "";
            callToActionTextColor = "";
            callToActionText = "";
            mobileCallToActionImage = "";
            mobileIconImage = "";
            deepLink = "";
        }
    }


    public static final String BOOKABLE_FINDER_CARD_TYPE = "Bookable";
    public static final String UUID = "uuid";
    private static final String UUID_COMPONENTS_SEPARATOR = ":";
    public String backgroundImage;
    public String callToActionImage;
    public String callToActionText;
    public String callToActionTextColor;
    private CardAttributes cardAttributes;
    public String channel;
    public String deepLink;
    public int derivedActualPosition;
    public int derivedTrackingPosition;
    public String discountText;
    public String discountTextColor;
    public String iconImage;
    public String name;
    public Long primaryKey;
    public String titleText;
    public String titleTextColor;
    public String type;
    public String uuid;

    public Finder()
    {
        name = "";
        type = "";
        cardAttributes = new CardAttributes();
        titleText = "";
        titleTextColor = "";
        discountText = "";
        discountTextColor = "";
        callToActionTextColor = "";
        callToActionText = "";
        backgroundImage = "";
        callToActionImage = "";
        iconImage = "";
        deepLink = "";
    }

    public void afterJsonDeserializationPostProcessor()
    {
        titleText = cardAttributes.titleText;
        titleTextColor = cardAttributes.titleTextColor;
        discountText = cardAttributes.maxDiscountText;
        discountTextColor = cardAttributes.maxDiscountTextColor;
        callToActionText = cardAttributes.callToActionText;
        callToActionTextColor = cardAttributes.callToActionTextColor;
        backgroundImage = cardAttributes.mobileBackgroundImage;
        callToActionImage = cardAttributes.mobileCallToActionImage;
        iconImage = cardAttributes.mobileIconImage;
        String s;
        if (cardAttributes.deepLink != null)
        {
            s = cardAttributes.deepLink;
        } else
        {
            s = "";
        }
        deepLink = s;
        if (Strings.isEmpty(uuid))
        {
            uuid = Strings.md5(Strings.join(":", new String[] {
                titleText, deepLink, name, type
            }));
        }
    }

    public int cardPosition()
    {
        return derivedActualPosition;
    }

    public String toString()
    {
        return (new StringBuilder(getClass().getSimpleName())).append('{').append(Strings.join(",", Arrays.asList(new String[] {
            type, name, deepLink
        }))).append('}').toString();
    }
}
