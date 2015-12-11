// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.fb_tmblr_twitter;

import java.util.HashSet;
import java.util.Set;

public class FBPermissionStates
{

    public static final int EMAIL = 2;
    public static String EMAIL_PERMISSION = "email";
    public static final int FRIENDS = 4;
    public static String FRIENDS_PERMISSION = "user_friends";
    public static final int NONE = 0;
    public static final int PUBLISH = 8;
    public static String PUBLISH_PERMISSION = "publish_actions";
    public static final int READ = 1;
    public static String READ_PERMISSION = "public_profile";

    public FBPermissionStates()
    {
    }

    public static int getMaskFromString(String s)
    {
        int i = 0;
        if (s.equals("public_profile"))
        {
            i = false | true;
        } else
        {
            if (s.equals("email"))
            {
                return 0 | 2;
            }
            if (s.equals("publish_actions"))
            {
                return 0 | 8;
            }
            if (s.equals("user_friends"))
            {
                return 0 | 4;
            }
        }
        return i;
    }

    public static Set getPermissionStringSet(int i)
    {
        HashSet hashset = new HashSet();
        if ((i & 1) != 0)
        {
            hashset.add("public_profile");
        }
        if ((i & 2) != 0)
        {
            hashset.add("email");
        }
        if ((i & 8) != 0)
        {
            hashset.add("publish_actions");
        }
        if ((i & 4) != 0)
        {
            hashset.add("user_friends");
        }
        return hashset;
    }

}
