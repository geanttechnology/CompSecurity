// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.os.Looper;

// Referenced classes of package android.support.v7:
//            ake, ajx

static final class eption
    implements ake
{

    public void a(ajx ajx)
    {
        if (Looper.myLooper() != Looper.getMainLooper())
        {
            throw new IllegalStateException((new StringBuilder()).append("Event bus ").append(ajx).append(" accessed from non-main thread ").append(Looper.myLooper()).toString());
        } else
        {
            return;
        }
    }

    eption()
    {
    }
}
