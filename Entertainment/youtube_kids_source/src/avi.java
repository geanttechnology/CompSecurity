// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.gms.common.api.Status;

abstract class avi extends aup
{

    azz a;

    avi()
    {
        a = new avj(this);
    }

    public final awn a(Status status)
    {
        return b(status);
    }

    public final bn b(Status status)
    {
        return new avk(this, status);
    }
}
