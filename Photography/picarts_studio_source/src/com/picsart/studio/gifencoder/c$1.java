// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.gifencoder;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

// Referenced classes of package com.picsart.studio.gifencoder:
//            c, GifDrawable

final class a
    implements Runnable
{

    private c a;

    public final void run()
    {
        for (Iterator iterator = a.a.mListeners.iterator(); iterator.hasNext(); iterator.next()) { }
    }

    kedQueue(c c1)
    {
        a = c1;
        super();
    }
}
