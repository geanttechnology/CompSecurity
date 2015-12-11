// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.tape;

import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package com.squareup.tape:
//            FileObjectQueue

public static interface 
{

    public abstract Object from(byte abyte0[])
        throws IOException;

    public abstract void toStream(Object obj, OutputStream outputstream)
        throws IOException;
}
