// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.a;

import com.smule.android.console.n;
import com.smule.magicpiano.PianoCoreBridge;

public class c
    implements n
{

    public c()
    {
    }

    public String a()
    {
        return "game";
    }

    public String a(String as[])
    {
        if (as != null && as.length >= 3)
        {
            if (as[1].compareToIgnoreCase("inches") == 0)
            {
                if (as[2].compareToIgnoreCase("off") == 0)
                {
                    PianoCoreBridge.setInchesPerBeat(-1F);
                    return "inches per beat override turned OFF.";
                } else
                {
                    PianoCoreBridge.setInchesPerBeat(Float.valueOf(as[2]).floatValue());
                    return (new StringBuilder()).append("inches per beat set to ").append(as[2]).toString();
                }
            }
            if (as[1].compareToIgnoreCase("wav") == 0)
            {
                if (as[2].compareToIgnoreCase("off") == 0)
                {
                    PianoCoreBridge.setDecodeToWav(false);
                    return "decode m4a on-the-fly";
                }
                if (as[2].compareToIgnoreCase("on") == 0)
                {
                    PianoCoreBridge.setDecodeToWav(true);
                    return "use wav files";
                }
            } else
            if (as[1].compareToIgnoreCase("fps") == 0)
            {
                if (as[2].compareToIgnoreCase("off") == 0)
                {
                    PianoCoreBridge.setDebugMode(false);
                    return "FPS counter off.";
                }
                if (as[2].compareToIgnoreCase("on") == 0)
                {
                    PianoCoreBridge.setDebugMode(true);
                    return "FPS counter on.";
                }
            } else
            if (as[1].compareToIgnoreCase("spacing") == 0)
            {
                if (as[2].compareToIgnoreCase("off") == 0)
                {
                    PianoCoreBridge.setPixelsPerBeatValues(-1F, -1F);
                    return "pixel spacing set to DEFAULT";
                }
                if (as.length >= 4)
                {
                    PianoCoreBridge.setPixelsPerBeatValues(Float.valueOf(as[2]).floatValue(), Float.valueOf(as[3]).floatValue());
                    return (new StringBuilder()).append("pixel spacing base: ").append(as[2]).append(" coefficient: ").append(as[3]).toString();
                }
            } else
            {
                if (as[1].compareToIgnoreCase("ffsize") == 0)
                {
                    if (as[2].compareToIgnoreCase("off") == 0)
                    {
                        PianoCoreBridge.setFireflyScale(-1F);
                        return "firefly scale set to DEFAULT";
                    } else
                    {
                        PianoCoreBridge.setFireflyScale(Float.valueOf(as[2]).floatValue());
                        return (new StringBuilder()).append("firefly scale set to: ").append(as[2]).toString();
                    }
                }
                if (as[1].compareToIgnoreCase("speed") == 0)
                {
                    if (as[2].compareToIgnoreCase("off") == 0)
                    {
                        PianoCoreBridge.setOverrideSpeed(-1F);
                        return "speed override off";
                    } else
                    {
                        PianoCoreBridge.setOverrideSpeed(Float.valueOf(as[2]).floatValue());
                        return (new StringBuilder()).append("speed override set to: ").append(as[2]).toString();
                    }
                }
                if (as[1].compareToIgnoreCase("slowing") == 0)
                {
                    if (as[2].compareToIgnoreCase("off") == 0)
                    {
                        PianoCoreBridge.setSlowingOffset(0.0F);
                        PianoCoreBridge.setSlowingFactor(0.5F);
                        return "firefly slowing set to DEFAULT";
                    }
                    if (as[2].compareToIgnoreCase("offset") == 0)
                    {
                        PianoCoreBridge.setSlowingOffset(Float.valueOf(as[3]).floatValue());
                        return (new StringBuilder()).append("slowing offset set to: ").append(as[3]).toString();
                    }
                    if (as[2].compareToIgnoreCase("factor") == 0)
                    {
                        float f = Float.valueOf(as[3]).floatValue();
                        if (f <= 0.0F)
                        {
                            return "slowing factor must be greater than 0.  You're messing with forces you don't understand.";
                        } else
                        {
                            PianoCoreBridge.setSlowingFactor(f);
                            return (new StringBuilder()).append("slowing factor set to: ").append(as[3]).toString();
                        }
                    }
                }
            }
        }
        return "No dice.  See http://jira.smule.com/confluence/display/CE/Android+Console+Debugger for help";
    }
}
