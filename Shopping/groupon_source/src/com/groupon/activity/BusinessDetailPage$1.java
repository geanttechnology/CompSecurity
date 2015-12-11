// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Context;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.groupon.db.models.Business;
import com.groupon.loader.BusinessDetailLoaderCallbacks;
import com.groupon.view.ObservableScrollView;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            BusinessDetailPage

class lbacks extends BusinessDetailLoaderCallbacks
{

    final BusinessDetailPage this$0;

    public void onMerchantDetailLoaded(Business business)
    {
        if (BusinessDetailPage.access$000(BusinessDetailPage.this) == 0)
        {
            BusinessDetailPage.access$002(BusinessDetailPage.this, 1);
        } else
        if (business != null)
        {
            BusinessDetailPage.access$102(BusinessDetailPage.this, business);
            if (Strings.isEmpty(isRatingsClicked))
            {
                progressBar.setVisibility(8);
                businessContent.setVisibility(0);
                scrollView.post(new Runnable() {

                    final BusinessDetailPage._cls1 this$1;

                    public void run()
                    {
                        if (BusinessDetailPage.access$200(this$0))
                        {
                            scrollView.smoothScrollTo(0, 0);
                            BusinessDetailPage.access$202(this$0, false);
                        }
                    }

            
            {
                this$1 = BusinessDetailPage._cls1.this;
                super();
            }
                });
            }
            BusinessDetailPage.access$300(BusinessDetailPage.this, business);
            initActionBar(null);
            return;
        }
    }

    _cls1.this._cls1(Context context, String s)
    {
        this$0 = BusinessDetailPage.this;
        super(context, s);
    }
}
