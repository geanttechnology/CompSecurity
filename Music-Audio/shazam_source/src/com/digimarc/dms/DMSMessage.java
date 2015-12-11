// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms;


// Referenced classes of package com.digimarc.dms:
//            DMSPayload

public class DMSMessage
{

    private String mMessageOrigin;
    private DMSPayload mPayload;
    private int mStatus;

    public DMSMessage(DMSPayload dmspayload, String s, int i)
    {
        mStatus = 0;
        mPayload = dmspayload;
        mMessageOrigin = s;
        mStatus = i;
    }

    public String getMessageOrigin()
    {
        return mMessageOrigin;
    }

    public DMSPayload getPayload()
    {
        return mPayload;
    }

    public int getStatus()
    {
        return mStatus;
    }
}
