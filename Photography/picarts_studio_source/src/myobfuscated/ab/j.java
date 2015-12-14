// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ab;

import android.graphics.Bitmap;
import android.os.Handler;
import myobfuscated.ag.f;
import myobfuscated.ah.e;

final class j extends f
{

    final int a;
    Bitmap b;
    private final Handler c;
    private final long d;

    j(Handler handler, int i, long l)
    {
        c = handler;
        a = i;
        d = l;
    }

    public final void a(Object obj, e e)
    {
        b = (Bitmap)obj;
        obj = c.obtainMessage(1, this);
        c.sendMessageAtTime(((android.os.Message) (obj)), d);
    }
}
