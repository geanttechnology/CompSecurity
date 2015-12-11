// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.text.TextUtils;

public final class btt
{

    public final Uri a;
    public final int b;
    public final int c;

    public btt(Uri uri)
    {
        b.a(uri);
        a = uri;
        b = 0;
        c = 0;
    }

    public btt(dzq dzq1)
    {
        Object obj;
        b.a(dzq1);
        obj = dzq1.b;
        if (obj != null) goto _L2; else goto _L1
_L1:
        obj = null;
_L4:
        a = ((Uri) (obj));
        b = dzq1.c;
        c = dzq1.d;
        return;
_L2:
        Uri uri = Uri.parse(((String) (obj)));
        obj = uri;
        if (TextUtils.isEmpty(uri.getScheme()))
        {
            obj = uri.buildUpon().scheme("https").build();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (!(obj instanceof btt))
        {
            break MISSING_BLOCK_LABEL_73;
        }
        obj = (btt)obj;
        if (a != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((btt) (obj)).a == null) goto _L1; else goto _L3
_L3:
        return false;
        if (a.equals(((btt) (obj)).a) && b == ((btt) (obj)).b && c == ((btt) (obj)).c) goto _L1; else goto _L4
_L4:
        return false;
        return false;
    }

    public final int hashCode()
    {
        int i;
        if (a == null)
        {
            i = 0;
        } else
        {
            i = a.hashCode();
        }
        return ((i + 31) * 31 + b) * 31 + c;
    }
}
