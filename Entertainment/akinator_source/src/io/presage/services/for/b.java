// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.services.for;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import io.presage.services.do.c;

// Referenced classes of package io.presage.services.for:
//            a, j, c

public abstract class b extends io.presage.services.for.a
    implements j
{
    private final class a extends ContentObserver
    {

        final b a;

        public final void onChange(boolean flag)
        {
            super.onChange(flag);
            b.a(a).dispatchMessage(new Message());
        }

        public a(Handler handler)
        {
            a = b.this;
            super(handler);
        }
    }


    private Uri b;
    private Handler c;
    private a d;

    public b(c c1, Uri uri, String s)
    {
        super(c1, s);
        c = new Handler(new io.presage.services.for.c(this));
        d = new a(c);
        b = uri;
        d().getContentResolver().registerContentObserver(b, false, d);
    }

    static Handler a(b b1)
    {
        return b1.c;
    }

    public final Uri a_()
    {
        return b;
    }

    public final void e()
    {
        super.e();
        d().getContentResolver().unregisterContentObserver(d);
    }
}
