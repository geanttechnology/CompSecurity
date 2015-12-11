// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.jsonFormatVisitors;


public class JsonValueFormat extends Enum
{

    private static final JsonValueFormat $VALUES[];
    public static final JsonValueFormat COLOR;
    public static final JsonValueFormat DATE;
    public static final JsonValueFormat DATE_TIME;
    public static final JsonValueFormat EMAIL;
    public static final JsonValueFormat HOST_NAME;
    public static final JsonValueFormat IPV6;
    public static final JsonValueFormat IP_ADDRESS;
    public static final JsonValueFormat PHONE;
    public static final JsonValueFormat REGEX;
    public static final JsonValueFormat STYLE;
    public static final JsonValueFormat TIME;
    public static final JsonValueFormat URI;
    public static final JsonValueFormat UTC_MILLISEC;

    private JsonValueFormat(String s, int i)
    {
        super(s, i);
    }


    public static JsonValueFormat valueOf(String s)
    {
        return (JsonValueFormat)Enum.valueOf(com/fasterxml/jackson/databind/jsonFormatVisitors/JsonValueFormat, s);
    }

    public static JsonValueFormat[] values()
    {
        return (JsonValueFormat[])$VALUES.clone();
    }

    static 
    {
        DATE_TIME = new JsonValueFormat("DATE_TIME", 0) {

            public String toString()
            {
                return "date-time";
            }

        };
        DATE = new JsonValueFormat("DATE", 1) {

            public String toString()
            {
                return "date";
            }

        };
        TIME = new JsonValueFormat("TIME", 2) {

            public String toString()
            {
                return "time";
            }

        };
        UTC_MILLISEC = new JsonValueFormat("UTC_MILLISEC", 3) {

            public String toString()
            {
                return "utc-millisec";
            }

        };
        REGEX = new JsonValueFormat("REGEX", 4) {

            public String toString()
            {
                return "regex";
            }

        };
        COLOR = new JsonValueFormat("COLOR", 5) {

            public String toString()
            {
                return "color";
            }

        };
        STYLE = new JsonValueFormat("STYLE", 6) {

            public String toString()
            {
                return "style";
            }

        };
        PHONE = new JsonValueFormat("PHONE", 7) {

            public String toString()
            {
                return "phone";
            }

        };
        URI = new JsonValueFormat("URI", 8) {

            public String toString()
            {
                return "uri";
            }

        };
        EMAIL = new JsonValueFormat("EMAIL", 9) {

            public String toString()
            {
                return "email";
            }

        };
        IP_ADDRESS = new JsonValueFormat("IP_ADDRESS", 10) {

            public String toString()
            {
                return "ip-address";
            }

        };
        IPV6 = new JsonValueFormat("IPV6", 11) {

            public String toString()
            {
                return "ipv6";
            }

        };
        HOST_NAME = new JsonValueFormat("HOST_NAME", 12) {

            public String toString()
            {
                return "host-name";
            }

        };
        $VALUES = (new JsonValueFormat[] {
            DATE_TIME, DATE, TIME, UTC_MILLISEC, REGEX, COLOR, STYLE, PHONE, URI, EMAIL, 
            IP_ADDRESS, IPV6, HOST_NAME
        });
    }
}
