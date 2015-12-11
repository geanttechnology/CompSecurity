// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.data.UserProfile;
import com.ebay.nautilus.domain.net.api.shopping.EbayShoppingApi;
import com.ebay.nautilus.domain.net.api.shopping.GetUserProfileRequest;
import com.ebay.nautilus.domain.net.api.shopping.GetUserProfileResponse;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            UserAvatarUrlDataManager

private final class userId extends AsyncTask
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
            obj = (GetUserProfileResponse)UserAvatarUrlDataManager.access$000(UserAvatarUrlDataManager.this, ((com.ebay.nautilus.kernel.net.Request) (obj)), avoid);
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
        UserAvatarUrlDataManager.access$100(UserAvatarUrlDataManager.this, this, resultstatus);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((ResultStatus)obj);
    }

    (String s)
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
