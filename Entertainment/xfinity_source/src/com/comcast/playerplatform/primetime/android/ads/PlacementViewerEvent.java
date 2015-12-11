// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.ads;


// Referenced classes of package com.comcast.playerplatform.primetime.android.ads:
//            PlacementEvent

public class PlacementViewerEvent extends PlacementEvent
{
    public static final class Type extends Enum
    {

        private static final Type $VALUES[];
        public static final Type FAST_FARWARD;
        public static final Type PAUSE;
        public static final Type PLAY;
        public static final Type REWIND;
        public static final Type STOP;

        public static Type valueOf(String s)
        {
            return (Type)Enum.valueOf(com/comcast/playerplatform/primetime/android/ads/PlacementViewerEvent$Type, s);
        }

        public static Type[] values()
        {
            return (Type[])$VALUES.clone();
        }

        static 
        {
            FAST_FARWARD = new Type("FAST_FARWARD", 0);
            PAUSE = new Type("PAUSE", 1);
            PLAY = new Type("PLAY", 2);
            REWIND = new Type("REWIND", 3);
            STOP = new Type("STOP", 4);
            $VALUES = (new Type[] {
                FAST_FARWARD, PAUSE, PLAY, REWIND, STOP
            });
        }

        private Type(String s, int i)
        {
            super(s, i);
        }
    }


    private String spotNPT;
    private Type type;

    public void getEventData(StringBuffer stringbuffer, String s)
    {
        stringbuffer.append(String.format("<ViewerEvent time=\"%s\" type=\"%s\" >", new Object[] {
            s, type
        }));
        stringbuffer.append(String.format("<SpotNPT scale=\"1.0\">%s</SpotNPT>", new Object[] {
            spotNPT
        }));
        stringbuffer.append("</ViewerEvent>");
    }

    public Boolean isEndAll()
    {
        return Boolean.valueOf(false);
    }
}
