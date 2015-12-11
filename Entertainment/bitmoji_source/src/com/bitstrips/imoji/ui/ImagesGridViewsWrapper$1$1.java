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
//            ImageLoader, ImagesGridViewsWrapper

class it> extends GetImojiImageTask
{

    final onPostExecute this$1;

    protected void onPostExecute(File file)
    {
        ((iClickListener)activity).onClick(file, imoji, gridView.getId());
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((File)obj);
    }

    l.gridView(Activity activity, ImageLoader imageloader, TemplatesManager templatesmanager)
    {
        this$1 = this._cls1.this;
        super(activity, imageloader, templatesmanager);
    }

    // Unreferenced inner class com/bitstrips/imoji/ui/ImagesGridViewsWrapper$1

/* anonymous class */
    class ImagesGridViewsWrapper._cls1
        implements android.widget.AdapterView.OnItemClickListener
    {

        final ImagesGridViewsWrapper this$0;
        final Activity val$activity;
        final GridView val$gridView;

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            (new ImagesGridViewsWrapper._cls1._cls1(activity, imageLoader, templatesManager)).execute(new Imoji[] {
                ((ImojiWithBadgeView)view).getImoji()
            });
        }

            
            {
                this$0 = final_imagesgridviewswrapper;
                activity = activity1;
                gridView = GridView.this;
                super();
            }
    }

}
