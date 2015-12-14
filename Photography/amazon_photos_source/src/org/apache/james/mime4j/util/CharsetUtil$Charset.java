// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.util;


// Referenced classes of package org.apache.james.mime4j.util:
//            CharsetUtil

private static class <init>
    implements Comparable
{

    private String aliases[];
    private String canonical;
    private String mime;

    public volatile int compareTo(Object obj)
    {
        return compareTo((compareTo)obj);
    }

    public int compareTo(compareTo compareto)
    {
        return canonical.compareTo(compareto.canonical);
    }




    private (String s, String s1, String as[])
    {
        canonical = null;
        mime = null;
        aliases = null;
        canonical = s;
        mime = s1;
        aliases = as;
    }

    aliases(String s, String s1, String as[], aliases aliases1)
    {
        this(s, s1, as);
    }
}
