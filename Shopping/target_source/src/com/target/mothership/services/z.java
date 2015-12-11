// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services;


public final class z extends Enum
{

    private static final z $VALUES[];
    public static final z ACCEPTED;
    public static final z BAD_GATEWAY;
    public static final z BAD_REQUEST;
    public static final z CONFLICT;
    public static final z CONTINUE;
    public static final z CREATED;
    public static final z EMPTY_RESPONSE;
    public static final z EXPECTATION_FAILED;
    public static final z FAILED_DEPENDENCY;
    public static final z FORBIDDEN;
    public static final z GATEWAY_TIMEOUT;
    public static final z GONE;
    public static final z HTTP_VERSION_NOT_SUPPORTED;
    public static final z INSUFFICIENT_SPACE_ON_RESOURCE;
    public static final z INSUFFICIENT_STORAGE;
    public static final z INTERNAL_SERVER_ERROR;
    public static final z LENGTH_REQUIRED;
    public static final z LOCKED;
    public static final z MAXIMUM_RETRY_EXCEEDED;
    public static final z METHOD_FAILURE;
    public static final z METHOD_NOT_ALLOWED;
    public static final z MOVED_PERMANENTLY;
    public static final z MOVED_TEMPORARILY;
    public static final z MULTIPLE_CHOICES;
    public static final z MULTI_STATUS;
    public static final z NONE;
    public static final z NON_AUTHORITATIVE_INFORMATION;
    public static final z NOT_ACCEPTABLE;
    public static final z NOT_FOUND;
    public static final z NOT_IMPLEMENTED;
    public static final z NOT_MODIFIED;
    public static final z NO_CONTENT;
    public static final z OK;
    public static final z PARTIAL_CONTENT;
    public static final z PAYMENT_REQUIRED;
    public static final z PRECONDITION_FAILED;
    public static final z PROCESSING;
    public static final z PROXY_AUTHENTICATION_REQUIRED;
    public static final z REQUESTED_RANGE_NOT_SATISFIABLE;
    public static final z REQUEST_TIMEOUT;
    public static final z REQUEST_TOO_LONG;
    public static final z REQUEST_URI_TOO_LONG;
    public static final z RESET_CONTENT;
    public static final z SEE_OTHER;
    public static final z SERVICE_UNAVAILABLE;
    public static final z SWITCHING_PROTOCOLS;
    public static final z TEMPORARY_REDIRECT;
    public static final z UNAUTHORIZED;
    public static final z UNKNOWN;
    public static final z UNPROCESSABLE_ENTITY;
    public static final z UNSUPPORTED_MEDIA_TYPE;
    public static final z USE_PROXY;
    private int mValue;

    private z(String s, int i, int j)
    {
        super(s, i);
        mValue = j;
    }

    public static z a(int i)
    {
        z az[] = values();
        int k = az.length;
        for (int j = 0; j < k; j++)
        {
            z z1 = az[j];
            if (z1.mValue == i)
            {
                return z1;
            }
        }

        return UNKNOWN;
    }

    public static z valueOf(String s)
    {
        return (z)Enum.valueOf(com/target/mothership/services/z, s);
    }

    public static z[] values()
    {
        return (z[])$VALUES.clone();
    }

    public int a()
    {
        return mValue;
    }

