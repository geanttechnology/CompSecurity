// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.triggers;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.poshmark.application.PMApplication;
import com.poshmark.application.PMApplicationSession;

public abstract class PMTrigger
{
    public static final class TriggerState extends Enum
    {

        private static final TriggerState $VALUES[];
        public static final TriggerState DISMISSED;
        public static final TriggerState IGNORED;
        public static final TriggerState INITIAL;
        public static final TriggerState INTERACTED;

        public static TriggerState valueOf(String s)
        {
            return (TriggerState)Enum.valueOf(com/poshmark/triggers/PMTrigger$TriggerState, s);
        }

        public static TriggerState[] values()
        {
            return (TriggerState[])$VALUES.clone();
        }

        static 
        {
            INITIAL = new TriggerState("INITIAL", 0);
            IGNORED = new TriggerState("IGNORED", 1);
            DISMISSED = new TriggerState("DISMISSED", 2);
            INTERACTED = new TriggerState("INTERACTED", 3);
            $VALUES = (new TriggerState[] {
                INITIAL, IGNORED, DISMISSED, INTERACTED
            });
        }

        private TriggerState(String s, int i)
        {
            super(s, i);
        }
    }


    int currentCount;
    TriggerState currentState;
    SharedPreferences savedTriggers;

    public PMTrigger()
    {
        currentState = TriggerState.INITIAL;
        currentCount = 0;
    }

    public abstract void fetchTriggerFromPrefs();

    public TriggerState getCurrentState()
    {
        return currentState;
    }

    public abstract int getThresholdForState(TriggerState triggerstate);

    public void incrementViewCount()
    {
        int i = getThresholdForState(currentState);
        if (currentCount + 1 <= i)
        {
            currentCount = currentCount + 1;
        }
    }

    protected void initPrefsObject()
    {
        if (savedTriggers == null)
        {
            String s = PMApplicationSession.GetPMSession().getUserId();
            if (s != null)
            {
                Context context = PMApplication.getContext();
                s = (new StringBuilder()).append(s).append("_Triggers").toString();
                PMApplication.getContext();
                savedTriggers = context.getSharedPreferences(s, 0);
            }
        }
    }

    public abstract boolean isValid();

    protected void saveTrigger()
    {
        if (savedTriggers != null)
        {
            String s = getClass().toString();
            android.content.SharedPreferences.Editor editor = savedTriggers.edit();
            editor.putInt((new StringBuilder()).append(s).append("_count").toString(), currentCount);
            editor.putString((new StringBuilder()).append(s).append("_state").toString(), currentState.toString());
            editor.commit();
            s = savedTriggers.getString((new StringBuilder()).append(s).append("_state").toString(), null);
            if (s != null)
            {
                Log.d("Saved TRigger", s);
            }
        }
    }

    public void setNewState(TriggerState triggerstate)
    {
        currentState = triggerstate;
        currentCount = 0;
        saveTrigger();
    }

    public abstract boolean shouldFireTrigger();
}
