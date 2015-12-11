// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import java.util.regex.Pattern;

public interface d
{

    public static final Pattern AMEX_START_PATTERN = Pattern.compile("^3[4,7]\\d{2,13}$");
    public static final Pattern DISCOVER_START_PATTERN = Pattern.compile("^6[0,2,4,5,6,8,9](\\d{9,12}|\\d{2,14})$");
    public static final Pattern MASTERCARD_START_PATTERN = Pattern.compile("^5[1-5]\\d{4,14}$");
    public static final Pattern TARGET_BUSINESS_START_PATTERN = Pattern.compile("^95.*$");
    public static final Pattern TARGET_BUSINESS_START_PATTERN_NEW = Pattern.compile("^585978.*$");
    public static final Pattern TARGET_CARD_START_PATTERN = Pattern.compile("^9.*$");
    public static final Pattern TARGET_CARD_START_PATTERN_NEW = Pattern.compile("^585975.*$");
    public static final Pattern TARGET_DEBIT_START_PATTERN = Pattern.compile("^639463.*$");
    public static final Pattern TARGET_MASTERCARD_START_PATTERN = Pattern.compile("^(511786|515072).*$");
    public static final Pattern TARGET_RED_CARD_VISA = Pattern.compile("^435237.*$");
    public static final Pattern TARGET_VISA_START_PATTERN = Pattern.compile("^435237.*$");
    public static final Pattern VISA_START_PATTERN = Pattern.compile("^4\\d{3,15}$");

}
