// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.Util;
import java.util.HashMap;

// Referenced classes of package com.google.android.exoplayer:
//            DecoderInfo

public final class MediaCodecUtil
{
    private static final class CodecKey
    {

        public final String mimeType;
        public final boolean secure;

        public boolean equals(Object obj)
        {
            if (this != obj)
            {
                if (obj == null || obj.getClass() != com/google/android/exoplayer/MediaCodecUtil$CodecKey)
                {
                    return false;
                }
                obj = (CodecKey)obj;
                if (!TextUtils.equals(mimeType, ((CodecKey) (obj)).mimeType) || secure != ((CodecKey) (obj)).secure)
                {
                    return false;
                }
            }
            return true;
        }

        public int hashCode()
        {
            int i;
            char c;
            if (mimeType == null)
            {
                i = 0;
            } else
            {
                i = mimeType.hashCode();
            }
            if (secure)
            {
                c = '\u04CF';
            } else
            {
                c = '\u04D5';
            }
            return (i + 31) * 31 + c;
        }

        public CodecKey(String s, boolean flag)
        {
            mimeType = s;
            secure = flag;
        }
    }

    public static class DecoderQueryException extends Exception
    {

        private DecoderQueryException(Throwable throwable)
        {
            super("Failed to query underlying media codecs", throwable);
        }

    }

    private static interface MediaCodecListCompat
    {

        public abstract int getCodecCount();

        public abstract MediaCodecInfo getCodecInfoAt(int i);

        public abstract boolean isSecurePlaybackSupported(String s, android.media.MediaCodecInfo.CodecCapabilities codeccapabilities);

        public abstract boolean secureDecodersExplicit();
    }

    private static final class MediaCodecListCompatV16
        implements MediaCodecListCompat
    {

        public int getCodecCount()
        {
            return MediaCodecList.getCodecCount();
        }

        public MediaCodecInfo getCodecInfoAt(int i)
        {
            return MediaCodecList.getCodecInfoAt(i);
        }

        public boolean isSecurePlaybackSupported(String s, android.media.MediaCodecInfo.CodecCapabilities codeccapabilities)
        {
            return "video/avc".equals(s);
        }

        public boolean secureDecodersExplicit()
        {
            return false;
        }

        private MediaCodecListCompatV16()
        {
        }

    }

    private static final class MediaCodecListCompatV21
        implements MediaCodecListCompat
    {

        private final int codecKind;
        private MediaCodecInfo mediaCodecInfos[];

        private void ensureMediaCodecInfosInitialized()
        {
            if (mediaCodecInfos == null)
            {
                mediaCodecInfos = (new MediaCodecList(codecKind)).getCodecInfos();
            }
        }

        public int getCodecCount()
        {
            ensureMediaCodecInfosInitialized();
            return mediaCodecInfos.length;
        }

        public MediaCodecInfo getCodecInfoAt(int i)
        {
            ensureMediaCodecInfosInitialized();
            return mediaCodecInfos[i];
        }

        public boolean isSecurePlaybackSupported(String s, android.media.MediaCodecInfo.CodecCapabilities codeccapabilities)
        {
            return codeccapabilities.isFeatureSupported("secure-playback");
        }

        public boolean secureDecodersExplicit()
        {
            return true;
        }

        public MediaCodecListCompatV21(boolean flag)
        {
            int i;
            if (flag)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            codecKind = i;
        }
    }


    private static final String TAG = "MediaCodecUtil";
    private static final HashMap codecs = new HashMap();

    private MediaCodecUtil()
    {
    }

