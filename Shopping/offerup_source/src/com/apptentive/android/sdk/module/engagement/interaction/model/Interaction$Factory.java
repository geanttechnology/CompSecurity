// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptentive.android.sdk.module.engagement.interaction.model;

import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.apptentive.android.sdk.module.engagement.interaction.model:
//            UpgradeMessageInteraction, EnjoymentDialogInteraction, RatingDialogInteraction, FeedbackDialogInteraction, 
//            MessageCenterInteraction, AppStoreRatingInteraction, SurveyInteraction, TextModalInteraction, 
//            NavigateToLinkInteraction, Interaction

public class ction
{

    public static Interaction parseInteraction(String s)
    {
        if (s == null)
        {
            return null;
        }
        ction ction;
        ction = nown;
        JSONObject jsonobject = new JSONObject(s);
        if (jsonobject.has("type"))
        {
            ction = se(jsonobject.getString("type"));
        }
        hMap.com.apptentive.android.sdk.module.engagement.interaction.model.Interaction.Type[ction.inal()];
        JVM INSTR tableswitch 1 9: default 182
    //                   1 96
    //                   2 105
    //                   3 114
    //                   4 123
    //                   5 132
    //                   6 141
    //                   7 150
    //                   8 159
    //                   9 168;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L2:
        return new UpgradeMessageInteraction(s);
_L3:
        return new EnjoymentDialogInteraction(s);
_L4:
        return new RatingDialogInteraction(s);
_L5:
        return new FeedbackDialogInteraction(s);
_L6:
        return new MessageCenterInteraction(s);
_L7:
        return new AppStoreRatingInteraction(s);
_L8:
        return new SurveyInteraction(s);
_L9:
        return new TextModalInteraction(s);
_L10:
        s = new NavigateToLinkInteraction(s);
        return s;
        s;
        return null;
_L1:
        return null;
    }

    public ction()
    {
    }
}
