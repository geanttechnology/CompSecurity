// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;


// Referenced classes of package android.support.design.widget:
//            bs, bk, bq

class bn
{

    bn()
    {
    }

    public bk a()
    {
        Object obj;
        if (android.os.Build.VERSION.SDK_INT >= 12)
        {
            obj = new bs();
        } else
        {
            obj = new bq();
        }
        return new bk(((bo) (obj)));
    }
}
