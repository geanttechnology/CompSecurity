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
import com.bitstrips.imoji.ui.adapters.ImageAdapter;
import com.bitstrips.imoji.ui.tasks.GetImojiImageTask;
import com.bitstrips.imoji.ui.views.ImojiWithBadgeView;
import java.io.File;

// Referenced classes of package com.bitstrips.imoji.ui:
//            ImageLoader

public class ImagesGridViewsWrapper
{
    public static interface ImojiClickListener
    {

        public abstract void onClick(File file, Imoji imoji, int i);
    }


    private GridView gridView;
    private ImageAdapter imageAdapter;
    ImageLoader imageLoader;
    private String supertag;
    TemplatesManager templatesManager;

    public ImagesGridViewsWrapper()
    {
    }

    public String getSupertag()
    {
        return supertag;
    }

    public void init(final Activity activity, final GridView gridView, String s)
    {
        this.gridView = gridView;
        supertag = s;
        imageAdapter = new ImageAdapter(activity, 0x7f03003e, s);
        gridView.setAdapter(imageAdapter);
        gridView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final ImagesGridViewsWrapper this$0;
            final Activity val$activity;
            final GridView val$gridView;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                (new GetImojiImageTask(activity, imageLoader, templatesManager) {

                    final _cls1 this$1;

                    protected void onPostExecute(File file)
                    {
                        ((ImojiClickListener)activity).onClick(file, imoji, gridView.getId());
                    }

                    protected volatile void onPostExecute(Object obj)
                    {
                        onPostExecute((File)obj);
                    }

            
            {
                this$1 = _cls1.this;
                super(activity, imageloader, templatesmanager);
            }
                }).execute(new Imoji[] {
                    ((ImojiWithBadgeView)view).getImoji()
                });
            }

            
            {
                this$0 = ImagesGridViewsWrapper.this;
                activity = activity1;
                gridView = gridview;
                super();
            }
        });
    }

    public void makeVisible()
    {
        gridView.setVisibility(0);
    }

    public void notifyDataSetChanged()
    {
        imageAdapter.notifyDataSetChanged();
    }

    public void updateData()
    {
        templatesManager.resetFriendmojisCachedImageUrl();
        notifyDataSetChanged();
    }
}
