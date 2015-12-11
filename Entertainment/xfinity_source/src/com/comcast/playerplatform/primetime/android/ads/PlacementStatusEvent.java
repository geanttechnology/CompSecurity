// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.ads;


// Referenced classes of package com.comcast.playerplatform.primetime.android.ads:
//            PlacementEvent

public class PlacementStatusEvent extends PlacementEvent
{
    public static final class Type extends Enum
    {

        private static final Type $VALUES[];
        public static final Type END;
        public static final Type END_ALL;
        public static final Type FIRST_QUARTILE;
        public static final Type SECOND_QUARTILE;
        public static final Type START;
        public static final Type STATUS;
        public static final Type THIRD_QUARTILE;

        public static Type valueOf(String s)
        {
            return (Type)Enum.valueOf(com/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type, s);
        }

        public static Type[] values()
        {
            return (Type[])$VALUES.clone();
        }

        static 
        {
            START = new Type("START", 0);
            STATUS = new Type("STATUS", 1);
            FIRST_QUARTILE = new Type("FIRST_QUARTILE", 2);
            SECOND_QUARTILE = new Type("SECOND_QUARTILE", 3);
            THIRD_QUARTILE = new Type("THIRD_QUARTILE", 4);
            END = new Type("END", 5);
            END_ALL = new Type("END_ALL", 6);
            $VALUES = (new Type[] {
                START, STATUS, FIRST_QUARTILE, SECOND_QUARTILE, THIRD_QUARTILE, END, END_ALL
            });
        }

        private Type(String s, int i)
        {
            super(s, i);
        }
    }


    private String spotNPT;
    private Type type;

    public PlacementStatusEvent(String s, float f, String s1, String s2, String s3, String s4, String s5, 
            String s6, Type type1)
    {
        type = type1;
        if (f < 1.0F)
        {
            f = 0.0F;
        } else
        {
            f /= 1000F;
        }
        spotNPT = String.format("%.3f", new Object[] {
            Float.valueOf(f)
        });
        buildEvent(s, s1, s2, s3, s4, s5, s6);
    }

    private String getPSNTypeString(Type type1)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$comcast$playerplatform$primetime$android$ads$PlacementStatusEvent$Type[];

            static 
            {
                $SwitchMap$com$comcast$playerplatform$primetime$android$ads$PlacementStatusEvent$Type = new int[Type.values().length];
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$ads$PlacementStatusEvent$Type[Type.START.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$ads$PlacementStatusEvent$Type[Type.STATUS.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$ads$PlacementStatusEvent$Type[Type.END.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$ads$PlacementStatusEvent$Type[Type.END_ALL.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$ads$PlacementStatusEvent$Type[Type.FIRST_QUARTILE.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$ads$PlacementStatusEvent$Type[Type.SECOND_QUARTILE.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$ads$PlacementStatusEvent$Type[Type.THIRD_QUARTILE.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.comcast.playerplatform.primetime.android.ads.PlacementStatusEvent.Type[type1.ordinal()])
        {
        default:
            return "";

        case 1: // '\001'
            return "startPlacement";

        case 2: // '\002'
            return "status";

        case 3: // '\003'
            return "endPlacement";

        case 4: // '\004'
            return "endAll";

        case 5: // '\005'
            return "private:firstQuartile";

        case 6: // '\006'
            return "private:midpoint";

        case 7: // '\007'
            return "private:thirdQuartile";
        }
    }

    public void getEventData(StringBuffer stringbuffer, String s)
    {
        stringbuffer.append(String.format("<PlacementStatusEvent time=\"%s\" type=\"%s\" >", new Object[] {
            s, getPSNTypeString(type)
        }));
        if (type != Type.END_ALL)
        {
            stringbuffer.append(String.format("<SpotNPT scale=\"1.0\">%s</SpotNPT>", new Object[] {
                spotNPT
            }));
        }
        stringbuffer.append("</PlacementStatusEvent>");
    }

    public Boolean isEndAll()
    {
        boolean flag;
        if (type != null && type == Type.END_ALL)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return Boolean.valueOf(flag);
    }
}
