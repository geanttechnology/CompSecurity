// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.vision;

import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.SystemClock;
import android.util.Log;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;
import com.google.android.gms.common.images.Size;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.google.android.gms.vision:
//            Detector

public class CameraSource
{
    public static class Builder
    {

        private final Detector zzaUK;
        private CameraSource zzaUL;

        public CameraSource build()
        {
            CameraSource camerasource = zzaUL;
            CameraSource camerasource1 = zzaUL;
            camerasource1.getClass();
            CameraSource.zza(camerasource, camerasource1. new zzb(zzaUK));
            return zzaUL;
        }

        public Builder setFacing(int i)
        {
            if (i != 0 && i != 1)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Invalid camera: ").append(i).toString());
            } else
            {
                CameraSource.zzc(zzaUL, i);
                return this;
            }
        }

        public Builder setRequestedFps(float f)
        {
            if (f <= 0.0F)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Invalid fps: ").append(f).toString());
            } else
            {
                CameraSource.zza(zzaUL, f);
                return this;
            }
        }

        public Builder setRequestedPreviewSize(int i, int j)
        {
            if (i <= 0 || i > 0xf4240 || j <= 0 || j > 0xf4240)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Invalid preview size: ").append(i).append("x").append(j).toString());
            } else
            {
                CameraSource.zza(zzaUL, i);
                CameraSource.zzb(zzaUL, j);
                return this;
            }
        }

        public Builder(Context context, Detector detector)
        {
            zzaUL = new CameraSource();
            if (context == null)
            {
                throw new IllegalArgumentException("No context supplied.");
            }
            if (detector == null)
            {
                throw new IllegalArgumentException("No detector supplied.");
            } else
            {
                zzaUK = detector;
                CameraSource.zza(zzaUL, context);
                return;
            }
        }
    }

    public static interface PictureCallback
    {

        public abstract void onPictureTaken(byte abyte0[]);
    }

    public static interface ShutterCallback
    {

        public abstract void onShutter();
    }

    private class zza
        implements android.hardware.Camera.PreviewCallback
    {

        final CameraSource zzaUM;

        public void onPreviewFrame(byte abyte0[], Camera camera)
        {
            CameraSource.zzc(zzaUM).zza(abyte0, camera);
        }

        private zza()
        {
            zzaUM = CameraSource.this;
            super();
        }

    }

    private class zzb
        implements Runnable
    {

        static final boolean $assertionsDisabled;
        private long zzMS;
        private Detector zzaUK;
        final CameraSource zzaUM;
        private boolean zzaUN;
        private long zzaUO;
        private int zzaUP;
        private ByteBuffer zzaUQ;
        private final Object zzpc = new Object();

        void release()
        {
            if (!$assertionsDisabled && CameraSource.zzd(zzaUM).getState() != Thread.State.TERMINATED)
            {
                throw new AssertionError();
            } else
            {
                zzaUK.release();
                zzaUK = null;
                return;
            }
        }

        public void run()
        {
_L1:
            Object obj = zzpc;
            obj;
            JVM INSTR monitorenter ;
            ByteBuffer bytebuffer;
            if (!zzaUN)
            {
                break MISSING_BLOCK_LABEL_30;
            }
            bytebuffer = zzaUQ;
            if (bytebuffer != null)
            {
                break MISSING_BLOCK_LABEL_30;
            }
            zzpc.wait();
            if (zzaUN)
            {
                break MISSING_BLOCK_LABEL_58;
            }
            obj;
            JVM INSTR monitorexit ;
            return;
            Object obj2;
            obj2;
            Log.d("CameraSource", "Frame processing loop terminated.", ((Throwable) (obj2)));
            obj;
            JVM INSTR monitorexit ;
            return;
            obj2;
            obj;
            JVM INSTR monitorexit ;
            throw obj2;
            Frame frame;
            frame = (new Frame.Builder()).setImageData(zzaUQ, CameraSource.zzg(zzaUM).getWidth(), CameraSource.zzg(zzaUM).getHeight(), 17).setId(zzaUP).setTimestampMillis(zzaUO).setRotation(CameraSource.zzf(zzaUM)).build();
            obj2 = zzaUQ;
            zzaUQ = null;
            obj;
            JVM INSTR monitorexit ;
            zzaUK.receiveFrame(frame);
            CameraSource.zzb(zzaUM).addCallbackBuffer(((ByteBuffer) (obj2)).array());
              goto _L1
            Object obj1;
            obj1;
            Log.e("CameraSource", "Exception thrown from receiver.", ((Throwable) (obj1)));
            CameraSource.zzb(zzaUM).addCallbackBuffer(((ByteBuffer) (obj2)).array());
              goto _L1
            obj1;
            CameraSource.zzb(zzaUM).addCallbackBuffer(((ByteBuffer) (obj2)).array());
            throw obj1;
        }

        void setActive(boolean flag)
        {
            synchronized (zzpc)
            {
                zzaUN = flag;
                zzpc.notifyAll();
            }
            return;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        void zza(byte abyte0[], Camera camera)
        {
            synchronized (zzpc)
            {
                if (zzaUQ != null)
                {
                    camera.addCallbackBuffer(zzaUQ.array());
                    zzaUQ = null;
                }
                zzaUO = SystemClock.elapsedRealtime() - zzMS;
                zzaUP = zzaUP + 1;
                zzaUQ = (ByteBuffer)CameraSource.zze(zzaUM).get(abyte0);
                zzpc.notifyAll();
            }
            return;
            abyte0;
            obj;
            JVM INSTR monitorexit ;
            throw abyte0;
        }

        static 
        {
            boolean flag;
            if (!com/google/android/gms/vision/CameraSource.desiredAssertionStatus())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            $assertionsDisabled = flag;
        }

        zzb(Detector detector)
        {
            zzaUM = CameraSource.this;
            super();
            zzMS = SystemClock.elapsedRealtime();
            zzaUN = true;
            zzaUP = 0;
            zzaUK = detector;
        }
    }

    private class zzc
        implements android.hardware.Camera.PictureCallback
    {

        final CameraSource zzaUM;
        private PictureCallback zzaUR;

        static PictureCallback zza(zzc zzc1, PictureCallback picturecallback)
        {
            zzc1.zzaUR = picturecallback;
            return picturecallback;
        }

        public void onPictureTaken(byte abyte0[], Camera camera)
        {
            if (zzaUR != null)
            {
                zzaUR.onPictureTaken(abyte0);
            }
            synchronized (CameraSource.zza(zzaUM))
            {
                if (CameraSource.zzb(zzaUM) != null)
                {
                    CameraSource.zzb(zzaUM).startPreview();
                }
            }
            return;
            camera;
            abyte0;
            JVM INSTR monitorexit ;
            throw camera;
        }

        private zzc()
        {
            zzaUM = CameraSource.this;
            super();
        }

    }

    private class zzd
        implements android.hardware.Camera.ShutterCallback
    {

        final CameraSource zzaUM;
        private ShutterCallback zzaUS;

        static ShutterCallback zza(zzd zzd1, ShutterCallback shuttercallback)
        {
            zzd1.zzaUS = shuttercallback;
            return shuttercallback;
        }

        public void onShutter()
        {
            if (zzaUS != null)
            {
                zzaUS.onShutter();
            }
        }

        private zzd()
        {
            zzaUM = CameraSource.this;
            super();
        }

    }

    private static class zze
    {

        private Size zzaUT;
        private Size zzaUU;

        public Size zzCa()
        {
            return zzaUT;
        }

        public Size zzCb()
        {
            return zzaUU;
        }

        public zze(android.hardware.Camera.Size size, android.hardware.Camera.Size size1)
        {
            zzaUT = new Size(size.width, size.height);
            zzaUU = new Size(size1.width, size1.height);
        }
    }


    public static final int CAMERA_FACING_BACK = 0;
    public static final int CAMERA_FACING_FRONT = 1;
    private Context mContext;
    private Size zzaUA;
    private float zzaUB;
    private int zzaUC;
    private int zzaUD;
    private SurfaceView zzaUE;
    private SurfaceTexture zzaUF;
    private boolean zzaUG;
    private Thread zzaUH;
    private zzb zzaUI;
    private Map zzaUJ;
    private final Object zzaUx;
    private Camera zzaUy;
    private int zzaUz;
    private int zzzS;

    private CameraSource()
    {
        zzaUx = new Object();
        zzaUz = 0;
        zzaUB = 30F;
        zzaUC = 1024;
        zzaUD = 768;
        zzaUJ = new HashMap();
    }


    private Camera zzBZ()
    {
        int i = zzjn(zzaUz);
        if (i == -1)
        {
            throw new RuntimeException("Could not find requested camera.");
        }
        Camera camera = Camera.open(i);
        zze zze1 = zza(camera, zzaUC, zzaUD);
        if (zze1 == null)
        {
            throw new RuntimeException("Could not find suitable preview size.");
        }
        Size size = zze1.zzCb();
        zzaUA = zze1.zzCa();
        int ai[] = zza(camera, zzaUB);
        if (ai == null)
        {
            throw new RuntimeException("Could not find suitable preview frames per second range.");
        } else
        {
            android.hardware.Camera.Parameters parameters = camera.getParameters();
            parameters.setPictureSize(size.getWidth(), size.getHeight());
            parameters.setPreviewSize(zzaUA.getWidth(), zzaUA.getHeight());
            parameters.setPreviewFpsRange(ai[0], ai[1]);
            parameters.setPreviewFormat(17);
            zza(camera, parameters, i);
            camera.setParameters(parameters);
            camera.setPreviewCallbackWithBuffer(new zza());
            camera.addCallbackBuffer(zza(zzaUA));
            camera.addCallbackBuffer(zza(zzaUA));
            camera.addCallbackBuffer(zza(zzaUA));
            camera.addCallbackBuffer(zza(zzaUA));
            return camera;
        }
    }

    static float zza(CameraSource camerasource, float f)
    {
        camerasource.zzaUB = f;
        return f;
    }

    static int zza(CameraSource camerasource, int i)
    {
        camerasource.zzaUC = i;
        return i;
    }

    static Context zza(CameraSource camerasource, Context context)
    {
        camerasource.mContext = context;
        return context;
    }

    static zzb zza(CameraSource camerasource, zzb zzb1)
    {
        camerasource.zzaUI = zzb1;
        return zzb1;
    }

    private static zze zza(Camera camera, int i, int j)
    {
        List list = zza(camera);
        camera = null;
        int k = 0x7fffffff;
        Iterator iterator = list.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            zze zze1 = (zze)iterator.next();
            Size size = zze1.zzCa();
            int l = Math.abs(size.getWidth() - i);
            l = Math.abs(size.getHeight() - j) + l;
            if (l < k)
            {
                camera = zze1;
                k = l;
            }
        } while (true);
        return camera;
    }

    static Object zza(CameraSource camerasource)
    {
        return camerasource.zzaUx;
    }

    private static List zza(Camera camera)
    {
        Object obj = camera.getParameters();
        camera = ((android.hardware.Camera.Parameters) (obj)).getSupportedPreviewSizes();
        List list = ((android.hardware.Camera.Parameters) (obj)).getSupportedPictureSizes();
        obj = new ArrayList();
        Iterator iterator = camera.iterator();
label0:
        do
        {
            if (iterator.hasNext())
            {
                android.hardware.Camera.Size size = (android.hardware.Camera.Size)iterator.next();
                float f = (float)size.width / (float)size.height;
                int i = list.size() - 1;
                do
                {
                    if (i < 0)
                    {
                        continue label0;
                    }
                    android.hardware.Camera.Size size1 = (android.hardware.Camera.Size)list.get(i);
                    if (Math.abs(f - (float)size1.width / (float)size1.height) < 0.01F)
                    {
                        ((List) (obj)).add(new zze(size, size1));
                        continue label0;
                    }
                    i--;
                } while (true);
            }
            if (((List) (obj)).size() == 0)
            {
                Log.w("CameraSource", "No preview sizes have a corresponding same-aspect-ratio picture size");
                for (camera = camera.iterator(); camera.hasNext(); ((List) (obj)).add(new zze((android.hardware.Camera.Size)camera.next(), null))) { }
            }
            return ((List) (obj));
        } while (true);
    }

    private void zza(Camera camera, android.hardware.Camera.Parameters parameters, int i)
    {
        int j = ((WindowManager)mContext.getSystemService("window")).getDefaultDisplay().getRotation();
        j;
        JVM INSTR tableswitch 0 3: default 56
    //                   0 156
    //                   1 162
    //                   2 169
    //                   3 177;
           goto _L1 _L2 _L3 _L4 _L5
_L5:
        break MISSING_BLOCK_LABEL_177;
_L1:
        Log.e("CameraSource", (new StringBuilder()).append("Bad rotation value: ").append(j).toString());
        j = 0;
_L6:
        android.hardware.Camera.CameraInfo camerainfo = new android.hardware.Camera.CameraInfo();
        Camera.getCameraInfo(i, camerainfo);
        if (camerainfo.facing == 1)
        {
            j = (j + camerainfo.orientation) % 360;
            i = (360 - j) % 360;
        } else
        {
            i = ((camerainfo.orientation - j) + 360) % 360;
            j = i;
        }
        zzzS = j / 90;
        camera.setDisplayOrientation(i);
        parameters.setRotation(j);
        return;
_L2:
        j = 0;
          goto _L6
_L3:
        j = 90;
          goto _L6
_L4:
        j = 180;
          goto _L6
        j = 270;
          goto _L6
    }

    private byte[] zza(Size size)
    {
        size = ByteBuffer.allocateDirect((int)Math.ceil((double)(long)(ImageFormat.getBitsPerPixel(17) * (size.getHeight() * size.getWidth())) / 8D) + 1);
        zzaUJ.put(size.array(), size);
        return size.array();
    }

    private int[] zza(Camera camera, float f)
    {
        int k = (int)(1000F * f);
        Object obj = null;
        int i = 0x7fffffff;
        Iterator iterator = camera.getParameters().getSupportedPreviewFpsRange().iterator();
        camera = obj;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            int ai[] = (int[])iterator.next();
            int j = ai[0];
            int l = ai[1];
            j = Math.abs(k - j) + Math.abs(k - l);
            if (j < i)
            {
                camera = ai;
                i = j;
            }
        } while (true);
        return camera;
    }

    static int zzb(CameraSource camerasource, int i)
    {
        camerasource.zzaUD = i;
        return i;
    }

    static Camera zzb(CameraSource camerasource)
    {
        return camerasource.zzaUy;
    }

    static int zzc(CameraSource camerasource, int i)
    {
        camerasource.zzaUz = i;
        return i;
    }

    static zzb zzc(CameraSource camerasource)
    {
        return camerasource.zzaUI;
    }

    static Thread zzd(CameraSource camerasource)
    {
        return camerasource.zzaUH;
    }

    static Map zze(CameraSource camerasource)
    {
        return camerasource.zzaUJ;
    }

    static int zzf(CameraSource camerasource)
    {
        return camerasource.zzzS;
    }

    static Size zzg(CameraSource camerasource)
    {
        return camerasource.zzaUA;
    }

    private static int zzjn(int i)
    {
        android.hardware.Camera.CameraInfo camerainfo = new android.hardware.Camera.CameraInfo();
        for (int j = 0; j < Camera.getNumberOfCameras(); j++)
        {
            Camera.getCameraInfo(j, camerainfo);
            if (camerainfo.facing == i)
            {
                return j;
            }
        }

        return -1;
    }

    public int getCameraFacing()
    {
        return zzaUz;
    }

    public Size getPreviewSize()
    {
        return zzaUA;
    }

    public void release()
    {
        synchronized (zzaUx)
        {
            stop();
            zzaUI.release();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public CameraSource start()
        throws IOException
    {
label0:
        {
            synchronized (zzaUx)
            {
                if (zzaUy == null)
                {
                    break label0;
                }
            }
            return this;
        }
        zzaUy = zzBZ();
        if (android.os.Build.VERSION.SDK_INT < 11)
        {
            break MISSING_BLOCK_LABEL_109;
        }
        zzaUF = new SurfaceTexture(100);
        zzaUy.setPreviewTexture(zzaUF);
        zzaUG = true;
_L1:
        zzaUy.startPreview();
        zzaUH = new Thread(zzaUI);
        zzaUI.setActive(true);
        zzaUH.start();
        obj;
        JVM INSTR monitorexit ;
        return this;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        zzaUE = new SurfaceView(mContext);
        zzaUy.setPreviewDisplay(zzaUE.getHolder());
        zzaUG = false;
          goto _L1
    }

    public CameraSource start(SurfaceHolder surfaceholder)
        throws IOException
    {
label0:
        {
            synchronized (zzaUx)
            {
                if (zzaUy == null)
                {
                    break label0;
                }
            }
            return this;
        }
        zzaUy = zzBZ();
        zzaUy.setPreviewDisplay(surfaceholder);
        zzaUy.startPreview();
        zzaUH = new Thread(zzaUI);
        zzaUI.setActive(true);
        zzaUH.start();
        zzaUG = false;
        obj;
        JVM INSTR monitorexit ;
        return this;
        surfaceholder;
        obj;
        JVM INSTR monitorexit ;
        throw surfaceholder;
    }

    public void stop()
    {
        Object obj = zzaUx;
        obj;
        JVM INSTR monitorenter ;
        Thread thread;
        zzaUI.setActive(false);
        thread = zzaUH;
        if (thread == null) goto _L2; else goto _L1
_L1:
        zzaUH.join();
_L7:
        zzaUH = null;
_L2:
        if (zzaUy == null) goto _L4; else goto _L3
_L3:
        zzaUy.stopPreview();
        zzaUy.setPreviewCallbackWithBuffer(null);
        if (!zzaUG) goto _L6; else goto _L5
_L5:
        zzaUy.setPreviewTexture(null);
_L8:
        zzaUy.release();
        zzaUy = null;
_L4:
        obj;
        JVM INSTR monitorexit ;
        return;
        Object obj1;
        obj1;
        Log.d("CameraSource", "Frame processing thread interrupted on release.");
          goto _L7
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
_L6:
        zzaUy.setPreviewDisplay(null);
          goto _L8
        obj1;
        Log.e("CameraSource", (new StringBuilder()).append("Failed to clear camera preview: ").append(obj1).toString());
          goto _L8
    }

    public void takePicture(ShutterCallback shuttercallback, PictureCallback picturecallback)
    {
        synchronized (zzaUx)
        {
            if (zzaUy != null)
            {
                zzd zzd1 = new zzd();
                zzd.zza(zzd1, shuttercallback);
                shuttercallback = new zzc();
                zzc.zza(shuttercallback, picturecallback);
                zzaUy.takePicture(zzd1, null, null, shuttercallback);
            }
        }
        return;
        shuttercallback;
        obj;
        JVM INSTR monitorexit ;
        throw shuttercallback;
    }
}
