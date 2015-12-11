// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.web.bridge.command;

import com.google.b.j;
import com.google.b.k;
import com.google.b.l;
import com.google.b.r;
import com.google.b.s;
import com.google.b.t;
import com.shazam.d.b;
import java.lang.reflect.Type;

public final class ShWebCommandType extends Enum
    implements b
{
    public static class Deserializer
        implements k
    {

        public ShWebCommandType deserialize(l l1, Type type, j j)
        {
            return ShWebCommandType.forString(l1.h().b());
        }

        public volatile Object deserialize(l l1, Type type, j j)
        {
            return deserialize(l1, type, j);
        }

        public Deserializer()
        {
        }
    }

    public static class Serializer
        implements t
    {

        public l serialize(ShWebCommandType shwebcommandtype, Type type, s s)
        {
            return new r(shwebcommandtype.jsonString);
        }

        public volatile l serialize(Object obj, Type type, s s)
        {
            return serialize((ShWebCommandType)obj, type, s);
        }

        public Serializer()
        {
        }
    }


    private static final ShWebCommandType $VALUES[];
    public static final ShWebCommandType ABOUT_BRIDGE;
    public static final ShWebCommandType APPLICATION_BACKGROUNDED;
    public static final ShWebCommandType BEACON;
    public static final ShWebCommandType CONTEXT;
    public static final ShWebCommandType IS_INTENT_SUPPORTED;
    public static final ShWebCommandType LOCATION;
    public static final ShWebCommandType NEW_WEB_VIEW;
    public static final ShWebCommandType PLAY_AUDIO;
    public static final ShWebCommandType SCROLL_TO;
    public static final ShWebCommandType SETUP_SOCIAL;
    public static final ShWebCommandType SHARE_SHEET;
    public static final ShWebCommandType SOCIAL_ACCESS_TOKEN;
    public static final ShWebCommandType SOCIAL_INVITE_FRIENDS;
    public static final ShWebCommandType START_INTENTS;
    public static final ShWebCommandType STOP_AUDIO;
    public static final ShWebCommandType TAB_SWITCHED;
    public static final ShWebCommandType TITLE;
    public static final ShWebCommandType TRACK_RESULT;
    public static final ShWebCommandType VIEW_APPEARED;
    private final String jsonString;

    private ShWebCommandType(String s, int i, String s1)
    {
        super(s, i);
        jsonString = s1;
    }

    public static ShWebCommandType forString(String s)
    {
        ShWebCommandType ashwebcommandtype[] = values();
        int j = ashwebcommandtype.length;
        for (int i = 0; i < j; i++)
        {
            ShWebCommandType shwebcommandtype = ashwebcommandtype[i];
            if (shwebcommandtype.jsonString.equals(s))
            {
                return shwebcommandtype;
            }
        }

        return null;
    }

    public static int getNumberOfPriorities()
    {
        return 3;
    }

    public static ShWebCommandType valueOf(String s)
    {
        return (ShWebCommandType)Enum.valueOf(com/shazam/android/web/bridge/command/ShWebCommandType, s);
    }

    public static ShWebCommandType[] values()
    {
        return (ShWebCommandType[])$VALUES.clone();
    }

    public final String getJsonString()
    {
        return jsonString;
    }

    public final int getPriority()
    {
        if (this == APPLICATION_BACKGROUNDED)
        {
            return 0;
        }
        return this != TAB_SWITCHED && this != VIEW_APPEARED ? 2 : 1;
    }

    static 
    {
        ABOUT_BRIDGE = new ShWebCommandType("ABOUT_BRIDGE", 0, "aboutBridge");
        APPLICATION_BACKGROUNDED = new ShWebCommandType("APPLICATION_BACKGROUNDED", 1, "applicationBackgrounded");
        NEW_WEB_VIEW = new ShWebCommandType("NEW_WEB_VIEW", 2, "newWebView");
        PLAY_AUDIO = new ShWebCommandType("PLAY_AUDIO", 3, "playAudio");
        STOP_AUDIO = new ShWebCommandType("STOP_AUDIO", 4, "stopAudio");
        START_INTENTS = new ShWebCommandType("START_INTENTS", 5, "startIntents");
        IS_INTENT_SUPPORTED = new ShWebCommandType("IS_INTENT_SUPPORTED", 6, "isIntentSupported");
        SETUP_SOCIAL = new ShWebCommandType("SETUP_SOCIAL", 7, "setupSocial");
        SOCIAL_INVITE_FRIENDS = new ShWebCommandType("SOCIAL_INVITE_FRIENDS", 8, "socialInviteFriends");
        SOCIAL_ACCESS_TOKEN = new ShWebCommandType("SOCIAL_ACCESS_TOKEN", 9, "socialAccessToken");
        TAB_SWITCHED = new ShWebCommandType("TAB_SWITCHED", 10, "tabSwitched");
        TITLE = new ShWebCommandType("TITLE", 11, "title");
        TRACK_RESULT = new ShWebCommandType("TRACK_RESULT", 12, "trackResult");
        VIEW_APPEARED = new ShWebCommandType("VIEW_APPEARED", 13, "viewAppeared");
        SCROLL_TO = new ShWebCommandType("SCROLL_TO", 14, "scrollTo");
        BEACON = new ShWebCommandType("BEACON", 15, "sendBeacon");
        CONTEXT = new ShWebCommandType("CONTEXT", 16, "context");
        SHARE_SHEET = new ShWebCommandType("SHARE_SHEET", 17, "sharesheet");
        LOCATION = new ShWebCommandType("LOCATION", 18, "location");
        $VALUES = (new ShWebCommandType[] {
            ABOUT_BRIDGE, APPLICATION_BACKGROUNDED, NEW_WEB_VIEW, PLAY_AUDIO, STOP_AUDIO, START_INTENTS, IS_INTENT_SUPPORTED, SETUP_SOCIAL, SOCIAL_INVITE_FRIENDS, SOCIAL_ACCESS_TOKEN, 
            TAB_SWITCHED, TITLE, TRACK_RESULT, VIEW_APPEARED, SCROLL_TO, BEACON, CONTEXT, SHARE_SHEET, LOCATION
        });
    }

}
