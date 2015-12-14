// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.http.rest.account;


// Referenced classes of package com.amazon.gallery.framework.network.http.rest.account:
//            Endpoint

public interface UserManager
{

    public abstract Endpoint getStoredEndpointFromSharedPreferences(String s);

    public abstract void removeEndpointSharedPreferences(String s);

    public abstract void storeEndpointInSharedPreferences(String s, Endpoint endpoint);
}
