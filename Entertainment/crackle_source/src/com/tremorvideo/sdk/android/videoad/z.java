// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import java.util.ArrayList;

public class z
{
    public class a
    {

        public String a;
        public int b;
        final z c;

        public a(String s, int i)
        {
            c = z.this;
            super();
            a = s;
            b = i;
        }
    }


    ArrayList a;

    public z()
    {
        a = new ArrayList();
    }

    public void a(String s, int i)
    {
        a.add(new a(s, i));
    }
}
