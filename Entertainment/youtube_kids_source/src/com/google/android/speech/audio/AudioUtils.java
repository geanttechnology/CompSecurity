// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.audio;

import a;
import android.media.audiofx.AudioEffect;
import emm;
import emp;
import eyt;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

// Referenced classes of package com.google.android.speech.audio:
//            AudioEncoderInputStream

public class AudioUtils
{

    private static final String AMR_AUDIO_FILE_HEADER = "#!AMR\n";
    private static final String AMR_INPUT_STREAM_CLASS = "android.media.AmrInputStream";
    public static final int BYTES_PER_SAMPLE = 2;
    public static final int DEFAULT_SAMPLING_RATE = 8000;
    private static final UUID EFFECT_TYPE_NOISE_SUPPRESSOR = UUID.fromString("58b4b260-8e06-11e0-aa8e-0002a5d5c51b");
    public static final int MAX_AMR_BYTES_PER_S3REQUEST = 384;
    private static Constructor sAmrInputStreamConstructor;

    private AudioUtils()
    {
    }

    private static InputStream createAmrInputStream(InputStream inputstream)
    {
        com/google/android/speech/audio/AudioUtils;
        JVM INSTR monitorenter ;
        if (sAmrInputStreamConstructor == null)
        {
            sAmrInputStreamConstructor = Class.forName("android.media.AmrInputStream").getConstructor(new Class[] {
                java/io/InputStream
            });
        }
        inputstream = (InputStream)sAmrInputStreamConstructor.newInstance(new Object[] {
            inputstream
        });
        com/google/android/speech/audio/AudioUtils;
        JVM INSTR monitorexit ;
        return inputstream;
        inputstream;
        com/google/android/speech/audio/AudioUtils;
        JVM INSTR monitorexit ;
        try
        {
            throw inputstream;
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw new RuntimeException("Exception while instantiating AmrInputStream", inputstream);
        }
    }

    private static InputStream createAmrWbInputStream(InputStream inputstream)
    {
        return new AudioEncoderInputStream(inputstream, "audio/amr-wb", 16000, 2048, 23850, 1);
    }

    public static byte[] encodeAmr(Encoding encoding, byte abyte0[])
    {
        switch (_cls1..SwitchMap.com.google.android.speech.audio.AudioUtils.Encoding[encoding.ordinal()])
        {
        default:
            throw new IllegalArgumentException((new StringBuilder("Encoding not supported: ")).append(encoding).toString());

        case 1: // '\001'
            return encodeAmrInternal(abyte0, 3, true);

        case 2: // '\002'
            return encodeAmrInternal(abyte0, 9, false);
        }
    }

    private static byte[] encodeAmrInternal(byte abyte0[], int i, boolean flag)
    {
        java.io.Closeable closeable = null;
        abyte0 = getEncodingInputStream(new ByteArrayInputStream(abyte0), i);
        closeable = abyte0;
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        closeable = abyte0;
        bytearrayoutputstream.write("#!AMR\n".getBytes());
        closeable = abyte0;
        byte abyte2[] = new byte[384];
_L2:
        closeable = abyte0;
        i = emm.a(abyte0, abyte2, 0, 384);
        if (i <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        closeable = abyte0;
        bytearrayoutputstream.write(abyte2, 0, i);
        if (true) goto _L2; else goto _L1
        abyte0;
        emp.a(closeable);
        throw abyte0;
_L1:
        closeable = abyte0;
        byte abyte1[] = bytearrayoutputstream.toByteArray();
        emp.a(abyte0);
        return abyte1;
    }

    public static Encoding getAmrEncodingForRecording(AudioStore.AudioRecording audiorecording)
    {
        if (audiorecording.getSampleRate() == 16000)
        {
            return Encoding.AMRWB;
        }
        if (audiorecording.getSampleRate() == 8000)
        {
            return Encoding.AMR;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("Unsupported sample rate: ")).append(audiorecording.getSampleRate()).toString());
        }
    }

    public static InputStream getEncodingInputStream(InputStream inputstream, int i)
    {
        if (i == 0)
        {
            return inputstream;
        }
        if (i == 3)
        {
            return createAmrInputStream(inputstream);
        }
        if (i == 9)
        {
            return createAmrWbInputStream(inputstream);
        } else
        {
            throw new RuntimeException((new StringBuilder("unsupported encoding:")).append(i).toString());
        }
    }

    public static List getNoiseSuppressors(eyt eyt1)
    {
        if (eyt1 != null) goto _L2; else goto _L1
_L1:
        eyt1 = a.K();
_L4:
        return eyt1;
_L2:
        LinkedList linkedlist;
        linkedlist = new LinkedList();
        List list = eyt1.a;
        android.media.audiofx.AudioEffect.Descriptor adescriptor[] = AudioEffect.queryEffects();
        int j = adescriptor.length;
        int i = 0;
        do
        {
            eyt1 = linkedlist;
            if (i >= j)
            {
                break;
            }
label0:
            {
                eyt1 = adescriptor[i];
                if (EFFECT_TYPE_NOISE_SUPPRESSOR.equals(((android.media.audiofx.AudioEffect.Descriptor) (eyt1)).type))
                {
                    eyt1 = ((android.media.audiofx.AudioEffect.Descriptor) (eyt1)).uuid.toString();
                    if (!list.contains(eyt1))
                    {
                        break label0;
                    }
                    linkedlist.add(eyt1);
                }
                i++;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
        linkedlist.clear();
        return linkedlist;
    }


    private class _cls1
    {

        static final int $SwitchMap$com$google$android$speech$audio$AudioUtils$Encoding[];

        static 
        {
            $SwitchMap$com$google$android$speech$audio$AudioUtils$Encoding = new int[Encoding.values().length];
            try
            {
                $SwitchMap$com$google$android$speech$audio$AudioUtils$Encoding[Encoding.AMR.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$google$android$speech$audio$AudioUtils$Encoding[Encoding.AMRWB.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class Encoding extends Enum
    {

        private static final Encoding $VALUES[];
        public static final Encoding AMR;
        public static final Encoding AMRWB;
        private final int mCode;
        private final String mExt;
        private final String mMimeType;
        private final int mRecognizerEncoding;

        public static Encoding fromCode(int i)
        {
            Encoding aencoding[] = values();
            int k = aencoding.length;
            for (int j = 0; j < k; j++)
            {
                Encoding encoding = aencoding[j];
                if (encoding.getCode() == i)
                {
                    return encoding;
                }
            }

            throw new IllegalArgumentException((new StringBuilder("invalid code: ")).append(i).toString());
        }

        public static Encoding valueOf(String s)
        {
            return (Encoding)Enum.valueOf(com/google/android/speech/audio/AudioUtils$Encoding, s);
        }

        public static Encoding[] values()
        {
            return (Encoding[])$VALUES.clone();
        }

        public final int getCode()
        {
            return mCode;
        }

        public final String getExt()
        {
            return mExt;
        }

        public final String getMimeType()
        {
            return mMimeType;
        }

        public final int getRecognizerEncoding()
        {
            return mRecognizerEncoding;
        }

        static 
        {
            AMR = new Encoding("AMR", 0, "audio/AMR", "amr", 1, 3);
            AMRWB = new Encoding("AMRWB", 1, "audio/amr-wb", "amr", 2, 9);
            $VALUES = (new Encoding[] {
                AMR, AMRWB
            });
        }

        private Encoding(String s, int i, String s1, String s2, int j, int k)
        {
            super(s, i);
            mMimeType = s1;
            mExt = s2;
            mCode = j;
            mRecognizerEncoding = k;
        }
    }

}
