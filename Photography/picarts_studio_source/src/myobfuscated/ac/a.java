// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ac;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.ad;
import java.io.ByteArrayOutputStream;
import myobfuscated.y.c;

// Referenced classes of package myobfuscated.ac:
//            d

public final class a
    implements d
{

    private final android.graphics.Bitmap.CompressFormat a;
    private final int b;

    public a()
    {
        this(android.graphics.Bitmap.CompressFormat.JPEG);
    }

    private a(android.graphics.Bitmap.CompressFormat compressformat)
    {
        a = compressformat;
        b = 100;
    }

    public final ad a(ad ad1)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        ((Bitmap)ad1.b()).compress(a, 100, bytearrayoutputstream);
        ad1.d();
        return new c(bytearrayoutputstream.toByteArray());
    }
}
