// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.model.auth;

import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.persistence.DataStore;
import com.amazon.rio.j2me.client.services.mShop.Date;
import com.amazon.rio.j2me.client.services.mShop.LoginData;
import com.amazon.rio.j2me.client.services.mShop.PrimeOneClickStatus;
import com.amazon.rio.j2me.client.services.mShop.SmileInfoResponse;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

// Referenced classes of package com.amazon.mShop.model.auth:
//            UserListener

public class User
{

    private static volatile User sUser;
    private static final List sUserListeners = new ArrayList();
    private String mCharity;
    private final Date mDob;
    private final String mEmail;
    private final String mFullName;
    private boolean mIsPrimeEligible;
    private boolean mOneClick;
    private boolean mPrime;
    private String mPrimeFunnelUrl;
    private boolean mSmile;

    public User(String s, String s1, boolean flag, boolean flag1, Date date, Boolean boolean1, String s2)
    {
        this(s, s1, flag, flag1, date, boolean1, s2, "", false);
    }

    public User(String s, String s1, boolean flag, boolean flag1, Date date, Boolean boolean1, String s2, 
            String s3, boolean flag2)
    {
        mEmail = s;
        s = s1;
        if (s1 == null)
        {
            s = "";
        }
        mFullName = s;
        mPrime = flag;
        mOneClick = flag1;
        mDob = date;
        if (boolean1 == null)
        {
            flag = false;
        } else
        {
            flag = boolean1.booleanValue();
        }
        mIsPrimeEligible = flag;
        mPrimeFunnelUrl = s2;
        mSmile = flag2;
        mCharity = s3;
    }

    public static void addUserListener(UserListener userlistener)
    {
        boolean flag;
label0:
        {
            boolean flag1 = false;
            Iterator iterator = sUserListeners.iterator();
            WeakReference weakreference;
label1:
            do
            {
                do
                {
                    flag = flag1;
                    if (!iterator.hasNext())
                    {
                        break label0;
                    }
                    weakreference = (WeakReference)iterator.next();
                    if (weakreference.get() != null)
                    {
                        continue label1;
                    }
                    iterator.remove();
                } while (true);
            } while (weakreference.get() != userlistener);
            flag = true;
        }
        if (!flag)
        {
            sUserListeners.add(new WeakReference(userlistener));
        }
    }

    public static void clearUser()
    {
        com/amazon/mShop/model/auth/User;
        JVM INSTR monitorenter ;
        sUser = null;
        com/amazon/mShop/model/auth/User;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public static Date getDateFromString(String s)
    {
        if (!Util.isEmpty(s))
        {
            if ((s = s.split("-")).length == 3)
            {
                Date date = new Date();
                date.setYear(Integer.parseInt(s[0]));
                date.setMonth(Integer.parseInt(s[1]));
                date.setDay(Integer.parseInt(s[2]));
                return date;
            }
        }
        return null;
    }

    public static String getLastUserEmail()
    {
        return com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getString("userEmail");
    }

    public static String getStringFromDate(Date date)
    {
        if (date == null)
        {
            return "";
        } else
        {
            StringBuffer stringbuffer = new StringBuffer();
            stringbuffer.append(date.getYear());
            stringbuffer.append("-");
            stringbuffer.append(date.getMonth());
            stringbuffer.append("-");
            stringbuffer.append(date.getDay());
            return stringbuffer.toString();
        }
    }

    public static User getUser()
    {
        com/amazon/mShop/model/auth/User;
        JVM INSTR monitorenter ;
        Object obj;
        String s;
        if (sUser != null)
        {
            break MISSING_BLOCK_LABEL_112;
        }
        obj = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore();
        s = ((DataStore) (obj)).getString("userFullName");
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_112;
        }
        sUser = new User(((DataStore) (obj)).getString("userEmail"), s, ((DataStore) (obj)).getBoolean("userPrime"), ((DataStore) (obj)).getBoolean("userOneClick"), getDateFromString(((DataStore) (obj)).getString("userDob")), Boolean.valueOf(((DataStore) (obj)).getBoolean("userPrimeEligible")), ((DataStore) (obj)).getString("userPrimeFunnelUrl"), ((DataStore) (obj)).getString("userCharity"), ((DataStore) (obj)).getBoolean("userIsSmile"));
        obj = sUser;
        com/amazon/mShop/model/auth/User;
        JVM INSTR monitorexit ;
        return ((User) (obj));
        Exception exception;
        exception;
        throw exception;
    }

    private static boolean isCharityNameChanged(String s)
    {
        return s == null && !Util.isEmpty(sUser.mCharity) || s != null && !s.equals(sUser.mCharity);
    }

