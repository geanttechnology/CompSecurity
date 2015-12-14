// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.adcontrollers;

import com.millennialmedia.internal.utils.HttpUtils;
import com.millennialmedia.internal.utils.Utils;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.millennialmedia.internal.adcontrollers:
//            VASTVideoController

class this._cls0
    implements Runnable
{

    final VASTVideoController this$0;

    public void run()
    {
        if (VASTVideoController.access$100(VASTVideoController.this) != null && !Utils.isEmpty(VASTVideoController.access$100(VASTVideoController.this).ror))
        {
            HttpUtils.getContentFromGetRequest(VASTVideoController.access$100(VASTVideoController.this).ror);
        }
        if (VASTVideoController.access$400(VASTVideoController.this) != null)
        {
            Iterator iterator = VASTVideoController.access$400(VASTVideoController.this).iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                com.millennialmedia.internal.video.oller oller = (com.millennialmedia.internal.video.oller)iterator.next();
                if (!Utils.isEmpty(oller.rror))
                {
                    HttpUtils.getContentFromGetRequest(oller.rror);
                }
            } while (true);
        }
    }

    ()
    {
        this$0 = VASTVideoController.this;
        super();
    }
}
