// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.gms.wearable.internal.v;
import java.util.ArrayList;
import java.util.List;

final class avy extends avx
{

    public avy(qk qk)
    {
        super(qk);
    }

    public void a(v v1)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.addAll(v1.c);
        a(new avn(avt.a(v1.b), arraylist));
    }
}
