// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;


public final class ag extends RuntimeException
{

    public final int a;

    ag(int i)
    {
        super(a(i));
        a = i;
    }

    ag(Exception exception)
    {
        super(exception);
        a = 2;
    }

    ag(String s, int i)
    {
        super(s);
        a = i;
    }

    ag(String s, Exception exception)
    {
        super(s, exception);
        a = 2;
    }

    static String a(int i)
    {
        switch (i)
        {
        default:
            return "No error.";

        case 1: // '\001'
            return "An invalid parameter was given.";

        case 3: // '\003'
            return "Requires the main thread.";

        case 10: // '\n'
            return "The request timed out.";

        case 11: // '\013'
            return "There is no network available.";

        case 12: // '\f'
            return "A request is already in progress.";

        case 13: // '\r'
            return "A request is already being cached.";

        case 14: // '\016'
            return "The request was not filled by the server.";

        case 15: // '\017'
            return "The server replied with unknown or bad content.";

        case 16: // '\020'
            return "The system is not permitting a request at this time, try again later.";

        case 17: // '\021'
            return "Previously fetched ad exists in the playback queue";

        case 20: // '\024'
            return "There is no fetched ad to display.";

        case 21: // '\025'
            return "The ad to display has expired.";

        case 22: // '\026'
            return "The ad could not be found on disk.";

        case 23: // '\027'
            return "The ad has already been displayed.";

        case 24: // '\030'
            return "The ad has already been displayed.";

        case 25: // '\031'
            return "The reference to the ad view was broken.";

        case 26: // '\032'
            return "The ad view does not have a parent activity.";

        case 100: // 'd'
            return "An unknown error occured.";
        }
    }
}
