// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.gms.cast.LaunchOptions;

final class aui extends aur
{

    private String a;
    private LaunchOptions c;

    aui(aug aug, String s, LaunchOptions launchoptions)
    {
        a = s;
        c = launchoptions;
        super();
    }

    protected final void a(awb awb)
    {
        awb = (azh)awb;
        try
        {
            String s = a;
            LaunchOptions launchoptions = c;
            awb.a(this);
            ((azq)awb.i()).a(s, launchoptions);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (awb awb)
        {
            a(2001);
        }
    }
}
