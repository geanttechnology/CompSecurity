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

class val.title
    implements com.comcast.cim.android.image.ener
{

    final TabletFeaturedFragment this$0;
    final MerlinId val$parentMerlinId;
    final String val$title;

    public void onLoad(ImageView imageview, String s, Bitmap bitmap)
    {
    }

    public void onLoadError(ImageView imageview, String s)
    {
        TabletFeaturedFragment.access$200().warn("Couldn't load program art for last watched, show the title", val$parentMerlinId);
        if (val$title != null && !val$title.isEmpty())
        {
            TabletFeaturedFragment.access$300(TabletFeaturedFragment.this, val$title);
            return;
        } else
        {
            programListener = programProvider.execute(new DefaultTaskExecutionListener() {

                final TabletFeaturedFragment._cls2 this$1;

                public void onError(TaskExecutionException taskexecutionexception)
                {
                    TabletFeaturedFragment.access$200().error("Couldn't get title for last watched", taskexecutionexception);
                }

                public void onPostExecute(DibicResource dibicresource)
                {
                    dibicresource = dibicresource.getProgramByMerlinId(parentMerlinId);
                    TabletFeaturedFragment.access$300(this$0, dibicresource.getTitle());
                }

                public volatile void onPostExecute(Object obj)
                {
                    onPostExecute((DibicResource)obj);
                }

            
            {
                this$1 = TabletFeaturedFragment._cls2.this;
                super();
            }
            });
            return;
        }
    }

    ionListener()
    {
        this$0 = final_tabletfeaturedfragment;
        val$parentMerlinId = merlinid;
        val$title = String.this;
        super();
    }
}
