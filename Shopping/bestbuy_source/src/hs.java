// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Build;

public class hs extends ka
{

    public hs()
    {
    }

    public void a()
    {
        String s;
        String s1;
        String s2;
        String s3;
        s = nb.a().s();
        s1 = nb.q();
        s2 = nb.a().m();
        s3 = Build.MANUFACTURER;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        if (!s.isEmpty())
        {
            fs.d(s, s3, s2, s1);
        }
        return;
        Exception exception;
        exception;
        exception.printStackTrace();
        return;
    }

    public void b()
    {
    }
}
