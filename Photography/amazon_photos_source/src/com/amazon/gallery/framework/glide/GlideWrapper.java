// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.glide;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.store.RewindHelper;
import com.amazon.gallery.framework.gallery.widget.ItemViewFactory;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.Persistable;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.bumptech.glide.BitmapRequestBuilder;
import com.bumptech.glide.BitmapTypeRequest;
import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.GenericRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.resource.bitmap.BitmapEncoder;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.StreamBitmapDecoder;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.signature.StringSignature;
import java.util.concurrent.ExecutionException;

// Referenced classes of package com.amazon.gallery.framework.glide:
//            BitmapResizer, TransitionImageViewTarget

public class GlideWrapper
{

    private static final String TAG = com/amazon/gallery/framework/glide/GlideWrapper.getName();
    private static StreamBitmapDecoder argb8888Decoder;
    private static BitmapEncoder pngEncoder;

    public GlideWrapper()
    {
    }

    public static void cancelLoadImage(ImageView imageview)
    {
        Glide.clear(imageview);
    }

    public static Activity getActivityForView(View view)
    {
        view = view.getContext();
        if (!(view instanceof Activity))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Context associated with ImageView should be an Activity: ").append(view).toString());
        } else
        {
            return (Activity)view;
        }
    }

    private static StreamBitmapDecoder getArgb8888Decoder(Context context)
    {
        if (argb8888Decoder == null)
        {
            context = Glide.get(context).getBitmapPool();
            argb8888Decoder = new StreamBitmapDecoder(Downsampler.AT_LEAST, context, DecodeFormat.PREFER_ARGB_8888);
        }
        return argb8888Decoder;
    }

    private static Target getLoadTarget(ImageView imageview)
    {
        return new BitmapImageViewTarget(imageview) {

            public Drawable getCurrentDrawable()
            {
                return null;
            }

        };
    }

    private static GenericRequestBuilder getRequestBuilder(Persistable persistable, ImageView imageview, boolean flag, int i, ItemViewFactory itemviewfactory)
    {
        BitmapRequestBuilder bitmaprequestbuilder1 = Glide.with(getActivityForView(imageview)).from(persistable.getClass()).asBitmap().load(persistable);
        BitmapRequestBuilder bitmaprequestbuilder = bitmaprequestbuilder1;
        if (flag)
        {
            bitmaprequestbuilder = bitmaprequestbuilder1.fitCenter();
        }
        RewindHelper.getInstance().insertSignature(persistable, bitmaprequestbuilder);
        bitmaprequestbuilder.animate(0x10a0000);
        if (itemviewfactory != null && (imageview.getWidth() * imageview.getHeight() == 0 || BitmapResizer.isOversizeImage(persistable)))
        {
            itemviewfactory.overrideSizeToGlideBuilder(i, persistable, bitmaprequestbuilder);
        }
        if ((persistable instanceof MediaItem) && "image/png".equals(((MediaItem)persistable).getMIMEType()))
        {
            bitmaprequestbuilder.encoder(pngEncoder);
        }
        return bitmaprequestbuilder;
    }

    public static Bitmap loadBitmap(Context context, Persistable persistable, int i, int j)
    {
        Object obj = null;
        persistable = (Bitmap)Glide.with(context).load(persistable).asBitmap().imageDecoder(getArgb8888Decoder(context)).fitCenter().into(i, j).get();
_L2:
        return persistable;
        context;
_L3:
        GLogger.ex(TAG, "An unexpected exception occurred while loading bitmap.", context);
        persistable = obj;
        if (context.getCause() == null) goto _L2; else goto _L1
_L1:
        GLogger.ex(TAG, "Caused by:", context.getCause());
        return null;
        context;
          goto _L3
    }

    public static void loadFullQualityImage(Context context, MediaItem mediaitem, ImageView imageview, int i, int j)
    {
        BitmapRequestBuilder bitmaprequestbuilder = Glide.with(context).load(mediaitem).asBitmap().fitCenter().placeholder(imageview.getDrawable()).signature(new StringSignature(mediaitem.getObjectId().toString())).format(DecodeFormat.PREFER_ARGB_8888);
        BitmapResizer.overrideSizeToGlideBuilder(i, j, mediaitem, android.widget.ImageView.ScaleType.FIT_CENTER, bitmaprequestbuilder);
        bitmaprequestbuilder.into(new TransitionImageViewTarget(context, imageview));
    }

    public static void loadImage(Persistable persistable, ImageView imageview, RequestListener requestlistener, GenericRequestBuilder genericrequestbuilder, boolean flag, int i, ItemViewFactory itemviewfactory)
    {
        persistable = getRequestBuilder(persistable, imageview, flag, i, itemviewfactory);
        imageview = getLoadTarget(imageview);
        persistable = persistable.thumbnail(genericrequestbuilder).listener(requestlistener);
        if (itemviewfactory != null)
        {
            i = itemviewfactory.getPlaceholderResourceId();
        } else
        {
            i = ItemViewFactory.PLACEHOLDER_DEFAULT;
        }
        persistable.placeholder(i).into(imageview);
    }

    static 
    {
        pngEncoder = new BitmapEncoder(android.graphics.Bitmap.CompressFormat.PNG, 100);
    }
}
