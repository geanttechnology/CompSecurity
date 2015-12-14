// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.beautyui.newui.MOneKeyFragment;

public class wb
    implements android.view.View.OnClickListener
{

    final MOneKeyFragment a;

    public wb(MOneKeyFragment monekeyfragment)
    {
        a = monekeyfragment;
        super();
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131558603: 
            MOneKeyFragment.q(a);
            return;

        case 2131558662: 
            MOneKeyFragment.r(a);
            break;
        }
    }
}
