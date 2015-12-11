// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup;

import java.io.IOException;
import org.jsoup.nodes.Document;

// Referenced classes of package org.jsoup:
//            Connection

public static interface 
    extends 
{

    public abstract String body();

    public abstract byte[] bodyAsBytes();

    public abstract String charset();

    public abstract String contentType();

    public abstract Document parse()
        throws IOException;

    public abstract int statusCode();

    public abstract String statusMessage();
}
