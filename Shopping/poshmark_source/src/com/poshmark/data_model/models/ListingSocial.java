// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models;

import com.poshmark.application.PMApplicationSession;
import com.poshmark.data_model.customcursors.CustomMatrixCursor;
import com.poshmark.data_model.models.inner_models.Comment;
import com.poshmark.data_model.models.inner_models.FeedContext;
import com.poshmark.data_model.models.inner_models.Like;
import com.poshmark.data_model.models.inner_models.ListingAggregates;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.poshmark.data_model.models:
//            ListingSummary, ListingDetails, EventContext

public class ListingSocial extends ListingSummary
{

    List comments;
    EventContext event_context;
    FeedContext feed_context;
    List likes;

    public ListingSocial()
    {
    }

    private void copyComments(ListingDetails listingdetails)
    {
        listingdetails = listingdetails.getComments();
        if (comments != null)
        {
            comments.clear();
        }
        if (listingdetails != null)
        {
            int j = listingdetails.size();
            if (j > 0)
            {
                if (comments == null)
                {
                    comments = new ArrayList();
                }
                for (int i = 0; i < j; i++)
                {
                    Comment comment = (Comment)listingdetails.get(i);
                    Comment comment1 = new Comment();
                    comment1.copy(comment);
                    comments.add(i, comment1);
                }

            }
        }
    }

    private void copyLikes(ListingDetails listingdetails)
    {
        listingdetails = listingdetails.getLikes();
        if (likes != null)
        {
            likes.clear();
        }
        if (listingdetails != null)
        {
            int j = listingdetails.size();
            if (j > 0)
            {
                if (likes == null)
                {
                    likes = new ArrayList();
                }
                for (int i = 0; i < j; i++)
                {
                    Like like = (Like)listingdetails.get(i);
                    Like like1 = new Like();
                    like1.copy(like);
                    likes.add(i, like1);
                }

            }
        }
    }

    public void addComment(Comment comment)
    {
        if (comments == null)
        {
            comments = new ArrayList();
        }
        Comment comment1 = new Comment();
        comment1.copy(comment);
        comments.add(comment1);
        comment = aggregates;
        comment.comments = ((ListingAggregates) (comment)).comments + 1;
    }

    public void copy(ListingDetails listingdetails)
    {
        super.copy(listingdetails);
        copyComments(listingdetails);
        copyLikes(listingdetails);
        if (feed_context != null)
        {
            feed_context.copy(listingdetails.feed_context);
        }
        if (event_context != null)
        {
            event_context.copy(listingdetails.event_context);
        }
    }

    public void deleteComment(int i)
    {
        if (comments != null && comments.size() > i)
        {
            comments.remove(i);
        }
        ListingAggregates listingaggregates = aggregates;
        listingaggregates.comments = listingaggregates.comments - 1;
    }

    public void fillCursorForComments(CustomMatrixCursor custommatrixcursor)
    {
        if (comments == null) goto _L2; else goto _L1
_L1:
        List list = comments;
        list;
        JVM INSTR monitorenter ;
        for (Iterator iterator = comments.iterator(); iterator.hasNext(); custommatrixcursor.addRow(new Object[] {
    Integer.valueOf(0), (Comment)iterator.next()
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

    public List getComments()
    {
        return comments;
    }

    public EventContext getEventContext()
    {
        return event_context;
    }

    public List getLikes()
    {
        return likes;
    }

    public String getSharedAtTime()
    {
        if (feed_context != null)
        {
            return feed_context.shared_at;
        } else
        {
            return null;
        }
    }

    public String getSharedByUserName()
    {
        Object obj = null;
        String s = obj;
        if (feed_context != null)
        {
            s = obj;
            if (feed_context.shared)
            {
                s = feed_context.shared_by_username;
            }
        }
        return s;
    }

    public boolean hasEventContext()
    {
        return event_context != null;
    }

    public boolean hasFeedContext()
    {
        return feed_context != null;
    }

    public void setListingLikeStatus(boolean flag)
    {
        super.setListingLikeStatus(flag);
        if (likes != null)
        {
            if (flag)
            {
                Object obj = new Like();
                obj.creator_display_handle = PMApplicationSession.GetPMSession().getDisplayHandle();
                obj.creator_id = PMApplicationSession.GetPMSession().getUserId();
                likes.add(obj);
                obj = aggregates;
                obj.likes = ((ListingAggregates) (obj)).likes + 1;
            } else
            {
                Iterator iterator = likes.iterator();
                while (iterator.hasNext()) 
                {
                    if (((Like)iterator.next()).creator_id.equals(PMApplicationSession.GetPMSession().getUserId()))
                    {
                        iterator.remove();
                        ListingAggregates listingaggregates = aggregates;
                        listingaggregates.likes = listingaggregates.likes - 1;
                    }
                }
            }
        }
    }
}
