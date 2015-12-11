// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.media.ExifInterface;
import android.net.Uri;
import java.io.IOException;

// Referenced classes of package android.support.v7:
//            akl, alb

class akp extends akl
{

    akp(Context context)
    {
        super(context);
    }

    static int a(Uri uri)
        throws IOException
    {
        switch ((new ExifInterface(uri.getPath())).getAttributeInt("Orientation", 1))
        {
        case 4: // '\004'
        case 5: // '\005'
        case 7: // '\007'
        default:
            return 0;

        case 6: // '\006'
            return 90;

        case 3: // '\003'
            return 180;

        case 8: // '\b'
            return 270;
        }
    }

    public ald.a a(alb alb1, int i)
        throws IOException
    {
        return new ald.a(null, b(alb1), aky.d.b, a(alb1.d));
    }

    public boolean a(alb alb1)
    {
        return "file".equals(alb1.d.getScheme());
    }
}
