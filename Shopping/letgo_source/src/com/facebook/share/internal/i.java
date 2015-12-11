// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.share.internal;

import android.os.Bundle;
import android.support.v7.kb;
import com.facebook.h;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.facebook.share.internal:
//            ShareFeedContent, h

public class i
{

    public static Bundle a(ShareFeedContent sharefeedcontent)
    {
        Bundle bundle = new Bundle();
        kb.a(bundle, "to", sharefeedcontent.a());
        kb.a(bundle, "link", sharefeedcontent.b());
        kb.a(bundle, "picture", sharefeedcontent.f());
        kb.a(bundle, "source", sharefeedcontent.g());
        kb.a(bundle, "name", sharefeedcontent.c());
        kb.a(bundle, "caption", sharefeedcontent.d());
        kb.a(bundle, "description", sharefeedcontent.e());
        return bundle;
    }

    public static Bundle a(ShareLinkContent sharelinkcontent)
    {
        Bundle bundle = new Bundle();
        kb.a(bundle, "href", sharelinkcontent.h());
        return bundle;
    }

    public static Bundle a(ShareOpenGraphContent shareopengraphcontent)
    {
        Bundle bundle;
        bundle = new Bundle();
        kb.a(bundle, "action_type", shareopengraphcontent.a().a());
        try
        {
            shareopengraphcontent = h.a(h.a(shareopengraphcontent), false);
        }
        // Misplaced declaration of an exception variable
        catch (ShareOpenGraphContent shareopengraphcontent)
        {
            throw new h("Unable to serialize the ShareOpenGraphContent to JSON", shareopengraphcontent);
        }
        if (shareopengraphcontent == null)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        if (shareopengraphcontent instanceof JSONObject)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        shareopengraphcontent = shareopengraphcontent.toString();
_L1:
        kb.a(bundle, "action_properties", shareopengraphcontent);
        return bundle;
        shareopengraphcontent = JSONObjectInstrumentation.toString((JSONObject)shareopengraphcontent);
          goto _L1
        return bundle;
    }

    public static Bundle b(ShareLinkContent sharelinkcontent)
    {
        Bundle bundle = new Bundle();
        kb.a(bundle, "name", sharelinkcontent.b());
        kb.a(bundle, "description", sharelinkcontent.a());
        kb.a(bundle, "link", kb.a(sharelinkcontent.h()));
        kb.a(bundle, "picture", kb.a(sharelinkcontent.c()));
        return bundle;
    }
}
