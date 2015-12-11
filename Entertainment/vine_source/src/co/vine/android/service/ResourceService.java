// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.support.v8.renderscript.RenderScript;
import co.vine.android.recorder.AudioArray;
import co.vine.android.recorder.EncoderManager;
import co.vine.android.recorder.PictureConverter;
import co.vine.android.recorder.RecordConfigUtils;
import co.vine.android.recorder.RecordSessionManager;
import co.vine.android.recorder.RecordSessionVersion;
import co.vine.android.recorder.SwVineFrameRecorder;
import co.vine.android.util.CrashUtil;
import co.vine.android.util.SystemUtil;
import com.edisonwang.android.slog.SLog;
import com.googlecode.javacpp.BytePointer;
import java.nio.ByteBuffer;

public class ResourceService extends Service
{
    public class CameraServiceBinder extends Handler
    {

        final ResourceService this$0;

        public void handleMessage(Message message)
        {
            switch (message.what)
            {
            default:
                SLog.e((new StringBuilder()).append("Invalid request: ").append(message.what).toString());
                return;

            case 101: // 'e'
                break;
            }
            if (ResourceService.isConversationActive)
            {
                message = "co.vine.android.camera.request.conversation.state.on";
            } else
            {
                message = "co.vine.android.camera.request.conversation.state.off";
            }
            message = new Intent(message);
            message.putExtra("co.vine.android.camera.request.conversation.state.id", ResourceService.lastActiveconversationRowId);
            sendBroadcast(message, "co.vine.android.BROADCAST");
        }

        public CameraServiceBinder()
        {
            this$0 = ResourceService.this;
            super();
        }
    }


    public static final String CONVERSATION_STATE_OFF = "co.vine.android.camera.request.conversation.state.off";
    public static final String CONVERSATION_STATE_ON = "co.vine.android.camera.request.conversation.state.on";
    public static final String CONVERSATION_STATE_ON_ID = "co.vine.android.camera.request.conversation.state.id";
    public static boolean IS_READY = false;
    public static final int REQUEST_CONVERSATION_STATE_BC = 101;
    public static boolean isConversationActive = false;
    public static long lastActiveconversationRowId;
    private static AudioArray sAudioDataBufferByte;
    private static AudioArray sAudioDataBufferShort;
    private static int sBufferUserCountByte;
    private static int sBufferUserCountShort;
    private static ByteBuffer sFrameBuffer;
    private static com.googlecode.javacv.cpp.opencv_core.IplImage sIplImage;
    private static final int sLOCK[] = new int[0];
    private static PictureConverter sPictureConverter;
    private static Bitmap sPreviewBitmap;
    private static Canvas sPreviewCanvas;
    private static RenderScript sRS;
    private static Bitmap sThumbnailBitmap;
    private static Canvas sThumbnailBitmapCanvas;
    private static Matrix sThumbnailMatrix;
    private static SwVineFrameRecorder sVineRecorder;
    private final Messenger messenger = new Messenger(new CameraServiceBinder());

    public ResourceService()
    {
    }

    public static Bitmap generateThumbnailBitmap(Point point)
    {
        int i = point.x / 2;
        return Bitmap.createBitmap(i, i, RecordConfigUtils.DEFAULT_BITMAP_CONFIG);
    }

    public static Matrix generateThumbnailMatrix(Bitmap bitmap, Bitmap bitmap1)
    {
        Matrix matrix = new Matrix();
        float f = (1.0F * (float)bitmap.getHeight()) / (float)bitmap1.getHeight();
        matrix.setScale(f, f);
        return matrix;
    }

