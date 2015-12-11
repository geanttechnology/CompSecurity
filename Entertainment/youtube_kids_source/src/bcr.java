// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Message;

final class bcr
    implements android.os.Handler.Callback
{

    private bcn a;

    bcr(bcn bcn1)
    {
        a = bcn1;
        super();
    }

    public final boolean handleMessage(Message message)
    {
        a.a(false);
        return true;
    }
}
