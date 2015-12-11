// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.accessibility;


public class AlternateInterfaceUtil
{

    private static boolean readMode = true;
    protected boolean shortCircuitTalk;

    public AlternateInterfaceUtil()
    {
        shortCircuitTalk = false;
    }

    public boolean getAndToggleShortCircuitTalk()
    {
        boolean flag = false;
        if (shortCircuitTalk)
        {
            shortCircuitTalk = false;
            flag = true;
        }
        return flag;
    }

    public boolean getReadMode()
    {
        return readMode;
    }

    public boolean getShortCircuitTalk()
    {
        return shortCircuitTalk;
    }

    public int interpretIfNumber(String s)
    {
        if (s.equalsIgnoreCase("won") || s.equalsIgnoreCase("one"))
        {
            return 1;
        }
        if (s.equalsIgnoreCase("to") || s.equalsIgnoreCase("too") || s.equalsIgnoreCase("two"))
        {
            return 2;
        }
        if (s.equalsIgnoreCase("for") || s.equalsIgnoreCase("fore") || s.equalsIgnoreCase("four"))
        {
            return 4;
        }
        if (s.equalsIgnoreCase("ate") || s.equalsIgnoreCase("eight"))
        {
            return 8;
        }
        int i;
        try
        {
            i = Integer.parseInt(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return -1;
        }
        return i;
    }

    public boolean isReadModeOn()
    {
        return readMode;
    }

    public void setReadMode(boolean flag)
    {
        readMode = flag;
    }

    public void setShortCircuitTalk(boolean flag)
    {
        shortCircuitTalk = flag;
    }

}
