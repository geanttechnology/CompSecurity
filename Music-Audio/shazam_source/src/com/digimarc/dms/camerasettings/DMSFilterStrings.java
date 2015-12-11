// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms.camerasettings;


public class DMSFilterStrings
{

    protected String mTarget;

    DMSFilterStrings(String s)
    {
        mTarget = "";
        mTarget = s;
    }

    private boolean isComment(String s)
    {
        if (s == null)
        {
            return false;
        } else
        {
            return s.startsWith("//");
        }
    }

    boolean contains(String s)
    {
        if (s != null && !isComment(s))
        {
            return mTarget.contains(s);
        } else
        {
            return false;
        }
    }

    boolean exactMatch(String s)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (s != null)
        {
            flag = flag1;
            if (!isComment(s))
            {
                flag = flag1;
                if (mTarget.compareTo(s) == 0)
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    boolean startsWith(String s)
    {
        if (s != null && !isComment(s))
        {
            return mTarget.startsWith(s);
        } else
        {
            return false;
        }
    }
}
