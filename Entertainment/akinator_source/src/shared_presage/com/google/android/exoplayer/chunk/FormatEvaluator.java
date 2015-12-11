// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.chunk;

import java.util.List;
import java.util.Random;
import shared_presage.com.google.android.exoplayer.upstream.BandwidthMeter;

// Referenced classes of package shared_presage.com.google.android.exoplayer.chunk:
//            Format, MediaChunk

public interface FormatEvaluator
{
    public static final class AdaptiveEvaluator
        implements FormatEvaluator
    {

        public static final float DEFAULT_BANDWIDTH_FRACTION = 0.75F;
        public static final int DEFAULT_MAX_DURATION_FOR_QUALITY_DECREASE_MS = 25000;
        public static final int DEFAULT_MAX_INITIAL_BITRATE = 0xc3500;
        public static final int DEFAULT_MIN_DURATION_FOR_QUALITY_INCREASE_MS = 10000;
        public static final int DEFAULT_MIN_DURATION_TO_RETAIN_AFTER_DISCARD_MS = 25000;
        private final float bandwidthFraction;
        private final BandwidthMeter bandwidthMeter;
        private final long maxDurationForQualityDecreaseUs;
        private final int maxInitialBitrate;
        private final long minDurationForQualityIncreaseUs;
        private final long minDurationToRetainAfterDiscardUs;

        private Format determineIdealFormat(Format aformat[], long l)
        {
            int i;
            if (l == -1L)
            {
                l = maxInitialBitrate;
            } else
            {
                l = (long)((float)l * bandwidthFraction);
            }
            for (i = 0; i < aformat.length; i++)
            {
                Format format = aformat[i];
                if ((long)format.bitrate <= l)
                {
                    return format;
                }
            }

            return aformat[aformat.length - 1];
        }

        public final void disable()
        {
        }

        public final void enable()
        {
        }

        public final void evaluate(List list, long l, Format aformat[], Evaluation evaluation)
        {
            Format format;
            boolean flag1;
            long l1;
            boolean flag2 = false;
            boolean flag;
            if (list.isEmpty())
            {
                l1 = 0L;
            } else
            {
                l1 = ((MediaChunk)list.get(list.size() - 1)).endTimeUs - l;
            }
            format = evaluation.format;
            aformat = determineIdealFormat(aformat, bandwidthMeter.getBitrateEstimate());
            if (aformat != null && format != null && ((Format) (aformat)).bitrate > format.bitrate)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag2;
            if (aformat != null)
            {
                flag1 = flag2;
                if (format != null)
                {
                    flag1 = flag2;
                    if (((Format) (aformat)).bitrate < format.bitrate)
                    {
                        flag1 = true;
                    }
                }
            }
            if (!flag) goto _L2; else goto _L1
_L1:
            if (l1 >= minDurationForQualityIncreaseUs) goto _L4; else goto _L3
_L3:
            list = format;
_L7:
            if (format != null && list != format)
            {
                evaluation.trigger = 3;
            }
            evaluation.format = list;
            return;
_L4:
            if (l1 >= minDurationToRetainAfterDiscardUs)
            {
                int i = 1;
                do
                {
                    if (i >= list.size())
                    {
                        break;
                    }
                    MediaChunk mediachunk = (MediaChunk)list.get(i);
                    if (mediachunk.startTimeUs - l >= minDurationToRetainAfterDiscardUs && mediachunk.format.bitrate < ((Format) (aformat)).bitrate && mediachunk.format.height < ((Format) (aformat)).height && mediachunk.format.height < 720 && mediachunk.format.width < 1280)
                    {
                        evaluation.queueSize = i;
                        list = aformat;
                        continue; /* Loop/switch isn't completed */
                    }
                    i++;
                } while (true);
                list = aformat;
                continue; /* Loop/switch isn't completed */
            }
              goto _L5
_L2:
            if (flag1 && format != null && l1 >= maxDurationForQualityDecreaseUs)
            {
                list = format;
                continue; /* Loop/switch isn't completed */
            }
_L5:
            list = aformat;
            if (true) goto _L7; else goto _L6
_L6:
        }

        public AdaptiveEvaluator(BandwidthMeter bandwidthmeter)
        {
            this(bandwidthmeter, 0xc3500, 10000, 25000, 25000, 0.75F);
        }

        public AdaptiveEvaluator(BandwidthMeter bandwidthmeter, int i, int j, int k, int l, float f)
        {
            bandwidthMeter = bandwidthmeter;
            maxInitialBitrate = i;
            minDurationForQualityIncreaseUs = (long)j * 1000L;
            maxDurationForQualityDecreaseUs = (long)k * 1000L;
            minDurationToRetainAfterDiscardUs = (long)l * 1000L;
            bandwidthFraction = f;
        }
    }

    public static final class Evaluation
    {

        public Format format;
        public int queueSize;
        public int trigger;

        public Evaluation()
        {
            trigger = 1;
        }
    }

    public static final class FixedEvaluator
        implements FormatEvaluator
    {

        public final void disable()
        {
        }

        public final void enable()
        {
        }

        public final void evaluate(List list, long l, Format aformat[], Evaluation evaluation)
        {
            evaluation.format = aformat[0];
        }

        public FixedEvaluator()
        {
        }
    }

    public static final class RandomEvaluator
        implements FormatEvaluator
    {

        private final Random random;

        public final void disable()
        {
        }

        public final void enable()
        {
        }

        public final void evaluate(List list, long l, Format aformat[], Evaluation evaluation)
        {
            list = aformat[random.nextInt(aformat.length)];
            if (evaluation.format != null && !evaluation.format.equals(list))
            {
                evaluation.trigger = 3;
            }
            evaluation.format = list;
        }

        public RandomEvaluator()
        {
            random = new Random();
        }

        public RandomEvaluator(int i)
        {
            random = new Random(i);
        }
    }


    public abstract void disable();

    public abstract void enable();

    public abstract void evaluate(List list, long l, Format aformat[], Evaluation evaluation);
}
