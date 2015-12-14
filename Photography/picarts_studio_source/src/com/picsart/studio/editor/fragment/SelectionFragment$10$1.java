// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.app.Activity;
import android.graphics.Bitmap;
import com.socialin.android.photo.freecrop.b;
import com.socialin.android.photo.freecrop.c;
import com.socialin.android.photo.imgop.ImageOpCommon;
import com.socialin.android.photo.select.SelectionDrawController;
import java.nio.ByteBuffer;
import java.util.ArrayList;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            SelectionFragment

final class a
    implements Runnable
{

    private a a;

    public final void run()
    {
        boolean flag = false;
        a.a.position(0);
        SelectionFragment.p(a.a).b.copyPixelsFromBuffer(a.a);
        SelectionFragment.a(a.a);
        SelectionFragment.a(a.a, false);
        SelectionFragment.p(a.a).a();
        b b1 = SelectionFragment.p(a.a).l;
        c c1 = new c(b1);
        c1.d = 3;
        b1.a.add(c1);
        if (!b1.b)
        {
            flag = true;
        }
        b1.b = flag;
        SelectionFragment.A(a.a);
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/picsart/studio/editor/fragment/SelectionFragment$10

/* anonymous class */
    final class SelectionFragment._cls10
        implements Runnable
    {

        final ByteBuffer a;
        final SelectionFragment b;
        private int c;
        private int d;

        public final void run()
        {
            ImageOpCommon.invertRedMask(a, c, d);
            Activity activity = b.getActivity();
            if (activity == null || activity.isFinishing())
            {
                SelectionFragment.a(a);
                return;
            } else
            {
                activity.runOnUiThread(new SelectionFragment._cls10._cls1(this));
                return;
            }
        }

            
            {
                b = selectionfragment;
                a = bytebuffer;
                c = i;
                d = j;
                super();
            }
    }

}
