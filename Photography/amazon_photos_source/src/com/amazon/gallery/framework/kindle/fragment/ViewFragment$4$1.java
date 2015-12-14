// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.fragment;

import android.os.AsyncTask;
import com.amazon.gallery.framework.gallery.timeline.TimelineNavigator;

// Referenced classes of package com.amazon.gallery.framework.kindle.fragment:
//            ViewFragment

class this._cls1
    implements com.amazon.gallery.framework.gallery.timeline..TimelineClickListener
{

    final llToPosition this$1;

    public void onTimeNavBarClick(int i, int j)
    {
        scrollToPosition(j);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/amazon/gallery/framework/kindle/fragment/ViewFragment$4

/* anonymous class */
    class ViewFragment._cls4 extends AsyncTask
    {

        final ViewFragment this$0;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            timelineNavigator.init(timelinebar);
            timelineNavigator.setTimelineClickListener(new ViewFragment._cls4._cls1());
            return null;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
            timelineNavigator.enableTimelineBar();
        }

            
            {
                this$0 = ViewFragment.this;
                super();
            }
    }

}
