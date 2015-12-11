// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.notifications;

import android.os.Handler;
import android.os.Message;
import com.poshmark.data_model.models.ListingDetails;
import com.poshmark.data_model.models.inner_models.Comment;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.poshmark.notifications:
//            ListingNotificationHandler

public class ListingNotificationManager
{
    public static final class MODE extends Enum
    {

        private static final MODE $VALUES[];
        public static final MODE LISTING_COMMENT_ADDED;
        public static final MODE LISTING_EDITED;
        public static final MODE LISTING_LIKED;

        public static MODE valueOf(String s)
        {
            return (MODE)Enum.valueOf(com/poshmark/notifications/ListingNotificationManager$MODE, s);
        }

        public static MODE[] values()
        {
            return (MODE[])$VALUES.clone();
        }

        static 
        {
            LISTING_EDITED = new MODE("LISTING_EDITED", 0);
            LISTING_LIKED = new MODE("LISTING_LIKED", 1);
            LISTING_COMMENT_ADDED = new MODE("LISTING_COMMENT_ADDED", 2);
            $VALUES = (new MODE[] {
                LISTING_EDITED, LISTING_LIKED, LISTING_COMMENT_ADDED
            });
        }

        private MODE(String s, int i)
        {
            super(s, i);
        }
    }


    static ListingNotificationManager listingNotificationManager = null;
    private int LISTING_COMMENT_ADDED;
    private int LISTING_EDITED;
    private int LISTING_LIKED;
    private Set handlerList;
    public Handler listingNotificationMsgHandler;

    public ListingNotificationManager()
    {
        handlerList = new HashSet();
        LISTING_EDITED = 0;
        LISTING_LIKED = 1;
        LISTING_COMMENT_ADDED = 2;
        listingNotificationMsgHandler = new Handler() {

            final ListingNotificationManager this$0;

            public void handleMessage(Message message)
            {
            }

            
            {
                this$0 = ListingNotificationManager.this;
                super();
            }
        };
    }

    public static ListingNotificationManager getListingNotificationManager()
    {
        if (listingNotificationManager == null)
        {
            listingNotificationManager = new ListingNotificationManager();
        }
        return listingNotificationManager;
    }

    private void launchAllCommentMessages(String s, Comment comment)
    {
        this;
        JVM INSTR monitorenter ;
        for (Iterator iterator = handlerList.iterator(); iterator.hasNext(); ((ListingNotificationHandler)iterator.next()).addCommentToListing(s, comment)) { }
        break MISSING_BLOCK_LABEL_45;
        s;
        throw s;
        this;
        JVM INSTR monitorexit ;
    }

    private void launchAllDeleteMessages(String s)
    {
        this;
        JVM INSTR monitorenter ;
        for (Iterator iterator = handlerList.iterator(); iterator.hasNext(); ((ListingNotificationHandler)iterator.next()).deleteListing(s)) { }
        break MISSING_BLOCK_LABEL_44;
        s;
        throw s;
        this;
        JVM INSTR monitorexit ;
    }

    private void launchAllEditMessages(ListingDetails listingdetails)
    {
        this;
        JVM INSTR monitorenter ;
        for (Iterator iterator = handlerList.iterator(); iterator.hasNext(); ((ListingNotificationHandler)iterator.next()).updateListing(listingdetails)) { }
        break MISSING_BLOCK_LABEL_44;
        listingdetails;
        throw listingdetails;
        this;
        JVM INSTR monitorexit ;
    }

    private void launchAllLikeMessages(String s, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        for (Iterator iterator = handlerList.iterator(); iterator.hasNext(); ((ListingNotificationHandler)iterator.next()).likeListing(s, flag)) { }
        break MISSING_BLOCK_LABEL_45;
        s;
        throw s;
        this;
        JVM INSTR monitorexit ;
    }

    private void launchAllNewListingCreatedMessages()
    {
        this;
        JVM INSTR monitorenter ;
        for (Iterator iterator = handlerList.iterator(); iterator.hasNext(); ((ListingNotificationHandler)iterator.next()).newListingCreated()) { }
        break MISSING_BLOCK_LABEL_43;
        Exception exception;
        exception;
        throw exception;
        this;
        JVM INSTR monitorexit ;
    }

    public void fireListingCommentMessage(String s, Comment comment)
    {
        this;
        JVM INSTR monitorenter ;
        launchAllCommentMessages(s, comment);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void fireListingDeletedMessage(String s)
    {
        this;
        JVM INSTR monitorenter ;
        launchAllDeleteMessages(s);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void fireListingEditedMessage(String s)
    {
        this;
        JVM INSTR monitorenter ;
        PMApi.getListingDetails(s, new PMApiResponseHandler() {

            final ListingNotificationManager this$0;

            public void handleResponse(PMApiResponse pmapiresponse)
            {
                if (!pmapiresponse.hasError())
                {
                    pmapiresponse = (ListingDetails)pmapiresponse.data;
                    launchAllEditMessages(pmapiresponse);
                    Message message = new Message();
                    message.obj = pmapiresponse;
                    message.what = 1;
                    listingNotificationMsgHandler.sendMessage(message);
                }
            }

            
            {
                this$0 = ListingNotificationManager.this;
                super();
            }
        });
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void fireListingLikedMessage(String s, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        launchAllLikeMessages(s, flag);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void fireNewListingCreatedMessage()
    {
        this;
        JVM INSTR monitorenter ;
        launchAllNewListingCreatedMessages();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void registerListingMessageHandler(ListingNotificationHandler listingnotificationhandler)
    {
        this;
        JVM INSTR monitorenter ;
        if (!handlerList.contains(listingnotificationhandler))
        {
            handlerList.add(listingnotificationhandler);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        listingnotificationhandler;
        throw listingnotificationhandler;
    }

    public void unregisterListingMessageHandler(ListingNotificationHandler listingnotificationhandler)
    {
        this;
        JVM INSTR monitorenter ;
        if (handlerList.contains(listingnotificationhandler))
        {
            handlerList.remove(listingnotificationhandler);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        listingnotificationhandler;
        throw listingnotificationhandler;
    }


}
