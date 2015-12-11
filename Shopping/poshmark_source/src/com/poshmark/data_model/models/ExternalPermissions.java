// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models;


public class ExternalPermissions
{

    public int email;
    public int public_profile;
    public int publish_actions;
    public int user_friends;

    public ExternalPermissions()
    {
        user_friends = 0;
        email = 0;
        public_profile = 0;
        publish_actions = 0;
    }
}
