// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models;


// Referenced classes of package com.poshmark.data_model.models:
//            ActiveUserInfo

public class type
{
    class PushPayload
    {

        String alert;
        int badge;
        final ActiveUserInfo.PushNotificationInfo this$1;
        String type;

        PushPayload()
        {
            this$1 = ActiveUserInfo.PushNotificationInfo.this;
            super();
        }
    }


    PushPayload aps;
    final ActiveUserInfo this$0;
    String type;

    PushPayload.this._cls1(String s, String s1, String s2)
    {
        this$0 = ActiveUserInfo.this;
        super();
        aps = new PushPayload();
        if (s != null)
        {
            aps.alert = s;
        }
        if (s1 != null)
        {
            aps.badge = Integer.parseInt(s1);
        }
        if (s2 != null)
        {
            type = s2;
        }
    }
}
