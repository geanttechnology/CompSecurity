// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

// Referenced classes of package android.support.v7:
//            ex

public abstract class ev
{
    public static interface a
    {

        public abstract void a();

        public abstract void b();
    }


    private static ev a;

    public ev()
    {
    }

    public static ev a()
    {
        android/support/v7/ev;
        JVM INSTR monitorenter ;
        ev ev1;
        if (a == null)
        {
            a = ex.a(0);
        }
        ev1 = a;
        android/support/v7/ev;
        JVM INSTR monitorexit ;
        return ev1;
        Exception exception;
        exception;
        throw exception;
    }

    public abstract void a(Context context, ImageView imageview, Uri uri, a a1);
}
