// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient;

import java.util.Iterator;

// Referenced classes of package cz.msebera.android.httpclient:
//            HeaderElement

public interface HeaderElementIterator
    extends Iterator
{

    public abstract boolean hasNext();

    public abstract HeaderElement nextElement();
}
