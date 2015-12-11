// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptentive.android.sdk.module.messagecenter.view;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.apptentive.android.sdk.Log;
import com.apptentive.android.sdk.model.FileMessage;
import com.apptentive.android.sdk.model.Message;
import com.apptentive.android.sdk.model.StoredFile;
import com.apptentive.android.sdk.util.ImageUtil;
import com.apptentive.android.sdk.util.Util;

// Referenced classes of package com.apptentive.android.sdk.module.messagecenter.view:
//            PersonalMessageView

public class FileMessageView extends PersonalMessageView
{

    private static final int MAX_IMAGE_DISPLAY_HEIGHT = 800;
    private static final int MAX_IMAGE_DISPLAY_WIDTH = 800;
    private static final float MAX_IMAGE_SCREEN_PROPORTION_X = 0.5F;
    private static final float MAX_IMAGE_SCREEN_PROPORTION_Y = 0.6F;

    public FileMessageView(Context context, FileMessage filemessage)
    {
        super(context, filemessage);
    }

    private Point getBitmapDimensions(StoredFile storedfile)
    {
        int j = 800;
        java.io.FileInputStream fileinputstream = context.openFileInput(storedfile.getLocalFilePath());
        storedfile = fileinputstream;
        Object obj = new android.graphics.BitmapFactory.Options();
        storedfile = fileinputstream;
        obj.inJustDecodeBounds = true;
        storedfile = fileinputstream;
        BitmapFactory.decodeStream(fileinputstream, null, ((android.graphics.BitmapFactory.Options) (obj)));
        storedfile = fileinputstream;
        Point point = Util.getScreenSize(context);
        storedfile = fileinputstream;
        int l = (int)(0.5F * (float)point.x);
        storedfile = fileinputstream;
        int k = (int)((float)point.x * 0.6F);
        int i;
        i = l;
        if (l > 800)
        {
            i = 800;
        }
          goto _L1
_L5:
        storedfile = fileinputstream;
        float f = ImageUtil.calculateBitmapScaleFactor(((android.graphics.BitmapFactory.Options) (obj)).outWidth, ((android.graphics.BitmapFactory.Options) (obj)).outHeight, i, j);
        storedfile = fileinputstream;
        obj = new Point((int)((float)((android.graphics.BitmapFactory.Options) (obj)).outWidth * f), (int)(f * (float)((android.graphics.BitmapFactory.Options) (obj)).outHeight));
        Util.ensureClosed(fileinputstream);
        return ((Point) (obj));
_L6:
        j = k;
        if (true)
        {
            break; /* Loop/switch isn't completed */
        }
        Exception exception1;
        exception1;
        fileinputstream = null;
_L4:
        storedfile = fileinputstream;
        Log.e("Error opening stored file.", exception1, new Object[0]);
        Util.ensureClosed(fileinputstream);
        return null;
        Exception exception;
        exception;
        storedfile = null;
_L3:
        Util.ensureClosed(storedfile);
        throw exception;
        exception;
        if (true) goto _L3; else goto _L2
_L2:
        exception1;
        if (true) goto _L4; else goto _L1
_L1:
        if (k <= 800) goto _L6; else goto _L5
    }

    private void loadImage(final StoredFile storedFile, final ImageView imageView)
    {
        storedFile = new _cls1();
        storedFile.setUncaughtExceptionHandler(new _cls2());
        storedFile.setName("Apptentive-FileMessageViewLoadImage");
        storedFile.start();
    }

    protected void init(FileMessage filemessage)
    {
        super.init(filemessage);
        filemessage = LayoutInflater.from(context);
        FrameLayout framelayout = (FrameLayout)findViewById(com.apptentive.android.sdk.R.id.apptentive_message_body);
        filemessage.inflate(com.apptentive.android.sdk.R.layout.apptentive_message_body_file, framelayout);
    }

    protected volatile void init(Message message)
    {
        init((FileMessage)message);
    }

