// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package android.support.v7:
//            ald, alb

class akl extends ald
{

    final Context a;

    akl(Context context)
    {
        a = context;
    }

    public ald.a a(alb alb1, int i)
        throws IOException
    {
        return new ald.a(b(alb1), aky.d.b);
    }

    public boolean a(alb alb1)
    {
        return "content".equals(alb1.d.getScheme());
    }

    InputStream b(alb alb1)
        throws FileNotFoundException
    {
        return a.getContentResolver().openInputStream(alb1.d);
    }
}
