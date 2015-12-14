// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.dropbox.client2.android;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.util.Log;

// Referenced classes of package com.dropbox.client2.android:
//            AuthActivity

final class b
    implements Runnable
{

    private Intent a;
    private String b;
    private AuthActivity c;

    public final void run()
    {
        AuthActivity.a();
        if (!AuthActivity.a(c, a)) goto _L2; else goto _L1
_L1:
        c.startActivity(a);
_L4:
        AuthActivity.b(c, b);
        return;
_L2:
        try
        {
            AuthActivity.a(c, b);
        }
        catch (ActivityNotFoundException activitynotfoundexception)
        {
            Log.e(AuthActivity.a(), "Could not launch intent. User may have restricted profile", activitynotfoundexception);
            c.finish();
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    (AuthActivity authactivity, Intent intent, String s)
    {
        c = authactivity;
        a = intent;
        b = s;
        super();
    }
}
