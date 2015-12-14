// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ck;

import android.view.MotionEvent;
import android.view.View;
import com.picsart.studio.EditingData;

// Referenced classes of package myobfuscated.ck:
//            a, c

final class t>
    implements android.view.OnTouchListener
{

    private a a;

    public final boolean onTouch(View view, MotionEvent motionevent)
    {
        if (motionevent.getPointerCount() > 1) goto _L2; else goto _L1
_L1:
        motionevent.getAction();
        JVM INSTR tableswitch 0 3: default 44
    //                   0 46
    //                   1 77
    //                   2 44
    //                   3 77;
           goto _L3 _L4 _L2 _L3 _L2
_L3:
        return false;
_L4:
        view = myobfuscated.ck.a.a(a).q;
        view.d = ((EditingData) (view)).d + 1;
        myobfuscated.ck.a.F(a);
        continue; /* Loop/switch isn't completed */
_L2:
        myobfuscated.ck.a.E(a);
        if (true) goto _L3; else goto _L5
_L5:
    }

    ent(a a1)
    {
        a = a1;
        super();
    }
}
