// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.io.IOException;

// Referenced classes of package com.parse:
//            ParseNetworkInterceptor, ParsePlugins, ManifestInfo, ParseHttpRequest, 
//            InstallationId, ParseHttpResponse

class this._cls0
    implements ParseNetworkInterceptor
{

    final ParsePlugins this$0;

    public ParseHttpResponse intercept(erceptor.Chain chain)
        throws IOException
    {
        ParseHttpRequest parsehttprequest = chain.getRequest();
        t.Builder builder = (new t.Builder(parsehttprequest)).addHeader("X-Parse-Application-Id", ParsePlugins.access$100(ParsePlugins.this)).addHeader("X-Parse-Client-Key", ParsePlugins.access$000(ParsePlugins.this)).addHeader("X-Parse-Client-Version", "a1.9.4").addHeader("X-Parse-App-Build-Version", String.valueOf(ManifestInfo.getVersionCode())).addHeader("X-Parse-App-Display-Version", ManifestInfo.getVersionName()).addHeader("X-Parse-OS-Version", android.os.ELEASE).addHeader("User-Agent", userAgent());
        if (parsehttprequest.getHeader("X-Parse-Installation-Id") == null)
        {
            builder.addHeader("X-Parse-Installation-Id", installationId().get());
        }
        return chain.proceed(builder.build());
    }

    se()
    {
        this$0 = ParsePlugins.this;
        super();
    }
}
