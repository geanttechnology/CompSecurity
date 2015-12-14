// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.request;

import com.socialin.android.apiv3.model.Adress;

// Referenced classes of package com.socialin.android.apiv3.request:
//            RequestParams, NotificationSettingsParams

public class UpdateUserParams extends RequestParams
{

    public Adress address;
    public String cover;
    public String email;
    public int mature;
    public String name;
    public NotificationSettingsParams notificationParams;
    public String password;
    public String passwordConfirm;
    public String photo;
    public String profileStatus;
    public String username;

    public UpdateUserParams()
    {
        mature = -1;
    }
}
