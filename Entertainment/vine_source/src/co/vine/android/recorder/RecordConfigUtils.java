// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.AudioRecord;
import android.os.Build;
import android.os.Environment;
import co.vine.android.util.CrashUtil;
import co.vine.android.util.SystemUtil;
import com.edisonwang.android.slog.SLog;
import com.lifevibes.mediacoder.LVMediaCoderConfiguration;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;

// Referenced classes of package co.vine.android.recorder:
//            RecordSessionManager, RecordSessionVersion, AudioArray, CameraManager, 
//            SwVineFrameRecorder, HwVineFrameRecorder

public class RecordConfigUtils
{
    public static class RecordConfig
    {

        private static final boolean CAMERA_SWITCH_ENABLED = true;
        public static final boolean DISABLE_FACE_RECOGNITION;
        private static final boolean FLASH_SWITCH_ENABLED = false;
        public static final boolean FORCE_AUTO_FOCUS;
        private static final int INITIAL_VIDEO_BUFFER_COUNT = 170;
        private static final float INVALID_ASPECT_RATIO = 0F;
        public static final boolean IS_ZERO_INDEX_BASED_ZOOM;
        private static final String KEY_ASPECT_RATIO_OVERRIDE_bf = "aspect_ratio_or_bf";
        private static final String KEY_ASPECT_RATIO_OVERRIDE_ff = "aspect_ratio_or_ff";
        private static final String KEY_BUFFER_SIZE = "bufferSize";
        private static final String KEY_CAMERA_SWITCH_ENABLED = "cameraSwitchEnabled";
        private static final String KEY_FLASH_SWITCH_ENABLED = "flashSwitchEnabled";
        private static final String KEY_FRAME_RATE = "frameRate";
        private static final String KEY_MAX_DURATION = "maxDuration";
        private static final String KEY_PREALLOCATE_BUFFER = "preAllocateBuffer";
        private static final String KEY_PREF = "RecordConfig";
        private static final String KEY_PREVIEW_HEIGHT = "previewHeight";
        private static final String KEY_PREVIEW_WIDTH = "previewWidth";
        private static final String KEY_PRE_RATIO = "pre_ratio";
        private static final String KEY_PROCESS_ON_SD = "processOnSD";
        private static final String KEY_RECORDING_ENABLED = "recordingEnabled";
        private static final String KEY_SET_RECORDING_HINT_bf = "set_recording_hint_bf";
        private static final String KEY_SET_RECORDING_HINT_ff = "set_recording_hint_ff";
        private static final String KEY_TARGET_SIZE = "targetSize";
        private static final String KEY_UPDATE_TIME = "updateTime";
        private static final String KEY_ZOOM_ENABLED = "zoomEnabled";
        private static final int PREVIEW_WIDTH = 640;
        private static final float PRE_ALLOCATE_RATIO = 1.5F;
        private static final boolean PROCESS_ON_SD_CARD;
        private static final int PROGRESS_MAX = 6000;
        private static final boolean SET_RECORDING_HINT_bf = true;
        private static final boolean SET_RECORDING_HINT_ff = true;
        public static final boolean SHOULD_DISABLE_BACKFACING_SET_RECORDING_HINT;
        public static final boolean SHOULD_DISABLE_FRONTFACING_SET_RECORDING_HINT;
        public static final boolean SHOULD_FORCE_SMOOTH_ZOOM;
        public static final boolean SHOULD_OVERRIDED_FRONTFACING_ASPECT_RATIO = false;
        public static final boolean SHOULD_OVERRIDE_BACKFACING_ASPECT_RATIO = false;
        public static final boolean SHOULD_SHOW_ZOOM_SLIDER;
        private static final float SIX_SECONDS = 6000F;
        private static final int TARGET_FRAME_RATE = 30;
        private static final boolean ZOOM_ENABLED = true;
        public final float backFacingAspectRatioOverride;
        public final boolean backFacingRecordingHint;
        public final int bufferCount;
        public final boolean cameraSwitchEnabled;
        public final boolean flashSwitchEnabled;
        public final float frontFacingAspectRatioOverride;
        public final boolean frontFacingRecordingHint;
        public final boolean highQuality = true;
        public final boolean isZoomButtonEnabled;
        public final int maxDuration;
        public final double memRatio;
        public final double preAllocRatio;
        public final boolean preAllocateBuffer;
        public final int previewHeight;
        public final int previewWidth;
        public final File processDir;
        public final boolean processOnSd;
        public final boolean recordingEnabled;
        public final int targetFrameRate;
        public final int targetSize;
        public final boolean zoomEnabled;

