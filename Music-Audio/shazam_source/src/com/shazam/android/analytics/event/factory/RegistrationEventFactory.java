// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.event.factory;

import com.shazam.android.analytics.event.Event;
import com.shazam.model.analytics.BeaconEventKey;
import com.shazam.model.analytics.event.DefinedEventParameterKey;

public class RegistrationEventFactory
{
    public static final class RegistrationAction extends Enum
    {

        private static final RegistrationAction $VALUES[];
        public static final RegistrationAction CHOOSE_ACCOUNT;
        public static final RegistrationAction REGISTER;
        private final String action;

        public static RegistrationAction valueOf(String s)
        {
            return (RegistrationAction)Enum.valueOf(com/shazam/android/analytics/event/factory/RegistrationEventFactory$RegistrationAction, s);
        }

        public static RegistrationAction[] values()
        {
            return (RegistrationAction[])$VALUES.clone();
        }

        public final String getAction()
        {
            return action;
        }

        static 
        {
            REGISTER = new RegistrationAction("REGISTER", 0, "register");
            CHOOSE_ACCOUNT = new RegistrationAction("CHOOSE_ACCOUNT", 1, "chooseaccount");
            $VALUES = (new RegistrationAction[] {
                REGISTER, CHOOSE_ACCOUNT
            });
        }

        private RegistrationAction(String s, int i, String s1)
        {
            super(s, i);
            action = s1;
        }
    }


    public RegistrationEventFactory()
    {
    }

    public static Event createRegistrationEvent(RegistrationAction registrationaction)
    {
        registrationaction = com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.TYPE, "registration").putNotEmptyOrNullParameter(DefinedEventParameterKey.ACTION, registrationaction.getAction()).build();
        return com.shazam.android.analytics.event.Event.Builder.anEvent().withEventType(BeaconEventKey.USER_EVENT).withParameters(registrationaction).build();
    }
}
