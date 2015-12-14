// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.PriorityHandlerThread;
import com.google.android.exoplayer.util.TraceUtil;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.android.exoplayer:
//            StandaloneMediaClock, ExoPlaybackException, TrackRenderer, MediaClock

final class ExoPlayerImplInternal
    implements android.os.Handler.Callback
{

    private static final int IDLE_INTERVAL_MS = 1000;
    private static final int MSG_CUSTOM = 9;
    private static final int MSG_DO_SOME_WORK = 7;
    public static final int MSG_ERROR = 4;
    private static final int MSG_INCREMENTAL_PREPARE = 2;
    private static final int MSG_PREPARE = 1;
    public static final int MSG_PREPARED = 1;
    private static final int MSG_RELEASE = 5;
    private static final int MSG_SEEK_TO = 6;
    private static final int MSG_SET_PLAY_WHEN_READY = 3;
    public static final int MSG_SET_PLAY_WHEN_READY_ACK = 3;
    private static final int MSG_SET_RENDERER_ENABLED = 8;
    public static final int MSG_STATE_CHANGED = 2;
    private static final int MSG_STOP = 4;
    private static final int PREPARE_INTERVAL_MS = 10;
    private static final int RENDERING_INTERVAL_MS = 10;
    private static final String TAG = "ExoPlayerImplInternal";
    private volatile long bufferedPositionUs;
    private int customMessagesProcessed;
    private int customMessagesSent;
    private volatile long durationUs;
    private long elapsedRealtimeUs;
    private final List enabledRenderers;
    private final Handler eventHandler;
    private final Handler handler;
    private final HandlerThread internalPlaybackThread = new PriorityHandlerThread((new StringBuilder()).append(getClass().getSimpleName()).append(":Handler").toString(), -16);
    private final long minBufferUs;
    private final long minRebufferUs;
    private boolean playWhenReady;
    private volatile long positionUs;
    private boolean rebuffering;
    private boolean released;
    private final boolean rendererEnabledFlags[];
    private MediaClock rendererMediaClock;
    private TrackRenderer rendererMediaClockSource;
    private TrackRenderer renderers[];
    private final StandaloneMediaClock standaloneMediaClock = new StandaloneMediaClock();
    private int state;

    public ExoPlayerImplInternal(Handler handler1, boolean flag, boolean aflag[], int i, int j)
    {
        customMessagesSent = 0;
        customMessagesProcessed = 0;
        eventHandler = handler1;
        playWhenReady = flag;
        rendererEnabledFlags = new boolean[aflag.length];
        minBufferUs = (long)i * 1000L;
        minRebufferUs = (long)j * 1000L;
        for (i = 0; i < aflag.length; i++)
        {
            rendererEnabledFlags[i] = aflag[i];
        }

        state = 1;
        durationUs = -1L;
        bufferedPositionUs = -1L;
        enabledRenderers = new ArrayList(aflag.length);
        internalPlaybackThread.start();
        handler = new Handler(internalPlaybackThread.getLooper(), this);
    }

    private void doSomeWork()
        throws ExoPlaybackException
    {
        TrackRenderer trackrenderer;
        boolean flag;
        boolean flag1;
        long l;
        long l1;
        long l2;
        TraceUtil.beginSection("doSomeWork");
        l2 = SystemClock.elapsedRealtime();
        int i;
        boolean flag2;
        if (durationUs != -1L)
        {
            l = durationUs;
        } else
        {
            l = 0x7fffffffffffffffL;
        }
        flag = true;
        flag1 = true;
        updatePositionUs();
        i = 0;
        l1 = l;
        long l3;
        long l4;
        if (i >= enabledRenderers.size())
        {
            break MISSING_BLOCK_LABEL_251;
        }
        trackrenderer = (TrackRenderer)enabledRenderers.get(i);
        trackrenderer.doSomeWork(positionUs, elapsedRealtimeUs);
        if (flag && trackrenderer.isEnded())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag2 = rendererReadyOrEnded(trackrenderer);
        if (!flag2)
        {
            trackrenderer.maybeThrowError();
        }
        if (flag1 && flag2)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (l1 == -1L)
        {
            l = l1;
        } else
        {
label0:
            {
                l3 = trackrenderer.getDurationUs();
                l4 = trackrenderer.getBufferedPositionUs();
                if (l4 != -1L)
                {
                    break label0;
                }
                l = -1L;
            }
        }
_L2:
        i++;
        l1 = l;
        break MISSING_BLOCK_LABEL_42;
        for (l = l1; l4 == -3L; l = l1)
        {
            continue; /* Loop/switch isn't completed */
        }

        if (l3 != -1L && l3 != -2L)
        {
            l = l1;
            if (l4 >= l3)
            {
                continue; /* Loop/switch isn't completed */
            }
        }
        l = Math.min(l1, l4);
        if (true) goto _L2; else goto _L1
_L1:
        bufferedPositionUs = l1;
        if (flag && (durationUs == -1L || durationUs <= positionUs))
        {
            setState(5);
            stopRenderers();
        } else
        if (state == 3 && flag1)
        {
            setState(4);
            if (playWhenReady)
            {
                startRenderers();
            }
        } else
        if (state == 4 && !flag1)
        {
            rebuffering = playWhenReady;
            setState(3);
            stopRenderers();
        }
        handler.removeMessages(7);
        if (playWhenReady && state == 4 || state == 3)
        {
            scheduleNextOperation(7, l2, 10L);
        } else
        if (!enabledRenderers.isEmpty())
        {
            scheduleNextOperation(7, l2, 1000L);
        }
        TraceUtil.endSection();
        return;
    }

    private void ensureStopped(TrackRenderer trackrenderer)
        throws ExoPlaybackException
    {
        if (trackrenderer.getState() == 3)
        {
            trackrenderer.stop();
        }
    }

    private void incrementalPrepareInternal()
        throws ExoPlaybackException
    {
        long l = SystemClock.elapsedRealtime();
        boolean flag1 = true;
        for (int i = 0; i < renderers.length;)
        {
            TrackRenderer trackrenderer = renderers[i];
            boolean flag3 = flag1;
            if (trackrenderer.getState() == 0)
            {
                flag3 = flag1;
                if (trackrenderer.prepare(positionUs) == 0)
                {
                    trackrenderer.maybeThrowError();
                    flag3 = false;
                }
            }
            i++;
            flag1 = flag3;
        }

        if (!flag1)
        {
            scheduleNextOperation(2, l, 10L);
            return;
        }
        long l2 = 0L;
        boolean flag5 = true;
        boolean flag4 = true;
        boolean aflag[] = new boolean[renderers.length];
        int k = 0;
        do
        {
            if (k < renderers.length)
            {
                TrackRenderer trackrenderer1 = renderers[k];
                boolean flag;
                boolean flag2;
                long l3;
                boolean flag6;
                if (trackrenderer1.getState() == 1)
                {
                    flag6 = true;
                } else
                {
                    flag6 = false;
                }
                aflag[k] = flag6;
                flag2 = flag5;
                flag = flag4;
                l3 = l2;
                if (aflag[k])
                {
                    long l1;
                    if (l2 == -1L)
                    {
                        l1 = l2;
                    } else
                    {
                        l3 = trackrenderer1.getDurationUs();
                        if (l3 == -1L)
                        {
                            l1 = -1L;
                        } else
                        {
                            l1 = l2;
                            if (l3 != -2L)
                            {
                                l1 = Math.max(l2, l3);
                            }
                        }
                    }
                    flag2 = flag5;
                    flag = flag4;
                    l3 = l1;
                    if (rendererEnabledFlags[k])
                    {
                        trackrenderer1.enable(positionUs, false);
                        enabledRenderers.add(trackrenderer1);
                        if (flag5 && trackrenderer1.isEnded())
                        {
                            flag2 = true;
                        } else
                        {
                            flag2 = false;
                        }
                        if (flag4 && rendererReadyOrEnded(trackrenderer1))
                        {
                            flag = true;
                            l3 = l1;
                        } else
                        {
                            flag = false;
                            l3 = l1;
                        }
                    }
                }
                k++;
                flag5 = flag2;
                flag4 = flag;
                l2 = l3;
                continue;
            }
            durationUs = l2;
            if (flag5 && (l2 == -1L || l2 <= positionUs))
            {
                state = 5;
            } else
            {
                int j;
                if (flag4)
                {
                    j = 4;
                } else
                {
                    j = 3;
                }
                state = j;
            }
            eventHandler.obtainMessage(1, state, 0, aflag).sendToTarget();
            if (playWhenReady && state == 4)
            {
                startRenderers();
            }
            handler.sendEmptyMessage(7);
            return;
        } while (true);
    }

    private void prepareInternal(TrackRenderer atrackrenderer[])
        throws ExoPlaybackException
    {
        resetInternal();
        renderers = atrackrenderer;
        int i = 0;
        while (i < atrackrenderer.length) 
        {
            MediaClock mediaclock = atrackrenderer[i].getMediaClock();
            if (mediaclock != null)
            {
                boolean flag;
                if (rendererMediaClock == null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                Assertions.checkState(flag);
                rendererMediaClock = mediaclock;
                rendererMediaClockSource = atrackrenderer[i];
            }
            i++;
        }
        setState(2);
        incrementalPrepareInternal();
    }

    private void release(TrackRenderer trackrenderer)
    {
        try
        {
            trackrenderer.release();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (TrackRenderer trackrenderer)
        {
            Log.e("ExoPlayerImplInternal", "Release failed.", trackrenderer);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (TrackRenderer trackrenderer)
        {
            Log.e("ExoPlayerImplInternal", "Release failed.", trackrenderer);
        }
    }

    private void releaseInternal()
    {
        resetInternal();
        setState(1);
        this;
        JVM INSTR monitorenter ;
        released = true;
        notifyAll();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private boolean rendererReadyOrEnded(TrackRenderer trackrenderer)
    {
        boolean flag1 = false;
        if (!trackrenderer.isEnded())
        {
            if (!trackrenderer.isReady())
            {
                return false;
            }
            if (state != 4)
            {
label0:
                {
                    long l1 = trackrenderer.getDurationUs();
                    long l2 = trackrenderer.getBufferedPositionUs();
                    long l;
                    boolean flag;
                    if (rebuffering)
                    {
                        l = minRebufferUs;
                    } else
                    {
                        l = minBufferUs;
                    }
                    if (l > 0L && l2 != -1L && l2 != -3L && l2 < positionUs + l)
                    {
                        flag = flag1;
                        if (l1 == -1L)
                        {
                            break label0;
                        }
                        flag = flag1;
                        if (l1 == -2L)
                        {
                            break label0;
                        }
                        flag = flag1;
                        if (l2 < l1)
                        {
                            break label0;
                        }
                    }
                    flag = true;
                }
                return flag;
            }
        }
        return true;
    }

    private void resetInternal()
    {
        handler.removeMessages(7);
        handler.removeMessages(2);
        rebuffering = false;
        standaloneMediaClock.stop();
        if (renderers == null)
        {
            return;
        }
        for (int i = 0; i < renderers.length; i++)
        {
            TrackRenderer trackrenderer = renderers[i];
            stopAndDisable(trackrenderer);
            release(trackrenderer);
        }

        renderers = null;
        rendererMediaClock = null;
        rendererMediaClockSource = null;
        enabledRenderers.clear();
    }

    private void scheduleNextOperation(int i, long l, long l1)
    {
        l = (l + l1) - SystemClock.elapsedRealtime();
        if (l <= 0L)
        {
            handler.sendEmptyMessage(i);
            return;
        } else
        {
            handler.sendEmptyMessageDelayed(i, l);
            return;
        }
    }

    private void seekToInternal(long l)
        throws ExoPlaybackException
    {
        rebuffering = false;
        positionUs = 1000L * l;
        standaloneMediaClock.stop();
        standaloneMediaClock.setPositionUs(positionUs);
        if (state == 1 || state == 2)
        {
            return;
        }
        for (int i = 0; i < enabledRenderers.size(); i++)
        {
            TrackRenderer trackrenderer = (TrackRenderer)enabledRenderers.get(i);
            ensureStopped(trackrenderer);
            trackrenderer.seekTo(positionUs);
        }

        setState(3);
        handler.sendEmptyMessage(7);
    }

    private void sendMessageInternal(int i, Object obj)
        throws ExoPlaybackException
    {
        obj = (Pair)obj;
        ((ExoPlayer.ExoPlayerComponent)((Pair) (obj)).first).handleMessage(i, ((Pair) (obj)).second);
        this;
        JVM INSTR monitorenter ;
        customMessagesProcessed = customMessagesProcessed + 1;
        notifyAll();
        this;
        JVM INSTR monitorexit ;
        if (state != 1 && state != 2)
        {
            handler.sendEmptyMessage(7);
        }
        return;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        obj;
        this;
        JVM INSTR monitorenter ;
        customMessagesProcessed = customMessagesProcessed + 1;
        notifyAll();
        this;
        JVM INSTR monitorexit ;
        throw obj;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
    }

    private void setPlayWhenReadyInternal(boolean flag)
        throws ExoPlaybackException
    {
        rebuffering = false;
        playWhenReady = flag;
        if (flag) goto _L2; else goto _L1
_L1:
        stopRenderers();
        updatePositionUs();
_L5:
        eventHandler.obtainMessage(3).sendToTarget();
        return;
_L2:
        if (state != 4) goto _L4; else goto _L3
_L3:
        startRenderers();
        handler.sendEmptyMessage(7);
          goto _L5
        Exception exception;
        exception;
        eventHandler.obtainMessage(3).sendToTarget();
        throw exception;
_L4:
        if (state != 3) goto _L5; else goto _L6
_L6:
        handler.sendEmptyMessage(7);
          goto _L5
    }

    private void setRendererEnabledInternal(int i, boolean flag)
        throws ExoPlaybackException
    {
        boolean flag1 = true;
        if (rendererEnabledFlags[i] != flag)
        {
            rendererEnabledFlags[i] = flag;
            if (state != 1 && state != 2)
            {
                TrackRenderer trackrenderer = renderers[i];
                i = trackrenderer.getState();
                if (i == 1 || i == 2 || i == 3)
                {
                    if (flag)
                    {
                        if (playWhenReady && state == 4)
                        {
                            flag = flag1;
                        } else
                        {
                            flag = false;
                        }
                        trackrenderer.enable(positionUs, flag);
                        enabledRenderers.add(trackrenderer);
                        if (flag)
                        {
                            trackrenderer.start();
                        }
                        handler.sendEmptyMessage(7);
                        return;
                    }
                    if (trackrenderer == rendererMediaClockSource)
                    {
                        standaloneMediaClock.setPositionUs(rendererMediaClock.getPositionUs());
                    }
                    ensureStopped(trackrenderer);
                    enabledRenderers.remove(trackrenderer);
                    trackrenderer.disable();
                    return;
                }
            }
        }
    }

    private void setState(int i)
    {
        if (state != i)
        {
            state = i;
            eventHandler.obtainMessage(2, i, 0).sendToTarget();
        }
    }

    private void startRenderers()
        throws ExoPlaybackException
    {
        rebuffering = false;
        standaloneMediaClock.start();
        for (int i = 0; i < enabledRenderers.size(); i++)
        {
            ((TrackRenderer)enabledRenderers.get(i)).start();
        }

    }

    private void stopAndDisable(TrackRenderer trackrenderer)
    {
        try
        {
            ensureStopped(trackrenderer);
            if (trackrenderer.getState() == 2)
            {
                trackrenderer.disable();
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (TrackRenderer trackrenderer)
        {
            Log.e("ExoPlayerImplInternal", "Stop failed.", trackrenderer);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (TrackRenderer trackrenderer)
        {
            Log.e("ExoPlayerImplInternal", "Stop failed.", trackrenderer);
        }
    }

    private void stopInternal()
    {
        resetInternal();
        setState(1);
    }

    private void stopRenderers()
        throws ExoPlaybackException
    {
        standaloneMediaClock.stop();
        for (int i = 0; i < enabledRenderers.size(); i++)
        {
            ensureStopped((TrackRenderer)enabledRenderers.get(i));
        }

    }

    private void updatePositionUs()
    {
        if (rendererMediaClock != null && enabledRenderers.contains(rendererMediaClockSource) && !rendererMediaClockSource.isEnded())
        {
            positionUs = rendererMediaClock.getPositionUs();
            standaloneMediaClock.setPositionUs(positionUs);
        } else
        {
            positionUs = standaloneMediaClock.getPositionUs();
        }
        elapsedRealtimeUs = SystemClock.elapsedRealtime() * 1000L;
    }

    public void blockingSendMessage(ExoPlayer.ExoPlayerComponent exoplayercomponent, int i, Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        if (!released) goto _L2; else goto _L1
_L1:
        Log.w("ExoPlayerImplInternal", (new StringBuilder()).append("Sent message(").append(i).append(") after release. Message ignored.").toString());
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        int j;
        j = customMessagesSent;
        customMessagesSent = j + 1;
        handler.obtainMessage(9, i, 0, Pair.create(exoplayercomponent, obj)).sendToTarget();
_L5:
        i = customMessagesProcessed;
        if (i > j) goto _L4; else goto _L3
_L3:
        wait();
          goto _L5
        exoplayercomponent;
        Thread.currentThread().interrupt();
          goto _L5
        exoplayercomponent;
        throw exoplayercomponent;
    }

    public long getBufferedPosition()
    {
        if (bufferedPositionUs == -1L)
        {
            return -1L;
        } else
        {
            return bufferedPositionUs / 1000L;
        }
    }

    public long getCurrentPosition()
    {
        return positionUs / 1000L;
    }

    public long getDuration()
    {
        if (durationUs == -1L)
        {
            return -1L;
        } else
        {
            return durationUs / 1000L;
        }
    }

    public Looper getPlaybackLooper()
    {
        return internalPlaybackThread.getLooper();
    }

    public boolean handleMessage(Message message)
    {
        boolean flag;
        boolean flag1;
        flag1 = false;
        flag = false;
        message.what;
        JVM INSTR tableswitch 1 9: default 237
    //                   1 60
    //                   2 76
    //                   3 82
    //                   4 120
    //                   5 126
    //                   6 104
    //                   7 98
    //                   8 146
    //                   9 132;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L2:
        prepareInternal((TrackRenderer[])(TrackRenderer[])message.obj);
        return true;
_L3:
        int i;
        try
        {
            incrementalPrepareInternal();
        }
        // Misplaced declaration of an exception variable
        catch (Message message)
        {
            Log.e("ExoPlayerImplInternal", "Internal track renderer error.", message);
            eventHandler.obtainMessage(4, message).sendToTarget();
            stopInternal();
            return true;
        }
        // Misplaced declaration of an exception variable
        catch (Message message)
        {
            Log.e("ExoPlayerImplInternal", "Internal runtime error.", message);
            eventHandler.obtainMessage(4, new ExoPlaybackException(message, true)).sendToTarget();
            stopInternal();
            return true;
        }
        return true;
_L4:
        if (message.arg1 != 0)
        {
            flag = true;
        }
        setPlayWhenReadyInternal(flag);
        return true;
_L8:
        doSomeWork();
        return true;
_L7:
        seekToInternal(((Long)message.obj).longValue());
        return true;
_L5:
        stopInternal();
        return true;
_L6:
        releaseInternal();
        return true;
_L10:
        sendMessageInternal(message.arg1, message.obj);
        return true;
_L9:
        i = message.arg1;
        flag = flag1;
        if (message.arg2 != 0)
        {
            flag = true;
        }
        setRendererEnabledInternal(i, flag);
        return true;
_L1:
        return false;
    }

    public transient void prepare(TrackRenderer atrackrenderer[])
    {
        handler.obtainMessage(1, atrackrenderer).sendToTarget();
    }

    public void release()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = released;
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        handler.sendEmptyMessage(5);
_L3:
        flag = released;
        if (flag)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        wait();
          goto _L3
        Object obj;
        obj;
        Thread.currentThread().interrupt();
          goto _L3
        obj;
        throw obj;
        internalPlaybackThread.quit();
          goto _L1
    }

    public void seekTo(long l)
    {
        handler.obtainMessage(6, Long.valueOf(l)).sendToTarget();
    }

    public void sendMessage(ExoPlayer.ExoPlayerComponent exoplayercomponent, int i, Object obj)
    {
        customMessagesSent = customMessagesSent + 1;
        handler.obtainMessage(9, i, 0, Pair.create(exoplayercomponent, obj)).sendToTarget();
    }

    public void setPlayWhenReady(boolean flag)
    {
        Handler handler1 = handler;
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        handler1.obtainMessage(3, i, 0).sendToTarget();
    }

    public void setRendererEnabled(int i, boolean flag)
    {
        Handler handler1 = handler;
        int j;
        if (flag)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        handler1.obtainMessage(8, i, j).sendToTarget();
    }

    public void stop()
    {
        handler.sendEmptyMessage(4);
    }
}
