// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.utils.file;

import android.util.Pair;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.amazon.gallery.foundation.utils.file:
//            ReusedBufferedReader

static final class  extends ThreadLocal
{

    protected Pair initialValue()
    {
        return new Pair(new AtomicBoolean(false), new char[ReusedBufferedReader.access$000()]);
    }

    protected volatile Object initialValue()
    {
        return initialValue();
    }

    ()
    {
    }
}
