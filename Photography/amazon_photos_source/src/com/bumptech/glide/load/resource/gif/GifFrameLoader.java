// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bumptech.glide.GenericRequestBuilder;
import com.bumptech.glide.GenericTranscodeRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.NullEncoder;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.UUID;

// Referenced classes of package com.bumptech.glide.load.resource.gif:
//            GifFrameResourceDecoder, GifFrameModelLoader

class GifFrameLoader
{
    static class DelayTarget extends SimpleTarget
    {

        private final Handler handler;
        private final int index;
        private Bitmap resource;
        private final long targetTime;

        public Bitmap getResource()
        {
            return resource;
        }

        public void onResourceReady(Bitmap bitmap, GlideAnimation glideanimation)
        {
            resource = bitmap;
            bitmap = handler.obtainMessage(1, this);
            handler.sendMessageAtTime(bitmap, targetTime);
        }

        public volatile void onResourceReady(Object obj, GlideAnimation glideanimation)
        {
            onResourceReady((Bitmap)obj, glideanimation);
        }


        public DelayTarget(Handler handler1, int i, long l)
        {
            handler = handler1;
            index = i;
            targetTime = l;
        }
    }

    public static interface FrameCallback
    {

        public abstract void onFrameReady(int i);
    }

    private class FrameLoaderCallback
        implements android.os.Handler.Callback
    {

        final GifFrameLoader this$0;

        public boolean handleMessage(Message message)
        {
            if (message.what == 1)
            {
                message = (DelayTarget)message.obj;
                onFrameReady(message);
                return true;
            }
            if (message.what == 2)
            {
                Glide.clear((DelayTarget)message.obj);
            }
            return false;
        }

        private FrameLoaderCallback()
        {
            this$0 = GifFrameLoader.this;
            super();
        }

    }

    static class FrameSignature
        implements Key
    {

        private final UUID uuid;

        public boolean equals(Object obj)
        {
            if (obj instanceof FrameSignature)
            {
                return ((FrameSignature)obj).uuid.equals(uuid);
            } else
            {
                return false;
            }
        }

        public int hashCode()
        {
            return uuid.hashCode();
        }

        public void updateDiskCacheKey(MessageDigest messagedigest)
            throws UnsupportedEncodingException
        {
            throw new UnsupportedOperationException("Not implemented");
        }

        public FrameSignature()
        {
            this(UUID.randomUUID());
        }

        FrameSignature(UUID uuid1)
        {
            uuid = uuid1;
        }
    }


    private final FrameCallback callback;
    private DelayTarget current;
    private final GifDecoder gifDecoder;
    private final Handler handler;
    private boolean isCleared;
    private boolean isLoadPending;
    private boolean isRunning;
    private GenericRequestBuilder requestBuilder;

    public GifFrameLoader(Context context, FrameCallback framecallback, GifDecoder gifdecoder, int i, int j)
    {
        this(framecallback, gifdecoder, null, getRequestBuilder(context, gifdecoder, i, j, Glide.get(context).getBitmapPool()));
    }

    GifFrameLoader(FrameCallback framecallback, GifDecoder gifdecoder, Handler handler1, GenericRequestBuilder genericrequestbuilder)
    {
        isRunning = false;
        isLoadPending = false;
        Handler handler2 = handler1;
        if (handler1 == null)
        {
            handler2 = new Handler(Looper.getMainLooper(), new FrameLoaderCallback());
        }
        callback = framecallback;
        gifDecoder = gifdecoder;
        handler = handler2;
        requestBuilder = genericrequestbuilder;
    }

    private static GenericRequestBuilder getRequestBuilder(Context context, GifDecoder gifdecoder, int i, int j, BitmapPool bitmappool)
    {
        bitmappool = new GifFrameResourceDecoder(bitmappool);
        GifFrameModelLoader gifframemodelloader = new GifFrameModelLoader();
        com.bumptech.glide.load.Encoder encoder = NullEncoder.get();
        return Glide.with(context).using(gifframemodelloader, com/bumptech/glide/gifdecoder/GifDecoder).load(gifdecoder).as(android/graphics/Bitmap).sourceEncoder(encoder).decoder(bitmappool).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).override(i, j);
    }

    private void loadNextFrame()
    {
        if (!isRunning || isLoadPending)
        {
            return;
        } else
        {
            isLoadPending = true;
            gifDecoder.advance();
            long l = SystemClock.uptimeMillis();
            long l1 = gifDecoder.getNextDelay();
            DelayTarget delaytarget = new DelayTarget(handler, gifDecoder.getCurrentFrameIndex(), l + l1);
            requestBuilder.signature(new FrameSignature()).into(delaytarget);
            return;
        }
    }

    public void clear()
    {
        stop();
        if (current != null)
        {
            Glide.clear(current);
            current = null;
        }
        isCleared = true;
    }

    public Bitmap getCurrentFrame()
    {
        if (current != null)
        {
            return current.getResource();
        } else
        {
            return null;
        }
    }

    void onFrameReady(DelayTarget delaytarget)
    {
        if (isCleared)
        {
            handler.obtainMessage(2, delaytarget).sendToTarget();
            return;
        }
        DelayTarget delaytarget1 = current;
        current = delaytarget;
        callback.onFrameReady(delaytarget.index);
        if (delaytarget1 != null)
        {
            handler.obtainMessage(2, delaytarget1).sendToTarget();
        }
        isLoadPending = false;
        loadNextFrame();
    }

    public void setFrameTransformation(Transformation transformation)
    {
        if (transformation == null)
        {
            throw new NullPointerException("Transformation must not be null");
        } else
        {
            requestBuilder = requestBuilder.transform(new Transformation[] {
                transformation
            });
            return;
        }
    }

    public void start()
    {
        if (isRunning)
        {
            return;
        } else
        {
            isRunning = true;
            isCleared = false;
            loadNextFrame();
            return;
        }
    }

    public void stop()
    {
        isRunning = false;
    }
}
