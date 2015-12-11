// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.media.SoundPool;
import java.util.List;

final class acj
    implements android.media.SoundPool.OnLoadCompleteListener
{

    private acd a;

    acj(acd acd1)
    {
        a = acd1;
        super();
    }

    public final void onLoadComplete(SoundPool soundpool, int i, int j)
    {
        if (!a.g.isEmpty())
        {
            a.a(((Integer)a.g.remove(0)).intValue());
        }
    }
}
