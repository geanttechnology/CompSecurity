// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.sdk.internal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KeyParser
{

    private static Pattern albumPattern = Pattern.compile("a\\d+");
    private static Pattern playlistPattern = Pattern.compile("p\\d+");
    private static Pattern trackPattern = Pattern.compile("t\\d+");

    public KeyParser()
    {
    }

    public static boolean isAlbumKey(String s)
    {
        if (s == null)
        {
            return false;
        } else
        {
            return albumPattern.matcher(s).matches();
        }
    }

    public static boolean isPlaylistKey(String s)
    {
        if (s == null)
        {
            return false;
        } else
        {
            return playlistPattern.matcher(s).matches();
        }
    }

    public static boolean isTrackKey(String s)
    {
        if (s == null)
        {
            return false;
        } else
        {
            return trackPattern.matcher(s).matches();
        }
    }

}
