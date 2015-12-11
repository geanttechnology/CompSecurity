// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import com.google.inject.Injector;
import com.groupon.abtest.BitmapAbTestHelper;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.ImageUrl;
import com.groupon.util.PicassoHelper;
import com.groupon.util.imageservice.ImageCdnUrlBuilder;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import com.squareup.picasso.Transformation;
import roboguice.RoboGuice;
import roboguice.util.Ln;
import roboguice.util.Strings;

public class UrlImageView extends ImageView
{
    private class InternalPicassoListener
        implements Callback
    {

        final UrlImageView this$0;

        public void onError(ImageView imageview)
        {
            Logger logger1 = UrlImageView.logger;
            String s1 = url;
            String s;
            int i;
            if (UrlImageView.isDeviceAtOrBelow2012)
            {
                s = "device_is_at_or_below_2012";
            } else
            {
                s = "device_is_above_2012";
            }
            if (UrlImageView.enable565Bitmap1506)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            logger1.logGeneralEvent("image_request_failed", s1, s, i, Logger.NULL_NST_FIELD);
            if (listener != null)
            {
                listener.onError(imageview);
            }
        }

        public void onSuccess(ImageView imageview)
        {
            if (listener != null)
            {
                listener.onSuccess(imageview);
            }
        }

        private InternalPicassoListener()
        {
            this$0 = UrlImageView.this;
            super();
        }

    }

    public static final class ScaleImageType extends Enum
    {

        private static final ScaleImageType $VALUES[];
        public static final ScaleImageType CENTER_CROP;
        public static final ScaleImageType CENTER_INSIDE;
        public static final ScaleImageType NONE;

        public static ScaleImageType valueOf(String s)
        {
            return (ScaleImageType)Enum.valueOf(com/groupon/view/UrlImageView$ScaleImageType, s);
        }

        public static ScaleImageType[] values()
        {
            return (ScaleImageType[])$VALUES.clone();
        }

        static 
        {
            NONE = new ScaleImageType("NONE", 0);
            CENTER_CROP = new ScaleImageType("CENTER_CROP", 1);
            CENTER_INSIDE = new ScaleImageType("CENTER_INSIDE", 2);
            $VALUES = (new ScaleImageType[] {
                NONE, CENTER_CROP, CENTER_INSIDE
            });
        }

        private ScaleImageType(String s, int i)
        {
            super(s, i);
        }
    }


    private static final int DEFAULT_IMAGE_QUALITY = 60;
    private static final String GENERAL_EVENT_CATEGORY = "image_request_failed";
    private static final String GENERAL_EVEN_LABEL_DEVICE_ABOVE_2012 = "device_is_above_2012";
    private static final String GENERAL_EVEN_LABEL_DEVICE_BELOW_2012 = "device_is_at_or_below_2012";
    private static volatile int cdnImageHeight;
    private static volatile int cdnImageWidth;
    protected static volatile Drawable defaultPlaceholder;
    protected static volatile boolean enable565Bitmap1506;
    private static volatile boolean isDeviceAtOrBelow2012;
    private static volatile Logger logger;
    private final Callback internalListener;
    private Callback listener;
    private final Picasso picasso;
    private String url;

    public UrlImageView(Context context)
    {
        this(context, null, 0);
    }

