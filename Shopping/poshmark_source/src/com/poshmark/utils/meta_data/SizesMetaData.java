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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.io.IOUtils;

public class SizesMetaData
{
    class Sizes
    {

        List sizes_by_category;
        final SizesMetaData this$0;

        public List getSizesForCategory(String s)
        {
            for (Iterator iterator = sizes_by_category.iterator(); iterator.hasNext();)
            {
                CategorySizes categorysizes = (CategorySizes)iterator.next();
                if (categorysizes.categoryName.equals(s))
                {
                    return categorysizes.sizes;
                }
            }

            return null;
        }

        Sizes()
        {
            this$0 = SizesMetaData.this;
            super();
            sizes_by_category = new ArrayList();
        }
    }

    class Sizes.CategorySizes
    {

        String categoryName;
        List sizes;
        final Sizes this$1;

        Sizes.CategorySizes()
        {
            this$1 = Sizes.this;
            super();
            sizes = new ArrayList();
        }
    }


    Sizes sizes;

    public SizesMetaData()
    {
        sizes = null;
        loadSizesData();
    }

    private void loadSizesData()
    {
        Object obj;
        Object obj1;
        obj = PMApplication.getContext().getResources().getAssets().open("listing_meta/sizes.json");
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
        obj = ((Gson) (obj1)).fromJson(((String) (obj)), com/poshmark/utils/meta_data/SizesMetaData$Sizes);
_L1:
        sizes = (Sizes)obj;
        return;
        try
        {
            obj = GsonInstrumentation.fromJson((Gson)obj1, ((String) (obj)), com/poshmark/utils/meta_data/SizesMetaData$Sizes);
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
            return;
        }
          goto _L1
    }

    public List getSizeListForCategory(MetaItem metaitem)
    {
        return sizes.getSizesForCategory(metaitem.getDisplay());
    }

    public List getSizeListForCategory(String s)
    {
        return sizes.getSizesForCategory(s);
    }

    public MetaItem getSizeMetaItem(MetaItem metaitem, String s)
    {
label0:
        {
            metaitem = sizes.getSizesForCategory(metaitem.getDisplay());
            if (metaitem == null)
            {
                break label0;
            }
            metaitem = metaitem.iterator();
            MetaItem metaitem1;
            do
            {
                if (!metaitem.hasNext())
                {
                    break label0;
                }
                metaitem1 = (MetaItem)metaitem.next();
            } while (!metaitem1.getId().equals(s));
            return metaitem1;
        }
        return null;
    }
}
