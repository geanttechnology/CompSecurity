// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.sharing;

import com.poshmark.utils.ShareManager;
import com.poshmark.utils.sharing.share_states.EmailShare;
import com.poshmark.utils.sharing.share_states.Finish;
import com.poshmark.utils.sharing.share_states.GetLocalContent;
import com.poshmark.utils.sharing.share_states.GetServerContent;
import com.poshmark.utils.sharing.share_states.ShareState;

// Referenced classes of package com.poshmark.utils.sharing:
//            PM_State_Machine, StateCompletionListener, FSMTransition

public class EmailShareStateMachine extends PM_State_Machine
    implements StateCompletionListener
{

    ShareManager shareManager;

    public EmailShareStateMachine(ShareManager sharemanager)
    {
        shareManager = sharemanager;
        transitions.addStateObject(new EmailShare(this, sharemanager));
        transitions.addStateObject(new GetServerContent(this, sharemanager));
        transitions.addStateObject(new GetLocalContent(this, sharemanager));
        transitions.addStateObject(new Finish(this, sharemanager));
        transitions.addTransition(GetServerContent.id, EmailShare.id, FSMTransition.CONDITION.OK);
        transitions.addTransition(GetServerContent.id, GetLocalContent.id, FSMTransition.CONDITION.FAIL);
        transitions.addTransition(GetLocalContent.id, EmailShare.id, FSMTransition.CONDITION.OK);
        transitions.addTransition(EmailShare.id, Finish.id, FSMTransition.CONDITION.OK);
        currentState = transitions.getState(GetServerContent.id);
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
