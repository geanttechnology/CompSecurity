// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.codehaus.jackson.io;

import java.io.IOException;
import java.io.Writer;

// Referenced classes of package org.codehaus.jackson.io:
//            IOContext

public abstract class OutputDecorator
{

    public abstract Writer decorate(IOContext iocontext, Writer writer)
        throws IOException;
}
