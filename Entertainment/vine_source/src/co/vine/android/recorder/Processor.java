// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import com.edisonwang.android.slog.SLog;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Pattern;

// Referenced classes of package co.vine.android.recorder:
//            FFmpegInvoke

public final class Processor
{
    class _cls1CpuFilter
        implements FileFilter
    {

        public boolean accept(File file)
        {
            return Pattern.matches("cpu[0-9]", file.getName());
        }

        _cls1CpuFilter()
        {
        }
    }

    public static final class Preset extends Enum
    {

        private static final Preset $VALUES[];
        public static final Preset FAST;
        public static final Preset FASTER;
        public static final Preset MEDIUM;
        public static final Preset SLOW;
        public static final Preset SLOWER;
        public static final Preset SUPERFAST;
        public static final Preset ULTRAFAST;
        public static final Preset VERYFAST;

        public static Preset valueOf(String s)
        {
            return (Preset)Enum.valueOf(co/vine/android/recorder/Processor$Preset, s);
        }

        public static Preset[] values()
        {
            return (Preset[])$VALUES.clone();
        }

        static 
        {
            ULTRAFAST = new Preset("ULTRAFAST", 0);
            SUPERFAST = new Preset("SUPERFAST", 1);
            VERYFAST = new Preset("VERYFAST", 2);
            FASTER = new Preset("FASTER", 3);
            FAST = new Preset("FAST", 4);
            MEDIUM = new Preset("MEDIUM", 5);
            SLOW = new Preset("SLOW", 6);
            SLOWER = new Preset("SLOWER", 7);
            $VALUES = (new Preset[] {
                ULTRAFAST, SUPERFAST, VERYFAST, FASTER, FAST, MEDIUM, SLOW, SLOWER
            });
        }

