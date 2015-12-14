// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.video;

import com.millennialmedia.MMLog;
import com.millennialmedia.internal.utils.HttpUtils;
import com.millennialmedia.internal.utils.Utils;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.millennialmedia.internal.video:
//            VASTVideoView

class this._cls0
    implements Runnable
{

    final VASTVideoView this$0;

    public void run()
    {
        Iterator iterator = VASTVideoView.access$2600(VASTVideoView.this).impressions.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)iterator.next();
            if (!Utils.isEmpty(s))
            {
                if (MMLog.isDebugEnabled())
                {
                    MMLog.d(VASTVideoView.access$1600(), (new StringBuilder()).append("Firing impression url = ").append(s).toString());
                }
                HttpUtils.getContentFromGetRequest(s);
            }
        } while (true);
        if (VASTVideoView.access$2700(VASTVideoView.this) != null)
        {
            for (Iterator iterator1 = VASTVideoView.access$2700(VASTVideoView.this).iterator(); iterator1.hasNext();)
            {
                Object obj = (rAd)iterator1.next();
                if (((rAd) (obj)).impressions != null)
                {
                    obj = ((rAd) (obj)).impressions.iterator();
                    while (((Iterator) (obj)).hasNext()) 
                    {
                        String s1 = (String)((Iterator) (obj)).next();
                        if (!Utils.isEmpty(s1))
                        {
                            if (MMLog.isDebugEnabled())
                            {
                                MMLog.d(VASTVideoView.access$1600(), (new StringBuilder()).append("Firing wrapper impression url = ").append(s1).toString());
                            }
                            HttpUtils.getContentFromGetRequest(s1);
                        }
                    }
                }
            }

        }
    }

    rAd()
    {
        this$0 = VASTVideoView.this;
        super();
    }
}
