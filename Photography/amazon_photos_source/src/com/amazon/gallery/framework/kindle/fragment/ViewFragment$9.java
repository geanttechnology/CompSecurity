// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.fragment;

import android.app.Activity;
import com.amazon.gallery.framework.kindle.provider.MediaContentConfiguration;
import com.amazon.gallery.thor.app.activity.ThorActionBar;

// Referenced classes of package com.amazon.gallery.framework.kindle.fragment:
//            ViewFragment

class val.thorActionBar
    implements Runnable
{

    final ViewFragment this$0;
    final ThorActionBar val$thorActionBar;

    public void run()
    {
        android.support.v4.app.FragmentActivity fragmentactivity = getActivity();
        if (fragmentactivity == null)
        {
            return;
        } else
        {
            fragmentactivity.runOnUiThread(new Runnable() {

                final ViewFragment._cls9 this$1;

                public void run()
                {
                    if (!thorActionBar.isDestroyed())
                    {
                        thorActionBar.updateHeaderOptions(contentConfiguration.toViewDescriptor(), null);
                        thorActionBar.viewStateChanged(contentConfiguration.toViewDescriptor());
                    }
                }

            
            {
                this$1 = ViewFragment._cls9.this;
                super();
            }
            });
            return;
        }
    }

    _cls1.this._cls1()
    {
        this$0 = final_viewfragment;
        val$thorActionBar = ThorActionBar.this;
        super();
    }
}
