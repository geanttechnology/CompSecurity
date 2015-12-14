// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.openapi;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.Log;

// Referenced classes of package com.tencent.mm.sdk.openapi:
//            WXMediaMessage

public class ject
{

    public static final String KEY_IDENTIFIER = "_wxobject_identifier_";

    public static WXMediaMessage fromBundle(Bundle bundle)
    {
        WXMediaMessage wxmediamessage = new WXMediaMessage();
        wxmediamessage.sdkVer = bundle.getInt("_wxobject_sdkVer");
        wxmediamessage.title = bundle.getString("_wxobject_title");
        wxmediamessage.description = bundle.getString("_wxobject_description");
        wxmediamessage.thumbData = bundle.getByteArray("_wxobject_thumbdata");
        String s = bundle.getString("_wxobject_identifier_");
        if (s == null || s.length() <= 0)
        {
            return wxmediamessage;
        }
        try
        {
            wxmediamessage.mediaObject = (ject)Class.forName(s).newInstance();
            wxmediamessage.mediaObject.unserialize(bundle);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
            Log.e("MicroMsg.SDK.WXMediaMessage", (new StringBuilder("get media object from bundle failed: unknown ident ")).append(s).toString());
            return wxmediamessage;
        }
        return wxmediamessage;
    }

    public static Bundle toBundle(WXMediaMessage wxmediamessage)
    {
        Bundle bundle = new Bundle();
        bundle.putInt("_wxobject_sdkVer", wxmediamessage.sdkVer);
        bundle.putString("_wxobject_title", wxmediamessage.title);
        bundle.putString("_wxobject_description", wxmediamessage.description);
        bundle.putByteArray("_wxobject_thumbdata", wxmediamessage.thumbData);
        if (wxmediamessage.mediaObject != null)
        {
            bundle.putString("_wxobject_identifier_", wxmediamessage.mediaObject.getClass().getName());
            wxmediamessage.mediaObject.serialize(bundle);
        }
        return bundle;
    }

    public ject()
    {
    }
}
