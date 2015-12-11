// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.text.TextUtils;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.storage.BackwardsCompatiableDataStorage;
import com.amazon.identity.auth.device.storage.DataStorage;
import com.amazon.identity.auth.device.utils.MAPLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            MultipleAccountsLogic, AmazonAccountManager

private static abstract class mMapping
    implements mMapping
{

    private final AmazonAccountManager mAmznAcctMan;
    protected final ServiceWrappingContext mContext;
    private final BackwardsCompatiableDataStorage mDataStorage;
    protected final com.amazon.identity.auth.device.api.etAccountMappingValue mMapping;

    public static Set getMetadataForAccount(DataStorage datastorage, String s, String s1)
    {
        datastorage = datastorage.getUserData(s, s1);
        s = new HashSet();
        if (TextUtils.isEmpty(datastorage))
        {
            return s;
        } else
        {
            s.addAll(Arrays.asList(datastorage.split(",")));
            return s;
        }
    }

    private boolean removeMappingFromAccount(String s)
    {
        String s1 = mMapping.etAccountMappingType();
        String s2 = mMapping.etAccountMappingValue();
        Set set = getMetadataForAccount(mDataStorage, s, s1);
        MultipleAccountsLogic.access$000();
        set.toString();
        if (!set.contains(s2))
        {
            MAPLog.w(MultipleAccountsLogic.access$000(), "Cannot remove %s for type %s from account", new Object[] {
                s2, s1
            });
            return false;
        } else
        {
            set.remove(s2);
            MultipleAccountsLogic.access$000();
            set.toString();
            mDataStorage.setUserData(s, s1, seralizeValues(set));
            return true;
        }
    }

    private String seralizeValues(Set set)
    {
        if (set == null)
        {
            return null;
        } else
        {
            return TextUtils.join(",", set);
        }
    }

    public boolean isMappingCurrentlySetForAccount(String s)
    {
        return getMetadataForAccount(mDataStorage, s, mMapping.etAccountMappingType()).contains(mMapping.etAccountMappingValue());
    }

    public abstract boolean isSupportedOnThisPlatform();

    protected abstract List notifyOfChange();

    public List onDeregister(String s)
    {
        return removeAndNotify(s);
    }

    public List removeAndNotify(String s)
    {
        if (removeMappingFromAccount(s))
        {
            MAPLog.i(MultipleAccountsLogic.access$000(), "Notifying of user change of type %s removed. Account for profile %s changed.", new Object[] {
                mMapping.etAccountMappingType(), mMapping.etAccountMappingValue()
            });
            return notifyOfChange();
        } else
        {
            MAPLog.i(MultipleAccountsLogic.access$000(), "Cannot remove mapping type %s for key %s did not change. Not notifing.", new Object[] {
                mMapping.etAccountMappingType(), mMapping.etAccountMappingValue()
            });
            return new ArrayList();
        }
    }

    public List setAndNotify(String s)
    {
        Iterator iterator = mAmznAcctMan.getAccounts().iterator();
        boolean flag = false;
        while (iterator.hasNext()) 
        {
            String s1 = (String)iterator.next();
            if (s1.equals(s))
            {
                String s2 = mMapping.etAccountMappingType();
                String s3 = mMapping.etAccountMappingValue();
                Set set = getMetadataForAccount(mDataStorage, s1, s2);
                MultipleAccountsLogic.access$000();
                set.toString();
                boolean flag1;
                if (set.contains(s3))
                {
                    MAPLog.w(MultipleAccountsLogic.access$000(), "Cannot create mapping of type with value %s to account", new Object[] {
                        s2, s3
                    });
                    flag1 = false;
                } else
                {
                    set.add(s3);
                    MultipleAccountsLogic.access$000();
                    set.toString();
                    mDataStorage.setUserData(s1, s2, seralizeValues(set));
                    flag1 = true;
                }
                flag = flag1 | flag;
            } else
            {
                removeMappingFromAccount(s1);
            }
        }
        if (flag)
        {
            MAPLog.i(MultipleAccountsLogic.access$000(), "Notifying of user change of type %s set. Account for profile %s changed.", new Object[] {
                mMapping.etAccountMappingType(), mMapping.etAccountMappingValue()
            });
            return notifyOfChange();
        } else
        {
            MAPLog.i(MultipleAccountsLogic.access$000(), "Setting mapping type %s for key %s did not change. Not notifing.", new Object[] {
                mMapping.etAccountMappingType(), mMapping.etAccountMappingValue()
            });
            return new ArrayList();
        }
    }

    public (ServiceWrappingContext servicewrappingcontext, com.amazon.identity.auth.device.api. , AmazonAccountManager amazonaccountmanager)
    {
        mContext = servicewrappingcontext;
        mAmznAcctMan = amazonaccountmanager;
        mDataStorage = new BackwardsCompatiableDataStorage(mContext);
        mMapping = ;
    }
}
