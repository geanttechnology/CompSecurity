// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.sharing;

import com.poshmark.utils.sharing.share_states.ShareState;

// Referenced classes of package com.poshmark.utils.sharing:
//            FSMTransition

public abstract class PM_State_Machine
{
    public static final class STATE_COMPLETION_RESULT extends Enum
    {

        private static final STATE_COMPLETION_RESULT $VALUES[];
        public static final STATE_COMPLETION_RESULT CANCEL;
        public static final STATE_COMPLETION_RESULT FAILED;
        public static final STATE_COMPLETION_RESULT OK;

        public static STATE_COMPLETION_RESULT valueOf(String s)
        {
            return (STATE_COMPLETION_RESULT)Enum.valueOf(com/poshmark/utils/sharing/PM_State_Machine$STATE_COMPLETION_RESULT, s);
        }

        public static STATE_COMPLETION_RESULT[] values()
        {
            return (STATE_COMPLETION_RESULT[])$VALUES.clone();
        }

        static 
        {
            OK = new STATE_COMPLETION_RESULT("OK", 0);
            FAILED = new STATE_COMPLETION_RESULT("FAILED", 1);
            CANCEL = new STATE_COMPLETION_RESULT("CANCEL", 2);
            $VALUES = (new STATE_COMPLETION_RESULT[] {
                OK, FAILED, CANCEL
            });
        }

        private STATE_COMPLETION_RESULT(String s, int i)
        {
            super(s, i);
        }
    }


    ShareState currentState;
    FSMTransition transitions;

    public PM_State_Machine()
    {
        transitions = new FSMTransition();
    }
}
