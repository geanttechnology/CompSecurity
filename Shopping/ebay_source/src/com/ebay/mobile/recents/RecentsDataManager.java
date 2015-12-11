// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.recents;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.ebay.common.Preferences;
import com.ebay.common.content.EbayCguidGetter;
import com.ebay.mobile.MyApp;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.content.dm.UssContentsDataManager;
import com.ebay.nautilus.domain.data.PdsSearchItemAttribute;
import com.ebay.nautilus.domain.data.PdsViewItemAttribute;
import com.ebay.nautilus.domain.data.UnifiedStream.ContentSourceEnum;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.api.pds.PdsGetAttributesRequest;
import com.ebay.nautilus.domain.net.api.pds.PdsGetAttributesResponse;
import com.ebay.nautilus.domain.net.api.pds.PdsSetAttrClearRequest;
import com.ebay.nautilus.domain.net.api.pds.PdsSetAttrRequest;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.net.Request;
import com.ebay.nautilus.kernel.net.Response;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class RecentsDataManager extends DataManager
{
    private abstract class AddRecentBaseTask extends BaseLoadTask
    {

        final RecentsDataManager this$0;

        protected transient ResultStatus startBackgroundTask(Void avoid[])
        {
            try
            {
                avoid = ((EbayResponse)sendRequest(getRequest())).getResultStatus();
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                return null;
            }
            return avoid;
        }

        protected volatile Object startBackgroundTask(Object aobj[])
        {
            return startBackgroundTask((Void[])aobj);
        }

        AddRecentBaseTask(String s)
        {
            this$0 = RecentsDataManager.this;
            super(s);
        }
    }

    private final class AddRecentSearchTask extends AddRecentBaseTask
    {

        final long categoryId;
        final boolean isSellerPrefix;
        final boolean isSpelledCorrectly;
        final String keyword;
        final List list = null;
        final String productPrefix;
        final int searchResultCount;
        final RecentsDataManager this$0;

        protected volatile EbayRequest getRequest()
        {
            return getRequest();
        }

        protected PdsSetAttrRequest getRequest()
        {
            PdsSearchItemAttribute pdssearchitemattribute = new PdsSearchItemAttribute(keyword, categoryId, searchResultCount, isSpelledCorrectly, isSellerPrefix, productPrefix);
            return new PdsSetAttrRequest(iafToken, cguid, site.idString, "10203", pdssearchitemattribute.toString());
        }

        protected void onCancelled(ResultStatus resultstatus)
        {
            super.onCancelled(resultstatus);
            handleAddSearchItemResult(this, null);
        }

        protected volatile void onCancelled(Object obj)
        {
            onCancelled((ResultStatus)obj);
        }

        protected void onPostExecute(ResultStatus resultstatus)
        {
            super.onPostExecute(resultstatus);
            handleAddSearchItemResult(this, resultstatus);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((ResultStatus)obj);
        }

        AddRecentSearchTask(String s, boolean flag, long l, int i, boolean flag1, 
                String s1)
        {
            Object obj = null;
            this$0 = RecentsDataManager.this;
            super(params.iafToken);
            categoryId = l;
            searchResultCount = i;
            isSpelledCorrectly = flag1;
            isSellerPrefix = flag;
            keyword = s;
            recentsdatamanager = obj;
            if (!TextUtils.isEmpty(s1))
            {
                recentsdatamanager = (new StringBuilder()).append(s1).append(":").toString();
            }
            productPrefix = RecentsDataManager.this;
        }
    }

    private final class AddRecentViewedItemTask extends AddRecentBaseTask
    {

        final long categoryId;
        final long itemId;
        final RecentsDataManager this$0;

        protected volatile EbayRequest getRequest()
        {
            return getRequest();
        }

        protected PdsSetAttrRequest getRequest()
        {
            PdsViewItemAttribute pdsviewitemattribute = new PdsViewItemAttribute(itemId, categoryId, site.id);
            return new PdsSetAttrRequest(iafToken, cguid, site.idString, "10297", pdsviewitemattribute.toString());
        }

        protected void onCancelled(ResultStatus resultstatus)
        {
            super.onCancelled(resultstatus);
            handleAddViewItemResult(this, null);
        }

        protected volatile void onCancelled(Object obj)
        {
            onCancelled((ResultStatus)obj);
        }

        protected void onPostExecute(ResultStatus resultstatus)
        {
            super.onPostExecute(resultstatus);
            handleAddViewItemResult(this, resultstatus);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((ResultStatus)obj);
        }

        AddRecentViewedItemTask(long l, long l1)
        {
            this$0 = RecentsDataManager.this;
            super(params.iafToken);
            itemId = l;
            categoryId = l1;
        }
    }

    private abstract class BaseLoadTask extends AsyncTask
    {

        protected String cguid;
        protected final String iafToken;
        private Preferences pref;
        protected final EbaySite site;
        final RecentsDataManager this$0;

        protected final transient Object doInBackground(Object aobj[])
        {
            cguid = EbayCguidGetter.get(getEbayContext(), pref, site, iafToken);
            return startBackgroundTask(aobj);
        }

        protected abstract EbayRequest getRequest();

        protected transient abstract Object startBackgroundTask(Object aobj[]);

        BaseLoadTask(String s)
        {
            this$0 = RecentsDataManager.this;
            super();
            iafToken = s;
            pref = MyApp.getPrefs();
            site = pref.getCurrentSite();
        }
    }

    private abstract class DeleteBaseTask extends BaseLoadTask
    {

        final RecentsDataManager this$0;

        protected transient ResultStatus startBackgroundTask(Void avoid[])
        {
            try
            {
                avoid = ((EbayResponse)sendRequest(getRequest())).getResultStatus();
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                return null;
            }
            return avoid;
        }

        protected volatile Object startBackgroundTask(Object aobj[])
        {
            return startBackgroundTask((Void[])aobj);
        }

        DeleteBaseTask(String s)
        {
            this$0 = RecentsDataManager.this;
            super(s);
        }
    }

    private final class DeleteRecentSearchTask extends DeleteBaseTask
    {

        final RecentsDataManager this$0;

        protected volatile EbayRequest getRequest()
        {
            return getRequest();
        }

        protected PdsSetAttrClearRequest getRequest()
        {
            return new PdsSetAttrClearRequest(iafToken, site, cguid, "10203");
        }

        protected void onCancelled(ResultStatus resultstatus)
        {
            super.onCancelled(resultstatus);
            handleDeleteSearchItemResult(null);
        }

        protected volatile void onCancelled(Object obj)
        {
            onCancelled((ResultStatus)obj);
        }

        protected void onPostExecute(ResultStatus resultstatus)
        {
            super.onPostExecute(resultstatus);
            handleDeleteSearchItemResult(resultstatus);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((ResultStatus)obj);
        }

        DeleteRecentSearchTask()
        {
            this$0 = RecentsDataManager.this;
            super(params.iafToken);
        }
    }

    private final class DeleteRecentViewedItemTask extends DeleteBaseTask
    {

        final RecentsDataManager this$0;

        protected volatile EbayRequest getRequest()
        {
            return getRequest();
        }

        protected PdsSetAttrClearRequest getRequest()
        {
            return new PdsSetAttrClearRequest(iafToken, site, cguid, "10297");
        }

        protected void onCancelled(ResultStatus resultstatus)
        {
            super.onCancelled(resultstatus);
            handleDeleteViewItemResult(null);
        }

        protected volatile void onCancelled(Object obj)
        {
            onCancelled((ResultStatus)obj);
        }

        protected void onPostExecute(ResultStatus resultstatus)
        {
            super.onPostExecute(resultstatus);
            handleDeleteViewItemResult(resultstatus);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((ResultStatus)obj);
        }

        DeleteRecentViewedItemTask()
        {
            this$0 = RecentsDataManager.this;
            super(params.iafToken);
        }
    }

    final class GetRecentDataLoadTask extends BaseLoadTask
    {

        final RecentsDataManager this$0;
        private final boolean wantRecentSearches;
        private final boolean wantRecentlyViewed;

        protected volatile EbayRequest getRequest()
        {
            return getRequest();
        }

        protected PdsGetAttributesRequest getRequest()
        {
            return new PdsGetAttributesRequest(iafToken, site, cguid, wantRecentlyViewed, wantRecentSearches);
        }

        protected void onCancelled(RecentsData recentsdata)
        {
            super.onCancelled(recentsdata);
            handleLoadDataResult(null);
        }

        protected volatile void onCancelled(Object obj)
        {
            onCancelled((RecentsData)obj);
        }

        protected void onPostExecute(RecentsData recentsdata)
        {
            super.onPostExecute(recentsdata);
            handleLoadDataResult(recentsdata);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((RecentsData)obj);
        }

        protected transient RecentsData startBackgroundTask(Object aobj[])
        {
            RecentsData recentsdata;
            try
            {
                aobj = (PdsGetAttributesResponse)sendRequest(getRequest());
                recentsdata = new RecentsData();
                recentsdata.status = ((PdsGetAttributesResponse) (aobj)).getResultStatus();
                if (!((PdsGetAttributesResponse) (aobj)).getResultStatus().hasError())
                {
                    recentsdata.recentSearches = ((PdsGetAttributesResponse) (aobj)).recentSearches;
                }
            }
            // Misplaced declaration of an exception variable
            catch (Object aobj[])
            {
                return null;
            }
            return recentsdata;
        }

        protected volatile Object startBackgroundTask(Object aobj[])
        {
            return startBackgroundTask(aobj);
        }

        GetRecentDataLoadTask(String s, boolean flag, boolean flag1)
        {
            this$0 = RecentsDataManager.this;
            super(s);
            wantRecentlyViewed = flag;
            wantRecentSearches = flag1;
        }
    }

    public static final class KeyParams extends com.ebay.nautilus.domain.content.DataManager.DataManagerKeyParams
    {

        final int hashCode;
        public final String iafToken;
        public final boolean recentlyViewedOnly;

        public RecentsDataManager createManager(EbayContext ebaycontext)
        {
            return new RecentsDataManager(ebaycontext, this);
        }

        public volatile DataManager createManager(EbayContext ebaycontext)
        {
            return createManager(ebaycontext);
        }

        public boolean equals(Object obj)
        {
            if (obj == this)
            {
                return true;
            }
            if (obj != null && obj.getClass() == getClass())
            {
                return TextUtils.equals(((KeyParams)obj).iafToken, iafToken);
            } else
            {
                return false;
            }
        }

        public int hashCode()
        {
            return hashCode;
        }

        public KeyParams(String s)
        {
            this(s, false);
        }

        public KeyParams(String s, boolean flag)
        {
            iafToken = s;
            recentlyViewedOnly = flag;
            if (s == null)
            {
                throw new IllegalArgumentException("KeyParams must be constructed with a valid iafToken");
            }
            int j = com/ebay/mobile/recents/RecentsDataManager$KeyParams.getName().hashCode();
            int k = s.hashCode();
            int i;
            if (flag)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            hashCode = (j * 31 + k) * 31 + i;
        }
    }

    public static interface Observer
    {

        public abstract void onAllSearchItemDeleteComplete(RecentsDataManager recentsdatamanager, Content content);

        public abstract void onAllViewedItemDeleteComplete(RecentsDataManager recentsdatamanager, Content content);

        public abstract void onGetRecentlySearchedData(RecentsDataManager recentsdatamanager, Content content);

        public abstract void onSearchItemAddComplete(RecentsDataManager recentsdatamanager, Content content);

        public abstract void onViewedItemAddComplete(RecentsDataManager recentsdatamanager, Content content);
    }

    private class RecentsData
    {

        private List recentSearches;
        private ResultStatus status;
        final RecentsDataManager this$0;



/*
        static ResultStatus access$002(RecentsData recentsdata, ResultStatus resultstatus)
        {
            recentsdata.status = resultstatus;
            return resultstatus;
        }

*/



/*
        static List access$102(RecentsData recentsdata, List list)
        {
            recentsdata.recentSearches = list;
            return list;
        }

*/

        private RecentsData()
        {
            this$0 = RecentsDataManager.this;
            super();
        }

    }

    public static class SimpleLookUpObserver
        implements Observer
    {

        public void onAllSearchItemDeleteComplete(RecentsDataManager recentsdatamanager, Content content)
        {
        }

        public void onAllViewedItemDeleteComplete(RecentsDataManager recentsdatamanager, Content content)
        {
        }

        public void onGetRecentlySearchedData(RecentsDataManager recentsdatamanager, Content content)
        {
        }

        public void onSearchItemAddComplete(RecentsDataManager recentsdatamanager, Content content)
        {
        }

        public void onViewedItemAddComplete(RecentsDataManager recentsdatamanager, Content content)
        {
        }

        public SimpleLookUpObserver()
        {
        }
    }


    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logTag = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("RecentsDataManager", 3, "Log RecentsDataManager");
    private final KeyParams params;
    private Content recentSearches;

    public RecentsDataManager(EbayContext ebaycontext, KeyParams keyparams)
    {
        super(ebaycontext, com/ebay/mobile/recents/RecentsDataManager$Observer);
        params = keyparams;
    }

    private void handleAddSearchItemResult(AddRecentSearchTask addrecentsearchtask, ResultStatus resultstatus)
    {
        if (resultstatus == null)
        {
            return;
        }
        if (resultstatus.hasError())
        {
            addrecentsearchtask = new Content(resultstatus);
        } else
        {
            ArrayList arraylist = new ArrayList();
            Object obj1 = null;
            Object obj = obj1;
            if (recentSearches != null)
            {
                obj = obj1;
                if (recentSearches.getData() != null)
                {
                    obj = (List)recentSearches.getData();
                }
            }
            addrecentsearchtask = new PdsSearchItemAttribute(addrecentsearchtask.keyword, addrecentsearchtask.categoryId, addrecentsearchtask.searchResultCount, addrecentsearchtask.isSpelledCorrectly, addrecentsearchtask.isSellerPrefix, addrecentsearchtask.productPrefix);
            arraylist.add(addrecentsearchtask);
            if (obj != null)
            {
                obj = ((List) (obj)).iterator();
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        break;
                    }
                    PdsSearchItemAttribute pdssearchitemattribute = (PdsSearchItemAttribute)((Iterator) (obj)).next();
                    if (!pdssearchitemattribute.isKeywordAndPrefixMatch(addrecentsearchtask))
                    {
                        arraylist.add(pdssearchitemattribute);
                    }
                } while (true);
            }
            recentSearches = new Content(Collections.unmodifiableList(arraylist), resultstatus);
            addrecentsearchtask = recentSearches;
        }
        ((Observer)dispatcher).onSearchItemAddComplete(this, addrecentsearchtask);
    }

    private void handleAddViewItemResult(AddRecentViewedItemTask addrecentvieweditemtask, ResultStatus resultstatus)
    {
        if (resultstatus == null)
        {
            return;
        }
        if (resultstatus.hasError())
        {
            addrecentvieweditemtask = new Content(resultstatus);
        } else
        {
            addrecentvieweditemtask = new Content(new PdsViewItemAttribute(addrecentvieweditemtask.itemId, addrecentvieweditemtask.categoryId, addrecentvieweditemtask.site.id), resultstatus);
            invalidateCoordinatedData();
        }
        ((Observer)dispatcher).onViewedItemAddComplete(this, addrecentvieweditemtask);
    }

    private void handleDeleteSearchItemResult(ResultStatus resultstatus)
    {
        if (resultstatus.hasError())
        {
            resultstatus = new Content(resultstatus);
        } else
        {
            recentSearches = new Content(Collections.EMPTY_LIST, resultstatus);
            resultstatus = recentSearches;
        }
        ((Observer)dispatcher).onAllSearchItemDeleteComplete(this, resultstatus);
    }

    private void handleDeleteViewItemResult(ResultStatus resultstatus)
    {
        Content content = new Content(resultstatus);
        if (!resultstatus.hasError())
        {
            invalidateCoordinatedData();
        }
        ((Observer)dispatcher).onAllViewedItemDeleteComplete(this, content);
    }

    private void handleLoadDataResult(RecentsData recentsdata)
    {
        if (recentsdata == null)
        {
            return;
        }
        if (recentsdata.status.hasError())
        {
            recentsdata = new Content(recentsdata.status);
        } else
        {
            recentSearches = new Content(Collections.unmodifiableList(recentsdata.recentSearches), recentsdata.status);
            recentsdata = recentSearches;
        }
        ((Observer)dispatcher).onGetRecentlySearchedData(this, recentsdata);
    }

    private void invalidateCoordinatedData()
    {
        UssContentsDataManager.invalidateActivityChannelData(getEbayContext(), new ContentSourceEnum[] {
            ContentSourceEnum.RECENTLY_VIEWED_ITEMS
        });
        UssContentsDataManager usscontentsdatamanager = (UssContentsDataManager)UssContentsDataManager.get(getEbayContext(), UssContentsDataManager.getContentSourceKeyParams(ContentSourceEnum.RECENTLY_VIEWED_ITEMS));
        if (usscontentsdatamanager != null)
        {
            usscontentsdatamanager.flush();
        }
    }

    public final void addLastViewedItem(long l, long l1)
    {
        NautilusKernel.verifyMain();
        if (l == 0L)
        {
            return;
        } else
        {
            (new AddRecentViewedItemTask(l, l1)).execute(new Void[0]);
            return;
        }
    }

    public void addRecentSearch(String s, boolean flag, long l, int i, boolean flag1, String s1)
    {
        NautilusKernel.verifyMain();
        if (TextUtils.isEmpty(s))
        {
            return;
        } else
        {
            (new AddRecentSearchTask(s, flag, l, i, flag1, s1)).execute(new Void[0]);
            return;
        }
    }

    public void clearRecentSearches()
    {
        NautilusKernel.verifyMain();
        (new DeleteRecentSearchTask()).execute(new Void[0]);
    }

    public final void clearRecentlyViewedItems()
    {
        NautilusKernel.verifyMain();
        (new DeleteRecentViewedItemTask()).execute(new Void[0]);
    }

    public void forceRefresh()
    {
        NautilusKernel.verifyMain();
        if (params.recentlyViewedOnly)
        {
            return;
        } else
        {
            (new GetRecentDataLoadTask(params.iafToken, false, true)).execute(new Object[0]);
            return;
        }
    }

    public KeyParams getParams()
    {
        return params;
    }

    public volatile Object getParams()
    {
        return getParams();
    }

    public void loadData(Observer observer)
    {
        NautilusKernel.verifyMain();
        if (!params.recentlyViewedOnly)
        {
            boolean flag;
            if (recentSearches == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                (new GetRecentDataLoadTask(params.iafToken, true, true)).execute(new Object[0]);
            }
            if (observer != null && !flag)
            {
                observer.onGetRecentlySearchedData(this, recentSearches);
                return;
            }
        }
    }

    public volatile void loadData(Object obj)
    {
        loadData((Observer)obj);
    }










}
