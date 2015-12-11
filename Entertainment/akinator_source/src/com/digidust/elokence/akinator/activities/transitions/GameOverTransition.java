// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities.transitions;

import android.content.Intent;
import com.digidust.elokence.akinator.activities.GameOverActivity;
import com.digidust.elokence.akinator.activities.PropositionPotionActivity;

public class GameOverTransition
{

    public static final int POTION_ULTIME_REQUEST_CODE = 1000;
    GameOverActivity activity;

    public GameOverTransition(GameOverActivity gameoveractivity)
    {
        activity = gameoveractivity;
    }

    public void displayUltimatePotion()
    {
        Intent intent = new Intent(activity, com/digidust/elokence/akinator/activities/PropositionPotionActivity);
        intent.putExtra("potion", "ultime");
        activity.startActivityForResult(intent, 1000);
    }
}
