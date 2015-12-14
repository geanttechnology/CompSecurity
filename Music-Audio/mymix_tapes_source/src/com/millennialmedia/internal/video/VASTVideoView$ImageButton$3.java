// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.video;

import com.millennialmedia.internal.utils.HttpUtils;
import com.millennialmedia.internal.utils.Utils;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.millennialmedia.internal.video:
//            VASTVideoView

class val.buttonClicks
    implements Runnable
{

    final equest this$1;
    final equest val$buttonClicks;

    public void run()
    {
        Iterator iterator = val$buttonClicks.kTrackingUrls.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)iterator.next();
            if (!Utils.isEmpty(s))
            {
                HttpUtils.getContentFromGetRequest(s);
            }
        } while (true);
    }

    ()
    {
        this$1 = final_;
        val$buttonClicks = val.buttonClicks.this;
        super();
    }
}
