// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import com.fotoable.fotobeauty.ExternReceiverActivity;

public class aaz
    implements aqu
{

    final String a;
    final String b;
    final ExternReceiverActivity c;

    public aaz(ExternReceiverActivity externreceiveractivity, String s, String s1)
    {
        c = externreceiveractivity;
        a = s;
        b = s1;
        super();
    }

    public void a(Bitmap bitmap)
    {
        String s1 = a;
        String s = s1;
        if (b != null)
        {
            s = (new StringBuilder()).append(s1).append(" ").append(b).toString();
        }
        atq.a(c, bitmap, null, null, s, new aba(this));
    }

    public void a(Exception exception)
    {
        String s = a;
        exception = s;
        if (b != null)
        {
            exception = (new StringBuilder()).append(s).append(" ").append(b).toString();
        }
        aty.a(c, exception);
        c.finish();
    }
}
