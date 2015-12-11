// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.actions;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.urbanairship.Logger;
import com.urbanairship.UAirship;

// Referenced classes of package com.urbanairship.actions:
//            LandingPageAction

class val.uri
    implements Runnable
{

    final LandingPageAction this$0;
    final Intent val$actionIntent;
    final Uri val$uri;

    public void run()
    {
        try
        {
            UAirship.getApplicationContext().startActivity(val$actionIntent);
            return;
        }
        catch (ActivityNotFoundException activitynotfoundexception)
        {
            Logger.error((new StringBuilder("Unable to view a landing page for uri ")).append(val$uri).append(". The landing page'sintent filter is missing the scheme: ").append(val$uri.getScheme()).toString());
        }
    }

    ()
    {
        this$0 = final_landingpageaction;
        val$actionIntent = intent;
        val$uri = Uri.this;
        super();
    }
}
