// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONArray;

// Referenced classes of package com.apprupt.sdk:
//            CvMediation, SimpleJSON

class this._cls0
    implements this._cls0
{

    final CvMediation this$0;

    public void run(Object obj, this._cls0 _pcls0)
        throws Exception
    {
        CvMediation.access$300()._mth300(new Object[] {
            "Processing order config..."
        });
        obj = (SimpleJSON)obj;
        SimpleJSON simplejson = ((SimpleJSON) (obj)).getJSONObject("order");
        if (simplejson != null)
        {
            CvMediation.access$800(CvMediation.this).clear();
            JSONArray jsonarray = simplejson.names();
            for (int i = 0; i < jsonarray.length(); i++)
            {
                String s = jsonarray.getString(i);
                CvMediation.access$800(CvMediation.this).put(s, simplejson.getStringsList(s, new ArrayList()));
            }

        }
        if (!CvMediation.access$800(CvMediation.this).containsKey("__default__"))
        {
            CvMediation.access$800(CvMediation.this).put("__default__", new ArrayList(Arrays.asList(com.apprupt.sdk.mediation.efaultOrder())));
        }
        CvMediation.access$700()._mth700(new Object[] {
            "Resolve: process order config:", obj
        });
        _pcls0.olve(obj);
    }

    ter.Info()
    {
        this$0 = CvMediation.this;
        super();
    }
}
