// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.view.MenuItem;
import com.gotv.crackle.data.VideoDubSubtitleProcessor;
import com.gotv.crackle.model.MediaDetailsItem;
import java.util.Map;

// Referenced classes of package com.gotv.crackle:
//            ChromeCastingDetailsActivity

class this._cls1
    implements Runnable
{

    final is._cls0 this$1;

    public void run()
    {
        ChromeCastingDetailsActivity.access$1100(_fld0).setVisible(true);
        ChromeCastingDetailsActivity.access$1202(_fld0, true);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/gotv/crackle/ChromeCastingDetailsActivity$2

/* anonymous class */
    class ChromeCastingDetailsActivity._cls2
        implements com.gotv.crackle.data.DataRequest.DataRequestListener
    {

        final ChromeCastingDetailsActivity this$0;

        public void onDataFailed(String s, String s1)
        {
        }

        public void onDataSuccess(String s)
        {
            s = ChromeCastingDetailsActivity.access$1000(ChromeCastingDetailsActivity.this).getCurrentItem();
            ChromeCastingDetailsActivity.access$1000(ChromeCastingDetailsActivity.this).setCurrentLanguage(s.getLocalizedLanguage());
            if (s.getClosedCaptionFiles().size() > 0 || ChromeCastingDetailsActivity.access$1000(ChromeCastingDetailsActivity.this).getCurrentItem().IsDubbed())
            {
                runOnUiThread(new ChromeCastingDetailsActivity._cls2._cls1());
            }
        }

            
            {
                this$0 = ChromeCastingDetailsActivity.this;
                super();
            }
    }

}
