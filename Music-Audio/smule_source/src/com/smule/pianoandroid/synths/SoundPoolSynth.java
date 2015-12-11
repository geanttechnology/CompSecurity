// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.synths;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.SoundPool;
import android.os.ParcelFileDescriptor;
import com.crittercism.app.Crittercism;
import com.smule.android.c.aa;
import com.smule.android.network.managers.UserManager;
import com.smule.pianoandroid.magicpiano.MagicApplication;
import com.smule.pianoandroid.utils.n;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class SoundPoolSynth
{

    private static String CLICK_NAME = "click";
    private static final String TAG = com/smule/pianoandroid/synths/SoundPoolSynth.getName();
    private static final String degrees[] = {
        "a", "a", "a", "c", "c", "d", "d", "d", "f", "f", 
        "g", "g"
    };
    private static float mClickVolume = 1.0F;
    private static boolean sShowToast = true;
    public static float volumeScale = 0.5F;
    private Queue activeStreams;
    private final float half_step = (float)Math.pow(2D, 0.083333333333333329D);
    private final int lowNote = 36;
    private Context mContext;
    private Boolean mInitialized;
    private SoundPool mSoundPool;
    private HashMap mWavMap;
    private final int maxStreams = 16;
    private float pitchBendPerChannel[];
    private final int topNote = 108;
    private final float whole_step = (float)Math.pow(2D, 0.16666666666666666D);

    public SoundPoolSynth()
    {
        mInitialized = Boolean.valueOf(false);
        mWavMap = new HashMap();
    }

    private void clearSounds()
    {
        if (activeStreams != null)
        {
            Integer integer;
            for (Iterator iterator = activeStreams.iterator(); iterator.hasNext(); mSoundPool.stop(integer.intValue()))
            {
                integer = (Integer)iterator.next();
            }

            activeStreams.clear();
        }
        if (mSoundPool != null && mWavMap != null)
        {
            Integer integer1;
            for (Iterator iterator1 = mWavMap.values().iterator(); iterator1.hasNext(); mSoundPool.unload(integer1.intValue()))
            {
                integer1 = (Integer)iterator1.next();
            }

        }
    }

    private void freeSoundPool()
    {
        synchronized (mInitialized)
        {
            setInitialized(Boolean.valueOf(false));
            clearSounds();
            releaseSoundPool();
        }
        return;
        exception;
        boolean1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private Boolean getInitialized()
    {
        return mInitialized;
    }

    private void initSoundPool()
    {
        Boolean boolean1 = mInitialized;
        boolean1;
        JVM INSTR monitorenter ;
        if (mSoundPool != null)
        {
            break MISSING_BLOCK_LABEL_62;
        }
        aa.a(TAG, "mSoundPool started initializing");
        mSoundPool = new SoundPool(16, 3, 0);
        loadWAVFiles();
        aa.a(TAG, "mSoundPool finished initializing");
_L2:
        setInitialized(Boolean.valueOf(true));
        return;
        aa.a(TAG, "mSoundPool already initialized");
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        boolean1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void leaveBreadcrumbForFile(File file)
    {
        String s = (new StringBuilder()).append("SampleID of 0 returned for ").append(file.getAbsolutePath()).append(".").toString();
        if (file.exists()) goto _L2; else goto _L1
_L1:
        file = (new StringBuilder()).append(s).append("file does not exist. ").toString();
_L4:
        Crittercism.a(file);
        return;
_L2:
        s = (new StringBuilder()).append(s).append("file exists. ").toString();
        Object obj = ParcelFileDescriptor.open(file, 0x10000000);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_156;
        }
        ((ParcelFileDescriptor) (obj)).close();
        file = s;
        continue; /* Loop/switch isn't completed */
        Object obj1;
        obj1;
        s = (new StringBuilder()).append(s).append(" FileNotFoundException was thrown.  This probably means no read permission since the file exists.").toString();
        aa.b(TAG, (new StringBuilder()).append(" FileNotFoundExcpetion opening: ").append(file.getAbsolutePath()).toString(), ((Throwable) (obj1)));
        file = s;
        continue; /* Loop/switch isn't completed */
        obj1 = (new StringBuilder()).append(s).append("  File descriptor returned by open() was null.").toString();
        file = ((File) (obj1));
        continue; /* Loop/switch isn't completed */
        obj1;
        aa.b(TAG, (new StringBuilder()).append("error loading ").append(file.getAbsolutePath()).toString(), ((Throwable) (obj1)));
        file = (new StringBuilder()).append(s).append("  An IOException was thrown.").toString();
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void loadWAVFiles()
    {
        File file;
        File file1;
        int i;
        int i1;
        mWavMap = new HashMap();
        file = mContext.getFilesDir();
        int j = 2;
        i = 0;
        do
        {
            if (j > 7)
            {
                break;
            }
            int l = 0;
            while (l < degrees.length) 
            {
                String s = (new StringBuilder()).append(degrees[l]).append(Integer.toString(j)).append("s_16").toString();
                int j1;
                if (mWavMap.containsKey(s))
                {
                    j1 = i;
                } else
                {
                    File file2 = new File(file, (new StringBuilder()).append(s).append(".wav").toString());
                    j1 = mSoundPool.load(file2.getAbsolutePath(), 0);
                    int k1 = j1;
                    if (j1 == 0)
                    {
                        k1 = j1;
                        if (n.a(mContext, s, file2))
                        {
                            k1 = mSoundPool.load(file2.getAbsolutePath(), 0);
                        }
                    }
                    if (k1 == 0)
                    {
                        j1 = i + 1;
                        leaveBreadcrumbForFile(file2);
                    } else
                    {
                        j1 = i;
                        if (mWavMap.get(s) == null)
                        {
                            mWavMap.put(s, Integer.valueOf(k1));
                            j1 = i;
                        }
                    }
                }
                l++;
                i = j1;
            }
            j++;
        } while (true);
        file1 = new File(file, (new StringBuilder()).append("c8s_16").append(".wav").toString());
        j = mSoundPool.load(file1.getAbsolutePath(), 0);
        i1 = j;
        if (j == 0)
        {
            i1 = j;
            if (n.a(mContext, "c8s_16", file1))
            {
                i1 = mSoundPool.load(file1.getAbsolutePath(), 0);
            }
        }
        if (i1 != 0) goto _L2; else goto _L1
_L1:
        int k;
        k = i + 1;
        leaveBreadcrumbForFile(file1);
_L4:
        file = new File(file, (new StringBuilder()).append(CLICK_NAME).append(".wav").toString());
        i1 = mSoundPool.load(file.getAbsolutePath(), 0);
        i = k;
        if (i1 == 0)
        {
            i = k + 1;
            leaveBreadcrumbForFile(file);
        }
        if (mWavMap.get(CLICK_NAME) == null)
        {
            mWavMap.put(CLICK_NAME, Integer.valueOf(i1));
        }
        if (i > 0)
        {
            reportSoundPoolError((new StringBuilder()).append("").append(i).append(" samples had a sampleID of 0").toString());
            MagicApplication.getInstance().showToast(MagicApplication.getContext().getString(0x7f0c00f3), 1);
        }
        return;
_L2:
        k = i;
        if (mWavMap.get("c8s_16") == null)
        {
            mWavMap.put("c8s_16", Integer.valueOf(i1));
            k = i;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private int needStep(int i)
    {
        int j;
        j = (i + 3) % 12;
        break MISSING_BLOCK_LABEL_7;
        if (i < 108 && i >= 36)
        {
            if (j > 1 && degrees[j] == degrees[j - 2])
            {
                return 2;
            }
            if (j > 0 && degrees[j] == degrees[j - 1])
            {
                return 1;
            }
        }
        return 0;
    }

    private void playSound(String s, float f, float f1)
    {
        if (s != null && mWavMap != null)
        {
            s = (Integer)mWavMap.get(s);
            if (s != null)
            {
                int i = mSoundPool.play(s.intValue(), f, f, 0, 0, f1);
                if (i != 0)
                {
                    int j;
                    for (; activeStreams.size() >= 16; mSoundPool.stop(j))
                    {
                        j = ((Integer)activeStreams.poll()).intValue();
                    }

                    activeStreams.offer(Integer.valueOf(i));
                }
            }
        }
    }

    public static void prepareResources(Context context)
    {
        File file = context.getFilesDir();
        File file1 = new File(file, (new StringBuilder()).append(CLICK_NAME).append(".wav").toString());
        if (!file1.exists() && !n.a(context, CLICK_NAME, file1))
        {
            showToastOnce();
        }
        file1 = new File(file, "sync_loop.wav");
        if (!file1.exists() && !n.a(context, "sync_loop", file1))
        {
            showToastOnce();
        }
        for (int i = 2; i <= 7; i++)
        {
            for (int j = 0; j < degrees.length; j++)
            {
                String s = (new StringBuilder()).append(degrees[j]).append(Integer.toString(i)).append("s_16").toString();
                File file2 = new File(file, (new StringBuilder()).append(s).append(".wav").toString());
                if (!file2.exists() && !n.a(context, s, file2))
                {
                    showToastOnce();
                }
            }

        }

        file = new File(file, (new StringBuilder()).append("c8s_16").append(".wav").toString());
        if (!file.exists() && !n.a(context, "c8s_16", file))
        {
            showToastOnce();
        }
    }

    private void releaseSoundPool()
    {
        if (mSoundPool != null)
        {
            mSoundPool.release();
            mSoundPool = null;
        }
        mWavMap = null;
    }

    private void reportSoundPoolError(String s)
    {
        SharedPreferences sharedpreferences = mContext.getSharedPreferences("startup_prefs", 0);
        long l = UserManager.n().c();
        int i = sharedpreferences.getInt("prev_version", -1);
        int j = android.os.Build.VERSION.SDK_INT;
        Crittercism.a((new StringBuilder()).append("Player ").append(l).append(" had an error in SoundPool: ").append(s).append(" Upgraded from app version: ").append(i).append(", OS version: ").append(j).toString());
        Crittercism.a(new RuntimeException("Error in SoundPool: Sample IDs are 0"));
        aa.b(TAG, "Error in SoundPool: Sample IDs are 0");
    }

    public static void setClickVolume(float f)
    {
        mClickVolume = f;
    }

    private void setInitialized(Boolean boolean1)
    {
        mInitialized = boolean1;
    }

    public static void setVolumeScaleForHeadphones(int i)
    {
        if (i == 1)
        {
            volumeScale = 0.2F;
            return;
        } else
        {
            volumeScale = 0.5F;
            return;
        }
    }

    private static void showToastOnce()
    {
        if (sShowToast)
        {
            MagicApplication.getInstance().showToast(MagicApplication.getContext().getString(0x7f0c00f3), 1);
            sShowToast = false;
        }
    }

    public void noteOff(int i, int j)
    {
    }

    public void noteOn(int i, int j, int k)
    {
label0:
        {
            synchronized (mInitialized)
            {
                if (getInitialized().booleanValue())
                {
                    break label0;
                }
                aa.a(TAG, "getInitialized() returned false, SoundPoolSynth.noteOn() returning early");
            }
            return;
        }
        if (i >= 0) goto _L2; else goto _L1
_L1:
        aa.e(TAG, (new StringBuilder()).append("Invalid channel ").append(i).append(". Setting to 0.").toString());
        int l = 0;
_L4:
        float f = 1.0F;
        float f2 = (volumeScale * (float)k) / 127F;
        i = j;
        break; /* Loop/switch isn't completed */
_L2:
        l = i;
        if (i >= pitchBendPerChannel.length)
        {
            aa.e(TAG, (new StringBuilder()).append("Invalid channel ").append(i).append(" setting to ").append(pitchBendPerChannel.length - 1).append(".").toString());
            l = pitchBendPerChannel.length - 1;
        }
        if (true) goto _L4; else goto _L3
_L9:
        String s = noteToWav(j);
        needStep(j);
        JVM INSTR tableswitch 1 2: default 311
    //                   1 263
    //                   2 272;
           goto _L5 _L6 _L7
_L5:
        float f1 = f;
        if (pitchBendPerChannel[l] != 0.0F)
        {
            f1 = (float)((double)f * Math.pow(2D, (double)pitchBendPerChannel[l] / 12D));
        }
        playSound(s, f2, f1);
        boolean1;
        JVM INSTR monitorexit ;
        return;
        exception;
        boolean1;
        JVM INSTR monitorexit ;
        throw exception;
_L6:
        f = half_step;
        continue; /* Loop/switch isn't completed */
_L7:
        f = whole_step;
        if (true) goto _L5; else goto _L3
_L3:
        do
        {
            j = i;
            if (i <= 108)
            {
                break;
            }
            i -= 12;
        } while (true);
        while (j < 36) 
        {
            j += 12;
        }
        if (true) goto _L9; else goto _L8
_L8:
    }

    public String noteToWav(int i)
    {
        if (i < 108) goto _L2; else goto _L1
_L1:
        int j = 107;
_L4:
        i = j / 12;
        return (new StringBuilder()).append(degrees[(j + 3) % 12]).append(Integer.toString(i - 1)).append("s_16").toString();
_L2:
        j = i;
        if (i <= 36)
        {
            j = 36;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onCreate(Context context)
    {
        mContext = context;
        pitchBendPerChannel = new float[128];
        activeStreams = new LinkedList();
        initSoundPool();
    }

    public void onPause()
    {
        this;
        JVM INSTR monitorenter ;
        freeSoundPool();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void onResume()
    {
        this;
        JVM INSTR monitorenter ;
        initSoundPool();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void onStop()
    {
        this;
        JVM INSTR monitorenter ;
        freeSoundPool();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void pitchBend(int i, float f)
    {
        if (i >= 0 && i < 128)
        {
            pitchBendPerChannel[i] = f;
        }
    }

    public void playClick()
    {
        if (mClickVolume > 0.0F)
        {
            playSound(CLICK_NAME, mClickVolume, 1.0F);
        }
    }

}
