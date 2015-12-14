// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.app.Activity;
import android.view.View;
import com.socialin.android.photo.select.SelectionDrawController;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            SelectionFragment

final class a
    implements Runnable
{

    private a a;

    public final void run()
    {
        SelectionFragment.a(a.a, false);
        SelectionFragment.p(a.a).q();
        SelectionFragment.p(a.a).t.invalidate();
        SelectionFragment.A(a.a);
        if (SelectionFragment.p(a.a).n == com.socialin.android.photo.select..FILL_TYPE.CLEAR)
        {
            SelectionFragment.p(a.a).a(com.socialin.android.photo.select..FILL_TYPE.ADD);
            SelectionFragment.z(a.a);
        }
    }

    FILL_TYPE(FILL_TYPE fill_type)
    {
        a = fill_type;
        super();
    }

    // Unreferenced inner class com/picsart/studio/editor/fragment/SelectionFragment$13

/* anonymous class */
    final class SelectionFragment._cls13
        implements Runnable
    {

        final SelectionFragment a;

        public final void run()
        {
            Activity activity = a.getActivity();
            if (activity == null || activity.isFinishing())
            {
                return;
            } else
            {
                activity.runOnUiThread(new SelectionFragment._cls13._cls1(this));
                return;
            }
        }

            
            {
                a = selectionfragment;
                super();
            }
    }

}
