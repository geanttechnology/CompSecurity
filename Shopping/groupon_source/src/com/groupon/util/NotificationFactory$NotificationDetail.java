// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.graphics.Bitmap;
import com.groupon.db.models.DealSummary;

// Referenced classes of package com.groupon.util:
//            NotificationFactory

public static class notificationType
{
    public static final class NotificationType extends Enum
    {

        private static final NotificationType $VALUES[];
        public static final NotificationType CLIENT_PULL;
        public static final NotificationType PROXIMITY;
        public static final NotificationType SERVER_PUSH;
        private String notificationTypeString;

        public static NotificationType valueOf(String s)
        {
            return (NotificationType)Enum.valueOf(com/groupon/util/NotificationFactory$NotificationDetail$NotificationType, s);
        }

        public static NotificationType[] values()
        {
            return (NotificationType[])$VALUES.clone();
        }

        static 
        {
            CLIENT_PULL = new NotificationType("CLIENT_PULL", 0, "{\"pushType\" : \"pull\"}");
            SERVER_PUSH = new NotificationType("SERVER_PUSH", 1, "{\"pushType\" : \"GCM\"}");
            PROXIMITY = new NotificationType("PROXIMITY", 2, "{\"pushType\" : \"proximity\"}");
            $VALUES = (new NotificationType[] {
                CLIENT_PULL, SERVER_PUSH, PROXIMITY
            });
        }


        private NotificationType(String s, int i, String s1)
        {
            super(s, i);
            notificationTypeString = s1;
        }
    }


    public String alertTitle;
    public DealSummary dealSummary;
    public Bitmap image;
    public String imageUrl;
    public boolean isDealNotification;
    public String link;
    public String nid;
    public NotificationType notificationType;
    public String price;
    public String purchaseLink;
    public String value;

    public NotificationType(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            boolean flag, NotificationType notificationtype)
    {
        alertTitle = s;
        nid = s1;
        link = s2;
        purchaseLink = s3;
        imageUrl = s4;
        price = s5;
        value = s6;
        isDealNotification = flag;
        notificationType = notificationtype;
    }

    public NotificationType(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            boolean flag, NotificationType notificationtype, DealSummary dealsummary)
    {
        alertTitle = s;
        nid = s1;
        link = s2;
        purchaseLink = s3;
        imageUrl = s4;
        price = s5;
        value = s6;
        dealSummary = dealsummary;
        isDealNotification = flag;
        notificationType = notificationtype;
    }
}