        public static boolean needsUpdate(Context context)
        {
            boolean flag = false;
            if (System.currentTimeMillis() - context.getSharedPreferences("RecordConfig", 0).getLong("updateTime", 0L) > 0x493e0L)
            {
                flag = true;
            }
            return flag;
        }

        public static RecordConfig update(Context context, JSONObject jsonobject)
        {
            co/vine/android/recorder/RecordConfigUtils$RecordConfig;
            JVM INSTR monitorenter ;
            SLog.d("Update config: {}.", jsonobject);
            RecordConfig recordconfig = new RecordConfig(context);
            android.content.SharedPreferences.Editor editor = context.getSharedPreferences("RecordConfig", 0).edit();
            editor.putBoolean("preAllocateBuffer", jsonobject.optBoolean("preAllocateBuffer", recordconfig.preAllocateBuffer));
            editor.putBoolean("recordingEnabled", jsonobject.optBoolean("recordingEnabled", recordconfig.recordingEnabled));
            editor.putBoolean("zoomEnabled", jsonobject.optBoolean("zoomEnabled", recordconfig.zoomEnabled));
            editor.putBoolean("cameraSwitchEnabled", jsonobject.optBoolean("cameraSwitchEnabled", recordconfig.cameraSwitchEnabled));
            editor.putBoolean("flashSwitchEnabled", jsonobject.optBoolean("flashSwitchEnabled", recordconfig.flashSwitchEnabled));
            editor.putBoolean("processOnSD", jsonobject.optBoolean("processOnSD", recordconfig.processOnSd));
            editor.putBoolean("set_recording_hint_ff", jsonobject.optBoolean("set_recording_hint_ff", recordconfig.frontFacingRecordingHint));
            editor.putBoolean("set_recording_hint_bf", jsonobject.optBoolean("set_recording_hint_bf", recordconfig.backFacingRecordingHint));
            editor.putInt("frameRate", jsonobject.optInt("frameRate", recordconfig.targetFrameRate));
            editor.putInt("targetSize", jsonobject.optInt("targetSize", recordconfig.targetSize));
            editor.putInt("previewWidth", jsonobject.optInt("previewWidth", recordconfig.previewWidth));
            editor.putInt("previewHeight", jsonobject.optInt("previewHeight", recordconfig.previewHeight));
            editor.putInt("bufferSize", jsonobject.optInt("bufferSize", recordconfig.bufferCount));
            editor.putInt("maxDuration", jsonobject.optInt("maxDuration", recordconfig.maxDuration));
            editor.putFloat("pre_ratio", (float)jsonobject.optDouble("pre_ratio", recordconfig.preAllocRatio));
            editor.putFloat("aspect_ratio_or_ff", (float)jsonobject.optDouble("aspect_ratio_or_ff", recordconfig.frontFacingAspectRatioOverride));
            editor.putFloat("aspect_ratio_or_bf", (float)jsonobject.optDouble("aspect_ratio_or_bf", recordconfig.backFacingAspectRatioOverride));
            editor.putLong("updateTime", System.currentTimeMillis());
            editor.apply();
            context = new RecordConfig(context);
            co/vine/android/recorder/RecordConfigUtils$RecordConfig;
            JVM INSTR monitorexit ;
            return context;
            context;
            throw context;
        }

