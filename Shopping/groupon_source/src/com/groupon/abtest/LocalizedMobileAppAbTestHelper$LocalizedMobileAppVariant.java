// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.abtest;

import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.abtest:
//            LocalizedMobileAppAbTestHelper

public static class <init>
{

    protected boolean enabled;
    protected float miles;

    public float getMiles()
    {
        return miles;
    }

    public boolean isEnabled()
    {
        return enabled;
    }

    private Q(String s, boolean flag)
    {
        if (!Strings.equalsIgnoreCase(s, "Original") && flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        enabled = flag;
        try
        {
            miles = Float.valueOf(s).floatValue();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Ln.w("Couldn't convert the localized mobile value to float. Using the default", new Object[0]);
        }
        enabled = false;
    }

    enabled(String s, boolean flag, enabled enabled1)
    {
        this(s, flag);
    }
}
