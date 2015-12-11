// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.share.model;

import android.os.Parcel;
import java.util.ArrayList;

// Referenced classes of package com.facebook.share.model:
//            ShareModel

public final class GameRequestContent
    implements ShareModel
{
    public static final class ActionType extends Enum
    {

        private static final ActionType $VALUES[];
        public static final ActionType ASKFOR;
        public static final ActionType SEND;
        public static final ActionType TURN;

        public static ActionType valueOf(String s)
        {
            return (ActionType)Enum.valueOf(com/facebook/share/model/GameRequestContent$ActionType, s);
        }

        public static ActionType[] values()
        {
            return (ActionType[])$VALUES.clone();
        }

        static 
        {
            SEND = new ActionType("SEND", 0);
            ASKFOR = new ActionType("ASKFOR", 1);
            TURN = new ActionType("TURN", 2);
            $VALUES = (new ActionType[] {
                SEND, ASKFOR, TURN
            });
        }

        private ActionType(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class Filters extends Enum
    {

        private static final Filters $VALUES[];
        public static final Filters APP_NON_USERS;
        public static final Filters APP_USERS;

        public static Filters valueOf(String s)
        {
            return (Filters)Enum.valueOf(com/facebook/share/model/GameRequestContent$Filters, s);
        }

        public static Filters[] values()
        {
            return (Filters[])$VALUES.clone();
        }

        static 
        {
            APP_USERS = new Filters("APP_USERS", 0);
            APP_NON_USERS = new Filters("APP_NON_USERS", 1);
            $VALUES = (new Filters[] {
                APP_USERS, APP_NON_USERS
            });
        }

        private Filters(String s, int i)
        {
            super(s, i);
        }
    }


    private final ActionType actionType;
    private final String data;
    private final Filters filters;
    private final String message;
    private final String objectId;
    private final ArrayList suggestions;
    private final String title;
    private final String to;

    public int describeContents()
    {
        return 0;
    }

    public ActionType getActionType()
    {
        return actionType;
    }

    public Filters getFilters()
    {
        return filters;
    }

    public String getObjectId()
    {
        return objectId;
    }

    public ArrayList getSuggestions()
    {
        return suggestions;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(message);
        parcel.writeString(to);
        parcel.writeString(title);
        parcel.writeString(data);
        parcel.writeString(getActionType().toString());
        parcel.writeString(getObjectId());
        parcel.writeString(getFilters().toString());
        parcel.writeStringList(getSuggestions());
    }
}
