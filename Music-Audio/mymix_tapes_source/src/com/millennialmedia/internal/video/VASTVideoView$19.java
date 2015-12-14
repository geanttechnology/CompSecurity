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

class this._cls0
    implements Runnable
{

    final VASTVideoView this$0;

    public void run()
    {
        if (VASTVideoView.access$2600(VASTVideoView.this) != null && !Utils.isEmpty(VASTVideoView.access$2600(VASTVideoView.this).error))
        {
            HttpUtils.getContentFromGetRequest(VASTVideoView.access$2600(VASTVideoView.this).error);
        }
        if (VASTVideoView.access$2700(VASTVideoView.this) != null)
        {
            Iterator iterator = VASTVideoView.access$2700(VASTVideoView.this).iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                rAd rad = (rAd)iterator.next();
                if (!Utils.isEmpty(rad.error))
                {
                    HttpUtils.getContentFromGetRequest(rad.error);
                }
            } while (true);
        }
    }

    rAd()
    {
        this$0 = VASTVideoView.this;
        super();
    }
}
