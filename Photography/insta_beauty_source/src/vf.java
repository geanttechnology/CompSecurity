// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.beautyui.newui.MNewSofterFragment;

public class vf
    implements android.view.View.OnClickListener
{

    final MNewSofterFragment a;

    public vf(MNewSofterFragment mnewsofterfragment)
    {
        a = mnewsofterfragment;
        super();
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131558603: 
            MNewSofterFragment.g(a);
            return;

        case 2131558662: 
            MNewSofterFragment.h(a);
            return;

        case 2131558935: 
            MNewSofterFragment.a(a, com.fotoable.beautyui.newui.MNewSofterFragment.SoftenState.Soften);
            MNewSofterFragment.i(a);
            return;

        case 2131558937: 
            MNewSofterFragment.a(a, com.fotoable.beautyui.newui.MNewSofterFragment.SoftenState.Skin);
            MNewSofterFragment.i(a);
            return;

        case 2131558936: 
            MNewSofterFragment.a(a, com.fotoable.beautyui.newui.MNewSofterFragment.SoftenState.White);
            MNewSofterFragment.i(a);
            return;
        }
    }
}
