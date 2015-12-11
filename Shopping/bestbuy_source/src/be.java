// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.Writer;

final class be extends Writer
{

    private final char a[] = new char[1];
    private char b;
    private bd c;

    public be(bd bd1)
    {
        c = bd1;
        super(bd.a(bd1));
        b = '\0';
    }

    private void a(char c1)
    {
        a[0] = c1;
        bd.a(c).write(a);
    }

    public final void close()
    {
    }

    public final void flush()
    {
        bd.a(c).flush();
    }

    public final void write(int i)
    {
        char c1 = (char)i;
        c1;
        JVM INSTR lookupswitch 8: default 80
    //                   8: 204
    //                   9: 219
    //                   10: 234
    //                   12: 249
    //                   13: 264
    //                   34: 167
    //                   47: 181
    //                   92: 167;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L7
_L1:
        if (c1 >= ' ' && (c1 < '\200' || c1 >= '\240') && (c1 < '\u2000' || c1 >= '\u2100')) goto _L10; else goto _L9
_L9:
        bd.a(c).write("\\u");
        String s = Integer.toHexString(c1);
        bd.a(c).write("0000", 0, 4 - s.length());
        bd.a(c).write(s);
_L12:
        b = c1;
        return;
_L7:
        a('\\');
_L10:
        a(c1);
        continue; /* Loop/switch isn't completed */
_L8:
        if (b == '<')
        {
            a('\\');
        }
        a(c1);
        continue; /* Loop/switch isn't completed */
_L2:
        bd.a(c).write("\\b");
        continue; /* Loop/switch isn't completed */
_L3:
        bd.a(c).write("\\t");
        continue; /* Loop/switch isn't completed */
_L4:
        bd.a(c).write("\\n");
        continue; /* Loop/switch isn't completed */
_L5:
        bd.a(c).write("\\f");
        continue; /* Loop/switch isn't completed */
_L6:
        bd.a(c).write("\\r");
        if (true) goto _L12; else goto _L11
_L11:
    }

    public final void write(char ac[], int i, int j)
    {
        for (; i < j; i++)
        {
            write(ac[i]);
        }

    }
}
