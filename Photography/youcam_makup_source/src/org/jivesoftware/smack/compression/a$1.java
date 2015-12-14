// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jivesoftware.smack.compression;

import java.io.InputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

// Referenced classes of package org.jivesoftware.smack.compression:
//            a

class > extends InflaterInputStream
{

    final a a;

    public int available()
    {
        if (inf.needsInput())
        {
            return 0;
        } else
        {
            return super.available();
        }
    }

    (a a1, InputStream inputstream, Inflater inflater, int i)
    {
        a = a1;
        super(inputstream, inflater, i);
    }
}
