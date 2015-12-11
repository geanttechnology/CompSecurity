// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.media.MediaCodecInfo;
import android.util.Log;
import android.util.Pair;
import java.util.HashMap;

public final class aob
{

    private static final HashMap a = new HashMap();

    private static Pair a(aoc aoc1, aoe aoe1)
    {
        Object obj;
        String s;
        String s1;
        android.media.MediaCodecInfo.CodecCapabilities codeccapabilities;
        int i;
        int j;
        boolean flag1;
        MediaCodecInfo mediacodecinfo;
        String as[];
        HashMap hashmap;
        int k;
        boolean flag;
        try
        {
            s = aoc1.a;
            k = aoe1.a();
            flag = aoe1.b();
        }
        // Misplaced declaration of an exception variable
        catch (aoc aoc1)
        {
            throw new aod(aoc1);
        }
        i = 0;
_L14:
        if (i >= k) goto _L2; else goto _L1
_L1:
        mediacodecinfo = aoe1.a(i);
        s1 = mediacodecinfo.getName();
        if (mediacodecinfo.isEncoder() || !s1.startsWith("OMX."))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (flag)
        {
            break MISSING_BLOCK_LABEL_81;
        }
        if (s1.endsWith(".secure"))
        {
            continue; /* Loop/switch isn't completed */
        }
        as = mediacodecinfo.getSupportedTypes();
        j = 0;
_L13:
        if (j >= as.length)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = as[j];
        if (!((String) (obj)).equalsIgnoreCase(s)) goto _L4; else goto _L3
_L3:
        codeccapabilities = mediacodecinfo.getCapabilitiesForType(((String) (obj)));
        flag1 = aoe1.a(aoc1.a, codeccapabilities);
        if (flag) goto _L6; else goto _L5
_L5:
        hashmap = a;
        if (!aoc1.b)
        {
            break MISSING_BLOCK_LABEL_328;
        }
        obj = new aoc(s, false);
_L15:
        hashmap.put(obj, Pair.create(s1, codeccapabilities));
        if (!flag1) goto _L8; else goto _L7
_L7:
        hashmap = a;
        if (!aoc1.b) goto _L10; else goto _L9
_L9:
        obj = aoc1;
_L11:
        hashmap.put(obj, Pair.create(String.valueOf(s1).concat(".secure"), codeccapabilities));
_L8:
        if (a.containsKey(aoc1))
        {
            return (Pair)a.get(aoc1);
        }
          goto _L4
_L10:
        obj = new aoc(s, true);
          goto _L11
_L6:
        HashMap hashmap1;
        hashmap1 = a;
        if (aoc1.b != flag1)
        {
            break MISSING_BLOCK_LABEL_294;
        }
        obj = aoc1;
_L12:
        hashmap1.put(obj, Pair.create(s1, codeccapabilities));
          goto _L8
        obj = new aoc(s, flag1);
          goto _L12
_L4:
        j++;
          goto _L13
        i++;
          goto _L14
_L2:
        return null;
        obj = aoc1;
          goto _L15
    }

    public static ang a(String s, boolean flag)
    {
        Object obj = b(s, flag);
        if (obj == null)
        {
            return null;
        }
        s = (String)((Pair) (obj)).first;
        obj = (android.media.MediaCodecInfo.CodecCapabilities)((Pair) (obj)).second;
        if (atp.a >= 19)
        {
            flag = ((android.media.MediaCodecInfo.CodecCapabilities) (obj)).isFeatureSupported("adaptive-playback");
        } else
        {
            flag = false;
        }
        return new ang(s, flag);
    }

    public static boolean a(int i, int j)
    {
        Object obj = b("video/avc", false);
        if (obj != null)
        {
            obj = (android.media.MediaCodecInfo.CodecCapabilities)((Pair) (obj)).second;
            int k = 0;
            while (k < ((android.media.MediaCodecInfo.CodecCapabilities) (obj)).profileLevels.length) 
            {
                android.media.MediaCodecInfo.CodecProfileLevel codecprofilelevel = ((android.media.MediaCodecInfo.CodecCapabilities) (obj)).profileLevels[k];
                if (codecprofilelevel.profile == i && codecprofilelevel.level >= j)
                {
                    return true;
                }
                k++;
            }
        }
        return false;
    }

    private static Pair b(String s, boolean flag)
    {
        aob;
        JVM INSTR monitorenter ;
        aoc aoc1 = new aoc(s, flag);
        if (!a.containsKey(aoc1)) goto _L2; else goto _L1
_L1:
        Object obj = (Pair)a.get(aoc1);
_L5:
        aob;
        JVM INSTR monitorexit ;
        return ((Pair) (obj));
_L2:
        if (atp.a < 21)
        {
            break MISSING_BLOCK_LABEL_168;
        }
        obj = new aog(flag);
_L3:
        Pair pair = a(aoc1, ((aoe) (obj)));
        obj = pair;
        if (!flag)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = pair;
        if (pair != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = pair;
        if (atp.a < 21)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = a(aoc1, new aof());
        if (obj == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        String s1 = (String)((Pair) (obj)).first;
        Log.w("MediaCodecUtil", (new StringBuilder(String.valueOf(s).length() + 63 + String.valueOf(s1).length())).append("MediaCodecList API didn't list secure decoder for: ").append(s).append(". Assuming: ").append(s1).toString());
        continue; /* Loop/switch isn't completed */
        obj = new aof();
          goto _L3
        s;
        throw s;
        if (true) goto _L5; else goto _L4
_L4:
    }

}
