// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.BitmapFactory;

class aqt
    implements Runnable
{

    final String a;
    final aqs b;

    aqt(aqs aqs1, String s)
    {
        b = aqs1;
        a = s;
        super();
    }

    public void run()
    {
        if (b.d != null)
        {
            android.graphics.Bitmap bitmap = BitmapFactory.decodeFile(a);
            b.d.a(bitmap);
        }
    }
}
