// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.io;

import com.comcast.cim.httpcomponentsandroid.util.CharArrayBuffer;
import java.io.IOException;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.io:
//            HttpTransportMetrics

public interface SessionInputBuffer
{

    public abstract HttpTransportMetrics getMetrics();

    public abstract boolean isDataAvailable(int i)
        throws IOException;

    public abstract int read()
        throws IOException;

    public abstract int read(byte abyte0[], int i, int j)
        throws IOException;

    public abstract int readLine(CharArrayBuffer chararraybuffer)
        throws IOException;
}
