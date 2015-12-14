// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.manager.RequestTracker;
import com.bumptech.glide.signature.ApplicationVersionSignature;
import com.bumptech.glide.util.Util;
import java.io.File;

// Referenced classes of package com.bumptech.glide:
//            Glide, DrawableTypeRequest, GenericRequestBuilder, GenericTranscodeRequest

public class RequestManager
    implements LifecycleListener
{
    public static interface DefaultOptions
    {

        public abstract void apply(GenericRequestBuilder genericrequestbuilder);
    }

    public final class GenericModelRequest
    {

        private final Class dataClass;
        private final ModelLoader modelLoader;
        final RequestManager this$0;

        public GenericTypeRequest load(Object obj)
        {
            return new GenericTypeRequest(obj);
        }



        GenericModelRequest(ModelLoader modelloader, Class class1)
        {
            this$0 = RequestManager.this;
            super();
            modelLoader = modelloader;
            dataClass = class1;
        }
    }

    public final class GenericModelRequest.GenericTypeRequest
    {

        private final Object model;
        private final Class modelClass;
        private final boolean providedModel = true;
        final GenericModelRequest this$1;

        public GenericTranscodeRequest as(Class class1)
        {
            class1 = (GenericTranscodeRequest)optionsApplier.apply(new GenericTranscodeRequest(context, glide, modelClass, modelLoader, dataClass, class1, requestTracker, lifecycle, optionsApplier));
            if (providedModel)
            {
                class1.load(model);
            }
            return class1;
        }

        GenericModelRequest.GenericTypeRequest(Object obj)
        {
            this$1 = GenericModelRequest.this;
            super();
            model = obj;
            modelClass = RequestManager.getSafeClass(obj);
        }
    }

    class OptionsApplier
    {

        final RequestManager this$0;

        public GenericRequestBuilder apply(GenericRequestBuilder genericrequestbuilder)
        {
            if (options != null)
            {
                options.apply(genericrequestbuilder);
            }
            return genericrequestbuilder;
        }

        OptionsApplier()
        {
            this$0 = RequestManager.this;
            super();
        }
    }

    private static class RequestManagerConnectivityListener
        implements com.bumptech.glide.manager.ConnectivityMonitor.ConnectivityListener
    {

        private final RequestTracker requestTracker;

        public void onConnectivityChanged(boolean flag)
        {
            if (flag)
            {
                requestTracker.restartRequests();
            }
        }

        public RequestManagerConnectivityListener(RequestTracker requesttracker)
        {
            requestTracker = requesttracker;
        }
    }


    private final Context context;
    private final Glide glide;
    private final Lifecycle lifecycle;
    private DefaultOptions options;
    private final OptionsApplier optionsApplier;
    private final RequestTracker requestTracker;

    public RequestManager(Context context1, Lifecycle lifecycle1)
    {
        this(context1, lifecycle1, new RequestTracker(), new ConnectivityMonitorFactory());
    }

    RequestManager(Context context1, final Lifecycle lifecycle, RequestTracker requesttracker, ConnectivityMonitorFactory connectivitymonitorfactory)
    {
        context = context1.getApplicationContext();
        this.lifecycle = lifecycle;
        requestTracker = requesttracker;
        glide = Glide.get(context1);
        optionsApplier = new OptionsApplier();
        context1 = connectivitymonitorfactory.build(context1, new RequestManagerConnectivityListener(requesttracker));
        if (Util.isOnBackgroundThread())
        {
            (new Handler(Looper.getMainLooper())).post(new Runnable() {

                final RequestManager this$0;
                final Lifecycle val$lifecycle;

                public void run()
                {
                    lifecycle.addListener(RequestManager.this);
                }

            
            {
                this$0 = RequestManager.this;
                lifecycle = lifecycle1;
                super();
            }
            });
        } else
        {
            lifecycle.addListener(this);
        }
        lifecycle.addListener(context1);
    }

    private static Class getSafeClass(Object obj)
    {
        if (obj != null)
        {
            return obj.getClass();
        } else
        {
            return null;
        }
    }

    private DrawableTypeRequest loadGeneric(Class class1)
    {
        ModelLoader modelloader = Glide.buildStreamModelLoader(class1, context);
        ModelLoader modelloader1 = Glide.buildFileDescriptorModelLoader(class1, context);
        if (class1 != null && modelloader == null && modelloader1 == null)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Unknown type ").append(class1).append(". You must provide a Model of a type for").append(" which there is a registered ModelLoader, if you are using a custom model, you must first call").append(" Glide#register with a ModelLoaderFactory for your custom model class").toString());
        } else
        {
            return (DrawableTypeRequest)optionsApplier.apply(new DrawableTypeRequest(class1, modelloader, modelloader1, context, glide, requestTracker, lifecycle, optionsApplier));
        }
    }

    public DrawableTypeRequest from(Class class1)
    {
        return loadGeneric(class1);
    }

    public DrawableTypeRequest fromFile()
    {
        return loadGeneric(java/io/File);
    }

    public DrawableTypeRequest fromResource()
    {
        return (DrawableTypeRequest)loadGeneric(java/lang/Integer).signature(ApplicationVersionSignature.obtain(context));
    }

    public DrawableTypeRequest fromString()
    {
        return loadGeneric(java/lang/String);
    }

    public DrawableTypeRequest fromUri()
    {
        return loadGeneric(android/net/Uri);
    }

    public DrawableTypeRequest load(Uri uri)
    {
        return (DrawableTypeRequest)fromUri().load(uri);
    }

    public DrawableTypeRequest load(File file)
    {
        return (DrawableTypeRequest)fromFile().load(file);
    }

    public DrawableTypeRequest load(Integer integer)
    {
        return (DrawableTypeRequest)fromResource().load(integer);
    }

    public DrawableTypeRequest load(Object obj)
    {
        return (DrawableTypeRequest)loadGeneric(getSafeClass(obj)).load(obj);
    }

    public DrawableTypeRequest load(String s)
    {
        return (DrawableTypeRequest)fromString().load(s);
    }

    public void onDestroy()
    {
        requestTracker.clearRequests();
    }

    public void onLowMemory()
    {
        glide.clearMemory();
    }

    public void onStart()
    {
        resumeRequests();
    }

    public void onStop()
    {
        pauseRequests();
    }

    public void onTrimMemory(int i)
    {
        glide.trimMemory(i);
    }

    public void pauseRequests()
    {
        Util.assertMainThread();
        requestTracker.pauseRequests();
    }

    public void resumeRequests()
    {
        Util.assertMainThread();
        requestTracker.resumeRequests();
    }

    public GenericModelRequest using(ModelLoader modelloader, Class class1)
    {
        return new GenericModelRequest(modelloader, class1);
    }







}
