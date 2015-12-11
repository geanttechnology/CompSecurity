// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptentive.android.sdk.module.engagement.interaction.model;

import android.app.Activity;
import android.content.Context;
import com.apptentive.android.sdk.module.engagement.EngagementModule;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.apptentive.android.sdk.module.engagement.interaction.model:
//            InteractionConfiguration

public abstract class Interaction extends JSONObject
{

    public static final String EVENT_NAME_LAUNCH = "launch";
    private static final String KEY_CONFIGURATION = "configuration";
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "interaction";
    private static final String KEY_TYPE = "type";
    private static final String KEY_VERSION = "version";

    public Interaction(String s)
    {
        super(s);
    }

    public InteractionConfiguration getConfiguration()
    {
        InteractionConfiguration interactionconfiguration;
        if (isNull("configuration"))
        {
            break MISSING_BLOCK_LABEL_29;
        }
        interactionconfiguration = new InteractionConfiguration(getJSONObject("configuration").toString());
        return interactionconfiguration;
        JSONException jsonexception;
        jsonexception;
        return new InteractionConfiguration();
    }

    public String getId()
    {
        String s;
        if (isNull("id"))
        {
            break MISSING_BLOCK_LABEL_19;
        }
        s = getString("id");
        return s;
        JSONException jsonexception;
        jsonexception;
        return null;
    }

    public Type getType()
    {
        Type type;
        if (isNull("type"))
        {
            break MISSING_BLOCK_LABEL_22;
        }
        type = Type.parse(getString("type"));
        return type;
        JSONException jsonexception;
        jsonexception;
        return Type.unknown;
    }

    public Integer getVersion()
    {
        int i;
        if (isNull("version"))
        {
            break MISSING_BLOCK_LABEL_22;
        }
        i = getInt("version");
        return Integer.valueOf(i);
        JSONException jsonexception;
        jsonexception;
        return null;
    }

    protected boolean isInRunnableState(Context context)
    {
        return true;
    }

    public void sendLaunchEvent(Activity activity)
    {
        EngagementModule.engageInternal(activity, this, "launch");
    }

    private class Type extends Enum
    {

        private static final Type $VALUES[];
        public static final Type AppStoreRating;
        public static final Type EnjoymentDialog;
        public static final Type FeedbackDialog;
        public static final Type MessageCenter;
        public static final Type NavigateToLink;
        public static final Type RatingDialog;
        public static final Type Survey;
        public static final Type TextModal;
        public static final Type UpgradeMessage;
        public static final Type unknown;

        public static Type parse(String s)
        {
            Type type;
            try
            {
                type = valueOf(s);
            }
            catch (IllegalArgumentException illegalargumentexception)
            {
                Log.v((new StringBuilder("Error parsing unknown Interaction.Type: ")).append(s).toString(), new Object[0]);
                return unknown;
            }
            return type;
        }

        public static Type valueOf(String s)
        {
            return (Type)Enum.valueOf(com/apptentive/android/sdk/module/engagement/interaction/model/Interaction$Type, s);
        }

        public static Type[] values()
        {
            return (Type[])$VALUES.clone();
        }

        static 
        {
            UpgradeMessage = new Type("UpgradeMessage", 0);
            EnjoymentDialog = new Type("EnjoymentDialog", 1);
            RatingDialog = new Type("RatingDialog", 2);
            FeedbackDialog = new Type("FeedbackDialog", 3);
            MessageCenter = new Type("MessageCenter", 4);
            AppStoreRating = new Type("AppStoreRating", 5);
            Survey = new Type("Survey", 6);
            TextModal = new Type("TextModal", 7);
            NavigateToLink = new Type("NavigateToLink", 8);
            unknown = new Type("unknown", 9);
            $VALUES = (new Type[] {
                UpgradeMessage, EnjoymentDialog, RatingDialog, FeedbackDialog, MessageCenter, AppStoreRating, Survey, TextModal, NavigateToLink, unknown
            });
        }

        private Type(String s, int i)
        {
            super(s, i);
        }
    }

}