    static 
    {
        ACCEPTED = new z("ACCEPTED", 0, 202);
        BAD_GATEWAY = new z("BAD_GATEWAY", 1, 502);
        BAD_REQUEST = new z("BAD_REQUEST", 2, 400);
        CONFLICT = new z("CONFLICT", 3, 409);
        CONTINUE = new z("CONTINUE", 4, 100);
        CREATED = new z("CREATED", 5, 201);
        EXPECTATION_FAILED = new z("EXPECTATION_FAILED", 6, 417);
        FAILED_DEPENDENCY = new z("FAILED_DEPENDENCY", 7, 424);
        FORBIDDEN = new z("FORBIDDEN", 8, 403);
        GATEWAY_TIMEOUT = new z("GATEWAY_TIMEOUT", 9, 504);
        GONE = new z("GONE", 10, 410);
        HTTP_VERSION_NOT_SUPPORTED = new z("HTTP_VERSION_NOT_SUPPORTED", 11, 505);
        INSUFFICIENT_SPACE_ON_RESOURCE = new z("INSUFFICIENT_SPACE_ON_RESOURCE", 12, 419);
        INSUFFICIENT_STORAGE = new z("INSUFFICIENT_STORAGE", 13, 507);
        INTERNAL_SERVER_ERROR = new z("INTERNAL_SERVER_ERROR", 14, 500);
        LENGTH_REQUIRED = new z("LENGTH_REQUIRED", 15, 411);
        LOCKED = new z("LOCKED", 16, 423);
        METHOD_FAILURE = new z("METHOD_FAILURE", 17, 420);
        METHOD_NOT_ALLOWED = new z("METHOD_NOT_ALLOWED", 18, 405);
        MOVED_PERMANENTLY = new z("MOVED_PERMANENTLY", 19, 301);
        MOVED_TEMPORARILY = new z("MOVED_TEMPORARILY", 20, 302);
        MULTIPLE_CHOICES = new z("MULTIPLE_CHOICES", 21, 300);
        MULTI_STATUS = new z("MULTI_STATUS", 22, 207);
        NON_AUTHORITATIVE_INFORMATION = new z("NON_AUTHORITATIVE_INFORMATION", 23, 203);
        NOT_ACCEPTABLE = new z("NOT_ACCEPTABLE", 24, 406);
        NOT_FOUND = new z("NOT_FOUND", 25, 404);
        NOT_IMPLEMENTED = new z("NOT_IMPLEMENTED", 26, 501);
        NOT_MODIFIED = new z("NOT_MODIFIED", 27, 304);
        NO_CONTENT = new z("NO_CONTENT", 28, 204);
        PAYMENT_REQUIRED = new z("PAYMENT_REQUIRED", 29, 402);
        PRECONDITION_FAILED = new z("PRECONDITION_FAILED", 30, 412);
        PROCESSING = new z("PROCESSING", 31, 102);
        PROXY_AUTHENTICATION_REQUIRED = new z("PROXY_AUTHENTICATION_REQUIRED", 32, 407);
        REQUESTED_RANGE_NOT_SATISFIABLE = new z("REQUESTED_RANGE_NOT_SATISFIABLE", 33, 416);
        REQUEST_TIMEOUT = new z("REQUEST_TIMEOUT", 34, 408);
        REQUEST_TOO_LONG = new z("REQUEST_TOO_LONG", 35, 413);
        REQUEST_URI_TOO_LONG = new z("REQUEST_URI_TOO_LONG", 36, 414);
        RESET_CONTENT = new z("RESET_CONTENT", 37, 205);
        SEE_OTHER = new z("SEE_OTHER", 38, 303);
        SERVICE_UNAVAILABLE = new z("SERVICE_UNAVAILABLE", 39, 503);
        SWITCHING_PROTOCOLS = new z("SWITCHING_PROTOCOLS", 40, 101);
        TEMPORARY_REDIRECT = new z("TEMPORARY_REDIRECT", 41, 307);
        UNAUTHORIZED = new z("UNAUTHORIZED", 42, 401);
        UNPROCESSABLE_ENTITY = new z("UNPROCESSABLE_ENTITY", 43, 422);
        UNSUPPORTED_MEDIA_TYPE = new z("UNSUPPORTED_MEDIA_TYPE", 44, 415);
        USE_PROXY = new z("USE_PROXY", 45, 305);
        PARTIAL_CONTENT = new z("PARTIAL_CONTENT", 46, 206);
        OK = new z("OK", 47, 200);
        EMPTY_RESPONSE = new z("EMPTY_RESPONSE", 48, 999);
        MAXIMUM_RETRY_EXCEEDED = new z("MAXIMUM_RETRY_EXCEEDED", 49, 1000);
        NONE = new z("NONE", 50, 0);
        UNKNOWN = new z("UNKNOWN", 51, -1);
        $VALUES = (new z[] {
            ACCEPTED, BAD_GATEWAY, BAD_REQUEST, CONFLICT, CONTINUE, CREATED, EXPECTATION_FAILED, FAILED_DEPENDENCY, FORBIDDEN, GATEWAY_TIMEOUT, 
            GONE, HTTP_VERSION_NOT_SUPPORTED, INSUFFICIENT_SPACE_ON_RESOURCE, INSUFFICIENT_STORAGE, INTERNAL_SERVER_ERROR, LENGTH_REQUIRED, LOCKED, METHOD_FAILURE, METHOD_NOT_ALLOWED, MOVED_PERMANENTLY, 
            MOVED_TEMPORARILY, MULTIPLE_CHOICES, MULTI_STATUS, NON_AUTHORITATIVE_INFORMATION, NOT_ACCEPTABLE, NOT_FOUND, NOT_IMPLEMENTED, NOT_MODIFIED, NO_CONTENT, PAYMENT_REQUIRED, 
            PRECONDITION_FAILED, PROCESSING, PROXY_AUTHENTICATION_REQUIRED, REQUESTED_RANGE_NOT_SATISFIABLE, REQUEST_TIMEOUT, REQUEST_TOO_LONG, REQUEST_URI_TOO_LONG, RESET_CONTENT, SEE_OTHER, SERVICE_UNAVAILABLE, 
            SWITCHING_PROTOCOLS, TEMPORARY_REDIRECT, UNAUTHORIZED, UNPROCESSABLE_ENTITY, UNSUPPORTED_MEDIA_TYPE, USE_PROXY, PARTIAL_CONTENT, OK, EMPTY_RESPONSE, MAXIMUM_RETRY_EXCEEDED, 
            NONE, UNKNOWN
        });
    }
}
