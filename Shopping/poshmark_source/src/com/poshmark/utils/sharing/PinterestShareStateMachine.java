// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.sharing;

import com.poshmark.utils.ShareManager;
import com.poshmark.utils.sharing.share_states.Finish;
import com.poshmark.utils.sharing.share_states.GetLocalContent;
import com.poshmark.utils.sharing.share_states.GetServerContent;
import com.poshmark.utils.sharing.share_states.PinterestConnect;
import com.poshmark.utils.sharing.share_states.PinterestShare;
import com.poshmark.utils.sharing.share_states.PinterestShareFinish;
import com.poshmark.utils.sharing.share_states.ShareState;

// Referenced classes of package com.poshmark.utils.sharing:
//            PM_State_Machine, StateCompletionListener, FSMTransition

public class PinterestShareStateMachine extends PM_State_Machine
    implements StateCompletionListener
{

    ShareManager shareManager;

    public PinterestShareStateMachine(ShareManager sharemanager)
    {
        shareManager = sharemanager;
        transitions.addStateObject(new PinterestConnect(this, sharemanager));
        transitions.addStateObject(new GetServerContent(this, sharemanager));
        transitions.addStateObject(new GetLocalContent(this, sharemanager));
        transitions.addStateObject(new PinterestShare(this, sharemanager));
        transitions.addStateObject(new PinterestShareFinish(this, sharemanager));
        transitions.addTransition(PinterestConnect.id, GetServerContent.id, FSMTransition.CONDITION.OK);
        transitions.addTransition(GetServerContent.id, GetLocalContent.id, FSMTransition.CONDITION.FAIL);
        transitions.addTransition(GetServerContent.id, PinterestShare.id, FSMTransition.CONDITION.OK);
        transitions.addTransition(GetLocalContent.id, PinterestShare.id, FSMTransition.CONDITION.OK);
        transitions.addTransition(PinterestShare.id, PinterestShareFinish.id, FSMTransition.CONDITION.OK);
        transitions.addTransition(PinterestShareFinish.id, Finish.id, FSMTransition.CONDITION.OK);
        currentState = transitions.getState(PinterestConnect.id);
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
