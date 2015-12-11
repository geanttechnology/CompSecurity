// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.magicpiano;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.location.Location;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.Toast;
import com.crittercism.app.Crittercism;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smule.android.c.aa;
import com.smule.android.c.f;
import com.smule.android.f.e;
import com.smule.android.f.n;
import com.smule.android.network.a.u;
import com.smule.android.network.a.v;
import com.smule.android.network.core.NetworkResponseCallback;
import com.smule.android.network.core.b;
import com.smule.android.network.managers.UserManager;
import com.smule.android.network.managers.ak;
import com.smule.android.network.managers.ap;
import com.smule.android.network.models.ResourceV2;
import com.smule.android.network.models.SongV2;
import com.smule.pianoandroid.data.model.Performance;
import com.smule.pianoandroid.magicpiano.GoodJobActivity;
import com.smule.pianoandroid.magicpiano.MagicActivity;
import com.smule.pianoandroid.magicpiano.MagicApplication;
import com.smule.pianoandroid.magicpiano.ProductListFragment;
import com.smule.pianoandroid.magicpiano.a.g;
import com.smule.pianoandroid.magicpiano.a.h;
import com.smule.pianoandroid.magicpiano.a.k;
import com.smule.pianoandroid.magicpiano.av;
import com.smule.pianoandroid.magicpiano.c.a;
import com.smule.pianoandroid.synths.SoundPoolSynth;
import com.smule.pianoandroid.utils.o;
import com.smule.pianoandroid.utils.q;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package com.smule.magicpiano:
//            b, Tutorial, MagicPerformanceStats, c, 
//            d, e

public class PianoCoreBridge
{

    public static final int DIFFICULTY_EASY = 1;
    public static final int DIFFICULTY_HARD = 3;
    public static final int DIFFICULTY_NORMAL = 2;
    public static final int DIFFICULTY_SINGLE_TOUCH = 0;
    public static final int MP_TOUCH_BEGAN = 0;
    public static final int MP_TOUCH_CANCELLED = 3;
    public static final int MP_TOUCH_ENDED = 2;
    public static final int MP_TOUCH_MOVED = 1;
    public static final int RESUME_DELAY = 1000;
    private static final String TAG = com/smule/magicpiano/PianoCoreBridge.getName();
    public static final int TUTORIAL_PLAY_DELAY = 3500;
    public static com.smule.magicpiano.e onTempoChangedCallback = null;
    public static boolean sChallenge = false;
    private static final Map sDefaultFeedback;
    private static int sDifficulty;
    public static com.smule.magicpiano.b sEnterFreeplayCallback = null;
    public static String sFilePath;
    public static boolean sJoin = false;
    public static Performance sLastPerformance = null;
    private static Context sPerformanceContext;
    private static boolean sPerformanceEnded = false;
    public static c sPerformancePausedCallback = null;
    public static boolean sPerforming;
    public static d sPlaybackEndedCallback = null;
    public static boolean sPreviewing;
    public static SongV2 sSong;

    public PianoCoreBridge()
    {
    }

    public static native void cycleKeyboardState();

    public static void displayTutorialFeedback(String s)
    {
        ((MagicActivity)sPerformanceContext).b(s);
    }

    public static void displayTutorialMessage(String s)
    {
        int i;
        if (TextUtils.isEmpty(s))
        {
            i = 0;
        } else
        {
            i = sPerformanceContext.getResources().getIdentifier(s, "string", sPerformanceContext.getPackageName());
        }
        ((MagicActivity)sPerformanceContext).f(i);
    }

    public static void displayTutorialSubtitle(String s)
    {
        int i;
        if (TextUtils.isEmpty(s))
        {
            i = 0;
        } else
        {
            i = sPerformanceContext.getResources().getIdentifier(s, "string", sPerformanceContext.getPackageName());
        }
        ((MagicActivity)sPerformanceContext).e(i);
    }

    public static void displayTutorialTitle(String s)
    {
        int i;
        if (TextUtils.isEmpty(s))
        {
            i = 0;
        } else
        {
            i = sPerformanceContext.getResources().getIdentifier(s, "string", sPerformanceContext.getPackageName());
        }
        ((MagicActivity)sPerformanceContext).d(i);
    }

