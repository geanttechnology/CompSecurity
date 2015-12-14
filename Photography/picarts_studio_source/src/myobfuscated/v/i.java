// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.v;

import android.content.Context;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

// Referenced classes of package myobfuscated.v:
//            ag, e, am, ae, 
//            g

public final class i
    implements ag
{

    public i()
    {
    }

    public final ae build(Context context, am am)
    {
        return new e(new g() {

            public final Class a()
            {
                return java/io/InputStream;
            }

            public final Object a(byte abyte0[])
            {
                return new ByteArrayInputStream(abyte0);
            }

        });
    }
}
