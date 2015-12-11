// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.fabric.sdk.android.services.settings;

import android.content.Context;
import android.content.res.Resources;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.KitInfo;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.common.AbstractSpiCall;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.ResponseParser;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;

// Referenced classes of package io.fabric.sdk.android.services.settings:
//            AppRequestData, IconRequest

abstract class AbstractAppSpiCall extends AbstractSpiCall
{

    public AbstractAppSpiCall(Kit kit, String s, String s1, HttpRequestFactory httprequestfactory, HttpMethod httpmethod)
    {
        super(kit, s, s1, httprequestfactory, httpmethod);
    }

    private HttpRequest applyHeadersTo(HttpRequest httprequest, AppRequestData apprequestdata)
    {
        return httprequest.header("X-CRASHLYTICS-API-KEY", apprequestdata.apiKey).header("X-CRASHLYTICS-API-CLIENT-TYPE", "android").header("X-CRASHLYTICS-API-CLIENT-VERSION", kit.getVersion());
    }

    private HttpRequest applyMultipartDataTo(HttpRequest httprequest, AppRequestData apprequestdata)
    {
        Object obj;
        HttpRequest httprequest1;
        httprequest1 = httprequest.part("app[identifier]", apprequestdata.appId).part("app[name]", apprequestdata.name).part("app[display_version]", apprequestdata.displayVersion).part("app[build_version]", apprequestdata.buildVersion).part("app[source]", Integer.valueOf(apprequestdata.source)).part("app[minimum_sdk_version]", apprequestdata.minSdkVersion).part("app[built_sdk_version]", apprequestdata.builtSdkVersion);
        if (!CommonUtils.isNullOrEmpty(apprequestdata.instanceIdentifier))
        {
            httprequest1.part("app[instance_identifier]", apprequestdata.instanceIdentifier);
        }
        if (apprequestdata.icon == null)
        {
            break MISSING_BLOCK_LABEL_193;
        }
        obj = null;
        httprequest = null;
        java.io.InputStream inputstream = kit.getContext().getResources().openRawResource(apprequestdata.icon.iconResourceId);
        httprequest = inputstream;
        obj = inputstream;
        httprequest1.part("app[icon][hash]", apprequestdata.icon.hash).part("app[icon][data]", "icon.png", "application/octet-stream", inputstream).part("app[icon][width]", Integer.valueOf(apprequestdata.icon.width)).part("app[icon][height]", Integer.valueOf(apprequestdata.icon.height));
        CommonUtils.closeOrLog(inputstream, "Failed to close app icon InputStream.");
_L2:
        if (apprequestdata.sdkKits != null)
        {
            for (httprequest = apprequestdata.sdkKits.iterator(); httprequest.hasNext(); httprequest1.part(getKitBuildTypeKey(apprequestdata), apprequestdata.getBuildType()))
            {
                apprequestdata = (KitInfo)httprequest.next();
                httprequest1.part(getKitVersionKey(apprequestdata), apprequestdata.getVersion());
            }

        }
        break MISSING_BLOCK_LABEL_321;
        android.content.res.Resources.NotFoundException notfoundexception;
        notfoundexception;
        obj = httprequest;
        Fabric.getLogger().e("Fabric", (new StringBuilder()).append("Failed to find app icon with resource ID: ").append(apprequestdata.icon.iconResourceId).toString(), notfoundexception);
        CommonUtils.closeOrLog(httprequest, "Failed to close app icon InputStream.");
        if (true) goto _L2; else goto _L1
_L1:
        httprequest;
        CommonUtils.closeOrLog(((java.io.Closeable) (obj)), "Failed to close app icon InputStream.");
        throw httprequest;
        return httprequest1;
    }

    String getKitBuildTypeKey(KitInfo kitinfo)
    {
        return String.format(Locale.US, "app[build][libraries][%s][type]", new Object[] {
            kitinfo.getIdentifier()
        });
    }

    String getKitVersionKey(KitInfo kitinfo)
    {
        return String.format(Locale.US, "app[build][libraries][%s][version]", new Object[] {
            kitinfo.getIdentifier()
        });
    }

    public boolean invoke(AppRequestData apprequestdata)
    {
        HttpRequest httprequest = applyMultipartDataTo(applyHeadersTo(getHttpRequest(), apprequestdata), apprequestdata);
        Fabric.getLogger().d("Fabric", (new StringBuilder()).append("Sending app info to ").append(getUrl()).toString());
        if (apprequestdata.icon != null)
        {
            Fabric.getLogger().d("Fabric", (new StringBuilder()).append("App icon hash is ").append(apprequestdata.icon.hash).toString());
            Fabric.getLogger().d("Fabric", (new StringBuilder()).append("App icon size is ").append(apprequestdata.icon.width).append("x").append(apprequestdata.icon.height).toString());
        }
        int i = httprequest.code();
        if ("POST".equals(httprequest.method()))
        {
            apprequestdata = "Create";
        } else
        {
            apprequestdata = "Update";
        }
        Fabric.getLogger().d("Fabric", (new StringBuilder()).append(apprequestdata).append(" app request ID: ").append(httprequest.header("X-REQUEST-ID")).toString());
        Fabric.getLogger().d("Fabric", (new StringBuilder()).append("Result was ").append(i).toString());
        return ResponseParser.parse(i) == 0;
    }
}
