// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import org.json.JSONObject;

// Referenced classes of package com.apprupt.sdk:
//            CvConfig, SimpleJSON

class this._cls0
    implements this._cls0
{

    final CvConfig this$0;

    public void run(Object obj, this._cls0 _pcls0)
        throws Exception
    {
label0:
        {
            CvConfig.access$000(CvConfig.this).(new Object[] {
                "Parsing config..."
            });
            obj = (String)obj;
            if (((String) (obj)).equals("null") || !((String) (obj)).startsWith("{") || !((String) (obj)).endsWith("}"))
            {
                throw new Exception("Cannot parse response - invalid JSON string");
            }
            SimpleJSON simplejson = new SimpleJSON(new JSONObject(((String) (obj))));
            SimpleJSON simplejson1 = simplejson.getJSONObject("mediation", new SimpleJSON("{\"dummy\":true}"));
            if (simplejson1 != null && !simplejson1.getBoolean("dummy", false))
            {
                obj = simplejson;
                if (simplejson1.has("adapters"))
                {
                    break label0;
                }
            }
            obj = new SimpleJSON();
            ((SimpleJSON) (obj)).put("mediation", simplejson.json);
        }
        CvConfig.access$000(CvConfig.this).(new Object[] {
            "Resolve: parse config:", obj
        });
        _pcls0.esolve(obj);
    }

    ()
    {
        this$0 = CvConfig.this;
        super();
    }
}