    private static int avcLevelToMaxFrameSize(int i)
    {
        char c = '\u6300';
        switch (i)
        {
        default:
            c = '\uFFFF';
            // fall through

        case 1: // '\001'
        case 2: // '\002'
            return c;

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
        throws DecoderQueryException
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

    private static Pair getMediaCodecInfo(CodecKey codeckey, MediaCodecListCompat mediacodeclistcompat)
        throws DecoderQueryException
    {
        try
        {
            codeckey = getMediaCodecInfoInternal(codeckey, mediacodeclistcompat);
        }
        // Misplaced declaration of an exception variable
        catch (CodecKey codeckey)
        {
            throw new DecoderQueryException(codeckey);
        }
        return codeckey;
    }

    private static Pair getMediaCodecInfo(String s, boolean flag)
        throws DecoderQueryException
    {
        com/google/android/exoplayer/MediaCodecUtil;
        JVM INSTR monitorenter ;
        CodecKey codeckey = new CodecKey(s, flag);
        if (!codecs.containsKey(codeckey)) goto _L2; else goto _L1
_L1:
        s = (Pair)codecs.get(codeckey);
_L5:
        com/google/android/exoplayer/MediaCodecUtil;
        JVM INSTR monitorexit ;
        return s;
_L2:
        Object obj;
        if (Util.SDK_INT < 21)
        {
            break MISSING_BLOCK_LABEL_153;
        }
        obj = new MediaCodecListCompatV21(flag);
_L3:
        Pair pair = getMediaCodecInfo(codeckey, ((MediaCodecListCompat) (obj)));
        obj = pair;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_171;
        }
        obj = pair;
        if (pair != null)
        {
            break MISSING_BLOCK_LABEL_171;
        }
        obj = pair;
        if (Util.SDK_INT < 21)
        {
            break MISSING_BLOCK_LABEL_171;
        }
        pair = getMediaCodecInfo(codeckey, ((MediaCodecListCompat) (new MediaCodecListCompatV16())));
        obj = pair;
        if (pair == null)
        {
            break MISSING_BLOCK_LABEL_171;
        }
        Log.w("MediaCodecUtil", (new StringBuilder()).append("MediaCodecList API didn't list secure decoder for: ").append(s).append(". Assuming: ").append((String)pair.first).toString());
        obj = pair;
        break MISSING_BLOCK_LABEL_171;
        obj = new MediaCodecListCompatV16();
          goto _L3
        s;
        throw s;
        s = ((String) (obj));
        if (true) goto _L5; else goto _L4
_L4:
    }

    private static Pair getMediaCodecInfoInternal(CodecKey codeckey, MediaCodecListCompat mediacodeclistcompat)
    {
        String s1 = codeckey.mimeType;
        int k = mediacodeclistcompat.getCodecCount();
        boolean flag = mediacodeclistcompat.secureDecodersExplicit();
        for (int i = 0; i < k; i++)
        {
            MediaCodecInfo mediacodecinfo = mediacodeclistcompat.getCodecInfoAt(i);
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
                boolean flag1 = mediacodeclistcompat.isSecurePlaybackSupported(codeckey.mimeType, codeccapabilities);
                if (!flag)
                {
                    HashMap hashmap = codecs;
                    CodecKey codeckey1;
                    if (codeckey.secure)
                    {
                        codeckey1 = new CodecKey(s1, false);
                    } else
                    {
                        codeckey1 = codeckey;
                    }
                    hashmap.put(codeckey1, Pair.create(s2, codeccapabilities));
                    if (flag1)
                    {
                        HashMap hashmap1 = codecs;
                        if (codeckey.secure)
                        {
                            codeckey1 = codeckey;
                        } else
                        {
                            codeckey1 = new CodecKey(s1, true);
                        }
                        hashmap1.put(codeckey1, Pair.create((new StringBuilder()).append(s2).append(".secure").toString(), codeccapabilities));
                    }
                } else
                {
                    HashMap hashmap2 = codecs;
                    CodecKey codeckey2;
                    if (codeckey.secure == flag1)
                    {
                        codeckey2 = codeckey;
                    } else
                    {
                        codeckey2 = new CodecKey(s1, flag1);
                    }
                    hashmap2.put(codeckey2, Pair.create(s2, codeccapabilities));
                }
                if (codecs.containsKey(codeckey))
                {
                    return (Pair)codecs.get(codeckey);
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
        throws DecoderQueryException
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

    public static boolean isSizeAndRateSupportedV21(String s, boolean flag, int i, int j, double d)
        throws DecoderQueryException
    {
        boolean flag2 = true;
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
        if (s == null)
        {
            return false;
        }
        s = ((android.media.MediaCodecInfo.CodecCapabilities)((Pair) (s)).second).getVideoCapabilities();
        if (s != null && s.areSizeAndRateSupported(i, j, d))
        {
            flag = flag2;
        } else
        {
            flag = false;
        }
        return flag;
    }

    public static int maxH264DecodableFrameSize()
        throws DecoderQueryException
    {
        Object obj;
        int k;
        k = 0;
        obj = getMediaCodecInfo("video/avc", false);
        if (obj != null) goto _L2; else goto _L1
_L1:
        return k;
_L2:
        int i = 0;
        obj = (android.media.MediaCodecInfo.CodecCapabilities)((Pair) (obj)).second;
        int j = 0;
        do
        {
            k = i;
            if (j >= ((android.media.MediaCodecInfo.CodecCapabilities) (obj)).profileLevels.length)
            {
                continue;
            }
            i = Math.max(avcLevelToMaxFrameSize(((android.media.MediaCodecInfo.CodecCapabilities) (obj)).profileLevels[j].level), i);
            j++;
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
    }

    public static void warmCodec(String s, boolean flag)
    {
        com/google/android/exoplayer/MediaCodecUtil;
        JVM INSTR monitorenter ;
        getMediaCodecInfo(s, flag);
_L2:
        com/google/android/exoplayer/MediaCodecUtil;
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
