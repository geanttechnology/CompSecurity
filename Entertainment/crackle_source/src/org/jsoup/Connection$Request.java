// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup;

import java.util.Collection;
import org.jsoup.parser.Parser;

// Referenced classes of package org.jsoup:
//            Connection

public static interface 
    extends 
{

    public abstract Collection data();

    public abstract  data( );

    public abstract  followRedirects(boolean flag);

    public abstract boolean followRedirects();

    public abstract  ignoreContentType(boolean flag);

    public abstract boolean ignoreContentType();

    public abstract  ignoreHttpErrors(boolean flag);

    public abstract boolean ignoreHttpErrors();

    public abstract  parser(Parser parser1);

    public abstract Parser parser();

    public abstract int timeout();

    public abstract  timeout(int i);
}
