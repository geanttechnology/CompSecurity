// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.flurry.sdk:
//            lb, hs, hv, hp, 
//            hu, hz, hy, ic, 
//            kg

public class is
    implements lb
{

    private static final String a = com/flurry/sdk/is.getSimpleName();

    public is()
    {
    }

    private void a(JSONObject jsonobject, String s, String s1)
    {
        if (jsonobject == null)
        {
            throw new IOException("Null Json object");
        }
        if (s1 != null)
        {
            jsonobject.put(s, s1);
            return;
        } else
        {
            jsonobject.put(s, JSONObject.NULL);
            return;
        }
    }

    public hs a(InputStream inputstream)
    {
        throw new IOException("Deserialize not supported for request");
    }

    public void a(OutputStream outputstream, hs hs1)
    {
        DataOutputStream dataoutputstream;
        JSONObject jsonobject;
        if (outputstream == null || hs1 == null)
        {
            return;
        }
        dataoutputstream = new DataOutputStream(outputstream) {

            final is a;

            public void close()
            {
            }

            
            {
                a = is.this;
                super(outputstream);
            }
        };
        jsonobject = new JSONObject();
        a(jsonobject, "project_key", hs1.a);
        a(jsonobject, "bundle_id", hs1.b);
        a(jsonobject, "app_version", hs1.c);
        jsonobject.put("sdk_version", hs1.d);
        jsonobject.put("platform", hs1.e);
        a(jsonobject, "platform_version", hs1.f);
        jsonobject.put("limit_ad_tracking", hs1.g);
        if (hs1.h == null || hs1.h.a == null) goto _L2; else goto _L1
_L1:
        outputstream = new JSONObject();
        JSONObject jsonobject1 = new JSONObject();
        a(jsonobject1, "model", hs1.h.a.a);
        a(jsonobject1, "brand", hs1.h.a.b);
        a(jsonobject1, "id", hs1.h.a.c);
        a(jsonobject1, "device", hs1.h.a.d);
        a(jsonobject1, "product", hs1.h.a.e);
        a(jsonobject1, "version_release", hs1.h.a.f);
        outputstream.put("com.flurry.proton.generated.avro.v2.AndroidTags", jsonobject1);
_L12:
        if (outputstream == null)
        {
            break MISSING_BLOCK_LABEL_381;
        }
        jsonobject.put("device_tags", outputstream);
_L3:
        outputstream = new JSONArray();
        JSONObject jsonobject3;
        for (Iterator iterator = hs1.i.iterator(); iterator.hasNext(); outputstream.put(jsonobject3))
        {
            hu hu1 = (hu)iterator.next();
            jsonobject3 = new JSONObject();
            jsonobject3.put("type", hu1.a);
            a(jsonobject3, "id", hu1.b);
        }

        break MISSING_BLOCK_LABEL_395;
        outputstream;
        throw new IOException("Invalid Json", outputstream);
        outputstream;
        dataoutputstream.close();
        throw outputstream;
        jsonobject.put("device_tags", JSONObject.NULL);
          goto _L3
        jsonobject.put("device_ids", outputstream);
        if (hs1.j == null || hs1.j.a == null) goto _L5; else goto _L4
_L4:
        outputstream = new JSONObject();
        JSONObject jsonobject2 = new JSONObject();
        jsonobject2.putOpt("latitude", Double.valueOf(hs1.j.a.a));
        jsonobject2.putOpt("longitude", Double.valueOf(hs1.j.a.b));
        jsonobject2.putOpt("accuracy", Float.valueOf(hs1.j.a.c));
        outputstream.put("com.flurry.proton.generated.avro.v2.Geolocation", jsonobject2);
_L10:
        if (outputstream == null) goto _L7; else goto _L6
_L6:
        jsonobject.put("geo", outputstream);
_L8:
        outputstream = new JSONObject();
        if (hs1.k == null)
        {
            break MISSING_BLOCK_LABEL_626;
        }
        a(((JSONObject) (outputstream)), "string", hs1.k.a);
        jsonobject.put("publisher_user_id", outputstream);
_L9:
        kg.a(5, a, (new StringBuilder()).append("Proton Request String: ").append(jsonobject.toString()).toString());
        dataoutputstream.write(jsonobject.toString().getBytes());
        dataoutputstream.flush();
        dataoutputstream.close();
        return;
_L7:
        jsonobject.put("geo", JSONObject.NULL);
          goto _L8
        jsonobject.put("publisher_user_id", JSONObject.NULL);
          goto _L9
_L5:
        outputstream = null;
        if (true) goto _L10; else goto _L2
_L2:
        outputstream = null;
        if (true) goto _L12; else goto _L11
_L11:
    }

    public volatile void a(OutputStream outputstream, Object obj)
    {
        a(outputstream, (hs)obj);
    }

    public Object b(InputStream inputstream)
    {
        return a(inputstream);
    }

}