        static 
        {
label0:
            {
                boolean flag1 = false;
                boolean flag;
                if (Build.MODEL.length() == "SM-C115".length() && Build.MODEL.contains("SM-C11"))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                SHOULD_FORCE_SMOOTH_ZOOM = flag;
                if (Build.MODEL.length() == "SM-C115".length() && Build.MODEL.contains("SM-C11"))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                DISABLE_FACE_RECOGNITION = flag;
                if (Build.MODEL.contains("Nexus 5") || Build.MODEL.contains("SM-N900"))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                SHOULD_DISABLE_FRONTFACING_SET_RECORDING_HINT = flag;
                if (Build.MODEL.contains("SGH-I747") || Build.MODEL.contains("SGH-T999") || Build.MODEL.contains("SGH-N064") || Build.MODEL.contains("SC-06D") || Build.MODEL.contains("SCH-J021") || Build.MODEL.contains("SCH-R530") || Build.MODEL.contains("SCH-I535") || Build.MODEL.contains("SCL21") || Build.MODEL.contains("SCH-S960L"))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                SHOULD_DISABLE_BACKFACING_SET_RECORDING_HINT = flag;
                if (SLog.sLogsOn || Build.MODEL.startsWith("SM-C11"))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                SHOULD_SHOW_ZOOM_SLIDER = flag;
                if (Build.MODEL.length() == "SM-C115".length() && Build.MODEL.contains("SM-C11"))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                IS_ZERO_INDEX_BASED_ZOOM = flag;
                if (!Build.MODEL.contains("GT-I9505") && !Build.MODEL.contains("GT-I9506") && !Build.MODEL.contains("GT-I9500") && !Build.MODEL.contains("SGH-I337") && !Build.MODEL.contains("SGH-M919") && !Build.MODEL.contains("SCH-I545") && !Build.MODEL.contains("SPH-L720") && !Build.MODEL.contains("GT-I9508") && !Build.MODEL.contains("SHV-E300") && !Build.MODEL.contains("SCH-R970") && !Build.MODEL.contains("SM-N900"))
                {
                    flag = flag1;
                    if (!Build.MODEL.contains("LG-D801"))
                    {
                        break label0;
                    }
                }
                flag = true;
            }
            FORCE_AUTO_FOCUS = flag;
            PROCESS_ON_SD_CARD = SLog.sLogsOn;
        }

