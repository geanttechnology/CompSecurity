// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.vlc.service;

import android.content.Context;
import com.acuitybrands.abbytelight.AblAngle;
import com.acuitybrands.abbytelight.AblCore;
import com.acuitybrands.abbytelight.AblError;
import com.acuitybrands.abbytelight.AblEventListener;
import com.acuitybrands.abbytelight.AblException;
import com.acuitybrands.abbytelight.AblLocation;
import com.target.ui.vlc.c;
import com.target.ui.vlc.model.VlcPositionInfo;

// Referenced classes of package com.target.ui.vlc.service:
//            b

class a extends b
    implements AblEventListener
{

    private static final String ACUITY_BASE_URL = "https://target-bls-framework.bytelightservices.com";
    private AblCore mAblCore;
    private boolean mEnabled;

    public a(String s, c c1, com.target.ui.vlc.model.a a1, Context context)
    {
        super(s, c1);
        try
        {
            mAblCore = new AblCore(context, this, s, "BAFFE17A-A1D6-4064-9630-3CFB4E5D1EF2", "https://target-bls-framework.bytelightservices.com");
            mSiteInfo = a1;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            mVlcListener.r();
        }
    }

    public void a()
    {
        if (mAblCore != null)
        {
            mAblCore.disable();
            mEnabled = false;
        }
    }

    public void a(com.target.ui.vlc.model.a a1)
    {
        if (mAblCore != null && !mEnabled)
        {
            mAblCore.enable(a1.a(), a1.b());
        }
    }

    public void b()
    {
        if (mAblCore != null)
        {
            mAblCore.terminate();
        }
    }

    public void onAblError(AblError ablerror)
    {
        mVlcListener.p();
    }

    public void onAblPositionUpdate(AblLocation abllocation, AblAngle ablangle)
    {
        if (abllocation == null)
        {
            return;
        }
        float f = 0.0F;
        if (ablangle != null)
        {
            f = ablangle.getAngleInDegrees();
        }
        abllocation = new VlcPositionInfo(abllocation.getX(), abllocation.getY(), abllocation.getZ(), f, abllocation.getAccuracy(), abllocation.getTimestamp(), mSiteInfo.b());
        mVlcListener.a(abllocation);
    }

    public void onAblSiteEnabled(String s, String s1, boolean flag)
    {
        mEnabled = true;
        mVlcListener.q();
    }
}
