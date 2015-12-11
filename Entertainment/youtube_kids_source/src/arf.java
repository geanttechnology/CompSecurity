// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.media.MediaDrm;

final class arf
    implements android.media.MediaDrm.OnEventListener
{

    private arc a;

    arf(arc arc1)
    {
        a = arc1;
        super();
    }

    public final void onEvent(MediaDrm mediadrm, byte abyte0[], int i, int j, byte abyte1[])
    {
        a.c.sendEmptyMessage(i);
    }
}
