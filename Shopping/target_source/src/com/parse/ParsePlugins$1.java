// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import com.parse.http.ParseHttpRequest;
import com.parse.http.ParseHttpResponse;
import com.parse.http.ParseNetworkInterceptor;
import java.io.IOException;

// Referenced classes of package com.parse:
//            ParsePlugins, Parse, ManifestInfo, InstallationId

class this._cls0
    implements ParseNetworkInterceptor
{

    final ParsePlugins this$0;

    public ParseHttpResponse intercept(com.parse.http.erceptor.Chain chain)
        throws IOException
    {
        ParseHttpRequest parsehttprequest = chain.getRequest();
        com.parse.http.t.Builder builder = (new com.parse.http.t.Builder(parsehttprequest)).addHeader("X-Parse-Application-Id", ParsePlugins.access$100(ParsePlugins.this)).addHeader("X-Parse-Client-Key", ParsePlugins.access$000(ParsePlugins.this)).addHeader("X-Parse-Client-Version", Parse.externalVersionName()).addHeader("X-Parse-App-Build-Version", String.valueOf(ManifestInfo.getVersionCode())).addHeader("X-Parse-App-Display-Version", ManifestInfo.getVersionName()).addHeader("X-Parse-OS-Version", android.os.ELEASE).addHeader("User-Agent", userAgent());
        if (parsehttprequest.getHeader("X-Parse-Installation-Id") == null)
        {
            builder.addHeader("X-Parse-Installation-Id", installationId().get());
        }
        return chain.proceed(builder.build());
    }

    esponse()
    {
        this$0 = ParsePlugins.this;
        super();
    }
}
