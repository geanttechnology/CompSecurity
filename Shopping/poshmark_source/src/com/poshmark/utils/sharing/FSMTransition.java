// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.sharing;

import com.poshmark.utils.sharing.share_states.ShareState;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class FSMTransition
{
    public static final class CONDITION extends Enum
    {

        private static final CONDITION $VALUES[];
        public static final CONDITION FAIL;
        public static final CONDITION OK;

        public static CONDITION valueOf(String s)
        {
            return (CONDITION)Enum.valueOf(com/poshmark/utils/sharing/FSMTransition$CONDITION, s);
        }

        public static CONDITION[] values()
        {
            return (CONDITION[])$VALUES.clone();
        }

        static 
        {
            OK = new CONDITION("OK", 0);
            FAIL = new CONDITION("FAIL", 1);
            $VALUES = (new CONDITION[] {
                OK, FAIL
            });
        }

        private CONDITION(String s, int i)
        {
            super(s, i);
        }
    }


    public Map allStates;
    Map transitionMap_FAIL;
    Map transitionMap_OK;

    FSMTransition()
    {
        allStates = new HashMap();
        transitionMap_OK = new HashMap();
        transitionMap_FAIL = new HashMap();
    }

    public void addStateObject(ShareState sharestate)
    {
        allStates.put(sharestate.getId(), sharestate);
    }

    public void addTransition(UUID uuid, UUID uuid1, CONDITION condition)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$poshmark$utils$sharing$FSMTransition$CONDITION[];

            static 
            {
                $SwitchMap$com$poshmark$utils$sharing$FSMTransition$CONDITION = new int[CONDITION.values().length];
                try
                {
                    $SwitchMap$com$poshmark$utils$sharing$FSMTransition$CONDITION[CONDITION.OK.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$sharing$FSMTransition$CONDITION[CONDITION.FAIL.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.poshmark.utils.sharing.FSMTransition.CONDITION[condition.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            transitionMap_OK.put(uuid, uuid1);
            return;

        case 2: // '\002'
            transitionMap_FAIL.put(uuid, uuid1);
            break;
        }
    }

    public ShareState getNextState(UUID uuid, CONDITION condition)
    {
        switch (_cls1..SwitchMap.com.poshmark.utils.sharing.FSMTransition.CONDITION[condition.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            uuid = (UUID)transitionMap_OK.get(uuid);
            return (ShareState)allStates.get(uuid);

        case 2: // '\002'
            uuid = (UUID)transitionMap_FAIL.get(uuid);
            break;
        }
        return (ShareState)allStates.get(uuid);
    }

    public ShareState getState(UUID uuid)
    {
        return (ShareState)allStates.get(uuid);
    }
}
