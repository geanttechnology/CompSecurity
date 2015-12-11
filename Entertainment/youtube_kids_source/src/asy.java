// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class asy
    implements Comparable
{

    private static final Pattern g = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)(\\.v1\\.exo)$");
    public final String a;
    public final long b;
    public final long c;
    public final boolean d;
    public final File e;
    public final long f;

    private asy(String s, long l, long l1, boolean flag, long l2, File file)
    {
        a = s;
        b = l;
        c = l1;
        d = flag;
        e = file;
        f = l2;
    }

    public static asy a(File file)
    {
        Matcher matcher = g.matcher(file.getName());
        if (!matcher.matches())
        {
            return null;
        } else
        {
            return a(matcher.group(1), Long.parseLong(matcher.group(2)), Long.parseLong(matcher.group(3)), file);
        }
    }

    public static asy a(String s, long l)
    {
        return new asy(s, l, -1L, false, -1L, null);
    }

    public static asy a(String s, long l, long l1)
    {
        return new asy(s, l, l1, false, -1L, null);
    }

    static asy a(String s, long l, long l1, File file)
    {
        return new asy(s, l, file.length(), true, l1, file);
    }

    public static File a(File file, String s, long l, long l1)
    {
        String s1 = String.valueOf(".v1.exo");
        return new File(file, (new StringBuilder(String.valueOf(s).length() + 42 + String.valueOf(s1).length())).append(s).append(".").append(l).append(".").append(l1).append(s1).toString());
    }

    public static asy b(String s, long l)
    {
        return new asy(s, l, -1L, false, -1L, null);
    }

    public final int a(asy asy1)
    {
        if (!a.equals(asy1.a))
        {
            return a.compareTo(asy1.a);
        }
        long l = b - asy1.b;
        if (l == 0L)
        {
            return 0;
        }
        return l >= 0L ? 1 : -1;
    }

    public final int compareTo(Object obj)
    {
        return a((asy)obj);
    }

}
