// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid;

import android.util.Pair;
import java.util.ArrayList;
import tv.freewheel.hybrid.utils.Logger;
import tv.freewheel.hybrid.utils.Scheduler;
import tv.freewheel.hybrid.utils.events.Event;
import tv.freewheel.hybrid.utils.events.EventDispatcher;

public class CuePointManager extends EventDispatcher
{

    public static String EVENT_CUE_POINT_REACHED = "event_cue_point_reached";
    private static double TIMER_UPDATE_INTERVAL = 0.5D;
    private ArrayList cuePoints;
    private final Logger logger = Logger.getLogger(this);
    private double timeElapsedSinceStart;
    private Scheduler timer;

    public CuePointManager()
    {
        cuePoints = new ArrayList();
        timer = new Scheduler();
    }

    public void addCuePointForName(String s, double d)
    {
        logger.debug((new StringBuilder()).append("Adding cuePoint ").append(s).append(" at ").append(d).toString());
        s = Pair.create(s, Double.valueOf(d));
        cuePoints.add(s);
    }

    public void reset()
    {
        logger.debug("reset");
        cuePoints.clear();
        stop();
        timeElapsedSinceStart = 0.0D;
    }

    public void setupTimer()
    {
        logger.debug("setupTimer");
        timer.setTask(new Runnable() {

            final CuePointManager this$0;

            public void run()
            {
                <no variable> = 
// JavaClassFileOutputException: get_constant: invalid tag

            
            {
                this$0 = CuePointManager.this;
                super();
            }
        });
        timer.start(TIMER_UPDATE_INTERVAL, true);
    }

    public void start()
    {
        logger.debug("start");
        timeElapsedSinceStart = 0.0D;
        setupTimer();
    }

    public void stop()
    {
        logger.debug("stop");
        timer.stop();
    }




/*
    static double access$018(CuePointManager cuepointmanager, double d)
    {
        d = cuepointmanager.timeElapsedSinceStart + d;
        cuepointmanager.timeElapsedSinceStart = d;
        return d;
    }

*/



}
