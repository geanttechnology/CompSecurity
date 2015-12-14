// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model;

import android.net.Uri;
import com.perfectcorp.model.Model;
import java.util.Date;

public class  extends Model
{

    public String address;
    public Uri avatarUrl;
    public String birthDay;
    public String displayName;
    public Long id;
    public Uri imageUrl;
    public Date lastModified;
    public String mail;
    public String name;
    public Uri organizerLogo;
    public String organizerName;
    public String phone;
    public String prodName;
    public String receiveTemplate;
    public String receiveType;
    public String serviceType;
    public String title;
    public String userStatus;

    public  b()
    {
        return ()Model.a(com/cyberlink/beautycircle/model/Event$ReceiveTemplate, receiveTemplate);
    }

    public receiveTemplate c()
    {
        return (receiveTemplate)Model.a(com/cyberlink/beautycircle/model/Event$AddressInfo, address);
    }

    public ()
    {
    }
}
