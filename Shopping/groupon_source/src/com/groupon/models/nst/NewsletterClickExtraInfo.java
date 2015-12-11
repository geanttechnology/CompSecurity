// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.nst;


// Referenced classes of package com.groupon.models.nst:
//            JsonEncodedNSTField

public class NewsletterClickExtraInfo extends JsonEncodedNSTField
{

    public static final String NEWSLETTER_SUBSCRIBE = "newsletter";
    public static final String OPT_IN = "opt-in";
    public static final String OPT_OUT = "opt-out";
    public String subscribe;
    public String subscription;

    public NewsletterClickExtraInfo(String s, String s1)
    {
        subscribe = s;
        subscription = s1;
    }
}
