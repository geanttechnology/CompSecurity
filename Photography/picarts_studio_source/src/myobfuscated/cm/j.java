// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cm;

import android.graphics.Bitmap;
import com.photo.effect.Effect;
import java.nio.ByteBuffer;
import myobfuscated.ck.c;

// Referenced classes of package myobfuscated.cm:
//            d, c, h

public class j
{

    d a;
    int b;
    h c;
    boolean d;
    myobfuscated.cm.c e;

    public j(myobfuscated.cm.c c1, d d1, int i, h h1, boolean flag)
    {
        e = c1;
        a = d1;
        b = i;
        c = h1;
        d = flag;
        super();
    }

    public void a(Effect effect, boolean flag, long l)
    {
        if (flag)
        {
            if (a.j != null)
            {
                a.j.rewind();
                a.c.copyPixelsToBuffer(a.j);
            }
            myobfuscated.cm.c.a(a, b);
        }
        myobfuscated.cm.c c1 = e;
        boolean flag1;
        if (effect.d.compareTo("Motion") == 0 && effect.b("Colorize"))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        c1.e = flag1;
        e.d.c = false;
        if (c != null)
        {
            android.graphics.Point point = a.e;
            if (d)
            {
                point = a.f;
            }
            c.a(effect, flag, l, point);
        }
        e.c = null;
    }
}
