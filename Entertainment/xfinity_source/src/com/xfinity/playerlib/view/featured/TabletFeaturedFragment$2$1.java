// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.featured;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.comcast.cim.cmasl.taskexecutor.exceptions.TaskExecutionException;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutor;
import com.comcast.cim.cmasl.taskexecutor.listener.DefaultTaskExecutionListener;
import com.xfinity.playerlib.model.MerlinId;
import com.xfinity.playerlib.model.dibic.DibicProgram;
import com.xfinity.playerlib.model.dibic.DibicResource;
import org.slf4j.Logger;

// Referenced classes of package com.xfinity.playerlib.view.featured:
//            TabletFeaturedFragment

class nListener extends DefaultTaskExecutionListener
{

    final onPostExecute this$1;

    public void onError(TaskExecutionException taskexecutionexception)
    {
        TabletFeaturedFragment.access$200().error("Couldn't get title for last watched", taskexecutionexception);
    }

    public void onPostExecute(DibicResource dibicresource)
    {
        dibicresource = dibicresource.getProgramByMerlinId(parentMerlinId);
        TabletFeaturedFragment.access$300(_fld0, dibicresource.getTitle());
    }

    public volatile void onPostExecute(Object obj)
    {
        onPostExecute((DibicResource)obj);
    }

    l.title()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/xfinity/playerlib/view/featured/TabletFeaturedFragment$2

/* anonymous class */
    class TabletFeaturedFragment._cls2
        implements com.comcast.cim.android.image.CimImageLoader.OnLoadListener
    {

        final TabletFeaturedFragment this$0;
        final MerlinId val$parentMerlinId;
        final String val$title;

        public void onLoad(ImageView imageview, String s, Bitmap bitmap)
        {
        }

        public void onLoadError(ImageView imageview, String s)
        {
            TabletFeaturedFragment.access$200().warn("Couldn't load program art for last watched, show the title", parentMerlinId);
            if (title != null && !title.isEmpty())
            {
                TabletFeaturedFragment.access$300(TabletFeaturedFragment.this, title);
                return;
            } else
            {
                programListener = programProvider.execute(new TabletFeaturedFragment._cls2._cls1());
                return;
            }
        }

            
            {
                this$0 = final_tabletfeaturedfragment;
                parentMerlinId = merlinid;
                title = String.this;
                super();
            }
    }

}
