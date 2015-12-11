// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobileapptracker;


// Referenced classes of package com.mobileapptracker:
//            MobileAppTracker, MATParameters

final class z
    implements Runnable
{

    final String a;
    final MobileAppTracker b;

    z(MobileAppTracker mobileapptracker, String s)
    {
        b = mobileapptracker;
        a = s;
        super();
    }

    public final void run()
    {
        String s = a.replaceAll("\\D+", "");
        StringBuilder stringbuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++)
        {
            stringbuilder.append(Integer.parseInt(String.valueOf(s.charAt(i))));
        }

        b.params.setPhoneNumber(stringbuilder.toString());
    }
}
