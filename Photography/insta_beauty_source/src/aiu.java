// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.fotoproedit.activity.ProEditSlimBodyActivity;

public class aiu
    implements android.view.View.OnClickListener
{

    final ProEditSlimBodyActivity a;

    public aiu(ProEditSlimBodyActivity proeditslimbodyactivity)
    {
        a = proeditslimbodyactivity;
        super();
    }

    public void onClick(View view)
    {
        ProEditSlimBodyActivity.e(a);
    }
}
