// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.netflix.mediaclient.service.resfetcher.volley;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

// Referenced classes of package com.netflix.mediaclient.service.resfetcher.volley:
//            ImageLoader

class this._cls0
    implements Runnable
{

    final ImageLoader this$0;

    public void run()
    {
        for (Iterator iterator = ImageLoader.access$700(ImageLoader.this).values().iterator(); iterator.hasNext();)
        {
            tchedImageRequest tchedimagerequest = (tchedImageRequest)iterator.next();
            Iterator iterator1 = tchedImageRequest.access._mth800(tchedimagerequest).iterator();
            while (iterator1.hasNext()) 
            {
                ageContainer agecontainer = (ageContainer)iterator1.next();
                if (ageContainer.access._mth900(agecontainer) != null)
                {
                    if (tchedimagerequest.getError() == null)
                    {
                        ageContainer.access._mth1002(agecontainer, tchedImageRequest.access._mth600(tchedimagerequest));
                        ageContainer.access._mth900(agecontainer).onResponse(agecontainer, false);
                    } else
                    {
                        ageContainer.access._mth900(agecontainer).onErrorResponse(tchedimagerequest.getError());
                    }
                }
            }
        }

        ImageLoader.access$700(ImageLoader.this).clear();
        ImageLoader.access$1102(ImageLoader.this, null);
    }

    ageListener()
    {
        this$0 = ImageLoader.this;
        super();
    }
}
