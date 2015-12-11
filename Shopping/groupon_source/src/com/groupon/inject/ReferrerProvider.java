// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.inject;

import com.google.inject.Provider;
import com.groupon.service.AttributionService;
import java.io.IOException;
import java.util.HashMap;
import oauth.signpost.OAuth;
import roboguice.util.Strings;

public class ReferrerProvider
    implements Provider
{

    private AttributionService attributionService;

    public ReferrerProvider()
    {
    }

    public volatile Object get()
    {
        return get();
    }

    public String get()
    {
        final String cid = attributionService.getAttributionDownloadCid();
        final String attribution = attributionService.getAttributionDownloadId();
        try
        {
            cid = OAuth.percentEncode(OAuth.formEncode((new HashMap() {

                final ReferrerProvider this$0;
                final String val$attribution;
                final String val$cid;

            
            {
                this$0 = ReferrerProvider.this;
                cid = s;
                attribution = s1;
                super();
                if (Strings.notEmpty(cid))
                {
                    put("cid", cid);
                }
                if (Strings.notEmpty(attribution))
                {
                    put("attribution", attribution);
                }
            }
            }).entrySet()));
        }
        catch (IOException ioexception)
        {
            throw new RuntimeException(ioexception);
        }
        return cid;
    }
}
