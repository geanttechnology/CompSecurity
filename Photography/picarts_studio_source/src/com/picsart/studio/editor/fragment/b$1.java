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

    final b a;

    public final void run()
    {
        Activity activity = a.getActivity();
        if (activity != null && !activity.isFinishing())
        {
            activity.runOnUiThread(new Runnable() {

                private b._cls1 a;

                public final void run()
                {
                    if (a.a.getView() != null)
                    {
                        Activity activity1 = a.a.getActivity();
                        if (activity1 != null)
                        {
                            ((EditorActivity)activity1).e();
                        }
                    }
                }

            
            {
                a = b._cls1.this;
                super();
            }
            });
        }
    }

    _cls1.a(b b1)
    {
        a = b1;
        super();
    }
}
