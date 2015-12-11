// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.net.api.events.EventDetailsRequest;
import com.ebay.nautilus.domain.net.api.events.EventDetailsResponse;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.net.Request;
import com.ebay.nautilus.kernel.net.Response;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            UserContextObservingDataManager

public class EventDetailsDataManager extends UserContextObservingDataManager
{
    public static final class KeyParams extends UserContextObservingDataManager.KeyBase
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public KeyParams createFromParcel(Parcel parcel)
            {
                return new KeyParams(parcel.readString());
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
        public final String eventSeoName;

        protected EventDetailsDataManager create(EbayContext ebaycontext)
        {
            return new EventDetailsDataManager(ebaycontext, this);
        }

        protected volatile UserContextObservingDataManager create(EbayContext ebaycontext)
        {
            return create(ebaycontext);
        }

        public boolean equals(Object obj)
        {
            return (obj instanceof KeyParams) && ((KeyParams)obj).eventSeoName.equals(eventSeoName);
        }

        public int hashCode()
        {
            return super.hashCode() * 31 + eventSeoName.hashCode();
        }

        public String toString()
        {
            return (new StringBuilder()).append("eventName:").append(eventSeoName).toString();
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            parcel.writeString(eventSeoName);
        }


        public KeyParams(String s)
        {
            eventSeoName = s;
            if (s == null)
            {
                throw new IllegalStateException("eventName must be non-null.");
            } else
            {
                return;
            }
        }
    }

    private final class LoadTask extends AsyncTask
    {

        private final Authentication auth;
        private final EbayCountry country;
        final EventDetailsDataManager this$0;

        protected transient EventDetailsResponse doInBackground(KeyParams akeyparams[])
        {
            String s;
            EventDetailsDataManager eventdetailsdatamanager;
            eventdetailsdatamanager = EventDetailsDataManager.this;
            if (auth == null)
            {
                break MISSING_BLOCK_LABEL_48;
            }
            s = auth.iafToken;
_L1:
            akeyparams = (EventDetailsResponse)eventdetailsdatamanager.sendRequest(new EventDetailsRequest(s, country, akeyparams[0].eventSeoName));
            return akeyparams;
            s = null;
              goto _L1
            akeyparams;
            return null;
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((KeyParams[])aobj);
        }

        protected void onCancelled()
        {
            super.onCancelled();
            handleLoadDataResult(this, null);
        }

        protected void onPostExecute(EventDetailsResponse eventdetailsresponse)
        {
            super.onPostExecute(eventdetailsresponse);
            handleLoadDataResult(this, eventdetailsresponse);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((EventDetailsResponse)obj);
        }

        public LoadTask(Authentication authentication, EbayCountry ebaycountry)
        {
            this$0 = EventDetailsDataManager.this;
            super();
            auth = authentication;
            country = ebaycountry;
        }
    }

    public static interface Observer
    {

        public abstract void onEventDetailsLoaded(EventDetailsDataManager eventdetailsdatamanager, com.ebay.nautilus.domain.net.api.events.EventDetailsResponse.EventDetails eventdetails);
    }


    private LoadTask loadTask;

    EventDetailsDataManager(EbayContext ebaycontext, KeyParams keyparams)
    {
        super(ebaycontext, com/ebay/nautilus/domain/content/dm/EventDetailsDataManager$Observer, keyparams);
    }

    void handleLoadDataResult(LoadTask loadtask, EventDetailsResponse eventdetailsresponse)
    {
        loadTask = null;
        if (eventdetailsresponse == null)
        {
            return;
        }
        Object obj = null;
        loadtask = obj;
        if (eventdetailsresponse.response != null)
        {
            loadtask = obj;
            if (eventdetailsresponse.response.events != null)
            {
                loadtask = obj;
                if (!eventdetailsresponse.response.events.isEmpty())
                {
                    loadtask = (com.ebay.nautilus.domain.net.api.events.EventDetailsResponse.EventDetails)eventdetailsresponse.response.events.get(0);
                }
            }
        }
        ((Observer)dispatcher).onEventDetailsLoaded(this, loadtask);
    }

    public void loadData()
    {
        NautilusKernel.verifyMain();
        if (loadTask == null)
        {
            EbayCountry ebaycountry = getCurrentCountry();
            if (ebaycountry == null)
            {
                throw new IllegalStateException("getCurrentCountry() returned null");
            }
            loadTask = new LoadTask(getCurrentUser(), ebaycountry);
            executeOnThreadPool(loadTask, new KeyParams[] {
                (KeyParams)getParams()
            });
        }
    }

    public void loadData(Observer observer)
    {
    }

    public volatile void loadData(Object obj)
    {
        loadData((Observer)obj);
    }

}
