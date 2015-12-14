// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.boombox.widget;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.amazon.boombox.internal.adapter.AsyncDrawableAdapter;
import com.amazon.boombox.internal.adapter.BitmapDrawableAdapter;
import com.amazon.boombox.internal.adapter.CachedAsyncDrawableAdapter;
import com.amazon.boombox.internal.adapter.FileAsyncDrawableAdapter;
import com.amazon.boombox.internal.adapter.LenticularArchiveDrawableAdapter;
import com.amazon.boombox.internal.util.IoUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LenticularView extends FrameLayout
    implements com.amazon.boombox.internal.adapter.AsyncDrawableAdapter.Listener
{
    public static interface FrameListener
    {

        public abstract void onFrameChange(int i);

        public abstract void onReady();
    }


    private static final String TAG = com/amazon/boombox/widget/LenticularView.getSimpleName();
    private int mCacheSize;
    private int mDisplayedFrameNumber;
    private AsyncDrawableAdapter mDrawableAdapter;
    private int mFrameCount;
    private List mFrameListeners;
    private ImageView mImageView;
    private double mMaxQuality;
    private int mOrientationOverride;
    private int mPosition;
    private boolean mReady;
    private Drawable mTransitionFrames[];

    public LenticularView(Context context)
    {
        this(context, null);
    }

    public LenticularView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public LenticularView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mDisplayedFrameNumber = -1;
        mFrameListeners = new ArrayList();
        mReady = false;
        mOrientationOverride = 0;
        mCacheSize = 10;
        mMaxQuality = 0.25D;
        mImageView = new ImageView(context, attributeset, i);
        addView(mImageView);
        if (attributeset != null)
        {
            context = attributeset.getAttributeValue("http://schemas.android.com/apk/lib/com.amazon.boombox", "cacheSize");
            if (context != null)
            {
                setCacheSize(Integer.parseInt(context));
            }
            context = attributeset.getAttributeValue("http://schemas.android.com/apk/lib/com.amazon.boombox", "maxQuality");
            if (context != null)
            {
                setMaxQuality(Double.parseDouble(context));
            }
            context = attributeset.getAttributeValue("http://schemas.android.com/apk/lib/com.amazon.boombox", "uri");
            if (context != null)
            {
                setUri(Uri.parse(context));
            }
        }
    }

    private String getFilePathFromImageUri(ContentResolver contentresolver, Uri uri)
    {
        ContentResolver contentresolver1 = null;
        contentresolver = contentresolver.query(uri, new String[] {
            "_data"
        }, null, null, null);
        if (contentresolver != null)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        contentresolver1 = contentresolver;
        throw new IllegalArgumentException((new StringBuilder()).append("Could not find path for ").append(uri).toString());
        contentresolver;
        IoUtil.closeSilently(contentresolver1);
        throw contentresolver;
        contentresolver1 = contentresolver;
        contentresolver.moveToFirst();
        contentresolver1 = contentresolver;
        uri = contentresolver.getString(contentresolver.getColumnIndexOrThrow("_data"));
        IoUtil.closeSilently(contentresolver);
        return uri;
    }

    private int getFrameNumberFromProgress(int i)
    {
        float f = (float)i / (float)getCount();
        int j = (int)((float)mFrameCount * f);
        i = j;
        if (j == mFrameCount)
        {
            i = j - 1;
        }
        return i;
    }

    private void notifyFrameChangeEvent(int i)
    {
        List list = mFrameListeners;
        list;
        JVM INSTR monitorenter ;
        for (Iterator iterator = (new ArrayList(mFrameListeners)).iterator(); iterator.hasNext(); ((FrameListener)iterator.next()).onFrameChange(i)) { }
        break MISSING_BLOCK_LABEL_54;
        Exception exception;
        exception;
        list;
        JVM INSTR monitorexit ;
        throw exception;
        list;
        JVM INSTR monitorexit ;
    }

    private void notifyFramesReady()
    {
        List list = mFrameListeners;
        list;
        JVM INSTR monitorenter ;
        for (Iterator iterator = (new ArrayList(mFrameListeners)).iterator(); iterator.hasNext(); ((FrameListener)iterator.next()).onReady()) { }
        break MISSING_BLOCK_LABEL_53;
        Exception exception;
        exception;
        list;
        JVM INSTR monitorexit ;
        throw exception;
        list;
        JVM INSTR monitorexit ;
    }

    private void setCurrentFrame(int i)
    {
        if (getWidth() != 0 && getHeight() != 0 && mDrawableAdapter != null)
        {
            if (i >= mFrameCount || i < 0)
            {
                throw new IndexOutOfBoundsException("frameNumber is out of bounds in LenticularView");
            }
            if (i != mDisplayedFrameNumber)
            {
                mDisplayedFrameNumber = i;
                i = (int)((double)getWidth() * mMaxQuality);
                int j = (int)((double)getHeight() * mMaxQuality);
                mDrawableAdapter.getDrawable(mDisplayedFrameNumber, i, j, this);
                return;
            }
        }
    }

    private void setDrawable(Drawable drawable)
    {
        while (drawable == null || mTransitionFrames != null && mTransitionFrames[1].hashCode() == drawable.hashCode()) 
        {
            return;
        }
        if (mTransitionFrames == null)
        {
            mTransitionFrames = new Drawable[2];
            mTransitionFrames[1] = drawable;
            mImageView.setImageDrawable(mTransitionFrames[1]);
            return;
        } else
        {
            mDrawableAdapter.dispose(mTransitionFrames[0]);
            mTransitionFrames[0] = mTransitionFrames[1];
            mTransitionFrames[1] = drawable;
            drawable = new TransitionDrawable(mTransitionFrames);
            mImageView.setImageDrawable(drawable);
            drawable.startTransition(500);
            return;
        }
    }

    private void setDrawableAdapter(AsyncDrawableAdapter asyncdrawableadapter)
    {
        mDrawableAdapter = asyncdrawableadapter;
        if (mDrawableAdapter != null)
        {
            mDrawableAdapter.getCount(this);
        }
    }

    private void updateFramesToCurrentPosition()
    {
        if (mDrawableAdapter == null)
        {
            return;
        } else
        {
            setCurrentFrame(getFrameNumberFromProgress(mPosition));
            return;
        }
    }

    public void addFrameListener(FrameListener framelistener)
    {
        synchronized (mFrameListeners)
        {
            if (mReady)
            {
                framelistener.onReady();
            }
            mFrameListeners.add(framelistener);
        }
        return;
        framelistener;
        list;
        JVM INSTR monitorexit ;
        throw framelistener;
    }

    public int getCount()
    {
        return mFrameCount;
    }

    public int getOrientationOverride()
    {
        return mOrientationOverride;
    }

    public int getPosition()
    {
        return mPosition;
    }

    public void onCountReady(int i)
    {
        mFrameCount = i;
    }

    public void onDrawableReady(int i, Drawable drawable)
    {
        if (drawable == null)
        {
            return;
        }
        setDrawable(drawable);
        synchronized (mFrameListeners)
        {
            if (!mReady)
            {
                mReady = true;
                notifyFramesReady();
            }
        }
        notifyFrameChangeEvent(i);
        return;
        exception;
        drawable;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void setBitmaps(List list)
    {
        if (list == null)
        {
            setDrawableAdapter(null);
            return;
        } else
        {
            setDrawableAdapter(new BitmapDrawableAdapter(getContext(), list));
            return;
        }
    }

    public void setCacheSize(int i)
    {
        mCacheSize = i;
    }

    public void setFiles(File afile[])
    {
        if (afile == null)
        {
            setDrawableAdapter(null);
            return;
        } else
        {
            setDrawableAdapter(new CachedAsyncDrawableAdapter(new FileAsyncDrawableAdapter(getContext(), afile), mCacheSize));
            return;
        }
    }

    public void setImageMatrix(Matrix matrix)
    {
        mImageView.setScaleType(android.widget.ImageView.ScaleType.MATRIX);
        mImageView.setImageMatrix(matrix);
    }

    public void setMaxQuality(double d)
    {
        if (d < 0.0D)
        {
            throw new IllegalArgumentException("maxQuality must be greater than 0.0");
        }
        if (d > 1.0D)
        {
            throw new IllegalArgumentException("maxQuality must be less than or equal to 1.0");
        } else
        {
            mMaxQuality = d;
            return;
        }
    }

    public void setOrientationOverride(int i)
    {
        mOrientationOverride = i;
    }

    public void setPosition(int i)
    {
        mPosition = i;
        updateFramesToCurrentPosition();
    }

    public void setUri(Uri uri)
    {
        if (uri == null)
        {
            setDrawableAdapter(null);
            return;
        }
        if (uri.getScheme().equals("file"))
        {
            uri = uri.getPath();
        } else
        {
            uri = getFilePathFromImageUri(getContext().getContentResolver(), uri);
        }
        setDrawableAdapter(new CachedAsyncDrawableAdapter(new LenticularArchiveDrawableAdapter(getContext(), new File(uri)), mCacheSize));
    }

}
