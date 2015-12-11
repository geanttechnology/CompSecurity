// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.minidev.json;

import java.io.IOException;

// Referenced classes of package net.minidev.json:
//            JSONStreamAware, JSONStyle

public interface JSONStreamAwareEx
    extends JSONStreamAware
{

    public abstract void writeJSONString(Appendable appendable, JSONStyle jsonstyle)
        throws IOException;
}
