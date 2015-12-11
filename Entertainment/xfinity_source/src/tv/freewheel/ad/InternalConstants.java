// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.ad;

import java.util.HashMap;

public final class InternalConstants
{

    public static final HashMap METR_MAP;

    static 
    {
        METR_MAP = new HashMap();
        METR_MAP.put("quartile", Integer.valueOf(7));
        METR_MAP.put("firstQuartile", Integer.valueOf(7));
        METR_MAP.put("thirdQuartile", Integer.valueOf(7));
        METR_MAP.put("midPoint", Integer.valueOf(6));
        METR_MAP.put("complete", Integer.valueOf(4));
        METR_MAP.put("_mute", Integer.valueOf(8));
        METR_MAP.put("_un-mute", Integer.valueOf(8));
        METR_MAP.put("_collapse", Integer.valueOf(16));
        METR_MAP.put("_expand", Integer.valueOf(16));
        METR_MAP.put("_pause", Integer.valueOf(32));
        METR_MAP.put("_resume", Integer.valueOf(32));
        METR_MAP.put("_rewind", Integer.valueOf(64));
        METR_MAP.put("_accept-invitation", Integer.valueOf(128));
        METR_MAP.put("_close", Integer.valueOf(256));
        METR_MAP.put("_minimize", Integer.valueOf(512));
        METR_MAP.put("defaultClick", Integer.valueOf(1024));
    }
}
