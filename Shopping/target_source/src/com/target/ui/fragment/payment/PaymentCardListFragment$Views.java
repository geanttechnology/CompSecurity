// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.payment;

import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.target.ui.view.a;
import com.target.ui.view.common.TargetErrorView;

// Referenced classes of package com.target.ui.fragment.payment:
//            PaymentCardListFragment

static class  extends a
{

    Button doneButton;
    View emptyListContainer;
    TextView emptyListPrimaryHint;
    TextView emptyListSecondaryHint;
    TargetErrorView errorContainer;
    View listContainer;
    ListView paymentCardList;

    (View view)
    {
        super(view);
    }
}
