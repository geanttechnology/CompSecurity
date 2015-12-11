// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.data.UserProfile;
import com.ebay.nautilus.domain.net.api.shopping.EbayShoppingApi;
import com.ebay.nautilus.domain.net.api.shopping.GetUserProfileRequest;
import com.ebay.nautilus.domain.net.api.shopping.GetUserProfileResponse;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;
import com.ebay.nautilus.kernel.net.Request;
import com.ebay.nautilus.kernel.net.Response;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            UserContextObservingDataManager, UserContextDataManager

public class UserAvatarUrlDataManager extends UserContextObservingDataManager
{
    public static final class KeyParams extends UserContextObservingDataManager.KeyBase
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public KeyParams createFromParcel(Parcel parcel)
            {
                return UserAvatarUrlDataManager.KEY;
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

        public UserAvatarUrlDataManager create(EbayContext ebaycontext)
        {
            return new UserAvatarUrlDataManager(ebaycontext);
        }

        public volatile UserContextObservingDataManager create(EbayContext ebaycontext)
        {
            return create(ebaycontext);
        }


        protected KeyParams()
        {
        }
    }

    private final class LoadTask extends AsyncTask
    {

        public String avatarLargeUrl;
        public String avatarSmallUrl;
        final UserAvatarUrlDataManager this$0;
        public final String userId;

        protected transient ResultStatus doInBackground(Void avoid[])
        {
            Object obj = currentCountry;
            if (obj != null)
            {
                avoid = new ResultStatusOwner();
                obj = new GetUserProfileRequest(new EbayShoppingApi(((EbayCountry) (obj)).site), userId, "Details");
                obj = (GetUserProfileResponse)safeSendRequest(((Request) (obj)), avoid);
                if (obj != null && ((GetUserProfileResponse) (obj)).result != null)
                {
                    avatarSmallUrl = ((GetUserProfileResponse) (obj)).result.myWorldSmallImage;
                    avatarLargeUrl = ((GetUserProfileResponse) (obj)).result.myWorldLargeImage;
                    if (avatarLargeUrl == null && avatarSmallUrl != null)
                    {
                        avatarLargeUrl = avatarSmallUrl;
                    }
                    return avoid.getResultStatus();
                }
            }
            return null;
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected void onPostExecute(ResultStatus resultstatus)
        {
            super.onPostExecute(resultstatus);
            handleLoadDataResult(this, resultstatus);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((ResultStatus)obj);
        }

        LoadTask(String s)
        {
            this$0 = UserAvatarUrlDataManager.this;
            super();
            userId = s;
            if (s == null)
            {
                throw new NullPointerException("User ID must not be null!");
            } else
            {
                return;
            }
        }
    }

    public static interface Observer
    {

        public abstract void onUserAvatarUrlChanged(UserAvatarUrlDataManager useravatarurldatamanager, String s, String s1);
    }


    public static final KeyParams KEY = new KeyParams();
    public EbayCountry currentCountry;
    private final Map userToTask = new HashMap();
    private final Map userToUrl = new HashMap();

    protected UserAvatarUrlDataManager(EbayContext ebaycontext)
    {
        super(ebaycontext, com/ebay/nautilus/domain/content/dm/UserAvatarUrlDataManager$Observer, KEY);
    }

    private void cancelAllLoaders()
    {
        for (Iterator iterator = userToTask.values().iterator(); iterator.hasNext(); ((LoadTask)iterator.next()).cancel(true)) { }
        userToTask.clear();
    }

    private void handleLoadDataResult(LoadTask loadtask, ResultStatus resultstatus)
    {
        String s = loadtask.userId;
        userToTask.remove(s);
        if (resultstatus != null && !resultstatus.hasError())
        {
            loadtask = loadtask.avatarLargeUrl;
            userToUrl.put(s, loadtask);
            ((Observer)dispatcher).onUserAvatarUrlChanged(this, s, loadtask);
        }
    }

    public String getDataForUserIfExists(String s)
    {
        return (String)userToUrl.get(s);
    }

    public void invalidateData()
    {
        NautilusKernel.verifyMain();
        userToUrl.clear();
        cancelAllLoaders();
    }

    public void loadData(Observer observer)
    {
    }

    public volatile void loadData(Object obj)
    {
        loadData((Observer)obj);
    }

    public void loadDataForUser(Observer observer, String s)
    {
        NautilusKernel.verifyMain();
        if (userToUrl.containsKey(s))
        {
            observer = (Observer)getSafeCallback(observer);
            if (observer != null)
            {
                observer.onUserAvatarUrlChanged(this, s, (String)userToUrl.get(s));
            }
        } else
        if (!userToTask.containsKey(s))
        {
            observer = new LoadTask(s);
            userToTask.put(s, observer);
            executeOnThreadPool(observer, new Void[0]);
            return;
        }
    }

    public void onCurrentCountryChanged(UserContextDataManager usercontextdatamanager, EbayCountry ebaycountry)
    {
        currentCountry = ebaycountry;
    }



}
