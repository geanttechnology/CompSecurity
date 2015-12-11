// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.request_team_member;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.target.ui.view.DepartmentAdjacencyBadgeView;
import com.target.ui.view.TargetButton;
import com.target.ui.view.a;
import com.target.ui.view.common.PulseView;
import com.target.ui.view.common.TargetErrorView;

// Referenced classes of package com.target.ui.fragment.request_team_member:
//            RequestTeamMemberDialogFragment

static class rootView extends a
{

    TargetButton actionButton;
    RelativeLayout buttonContainer;
    TargetButton cancelButton;
    ImageView headerImage;
    View listDivider;
    DepartmentAdjacencyBadgeView mBadgeView;
    TargetErrorView mErrorView;
    View progressContainer;
    PulseView pulseView;
    RecyclerView recyclerView;
    final View rootView;
    TextView tvRequestTeamMemberExplaination;
    TextView tvRequestTeamMemberHeader;
    TextView tvRequestTeamMemberTitle;

    public (View view)
    {
        super(view);
        rootView = view;
    }
}
