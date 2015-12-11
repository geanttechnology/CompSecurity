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
import com.urbanairship.richpush.RichPushMessage;

// Referenced classes of package com.urbanairship.actions:
//            OverlayRichPushMessageAction

class val.message
    implements Runnable
{

    final OverlayRichPushMessageAction this$0;
    final RichPushMessage val$message;

    public void run()
    {
        Intent intent = (new Intent("com.urbanairship.actions.SHOW_LANDING_PAGE_INTENT_ACTION")).setPackage(UAirship.getPackageName()).addFlags(0x30000000).setData(Uri.fromParts("message", val$message.getMessageId(), null));
        try
        {
            UAirship.getApplicationContext().startActivity(intent);
            return;
        }
        catch (ActivityNotFoundException activitynotfoundexception)
        {
            Logger.error("Unable to view the inbox message in a landing page. The landing page activity is either missing in the manifest or does not include the message scheme in its intent filter.");
        }
    }

    ()
    {
        this$0 = final_overlayrichpushmessageaction;
        val$message = RichPushMessage.this;
        super();
    }
}
