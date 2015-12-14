// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package w.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public abstract class a extends Dialog
{

    private Activity a;
    private View b;

    public a(Context context, boolean flag)
    {
        int i;
        if (flag)
        {
            i = 0x7f0a0209;
        } else
        {
            i = 0x7f0a0225;
        }
        super(context, i);
        requestWindowFeature(1);
        a = (Activity)context;
    }

    private void b()
    {
        b = LayoutInflater.from(getContext()).inflate(a(), null, false);
        setContentView(b);
        a(b);
    }

    protected abstract int a();

    protected void a(View view)
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        b();
    }
}
