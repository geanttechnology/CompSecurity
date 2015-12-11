// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ImageFormat;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.util.SparseArray;
import android.view.Display;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import co.vine.android.VineNotSupportedException;
import co.vine.android.util.CrashUtil;
import co.vine.android.util.IntentionalObjectCounter;
import co.vine.android.util.MathUtil;
import com.edisonwang.android.slog.SLog;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

// Referenced classes of package co.vine.android.recorder:
//            CameraSetting, RecordConfigUtils, RecordController, BasicVineRecorder

public class CameraManager
    implements android.hardware.Camera.OnZoomChangeListener
{
    private class AddBufferThread extends Thread
    {

        final CameraManager this$0;

        public void run()
        {
            do
            {
                Object obj;
label0:
                {
label1:
                    {
                        if (mRunAddBufferThread)
                        {
                            if (mCamera == null)
                            {
                                continue;
                            }
                            obj = (byte[])mAddArray.poll();
                            if (obj != null)
                            {
                                break label1;
                            }
                            try
                            {
                                Thread.sleep(50L);
                                continue;
                            }
                            // Misplaced declaration of an exception variable
                            catch (Object obj) { }
                        }
                        obj = new ArrayList();
                        do
                        {
                            byte abyte0[] = (byte[])mAddArray.poll();
                            if (abyte0 == null)
                            {
                                break;
                            }
                            if (mCamera != null)
                            {
                                addCallbackBuffer(abyte0);
                            } else
                            {
                                ((ArrayList) (obj)).add(abyte0);
                            }
                        } while (true);
                        break label0;
                    }
                    addCallbackBuffer(((byte []) (obj)));
                    continue;
                }
                mBufferArray.addAll(((java.util.Collection) (obj)));
                return;
            } while (true);
        }

        public AddBufferThread()
        {
            this$0 = CameraManager.this;
            super("AddBufferThread");
        }
    }

    private static class DummySurfaceHolder
        implements SurfaceHolder
    {

        private final Surface mSurface;

        public void addCallback(android.view.SurfaceHolder.Callback callback)
        {
        }

        public Surface getSurface()
        {
            return mSurface;
        }

        public Rect getSurfaceFrame()
        {
            return null;
        }

        public boolean isCreating()
        {
            return false;
        }

        public Canvas lockCanvas()
        {
            return null;
        }

        public Canvas lockCanvas(Rect rect)
        {
            return null;
        }

        public void removeCallback(android.view.SurfaceHolder.Callback callback)
        {
        }

        public void setFixedSize(int i, int j)
        {
        }

        public void setFormat(int i)
        {
        }

        public void setKeepScreenOn(boolean flag)
        {
        }

        public void setSizeFromLayout()
        {
        }

        public void setType(int i)
        {
        }

        public void unlockCanvasAndPost(Canvas canvas)
        {
        }

        public DummySurfaceHolder(Surface surface)
        {
            mSurface = surface;
        }
    }

    public static class InvalidPreviewSizeException extends Exception
    {

        public InvalidPreviewSizeException(String s)
        {
            super(s);
        }
    }

    public class StartPreviewThread extends Thread
    {

        private final RecordConfigUtils.RecordConfig config;
        private final long currentDuration;
        private final int frameRate;
        private boolean releasedAlready;
        final CameraManager this$0;

        public void notifyReleasedAlready()
        {
            releasedAlready = true;
        }

        public void run()
        {
            Object obj1 = new AddBufferThread();
            if (mController == null) goto _L2; else goto _L1
_L1:
            int i;
            i = config.maxDuration;
            i = Math.max((int)((float)(config.bufferCount * (frameRate / config.targetFrameRate)) * ((float)((long)i - currentDuration) / (float)i)), 30) / 10;
            CrashUtil.log("Buffer count: {}.", new Object[] {
                Integer.valueOf(i)
            });
            releasedAlready = false;
            Object obj = mLOCK;
            obj;
            JVM INSTR monitorenter ;
            if (mCamera == null || releasedAlready) goto _L4; else goto _L3
_L3:
            Iterator iterator = mAddedBufferArray.iterator();
            int k = i;
_L6:
            i = k;
            if (!iterator.hasNext())
            {
                break; /* Loop/switch isn't completed */
            }
            byte abyte1[] = (byte[])iterator.next();
            mCamera.addCallbackBuffer(abyte1);
            k--;
            if (true) goto _L6; else goto _L5
_L4:
            releasedAlready = true;
            CrashUtil.log("Camera was released already.");
_L5:
            obj;
            JVM INSTR monitorexit ;
            k = i;
            if (!releasedAlready)
            {
                obj = mBufferArray.iterator();
                do
                {
                    k = i;
                    if (!((Iterator) (obj)).hasNext())
                    {
                        break;
                    }
                    byte abyte0[] = (byte[])((Iterator) (obj)).next();
                    addCallbackBuffer(abyte0);
                    i--;
                } while (true);
            }
            break MISSING_BLOCK_LABEL_267;
            obj1;
            obj;
            JVM INSTR monitorexit ;
            throw obj1;
            long l1;
            CrashUtil.log("After reused buffer count: {}.", new Object[] {
                Integer.valueOf(k)
            });
            l1 = System.currentTimeMillis();
            obj = mLOCK;
            obj;
            JVM INSTR monitorenter ;
            if (mCamera == null || releasedAlready) goto _L8; else goto _L7
_L7:
            mCamera.setPreviewCallbackWithBuffer(mController);
            mControllerId = String.valueOf(mController);
            CrashUtil.log((new StringBuilder()).append("Current camera callback: ").append(mControllerId).toString());
_L16:
            System.gc();
            if (releasedAlready) goto _L10; else goto _L9
_L9:
            boolean flag;
            boolean flag1;
            flag1 = false;
            flag = false;
            i = ((flag1) ? 1 : 0);
            if (!config.preAllocateBuffer) goto _L12; else goto _L11
_L11:
            i = ((flag1) ? 1 : 0);
            if (CameraManager.hasPreallocateBuffers) goto _L12; else goto _L13
_L13:
            i = (int)((double)(mFrameSize * (k - mBufferArray.size())) * config.preAllocRatio);
            CrashUtil.log("Pre-allocate buffer {}: {}.", new Object[] {
                Double.valueOf(config.preAllocRatio), Integer.valueOf(i)
            });
            CameraManager.hasPreallocateBuffers = true;
            obj = new byte[i];
            i = ((flag) ? 1 : 0);
_L14:
            mSharedByteBuffer = ByteBuffer.wrap(new byte[mFrameSize]);
            if (obj != null)
            {
                obj[0] = 1;
            }
            System.gc();
_L12:
            int l = k;
            if (i != 0)
            {
                l = k;
                if (config.preAllocRatio <= 1.0D)
                {
                    l = (int)((double)k * 0.5D);
                }
            }
            k = Math.max(l, 0);
            CameraManager cameramanager;
            boolean flag2;
            if (mSharedByteBuffer == null)
            {
                i = mFrameSize;
                obj = (byte[][])Array.newInstance(Byte.TYPE, new int[] {
                    k + 1, i
                });
                mSharedByteBuffer = ByteBuffer.wrap(obj[k]);
            } else
            {
                int j = mFrameSize;
                obj = (byte[][])Array.newInstance(Byte.TYPE, new int[] {
                    k, j
                });
            }
            cameramanager = CameraManager.this;
            if (!releasedAlready)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            cameramanager.mRunAddBufferThread = flag2;
            ((AddBufferThread) (obj1)).start();
            for (i = 0; i < k; i++)
            {
                if (i % 15 == 1)
                {
                    CrashUtil.log("Add buffer {}.", new Object[] {
                        Integer.valueOf(i)
                    });
                }
                addBuffer(obj[i], false);
            }

            break; /* Loop/switch isn't completed */
_L8:
            releasedAlready = true;
            continue; /* Loop/switch isn't completed */
            obj1;
            obj;
            JVM INSTR monitorexit ;
            throw obj1;
            obj;
            obj = null;
            i = 1;
            CrashUtil.log("Pre-allocation failed with ratio {}, ignore pre-allocation step.", new Object[] {
                Double.valueOf(config.preAllocRatio)
            });
            if (true) goto _L14; else goto _L10
_L10:
            SLog.d("Waiting for adding to be done.");
            mRunAddBufferThread = false;
            CrashUtil.log("Making buffer took {} ms.", new Object[] {
                Long.valueOf(System.currentTimeMillis() - l1)
            });
_L2:
            synchronized (mLOCK)
            {
                if (mCamera != null && !releasedAlready)
                {
                    mLastPreviewFrameTimestamp = -1L;
                    mFramesReceived = 0L;
                    mPreviewStartTime = System.currentTimeMillis();
                    mCamera.startPreview();
                }
            }
            try
            {
                ((AddBufferThread) (obj1)).join();
                return;
            }
            catch (InterruptedException interruptedexception)
            {
                SLog.e("Couldn't wait for add thread to join.");
            }
            break MISSING_BLOCK_LABEL_924;
            exception;
            ai;
            JVM INSTR monitorexit ;
            throw exception;
            return;
            if (true) goto _L16; else goto _L15
_L15:
        }

        public StartPreviewThread(int i, long l)
        {
            this$0 = CameraManager.this;
            super("StartPreviewThread");
            frameRate = i;
            currentDuration = l;
            config = mController.mParent.getConfig();
        }
    }


    private static CameraManager INSTANCE;
    private static boolean hasPreallocateBuffers;
    private static final Integer mBackFacing[];
    private static final Integer mFrontFacing[];
    public static int sCameraBufferCount;
    private static final SparseArray sCameraInfoTable;
    private static final SparseArray sCameraSettingTable;
    private volatile boolean isPreviewing;
    private final ConcurrentLinkedQueue mAddArray = new ConcurrentLinkedQueue();
    private final Set mAddedBufferArray = Collections.newSetFromMap(new ConcurrentHashMap());
    private boolean mAutoStopZoomCalled;
    private final ConcurrentLinkedQueue mBufferArray = new ConcurrentLinkedQueue();
    private Camera mCamera;
    private CameraSetting mCameraSetting;
    private RecordController mController;
    private String mControllerId;
    private int mCurrentCamera;
    private int mCurrentZoomTarget;
    private ArrayList mFocusArea;
    private int mFrameSize;
    private long mFramesReceived;
    private final IntentionalObjectCounter mIntentionalObjectCounter = new IntentionalObjectCounter("recorder", this);
    private boolean mIsCurrentFront;
    private boolean mIsSmoothZoomSupported;
    private boolean mIsSmoothZooming;
    private boolean mIsSmoothZoomingStopCalled;
    private final int mLOCK[] = new int[0];
    private long mLastPreviewFrameTimestamp;
    private final Matrix mMatrix = new Matrix();
    private int mMaxZoom;
    private long mMaxtimeElapsed;
    private int mPreviewHeight;
    private long mPreviewStartTime;
    private int mPreviewWidth;
    private int mRequestedZoom;
    private volatile boolean mRunAddBufferThread;
    private ByteBuffer mSharedByteBuffer;
    private StartPreviewThread mStartPreviewThread;

    private CameraManager()
    {
        mIsCurrentFront = false;
        mCurrentCamera = -1;
        mMaxtimeElapsed = -1L;
    }

    private void calculateTapArea(int i, int j, float f, int k, int l, int i1, int j1, 
            Rect rect)
    {
        i = (int)((float)i * f);
        j = (int)((float)j * f);
        k = MathUtil.clamp(k - i / 2, 0, i1 - i);
        l = MathUtil.clamp(l - j / 2, 0, j1 - j);
        RectF rectf = new RectF(k, l, k + i, l + j);
        mMatrix.mapRect(rectf);
        MathUtil.rectFToRect(rectf, rect);
    }

    private void disableVideoStab(android.hardware.Camera.Parameters parameters)
    {
        if (android.os.Build.VERSION.SDK_INT >= 15 && parameters.isVideoStabilizationSupported())
        {
            parameters.setVideoStabilization(false);
        }
    }

    public static int getCameraDisplayOrientation(int i, int j)
    {
        co/vine/android/recorder/CameraManager;
        JVM INSTR monitorenter ;
        Object obj = (android.hardware.Camera.CameraInfo)sCameraInfoTable.get(j);
        if (obj != null) goto _L2; else goto _L1
_L1:
        obj = new android.hardware.Camera.CameraInfo();
        Camera.getCameraInfo(j, ((android.hardware.Camera.CameraInfo) (obj)));
        sCameraInfoTable.put(j, obj);
_L3:
        SLog.d("Set rotation to {} degrees", Integer.valueOf(i));
        if (((android.hardware.Camera.CameraInfo) (obj)).facing != 1)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        i = (360 - (((android.hardware.Camera.CameraInfo) (obj)).orientation + i) % 360) % 360;
_L4:
        co/vine/android/recorder/CameraManager;
        JVM INSTR monitorexit ;
        return i;
_L2:
        SLog.i("Using cached camera info.");
          goto _L3
        obj;
        throw obj;
        i = ((((android.hardware.Camera.CameraInfo) (obj)).orientation - i) + 360) % 360;
          goto _L4
    }

    public static CameraSetting getCameraInfo(RecordConfigUtils.RecordConfig recordconfig, int i, android.hardware.Camera.Parameters parameters, int j, boolean flag)
        throws VineNotSupportedException
    {
        Object obj;
        int k;
        int j1;
        j = getCameraDisplayOrientation(j, i);
        int i1 = j;
        if (flag)
        {
            i1 = -j;
        }
        obj = (CameraSetting)sCameraSettingTable.get(i);
        if (obj != null)
        {
            recordconfig = new CameraSetting(((CameraSetting) (obj)));
            recordconfig.degrees = i1;
            SLog.i("Using cached camera setting.");
            return recordconfig;
        }
        obj = null;
        Object obj2;
        Integer integer;
        int l;
        int k1;
        try
        {
            obj2 = parameters.getSupportedPreviewFormats();
        }
        catch (NullPointerException nullpointerexception)
        {
            CrashUtil.log("This device sucks, it cannot return params properly.");
            continue; /* Loop/switch isn't completed */
        }
        obj = obj2;
_L8:
label0:
        {
            k = 17;
            l = k;
            if (obj == null)
            {
                break label0;
            }
            obj2 = ((List) (obj)).iterator();
            do
            {
                j = k;
                if (!((Iterator) (obj2)).hasNext())
                {
                    break;
                }
                integer = (Integer)((Iterator) (obj2)).next();
                SLog.d("Supported format: {}", integer);
                if (integer.intValue() != 4)
                {
                    continue;
                }
                j = integer.intValue();
                break;
            } while (true);
            l = j;
            if (j != 17)
            {
                break label0;
            }
            obj = ((List) (obj)).iterator();
            do
            {
                l = j;
                if (!((Iterator) (obj)).hasNext())
                {
                    break label0;
                }
                obj2 = (Integer)((Iterator) (obj)).next();
            } while (((Integer) (obj2)).intValue() != 256);
            l = ((Integer) (obj2)).intValue();
        }
        SLog.d("Selected format: {}.", Integer.valueOf(l));
        if (!CamcorderProfile.hasProfile(i, 4)) goto _L2; else goto _L1
_L1:
        obj = CamcorderProfile.get(i, 4);
        CrashUtil.log("Use default profile");
_L5:
        SLog.d("Preferred FrameRate: {}.", Integer.valueOf(((CamcorderProfile) (obj)).videoFrameRate));
        if (((CamcorderProfile) (obj)).videoFrameRate >= recordconfig.targetFrameRate)
        {
            obj.videoFrameRate = recordconfig.targetFrameRate;
        }
        CrashUtil.log("Original Width * Height: {}/{}", new Object[] {
            Integer.valueOf(((CamcorderProfile) (obj)).videoFrameWidth), Integer.valueOf(((CamcorderProfile) (obj)).videoFrameHeight)
        });
        obj.videoFrameWidth = recordconfig.previewWidth;
        if (((CamcorderProfile) (obj)).videoFrameHeight <= ((CamcorderProfile) (obj)).videoFrameWidth) goto _L4; else goto _L3
_L3:
        if (recordconfig.highQuality)
        {
            j = 480;
        } else
        {
            j = 240;
        }
        obj.videoFrameHeight = j;
_L4:
        SLog.d("Video: {}*{} codec: {} bitRate:{} frameRate:{}.", new Object[] {
            Integer.valueOf(((CamcorderProfile) (obj)).videoFrameWidth), Integer.valueOf(((CamcorderProfile) (obj)).videoFrameHeight), Integer.valueOf(((CamcorderProfile) (obj)).videoCodec), Integer.valueOf(((CamcorderProfile) (obj)).videoBitRate), Integer.valueOf(((CamcorderProfile) (obj)).videoFrameRate)
        });
        SLog.d("Audio: bitRate:{} channels: {} codec: {} sampleRate: {} ", new Object[] {
            Integer.valueOf(((CamcorderProfile) (obj)).audioBitRate), Integer.valueOf(((CamcorderProfile) (obj)).audioChannels), Integer.valueOf(((CamcorderProfile) (obj)).audioCodec), Integer.valueOf(((CamcorderProfile) (obj)).audioSampleRate)
        });
        j = ((CamcorderProfile) (obj)).videoFrameWidth;
        k = ((CamcorderProfile) (obj)).videoFrameHeight;
        j1 = ((CamcorderProfile) (obj)).videoFrameRate;
_L6:
        SLog.d("FFC OR: {}.", Float.valueOf(recordconfig.frontFacingAspectRatioOverride));
        SLog.d("BFC OR: {}.", Float.valueOf(recordconfig.backFacingAspectRatioOverride));
        k1 = k;
        if (j == 640)
        {
            k1 = k;
            if (k != 480)
            {
                CrashUtil.log("Force 480 with 480p.");
                k1 = 480;
            }
        }
        recordconfig = new CameraSetting(j, k1, i1, j1, l, flag, recordconfig.frontFacingAspectRatioOverride, recordconfig.backFacingAspectRatioOverride);
        sCameraSettingTable.put(i, recordconfig);
        recordconfig = new CameraSetting(recordconfig);
        if (!SLog.sLogsOn)
        {
            break MISSING_BLOCK_LABEL_1072;
        }
        obj = parameters.getPreferredPreviewSizeForVideo();
        if (obj != null)
        {
            SLog.d("Preferred Width * Height: {}/{}.", Integer.valueOf(((android.hardware.Camera.Size) (obj)).width), Integer.valueOf(((android.hardware.Camera.Size) (obj)).height));
        }
        obj = parameters.getSupportedVideoSizes();
        if (obj != null)
        {
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); SLog.d("Supported Video Width * Height: {}/{}.", Integer.valueOf(((android.hardware.Camera.Size) (obj2)).width), Integer.valueOf(((android.hardware.Camera.Size) (obj2)).height)))
            {
                obj2 = (android.hardware.Camera.Size)((Iterator) (obj)).next();
            }

        }
        break MISSING_BLOCK_LABEL_945;
