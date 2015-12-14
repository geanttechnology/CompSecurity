// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import com.perfectcorp.model.Model;

public class A extends Model
{

    public boolean default_profile_image;
    public String description;
    public Long id;
    public String name;
    public String profile_image_url;
    public String screen_name;

    public String a(String s)
    {
        String s2 = profile_image_url;
        if (s2 != null)
        {
            int i = s2.lastIndexOf("_");
            int j = s2.lastIndexOf(".");
            int k = s2.lastIndexOf("/");
            String s1 = (new StringBuilder()).append(s2.substring(0, i)).append(s).toString();
            s = s1;
            if (j > k)
            {
                s = (new StringBuilder()).append(s1).append(s2.substring(j)).toString();
            }
            return s;
        } else
        {
            return null;
        }
    }

    public A()
    {
    }
}