        public RecordConfig(Context context)
        {
            boolean flag1 = true;
            super();
            memRatio = SystemUtil.getMemoryRatio(context, true);
            double d;
            SharedPreferences sharedpreferences;
            int i;
            int j;
            boolean flag;
            if (memRatio >= 1.0D)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            sharedpreferences = context.getSharedPreferences("RecordConfig", 0);
            if (memRatio >= 2D)
            {
                d = sharedpreferences.getFloat("pre_ratio", 1.5F);
            } else
            {
                d = 0.80000000000000004D;
            }
            preAllocRatio = d;
            preAllocateBuffer = sharedpreferences.getBoolean("preAllocateBuffer", true);
            recordingEnabled = sharedpreferences.getBoolean("recordingEnabled", flag);
            zoomEnabled = sharedpreferences.getBoolean("zoomEnabled", true);
            if ((PROCESS_ON_SD_CARD || sharedpreferences.getBoolean("processOnSD", PROCESS_ON_SD_CARD)) && "mounted".equals(Environment.getExternalStorageState()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            processOnSd = flag;
            if (processOnSd)
            {
                context = RecordConfigUtils.FOLDER_ROOT_PROCESS_DEBUG;
            } else
            {
                context = context.getFilesDir();
            }
            processDir = context;
            if (sharedpreferences.getBoolean("cameraSwitchEnabled", true) && CameraManager.hasFrontFacingCamera() && CameraManager.hasBackFacingCamera())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            cameraSwitchEnabled = flag;
            flashSwitchEnabled = sharedpreferences.getBoolean("flashSwitchEnabled", false);
            targetFrameRate = sharedpreferences.getInt("frameRate", 30);
            targetSize = sharedpreferences.getInt("targetSize", 480);
            j = sharedpreferences.getInt("previewWidth", 640);
            if (highQuality)
            {
                i = 1;
            } else
            {
                i = 2;
            }
            previewWidth = j / i;
            j = sharedpreferences.getInt("previewHeight", 480);
            if (highQuality)
            {
                i = 1;
            } else
            {
                i = 2;
            }
            previewHeight = j / i;
            maxDuration = sharedpreferences.getInt("maxDuration", 6000);
            i = (int)((float)sharedpreferences.getInt("bufferSize", 170) * ((float)maxDuration / 6000F));
            if (memRatio <= 1.0D)
            {
                i = (int)((double)i * 0.80000000000000004D);
            }
            bufferCount = i;
            frontFacingAspectRatioOverride = sharedpreferences.getFloat("aspect_ratio_or_ff", 0.0F);
            backFacingAspectRatioOverride = sharedpreferences.getFloat("aspect_ratio_or_bf", 0.0F);
            if (SHOULD_DISABLE_FRONTFACING_SET_RECORDING_HINT)
            {
                flag = false;
            } else
            {
                flag = sharedpreferences.getBoolean("set_recording_hint_ff", true);
            }
            frontFacingRecordingHint = flag;
            if (SHOULD_DISABLE_BACKFACING_SET_RECORDING_HINT)
            {
                flag = false;
            } else
            {
                flag = sharedpreferences.getBoolean("set_recording_hint_bf", true);
            }
            backFacingRecordingHint = flag;
            if (SHOULD_SHOW_ZOOM_SLIDER && zoomEnabled)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            isZoomButtonEnabled = flag;
        }
    }


    public static final int AUDIO_BIT_RATE;
    public static final int AUDIO_BUFFER_SIZE;
    public static final int AUDIO_FORMAT = 16;
    public static final int AUDIO_RUNNABLE_SAMPLE_SIZE;
    public static final int AUDIO_SAMPLE_PER_MS_MAX = 48;
    public static final double AUDIO_SAMPLE_PER_NS_EXACT = 0.0441D;
    public static final int AUDIO_SAMPLE_RATE_HZ = 44100;
    private static String DCIM;
    public static final android.graphics.Bitmap.Config DEFAULT_BITMAP_CONFIG;
    public static final int DEFAULT_TARGET_SIZE = 480;
    public static final File FOLDER_ROOT_DIRECT_UPLOAD;
    public static final String FOLDER_ROOT_PROCESS = "process";
    private static final File FOLDER_ROOT_PROCESS_DEBUG;
    private static final String FOLDER_ROOT_SAVE;
    public static final String FOLDER_ROOT_TO_UPLOAD = "upload";
    public static final int HIGHEST_PROFILE = 4;
    public static final boolean HW_ENABLED = "sw".toLowerCase().contains("hw");
    public static final int MAX_DRAFTS = 9;
    public static final int N_AUDIO_CHANNELS = 1;
    public static final int N_IMAGE_CHANNELS = 4;
    public static final String PREF_CAN_LOAD = "canLoad";
    public static final int PROGRESS_THRESHOLD_MESSAGING = 66;
    public static final int PROGRESS_THRESHOLD_REGULAR = 1000;
    public static final int PROGRESS_TIMER_SLEEP = 35;
    public static final boolean SW_ENABLED = "sw".toLowerCase().contains("sw");
    public static final boolean THUMBNAIL_MODE_MEDIA_UTILS = false;
    public static final boolean THUMBNAIL_MODE_OPENCV = true;
    private static final String UPLOAD_IMAGE_EXTENSION = "_image";
    public static final int VIDEO_BIT_RATE;
    public static final String VIDEO_CONTAINER_EXT;
    private static LVMediaCoderConfiguration sEncoderConfig;
    private static RecordConfig sGenericConfig;

    public RecordConfigUtils()
    {
    }

    public static File copyForUpload(File file, String s, String s1)
        throws IOException
    {
        s = new File(s);
        file = getUploadFile(file, s1);
        FileUtils.copyFile(s, file);
        return file;
    }

    public static boolean copySilently(File file, File file1)
    {
        try
        {
            FileUtils.copyFile(file, file1);
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            SLog.e("Failed to copy", file);
            return false;
        }
        return true;
    }

    public static AudioArray createAudioArray(AudioArray.AudioArrayType audioarraytype)
    {
        return new AudioArray(AUDIO_RUNNABLE_SAMPLE_SIZE, audioarraytype);
    }

    public static Bitmap createDefaultSizeBitmap()
    {
        return Bitmap.createBitmap(480, 480, DEFAULT_BITMAP_CONFIG);
    }

    public static void deleteNonFolders(File file)
    {
        if (file.isDirectory())
        {
            file = file.listFiles();
            int j = file.length;
            for (int i = 0; i < j; i++)
            {
                deleteNonFolders(file[i]);
            }

        }
    }

    public static void deletePreProcess(File file)
    {
        deleteNonFolders(new File(file, "process"));
    }

    public static File getCameraRollFile(Context context, long l, String s)
    {
        co/vine/android/recorder/RecordConfigUtils;
        JVM INSTR monitorenter ;
        Object obj = null;
        if (!"mounted".equals(Environment.getExternalStorageState())) goto _L2; else goto _L1
_L1:
        context = new File(FOLDER_ROOT_SAVE);
_L6:
        if (context != null) goto _L4; else goto _L3
_L3:
        context = null;
_L8:
        co/vine/android/recorder/RecordConfigUtils;
        JVM INSTR monitorexit ;
        return context;
_L2:
        Cursor cursor = context.getContentResolver().query(android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI, new String[] {
            "_id", "_data", "datetaken"
        }, null, null, "datetaken DESC");
        context = obj;
        if (cursor == null) goto _L6; else goto _L5
_L5:
        context = obj;
        if (!cursor.moveToFirst()) goto _L6; else goto _L7
_L7:
        context = new File((new File(cursor.getString(cursor.getColumnIndexOrThrow("_data")))).getParentFile(), "Vine");
          goto _L6
        context;
        SLog.e("Failed to get internal path", context);
        context = obj;
          goto _L6
        context;
        throw context;
_L4:
        if (context.exists() || context.mkdirs())
        {
            break MISSING_BLOCK_LABEL_197;
        }
        SLog.d("Failed to make dirs.");
        CrashUtil.logException(new RuntimeException("Failed to make directories. You will be doomed."));
        context = null;
          goto _L8
        String s1 = (new SimpleDateFormat("yyyy_MM_dd_HH_mm_sss")).format(Long.valueOf(l));
        context = new File((new StringBuilder()).append(context.getPath()).append(File.separator).append(s1).append(".").append(s).toString());
          goto _L8
    }

    public static LVMediaCoderConfiguration getEncoderConfiguration()
    {
        if (sEncoderConfig == null)
        {
            sEncoderConfig = new LVMediaCoderConfiguration();
        }
        return sEncoderConfig;
    }

    public static String getFrameInfoPath(String s)
    {
        return (new StringBuilder()).append(s).append(".info").toString();
    }

    public static RecordConfig getGenericConfig(Context context)
    {
        if (sGenericConfig == null)
        {
            sGenericConfig = new RecordConfig(context);
        }
        return sGenericConfig;
    }

    public static int getMaxAudioBufferSize(RecordConfig recordconfig)
    {
        return (int)((double)(recordconfig.maxDuration * 48) * 1.1000000000000001D);
    }

    public static File getPreProcessFile(RecordConfig recordconfig, String s, String s1, String s2)
    {
        co/vine/android/recorder/RecordConfigUtils;
        JVM INSTR monitorenter ;
        recordconfig = getPreProcessFile(recordconfig.processDir, s, s1, s2);
        co/vine/android/recorder/RecordConfigUtils;
        JVM INSTR monitorexit ;
        return recordconfig;
        recordconfig;
        throw recordconfig;
    }

    public static File getPreProcessFile(File file, String s, String s1, String s2)
    {
        co/vine/android/recorder/RecordConfigUtils;
        JVM INSTR monitorenter ;
        file = new File(new File(file, "process"), s);
        if (!file.exists() && !file.mkdirs())
        {
            SLog.d("Failed to make dirs.");
            throw new RuntimeException("Failed to make directories. You will be doomed.");
        }
        break MISSING_BLOCK_LABEL_59;
        file;
        co/vine/android/recorder/RecordConfigUtils;
        JVM INSTR monitorexit ;
        throw file;
        s = (new StringBuilder()).append(file.getPath()).append(File.separator).append(s1);
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_130;
        }
        file = (new StringBuilder()).append(".").append(s2).toString();
_L1:
        file = new File(s.append(file).toString());
        co/vine/android/recorder/RecordConfigUtils;
        JVM INSTR monitorexit ;
        return file;
        file = "";
          goto _L1
    }