_L2:
        obj = CamcorderProfile.get(i, 1);
          goto _L5
        Exception exception;
        exception;
        Object obj3 = parameters.getSupportedPreviewSizes();
        HashSet hashset = new HashSet();
        if (obj3 != null)
        {
            obj3 = ((List) (obj3)).iterator();
            do
            {
                if (!((Iterator) (obj3)).hasNext())
                {
                    break;
                }
                android.hardware.Camera.Size size1 = (android.hardware.Camera.Size)((Iterator) (obj3)).next();
                CrashUtil.log("Supported width and height: {}, {}.", new Object[] {
                    Integer.valueOf(size1.width), Integer.valueOf(size1.height)
                });
                if (size1.height == recordconfig.targetSize)
                {
                    hashset.add(Integer.valueOf(size1.width));
                }
            } while (true);
            if (hashset.isEmpty())
            {
                CrashUtil.log("Edison: Target size is not supported.");
                k = recordconfig.previewHeight;
                j = recordconfig.previewWidth;
            } else
            if (hashset.contains(Integer.valueOf(recordconfig.previewWidth)))
            {
                k = recordconfig.previewHeight;
                j = recordconfig.previewWidth;
            } else
            {
                CrashUtil.log("Edison: Target width is not supported.");
                k = recordconfig.previewHeight;
                j = recordconfig.previewWidth;
            }
        } else
        {
            k = recordconfig.previewHeight;
            j = recordconfig.previewWidth;
        }
        j1 = recordconfig.targetFrameRate;
          goto _L6
        recordconfig;
        throw new VineNotSupportedException(recordconfig);
        Object obj1 = parameters.getSupportedPreviewSizes();
        if (obj1 != null)
        {
            android.hardware.Camera.Size size;
            for (obj1 = ((List) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); SLog.d("Supported Preview Width * Height: {}/{}.", Integer.valueOf(size.width), Integer.valueOf(size.height)))
            {
                size = (android.hardware.Camera.Size)((Iterator) (obj1)).next();
            }

        }
        SLog.d("Camera w/h/f/p/d: {}/{}/{}/{}/{}", new Object[] {
            Integer.valueOf(((CameraSetting) (recordconfig)).originalW), Integer.valueOf(((CameraSetting) (recordconfig)).originalH), Integer.valueOf(((CameraSetting) (recordconfig)).frameRate), Integer.valueOf(parameters.getPreviewFormat()), Integer.valueOf(((CameraSetting) (recordconfig)).degrees)
        });
        return recordconfig;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public static int getCameraRotation(Activity activity)
    {
        switch (activity.getWindowManager().getDefaultDisplay().getRotation())
        {
        case 0: // '\0'
        default:
            return 0;

        case 1: // '\001'
            return 90;

        case 2: // '\002'
            return 180;

        case 3: // '\003'
            return 270;
        }
    }

    public static CameraManager getInstance()
    {
        co/vine/android/recorder/CameraManager;
        JVM INSTR monitorenter ;
        CameraManager cameramanager;
        if (INSTANCE == null)
        {
            INSTANCE = new CameraManager();
        }
        cameramanager = INSTANCE;
        co/vine/android/recorder/CameraManager;
        JVM INSTR monitorexit ;
        return cameramanager;
        Exception exception;
        exception;
        throw exception;
    }

    private String getNextParamValue(boolean flag, List list, String s)
    {
        if (list == null) goto _L2; else goto _L1
_L1:
        int i = 0;
_L9:
        if (i < list.size() && !((String)list.get(i)).equals(s)) goto _L4; else goto _L3
_L3:
        if (!flag) goto _L6; else goto _L5
_L5:
        int j = i + 1;
        i = j;
        if (j >= list.size())
        {
            i = list.size() - 1;
        }
_L7:
        SLog.d("Modify to: {}", list.get(i));
        return (String)list.get(i);
_L4:
        i++;
        continue; /* Loop/switch isn't completed */
_L6:
        int k = i - 1;
        i = k;
        if (k < 0)
        {
            i = 0;
        }
        if (true) goto _L7; else goto _L2
_L2:
        return null;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public static boolean hasBackFacingCamera()
    {
        return mBackFacing.length > 0;
    }

    public static boolean hasCamera()
    {
        return hasBackFacingCamera() || hasFrontFacingCamera();
    }

    public static boolean hasFrontFacingCamera()
    {
        return mFrontFacing.length > 0;
    }

    private void initializeFocusAreas(int i, int j)
    {
        if (mFocusArea == null)
        {
            mFocusArea = new ArrayList();
            mFocusArea.add(new android.hardware.Camera.Area(new Rect(), 1));
        }
        calculateTapArea(100, 100, 1.0F, i, j, mCameraSetting.originalW, mCameraSetting.originalH, ((android.hardware.Camera.Area)mFocusArea.get(0)).rect);
    }

    public static void preLoadCameras(Context context)
        throws VineNotSupportedException
    {
        getInstance().preLoadCameras(RecordConfigUtils.getGenericConfig(context));
    }

    private CameraSetting safeCameraOpen(RecordConfigUtils.RecordConfig recordconfig, boolean flag, int i, int j, boolean flag1)
        throws VineNotSupportedException
    {
        if (i == -1)
        {
            return null;
        }
        int ai[] = mLOCK;
        ai;
        JVM INSTR monitorenter ;
        if (flag1)
        {
            break MISSING_BLOCK_LABEL_29;
        }
        if (mCurrentCamera == i)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        releaseCameraAndPreview("safeCameraOpen");
        if (flag1) goto _L2; else goto _L1
_L1:
        if (mCamera != null && mCurrentCamera == i) goto _L3; else goto _L2
_L2:
        long l = System.currentTimeMillis();
        mCamera = Camera.open(i);
        mCamera.setZoomChangeListener(this);
        SLog.d("Open camera took {}ms.", Long.valueOf(System.currentTimeMillis() - l));
        mIsSmoothZooming = false;
        mAutoStopZoomCalled = false;
        mIsSmoothZoomingStopCalled = false;
        mCurrentZoomTarget = -1;
_L10:
        android.hardware.Camera.Parameters parameters;
        mCameraSetting = null;
        parameters = mCamera.getParameters();
        mMaxZoom = parameters.getMaxZoom();
        if (!RecordConfigUtils.RecordConfig.IS_ZERO_INDEX_BASED_ZOOM) goto _L5; else goto _L4
_L4:
        mMaxZoom = mMaxZoom - 1;
        mRequestedZoom = 0;
_L8:
        if (!RecordConfigUtils.RecordConfig.SHOULD_FORCE_SMOOTH_ZOOM && !parameters.isSmoothZoomSupported())
        {
            flag1 = false;
        } else
        {
            flag1 = true;
        }
        mIsSmoothZoomSupported = flag1;
        if (mCamera == null) goto _L7; else goto _L6
_L6:
        SLog.d("1. Open Camera.");
        mCurrentCamera = i;
        mIsCurrentFront = flag;
        mCameraSetting = getCameraInfo(recordconfig, mCurrentCamera, parameters, j, flag);
        recordconfig = mCameraSetting;
        return recordconfig;
        recordconfig;
        ai;
        JVM INSTR monitorexit ;
        throw recordconfig;
_L3:
        SLog.d("Camera was already opened.");
        continue; /* Loop/switch isn't completed */
        recordconfig;
        throw recordconfig;
_L5:
        mRequestedZoom = 1;
          goto _L8
        recordconfig;
        CrashUtil.logException(recordconfig);
_L7:
        ai;
        JVM INSTR monitorexit ;
        return null;
        if (true) goto _L10; else goto _L9
_L9:
    }

    private void startPreview(RecordConfigUtils.RecordConfig recordconfig, Surface surface, SurfaceTexture surfacetexture, boolean flag, boolean flag1, int i, int j, 
            int k)
        throws InvalidPreviewSizeException
    {
        int ai[] = mLOCK;
        ai;
        JVM INSTR monitorenter ;
        if (!isPreviewing)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        SLog.d("Do not preview again.");
        return;
        if (mCamera == null) goto _L2; else goto _L1
_L1:
        SLog.d("2,3: Set preview display and start preview.");
        if (surface == null) goto _L4; else goto _L3
_L3:
        mCamera.setPreviewDisplay(new DummySurfaceHolder(surface));
_L9:
        isPreviewing = true;
        surface = mCamera.getParameters();
        j = fixOrientation(j);
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        startContinuousAutoFocus(surface);
        if (!flag) goto _L6; else goto _L5
_L5:
        changeFlashState(true);
          goto _L6
_L11:
        surface.setPreviewSize(mPreviewWidth, mPreviewHeight);
        surface.setPictureSize(mPreviewWidth, mPreviewHeight);
        surface.set("video-size", (new StringBuilder()).append(Integer.toString(mPreviewWidth)).append("x").append(Integer.toString(mPreviewHeight)).toString());
        if (RecordConfigUtils.RecordConfig.DISABLE_FACE_RECOGNITION)
        {
            surface.set("face-detection", "off");
        }
        if ((!mIsCurrentFront || !recordconfig.frontFacingRecordingHint) && (mIsCurrentFront || !recordconfig.backFacingRecordingHint))
        {
            flag1 = false;
        } else
        {
            flag1 = true;
        }
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_227;
        }
        surface.setRecordingHint(true);
        CrashUtil.log("Set preview size: {} * {}, {}, {}.", new Object[] {
            Integer.valueOf(mPreviewWidth), Integer.valueOf(mPreviewHeight), Boolean.valueOf(flag), Boolean.valueOf(flag1)
        });
        surface.setPreviewFormat(17);
        disableVideoStab(surface);
        mCamera.setParameters(surface);
        if (SLog.sLogsOn)
        {
            SLog.d("Starting params: {}.", mCamera.getParameters().flatten());
        }
        mStartPreviewThread = new StartPreviewThread(i, k);
        mStartPreviewThread.start();
_L2:
        ai;
        JVM INSTR monitorexit ;
        return;
        ai;
        JVM INSTR monitorexit ;
        throw recordconfig;
_L4:
        if (surfacetexture == null) goto _L8; else goto _L7
_L7:
        mCamera.setPreviewTexture(surfacetexture);
          goto _L9
_L12:
        isPreviewing = false;
        CrashUtil.log("Failed to startPreview: {}.", new Object[] {
            recordconfig.getMessage()
        });
        if (!(recordconfig instanceof InvalidPreviewSizeException)) goto _L2; else goto _L10
_L10:
        throw (InvalidPreviewSizeException)recordconfig;
_L8:
        SLog.d("Surface is not ready, wait...");
        ai;
        JVM INSTR monitorexit ;
        return;
_L14:
        flag = false;
          goto _L11
        recordconfig;
        try
        {
            throw new InvalidPreviewSizeException(recordconfig.getMessage());
        }
        // Misplaced declaration of an exception variable
        catch (RecordConfigUtils.RecordConfig recordconfig) { }
        finally { }
          goto _L12
_L6:
        if (j != 90 && j != 270) goto _L14; else goto _L13
_L13:
        flag = true;
          goto _L11
    }

    public void addBuffer(byte abyte0[], boolean flag)
    {
        int ai[] = mLOCK;
        ai;
        JVM INSTR monitorenter ;
        if (abyte0 == null) goto _L2; else goto _L1
_L1:
        if (!flag) goto _L4; else goto _L3
_L3:
        mBufferArray.offer(abyte0);
_L2:
        ai;
        JVM INSTR monitorexit ;
        return;
_L4:
        if (mCamera == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        if (mRunAddBufferThread)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        addCallbackBuffer(abyte0);
          goto _L2
        abyte0;
        ai;
        JVM INSTR monitorexit ;
        throw abyte0;
        mAddArray.offer(abyte0);
          goto _L2
        mBufferArray.offer(abyte0);
          goto _L2
    }

    public void addCallbackBuffer(byte abyte0[])
    {
        int ai[] = mLOCK;
        ai;
        JVM INSTR monitorenter ;
        if (mCamera == null)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        mCamera.addCallbackBuffer(abyte0);
        sCameraBufferCount++;
        mAddedBufferArray.add(abyte0);
_L2:
        return;
        SLog.e("Buffer couldn't be added.");
        if (true) goto _L2; else goto _L1
_L1:
        abyte0;
        ai;
        JVM INSTR monitorexit ;
        throw abyte0;
    }

    public boolean autoFocus(android.hardware.Camera.AutoFocusCallback autofocuscallback)
    {
        try
        {
            mCamera.autoFocus(autofocuscallback);
        }
        // Misplaced declaration of an exception variable
        catch (android.hardware.Camera.AutoFocusCallback autofocuscallback)
        {
            CrashUtil.logException(autofocuscallback, "Failed to autoFocus.", new Object[0]);
            return false;
        }
        return true;
    }

    public boolean canChangeFocus()
    {
label0:
        {
            boolean flag1 = false;
            boolean flag = flag1;
            int i;
            try
            {
                if (mCamera == null)
                {
                    break label0;
                }
                i = mCamera.getParameters().getMaxNumFocusAreas();
            }
            catch (Exception exception)
            {
                return false;
            }
            flag = flag1;
            if (i > 0)
            {
                flag = true;
            }
        }
        return flag;
    }

    public void changeFlashState(boolean flag)
    {
        android.hardware.Camera.Parameters parameters = mCamera.getParameters();
        String s;
        if (flag)
        {
            s = "torch";
        } else
        {
            s = "off";
        }
        parameters.setFlashMode(s);
        mCamera.setParameters(parameters);
    }

    public int fixOrientation(int i)
    {
        int ai[] = mLOCK;
        ai;
        JVM INSTR monitorenter ;
        int j = 0;
        if (mCamera == null)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        i = getCameraDisplayOrientation(i, mCurrentCamera);
        mCamera.setDisplayOrientation(i);
        SLog.d("Fixed orientation: {}", Integer.valueOf(i));
        j = i;
        if (mPreviewWidth == 0)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        j = i;
        if (mPreviewHeight == 0)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        Matrix matrix = new Matrix();
        MathUtil.prepareMatrix(matrix, mIsCurrentFront, i, mPreviewWidth, mPreviewHeight);
        matrix.invert(mMatrix);
        j = i;
        ai;
        JVM INSTR monitorexit ;
        return j;
        Exception exception;
        exception;
        ai;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public int getAddedBufferArrayCount()
    {
        return mAddedBufferArray.size();
    }

    public Camera getCamera()
    {
        return mCamera;
    }

    public CameraSetting getCameraSetting()
    {
        return mCameraSetting;
    }

    public String getControllerId()
    {
        return mControllerId;
    }

    public int getDefaultCameraId(boolean flag)
    {
        int i = -1;
        if (flag)
        {
            if (hasFrontFacingCamera())
            {
                i = mFrontFacing[0].intValue();
            }
        } else
        if (hasBackFacingCamera())
        {
            return mBackFacing[0].intValue();
        }
        return i;
    }

    public int getFrameSize()
    {
        return mFrameSize;
    }

    public int getMaxZoom()
    {
        return mMaxZoom;
    }

    public android.hardware.Camera.Parameters getParameters()
    {
        if (mCamera != null)
        {
            return mCamera.getParameters();
        } else
        {
            return null;
        }
    }

    public ByteBuffer getSharedByteBuffer()
    {
        return mSharedByteBuffer;
    }

    public boolean isCameraReady()
    {
        return mCamera != null && mCameraSetting != null;
    }

    public boolean isFlashSupported()
    {
        Object obj;
        boolean flag1;
        flag1 = true;
        obj = mCamera.getParameters().getSupportedFlashModes();
        if (obj != null && ((List) (obj)).size() != 0) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        obj = ((List) (obj)).iterator();
label0:
        do
        {
label1:
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break label1;
                }
                String s = (String)((Iterator) (obj)).next();
                flag = flag1;
                if ("on".equals(s))
                {
                    continue;
                }
                if ("torch".equals(s))
                {
                    return true;
                }
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
        return false;
    }

    public boolean isFrameAdded(byte abyte0[])
    {
        return mAddedBufferArray.contains(abyte0);
    }

    public boolean isPreviewing()
    {
        return isPreviewing;
    }

    public boolean isSmoothZoomingSupported()
    {
        return mIsSmoothZoomSupported;
    }

    public boolean isZoomSupported()
    {
        return mMaxZoom > 1;
    }

    protected void lock()
    {
        SLog.d("5d. Lock Camera");
        mCamera.lock();
    }

    public void modifyAntiBanding(boolean flag)
    {
        int ai[] = mLOCK;
        ai;
        JVM INSTR monitorenter ;
        Object obj = mCamera;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        String s;
        obj = mCamera.getParameters();
        s = getNextParamValue(flag, ((android.hardware.Camera.Parameters) (obj)).getSupportedAntibanding(), ((android.hardware.Camera.Parameters) (obj)).getAntibanding());
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        ((android.hardware.Camera.Parameters) (obj)).setAntibanding(s);
        mCamera.setParameters(((android.hardware.Camera.Parameters) (obj)));
        mCamera.setParameters(((android.hardware.Camera.Parameters) (obj)));
_L1:
        ai;
        JVM INSTR monitorexit ;
        return;
        Object obj1;
        obj1;
        SLog.d("It just didn't work.");
          goto _L1
        obj1;
        ai;
        JVM INSTR monitorexit ;
        throw obj1;
    }

    public void modifyColorEffects(boolean flag)
    {
        int ai[] = mLOCK;
        ai;
        JVM INSTR monitorenter ;
        Object obj = mCamera;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        String s;
        obj = mCamera.getParameters();
        s = getNextParamValue(flag, ((android.hardware.Camera.Parameters) (obj)).getSupportedColorEffects(), ((android.hardware.Camera.Parameters) (obj)).getColorEffect());
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        ((android.hardware.Camera.Parameters) (obj)).setColorEffect(s);
        mCamera.setParameters(((android.hardware.Camera.Parameters) (obj)));
        mCamera.setParameters(((android.hardware.Camera.Parameters) (obj)));
_L1:
        ai;
        JVM INSTR monitorexit ;
        return;
        Object obj1;
        obj1;
        SLog.d("It just didn't work.");
          goto _L1
        obj1;
        ai;
        JVM INSTR monitorexit ;
        throw obj1;
    }

    public void modifyExposure(boolean flag)
    {
        int ai[] = mLOCK;
        ai;
        JVM INSTR monitorenter ;
        Object obj = mCamera;
        if (obj == null) goto _L2; else goto _L1
_L1:
        double d;
        int i;
        int j;
        int k;
        obj = mCamera.getParameters();
        k = ((android.hardware.Camera.Parameters) (obj)).getExposureCompensation();
        i = ((android.hardware.Camera.Parameters) (obj)).getMaxExposureCompensation();
        j = ((android.hardware.Camera.Parameters) (obj)).getMinExposureCompensation();
        d = (double)(i - j) / 10D;
        if (!flag) goto _L4; else goto _L3
_L3:
        j = (int)Math.floor((double)k + d);
        if (j < i)
        {
            i = j;
        }
        ((android.hardware.Camera.Parameters) (obj)).setExposureCompensation(i);
_L5:
        mCamera.setParameters(((android.hardware.Camera.Parameters) (obj)));
_L2:
        ai;
        JVM INSTR monitorexit ;
        return;
_L4:
        double d1 = k;
        i = (int)Math.floor(d1 - d);
        if (i <= j)
        {
            i = j;
        }
        ((android.hardware.Camera.Parameters) (obj)).setExposureCompensation(i);
          goto _L5
        Object obj1;
        obj1;
        SLog.d("It just didn't work.");
          goto _L2
        obj1;
        ai;
        JVM INSTR monitorexit ;
        throw obj1;
          goto _L5
    }

    public void modifySceneMode(boolean flag)
    {
        int ai[] = mLOCK;
        ai;
        JVM INSTR monitorenter ;
        Object obj = mCamera;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        String s;
        obj = mCamera.getParameters();
        s = getNextParamValue(flag, ((android.hardware.Camera.Parameters) (obj)).getSupportedSceneModes(), ((android.hardware.Camera.Parameters) (obj)).getSceneMode());
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        ((android.hardware.Camera.Parameters) (obj)).setSceneMode(s);
        mCamera.setParameters(((android.hardware.Camera.Parameters) (obj)));
_L1:
        ai;
        JVM INSTR monitorexit ;
        return;
        Object obj1;
        obj1;
        SLog.d("It just didn't work.");
          goto _L1
        obj1;
        ai;
        JVM INSTR monitorexit ;
        throw obj1;
    }

    public void modifyWhiteBalance(boolean flag)
    {
        int ai[] = mLOCK;
        ai;
        JVM INSTR monitorenter ;
        Object obj = mCamera;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        String s;
        obj = mCamera.getParameters();
        s = getNextParamValue(flag, ((android.hardware.Camera.Parameters) (obj)).getSupportedWhiteBalance(), ((android.hardware.Camera.Parameters) (obj)).getWhiteBalance());
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        ((android.hardware.Camera.Parameters) (obj)).setWhiteBalance(s);
        mCamera.setParameters(((android.hardware.Camera.Parameters) (obj)));
_L1:
        ai;
        JVM INSTR monitorexit ;
        return;
        Object obj1;
        obj1;
        SLog.d("It just didn't work.");
          goto _L1
        obj1;
        ai;
        JVM INSTR monitorexit ;
        throw obj1;
    }

    public int modifyZoom(int i)
    {
        boolean flag = false;
        int ai[] = mLOCK;
        ai;
        JVM INSTR monitorenter ;
        if (mCamera == null) goto _L2; else goto _L1
_L1:
        int j;
        byte byte0;
        byte0 = 0;
        j = i;
        if (RecordConfigUtils.RecordConfig.IS_ZERO_INDEX_BASED_ZOOM)
        {
            j = i - 1;
            byte0 = -1;
        }
        if (j == mRequestedZoom || j > mMaxZoom || j <= byte0) goto _L2; else goto _L3
_L3:
        if (j > mRequestedZoom)
        {
            flag = true;
        }
        mRequestedZoom = j;
        SLog.d("Modifying waiting to zoom to {} using smooth? {}.", Integer.valueOf(mRequestedZoom), Boolean.valueOf(mIsSmoothZoomSupported));
        if (!mIsSmoothZoomSupported) goto _L5; else goto _L4
_L4:
        startSmoothZoom(flag);
_L2:
        ai;
        JVM INSTR monitorexit ;
        return mRequestedZoom;
_L5:
        startInstantZoom();
          goto _L2
        Object obj;
        obj;
        CrashUtil.logException(((Throwable) (obj)), "It just didn't work.", new Object[0]);
          goto _L2
        obj;
        ai;
        JVM INSTR monitorexit ;
        throw obj;
    }

    public int modifyZoom(boolean flag)
    {
        int i;
        int j;
        if (mIsSmoothZoomSupported)
        {
            if (flag)
            {
                i = mMaxZoom;
            } else
            {
                i = 0;
            }
        } else
        if (flag)
        {
            i = mRequestedZoom + 1;
        } else
        {
            i = mRequestedZoom - 1;
        }
        j = i;
        if (RecordConfigUtils.RecordConfig.IS_ZERO_INDEX_BASED_ZOOM)
        {
            j = i + 1;
        }
        return modifyZoom(j);
    }

    public void onPreviewFrameReceived()
    {
        mFramesReceived = mFramesReceived + 1L;
        if (mLastPreviewFrameTimestamp != -1L)
        {
            mMaxtimeElapsed = Math.max(System.currentTimeMillis() - mLastPreviewFrameTimestamp, mMaxtimeElapsed);
        }
        mLastPreviewFrameTimestamp = System.currentTimeMillis();
    }

    public void onZoomChange(int i, boolean flag, Camera camera)
    {
        boolean flag2 = true;
        if (flag)
        {
            SLog.d("Zoom stopped on value {} (target {}, queued value: {}).", Integer.valueOf(i), Integer.valueOf(mCurrentZoomTarget), Integer.valueOf(mRequestedZoom));
            mIsSmoothZooming = false;
            int j;
            boolean flag1;
            if (mCamera != null)
            {
                try
                {
                    startContinuousAutoFocus(mCamera.getParameters());
                }
                // Misplaced declaration of an exception variable
                catch (Camera camera) { }
            }
            if (mIsSmoothZoomingStopCalled)
            {
                mIsSmoothZoomingStopCalled = false;
                if (mRequestedZoom == mCurrentZoomTarget)
                {
                    mRequestedZoom = i;
                }
            }
            if (i != mRequestedZoom && mIsSmoothZoomSupported && mCamera != null)
            {
                if (mRequestedZoom >= i)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                startSmoothZoom(flag1);
            }
        } else
        {
            SLog.d("Zoom updated on value {} (queued value: {}).", Integer.valueOf(i), Integer.valueOf(mRequestedZoom));
            if (mCurrentZoomTarget == i)
            {
                SLog.d("Stop zoom on reaching target.");
                mAutoStopZoomCalled = stopSmoothZoom();
            }
        }
        if (mController != null)
        {
            camera = mController;
            if (RecordConfigUtils.RecordConfig.IS_ZERO_INDEX_BASED_ZOOM)
            {
                j = i + 1;
            } else
            {
                j = i;
            }
            if (flag && i == mRequestedZoom)
            {
                flag1 = flag2;
            } else
            {
                flag1 = false;
            }
            camera.onZoomUpdated(j, flag1);
            if (flag)
            {
                mAutoStopZoomCalled = false;
            }
        }
    }

    public CameraSetting openDefaultCamera(RecordConfigUtils.RecordConfig recordconfig, boolean flag, int i, boolean flag1)
        throws VineNotSupportedException
    {
        return safeCameraOpen(recordconfig, flag, getDefaultCameraId(flag), i, flag1);
    }

    public void preLoadCameras(RecordConfigUtils.RecordConfig recordconfig)
        throws VineNotSupportedException
    {
        if (mIntentionalObjectCounter.getCount() != 0) goto _L2; else goto _L1
_L1:
        int ai[] = mLOCK;
        ai;
        JVM INSTR monitorenter ;
        if (mCamera != null) goto _L4; else goto _L3
_L3:
        if ((CameraSetting)sCameraSettingTable.get(getDefaultCameraId(true)) != null) goto _L6; else goto _L5
_L5:
        openDefaultCamera(recordconfig, true, 0, false);
        releaseCameraAndPreview("preload");
_L10:
        if ((CameraSetting)sCameraSettingTable.get(getDefaultCameraId(false)) != null) goto _L8; else goto _L7
_L7:
        openDefaultCamera(recordconfig, false, 0, false);
        releaseCameraAndPreview("preload");
_L4:
        return;
_L6:
        SLog.d("Skip preload ffc.");
        continue; /* Loop/switch isn't completed */
        recordconfig;
        ai;
        JVM INSTR monitorexit ;
        throw recordconfig;
_L8:
        SLog.d("Skip preload bfc.");
          goto _L4
_L2:
        return;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public void printSupportedPreviewSizes()
    {
        if (mCamera != null)
        {
            Object obj = mCamera.getParameters().getPreferredPreviewSizeForVideo();
            if (obj != null)
            {
                CrashUtil.log("Preferred size: {} * {}", new Object[] {
                    Integer.valueOf(((android.hardware.Camera.Size) (obj)).width), Integer.valueOf(((android.hardware.Camera.Size) (obj)).height)
                });
            }
            obj = mCamera.getParameters().getSupportedPreviewSizes();
            if (obj != null)
            {
                android.hardware.Camera.Size size;
                for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); CrashUtil.log("Supported Preview Size: {} * {}.", new Object[] {
    Integer.valueOf(size.width), Integer.valueOf(size.height)
}))
                {
                    size = (android.hardware.Camera.Size)((Iterator) (obj)).next();
                }

            }
        }
    }

    public void releaseCameraAndPreview(String s)
    {
        int i;
        boolean flag;
        flag = true;
        i = -1;
        StartPreviewThread startpreviewthread = mStartPreviewThread;
        if (startpreviewthread != null)
        {
            startpreviewthread.notifyReleasedAlready();
        }
        waitForPreviewToStart();
        int ai[] = mLOCK;
        ai;
        JVM INSTR monitorenter ;
        if (mCamera == null) goto _L2; else goto _L1
_L1:
        SLog.d("6,7 RELEASE Camera and STOP Preview.");
        if (isPreviewing())
        {
            stopPreview();
        }
        CrashUtil.log("Camera was released from {}.", new Object[] {
            s
        });
        if (mFramesReceived > 0L)
        {
            i = (int)((mFramesReceived * 1000L) / (System.currentTimeMillis() - mPreviewStartTime));
        }
        if (i <= 0) goto _L4; else goto _L3
_L3:
        long l;
        if (mMaxtimeElapsed <= 0L)
        {
            break MISSING_BLOCK_LABEL_195;
        }
        l = 1000L / mMaxtimeElapsed;
_L5:
        SLog.b("Lowest frame rate: {}.", Long.valueOf(l));
        if (i <= 0 || i >= 15)
        {
            flag = false;
        }
        SLog.b("Average frame rate: {}.", Integer.valueOf(i), flag);
_L4:
        mCamera.setPreviewCallback(null);
        sCameraBufferCount = 0;
        mControllerId = "null";
        mCamera.release();
        mCamera = null;
        mCameraSetting = null;
        mCurrentCamera = -1;
_L2:
        ai;
        JVM INSTR monitorexit ;
        return;
        l = mMaxtimeElapsed;
          goto _L5
        s;
        ai;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void releaseCameraResources()
    {
        mBufferArray.clear();
        mAddedBufferArray.clear();
        System.gc();
    }

    public void removeBufferFromAvailableQueue(byte abyte0[])
    {
        mAddedBufferArray.remove(abyte0);
    }

    public void setController(RecordController recordcontroller)
    {
        mController = recordcontroller;
    }

    public boolean setFocusAreas(int i, int j)
    {
        try
        {
            initializeFocusAreas(i, j);
            android.hardware.Camera.Parameters parameters = mCamera.getParameters();
            parameters.setFocusAreas(mFocusArea);
            mCamera.setParameters(parameters);
        }
        catch (Exception exception)
        {
            CrashUtil.logException(exception, "Failed to set focus areas {}, {}.", new Object[] {
                mMatrix, ((android.hardware.Camera.Area)mFocusArea.get(0)).rect
            });
            return false;
        }
        return true;
    }

    public int setFrameRate(int i)
    {
        int ai1[] = mLOCK;
        ai1;
        JVM INSTR monitorenter ;
        Object obj = mCamera;
        if (obj == null) goto _L2; else goto _L1
_L1:
        obj = mCamera.getParameters();
        ((android.hardware.Camera.Parameters) (obj)).setPreviewFpsRange(i * 1000, i * 1000);
        SLog.d("SET frameRate using fixed-range frameRate");
        mCamera.setParameters(((android.hardware.Camera.Parameters) (obj)));
        ai1;
        JVM INSTR monitorexit ;
        return i;
        Object obj1;
        obj1;
        obj1 = mCamera.getParameters();
        ((android.hardware.Camera.Parameters) (obj1)).setPreviewFrameRate(i);
        mCamera.setParameters(((android.hardware.Camera.Parameters) (obj1)));
        SLog.d("SET frameRate using fixed frameRate");
        ai1;
        JVM INSTR monitorexit ;
        return i;
        obj1;
        android.hardware.Camera.Parameters parameters = mCamera.getParameters();
        List list = parameters.getSupportedPreviewFpsRange();
        if (list != null)
        {
            break MISSING_BLOCK_LABEL_138;
        }
        CrashUtil.log("Cannot set frame-rate");
        ai1;
        JVM INSTR monitorexit ;
        return i;
        obj1;
        ai1;
        JVM INSTR monitorexit ;
        return 30;
        obj1;
        ai1;
        JVM INSTR monitorexit ;
        throw obj1;
        int j;
        int l;
        int i2;
        int l2;
        l2 = i * 1000;
        obj1 = null;
        l = 0;
        i2 = 0;
        j = -1;
        int l1 = list.size() - 1;
        i = 0;
_L12:
        Object obj2 = obj1;
        if (i >= list.size()) goto _L4; else goto _L3
_L3:
        obj2 = (int[])list.get(i);
        SLog.d("Supported FPS: {}", obj2);
        if (obj2[0] != l2) goto _L5; else goto _L4
_L4:
        int ai[] = ((int []) (obj2));
        if (obj2 != null) goto _L7; else goto _L6
_L6:
        if (j == -1) goto _L9; else goto _L8
_L8:
        ai = (int[])list.get(j);
_L7:
        i = ai[1];
        if (i < l2)
        {
            break; /* Loop/switch isn't completed */
        }
        SLog.d("Try Using variable FPS: {}, {}.", Integer.valueOf(l), Integer.valueOf(l2));
        parameters.setPreviewFpsRange(l, l2);
        mCamera.setParameters(parameters);
        i = l2 / 1000;
        ai1;
        JVM INSTR monitorexit ;
        return i;
_L9:
        ai = (int[])list.get(l1);
        if (true) goto _L7; else goto _L10
        obj2;
        obj2 = mCamera.getParameters();
        SLog.d("Try Using fixed framerate FPS: {}", Integer.valueOf(l2));
        ((android.hardware.Camera.Parameters) (obj2)).setPreviewFrameRate(l2 / 1000);
        mCamera.setParameters(((android.hardware.Camera.Parameters) (obj2)));
        i = l2 / 1000;
        ai1;
        JVM INSTR monitorexit ;
        return i;
        obj2;
        obj2 = mCamera.getParameters();
        SLog.d("Try Using selected framerate FPS: {}, {}, {}.", Integer.valueOf(ai[0]), Integer.valueOf(ai[1]), Integer.valueOf(l2));
        ((android.hardware.Camera.Parameters) (obj2)).setPreviewFpsRange(ai[0], ai[1]);
        mCamera.setParameters(((android.hardware.Camera.Parameters) (obj2)));
        i = ai[1] / 1000;
        ai1;
        JVM INSTR monitorexit ;
        return i;
_L10:
        SLog.d("Fall back, should never reach here.");
        i = l2 / 1000;
        parameters.setPreviewFrameRate(i);
        mCamera.setParameters(parameters);
        ai1;
        JVM INSTR monitorexit ;
        return i;
        exception;
        ai1;
        JVM INSTR monitorexit ;
        return 30;
_L2:
        ai1;
        JVM INSTR monitorexit ;
        return 30;
_L5:
        int k;
        int j1;
        int j2;
        int k2;
        if (obj2[1] != l2)
        {
            break; /* Loop/switch isn't completed */
        }
        int k1 = l;
        Exception exception;
        if (l < obj2[0])
        {
            k1 = obj2[0];
            j = i;
        }
        j1 = i2;
        k = k1;
        j2 = l1;
        k2 = j;
        if (i2 <= obj2[1])
        {
            j1 = obj2[1];
            k2 = j;
            j2 = l1;
            k = k1;
        }
_L14:
        i++;
        i2 = j1;
        l = k;
        l1 = j2;
        j = k2;
        if (true) goto _L12; else goto _L11
_L11:
        j1 = i2;
        k = l;
        j2 = l1;
        k2 = j;
        if (l <= obj2[0])
        {
            int i1 = obj2[0];
            j1 = i2;
            k = i1;
            j2 = l1;
            k2 = j;
            if (i2 <= obj2[1])
            {
                j1 = obj2[1];
                j2 = i;
                k = i1;
                k2 = j;
            }
        }
        if (true) goto _L14; else goto _L13
_L13:
        if (true) goto _L12; else goto _L15
_L15:
    }

    public void setPreviewSize(int i, int j)
    {
        mPreviewWidth = i;
        mPreviewHeight = j;
        mFrameSize = (mPreviewWidth * mPreviewHeight * ImageFormat.getBitsPerPixel(17)) / 8;
    }

    public boolean startContinuousAutoFocus(android.hardware.Camera.Parameters parameters)
    {
        String s;
        Object obj;
        s = "";
        obj = parameters.getSupportedFocusModes();
        if (obj != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        if (RecordConfigUtils.RecordConfig.FORCE_AUTO_FOCUS)
        {
            s = "auto";
            SLog.d("Focus Mode: AUTO");
        } else
        if (((List) (obj)).contains("continuous-video"))
        {
            s = "continuous-video";
            SLog.d("Focus Mode: CONTINUOUS VIDEO");
        } else
        if (((List) (obj)).contains("infinity"))
        {
            s = "infinity";
            SLog.d("Focus Mode: INFINITY");
        }
        obj = parameters.getFocusMode();
        if (s.equals("")) goto _L1; else goto _L3
_L3:
        parameters.setFocusMode(s);
        mCamera.setParameters(parameters);
        return true;
        Exception exception;
        exception;
        CrashUtil.logException(exception, "Continuous Auto Focus is not supported on this device.", new Object[0]);
        parameters.setFocusMode(((String) (obj)));
        return false;
    }

    public void startInstantZoom()
    {
        SLog.d("Instant zoom started on value {}", Integer.valueOf(mRequestedZoom));
        mCurrentZoomTarget = mRequestedZoom;
        android.hardware.Camera.Parameters parameters = mCamera.getParameters();
        parameters.setZoom(mRequestedZoom);
        mCamera.setParameters(parameters);
        onZoomChange(mRequestedZoom, true, mCamera);
    }

    public void startPreview(RecordConfigUtils.RecordConfig recordconfig, SurfaceTexture surfacetexture, boolean flag, boolean flag1, int i, int j, int k)
        throws InvalidPreviewSizeException
    {
        startPreview(recordconfig, null, surfacetexture, flag, flag1, i, j, k);
    }

    public void startPreview(RecordConfigUtils.RecordConfig recordconfig, Surface surface, boolean flag, boolean flag1, int i, int j, int k)
        throws InvalidPreviewSizeException
    {
        startPreview(recordconfig, surface, null, flag, flag1, i, j, k);
    }

    public void startSmoothZoom(boolean flag)
    {
label0:
        {
            if (!mIsSmoothZoomSupported)
            {
                throw new IllegalStateException("Smooth zoom not supported.");
            }
            if (!mIsSmoothZooming)
            {
                SLog.d("Smooth zoom started on value {}", Integer.valueOf(mRequestedZoom));
                stopContinuousFocus(mCamera.getParameters());
                mIsSmoothZooming = true;
                mCurrentZoomTarget = mRequestedZoom;
                if (!flag)
                {
                    break label0;
                }
                mCamera.startSmoothZoom(mMaxZoom);
            }
            return;
        }
        mCamera.startSmoothZoom(0);
    }

    public boolean stopContinuousFocus(android.hardware.Camera.Parameters parameters)
    {
        String s;
        List list;
        s = "";
        list = parameters.getSupportedFocusModes();
        SLog.d("Force auto focus: {}", Boolean.valueOf(RecordConfigUtils.RecordConfig.FORCE_AUTO_FOCUS));
        if (list == null) goto _L2; else goto _L1
_L1:
        if (!list.contains("auto") && !RecordConfigUtils.RecordConfig.FORCE_AUTO_FOCUS) goto _L4; else goto _L3
_L3:
        s = "auto";
        SLog.d("Focus Mode: FOCUS_MODE_AUTO");
_L5:
        if (!s.equals(""))
        {
            parameters.setFocusMode(s);
            mCamera.setParameters(parameters);
            return true;
        }
        break; /* Loop/switch isn't completed */
_L4:
        if (list.contains("continuous-picture"))
        {
            s = "continuous-picture";
            SLog.d("Focus Mode: FOCUS_MODE_CONTINUOUS_PICTURE");
        }
        if (true) goto _L5; else goto _L2
_L2:
        return false;
    }

    public void stopPreview()
    {
        synchronized (mLOCK)
        {
            SLog.d("6. Stop Preview.");
            mCamera.stopPreview();
            mLastPreviewFrameTimestamp = -1L;
            isPreviewing = false;
        }
        return;
        exception;
        ai;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean stopSmoothZoom()
    {
        if (mIsSmoothZooming && !mIsSmoothZoomingStopCalled)
        {
            mIsSmoothZoomingStopCalled = true;
            SLog.d("Stop smooth zoom.");
            try
            {
                mCamera.stopSmoothZoom();
            }
            catch (Exception exception)
            {
                CrashUtil.log("Failed to stop smooth zoom.");
                return true;
            }
            return true;
        } else
        {
            return false;
        }
    }

    public void switchImageStabilization()
    {
        int ai[] = mLOCK;
        ai;
        JVM INSTR monitorenter ;
        Object obj;
        if (android.os.Build.VERSION.SDK_INT < 15)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        obj = mCamera;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        obj = mCamera.getParameters();
        if (!((android.hardware.Camera.Parameters) (obj)).isVideoStabilizationSupported())
        {
            break MISSING_BLOCK_LABEL_53;
        }
        Object obj1;
        boolean flag;
        if (!((android.hardware.Camera.Parameters) (obj)).getVideoStabilization())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ((android.hardware.Camera.Parameters) (obj)).setVideoStabilization(flag);
        mCamera.setParameters(((android.hardware.Camera.Parameters) (obj)));
_L1:
        ai;
        JVM INSTR monitorexit ;
        return;
        obj1;
        SLog.d("It just didn't work.");
          goto _L1
        obj1;
        ai;
        JVM INSTR monitorexit ;
        throw obj1;
    }

    public void waitForPreviewToStart()
    {
        try
        {
            if (mStartPreviewThread != null)
            {
                long l = System.currentTimeMillis();
                mStartPreviewThread.join();
                SLog.i("Waiting for preview thread took {}ms.", Long.valueOf(System.currentTimeMillis() - l));
            }
        }
        catch (InterruptedException interruptedexception)
        {
            SLog.d("Couldn't wait for preview to join.");
        }
        mStartPreviewThread = null;
    }

    static 
    {
        android.hardware.Camera.CameraInfo camerainfo;
        ArrayList arraylist;
        ArrayList arraylist1;
        int i;
        int j;
        camerainfo = new android.hardware.Camera.CameraInfo();
        j = Camera.getNumberOfCameras();
        arraylist = new ArrayList();
        arraylist1 = new ArrayList();
        i = 0;
_L2:
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        Camera.getCameraInfo(i, camerainfo);
        if (camerainfo.facing == 1)
        {
            arraylist.add(Integer.valueOf(i));
            break MISSING_BLOCK_LABEL_163;
        }
        try
        {
            if (camerainfo.facing == 0)
            {
                arraylist1.add(Integer.valueOf(i));
            }
        }
        catch (Exception exception)
        {
            CrashUtil.logException(exception, "Cannot get camera info for camera #{}.", new Object[] {
                Integer.valueOf(i)
            });
        }
        break MISSING_BLOCK_LABEL_163;
        mFrontFacing = (Integer[])arraylist.toArray(new Integer[arraylist.size()]);
        mBackFacing = (Integer[])arraylist1.toArray(new Integer[arraylist1.size()]);
        sCameraInfoTable = new SparseArray();
        sCameraSettingTable = new SparseArray();
        return;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }



/*
    static boolean access$002(CameraManager cameramanager, boolean flag)
    {
        cameramanager.mRunAddBufferThread = flag;
        return flag;
    }

*/




/*
    static ByteBuffer access$1002(CameraManager cameramanager, ByteBuffer bytebuffer)
    {
        cameramanager.mSharedByteBuffer = bytebuffer;
        return bytebuffer;
    }

*/


/*
    static long access$1102(CameraManager cameramanager, long l)
    {
        cameramanager.mLastPreviewFrameTimestamp = l;
        return l;
    }

*/


/*
    static long access$1202(CameraManager cameramanager, long l)
    {
        cameramanager.mFramesReceived = l;
        return l;
    }

*/


/*
    static long access$1302(CameraManager cameramanager, long l)
    {
        cameramanager.mPreviewStartTime = l;
        return l;
    }

*/








/*
    static String access$702(CameraManager cameramanager, String s)
    {
        cameramanager.mControllerId = s;
        return s;
    }

*/



/*
    static boolean access$802(boolean flag)
    {
        hasPreallocateBuffers = flag;
        return flag;
    }

*/

}
