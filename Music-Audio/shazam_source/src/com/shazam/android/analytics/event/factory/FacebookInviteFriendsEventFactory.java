// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.event.factory;

import com.shazam.android.analytics.event.Event;
import com.shazam.model.analytics.event.DefinedEventParameterKey;

// Referenced classes of package com.shazam.android.analytics.event.factory:
//            UserEventEventFactory

public class FacebookInviteFriendsEventFactory
{

    public FacebookInviteFriendsEventFactory()
    {
    }

    private static com.shazam.android.analytics.event.EventParameters.Builder commonFacebookInviteFriendsEventParameters()
    {
        return com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.TYPE, "fbinvite");
    }

    public static Event createFacebookInviteFriendsImpressionEvent()
    {
        return UserEventEventFactory.aUserEventWith(commonFacebookInviteFriendsEventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.ACTION, "view").build());
    }

    public static Event createFacebookInviteFriendsInviteEvent()
    {
        return UserEventEventFactory.aUserEventWith(commonFacebookInviteFriendsEventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.ACTION, "invite").build());
    }

    public static Event createFacebookInviteFriendsSkipEvent()
    {
        return UserEventEventFactory.aUserEventWith(commonFacebookInviteFriendsEventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.ACTION, "skip").build());
    }
}
