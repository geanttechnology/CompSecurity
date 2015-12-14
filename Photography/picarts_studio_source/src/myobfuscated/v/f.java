// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.v;

import android.content.Context;
import java.nio.ByteBuffer;

// Referenced classes of package myobfuscated.v:
//            ag, e, am, ae, 
//            g

public final class f
    implements ag
{

    public f()
    {
    }

    public final ae build(Context context, am am)
    {
        return new e(new g() {

            public final Class a()
            {
                return java/nio/ByteBuffer;
            }

            public final Object a(byte abyte0[])
            {
                return ByteBuffer.wrap(abyte0);
            }

        });
    }
}
