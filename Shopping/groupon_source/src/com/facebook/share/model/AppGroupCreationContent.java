// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.share.model;

import android.os.Parcel;

// Referenced classes of package com.facebook.share.model:
//            ShareModel

public final class AppGroupCreationContent
    implements ShareModel
{
    public static final class AppGroupPrivacy extends Enum
    {

        private static final AppGroupPrivacy $VALUES[];
        public static final AppGroupPrivacy Closed;
        public static final AppGroupPrivacy Open;

        public static AppGroupPrivacy valueOf(String s)
        {
            return (AppGroupPrivacy)Enum.valueOf(com/facebook/share/model/AppGroupCreationContent$AppGroupPrivacy, s);
        }

        public static AppGroupPrivacy[] values()
        {
            return (AppGroupPrivacy[])$VALUES.clone();
        }

        static 
        {
            Open = new AppGroupPrivacy("Open", 0);
            Closed = new AppGroupPrivacy("Closed", 1);
            $VALUES = (new AppGroupPrivacy[] {
                Open, Closed
            });
        }

        private AppGroupPrivacy(String s, int i)
        {
            super(s, i);
        }
    }


    private final String description;
    private final String name;
    private AppGroupPrivacy privacy;

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(name);
        parcel.writeString(description);
        parcel.writeString(privacy.toString());
    }
}
