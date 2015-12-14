// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ab;

import android.os.Handler;
import android.os.Message;
import com.bumptech.glide.k;
import java.util.List;

// Referenced classes of package myobfuscated.ab:
//            j, i, k

final class l
    implements android.os.Handler.Callback
{

    private i a;

    private l(i i1)
    {
        a = i1;
        super();
    }

    l(i i1, byte byte0)
    {
        this(i1);
    }

    public final boolean handleMessage(Message message)
    {
        if (message.what == 1)
        {
            message = (j)message.obj;
            i i1 = a;
            if (i1.h)
            {
                i1.b.obtainMessage(2, message).sendToTarget();
            } else
            {
                if (((j) (message)).b != null)
                {
                    i1.c();
                    j j1 = i1.g;
                    i1.g = message;
                    for (int k1 = i1.c.size() - 1; k1 >= 0; k1--)
                    {
                        ((myobfuscated.ab.k)i1.c.get(k1)).b();
                    }

                    if (j1 != null)
                    {
                        i1.b.obtainMessage(2, j1).sendToTarget();
                    }
                }
                i1.f = false;
                i1.b();
            }
            return true;
        }
        if (message.what == 2)
        {
            message = (j)message.obj;
            a.d.a(message);
        }
        return false;
    }
}
