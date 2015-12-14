// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.app.Activity;
import com.picsart.studio.editor.activity.EditorActivity;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            b

final class a
    implements Runnable
{

    private Activity.e a;

    public final void run()
    {
        if (a.a.getView() != null)
        {
            Activity activity = a.a.getActivity();
            if (activity != null)
            {
                ((EditorActivity)activity).e();
            }
        }
    }

    Activity(Activity activity)
    {
        a = activity;
        super();
    }

    // Unreferenced inner class com/picsart/studio/editor/fragment/b$1

/* anonymous class */
    final class b._cls1
        implements Runnable
    {

        final b a;

        public final void run()
        {
            Activity activity = a.getActivity();
            if (activity != null && !activity.isFinishing())
            {
                activity.runOnUiThread(new b._cls1._cls1(this));
            }
        }

            
            {
                a = b1;
                super();
            }
    }

}
