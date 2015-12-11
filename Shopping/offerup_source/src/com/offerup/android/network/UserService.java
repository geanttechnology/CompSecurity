// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.network;

import e.a;
import retrofit.Callback;
import retrofit.mime.TypedFile;

public interface UserService
{

    public abstract void createUser(String s, String s1, String s2, Callback callback);

    public abstract void getMyListedItems(Callback callback);

    public abstract void getProfile(String s, Callback callback);

    public abstract void getProfile(Callback callback);

    public abstract a getUserInformation(long l);

    public abstract a getUsersListedItems(long l);

    public abstract void loginWithEmail(String s, String s1, Callback callback);

    public abstract void loginWithFb(String s, Callback callback);

    public abstract void postVerifyData(String s, String s1, Callback callback);

    public abstract void updateProfilePicture(TypedFile typedfile, Callback callback);

    public abstract void validateUser(String s, String s1, Callback callback);
}
