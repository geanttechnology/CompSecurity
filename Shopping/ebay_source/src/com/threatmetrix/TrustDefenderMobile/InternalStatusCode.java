// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.threatmetrix.TrustDefenderMobile;


public final class InternalStatusCode extends Enum
{

    private static final InternalStatusCode $VALUES[];
    public static final InternalStatusCode THM_ConfigurationError;
    public static final InternalStatusCode THM_Connection_Error;
    public static final InternalStatusCode THM_HostNotFound_Error;
    public static final InternalStatusCode THM_HostVerification_Error;
    public static final InternalStatusCode THM_Internal_Error;
    public static final InternalStatusCode THM_Interrupted_Error;
    public static final InternalStatusCode THM_InvalidOrgID;
    public static final InternalStatusCode THM_NetworkTimeout_Error;
    public static final InternalStatusCode THM_NotYet;
    public static final InternalStatusCode THM_OK;
    public static final InternalStatusCode THM_PartialProfile;
    private final String desc;
    private final String label;

    private InternalStatusCode(String s, int i, String s1, String s2)
    {
        super(s, i);
        label = s1;
        desc = s2;
    }

    public static InternalStatusCode valueOf(String s)
    {
        return (InternalStatusCode)Enum.valueOf(com/threatmetrix/TrustDefenderMobile/InternalStatusCode, s);
    }

    public static InternalStatusCode[] values()
    {
        return (InternalStatusCode[])$VALUES.clone();
    }

    public String toString()
    {
        return label;
    }

    static 
    {
        THM_NotYet = new InternalStatusCode("THM_NotYet", 0, "Not Yet", "Profile request has successfully started but is not completed");
        THM_OK = new InternalStatusCode("THM_OK", 1, "Okay", "Completed, No errors");
        THM_Connection_Error = new InternalStatusCode("THM_Connection_Error", 2, "Connection Error", "There has been a connection issue, profiling aborted");
        THM_HostNotFound_Error = new InternalStatusCode("THM_HostNotFound_Error", 3, "Host Not Found", "Unable to resolve the host name");
        THM_NetworkTimeout_Error = new InternalStatusCode("THM_NetworkTimeout_Error", 4, "Network Timeout", "Communications layer timed out");
        THM_Internal_Error = new InternalStatusCode("THM_Internal_Error", 5, "Internal Error", "Internal Error, profiling incomplete or interrupted");
        THM_HostVerification_Error = new InternalStatusCode("THM_HostVerification_Error", 6, "Host Verification Error", "Certificate verification failure! Potential MITM attack");
        THM_Interrupted_Error = new InternalStatusCode("THM_Interrupted_Error", 7, "Interrupted", "Request was cancelled");
        THM_InvalidOrgID = new InternalStatusCode("THM_InvalidOrgID", 8, "Invalid ORG ID", "Request contained an invalid org id");
        THM_ConfigurationError = new InternalStatusCode("THM_ConfigurationError", 9, "Configuration Error", "Failed to retrieve configuration from server");
        THM_PartialProfile = new InternalStatusCode("THM_PartialProfile", 10, "Partial Profile", "Connection error, only partial profile completed");
        $VALUES = (new InternalStatusCode[] {
            THM_NotYet, THM_OK, THM_Connection_Error, THM_HostNotFound_Error, THM_NetworkTimeout_Error, THM_Internal_Error, THM_HostVerification_Error, THM_Interrupted_Error, THM_InvalidOrgID, THM_ConfigurationError, 
            THM_PartialProfile
        });
    }
}
