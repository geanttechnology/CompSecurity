// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.sharing;

import com.poshmark.utils.ShareManager;
import com.poshmark.utils.sharing.share_states.Finish;
import com.poshmark.utils.sharing.share_states.ShareState;
import com.poshmark.utils.sharing.share_states.ShareToPartyInit;
import com.poshmark.utils.sharing.share_states.ShareToPartyShare;

// Referenced classes of package com.poshmark.utils.sharing:
//            PM_State_Machine, StateCompletionListener, FSMTransition

public class ShareToPartyStateMachine extends PM_State_Machine
    implements StateCompletionListener
{

    ShareManager shareManager;

    public ShareToPartyStateMachine(ShareManager sharemanager)
    {
        shareManager = sharemanager;
        transitions.addStateObject(new ShareToPartyInit(this, sharemanager));
        transitions.addStateObject(new ShareToPartyShare(this, sharemanager));
        transitions.addStateObject(new Finish(this, sharemanager));
        transitions.addTransition(ShareToPartyInit.id, ShareToPartyShare.id, FSMTransition.CONDITION.OK);
        transitions.addTransition(ShareToPartyShare.id, Finish.id, FSMTransition.CONDITION.OK);
        currentState = transitions.getState(ShareToPartyInit.id);
    }

    public void init()
    {
        currentState.executeState();
    }

    public void stateCompleted()
    {
        if (currentState != null)
        {
            currentState = transitions.getNextState(currentState.getId(), FSMTransition.CONDITION.OK);
            if (currentState != null)
            {
                currentState.executeState();
            }
        }
    }

    public void stateFailed()
    {
        if (currentState != null)
        {
            currentState = transitions.getNextState(currentState.getId(), FSMTransition.CONDITION.FAIL);
            if (currentState != null)
            {
                currentState.executeState();
            }
        }
    }
}
