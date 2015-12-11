// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.view.viewholder;

import android.text.Html;
import android.view.View;
import android.widget.TextView;
import com.groupon.mvc.model.AdditionalInfo;

// Referenced classes of package com.groupon.mvc.view.viewholder:
//            RecyclerItemViewHolder

public class AdditionalInfoViewHolder extends RecyclerItemViewHolder
{

    TextView additionalInfoView;

    public AdditionalInfoViewHolder(View view)
    {
        super(view);
    }

    public void populateViews()
    {
        additionalInfoView.setText(Html.fromHtml(((AdditionalInfo)model).storesInfoHtml));
    }
}
