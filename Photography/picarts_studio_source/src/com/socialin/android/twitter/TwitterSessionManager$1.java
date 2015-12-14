// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.twitter;

import android.content.Context;
import android.content.SharedPreferences;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.util.s;
import java.util.Date;
import myobfuscated.cy.a;

// Referenced classes of package com.socialin.android.twitter:
//            TwitterSessionManager

final class a
    implements Runnable
{

    private Context a;

    public final void run()
    {
        if (TwitterSessionManager.access$000() == null)
        {
            SharedPreferences _tmp = TwitterSessionManager.access$002(a.getSharedPreferences("TwitterPrefs", 0));
        }
        if (TwitterSessionManager.access$100())
        {
            TwitterSessionManager.access$200(a);
            if (TwitterSessionManager.isValidTwitterInstance() && s.a(a))
            {
                myobfuscated.cy.a.a(a).edit().putLong("twitter.anal.date", (new Date()).getTime()).apply();
                AnalyticUtils.getInstance(a).trackDeviceContactInfo("twitter", TwitterSessionManager.getAuthFriendIds());
            }
        }
    }

    (Context context)
    {
        a = context;
        super();
    }
}
