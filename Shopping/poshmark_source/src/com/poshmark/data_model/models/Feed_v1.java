// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models;

import com.poshmark.data_model.customcursors.CustomMatrixCursor;
import com.poshmark.data_model.models.inner_models.Comment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.poshmark.data_model.models:
//            PMData, ListingSocial, ListingDetails

public class Feed_v1 extends PMData
{

    List data;
    HashMap feedHash;
    LinkedHashMap feedMap;
    PMData.NextMaxID more;

    public Feed_v1()
    {
        data = new ArrayList();
        more = null;
        feedHash = new HashMap();
        feedMap = new LinkedHashMap();
    }

    public void addNewComment(String s, Comment comment)
    {
        if (feedMap.containsKey(s))
        {
            ((ListingSocial)feedMap.get(s)).addComment(comment);
        }
    }

    public void append(PMData pmdata)
    {
        if (data != null && pmdata != null)
        {
            pmdata = (Feed_v1)pmdata;
            Iterator iterator = pmdata.getFeedList().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                ListingSocial listingsocial = (ListingSocial)iterator.next();
                if ((ListingSocial)feedMap.put(listingsocial.id, listingsocial) != null)
                {
                    iterator.remove();
                }
            } while (true);
            data.addAll(((Feed_v1) (pmdata)).data);
            more = ((Feed_v1) (pmdata)).more;
        }
    }

    public void createHashAndRemoveDups()
    {
        Iterator iterator = data.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ListingSocial listingsocial = (ListingSocial)iterator.next();
            if ((ListingSocial)feedMap.put(listingsocial.id, listingsocial) != null)
            {
                iterator.remove();
            }
        } while (true);
    }

    public void deleteListing(String s)
    {
        if (feedMap.containsKey(s))
        {
            feedMap.remove(s);
        }
    }

    public void fillCursor(CustomMatrixCursor custommatrixcursor)
    {
        if (data == null) goto _L2; else goto _L1
_L1:
        LinkedHashMap linkedhashmap = feedMap;
        linkedhashmap;
        JVM INSTR monitorenter ;
        for (Iterator iterator = feedMap.entrySet().iterator(); iterator.hasNext(); custommatrixcursor.addRow(new Object[] {
    Integer.valueOf(0), (ListingSocial)((java.util.Map.Entry)iterator.next()).getValue()
})) { }
        break MISSING_BLOCK_LABEL_79;
        custommatrixcursor;
        linkedhashmap;
        JVM INSTR monitorexit ;
        throw custommatrixcursor;
        linkedhashmap;
        JVM INSTR monitorexit ;
_L2:
    }

    public List getFeedList()
    {
        return data;
    }

    public String getNextPageMaxValue()
    {
        if (more != null)
        {
            return more.next_max_id;
        } else
        {
            return null;
        }
    }

    public boolean isEmpty()
    {
        return data.isEmpty();
    }

    public void setNextMaxId(String s)
    {
        more.next_max_id = s;
    }

    public void updateLikeStatus(String s, boolean flag)
    {
        if (feedMap.containsKey(s))
        {
            ((ListingSocial)feedMap.get(s)).setListingLikeStatus(flag);
        }
    }

    public void updateListing(ListingDetails listingdetails)
    {
        if (feedMap.containsKey(listingdetails.getIdAsString()))
        {
            ((ListingSocial)feedMap.get(listingdetails.getIdAsString())).copy(listingdetails);
        }
    }
}