    public static AudioArray getAudioDataBuffer(co.vine.android.recorder.AudioArray.AudioArrayType audioarraytype)
    {
label0:
        {
            synchronized (sLOCK)
            {
                if (audioarraytype != co.vine.android.recorder.AudioArray.AudioArrayType.BYTE)
                {
                    break MISSING_BLOCK_LABEL_63;
                }
                sBufferUserCountByte++;
                if (sAudioDataBufferByte == null)
                {
                    sAudioDataBufferByte = RecordConfigUtils.createAudioArray(audioarraytype);
                }
                if (sBufferUserCountByte <= 1)
                {
                    break label0;
                }
                audioarraytype = RecordConfigUtils.createAudioArray(audioarraytype);
            }
            return audioarraytype;
        }
        audioarraytype = sAudioDataBufferByte;
        ai;
        JVM INSTR monitorexit ;
        return audioarraytype;
        audioarraytype;
        ai;
        JVM INSTR monitorexit ;
        throw audioarraytype;
        sBufferUserCountShort++;
        if (sAudioDataBufferShort == null)
        {
            sAudioDataBufferShort = RecordConfigUtils.createAudioArray(audioarraytype);
        }
        if (sBufferUserCountShort <= 1)
        {
            break MISSING_BLOCK_LABEL_100;
        }
        audioarraytype = RecordConfigUtils.createAudioArray(audioarraytype);
        ai;
        JVM INSTR monitorexit ;
        return audioarraytype;
        audioarraytype = sAudioDataBufferShort;
        ai;
        JVM INSTR monitorexit ;
        return audioarraytype;
    }

