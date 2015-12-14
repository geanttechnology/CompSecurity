// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Rect;
import java.io.File;

public class aob
{

    public int a;
    public String b;
    public String c;
    long d;
    long e;
    int f;
    public int g;
    public long h;
    String i;
    public Rect j;
    public String k;

    public aob()
    {
    }

    public boolean a(String s)
    {
        return (new File((new StringBuilder()).append(s).append(File.separator).append(b.substring(b.lastIndexOf("/") + 1)).toString())).exists();
    }
}
