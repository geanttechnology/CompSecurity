// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm.listingdraft;


public final class ListingDraftOperation extends Enum
{

    private static final ListingDraftOperation $VALUES[];
    public static final ListingDraftOperation CREATE;
    public static final ListingDraftOperation CREATE_RELIST;
    public static final ListingDraftOperation DELETE_SAVED_DRAFTS;
    public static final ListingDraftOperation GET;
    public static final ListingDraftOperation GET_SAVED_DRAFTS;
    public static final ListingDraftOperation PUBLISH;
    public static final ListingDraftOperation UPDATE_BEST_OFFER;
    public static final ListingDraftOperation UPDATE_CATEGORY;
    public static final ListingDraftOperation UPDATE_CHARITY_ID;
    public static final ListingDraftOperation UPDATE_CHARITY_PERCENTAGE;
    public static final ListingDraftOperation UPDATE_CONDITION;
    public static final ListingDraftOperation UPDATE_CONDITION_DESCRIPTION;
    public static final ListingDraftOperation UPDATE_CURRENCY;
    public static final ListingDraftOperation UPDATE_DELETE_SHIPPING;
    public static final ListingDraftOperation UPDATE_DESCRIPTION;
    public static final ListingDraftOperation UPDATE_DROP_PRODUCT;
    public static final ListingDraftOperation UPDATE_FORMAT;
    public static final ListingDraftOperation UPDATE_FOR_REVIEW;
    public static final ListingDraftOperation UPDATE_HANDLING_TIME;
    public static final ListingDraftOperation UPDATE_IMMEDIATE_PAY;
    public static final ListingDraftOperation UPDATE_ITEM_SPECIFICS;
    public static final ListingDraftOperation UPDATE_LOCATION;
    public static final ListingDraftOperation UPDATE_PACKAGE_DETAILS;
    public static final ListingDraftOperation UPDATE_PAYMENT_METHODS;
    public static final ListingDraftOperation UPDATE_PHOTOS_AFTER_INDEX_0;
    public static final ListingDraftOperation UPDATE_PHOTOS_AFTER_INDEX_1;
    public static final ListingDraftOperation UPDATE_PHOTOS_AFTER_INDEX_10;
    public static final ListingDraftOperation UPDATE_PHOTOS_AFTER_INDEX_11;
    public static final ListingDraftOperation UPDATE_PHOTOS_AFTER_INDEX_12;
    public static final ListingDraftOperation UPDATE_PHOTOS_AFTER_INDEX_13;
    public static final ListingDraftOperation UPDATE_PHOTOS_AFTER_INDEX_14;
    public static final ListingDraftOperation UPDATE_PHOTOS_AFTER_INDEX_15;
    public static final ListingDraftOperation UPDATE_PHOTOS_AFTER_INDEX_16;
    public static final ListingDraftOperation UPDATE_PHOTOS_AFTER_INDEX_17;
    public static final ListingDraftOperation UPDATE_PHOTOS_AFTER_INDEX_18;
    public static final ListingDraftOperation UPDATE_PHOTOS_AFTER_INDEX_19;
    public static final ListingDraftOperation UPDATE_PHOTOS_AFTER_INDEX_2;
    public static final ListingDraftOperation UPDATE_PHOTOS_AFTER_INDEX_20;
    public static final ListingDraftOperation UPDATE_PHOTOS_AFTER_INDEX_21;
    public static final ListingDraftOperation UPDATE_PHOTOS_AFTER_INDEX_22;
    public static final ListingDraftOperation UPDATE_PHOTOS_AFTER_INDEX_23;
    public static final ListingDraftOperation UPDATE_PHOTOS_AFTER_INDEX_3;
    public static final ListingDraftOperation UPDATE_PHOTOS_AFTER_INDEX_4;
    public static final ListingDraftOperation UPDATE_PHOTOS_AFTER_INDEX_5;
    public static final ListingDraftOperation UPDATE_PHOTOS_AFTER_INDEX_6;
    public static final ListingDraftOperation UPDATE_PHOTOS_AFTER_INDEX_7;
    public static final ListingDraftOperation UPDATE_PHOTOS_AFTER_INDEX_8;
    public static final ListingDraftOperation UPDATE_PHOTOS_AFTER_INDEX_9;
    public static final ListingDraftOperation UPDATE_PREFERENCE_FREE_TEXT;
    public static final ListingDraftOperation UPDATE_PRICE_AUCTION;
    public static final ListingDraftOperation UPDATE_PRICE_FIXED;
    public static final ListingDraftOperation UPDATE_REFUND_METHOD;
    public static final ListingDraftOperation UPDATE_REMOVE_STOCK_PHOTO;
    public static final ListingDraftOperation UPDATE_RESTOCKING_FEE;
    public static final ListingDraftOperation UPDATE_RETURNS_ACCEPTED;
    public static final ListingDraftOperation UPDATE_RETURN_PERIOD;
    public static final ListingDraftOperation UPDATE_RETURN_SHIPPING_PAID_BY;
    public static final ListingDraftOperation UPDATE_SHIPPING;
    public static final ListingDraftOperation UPDATE_SHIPPING_FOR_GUIDANCE;
    public static final ListingDraftOperation UPDATE_START_RANGE;
    public static final ListingDraftOperation UPDATE_START_TIME_DURATION;
    public static final ListingDraftOperation UPDATE_TITLES;

