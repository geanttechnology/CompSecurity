// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.widget.ImageButton;
import com.fotoable.fotoproedit.activity.ProEditSlimBodyActivity;

public class ajc
    implements android.view.View.OnClickListener
{

    final ProEditSlimBodyActivity a;

    public ajc(ProEditSlimBodyActivity proeditslimbodyactivity)
    {
        a = proeditslimbodyactivity;
        super();
    }

    public void onClick(View view)
    {
        ProEditSlimBodyActivity.a(a, ProEditSlimBodyActivity.m(a), false);
        ProEditSlimBodyActivity.a(a, ProEditSlimBodyActivity.n(a), false);
        ProEditSlimBodyActivity.a(a, ProEditSlimBodyActivity.o(a), false);
        ProEditSlimBodyActivity.a(a, ProEditSlimBodyActivity.p(a), false);
        ProEditSlimBodyActivity.a(a, ProEditSlimBodyActivity.q(a), false);
        ProEditSlimBodyActivity.a(a, (ImageButton)view, true);
        switch (((Integer)view.getTag()).intValue())
        {
        default:
            return;

        case 1024: 
            ProEditSlimBodyActivity.a(a, 0.4F);
            return;

        case 1025: 
            ProEditSlimBodyActivity.a(a, 0.8F);
            return;

        case 1026: 
            ProEditSlimBodyActivity.a(a, 1.2F);
            return;

        case 1027: 
            ProEditSlimBodyActivity.a(a, 1.6F);
            return;

        case 1028: 
            ProEditSlimBodyActivity.a(a, 2.0F);
            break;
        }
    }
}
