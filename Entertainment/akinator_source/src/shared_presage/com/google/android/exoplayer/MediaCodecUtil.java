// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import java.util.HashMap;
import shared_presage.com.google.android.exoplayer.util.Assertions;
import shared_presage.com.google.android.exoplayer.util.Util;

// Referenced classes of package shared_presage.com.google.android.exoplayer:
//            DecoderInfo, j

public final class MediaCodecUtil
{
    public static class DecoderQueryException extends Exception
    {

        private DecoderQueryException(Throwable throwable)
        {
            super("Failed to query underlying media codecs", throwable);
        }

        DecoderQueryException(Throwable throwable, j j)
        {
            this(throwable);
        }
    }

    private static final class a
    {

        public final String a;
        public final boolean b;

        public final boolean equals(Object obj)
        {
            if (this != obj)
            {
                if (obj == null || obj.getClass() != shared_presage/com/google/android/exoplayer/MediaCodecUtil$a)
                {
                    return false;
                }
                obj = (a)obj;
                if (!TextUtils.equals(a, ((a) (obj)).a) || b != ((a) (obj)).b)
                {
                    return false;
                }
            }
            return true;
        }

        public final int hashCode()
        {
            int i;
            char c1;
            if (a == null)
            {
                i = 0;
            } else
            {
                i = a.hashCode();
            }
            if (b)
            {
                c1 = '\u04CF';
            } else
            {
                c1 = '\u04D5';
            }
            return c1 + (i + 31) * 31;
        }

        public a(String s, boolean flag)
        {
            a = s;
            b = flag;
        }
    }

    private static interface b
    {

        public abstract int a();

        public abstract MediaCodecInfo a(int i);

        public abstract boolean a(String s, android.media.MediaCodecInfo.CodecCapabilities codeccapabilities);

        public abstract boolean b();
    }

    private static final class c
        implements b
    {

        public final int a()
        {
            return MediaCodecList.getCodecCount();
        }

        public final MediaCodecInfo a(int i)
        {
            return MediaCodecList.getCodecInfoAt(i);
        }

        public final boolean a(String s, android.media.MediaCodecInfo.CodecCapabilities codeccapabilities)
        {
            return "video/avc".equals(s);
        }

        public final boolean b()
        {
            return false;
        }

        private c()
        {
        }

        c(byte byte0)
        {
            this();
        }
    }

    private static final class d
        implements b
    {

        private final int a;
        private MediaCodecInfo b[];

        private void c()
        {
            if (b == null)
            {
                b = (new MediaCodecList(a)).getCodecInfos();
            }
        }

        public final int a()
        {
            c();
            return b.length;
        }

        public final MediaCodecInfo a(int i)
        {
            c();
            return b[i];
        }

        public final boolean a(String s, android.media.MediaCodecInfo.CodecCapabilities codeccapabilities)
        {
            return codeccapabilities.isFeatureSupported("secure-playback");
        }

        public final boolean b()
        {
            return true;
        }

        public d(boolean flag)
        {
            int i;
            if (flag)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            a = i;
        }
    }


    private static final String TAG = "MediaCodecUtil";
    private static final HashMap codecs = new HashMap();

    private MediaCodecUtil()
    {
    }

    private static int avcLevelToMaxFrameSize(int i)
    {
        char c1 = '\u6300';
        switch (i)
        {
        default:
            c1 = '\uFFFF';
            // fall through

        case 1: // '\001'
        case 2: // '\002'
            return c1;

        case 8: // '\b'
            return 0x18c00;

        case 16: // '\020'
            return 0x18c00;

        case 32: // ' '
            return 0x18c00;

        case 64: // '@'
            return 0x31800;

        case 128: 
            return 0x65400;

        case 256: 
            return 0x65400;

        case 512: 
            return 0xe1000;

        case 1024: 
            return 0x140000;

        case 2048: 
            return 0x200000;

        case 4096: 
            return 0x200000;

        case 8192: 
            return 0x220000;

        case 16384: 
            return 0x564000;

        case 32768: 
            return 0x900000;
        }
    }

    public static DecoderInfo getDecoderInfo(String s, boolean flag)
    {
        s = getMediaCodecInfo(s, flag);
        if (s == null)
        {
            return null;
        } else
        {
            return new DecoderInfo((String)((Pair) (s)).first, isAdaptive((android.media.MediaCodecInfo.CodecCapabilities)((Pair) (s)).second));
        }
    }

