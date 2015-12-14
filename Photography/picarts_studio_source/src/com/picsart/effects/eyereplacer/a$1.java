// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.eyereplacer;

import android.graphics.Bitmap;
import com.socialin.android.photo.imgop.ImageOpCommon;
import java.nio.ByteBuffer;

// Referenced classes of package com.picsart.effects.eyereplacer:
//            a

final class a
    implements Runnable
{

    private ByteBuffer a;
    private a b;

    public final void run()
    {
        b.c.copyPixelsFromBuffer(a);
        ImageOpCommon.freeNativeBuffer(a);
    }

    geOpCommon(a a1, ByteBuffer bytebuffer)
    {
        b = a1;
        a = bytebuffer;
        super();
    }
}