    public static ByteBuffer getFrameBuffer()
    {
        ByteBuffer bytebuffer;
        synchronized (sLOCK)
        {
            if (sFrameBuffer == null)
            {
                sFrameBuffer = (new BytePointer(0xe1000)).asByteBuffer();
            }
            bytebuffer = sFrameBuffer;
        }
        return bytebuffer;
        exception;
        ai;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static com.googlecode.javacv.cpp.opencv_core.IplImage getFrameImage()
    {
        com.googlecode.javacv.cpp.opencv_core.IplImage iplimage;
        synchronized (sLOCK)
        {
            if (sIplImage == null)
            {
                sIplImage = com.googlecode.javacv.cpp.opencv_core.IplImage.create(480, 480, 8, 4);
            }
            iplimage = sIplImage;
        }
        return iplimage;
        exception;
        ai;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static PictureConverter getPictureConverter()
    {
        return sPictureConverter;
    }

    public static Bitmap getPreviewBitmap()
    {
        Bitmap bitmap;
        synchronized (sLOCK)
        {
            if (sPreviewBitmap == null)
            {
                sPreviewBitmap = RecordConfigUtils.createDefaultSizeBitmap();
            }
            bitmap = sPreviewBitmap;
        }
        return bitmap;
        exception;
        ai;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static Canvas getPreviewCanvas()
    {
        Canvas canvas;
        synchronized (sLOCK)
        {
            if (sPreviewCanvas == null)
            {
                sPreviewCanvas = new Canvas(getPreviewBitmap());
            }
            canvas = sPreviewCanvas;
        }
        return canvas;
        exception;
        ai;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static RenderScript getRenderScript(Context context)
    {
        synchronized (sLOCK)
        {
            if (sRS == null)
            {
                sRS = RenderScript.create(context.getApplicationContext());
            }
            context = sRS;
        }
        return context;
        context;
        ai;
        JVM INSTR monitorexit ;
        throw context;
    }

    public static Bitmap getThumbnailBitmap(Context context)
    {
        synchronized (sLOCK)
        {
            if (sThumbnailBitmap == null)
            {
                sThumbnailBitmap = generateThumbnailBitmap(SystemUtil.getDisplaySize(context));
            }
            context = sThumbnailBitmap;
        }
        return context;
        context;
        ai;
        JVM INSTR monitorexit ;
        throw context;
    }

    public static Canvas getThumbnailCanvas(Context context)
    {
        synchronized (sLOCK)
        {
            if (sThumbnailBitmapCanvas == null)
            {
                sThumbnailBitmapCanvas = new Canvas(getThumbnailBitmap(context));
            }
            context = sThumbnailBitmapCanvas;
        }
        return context;
        context;
        ai;
        JVM INSTR monitorexit ;
        throw context;
    }

    public static Matrix getThumbnailMatrix(Context context)
    {
        synchronized (sLOCK)
        {
            if (sThumbnailMatrix == null)
            {
                sThumbnailMatrix = generateThumbnailMatrix(getThumbnailBitmap(context), getPreviewBitmap());
            }
            context = sThumbnailMatrix;
        }
        return context;
        context;
        ai;
        JVM INSTR monitorexit ;
        throw context;
    }

    public static void initVineRecorder(Context context)
    {
        int ai[] = sLOCK;
        ai;
        JVM INSTR monitorenter ;
        SwVineFrameRecorder swvineframerecorder = sVineRecorder;
        if (swvineframerecorder != null) goto _L2; else goto _L1
_L1:
        if (!SwVineFrameRecorder.hasEverSuccessfullyLoaded)
        {
            SwVineFrameRecorder.tryLoad(context);
            if (RecordSessionManager.DEFAULT_VERSION == RecordSessionVersion.SW_MP4)
            {
                EncoderManager.tryLoad();
            }
            RecordConfigUtils.setLoadWasEverSuccessful(context, true);
        }
_L4:
        sVineRecorder = new SwVineFrameRecorder("", 0, 0, 1, null, null);
_L2:
        ai;
        JVM INSTR monitorexit ;
        return;
        Throwable throwable;
        throwable;
        try
        {
            CrashUtil.logException(throwable, "Failed to load", new Object[0]);
            RecordConfigUtils.setLoadWasEverSuccessful(context, false);
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Context context) { }
        finally { }
        CrashUtil.logException(context);
          goto _L2
        ai;
        JVM INSTR monitorexit ;
        throw context;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static void releaseAudioBuffer(co.vine.android.recorder.AudioArray.AudioArrayType audioarraytype)
    {
        int ai[] = sLOCK;
        ai;
        JVM INSTR monitorenter ;
        if (audioarraytype != co.vine.android.recorder.AudioArray.AudioArrayType.BYTE)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        sBufferUserCountByte--;
        if (sBufferUserCountByte < 0)
        {
            sBufferUserCountByte = 0;
        }
_L2:
        return;
        sBufferUserCountShort--;
        if (sBufferUserCountShort < 0)
        {
            sBufferUserCountShort = 0;
        }
        if (true) goto _L2; else goto _L1
_L1:
        audioarraytype;
        ai;
        JVM INSTR monitorexit ;
        throw audioarraytype;
    }

    public static void setPictureConverter(PictureConverter pictureconverter)
    {
        sPictureConverter = pictureconverter;
    }

    public IBinder onBind(Intent intent)
    {
        return messenger.getBinder();
    }

    public void onCreate()
    {
        SLog.d("Camera Service onCreate start.");
        long l = System.currentTimeMillis();
        try
        {
            getThumbnailBitmap(this);
            getRenderScript(this);
            if (RecordConfigUtils.HW_ENABLED)
            {
                getFrameBuffer();
            }
            if (RecordConfigUtils.SW_ENABLED)
            {
                initVineRecorder(this);
                getFrameImage();
            }
            getPreviewBitmap();
            getThumbnailMatrix(this);
            getThumbnailCanvas(this);
            getPreviewCanvas();
        }
        catch (Throwable throwable)
        {
            CrashUtil.log("Failed to init camera service, it is ok.", new Object[] {
                throwable
            });
        }
        IS_READY = true;
        SLog.d("Camera Service took {}ms.", Long.valueOf(System.currentTimeMillis() - l));
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (sVineRecorder != null)
        {
            sVineRecorder.release();
            sVineRecorder = null;
        }
        SLog.d("Camera Service onDestroy..");
        IS_READY = false;
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        return 1;
    }

    static 
    {
        IS_READY = false;
    }
}
