// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.event.factory.woodstock;

import com.shazam.android.analytics.event.BeaconErrorCode;
import com.shazam.android.analytics.event.Event;
import com.shazam.android.analytics.event.EventParameters;
import com.shazam.model.analytics.BeaconEventKey;
import com.shazam.model.analytics.event.DefinedEventParameterKey;
import com.shazam.model.analytics.woodstock.PostAnalyticsInfo;

public class PostEventFactory
{
    private static interface PostAction
    {

        public abstract String getValue();
    }

    public static final class PublishAction extends Enum
        implements PostAction
    {

        private static final PublishAction $VALUES[];
        public static final PublishAction CANCEL;
        public static final PublishAction ERROR;
        public static final PublishAction INIT;
        public static final PublishAction LAUNCH_DIALOG;
        public static final PublishAction POST;
        public static final PublishAction SUCCESS;
        private final String value;

        public static PublishAction valueOf(String s)
        {
            return (PublishAction)Enum.valueOf(com/shazam/android/analytics/event/factory/woodstock/PostEventFactory$PublishAction, s);
        }

        public static PublishAction[] values()
        {
            return (PublishAction[])$VALUES.clone();
        }

        public final String getValue()
        {
            return value;
        }

        static 
        {
            LAUNCH_DIALOG = new PublishAction("LAUNCH_DIALOG", 0, "launchdialog");
            INIT = new PublishAction("INIT", 1, "init");
            CANCEL = new PublishAction("CANCEL", 2, "cancel");
            POST = new PublishAction("POST", 3, "post");
            SUCCESS = new PublishAction("SUCCESS", 4, "success");
            ERROR = new PublishAction("ERROR", 5, "error");
            $VALUES = (new PublishAction[] {
                LAUNCH_DIALOG, INIT, CANCEL, POST, SUCCESS, ERROR
            });
        }

        private PublishAction(String s, int i, String s1)
        {
            super(s, i);
            value = s1;
        }
    }

    public static final class UnpublishAction extends Enum
        implements PostAction
    {

        private static final UnpublishAction $VALUES[];
        public static final UnpublishAction ERROR;
        public static final UnpublishAction SUCCESS;
        public static final UnpublishAction UNPUBLISH;
        public static final UnpublishAction UNPUBLISH_AND_DELETE;
        private final String value;

        public static UnpublishAction valueOf(String s)
        {
            return (UnpublishAction)Enum.valueOf(com/shazam/android/analytics/event/factory/woodstock/PostEventFactory$UnpublishAction, s);
        }

        public static UnpublishAction[] values()
        {
            return (UnpublishAction[])$VALUES.clone();
        }

        public final String getValue()
        {
            return value;
        }

        static 
        {
            UNPUBLISH = new UnpublishAction("UNPUBLISH", 0, "unpublish");
            UNPUBLISH_AND_DELETE = new UnpublishAction("UNPUBLISH_AND_DELETE", 1, "unpublishdelete");
            SUCCESS = new UnpublishAction("SUCCESS", 2, "success");
            ERROR = new UnpublishAction("ERROR", 3, "error");
            $VALUES = (new UnpublishAction[] {
                UNPUBLISH, UNPUBLISH_AND_DELETE, SUCCESS, ERROR
            });
        }

        private UnpublishAction(String s, int i, String s1)
        {
            super(s, i);
            value = s1;
        }
    }


    private static final String PUBLISH = "publish";
    private static final String UNPUBLISH = "unpublish";

    public PostEventFactory()
    {
    }

    private static Event anUserEventWith(EventParameters eventparameters)
    {
        return com.shazam.android.analytics.event.Event.Builder.anEvent().withEventType(BeaconEventKey.USER_EVENT).withParameters(eventparameters).build();
    }

    private static Event createPostErrorEventFor(PostAnalyticsInfo postanalyticsinfo, BeaconErrorCode beaconerrorcode, String s)
    {
        return anUserEventWith(getCommonParams(PublishAction.ERROR, postanalyticsinfo, s).putNotEmptyOrNullParameter(DefinedEventParameterKey.ERROR_CODE, beaconerrorcode.getErrorCode()).build());
    }

    private static Event createPostEventFor(PostAction postaction, PostAnalyticsInfo postanalyticsinfo, String s)
    {
        return anUserEventWith(getCommonParams(postaction, postanalyticsinfo, s).build());
    }

    public static Event createPublishPostErrorEventFor(PostAnalyticsInfo postanalyticsinfo, BeaconErrorCode beaconerrorcode)
    {
        return createPostErrorEventFor(postanalyticsinfo, beaconerrorcode, "publish");
    }

    public static Event createPublishPostEventFor(PublishAction publishaction, PostAnalyticsInfo postanalyticsinfo)
    {
        return createPostEventFor(publishaction, postanalyticsinfo, "publish");
    }

    public static Event createUnpublishPostErrorEventFor(PostAnalyticsInfo postanalyticsinfo, BeaconErrorCode beaconerrorcode)
    {
        return createPostErrorEventFor(postanalyticsinfo, beaconerrorcode, "unpublish");
    }

    public static Event createUnpublishPostEventFor(UnpublishAction unpublishaction, PostAnalyticsInfo postanalyticsinfo)
    {
        return createPostEventFor(unpublishaction, postanalyticsinfo, "unpublish");
    }

    private static com.shazam.android.analytics.event.EventParameters.Builder getCommonParams(PostAction postaction, PostAnalyticsInfo postanalyticsinfo, String s)
    {
        return com.shazam.android.analytics.event.EventParameters.Builder.eventParameters().putNotEmptyOrNullParameter(DefinedEventParameterKey.TYPE, s).putNotEmptyOrNullParameter(DefinedEventParameterKey.SCREEN_NAME, postanalyticsinfo.screenName).putNotEmptyOrNullParameter(DefinedEventParameterKey.ORIGIN, postanalyticsinfo.screenOrigin).putNotEmptyOrNullParameter(DefinedEventParameterKey.TRACK_KEY, postanalyticsinfo.trackKey).putNotEmptyOrNullParameter(DefinedEventParameterKey.ACTION, postaction.getValue());
    }
}
