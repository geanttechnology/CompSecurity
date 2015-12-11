// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models;

import com.poshmark.data_model.customcursors.CustomMatrixCursor;
import com.poshmark.data_model.models.inner_models.Comment;
import com.poshmark.data_model.models.inner_models.Like;
import com.poshmark.data_model.models.inner_models.UserReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.poshmark.data_model.models:
//            PMData, ListingSocial

public class UserInteractions extends PMData
{

    List data;

    public UserInteractions()
    {
        data = new ArrayList();
    }

    public void addContextualData(ListingSocial listingsocial)
    {
        HashMap hashmap = new HashMap();
        if (listingsocial != null && listingsocial.comments != null)
        {
            Comment comment;
            UserReference userreference1;
            for (Iterator iterator = listingsocial.comments.iterator(); iterator.hasNext(); hashmap.put(comment.creator_id, userreference1))
            {
                comment = (Comment)iterator.next();
                userreference1 = new UserReference();
                userreference1.setDisplayHandle(comment.getCommenterDisplayHandle());
            }

        }
        if (listingsocial != null && listingsocial.likes != null)
        {
            Like like;
            UserReference userreference;
            for (listingsocial = listingsocial.likes.iterator(); listingsocial.hasNext(); hashmap.put(like.creator_id, userreference))
            {
                like = (Like)listingsocial.next();
                userreference = new UserReference();
                userreference.setDisplayHandle(like.getDisplayHandle());
            }

        }
        for (listingsocial = hashmap.values().iterator(); listingsocial.hasNext(); data.add(listingsocial.next())) { }
    }

    public void fillCursor(CustomMatrixCursor custommatrixcursor)
    {
        if (data == null) goto _L2; else goto _L1
_L1:
        List list = data;
        list;
        JVM INSTR monitorenter ;
        for (Iterator iterator = data.iterator(); iterator.hasNext(); custommatrixcursor.addRow(new Object[] {
    Integer.valueOf(0), (UserReference)iterator.next()
})) { }
        break MISSING_BLOCK_LABEL_68;
        custommatrixcursor;
        list;
        JVM INSTR monitorexit ;
        throw custommatrixcursor;
        list;
        JVM INSTR monitorexit ;
_L2:
    }

    public void fillFilteredCursor(CustomMatrixCursor custommatrixcursor, CharSequence charsequence)
    {
        if (data == null) goto _L2; else goto _L1
_L1:
        List list = data;
        list;
        JVM INSTR monitorenter ;
        Iterator iterator = data.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            UserReference userreference = (UserReference)iterator.next();
            if (userreference.getDisplayHandle().startsWith(charsequence.toString()))
            {
                custommatrixcursor.addRow(new Object[] {
                    Integer.valueOf(0), userreference
                });
            }
        } while (true);
        break MISSING_BLOCK_LABEL_92;
        custommatrixcursor;
        list;
        JVM INSTR monitorexit ;
        throw custommatrixcursor;
        list;
        JVM INSTR monitorexit ;
_L2:
    }

    public String[] getInteractionArray()
    {
        ArrayList arraylist = new ArrayList(data.size());
        UserReference userreference;
        for (Iterator iterator = data.iterator(); iterator.hasNext(); arraylist.add((new StringBuilder()).append("@").append(userreference.getDisplayHandle()).toString()))
        {
            userreference = (UserReference)iterator.next();
        }

        return (String[])arraylist.toArray(new String[0]);
    }
}
