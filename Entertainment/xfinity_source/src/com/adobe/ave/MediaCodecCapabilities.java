// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.ave;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MediaCodecCapabilities
{

    private static final String TAG = "MediaCodecCapabilities(j)";
    private static Map capabilitiesMap = new HashMap();
    private static ArrayList codecInfoList = new ArrayList();

    public MediaCodecCapabilities()
    {
    }

    public static boolean IsABRSupportedByMediaCodec(String s)
    {
        if (android.os.Build.VERSION.SDK_INT >= 19) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        int i;
        if (codecInfoList.isEmpty() || capabilitiesMap.keySet().isEmpty() || !s.equalsIgnoreCase("video/avc"))
        {
            break MISSING_BLOCK_LABEL_147;
        }
        i = 0;
_L4:
        android.media.MediaCodecInfo.CodecCapabilities codeccapabilities;
        if (i >= codecInfoList.size())
        {
            continue; /* Loop/switch isn't completed */
        }
        s = (MediaCodecInfo)codecInfoList.get(i);
        codeccapabilities = (android.media.MediaCodecInfo.CodecCapabilities)capabilitiesMap.get(s.getName());
        if (codeccapabilities != null)
        {
            break; /* Loop/switch isn't completed */
        }
_L6:
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        boolean flag;
        flag = codeccapabilities.isFeatureSupported("adaptive-playback");
        Log.w("MediaCodecCapabilities(j)", (new StringBuilder()).append("IsCodecSupported (video/avc) : info = ").append(s.getName()).append("AdaptivePlayback supported = ").append(flag).toString());
        if (!flag) goto _L6; else goto _L5
_L5:
        return true;
        int l = MediaCodecList.getCodecCount();
        int j = 0;
        while (j < l) 
        {
            MediaCodecInfo mediacodecinfo = MediaCodecList.getCodecInfoAt(j);
            if (!mediacodecinfo.isEncoder())
            {
                String as[] = mediacodecinfo.getSupportedTypes();
                int k = 0;
                while (k < as.length) 
                {
                    if (as[k].equalsIgnoreCase(s))
                    {
                        boolean flag1 = mediacodecinfo.getCapabilitiesForType(as[k]).isFeatureSupported("adaptive-playback");
                        Log.w("MediaCodecCapabilities(j)", (new StringBuilder()).append("IsCodecSupported (video/avc) : info = ").append(mediacodecinfo.getName()).append("AdaptivePlayback supported = ").append(flag1).toString());
                        if (flag1)
                        {
                            return true;
                        }
                    }
                    k++;
                }
            }
            j++;
        }
        if (true) goto _L1; else goto _L7
_L7:
    }

    public static boolean IsCodecSupported(String s)
    {
        int k = MediaCodecList.getCodecCount();
        int i = 0;
        while (i < k) 
        {
            MediaCodecInfo mediacodecinfo = MediaCodecList.getCodecInfoAt(i);
            if (!mediacodecinfo.isEncoder())
            {
                String as[] = mediacodecinfo.getSupportedTypes();
                int j = 0;
                while (j < as.length) 
                {
                    if (as[j].equalsIgnoreCase(s))
                    {
                        Log.w("MediaCodecCapabilities(j)", (new StringBuilder()).append("IsCodecSupported (").append(s).append(") : info = ").append(mediacodecinfo.getName()).append(" : yes, it's supported").toString());
                        return true;
                    }
                    j++;
                }
            }
            i++;
        }
        Log.w("MediaCodecCapabilities(j)", (new StringBuilder()).append("IsCodecSupported (").append(s).append(") : no, it's not supported").toString());
        return false;
    }

    public static boolean IsProfileLevelSupported(String s, int i, int j)
    {
        boolean flag;
        boolean flag2;
        flag2 = false;
        flag = false;
        if (codecInfoList.isEmpty())
        {
            getCodecInfos(s);
        }
        if (codecInfoList.isEmpty())
        {
            Log.w("MediaCodecCapabilities(j)", (new StringBuilder()).append("no codeInfo for mime ").append(s).toString());
            return false;
        }
        if (!capabilitiesMap.keySet().isEmpty()) goto _L2; else goto _L1
_L1:
        int k = 0;
_L6:
        flag2 = flag;
        if (k >= codecInfoList.size()) goto _L4; else goto _L3
_L3:
        MediaCodecInfo mediacodecinfo;
        mediacodecinfo = (MediaCodecInfo)codecInfoList.get(k);
        s = null;
        android.media.MediaCodecInfo.CodecCapabilities codeccapabilities;
        try
        {
            codeccapabilities = mediacodecinfo.getCapabilitiesForType(new String("video/avc"));
        }
        catch (Exception exception)
        {
            Log.w("MediaCodecCapabilities(j)", "caught exception");
            break MISSING_BLOCK_LABEL_121;
        }
        s = codeccapabilities;
        if (s != null && isProfileLevelSupportedByCapacities(s, i, j, mediacodecinfo.getName()))
        {
            flag = true;
        }
        k++;
        continue; /* Loop/switch isn't completed */
_L2:
        s = capabilitiesMap.keySet().iterator();
        boolean flag1 = flag2;
        do
        {
            flag2 = flag1;
            if (!s.hasNext())
            {
                break;
            }
            String s1 = (String)s.next();
            android.media.MediaCodecInfo.CodecCapabilities codeccapabilities1 = (android.media.MediaCodecInfo.CodecCapabilities)capabilitiesMap.get(s1);
            if (codeccapabilities1 != null && isProfileLevelSupportedByCapacities(codeccapabilities1, i, j, s1))
            {
                flag1 = true;
            }
        } while (true);
_L4:
        if (!flag2)
        {
            Log.w("MediaCodecCapabilities(j)", (new StringBuilder()).append("profile ").append(i).append(" and level ").append(j).append("not supported").toString());
        }
        return flag2;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static void PreloadCodecInfoList(String s)
    {
        if (android.os.Build.VERSION.SDK_INT > 22)
        {
            if (codecInfoList.isEmpty())
            {
                getCodecInfos(s);
            }
            if (codecInfoList.isEmpty())
            {
                Log.w("MediaCodecCapabilities(j)", (new StringBuilder()).append("no codeInfo for mime ").append(s).toString());
                return;
            }
            int i = 0;
            while (i < codecInfoList.size()) 
            {
                MediaCodecInfo mediacodecinfo = (MediaCodecInfo)codecInfoList.get(i);
                try
                {
                    android.media.MediaCodecInfo.CodecCapabilities codeccapabilities = mediacodecinfo.getCapabilitiesForType(s);
                    capabilitiesMap.put(mediacodecinfo.getName(), codeccapabilities);
                }
                catch (Exception exception)
                {
                    Log.w("MediaCodecCapabilities(j)", "caught exception");
                }
                i++;
            }
        }
    }

    public static void PrintCodecList()
    {
        int k = MediaCodecList.getCodecCount();
        Log.w("MediaCodecCapabilities(j)", "PrintCodecList ---------");
        int i = 0;
        while (i < k) 
        {
            MediaCodecInfo mediacodecinfo = MediaCodecList.getCodecInfoAt(i);
            if (!mediacodecinfo.isEncoder())
            {
                Log.w("MediaCodecCapabilities(j)", (new StringBuilder()).append("    Name = [").append(mediacodecinfo.getName()).append("]").toString());
                String as[] = mediacodecinfo.getSupportedTypes();
                int j = 0;
                while (j < as.length) 
                {
                    Log.w("MediaCodecCapabilities(j)", (new StringBuilder()).append("        SupportedType[").append(j).append("] = [").append(as[j]).append("]").toString());
                    j++;
                }
            }
            i++;
        }
        Log.w("MediaCodecCapabilities(j)", "-------------------------------");
    }

    private static void getCodecInfos(String s)
    {
        int k = MediaCodecList.getCodecCount();
        int i = 0;
        while (i < k) 
        {
            MediaCodecInfo mediacodecinfo = MediaCodecList.getCodecInfoAt(i);
            if (!mediacodecinfo.isEncoder())
            {
                String as[] = mediacodecinfo.getSupportedTypes();
                int j = 0;
                while (j < as.length) 
                {
                    if (as[j].equalsIgnoreCase(s))
                    {
                        codecInfoList.add(mediacodecinfo);
                        Log.w("MediaCodecCapabilities(j)", (new StringBuilder()).append("info = ").append(mediacodecinfo.getName()).toString());
                    }
                    j++;
                }
            }
            i++;
        }
    }

    private static boolean isProfileLevelSupportedByCapacities(android.media.MediaCodecInfo.CodecCapabilities codeccapabilities, int i, int j, String s)
    {
        boolean flag = false;
        StringBuilder stringbuilder = new StringBuilder();
        for (int k = 0; k < codeccapabilities.profileLevels.length;)
        {
            if (k > 0)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append((new StringBuilder()).append(codeccapabilities.profileLevels[k].profile).append(" / ").append(codeccapabilities.profileLevels[k].level).toString());
            boolean flag1 = flag;
            if (codeccapabilities.profileLevels[k].profile >= i)
            {
                flag1 = flag;
                if (codeccapabilities.profileLevels[k].level >= j)
                {
                    Log.w("MediaCodecCapabilities(j)", (new StringBuilder()).append("IsProfileLevelSupported suppported: caps.profileLevels[k].profile: ").append(codeccapabilities.profileLevels[k].profile).append(" >= profile: ").append(i).append(" and caps.profileLevels[k].level: ").append(codeccapabilities.profileLevels[k].level).append(" >= level: ").append(j).toString());
                    flag1 = true;
                }
            }
            k++;
            flag = flag1;
        }

        Log.d("MediaCodecCapabilities(j)", (new StringBuilder()).append("codecName ").append(s).append("    profiles/levels: ").append(stringbuilder).toString());
        return flag;
    }

}
