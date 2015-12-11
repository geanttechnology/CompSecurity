// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package com.tapjoy.internal:
//            bk, af, bh, bj

public final class w
    implements bk
{

    public static final w a = new w();

    private w()
    {
    }

    public final Bitmap a(InputStream inputstream)
    {
        try
        {
            inputstream = (Bitmap)af.a(new bh(inputstream) {

                final InputStream a;
                final w b;

                public final Object call()
                {
                    if (a instanceof bj)
                    {
                        return BitmapFactory.decodeStream(a);
                    } else
                    {
                        return BitmapFactory.decodeStream(new bj(a));
                    }
                }

            
            {
                b = w.this;
                a = inputstream;
                super();
            }
            });
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            return null;
        }
        return inputstream;
    }

    public final void a(OutputStream outputstream, Object obj)
    {
        if (!((Bitmap)obj).compress(android.graphics.Bitmap.CompressFormat.PNG, 100, outputstream))
        {
            throw new RuntimeException();
        } else
        {
            return;
        }
    }

    public final Object b(InputStream inputstream)
    {
        return a(inputstream);
    }

}
