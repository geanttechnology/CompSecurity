// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.dm.listingdraft.ListingDraftOperation;
import com.ebay.nautilus.domain.data.LdsField;
import com.ebay.nautilus.domain.data.ListingDraft;
import com.ebay.nautilus.domain.data.UnifiedStream.ContentSourceEnum;
import com.ebay.nautilus.domain.dcs.DcsNautilusBoolean;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import com.ebay.nautilus.domain.net.api.lds.DeleteSavedListingDraftsRequest;
import com.ebay.nautilus.domain.net.api.lds.GetSavedListingDraftsRequest;
import com.ebay.nautilus.domain.net.api.lds.LdsRequestParams;
import com.ebay.nautilus.domain.net.api.lds.LdsResponse;
import com.ebay.nautilus.domain.net.api.lds.ListingCategoryFilters;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.net.Request;
import com.ebay.nautilus.kernel.net.Response;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            UserContextObservingDataManager, UssContentsDataManager, UserContextDataManager

public final class SavedListingDraftDataManager extends UserContextObservingDataManager
{
    private final class DeleteTask extends AsyncTask
    {

        private final EbayCountry country;
        private final ArrayList draftIds;
        private final String iafToken;
        private final ArrayList motorsDraftIds;
        final SavedListingDraftDataManager this$0;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            if (country != null && iafToken != null && (draftIds != null || motorsDraftIds != null)) goto _L2; else goto _L1
_L1:
            return null;
_L2:
            avoid = new LdsRequestParams(ListingDraftOperation.DELETE_SAVED_DRAFTS);
            avoid.iafToken = iafToken;
            avoid.site = country.site;
            if (draftIds != null && !draftIds.isEmpty())
            {
                DeleteSavedListingDraftsRequest deletesavedlistingdraftsrequest = new DeleteSavedListingDraftsRequest(avoid, draftIds);
                sendRequest(deletesavedlistingdraftsrequest);
            }
            if (motorsDraftIds == null || motorsDraftIds.isEmpty()) goto _L1; else goto _L3
_L3:
            avoid.site = EbaySite.MOTOR;
            avoid = new DeleteSavedListingDraftsRequest(avoid, motorsDraftIds);
            sendRequest(avoid);
            return null;
            avoid;
            return null;
        }

