// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.ftue;

import android.widget.ImageView;
import com.amazon.gallery.framework.network.util.EndpointLoadedEvent;

// Referenced classes of package com.amazon.gallery.thor.ftue:
//            WelcomeScreen

class pointLoadedEvent
    implements Runnable
{

    final WelcomeScreen this$0;
    final EndpointLoadedEvent val$endpointLoaded;

    public void run()
    {
        WelcomeScreen.access$1000(WelcomeScreen.this).setImageResource(WelcomeScreen.access$900(WelcomeScreen.this, val$endpointLoaded.endpoint));
    }

    pointLoadedEvent()
    {
        this$0 = final_welcomescreen;
        val$endpointLoaded = EndpointLoadedEvent.this;
        super();
    }
}
