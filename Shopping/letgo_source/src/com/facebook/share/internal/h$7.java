// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.share.internal;

import android.net.Uri;
import com.facebook.h;
import com.facebook.share.model.SharePhoto;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.facebook.share.internal:
//            h

static final class oto
    implements oto
{

    public JSONObject a(SharePhoto sharephoto)
    {
        sharephoto = sharephoto.c();
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("url", sharephoto.toString());
        }
        // Misplaced declaration of an exception variable
        catch (SharePhoto sharephoto)
        {
            throw new h("Unable to attach images", sharephoto);
        }
        return jsonobject;
    }

    oto()
    {
    }
}
