// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cf;

import android.widget.CompoundButton;
import com.socialin.android.brushlib.controller.a;
import com.socialin.android.photo.draw.dialog.SelectBrushDialog;

// Referenced classes of package myobfuscated.cf:
//            a

final class it>
    implements android.widget.oundButton.OnCheckedChangeListener
{

    private myobfuscated.cf.a a;

    public final void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        compoundbutton.getId();
        JVM INSTR tableswitch 2131755467 2131755472: default 44
    //                   2131755467 92
    //                   2131755468 44
    //                   2131755469 77
    //                   2131755470 107
    //                   2131755471 44
    //                   2131755472 62;
           goto _L1 _L2 _L1 _L3 _L4 _L1 _L5
_L1:
        a.F.a(a.y);
        return;
_L5:
        a.y.setAutoOrient(flag);
        continue; /* Loop/switch isn't completed */
_L3:
        a.y.setVaryOpacity(flag);
        continue; /* Loop/switch isn't completed */
_L2:
        a.y.setVaryThickness(flag);
        continue; /* Loop/switch isn't completed */
_L4:
        a.b = flag;
        if (true) goto _L1; else goto _L6
_L6:
    }

    undButton(myobfuscated.cf.a a1)
    {
        a = a1;
        super();
    }
}