        public DeleteTask(EbayCountry ebaycountry, Authentication authentication, ArrayList arraylist, ArrayList arraylist1)
        {
            this$0 = SavedListingDraftDataManager.this;
            super();
            country = ebaycountry;
            if (authentication != null)
            {
                savedlistingdraftdatamanager = authentication.iafToken;
            } else
            {
                savedlistingdraftdatamanager = null;
            }
            iafToken = SavedListingDraftDataManager.this;
            draftIds = arraylist;
            motorsDraftIds = arraylist1;
        }
    }

    public static final class DispatchType extends Enum
    {

        private static final DispatchType $VALUES[];
        public static final DispatchType ADD;
        public static final DispatchType DELETE;
        public static final DispatchType LOAD;
        public static final DispatchType REMOVE;
        public static final DispatchType UPDATE;

        public static DispatchType valueOf(String s)
        {
            return (DispatchType)Enum.valueOf(com/ebay/nautilus/domain/content/dm/SavedListingDraftDataManager$DispatchType, s);
        }

        public static DispatchType[] values()
        {
            return (DispatchType[])$VALUES.clone();
        }

        static 
        {
            LOAD = new DispatchType("LOAD", 0);
            UPDATE = new DispatchType("UPDATE", 1);
            DELETE = new DispatchType("DELETE", 2);
            REMOVE = new DispatchType("REMOVE", 3);
            ADD = new DispatchType("ADD", 4);
            $VALUES = (new DispatchType[] {
                LOAD, UPDATE, DELETE, REMOVE, ADD
            });
        }

        private DispatchType(String s, int i)
        {
            super(s, i);
        }
    }

    public static class DraftIdWithSite
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public DraftIdWithSite createFromParcel(Parcel parcel)
            {
                return new DraftIdWithSite(parcel);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public DraftIdWithSite[] newArray(int i)
            {
                return new DraftIdWithSite[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        public String draftId;
        public int siteId;

        public int describeContents()
        {
            return 0;
        }

        public boolean equals(Object obj)
        {
            if (obj instanceof DraftIdWithSite)
            {
                if (obj == this)
                {
                    return true;
                }
                obj = (DraftIdWithSite)obj;
                if (((DraftIdWithSite) (obj)).siteId == siteId && ((DraftIdWithSite) (obj)).draftId.equals(draftId))
                {
                    return true;
                }
            }
            return false;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            parcel.writeString(draftId);
            parcel.writeInt(siteId);
        }


        public DraftIdWithSite(int i, String s)
        {
            siteId = i;
            draftId = s;
        }

        private DraftIdWithSite(Parcel parcel)
        {
            draftId = parcel.readString();
            siteId = parcel.readInt();
        }

    }

    public static final class KeyParams extends UserContextObservingDataManager.KeyBase
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public KeyParams createFromParcel(Parcel parcel)
            {
                return SavedListingDraftDataManager.KEY;
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

        public SavedListingDraftDataManager create(EbayContext ebaycontext)
        {
            return new SavedListingDraftDataManager(ebaycontext, this);
        }

        public volatile UserContextObservingDataManager create(EbayContext ebaycontext)
        {
            return create(ebaycontext);
        }

        public boolean equals(Object obj)
        {
            return obj == this || (obj instanceof KeyParams);
        }


        public KeyParams()
        {
        }
    }

    private final class LoadTask extends AsyncTask
    {

        private final EbayCountry country;
        private final String iafToken;
        LdsResponse response;
        final SavedListingDraftDataManager this$0;

        protected transient Content doInBackground(Void avoid[])
        {
            if (country == null || iafToken == null)
            {
                return null;
            }
            Object obj = getDraftFilterConfig();
            LdsRequestParams ldsrequestparams;
            com.ebay.nautilus.kernel.content.ResultStatus.Message message;
            try
            {
                ldsrequestparams = new LdsRequestParams(ListingDraftOperation.GET_SAVED_DRAFTS);
                ldsrequestparams.iafToken = iafToken;
                ldsrequestparams.site = country.site;
                response = (LdsResponse)sendRequest(new GetSavedListingDraftsRequest(ldsrequestparams, ((com.ebay.nautilus.domain.net.api.lds.GetSavedListingDraftsRequest.DraftFilterConfig) (obj))));
                avoid = response.getResultStatus();
                message = avoid.getFirstError();
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                return null;
            }
            if (message == null)
            {
                break MISSING_BLOCK_LABEL_126;
            }
            if ("network".equals(message.getCategory()))
            {
                avoid.setCanRetry(true);
            }
            return new Content(null, avoid);
            if (EbaySite.US.equals(country.site))
            {
                SavedListingDraftDataManager.filterMotorsFromSite0(response.drafts);
                ldsrequestparams.site = EbaySite.MOTOR;
                obj = (LdsResponse)sendRequest(new GetSavedListingDraftsRequest(ldsrequestparams, ((com.ebay.nautilus.domain.net.api.lds.GetSavedListingDraftsRequest.DraftFilterConfig) (obj))));
                if (!((LdsResponse) (obj)).getResultStatus().hasError())
                {
                    response.drafts.addAll(((LdsResponse) (obj)).drafts);
                }
                Collections.sort(response.drafts, new Comparator() {

                    final LoadTask this$1;

                    public int compare(ListingDraft listingdraft, ListingDraft listingdraft1)
                    {
                        return listingdraft1.lastModified.getDateValue().compareTo(listingdraft.lastModified.getDateValue());
                    }

                    public volatile int compare(Object obj, Object obj1)
                    {
                        return compare((ListingDraft)obj, (ListingDraft)obj1);
                    }

            
            {
                this$1 = LoadTask.this;
                super();
            }
                });
            }
            avoid = new Content(response.drafts, avoid);
            return avoid;
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected void onPostExecute(Content content1)
        {
            super.onPostExecute(content1);
            if (loadTask == this)
            {
                loadTask = null;
            }
            if (content1 == null)
            {
                return;
            }
            if (!content1.getStatus().hasError())
            {
                content = content1;
            }
            ((Observer)
// JavaClassFileOutputException: get_constant: invalid tag

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Content)obj);
        }

        public LoadTask(EbayCountry ebaycountry, Authentication authentication)
        {
            this$0 = SavedListingDraftDataManager.this;
            super();
            country = ebaycountry;
            if (authentication != null)
            {
                savedlistingdraftdatamanager = authentication.iafToken;
            } else
            {
                savedlistingdraftdatamanager = null;
            }
            iafToken = SavedListingDraftDataManager.this;
        }
    }

    public static interface Observer
    {

        public abstract void onContentChanged(Content content1, DispatchType dispatchtype);
    }


    public static final KeyParams KEY = new KeyParams();
    private Content content;
    private boolean isCountryInitialized;
    private boolean isUserInitialized;
    private LoadTask loadTask;
    private boolean refreshNextLoad;

    private SavedListingDraftDataManager(EbayContext ebaycontext, KeyParams keyparams)
    {
        UserContextObservingDataManager(ebaycontext, com/ebay/nautilus/domain/content/dm/SavedListingDraftDataManager$Observer, keyparams);
        content = null;
        isUserInitialized = false;
        isCountryInitialized = false;
        refreshNextLoad = false;
    }


    private static void filterMotorsFromSite0(ArrayList arraylist)
    {
        ArrayList arraylist1 = new ArrayList();
        Iterator iterator = arraylist.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ListingDraft listingdraft = (ListingDraft)iterator.next();
            if (!TextUtils.isEmpty(listingdraft.category.getStringValue()) && ListingCategoryFilters.isMotorsCategoryPath(listingdraft.categoryIdPath.getStringValue().replace(" > ", ":")))
            {
                arraylist1.add(listingdraft);
            }
        } while (true);
        arraylist.removeAll(arraylist1);
    }

    private ListingDraft findByDraftId(String s)
    {
        for (Iterator iterator = ((List)content.getData()).iterator(); iterator.hasNext();)
        {
            ListingDraft listingdraft = (ListingDraft)iterator.next();
            if (s.equals(listingdraft.id))
            {
                return listingdraft;
            }
        }

        return null;
    }

    public void addDraft(ListingDraft listingdraft)
    {
        NautilusKernel.verifyMain();
        if (listingdraft != null)
        {
            UssContentsDataManager.invalidateSellChannelData(getEbayContext(), new ContentSourceEnum[] {
                ContentSourceEnum.LISTING_DRAFT
            });
            if (content == null)
            {
                refreshNextLoad = true;
                return;
            }
            if (findByDraftId(listingdraft.id) == null)
            {
                listingdraft.lastModified = new LdsField();
                listingdraft.lastModified.replaceSelectedValue(EbayDateUtils.format(new Date()));
                ((List)content.getData()).add(0, listingdraft);
                ((Observer)dispatcher).onContentChanged(content, DispatchType.ADD);
                return;
            }
        }
    }

    public void deleteDrafts(ArrayList arraylist)
    {
        NautilusKernel.verifyMain();
        if (content == null || arraylist == null)
        {
            return;
        }
        ArrayList arraylist1 = new ArrayList();
        ListingDraft listingdraft;
        for (arraylist = arraylist.iterator(); arraylist.hasNext(); arraylist1.add(new DraftIdWithSite(listingdraft.siteId, listingdraft.id)))
        {
            listingdraft = (ListingDraft)arraylist.next();
        }

        deleteDraftsById(arraylist1);
    }

    public void deleteDraftsById(ArrayList arraylist)
    {
        NautilusKernel.verifyMain();
        if (content == null || arraylist == null)
        {
            return;
        }
        ArrayList arraylist1 = new ArrayList();
        List list = (List)content.getData();
        ArrayList arraylist2 = new ArrayList();
        ArrayList arraylist3 = new ArrayList();
        Iterator iterator = list.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ListingDraft listingdraft = (ListingDraft)iterator.next();
            if (arraylist.contains(new DraftIdWithSite(listingdraft.siteId, listingdraft.id)))
            {
                arraylist1.add(listingdraft);
                if (listingdraft.siteId == 100)
                {
                    arraylist3.add(listingdraft.id);
                } else
                {
                    arraylist2.add(listingdraft.id);
                }
            }
        } while (true);
        list.removeAll(arraylist1);
        UssContentsDataManager.invalidateSellChannelData(getEbayContext(), new ContentSourceEnum[] {
            ContentSourceEnum.LISTING_DRAFT
        });
        ((Observer)dispatcher).onContentChanged(content, DispatchType.DELETE);
        executeOnThreadPool(new DeleteTask(getCurrentCountry(), getCurrentUser(), arraylist2, arraylist3), new Void[0]);
    }

    com.ebay.nautilus.domain.net.api.lds.GetSavedListingDraftsRequest.DraftFilterConfig getDraftFilterConfig()
    {
        DeviceConfiguration deviceconfiguration = DeviceConfiguration.getAsync();
        com.ebay.nautilus.domain.net.api.lds.GetSavedListingDraftsRequest.DraftFilterConfig draftfilterconfig = new DraftFilterConfig();
        draftfilterconfig.androidMotors = deviceconfiguration.get(DcsNautilusBoolean.DRAFTS_ANDROID_MOTORS_APP);
        draftfilterconfig.syi = deviceconfiguration.get(DcsNautilusBoolean.DRAFTS_SYI);
        draftfilterconfig.webnext = deviceconfiguration.get(DcsNautilusBoolean.DRAFTS_WEBNEXT);
        draftfilterconfig.iphone = deviceconfiguration.get(DcsNautilusBoolean.DRAFTS_IPHONE);
        draftfilterconfig.ipad = deviceconfiguration.get(DcsNautilusBoolean.DRAFTS_IPAD);
        draftfilterconfig.windows8 = deviceconfiguration.get(DcsNautilusBoolean.DRAFTS_WINDOWS8);
        draftfilterconfig.windows8Phone = deviceconfiguration.get(DcsNautilusBoolean.DRAFTS_WINDOWS8_PHONE);
        draftfilterconfig.bear = deviceconfiguration.get(DcsNautilusBoolean.DRAFTS_BEAR);
        draftfilterconfig.cub = deviceconfiguration.get(DcsNautilusBoolean.DRAFTS_CUB);
        return draftfilterconfig;
    }

    public void invalidateAndForceReloadData()
    {
        refreshNextLoad = false;
        NautilusKernel.verifyMain();
        if (loadTask != null)
        {
            loadTask.cancel(true);
            loadTask = null;
        }
        content = null;
        loadTask = new LoadTask(getCurrentCountry(), getCurrentUser());
        UssContentsDataManager.invalidateSellChannelData(getEbayContext(), new ContentSourceEnum[] {
            ContentSourceEnum.LISTING_DRAFT
        });
        executeOnThreadPool(loadTask, new Void[0]);
    }

    public void loadData(Observer observer)
    {
        NautilusKernel.verifyMain();
        if (loadTask == null)
        {
            if (content == null)
            {
                refreshNextLoad = false;
                loadTask = new LoadTask(getCurrentCountry(), getCurrentUser());
                executeOnThreadPool(loadTask, new Void[0]);
                return;
            }
            if (refreshNextLoad)
            {
                invalidateAndForceReloadData();
                return;
            }
            if (observer != null)
            {
                observer.onContentChanged(content, DispatchType.ADD);
                return;
            }
        }
    }

    public volatile void loadData(Object obj)
    {
        loadData((Observer)obj);
    }

    public void onCurrentCountryChanged(UserContextDataManager usercontextdatamanager, EbayCountry ebaycountry)
    {
        onCurrentCountryChanged(usercontextdatamanager, ebaycountry);
        if (!isCountryInitialized)
        {
            isCountryInitialized = true;
            return;
        } else
        {
            invalidateAndForceReloadData();
            return;
        }
    }

    public void onCurrentUserChanged(UserContextDataManager usercontextdatamanager, String s, String s1, boolean flag)
    {
        onCurrentUserChanged(usercontextdatamanager, s, s1, flag);
        if (!isUserInitialized)
        {
            isUserInitialized = true;
        } else
        if (!flag)
        {
            invalidateAndForceReloadData();
            return;
        }
    }

    public void removeDraft(String s)
    {
        NautilusKernel.verifyMain();
        if (s == null)
        {
            return;
        }
        UssContentsDataManager.invalidateSellChannelData(getEbayContext(), new ContentSourceEnum[] {
            ContentSourceEnum.LISTING_DRAFT, ContentSourceEnum.SELLING_UTILITY
        });
        if (content == null)
        {
            refreshNextLoad = true;
            return;
        }
        List list = (List)content.getData();
        Object obj = null;
        Iterator iterator = list.iterator();
        ListingDraft listingdraft;
        do
        {
            listingdraft = obj;
            if (!iterator.hasNext())
            {
                break;
            }
            listingdraft = (ListingDraft)iterator.next();
        } while (!s.equals(listingdraft.id));
        if (listingdraft != null)
        {
            list.remove(listingdraft);
        }
        ((Observer)dispatcher).onContentChanged(content, DispatchType.REMOVE);
    }

    public void updateDraft(ListingDraft listingdraft)
    {
        NautilusKernel.verifyMain();
        if (listingdraft != null)
        {
            UssContentsDataManager.invalidateSellChannelData(getEbayContext(), new ContentSourceEnum[] {
                ContentSourceEnum.LISTING_DRAFT
            });
            if (content == null)
            {
                refreshNextLoad = true;
                return;
            }
            ListingDraft listingdraft1 = findByDraftId(listingdraft.id);
            if (listingdraft1 != null)
            {
                if (!listingdraft.equals(listingdraft1))
                {
                    listingdraft.lastModified = new LdsField();
                    listingdraft.lastModified.replaceSelectedValue(EbayDateUtils.format(new Date()));
                    List list = (List)content.getData();
                    list.add(list.indexOf(listingdraft1), listingdraft);
                    list.remove(listingdraft1);
                }
                ((Observer)dispatcher).onContentChanged(content, DispatchType.UPDATE);
                return;
            }
        }
    }







/*
    static LoadTask access$402(SavedListingDraftDataManager savedlistingdraftdatamanager, LoadTask loadtask)
    {
        savedlistingdraftdatamanager.loadTask = loadtask;
        return loadtask;
    }

*/


/*
    static Content access$502(SavedListingDraftDataManager savedlistingdraftdatamanager, Content content1)
    {
        savedlistingdraftdatamanager.content = content1;
        return content1;
    }

*/



}
