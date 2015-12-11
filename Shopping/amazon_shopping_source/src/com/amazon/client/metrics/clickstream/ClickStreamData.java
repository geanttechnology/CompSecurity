// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.clickstream;

import com.amazon.client.metrics.MetricsException;

public final class ClickStreamData extends Enum
{

    private static final ClickStreamData $VALUES[];
    public static final ClickStreamData COUNTRY_OF_RESIDENCE;
    public static final ClickStreamData CUSTOMER_ID;
    public static final ClickStreamData DEVICE_TYPE_ID;
    public static final ClickStreamData ECOMMERCE_PAGE_ACTION;
    public static final ClickStreamData END_TIME;
    public static final ClickStreamData GROUPING_ASIN;
    public static final ClickStreamData HIT_TYPE;
    public static final ClickStreamData IMPRESSION_DATA;
    public static final ClickStreamData IMPRESSION_METADATA;
    public static final ClickStreamData IMPRESSION_PROGRAM_GROUP;
    public static final ClickStreamData IMPRESSION_TYPE;
    public static final ClickStreamData INFO;
    public static final ClickStreamData IP_ADDRESS;
    public static final ClickStreamData IS_CUSTOMER_HIT;
    public static final ClickStreamData IS_GLANCE_VIEW;
    public static final ClickStreamData IS_PRIME_CUSTOMER;
    public static final ClickStreamData IS_PRIME_ELIGIBLE_ITEM;
    public static final ClickStreamData MARKETPLACE;
    public static final ClickStreamData MARKETPLACE_ID;
    public static final ClickStreamData ORDER_DATA;
    public static final ClickStreamData PAGE_ACTION;
    public static final ClickStreamData PAGE_ASSEMBLY_TYPE;
    public static final ClickStreamData PAGE_TYPE;
    public static final ClickStreamData PAGE_TYPE_ID;
    public static final ClickStreamData PRODUCT_GLID;
    public static final ClickStreamData REQUEST_ID;
    public static final ClickStreamData SESSION_ID;
    public static final ClickStreamData SITE_VARIANT;
    public static final ClickStreamData START_TIME;
    public static final ClickStreamData SUB_PAGE_TYPE;
    public static final ClickStreamData TAB_ID;
    public static final ClickStreamData TEAM_NAME;
    public static final ClickStreamData USER_AGENT;
    private final String mName;

    private ClickStreamData(String s, int i, String s1)
    {
        super(s, i);
        mName = s1;
    }

    public static ClickStreamData fromString(String s)
        throws MetricsException
    {
        ClickStreamData aclickstreamdata[] = values();
        int j = aclickstreamdata.length;
        for (int i = 0; i < j; i++)
        {
            ClickStreamData clickstreamdata = aclickstreamdata[i];
            if (clickstreamdata.getName().equalsIgnoreCase(s))
            {
                return clickstreamdata;
            }
        }

        throw new MetricsException((new StringBuilder()).append(s).append(" is not a valid ClickStreamData").toString());
    }

    public static ClickStreamData valueOf(String s)
    {
        return (ClickStreamData)Enum.valueOf(com/amazon/client/metrics/clickstream/ClickStreamData, s);
    }

    public static ClickStreamData[] values()
    {
        return (ClickStreamData[])$VALUES.clone();
    }

    public String getName()
    {
        return mName;
    }

