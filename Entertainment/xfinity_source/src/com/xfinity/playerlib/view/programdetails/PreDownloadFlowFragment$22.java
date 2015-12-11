// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import com.comcast.cim.cmasl.utils.provider.Provider;
import com.comcast.cim.model.parentalcontrols.ParentalControlsPin;
import com.xfinity.playerlib.view.common.ParentalControlPinFragment;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            PreDownloadFlowFragment

class val.pin
    implements Provider
{

    final PreDownloadFlowFragment this$0;
    final ParentalControlsPin val$pin;

    public ParentalControlPinFragment get()
    {
        ParentalControlPinFragment parentalcontrolpinfragment = new ParentalControlPinFragment();
        parentalcontrolpinfragment.setPinValidator(new com.comcast.cim.android.view.common.PinKeypadFragment.PinValidator() {

            final PreDownloadFlowFragment._cls22 this$1;

            public void validatePin(String s, com.comcast.cim.android.view.common.PinKeypadFragment.PinValidationCompletedListener pinvalidationcompletedlistener)
            {
                boolean flag = (new ParentalControlsPin(s)).equals(pin);
                if (flag)
                {
                    PreDownloadFlowFragment.access$3600(this$0);
                }
                pinvalidationcompletedlistener.onPinValidationComplete(flag);
            }

            
            {
                this$1 = PreDownloadFlowFragment._cls22.this;
                super();
            }
        });
        parentalcontrolpinfragment.setOnCancelListener(PreDownloadFlowFragment.access$700(PreDownloadFlowFragment.this));
        return parentalcontrolpinfragment;
    }

    public volatile Object get()
    {
        return get();
    }

    _cls1.this._cls1()
    {
        this$0 = final_predownloadflowfragment;
        val$pin = ParentalControlsPin.this;
        super();
    }
}
