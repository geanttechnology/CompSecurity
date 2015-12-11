// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.net;


public final class EndpointType extends Enum
{

    private static final EndpointType $VALUES[];
    public static final EndpointType AUTOCOMPLETE;
    public static final EndpointType CATEGORY;
    public static final EndpointType FEED_LOCATION;
    public static final EndpointType FEED_MAP;
    public static final EndpointType GENERAL;
    public static final EndpointType INITIALIZE;
    public static final EndpointType LIST;
    public static final EndpointType LOOKUP;
    public static final EndpointType MAP;
    public static final EndpointType MAP_ANNOTATION_VIEW_ANALYTICS;
    public static final EndpointType MAP_ZONE_VIEW_ANALYTICS;
    public static final EndpointType NEARBY;
    public static final EndpointType POI;
    public static final EndpointType RECOMMEND_ANALYTICS;
    public static final EndpointType RECOMMEND_ITEMS;
    public static final EndpointType ROUTE;
    public static final EndpointType ROUTE_ORDER;
    public static final EndpointType SEARCH;
    public static final EndpointType VENUE_PROXIMITY_ANALYTICS;
    public final String endpoint;
    public final String service;

    private EndpointType(String s, int i, String s1, String s2)
    {
        super(s, i);
        service = s1;
        endpoint = s2;
    }

    public static EndpointType valueOf(String s)
    {
        return (EndpointType)Enum.valueOf(com/pointinside/net/EndpointType, s);
    }

    public static EndpointType[] values()
    {
        return (EndpointType[])$VALUES.clone();
    }

    String getEndpointName()
    {
        return endpoint;
    }

    String getServiceName()
    {
        return service;
    }

    public String toString()
    {
        return String.format("serviceName=%s, endpointName=%s)", new Object[] {
            service, endpoint
        });
    }

    static 
    {
        FEED_MAP = new EndpointType("FEED_MAP", 0, "feeds/maps", "venues");
        FEED_LOCATION = new EndpointType("FEED_LOCATION", 1, "feeds/location", "venues");
        ROUTE = new EndpointType("ROUTE", 2, "route", "route");
        ROUTE_ORDER = new EndpointType("ROUTE_ORDER", 3, "route", "order");
        LIST = new EndpointType("LIST", 4, "list", "list");
        MAP = new EndpointType("MAP", 5, "maps", "staticmap");
        RECOMMEND_ITEMS = new EndpointType("RECOMMEND_ITEMS", 6, "recommend", "item");
        RECOMMEND_ANALYTICS = new EndpointType("RECOMMEND_ANALYTICS", 7, "recommend", "contents/analytics");
        SEARCH = new EndpointType("SEARCH", 8, "search", "search");
        NEARBY = new EndpointType("NEARBY", 9, "search", "search/nearby");
        POI = new EndpointType("POI", 10, "feeds/POI", "venues");
        AUTOCOMPLETE = new EndpointType("AUTOCOMPLETE", 11, "search", "autocomplete");
        CATEGORY = new EndpointType("CATEGORY", 12, "search", "search");
        LOOKUP = new EndpointType("LOOKUP", 13, "search", "product/lookup");
        INITIALIZE = new EndpointType("INITIALIZE", 14, "analytics", "initialize");
        GENERAL = new EndpointType("GENERAL", 15, "analytics", "general");
        VENUE_PROXIMITY_ANALYTICS = new EndpointType("VENUE_PROXIMITY_ANALYTICS", 16, "feeds/location", "venues/proximity/analytics");
        MAP_ZONE_VIEW_ANALYTICS = new EndpointType("MAP_ZONE_VIEW_ANALYTICS", 17, "analytics", "map/view");
        MAP_ANNOTATION_VIEW_ANALYTICS = new EndpointType("MAP_ANNOTATION_VIEW_ANALYTICS", 18, "analytics", "map/annotation");
        $VALUES = (new EndpointType[] {
            FEED_MAP, FEED_LOCATION, ROUTE, ROUTE_ORDER, LIST, MAP, RECOMMEND_ITEMS, RECOMMEND_ANALYTICS, SEARCH, NEARBY, 
            POI, AUTOCOMPLETE, CATEGORY, LOOKUP, INITIALIZE, GENERAL, VENUE_PROXIMITY_ANALYTICS, MAP_ZONE_VIEW_ANALYTICS, MAP_ANNOTATION_VIEW_ANALYTICS
        });
    }
}
