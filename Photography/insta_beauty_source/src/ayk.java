// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.view.actionbar.CommonActionBarView1;

public class ayk
    implements android.view.View.OnClickListener
{

    final CommonActionBarView1 a;

    public ayk(CommonActionBarView1 commonactionbarview1)
    {
        a = commonactionbarview1;
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
