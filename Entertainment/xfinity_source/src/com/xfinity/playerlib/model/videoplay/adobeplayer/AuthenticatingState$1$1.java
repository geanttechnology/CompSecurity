// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.videoplay.adobeplayer;

import com.comcast.cim.cmasl.taskexecutor.task.Task;
import com.comcast.cim.cmasl.xip.ams.AmsHttpErrorException;
import com.comcast.cim.model.parentalcontrols.ParentalControlsPin;
import com.comcast.cim.model.parentalcontrols.ParentalControlsSettings;
import java.util.concurrent.Executor;

// Referenced classes of package com.xfinity.playerlib.model.videoplay.adobeplayer:
//            AuthenticatingState, VideoStateController

class this._cls1
    implements Runnable
{

    final msAuthenticationSuccess this$1;

    public void run()
    {
        stateController.onAmsAuthenticationSuccess();
    }

    l.pin()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$1

/* anonymous class */
    class AuthenticatingState._cls1
        implements Runnable
    {

        final AuthenticatingState this$0;
        final String val$pin;

        private void callOnAmsAuthenticationException(final Exception e)
        {
            stateController.getUiThreadExecutor().execute(new AuthenticatingState._cls1._cls3());
        }

        private void callOnAmsAuthenticationSuccess()
        {
            stateController.getUiThreadExecutor().execute(new AuthenticatingState._cls1._cls1());
        }

        private void callOnAmsPinRequired()
        {
            stateController.getUiThreadExecutor().execute(new AuthenticatingState._cls1._cls2());
        }

        public void run()
        {
            if (stateController.shouldUseDownloadFile()) goto _L2; else goto _L1
_L1:
            stateController.performAmsAuthorization(pin);
_L4:
            callOnAmsAuthenticationSuccess();
            return;
_L2:
            if (stateController.getLiveStream() != null) goto _L4; else goto _L3
_L3:
            ParentalControlsSettings parentalcontrolssettings = (ParentalControlsSettings)stateController.getParentalControlsCache().execute();
            if (parentalcontrolssettings == null) goto _L4; else goto _L5
_L5:
            ParentalControlsPin parentalcontrolspin;
            try
            {
                parentalcontrolspin = parentalcontrolssettings.getParentalPin();
            }
            catch (Exception exception)
            {
                if ((exception instanceof AmsHttpErrorException) && ((AmsHttpErrorException)exception).getDetailedStatusCode() == 417)
                {
                    callOnAmsPinRequired();
                    return;
                } else
                {
                    callOnAmsAuthenticationException(exception);
                    return;
                }
            }
            if (parentalcontrolspin == null) goto _L4; else goto _L6
_L6:
            if (!AuthenticatingState.access$000(AuthenticatingState.this, parentalcontrolssettings, stateController.getVideoFacade()) || pin != null && parentalcontrolspin.getPin().equals(pin)) goto _L4; else goto _L7
_L7:
            callOnAmsPinRequired();
              goto _L4
        }

            
            {
                this$0 = final_authenticatingstate;
                pin = String.this;
                super();
            }

        // Unreferenced inner class com/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$1$2

/* anonymous class */
        class AuthenticatingState._cls1._cls2
            implements Runnable
        {

            final AuthenticatingState._cls1 this$1;

            public void run()
            {
                stateController.onAmsPinRequired();
            }

                    
                    {
                        this$1 = AuthenticatingState._cls1.this;
                        super();
                    }
        }


        // Unreferenced inner class com/xfinity/playerlib/model/videoplay/adobeplayer/AuthenticatingState$1$3

/* anonymous class */
        class AuthenticatingState._cls1._cls3
            implements Runnable
        {

            final AuthenticatingState._cls1 this$1;
            final Exception val$e;

            public void run()
            {
                stateController.onAmsAuthenticationException(e);
            }

                    
                    {
                        this$1 = AuthenticatingState._cls1.this;
                        e = exception;
                        super();
                    }
        }

    }

}
