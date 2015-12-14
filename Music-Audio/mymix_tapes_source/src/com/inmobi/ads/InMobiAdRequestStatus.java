// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.ads;


public final class InMobiAdRequestStatus
{
    public static final class StatusCode extends Enum
    {

        private static final StatusCode $VALUES[];
        public static final StatusCode AD_ACTIVE;
        public static final StatusCode EARLY_REFRESH_REQUEST;
        public static final StatusCode INTERNAL_ERROR;
        public static final StatusCode NETWORK_UNREACHABLE;
        public static final StatusCode NO_FILL;
        public static final StatusCode REQUEST_INVALID;
        public static final StatusCode REQUEST_PENDING;
        public static final StatusCode REQUEST_TIMED_OUT;
        public static final StatusCode SERVER_ERROR;

        public static StatusCode valueOf(String s)
        {
            return (StatusCode)Enum.valueOf(com/inmobi/ads/InMobiAdRequestStatus$StatusCode, s);
        }

        public static StatusCode[] values()
        {
            return (StatusCode[])$VALUES.clone();
        }

        static 
        {
            NETWORK_UNREACHABLE = new StatusCode("NETWORK_UNREACHABLE", 0);
            NO_FILL = new StatusCode("NO_FILL", 1);
            REQUEST_INVALID = new StatusCode("REQUEST_INVALID", 2);
            REQUEST_PENDING = new StatusCode("REQUEST_PENDING", 3);
            REQUEST_TIMED_OUT = new StatusCode("REQUEST_TIMED_OUT", 4);
            INTERNAL_ERROR = new StatusCode("INTERNAL_ERROR", 5);
            SERVER_ERROR = new StatusCode("SERVER_ERROR", 6);
            AD_ACTIVE = new StatusCode("AD_ACTIVE", 7);
            EARLY_REFRESH_REQUEST = new StatusCode("EARLY_REFRESH_REQUEST", 8);
            $VALUES = (new StatusCode[] {
                NETWORK_UNREACHABLE, NO_FILL, REQUEST_INVALID, REQUEST_PENDING, REQUEST_TIMED_OUT, INTERNAL_ERROR, SERVER_ERROR, AD_ACTIVE, EARLY_REFRESH_REQUEST
            });
        }

        private StatusCode(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String AD_ACTIVE_MESSAGE = "The Ad Request could not be submitted as the user is viewing another Ad.";
    private static final String AD_EARLY_REFRESH_MESSAGE = "The Ad Request cannot be done so frequently. Please wait for some time before loading another ad.";
    private static final String INTERNAL_ERROR_MESSAGE = "The InMobi SDK encountered an internal error.";
    private static final String NETWORK_UNREACHABLE_MESSAGE = "The Internet is unreachable. Please check your Internet connection.";
    private static final String NO_FILL_MESSAGE = "Ad request successful but no ad served.";
    private static final String REQUEST_INVALID_MESSAGE = "An invalid ad request was sent and was rejected by the Ad Network. Please validate the ad request and try again";
    private static final String REQUEST_PENDING_MESSAGE = "The SDK is pending response to a previous ad request. Please wait for the previous ad request to complete before requesting for another ad.";
    private static final String REQUEST_TIMED_OUT_MESSAGE = "The Ad Request timed out waiting for a response from the network. This can be caused due to a bad network connection. Please try again after a few minutes.";
    private static final String SERVER_ERROR_MESSAGE = "The Ad Server encountered an error when processing the ad request. This may be a transient issue. Please try again in a few minutes";
    private String mMessage;
    private StatusCode mStatusCode;

    public InMobiAdRequestStatus(StatusCode statuscode)
    {
        mStatusCode = statuscode;
        setMessage();
    }

    private void setMessage()
    {
        static class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[StatusCode.values().length];
                try
                {
                    a[StatusCode.INTERNAL_ERROR.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    a[StatusCode.NETWORK_UNREACHABLE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    a[StatusCode.REQUEST_INVALID.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    a[StatusCode.REQUEST_PENDING.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    a[StatusCode.REQUEST_TIMED_OUT.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[StatusCode.SERVER_ERROR.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[StatusCode.NO_FILL.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[StatusCode.AD_ACTIVE.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[StatusCode.EARLY_REFRESH_REQUEST.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1.a[mStatusCode.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            mMessage = "The InMobi SDK encountered an internal error.";
            return;

        case 2: // '\002'
            mMessage = "The Internet is unreachable. Please check your Internet connection.";
            return;

        case 3: // '\003'
            mMessage = "An invalid ad request was sent and was rejected by the Ad Network. Please validate the ad request and try again";
            return;

        case 4: // '\004'
            mMessage = "The SDK is pending response to a previous ad request. Please wait for the previous ad request to complete before requesting for another ad.";
            return;

        case 5: // '\005'
            mMessage = "The Ad Request timed out waiting for a response from the network. This can be caused due to a bad network connection. Please try again after a few minutes.";
            return;

        case 6: // '\006'
            mMessage = "The Ad Server encountered an error when processing the ad request. This may be a transient issue. Please try again in a few minutes";
            return;

        case 7: // '\007'
            mMessage = "Ad request successful but no ad served.";
            return;

        case 8: // '\b'
            mMessage = "The Ad Request could not be submitted as the user is viewing another Ad.";
            return;

        case 9: // '\t'
            mMessage = "The Ad Request cannot be done so frequently. Please wait for some time before loading another ad.";
            break;
        }
    }

    public String getMessage()
    {
        return mMessage;
    }

    public StatusCode getStatusCode()
    {
        return mStatusCode;
    }

    public InMobiAdRequestStatus setCustomMessage(String s)
    {
        if (s != null)
        {
            mMessage = s;
        }
        return this;
    }
}
