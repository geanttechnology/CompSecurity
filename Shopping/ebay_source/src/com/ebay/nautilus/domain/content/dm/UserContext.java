// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.EbayContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            UserContextDataManager

public class UserContext
{

    private boolean countryInitialized;
    private EbayCountry currentCountry;
    private String currentUserId;
    private int currentUserIndex;
    private final EbayContext ebayContext;
    private boolean userInitialized;
    private final ArrayList users = new ArrayList();

    public UserContext(EbayContext ebaycontext)
    {
        currentUserIndex = -1;
        ebayContext = ebaycontext.getApplicationContext();
    }

    protected static Authentication createAuth(String s, String s1)
    {
        return new Authentication(s.toLowerCase(Locale.getDefault()), s1);
    }

    private static int indexOfUser(List list, String s)
    {
        int j = list.size();
        for (int i = 0; i < j; i++)
        {
            if (((Authentication)list.get(i)).user.equalsIgnoreCase(s))
            {
                return i;
            }
        }

        return -1;
    }

    private void initializeCountry()
    {
        if (!countryInitialized)
        {
            countryInitialized = true;
            currentCountry = onInitializeCountry();
        }
    }

    private void initializeUser()
    {
        if (!userInitialized)
        {
            userInitialized = true;
            currentUserIndex = onInitializeUser(users);
            if (currentUserIndex < -1 || currentUserIndex >= users.size())
            {
                throw new IllegalArgumentException("currentUserIndex must be a valid index or -1!");
            }
            for (Iterator iterator = users.iterator(); iterator.hasNext();)
            {
                if ((Authentication)iterator.next() == null)
                {
                    throw new IllegalArgumentException("null is not allowed");
                }
            }

            String s;
            if (currentUserIndex > -1)
            {
                s = ((Authentication)users.get(currentUserIndex)).user;
            } else
            {
                s = "";
            }
            currentUserId = s;
        }
    }

