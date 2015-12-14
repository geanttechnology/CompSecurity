// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;


// Referenced classes of package com.picsart.studio.editor.fragment:
//            SquareFitFragment

final class c extends Thread
{

    private String a;
    private String b;
    private String c;
    private SquareFitFragment d;

    public final void run()
    {
        if (SquareFitFragment.a(d, a, b, c))
        {
            SquareFitFragment.N(d);
        }
    }

    (SquareFitFragment squarefitfragment, String s, String s1, String s2)
    {
        d = squarefitfragment;
        a = s;
        b = s1;
        c = s2;
        super();
    }
}
