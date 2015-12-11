// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;

public class aiy extends ge
{

    public final ir a = ir.a(getContext());
    public final iz b = ir.c();
    public final ajb c;

    public aiy(Context context, int i, ajb ajb)
    {
        super(context, i);
        context = a;
        c = ajb;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = (Button)findViewById(0x7f100152);
        if (bundle != null)
        {
            bundle.setOnClickListener(new aiz(this));
        }
    }
}
