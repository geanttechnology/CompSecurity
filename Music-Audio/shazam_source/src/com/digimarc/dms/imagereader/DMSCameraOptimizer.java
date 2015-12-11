// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms.imagereader;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.util.Log;
import com.digimarc.dms.camerasettings.DMSCameraSettingsKB;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.digimarc.dms.imagereader:
//            ResolutionPoints

public class DMSCameraOptimizer
{
    public static final class CaptureFormat extends Enum
    {

        private static final CaptureFormat $VALUES[];
        public static final CaptureFormat RGB888;
        public static final CaptureFormat RGBA8888;
        public static final CaptureFormat YUV420;

        public static CaptureFormat valueOf(String s)
        {
            return (CaptureFormat)Enum.valueOf(com/digimarc/dms/imagereader/DMSCameraOptimizer$CaptureFormat, s);
        }

        public static CaptureFormat[] values()
        {
            return (CaptureFormat[])$VALUES.clone();
        }

        static 
        {
            YUV420 = new CaptureFormat("YUV420", 0);
            RGB888 = new CaptureFormat("RGB888", 1);
            RGBA8888 = new CaptureFormat("RGBA8888", 2);
            $VALUES = (new CaptureFormat[] {
                YUV420, RGB888, RGBA8888
            });
        }

        private CaptureFormat(String s, int i)
        {
            super(s, i);
        }
    }


    private static Comparator PointComparator = new Comparator() {

        public final int compare(ResolutionPoints resolutionpoints, ResolutionPoints resolutionpoints1)
        {
            return resolutionpoints1.compareTo(resolutionpoints);
        }

        public final volatile int compare(Object obj, Object obj1)
        {
            return compare((ResolutionPoints)obj, (ResolutionPoints)obj1);
        }

    };
    private static final String TAG = "DMSCameraOptimizer";
    private static final int defaultPreviewSizeX = 1280;
    private static final int defaultPreviewSizeY = 720;
    private static Set mIppHash = new HashSet() {

            
            {
                add("off");
                add("ldc");
                add("nsf");
                add("ldc-nsf");
            }
    };
    private CaptureFormat mCaptureFormat;
    private boolean mChromaMarks;
    private boolean mClassicMarks;

    public DMSCameraOptimizer()
    {
        mCaptureFormat = CaptureFormat.YUV420;
        mClassicMarks = true;
        mChromaMarks = true;
    }

    public static android.hardware.Camera.Parameters getBestCameraParameters(Context context, android.hardware.Camera.Parameters parameters)
    {
        outputCameraParameters(parameters);
        Object obj = getBestPreviewSize(context, parameters.get("preview-size-values"));
        parameters.setPreviewSize(((Point) (obj)).x, ((Point) (obj)).y);
        context = DMSCameraSettingsKB.getInstance(context, null);
        String s;
        String as[];
        Exception exception;
        String s1;
        int i;
        int j;
        if (context.isLimitedFocus())
        {
            (new StringBuilder("Handset model ")).append(Build.MODEL).append(" has limited AF support, limiting to AUTO setting");
            i = 1;
        } else
        {
            i = 0;
        }
        obj = parameters.getSupportedFocusModes();
        (new StringBuilder("Available focus modes :")).append(obj);
        if (((List) (obj)).contains("fixed"))
        {
            parameters.setFocusMode("fixed");
        }
        if (((List) (obj)).contains("auto"))
        {
            parameters.setFocusMode("auto");
        }
        if (i == 0)
        {
            if (((List) (obj)).contains("continuous-video"))
            {
                parameters.setFocusMode("continuous-video");
            }
            if (((List) (obj)).contains("continuous-picture"))
            {
                parameters.setFocusMode("continuous-picture");
            }
        }
        (new StringBuilder("Selected focus mode: ")).append(parameters.getFocusMode());
        if (!context.needsCameraCorrections()) goto _L2; else goto _L1
_L1:
        obj = parameters.get("ipp");
        s = parameters.get("ipp-values");
        if (obj == null || s == null) goto _L2; else goto _L3
_L3:
        as = s.split(",");
        j = as.length;
        i = 0;
_L8:
        if (i >= j) goto _L2; else goto _L4
_L4:
        s1 = as[i];
        if (!mIppHash.contains(s1) || !s1.contentEquals("off")) goto _L6; else goto _L5
_L5:
        parameters.set("ipp", "off");
        (new StringBuilder("Found IPP, old value: ")).append(((String) (obj))).append(" new value: ").append(parameters.get("ipp"));
_L2:
        context = context.getCameraParams();
        if (context != null)
        {
            j = context.length;
            i = 0;
            while (i < j) 
            {
                obj = context[i];
                as = ((String) (obj)).split("=");
                if (as[0] != null && as[1] != null)
                {
                    (new StringBuilder("Setting Camera.Parameters to: ")).append(as[0]).append(",").append(as[1]);
                    try
                    {
                        parameters.set(as[0], as[1]);
                    }
                    // Misplaced declaration of an exception variable
                    catch (Exception exception)
                    {
                        Log.e("DMSCameraOptimizer", (new StringBuilder("Device failed to set camera params: ")).append(((String) (obj))).toString());
                    }
                }
                i++;
            }
        }
        break; /* Loop/switch isn't completed */
_L6:
        i++;
        if (true) goto _L8; else goto _L7
_L7:
        outputCameraParameters(parameters);
        return parameters;
    }

