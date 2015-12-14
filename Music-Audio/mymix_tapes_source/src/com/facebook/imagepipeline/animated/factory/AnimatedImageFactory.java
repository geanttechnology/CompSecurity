// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.animated.factory;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.animated.base.AnimatedImageResultBuilder;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider;
import com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.gif.GifImage;
import com.facebook.imagepipeline.image.CloseableAnimatedImage;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.webp.WebPImage;
import java.util.ArrayList;
import java.util.List;

public class AnimatedImageFactory
{

    private final AnimatedDrawableBackendProvider mAnimatedDrawableBackendProvider;
    private final PlatformBitmapFactory mBitmapFactory;

    public AnimatedImageFactory(AnimatedDrawableBackendProvider animateddrawablebackendprovider, PlatformBitmapFactory platformbitmapfactory)
    {
        mAnimatedDrawableBackendProvider = animateddrawablebackendprovider;
        mBitmapFactory = platformbitmapfactory;
    }

    private CloseableReference createBitmap(int i, int j)
    {
        CloseableReference closeablereference = mBitmapFactory.createBitmap(i, j);
        ((Bitmap)closeablereference.get()).eraseColor(0);
        if (android.os.Build.VERSION.SDK_INT >= 12)
        {
            ((Bitmap)closeablereference.get()).setHasAlpha(true);
        }
        return closeablereference;
    }

    private CloseableReference createPreviewBitmap(AnimatedImage animatedimage, int i)
    {
        CloseableReference closeablereference = createBitmap(animatedimage.getWidth(), animatedimage.getHeight());
        animatedimage = AnimatedImageResult.forAnimatedImage(animatedimage);
        (new AnimatedImageCompositor(mAnimatedDrawableBackendProvider.get(animatedimage, null), new com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.Callback() {

            final AnimatedImageFactory this$0;

            public CloseableReference getCachedBitmap(int j)
            {
                return null;
            }

            public void onIntermediateResult(int j, Bitmap bitmap)
            {
            }

            
            {
                this$0 = AnimatedImageFactory.this;
                super();
            }
        })).renderFrame(i, (Bitmap)closeablereference.get());
        return closeablereference;
    }

    private List decodeAllFrames(AnimatedImage animatedimage)
    {
        final ArrayList bitmaps = new ArrayList();
        animatedimage = AnimatedImageResult.forAnimatedImage(animatedimage);
        animatedimage = mAnimatedDrawableBackendProvider.get(animatedimage, null);
        AnimatedImageCompositor animatedimagecompositor = new AnimatedImageCompositor(animatedimage, new com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.Callback() {

            final AnimatedImageFactory this$0;
            final List val$bitmaps;

            public CloseableReference getCachedBitmap(int j)
            {
                return CloseableReference.cloneOrNull((CloseableReference)bitmaps.get(j));
            }

            public void onIntermediateResult(int j, Bitmap bitmap)
            {
            }

            
            {
                this$0 = AnimatedImageFactory.this;
                bitmaps = list;
                super();
            }
        });
        for (int i = 0; i < animatedimage.getFrameCount(); i++)
        {
            CloseableReference closeablereference = createBitmap(animatedimage.getWidth(), animatedimage.getHeight());
            animatedimagecompositor.renderFrame(i, (Bitmap)closeablereference.get());
            bitmaps.add(closeablereference);
        }

        return bitmaps;
    }

    private CloseableAnimatedImage getCloseableImage(ImageDecodeOptions imagedecodeoptions, AnimatedImage animatedimage)
    {
        CloseableReference closeablereference;
        List list;
        CloseableReference closeablereference1;
        List list1;
        CloseableReference closeablereference2;
        Object obj;
        obj = null;
        list1 = null;
        closeablereference2 = null;
        closeablereference = null;
        list = obj;
        closeablereference1 = closeablereference2;
        if (!imagedecodeoptions.useLastFrameForPreview) goto _L2; else goto _L1
_L1:
        list = obj;
        closeablereference1 = closeablereference2;
        int i = animatedimage.getFrameCount() - 1;
_L4:
        list = obj;
        closeablereference1 = closeablereference2;
        if (!imagedecodeoptions.decodeAllFrames)
        {
            break MISSING_BLOCK_LABEL_98;
        }
        list = obj;
        closeablereference1 = closeablereference2;
        list1 = decodeAllFrames(animatedimage);
        list = list1;
        closeablereference1 = closeablereference2;
        closeablereference = CloseableReference.cloneOrNull((CloseableReference)list1.get(i));
        closeablereference2 = closeablereference;
        list = list1;
        closeablereference1 = closeablereference;
        if (!imagedecodeoptions.decodePreviewFrame)
        {
            break MISSING_BLOCK_LABEL_138;
        }
        closeablereference2 = closeablereference;
        if (closeablereference != null)
        {
            break MISSING_BLOCK_LABEL_138;
        }
        list = list1;
        closeablereference1 = closeablereference;
        closeablereference2 = createPreviewBitmap(animatedimage, i);
        list = list1;
        closeablereference1 = closeablereference2;
        imagedecodeoptions = new CloseableAnimatedImage(AnimatedImageResult.newBuilder(animatedimage).setPreviewBitmap(closeablereference2).setFrameForPreview(i).setDecodedFrames(list1).build());
        CloseableReference.closeSafely(closeablereference2);
        CloseableReference.closeSafely(list1);
        return imagedecodeoptions;
_L2:
        i = 0;
        if (true) goto _L4; else goto _L3
_L3:
        imagedecodeoptions;
        CloseableReference.closeSafely(closeablereference1);
        CloseableReference.closeSafely(list);
        throw imagedecodeoptions;
    }

    public CloseableImage decodeGif(EncodedImage encodedimage, ImageDecodeOptions imagedecodeoptions)
    {
        encodedimage = encodedimage.getByteBufferRef();
        Preconditions.checkNotNull(encodedimage);
        PooledByteBuffer pooledbytebuffer;
        boolean flag;
        if (!imagedecodeoptions.forceOldAnimationCode)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkState(flag);
        pooledbytebuffer = (PooledByteBuffer)encodedimage.get();
        imagedecodeoptions = getCloseableImage(imagedecodeoptions, GifImage.create(pooledbytebuffer.getNativePtr(), pooledbytebuffer.size()));
        CloseableReference.closeSafely(encodedimage);
        return imagedecodeoptions;
        imagedecodeoptions;
        CloseableReference.closeSafely(encodedimage);
        throw imagedecodeoptions;
    }

    public CloseableImage decodeWebP(EncodedImage encodedimage, ImageDecodeOptions imagedecodeoptions)
    {
        encodedimage = encodedimage.getByteBufferRef();
        Preconditions.checkNotNull(encodedimage);
        PooledByteBuffer pooledbytebuffer;
        boolean flag;
        if (!imagedecodeoptions.forceOldAnimationCode)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag);
        pooledbytebuffer = (PooledByteBuffer)encodedimage.get();
        imagedecodeoptions = getCloseableImage(imagedecodeoptions, WebPImage.create(pooledbytebuffer.getNativePtr(), pooledbytebuffer.size()));
        CloseableReference.closeSafely(encodedimage);
        return imagedecodeoptions;
        imagedecodeoptions;
        CloseableReference.closeSafely(encodedimage);
        throw imagedecodeoptions;
    }
}
