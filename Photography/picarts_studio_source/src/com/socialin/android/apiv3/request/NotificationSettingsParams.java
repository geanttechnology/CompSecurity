// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.request;


// Referenced classes of package com.socialin.android.apiv3.request:
//            RequestParams

public class NotificationSettingsParams extends RequestParams
{

    public static final int DISABLED = 0;
    public static final int ENABLED = 1;
    public int comment;
    public int follow;
    public int followMe;
    public int like;
    public int likeMe;
    public int mention;
    public int publish;
    public int pushMe;
    public int repostMe;
    public int repostOther;
    public int suggestFb;
    public int suggestTwitter;

    public NotificationSettingsParams()
    {
        like = 1;
        likeMe = 1;
        repostMe = 1;
        repostOther = 1;
        comment = 1;
        mention = 1;
        publish = 1;
        suggestFb = 1;
        suggestTwitter = 1;
        follow = 1;
        followMe = 1;
        pushMe = 1;
    }

    public void setAll(int i)
    {
        like = i;
        likeMe = i;
        repostMe = i;
        repostOther = i;
        comment = i;
        mention = i;
        publish = i;
        suggestFb = i;
        suggestTwitter = i;
        follow = i;
        followMe = i;
        pushMe = i;
    }
}
