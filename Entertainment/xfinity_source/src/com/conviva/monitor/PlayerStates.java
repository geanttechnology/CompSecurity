// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.conviva.monitor;

import java.util.HashMap;
import java.util.Map;

public class PlayerStates
{

    public static Map stateToInt = null;

    public static void init()
    {
        stateToInt = new HashMap();
        stateToInt.put("PLAYING", Integer.valueOf(3));
        stateToInt.put("STOPPED", Integer.valueOf(1));
        stateToInt.put("PAUSED", Integer.valueOf(12));
        stateToInt.put("BUFFERING", Integer.valueOf(6));
        stateToInt.put("NOTMONITORED", Integer.valueOf(98));
        stateToInt.put("UNKNOWN", Integer.valueOf(100));
    }

}
