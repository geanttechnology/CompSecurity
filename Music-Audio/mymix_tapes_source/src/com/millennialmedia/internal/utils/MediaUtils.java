// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.utils;

import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.util.Base64;
import com.millennialmedia.MMLog;
import com.millennialmedia.internal.MMIntentWrapperActivity;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

// Referenced classes of package com.millennialmedia.internal.utils:
//            EnvironmentUtils, IOUtils

public class MediaUtils
{
    public static interface PhotoListener
    {

        public abstract void onError(String s);

        public abstract void onPhoto(File file);
    }

    public static interface PlayVideoListener
    {

        public abstract void onError(String s);

        public abstract void onVideoStarted(Uri uri);
    }

    public static interface SavePictureListener
    {

        public abstract void onError(String s);

        public abstract void onPictureSaved(File file);
    }


    private static final String TAG = com/millennialmedia/internal/utils/MediaUtils.getSimpleName();

    public MediaUtils()
    {
    }

    public static String base64EncodeBitmap(Bitmap bitmap, String s)
    {
        android.graphics.Bitmap.CompressFormat compressformat;
        ByteArrayOutputStream bytearrayoutputstream;
        if ("image/jpg".equalsIgnoreCase(s) || "image/jpeg".equalsIgnoreCase(s))
        {
            compressformat = android.graphics.Bitmap.CompressFormat.JPEG;
        } else
        if ("image/webp".equalsIgnoreCase(s))
        {
            compressformat = android.graphics.Bitmap.CompressFormat.WEBP;
        } else
        {
            s = "image/png";
            compressformat = android.graphics.Bitmap.CompressFormat.PNG;
        }
        bytearrayoutputstream = new ByteArrayOutputStream();
        if (!bitmap.compress(compressformat, 100, bytearrayoutputstream))
        {
            MMLog.e(TAG, "Unable to compress bitmap for encoding");
            return null;
        } else
        {
            bitmap = bytearrayoutputstream.toByteArray();
            return (new StringBuilder()).append("data:").append(s).append(";base64,").append(Base64.encodeToString(bitmap, 0)).toString();
        }
    }

    public static String getMimeTypeFromFile(File file)
    {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        return options.outMimeType;
    }

    public static void getPhotoFromCamera(Context context, PhotoListener photolistener)
    {
        if (photolistener == null)
        {
            MMLog.e(TAG, "PhotoListener is required");
            return;
        }
        if (!EnvironmentUtils.hasCamera())
        {
            photolistener.onError("This device does not have a camera");
            return;
        }
        File file;
        Intent intent;
        try
        {
            file = File.createTempFile("CAMERA_", ".tmp", EnvironmentUtils.getCacheDirectory());
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            photolistener.onError("Unable to create temporary file for picture");
            return;
        }
        intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra("output", Uri.fromFile(file));
        MMIntentWrapperActivity.launch(context, intent, new com.millennialmedia.internal.MMIntentWrapperActivity.MMIntentWrapperListener(file, photolistener) {

            final File val$file;
            final PhotoListener val$photoListener;

            public void onData(Intent intent1)
            {
                if (file != null && file.exists())
                {
                    photoListener.onPhoto(file);
                    return;
                } else
                {
                    photoListener.onError("Unable to get image from camera");
                    return;
                }
            }

            public void onError(String s)
            {
                photoListener.onError(s);
            }

            
            {
                file = file1;
                photoListener = photolistener;
                super();
            }
        });
    }

    public static void getPhotoFromGallery(Context context, PhotoListener photolistener)
    {
        if (photolistener == null)
        {
            MMLog.e(TAG, "PhotoListener is required");
            return;
        } else
        {
            MMIntentWrapperActivity.launch(context, getPictureChooserIntent(), new com.millennialmedia.internal.MMIntentWrapperActivity.MMIntentWrapperListener(context, photolistener) {

                final Context val$context;
                final PhotoListener val$photoListener;

                public void onData(Intent intent)
                {
                    if (intent != null)
                    {
                        Object obj = intent.getData();
                        if (obj != null)
                        {
                            intent = ((Uri) (obj)).getPath();
                            Cursor cursor = context.getContentResolver().query(((Uri) (obj)), new String[] {
                                "_data"
                            }, null, null, null);
                            obj = intent;
                            if (cursor != null)
                            {
                                int i = cursor.getColumnIndex("_data");
                                if (cursor.moveToFirst())
                                {
                                    intent = cursor.getString(i);
                                }
                                cursor.close();
                                obj = intent;
                            }
                            if (obj != null)
                            {
                                intent = new File(((String) (obj)));
                                if (intent != null && intent.exists())
                                {
                                    photoListener.onPhoto(intent);
                                    return;
                                }
                            }
                        }
                    }
                    photoListener.onError("Unable to get image from gallery");
                }

                public void onError(String s)
                {
                    photoListener.onError(s);
                }

            
            {
                context = context1;
                photoListener = photolistener;
                super();
            }
            });
            return;
        }
    }

