// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.fotoproedit.activity.ProEditNewStretchActivity;

public class aij
    implements uy
{

    final ProEditNewStretchActivity a;

    public aij(ProEditNewStretchActivity proeditnewstretchactivity)
    {
        a = proeditnewstretchactivity;
        super();
    }

    public void a()
    {
        a.runOnUiThread(new aik(this));
    }
}
