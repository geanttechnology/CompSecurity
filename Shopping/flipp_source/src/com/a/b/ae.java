// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.a.b:
//            d, a, ad

final class ae extends Handler
{

    ae(Looper looper)
    {
        super(looper);
    }

    public final void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            throw new AssertionError((new StringBuilder("Unknown handler message received: ")).append(message.what).toString());

        case 8: // '\b'
            for (message = ((List)message.obj).iterator(); message.hasNext();)
            {
                Object obj2 = (d)message.next();
                ad ad1 = ((d) (obj2)).b;
                Object obj = ((d) (obj2)).h;
                if (!((List) (obj)).isEmpty())
                {
                    Object obj1 = ((d) (obj2)).g;
                    obj1 = ((d) (obj2)).m;
                    obj1 = ((d) (obj2)).j;
                    obj2 = ((d) (obj2)).a();
                    obj = ((List) (obj)).iterator();
                    while (((Iterator) (obj)).hasNext()) 
                    {
                        a a1 = (a)((Iterator) (obj)).next();
                        if (!a1.i)
                        {
                            ad1.g.remove(a1.c.get());
                            if (obj1 != null)
                            {
                                if (obj2 == null)
                                {
                                    throw new AssertionError("LoadedFrom cannot be null.");
                                }
                                a1.a(((android.graphics.Bitmap) (obj1)), ((aj) (obj2)));
                            } else
                            {
                                a1.a();
                            }
                        }
                    }
                }
            }

            break;

        case 3: // '\003'
            message = (a)message.obj;
            ad.a(((a) (message)).a, ((a) (message)).c.get());
            break;
        }
    }
}
