// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.net.Uri;
import android.provider.ContactsContract;
import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imageutils.JfifUtil;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executor;

// Referenced classes of package com.facebook.imagepipeline.producers:
//            LocalFetchProducer

public class LocalContentUriFetchProducer extends LocalFetchProducer
{

    private static final float ACCEPTABLE_REQUESTED_TO_ACTUAL_SIZE_RATIO = 1.333333F;
    private static final String DISPLAY_PHOTO_PATH;
    private static final Rect MICRO_THUMBNAIL_DIMENSIONS = new Rect(0, 0, 96, 96);
    private static final Rect MINI_THUMBNAIL_DIMENSIONS = new Rect(0, 0, 512, 384);
    private static final int NO_THUMBNAIL = 0;
    static final String PRODUCER_NAME = "LocalContentUriFetchProducer";
    private static final String PROJECTION[] = {
        "_id", "_data"
    };
    private static final Class TAG = com/facebook/imagepipeline/producers/LocalContentUriFetchProducer;
    private static final String THUMBNAIL_PROJECTION[] = {
        "_data"
    };
    private final ContentResolver mContentResolver;

    public LocalContentUriFetchProducer(Executor executor, PooledByteBufferFactory pooledbytebufferfactory, ContentResolver contentresolver)
    {
        super(executor, pooledbytebufferfactory);
        mContentResolver = contentresolver;
    }

    private EncodedImage getCameraImage(Uri uri, ResizeOptions resizeoptions)
        throws IOException
    {
        uri = mContentResolver.query(uri, PROJECTION, null, null, null);
        if (uri == null)
        {
            return null;
        }
        int i = uri.getCount();
        if (i == 0)
        {
            uri.close();
            return null;
        }
        String s;
        uri.moveToFirst();
        s = uri.getString(uri.getColumnIndex("_data"));
        if (resizeoptions == null)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        resizeoptions = getThumbnail(resizeoptions, uri.getInt(uri.getColumnIndex("_id")));
        if (resizeoptions == null)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        resizeoptions.setRotationAngle(getRotationAngle(s));
        uri.close();
        return resizeoptions;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_130;
        }
        resizeoptions = getByteBufferBackedEncodedImage(s, getLength(s));
        uri.close();
        return resizeoptions;
        uri.close();
        return null;
        resizeoptions;
        uri.close();
        throw resizeoptions;
    }

    private static int getLength(String s)
    {
        if (s == null)
        {
            return -1;
        } else
        {
            return (int)(new File(s)).length();
        }
    }

    private static int getRotationAngle(String s)
    {
        int i = 0;
        if (s != null)
        {
            try
            {
                i = JfifUtil.getAutoRotateAngleFromOrientation((new ExifInterface(s)).getAttributeInt("Orientation", 1));
            }
            catch (IOException ioexception)
            {
                FLog.e(TAG, ioexception, "Unable to retrieve thumbnail rotation for %s", new Object[] {
                    s
                });
                return 0;
            }
        }
        return i;
    }

    private EncodedImage getThumbnail(ResizeOptions resizeoptions, int i)
        throws IOException
    {
        EncodedImage encodedimage;
        int j;
        encodedimage = null;
        j = getThumbnailKind(resizeoptions);
        if (j != 0) goto _L2; else goto _L1
_L1:
        Object obj = encodedimage;
_L4:
        return ((EncodedImage) (obj));
_L2:
        obj = null;
        resizeoptions = android.provider.MediaStore.Images.Thumbnails.queryMiniThumbnail(mContentResolver, i, j, THUMBNAIL_PROJECTION);
        if (resizeoptions != null)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = encodedimage;
        if (resizeoptions != null)
        {
            resizeoptions.close();
            return null;
        }
        if (true) goto _L4; else goto _L3
_L3:
        obj = resizeoptions;
        resizeoptions.moveToFirst();
        obj = resizeoptions;
        if (resizeoptions.getCount() <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = resizeoptions;
        String s = resizeoptions.getString(resizeoptions.getColumnIndex("_data"));
        obj = resizeoptions;
        if (!(new File(s)).exists())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = resizeoptions;
        encodedimage = getByteBufferBackedEncodedImage(s, getLength(s));
        obj = encodedimage;
        if (resizeoptions != null)
        {
            resizeoptions.close();
            return encodedimage;
        }
        if (true) goto _L4; else goto _L5
_L5:
        obj = encodedimage;
        if (resizeoptions == null) goto _L4; else goto _L6
_L6:
        resizeoptions.close();
        return null;
        resizeoptions;
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw resizeoptions;
    }

    private static int getThumbnailKind(ResizeOptions resizeoptions)
    {
        if (isThumbnailBigEnough(resizeoptions, MICRO_THUMBNAIL_DIMENSIONS))
        {
            return 3;
        }
        return !isThumbnailBigEnough(resizeoptions, MINI_THUMBNAIL_DIMENSIONS) ? 0 : 1;
    }

    private static boolean isCameraUri(Uri uri)
    {
        uri = uri.toString();
        return uri.startsWith(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString()) || uri.startsWith(android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI.toString());
    }

    private static boolean isContactUri(Uri uri)
    {
        return "com.android.contacts".equals(uri.getAuthority()) && !uri.getPath().startsWith(DISPLAY_PHOTO_PATH);
    }

    static boolean isThumbnailBigEnough(ResizeOptions resizeoptions, Rect rect)
    {
        return (float)resizeoptions.width <= (float)rect.width() * 1.333333F && (float)resizeoptions.height <= (float)rect.height() * 1.333333F;
    }

    protected EncodedImage getEncodedImage(ImageRequest imagerequest)
        throws IOException
    {
        Uri uri = imagerequest.getSourceUri();
        if (!isContactUri(uri)) goto _L2; else goto _L1
_L1:
        imagerequest = getByteBufferBackedEncodedImage(android.provider.ContactsContract.Contacts.openContactPhotoInputStream(mContentResolver, uri), -1);
_L4:
        return imagerequest;
_L2:
        EncodedImage encodedimage;
        if (!isCameraUri(uri))
        {
            break; /* Loop/switch isn't completed */
        }
        encodedimage = getCameraImage(uri, imagerequest.getResizeOptions());
        imagerequest = encodedimage;
        if (encodedimage != null) goto _L4; else goto _L3
_L3:
        return getByteBufferBackedEncodedImage(mContentResolver.openInputStream(uri), -1);
    }

    protected String getProducerName()
    {
        return "LocalContentUriFetchProducer";
    }

    static 
    {
        DISPLAY_PHOTO_PATH = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "display_photo").getPath();
    }
}