    private static void enterFreeplay(int i)
    {
        if (sEnterFreeplayCallback != null)
        {
            sEnterFreeplayCallback.a(i);
        }
    }

    public static int getDifficulty()
    {
        return sDifficulty;
    }

    public static f getEnsembleAnalyticsType()
    {
        if (isJoin())
        {
            return f.e;
        } else
        {
            return f.a;
        }
    }

    public static String getEnsembleType()
    {
        if (isJoin())
        {
            return "MIX";
        } else
        {
            return "SOLO";
        }
    }

    public static native int getFileLastAccessedTime(String s);

    public static native MagicPerformanceStats getPerformanceStats();

    private static String getPositiveFeedback(int i, int j, String s)
    {
        Context context = MagicApplication.getContext();
        if ("v1".equals(s))
        {
            if (j % 100 == 0 && j > 0)
            {
                return context.getString(0x7f0c01c2);
            }
            if (j % 20 == 0 && j > 0)
            {
                return context.getString(0x7f0c01cf);
            }
            if (j % 10 == 0 && j > 0)
            {
                return context.getString(0x7f0c0131);
            }
            if (j == 5)
            {
                return context.getString(0x7f0c01a8);
            } else
            {
                return "";
            }
        }
        if (j <= 10)
        {
            return context.getString(0x7f0c01a8);
        }
        if (j <= 20)
        {
            return context.getString(0x7f0c0131);
        }
        if (j <= 50)
        {
            return context.getString(0x7f0c01cf);
        }
        if (j > 50)
        {
            return context.getString(0x7f0c01c2);
        } else
        {
            return "";
        }
    }

    public static SongV2 getSong()
    {
        return sSong;
    }

    public static native void handleTouch(float f1, float f2, int i, int j);

    public static void initGfx(Context context, int i, int j)
    {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((WindowManager)context.getSystemService("window")).getDefaultDisplay().getMetrics(displaymetrics);
        float f1 = displaymetrics.density * 160F;
        float f3 = displaymetrics.xdpi;
        float f2 = displaymetrics.ydpi;
        float f4 = Math.abs(f3 / f1 - 1.0F);
        float f5 = Math.abs(f2 / f1 - 1.0F);
        if ((double)f4 > 0.050000000000000003D || (double)f5 > 0.050000000000000003D)
        {
            f2 = f1;
        } else
        {
            f1 = f3;
        }
        initGfxNative(i, j, f1, f2, 160F);
    }

    public static native void initGfxNative(int i, int j, float f1, float f2, float f3);

    public static void initResources(Context context)
    {
        int i = 0;
        String as[] = new String[28];
        as[0] = "btn_pause.png";
        as[1] = "black-key";
        as[2] = "white-key";
        as[3] = "sol-1";
        as[4] = "ring.bw";
        as[5] = "firefly.bw";
        as[6] = "freeplay.bw";
        as[7] = "touch.bw";
        as[8] = "slide_container.bw";
        as[9] = "slide_trail_left.bw";
        as[10] = "slide_trail_right.bw";
        as[11] = "fonts/Helvetica-Bold_32.png";
        as[12] = "fonts/Helvetica-Bold_32.dat";
        as[13] = "fonts/Helvetica-Bold_64.png";
        as[14] = "fonts/Helvetica-Bold_64.dat";
        as[15] = "DecorationFragment.glsl";
        as[16] = "DecorationVertex.glsl";
        as[17] = "EdgeGlowFragment.glsl";
        as[18] = "EdgeGlowVertex.glsl";
        as[19] = "GlobeFragment.glsl";
        as[20] = "GlobeVertex.glsl";
        as[21] = "singGlobe_front.png";
        as[22] = "singGlobe_back.png";
        as[23] = "singGlobe_left.png";
        as[24] = "singGlobe_right.png";
        as[25] = "singGlobe_top.png";
        as[26] = "singGlobe_bottom.png";
        as[27] = "beam_flare.png";
        File file = context.getFilesDir();
        int j = as.length;
        do
        {
label0:
            {
                if (i < j)
                {
                    String s = as[i];
                    File file1 = new File(file, s);
                    if (n.a(context, s, file1))
                    {
                        break label0;
                    }
                    aa.b(TAG, (new StringBuilder()).append("failed to extract asset: ").append(file1.getName()).toString());
                    Crittercism.a(new Exception((new StringBuilder()).append("Failed to extract asset: ").append(file1.getName()).toString()));
                }
                setStringResources("Preview", "drag | pinch", "Miss", "Good", "Perfect!!", "      ", "", "", "x", "Too Slow", "Too Fast");
                setApplicationDir(n.a(context));
                setDebugMode(MagicApplication.isDebug().booleanValue());
                float f1;
                if (av.h(context))
                {
                    f1 = 1.0F;
                } else
                {
                    f1 = 0.0F;
                }
                SoundPoolSynth.setClickVolume(f1);
                initializeNativeResources();
                return;
            }
            i++;
        } while (true);
    }

