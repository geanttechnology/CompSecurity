// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ImageView;
import com.amazon.gallery.foundation.image.BitmapDecoder;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.gallery.widget.holder.LoadingHolderInterface;
import java.io.FileNotFoundException;
import uk.co.senab.photoview.PhotoView;

// Referenced classes of package com.amazon.gallery.framework.gallery.widget:
//            ViewFactory, GridStatus

public class UriViewFactory
    implements ViewFactory
{
    private static class UriViewHolder
        implements LoadingHolderInterface
    {

        private ImageView imageView;
        private boolean isLoaded;

        public void imageLoaded(Bitmap bitmap)
        {
            imageView.setImageBitmap(bitmap);
            isLoaded = true;
        }

        public boolean isLoading()
        {
            return !isLoaded;
        }

        public UriViewHolder(ImageView imageview)
        {
            isLoaded = false;
            imageView = imageview;
        }
    }


    private static final String TAG = com/amazon/gallery/framework/gallery/widget/UriViewFactory.getName();
    private GridStatus loadingStatusTracker;
    private int mBoundingHeight;
    private int mBoundingWidth;
    private Context mContext;

    public UriViewFactory()
    {
    }

    public View createView(Uri uri)
    {
        return new PhotoView(mContext);
    }

    public volatile View createView(Object obj)
    {
        return createView((Uri)obj);
    }

    public View getView(int i, Uri uri, View view)
    {
        final UriViewHolder viewHolder;
        if (view != null)
        {
            view = (ImageView)view;
        } else
        {
            view = (ImageView)createView(uri);
        }
        viewHolder = new UriViewHolder(view);
        view.setTag(viewHolder);
        loadingStatusTracker.onVisible(viewHolder);
        (new AsyncTask() {

            final UriViewFactory this$0;
            final UriViewHolder val$viewHolder;

            protected transient Bitmap doInBackground(Uri auri[])
            {
                try
                {
                    auri = BitmapDecoder.loadBitmapFromUri(mContext, auri[0], mBoundingWidth, mBoundingHeight, 0);
                }
                // Misplaced declaration of an exception variable
                catch (Uri auri[])
                {
                    GLogger.ex(UriViewFactory.TAG, "File not found while loading bitmap.", auri);
                    return null;
                }
                return auri;
            }

            protected volatile Object doInBackground(Object aobj[])
            {
                return doInBackground((Uri[])aobj);
            }

            protected void onPostExecute(Bitmap bitmap)
            {
                if (bitmap != null)
                {
                    viewHolder.imageLoaded(bitmap);
                }
            }

            protected volatile void onPostExecute(Object obj)
            {
                onPostExecute((Bitmap)obj);
            }

            
            {
                this$0 = UriViewFactory.this;
                viewHolder = uriviewholder;
                super();
            }
        }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Uri[] {
            uri
        });
        return view;
    }

    public volatile View getView(int i, Object obj, View view)
    {
        return getView(i, (Uri)obj, view);
    }

    public void onViewDestroy(View view)
    {
        view = (LoadingHolderInterface)view.getTag();
        if (view != null)
        {
            loadingStatusTracker.onHidden(view);
        }
    }

    public void reset()
    {
        loadingStatusTracker.reset();
    }

    public void setBoundingSize(int i, int j)
    {
        mBoundingWidth = i;
        mBoundingHeight = j;
    }

    public void setContext(Context context)
    {
        mContext = context;
    }

    public void setLoadingStatusTracker(GridStatus gridstatus)
    {
        loadingStatusTracker = gridstatus;
    }





}
