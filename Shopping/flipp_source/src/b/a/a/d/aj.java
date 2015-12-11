// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.d;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

// Referenced classes of package b.a.a.d:
//            al, am

final class aj
    implements al, am
{

    volatile am a;
    volatile al b;
    private final String c;
    private final String d;
    private final String e[];
    private final boolean f = false;
    private final boolean g = true;
    private final am h;
    private final al i;

    aj(String s, String s1, am am1, al al1)
    {
        c = s;
        d = s1;
        if (s.equals(s1))
        {
            e = (new String[] {
                s
            });
        } else
        {
            TreeSet treeset = new TreeSet(String.CASE_INSENSITIVE_ORDER);
            treeset.add(s);
            treeset.add(s1);
            s = new ArrayList(treeset);
            Collections.reverse(s);
            e = (String[])s.toArray(new String[s.size()]);
        }
        h = am1;
        i = al1;
    }
}
