// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;

import android.app.Application;

// Referenced classes of package io.branch.referral:
//            BranchUtil, Branch

public class BranchApp extends Application
{

    public BranchApp()
    {
    }

    public void onCreate()
    {
        super.onCreate();
        if (!BranchUtil.isTestModeEnabled(this))
        {
            Branch.getInstance(this);
            return;
        } else
        {
            Branch.getTestInstance(this);
            return;
        }
    }
}
