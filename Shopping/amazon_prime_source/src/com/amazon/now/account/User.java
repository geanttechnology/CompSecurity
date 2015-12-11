// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.account;

import android.text.TextUtils;
import com.amazon.now.util.DataStore;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.amazon.now.account:
//            UserListener

public class User
{

    private static final ArrayList sUserListeners = new ArrayList();

    public User()
    {
    }

    public static void addUserListener(UserListener userlistener)
    {
        com/amazon/now/account/User;
        JVM INSTR monitorenter ;
        sUserListeners.add(userlistener);
        com/amazon/now/account/User;
        JVM INSTR monitorexit ;
        return;
        userlistener;
        throw userlistener;
    }

    public static boolean containUserListener(UserListener userlistener)
    {
        com/amazon/now/account/User;
        JVM INSTR monitorenter ;
        boolean flag = sUserListeners.contains(userlistener);
        com/amazon/now/account/User;
        JVM INSTR monitorexit ;
        return flag;
        userlistener;
        throw userlistener;
    }

    public static String getUserCor()
    {
        com/amazon/now/account/User;
        JVM INSTR monitorenter ;
        String s = DataStore.getString("user_cor");
        com/amazon/now/account/User;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    public static String getUserEmail()
    {
        com/amazon/now/account/User;
        JVM INSTR monitorenter ;
        String s = DataStore.getString("user_email");
        com/amazon/now/account/User;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    public static String getUserName()
    {
        com/amazon/now/account/User;
        JVM INSTR monitorenter ;
        String s = DataStore.getString("user_full_email");
        com/amazon/now/account/User;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    public static String getUserPfm()
    {
        com/amazon/now/account/User;
        JVM INSTR monitorenter ;
        String s = DataStore.getString("user_pfm");
        com/amazon/now/account/User;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    public static boolean isSignedIn()
    {
        return !TextUtils.isEmpty(getUserName()) && !TextUtils.isEmpty(getUserCor()) && !TextUtils.isEmpty(getUserPfm());
    }

    public static void removeUser()
    {
        com/amazon/now/account/User;
        JVM INSTR monitorenter ;
        DataStore.removeKey("user_email");
        DataStore.removeKey("user_full_email");
        DataStore.removeKey("user_cor");
        DataStore.removeKey("user_pfm");
        for (Iterator iterator = sUserListeners.iterator(); iterator.hasNext(); ((UserListener)iterator.next()).userSignedOut()) { }
        break MISSING_BLOCK_LABEL_62;
        Exception exception;
        exception;
        throw exception;
        com/amazon/now/account/User;
        JVM INSTR monitorexit ;
    }

    public static void removeUserListener(UserListener userlistener)
    {
        com/amazon/now/account/User;
        JVM INSTR monitorenter ;
        sUserListeners.remove(userlistener);
        com/amazon/now/account/User;
        JVM INSTR monitorexit ;
        return;
        userlistener;
        throw userlistener;
    }

    public static void saveUser(String s, String s1, String s2, String s3)
    {
        com/amazon/now/account/User;
        JVM INSTR monitorenter ;
        DataStore.putString("user_email", s);
        DataStore.putString("user_full_email", s1);
        DataStore.putString("user_cor", s2);
        DataStore.putString("user_pfm", s3);
        for (s = sUserListeners.iterator(); s.hasNext(); ((UserListener)s.next()).userSignedIn()) { }
        break MISSING_BLOCK_LABEL_66;
        s;
        throw s;
        com/amazon/now/account/User;
        JVM INSTR monitorexit ;
    }

}
