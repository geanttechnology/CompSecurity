// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model;

import com.perfectcorp.model.Model;

public class UserAtrribute extends Model
{

    int a;
    int b;
    public String eyeColor;
    public String hairColor;
    public String hairTexture;
    public String hairType;
    public Boolean isSensitive;
    public String lashLength;
    public String skinColor;
    public String skinType;
    public String underTone;

    public UserAtrribute()
    {
    }

    public static void a(UserAtrribute useratrribute, UserAtrribute useratrribute1)
    {
        if (useratrribute == null || useratrribute1 == null)
        {
            return;
        } else
        {
            useratrribute1.skinType = useratrribute.skinType;
            useratrribute1.skinColor = useratrribute.skinColor;
            useratrribute1.isSensitive = useratrribute.isSensitive;
            useratrribute1.eyeColor = useratrribute.eyeColor;
            useratrribute1.underTone = useratrribute.underTone;
            useratrribute1.lashLength = useratrribute.lashLength;
            useratrribute1.hairTexture = useratrribute.hairTexture;
            useratrribute1.hairColor = useratrribute.hairColor;
            useratrribute1.hairType = useratrribute.hairType;
            useratrribute1.a = useratrribute.a;
            useratrribute1.b = useratrribute.b;
            return;
        }
    }
}
