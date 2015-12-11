// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup;

import java.net.URL;
import java.util.Map;

// Referenced classes of package org.jsoup:
//            Connection

public static interface d
{

    public abstract String cookie(String s);

    public abstract d cookie(String s, String s1);

    public abstract Map cookies();

    public abstract boolean hasCookie(String s);

    public abstract boolean hasHeader(String s);

    public abstract String header(String s);

    public abstract d header(String s, String s1);

    public abstract Map headers();

    public abstract d method(d d);

    public abstract d method();

    public abstract d removeCookie(String s);

    public abstract d removeHeader(String s);

    public abstract URL url();

    public abstract d url(URL url1);
}
