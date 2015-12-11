// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;


// Referenced classes of package android.support.v7.internal.widget:
//            e

private class <init>
    implements Runnable
{

    final e a;

    public void run()
    {
        if (a.u)
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

    a(e e1, a a1)
    {
        this(e1);
    }
}
