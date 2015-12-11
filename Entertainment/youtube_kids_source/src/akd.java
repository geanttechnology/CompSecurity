// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.gms.common.api.Status;

final class akd
    implements awo
{

    private String a;
    private akc b;

    akd(akc akc1, String s)
    {
        b = akc1;
        a = s;
        super();
    }

    public final void a(awn awn)
    {
        awn = (Status)awn;
        Object obj = b.a;
        if (awn.a())
        {
            awn = "succeeded: ";
        } else
        {
            awn = "failed: ";
        }
        obj = a;
        (new StringBuilder(String.valueOf(awn).length() + 16 + String.valueOf(obj).length())).append("sending message ").append(awn).append(((String) (obj)));
    }
}