    public void updateMessage(FileMessage filemessage)
    {
        FileMessage filemessage1 = (FileMessage)message;
        super.updateMessage(filemessage);
        StoredFile storedfile;
        if (filemessage != null)
        {
            if ((storedfile = filemessage.getStoredFile(context)) != null && storedfile.getLocalFilePath() != null)
            {
                boolean flag;
                boolean flag1;
                if (filemessage1 != null)
                {
                    filemessage = filemessage1.getStoredFile(context);
                } else
                {
                    filemessage = null;
                }
                if (filemessage1 == null || filemessage.getLocalFilePath() == null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (filemessage1 != null && !storedfile.getLocalFilePath().equals(filemessage.getLocalFilePath()))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (flag || flag1)
                {
                    String s = storedfile.getMimeType();
                    if (s == null)
                    {
                        Log.e("FileMessage mime type is null.", new Object[0]);
                        return;
                    }
                    filemessage = (ImageView)findViewById(com.apptentive.android.sdk.R.id.apptentive_file_message_image);
                    if (s.contains("image"))
                    {
                        filemessage.setVisibility(4);
                        Point point = getBitmapDimensions(storedfile);
                        if (point == null)
                        {
                            Log.w("Unable to peek at image dimensions.", new Object[0]);
                            return;
                        } else
                        {
                            filemessage.setPadding(point.x, point.y, 0, 0);
                            loadImage(storedfile, filemessage);
                            return;
                        }
                    }
                }
            }
        }
    }

    public volatile void updateMessage(Message message)
    {
        updateMessage((FileMessage)message);
    }

    private class _cls1 extends Thread
    {

        final FileMessageView this$0;
        final ImageView val$imageView;
        final StoredFile val$storedFile;

        public void run()
        {
            Object obj;
            java.io.FileInputStream fileinputstream;
            Object obj2;
            int j;
            obj2 = null;
            obj = null;
            fileinputstream = null;
            j = 800;
            java.io.FileInputStream fileinputstream1 = context.openFileInput(storedFile.getLocalFilePath());
            fileinputstream = fileinputstream1;
            obj2 = fileinputstream1;
            obj = fileinputstream1;
            final Bitmap imageBitmap = Util.getScreenSize(context);
            fileinputstream = fileinputstream1;
            obj2 = fileinputstream1;
            obj = fileinputstream1;
            int l = (int)(0.5F * (float)((Point) (imageBitmap)).x);
            fileinputstream = fileinputstream1;
            obj2 = fileinputstream1;
            obj = fileinputstream1;
            int k = (int)((float)((Point) (imageBitmap)).x * 0.6F);
            int i;
            i = l;
            if (l > 800)
            {
                i = 800;
            }
              goto _L1
_L2:
            fileinputstream = fileinputstream1;
            obj2 = fileinputstream1;
            obj = fileinputstream1;
            imageBitmap = ImageUtil.createScaledBitmapFromStream(fileinputstream1, i, j, null);
            fileinputstream = fileinputstream1;
            obj2 = fileinputstream1;
            obj = fileinputstream1;
            Log.v("Loaded bitmap and re-sized to: %d x %d", new Object[] {
                Integer.valueOf(imageBitmap.getWidth()), Integer.valueOf(imageBitmap.getHeight())
            });
            fileinputstream = fileinputstream1;
            obj2 = fileinputstream1;
            obj = fileinputstream1;
            class _cls1
                implements Runnable
            {

                final _cls1 this$1;
                final Bitmap val$imageBitmap;

                public void run()
                {
                    imageView.setImageBitmap(imageBitmap);
                    imageView.setPadding(0, 0, 0, 0);
                    imageView.setVisibility(0);
                }

                _cls1()
                {
                    this$1 = _cls1.this;
                    imageBitmap = bitmap;
                    super();
                }
            }

            imageView.post(new _cls1());
            Util.ensureClosed(fileinputstream1);
            return;
_L3:
            j = k;
            if (false)
            {
            } else
            {
                break; /* Loop/switch isn't completed */
            }
            obj2;
            obj = fileinputstream;
            Log.e("Error opening stored image.", ((Throwable) (obj2)), new Object[0]);
            Util.ensureClosed(fileinputstream);
            return;
            Object obj1;
            obj1;
            obj = obj2;
            Log.e("Ran out of memory opening image.", ((Throwable) (obj1)), new Object[0]);
            Util.ensureClosed(((java.io.Closeable) (obj2)));
            return;
            obj1;
            Util.ensureClosed(((java.io.Closeable) (obj)));
            throw obj1;
_L1:
            if (k <= 800) goto _L3; else goto _L2
        }

        _cls1()
        {
            this$0 = FileMessageView.this;
            storedFile = storedfile;
            imageView = imageview;
            super();
        }
    }


    private class _cls2
        implements Thread.UncaughtExceptionHandler
    {

        final FileMessageView this$0;

        public void uncaughtException(Thread thread, Throwable throwable)
        {
            Log.w("UncaughtException in FileMessageView.", throwable, new Object[0]);
            MetricModule.sendError(context.getApplicationContext(), throwable, null, null);
        }

        _cls2()
        {
            this$0 = FileMessageView.this;
            super();
        }
    }

}