    private static Intent getPictureChooserIntent()
    {
        return new Intent("android.intent.action.PICK", android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
    }

    public static Bitmap getScaledBitmapFromFile(File file, int i, int j, boolean flag, boolean flag1)
    {
        android.graphics.BitmapFactory.Options options;
        int k;
        int l;
        options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        l = 0;
        k = l;
        if (!flag1) goto _L2; else goto _L1
_L1:
        ExifInterface exifinterface;
        int i1;
        try
        {
            exifinterface = new ExifInterface(file.getCanonicalPath());
        }
        catch (IOException ioexception)
        {
            k = l;
            continue; /* Loop/switch isn't completed */
        }
        i1 = exifinterface.getAttributeInt("Orientation", 1);
        k = l;
        switch (i1)
        {
        default:
            k = l;
            break;

        case 4: // '\004'
        case 5: // '\005'
        case 7: // '\007'
            break;

        case 6: // '\006'
            k = 90;
            continue; /* Loop/switch isn't completed */

        case 3: // '\003'
            k = 180;
            continue; /* Loop/switch isn't completed */

        case 8: // '\b'
            k = 270;
            continue; /* Loop/switch isn't completed */
        }
        break;
_L2:
label0:
        {
            if (k != 90)
            {
                i1 = i;
                l = j;
                if (k != 270)
                {
                    break label0;
                }
            }
            l = i;
            i1 = j;
        }
        options.inSampleSize = 1;
        if (options.outWidth > i1 || options.outHeight > l)
        {
            i = options.outWidth / 2;
            for (j = options.outHeight / 2; i / options.inSampleSize > i1 && j / options.inSampleSize > l; options.inSampleSize = options.inSampleSize * 2) { }
        }
        options.inJustDecodeBounds = false;
        Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        if (bitmap == null || options.outWidth == 0 || options.outHeight == 0)
        {
            MMLog.e(TAG, (new StringBuilder()).append("Unable to load bitmap from file <").append(file.getAbsolutePath()).append(">").toString());
            file = null;
        } else
        {
            float f2 = Math.min(1.0F, (float)i1 / (float)options.outWidth);
            float f3 = Math.min(1.0F, (float)l / (float)options.outHeight);
            float f1 = f3;
            float f = f2;
            if (flag)
            {
                f = Math.min(f2, f3);
                f1 = f;
            }
            if (f == 1.0F && f1 == 1.0F && k == 0)
            {
                file = bitmap;
                if (MMLog.isDebugEnabled())
                {
                    MMLog.d(TAG, (new StringBuilder()).append("Unscaled and unrotated bitmap: ").append(bitmap.getWidth()).append(" x ").append(bitmap.getHeight()).toString());
                    return bitmap;
                }
            } else
            {
                file = new Matrix();
                file.postScale(f, f1);
                if (k > 0)
                {
                    if (MMLog.isDebugEnabled())
                    {
                        MMLog.d(TAG, (new StringBuilder()).append("Rotating image ").append(k).append(" degrees").toString());
                    }
                    file.postRotate(k);
                }
                file = Bitmap.createBitmap(bitmap, 0, 0, options.outWidth, options.outHeight, file, true);
                if (file == null)
                {
                    MMLog.e(TAG, "Unable to create scaled bitmap");
                }
                if (MMLog.isDebugEnabled())
                {
                    MMLog.d(TAG, (new StringBuilder()).append("Scaled and rotated bitmap: ").append(file.getWidth()).append(" x ").append(file.getHeight()).toString());
                }
                bitmap.recycle();
                return file;
            }
        }
        return file;
        IOException ioexception1;
        ioexception1;
        k = l;
        if (true) goto _L2; else goto _L3
_L3:
    }

    public static boolean isPictureChooserAvailable()
    {
        Object obj = getPictureChooserIntent();
        obj = EnvironmentUtils.getApplicationContext().getPackageManager().queryIntentActivities(((Intent) (obj)), 0x10000);
        return obj != null && ((List) (obj)).size() > 0;
    }

    public static void savePicture(Context context, String s, String s1, SavePictureListener savepicturelistener)
    {
        if (savepicturelistener == null)
        {
            MMLog.e(TAG, "PictureListener is required");
            return;
        }
        if (!EnvironmentUtils.isExternalStorageWritable())
        {
            savepicturelistener.onError("Storage not mounted, cannot add image to photo library");
            return;
        }
        if (s == null)
        {
            savepicturelistener.onError("url is required");
            return;
        }
        Uri uri = Uri.parse(s);
        if (uri.getScheme().startsWith("http"))
        {
            File file = EnvironmentUtils.getExternalCacheDirectory(true);
            if (file == null)
            {
                savepicturelistener.onError("Cannot access cache directory");
                return;
            }
            file = new File(file, "Pictures");
            if (s1 == null)
            {
                s1 = IOUtils.getUniqueFileName(file, uri.getLastPathSegment());
            } else
            {
                s1 = IOUtils.getUniqueFileName(file, s1);
            }
            if (s1 == null)
            {
                savepicturelistener.onError("Unable to store photo");
                return;
            } else
            {
                IOUtils.downloadFile(s, null, s1, new IOUtils.DownloadListener(context, savepicturelistener) {

                    final Context val$context;
                    final SavePictureListener val$pictureListener;

                    public void onDownloadFailed(Throwable throwable)
                    {
                        pictureListener.onError("Unable to download file");
                    }

                    public void onDownloadSucceeded(File file1)
                    {
                        MediaUtils.scanPicture(context, file1, pictureListener, true);
                    }

            
            {
                context = context1;
                pictureListener = savepicturelistener;
                super();
            }
                });
                return;
            }
        }
        s = new File(uri.getPath());
        if (!s.exists())
        {
            savepicturelistener.onError((new StringBuilder()).append("No file found at ").append(s.getAbsolutePath()).toString());
            return;
        } else
        {
            scanPicture(context, s, savepicturelistener, false);
            return;
        }
    }

    private static void scanPicture(Context context, File file, SavePictureListener savepicturelistener, boolean flag)
    {
        String s = file.getAbsolutePath();
        file = new android.media.MediaScannerConnection.OnScanCompletedListener(flag, file, savepicturelistener) {

            final boolean val$deleteOnFailure;
            final File val$file;
            final SavePictureListener val$pictureListener;

            public void onScanCompleted(String s1, Uri uri)
            {
                if (uri == null)
                {
                    if (deleteOnFailure)
                    {
                        file.delete();
                    }
                    pictureListener.onError((new StringBuilder()).append("Failed to scan file ").append(s1).toString());
                    return;
                } else
                {
                    pictureListener.onPictureSaved(file);
                    return;
                }
            }

            
            {
                deleteOnFailure = flag;
                file = file1;
                pictureListener = savepicturelistener;
                super();
            }
        };
        MediaScannerConnection.scanFile(context, new String[] {
            s
        }, null, file);
    }

    public static void setFileDescription(File file, String s)
    {
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        ExifInterface exifinterface = new ExifInterface(file.getCanonicalPath());
        exifinterface.setAttribute("UserComment", s);
        exifinterface.saveAttributes();
_L1:
        return;
        s;
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("Cannot set description on media file <").append(file.getAbsolutePath()).append(">").toString());
            return;
        }
          goto _L1
    }

    public static void startVideoPlayer(Context context, String s, PlayVideoListener playvideolistener)
    {
        if (playvideolistener == null)
        {
            MMLog.e(TAG, "VideoListener is required");
            return;
        }
        if (s == null)
        {
            playvideolistener.onError("url is required");
            return;
        }
        Object obj = Uri.parse(s);
        s = ((String) (obj));
        if (!((Uri) (obj)).getScheme().startsWith("http"))
        {
            s = EnvironmentUtils.getExternalCacheDirectory(false);
            if (s == null)
            {
                playvideolistener.onError("Cannot access cache directory");
                return;
            }
            s = new File(s, ((Uri) (obj)).getPath());
            if (!s.exists())
            {
                playvideolistener.onError((new StringBuilder()).append("No file found at ").append(s.getAbsolutePath()).toString());
                return;
            }
            s = Uri.fromFile(s);
        }
        obj = new Intent("android.intent.action.VIEW");
        ((Intent) (obj)).setDataAndType(s, "video/*");
        try
        {
            context.startActivity(((Intent) (obj)));
            playvideolistener.onVideoStarted(s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            playvideolistener.onError("No video application installed");
        }
    }


}