    private ListingDraftOperation(String s, int i)
    {
        super(s, i);
    }

    public static ListingDraftOperation fromOrdinal(int i)
    {
        return values()[i];
    }

    public static ListingDraftOperation valueOf(String s)
    {
        return (ListingDraftOperation)Enum.valueOf(com/ebay/nautilus/domain/content/dm/listingdraft/ListingDraftOperation, s);
    }

    public static ListingDraftOperation[] values()
    {
        return (ListingDraftOperation[])$VALUES.clone();
    }

    public boolean shouldCompletionTriggerSecondaryTasks()
    {
        static class _cls1
        {

            static final int $SwitchMap$com$ebay$nautilus$domain$content$dm$listingdraft$ListingDraftOperation[];

            static 
            {
                $SwitchMap$com$ebay$nautilus$domain$content$dm$listingdraft$ListingDraftOperation = new int[ListingDraftOperation.values().length];
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$content$dm$listingdraft$ListingDraftOperation[ListingDraftOperation.CREATE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$content$dm$listingdraft$ListingDraftOperation[ListingDraftOperation.CREATE_RELIST.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$content$dm$listingdraft$ListingDraftOperation[ListingDraftOperation.GET.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$content$dm$listingdraft$ListingDraftOperation[ListingDraftOperation.UPDATE_CATEGORY.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.ebay.nautilus.domain.content.dm.listingdraft.ListingDraftOperation[ordinal()])
        {
        default:
            return false;

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
            return true;
        }
    }

    static 
    {
        GET_SAVED_DRAFTS = new ListingDraftOperation("GET_SAVED_DRAFTS", 0);
        DELETE_SAVED_DRAFTS = new ListingDraftOperation("DELETE_SAVED_DRAFTS", 1);
        GET = new ListingDraftOperation("GET", 2);
        CREATE = new ListingDraftOperation("CREATE", 3);
        CREATE_RELIST = new ListingDraftOperation("CREATE_RELIST", 4);
        PUBLISH = new ListingDraftOperation("PUBLISH", 5);
        UPDATE_START_RANGE = new ListingDraftOperation("UPDATE_START_RANGE", 6);
        UPDATE_FOR_REVIEW = new ListingDraftOperation("UPDATE_FOR_REVIEW", 7);
        UPDATE_TITLES = new ListingDraftOperation("UPDATE_TITLES", 8);
        UPDATE_CONDITION = new ListingDraftOperation("UPDATE_CONDITION", 9);
        UPDATE_DROP_PRODUCT = new ListingDraftOperation("UPDATE_DROP_PRODUCT", 10);
        UPDATE_CATEGORY = new ListingDraftOperation("UPDATE_CATEGORY", 11);
        UPDATE_ITEM_SPECIFICS = new ListingDraftOperation("UPDATE_ITEM_SPECIFICS", 12);
        UPDATE_DESCRIPTION = new ListingDraftOperation("UPDATE_DESCRIPTION", 13);
        UPDATE_FORMAT = new ListingDraftOperation("UPDATE_FORMAT", 14);
        UPDATE_PRICE_AUCTION = new ListingDraftOperation("UPDATE_PRICE_AUCTION", 15);
        UPDATE_PRICE_FIXED = new ListingDraftOperation("UPDATE_PRICE_FIXED", 16);
        UPDATE_BEST_OFFER = new ListingDraftOperation("UPDATE_BEST_OFFER", 17);
        UPDATE_RETURNS_ACCEPTED = new ListingDraftOperation("UPDATE_RETURNS_ACCEPTED", 18);
        UPDATE_PREFERENCE_FREE_TEXT = new ListingDraftOperation("UPDATE_PREFERENCE_FREE_TEXT", 19);
        UPDATE_HANDLING_TIME = new ListingDraftOperation("UPDATE_HANDLING_TIME", 20);
        UPDATE_LOCATION = new ListingDraftOperation("UPDATE_LOCATION", 21);
        UPDATE_RETURN_PERIOD = new ListingDraftOperation("UPDATE_RETURN_PERIOD", 22);
        UPDATE_REFUND_METHOD = new ListingDraftOperation("UPDATE_REFUND_METHOD", 23);
        UPDATE_RETURN_SHIPPING_PAID_BY = new ListingDraftOperation("UPDATE_RETURN_SHIPPING_PAID_BY", 24);
        UPDATE_PAYMENT_METHODS = new ListingDraftOperation("UPDATE_PAYMENT_METHODS", 25);
        UPDATE_SHIPPING = new ListingDraftOperation("UPDATE_SHIPPING", 26);
        UPDATE_SHIPPING_FOR_GUIDANCE = new ListingDraftOperation("UPDATE_SHIPPING_FOR_GUIDANCE", 27);
        UPDATE_IMMEDIATE_PAY = new ListingDraftOperation("UPDATE_IMMEDIATE_PAY", 28);
        UPDATE_CURRENCY = new ListingDraftOperation("UPDATE_CURRENCY", 29);
        UPDATE_REMOVE_STOCK_PHOTO = new ListingDraftOperation("UPDATE_REMOVE_STOCK_PHOTO", 30);
        UPDATE_START_TIME_DURATION = new ListingDraftOperation("UPDATE_START_TIME_DURATION", 31);
        UPDATE_PACKAGE_DETAILS = new ListingDraftOperation("UPDATE_PACKAGE_DETAILS", 32);
        UPDATE_DELETE_SHIPPING = new ListingDraftOperation("UPDATE_DELETE_SHIPPING", 33);
        UPDATE_RESTOCKING_FEE = new ListingDraftOperation("UPDATE_RESTOCKING_FEE", 34);
        UPDATE_CHARITY_ID = new ListingDraftOperation("UPDATE_CHARITY_ID", 35);
        UPDATE_CHARITY_PERCENTAGE = new ListingDraftOperation("UPDATE_CHARITY_PERCENTAGE", 36);
        UPDATE_CONDITION_DESCRIPTION = new ListingDraftOperation("UPDATE_CONDITION_DESCRIPTION", 37);
        UPDATE_PHOTOS_AFTER_INDEX_0 = new ListingDraftOperation("UPDATE_PHOTOS_AFTER_INDEX_0", 38);
        UPDATE_PHOTOS_AFTER_INDEX_1 = new ListingDraftOperation("UPDATE_PHOTOS_AFTER_INDEX_1", 39);
        UPDATE_PHOTOS_AFTER_INDEX_2 = new ListingDraftOperation("UPDATE_PHOTOS_AFTER_INDEX_2", 40);
        UPDATE_PHOTOS_AFTER_INDEX_3 = new ListingDraftOperation("UPDATE_PHOTOS_AFTER_INDEX_3", 41);
        UPDATE_PHOTOS_AFTER_INDEX_4 = new ListingDraftOperation("UPDATE_PHOTOS_AFTER_INDEX_4", 42);
        UPDATE_PHOTOS_AFTER_INDEX_5 = new ListingDraftOperation("UPDATE_PHOTOS_AFTER_INDEX_5", 43);
        UPDATE_PHOTOS_AFTER_INDEX_6 = new ListingDraftOperation("UPDATE_PHOTOS_AFTER_INDEX_6", 44);
        UPDATE_PHOTOS_AFTER_INDEX_7 = new ListingDraftOperation("UPDATE_PHOTOS_AFTER_INDEX_7", 45);
        UPDATE_PHOTOS_AFTER_INDEX_8 = new ListingDraftOperation("UPDATE_PHOTOS_AFTER_INDEX_8", 46);
        UPDATE_PHOTOS_AFTER_INDEX_9 = new ListingDraftOperation("UPDATE_PHOTOS_AFTER_INDEX_9", 47);
        UPDATE_PHOTOS_AFTER_INDEX_10 = new ListingDraftOperation("UPDATE_PHOTOS_AFTER_INDEX_10", 48);
        UPDATE_PHOTOS_AFTER_INDEX_11 = new ListingDraftOperation("UPDATE_PHOTOS_AFTER_INDEX_11", 49);
        UPDATE_PHOTOS_AFTER_INDEX_12 = new ListingDraftOperation("UPDATE_PHOTOS_AFTER_INDEX_12", 50);
        UPDATE_PHOTOS_AFTER_INDEX_13 = new ListingDraftOperation("UPDATE_PHOTOS_AFTER_INDEX_13", 51);
        UPDATE_PHOTOS_AFTER_INDEX_14 = new ListingDraftOperation("UPDATE_PHOTOS_AFTER_INDEX_14", 52);
        UPDATE_PHOTOS_AFTER_INDEX_15 = new ListingDraftOperation("UPDATE_PHOTOS_AFTER_INDEX_15", 53);
        UPDATE_PHOTOS_AFTER_INDEX_16 = new ListingDraftOperation("UPDATE_PHOTOS_AFTER_INDEX_16", 54);
        UPDATE_PHOTOS_AFTER_INDEX_17 = new ListingDraftOperation("UPDATE_PHOTOS_AFTER_INDEX_17", 55);
        UPDATE_PHOTOS_AFTER_INDEX_18 = new ListingDraftOperation("UPDATE_PHOTOS_AFTER_INDEX_18", 56);
        UPDATE_PHOTOS_AFTER_INDEX_19 = new ListingDraftOperation("UPDATE_PHOTOS_AFTER_INDEX_19", 57);
        UPDATE_PHOTOS_AFTER_INDEX_20 = new ListingDraftOperation("UPDATE_PHOTOS_AFTER_INDEX_20", 58);
        UPDATE_PHOTOS_AFTER_INDEX_21 = new ListingDraftOperation("UPDATE_PHOTOS_AFTER_INDEX_21", 59);
        UPDATE_PHOTOS_AFTER_INDEX_22 = new ListingDraftOperation("UPDATE_PHOTOS_AFTER_INDEX_22", 60);
        UPDATE_PHOTOS_AFTER_INDEX_23 = new ListingDraftOperation("UPDATE_PHOTOS_AFTER_INDEX_23", 61);
        $VALUES = (new ListingDraftOperation[] {
            GET_SAVED_DRAFTS, DELETE_SAVED_DRAFTS, GET, CREATE, CREATE_RELIST, PUBLISH, UPDATE_START_RANGE, UPDATE_FOR_REVIEW, UPDATE_TITLES, UPDATE_CONDITION, 
            UPDATE_DROP_PRODUCT, UPDATE_CATEGORY, UPDATE_ITEM_SPECIFICS, UPDATE_DESCRIPTION, UPDATE_FORMAT, UPDATE_PRICE_AUCTION, UPDATE_PRICE_FIXED, UPDATE_BEST_OFFER, UPDATE_RETURNS_ACCEPTED, UPDATE_PREFERENCE_FREE_TEXT, 
            UPDATE_HANDLING_TIME, UPDATE_LOCATION, UPDATE_RETURN_PERIOD, UPDATE_REFUND_METHOD, UPDATE_RETURN_SHIPPING_PAID_BY, UPDATE_PAYMENT_METHODS, UPDATE_SHIPPING, UPDATE_SHIPPING_FOR_GUIDANCE, UPDATE_IMMEDIATE_PAY, UPDATE_CURRENCY, 
            UPDATE_REMOVE_STOCK_PHOTO, UPDATE_START_TIME_DURATION, UPDATE_PACKAGE_DETAILS, UPDATE_DELETE_SHIPPING, UPDATE_RESTOCKING_FEE, UPDATE_CHARITY_ID, UPDATE_CHARITY_PERCENTAGE, UPDATE_CONDITION_DESCRIPTION, UPDATE_PHOTOS_AFTER_INDEX_0, UPDATE_PHOTOS_AFTER_INDEX_1, 
            UPDATE_PHOTOS_AFTER_INDEX_2, UPDATE_PHOTOS_AFTER_INDEX_3, UPDATE_PHOTOS_AFTER_INDEX_4, UPDATE_PHOTOS_AFTER_INDEX_5, UPDATE_PHOTOS_AFTER_INDEX_6, UPDATE_PHOTOS_AFTER_INDEX_7, UPDATE_PHOTOS_AFTER_INDEX_8, UPDATE_PHOTOS_AFTER_INDEX_9, UPDATE_PHOTOS_AFTER_INDEX_10, UPDATE_PHOTOS_AFTER_INDEX_11, 
            UPDATE_PHOTOS_AFTER_INDEX_12, UPDATE_PHOTOS_AFTER_INDEX_13, UPDATE_PHOTOS_AFTER_INDEX_14, UPDATE_PHOTOS_AFTER_INDEX_15, UPDATE_PHOTOS_AFTER_INDEX_16, UPDATE_PHOTOS_AFTER_INDEX_17, UPDATE_PHOTOS_AFTER_INDEX_18, UPDATE_PHOTOS_AFTER_INDEX_19, UPDATE_PHOTOS_AFTER_INDEX_20, UPDATE_PHOTOS_AFTER_INDEX_21, 
            UPDATE_PHOTOS_AFTER_INDEX_22, UPDATE_PHOTOS_AFTER_INDEX_23
        });
    }
}
