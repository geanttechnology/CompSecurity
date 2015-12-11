// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.android.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.ebay.common.util.ImageUtil;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.dm.ImageDataManager;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.FwActivity;

public class RemoteImageView extends ImageView
    implements com.ebay.nautilus.domain.content.dm.ImageDataManager.Observer
{
    public static final class DynamicHeight extends Enum
    {

        private static final DynamicHeight $VALUES[];
        public static final DynamicHeight DISABLED;
        public static final DynamicHeight FOUR_BY_THREE;
        public static final DynamicHeight SQUARE;

        public static DynamicHeight valueOf(String s)
        {
            return (DynamicHeight)Enum.valueOf(com/ebay/android/widget/RemoteImageView$DynamicHeight, s);
        }

        public static DynamicHeight[] values()
        {
            return (DynamicHeight[])$VALUES.clone();
        }

        static 
        {
            DISABLED = new DynamicHeight("DISABLED", 0);
            SQUARE = new DynamicHeight("SQUARE", 1);
            FOUR_BY_THREE = new DynamicHeight("FOUR_BY_THREE", 2);
            $VALUES = (new DynamicHeight[] {
                DISABLED, SQUARE, FOUR_BY_THREE
            });
        }

        private DynamicHeight(String s, int i)
        {
            super(s, i);
        }
    }

    public static interface OnRemoteImageLoadedListener
    {

        public abstract void onRemoteImageLoaded(RemoteImageView remoteimageview, String s);
    }


    private boolean averageBackgroundColor;
    private ImageDataManager dm;
    private final DynamicHeight dynamicHeight;
    protected final EbayContext ebayContext;
    protected int emptyLoadingColor;
    protected Integer explicitImageResource;
    private Animation fadeInAnimation;
    private int heightPixels;
    private boolean isImageReceived;
    private com.ebay.nautilus.domain.content.dm.ImageDataManager.LoadToken loadToken;
    private final int maxHeightPixels;
    private final int maxWidthPixels;
    protected int missingImageResId;
    private OnRemoteImageLoadedListener onImageLoadedListener;
    protected String remoteImageUrl;
    private com.ebay.nautilus.domain.content.dm.ImageDataManager.UrlRewriterType urlRewriterType;
    private int widthPixels;
    protected String zoomGuid;
    protected String zoomMd5;

    public RemoteImageView(Context context)
    {
        this(context, null);
    }

    public RemoteImageView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public RemoteImageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        widthPixels = 0;
        heightPixels = 0;
        Object obj;
        for (obj = context; obj != null && !(obj instanceof FwActivity);)
        {
            if (obj instanceof ContextWrapper)
            {
                obj = ((ContextWrapper)obj).getBaseContext();
            } else
            {
                obj = null;
            }
        }

        obj = (FwActivity)obj;
        if (obj != null)
        {
            obj = ((FwActivity) (obj)).getEbayContext();
        } else
        {
            obj = null;
        }
        ebayContext = ((EbayContext) (obj));
        if (android.os.Build.VERSION.SDK_INT == 17)
        {
            setLayerType(1, null);
        }
        attributeset = context.obtainStyledAttributes(attributeset, com.ebay.mobile.R.styleable.RemoteImageView, i, 0);
        urlRewriterType = com.ebay.nautilus.domain.content.dm.ImageDataManager.UrlRewriterType.values()[attributeset.getInt(0, 0)];
        maxWidthPixels = attributeset.getInt(2, 0x7fffffff);
        maxHeightPixels = attributeset.getInt(3, 0x7fffffff);
        setFadeInAnimation(attributeset.getInt(4, 0));
        emptyLoadingColor = attributeset.getColor(1, context.getResources().getColor(0x7f0d00cd));
        averageBackgroundColor = attributeset.getBoolean(5, false);
        dynamicHeight = DynamicHeight.values()[attributeset.getInt(6, 0)];
        attributeset.recycle();
        missingImageResId = 0x7f0201f5;
    }

    private void acquire()
    {
        if (explicitImageResource != null)
        {
            setImageResourceInternal(explicitImageResource.intValue());
        } else
        {
            if (dm == null)
            {
                setImageResourceInternal(0x106000d);
                return;
            }
            if (TextUtils.isEmpty(remoteImageUrl))
            {
                failure();
                return;
            }
            android.graphics.Bitmap bitmap = dm.loadImageImmediate(remoteImageUrl, zoomGuid, zoomMd5, urlRewriterType, widthPixels, heightPixels);
            setImageBitmap(bitmap);
            if (bitmap == null)
            {
                if (widthPixels > 0 || heightPixels > 0)
                {
                    loadToken = dm.loadImage(this, remoteImageUrl, zoomGuid, zoomMd5, urlRewriterType, widthPixels, heightPixels);
                    return;
                }
            } else
            {
                if (averageBackgroundColor)
                {
                    setBackgroundColor(ImageUtil.getAverageColor(bitmap, true));
                } else
                {
                    setBackgroundColor(0);
                }
                notifyListener();
                return;
            }
        }
    }

    private void failure()
    {
        setImageResourceInternal(missingImageResId);
        loadToken = null;
        notifyListener();
    }

    private void notifyListener()
    {
        isImageReceived = true;
        if (onImageLoadedListener != null)
        {
            onImageLoadedListener.onRemoteImageLoaded(this, remoteImageUrl);
        }
    }

    private void success(com.ebay.nautilus.domain.content.dm.ImageDataManager.ImageInfo imageinfo)
    {
        if (imageinfo != null && imageinfo.image != null && imageinfo.loadToken.equals(loadToken))
        {
            if (fadeInAnimation != null && !imageinfo.fromCache)
            {
                startAnimation(fadeInAnimation);
            } else
            {
                setAlpha(1.0F);
            }
            if (averageBackgroundColor)
            {
                setBackgroundColor(ImageUtil.getAverageColor(imageinfo.image, true));
            } else
            {
                setBackgroundColor(0);
            }
            setImageBitmap(imageinfo.image);
            loadToken = null;
            notifyListener();
        }
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        if (dm != null)
        {
            dm.unregisterObserver(this);
            dm = null;
        }
        loadToken = null;
        setOnRemoteImageLoadedListener(null);
        setImageResourceInternal(0x106000d);
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        if (flag)
        {
            widthPixels = Math.min(k - i, maxWidthPixels);
            heightPixels = Math.min(l - j, maxHeightPixels);
            if (!isImageReceived)
            {
                acquire();
            }
        }
    }

    public void onLoadImageComplete(ImageDataManager imagedatamanager, Content content)
    {
        if (!content.getStatus().hasError())
        {
            success((com.ebay.nautilus.domain.content.dm.ImageDataManager.ImageInfo)content.getData());
            return;
        } else
        {
            failure();
            return;
        }
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        if (dynamicHeight != null && !dynamicHeight.equals(DynamicHeight.DISABLED))
        {
            if (dynamicHeight.equals(DynamicHeight.SQUARE))
            {
                i = getMeasuredWidth();
                setMeasuredDimension(i, i);
                return;
            }
            if (dynamicHeight.equals(DynamicHeight.FOUR_BY_THREE))
            {
                i = getMeasuredWidth();
                setMeasuredDimension(i, (int)((double)i * 0.75D));
                return;
            }
        }
    }

    protected void onWindowVisibilityChanged(int i)
    {
        super.onWindowVisibilityChanged(i);
        i;
        JVM INSTR lookupswitch 3: default 40
    //                   0: 41
    //                   4: 111
    //                   8: 111;
           goto _L1 _L2 _L3 _L3
_L1:
        return;
_L2:
        if (isInEditMode())
        {
            setImageResource(missingImageResId);
            setColorFilter(0x33000000, android.graphics.PorterDuff.Mode.OVERLAY);
            return;
        }
        if (dm == null && ebayContext != null)
        {
            dm = (ImageDataManager)ImageDataManager.get(ebayContext, ImageDataManager.KEY);
            dm.registerObserver(this);
            acquire();
            return;
        }
          goto _L1
_L3:
        if (dm != null)
        {
            dm.unregisterObserver(this);
            dm = null;
        }
        loadToken = null;
        setOnRemoteImageLoadedListener(null);
        setImageResourceInternal(0x106000d);
        return;
    }

    public void setAverageBackgroundColor(boolean flag)
    {
        averageBackgroundColor = flag;
    }

    public void setFadeInAnimation(int i)
    {
        if (i > 0)
        {
            fadeInAnimation = new AlphaAnimation(0.0F, 1.0F);
            fadeInAnimation.setDuration(i);
            return;
        } else
        {
            fadeInAnimation = null;
            return;
        }
    }

    public void setImageResource(int i)
    {
        explicitImageResource = Integer.valueOf(i);
        setImageResourceInternal(i);
    }

    protected void setImageResourceInternal(int i)
    {
        setImageDrawable(getResources().getDrawable(i));
    }

    public void setOnRemoteImageLoadedListener(OnRemoteImageLoadedListener onremoteimageloadedlistener)
    {
        onImageLoadedListener = onremoteimageloadedlistener;
    }

    public void setRemoteImageUrl(String s)
    {
        setRemoteImageUrl(s, null, null);
    }

    public void setRemoteImageUrl(String s, String s1, String s2)
    {
        explicitImageResource = null;
        boolean flag1 = true;
        boolean flag = flag1;
        if (loadToken != null)
        {
            flag = flag1;
            if (remoteImageUrl != null)
            {
                if (remoteImageUrl.equalsIgnoreCase(s))
                {
                    flag = false;
                } else
                {
                    dm.cancelLoadImage(loadToken);
                    loadToken = null;
                    flag = flag1;
                }
            }
        }
        if (flag)
        {
            isImageReceived = false;
            if (averageBackgroundColor)
            {
                setBackgroundColor(0);
            } else
            {
                setBackgroundColor(emptyLoadingColor);
            }
            if (fadeInAnimation != null)
            {
                fadeInAnimation.cancel();
                fadeInAnimation.reset();
                fadeInAnimation.setStartTime(0L);
            }
            remoteImageUrl = s;
            zoomGuid = s1;
            zoomMd5 = s2;
            acquire();
        }
    }

    public void setUrlRewriter(com.ebay.nautilus.domain.content.dm.ImageDataManager.UrlRewriterType urlrewritertype)
    {
        urlRewriterType = urlrewritertype;
    }
}
