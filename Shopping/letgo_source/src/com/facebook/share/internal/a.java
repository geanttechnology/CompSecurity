// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.share.internal;

import android.os.Bundle;
import android.support.v7.kb;
import android.support.v7.kc;
import com.facebook.h;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideoContent;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.facebook.share.internal:
//            h

public class a
{

    private static Bundle a(ShareContent sharecontent, boolean flag)
    {
        Bundle bundle = new Bundle();
        kb.a(bundle, "com.facebook.platform.extra.LINK", sharecontent.h());
        kb.a(bundle, "com.facebook.platform.extra.PLACE", sharecontent.j());
        kb.a(bundle, "com.facebook.platform.extra.REF", sharecontent.k());
        bundle.putBoolean("com.facebook.platform.extra.DATA_FAILURES_FATAL", flag);
        sharecontent = sharecontent.i();
        if (!kb.a(sharecontent))
        {
            bundle.putStringArrayList("com.facebook.platform.extra.FRIENDS", new ArrayList(sharecontent));
        }
        return bundle;
    }

    private static Bundle a(ShareLinkContent sharelinkcontent, boolean flag)
    {
        Bundle bundle = a(((ShareContent) (sharelinkcontent)), flag);
        kb.a(bundle, "com.facebook.platform.extra.TITLE", sharelinkcontent.b());
        kb.a(bundle, "com.facebook.platform.extra.DESCRIPTION", sharelinkcontent.a());
        kb.a(bundle, "com.facebook.platform.extra.IMAGE", sharelinkcontent.c());
        return bundle;
    }

    private static Bundle a(ShareOpenGraphContent shareopengraphcontent, JSONObject jsonobject, boolean flag)
    {
        Bundle bundle = a(((ShareContent) (shareopengraphcontent)), flag);
        kb.a(bundle, "com.facebook.platform.extra.PREVIEW_PROPERTY_NAME", shareopengraphcontent.b());
        kb.a(bundle, "com.facebook.platform.extra.ACTION_TYPE", shareopengraphcontent.a().a());
        if (!(jsonobject instanceof JSONObject))
        {
            shareopengraphcontent = jsonobject.toString();
        } else
        {
            shareopengraphcontent = JSONObjectInstrumentation.toString((JSONObject)jsonobject);
        }
        kb.a(bundle, "com.facebook.platform.extra.ACTION", shareopengraphcontent);
        return bundle;
    }

    private static Bundle a(SharePhotoContent sharephotocontent, List list, boolean flag)
    {
        sharephotocontent = a(((ShareContent) (sharephotocontent)), flag);
        sharephotocontent.putStringArrayList("com.facebook.platform.extra.PHOTOS", new ArrayList(list));
        return sharephotocontent;
    }

    private static Bundle a(ShareVideoContent sharevideocontent, boolean flag)
    {
        return null;
    }

    public static Bundle a(UUID uuid, ShareContent sharecontent, boolean flag)
    {
        kc.a(sharecontent, "shareContent");
        kc.a(uuid, "callId");
        Bundle bundle = null;
        if (sharecontent instanceof ShareLinkContent)
        {
            bundle = a((ShareLinkContent)sharecontent, flag);
        } else
        {
            if (sharecontent instanceof SharePhotoContent)
            {
                sharecontent = (SharePhotoContent)sharecontent;
                return a(((SharePhotoContent) (sharecontent)), h.a(sharecontent, uuid), flag);
            }
            if (sharecontent instanceof ShareVideoContent)
            {
                return a((ShareVideoContent)sharecontent, flag);
            }
            if (sharecontent instanceof ShareOpenGraphContent)
            {
                sharecontent = (ShareOpenGraphContent)sharecontent;
                try
                {
                    uuid = a(((ShareOpenGraphContent) (sharecontent)), h.a(uuid, sharecontent), flag);
                }
                // Misplaced declaration of an exception variable
                catch (UUID uuid)
                {
                    throw new h((new StringBuilder()).append("Unable to create a JSON Object from the provided ShareOpenGraphContent: ").append(uuid.getMessage()).toString());
                }
                return uuid;
            }
        }
        return bundle;
    }
}
