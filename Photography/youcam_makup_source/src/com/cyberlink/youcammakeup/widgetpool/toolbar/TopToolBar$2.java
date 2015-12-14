// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.toolbar;

import android.view.View;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.activity.f;
import com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.MakeupMode;
import com.cyberlink.youcammakeup.utility.o;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.toolbar:
//            TopToolBar

class a
    implements android.view.istener
{

    final TopToolBar a;

    public void onClick(View view)
    {
        view = Globals.d().t();
        if (view != null)
        {
            view.d(false);
        }
        b.a(new YMKSavingPageEvent(YMKSavingPageEvent.b, System.currentTimeMillis(), com.cyberlink.youcammakeup.clflurry.Event.Operation.a, false, false));
        break MISSING_BLOCK_LABEL_37;
label0:
        while (true) 
        {
            do
            {
                do
                {
                    return;
                } while (!StatusManager.j().E().booleanValue() || Globals.d().i().a());
                a.a(Boolean.valueOf(true));
                if (StatusManager.j().r() != MakeupMode.a)
                {
                    continue;
                }
                view = Globals.d().t();
                if (StatusManager.j().o() == "editView" && view != null)
                {
                    view.a(new f() {

                        final TopToolBar._cls2 a;

                        public void a()
                        {
                            a.a.a(Boolean.valueOf(false));
                        }

            
            {
                a = TopToolBar._cls2.this;
                super();
            }
                    });
                    return;
                }
                continue label0;
            } while (a.b() || com.cyberlink.youcammakeup.widgetpool.toolbar.TopToolBar.b(a));
            view = Globals.d().t();
            if (StatusManager.j().o() == "editView" && view != null)
            {
                view.I();
                a.a(Boolean.valueOf(false));
                return;
            }
        }
    }

    _cls1.a(TopToolBar toptoolbar)
    {
        a = toptoolbar;
        super();
    }
}
