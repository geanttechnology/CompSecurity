// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.api.Status;

final class azi
    implements auf
{

    private final Status a;
    private final String b;
    private final String c;

    public azi(Status status)
    {
        this(status, null, null, null, false);
    }

    public azi(Status status, ApplicationMetadata applicationmetadata, String s, String s1, boolean flag)
    {
        a = status;
        b = s;
        c = s1;
    }

    public final String a()
    {
        return b;
    }

    public final Status a_()
    {
        return a;
    }

    public final String b()
    {
        return c;
    }
}
