// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.symban;

import com.ebay.nautilus.domain.data.EbayCosDateTime;
import com.ebay.nautilus.domain.data.SymbanNotification;
import com.ebay.nautilus.domain.data.cos.base.Text;
import com.ebay.nautilus.domain.net.EbayCosResponse;
import com.ebay.nautilus.domain.net.dataobject.BaseApiResponse;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class SymbanReadResponse extends EbayCosResponse
{
    public static class Body extends BaseApiResponse
    {

        public int badgeCount;
        public EbayCosDateTime latestNotificationTime;
        public String next;
        public List notifications;
        public String prev;
        public int responseStatus;
        public int total;

        public Body()
        {
        }
    }

    public static class Body.PullNotification
        implements SymbanNotification
    {

        public CallToAction action;
        public String content;
        public EbayCosDateTime creationDate;
        public com.ebay.nautilus.domain.data.SymbanNotification.UiGroupEnum group;
        public EbayCosDateTime lastModificationDate;
        public com.ebay.nautilus.domain.data.SymbanNotification.MdnsNameEnum mdnsName;
        public String name;
        public String notificationId;
        public String notificationType;
        public String notificationUrl;
        public boolean popup;
        public Text shortTitle;
        public com.ebay.nautilus.domain.data.SymbanNotification.StatusEnum status;
        public NotificationSubject subject;
        public EbayCosDateTime subjectEventDate;
        public Text title;

        public com.ebay.nautilus.domain.data.SymbanNotification.ActionEnum getAction()
        {
            if (action == null)
            {
                return null;
            } else
            {
                return action.name;
            }
        }

        public String getContent()
        {
            return content;
        }

        public String getImageUrl()
        {
            return notificationUrl;
        }

        public String getListingId()
        {
            if (subject == null || subject.listing == null)
            {
                return null;
            } else
            {
                return subject.listing.listingId;
            }
        }

        public com.ebay.nautilus.domain.data.SymbanNotification.MdnsNameEnum getMdnsName()
        {
            return mdnsName;
        }

        public String getMessageId()
        {
            if (subject == null || subject.message == null)
            {
                return null;
            } else
            {
                return subject.message.messageId;
            }
        }

        public String getNotificationId()
        {
            return notificationId;
        }

        public Date getScheduledEndDate()
        {
            if (subject == null || subject.listing == null || subject.listing.scheduledEndDate == null)
            {
                return null;
            } else
            {
                return subject.listing.scheduledEndDate.getValue();
            }
        }

        public String getTitle()
        {
            if (shortTitle == null)
            {
                return null;
            } else
            {
                return shortTitle.content;
            }
        }

        public String getTransactionId()
        {
            if (subject == null || subject.listing == null)
            {
                return null;
            } else
            {
                return subject.listing.transactionId;
            }
        }

        public com.ebay.nautilus.domain.data.SymbanNotification.UiGroupEnum getUiGroup()
        {
            return group;
        }

        public boolean isNew()
        {
            return com.ebay.nautilus.domain.data.SymbanNotification.StatusEnum.NEW.equals(status);
        }

        public Body.PullNotification()
        {
        }
    }

    public static class Body.PullNotification.CallToAction
    {

        public com.ebay.nautilus.domain.data.SymbanNotification.ActionEnum name;
        public Text title;

        public Body.PullNotification.CallToAction()
        {
        }
    }

    public static class Body.PullNotification.NotificationSubject
    {

        public Listing listing;
        public Message message;

        public Body.PullNotification.NotificationSubject()
        {
        }
    }

    public static class Body.PullNotification.NotificationSubject.Listing
    {

        public String bestOfferId;
        public String listingId;
        public EbayCosDateTime scheduledEndDate;
        public String transactionId;

        public Body.PullNotification.NotificationSubject.Listing()
        {
        }
    }

    public static class Body.PullNotification.NotificationSubject.Message
    {

        public String messageId;

        public Body.PullNotification.NotificationSubject.Message()
        {
        }
    }


    Body body;

    protected SymbanReadResponse()
    {
        super(true);
        body = new Body();
    }

    public Body getBody()
    {
        return body;
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        body = (Body)readJsonStream(inputstream, com/ebay/nautilus/domain/net/symban/SymbanReadResponse$Body);
    }
}