    static 
    {
        REQUEST_ID = new ClickStreamData("REQUEST_ID", 0, "RequestId");
        SESSION_ID = new ClickStreamData("SESSION_ID", 1, "Session");
        CUSTOMER_ID = new ClickStreamData("CUSTOMER_ID", 2, "CustomerId");
        END_TIME = new ClickStreamData("END_TIME", 3, "EndTime");
        START_TIME = new ClickStreamData("START_TIME", 4, "StartTime");
        IP_ADDRESS = new ClickStreamData("IP_ADDRESS", 5, "REMOTE_ADDR");
        USER_AGENT = new ClickStreamData("USER_AGENT", 6, "HTTP_USER_AGENT");
        MARKETPLACE_ID = new ClickStreamData("MARKETPLACE_ID", 7, "Marketplaceid");
        MARKETPLACE = new ClickStreamData("MARKETPLACE", 8, "Marketplace");
        DEVICE_TYPE_ID = new ClickStreamData("DEVICE_TYPE_ID", 9, "deviceTypeID");
        INFO = new ClickStreamData("INFO", 10, "Info");
        COUNTRY_OF_RESIDENCE = new ClickStreamData("COUNTRY_OF_RESIDENCE", 11, "cor");
        PAGE_TYPE = new ClickStreamData("PAGE_TYPE", 12, "page-type");
        HIT_TYPE = new ClickStreamData("HIT_TYPE", 13, "hitType");
        TEAM_NAME = new ClickStreamData("TEAM_NAME", 14, "team-name");
        SITE_VARIANT = new ClickStreamData("SITE_VARIANT", 15, "site-variant");
        PAGE_ACTION = new ClickStreamData("PAGE_ACTION", 16, "page-action");
        SUB_PAGE_TYPE = new ClickStreamData("SUB_PAGE_TYPE", 17, "sub-page-type");
        PAGE_TYPE_ID = new ClickStreamData("PAGE_TYPE_ID", 18, "page-type-id");
        TAB_ID = new ClickStreamData("TAB_ID", 19, "tab-id");
        PAGE_ASSEMBLY_TYPE = new ClickStreamData("PAGE_ASSEMBLY_TYPE", 20, "pageAssemblyType");
        IS_CUSTOMER_HIT = new ClickStreamData("IS_CUSTOMER_HIT", 21, "is-customer-hit");
        IS_PRIME_CUSTOMER = new ClickStreamData("IS_PRIME_CUSTOMER", 22, "is-prime-customer");
        GROUPING_ASIN = new ClickStreamData("GROUPING_ASIN", 23, "groupingAsin");
        PRODUCT_GLID = new ClickStreamData("PRODUCT_GLID", 24, "productGLID");
        ECOMMERCE_PAGE_ACTION = new ClickStreamData("ECOMMERCE_PAGE_ACTION", 25, "ecommerce-page-action");
        ORDER_DATA = new ClickStreamData("ORDER_DATA", 26, "order-data");
        IS_PRIME_ELIGIBLE_ITEM = new ClickStreamData("IS_PRIME_ELIGIBLE_ITEM", 27, "is-prime-eligible-item");
        IS_GLANCE_VIEW = new ClickStreamData("IS_GLANCE_VIEW", 28, "is-glance-view");
        IMPRESSION_PROGRAM_GROUP = new ClickStreamData("IMPRESSION_PROGRAM_GROUP", 29, "programGroup");
        IMPRESSION_TYPE = new ClickStreamData("IMPRESSION_TYPE", 30, "impressionType");
        IMPRESSION_DATA = new ClickStreamData("IMPRESSION_DATA", 31, "impressionData");
        IMPRESSION_METADATA = new ClickStreamData("IMPRESSION_METADATA", 32, "impressionMetadata");
        $VALUES = (new ClickStreamData[] {
            REQUEST_ID, SESSION_ID, CUSTOMER_ID, END_TIME, START_TIME, IP_ADDRESS, USER_AGENT, MARKETPLACE_ID, MARKETPLACE, DEVICE_TYPE_ID, 
            INFO, COUNTRY_OF_RESIDENCE, PAGE_TYPE, HIT_TYPE, TEAM_NAME, SITE_VARIANT, PAGE_ACTION, SUB_PAGE_TYPE, PAGE_TYPE_ID, TAB_ID, 
            PAGE_ASSEMBLY_TYPE, IS_CUSTOMER_HIT, IS_PRIME_CUSTOMER, GROUPING_ASIN, PRODUCT_GLID, ECOMMERCE_PAGE_ACTION, ORDER_DATA, IS_PRIME_ELIGIBLE_ITEM, IS_GLANCE_VIEW, IMPRESSION_PROGRAM_GROUP, 
            IMPRESSION_TYPE, IMPRESSION_DATA, IMPRESSION_METADATA
        });
    }
}
