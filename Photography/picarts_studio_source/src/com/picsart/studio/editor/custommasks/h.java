// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.custommasks;

import java.util.List;

public final class h
{

    public String a;
    public String b;
    public List c;
    boolean d;
    public boolean e;

    public h()
    {
        d = false;
    }

    public final String toString()
    {
        String s = a.toLowerCase();
        return (new StringBuilder()).append(Character.toString(s.charAt(0)).toUpperCase()).append(s.substring(1)).toString();
    }
}
