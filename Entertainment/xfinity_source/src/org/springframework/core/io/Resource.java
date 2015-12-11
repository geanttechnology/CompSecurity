// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.core.io;

import java.io.IOException;

// Referenced classes of package org.springframework.core.io:
//            InputStreamSource

public interface Resource
    extends InputStreamSource
{

    public abstract long contentLength()
        throws IOException;

    public abstract String getDescription();

    public abstract String getFilename();
}
