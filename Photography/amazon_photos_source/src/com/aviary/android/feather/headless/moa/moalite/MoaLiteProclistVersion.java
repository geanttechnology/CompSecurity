// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.headless.moa.moalite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class MoaLiteProclistVersion
{

    static final Pattern PATTERN = Pattern.compile("^([0-9]+)\\.([0-9]+)\\.([0-9]+)$");
    static final int VERSION_GROUP_SIZE = 3;
    static final int VERSION_MAJOR_INDEX = 1;
    static final int VERSION_MINOR_INDEX = 2;
    static final int VERSION_PATCH_INDEX = 3;
    final int major;
    final int minor;
    final int patch;

    public MoaLiteProclistVersion(int i, int j, int k)
    {
        major = i;
        minor = j;
        patch = k;
    }

    public static MoaLiteProclistVersion fromString(String s)
    {
        Object obj = PATTERN.matcher(s);
        if (((Matcher) (obj)).matches() && ((Matcher) (obj)).groupCount() == 3)
        {
            s = ((Matcher) (obj)).group(1);
            String s1 = ((Matcher) (obj)).group(2);
            obj = ((Matcher) (obj)).group(3);
            try
            {
                s = new MoaLiteProclistVersion(Integer.parseInt(s), Integer.parseInt(s1), Integer.parseInt(((String) (obj))));
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return null;
            }
            return s;
        } else
        {
            return null;
        }
    }

    public boolean supports(MoaLiteProclistVersion moaliteproclistversion)
    {
        return major >= moaliteproclistversion.major && minor >= moaliteproclistversion.minor && patch >= moaliteproclistversion.patch;
    }

    public String toString()
    {
        return (new StringBuilder()).append(major).append(".").append(minor).append(".").append(patch).toString();
    }

}
