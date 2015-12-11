// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.graphics.Bitmap;
import com.jumio.netverify.sdk.extraction.templatematcher.TemplateInfoWrapper;

// Referenced classes of package jumiomobile:
//            px

public class ps extends px
{

    private Bitmap a;
    private Bitmap b;
    private TemplateInfoWrapper c;

    public ps(String s, long l, Bitmap bitmap, Bitmap bitmap1, TemplateInfoWrapper templateinfowrapper)
    {
        super(s, l);
        a = bitmap;
        b = bitmap1;
        c = templateinfowrapper;
    }

    public Bitmap[] b()
    {
        return (new Bitmap[] {
            a, b
        });
    }

    public TemplateInfoWrapper c()
    {
        return c;
    }
}
