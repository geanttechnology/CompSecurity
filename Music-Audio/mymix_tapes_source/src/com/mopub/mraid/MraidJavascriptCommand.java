// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mraid;


// Referenced classes of package com.mopub.mraid:
//            PlacementType

public class MraidJavascriptCommand extends Enum
{

    private static final MraidJavascriptCommand $VALUES[];
    public static final MraidJavascriptCommand CLOSE;
    public static final MraidJavascriptCommand CREATE_CALENDAR_EVENT;
    public static final MraidJavascriptCommand EXPAND;
    public static final MraidJavascriptCommand OPEN;
    public static final MraidJavascriptCommand PLAY_VIDEO;
    public static final MraidJavascriptCommand RESIZE;
    public static final MraidJavascriptCommand SET_ORIENTATION_PROPERTIES;
    public static final MraidJavascriptCommand STORE_PICTURE;
    public static final MraidJavascriptCommand UNSPECIFIED;
    public static final MraidJavascriptCommand USE_CUSTOM_CLOSE;
    private final String mJavascriptString;

    private MraidJavascriptCommand(String s, int i, String s1)
    {
        super(s, i);
        mJavascriptString = s1;
    }


    static MraidJavascriptCommand fromJavascriptString(String s)
    {
        MraidJavascriptCommand amraidjavascriptcommand[] = values();
        int j = amraidjavascriptcommand.length;
        for (int i = 0; i < j; i++)
        {
            MraidJavascriptCommand mraidjavascriptcommand = amraidjavascriptcommand[i];
            if (mraidjavascriptcommand.mJavascriptString.equals(s))
            {
                return mraidjavascriptcommand;
            }
        }

        return UNSPECIFIED;
    }

    public static MraidJavascriptCommand valueOf(String s)
    {
        return (MraidJavascriptCommand)Enum.valueOf(com/mopub/mraid/MraidJavascriptCommand, s);
    }

    public static MraidJavascriptCommand[] values()
    {
        return (MraidJavascriptCommand[])$VALUES.clone();
    }

    boolean requiresClick(PlacementType placementtype)
    {
        return false;
    }

    String toJavascriptString()
    {
        return mJavascriptString;
    }

    static 
    {
        CLOSE = new MraidJavascriptCommand("CLOSE", 0, "close");
        EXPAND = new MraidJavascriptCommand("EXPAND", 1, "expand") {

            boolean requiresClick(PlacementType placementtype)
            {
                return placementtype == PlacementType.INLINE;
            }

        };
        USE_CUSTOM_CLOSE = new MraidJavascriptCommand("USE_CUSTOM_CLOSE", 2, "usecustomclose");
        OPEN = new MraidJavascriptCommand("OPEN", 3, "open") {

            boolean requiresClick(PlacementType placementtype)
            {
                return true;
            }

        };
        RESIZE = new MraidJavascriptCommand("RESIZE", 4, "resize") {

            boolean requiresClick(PlacementType placementtype)
            {
                return true;
            }

        };
        SET_ORIENTATION_PROPERTIES = new MraidJavascriptCommand("SET_ORIENTATION_PROPERTIES", 5, "setOrientationProperties");
        PLAY_VIDEO = new MraidJavascriptCommand("PLAY_VIDEO", 6, "playVideo") {

            boolean requiresClick(PlacementType placementtype)
            {
                return placementtype == PlacementType.INLINE;
            }

        };
        STORE_PICTURE = new MraidJavascriptCommand("STORE_PICTURE", 7, "storePicture") {

            boolean requiresClick(PlacementType placementtype)
            {
                return true;
            }

        };
        CREATE_CALENDAR_EVENT = new MraidJavascriptCommand("CREATE_CALENDAR_EVENT", 8, "createCalendarEvent") {

            boolean requiresClick(PlacementType placementtype)
            {
                return true;
            }

        };
        UNSPECIFIED = new MraidJavascriptCommand("UNSPECIFIED", 9, "");
        $VALUES = (new MraidJavascriptCommand[] {
            CLOSE, EXPAND, USE_CUSTOM_CLOSE, OPEN, RESIZE, SET_ORIENTATION_PROPERTIES, PLAY_VIDEO, STORE_PICTURE, CREATE_CALENDAR_EVENT, UNSPECIFIED
        });
    }
}
