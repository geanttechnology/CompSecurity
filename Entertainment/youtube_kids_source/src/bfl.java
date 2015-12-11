// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import java.util.Map;

public class bfl
    implements cri
{

    private int a;
    private int b;

    public bfl(int i, int j)
    {
        a = -1;
        b = -1;
        a = i;
        b = j;
    }

    public final String a()
    {
        return bfl.getSimpleName();
    }

    public final String a(Uri uri, String s)
    {
        uri = (Integer)bfj.a.get(s);
        if (uri == null)
        {
            return null;
        }
        switch (uri.intValue())
        {
        default:
            return null;

        case 22: // '\026'
            return Integer.toString(a);

        case 23: // '\027'
            return Integer.toString(b);
        }
    }
}
