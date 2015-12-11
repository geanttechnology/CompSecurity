// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;


public final class eu extends Enum
{

    public static final eu a;
    public static final eu b;
    public static final eu c;
    public static final eu d;
    public static final eu e;
    public static final eu f;
    public static final eu g;
    public static final eu h;
    public static final eu i;
    public static final eu j;
    public static final eu k;
    private static final eu n[];
    private final String l;
    private final String m;

    private eu(String s, int i1, String s1, String s2)
    {
        super(s, i1);
        l = s1;
        m = s2;
    }

    public static eu valueOf(String s)
    {
        return (eu)Enum.valueOf(com/tapjoy/internal/eu, s);
    }

    public static eu[] values()
    {
        return (eu[])n.clone();
    }

    public final String a()
    {
        return m;
    }

    public final String toString()
    {
        return l;
    }

    static 
    {
        a = new eu("THM_NotYet", 0, "Not Yet", "Profile request has successfully started but is not completed");
        b = new eu("THM_OK", 1, "Okay", "Completed, No errors");
        c = new eu("THM_Connection_Error", 2, "Connection Error", "There has been a connection issue, profiling aborted");
        d = new eu("THM_HostNotFound_Error", 3, "Host Not Found", "Unable to resolve the host name");
        e = new eu("THM_NetworkTimeout_Error", 4, "Network Timeout", "Communications layer timed out");
        f = new eu("THM_Internal_Error", 5, "Internal Error", "Internal Error, profiling incomplete or interrupted");
        g = new eu("THM_HostVerification_Error", 6, "Host Verification Error", "Certificate verification failure! Potential MITM attack");
        h = new eu("THM_Interrupted_Error", 7, "Interrupted", "Request was cancelled");
        i = new eu("THM_InvalidOrgID", 8, "Invalid ORG ID", "Request contained an invalid org id");
        j = new eu("THM_ConfigurationError", 9, "Configuration Error", "Failed to retrieve configuration from server");
        k = new eu("THM_PartialProfile", 10, "Partial Profile", "Connection error, only partial profile completed");
        n = (new eu[] {
            a, b, c, d, e, f, g, h, i, j, 
            k
        });
    }
}