    public UrlImageView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public UrlImageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        internalListener = new InternalPicassoListener();
        picasso = PicassoHelper.getPicasso(context);
        init(context);
    }

    private static String generateFullCdnImageUrl(String s, int i, int j, int k)
    {
        return (new ImageCdnUrlBuilder(s)).size(i, j).quality(k).build();
    }

    public static int getCdnImageWidth()
    {
        return cdnImageWidth;
    }

    private RequestCreator getRequestCreatorWithSize(RequestCreator requestcreator, int i, int j)
    {
        if (i != 0 && j != 0)
        {
            return requestcreator.resize(i, j);
        } else
        {
            return requestcreator.fit();
        }
    }

    protected static void initSizesIfNecessary(Context context)
    {
        if (cdnImageWidth != 0)
        {
            break MISSING_BLOCK_LABEL_128;
        }
        com/groupon/view/UrlImageView;
        JVM INSTR monitorenter ;
        if (cdnImageWidth == 0)
        {
            cdnImageWidth = Math.min(context.getResources().getDisplayMetrics().widthPixels, context.getResources().getDisplayMetrics().heightPixels);
            cdnImageHeight = context.getResources().getDimensionPixelSize(0x7f0b00ca);
            context = RoboGuice.getInjector(context);
            enable565Bitmap1506 = ((BitmapAbTestHelper)context.getInstance(com/groupon/abtest/BitmapAbTestHelper)).isEnable565Bitmap1506();
            Ln.d((new StringBuilder()).append("enable565Bitmap1506 enabled: ").append(enable565Bitmap1506).toString(), new Object[0]);
            logger = (Logger)context.getInstance(com/groupon/tracking/mobile/sdk/Logger);
        }
        com/groupon/view/UrlImageView;
        JVM INSTR monitorexit ;
        return;
        context;
        com/groupon/view/UrlImageView;
        JVM INSTR monitorexit ;
        throw context;
    }

    public static void prefetch(Application application, ImageUrl imageurl)
    {
        initSizesIfNecessary(application);
        if (Strings.notEmpty(imageurl.getUrl()))
        {
            RequestCreator requestcreator;
            if (imageurl.isCdnImage())
            {
                imageurl = generateFullCdnImageUrl(imageurl.getUrl(), cdnImageWidth, cdnImageHeight, 60);
            } else
            {
                imageurl = imageurl.getUrl();
            }
            requestcreator = PicassoHelper.getPicasso(application).load(imageurl).skipMemoryCache();
            application = requestcreator;
            if (enable565Bitmap1506)
            {
                application = PicassoHelper.request565Bitmap(requestcreator, imageurl);
            }
            application.fetch();
        }
    }

    public void clearImage()
    {
        url = null;
        setImageBitmap(null);
    }

    protected String generateCdnImageUrl(String s, int i, int j, int k)
    {
        return generateFullCdnImageUrl(s, i, j, k);
    }

    protected RequestCreator getRequestCreator(String s, Transformation transformation, Drawable drawable, ScaleImageType scaleimagetype, int i, int j)
    {
        RequestCreator requestcreator1 = picasso.load(s);
        RequestCreator requestcreator = requestcreator1;
        if (enable565Bitmap1506)
        {
            requestcreator = PicassoHelper.request565Bitmap(requestcreator1, s);
        }
        s = requestcreator;
        if (drawable != null)
        {
            s = requestcreator.placeholder(drawable).error(drawable);
        }
        drawable = s;
        if (transformation != null)
        {
            drawable = s.transform(transformation);
        }
        static class _cls1
        {

            static final int $SwitchMap$com$groupon$view$UrlImageView$ScaleImageType[];

            static 
            {
                $SwitchMap$com$groupon$view$UrlImageView$ScaleImageType = new int[ScaleImageType.values().length];
                try
                {
                    $SwitchMap$com$groupon$view$UrlImageView$ScaleImageType[ScaleImageType.CENTER_CROP.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$groupon$view$UrlImageView$ScaleImageType[ScaleImageType.CENTER_INSIDE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.groupon.view.UrlImageView.ScaleImageType[scaleimagetype.ordinal()])
        {
        default:
            return drawable;

        case 1: // '\001'
            return getRequestCreatorWithSize(drawable, i, j).centerCrop();

        case 2: // '\002'
            return getRequestCreatorWithSize(drawable, i, j).centerInside();
        }
    }

    protected void init(Context context)
    {
        if (defaultPlaceholder != null) goto _L2; else goto _L1
_L1:
        com/groupon/view/UrlImageView;
        JVM INSTR monitorenter ;
        if (defaultPlaceholder == null)
        {
            defaultPlaceholder = context.getResources().getDrawable(0x7f0201a3);
        }
        com/groupon/view/UrlImageView;
        JVM INSTR monitorexit ;
_L2:
        initSizesIfNecessary(context);
        setImageDrawable(defaultPlaceholder);
        defaultPlaceholder.setCallback(null);
        return;
        context;
        com/groupon/view/UrlImageView;
        JVM INSTR monitorexit ;
        throw context;
    }

    public void prefetch(ImageUrl imageurl)
    {
        if (imageurl.isCdnImage())
        {
            RequestCreator requestcreator2 = picasso.load(generateFullCdnImageUrl(imageurl.getUrl(), cdnImageWidth, cdnImageHeight, 60));
            RequestCreator requestcreator = requestcreator2;
            if (enable565Bitmap1506)
            {
                requestcreator = PicassoHelper.request565Bitmap(requestcreator2, imageurl.getUrl());
            }
            requestcreator.fetch();
            return;
        }
        int i = getWidth();
        int j = getHeight();
        if (i >= 0 && j >= 0 && (i > 0 || j > 0))
        {
            RequestCreator requestcreator3 = picasso.load(imageurl.getUrl()).resize(i, j).centerCrop();
            RequestCreator requestcreator1 = requestcreator3;
            if (enable565Bitmap1506)
            {
                requestcreator1 = PicassoHelper.request565Bitmap(requestcreator3, imageurl.getUrl());
            }
            requestcreator1.fetch();
            return;
        } else
        {
            Ln.d("Couldn't prefetch image as ImageView size is null", new Object[0]);
            return;
        }
    }

    public void setCallback(Callback callback)
    {
        listener = callback;
    }

    public void setImageUrl(ImageUrl imageurl)
    {
        setImageUrl(imageurl, null, defaultPlaceholder, ScaleImageType.CENTER_CROP, false, 0, 0);
    }

    public void setImageUrl(ImageUrl imageurl, int i, int j)
    {
        setImageUrl(imageurl, null, defaultPlaceholder, ScaleImageType.CENTER_CROP, false, i, j);
    }

    public void setImageUrl(ImageUrl imageurl, Drawable drawable)
    {
        setImageUrl(imageurl, null, drawable, ScaleImageType.CENTER_CROP, false, 0, 0);
    }

    public void setImageUrl(ImageUrl imageurl, Drawable drawable, ScaleImageType scaleimagetype, boolean flag)
    {
        setImageUrl(imageurl, null, drawable, scaleimagetype, flag, 0, 0);
    }

    public void setImageUrl(ImageUrl imageurl, Transformation transformation)
    {
        setImageUrl(imageurl, transformation, defaultPlaceholder, ScaleImageType.CENTER_CROP, false, 0, 0);
    }

    public void setImageUrl(ImageUrl imageurl, Transformation transformation, Drawable drawable, ScaleImageType scaleimagetype, boolean flag, int i, int j)
    {
        if (imageurl.isCdnImage())
        {
            int l = i;
            int k = j;
            if (i == 0)
            {
                l = i;
                k = j;
                if (j == 0)
                {
                    l = cdnImageWidth;
                    k = cdnImageHeight;
                }
            }
            imageurl = generateCdnImageUrl(imageurl.getUrl(), l, k, 60);
            if (!flag)
            {
                scaleimagetype = ScaleImageType.NONE;
            }
            setImageUrl(((String) (imageurl)), transformation, drawable, scaleimagetype, 0, 0);
            return;
        } else
        {
            setImageUrl(imageurl.getUrl(), transformation, drawable, scaleimagetype, i, j);
            return;
        }
    }

    public void setImageUrl(String s)
    {
        setImageUrl(s, null, defaultPlaceholder, ScaleImageType.CENTER_CROP, 0, 0);
    }

    public void setImageUrl(String s, ScaleImageType scaleimagetype)
    {
        setImageUrl(s, null, defaultPlaceholder, scaleimagetype, 0, 0);
    }

    public void setImageUrl(String s, Transformation transformation)
    {
        setImageUrl(s, transformation, defaultPlaceholder, ScaleImageType.CENTER_CROP, 0, 0);
    }

    public void setImageUrl(String s, Transformation transformation, Drawable drawable)
    {
        setImageUrl(s, transformation, drawable, ScaleImageType.CENTER_CROP, 0, 0);
    }

    public void setImageUrl(String s, Transformation transformation, Drawable drawable, ScaleImageType scaleimagetype)
    {
        setImageUrl(s, transformation, drawable, scaleimagetype, 0, 0);
    }

    public void setImageUrl(String s, Transformation transformation, Drawable drawable, ScaleImageType scaleimagetype, int i, int j)
    {
        Ln.d((new StringBuilder()).append("image service requesting ").append(s).toString(), new Object[0]);
        if (Strings.isEmpty(s))
        {
            setImageDrawable(drawable);
            return;
        } else
        {
            url = s;
            s = getRequestCreator(s, transformation, drawable, scaleimagetype, i, j);
            s.tag(Integer.valueOf(getContext().hashCode()));
            s.into(this, internalListener);
            return;
        }
    }




}
