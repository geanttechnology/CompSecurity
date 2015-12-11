// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import java.util.Map;

public class bfg
    implements cri
{

    private crw a;

    public bfg(crw crw1)
    {
        a = crw1;
    }

    public final String a()
    {
        return bfg.getSimpleName();
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

        case 4: // '\004'
            if (a != null)
            {
                return Integer.toString(a.b.o);
            } else
            {
                return "0";
            }

        case 10: // '\n'
            if (a != null)
            {
                boolean flag;
                if (a.b.m != 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    return "1";
                }
            }
            return "0";

        case 16: // '\020'
            if (a != null)
            {
                return Integer.toString(a.b.n);
            } else
            {
                return "0";
            }

        case 17: // '\021'
            if (a != null && a.c != null)
            {
                return a.c;
            } else
            {
                return "";
            }

        case 24: // '\030'
            break;
        }
        if (a != null)
        {
            return Integer.toString(a.b.m);
        } else
        {
            return "0";
        }
    }
}