    public static String getThumbnailPath(String s)
    {
        return (new StringBuilder()).append(s).append("_image").toString();
    }

    public static int getTimeStampInNsFromSampleCounted(int i)
    {
        return (int)((double)i / 0.0441D);
    }

    private static File getUploadFile(File file, String s)
    {
        co/vine/android/recorder/RecordConfigUtils;
        JVM INSTR monitorenter ;
        file = new File(file, "upload");
        if (!file.exists() && !file.mkdirs())
        {
            SLog.d("Failed to make dirs: {},", s);
            throw new RuntimeException("Failed to make directories. You will be doomed.");
        }
        break MISSING_BLOCK_LABEL_52;
        file;
        co/vine/android/recorder/RecordConfigUtils;
        JVM INSTR monitorexit ;
        throw file;
        file = new File(file, s);
        co/vine/android/recorder/RecordConfigUtils;
        JVM INSTR monitorexit ;
        return file;
    }

    public static int getVideoBufferMax(RecordConfig recordconfig)
    {
        return (int)(((double)VIDEO_BIT_RATE * 1.1000000000000001D * (double)recordconfig.maxDuration) / 1000D);
    }

    public static boolean isDefaultFrontFacing()
    {
        return !CameraManager.hasBackFacingCamera();
    }

    public static boolean isFastEncoding(boolean flag)
    {
        return flag && android.os.Build.VERSION.SDK_INT >= 16;
    }

