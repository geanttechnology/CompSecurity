// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.events;

import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.comcast.playerplatform.primetime.android.events:
//            PlayerEventManager, AbstractPlayerPlatformVideoEventListener

class val.hasCC
    implements Runnable
{

    final PlayerEventManager this$0;
    final List val$availableAudioLanguages;
    final List val$availableClosedCaptionTracks;
    final long val$duration;
    final boolean val$hasCC;
    final long val$height;
    final String val$mediaType;
    final double val$openingLatency;
    final List val$playbackSpeeds;
    final String val$type;
    final long val$width;

    public void run()
    {
        List list = listeners;
        list;
        JVM INSTR monitorenter ;
        for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((AbstractPlayerPlatformVideoEventListener)iterator.next()).mediaOpened(val$type, val$mediaType, val$playbackSpeeds, val$availableAudioLanguages, val$availableClosedCaptionTracks, val$width, val$height, val$duration, val$openingLatency, val$hasCC)) { }
        break MISSING_BLOCK_LABEL_92;
        Exception exception;
        exception;
        list;
        JVM INSTR monitorexit ;
        throw exception;
        list;
        JVM INSTR monitorexit ;
    }

    VideoEventListener()
    {
        this$0 = final_playereventmanager;
        val$type = s;
        val$mediaType = s1;
        val$playbackSpeeds = list;
        val$availableAudioLanguages = list1;
        val$availableClosedCaptionTracks = list2;
        val$width = l;
        val$height = l1;
        val$duration = l2;
        val$openingLatency = d;
        val$hasCC = Z.this;
        super();
    }
}
