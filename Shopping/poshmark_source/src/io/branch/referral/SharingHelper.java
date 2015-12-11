// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;


public class SharingHelper
{
    public static final class SHARE_WITH extends Enum
    {

        private static final SHARE_WITH $VALUES[];
        public static final SHARE_WITH EMAIL;
        public static final SHARE_WITH FACEBOOK;
        public static final SHARE_WITH FLICKR;
        public static final SHARE_WITH GOOGLE_DOC;
        public static final SHARE_WITH MESSAGE;
        public static final SHARE_WITH TWITTER;
        public static final SHARE_WITH WHATS_APP;
        private String name;

        public static SHARE_WITH valueOf(String s)
        {
            return (SHARE_WITH)Enum.valueOf(io/branch/referral/SharingHelper$SHARE_WITH, s);
        }

        public static SHARE_WITH[] values()
        {
            return (SHARE_WITH[])$VALUES.clone();
        }

        public String getAppName()
        {
            return name;
        }

        public String toString()
        {
            return name;
        }

        static 
        {
            FACEBOOK = new SHARE_WITH("FACEBOOK", 0, "com.facebook.katana");
            TWITTER = new SHARE_WITH("TWITTER", 1, "com.twitter.android");
            MESSAGE = new SHARE_WITH("MESSAGE", 2, ".mms");
            EMAIL = new SHARE_WITH("EMAIL", 3, "com.google.android.email");
            FLICKR = new SHARE_WITH("FLICKR", 4, "com.yahoo.mobile.client.android.flickr");
            GOOGLE_DOC = new SHARE_WITH("GOOGLE_DOC", 5, "com.google.android.apps.docs");
            WHATS_APP = new SHARE_WITH("WHATS_APP", 6, "com.whatsapp");
            $VALUES = (new SHARE_WITH[] {
                FACEBOOK, TWITTER, MESSAGE, EMAIL, FLICKR, GOOGLE_DOC, WHATS_APP
            });
        }

        private SHARE_WITH(String s, int i, String s1)
        {
            super(s, i);
            name = "";
            name = s1;
        }
    }


    public SharingHelper()
    {
    }
}