        private Preset(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class Rotation extends Enum
    {

        private static final Rotation $VALUES[];
        public static final Rotation NO_FLIP_90_CLOCKWISE;
        public static final Rotation NO_FLIP_90_COUNTER_CLOCKWISE;
        public static final Rotation VERTICAL_FLIP_AND_90_CLOCKWISE;
        public static final Rotation VERTICAL_FLIP_AND_90_COUNTER_CLOCKWISE;

        public static Rotation valueOf(String s)
        {
            return (Rotation)Enum.valueOf(co/vine/android/recorder/Processor$Rotation, s);
        }

        public static Rotation[] values()
        {
            return (Rotation[])$VALUES.clone();
        }

        static 
        {
            VERTICAL_FLIP_AND_90_COUNTER_CLOCKWISE = new Rotation("VERTICAL_FLIP_AND_90_COUNTER_CLOCKWISE", 0);
            NO_FLIP_90_CLOCKWISE = new Rotation("NO_FLIP_90_CLOCKWISE", 1);
            NO_FLIP_90_COUNTER_CLOCKWISE = new Rotation("NO_FLIP_90_COUNTER_CLOCKWISE", 2);
            VERTICAL_FLIP_AND_90_CLOCKWISE = new Rotation("VERTICAL_FLIP_AND_90_CLOCKWISE", 3);
            $VALUES = (new Rotation[] {
                VERTICAL_FLIP_AND_90_COUNTER_CLOCKWISE, NO_FLIP_90_CLOCKWISE, NO_FLIP_90_COUNTER_CLOCKWISE, VERTICAL_FLIP_AND_90_CLOCKWISE
            });
        }

        private Rotation(String s, int i)
        {
            super(s, i);
        }
    }


    private ArrayList mCommand;
    private ArrayList mFilters;
    private final FFmpegInvoke mInvoker;
    private HashMap mMetaData;
    private final int mNumCores = getNumCores();

    public Processor(String s)
    {
        mInvoker = new FFmpegInvoke(s);
    }

    private static int getNumCores()
    {
        int i;
        try
        {
            i = (new File("/sys/devices/system/cpu/")).listFiles(new _cls1CpuFilter()).length;
        }
        catch (Exception exception)
        {
            return 1;
        }
        return i;
    }

    public Processor addInputPath(String s)
    {
        mCommand.add("-i");
        mCommand.add(s);
        return this;
    }

    public Processor addMetaData(String s, String s1)
    {
        mMetaData.put(s, s1);
        return this;
    }

    public Processor enableOverwrite()
    {
        mCommand.add("-y");
        return this;
    }

    public Processor enableShortest()
    {
        mCommand.add("-shortest");
        return this;
    }

    public Processor filterCrop(int i, int j)
    {
        mFilters.add((new StringBuilder()).append("crop=").append(i).append(":").append(j).toString());
        return this;
    }

    public Processor filterRotation(Rotation rotation)
    {
        mFilters.add((new StringBuilder()).append("transpose=").append(rotation.ordinal()).toString());
        return this;
    }

    public Processor newCommand()
    {
        mMetaData = new HashMap();
        mFilters = new ArrayList();
        mCommand = new ArrayList();
        mCommand.add("ffmpeg");
        return this;
    }

    public transient int process(String as[])
    {
        return mInvoker.run(as);
    }

    public int processToOutput(String s)
    {
        if (mFilters.size() > 0)
        {
            mCommand.add("-vf");
            Object obj = new StringBuilder();
            for (Iterator iterator1 = mFilters.iterator(); iterator1.hasNext(); ((StringBuilder) (obj)).append(","))
            {
                ((StringBuilder) (obj)).append((String)iterator1.next());
            }

            obj = ((StringBuilder) (obj)).toString();
            mCommand.add(((String) (obj)).substring(0, ((String) (obj)).length() - 1));
        }
        String s1;
        for (Iterator iterator = mMetaData.keySet().iterator(); iterator.hasNext(); mCommand.add((new StringBuilder()).append(s1).append("=").append("\"").append((String)mMetaData.get(s1)).append("\"").toString()))
        {
            s1 = (String)iterator.next();
            mCommand.add("-metadata");
        }

        if (mNumCores <= 1);
        mCommand.add(s);
        for (s = mCommand.iterator(); s.hasNext(); SLog.d("Add arg '{}'", (String)s.next())) { }
        return process((String[])mCommand.toArray(new String[mCommand.size()]));
    }

    public Processor setAudioCopy()
    {
        mCommand.add("-acodec");
        mCommand.add("copy");
        return this;
    }

    public Processor setBsfA(String s)
    {
        mCommand.add("-bsf:a");
        mCommand.add(s);
        return this;
    }

    public Processor setBsfV(String s)
    {
        mCommand.add("-bsf:v");
        mCommand.add(s);
        return this;
    }

    public Processor setCopy()
    {
        mCommand.add("-c");
        mCommand.add("copy");
        return this;
    }

    public Processor setFormat(String s)
    {
        mCommand.add("-f");
        mCommand.add(s);
        return this;
    }

    public Processor setFrames(long l, int i)
    {
        mCommand.add("-vframes");
        mCommand.add(String.valueOf((int)(((double)l / 1000D) * (double)i)));
        return this;
    }

    public Processor setMap(String s)
    {
        mCommand.add("-map");
        mCommand.add(s);
        return this;
    }

    public Processor setMetaData(HashMap hashmap)
    {
        mMetaData = hashmap;
        return this;
    }

    public Processor setPreset(Preset preset)
    {
        mCommand.add("-preset");
        mCommand.add(preset.name().toLowerCase(Locale.US));
        return this;
    }

    public Processor setShortest()
    {
        mCommand.add("-shortest");
        return this;
    }

    public Processor setSize(int i, int j)
    {
        mCommand.add("-s");
        mCommand.add((new StringBuilder()).append("").append(i).append("x").append(j).toString());
        return this;
    }

    public Processor setStart(long l)
    {
        mCommand.add("-ss");
        mCommand.add(String.valueOf((double)l / 1000D));
        return this;
    }

    public Processor setTotalDuration(long l)
    {
        mCommand.add("-t");
        mCommand.add(String.valueOf((double)l / 1000D));
        return this;
    }

    public Processor setVFrames(int i)
    {
        mCommand.add("-vframes");
        mCommand.add(String.valueOf(i));
        return this;
    }

    public Processor setVideoCopy()
    {
        mCommand.add("-vcodec");
        mCommand.add("copy");
        return this;
    }

    public Processor useMjpeg()
    {
        mCommand.add("-vcodec");
        mCommand.add("mjpeg");
        return this;
    }

    public Processor useX264()
    {
        mCommand.add("-vcodec");
        mCommand.add("libx264");
        return this;
    }

    static 
    {
        System.loadLibrary("ffmpeginvoke");
    }
}
