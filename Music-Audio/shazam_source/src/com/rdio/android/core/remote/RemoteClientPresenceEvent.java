// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.remote;

import java.util.Map;

public class RemoteClientPresenceEvent
{
    public static final class Action extends Enum
    {

        private static final Action $VALUES[];
        public static final Action Join;
        public static final Action Part;

        public static Action valueOf(String s)
        {
            return (Action)Enum.valueOf(com/rdio/android/core/remote/RemoteClientPresenceEvent$Action, s);
        }

        public static Action[] values()
        {
            return (Action[])$VALUES.clone();
        }

        static 
        {
            Join = new Action("Join", 0);
            Part = new Action("Part", 1);
            $VALUES = (new Action[] {
                Join, Part
            });
        }

        private Action(String s, int i)
        {
            super(s, i);
        }
    }


    private final Action action;
    private final String clientId;
    private final Map connectedClients;

    public RemoteClientPresenceEvent(String s, Action action1, Map map)
    {
        clientId = s;
        action = action1;
        connectedClients = map;
    }

    public Action getAction()
    {
        return action;
    }

    public String getClientId()
    {
        return clientId;
    }

    public Map getConnectedClients()
    {
        return connectedClients;
    }
}
