// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.widget.ImageView;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.UnitTransformation;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.RequestTracker;
import com.bumptech.glide.provider.ChildLoadProvider;
import com.bumptech.glide.provider.LoadProvider;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.GenericRequest;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestCoordinator;
import com.bumptech.glide.request.RequestFutureTarget;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.ThumbnailRequestCoordinator;
import com.bumptech.glide.request.animation.GlideAnimationFactory;
import com.bumptech.glide.request.animation.NoAnimation;
import com.bumptech.glide.request.animation.ViewAnimationFactory;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.signature.EmptySignature;
import com.bumptech.glide.util.Util;

// Referenced classes of package com.bumptech.glide:
//            Priority, Glide

public class GenericRequestBuilder
    implements Cloneable
{

    private GlideAnimationFactory animationFactory;
    protected final Context context;
    private DiskCacheStrategy diskCacheStrategy;
    private int errorId;
    private Drawable errorPlaceholder;
    protected final Glide glide;
    private boolean isCacheable;
    private boolean isModelSet;
    private boolean isThumbnailBuilt;
    private boolean isTransformationSet;
    protected final Lifecycle lifecycle;
    private ChildLoadProvider loadProvider;
    private Object model;
    protected final Class modelClass;
    private int overrideHeight;
    private int overrideWidth;
    private Drawable placeholderDrawable;
    private int placeholderId;
    private Priority priority;
    private RequestListener requestListener;
    protected final RequestTracker requestTracker;
    private Key signature;
    private Float sizeMultiplier;
    private Float thumbSizeMultiplier;
    private GenericRequestBuilder thumbnailRequestBuilder;
    protected final Class transcodeClass;
    private Transformation transformation;

    GenericRequestBuilder(Context context1, Class class1, LoadProvider loadprovider, Class class2, Glide glide1, RequestTracker requesttracker, Lifecycle lifecycle1)
    {
        Object obj = null;
        super();
        signature = EmptySignature.obtain();
        sizeMultiplier = Float.valueOf(1.0F);
        priority = null;
        isCacheable = true;
        animationFactory = NoAnimation.getFactory();
        overrideHeight = -1;
        overrideWidth = -1;
        diskCacheStrategy = DiskCacheStrategy.RESULT;
        transformation = UnitTransformation.get();
        context = context1;
        modelClass = class1;
        transcodeClass = class2;
        glide = glide1;
        requestTracker = requesttracker;
        lifecycle = lifecycle1;
        class2 = obj;
        if (loadprovider != null)
        {
            class2 = new ChildLoadProvider(loadprovider);
        }
        loadProvider = class2;
        if (context1 == null)
        {
            throw new NullPointerException("Context can't be null");
        }
        if (class1 != null && loadprovider == null)
        {
            throw new NullPointerException("LoadProvider must not be null");
        } else
        {
            return;
        }
    }

    GenericRequestBuilder(LoadProvider loadprovider, Class class1, GenericRequestBuilder genericrequestbuilder)
    {
        this(genericrequestbuilder.context, genericrequestbuilder.modelClass, loadprovider, class1, genericrequestbuilder.glide, genericrequestbuilder.requestTracker, genericrequestbuilder.lifecycle);
        model = genericrequestbuilder.model;
        isModelSet = genericrequestbuilder.isModelSet;
        signature = genericrequestbuilder.signature;
        diskCacheStrategy = genericrequestbuilder.diskCacheStrategy;
        isCacheable = genericrequestbuilder.isCacheable;
    }

    private Request buildRequest(Target target)
    {
        if (priority == null)
        {
            priority = Priority.NORMAL;
        }
        isThumbnailBuilt = false;
        return buildRequestRecursive(target, null);
    }

    private Request buildRequestRecursive(Target target, ThumbnailRequestCoordinator thumbnailrequestcoordinator)
    {
        if (thumbnailRequestBuilder != null)
        {
            if (isThumbnailBuilt)
            {
                throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
            }
            if (thumbnailRequestBuilder.animationFactory.equals(NoAnimation.getFactory()))
            {
                thumbnailRequestBuilder.animationFactory = animationFactory;
            }
            if (thumbnailRequestBuilder.priority == null)
            {
                thumbnailRequestBuilder.priority = getThumbnailPriority();
            }
            if (Util.isValidDimensions(overrideWidth, overrideHeight) && !Util.isValidDimensions(thumbnailRequestBuilder.overrideWidth, thumbnailRequestBuilder.overrideHeight))
            {
                thumbnailRequestBuilder.override(overrideWidth, overrideHeight);
            }
            thumbnailrequestcoordinator = new ThumbnailRequestCoordinator(thumbnailrequestcoordinator);
            Request request = obtainRequest(target, sizeMultiplier.floatValue(), priority, thumbnailrequestcoordinator);
            isThumbnailBuilt = true;
            thumbnailrequestcoordinator.setRequests(request, thumbnailRequestBuilder.buildRequestRecursive(target, thumbnailrequestcoordinator));
            return thumbnailrequestcoordinator;
        }
        if (thumbSizeMultiplier != null)
        {
            thumbnailrequestcoordinator = new ThumbnailRequestCoordinator(thumbnailrequestcoordinator);
            thumbnailrequestcoordinator.setRequests(obtainRequest(target, sizeMultiplier.floatValue(), priority, thumbnailrequestcoordinator), obtainRequest(target, thumbSizeMultiplier.floatValue(), getThumbnailPriority(), thumbnailrequestcoordinator));
            return thumbnailrequestcoordinator;
        } else
        {
            return obtainRequest(target, sizeMultiplier.floatValue(), priority, thumbnailrequestcoordinator);
        }
    }

    private Priority getThumbnailPriority()
    {
        if (priority == Priority.LOW)
        {
            return Priority.NORMAL;
        }
        if (priority == Priority.NORMAL)
        {
            return Priority.HIGH;
        } else
        {
            return Priority.IMMEDIATE;
        }
    }

    private Request obtainRequest(Target target, float f, Priority priority1, RequestCoordinator requestcoordinator)
    {
        return GenericRequest.obtain(loadProvider, model, signature, context, priority1, target, f, placeholderDrawable, placeholderId, errorPlaceholder, errorId, requestListener, requestcoordinator, glide.getEngine(), transformation, transcodeClass, isCacheable, animationFactory, overrideWidth, overrideHeight, diskCacheStrategy);
    }

    public GenericRequestBuilder animate(int i)
    {
        return animate(((GlideAnimationFactory) (new ViewAnimationFactory(context, i))));
    }

    GenericRequestBuilder animate(GlideAnimationFactory glideanimationfactory)
    {
        if (glideanimationfactory == null)
        {
            throw new NullPointerException("Animation factory must not be null!");
        } else
        {
            animationFactory = glideanimationfactory;
            return this;
        }
    }

    void applyCenterCrop()
    {
    }

    void applyFitCenter()
    {
    }

    public GenericRequestBuilder cacheDecoder(ResourceDecoder resourcedecoder)
    {
        if (loadProvider != null)
        {
            loadProvider.setCacheDecoder(resourcedecoder);
        }
        return this;
    }

    public GenericRequestBuilder clone()
    {
        ChildLoadProvider childloadprovider;
        GenericRequestBuilder genericrequestbuilder;
        genericrequestbuilder = (GenericRequestBuilder)super.clone();
        if (loadProvider == null)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        childloadprovider = loadProvider.clone();
_L1:
        genericrequestbuilder.loadProvider = childloadprovider;
        return genericrequestbuilder;
        childloadprovider = null;
          goto _L1
        CloneNotSupportedException clonenotsupportedexception;
        clonenotsupportedexception;
        throw new RuntimeException(clonenotsupportedexception);
    }

    public volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    public GenericRequestBuilder decoder(ResourceDecoder resourcedecoder)
    {
        if (loadProvider != null)
        {
            loadProvider.setSourceDecoder(resourcedecoder);
        }
        return this;
    }

    public GenericRequestBuilder diskCacheStrategy(DiskCacheStrategy diskcachestrategy)
    {
        diskCacheStrategy = diskcachestrategy;
        return this;
    }

    public GenericRequestBuilder encoder(ResourceEncoder resourceencoder)
    {
        if (loadProvider != null)
        {
            loadProvider.setEncoder(resourceencoder);
        }
        return this;
    }

    public FutureTarget into(int i, int j)
    {
        final RequestFutureTarget target = new RequestFutureTarget(glide.getMainHandler(), i, j);
        glide.getMainHandler().post(new Runnable() {

            final GenericRequestBuilder this$0;
            final RequestFutureTarget val$target;

            public void run()
            {
                if (!target.isCancelled())
                {
                    into(target);
                }
            }

            
            {
                this$0 = GenericRequestBuilder.this;
                target = requestfuturetarget;
                super();
            }
        });
        return target;
    }

    public Target into(ImageView imageview)
    {
        Util.assertMainThread();
        if (imageview == null)
        {
            throw new IllegalArgumentException("You must pass in a non null View");
        }
        if (isTransformationSet || imageview.getScaleType() == null) goto _L2; else goto _L1
_L1:
        static class _cls2
        {

            static final int $SwitchMap$android$widget$ImageView$ScaleType[];

            static 
            {
                $SwitchMap$android$widget$ImageView$ScaleType = new int[android.widget.ImageView.ScaleType.values().length];
                try
                {
                    $SwitchMap$android$widget$ImageView$ScaleType[android.widget.ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$android$widget$ImageView$ScaleType[android.widget.ImageView.ScaleType.FIT_CENTER.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$android$widget$ImageView$ScaleType[android.widget.ImageView.ScaleType.FIT_START.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$android$widget$ImageView$ScaleType[android.widget.ImageView.ScaleType.FIT_END.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls2..SwitchMap.android.widget.ImageView.ScaleType[imageview.getScaleType().ordinal()];
        JVM INSTR tableswitch 1 4: default 72
    //                   1 89
    //                   2 96
    //                   3 96
    //                   4 96;
           goto _L2 _L3 _L4 _L4 _L4
_L2:
        return into(glide.buildImageViewTarget(imageview, transcodeClass));
_L3:
        applyCenterCrop();
        continue; /* Loop/switch isn't completed */
_L4:
        applyFitCenter();
        if (true) goto _L2; else goto _L5
_L5:
    }

    public Target into(Target target)
    {
        Util.assertMainThread();
        if (target == null)
        {
            throw new IllegalArgumentException("You must pass in a non null Target");
        }
        if (!isModelSet)
        {
            throw new IllegalArgumentException("You must first set a model (try #load())");
        }
        Request request = target.getRequest();
        if (request != null)
        {
            request.clear();
            requestTracker.removeRequest(request);
            request.recycle();
        }
        request = buildRequest(target);
        target.setRequest(request);
        lifecycle.addListener(target);
        requestTracker.runRequest(request);
        return target;
    }

    public GenericRequestBuilder listener(RequestListener requestlistener)
    {
        requestListener = requestlistener;
        return this;
    }

    public GenericRequestBuilder load(Object obj)
    {
        model = obj;
        isModelSet = true;
        return this;
    }

    public GenericRequestBuilder override(int i, int j)
    {
        if (!Util.isValidDimensions(i, j))
        {
            throw new IllegalArgumentException("Width and height must be Target#SIZE_ORIGINAL or > 0");
        } else
        {
            overrideWidth = i;
            overrideHeight = j;
            return this;
        }
    }

    public GenericRequestBuilder placeholder(int i)
    {
        placeholderId = i;
        return this;
    }

    public GenericRequestBuilder placeholder(Drawable drawable)
    {
        placeholderDrawable = drawable;
        return this;
    }

    public GenericRequestBuilder signature(Key key)
    {
        if (key == null)
        {
            throw new NullPointerException("Signature must not be null");
        } else
        {
            signature = key;
            return this;
        }
    }

    public GenericRequestBuilder skipMemoryCache(boolean flag)
    {
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isCacheable = flag;
        return this;
    }

    public GenericRequestBuilder sourceEncoder(Encoder encoder1)
    {
        if (loadProvider != null)
        {
            loadProvider.setSourceEncoder(encoder1);
        }
        return this;
    }

    public GenericRequestBuilder thumbnail(GenericRequestBuilder genericrequestbuilder)
    {
        if (equals(genericrequestbuilder))
        {
            throw new IllegalArgumentException("You cannot set a request as a thumbnail for itself. Consider using clone() on the request you are passing to thumbnail()");
        } else
        {
            thumbnailRequestBuilder = genericrequestbuilder;
            return this;
        }
    }

    public transient GenericRequestBuilder transform(Transformation atransformation[])
    {
        isTransformationSet = true;
        if (atransformation.length == 1)
        {
            transformation = atransformation[0];
            return this;
        } else
        {
            transformation = new MultiTransformation(atransformation);
            return this;
        }
    }
}
