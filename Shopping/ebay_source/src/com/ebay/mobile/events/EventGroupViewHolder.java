// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.events;

import android.view.View;
import android.widget.TextView;
import com.ebay.mobile.common.view.ViewHolder;
import com.ebay.mobile.common.view.ViewModel;

// Referenced classes of package com.ebay.mobile.events:
//            EventGroupViewModel

public class EventGroupViewHolder extends ViewHolder
{

    private final TextView name;

    public EventGroupViewHolder(View view)
    {
        super(view);
        name = (TextView)itemView.findViewById(0x7f1000ce);
    }

    public static boolean isValidModel(ViewModel viewmodel, boolean flag, boolean flag1)
    {
        if (!(viewmodel instanceof EventGroupViewModel))
        {
            return false;
        } else
        {
            return isNotEmpty(new CharSequence[] {
                ((EventGroupViewModel)viewmodel).name
            });
        }
    }

    public void bind(ViewModel viewmodel)
    {
        super.bind(viewmodel);
        if (viewmodel instanceof EventGroupViewModel)
        {
            viewmodel = (EventGroupViewModel)viewmodel;
            name.setText(((EventGroupViewModel) (viewmodel)).name);
        }
    }
}