    public static native void initSoundPoolBridge(SoundPoolSynth soundpoolsynth);

    public static native void initializeNativeResources();

    public static boolean isJoin()
    {
        return sJoin;
    }

    public static native void leaveFreeplay();

    public static void leavePerformance()
    {
        sPerforming = false;
        if (sPerformanceContext != null)
        {
            ((FragmentActivity)sPerformanceContext).finish();
        }
        uninitNative();
    }

    public static Tutorial.TutorialEvent[] loadTutorial(String s)
    {
        int i = sPerformanceContext.getResources().getIdentifier(s, "raw", sPerformanceContext.getPackageName());
        Object obj = (Tutorial)e.a(e.a().readTree(sPerformanceContext.getResources().openRawResource(i)).get("tutorial"), com/smule/magicpiano/Tutorial);
        s = ((String) (obj));
_L2:
        aa.b(TAG, (new StringBuilder()).append("Tutorial ").append(s).toString());
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_227;
        }
        obj = new ArrayList(((Tutorial) (s)).mEvents.length);
        s = ((Tutorial) (s)).mEvents;
        int l = s.length;
        for (int j = 0; j < l; j++)
        {
            Object obj1 = s[j];
            if (!TextUtils.isEmpty(((Tutorial.TutorialEvent) (obj1)).mEventType))
            {
                ((List) (obj)).add(obj1);
            }
        }

