// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import java.nio.ByteBuffer;
import java.util.Set;

public abstract class bxf
    implements bn
{

    private final bov a;
    private final bxe b;

    public bxf(bov bov1, bxe bxe1)
    {
        a = (bov)b.a(bov1);
        b = (bxe)b.a(bxe1);
    }

    public View a(bxh bxh, bvz bvz1)
    {
        bxh = b.h();
        bov bov1 = a;
        if (bov1.a.o())
        {
            while (bvz1 != null) 
            {
                if (!bov.a(bvz1.a()))
                {
                    continue;
                }
                byte abyte0[] = bvz1.a();
                boolean flag;
                if (!bvy.a(abyte0))
                {
                    flag = false;
                } else
                {
                    flag = ((bvy) (bxh)).c.contains(ByteBuffer.wrap(abyte0));
                }
                if (flag)
                {
                    continue;
                }
                abyte0 = bov.a();
                abyte0.b = new ebz();
                ((dnp) (abyte0)).b.a = new ece[1];
                ((dnp) (abyte0)).b.a[0] = bov.a(bvz1);
                if (bov.b(((bvy) (bxh)).a))
                {
                    ((dnp) (abyte0)).b.b = ((bvy) (bxh)).a;
                }
                ((dnp) (abyte0)).b.c = ((bvy) (bxh)).b;
                if (false)
                {
                    abyte0.f = null;
                }
                bov1.a(abyte0);
                if (bov1.a.r())
                {
                    bov.a("VISIB:", ((bvy) (bxh)).a, bvz1.a(), ((bvy) (bxh)).b, bvz1);
                }
                abyte0 = bvz1.a();
                if (bvy.a(abyte0))
                {
                    ((bvy) (bxh)).c.add(ByteBuffer.wrap(abyte0));
                }
                bvz1 = bvz1.b();
            }
        }
        return null;
    }
}
