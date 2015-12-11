// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.media;

import java.util.Vector;

// Referenced classes of package com.disney.datg.videoplatforms.sdk.media:
//            CaptionCue

public class CaptionData
{
    public static final class CaptionEventType extends Enum
    {

        private static final CaptionEventType $VALUES[];
        public static final CaptionEventType CLEAR;
        public static final CaptionEventType LINEBREAK;
        public static final CaptionEventType TEXT;

        public static CaptionEventType valueOf(String s)
        {
            return (CaptionEventType)Enum.valueOf(com/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionEventType, s);
        }

        public static CaptionEventType[] values()
        {
            return (CaptionEventType[])$VALUES.clone();
        }

        static 
        {
            TEXT = new CaptionEventType("TEXT", 0);
            CLEAR = new CaptionEventType("CLEAR", 1);
            LINEBREAK = new CaptionEventType("LINEBREAK", 2);
            $VALUES = (new CaptionEventType[] {
                TEXT, CLEAR, LINEBREAK
            });
        }

        private CaptionEventType(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class CaptionMode extends Enum
    {

        private static final CaptionMode $VALUES[];
        public static final CaptionMode PAINT_ON;
        public static final CaptionMode POP_ON;
        public static final CaptionMode ROLL_UP;
        public static final CaptionMode TEXT;
        public static final CaptionMode UNKNOWN;

        public static CaptionMode valueOf(String s)
        {
            return (CaptionMode)Enum.valueOf(com/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode, s);
        }

        public static CaptionMode[] values()
        {
            return (CaptionMode[])$VALUES.clone();
        }

        static 
        {
            UNKNOWN = new CaptionMode("UNKNOWN", 0);
            POP_ON = new CaptionMode("POP_ON", 1);
            ROLL_UP = new CaptionMode("ROLL_UP", 2);
            PAINT_ON = new CaptionMode("PAINT_ON", 3);
            TEXT = new CaptionMode("TEXT", 4);
            $VALUES = (new CaptionMode[] {
                UNKNOWN, POP_ON, ROLL_UP, PAINT_ON, TEXT
            });
        }

        private CaptionMode(String s, int i)
        {
            super(s, i);
        }
    }


    private int channel;
    private Vector cues;
    private CaptionEventType eventType;
    private CaptionMode mode;

    public CaptionData()
    {
        cues = new Vector();
        channel = 0;
    }

    protected void addCue(CaptionCue captioncue)
    {
        cues.add(captioncue);
    }

    public String getWebVTT()
    {
        StringBuffer stringbuffer = new StringBuffer();
        for (int i = 0; i < cues.size(); i++)
        {
            CaptionCue captioncue = (CaptionCue)cues.get(i);
            if (captioncue == null)
            {
                continue;
            }
            if (i == 0)
            {
                stringbuffer.append(captioncue.getHeader());
            }
            stringbuffer.append(captioncue.getWebVTT());
        }

        return stringbuffer.toString();
    }

    protected void setEventType(com.uplynk.media.CaptionEvent.CaptionEventType captioneventtype)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$uplynk$media$CaptionEvent$CaptionEventType[];
            static final int $SwitchMap$com$uplynk$media$CaptionEvent$CaptionMode[];

            static 
            {
                $SwitchMap$com$uplynk$media$CaptionEvent$CaptionEventType = new int[com.uplynk.media.CaptionEvent.CaptionEventType.values().length];
                try
                {
                    $SwitchMap$com$uplynk$media$CaptionEvent$CaptionEventType[com.uplynk.media.CaptionEvent.CaptionEventType.LINEBREAK.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$uplynk$media$CaptionEvent$CaptionEventType[com.uplynk.media.CaptionEvent.CaptionEventType.TEXT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$uplynk$media$CaptionEvent$CaptionEventType[com.uplynk.media.CaptionEvent.CaptionEventType.CLEAR.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                $SwitchMap$com$uplynk$media$CaptionEvent$CaptionMode = new int[com.uplynk.media.CaptionEvent.CaptionMode.values().length];
                try
                {
                    $SwitchMap$com$uplynk$media$CaptionEvent$CaptionMode[com.uplynk.media.CaptionEvent.CaptionMode.UNKNOWN.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$uplynk$media$CaptionEvent$CaptionMode[com.uplynk.media.CaptionEvent.CaptionMode.POP_ON.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$uplynk$media$CaptionEvent$CaptionMode[com.uplynk.media.CaptionEvent.CaptionMode.ROLL_UP.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$uplynk$media$CaptionEvent$CaptionMode[com.uplynk.media.CaptionEvent.CaptionMode.PAINT_ON.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$uplynk$media$CaptionEvent$CaptionMode[com.uplynk.media.CaptionEvent.CaptionMode.TEXT.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.uplynk.media.CaptionEvent.CaptionEventType[captioneventtype.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            eventType = CaptionEventType.LINEBREAK;
            return;

        case 2: // '\002'
            eventType = CaptionEventType.TEXT;
            return;

        case 3: // '\003'
            eventType = CaptionEventType.CLEAR;
            break;
        }
    }

    protected void setMode(com.uplynk.media.CaptionEvent.CaptionMode captionmode)
    {
        switch (_cls1..SwitchMap.com.uplynk.media.CaptionEvent.CaptionMode[captionmode.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            mode = CaptionMode.UNKNOWN;
            return;

        case 2: // '\002'
            mode = CaptionMode.POP_ON;
            return;

        case 3: // '\003'
            mode = CaptionMode.ROLL_UP;
            return;

        case 4: // '\004'
            mode = CaptionMode.PAINT_ON;
            return;

        case 5: // '\005'
            mode = CaptionMode.TEXT;
            break;
        }
    }
}
