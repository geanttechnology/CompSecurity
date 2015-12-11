// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.concurrent.Future;

public class dae extends dag
{

    private static final int TIMEOUT_MS = 5000;
    private final Future mMobileUserInfoFuture;
    private final String mRequestId;
    private final ewq mS3AudioInfo;
    private final Future mS3ClientInfoFuture;
    private final Future mS3UserInfoFuture;
    private final String mService;
    public final dai mTimeoutEnforcer = new dai(5000L);

    public dae(Future future, Future future1, Future future2, ewq ewq, String s, String s1)
    {
        mMobileUserInfoFuture = future;
        mS3ClientInfoFuture = future1;
        mS3UserInfoFuture = future2;
        mS3AudioInfo = ewq;
        mRequestId = s;
        mService = s1;
    }

    public exe produceRequest()
    {
        exe exe1 = a.E().a(mService);
        if (mMobileUserInfoFuture != null)
        {
            exe1.a((ews)mTimeoutEnforcer.a(mMobileUserInfoFuture));
        }
        if (mS3AudioInfo != null)
        {
            exe1.a(mS3AudioInfo);
        }
        if (mS3UserInfoFuture != null)
        {
            exe1.a((exh)mTimeoutEnforcer.a(mS3UserInfoFuture));
        }
        exe1.a((new exg()).a(mRequestId));
        exe1.a((exa)mTimeoutEnforcer.a(mS3ClientInfoFuture));
        return exe1;
    }
}
