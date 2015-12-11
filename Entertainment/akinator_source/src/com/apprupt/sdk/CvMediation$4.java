// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import com.apprupt.sdk.mediation.Adapter;
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
            "Processing adapters config..."
        });
        obj = (SimpleJSON)obj;
        SimpleJSON simplejson = ((SimpleJSON) (obj)).getJSONObject("adapters");
        if (simplejson != null)
        {
            JSONArray jsonarray = simplejson.names();
            for (int i = 0; i < jsonarray.length(); i++)
            {
                String s = (String)jsonarray.get(i);
                if (CvMediation.access$500(CvMediation.this).containsKey(s))
                {
                    CvMediation.access$600(CvMediation.this)._mth0(new Object[] {
                        "Configuration for", s
                    });
                    ((Adapter)CvMediation.access$500(CvMediation.this).get(s)).configure(simplejson.getJSONObject(s).json);
                }
            }

        }
        CvMediation.access$700()._mth700(new Object[] {
            "Resolve: process adapters config:", obj
        });
        _pcls0.olve(obj);
    }

    ter()
    {
        this$0 = CvMediation.this;
        super();
    }
}
