// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.content.DatedContent;
import com.ebay.nautilus.domain.data.EbayItemIdAndVariationSpecifics;
import com.ebay.nautilus.domain.data.MyEbayListItem;
import com.ebay.nautilus.domain.data.UnifiedStream.ContentSourceEnum;
import com.ebay.nautilus.domain.data.UserDefinedList;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.EbayResponseError;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingApi;
import com.ebay.nautilus.domain.net.api.trading.GetMyEbayBuyingRequest;
import com.ebay.nautilus.domain.net.api.trading.GetMyEbayResponse;
import com.ebay.nautilus.domain.net.api.trading.WatchListChangeRequest;
import com.ebay.nautilus.domain.net.api.trading.WatchListChangeResponse;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;
import com.ebay.nautilus.kernel.net.Request;
import com.ebay.nautilus.kernel.net.Response;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            MyEbayDataManager, UssContentsDataManager, UserContextObservingDataManager

public final class MyEbayWatchingDataManager extends MyEbayDataManager
{
    private final class AddRemoveTask extends AsyncTask
    {

        public final boolean add;
        public final Observer observer;
        final MyEbayWatchingDataManager this$0;

        protected transient Content doInBackground(EbayItemIdAndVariationSpecifics aebayitemidandvariationspecifics[])
        {
            try
            {
                aebayitemidandvariationspecifics = addRemoveItems(add, aebayitemidandvariationspecifics);
            }
            // Misplaced declaration of an exception variable
            catch (EbayItemIdAndVariationSpecifics aebayitemidandvariationspecifics[])
            {
                return null;
            }
            return aebayitemidandvariationspecifics;
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((EbayItemIdAndVariationSpecifics[])aobj);
        }

        protected void onCancelled()
        {
            super.onCancelled();
            handleAddRemoveResult(this, null);
        }