    public static boolean loadWasEverSuccessful(Context context)
    {
        return context.getSharedPreferences(co/vine/android/recorder/SwVineFrameRecorder.getName(), 0).getBoolean("canLoad", false);
    }

    public static HwVineFrameRecorder newVideoRecorder(Context context, String s, int i)
    {
        return new HwVineFrameRecorder(context, s, i);
    }

    public static SwVineFrameRecorder newVideoRecorder(String s, int i, int j, com.googlecode.javacv.cpp.avcodec.AVPacket avpacket, com.googlecode.javacv.cpp.avcodec.AVPacket avpacket1, boolean flag)
    {
        s = new SwVineFrameRecorder(s, j, j, 1, avpacket, avpacket1);
        s.setAudioCodecName("libvorbis");
        s.setVideoCodecName("libvpx");
        s.setFormat("webm");
        s.setSampleRate(44100);
        s.setFrameRate(i);
        return s;
    }

    public static SwVineFrameRecorder newVideoRecorder(String s, int i, int j, boolean flag)
    {
        return newVideoRecorder(s, i, j, null, null, flag);
    }

    public static void setLoadWasEverSuccessful(Context context, boolean flag)
    {
        if (context == null)
        {
            return;
        } else
        {
            context.getSharedPreferences(co/vine/android/recorder/SwVineFrameRecorder.getName(), 0).edit().putBoolean("canLoad", flag).commit();
            return;
        }
    }

    static 
    {
        int i;
        if (RecordSessionManager.DEFAULT_VERSION.willEventuallyTranscoded)
        {
            i = 0x1e8480;
        } else
        {
            i = 0xf4240;
        }
        VIDEO_BIT_RATE = i;
        if (RecordSessionManager.DEFAULT_VERSION.willEventuallyTranscoded)
        {
            i = 0x1f400;
        } else
        {
            i = 64000;
        }
        AUDIO_BIT_RATE = i;
        AUDIO_BUFFER_SIZE = AudioRecord.getMinBufferSize(44100, 16, 2);
        if (AUDIO_BUFFER_SIZE > 0)
        {
            i = AUDIO_BUFFER_SIZE;
        } else
        {
            i = 7680;
        }
        AUDIO_RUNNABLE_SAMPLE_SIZE = i;
        DEFAULT_BITMAP_CONFIG = android.graphics.Bitmap.Config.ARGB_8888;
        VIDEO_CONTAINER_EXT = RecordSessionManager.DEFAULT_VERSION.videoOutputExtension;
        try
        {
            DCIM = Environment.DIRECTORY_DCIM;
        }
        catch (Exception exception)
        {
            DCIM = "DCIM";
        }
        FOLDER_ROOT_SAVE = (new File(Environment.getExternalStoragePublicDirectory(DCIM), "Vine")).getPath();
        FOLDER_ROOT_PROCESS_DEBUG = new File(Environment.getExternalStoragePublicDirectory(DCIM), "vine_capture");
        FOLDER_ROOT_DIRECT_UPLOAD = new File(Environment.getExternalStoragePublicDirectory(DCIM), "vine_upload");
        if (SLog.sLogsOn)
        {
            FOLDER_ROOT_DIRECT_UPLOAD.mkdirs();
        }
    }

}
