// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.event;


public abstract class ApplicationStateDelegate
{
    public static final class InHomeState extends Enum
    {

        private static final InHomeState $VALUES[];
        public static final InHomeState IN_HOME;
        public static final InHomeState OUT_OF_HOME;
        public static final InHomeState UNKNOWN;

        public static InHomeState valueOf(String s)
        {
            return (InHomeState)Enum.valueOf(com/comcast/playerplatform/analytics/java/event/ApplicationStateDelegate$InHomeState, s);
        }

        public static InHomeState[] values()
        {
            return (InHomeState[])$VALUES.clone();
        }

        static 
        {
            OUT_OF_HOME = new InHomeState("OUT_OF_HOME", 0);
            IN_HOME = new InHomeState("IN_HOME", 1);
            UNKNOWN = new InHomeState("UNKNOWN", 2);
            $VALUES = (new InHomeState[] {
                OUT_OF_HOME, IN_HOME, UNKNOWN
            });
        }

        private InHomeState(String s, int i)
        {
            super(s, i);
        }
    }


    public ApplicationStateDelegate()
    {
    }

    public InHomeState getInHomeState()
    {
        return InHomeState.UNKNOWN;
    }
}
