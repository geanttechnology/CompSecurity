// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.dialogs;

import android.view.MotionEvent;
import android.view.View;
import com.cyberlink.youcammakeup.widgetpool.common.FaceSwitcherView;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.dialogs:
//            FaceSwitcherDialog

class b
    implements Runnable
{

    final issType a;
    final int b;
    final issType c;

    public void run()
    {
        FaceSwitcherDialog.a(c.c, a, b);
    }

    issType(issType isstype, issType isstype1, int i)
    {
        c = isstype;
        a = isstype1;
        b = i;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/dialogs/FaceSwitcherDialog$7

/* anonymous class */
    class FaceSwitcherDialog._cls7
        implements android.view.View.OnTouchListener
    {

        final FaceSwitcherDialog a;

        public boolean onTouch(View view, MotionEvent motionevent)
        {
            motionevent.getActionMasked();
            JVM INSTR tableswitch 0 1: default 28
        //                       0 30
        //                       1 66;
               goto _L1 _L2 _L3
_L1:
            int i;
            return true;
_L2:
            if ((i = FaceSwitcherDialog.b(a).a(motionevent.getX(), motionevent.getY())) >= 0)
            {
                FaceSwitcherDialog.b(a).setHoveredFacePosition(i);
                return true;
            }
              goto _L1
_L3:
            int j;
            i = FaceSwitcherDialog.b(a).a(motionevent.getX(), motionevent.getY());
            j = FaceSwitcherDialog.b(a).getHoveredFacePosition();
            motionevent = FaceSwitcherDialog.DismissType.a;
            if (i < 0 || i != j) goto _L5; else goto _L4
_L4:
            FaceSwitcherDialog.b(a).setSeletectFacePosition(i);
            view = FaceSwitcherDialog.DismissType.b;
_L7:
            FaceSwitcherDialog.b(a).post(new FaceSwitcherDialog._cls7._cls1(this, view, i));
            return true;
_L5:
            view = motionevent;
            if (j >= 0)
            {
                FaceSwitcherDialog.b(a).setHoveredFacePosition(-1);
                view = motionevent;
            }
            if (true) goto _L7; else goto _L6
_L6:
        }

            
            {
                a = faceswitcherdialog;
                super();
            }
    }

}
