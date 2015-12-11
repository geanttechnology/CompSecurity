// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.utils;


public class UplynkUtils
{

    public static String translateMovieRating(int i)
    {
        switch (i)
        {
        default:
            return "N/A";

        case 1: // '\001'
            return "G";

        case 2: // '\002'
            return "PG";

        case 3: // '\003'
            return "PG-13";

        case 4: // '\004'
            return "R";

        case 5: // '\005'
            return "NC-17";

        case 6: // '\006'
            return "X";

        case 7: // '\007'
            return "NR";
        }
    }

    public static String translateTVRating(int i, int j)
    {
        if (j != -1 && j == 4)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        switch (i)
        {
        default:
            return "N/A";

        case 1: // '\001'
            return "TV-Y";

        case 2: // '\002'
            if (j != 0)
            {
                return "TV-Y7-FV";
            } else
            {
                return "TV-Y7";
            }

        case 3: // '\003'
            return "TV-G";

        case 4: // '\004'
            return "TV-PG";

        case 5: // '\005'
            return "TV-14";

        case 6: // '\006'
            return "TV-MA";

        case 7: // '\007'
            return "NR";
        }
    }
}
