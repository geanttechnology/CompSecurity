// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.v;

import android.os.ParcelFileDescriptor;
import java.io.File;

// Referenced classes of package myobfuscated.v:
//            o, r

public final class p extends o
{

    public p()
    {
        super(new r() {

            public final Class a()
            {
                return android/os/ParcelFileDescriptor;
            }

            public final Object a(File file)
            {
                return ParcelFileDescriptor.open(file, 0x10000000);
            }

            public final void a(Object obj)
            {
                ((ParcelFileDescriptor)obj).close();
            }

        });
    }
}
