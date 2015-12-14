// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.request;

import android.net.Uri;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.ResizeOptions;
import java.io.File;

// Referenced classes of package com.facebook.imagepipeline.request:
//            ImageRequestBuilder, Postprocessor

public class ImageRequest
{
    public static final class ImageType extends Enum
    {

        private static final ImageType $VALUES[];
        public static final ImageType DEFAULT;
        public static final ImageType SMALL;

        public static ImageType valueOf(String s)
        {
            return (ImageType)Enum.valueOf(com/facebook/imagepipeline/request/ImageRequest$ImageType, s);
        }

        public static ImageType[] values()
        {
            return (ImageType[])$VALUES.clone();
        }

        static 
        {
            SMALL = new ImageType("SMALL", 0);
            DEFAULT = new ImageType("DEFAULT", 1);
            $VALUES = (new ImageType[] {
                SMALL, DEFAULT
            });
        }

        private ImageType(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class RequestLevel extends Enum
    {

        private static final RequestLevel $VALUES[];
        public static final RequestLevel BITMAP_MEMORY_CACHE;
        public static final RequestLevel DISK_CACHE;
        public static final RequestLevel ENCODED_MEMORY_CACHE;
        public static final RequestLevel FULL_FETCH;
        private int mValue;

        public static RequestLevel getMax(RequestLevel requestlevel, RequestLevel requestlevel1)
        {
            if (requestlevel.getValue() > requestlevel1.getValue())
            {
                return requestlevel;
            } else
            {
                return requestlevel1;
            }
        }

        public static RequestLevel valueOf(String s)
        {
            return (RequestLevel)Enum.valueOf(com/facebook/imagepipeline/request/ImageRequest$RequestLevel, s);
        }

        public static RequestLevel[] values()
        {
            return (RequestLevel[])$VALUES.clone();
        }

        public int getValue()
        {
            return mValue;
        }

        static 
        {
            FULL_FETCH = new RequestLevel("FULL_FETCH", 0, 1);
            DISK_CACHE = new RequestLevel("DISK_CACHE", 1, 2);
            ENCODED_MEMORY_CACHE = new RequestLevel("ENCODED_MEMORY_CACHE", 2, 3);
            BITMAP_MEMORY_CACHE = new RequestLevel("BITMAP_MEMORY_CACHE", 3, 4);
            $VALUES = (new RequestLevel[] {
                FULL_FETCH, DISK_CACHE, ENCODED_MEMORY_CACHE, BITMAP_MEMORY_CACHE
            });
        }

        private RequestLevel(String s, int i, int j)
        {
            super(s, i);
            mValue = j;
        }
    }


    private final boolean mAutoRotateEnabled;
    private final ImageDecodeOptions mImageDecodeOptions;
    private final ImageType mImageType;
    private final boolean mIsDiskCacheEnabled;
    private final boolean mLocalThumbnailPreviewsEnabled;
    private final RequestLevel mLowestPermittedRequestLevel;
    private final Postprocessor mPostprocessor;
    private final boolean mProgressiveRenderingEnabled;
    private final Priority mRequestPriority;
    ResizeOptions mResizeOptions;
    private File mSourceFile;
    private final Uri mSourceUri;

    protected ImageRequest(ImageRequestBuilder imagerequestbuilder)
    {
        mResizeOptions = null;
        mImageType = imagerequestbuilder.getImageType();
        mSourceUri = imagerequestbuilder.getSourceUri();
        mProgressiveRenderingEnabled = imagerequestbuilder.isProgressiveRenderingEnabled();
        mLocalThumbnailPreviewsEnabled = imagerequestbuilder.isLocalThumbnailPreviewsEnabled();
        mImageDecodeOptions = imagerequestbuilder.getImageDecodeOptions();
        mResizeOptions = imagerequestbuilder.getResizeOptions();
        mAutoRotateEnabled = imagerequestbuilder.isAutoRotateEnabled();
        mRequestPriority = imagerequestbuilder.getRequestPriority();
        mLowestPermittedRequestLevel = imagerequestbuilder.getLowestPermittedRequestLevel();
        mIsDiskCacheEnabled = imagerequestbuilder.isDiskCacheEnabled();
        mPostprocessor = imagerequestbuilder.getPostprocessor();
    }

    public static ImageRequest fromUri(Uri uri)
    {
        if (uri == null)
        {
            return null;
        } else
        {
            return ImageRequestBuilder.newBuilderWithSource(uri).build();
        }
    }

    public static ImageRequest fromUri(String s)
    {
        if (s == null || s.length() == 0)
        {
            return null;
        } else
        {
            return fromUri(Uri.parse(s));
        }
    }

    public boolean getAutoRotateEnabled()
    {
        return mAutoRotateEnabled;
    }

    public ImageDecodeOptions getImageDecodeOptions()
    {
        return mImageDecodeOptions;
    }

    public ImageType getImageType()
    {
        return mImageType;
    }

    public boolean getLocalThumbnailPreviewsEnabled()
    {
        return mLocalThumbnailPreviewsEnabled;
    }

    public RequestLevel getLowestPermittedRequestLevel()
    {
        return mLowestPermittedRequestLevel;
    }

    public Postprocessor getPostprocessor()
    {
        return mPostprocessor;
    }

    public int getPreferredHeight()
    {
        if (mResizeOptions != null)
        {
            return mResizeOptions.height;
        } else
        {
            return -1;
        }
    }

    public int getPreferredWidth()
    {
        if (mResizeOptions != null)
        {
            return mResizeOptions.width;
        } else
        {
            return -1;
        }
    }

    public Priority getPriority()
    {
        return mRequestPriority;
    }

    public boolean getProgressiveRenderingEnabled()
    {
        return mProgressiveRenderingEnabled;
    }

    public ResizeOptions getResizeOptions()
    {
        return mResizeOptions;
    }

    public File getSourceFile()
    {
        this;
        JVM INSTR monitorenter ;
        File file;
        if (mSourceFile == null)
        {
            mSourceFile = new File(mSourceUri.getPath());
        }
        file = mSourceFile;
        this;
        JVM INSTR monitorexit ;
        return file;
        Exception exception;
        exception;
        throw exception;
    }

    public Uri getSourceUri()
    {
        return mSourceUri;
    }

    public boolean isDiskCacheEnabled()
    {
        return mIsDiskCacheEnabled;
    }
}
