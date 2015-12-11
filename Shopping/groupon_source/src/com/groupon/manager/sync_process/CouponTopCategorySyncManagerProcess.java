// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager.sync_process;

import android.content.Context;
import android.content.res.Resources;
import com.groupon.manager.UniversalInfo;

// Referenced classes of package com.groupon.manager.sync_process:
//            CouponCategorySyncManagerProcess

public class CouponTopCategorySyncManagerProcess extends CouponCategorySyncManagerProcess
{

    protected final int PHONE_LIMIT = 6;
    protected final int TABLET_LIMIT = 9;
    protected boolean isThrowingErrorOnException;

    public CouponTopCategorySyncManagerProcess(Context context, String s, boolean flag)
    {
        super(context, s);
        isThrowingErrorOnException = flag;
    }

    public Object[] getSyncQueryParams(UniversalInfo universalinfo)
    {
        byte byte0;
        if (context.getResources().getBoolean(0x7f090007))
        {
            byte0 = 6;
        } else
        {
            byte0 = 9;
        }
        return (new Object[] {
            "limit", Integer.valueOf(byte0), "view", "android"
        });
    }

    public String getSyncUrl(UniversalInfo universalinfo)
    {
        return "https:/freebies/categories/top";
    }

    public boolean isThrowingErrorOnException()
    {
        return isThrowingErrorOnException;
    }
}
