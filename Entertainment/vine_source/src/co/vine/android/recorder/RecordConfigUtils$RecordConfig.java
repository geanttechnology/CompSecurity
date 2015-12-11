// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Environment;
import co.vine.android.util.SystemUtil;
import com.edisonwang.android.slog.SLog;
import java.io.File;
import org.json.JSONObject;

// Referenced classes of package co.vine.android.recorder:
//            RecordConfigUtils, CameraManager

public static class isZoomButtonEnabled
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

    public static isZoomButtonEnabled update(Context context, JSONObject jsonobject)
    {
        co/vine/android/recorder/RecordConfigUtils$RecordConfig;
        JVM INSTR monitorenter ;
        SLog.d("Update config: {}.", jsonobject);
        isZoomButtonEnabled iszoombuttonenabled = new <init>(context);
        android.content.rdConfig rdconfig = context.getSharedPreferences("RecordConfig", 0).edit();
        rdconfig.lean("preAllocateBuffer", jsonobject.optBoolean("preAllocateBuffer", iszoombuttonenabled.preAllocateBuffer));
        rdconfig.lean("recordingEnabled", jsonobject.optBoolean("recordingEnabled", iszoombuttonenabled.recordingEnabled));
        rdconfig.lean("zoomEnabled", jsonobject.optBoolean("zoomEnabled", iszoombuttonenabled.zoomEnabled));
        rdconfig.lean("cameraSwitchEnabled", jsonobject.optBoolean("cameraSwitchEnabled", iszoombuttonenabled.cameraSwitchEnabled));
        rdconfig.lean("flashSwitchEnabled", jsonobject.optBoolean("flashSwitchEnabled", iszoombuttonenabled.flashSwitchEnabled));
        rdconfig.lean("processOnSD", jsonobject.optBoolean("processOnSD", iszoombuttonenabled.processOnSd));
        rdconfig.lean("set_recording_hint_ff", jsonobject.optBoolean("set_recording_hint_ff", iszoombuttonenabled.frontFacingRecordingHint));
        rdconfig.lean("set_recording_hint_bf", jsonobject.optBoolean("set_recording_hint_bf", iszoombuttonenabled.backFacingRecordingHint));
        rdconfig.("frameRate", jsonobject.optInt("frameRate", iszoombuttonenabled.targetFrameRate));
        rdconfig.("targetSize", jsonobject.optInt("targetSize", iszoombuttonenabled.targetSize));
        rdconfig.("previewWidth", jsonobject.optInt("previewWidth", iszoombuttonenabled.previewWidth));
        rdconfig.("previewHeight", jsonobject.optInt("previewHeight", iszoombuttonenabled.previewHeight));
        rdconfig.("bufferSize", jsonobject.optInt("bufferSize", iszoombuttonenabled.bufferCount));
        rdconfig.("maxDuration", jsonobject.optInt("maxDuration", iszoombuttonenabled.maxDuration));
        rdconfig.at("pre_ratio", (float)jsonobject.optDouble("pre_ratio", iszoombuttonenabled.preAllocRatio));
        rdconfig.at("aspect_ratio_or_ff", (float)jsonobject.optDouble("aspect_ratio_or_ff", iszoombuttonenabled.frontFacingAspectRatioOverride));
        rdconfig.at("aspect_ratio_or_bf", (float)jsonobject.optDouble("aspect_ratio_or_bf", iszoombuttonenabled.backFacingAspectRatioOverride));
        rdconfig.g("updateTime", System.currentTimeMillis());
        rdconfig.g();
        context = new <init>(context);
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

    public (Context context)
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
            context = RecordConfigUtils.access$000();
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
