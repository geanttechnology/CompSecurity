// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.location.Location;
import java.util.Date;
import java.util.Set;

public class pu
{

    private final Date a;
    private final com.google.ads.AdRequest.Gender b;
    private final Set c;
    private final boolean d;
    private final Location e;

    public pu(Date date, com.google.ads.AdRequest.Gender gender, Set set, boolean flag, Location location)
    {
        a = date;
        b = gender;
        c = set;
        d = flag;
        e = location;
    }
}
