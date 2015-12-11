// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;


// Referenced classes of package android.support.v7.internal.widget:
//            e

private final class <init>
    implements Runnable
{

    final e a;

    public final void run()
    {
        if (a.v)
        {
            if (a.getAdapter() != null)
            {
                a.post(this);
            }
            return;
        } else
        {
            android.support.v7.internal.widget.e.b(a);
            return;
        }
    }

    private (e e1)
    {
        a = e1;
        super();
    }

    a(e e1, byte byte0)
    {
        this(e1);
    }
}
