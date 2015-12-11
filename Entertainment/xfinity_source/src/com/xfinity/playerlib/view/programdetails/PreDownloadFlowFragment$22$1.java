// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import com.comcast.cim.cmasl.utils.provider.Provider;
import com.comcast.cim.model.parentalcontrols.ParentalControlsPin;
import com.xfinity.playerlib.view.common.ParentalControlPinFragment;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            PreDownloadFlowFragment

class this._cls1
    implements com.comcast.cim.android.view.common.r
{

    final Complete this$1;

    public void validatePin(String s, com.comcast.cim.android.view.common.onCompletedListener oncompletedlistener)
    {
        boolean flag = (new ParentalControlsPin(s)).equals(pin);
        if (flag)
        {
            PreDownloadFlowFragment.access$3600(_fld0);
        }
        oncompletedlistener.onPinValidationComplete(flag);
    }

    l.pin()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$22

/* anonymous class */
    class PreDownloadFlowFragment._cls22
        implements Provider
    {

        final PreDownloadFlowFragment this$0;
        final ParentalControlsPin val$pin;

        public ParentalControlPinFragment get()
        {
            ParentalControlPinFragment parentalcontrolpinfragment = new ParentalControlPinFragment();
            parentalcontrolpinfragment.setPinValidator(new PreDownloadFlowFragment._cls22._cls1());
            parentalcontrolpinfragment.setOnCancelListener(PreDownloadFlowFragment.access$700(PreDownloadFlowFragment.this));
            return parentalcontrolpinfragment;
        }

        public volatile Object get()
        {
            return get();
        }

            
            {
                this$0 = final_predownloadflowfragment;
                pin = ParentalControlsPin.this;
                super();
            }
    }

}
