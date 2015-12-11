// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client.web;


public final class HttpHeader extends Enum
{

    private static final HttpHeader $VALUES[];
    public static final HttpHeader ACCEPT;
    public static final HttpHeader ACCEPT_CHARSET;
    public static final HttpHeader ACCEPT_ENCODING;
    public static final HttpHeader ACCEPT_LANGUAGE;
    public static final HttpHeader ACCEPT_RANGES;
    public static final HttpHeader ACCESS_CONTROL_ALLOW_CREDENTIALS;
    public static final HttpHeader ACCESS_CONTROL_ALLOW_HEADERS;
    public static final HttpHeader ACCESS_CONTROL_ALLOW_METHODS;
    public static final HttpHeader ACCESS_CONTROL_ALLOW_ORIGIN;
    public static final HttpHeader ACCESS_CONTROL_EXPOSE_HEADERS;
    public static final HttpHeader ACCESS_CONTROL_MAX_AGE;
    public static final HttpHeader ACCESS_CONTROL_REQUEST_HEADERS;
    public static final HttpHeader ACCESS_CONTROL_REQUEST_METHOD;
    public static final HttpHeader AGE;
    public static final HttpHeader ALLOW;
    public static final HttpHeader AUTHORIZATION;
    public static final HttpHeader CACHE_CONTROL;
    public static final HttpHeader CONNECTION;
    public static final HttpHeader CONTENT_DISPOSITION;
    public static final HttpHeader CONTENT_ENCODING;
    public static final HttpHeader CONTENT_LANGUAGE;
    public static final HttpHeader CONTENT_LENGTH;
    public static final HttpHeader CONTENT_LOCATION;
    public static final HttpHeader CONTENT_MD5;
    public static final HttpHeader CONTENT_RANGE;
    public static final HttpHeader CONTENT_SECURITY_POLICY;
    public static final HttpHeader CONTENT_SECURITY_POLICY_REPORT_ONLY;
    public static final HttpHeader CONTENT_TYPE;
    public static final HttpHeader COOKIE;
    public static final HttpHeader DATE;
    public static final HttpHeader DNT;
    public static final HttpHeader ETAG;
    public static final HttpHeader EXPECT;
    public static final HttpHeader EXPIRES;
    public static final HttpHeader FROM;
    public static final HttpHeader HOST;
    public static final HttpHeader IF_MATCH;
    public static final HttpHeader IF_MODIFIED_SINCE;
    public static final HttpHeader IF_NONE_MATCH;
    public static final HttpHeader IF_RANGE;
    public static final HttpHeader IF_UNMODIFIED_SINCE;
    public static final HttpHeader LAST_EVENT_ID;
    public static final HttpHeader LAST_MODIFIED;
    public static final HttpHeader LINK;
    public static final HttpHeader LOCATION;
    public static final HttpHeader MAX_FORWARDS;
    public static final HttpHeader ORIGIN;
    public static final HttpHeader P3P;
    public static final HttpHeader PRAGMA;
    public static final HttpHeader PROXY_AUTHENTICATE;
    public static final HttpHeader PROXY_AUTHORIZATION;
    public static final HttpHeader PUBLIC_KEY_PINS;
    public static final HttpHeader PUBLIC_KEY_PINS_REPORT_ONLY;
    public static final HttpHeader RANGE;
    public static final HttpHeader REFERER;
    public static final HttpHeader REFRESH;
    public static final HttpHeader RETRY_AFTER;
    public static final HttpHeader SERVER;
    public static final HttpHeader SET_COOKIE;
    public static final HttpHeader SET_COOKIE2;
    public static final HttpHeader STRICT_TRANSPORT_SECURITY;
    public static final HttpHeader TE;
    public static final HttpHeader TIMING_ALLOW_ORIGIN;
    public static final HttpHeader TRAILER;
    public static final HttpHeader TRANSFER_ENCODING;
    public static final HttpHeader UPGRADE;
    public static final HttpHeader USER_AGENT;
    public static final HttpHeader VARY;
    public static final HttpHeader VIA;
    public static final HttpHeader WARNING;
    public static final HttpHeader WWW_AUTHENTICATE;
    public static final HttpHeader X_CONTENT_TYPE_OPTIONS;
    public static final HttpHeader X_DO_NOT_TRACK;
    public static final HttpHeader X_FORWARDED_FOR;
    public static final HttpHeader X_FORWARDED_PROTO;
    public static final HttpHeader X_FRAME_OPTIONS;
    public static final HttpHeader X_POWERED_BY;
    public static final HttpHeader X_REQUESTED_WITH;
    public static final HttpHeader X_USER_IP;
    public static final HttpHeader X_XSS_PROTECTION;
    private final String name;

