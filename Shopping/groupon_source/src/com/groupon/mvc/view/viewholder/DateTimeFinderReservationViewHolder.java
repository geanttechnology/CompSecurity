// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.view.viewholder;

import android.view.View;
import android.widget.TextView;
import com.groupon.mvc.model.DateTimeFinderReservation;

// Referenced classes of package com.groupon.mvc.view.viewholder:
//            RecyclerItemViewHolder

public class DateTimeFinderReservationViewHolder extends RecyclerItemViewHolder
{

    TextView reservationBody;
    TextView reservationHeader;

    public DateTimeFinderReservationViewHolder(View view)
    {
        super(view);
    }

    public void populateViews()
    {
        reservationHeader.setText(((DateTimeFinderReservation)model).headerText);
        reservationBody.setText(((DateTimeFinderReservation)model).bodyText);
        itemView.setOnClickListener((android.view.View.OnClickListener)callback);
    }
}