    public final EbayCountry ensureCountry()
    {
        this;
        JVM INSTR monitorenter ;
        EbayCountry ebaycountry;
        initializeCountry();
        if (currentCountry == null)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        ebaycountry = currentCountry;
_L1:
        this;
        JVM INSTR monitorexit ;
        return ebaycountry;
        ebaycountry = onDefaultCountry();
          goto _L1
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final List getAllUsers()
    {
        ArrayList arraylist1;
        synchronized (users)
        {
            initializeUser();
            arraylist1 = new ArrayList(users);
        }
        return arraylist1;
        exception;
        arraylist;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final EbayCountry getCurrentCountry()
    {
        this;
        JVM INSTR monitorenter ;
        EbayCountry ebaycountry;
        initializeCountry();
        ebaycountry = currentCountry;
        this;
        JVM INSTR monitorexit ;
        return ebaycountry;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final Authentication getCurrentUser()
    {
        ArrayList arraylist = users;
        arraylist;
        JVM INSTR monitorenter ;
        Object obj;
        initializeUser();
        if (currentUserIndex == -1)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        obj = (Authentication)users.get(currentUserIndex);
_L2:
        return ((Authentication) (obj));
        obj;
        arraylist;
        JVM INSTR monitorexit ;
        throw obj;
        obj = null;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public final String getCurrentUserId()
    {
        String s;
        synchronized (users)
        {
            initializeUser();
            s = currentUserId;
        }
        return s;
        exception;
        arraylist;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected void notifyCurrentCountryChanged(EbayCountry ebaycountry)
    {
        UserContextDataManager usercontextdatamanager = (UserContextDataManager)DataManager.getIfExists(ebayContext, UserContextDataManager.KEY);
        if (usercontextdatamanager != null)
        {
            usercontextdatamanager.notifyCurrentCountryChanged(ebaycountry);
        }
    }

    protected void notifyCurrentUserChanged(String s, String s1, boolean flag)
    {
        UserContextDataManager usercontextdatamanager = (UserContextDataManager)DataManager.getIfExists(ebayContext, UserContextDataManager.KEY);
        if (usercontextdatamanager != null)
        {
            usercontextdatamanager.notifyCurrentUserChanged(s, s1, flag);
        }
    }

    protected void notifyUserSignedInStatusChanged(String s, String s1, String s2)
    {
        UserContextDataManager usercontextdatamanager = (UserContextDataManager)DataManager.getIfExists(ebayContext, UserContextDataManager.KEY);
        if (usercontextdatamanager != null)
        {
            usercontextdatamanager.notifyUserSignedInStatusChanged(s, s1, s2);
        }
    }

    protected EbayCountry onDefaultCountry()
    {
        return EbayCountry.getInstance(EbaySite.US);
    }

    protected EbayCountry onInitializeCountry()
    {
        return null;
    }

    protected int onInitializeUser(List list)
    {
        return -1;
    }

    public final void setCurrentCountry(EbayCountry ebaycountry)
    {
        NautilusKernel.verifyMain();
        this;
        JVM INSTR monitorenter ;
        initializeCountry();
        if (ebaycountry != null)
        {
            break MISSING_BLOCK_LABEL_23;
        }
        if (currentCountry != null)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        if (!ebaycountry.equals(currentCountry))
        {
            break MISSING_BLOCK_LABEL_42;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        ebaycountry;
        this;
        JVM INSTR monitorexit ;
        throw ebaycountry;
        currentCountry = ebaycountry;
        this;
        JVM INSTR monitorexit ;
        notifyCurrentCountryChanged(ebaycountry);
        return;
    }

    public final boolean setCurrentUser(String s)
    {
        NautilusKernel.verifyMain();
        ArrayList arraylist = users;
        arraylist;
        JVM INSTR monitorenter ;
        int i;
        initializeUser();
        i = indexOfUser(users, s);
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        if (i != currentUserIndex)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        arraylist;
        JVM INSTR monitorexit ;
        return false;
        currentUserIndex = i;
        s = (Authentication)users.get(i);
        currentUserId = ((Authentication) (s)).user;
        arraylist;
        JVM INSTR monitorexit ;
        notifyCurrentUserChanged(((Authentication) (s)).user, ((Authentication) (s)).iafToken, false);
        return true;
        s;
        arraylist;
        JVM INSTR monitorexit ;
        throw s;
    }

    public final void signInUserAndSetCurrent(String s, String s1)
    {
        String s2;
        boolean flag1;
        flag1 = true;
        NautilusKernel.verifyMain();
        s2 = null;
        ArrayList arraylist1 = users;
        arraylist1;
        JVM INSTR monitorenter ;
        int i;
        initializeUser();
        i = indexOfUser(users, s);
        if (i != -1) goto _L2; else goto _L1
_L1:
        currentUserIndex = 0;
        ArrayList arraylist = users;
        s = createAuth(s, s1);
        arraylist.add(0, s);
        boolean flag = true;
_L5:
        currentUserId = ((Authentication) (s)).user;
        arraylist1;
        JVM INSTR monitorexit ;
        notifyUserSignedInStatusChanged(((Authentication) (s)).user, s2, s1);
        s = ((Authentication) (s)).user;
        Object obj;
        if (flag)
        {
            flag1 = false;
        }
        notifyCurrentUserChanged(s, s1, flag1);
        return;
_L2:
        obj = (Authentication)users.get(i);
        s2 = ((Authentication) (obj)).iafToken;
        if (currentUserIndex != i)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (s2.equals(s1)) goto _L4; else goto _L3
_L3:
        obj = users;
        s = createAuth(s, s1);
        ((ArrayList) (obj)).set(i, s);
_L7:
        currentUserIndex = i;
          goto _L5
        s;
        arraylist1;
        JVM INSTR monitorexit ;
        throw s;
_L4:
        s = ((String) (obj));
        if (flag) goto _L7; else goto _L6
_L6:
        arraylist1;
        JVM INSTR monitorexit ;
    }

    public final void signOutCurrentUser()
    {
label0:
        {
            NautilusKernel.verifyMain();
            synchronized (users)
            {
                initializeUser();
                if (currentUserIndex != -1)
                {
                    break label0;
                }
            }
            return;
        }
        Authentication authentication;
        authentication = (Authentication)users.remove(currentUserIndex);
        currentUserIndex = -1;
        currentUserId = "";
        arraylist;
        JVM INSTR monitorexit ;
        notifyUserSignedInStatusChanged(authentication.user, authentication.iafToken, null);
        notifyCurrentUserChanged(null, null, false);
        return;
        exception;
        arraylist;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void signOutUser(String s)
    {
        int i;
        NautilusKernel.verifyMain();
        synchronized (users)
        {
            initializeUser();
        }
        i = indexOfUser(users, s);
        if (i == -1)
        {
            return;
        }
        break MISSING_BLOCK_LABEL_36;
        s;
        arraylist;
        JVM INSTR monitorexit ;
        throw s;
        if (i == currentUserIndex)
        {
            signOutCurrentUser();
            return;
        }
        Authentication authentication;
        synchronized (users)
        {
            authentication = (Authentication)users.remove(i);
            if (i < currentUserIndex)
            {
                currentUserIndex = currentUserIndex - 1;
            }
        }
        notifyUserSignedInStatusChanged(authentication.user, authentication.iafToken, null);
        return;
        exception;
        s;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