    private HttpHeader(String s, int i, String s1)
    {
        super(s, i);
        name = s1;
    }

    public static HttpHeader valueOf(String s)
    {
        return (HttpHeader)Enum.valueOf(com/amazon/searchapp/retailsearch/client/web/HttpHeader, s);
    }

    public static HttpHeader[] values()
    {
        return (HttpHeader[])$VALUES.clone();
    }

    public String getName()
    {
        return name;
    }

    static 
    {
        CACHE_CONTROL = new HttpHeader("CACHE_CONTROL", 0, "Cache-Control");
        CONTENT_LENGTH = new HttpHeader("CONTENT_LENGTH", 1, "Content-Length");
        CONTENT_TYPE = new HttpHeader("CONTENT_TYPE", 2, "Content-Type");
        DATE = new HttpHeader("DATE", 3, "Date");
        PRAGMA = new HttpHeader("PRAGMA", 4, "Pragma");
        VIA = new HttpHeader("VIA", 5, "Via");
        WARNING = new HttpHeader("WARNING", 6, "Warning");
        ACCEPT = new HttpHeader("ACCEPT", 7, "Accept");
        ACCEPT_CHARSET = new HttpHeader("ACCEPT_CHARSET", 8, "Accept-Charset");
        ACCEPT_ENCODING = new HttpHeader("ACCEPT_ENCODING", 9, "Accept-Encoding");
        ACCEPT_LANGUAGE = new HttpHeader("ACCEPT_LANGUAGE", 10, "Accept-Language");
        ACCESS_CONTROL_REQUEST_HEADERS = new HttpHeader("ACCESS_CONTROL_REQUEST_HEADERS", 11, "Access-Control-Request-Headers");
        ACCESS_CONTROL_REQUEST_METHOD = new HttpHeader("ACCESS_CONTROL_REQUEST_METHOD", 12, "Access-Control-Request-Method");
        AUTHORIZATION = new HttpHeader("AUTHORIZATION", 13, "Authorization");
        CONNECTION = new HttpHeader("CONNECTION", 14, "Connection");
        COOKIE = new HttpHeader("COOKIE", 15, "Cookie");
        EXPECT = new HttpHeader("EXPECT", 16, "Expect");
        FROM = new HttpHeader("FROM", 17, "From");
        HOST = new HttpHeader("HOST", 18, "Host");
        IF_MATCH = new HttpHeader("IF_MATCH", 19, "If-Match");
        IF_MODIFIED_SINCE = new HttpHeader("IF_MODIFIED_SINCE", 20, "If-Modified-Since");
        IF_NONE_MATCH = new HttpHeader("IF_NONE_MATCH", 21, "If-None-Match");
        IF_RANGE = new HttpHeader("IF_RANGE", 22, "If-Range");
        IF_UNMODIFIED_SINCE = new HttpHeader("IF_UNMODIFIED_SINCE", 23, "If-Unmodified-Since");
        LAST_EVENT_ID = new HttpHeader("LAST_EVENT_ID", 24, "Last-Event-ID");
        MAX_FORWARDS = new HttpHeader("MAX_FORWARDS", 25, "Max-Forwards");
        ORIGIN = new HttpHeader("ORIGIN", 26, "Origin");
        PROXY_AUTHORIZATION = new HttpHeader("PROXY_AUTHORIZATION", 27, "Proxy-Authorization");
        RANGE = new HttpHeader("RANGE", 28, "Range");
        REFERER = new HttpHeader("REFERER", 29, "Referer");
        TE = new HttpHeader("TE", 30, "TE");
        UPGRADE = new HttpHeader("UPGRADE", 31, "Upgrade");
        USER_AGENT = new HttpHeader("USER_AGENT", 32, "User-Agent");
        ACCEPT_RANGES = new HttpHeader("ACCEPT_RANGES", 33, "Accept-Ranges");
        ACCESS_CONTROL_ALLOW_HEADERS = new HttpHeader("ACCESS_CONTROL_ALLOW_HEADERS", 34, "Access-Control-Allow-Headers");
        ACCESS_CONTROL_ALLOW_METHODS = new HttpHeader("ACCESS_CONTROL_ALLOW_METHODS", 35, "Access-Control-Allow-Methods");
        ACCESS_CONTROL_ALLOW_ORIGIN = new HttpHeader("ACCESS_CONTROL_ALLOW_ORIGIN", 36, "Access-Control-Allow-Origin");
        ACCESS_CONTROL_ALLOW_CREDENTIALS = new HttpHeader("ACCESS_CONTROL_ALLOW_CREDENTIALS", 37, "Access-Control-Allow-Credentials");
        ACCESS_CONTROL_EXPOSE_HEADERS = new HttpHeader("ACCESS_CONTROL_EXPOSE_HEADERS", 38, "Access-Control-Expose-Headers");
        ACCESS_CONTROL_MAX_AGE = new HttpHeader("ACCESS_CONTROL_MAX_AGE", 39, "Access-Control-Max-Age");
        AGE = new HttpHeader("AGE", 40, "Age");
        ALLOW = new HttpHeader("ALLOW", 41, "Allow");
        CONTENT_DISPOSITION = new HttpHeader("CONTENT_DISPOSITION", 42, "Content-Disposition");
        CONTENT_ENCODING = new HttpHeader("CONTENT_ENCODING", 43, "Content-Encoding");
        CONTENT_LANGUAGE = new HttpHeader("CONTENT_LANGUAGE", 44, "Content-Language");
        CONTENT_LOCATION = new HttpHeader("CONTENT_LOCATION", 45, "Content-Location");
        CONTENT_MD5 = new HttpHeader("CONTENT_MD5", 46, "Content-MD5");
        CONTENT_RANGE = new HttpHeader("CONTENT_RANGE", 47, "Content-Range");
        CONTENT_SECURITY_POLICY = new HttpHeader("CONTENT_SECURITY_POLICY", 48, "Content-Security-Policy");
        CONTENT_SECURITY_POLICY_REPORT_ONLY = new HttpHeader("CONTENT_SECURITY_POLICY_REPORT_ONLY", 49, "Content-Security-Policy-Report-Only");
        ETAG = new HttpHeader("ETAG", 50, "ETag");
        EXPIRES = new HttpHeader("EXPIRES", 51, "Expires");
        LAST_MODIFIED = new HttpHeader("LAST_MODIFIED", 52, "Last-Modified");
        LINK = new HttpHeader("LINK", 53, "Link");
        LOCATION = new HttpHeader("LOCATION", 54, "Location");
        P3P = new HttpHeader("P3P", 55, "P3P");
        PROXY_AUTHENTICATE = new HttpHeader("PROXY_AUTHENTICATE", 56, "Proxy-Authenticate");
        REFRESH = new HttpHeader("REFRESH", 57, "Refresh");
        RETRY_AFTER = new HttpHeader("RETRY_AFTER", 58, "Retry-After");
        SERVER = new HttpHeader("SERVER", 59, "Server");
        SET_COOKIE = new HttpHeader("SET_COOKIE", 60, "Set-Cookie");
        SET_COOKIE2 = new HttpHeader("SET_COOKIE2", 61, "Set-Cookie2");
        STRICT_TRANSPORT_SECURITY = new HttpHeader("STRICT_TRANSPORT_SECURITY", 62, "Strict-Transport-Security");
        TIMING_ALLOW_ORIGIN = new HttpHeader("TIMING_ALLOW_ORIGIN", 63, "Timing-Allow-Origin");
        TRAILER = new HttpHeader("TRAILER", 64, "Trailer");
        TRANSFER_ENCODING = new HttpHeader("TRANSFER_ENCODING", 65, "Transfer-Encoding");
        VARY = new HttpHeader("VARY", 66, "Vary");
        WWW_AUTHENTICATE = new HttpHeader("WWW_AUTHENTICATE", 67, "WWW-Authenticate");
        DNT = new HttpHeader("DNT", 68, "DNT");
        X_CONTENT_TYPE_OPTIONS = new HttpHeader("X_CONTENT_TYPE_OPTIONS", 69, "X-Content-Type-Options");
        X_DO_NOT_TRACK = new HttpHeader("X_DO_NOT_TRACK", 70, "X-Do-Not-Track");
        X_FORWARDED_FOR = new HttpHeader("X_FORWARDED_FOR", 71, "X-Forwarded-For");
        X_FORWARDED_PROTO = new HttpHeader("X_FORWARDED_PROTO", 72, "X-Forwarded-Proto");
        X_FRAME_OPTIONS = new HttpHeader("X_FRAME_OPTIONS", 73, "X-Frame-Options");
        X_POWERED_BY = new HttpHeader("X_POWERED_BY", 74, "X-Powered-By");
        PUBLIC_KEY_PINS = new HttpHeader("PUBLIC_KEY_PINS", 75, "Public-Key-Pins");
        PUBLIC_KEY_PINS_REPORT_ONLY = new HttpHeader("PUBLIC_KEY_PINS_REPORT_ONLY", 76, "Public-Key-Pins-Report-Only");
        X_REQUESTED_WITH = new HttpHeader("X_REQUESTED_WITH", 77, "X-Requested-With");
        X_USER_IP = new HttpHeader("X_USER_IP", 78, "X-User-IP");
        X_XSS_PROTECTION = new HttpHeader("X_XSS_PROTECTION", 79, "X-XSS-Protection");
        $VALUES = (new HttpHeader[] {
            CACHE_CONTROL, CONTENT_LENGTH, CONTENT_TYPE, DATE, PRAGMA, VIA, WARNING, ACCEPT, ACCEPT_CHARSET, ACCEPT_ENCODING, 
            ACCEPT_LANGUAGE, ACCESS_CONTROL_REQUEST_HEADERS, ACCESS_CONTROL_REQUEST_METHOD, AUTHORIZATION, CONNECTION, COOKIE, EXPECT, FROM, HOST, IF_MATCH, 
            IF_MODIFIED_SINCE, IF_NONE_MATCH, IF_RANGE, IF_UNMODIFIED_SINCE, LAST_EVENT_ID, MAX_FORWARDS, ORIGIN, PROXY_AUTHORIZATION, RANGE, REFERER, 
            TE, UPGRADE, USER_AGENT, ACCEPT_RANGES, ACCESS_CONTROL_ALLOW_HEADERS, ACCESS_CONTROL_ALLOW_METHODS, ACCESS_CONTROL_ALLOW_ORIGIN, ACCESS_CONTROL_ALLOW_CREDENTIALS, ACCESS_CONTROL_EXPOSE_HEADERS, ACCESS_CONTROL_MAX_AGE, 
            AGE, ALLOW, CONTENT_DISPOSITION, CONTENT_ENCODING, CONTENT_LANGUAGE, CONTENT_LOCATION, CONTENT_MD5, CONTENT_RANGE, CONTENT_SECURITY_POLICY, CONTENT_SECURITY_POLICY_REPORT_ONLY, 
            ETAG, EXPIRES, LAST_MODIFIED, LINK, LOCATION, P3P, PROXY_AUTHENTICATE, REFRESH, RETRY_AFTER, SERVER, 
            SET_COOKIE, SET_COOKIE2, STRICT_TRANSPORT_SECURITY, TIMING_ALLOW_ORIGIN, TRAILER, TRANSFER_ENCODING, VARY, WWW_AUTHENTICATE, DNT, X_CONTENT_TYPE_OPTIONS, 
            X_DO_NOT_TRACK, X_FORWARDED_FOR, X_FORWARDED_PROTO, X_FRAME_OPTIONS, X_POWERED_BY, PUBLIC_KEY_PINS, PUBLIC_KEY_PINS_REPORT_ONLY, X_REQUESTED_WITH, X_USER_IP, X_XSS_PROTECTION
        });
    }
}
