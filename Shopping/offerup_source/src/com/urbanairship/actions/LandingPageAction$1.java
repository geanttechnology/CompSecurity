// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.actions;

import android.net.Uri;
import com.urbanairship.Logger;
import com.urbanairship.UAirship;
import com.urbanairship.richpush.RichPushInbox;
import com.urbanairship.richpush.RichPushManager;
import com.urbanairship.widget.UAWebView;

// Referenced classes of package com.urbanairship.actions:
//            LandingPageAction

class val.uri
    implements Runnable
{

    final LandingPageAction this$0;
    final Uri val$uri;

    public void run()
    {
        UAWebView uawebview = new UAWebView(UAirship.getApplicationContext());
        if (val$uri.getScheme().equalsIgnoreCase("message"))
        {
            String s = val$uri.getSchemeSpecificPart();
            com.urbanairship.richpush.RichPushMessage richpushmessage = UAirship.shared().getRichPushManager().getRichPushInbox().getMessage(s);
            if (richpushmessage != null)
            {
                uawebview.loadRichPushMessage(richpushmessage);
                return;
            } else
            {
                Logger.debug((new StringBuilder("LandingPageAction - Message ")).append(s).append(" not found.").toString());
                return;
            }
        } else
        {
            uawebview.loadUrl(val$uri.toString());
            return;
        }
    }

    ()
    {
        this$0 = final_landingpageaction;
        val$uri = Uri.this;
        super();
    }
}
