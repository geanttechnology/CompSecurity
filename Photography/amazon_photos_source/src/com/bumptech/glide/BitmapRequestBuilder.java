// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.FileDescriptorBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.ImageVideoBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.StreamBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.VideoBitmapDecoder;
import com.bumptech.glide.load.resource.file.FileToStreamDecoder;
import com.bumptech.glide.provider.LoadProvider;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

// Referenced classes of package com.bumptech.glide:
//            GenericRequestBuilder, Glide

public class BitmapRequestBuilder extends GenericRequestBuilder
{

    private final BitmapPool bitmapPool;
    private DecodeFormat decodeFormat;
    private Downsampler downsampler;
    private ResourceDecoder imageDecoder;
    private ResourceDecoder videoDecoder;

    BitmapRequestBuilder(LoadProvider loadprovider, Class class1, GenericRequestBuilder genericrequestbuilder)
    {
        super(loadprovider, class1, genericrequestbuilder);
        downsampler = Downsampler.AT_LEAST;
        bitmapPool = genericrequestbuilder.glide.getBitmapPool();
        decodeFormat = genericrequestbuilder.glide.getDecodeFormat();
        imageDecoder = new StreamBitmapDecoder(bitmapPool, decodeFormat);
        videoDecoder = new FileDescriptorBitmapDecoder(bitmapPool, decodeFormat);
    }

    public BitmapRequestBuilder animate(int i)
    {
        super.animate(i);
        return this;
    }

    public volatile GenericRequestBuilder animate(int i)
    {
        return animate(i);
    }

    void applyCenterCrop()
    {
        centerCrop();
    }

    void applyFitCenter()
    {
        fitCenter();
    }

    public BitmapRequestBuilder cacheDecoder(ResourceDecoder resourcedecoder)
    {
        super.cacheDecoder(resourcedecoder);
        return this;
    }

    public volatile GenericRequestBuilder cacheDecoder(ResourceDecoder resourcedecoder)
    {
        return cacheDecoder(resourcedecoder);
    }

    public BitmapRequestBuilder centerCrop()
    {
        return transform(new BitmapTransformation[] {
            glide.getBitmapCenterCrop()
        });
    }

    public BitmapRequestBuilder clone()
    {
        return (BitmapRequestBuilder)super.clone();
    }

    public volatile GenericRequestBuilder clone()
    {
        return clone();
    }

    public volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    public BitmapRequestBuilder decoder(ResourceDecoder resourcedecoder)
    {
        super.decoder(resourcedecoder);
        return this;
    }

    public volatile GenericRequestBuilder decoder(ResourceDecoder resourcedecoder)
    {
        return decoder(resourcedecoder);
    }

    public BitmapRequestBuilder diskCacheStrategy(DiskCacheStrategy diskcachestrategy)
    {
        super.diskCacheStrategy(diskcachestrategy);
        return this;
    }

    public volatile GenericRequestBuilder diskCacheStrategy(DiskCacheStrategy diskcachestrategy)
    {
        return diskCacheStrategy(diskcachestrategy);
    }

    public BitmapRequestBuilder encoder(ResourceEncoder resourceencoder)
    {
        super.encoder(resourceencoder);
        return this;
    }

    public volatile GenericRequestBuilder encoder(ResourceEncoder resourceencoder)
    {
        return encoder(resourceencoder);
    }

    public BitmapRequestBuilder fitCenter()
    {
        return transform(new BitmapTransformation[] {
            glide.getBitmapFitCenter()
        });
    }

    public BitmapRequestBuilder format(DecodeFormat decodeformat)
    {
        decodeFormat = decodeformat;
        imageDecoder = new StreamBitmapDecoder(downsampler, bitmapPool, decodeformat);
        videoDecoder = new FileDescriptorBitmapDecoder(new VideoBitmapDecoder(), bitmapPool, decodeformat);
        super.cacheDecoder(new FileToStreamDecoder(new StreamBitmapDecoder(downsampler, bitmapPool, decodeformat)));
        super.decoder(new ImageVideoBitmapDecoder(imageDecoder, videoDecoder));
        return this;
    }

    public BitmapRequestBuilder imageDecoder(ResourceDecoder resourcedecoder)
    {
        imageDecoder = resourcedecoder;
        super.decoder(new ImageVideoBitmapDecoder(resourcedecoder, videoDecoder));
        return this;
    }

    public Target into(ImageView imageview)
    {
        return super.into(imageview);
    }

    public BitmapRequestBuilder listener(RequestListener requestlistener)
    {
        super.listener(requestlistener);
        return this;
    }

    public volatile GenericRequestBuilder listener(RequestListener requestlistener)
    {
        return listener(requestlistener);
    }

    public BitmapRequestBuilder load(Object obj)
    {
        super.load(obj);
        return this;
    }

    public volatile GenericRequestBuilder load(Object obj)
    {
        return load(obj);
    }

    public BitmapRequestBuilder override(int i, int j)
    {
        super.override(i, j);
        return this;
    }

    public volatile GenericRequestBuilder override(int i, int j)
    {
        return override(i, j);
    }

    public BitmapRequestBuilder placeholder(int i)
    {
        super.placeholder(i);
        return this;
    }

    public BitmapRequestBuilder placeholder(Drawable drawable)
    {
        super.placeholder(drawable);
        return this;
    }

    public volatile GenericRequestBuilder placeholder(int i)
    {
        return placeholder(i);
    }

    public volatile GenericRequestBuilder placeholder(Drawable drawable)
    {
        return placeholder(drawable);
    }

    public BitmapRequestBuilder signature(Key key)
    {
        super.signature(key);
        return this;
    }

    public volatile GenericRequestBuilder signature(Key key)
    {
        return signature(key);
    }

    public BitmapRequestBuilder skipMemoryCache(boolean flag)
    {
        super.skipMemoryCache(flag);
        return this;
    }

    public volatile GenericRequestBuilder skipMemoryCache(boolean flag)
    {
        return skipMemoryCache(flag);
    }

    public BitmapRequestBuilder sourceEncoder(Encoder encoder1)
    {
        super.sourceEncoder(encoder1);
        return this;
    }

    public volatile GenericRequestBuilder sourceEncoder(Encoder encoder1)
    {
        return sourceEncoder(encoder1);
    }

    public BitmapRequestBuilder thumbnail(GenericRequestBuilder genericrequestbuilder)
    {
        super.thumbnail(genericrequestbuilder);
        return this;
    }

    public volatile GenericRequestBuilder thumbnail(GenericRequestBuilder genericrequestbuilder)
    {
        return thumbnail(genericrequestbuilder);
    }

    public transient BitmapRequestBuilder transform(Transformation atransformation[])
    {
        super.transform(atransformation);
        return this;
    }

    public transient BitmapRequestBuilder transform(BitmapTransformation abitmaptransformation[])
    {
        super.transform(abitmaptransformation);
        return this;
    }

    public volatile GenericRequestBuilder transform(Transformation atransformation[])
    {
        return transform(atransformation);
    }
}
