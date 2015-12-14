// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.beautyui.ProEditActionBarView1;

public class kb
    implements android.view.View.OnClickListener
{

    final ProEditActionBarView1 a;

    public kb(ProEditActionBarView1 proeditactionbarview1)
    {
        a = proeditactionbarview1;
        super();
    }

    public void onClick(View view)
    {
        if (a.listener != null)
        {
            a.listener.b();
        }
    }
}
