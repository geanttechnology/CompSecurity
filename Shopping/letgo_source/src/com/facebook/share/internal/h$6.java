// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.share.internal;

import com.facebook.h;
import com.facebook.share.model.SharePhoto;
import java.util.ArrayList;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.facebook.share.internal:
//            h

static final class b
    implements b
{

    final UUID a;
    final ArrayList b;

    public JSONObject a(SharePhoto sharephoto)
    {
        Object obj = h.a(a, sharephoto);
        if (obj != null) goto _L2; else goto _L1
_L1:
        obj = null;
_L4:
        return ((JSONObject) (obj));
_L2:
        b.add(obj);
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("url", ((android.support.v7.) (obj)).a());
        }
        // Misplaced declaration of an exception variable
        catch (SharePhoto sharephoto)
        {
            throw new h("Unable to attach images", sharephoto);
        }
        obj = jsonobject;
        if (!sharephoto.d()) goto _L4; else goto _L3
_L3:
        jsonobject.put("user_generated", true);
        return jsonobject;
    }

    oto(UUID uuid, ArrayList arraylist)
    {
        a = uuid;
        b = arraylist;
        super();
    }
}
