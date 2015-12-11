// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.text.TextUtils;
import java.io.ByteArrayInputStream;

public final class bdo
    implements cou
{

    private final bns a;
    private final bjp b;

    public bdo(bns bns1, bjp bjp1)
    {
        a = (bns)b.a(bns1);
        b = (bjp)b.a(bjp1);
    }

    public final Object a_(Object obj)
    {
        obj = (bxb)obj;
        b.a(obj);
        obj = ((bxb) (obj)).k();
        if (TextUtils.isEmpty(((CharSequence) (obj))))
        {
            return null;
        } else
        {
            return ((bfy)a.a(new ByteArrayInputStream(((String) (obj)).getBytes("UTF-8")), (bnq)b.b_())).a();
        }
    }
}
