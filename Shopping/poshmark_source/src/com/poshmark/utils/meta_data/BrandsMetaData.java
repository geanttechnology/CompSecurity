// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.meta_data;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.poshmark.application.PMApplication;
import com.poshmark.data_model.models.MetaItem;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.io.IOUtils;

public class BrandsMetaData
{
    class Brands
    {

        List data;
        final BrandsMetaData this$0;

        public MetaItem getBrandFromLabel(String s)
        {
label0:
            {
                if (data == null)
                {
                    break label0;
                }
                Iterator iterator = data.iterator();
                MetaItem metaitem;
                do
                {
                    if (!iterator.hasNext())
                    {
                        break label0;
                    }
                    metaitem = (MetaItem)iterator.next();
                } while (!metaitem.getDisplay().equals(s));
                return metaitem;
            }
            return null;
        }

        public List getList()
        {
            return data;
        }

        Brands()
        {
            this$0 = BrandsMetaData.this;
            super();
        }
    }


    Brands allBrands;
    Brands brands;

    public BrandsMetaData()
    {
        brands = null;
        allBrands = null;
    }

    public BrandsMetaData(MetaItem metaitem)
    {
        brands = null;
        allBrands = null;
        loadBrandsOfCategory(metaitem);
    }

    public List getAllBrands()
    {
        if (allBrands == null)
        {
            loadAllBrands();
        }
        return allBrands.data;
    }

    public MetaItem getBrand(String s)
    {
        if (brands != null)
        {
            return brands.getBrandFromLabel(s);
        } else
        {
            return null;
        }
    }

    public List getBrandListForCategory()
    {
        if (brands != null)
        {
            return brands.data;
        } else
        {
            return null;
        }
    }

    public void loadAllBrands()
    {
        Object obj;
        Object obj1;
        obj = PMApplication.getContext().getResources().getAssets().open("listing_meta/All.json");
        obj1 = new StringWriter();
        IOUtils.copy(((java.io.InputStream) (obj)), ((java.io.Writer) (obj1)), "UTF-8");
        obj = ((StringWriter) (obj1)).toString();
        new Gson();
        obj1 = new GsonBuilder();
        ((GsonBuilder) (obj1)).serializeNulls().excludeFieldsWithModifiers(new int[0]);
        obj1 = ((GsonBuilder) (obj1)).create();
        if (obj1 instanceof Gson)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        obj = ((Gson) (obj1)).fromJson(((String) (obj)), com/poshmark/utils/meta_data/BrandsMetaData$Brands);
_L1:
        allBrands = (Brands)obj;
        return;
        try
        {
            obj = GsonInstrumentation.fromJson((Gson)obj1, ((String) (obj)), com/poshmark/utils/meta_data/BrandsMetaData$Brands);
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
            return;
        }
          goto _L1
    }

    public void loadBrandsOfCategory(MetaItem metaitem)
    {
        if (metaitem == null)
        {
            return;
        }
        Object obj;
        metaitem = (new StringBuilder()).append("listing_meta/").append(metaitem.getId().replace(" ", "_")).append(".json").toString();
        metaitem = PMApplication.getContext().getResources().getAssets().open(metaitem);
        obj = new StringWriter();
        IOUtils.copy(metaitem, ((java.io.Writer) (obj)), "UTF-8");
        metaitem = ((StringWriter) (obj)).toString();
        new Gson();
        obj = new GsonBuilder();
        ((GsonBuilder) (obj)).serializeNulls().excludeFieldsWithModifiers(new int[0]);
        obj = ((GsonBuilder) (obj)).create();
        if (obj instanceof Gson) goto _L2; else goto _L1
_L1:
        metaitem = ((MetaItem) (((Gson) (obj)).fromJson(metaitem, com/poshmark/utils/meta_data/BrandsMetaData$Brands)));
_L3:
        brands = (Brands)metaitem;
        metaitem = PMApplication.getContext().getResources().getAssets().open("listing_meta/Other.json");
        StringWriter stringwriter = new StringWriter();
        IOUtils.copy(metaitem, stringwriter, "UTF-8");
        metaitem = stringwriter.toString();
        if (obj instanceof Gson)
        {
            break MISSING_BLOCK_LABEL_208;
        }
        metaitem = ((MetaItem) (((Gson) (obj)).fromJson(metaitem, com/poshmark/utils/meta_data/BrandsMetaData$Brands)));
_L4:
        allBrands = (Brands)metaitem;
        return;
_L2:
        try
        {
            metaitem = ((MetaItem) (GsonInstrumentation.fromJson((Gson)obj, metaitem, com/poshmark/utils/meta_data/BrandsMetaData$Brands)));
        }
        // Misplaced declaration of an exception variable
        catch (MetaItem metaitem)
        {
            metaitem.printStackTrace();
            return;
        }
          goto _L3
        metaitem = ((MetaItem) (GsonInstrumentation.fromJson((Gson)obj, metaitem, com/poshmark/utils/meta_data/BrandsMetaData$Brands)));
          goto _L4
    }
}
