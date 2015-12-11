// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.product;

import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class ata
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    private ArrayList commonFeatures;
    private ArrayList conditionalFeatures;
    private ArrayList protectionServicesList;
    private ArrayList terms;

    public static ata getProtectionServicesData(JSONObject jsonobject)
    {
        ata ata;
        JSONArray jsonarray;
        ata = new <init>();
        ata.conditionalFeatures = new ArrayList();
        ata.commonFeatures = new ArrayList();
        ata.terms = new ArrayList();
        ata.protectionServicesList = new ArrayList();
        jsonarray = jsonobject.getJSONArray("conditionalFeatures");
        if (jsonarray == null) goto _L2; else goto _L1
_L1:
        if (!jsonarray.getJSONObject(0).getJSONArray("columns").getJSONObject(0).optString("planType").toString().equalsIgnoreCase("GSP-R")) goto _L4; else goto _L3
_L3:
        ata ata2 = new ata("Protection Plan Benefits*", "Replacement Plan", "");
        ata.protectionServicesList.add(ata2);
_L5:
        for (int i = 0; i < jsonarray.length(); i++)
        {
            Object obj1 = jsonarray.getJSONObject(i);
            if (obj1 != null)
            {
                String s1 = ((JSONObject) (obj1)).getJSONArray("columns").getJSONObject(0).optString("serviceInFeature");
                String s4 = ((JSONObject) (obj1)).optString("description");
                obj1 = new ata(((JSONObject) (obj1)).optString("title"), s1, s4);
                ata.conditionalFeatures.add(obj1);
                ata.protectionServicesList.add(obj1);
            }
        }

        break; /* Loop/switch isn't completed */
_L4:
        if (jsonarray.getJSONObject(0).getJSONArray("columns").getJSONObject(0).optString("planType").toString().equalsIgnoreCase("GSP"))
        {
            ata ata3 = new ata("Protection Plan Benefits*", "Standard Protection Plan", "");
            ata.protectionServicesList.add(ata3);
        } else
        if (jsonarray.getJSONObject(0).getJSONArray("columns").getJSONObject(0).optString("planType").toString().equalsIgnoreCase("ADH"))
        {
            ata ata4 = new ata("Protection Plan Benefits*", "Accidental Damage\n from Handling Plans", "");
            ata.protectionServicesList.add(ata4);
        }
        if (true) goto _L5; else goto _L2
_L2:
        JSONArray jsonarray1 = jsonobject.getJSONArray("commonFeatures");
        if (jsonarray1 != null)
        {
            ata ata5 = new ata("Peace of Mind with Every Plan", "", "");
            ata.protectionServicesList.add(ata5);
            for (int j = 0; j < jsonarray1.length(); j++)
            {
                Object obj2 = jsonarray1.optJSONObject(j);
                if (obj2 != null)
                {
                    String s2 = ((JSONObject) (obj2)).optString("description");
                    String s5 = ((JSONObject) (obj2)).getJSONArray("columns").getJSONObject(0).optString("serviceInFeature");
                    obj2 = new ata(((JSONObject) (obj2)).optString("title"), s5, s2);
                    ata.commonFeatures.add(obj2);
                    ata.protectionServicesList.add(obj2);
                }
            }

        }
        jsonobject = jsonobject.optJSONArray("terms");
        if (jsonobject != null)
        {
            ata ata1 = new ata("Available Plans", "", "");
            ata.protectionServicesList.add(ata1);
            for (int k = 0; k < jsonobject.length(); k++)
            {
                Object obj = jsonobject.optJSONObject(k);
                if (obj != null)
                {
                    String s = ((JSONObject) (obj)).optString("description");
                    String s3 = ((JSONObject) (obj)).optJSONArray("columns").optJSONObject(0).optString("price");
                    obj = new ata(((JSONObject) (obj)).optString("term"), (new StringBuilder()).append("$").append(s3).toString(), s);
                    ata.terms.add(obj);
                    ata.protectionServicesList.add(obj);
                }
            }

        }
        return ata;
    }

    public ArrayList getCommonFeaturesList()
    {
        return commonFeatures;
    }

    public ArrayList getConditionalFeaturesList()
    {
        return conditionalFeatures;
    }

    public ArrayList getProtectionServicesList()
    {
        return protectionServicesList;
    }

    public ArrayList getTermsList()
    {
        return terms;
    }

    public ata()
    {
    }
}
