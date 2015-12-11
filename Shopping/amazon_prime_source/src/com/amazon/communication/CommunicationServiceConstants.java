// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;


public class CommunicationServiceConstants
{
    public final class TCOMM_IPC_STATUS
    {

        public static final int INVALID_POLICY_ERROR = 7;
        public static final int MISSING_CREDENTIALS_ERROR = 2;
        public static final int NETWORK_CONNECTIVITY_ERROR = 4;
        public static final int SECURE_PORT_NOT_DEFINED_ERROR = 6;
        public static final int SERVICE_NOT_INITIALIZED_ERROR = 8;
        public static final int SUCCESS = 0;
        public static final int UNKNOWN_ERROR = 1;
        public static final int UNREACHABLE_ENDPOINT_ERROR = 3;
        public static final int WIFI_UNAVAILABLE_ERROR = 5;
        final CommunicationServiceConstants this$0;

        public TCOMM_IPC_STATUS()
        {
            this$0 = CommunicationServiceConstants.this;
            super();
        }
    }


    public static final String COMMUNICATION_SERVICE_INITIALIZED = "com.amazon.intent.COMMUNICATION_SERVICE_INITIALIZED";
    public static final String SERVICE_NAME = "TytoCommunicationService";

    public CommunicationServiceConstants()
    {
    }
}