        protected void onPostExecute(Content content)
        {
            super.onPostExecute(content);
            handleAddRemoveResult(this, content);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Content)obj);
        }

        public AddRemoveTask(boolean flag, Observer observer1)
        {
            this$0 = MyEbayWatchingDataManager.this;
            super();
            add = flag;
            observer = observer1;
        }
    }

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
        public final String user;

        public MyEbayWatchingDataManager create(EbayContext ebaycontext)
        {
            return new MyEbayWatchingDataManager(ebaycontext, this);
        }

        public volatile UserContextObservingDataManager create(EbayContext ebaycontext)
        {
            return create(ebaycontext);
        }

        public int describeContents()
        {
            return 0;
        }

        public boolean equals(Object obj)
        {
            if (this == obj)
            {
                return true;
            }
            if (obj == null || obj.getClass() != getClass())
            {
                return false;
            } else
            {
                obj = (KeyParams)obj;
                return TextUtils.equals(user, ((KeyParams) (obj)).user);
            }
        }

        public int hashCode()
        {
            int j = super.hashCode();
            int i;
            if (user == null)
            {
                i = 0;
            } else
            {
                i = user.hashCode();
            }
            return j * 31 + i;
        }

        public String toString()
        {
            return (new StringBuilder()).append("user:").append(user).toString();
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            parcel.writeString(user);
        }


        public KeyParams(String s)
        {
            user = s;
        }
    }

    public static interface Observer
    {

        public abstract void onAddToWatchListComplete(MyEbayWatchingDataManager myebaywatchingdatamanager, Content content);

        public abstract void onRemoveAllFromWatchListComplete(MyEbayWatchingDataManager myebaywatchingdatamanager, ResultStatus resultstatus);

        public abstract void onRemoveFromWatchListComplete(MyEbayWatchingDataManager myebaywatchingdatamanager, Content content);

        public abstract void onWatchingListChanged(MyEbayWatchingDataManager myebaywatchingdatamanager, String s, DatedContent datedcontent);
    }

    private final class RemoveAllTask extends AsyncTask
    {

        public final Observer observer;
        final MyEbayWatchingDataManager this$0;

        protected transient ResultStatus doInBackground(Void avoid[])
        {
            try
            {
                avoid = removeAllItems();
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                return null;
            }
            return avoid;
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected void onCancelled()
        {
            super.onCancelled();
            handleRemoveAllResult(this, null);
        }

        protected void onPostExecute(ResultStatus resultstatus)
        {
            super.onPostExecute(resultstatus);
            handleRemoveAllResult(this, resultstatus);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((ResultStatus)obj);
        }

        public RemoveAllTask(Observer observer1)
        {
            this$0 = MyEbayWatchingDataManager.this;
            super();
            observer = observer1;
        }
    }

    public static final class Sort extends Enum
    {

        private static final Sort $VALUES[];
        public static final Sort CurrentPrice;
        public static final Sort CurrentPriceDescending;
        public static final Sort EndTimeDescending;
        public static final Sort TimeLeft;

        public static Sort valueOf(String s)
        {
            return (Sort)Enum.valueOf(com/ebay/nautilus/domain/content/dm/MyEbayWatchingDataManager$Sort, s);
        }

        public static Sort[] values()
        {
            return (Sort[])$VALUES.clone();
        }

        static 
        {
            TimeLeft = new Sort("TimeLeft", 0);
            CurrentPrice = new Sort("CurrentPrice", 1);
            CurrentPriceDescending = new Sort("CurrentPriceDescending", 2);
            EndTimeDescending = new Sort("EndTimeDescending", 3);
            $VALUES = (new Sort[] {
                TimeLeft, CurrentPrice, CurrentPriceDescending, EndTimeDescending
            });
        }

        private Sort(String s, int i)
        {
            super(s, i);
        }
    }

    private final class UserDefinedListLoader
    {

        public DatedContent data;
        public int listCount;
        public final String listName;
        protected LoadTask loadTask;
        public final String sort;
        final MyEbayWatchingDataManager this$0;

        private List removeItemsFromList(List list, Set set)
        {
            Iterator iterator = list.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                if (set.contains(new EbayItemIdAndVariationSpecifics((MyEbayListItem)iterator.next())))
                {
                    iterator.remove();
                }
            } while (true);
            if (list.isEmpty())
            {
                return Collections.emptyList();
            } else
            {
                return Collections.unmodifiableList(list);
            }
        }

        public final boolean forceReload()
        {
            boolean flag = false;
            this;
            JVM INSTR monitorenter ;
            LoadTask loadtask = loadTask;
            if (loadtask == null) goto _L2; else goto _L1
_L1:
            this;
            JVM INSTR monitorexit ;
            return flag;
_L2:
            markDirty();
            loadTask = new LoadTask();
            DataManager.executeOnThreadPool(loadTask, new Void[0]);
            flag = true;
            if (true) goto _L1; else goto _L3
_L3:
            Exception exception;
            exception;
            throw exception;
        }

        public final DatedContent getData()
        {
            this;
            JVM INSTR monitorenter ;
            DatedContent datedcontent = data;
            this;
            JVM INSTR monitorexit ;
            return datedcontent;
            Exception exception;
            exception;
            throw exception;
        }

        final void handleLoadListResult(LoadTask loadtask, DatedContent datedcontent)
        {
            this;
            JVM INSTR monitorenter ;
            if (loadTask == loadtask)
            {
                loadTask = null;
            }
            if (datedcontent != null)
            {
                break MISSING_BLOCK_LABEL_22;
            }
            this;
            JVM INSTR monitorexit ;
            return;
            if (!datedcontent.getStatus().hasError())
            {
                data = datedcontent;
            }
            this;
            JVM INSTR monitorexit ;
            if (data != null)
            {
                splitWatchingListAndCallback(data);
                return;
            } else
            {
                return;
            }
            loadtask;
            this;
            JVM INSTR monitorexit ;
            throw loadtask;
        }

        public final void load()
        {
            this;
            JVM INSTR monitorenter ;
            if (data == null && loadTask == null)
            {
                loadTask = new LoadTask();
                DataManager.executeOnThreadPool(loadTask, new Void[0]);
            }
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        final DatedContent loadList()
            throws InterruptedException
        {
            Object obj = new ResultStatusOwner();
            Object obj1 = getApi(((ResultStatusOwner) (obj)));
            if (obj1 == null)
            {
                return new DatedContent(((ResultStatusOwner) (obj)).getResultStatus());
            }
            obj = new GetMyEbayBuyingRequest(((EbayTradingApi) (obj1)), "WatchList", 200, 1, sort);
            GetMyEbayResponse getmyebayresponse = (GetMyEbayResponse)sendRequest(((Request) (obj)));
            obj1 = getmyebayresponse.getResultStatus();
            if (((ResultStatus) (obj1)).hasError())
            {
                obj = ((ResultStatus) (obj1)).getFirstError();
                if (obj != null && "network".equals(((com.ebay.nautilus.kernel.content.ResultStatus.Message) (obj)).getCategory()))
                {
                    ((ResultStatus) (obj1)).setCanRetry(true);
                }
                return new DatedContent(((ResultStatus) (obj1)));
            }
            obj = getmyebayresponse.resultItemList;
            if (obj == null)
            {
                obj = Collections.emptyList();
            } else
            {
                obj = Collections.unmodifiableList(((List) (obj)));
            }
            return new DatedContent(new UserDefinedList(listName, getmyebayresponse.totalEntries, ((List) (obj))), ((ResultStatus) (obj1)));
        }

        public final void markDirty()
        {
            this;
            JVM INSTR monitorenter ;
            if (loadTask != null)
            {
                loadTask.cancel(true);
            }
            loadTask = null;
            data = null;
            listCount = 0;
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        public final void removeAllItems()
        {
            this;
            JVM INSTR monitorenter ;
            if (data == null || data.getData() == null || ((UserDefinedList)data.getData()).list == null || !((UserDefinedList)data.getData()).list.isEmpty())
            {
                break MISSING_BLOCK_LABEL_59;
            }
            this;
            JVM INSTR monitorexit ;
            return;
            listCount = 0;
            List list = Collections.emptyList();
            data = new DatedContent(new UserDefinedList(listName, 0, list));
            this;
            JVM INSTR monitorexit ;
            splitWatchingListAndCallback(data);
            return;
            Exception exception;
            exception;
            this;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public final void removeItems(EbayItemIdAndVariationSpecifics aebayitemidandvariationspecifics[])
        {
            this;
            JVM INSTR monitorenter ;
            if (data != null && data.getData() != null && ((UserDefinedList)data.getData()).list != null)
            {
                break MISSING_BLOCK_LABEL_38;
            }
            this;
            JVM INSTR monitorexit ;
            return;
            int i;
            aebayitemidandvariationspecifics = new HashSet(Arrays.asList(aebayitemidandvariationspecifics));
            if (!"".equals(listName))
            {
                break MISSING_BLOCK_LABEL_192;
            }
            aebayitemidandvariationspecifics = removeItemsFromList(new ArrayList(((UserDefinedList)data.getData()).list), aebayitemidandvariationspecifics);
            i = aebayitemidandvariationspecifics.size();
            if (((UserDefinedList)data.getData()).list.size() != i)
            {
                break MISSING_BLOCK_LABEL_125;
            }
            this;
            JVM INSTR monitorexit ;
            return;
            aebayitemidandvariationspecifics;
            this;
            JVM INSTR monitorexit ;
            throw aebayitemidandvariationspecifics;
            listCount = i;
            ArrayList arraylist = new ArrayList(i);
            arraylist.addAll(aebayitemidandvariationspecifics);
            data = new DatedContent(new UserDefinedList(listName, i, Collections.unmodifiableList(arraylist)), data.getLastUpdatedMillis());
            splitWatchingListAndCallback(data);
            this;
            JVM INSTR monitorexit ;
        }

        public UserDefinedListLoader(String s, String s1)
        {
            this$0 = MyEbayWatchingDataManager.this;
            super();
            listCount = 0;
            data = null;
            loadTask = null;
            listName = s;
            sort = s1;
        }
    }

    private final class UserDefinedListLoader.LoadTask extends AsyncTask
    {

        final UserDefinedListLoader this$1;

        protected transient DatedContent doInBackground(Void avoid[])
        {
            try
            {
                avoid = loadList();
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                return null;
            }
            return avoid;
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected void onCancelled()
        {
            super.onCancelled();
            handleLoadListResult(this, null);
        }

        protected void onPostExecute(DatedContent datedcontent)
        {
            super.onPostExecute(datedcontent);
            handleLoadListResult(this, datedcontent);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((DatedContent)obj);
        }

        private UserDefinedListLoader.LoadTask()
        {
            this$1 = UserDefinedListLoader.this;
            super();
        }

    }


    public static final String ACTIVE_LIST_NAME = "active";
    public static final Sort DEFAULT_WATCH_LIST_SORT;
    public static final String ENDED_LIST_NAME = "ended";
    private static final int MAX_WATCHING_SIZE = 200;
    public static final String WATCHING_LIST_NAME = "";
    private UserDefinedListLoader listLoader;

    MyEbayWatchingDataManager(EbayContext ebaycontext, KeyParams keyparams)
    {
        super(ebaycontext, com/ebay/nautilus/domain/content/dm/MyEbayWatchingDataManager$Observer, keyparams);
        listLoader = new UserDefinedListLoader("", DEFAULT_WATCH_LIST_SORT.toString());
    }

    private transient int addRemoveItems(EbayTradingApi ebaytradingapi, ResultStatusOwner resultstatusowner, com.ebay.nautilus.domain.net.api.trading.WatchListChangeRequest.Change achange[])
        throws InterruptedException
    {
        int i = -1;
        int l = achange.length;
        for (int k = 0; k < l;)
        {
            Object obj = (WatchListChangeResponse)sendRequest(new WatchListChangeRequest(ebaytradingapi, achange[k]));
            ResultStatus resultstatus = ((WatchListChangeResponse) (obj)).getResultStatus();
            if (!resultstatus.hasError())
            {
                i = ((WatchListChangeResponse) (obj)).itemCount;
            }
            obj = resultstatus.getMessages();
            int j = i;
            if (obj != null)
            {
                Iterator iterator = ((List) (obj)).iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    com.ebay.nautilus.kernel.content.ResultStatus.Message message = (com.ebay.nautilus.kernel.content.ResultStatus.Message)iterator.next();
                    switch (message.getId())
                    {
                    case 20819: 
                    case 20820: 
                        iterator.remove();
                        i = -1;
                        break;

                    case 21002: 
                    case 21003: 
                        iterator.remove();
                        break;

                    case 20821: 
                        if (message instanceof EbayResponseError)
                        {
                            ((EbayResponseError)message).severity = 1;
                        }
                        break;
                    }
                } while (true);
                j = i;
                if (!((List) (obj)).isEmpty())
                {
                    resultstatusowner.addResultMessage(((java.util.Collection) (obj)));
                    j = i;
                }
            }
            k++;
            i = j;
        }

        return i;
    }

    private void cancelPendingTasks()
    {
        if (listLoader.loadTask != null)
        {
            listLoader.loadTask.cancel(true);
        }
    }

    private static com.ebay.nautilus.domain.net.api.trading.WatchListChangeRequest.Change[] getAddRemoveChange(boolean flag, EbayItemIdAndVariationSpecifics aebayitemidandvariationspecifics[])
    {
        int j = 0;
        int k = 0;
        int l = aebayitemidandvariationspecifics.length;
        int i = 0;
        while (i < l) 
        {
            if (aebayitemidandvariationspecifics[i].variationSpecifics.isEmpty())
            {
                j++;
            } else
            {
                k++;
            }
            i++;
        }
        EbayItemIdAndVariationSpecifics aebayitemidandvariationspecifics1[];
        long al[];
        if (j != 0)
        {
            al = new long[j];
        } else
        {
            al = null;
        }
        if (j == 0)
        {
            aebayitemidandvariationspecifics1 = aebayitemidandvariationspecifics;
        } else
        if (k != 0)
        {
            aebayitemidandvariationspecifics1 = new EbayItemIdAndVariationSpecifics[k];
        } else
        {
            aebayitemidandvariationspecifics1 = null;
        }
        if (j != 0)
        {
            int k1 = aebayitemidandvariationspecifics.length;
            k = 0;
            j = 0;
            i = 0;
            while (k < k1) 
            {
                EbayItemIdAndVariationSpecifics ebayitemidandvariationspecifics = aebayitemidandvariationspecifics[k];
                if (ebayitemidandvariationspecifics.variationSpecifics.isEmpty())
                {
                    int i1 = i + 1;
                    al[i] = ebayitemidandvariationspecifics.id;
                    i = i1;
                } else
                {
                    int j1 = j + 1;
                    aebayitemidandvariationspecifics1[j] = ebayitemidandvariationspecifics;
                    j = j1;
                }
                k++;
            }
        }
        i = 0;
        if (al != null)
        {
            i = 0 + 1;
        }
        j = i;
        if (aebayitemidandvariationspecifics1 != null)
        {
            j = i + 1;
        }
        aebayitemidandvariationspecifics = new com.ebay.nautilus.domain.net.api.trading.WatchListChangeRequest.Change[j];
        if (al != null)
        {
            i = 0 + 1;
            aebayitemidandvariationspecifics[0] = com.ebay.nautilus.domain.net.api.trading.WatchListChangeRequest.Change.create(flag, al);
        } else
        {
            i = 0;
        }
        if (aebayitemidandvariationspecifics1 != null)
        {
            aebayitemidandvariationspecifics[i] = com.ebay.nautilus.domain.net.api.trading.WatchListChangeRequest.Change.create(flag, aebayitemidandvariationspecifics1);
            return aebayitemidandvariationspecifics;
        } else
        {
            return aebayitemidandvariationspecifics;
        }
    }

    private void loadListOrCallback()
    {
        DatedContent datedcontent = listLoader.getData();
        if (datedcontent != null)
        {
            splitWatchingListAndCallback(datedcontent);
            return;
        } else
        {
            listLoader.load();
            return;
        }
    }

    private void splitWatchingList(List list, List list1, List list2)
    {
        long l = EbayResponse.currentHostTime();
        for (list = list.iterator(); list.hasNext();)
        {
            MyEbayListItem myebaylistitem = (MyEbayListItem)list.next();
            if (myebaylistitem.endTimestamp < l)
            {
                list2.add(myebaylistitem);
            } else
            {
                list1.add(myebaylistitem);
            }
        }

    }

    Content addRemoveItems(boolean flag, EbayItemIdAndVariationSpecifics aebayitemidandvariationspecifics[])
        throws InterruptedException
    {
        com.ebay.nautilus.domain.net.api.trading.WatchListChangeRequest.Change achange[] = getAddRemoveChange(flag, aebayitemidandvariationspecifics);
        ResultStatusOwner resultstatusowner = new ResultStatusOwner();
        EbayTradingApi ebaytradingapi = getApi(resultstatusowner);
        if (ebaytradingapi == null)
        {
            return new Content(resultstatusowner.getResultStatus());
        } else
        {
            addRemoveItems(ebaytradingapi, resultstatusowner, achange);
            return new Content(aebayitemidandvariationspecifics, resultstatusowner.getResultStatus());
        }
    }

    public transient void addToWatchList(Observer observer, EbayItemIdAndVariationSpecifics aebayitemidandvariationspecifics[])
    {
        if (aebayitemidandvariationspecifics == null || aebayitemidandvariationspecifics.length == 0)
        {
            throw new IllegalArgumentException("items is empty");
        } else
        {
            NautilusKernel.verifyMain();
            executeOnThreadPool(new AddRemoveTask(true, (Observer)getSafeCallback(observer)), aebayitemidandvariationspecifics);
            return;
        }
    }

    public boolean forceReloadWatchList()
    {
        NautilusKernel.verifyMain();
        return listLoader.forceReload();
    }

    void handleAddRemoveResult(AddRemoveTask addremovetask, Content content)
    {
        if (content != null)
        {
            if (!content.getStatus().hasError())
            {
                if (addremovetask.add)
                {
                    forceReloadWatchList();
                } else
                {
                    listLoader.removeItems((EbayItemIdAndVariationSpecifics[])content.getData());
                }
            }
            if (addremovetask.observer != null)
            {
                if (addremovetask.add)
                {
                    addremovetask.observer.onAddToWatchListComplete(this, content);
                    return;
                } else
                {
                    addremovetask.observer.onRemoveFromWatchListComplete(this, content);
                    return;
                }
            }
        }
    }

    void handleRemoveAllResult(RemoveAllTask removealltask, ResultStatus resultstatus)
    {
        if (resultstatus != null)
        {
            if (!resultstatus.hasError())
            {
                listLoader.removeAllItems();
            }
            if (removealltask.observer != null)
            {
                removealltask.observer.onRemoveAllFromWatchListComplete(this, resultstatus);
                return;
            }
        }
    }

    public void invalidateRelatedDataManagers()
    {
        super.invalidateRelatedDataManagers();
        UssContentsDataManager.invalidateActivityChannelData(getEbayContext(), new ContentSourceEnum[] {
            ContentSourceEnum.WATCHING
        });
    }

    public void loadData(Observer observer)
    {
    }

    public volatile void loadData(Object obj)
    {
        loadData((Observer)obj);
    }

    public void loadWatchList()
    {
        NautilusKernel.verifyMain();
        cancelPendingTasks();
        loadListOrCallback();
    }

    protected final void onNewUser(String s)
    {
    }

    protected final void onUserAuthChanged()
    {
    }

    protected final void onUserSignedOut()
    {
        cancelPendingTasks();
        splitWatchingListAndCallback(new DatedContent(new UserDefinedList("", 0, Collections.unmodifiableList(new ArrayList())), EbayResponse.currentHostTime()));
    }

    public void removeAllFromWatchList(Observer observer)
    {
        NautilusKernel.verifyMain();
        executeOnThreadPool(new RemoveAllTask((Observer)getSafeCallback(observer)), new Void[0]);
    }

    ResultStatus removeAllItems()
        throws InterruptedException
    {
        com.ebay.nautilus.domain.net.api.trading.WatchListChangeRequest.Change change = com.ebay.nautilus.domain.net.api.trading.WatchListChangeRequest.Change.removeAllItems();
        ResultStatusOwner resultstatusowner = new ResultStatusOwner();
        EbayTradingApi ebaytradingapi = getApi(resultstatusowner);
        if (ebaytradingapi == null)
        {
            return resultstatusowner.getResultStatus();
        } else
        {
            addRemoveItems(ebaytradingapi, resultstatusowner, new com.ebay.nautilus.domain.net.api.trading.WatchListChangeRequest.Change[] {
                change
            });
            return resultstatusowner.getResultStatus();
        }
    }

    public transient void removeFromWatchList(Observer observer, EbayItemIdAndVariationSpecifics aebayitemidandvariationspecifics[])
    {
        if (aebayitemidandvariationspecifics == null || aebayitemidandvariationspecifics.length == 0)
        {
            throw new IllegalArgumentException("items is empty");
        } else
        {
            NautilusKernel.verifyMain();
            executeOnThreadPool(new AddRemoveTask(false, (Observer)getSafeCallback(observer)), aebayitemidandvariationspecifics);
            return;
        }
    }

    public void setSortMethod(Sort sort)
    {
        Sort sort1 = sort;
        if (sort == null)
        {
            sort1 = DEFAULT_WATCH_LIST_SORT;
        }
        sort = sort1.toString();
        if (listLoader == null || !listLoader.sort.equals(sort))
        {
            listLoader = new UserDefinedListLoader("", sort);
        }
    }

    protected void splitWatchingListAndCallback(DatedContent datedcontent)
    {
        ArrayList arraylist1 = new ArrayList(((UserDefinedList)datedcontent.getData()).list);
        ArrayList arraylist2 = new ArrayList();
        ArrayList arraylist = new ArrayList();
        splitWatchingList(arraylist1, arraylist2, arraylist);
        long l = datedcontent.getLastUpdatedMillis();
        ((Observer)dispatcher).onWatchingListChanged(this, "", datedcontent);
        datedcontent = new DatedContent(new UserDefinedList("active", arraylist2.size(), arraylist2), l);
        ((Observer)dispatcher).onWatchingListChanged(this, "active", datedcontent);
        datedcontent = new DatedContent(new UserDefinedList("ended", arraylist.size(), arraylist), l);
        ((Observer)dispatcher).onWatchingListChanged(this, "ended", datedcontent);
    }

    static 
    {
        DEFAULT_WATCH_LIST_SORT = Sort.TimeLeft;
    }

}
