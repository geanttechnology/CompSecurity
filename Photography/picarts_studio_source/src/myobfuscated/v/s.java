// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.v;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

// Referenced classes of package myobfuscated.v:
//            o, r

public final class s extends o
{

    public s()
    {
        super(new r() {

            public final Class a()
            {
                return java/io/InputStream;
            }

            public final Object a(File file)
            {
                return new FileInputStream(file);
            }

            public final void a(Object obj)
            {
                ((InputStream)obj).close();
            }

        });
    }
}
