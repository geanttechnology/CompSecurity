// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.gms.common.api.Status;

final class ake
    implements awo
{

    private String a;
    private akc b;

    ake(akc akc1, String s)
    {
        b = akc1;
        a = s;
        super();
    }

    public final void a(awn awn)
    {
        awn = (bn)awn;
        if (b.b == null)
        {
            awn = b.a;
            awn = a;
            (new StringBuilder(String.valueOf(awn).length() + 41)).append("sendCommandCallback ").append(awn).append(": no longer connected");
            return;
        }
        if (awn.a_().a())
        {
            awn = b.a;
            awn = a;
            (new StringBuilder(String.valueOf(awn).length() + 26)).append("Command ").append(awn).append(" sent successfully");
            return;
        } else
        {
            awn = b.a;
            awn = a;
            (new StringBuilder(String.valueOf(awn).length() + 15)).append("Command ").append(awn).append(" failed");
            return;
        }
    }
}
