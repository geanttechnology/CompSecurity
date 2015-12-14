// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.RequestTracker;
import com.bumptech.glide.provider.LoadProvider;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.animation.DrawableCrossFadeFactory;
import com.bumptech.glide.request.target.Target;

// Referenced classes of package com.bumptech.glide:
//            GenericRequestBuilder, Glide

public class DrawableRequestBuilder extends GenericRequestBuilder
{

    DrawableRequestBuilder(Context context, Class class1, LoadProvider loadprovider, Glide glide, RequestTracker requesttracker, Lifecycle lifecycle)
    {
        super(context, class1, loadprovider, com/bumptech/glide/load/resource/drawable/GlideDrawable, glide, requesttracker, lifecycle);
        crossFade();
    }

    public DrawableRequestBuilder animate(int i)
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

    public DrawableRequestBuilder cacheDecoder(ResourceDecoder resourcedecoder)
    {
        super.cacheDecoder(resourcedecoder);
        return this;
    }

    public volatile GenericRequestBuilder cacheDecoder(ResourceDecoder resourcedecoder)
    {
        return cacheDecoder(resourcedecoder);
    }

    public DrawableRequestBuilder centerCrop()
    {
        return transform(new Transformation[] {
            glide.getDrawableCenterCrop()
        });
    }

    public DrawableRequestBuilder clone()
    {
        return (DrawableRequestBuilder)super.clone();
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

    public final DrawableRequestBuilder crossFade()
    {
        super.animate(new DrawableCrossFadeFactory());
        return this;
    }

    public DrawableRequestBuilder decoder(ResourceDecoder resourcedecoder)
    {
        super.decoder(resourcedecoder);
        return this;
    }

    public volatile GenericRequestBuilder decoder(ResourceDecoder resourcedecoder)
    {
        return decoder(resourcedecoder);
    }

    public DrawableRequestBuilder diskCacheStrategy(DiskCacheStrategy diskcachestrategy)
    {
        super.diskCacheStrategy(diskcachestrategy);
        return this;
    }

    public volatile GenericRequestBuilder diskCacheStrategy(DiskCacheStrategy diskcachestrategy)
    {
        return diskCacheStrategy(diskcachestrategy);
    }

    public DrawableRequestBuilder encoder(ResourceEncoder resourceencoder)
    {
        super.encoder(resourceencoder);
        return this;
    }

    public volatile GenericRequestBuilder encoder(ResourceEncoder resourceencoder)
    {
        return encoder(resourceencoder);
    }

    public DrawableRequestBuilder fitCenter()
    {
        return transform(new Transformation[] {
            glide.getDrawableFitCenter()
        });
    }

    public Target into(ImageView imageview)
    {
        return super.into(imageview);
    }

    public DrawableRequestBuilder listener(RequestListener requestlistener)
    {
        super.listener(requestlistener);
        return this;
    }

    public volatile GenericRequestBuilder listener(RequestListener requestlistener)
    {
        return listener(requestlistener);
    }

    public DrawableRequestBuilder load(Object obj)
    {
        super.load(obj);
        return this;
    }

    public volatile GenericRequestBuilder load(Object obj)
    {
        return load(obj);
    }

    public DrawableRequestBuilder override(int i, int j)
    {
        super.override(i, j);
        return this;
    }

    public volatile GenericRequestBuilder override(int i, int j)
    {
        return override(i, j);
    }

    public DrawableRequestBuilder placeholder(int i)
    {
        super.placeholder(i);
        return this;
    }

    public DrawableRequestBuilder placeholder(Drawable drawable)
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

    public DrawableRequestBuilder signature(Key key)
    {
        super.signature(key);
        return this;
    }

    public volatile GenericRequestBuilder signature(Key key)
    {
        return signature(key);
    }

    public DrawableRequestBuilder skipMemoryCache(boolean flag)
    {
        super.skipMemoryCache(flag);
        return this;
    }

    public volatile GenericRequestBuilder skipMemoryCache(boolean flag)
    {
        return skipMemoryCache(flag);
    }

    public DrawableRequestBuilder sourceEncoder(Encoder encoder1)
    {
        super.sourceEncoder(encoder1);
        return this;
    }

    public volatile GenericRequestBuilder sourceEncoder(Encoder encoder1)
    {
        return sourceEncoder(encoder1);
    }

    public DrawableRequestBuilder thumbnail(GenericRequestBuilder genericrequestbuilder)
    {
        super.thumbnail(genericrequestbuilder);
        return this;
    }

    public volatile GenericRequestBuilder thumbnail(GenericRequestBuilder genericrequestbuilder)
    {
        return thumbnail(genericrequestbuilder);
    }

    public transient DrawableRequestBuilder transform(Transformation atransformation[])
    {
        super.transform(atransformation);
        return this;
    }

    public volatile GenericRequestBuilder transform(Transformation atransformation[])
    {
        return transform(atransformation);
    }
}
