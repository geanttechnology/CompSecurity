// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models;


public class ActiveUserInfo
{
    class DeepLinkInfo
    {

        public String deep_link;
        String source_app;
        final ActiveUserInfo this$0;

        public DeepLinkInfo(String s)
        {
            this$0 = ActiveUserInfo.this;
            super();
            deep_link = new String();
            deep_link = s;
        }
    }

    public class LocalNotificationInfo
    {

        String oi;
        String ot;
        final ActiveUserInfo this$0;
        String vb;

        LocalNotificationInfo(String s)
        {
            this$0 = ActiveUserInfo.this;
            super();
            vb = "rm";
            oi = new String();
            ot = "ev";
            oi = s;
        }
    }

    public class PushNotificationInfo
    {

        PushPayload aps;
        final ActiveUserInfo this$0;
        String type;

        PushNotificationInfo(String s, String s1, String s2)
        {
            this$0 = ActiveUserInfo.this;
            super();
            aps = new PushPayload();
            if (s != null)
            {
                aps.alert = s;
            }
            if (s1 != null)
            {
                aps.badge = Integer.parseInt(s1);
            }
            if (s2 != null)
            {
                type = s2;
            }
        }
    }

    class PushNotificationInfo.PushPayload
    {

        String alert;
        int badge;
        final PushNotificationInfo this$1;
        String type;

        PushNotificationInfo.PushPayload()
        {
            this$1 = PushNotificationInfo.this;
            super();
        }
    }


    public DeepLinkInfo deep_link;
    public LocalNotificationInfo local_ntf;
    public PushNotificationInfo push_ntf;
    public String type;

    public ActiveUserInfo()
    {
        type = new String();
    }

    public void addDeepLink(String s)
    {
        deep_link = new DeepLinkInfo(s);
    }

    public void addLocalNotification(String s)
    {
        local_ntf = new LocalNotificationInfo(s);
    }

    public void addPushNotification(String s, String s1, String s2)
    {
        push_ntf = new PushNotificationInfo(s, s1, s2);
    }
}