    public static boolean isLoggedIn()
    {
        com/amazon/mShop/model/auth/User;
        JVM INSTR monitorenter ;
        User user = getUser();
        boolean flag;
        if (user != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        com/amazon/mShop/model/auth/User;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    private static void notifyUserUpdate(User user)
    {
        saveUser(user);
        user = (new ArrayList(sUserListeners)).listIterator(sUserListeners.size());
        do
        {
            if (!user.hasPrevious())
            {
                break;
            }
            WeakReference weakreference = (WeakReference)user.previous();
            if (weakreference.get() != null)
            {
                ((UserListener)weakreference.get()).userUpdated(sUser);
            }
        } while (true);
    }

    public static void removeUserListener(UserListener userlistener)
    {
        Iterator iterator = sUserListeners.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            WeakReference weakreference = (WeakReference)iterator.next();
            if (weakreference.get() == null || weakreference.get() == userlistener)
            {
                iterator.remove();
            }
        } while (true);
    }

    public static void saveUser(User user)
    {
        com/amazon/mShop/model/auth/User;
        JVM INSTR monitorenter ;
        DataStore datastore;
        sUser = user;
        datastore = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore();
        if (user != null) goto _L2; else goto _L1
_L1:
        datastore.remove("userFullName");
        datastore.remove("userPrime");
        datastore.remove("userOneClick");
        datastore.remove("userDob");
        datastore.remove("userPrimeEligible");
        datastore.remove("userPrimeFunnelUrl");
        datastore.remove("userIsSmile");
        datastore.remove("userCharity");
_L4:
        com/amazon/mShop/model/auth/User;
        JVM INSTR monitorexit ;
        return;
_L2:
        datastore.putString("userEmail", user.getEmail());
        datastore.putString("userFullName", user.getFullName());
        datastore.putBoolean("userPrime", user.isPrime());
        datastore.putBoolean("userOneClick", user.isOneClick());
        datastore.putString("userDob", getStringFromDate(user.getDob()));
        datastore.putBoolean("userPrimeEligible", user.isPrimeEligible());
        datastore.putString("userPrimeFunnelUrl", user.getPrimeFunnelUrl());
        datastore.putBoolean("userIsSmile", user.isSmile());
        datastore.putString("userCharity", user.getCharity());
        if (true) goto _L4; else goto _L3
_L3:
        user;
        throw user;
    }

    public static void saveUser(String s, LoginData logindata)
    {
        boolean flag = false;
        boolean flag1 = false;
        if (logindata.getPrimeOneClickStatus() != null)
        {
            flag = logindata.getPrimeOneClickStatus().getIsPrime();
            flag1 = logindata.getPrimeOneClickStatus().getIsOneClickEnabled();
        }
        boolean flag2 = false;
        String s1 = "";
        User user = sUser;
        if (user != null)
        {
            flag2 = user.isSmile();
            s1 = user.getCharity();
        }
        saveUser(new User(s, logindata.getFullName(), flag, flag1, logindata.getDob(), logindata.getIsPrimeFunnelEligible(), logindata.getPrimeFunnelUrl(), s1, flag2));
    }

    public static void setOneClickEnabled(boolean flag)
    {
        com/amazon/mShop/model/auth/User;
        JVM INSTR monitorenter ;
        User user = sUser;
        if (user != null) goto _L2; else goto _L1
_L1:
        com/amazon/mShop/model/auth/User;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (sUser.mOneClick != flag)
        {
            DataStore datastore = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore();
            sUser.mOneClick = flag;
            datastore.putBoolean("userOneClick", sUser.isOneClick());
        }
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public static void setPrimeOneClickStatus(PrimeOneClickStatus primeoneclickstatus)
    {
        com/amazon/mShop/model/auth/User;
        JVM INSTR monitorenter ;
        User user = sUser;
        if (user != null) goto _L2; else goto _L1
_L1:
        com/amazon/mShop/model/auth/User;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (sUser.mPrime != primeoneclickstatus.getIsPrime())
        {
            DataStore datastore = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore();
            sUser.mPrime = primeoneclickstatus.getIsPrime();
            datastore.putBoolean("userPrime", sUser.isPrime());
        }
        setOneClickEnabled(primeoneclickstatus.getIsOneClickEnabled());
        if (true) goto _L1; else goto _L3
_L3:
        primeoneclickstatus;
        throw primeoneclickstatus;
    }

    public static void userSignedIn(User user)
    {
        com/amazon/mShop/model/auth/User;
        JVM INSTR monitorenter ;
        saveUser(user);
        ListIterator listiterator = (new ArrayList(sUserListeners)).listIterator(sUserListeners.size());
        do
        {
            if (!listiterator.hasPrevious())
            {
                break;
            }
            WeakReference weakreference = (WeakReference)listiterator.previous();
            if (weakreference.get() != null)
            {
                ((UserListener)weakreference.get()).userSignedIn(user);
            }
        } while (true);
        break MISSING_BLOCK_LABEL_79;
        user;
        throw user;
        com/amazon/mShop/model/auth/User;
        JVM INSTR monitorexit ;
    }

    public static void userSignedIn(String s, LoginData logindata)
    {
        boolean flag = false;
        boolean flag1 = false;
        if (logindata.getPrimeOneClickStatus() != null)
        {
            flag = logindata.getPrimeOneClickStatus().getIsPrime();
            flag1 = logindata.getPrimeOneClickStatus().getIsOneClickEnabled();
        }
        boolean flag2 = false;
        String s1 = "";
        User user = sUser;
        if (user != null)
        {
            flag2 = user.isSmile();
            s1 = user.getCharity();
        }
        userSignedIn(new User(s, logindata.getFullName(), flag, flag1, logindata.getDob(), logindata.getIsPrimeFunnelEligible(), logindata.getPrimeFunnelUrl(), s1, flag2));
    }

    public static void userSignedOut()
    {
        com/amazon/mShop/model/auth/User;
        JVM INSTR monitorenter ;
        saveUser(null);
        ListIterator listiterator = (new ArrayList(sUserListeners)).listIterator(sUserListeners.size());
        do
        {
            if (!listiterator.hasPrevious())
            {
                break;
            }
            WeakReference weakreference = (WeakReference)listiterator.previous();
            if (weakreference.get() != null)
            {
                ((UserListener)weakreference.get()).userSignedOut();
            }
        } while (true);
        break MISSING_BLOCK_LABEL_78;
        Exception exception;
        exception;
        throw exception;
        com/amazon/mShop/model/auth/User;
        JVM INSTR monitorexit ;
    }

    public static void userUpdated(LoginData logindata)
    {
        com/amazon/mShop/model/auth/User;
        JVM INSTR monitorenter ;
        if (sUser == null) goto _L2; else goto _L1
_L1:
        String s = logindata.getFullName();
        if (s == null) goto _L4; else goto _L3
_L3:
        if (s.trim().length() <= 0) goto _L4; else goto _L5
_L5:
        Date date = logindata.getDob();
        if (date == null) goto _L7; else goto _L6
_L6:
        Boolean boolean1 = Boolean.valueOf(sUser.isPrimeEligible());
        String s1 = sUser.getPrimeFunnelUrl();
        if (logindata.getIsPrimeFunnelEligible() != null)
        {
            boolean1 = logindata.getIsPrimeFunnelEligible();
            s1 = logindata.getPrimeFunnelUrl();
        }
        boolean flag = sUser.isSmile();
        String s2 = sUser.getCharity();
        notifyUserUpdate(new User(sUser.getEmail(), s, logindata.getPrimeOneClickStatus().getIsPrime(), logindata.getPrimeOneClickStatus().getIsOneClickEnabled(), date, boolean1, s1, s2, flag));
_L2:
        com/amazon/mShop/model/auth/User;
        JVM INSTR monitorexit ;
        return;
_L4:
        s = sUser.getFullName();
          goto _L5
_L7:
        date = sUser.getDob();
          goto _L6
        logindata;
        throw logindata;
          goto _L5
    }

    public static void userUpdated(SmileInfoResponse smileinforesponse)
    {
        com/amazon/mShop/model/auth/User;
        JVM INSTR monitorenter ;
        if (sUser == null)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        smileinforesponse = smileinforesponse.getCharityName();
        if (!isCharityNameChanged(smileinforesponse))
        {
            break MISSING_BLOCK_LABEL_35;
        }
        boolean flag;
        if (!Util.isEmpty(smileinforesponse))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        userUpdated(flag, ((String) (smileinforesponse)));
        com/amazon/mShop/model/auth/User;
        JVM INSTR monitorexit ;
        return;
        smileinforesponse;
        throw smileinforesponse;
    }

    public static void userUpdated(boolean flag, String s)
    {
        com/amazon/mShop/model/auth/User;
        JVM INSTR monitorenter ;
        if (sUser != null && isCharityNameChanged(s))
        {
            notifyUserUpdate(new User(sUser.getEmail(), sUser.getFullName(), sUser.isPrime(), sUser.isOneClick(), sUser.getDob(), Boolean.valueOf(sUser.isPrimeEligible()), sUser.getPrimeFunnelUrl(), s, flag));
        }
        com/amazon/mShop/model/auth/User;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public String getCharity()
    {
        return mCharity;
    }

    public Date getDob()
    {
        return mDob;
    }

    public String getEmail()
    {
        return mEmail;
    }

    public String getFullName()
    {
        return mFullName;
    }

    public String getPrimeFunnelUrl()
    {
        return mPrimeFunnelUrl;
    }

    public boolean isOneClick()
    {
        return mOneClick;
    }

    public boolean isPrime()
    {
        return mPrime;
    }

    public boolean isPrimeEligible()
    {
        return mIsPrimeEligible;
    }

    public boolean isSmile()
    {
        return mSmile;
    }

}
