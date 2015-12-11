// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.sharing;

import com.poshmark.utils.ShareManager;
import com.poshmark.utils.sharing.share_states.Finish;
import com.poshmark.utils.sharing.share_states.GetLocalContent;
import com.poshmark.utils.sharing.share_states.GetServerContent;
import com.poshmark.utils.sharing.share_states.ShareState;
import com.poshmark.utils.sharing.share_states.ShareToFollowersInit;
import com.poshmark.utils.sharing.share_states.ShareToFollowersShare;

// Referenced classes of package com.poshmark.utils.sharing:
//            PM_State_Machine, StateCompletionListener, FSMTransition

public class ShareToFollowersStateMachine extends PM_State_Machine
    implements StateCompletionListener
{

    ShareManager shareManager;

    public ShareToFollowersStateMachine(ShareManager sharemanager)
    {
        shareManager = sharemanager;
        transitions.addStateObject(new ShareToFollowersInit(this, sharemanager));
        transitions.addStateObject(new GetServerContent(this, sharemanager));
        transitions.addStateObject(new GetLocalContent(this, sharemanager));
        transitions.addStateObject(new ShareToFollowersShare(this, sharemanager));
        transitions.addStateObject(new Finish(this, sharemanager));
        transitions.addTransition(ShareToFollowersInit.id, GetServerContent.id, FSMTransition.CONDITION.OK);
        transitions.addTransition(GetServerContent.id, ShareToFollowersShare.id, FSMTransition.CONDITION.OK);
        transitions.addTransition(GetServerContent.id, GetLocalContent.id, FSMTransition.CONDITION.FAIL);
        transitions.addTransition(GetLocalContent.id, ShareToFollowersShare.id, FSMTransition.CONDITION.OK);
        transitions.addTransition(ShareToFollowersShare.id, Finish.id, FSMTransition.CONDITION.OK);
        currentState = transitions.getState(ShareToFollowersInit.id);
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
