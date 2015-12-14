// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import java.lang.ref.SoftReference;
import java.util.Map;

class bpc
    implements Runnable
{

    final String a;
    final bpf b;
    final bpb c;

    bpc(bpb bpb1, String s, bpf bpf)
    {
        c = bpb1;
        a = s;
        b = bpf;
        super();
    }

    public void run()
    {
        RuntimeException runtimeexception;
        try
        {
            android.graphics.drawable.Drawable drawable = c.a(a);
            c.a.put(a, new SoftReference(drawable));
            bpb.a(c).post(new bpd(this, drawable));
            return;
        }
        catch (Exception exception)
        {
            runtimeexception = new RuntimeException(exception);
        }
        bpb.a(c).post(new bpe(this, runtimeexception));
    }
}
