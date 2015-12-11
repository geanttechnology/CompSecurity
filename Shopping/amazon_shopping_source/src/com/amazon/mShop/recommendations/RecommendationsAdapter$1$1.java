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

class val.view
    implements android.widget.ener
{

    final val.view this$1;
    final View val$view;

    public void onItemClick(AdapterView adapterview, View view1, int i, long l)
    {
        RecommendationsAdapter.access$000(_fld0).dismiss();
        if (i == 0)
        {
            RefMarkerObserver.logRefMarker("recs_o");
            removeItemAndRefreshUI(_fld0, Integer.parseInt(val$view.getTag().toString()), 0);
        } else
        if (i == 1)
        {
            RefMarkerObserver.logRefMarker("recs_ni");
            removeItemAndRefreshUI(_fld0, Integer.parseInt(val$view.getTag().toString()), 1);
            return;
        }
    }

    is._cls0()
    {
        this$1 = final__pcls0;
        val$view = View.this;
        super();
    }

    // Unreferenced inner class com/amazon/mShop/recommendations/RecommendationsAdapter$1

/* anonymous class */
    class RecommendationsAdapter._cls1
        implements android.view.View.OnClickListener
    {

        final RecommendationsAdapter this$0;

        public void onClick(View view1)
        {
            if (RecommendationsAdapter.access$000(RecommendationsAdapter.this) == null || !RecommendationsAdapter.access$000(RecommendationsAdapter.this).isShowing())
            {
                Object obj = new com.amazon.mShop.AmazonAlertDialog.Builder(RecommendationsAdapter.access$100(RecommendationsAdapter.this));
                RecommendationsAdapter.access$002(RecommendationsAdapter.this, ((com.amazon.mShop.AmazonAlertDialog.Builder) (obj)).create());
                obj = new ArrayAdapter(RecommendationsAdapter.access$100(RecommendationsAdapter.this), com.amazon.mShop.android.lib.R.layout.select_dialog_item);
                ((ArrayAdapter) (obj)).add(RecommendationsAdapter.access$100(RecommendationsAdapter.this).getString(com.amazon.mShop.android.lib.R.string.recommendations_item_ownit));
                ((ArrayAdapter) (obj)).add(RecommendationsAdapter.access$100(RecommendationsAdapter.this).getString(com.amazon.mShop.android.lib.R.string.recommendations_item_notinterest));
                AmazonAlertDialog.customizeAlertDialog(RecommendationsAdapter.access$100(RecommendationsAdapter.this), RecommendationsAdapter.access$000(RecommendationsAdapter.this), RecommendationsAdapter.access$100(RecommendationsAdapter.this).getString(com.amazon.mShop.android.lib.R.string.recommendations_fix_this), ((android.widget.ListAdapter) (obj)), view1. new RecommendationsAdapter._cls1._cls1(), -1);
                RecommendationsAdapter.access$000(RecommendationsAdapter.this).setCanceledOnTouchOutside(true);
                RecommendationsAdapter.access$000(RecommendationsAdapter.this).show();
            }
        }

            
            {
                this$0 = RecommendationsAdapter.this;
                super();
            }
    }

}
