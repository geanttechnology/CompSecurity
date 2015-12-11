// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid;

import java.util.Iterator;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid:
//            Header

public interface HeaderIterator
    extends Iterator
{

    public abstract boolean hasNext();

    public abstract Header nextHeader();
}
