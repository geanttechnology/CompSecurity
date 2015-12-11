// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.meta_data;

import com.poshmark.data_model.models.MetaItem;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.poshmark.utils.meta_data:
//            BrandsMetaData

class this._cls0
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

    ()
    {
        this$0 = BrandsMetaData.this;
        super();
    }
}
