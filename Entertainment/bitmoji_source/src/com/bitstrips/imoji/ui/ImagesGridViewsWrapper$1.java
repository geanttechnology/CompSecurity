// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import com.bitstrips.imoji.manager.TemplatesManager;
import com.bitstrips.imoji.models.Imoji;
import com.bitstrips.imoji.ui.tasks.GetImojiImageTask;
import com.bitstrips.imoji.ui.views.ImojiWithBadgeView;
import java.io.File;

// Referenced classes of package com.bitstrips.imoji.ui:
//            ImagesGridViewsWrapper, ImageLoader

class val.gridView
    implements android.widget.stener
{

    final ImagesGridViewsWrapper this$0;
    final Activity val$activity;
    final GridView val$gridView;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        (new GetImojiImageTask(val$activity, imageLoader, templatesManager) {

            final ImagesGridViewsWrapper._cls1 this$1;

            protected void onPostExecute(File file)
            {
                ((ImagesGridViewsWrapper.ImojiClickListener)activity).onClick(file, imoji, gridView.getId());
            }

            protected volatile void onPostExecute(Object obj)
            {
                onPostExecute((File)obj);
            }

            
            {
                this$1 = ImagesGridViewsWrapper._cls1.this;
                super(activity1, imageloader, templatesmanager);
            }
        }).execute(new Imoji[] {
            ((ImojiWithBadgeView)view).getImoji()
        });
    }

    init>()
    {
        this$0 = final_imagesgridviewswrapper;
        val$activity = activity1;
        val$gridView = GridView.this;
        super();
    }
}
