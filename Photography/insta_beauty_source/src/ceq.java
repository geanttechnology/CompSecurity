// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.InputStream;
import java.io.OutputStream;

public class ceq
    implements cep
{

    public ceq()
    {
    }

    public Object a(InputStream inputstream)
    {
        return BitmapFactory.decodeStream(inputstream);
    }

    public void a(OutputStream outputstream, Object obj)
    {
        ((Bitmap)obj).compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, outputstream);
    }
}
