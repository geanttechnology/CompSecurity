// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities.transitions;

import android.content.Intent;
import com.digidust.elokence.akinator.activities.AkActivity;
import com.digidust.elokence.akinator.activities.PropositionPotionActivity2;

public class TransitionToStore
{

    public static final int requestCodePopu = 667;
    public static final int requestCodeStore = 666;
    AkActivity activity;

    public TransitionToStore(AkActivity akactivity)
    {
        activity = akactivity;
    }

    public void goToPotionPopu()
    {
        Intent intent = new Intent(activity, com/digidust/elokence/akinator/activities/PropositionPotionActivity2);
        intent.putExtra("potion", "survitamine");
        activity.startActivityForResult(intent, 667);
    }
}