    private static Pair getMediaCodecInfo(String s, boolean flag)
    {
        shared_presage/com/google/android/exoplayer/MediaCodecUtil;
        JVM INSTR monitorenter ;
        a a1 = new a(s, flag);
        if (!codecs.containsKey(a1)) goto _L2; else goto _L1
_L1:
        Object obj = (Pair)codecs.get(a1);
_L5:
        shared_presage/com/google/android/exoplayer/MediaCodecUtil;
        JVM INSTR monitorexit ;
        return ((Pair) (obj));
_L2:
        if (Util.SDK_INT < 21)
        {
            break MISSING_BLOCK_LABEL_146;
        }
        obj = new d(flag);
_L3:
        Pair pair = getMediaCodecInfo(a1, ((b) (obj)));
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
        if (Util.SDK_INT < 21)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = getMediaCodecInfo(a1, ((b) (new c((byte)0))));
        if (obj == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        Log.w("MediaCodecUtil", (new StringBuilder("MediaCodecList API didn't list secure decoder for: ")).append(s).append(". Assuming: ").append((String)((Pair) (obj)).first).toString());
        continue; /* Loop/switch isn't completed */
        obj = new c((byte)0);
          goto _L3
        s;
        throw s;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private static Pair getMediaCodecInfo(a a1, b b1)
    {
        try
        {
            a1 = getMediaCodecInfoInternal(a1, b1);
        }
        // Misplaced declaration of an exception variable
        catch (a a1)
        {
            throw new DecoderQueryException(a1, null);
        }
        return a1;
    }

    private static Pair getMediaCodecInfoInternal(a a1, b b1)
    {
        String s1 = a1.a;
        int k = b1.a();
        boolean flag = b1.b();
        for (int i = 0; i < k; i++)
        {
            MediaCodecInfo mediacodecinfo = b1.a(i);
            String s2 = mediacodecinfo.getName();
            if (!isCodecUsableDecoder(mediacodecinfo, s2, flag))
            {
                continue;
            }
            String as[] = mediacodecinfo.getSupportedTypes();
            for (int j = 0; j < as.length; j++)
            {
                String s = as[j];
                if (!s.equalsIgnoreCase(s1))
                {
                    continue;
                }
                android.media.MediaCodecInfo.CodecCapabilities codeccapabilities = mediacodecinfo.getCapabilitiesForType(s);
                boolean flag1 = b1.a(a1.a, codeccapabilities);
                if (!flag)
                {
                    HashMap hashmap = codecs;
                    a a2;
                    if (a1.b)
                    {
                        a2 = new a(s1, false);
                    } else
                    {
                        a2 = a1;
                    }
                    hashmap.put(a2, Pair.create(s2, codeccapabilities));
                    if (flag1)
                    {
                        HashMap hashmap1 = codecs;
                        if (a1.b)
                        {
                            a2 = a1;
                        } else
                        {
                            a2 = new a(s1, true);
                        }
                        hashmap1.put(a2, Pair.create((new StringBuilder()).append(s2).append(".secure").toString(), codeccapabilities));
                    }
                } else
                {
                    HashMap hashmap2 = codecs;
                    a a3;
                    if (a1.b == flag1)
                    {
                        a3 = a1;
                    } else
                    {
                        a3 = new a(s1, flag1);
                    }
                    hashmap2.put(a3, Pair.create(s2, codeccapabilities));
                }
                if (codecs.containsKey(a1))
                {
                    return (Pair)codecs.get(a1);
                }
            }

        }

        return null;
    }

    private static boolean isAdaptive(android.media.MediaCodecInfo.CodecCapabilities codeccapabilities)
    {
        if (Util.SDK_INT >= 19)
        {
            return isAdaptiveV19(codeccapabilities);
        } else
        {
            return false;
        }
    }

    private static boolean isAdaptiveV19(android.media.MediaCodecInfo.CodecCapabilities codeccapabilities)
    {
        return codeccapabilities.isFeatureSupported("adaptive-playback");
    }

    private static boolean isCodecUsableDecoder(MediaCodecInfo mediacodecinfo, String s, boolean flag)
    {
        while (mediacodecinfo.isEncoder() || !s.startsWith("OMX.") || !flag && s.endsWith(".secure") || Util.SDK_INT == 16 && ("dlxu".equals(Util.DEVICE) || "protou".equals(Util.DEVICE) || "C6602".equals(Util.DEVICE) || "C6603".equals(Util.DEVICE)) && s.equals("OMX.qcom.audio.decoder.mp3") || Util.SDK_INT <= 19 && Util.DEVICE != null && Util.DEVICE.startsWith("serrano") && "samsung".equals(Util.MANUFACTURER) && s.equals("OMX.SEC.vp8.dec")) 
        {
            return false;
        }
        return true;
    }

    public static boolean isH264ProfileSupported(int i, int j)
    {
        Object obj = getMediaCodecInfo("video/avc", false);
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

    public static boolean isSizeAndRateSupportedV21(String s, boolean flag, int i, int j, double d1)
    {
        boolean flag1;
        if (Util.SDK_INT >= 21)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        Assertions.checkState(flag1);
        s = getMediaCodecInfo(s, flag);
        if (s != null)
        {
            if ((s = ((android.media.MediaCodecInfo.CodecCapabilities)((Pair) (s)).second).getVideoCapabilities()) != null && s.areSizeAndRateSupported(i, j, d1))
            {
                return true;
            }
        }
        return false;
    }

    public static int maxH264DecodableFrameSize()
    {
        int i = 0;
        Object obj = getMediaCodecInfo("video/avc", false);
        if (obj == null)
        {
            return 0;
        }
        obj = (android.media.MediaCodecInfo.CodecCapabilities)((Pair) (obj)).second;
        int j = 0;
        for (; i < ((android.media.MediaCodecInfo.CodecCapabilities) (obj)).profileLevels.length; i++)
        {
            j = Math.max(avcLevelToMaxFrameSize(((android.media.MediaCodecInfo.CodecCapabilities) (obj)).profileLevels[i].level), j);
        }

        return j;
    }

    public static void warmCodec(String s, boolean flag)
    {
        shared_presage/com/google/android/exoplayer/MediaCodecUtil;
        JVM INSTR monitorenter ;
        getMediaCodecInfo(s, flag);
_L2:
        shared_presage/com/google/android/exoplayer/MediaCodecUtil;
        JVM INSTR monitorexit ;
        return;
        s;
        Log.e("MediaCodecUtil", "Codec warming failed", s);
        if (true) goto _L2; else goto _L1
_L1:
        s;
        throw s;
    }

}
