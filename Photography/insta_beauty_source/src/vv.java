// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.beautyui.newui.MOneKeyFragment;

public class vv
    implements android.view.View.OnClickListener
{

    final MOneKeyFragment a;

    public vv(MOneKeyFragment monekeyfragment)
    {
        a = monekeyfragment;
        super();
    }

    public void onClick(View view)
    {
        view.getId();
        JVM INSTR tableswitch 2131558920 2131558924: default 40
    //                   2131558920 90
    //                   2131558921 76
    //                   2131558922 62
    //                   2131558923 104
    //                   2131558924 118;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        MOneKeyFragment.b(a, MOneKeyFragment.g(a));
        MOneKeyFragment.h(a);
        return;
_L4:
        MOneKeyFragment.a(a, com.fotoable.beautyui.newui.MOneKeyFragment.SoftenState.IsSel1);
        continue; /* Loop/switch isn't completed */
_L3:
        MOneKeyFragment.a(a, com.fotoable.beautyui.newui.MOneKeyFragment.SoftenState.IsSel2);
        continue; /* Loop/switch isn't completed */
_L2:
        MOneKeyFragment.a(a, com.fotoable.beautyui.newui.MOneKeyFragment.SoftenState.IsSel3);
        continue; /* Loop/switch isn't completed */
_L5:
        MOneKeyFragment.a(a, com.fotoable.beautyui.newui.MOneKeyFragment.SoftenState.IsSel4);
        continue; /* Loop/switch isn't completed */
_L6:
        MOneKeyFragment.a(a, com.fotoable.beautyui.newui.MOneKeyFragment.SoftenState.IsSel5);
        if (true) goto _L1; else goto _L7
_L7:
    }
}
