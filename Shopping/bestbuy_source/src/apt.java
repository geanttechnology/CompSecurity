// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.google.android.gms.plus.PlusOneButton;

public class apt
    implements android.view.View.OnClickListener, apu
{

    final PlusOneButton a;
    private final apu b;

    public apt(PlusOneButton plusonebutton, apu apu1)
    {
        a = plusonebutton;
        super();
        b = apu1;
    }

    public void a(Intent intent)
    {
        android.content.Context context = a.getContext();
        if ((context instanceof Activity) && intent != null)
        {
            ((Activity)context).startActivityForResult(intent, PlusOneButton.b(a));
        }
    }

    public void onClick(View view)
    {
        view = (Intent)PlusOneButton.a(a).getTag();
        if (b != null)
        {
            b.a(view);
            return;
        } else
        {
            a(view);
            return;
        }
    }
}
