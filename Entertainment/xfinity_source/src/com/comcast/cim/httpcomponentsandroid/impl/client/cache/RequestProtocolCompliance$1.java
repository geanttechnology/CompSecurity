// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.client.cache;


// Referenced classes of package com.comcast.cim.httpcomponentsandroid.impl.client.cache:
//            RequestProtocolCompliance, RequestProtocolError

static class Y
{

    static final int $SwitchMap$com$comcast$cim$httpcomponentsandroid$impl$client$cache$RequestProtocolError[];

    static 
    {
        $SwitchMap$com$comcast$cim$httpcomponentsandroid$impl$client$cache$RequestProtocolError = new int[RequestProtocolError.values().length];
        try
        {
            $SwitchMap$com$comcast$cim$httpcomponentsandroid$impl$client$cache$RequestProtocolError[RequestProtocolError.BODY_BUT_NO_LENGTH_ERROR.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$comcast$cim$httpcomponentsandroid$impl$client$cache$RequestProtocolError[RequestProtocolError.WEAK_ETAG_AND_RANGE_ERROR.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$comcast$cim$httpcomponentsandroid$impl$client$cache$RequestProtocolError[RequestProtocolError.WEAK_ETAG_ON_PUTDELETE_METHOD_ERROR.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$comcast$cim$httpcomponentsandroid$impl$client$cache$RequestProtocolError[RequestProtocolError.NO_CACHE_DIRECTIVE_WITH_FIELD_NAME.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
