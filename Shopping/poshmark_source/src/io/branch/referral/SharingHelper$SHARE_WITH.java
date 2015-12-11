// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;


// Referenced classes of package io.branch.referral:
//            SharingHelper

public static final class name extends Enum
{

    private static final WHATS_APP $VALUES[];
    public static final WHATS_APP EMAIL;
    public static final WHATS_APP FACEBOOK;
    public static final WHATS_APP FLICKR;
    public static final WHATS_APP GOOGLE_DOC;
    public static final WHATS_APP MESSAGE;
    public static final WHATS_APP TWITTER;
    public static final WHATS_APP WHATS_APP;
    private String name;

    public static name valueOf(String s)
    {
        return (name)Enum.valueOf(io/branch/referral/SharingHelper$SHARE_WITH, s);
    }

    public static name[] values()
    {
        return (name[])$VALUES.clone();
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
        FACEBOOK = new <init>("FACEBOOK", 0, "com.facebook.katana");
        TWITTER = new <init>("TWITTER", 1, "com.twitter.android");
        MESSAGE = new <init>("MESSAGE", 2, ".mms");
        EMAIL = new <init>("EMAIL", 3, "com.google.android.email");
        FLICKR = new <init>("FLICKR", 4, "com.yahoo.mobile.client.android.flickr");
        GOOGLE_DOC = new <init>("GOOGLE_DOC", 5, "com.google.android.apps.docs");
        WHATS_APP = new <init>("WHATS_APP", 6, "com.whatsapp");
        $VALUES = (new .VALUES[] {
            FACEBOOK, TWITTER, MESSAGE, EMAIL, FLICKR, GOOGLE_DOC, WHATS_APP
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        name = "";
        name = s1;
    }
}
