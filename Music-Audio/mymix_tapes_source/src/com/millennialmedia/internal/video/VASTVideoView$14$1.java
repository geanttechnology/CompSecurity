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

class this._cls1
    implements Runnable
{

    final tFromGetRequest this$1;

    public void run()
    {
        for (Iterator iterator = VASTVideoView.access$2300(_fld0).iterator(); iterator.hasNext();)
        {
            Iterator iterator2 = ((cks)iterator.next()).clickTrackingUrls.iterator();
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

    cks()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/millennialmedia/internal/video/VASTVideoView$14

/* anonymous class */
    class VASTVideoView._cls14
        implements android.view.View.OnClickListener
    {

        final VASTVideoView this$0;
        final VASTParser.VideoClicks val$videoClicks;

        public void onClick(final View fireClickTrackers)
        {
            VASTVideoView.access$100(VASTVideoView.this);
            fireClickTrackers = new VASTVideoView._cls14._cls1();
            if (!Utils.isEmpty(videoClicks.clickThrough))
            {
                Utils.startActivityFromUrl(videoClicks.clickThrough);
                ThreadUtils.runOnWorkerThread(fireClickTrackers);
                return;
            } else
            {
                ThreadUtils.runOnWorkerThread(new VASTVideoView._cls14._cls2());
                return;
            }
        }

            
            {
                this$0 = final_vastvideoview;
                videoClicks = VASTParser.VideoClicks.this;
                super();
            }

        // Unreferenced inner class com/millennialmedia/internal/video/VASTVideoView$14$2

/* anonymous class */
        class VASTVideoView._cls14._cls2
            implements Runnable
        {

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
        }

    }

}
