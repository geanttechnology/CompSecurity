// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.view;

import android.app.Activity;
import android.app.Fragment;
import com.ebay.nautilus.kernel.content.ResultStatus;

// Referenced classes of package com.ebay.common.view:
//            EbayErrorHandler

public static class HandleState
{
    public static final class HandleState extends Enum
    {

        private static final HandleState $VALUES[];
        public static final HandleState DefaultHandling;
        public static final HandleState Handled;
        public static final HandleState Ignored;

        public static HandleState valueOf(String s)
        {
            return (HandleState)Enum.valueOf(com/ebay/common/view/EbayErrorHandler$OverrideHandler$HandleState, s);
        }

        public static HandleState[] values()
        {
            return (HandleState[])$VALUES.clone();
        }

        static 
        {
            DefaultHandling = new HandleState("DefaultHandling", 0);
            Handled = new HandleState("Handled", 1);
            Ignored = new HandleState("Ignored", 2);
            $VALUES = (new HandleState[] {
                DefaultHandling, Handled, Ignored
            });
        }

        private HandleState(String s, int i)
        {
            super(s, i);
        }
    }


    public HandleState handleError(Activity activity, Fragment fragment, int i, ResultStatus resultstatus)
    {
        return HandleState.DefaultHandling;
    }

    public HandleState handleWarning(Activity activity, Fragment fragment, int i, ResultStatus resultstatus)
    {
        return HandleState.DefaultHandling;
    }

    public HandleState()
    {
    }
}
