// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.EbayContext;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            UserContext

public final class UserContextDataManager extends DataManager
{
    public static final class KeyParams extends com.ebay.nautilus.domain.content.DataManager.DataManagerKeyParams
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public KeyParams createFromParcel(Parcel parcel)
            {
                return UserContextDataManager.KEY;
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public KeyParams[] newArray(int i)
            {
                return new KeyParams[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };

        public volatile DataManager createManager(EbayContext ebaycontext)
        {
            return createManager(ebaycontext);
        }

        public UserContextDataManager createManager(EbayContext ebaycontext)
        {
            return new UserContextDataManager(ebaycontext);
        }

        public boolean equals(Object obj)
        {
            return obj instanceof KeyParams;
        }

        public String toString()
        {
            return "UserContextDataManager.KEY";
        }


        public KeyParams()
        {
        }
    }

    public static interface Observer
    {

        public abstract void onCurrentCountryChanged(UserContextDataManager usercontextdatamanager, EbayCountry ebaycountry);

        public abstract void onCurrentUserChanged(UserContextDataManager usercontextdatamanager, String s, String s1, boolean flag);

        public abstract void onUserSignedInStatusChanged(UserContextDataManager usercontextdatamanager, String s, String s1, String s2);
    }


    public static final KeyParams KEY = new KeyParams();
    private final UserContext userContext;

    UserContextDataManager(EbayContext ebaycontext)
    {
        super(ebaycontext, com/ebay/nautilus/domain/content/dm/UserContextDataManager$Observer);
        userContext = (UserContext)ebaycontext.getExtension(com/ebay/nautilus/domain/content/dm/UserContext);
    }

    public List getAllUsers()
    {
        return userContext.getAllUsers();
    }

    public EbayCountry getCurrentCountry()
    {
        return userContext.getCurrentCountry();
    }

    public Authentication getCurrentUser()
    {
        return userContext.getCurrentUser();
    }

    public KeyParams getParams()
    {
        return KEY;
    }

    public volatile Object getParams()
    {
        return getParams();
    }

    public void loadData(Observer observer)
    {
        NautilusKernel.verifyMain();
        if (observer != null)
        {
            String s1 = null;
            String s = null;
            Authentication authentication = userContext.getCurrentUser();
            if (authentication != null)
            {
                s1 = authentication.user;
                s = authentication.iafToken;
            }
            observer.onCurrentUserChanged(this, s1, s, false);
            observer.onCurrentCountryChanged(this, userContext.ensureCountry());
        }
    }

    public volatile void loadData(Object obj)
    {
        loadData((Observer)obj);
    }

    final void notifyCurrentCountryChanged(EbayCountry ebaycountry)
    {
        ((Observer)dispatcher).onCurrentCountryChanged(this, ebaycountry);
    }

    final void notifyCurrentUserChanged(String s, String s1, boolean flag)
    {
        ((Observer)dispatcher).onCurrentUserChanged(this, s, s1, flag);
    }

    final void notifyUserSignedInStatusChanged(String s, String s1, String s2)
    {
        ((Observer)dispatcher).onUserSignedInStatusChanged(this, s, s1, s2);
    }

    public void setCurrentCountry(EbayCountry ebaycountry)
    {
        userContext.setCurrentCountry(ebaycountry);
    }

    public boolean setCurrentUser(String s)
    {
        return userContext.setCurrentUser(s);
    }

    public void signInUserAndSetCurrent(String s, String s1)
    {
        userContext.signInUserAndSetCurrent(s, s1);
    }

    public void signOutCurrentUser()
    {
        userContext.signOutCurrentUser();
    }

    public void signOutUser(String s)
    {
        userContext.signOutUser(s);
    }

}
