// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm.listingdraft;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.util.SparseArray;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.content.dm.ListingDraftDataManager;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public final class ConditionDefinitionLoadTask extends AsyncTask
{
    private final class RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final ConditionDefinitionLoadTask this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if (!"Help".equals(s1)) goto _L2; else goto _L1
_L1:
            Object obj;
            int i;
            int j;
            int k;
            obj = attributes.getValue("ID").split("_");
            k = -1;
            j = -1;
            i = -1;
            if (obj.length != 3) goto _L4; else goto _L3
_L3:
            k = getSiteId(obj[0]);
            j = Integer.parseInt(obj[1]);
            i = Integer.parseInt(obj[2]);
_L6:
            if (k == site.idInt && j == setId)
            {
                obj = attributes.getValue("Content");
                conditionDefinitions.put(i, obj);
            }
_L2:
            return super.get(s, s1, s2, attributes);
_L4:
            if (obj.length == 4)
            {
                k = getSiteId((new StringBuilder()).append(obj[0]).append(obj[1]).toString());
                j = Integer.parseInt(obj[2]);
                i = Integer.parseInt(obj[3]);
            }
            if (true) goto _L6; else goto _L5
_L5:
        }

        private RootElement()
        {
            this$0 = ConditionDefinitionLoadTask.this;
            super();
        }

    }


    private static final HashMap siteNameMap;
    private final SparseArray conditionDefinitions = new SparseArray();
    private final ListingDraftDataManager listingDraftDataManager;
    private final int setId;
    private final EbaySite site;

    public ConditionDefinitionLoadTask(ListingDraftDataManager listingdraftdatamanager, int i, EbaySite ebaysite)
    {
        listingDraftDataManager = listingdraftdatamanager;
        setId = i;
        site = ebaysite;
    }

    private int getSiteId(String s)
    {
        return ((Integer)siteNameMap.get(s)).intValue();
    }

    protected transient SparseArray doInBackground(Void avoid[])
    {
        int i;
        if (!EbaySite.US.equals(site) && !EbaySite.MOTOR.equals(site))
        {
            avoid = "condition_definitions_intl.xml";
        } else
        {
            avoid = "condition_definitions.xml";
        }
        avoid = listingDraftDataManager.getContext().getAssets().open(avoid);
        i = avoid.available();
        if (i > 0)
        {
            try
            {
                byte abyte0[] = new byte[i];
                avoid.read(abyte0);
                avoid.close();
                SaxHandler.parseXml(abyte0, new RootElement());
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[]) { }
        }
        return conditionDefinitions;
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected void onPostExecute(SparseArray sparsearray)
    {
        super.onPostExecute(sparsearray);
        listingDraftDataManager.handleConditionDefinitionsResult(sparsearray);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((SparseArray)obj);
    }

    static 
    {
        siteNameMap = new HashMap();
        siteNameMap.put("AU", Integer.valueOf(15));
        siteNameMap.put("AT", Integer.valueOf(16));
        siteNameMap.put("NL", Integer.valueOf(123));
        siteNameMap.put("BENL", Integer.valueOf(123));
        siteNameMap.put("BEFR", Integer.valueOf(23));
        siteNameMap.put("CA", Integer.valueOf(2));
        siteNameMap.put("CAFR", Integer.valueOf(210));
        siteNameMap.put("MOTORS", Integer.valueOf(100));
        siteNameMap.put("FR", Integer.valueOf(71));
        siteNameMap.put("DE", Integer.valueOf(77));
        siteNameMap.put("HK", Integer.valueOf(201));
        siteNameMap.put("IN", Integer.valueOf(203));
        siteNameMap.put("IE", Integer.valueOf(205));
        siteNameMap.put("IT", Integer.valueOf(101));
        siteNameMap.put("MY", Integer.valueOf(207));
        siteNameMap.put("NL", Integer.valueOf(146));
        siteNameMap.put("PH", Integer.valueOf(211));
        siteNameMap.put("PL", Integer.valueOf(212));
        siteNameMap.put("SG", Integer.valueOf(216));
        siteNameMap.put("ES", Integer.valueOf(186));
        siteNameMap.put("CH", Integer.valueOf(193));
        siteNameMap.put("UK", Integer.valueOf(3));
        siteNameMap.put("US", Integer.valueOf(0));
    }




}
