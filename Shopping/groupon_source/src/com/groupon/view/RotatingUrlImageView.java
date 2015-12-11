// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Handler;
import android.util.AttributeSet;
import com.groupon.util.ImageUrl;
import com.groupon.util.PicassoHelper;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import com.squareup.picasso.Target;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.view:
//            UrlImageView

public class RotatingUrlImageView extends UrlImageView
    implements Target
{
    private class RequestNextImageAndRotateRunnable
        implements Runnable
    {

        final RotatingUrlImageView this$0;

        public void run()
        {
            if (isShown())
            {
                requestNextImageAndRotateUntilLastImage();
            }
        }

        private RequestNextImageAndRotateRunnable()
        {
            this$0 = RotatingUrlImageView.this;
            super();
        }

    }


    private static int FIRST_ROTATION_INTERVAL_IN_MS = 500;
    private static int SUBSEQUENT_ROTATION_INTERVAL_IN_MS = 1800;
    private static int TRANSITION_TIME_IN_MS = 400;
    private Handler handler;
    private Drawable previousDrawable;
    private boolean shouldRequestImage;
    private int uriIndex;
    private ImageUrl uris[];

    public RotatingUrlImageView(Context context)
    {
        this(context, null, 0);
    }

    public RotatingUrlImageView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public RotatingUrlImageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        uriIndex = 0;
        handler = new Handler();
        if (previousDrawable == null)
        {
            setImageDrawable(defaultPlaceholder);
        } else
        {
            setImageDrawable(previousDrawable);
        }
        defaultPlaceholder.setCallback(null);
    }

    private void delayNextRotation()
    {
        int i;
        if (uriIndex == 0)
        {
            i = FIRST_ROTATION_INTERVAL_IN_MS;
        } else
        {
            i = SUBSEQUENT_ROTATION_INTERVAL_IN_MS;
        }
        handler.postDelayed(new RequestNextImageAndRotateRunnable(), i);
    }

    private void initializeRotation(boolean flag)
    {
        handler.removeCallbacksAndMessages(null);
        previousDrawable = null;
        if (flag)
        {
            uriIndex = uris.length - 1;
        } else
        {
            uriIndex = 0;
        }
        shouldRequestImage = true;
        requestLayout();
    }

    private boolean isAnimationOver()
    {
        return uriIndex == uris.length - 1;
    }

    private void requestNextImageAndRotateUntilLastImage()
    {
        boolean flag;
        if (uriIndex < uris.length && uriIndex >= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            setImageUrl(uris[uriIndex].getUrl());
            if (!isAnimationOver())
            {
                uriIndex = uriIndex + 1;
            }
        }
    }

    public void onBitmapFailed(Drawable drawable)
    {
        setImageBitmap(((BitmapDrawable)defaultPlaceholder).getBitmap());
        if (!isAnimationOver())
        {
            delayNextRotation();
        }
    }

    public void onBitmapLoaded(Bitmap bitmap, com.squareup.picasso.Picasso.LoadedFrom loadedfrom)
    {
        setImageBitmap(bitmap);
        if (!isAnimationOver())
        {
            delayNextRotation();
        }
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        if (shouldRequestImage && i != k && j != l)
        {
            shouldRequestImage = false;
            requestNextImageAndRotateUntilLastImage();
        }
    }

    public void onPrepareLoad(Drawable drawable)
    {
    }

    public void reset()
    {
        initializeRotation(false);
    }

    public void setCallback(Callback callback)
    {
        throw new UnsupportedOperationException("This class can't have any listener.");
    }

    public void setImageBitmap(Bitmap bitmap)
    {
        if (previousDrawable == null)
        {
            previousDrawable = new BitmapDrawable(getResources(), bitmap);
            super.setImageDrawable(previousDrawable);
            return;
        } else
        {
            Drawable adrawable[] = new Drawable[2];
            adrawable[0] = previousDrawable;
            adrawable[1] = new BitmapDrawable(getResources(), bitmap);
            previousDrawable = adrawable[1];
            bitmap = new TransitionDrawable(adrawable);
            super.setImageDrawable(bitmap);
            bitmap.setCrossFadeEnabled(true);
            setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
            bitmap.resetTransition();
            bitmap.startTransition(TRANSITION_TIME_IN_MS);
            return;
        }
    }

    public void setImageUrl(String s)
    {
        if (Strings.notEmpty(s))
        {
            RequestCreator requestcreator1 = PicassoHelper.getPicasso(getContext()).load(s).tag(Integer.valueOf(getContext().hashCode())).resize(getWidth(), getHeight());
            RequestCreator requestcreator = requestcreator1;
            if (enable565Bitmap1506)
            {
                requestcreator = PicassoHelper.request565Bitmap(requestcreator1, s);
            }
            requestcreator.into(this);
        }
    }

    public void setImageUrls(ImageUrl aimageurl[], boolean flag)
    {
        uris = aimageurl;
        initializeRotation(flag);
    }


}
