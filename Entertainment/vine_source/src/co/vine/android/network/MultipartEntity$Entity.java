// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package co.vine.android.network:
//            MultipartEntity

public static interface 
{

    public abstract InputStream getInputStream()
        throws IOException;

    public abstract void writeTo(OutputStream outputstream)
        throws IOException;
}