        break; /* Loop/switch isn't completed */
        obj;
        aa.b(TAG, (new StringBuilder()).append("Failed to parse tutorial file ").append(s).toString(), ((Throwable) (obj)));
        s = null;
        if (true) goto _L2; else goto _L1
_L1:
        s = new Tutorial.TutorialEvent[((List) (obj)).size()];
        aa.b(TAG, (new StringBuilder()).append("Tutorial events N ").append(s.length).toString());
        return (Tutorial.TutorialEvent[])((List) (obj)).toArray(s);
        return null;
    }

    public static void logCrittercismException(int i)
    {
        if (sPerformanceContext == null)
        {
            break MISSING_BLOCK_LABEL_23;
        }
        ((Activity)sPerformanceContext).runOnUiThread(new Runnable(i) {

            final int a;

            public void run()
            {
                Crittercism.a(new Exception((new StringBuilder()).append("jni exception, couldn't load midi: ").append(PianoCoreBridge.sFilePath).append(" error code ").append(a).toString()));
            }

            
            {
                a = i;
                super();
            }
        });
        return;
        Exception exception;
        exception;
        aa.b(TAG, "error handling jni crittercism exception");
        return;
    }

    public static void maybeReportSongPlayToServer(MagicPerformanceStats magicperformancestats)
    {
        Object obj;
        if (sPerformanceContext != null)
        {
            if ((obj = ((MagicActivity)sPerformanceContext).d) != null)
            {
                boolean flag;
                if (magicperformancestats.streamedChords() == magicperformancestats.totalStreamedChords())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    ak ak1;
                    String s;
                    u u1;
                    NetworkResponseCallback networkresponsecallback;
                    if (ap.a().b())
                    {
                        magicperformancestats = v.a;
                    } else
                    {
                        magicperformancestats = v.c;
                    }
                    ak1 = ak.a();
                    s = ((SongV2) (obj)).songId;
                    u1 = u.b;
                    networkresponsecallback = new NetworkResponseCallback() {

                        public void handleResponse(com.smule.android.network.core.o o1)
                        {
                            if (o1.a())
                            {
                                f f1;
                                String s1;
                                if (!TextUtils.isEmpty(ProductListFragment.a))
                                {
                                    o1 = ProductListFragment.a;
                                } else
                                {
                                    o1 = "n/a";
                                }
                                s1 = PianoCoreBridge.getSong().songId;
                                if (PianoCoreBridge.sJoin)
                                {
                                    f1 = f.e;
                                } else
                                {
                                    f1 = f.a;
                                }
                                q.c(s1, o1, f1);
                            }
                        }

                        public volatile void handleResponse(Object obj1)
                        {
                            handleResponse((com.smule.android.network.core.o)obj1);
                        }

                    };
                    if (sJoin)
                    {
                        obj = ((SongV2) (obj)).performanceKey;
                    } else
                    {
                        obj = null;
                    }
                    ak1.a(s, null, null, Integer.valueOf(0), magicperformancestats, u1, networkresponsecallback, ((String) (obj)));
                    return;
                }
            }
        }
    }

    public static void performanceEndedWithStats(MagicPerformanceStats magicperformancestats)
    {
        String s;
        if (sPerformanceEnded)
        {
            return;
        }
        aa.c(TAG, "performanceEndedWithStats");
        sPerformanceEnded = true;
        if (a.a().f() > 1)
        {
            o.a();
        }
        if (sChallenge)
        {
            o.b();
        }
        sLastPerformance = new Performance();
        sLastPerformance.date = new Date();
        sLastPerformance.broadcast = false;
        sLastPerformance.score = magicperformancestats.score();
        sLastPerformance.totalPointsPossible = magicperformancestats.totalPointsPossible();
        sLastPerformance.longestStreak = magicperformancestats.longestStreak;
        Object obj = com.smule.android.f.f.a(MagicApplication.getContext());
        if (obj != null)
        {
            sLastPerformance.latitude = (float)((Location) (obj)).getLatitude();
            sLastPerformance.longitude = (float)((Location) (obj)).getLongitude();
        }
        Context context = MagicApplication.getContext();
        obj = new Intent(context, com/smule/pianoandroid/magicpiano/GoodJobActivity);
        ((Intent) (obj)).putExtra("stats", magicperformancestats);
        ((Intent) (obj)).putExtra("score", magicperformancestats.score());
        ((Intent) (obj)).putExtra("streak", magicperformancestats.longestStreak);
        ((Intent) (obj)).putExtra("latitude", sLastPerformance.latitude);
        ((Intent) (obj)).putExtra("longitude", sLastPerformance.longitude);
        int i;
        boolean flag;
        if (sPerforming)
        {
            i = 0;
        } else
        {
            i = -1;
        }
        ((Intent) (obj)).putExtra("SONG_MODE", i);
        ((Intent) (obj)).putExtra("daily_challenge", sChallenge);
        sPerforming = false;
        s = sSong.songId;
        ((Intent) (obj)).putExtra("SONG_UID_EXTRA", s);
        flag = context.getSharedPreferences("magic_piano_prefs", 0).getBoolean("GameMode", true);
        if (sChallenge || flag)
        {
            g g1 = g.a();
            k k2 = k.values()[magicperformancestats.difficulty];
            g1.a(h.a(1, k2), h.a(2, k2), h.a(3, k2));
            if (sChallenge)
            {
                com.smule.android.network.managers.e.a().a(magicperformancestats.score(), com.smule.android.network.managers.e.a().f());
                if (!UserManager.n().i())
                {
                    if (!com.smule.android.network.managers.e.a().f().isEnded())
                    {
                        b.a(new Runnable() {

                            public void run()
                            {
                                com.smule.android.network.managers.e.a().c(com.smule.android.network.managers.e.a().f());
                            }

                        });
                    } else
                    {
                        Toast.makeText(context, sPerformanceContext.getString(0x7f0c027b), 1).show();
                    }
                }
            } else
            {
                if (flag)
                {
                    g1.a(s, magicperformancestats, new Runnable(s) {

                        final String a;

                        public void run()
                        {
                            ak.j(a);
                        }

            
            {
                a = s;
                super();
            }
                    });
                    com.smule.pianoandroid.magicpiano.a.e.a("played_song", sSong, magicperformancestats);
                }
                if (a.a().a)
                {
                    q.k(sSong.songId);
                    a.a().a = false;
                }
                a.a().g();
                maybeReportSongPlayToServer(magicperformancestats);
            }
        }
        if (a.a().c()) goto _L2; else goto _L1
_L1:
        a.a().a(true);
        q.x();
_L4:
        (new Timer()).schedule(new TimerTask(((Intent) (obj))) {

            final Intent a;

            public void run()
            {
                if (PianoCoreBridge.sChallenge)
                {
                    if (PianoCoreBridge.sPerformanceContext != null)
                    {
                        PianoCoreBridge.sPerformanceContext.startActivity(a);
                        ((Activity)PianoCoreBridge.sPerformanceContext).finish();
                    }
                } else
                if (PianoCoreBridge.sPerformanceContext != null)
                {
                    ((Activity)PianoCoreBridge.sPerformanceContext).startActivityForResult(a, 2);
                    return;
                }
            }

            
            {
                a = intent;
                super();
            }
        }, 2000L);
        return;
_L2:
        if (!sChallenge)
        {
            k k1 = k.values()[getDifficulty()];
            if (isJoin())
            {
                magicperformancestats = f.e;
            } else
            {
                magicperformancestats = f.a;
            }
            q.b(null, k1, s, magicperformancestats);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static void performancePaused()
    {
        if (sPerformancePausedCallback != null)
        {
            sPerformancePausedCallback.c();
        }
    }

    public static native void playPerformanceFromFile(String s);

    public static void previewEnded()
    {
        aa.c(TAG, "previewEnded");
        sPerforming = false;
        (new Timer()).schedule(new TimerTask() {

            public void run()
            {
                PianoCoreBridge.leavePerformance();
            }

        }, 2000L);
    }

    public static native void reloadTextures();

    public static native void render(int i, int j);

    public static native void resize(int i, int j);

    private static native void restartPerformance();

    public static void restartPerformance(Context context)
    {
        if (sFilePath == null) goto _L2; else goto _L1
_L1:
        restartPerformance();
        context = sFilePath;
        boolean flag1 = sPreviewing;
        boolean flag;
        if (!sPreviewing)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        startPerformance(context, flag1, flag);
_L4:
        if (!sPreviewing)
        {
            sPerforming = true;
        }
        return;
_L2:
        if (sSong != null)
        {
            restartPerformance();
            startPerformanceWithSong(context, sSong, sPreviewing);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static native void setApplicationDir(String s);

    private static native void setChallenge(boolean flag);

    public static void setContext(Context context)
    {
        sPerformanceContext = context;
    }

    public static void setDailyChallenge(boolean flag)
    {
        sChallenge = flag;
        setChallenge(sChallenge);
    }

    public static native void setDebugMode(boolean flag);

    public static native void setDecodeToWav(boolean flag);

    public static void setDifficulty(int i)
    {
        sDifficulty = i;
        setPerformanceDifficulty(i);
    }

    public static native boolean setFileLastAccessedTime(String s, int i);

    public static native void setFireflyScale(float f1);

    public static native void setInchesPerBeat(float f1);

    private static native void setJamsSpacing(float f1);

    public static void setJoin(Boolean boolean1, Boolean boolean2)
    {
        sJoin = boolean1.booleanValue();
        setJoinNative(sJoin, boolean2.booleanValue());
    }

    public static native void setJoinAudioFile(String s, boolean flag);

    public static native void setJoinNative(boolean flag, boolean flag1);

    public static native void setLatencyCompensation(float f1);

    public static native void setOverrideSpeed(float f1);

    public static void setPaused(boolean flag)
    {
        setPausedNative(flag);
    }

    public static native void setPausedNative(boolean flag);

    public static native void setPerformanceDifficulty(int i);

    public static native void setPixelsPerBeatValues(float f1, float f2);

    public static native void setScoreMode(boolean flag, boolean flag1);

    public static native void setSlowingFactor(float f1);

    public static native void setSlowingOffset(float f1);

    public static void setSong(SongV2 songv2)
    {
        sSong = songv2;
    }

    public static native void setStringResources(String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, 
            String s8, String s9, String s10);

    public static native void setTouchInteraction(boolean flag);

    public static native void setVoxVolume(float f1);

    public static void songPlaybackEnded()
    {
        if (sPlaybackEndedCallback != null)
        {
            sPlaybackEndedCallback.a();
        }
    }

    public static void startAudioSync(Context context)
    {
        sPerformanceContext = context;
        context = (new StringBuilder()).append(n.a(sPerformanceContext)).append(File.separator).append("sync_loop.wav").toString();
        setJoin(Boolean.valueOf(true), Boolean.valueOf(false));
        setJoinAudioFile(context, true);
        setVoxVolume(0.7F);
        setTouchInteraction(false);
        startAudioSyncNative();
    }

    private static native void startAudioSyncNative();

    public static native void startFreeplay();

    protected static void startPerformance(String s, boolean flag, boolean flag1)
    {
        sPerformanceEnded = false;
        setJamsSpacing(com.smule.pianoandroid.utils.n.b(sSong));
        startPerformanceNative(s, flag, flag1);
    }

    public static void startPerformanceFromFile(String s, boolean flag)
    {
        boolean flag1 = true;
        sFilePath = s;
        if (sFilePath == null || sFilePath.isEmpty())
        {
            Crittercism.a(new Exception((new StringBuilder()).append("no midi file for song: ").append(sSong.title).toString()));
        }
        sPreviewing = flag;
        sPerforming = true;
        if (flag)
        {
            flag1 = false;
        }
        startPerformance(s, flag, Boolean.valueOf(flag1).booleanValue());
    }

    private static native void startPerformanceNative(String s, boolean flag, boolean flag1);

    public static native void startPerformancePlayback();

    public static void startPerformanceWithSong(Context context, SongV2 songv2, boolean flag)
    {
        sPreviewing = flag;
        sSong = songv2;
        sPerformanceContext = context;
        String s = context.getCacheDir().getAbsolutePath();
        context = null;
        songv2 = songv2.resources.iterator();
        do
        {
            if (!songv2.hasNext())
            {
                break;
            }
            ResourceV2 resourcev2 = (ResourceV2)songv2.next();
            if (resourcev2.role.equals("main"))
            {
                context = s.concat(resourcev2.uid);
            }
        } while (true);
        if (context == null)
        {
            aa.b(TAG, "Couldn't get filepath to play");
            return;
        }
        boolean flag1;
        if (!flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        startPerformance(context, flag, flag1);
        sPerforming = true;
    }

    public static native void stopPerformancePlayback();

    public static native void syncComplete();

    public static void tempoChanged(int i)
    {
        if (onTempoChangedCallback != null)
        {
            onTempoChangedCallback.a(i);
        }
    }

    public static native void togglePianoVisuals(boolean flag);

    public static void tutorialComplete()
    {
        ((MagicActivity)sPerformanceContext).f();
    }

    public static native void uninitNative();

    public static native void updateAudio();

    public static void updateFeedbackText(int i, int j)
    {
        Object obj;
        String s;
        Object obj1;
        obj = MagicApplication.getContext();
        obj1 = com.smule.android.network.managers.a.a().a("piandroid.tutorial", "feedback", sDefaultFeedback);
        s = (String)((Map) (obj1)).get("negative");
        obj1 = (String)((Map) (obj1)).get("positive");
        i;
        JVM INSTR tableswitch 0 13: default 120
    //                   0 133
    //                   1 164
    //                   2 202
    //                   3 265
    //                   4 303
    //                   5 334
    //                   6 365
    //                   7 396
    //                   8 233
    //                   9 416
    //                   10 421
    //                   11 432
    //                   12 443
    //                   13 454;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15
_L1:
        obj = null;
_L18:
        if (i < 10) goto _L17; else goto _L16
_L16:
        displayTutorialFeedback(((String) (obj)));
_L21:
        return;
_L2:
        if ("miss".equals(s))
        {
            obj = ((Context) (obj)).getString(0x7f0c018b);
        } else
        {
            obj = ((Context) (obj)).getString(0x7f0c0292);
        }
          goto _L18
_L3:
        if ("miss".equals(s))
        {
            if (isJoin())
            {
                obj = ((Context) (obj)).getString(0x7f0c0292);
            } else
            {
                obj = "";
            }
        } else
        {
            obj = "";
        }
          goto _L18
_L4:
        if ("perfect".equals(obj1))
        {
            obj = ((Context) (obj)).getString(0x7f0c01cf);
        } else
        {
            obj = getPositiveFeedback(i, j, ((String) (obj1)));
        }
          goto _L18
_L10:
        if ("perfect".equals(obj1))
        {
            obj = ((Context) (obj)).getString(0x7f0c0129);
        } else
        {
            obj = getPositiveFeedback(i, j, ((String) (obj1)));
        }
          goto _L18
_L5:
        if ("miss".equals(s))
        {
            if (isJoin())
            {
                obj = ((Context) (obj)).getString(0x7f0c0293);
            } else
            {
                obj = "";
            }
        } else
        {
            obj = "";
        }
          goto _L18
_L6:
        if ("miss".equals(s))
        {
            obj = ((Context) (obj)).getString(0x7f0c018b);
        } else
        {
            obj = ((Context) (obj)).getString(0x7f0c0293);
        }
          goto _L18
_L7:
        if ("miss".equals(s))
        {
            obj = ((Context) (obj)).getString(0x7f0c018b);
        } else
        {
            obj = ((Context) (obj)).getString(0x7f0c0291);
        }
          goto _L18
_L8:
        if ("miss".equals(s))
        {
            obj = ((Context) (obj)).getString(0x7f0c018b);
        } else
        {
            obj = ((Context) (obj)).getString(0x7f0c0290);
        }
          goto _L18
_L9:
        if (!"miss".equals(s)) goto _L1; else goto _L19
_L19:
        obj = ((Context) (obj)).getString(0x7f0c018b);
          goto _L18
_L11:
        obj = null;
          goto _L18
_L12:
        obj = ((Context) (obj)).getString(0x7f0c02a9);
          goto _L18
_L13:
        obj = ((Context) (obj)).getString(0x7f0c02aa);
          goto _L18
_L14:
        obj = ((Context) (obj)).getString(0x7f0c02a0);
          goto _L18
_L15:
        obj = ((Context) (obj)).getString(0x7f0c02ab);
          goto _L18
_L17:
        if (!(sPerformanceContext instanceof MagicActivity) || TextUtils.isEmpty(((CharSequence) (obj)))) goto _L21; else goto _L20
_L20:
        ((MagicActivity)sPerformanceContext).a(((String) (obj)));
        return;
          goto _L18
    }

    public static void updateProgressBar(float f1)
    {
        if (sPerformanceContext instanceof MagicActivity)
        {
            ((MagicActivity)sPerformanceContext).b(Math.round(10000F * f1));
        }
    }

    public static native void writePerformanceMidi(String s);

    static 
    {
        sDefaultFeedback = new HashMap();
        sDefaultFeedback.put("positive", "perfect");
        sDefaultFeedback.put("negative", "miss");
        System.loadLibrary("magic_audio");
        System.loadLibrary("magic_gfx");
        System.loadLibrary("magic_core");
        System.loadLibrary("magic_globe");
    }

}
