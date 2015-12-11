// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities.transitions;

import android.content.Intent;
import com.digidust.elokence.akinator.activities.HomeActivity;
import com.digidust.elokence.akinator.activities.PropositionPotionActivity;

public class HomeTransition
{

    HomeActivity activity;

    public HomeTransition(HomeActivity homeactivity)
    {
        activity = homeactivity;
    }

    public void displayAchatPotion()
    {
        Intent intent = new Intent(activity, com/digidust/elokence/akinator/activities/PropositionPotionActivity);
        intent.putExtra("potion", "ultime");
        activity.startActivity(intent);
        activity.disableAdOneTime();
    }
}
