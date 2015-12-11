// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.givingworks;

import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.kernel.content.ResultStatus;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.common.net.api.givingworks:
//            NonProfitDataManager

private static final class <init>
{

    public Content content;

    public boolean addFavorite(com.ebay.common.model.givingworks.n n)
    {
        if (NonProfitDataManager.logger.ction)
        {
            NonProfitDataManager.logger.ction((new StringBuilder()).append(".addNewFavorite: ").append(n).toString());
        }
        if (content == null) goto _L2; else goto _L1
_L1:
        List list = (List)content.getData();
        for (Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            if (((com.ebay.common.model.givingworks.n.content)iterator.next()).content.equals(n.content))
            {
                return false;
            }
        }

        list.add(n);
        Collections.sort(list);
        content = new Content(list, content.getStatus());
_L4:
        return true;
_L2:
        ArrayList arraylist = new ArrayList();
        arraylist.add(n);
        content = new Content(arraylist, ResultStatus.create(new com.ebay.nautilus.kernel.content.on.content[0]));
        if (true) goto _L4; else goto _L3
_L3:
    }

    public String[] getFavoriteNonprofitIds()
    {
        ArrayList arraylist = new ArrayList();
        if (content != null)
        {
            Object obj = (List)content.getData();
            if (obj != null)
            {
                for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); arraylist.add(((com.ebay.common.model.givingworks.n.content)((Iterator) (obj)).next()).content)) { }
            }
        }
        if (NonProfitDataManager.logger.content)
        {
            NonProfitDataManager.logger.content((new StringBuilder()).append(".getFavoriteNonprofitIds: ").append(arraylist).toString());
        }
        return (String[])arraylist.toArray(new String[arraylist.size()]);
    }

    public boolean removeFavorite(com.ebay.common.model.givingworks.n n)
    {
label0:
        {
            if (NonProfitDataManager.logger.ction)
            {
                NonProfitDataManager.logger.ction((new StringBuilder()).append(".removeFavorite: ").append(n).toString());
            }
            if (content == null)
            {
                break label0;
            }
            List list = (List)content.getData();
            Iterator iterator = list.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
            } while (!n.content.equals(((com.ebay.common.model.givingworks.n.content)iterator.next()).content));
            iterator.remove();
            content = new Content(list, content.getStatus());
            return true;
        }
        return false;
    }

    private ()
    {
        content = null;
    }

    content(content content1)
    {
        this();
    }
}
