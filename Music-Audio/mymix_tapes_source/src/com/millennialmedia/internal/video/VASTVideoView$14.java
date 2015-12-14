// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.video;

import android.view.View;
import com.millennialmedia.MMLog;
import com.millennialmedia.internal.utils.HttpUtils;
import com.millennialmedia.internal.utils.ThreadUtils;
import com.millennialmedia.internal.utils.Utils;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.millennialmedia.internal.video:
//            VASTVideoView

class licks
    implements android.view.ner
{

    final VASTVideoView this$0;
    final licks val$videoClicks;

    public void onClick(final View fireClickTrackers)
    {
        VASTVideoView.access$100(VASTVideoView.this);
        fireClickTrackers = new Runnable() {

            final VASTVideoView._cls14 this$1;

            public void run()
            {
                for (Iterator iterator = VASTVideoView.access$2300(this$0).iterator(); iterator.hasNext();)
                {
                    Iterator iterator2 = ((VASTParser.VideoClicks)iterator.next()).clickTrackingUrls.iterator();
                    while (iterator2.hasNext()) 
                    {
                        String s1 = (String)iterator2.next();
                        if (!Utils.isEmpty(s1))
                        {
                            if (MMLog.isDebugEnabled())
                            {
                                MMLog.d(VASTVideoView.access$1600(), (new StringBuilder()).append("Firing wrapper video click tracker url = ").append(s1).toString());
                            }
                            HttpUtils.getContentFromGetRequest(s1);
                        }
                    }
                }

                Iterator iterator1 = videoClicks.clickTrackingUrls.iterator();
                do
                {
                    if (!iterator1.hasNext())
                    {
                        break;
                    }
                    String s = (String)iterator1.next();
                    if (!Utils.isEmpty(s))
                    {
                        if (MMLog.isDebugEnabled())
                        {
                            MMLog.d(VASTVideoView.access$1600(), (new StringBuilder()).append("Firing video click tracker url = ").append(s).toString());
                        }
                        HttpUtils.getContentFromGetRequest(s);
                    }
                } while (true);
            }

            
            {
                this$1 = VASTVideoView._cls14.this;
                super();
            }
        };
        if (!Utils.isEmpty(val$videoClicks.clickThrough))
        {
            Utils.startActivityFromUrl(val$videoClicks.clickThrough);
            ThreadUtils.runOnWorkerThread(fireClickTrackers);
            return;
        } else
        {
            ThreadUtils.runOnWorkerThread(new Runnable() {

                final VASTVideoView._cls14 this$1;
                final Runnable val$fireClickTrackers;

                public void run()
                {
                    Iterator iterator = videoClicks.customClickUrls.iterator();
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
                    fireClickTrackers.run();
                }

            
            {
                this$1 = VASTVideoView._cls14.this;
                fireClickTrackers = runnable;
                super();
            }
            });
            return;
        }
    }

    licks()
    {
        this$0 = final_vastvideoview;
        val$videoClicks = licks.this;
        super();
    }
}
