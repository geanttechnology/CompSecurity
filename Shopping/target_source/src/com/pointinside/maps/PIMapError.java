// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps;


// Referenced classes of package com.pointinside.maps:
//            PIMGLUtil

public class PIMapError extends Exception
{
    public static final class Kind extends Enum
    {

        private static final Kind $VALUES[];
        public static final Kind MAP_FEATURE;
        public static final Kind ROUTE;

        public static Kind valueOf(String s)
        {
            return (Kind)Enum.valueOf(com/pointinside/maps/PIMapError$Kind, s);
        }

        public static Kind[] values()
        {
            return (Kind[])$VALUES.clone();
        }

        static 
        {
            MAP_FEATURE = new Kind("MAP_FEATURE", 0);
            ROUTE = new Kind("ROUTE", 1);
            $VALUES = (new Kind[] {
                MAP_FEATURE, ROUTE
            });
        }

        private Kind(String s, int i)
        {
            super(s, i);
        }
    }


    private final Kind kind;

    PIMapError(String s, Kind kind1)
    {
        super(s);
        kind = kind1;
    }

    public static PIMapError generateError(Kind kind1, String s)
    {
        return new PIMapError(s, kind1);
    }

    public static PIMapError generateError(Kind kind1, String s, int i)
    {
        return new PIMapError((new StringBuilder()).append(s).append(PIMGLUtil.errorIntToString(i)).toString(), kind1);
    }

    public static PIMapError generateError(Kind kind1, String s, RuntimeException runtimeexception)
    {
        return new PIMapError((new StringBuilder()).append(s).append(runtimeexception.getMessage()).toString(), kind1);
    }

    public Kind getKind()
    {
        return kind;
    }
}
