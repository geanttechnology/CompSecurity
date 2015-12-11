// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.media.MediaCodec;
import android.os.Handler;

final class cji extends aoh
{

    private boolean h;

    cji(cjh cjh, aor aor, ara ara, boolean flag, int i, long l, 
            aom aom, Handler handler, aol aol, int j, boolean flag1)
    {
        h = flag1;
        super(aor, ara, true, 1, 5000L, aom, handler, aol, 1);
    }

    protected final boolean a(MediaCodec mediacodec, boolean flag, aon aon, aon aon1)
    {
        return !h && super.a(mediacodec, flag, aon, aon1);
    }
}