    protected static Point getBestPreviewSize(Context context, String s)
    {
        int i;
        int j;
        i = 0;
        j = getRecommendedResolution(context);
        context = s.split(",");
        s = new ArrayList();
_L2:
        if (i >= context.length)
        {
            break; /* Loop/switch isn't completed */
        }
        ResolutionPoints resolutionpoints = new ResolutionPoints(0, 0);
        String as[] = context[i].split("x");
        resolutionpoints.x = Integer.parseInt(as[0]);
        resolutionpoints.y = Integer.parseInt(as[1]);
        s.add(resolutionpoints);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        Iterator iterator;
        Collections.sort(s, PointComparator);
        iterator = s.iterator();
_L6:
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        int k;
        context = (Point)iterator.next();
        i = ((Point) (context)).x;
        k = ((Point) (context)).y;
        if (j < i * k) goto _L6; else goto _L5
_L5:
        Object obj = context;
        if (context == null)
        {
            obj = context;
            if (s != null)
            {
                obj = context;
                if (s.size() > 0)
                {
                    obj = (Point)s.get(s.size() - 1);
                }
            }
        }
        return ((Point) (obj));
_L4:
        context = null;
        continue; /* Loop/switch isn't completed */
        context;
        context = null;
_L8:
        s = context;
        context = null;
        if (true) goto _L5; else goto _L7
_L7:
        context;
        context = s;
          goto _L8
    }

    private static int getRecommendedResolution(Context context)
    {
        context = DMSCameraSettingsKB.getInstance(context, null).getRecommendedResolution(Build.MODEL);
        if (context != null)
        {
            int i = ((Point) (context)).x * ((Point) (context)).y;
            if (i > 0)
            {
                return i;
            }
            (new StringBuilder("Invalid Resolution: ")).append(((Point) (context)).x).append("x").append(((Point) (context)).y);
        }
        return 0xe1000;
    }

    private static void outputCameraParameters(android.hardware.Camera.Parameters parameters)
    {
        Object obj = parameters.flatten();
        String s;
        String s1;
        String s2;
        for (obj = Pattern.compile(";[[\\w][-]]+-values=").matcher(((CharSequence) (obj))); ((Matcher) (obj)).find(); (new StringBuilder("    Param: ")).append(s).append(", Value: ").append(s1).append(", Options: ").append(s2))
        {
            s = ((Matcher) (obj)).group();
            s2 = s.substring(1, s.length() - 1);
            s = s2.substring(0, s2.indexOf("-values"));
            s1 = parameters.get(s);
            s2 = parameters.get(s2);
        }

    }

    protected CaptureFormat getCaptureFormat()
    {
        return mCaptureFormat;
    }

    protected boolean getChromaWatermarksSupported()
    {
        return mChromaMarks;
    }

    protected boolean getClassicWatermarksSupported()
    {
        return mClassicMarks;
    }

    protected void setCaptureFormat(CaptureFormat captureformat)
    {
        mCaptureFormat = captureformat;
    }

    protected void setChromaWatermarksSupported(boolean flag)
    {
        mChromaMarks = flag;
    }

    protected void setClassicWatermarksSupported(boolean flag)
    {
        mClassicMarks = flag;
    }

}
