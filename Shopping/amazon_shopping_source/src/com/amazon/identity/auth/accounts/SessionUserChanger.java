// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import com.amazon.identity.auth.device.utils.ArrayUtil;
import com.amazon.identity.auth.device.utils.MAPLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            AmazonAccountManager

public class SessionUserChanger
{
    public static interface OnSessionUsersChangedListener
    {

        public abstract void onChanged(Collection collection, Collection collection1);
    }


    private static final String TAG = com/amazon/identity/auth/accounts/SessionUserChanger.getName();
    private final AmazonAccountManager mAmazonAccountMan;
    private final List mListeners = new ArrayList();

    public SessionUserChanger(AmazonAccountManager amazonaccountmanager)
    {
        mAmazonAccountMan = amazonaccountmanager;
    }

    private boolean accountCanBeSessionUser(String s)
    {
        while (!mAmazonAccountMan.doesAccountExist(s) || mAmazonAccountMan.isAccountDeregistering(s)) 
        {
            return false;
        }
        return true;
    }

    private Set changeToSessionUsers(Collection collection, Collection collection1)
    {
        if (collection.size() > 0 || collection1.size() > 0)
        {
            String s;
            for (Iterator iterator = collection.iterator(); iterator.hasNext(); mAmazonAccountMan.setAccountAsSessionUser(s))
            {
                s = (String)iterator.next();
            }

            String s1;
            for (Iterator iterator1 = collection1.iterator(); iterator1.hasNext(); mAmazonAccountMan.removeAccountAsSessionUser(s1))
            {
                s1 = (String)iterator1.next();
            }

            for (Iterator iterator2 = mListeners.iterator(); iterator2.hasNext(); ((OnSessionUsersChangedListener)iterator2.next()).onChanged(collection, collection1)) { }
        } else
        {
            MAPLog.i(TAG, "No New Session Users to add");
        }
        return mAmazonAccountMan.getSessionUsers();
    }

    public Set addSessionUsers(Set set)
    {
        Set set1 = mAmazonAccountMan.getSessionUsers();
        set1.addAll(set);
        return changeSessionUsers(set1);
    }

    public Set changeSessionUsers(Set set)
    {
        Set set2 = mAmazonAccountMan.getSessionUsers();
        if (set != null) goto _L2; else goto _L1
_L1:
        set = null;
_L4:
        HashSet hashset;
        Iterator iterator;
        if (set == null || set.size() == 0)
        {
            MAPLog.e(TAG, "Cannot remove all session users. Change aborted");
            return set2;
        } else
        {
            Set set1 = mAmazonAccountMan.getSessionUsers();
            HashSet hashset1 = new HashSet();
            hashset1.addAll(set);
            hashset1.removeAll(set1);
            HashSet hashset2 = new HashSet();
            hashset2.addAll(set1);
            hashset2.removeAll(set);
            return changeToSessionUsers(hashset1, hashset2);
        }
_L2:
        hashset = new HashSet();
        iterator = set.iterator();
_L5:
        set = hashset;
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        set = (String)iterator.next();
        if (accountCanBeSessionUser(set))
        {
            hashset.add(set);
        }
          goto _L5
    }

    public Set onSessionUserDeregistered(String s)
    {
        Object obj;
        HashSet hashset;
        obj = null;
        if (!mAmazonAccountMan.isSessionUserAmazonAccount(s))
        {
            String s1 = TAG;
            String.format("%s is not a session user, so nothing to notify about it being deregistered", new Object[] {
                s
            });
            return mAmazonAccountMan.getSessionUsers();
        }
        hashset = new HashSet();
        if (mAmazonAccountMan.isSecondaryAmazonAccount(s)) goto _L2; else goto _L1
_L1:
        String s2 = obj;
_L4:
        if (s2 != null)
        {
            hashset.add(s2);
        }
        return changeToSessionUsers(hashset, ArrayUtil.asSet(new String[] {
            s
        }));
_L2:
        s2 = obj;
        if (mAmazonAccountMan.getSessionUsers().size() == 1)
        {
            String s3 = mAmazonAccountMan.getDevicePrimaryAmazonAccount();
            s2 = obj;
            if (accountCanBeSessionUser(s3))
            {
                s2 = s3;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public Set removeSessionUsers(Set set)
    {
        Set set1 = mAmazonAccountMan.getSessionUsers();
        set1.removeAll(set);
        return changeSessionUsers(set1);
    }

    public void setListener(OnSessionUsersChangedListener onsessionuserschangedlistener)
    {
        mListeners.add(onsessionuserschangedlistener);
    }

}
