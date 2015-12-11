// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.recommendations;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.AmazonAlertDialog;
import com.amazon.mShop.net.RefMarkerObserver;

// Referenced classes of package com.amazon.mShop.recommendations:
//            RecommendationsAdapter

class this._cls0
    implements android.view.mendationsAdapter._cls1
{

    final RecommendationsAdapter this$0;

    public void onClick(final View view)
    {
        if (RecommendationsAdapter.access$000(RecommendationsAdapter.this) == null || !RecommendationsAdapter.access$000(RecommendationsAdapter.this).isShowing())
        {
            Object obj = new com.amazon.mShop.(RecommendationsAdapter.access$100(RecommendationsAdapter.this));
            RecommendationsAdapter.access$002(RecommendationsAdapter.this, ((com.amazon.mShop.) (obj)).create());
            obj = new ArrayAdapter(RecommendationsAdapter.access$100(RecommendationsAdapter.this), com.amazon.mShop.android.lib.em);
            ((ArrayAdapter) (obj)).add(RecommendationsAdapter.access$100(RecommendationsAdapter.this).getString(com.amazon.mShop.android.lib.item_ownit));
            ((ArrayAdapter) (obj)).add(RecommendationsAdapter.access$100(RecommendationsAdapter.this).getString(com.amazon.mShop.android.lib.item_notinterest));
            AmazonAlertDialog.customizeAlertDialog(RecommendationsAdapter.access$100(RecommendationsAdapter.this), RecommendationsAdapter.access$000(RecommendationsAdapter.this), RecommendationsAdapter.access$100(RecommendationsAdapter.this).getString(com.amazon.mShop.android.lib.fix_this), ((android.widget.ListAdapter) (obj)), new android.widget.AdapterView.OnItemClickListener() {

                final RecommendationsAdapter._cls1 this$1;
                final View val$view;

                public void onItemClick(AdapterView adapterview, View view1, int i, long l)
                {
                    RecommendationsAdapter.access$000(this$0).dismiss();
                    if (i == 0)
                    {
                        RefMarkerObserver.logRefMarker("recs_o");
                        removeItemAndRefreshUI(this$0, Integer.parseInt(view.getTag().toString()), 0);
                    } else
                    if (i == 1)
                    {
                        RefMarkerObserver.logRefMarker("recs_ni");
                        removeItemAndRefreshUI(this$0, Integer.parseInt(view.getTag().toString()), 1);
                        return;
                    }
                }

            
            {
                this$1 = RecommendationsAdapter._cls1.this;
                view = view1;
                super();
            }
            }, -1);
            RecommendationsAdapter.access$000(RecommendationsAdapter.this).setCanceledOnTouchOutside(true);
            RecommendationsAdapter.access$000(RecommendationsAdapter.this).show();
        }
    }

    _cls1.val.view()
    {
        this$0 = RecommendationsAdapter.this;
        super();
    }
}
