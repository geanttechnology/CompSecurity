// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common;

import android.content.Context;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.ebay.common.model.SavedSeller;
import com.ebay.common.model.UserDetail;
import com.ebay.common.model.favseller.FavoriteSeller;
import com.ebay.common.net.api.aps.ApplicationProcessServiceApi;
import com.ebay.common.net.api.aps.UserActivitySummary;
import com.ebay.common.net.api.shopping.EbayShoppingApiHelper;
import com.ebay.common.net.api.trading.EbayTradingApiHelper;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.notifications.PollServiceListCache;
import com.ebay.mobile.search.SavedSearchList;
import com.ebay.mobile.util.EbayApiUtil;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.ServiceContentOverride;
import com.ebay.nautilus.domain.data.UserProfile;
import com.ebay.nautilus.domain.net.api.shopping.EbayShoppingApi;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingApi;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.shell.app.BaseActivity;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.ebay.common:
//            Preferences

public final class UserCache
{
    public static interface IUpdateFavSellers
    {

        public abstract void updateFavSellers();
    }

    public static interface IUpdateMsgRemindersCounts
    {

        public abstract void onEbayError(List list);

        public abstract void onRemindersError();

        public abstract void updateMsgRemindersCounts(UserActivitySummary useractivitysummary);
    }

    public static interface IUpdateSavedSearch
    {

        public abstract void updateSavedSearch(SavedSearchList savedsearchlist);
    }

    public static interface IUpdateUserDetails
    {

        public abstract void updateUserDetails(UserDetail userdetail);
    }

    public static interface IUpdateUserProfile
    {

        public abstract void updateUserProfile(UserProfile userprofile);
    }

    private static final class Internal
    {

        private static final int PROFILE_UPDATE_THRESHOLD = 0x36ee80;
        private static SoftReference single = null;
        private ArrayList favSellerList;
        private final ArrayList favSellersHandlers = new ArrayList();
        private int flagFavSellersState;
        private int flagMsgRemindersCountsState;
        private int flagSavedSearchState;
        private int flagUserDetailsState;
        private int flagUserProfileState;
        private final HashSet leftFeedbackItems = new HashSet();
        private final ArrayList msgRemindersCountsHandlers = new ArrayList();
        private final UserActivitySummary msgRemindersSummary = new UserActivitySummary();
        private final HashMap paidStatusAndTime = new HashMap();
        private final HashSet priceRevealedItems = new HashSet();
        final Handler runHandler = new Handler();
        private final ArrayList savedSearchHandlers = new ArrayList();
        private SavedSearchList savedSearchList;
        private final HashSet shippedItems = new HashSet();
        private Thread threadFavSellerList;
        private Thread threadMsgRemindersCounts;
        private Thread threadSavedSearchList;
        private Thread threadUserDetails;
        private Thread threadUserProfile;
        private long timeSinceLastProfileUpdate;
        private volatile UserDetail userDetails;
        private final ArrayList userDetailsHandlers = new ArrayList();
        private UserProfile userProfile;
        private final ArrayList userProfileHandlers = new ArrayList();

        private String generateKey(String s, String s1)
        {
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append(s);
            stringbuilder.append(':');
            s = s1;
            if (s1 == null)
            {
                s = "any";
            }
            stringbuilder.append(s);
            return stringbuilder.toString();
        }

        static Internal get()
        {
            com/ebay/common/UserCache$Internal;
            JVM INSTR monitorenter ;
            if (single == null) goto _L2; else goto _L1
_L1:
            Internal internal = (Internal)single.get();
_L4:
            Internal internal1;
            internal1 = internal;
            if (internal != null)
            {
                break MISSING_BLOCK_LABEL_44;
            }
            internal1 = new Internal();
            single = new SoftReference(internal1);
            com/ebay/common/UserCache$Internal;
            JVM INSTR monitorexit ;
            return internal1;
_L2:
            internal = null;
            if (true) goto _L4; else goto _L3
_L3:
            Exception exception;
            exception;
            throw exception;
        }

        static Internal getIfExists()
        {
            com/ebay/common/UserCache$Internal;
            JVM INSTR monitorenter ;
            if (single == null) goto _L2; else goto _L1
_L1:
            Internal internal = (Internal)single.get();
_L4:
            com/ebay/common/UserCache$Internal;
            JVM INSTR monitorexit ;
            return internal;
_L2:
            internal = null;
            if (true) goto _L4; else goto _L3
_L3:
            Exception exception;
            exception;
            throw exception;
        }

        private void register(ArrayList arraylist, Object obj)
        {
            arraylist;
            JVM INSTR monitorenter ;
            boolean flag = true;
            int j = arraylist.size();
_L2:
            int k;
            if (j <= 0)
            {
                break; /* Loop/switch isn't completed */
            }
            k = j - 1;
            Object obj1 = ((WeakReference)arraylist.get(k)).get();
            if (obj1 != null)
            {
                break MISSING_BLOCK_LABEL_58;
            }
            arraylist.remove(k);
            j = k;
            continue; /* Loop/switch isn't completed */
            obj;
            arraylist;
            JVM INSTR monitorexit ;
            throw obj;
            j = k;
            if (obj1 == obj)
            {
                flag = false;
                j = k;
            }
            if (true) goto _L2; else goto _L1
_L1:
            if (!flag)
            {
                break MISSING_BLOCK_LABEL_95;
            }
            arraylist.add(new WeakReference(obj));
            arraylist;
            JVM INSTR monitorexit ;
        }

        private void unregister(ArrayList arraylist, Object obj)
        {
            arraylist;
            JVM INSTR monitorenter ;
            int j = arraylist.size();
_L3:
            int k;
            if (j <= 0)
            {
                break MISSING_BLOCK_LABEL_64;
            }
            k = j - 1;
            Object obj1 = ((WeakReference)arraylist.get(k)).get();
            if (obj1 == null) goto _L2; else goto _L1
_L1:
            j = k;
            if (obj1 != obj) goto _L3; else goto _L2
_L2:
            arraylist.remove(k);
            j = k;
              goto _L3
            obj;
            arraylist;
            JVM INSTR monitorexit ;
            throw obj;
            arraylist;
            JVM INSTR monitorexit ;
        }

        void addToFavSeller(String s)
        {
            if (TextUtils.isEmpty(s))
            {
                return;
            }
            if (favSellerList == null)
            {
                favSellerList = new ArrayList();
            }
            synchronized (favSellerList)
            {
                FavoriteSeller favoriteseller = new FavoriteSeller();
                favoriteseller.sellerId = s;
                favSellerList.add(favoriteseller);
            }
            return;
            s;
            arraylist;
            JVM INSTR monitorexit ;
            throw s;
        }

        void addToLeftFeedback(String s, String s1)
        {
            if (s == null || s1 == null)
            {
                return;
            }
            s1 = generateKey(s, s1);
            synchronized (leftFeedbackItems)
            {
                leftFeedbackItems.add(s1);
            }
            return;
            s1;
            s;
            JVM INSTR monitorexit ;
            throw s1;
        }

        void addToPaidStatus(String s, String s1, PaidStatusAndTime paidstatusandtime)
        {
            if (s != null)
            {
                synchronized (paidStatusAndTime)
                {
                    paidStatusAndTime.put(generateKey(s, s1), paidstatusandtime);
                }
                return;
            } else
            {
                return;
            }
            s;
            hashmap;
            JVM INSTR monitorexit ;
            throw s;
        }

        void assignFavSellers(ArrayList arraylist)
        {
            favSellerList = arraylist;
            updateFavSellers();
        }

        public final void clearAll()
        {
            clearPaid();
            clearMsgRemindersCounts();
            clearPriceRevealed();
            clearUserProfile();
            clearUserDetails();
            clearFavSellers();
            clearSavedSearch();
        }

        void clearFavSellers()
        {
            favSellerList = null;
            flagFavSellersState = 0;
        }

        void clearLeftFeedback()
        {
            synchronized (leftFeedbackItems)
            {
                leftFeedbackItems.clear();
            }
            return;
            exception;
            hashset;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public final void clearMsgRemindersCounts()
        {
            ArrayList arraylist = msgRemindersCountsHandlers;
            arraylist;
            JVM INSTR monitorenter ;
            Thread thread = threadMsgRemindersCounts;
            if (thread == null)
            {
                break MISSING_BLOCK_LABEL_28;
            }
            threadMsgRemindersCounts.interrupt();
            threadMsgRemindersCounts = null;
_L1:
            flagMsgRemindersCountsState = 0;
            msgRemindersSummary.messagesNewAlertCount = 0;
            msgRemindersSummary.messagesNewMessageCount = 0;
            msgRemindersSummary.buyingFeedbackToSend = 0;
            msgRemindersSummary.buyingPaymentToSend = 0;
            msgRemindersSummary.buyingBiddingCount = 0;
            msgRemindersSummary.buyingWinningCount = 0;
            msgRemindersSummary.buyingWonCount = 0;
            msgRemindersSummary.buyingWonDurationInDays = 0;
            msgRemindersSummary.buyingOutbidCount = 0;
            msgRemindersSummary.buyingBestOfferCount = 0;
            msgRemindersSummary.buyingWatchCount = 0;
            msgRemindersSummary.buyingBidEndingSoonCount = 0;
            msgRemindersSummary.buyingSecondChanceOfferCount = 0;
            msgRemindersSummary.buyingWatchEndingSoonCount = 0;
            msgRemindersSummary.sellingFeedbackToSend = 0;
            msgRemindersSummary.sellingPaymentToReceive = 0;
            msgRemindersSummary.sellingShippingNeeded = 0;
            msgRemindersSummary.sellingActiveCount = 0;
            msgRemindersSummary.sellingSoldCount = 0;
            msgRemindersSummary.sellingUnsoldCount = 0;
            msgRemindersSummary.sellingScheduledCount = 0;
            msgRemindersSummary.sellingDurationInDays = 0;
            msgRemindersSummary.sellingBestOfferCount = 0;
            msgRemindersSummary.sellingSellEndingSoonCount = 0;
            arraylist;
            JVM INSTR monitorexit ;
            return;
            Object obj;
            obj;
            threadMsgRemindersCounts = null;
              goto _L1
            obj;
            arraylist;
            JVM INSTR monitorexit ;
            throw obj;
            obj;
            threadMsgRemindersCounts = null;
            throw obj;
        }

        void clearPaid()
        {
            synchronized (paidStatusAndTime)
            {
                paidStatusAndTime.clear();
            }
            return;
            exception;
            hashmap;
            JVM INSTR monitorexit ;
            throw exception;
        }

        void clearPriceRevealed()
        {
            synchronized (priceRevealedItems)
            {
                priceRevealedItems.clear();
            }
            return;
            exception;
            hashset;
            JVM INSTR monitorexit ;
            throw exception;
        }

        void clearSavedSearch()
        {
            savedSearchList = new SavedSearchList();
            flagSavedSearchState = 0;
        }

        void clearShipped()
        {
            synchronized (shippedItems)
            {
                shippedItems.clear();
            }
            return;
            exception;
            hashset;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public final void clearUserDetails()
        {
            ArrayList arraylist = userDetailsHandlers;
            arraylist;
            JVM INSTR monitorenter ;
            Thread thread = threadUserDetails;
            if (thread == null)
            {
                break MISSING_BLOCK_LABEL_28;
            }
            threadUserDetails.interrupt();
            threadUserDetails = null;
_L1:
            flagUserDetailsState = 0;
            userDetails = null;
            arraylist;
            JVM INSTR monitorexit ;
            return;
            Object obj;
            obj;
            threadUserDetails = null;
              goto _L1
            obj;
            arraylist;
            JVM INSTR monitorexit ;
            throw obj;
            obj;
            threadUserDetails = null;
            throw obj;
        }

        public final void clearUserProfile()
        {
            ArrayList arraylist = userProfileHandlers;
            arraylist;
            JVM INSTR monitorenter ;
            Thread thread = threadUserProfile;
            if (thread == null)
            {
                break MISSING_BLOCK_LABEL_28;
            }
            threadUserProfile.interrupt();
            threadUserProfile = null;
_L1:
            flagUserProfileState = 0;
            userProfile = null;
            arraylist;
            JVM INSTR monitorexit ;
            return;
            Object obj;
            obj;
            threadUserProfile = null;
              goto _L1
            obj;
            arraylist;
            JVM INSTR monitorexit ;
            throw obj;
            obj;
            threadUserProfile = null;
            throw obj;
        }

        void flushPaid()
        {
            long l = System.currentTimeMillis();
            HashMap hashmap = paidStatusAndTime;
            hashmap;
            JVM INSTR monitorenter ;
            Iterator iterator = paidStatusAndTime.keySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                String s = (String)iterator.next();
                if (l - ((PaidStatusAndTime)paidStatusAndTime.get(s)).timestamp.longValue() > 0x1b77400L)
                {
                    iterator.remove();
                }
            } while (true);
            break MISSING_BLOCK_LABEL_85;
            Exception exception;
            exception;
            hashmap;
            JVM INSTR monitorexit ;
            throw exception;
            hashmap;
            JVM INSTR monitorexit ;
        }

        PaidStatusAndTime getPaidStatusAndTime(String s, String s1)
        {
            return (PaidStatusAndTime)paidStatusAndTime.get(generateKey(s, s1));
        }

        public final SavedSearchList getSavedSearchList()
        {
            return savedSearchList;
        }

        public final UserDetail getUserDetails()
        {
            return userDetails;
        }

        boolean hasLeftFeedback(String s, String s1)
        {
            if (s != null && s1 != null)
            {
                boolean flag;
                synchronized (leftFeedbackItems)
                {
                    flag = leftFeedbackItems.contains(generateKey(s, s1));
                }
                return flag;
            } else
            {
                return false;
            }
            s;
            hashset;
            JVM INSTR monitorexit ;
            throw s;
        }

        boolean isFavSeller(String s)
        {
            boolean flag1;
            for (flag1 = false; TextUtils.isEmpty(s) || favSellerList == null || favSellerList.isEmpty();)
            {
                return false;
            }

            ArrayList arraylist = favSellerList;
            arraylist;
            JVM INSTR monitorenter ;
            Iterator iterator = favSellerList.iterator();
_L2:
            boolean flag = flag1;
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_79;
            }
            if (!((FavoriteSeller)iterator.next()).sellerId.equalsIgnoreCase(s)) goto _L2; else goto _L1
_L1:
            flag = true;
            arraylist;
            JVM INSTR monitorexit ;
            return flag;
            s;
            arraylist;
            JVM INSTR monitorexit ;
            throw s;
        }

        boolean isPriceRevealed(String s)
        {
            return priceRevealedItems.contains(s);
        }

        boolean isShipped(String s, String s1)
        {
            if (s != null && s1 != null)
            {
                boolean flag;
                synchronized (shippedItems)
                {
                    flag = shippedItems.contains(generateKey(s, s1));
                }
                return flag;
            } else
            {
                return false;
            }
            s;
            hashset;
            JVM INSTR monitorexit ;
            throw s;
        }

        public void onEbayError(ArrayList arraylist)
        {
            ArrayList arraylist1 = msgRemindersCountsHandlers;
            arraylist1;
            JVM INSTR monitorenter ;
            int j = arraylist1.size();
_L1:
            if (j <= 0)
            {
                break MISSING_BLOCK_LABEL_69;
            }
            j--;
            IUpdateMsgRemindersCounts iupdatemsgreminderscounts = (IUpdateMsgRemindersCounts)((WeakReference)arraylist1.get(j)).get();
            if (iupdatemsgreminderscounts != null)
            {
                break MISSING_BLOCK_LABEL_59;
            }
            arraylist1.remove(j);
              goto _L1
            arraylist;
            arraylist1;
            JVM INSTR monitorexit ;
            throw arraylist;
            iupdatemsgreminderscounts.onEbayError(arraylist);
              goto _L1
            arraylist1;
            JVM INSTR monitorexit ;
        }

        public void onError()
        {
            ArrayList arraylist = msgRemindersCountsHandlers;
            arraylist;
            JVM INSTR monitorenter ;
            int j = arraylist.size();
_L1:
            if (j <= 0)
            {
                break MISSING_BLOCK_LABEL_62;
            }
            j--;
            Object obj = (IUpdateMsgRemindersCounts)((WeakReference)arraylist.get(j)).get();
            if (obj != null)
            {
                break MISSING_BLOCK_LABEL_53;
            }
            arraylist.remove(j);
              goto _L1
            obj;
            arraylist;
            JVM INSTR monitorexit ;
            throw obj;
            ((IUpdateMsgRemindersCounts) (obj)).onRemindersError();
              goto _L1
            arraylist;
            JVM INSTR monitorexit ;
        }

        public final void refreshAll(Authentication authentication, Context context1, EbayContext ebaycontext)
        {
            refreshMsgRemindersCounts(authentication, EbayApiUtil.getApsApi(ebaycontext));
            refreshSavedSearch(context1, ebaycontext, authentication.iafToken);
        }

        void refreshFavSellers(EbayContext ebaycontext, EbayTradingApi ebaytradingapi)
        {
            if (threadFavSellerList == null)
            {
                threadFavSellerList = new TUpdateFavSellers(this, ebaycontext, ebaytradingapi);
                threadFavSellerList.start();
            }
        }

        public final void refreshMsgRemindersCounts(Authentication authentication, ApplicationProcessServiceApi applicationprocessserviceapi)
        {
            synchronized (msgRemindersCountsHandlers)
            {
                if (threadMsgRemindersCounts == null)
                {
                    threadMsgRemindersCounts = new TUpdateMsgRemindersCounts(this, applicationprocessserviceapi, authentication.iafToken, authentication.user);
                    flagMsgRemindersCountsState = flagMsgRemindersCountsState | 2;
                    threadMsgRemindersCounts.start();
                }
            }
            return;
            authentication;
            arraylist;
            JVM INSTR monitorexit ;
            throw authentication;
        }

        void refreshSavedSearch(Context context1, EbayContext ebaycontext, String s)
        {
            if (threadSavedSearchList == null)
            {
                threadSavedSearchList = new TUpdateSavedSearch(this, context1, ebaycontext, s);
                threadSavedSearchList.start();
            }
        }

        public final void refreshUserDetails(EbayContext ebaycontext, EbayTradingApi ebaytradingapi)
        {
            synchronized (userDetailsHandlers)
            {
                if (threadUserDetails == null)
                {
                    threadUserDetails = new TUpdateUserDetails(this, ebaycontext, ebaytradingapi);
                    flagUserDetailsState = flagUserDetailsState | 2;
                    threadUserDetails.start();
                }
            }
            return;
            ebaycontext;
            arraylist;
            JVM INSTR monitorexit ;
            throw ebaycontext;
        }

        public final void refreshUserProfile(EbayContext ebaycontext, EbayShoppingApi ebayshoppingapi, String s)
        {
            synchronized (userProfileHandlers)
            {
                if (threadUserProfile == null)
                {
                    threadUserProfile = new TUpdateUserProfile(this, ebaycontext, ebayshoppingapi, s);
                    flagUserProfileState = flagUserProfileState | 2;
                    threadUserProfile.start();
                }
            }
            return;
            ebaycontext;
            arraylist;
            JVM INSTR monitorexit ;
            throw ebaycontext;
        }

        public final void registerFavSellersHandler(EbayContext ebaycontext, EbayTradingApi ebaytradingapi, IUpdateFavSellers iupdatefavsellers)
        {
            register(favSellersHandlers, iupdatefavsellers);
            ArrayList arraylist = favSellersHandlers;
            arraylist;
            JVM INSTR monitorenter ;
            if ((flagFavSellersState & 1) == 0) goto _L2; else goto _L1
_L1:
            iupdatefavsellers.updateFavSellers();
_L4:
            return;
_L2:
            if ((flagFavSellersState & 2) != 0 || ebaytradingapi == null) goto _L4; else goto _L3
_L3:
            refreshFavSellers(ebaycontext, ebaytradingapi);
              goto _L4
            ebaycontext;
            arraylist;
            JVM INSTR monitorexit ;
            throw ebaycontext;
        }

        public final void registerMsgRemindersCountsHandler(Authentication authentication, ApplicationProcessServiceApi applicationprocessserviceapi, IUpdateMsgRemindersCounts iupdatemsgreminderscounts, boolean flag)
        {
            register(msgRemindersCountsHandlers, iupdatemsgreminderscounts);
            ArrayList arraylist = msgRemindersCountsHandlers;
            arraylist;
            JVM INSTR monitorenter ;
            if ((flagMsgRemindersCountsState & 1) == 0 || flag) goto _L2; else goto _L1
_L1:
            iupdatemsgreminderscounts.updateMsgRemindersCounts(msgRemindersSummary);
_L4:
            arraylist;
            JVM INSTR monitorexit ;
            return;
_L2:
            if ((flagMsgRemindersCountsState & 2) != 0 || authentication == null) goto _L4; else goto _L3
_L3:
            refreshMsgRemindersCounts(authentication, applicationprocessserviceapi);
              goto _L4
            authentication;
            arraylist;
            JVM INSTR monitorexit ;
            throw authentication;
        }

        public final void registerSavedSearchHandler(Context context1, EbayContext ebaycontext, String s, IUpdateSavedSearch iupdatesavedsearch)
        {
            register(savedSearchHandlers, iupdatesavedsearch);
            ArrayList arraylist = savedSearchHandlers;
            arraylist;
            JVM INSTR monitorenter ;
            if ((flagSavedSearchState & 1) == 0) goto _L2; else goto _L1
_L1:
            iupdatesavedsearch.updateSavedSearch(savedSearchList);
_L4:
            return;
_L2:
            if ((flagSavedSearchState & 2) == 0)
            {
                refreshSavedSearch(context1, ebaycontext, s);
            }
            if (true) goto _L4; else goto _L3
_L3:
            context1;
            arraylist;
            JVM INSTR monitorexit ;
            throw context1;
        }

        public final void registerUserDetailsHandler(EbayContext ebaycontext, EbayTradingApi ebaytradingapi, IUpdateUserDetails iupdateuserdetails)
        {
            register(userDetailsHandlers, iupdateuserdetails);
            ArrayList arraylist = userDetailsHandlers;
            arraylist;
            JVM INSTR monitorenter ;
            if ((flagUserDetailsState & 1) == 0) goto _L2; else goto _L1
_L1:
            iupdateuserdetails.updateUserDetails(userDetails);
_L4:
            return;
_L2:
            if ((flagUserDetailsState & 2) != 0 || ebaytradingapi == null) goto _L4; else goto _L3
_L3:
            refreshUserDetails(ebaycontext, ebaytradingapi);
              goto _L4
            ebaycontext;
            arraylist;
            JVM INSTR monitorexit ;
            throw ebaycontext;
        }

        public final void registerUserProfileHandler(EbayContext ebaycontext, EbayShoppingApi ebayshoppingapi, String s, IUpdateUserProfile iupdateuserprofile)
        {
            register(userProfileHandlers, iupdateuserprofile);
            ArrayList arraylist = userProfileHandlers;
            arraylist;
            JVM INSTR monitorenter ;
            if ((flagUserProfileState & 1) == 0 || System.currentTimeMillis() - timeSinceLastProfileUpdate >= 0x36ee80L) goto _L2; else goto _L1
_L1:
            iupdateuserprofile.updateUserProfile(userProfile);
_L4:
            return;
_L2:
            if ((flagUserProfileState & 2) != 0 || ebayshoppingapi == null) goto _L4; else goto _L3
_L3:
            timeSinceLastProfileUpdate = System.currentTimeMillis();
            refreshUserProfile(ebaycontext, ebayshoppingapi, s);
              goto _L4
            ebaycontext;
            arraylist;
            JVM INSTR monitorexit ;
            throw ebaycontext;
        }

        void removeFavSeller(String s)
        {
            while (TextUtils.isEmpty(s) || favSellerList == null || favSellerList.isEmpty()) 
            {
                return;
            }
            ArrayList arraylist = favSellerList;
            arraylist;
            JVM INSTR monitorenter ;
            int j = 0;
_L2:
            if (j < favSellerList.size())
            {
                if (!((FavoriteSeller)favSellerList.get(j)).sellerId.equalsIgnoreCase(s))
                {
                    break MISSING_BLOCK_LABEL_83;
                }
                favSellerList.remove(j);
            }
            arraylist;
            JVM INSTR monitorexit ;
            return;
            s;
            arraylist;
            JVM INSTR monitorexit ;
            throw s;
            j++;
            if (true) goto _L2; else goto _L1
_L1:
        }

        void setPriceRevealed(String s)
        {
            if (s != null)
            {
                priceRevealedItems.add(s);
            }
        }

        void setShipped(String s, String s1, boolean flag)
        {
            if (s == null || s1 == null)
            {
                return;
            }
            s1 = generateKey(s, s1);
            s = shippedItems;
            s;
            JVM INSTR monitorenter ;
            if (!flag)
            {
                break MISSING_BLOCK_LABEL_44;
            }
            shippedItems.add(s1);
_L1:
            s;
            JVM INSTR monitorexit ;
            return;
            s1;
            s;
            JVM INSTR monitorexit ;
            throw s1;
            shippedItems.remove(s1);
              goto _L1
        }

        public final void setUserDetails(UserDetail userdetail)
        {
            synchronized (userDetailsHandlers)
            {
                userDetails = userdetail;
                flagUserDetailsState = flagUserDetailsState | 1;
            }
            return;
            userdetail;
            arraylist;
            JVM INSTR monitorexit ;
            throw userdetail;
        }

        public final void setUserProfile(UserProfile userprofile)
        {
            synchronized (userProfileHandlers)
            {
                userProfile = userprofile;
                flagUserProfileState = flagUserProfileState | 1;
            }
            return;
            userprofile;
            arraylist;
            JVM INSTR monitorexit ;
            throw userprofile;
        }

        public final void unregisterFavSellersHandler(IUpdateFavSellers iupdatefavsellers)
        {
            unregister(favSellersHandlers, iupdatefavsellers);
        }

        public final void unregisterMsgRemindersCountsHandler(IUpdateMsgRemindersCounts iupdatemsgreminderscounts)
        {
            unregister(msgRemindersCountsHandlers, iupdatemsgreminderscounts);
        }

        public final void unregisterSavedSearchHandler(IUpdateSavedSearch iupdatesavedsearch)
        {
            unregister(savedSearchHandlers, iupdatesavedsearch);
        }

        public final void unregisterUserDetailsHandler(IUpdateUserDetails iupdateuserdetails)
        {
            unregister(userDetailsHandlers, iupdateuserdetails);
        }

        public final void unregisterUserProfileHandler(IUpdateUserProfile iupdateuserprofile)
        {
            unregister(userProfileHandlers, iupdateuserprofile);
        }

        public final void updateFavSellers()
        {
            ArrayList arraylist = favSellersHandlers;
            arraylist;
            JVM INSTR monitorenter ;
            int j;
            flagFavSellersState = 1;
            j = arraylist.size();
_L1:
            if (j <= 0)
            {
                break MISSING_BLOCK_LABEL_67;
            }
            j--;
            Object obj = (IUpdateFavSellers)((WeakReference)arraylist.get(j)).get();
            if (obj != null)
            {
                break MISSING_BLOCK_LABEL_58;
            }
            arraylist.remove(j);
              goto _L1
            obj;
            arraylist;
            JVM INSTR monitorexit ;
            throw obj;
            ((IUpdateFavSellers) (obj)).updateFavSellers();
              goto _L1
            arraylist;
            JVM INSTR monitorexit ;
        }

        public final void updateMsgRemindersCounts(UserActivitySummary useractivitysummary)
        {
            ArrayList arraylist = msgRemindersCountsHandlers;
            arraylist;
            JVM INSTR monitorenter ;
            int j;
            msgRemindersSummary.messagesNewAlertCount = useractivitysummary.messagesNewAlertCount;
            msgRemindersSummary.messagesNewMessageCount = useractivitysummary.messagesNewMessageCount;
            msgRemindersSummary.buyingFeedbackToSend = useractivitysummary.buyingFeedbackToSend;
            msgRemindersSummary.buyingPaymentToSend = useractivitysummary.buyingPaymentToSend;
            msgRemindersSummary.buyingBiddingCount = useractivitysummary.buyingBiddingCount;
            msgRemindersSummary.buyingWinningCount = useractivitysummary.buyingWinningCount;
            msgRemindersSummary.buyingWonCount = useractivitysummary.buyingWonCount;
            msgRemindersSummary.buyingWonDurationInDays = useractivitysummary.buyingWonDurationInDays;
            msgRemindersSummary.buyingOutbidCount = useractivitysummary.buyingOutbidCount;
            msgRemindersSummary.buyingBestOfferCount = useractivitysummary.buyingBestOfferCount;
            msgRemindersSummary.buyingWatchCount = useractivitysummary.buyingWatchCount;
            msgRemindersSummary.buyingBidEndingSoonCount = useractivitysummary.buyingBidEndingSoonCount;
            msgRemindersSummary.buyingSecondChanceOfferCount = useractivitysummary.buyingSecondChanceOfferCount;
            msgRemindersSummary.buyingWatchEndingSoonCount = useractivitysummary.buyingWatchEndingSoonCount;
            msgRemindersSummary.sellingFeedbackToSend = useractivitysummary.sellingFeedbackToSend;
            msgRemindersSummary.sellingPaymentToReceive = useractivitysummary.sellingPaymentToReceive;
            msgRemindersSummary.sellingShippingNeeded = useractivitysummary.sellingShippingNeeded;
            msgRemindersSummary.sellingActiveCount = useractivitysummary.sellingActiveCount;
            msgRemindersSummary.sellingSoldCount = useractivitysummary.sellingSoldCount;
            msgRemindersSummary.sellingUnsoldCount = useractivitysummary.sellingUnsoldCount;
            msgRemindersSummary.sellingScheduledCount = useractivitysummary.sellingScheduledCount;
            msgRemindersSummary.sellingDurationInDays = useractivitysummary.sellingDurationInDays;
            msgRemindersSummary.sellingBestOfferCount = useractivitysummary.sellingBestOfferCount;
            msgRemindersSummary.sellingSellEndingSoonCount = useractivitysummary.sellingSellEndingSoonCount;
            flagMsgRemindersCountsState = 1;
            j = arraylist.size();
_L1:
            if (j <= 0)
            {
                break MISSING_BLOCK_LABEL_338;
            }
            j--;
            IUpdateMsgRemindersCounts iupdatemsgreminderscounts = (IUpdateMsgRemindersCounts)((WeakReference)arraylist.get(j)).get();
            if (iupdatemsgreminderscounts != null)
            {
                break MISSING_BLOCK_LABEL_328;
            }
            arraylist.remove(j);
              goto _L1
            useractivitysummary;
            arraylist;
            JVM INSTR monitorexit ;
            throw useractivitysummary;
            iupdatemsgreminderscounts.updateMsgRemindersCounts(useractivitysummary);
              goto _L1
            arraylist;
            JVM INSTR monitorexit ;
        }

        public final void updateSavedSearch(SavedSearchList savedsearchlist)
        {
            ArrayList arraylist = savedSearchHandlers;
            arraylist;
            JVM INSTR monitorenter ;
            int j;
            flagSavedSearchState = 1;
            j = arraylist.size();
_L1:
            if (j <= 0)
            {
                break MISSING_BLOCK_LABEL_74;
            }
            j--;
            IUpdateSavedSearch iupdatesavedsearch = (IUpdateSavedSearch)((WeakReference)arraylist.get(j)).get();
            if (iupdatesavedsearch != null)
            {
                break MISSING_BLOCK_LABEL_64;
            }
            arraylist.remove(j);
              goto _L1
            savedsearchlist;
            arraylist;
            JVM INSTR monitorexit ;
            throw savedsearchlist;
            iupdatesavedsearch.updateSavedSearch(savedsearchlist);
              goto _L1
            arraylist;
            JVM INSTR monitorexit ;
        }

        public final void updateUserDetails(UserDetail userdetail)
        {
            ArrayList arraylist = userDetailsHandlers;
            arraylist;
            JVM INSTR monitorenter ;
            int j;
            userDetails = userdetail;
            flagUserDetailsState = 1;
            j = arraylist.size();
_L1:
            if (j <= 0)
            {
                break MISSING_BLOCK_LABEL_79;
            }
            j--;
            IUpdateUserDetails iupdateuserdetails = (IUpdateUserDetails)((WeakReference)arraylist.get(j)).get();
            if (iupdateuserdetails != null)
            {
                break MISSING_BLOCK_LABEL_69;
            }
            arraylist.remove(j);
              goto _L1
            userdetail;
            arraylist;
            JVM INSTR monitorexit ;
            throw userdetail;
            iupdateuserdetails.updateUserDetails(userdetail);
              goto _L1
            arraylist;
            JVM INSTR monitorexit ;
        }

        public final void updateUserProfile(UserProfile userprofile)
        {
            ArrayList arraylist = userProfileHandlers;
            arraylist;
            JVM INSTR monitorenter ;
            int j;
            userProfile = userprofile;
            flagUserProfileState = 1;
            j = arraylist.size();
_L1:
            if (j <= 0)
            {
                break MISSING_BLOCK_LABEL_79;
            }
            j--;
            IUpdateUserProfile iupdateuserprofile = (IUpdateUserProfile)((WeakReference)arraylist.get(j)).get();
            if (iupdateuserprofile != null)
            {
                break MISSING_BLOCK_LABEL_69;
            }
            arraylist.remove(j);
              goto _L1
            userprofile;
            arraylist;
            JVM INSTR monitorexit ;
            throw userprofile;
            iupdateuserprofile.updateUserProfile(userprofile);
              goto _L1
            arraylist;
            JVM INSTR monitorexit ;
        }




/*
        static int access$1072(Internal internal, int j)
        {
            j = internal.flagUserDetailsState & j;
            internal.flagUserDetailsState = j;
            return j;
        }

*/


/*
        static Thread access$1102(Internal internal, Thread thread)
        {
            internal.threadUserDetails = thread;
            return thread;
        }

*/



/*
        static int access$1472(Internal internal, int j)
        {
            j = internal.flagFavSellersState & j;
            internal.flagFavSellersState = j;
            return j;
        }

*/


/*
        static Thread access$1502(Internal internal, Thread thread)
        {
            internal.threadFavSellerList = thread;
            return thread;
        }

*/



/*
        static SavedSearchList access$1702(Internal internal, SavedSearchList savedsearchlist)
        {
            internal.savedSearchList = savedsearchlist;
            return savedsearchlist;
        }

*/


/*
        static int access$202(Internal internal, int j)
        {
            internal.flagMsgRemindersCountsState = j;
            return j;
        }

*/


/*
        static int access$2472(Internal internal, int j)
        {
            j = internal.flagSavedSearchState & j;
            internal.flagSavedSearchState = j;
            return j;
        }

*/


/*
        static Thread access$2502(Internal internal, Thread thread)
        {
            internal.threadSavedSearchList = thread;
            return thread;
        }

*/


/*
        static int access$272(Internal internal, int j)
        {
            j = internal.flagMsgRemindersCountsState & j;
            internal.flagMsgRemindersCountsState = j;
            return j;
        }

*/


/*
        static Thread access$302(Internal internal, Thread thread)
        {
            internal.threadMsgRemindersCounts = thread;
            return thread;
        }

*/



/*
        static int access$672(Internal internal, int j)
        {
            j = internal.flagUserProfileState & j;
            internal.flagUserProfileState = j;
            return j;
        }

*/


/*
        static Thread access$702(Internal internal, Thread thread)
        {
            internal.threadUserProfile = thread;
            return thread;
        }

*/


        private Internal()
        {
            flagMsgRemindersCountsState = 0;
            threadMsgRemindersCounts = null;
            flagUserProfileState = 0;
            timeSinceLastProfileUpdate = 0L;
            userProfile = null;
            threadUserProfile = null;
            flagUserDetailsState = 0;
            userDetails = null;
            threadUserDetails = null;
            flagFavSellersState = 0;
            favSellerList = null;
            threadFavSellerList = null;
            flagSavedSearchState = 0;
            savedSearchList = new SavedSearchList();
            threadSavedSearchList = null;
        }
    }

    public static class PaidStatusAndTime
    {

        public String apiTime;
        public String status;
        public Long timestamp;

        public PaidStatusAndTime(String s, String s1, Long long1)
        {
            status = s;
            apiTime = s1;
            timestamp = long1;
        }
    }

    private static final class TUpdateMsgRemindersCounts extends Thread
    {

        private final ApplicationProcessServiceApi api;
        private final Internal i;
        private final String iafToken;
        private final String userId;

        public void run()
        {
            Runnable runnable;
            Object obj;
            com.ebay.common.net.EbayRequestHelper.EbayRequestErrorException ebayrequesterrorexception;
            try
            {
                Process.setThreadPriority(10);
            }
            catch (Exception exception) { }
            runnable = api.getUserActivitySummary(iafToken, userId). new Runnable() {

                final TUpdateMsgRemindersCounts this$0;
                final UserActivitySummary val$summary;

                public void run()
                {
                    i.updateMsgRemindersCounts(summary);
                }

            
            {
                this$0 = final_tupdatemsgreminderscounts;
                summary = UserActivitySummary.this;
                super();
            }
            };
            if (!i.runHandler.post(runnable))
            {
                throw new Exception();
            }
            break MISSING_BLOCK_LABEL_94;
            ebayrequesterrorexception;
            synchronized (i.msgRemindersCountsHandlers)
            {
                i.flagMsgRemindersCountsState = 0;
            }
            i.onEbayError(ebayrequesterrorexception.getErrors());
            i.threadMsgRemindersCounts = null;
            return;
            i.threadMsgRemindersCounts = null;
            return;
            exception1;
            arraylist;
            JVM INSTR monitorexit ;
            throw exception1;
            obj;
            i.threadMsgRemindersCounts = null;
            throw obj;
            obj;
            synchronized (i.msgRemindersCountsHandlers)
            {
                <no variable> = ((access._cls202) (this)).access$202 & <no variable>;
            }
            i.onError();
            i.threadMsgRemindersCounts = null;
            return;
            exception2;
            arraylist1;
            JVM INSTR monitorexit ;
            throw exception2;
        }


        public TUpdateMsgRemindersCounts(Internal internal, ApplicationProcessServiceApi applicationprocessserviceapi, String s, String s1)
        {
            i = internal;
            api = applicationprocessserviceapi;
            iafToken = s;
            userId = s1;
        }
    }

    private static final class TUpdateSavedSearch extends Thread
    {

        private final WeakReference contextRef;
        private final EbayContext ebayContext;
        private final Internal i;
        private final String iafToken;
        private final boolean refreshNewItemCounts;

        public void run()
        {
            try
            {
                Process.setThreadPriority(10);
            }
            catch (Exception exception) { }
            obj1 = (Context)contextRef.get();
            if (obj1 == null)
            {
                i.threadSavedSearchList = null;
                return;
            }
            obj = new SavedSearchList();
            if (refreshNewItemCounts) goto _L2; else goto _L1
_L1:
            ((SavedSearchList) (obj)).setSearchList(PollServiceListCache.fetchSavedSearchList(((Context) (obj1)), ebayContext, iafToken));
_L4:
            synchronized (i.savedSearchHandlers)
            {
                i.savedSearchList = ((SavedSearchList) (obj));
            }
            try
            {
                obj = ((_cls1) (obj)). new Runnable() {

                    final TUpdateSavedSearch this$0;
                    final SavedSearchList val$list;

                    public void run()
                    {
                        i.updateSavedSearch(list);
                        if (!refreshNewItemCounts)
                        {
                            (new TUpdateSavedSearch(i, (Context)contextRef.get(), ebayContext, iafToken, true)).start();
                        }
                    }

            
            {
                this$0 = final_tupdatesavedsearch;
                list = SavedSearchList.this;
                super();
            }
                };
                if (!i.runHandler.post(((Runnable) (obj))))
                {
                    throw new Exception();
                }
                break; /* Loop/switch isn't completed */
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
            finally
            {
                i.threadSavedSearchList = null;
            }
            Log.e("UserCache", "exception in TUpdateSavedSearch", ((Throwable) (obj)));
            synchronized (i.savedSearchHandlers)
            {
                <no variable> = 
// JavaClassFileOutputException: get_constant: invalid tag






        public TUpdateSavedSearch(Internal internal, Context context1, EbayContext ebaycontext, String s)
        {
            this(internal, context1, ebaycontext, s, false);
        }

        private TUpdateSavedSearch(Internal internal, Context context1, EbayContext ebaycontext, String s, boolean flag)
        {
            i = internal;
            contextRef = new WeakReference(context1);
            ebayContext = ebaycontext;
            iafToken = s;
            refreshNewItemCounts = flag;
        }

    }


    private static final String ANY_TRANS_ID = "any";
    private static final int FLAG_FETCHING = 2;
    private static final int FLAG_NONE = 0;
    private static final int FLAG_RECEIVED = 1;
    private final Context context;
    private final EbayContext ebayContext;
    private final Internal i;

    public UserCache(Context context1, EbayContext ebaycontext)
    {
        context = context1;
        ebayContext = ebaycontext;
        i = Internal.get();
    }

    public UserCache(BaseActivity baseactivity)
    {
        UserCache(((Context) (baseactivity)), baseactivity.getEbayContext());
    }

    public static final void clearDetailsForLogout()
    {
        Internal internal = Internal.getIfExists();
        if (internal != null)
        {
            internal.clearAll();
        }
    }

    private Authentication getAuthentication()
    {
        return MyApp.getPrefs().getAuthentication();
    }

    public static final SavedSearchList getSavedSearchList()
    {
        Internal internal = Internal.getIfExists();
        if (internal != null)
        {
            return internal.getSavedSearchList();
        } else
        {
            return new SavedSearchList();
        }
    }

    private EbayTradingApi getTradingApi()
    {
        Authentication authentication = getAuthentication();
        if (authentication != null)
        {
            return EbayApiUtil.getTradingApi(context, authentication);
        } else
        {
            return null;
        }
    }

    public static final UserDetail getUserDetails()
    {
        Internal internal = Internal.getIfExists();
        if (internal != null)
        {
            return internal.getUserDetails();
        } else
        {
            return null;
        }
    }

    public final void addToFavSeller(String s)
    {
        i.addToFavSeller(s);
    }

    public final void addToLeftFeedback(String s, String s1)
    {
        i.addToLeftFeedback(s, s1);
    }

    public final void addToPaidStatus(String s, String s1, String s2, String s3)
    {
        i.addToPaidStatus(s, s1, new PaidStatusAndTime(s2, s3, Long.valueOf(System.currentTimeMillis())));
        ServiceContentOverride.setPaidStatus(Long.valueOf(s).longValue(), s1, s2);
    }

    public final void assignFavSellers(ArrayList arraylist)
    {
        i.assignFavSellers(arraylist);
    }

    public final void clearFavSellers()
    {
        i.clearFavSellers();
    }

    public final void clearLeftFeedback()
    {
        i.clearLeftFeedback();
    }

    public final void clearPaid()
    {
        i.clearPaid();
    }

    public final void clearSavedSearchList()
    {
        i.clearSavedSearch();
    }

    public final void clearShipped()
    {
        i.clearShipped();
    }

    public final PaidStatusAndTime getPaidStatusAndTime(String s, String s1)
    {
        return i.getPaidStatusAndTime(s, s1);
    }

    public final boolean hasLeftFeedback(String s, String s1)
    {
        return i.hasLeftFeedback(s, s1);
    }

    public final boolean isFavSeller(String s)
    {
        return i.isFavSeller(s);
    }

    public final boolean isPriceRevealed(String s)
    {
        return i.isPriceRevealed(s);
    }

    public final boolean isShipped(String s, String s1)
    {
        return i.isShipped(s, s1);
    }

    public final void refreshAll()
    {
        Authentication authentication = getAuthentication();
        if (authentication != null)
        {
            i.refreshAll(authentication, context, ebayContext);
        }
    }

    public final void refreshMsgRemindersCounts()
    {
        Authentication authentication = getAuthentication();
        if (authentication != null)
        {
            i.refreshMsgRemindersCounts(authentication, EbayApiUtil.getApsApi(ebayContext));
        }
    }

    public final void refreshSavedSearchList()
    {
        Authentication authentication = getAuthentication();
        if (authentication != null)
        {
            i.refreshSavedSearch(context, ebayContext, authentication.iafToken);
        }
    }

    public final void refreshUserDetails()
    {
        EbayTradingApi ebaytradingapi = getTradingApi();
        if (ebaytradingapi != null)
        {
            i.refreshUserDetails(ebayContext, ebaytradingapi);
        }
    }

    public final void refreshUserProfile()
    {
        Authentication authentication = getAuthentication();
        if (authentication != null)
        {
            i.refreshUserProfile(ebayContext, EbayApiUtil.getShoppingApi(context), authentication.user);
        }
    }

    public final void registerFavSellersHandler(IUpdateFavSellers iupdatefavsellers)
    {
        i.registerFavSellersHandler(ebayContext, getTradingApi(), iupdatefavsellers);
    }

    public final void registerMsgRemindersCountsHandler(IUpdateMsgRemindersCounts iupdatemsgreminderscounts, boolean flag)
    {
        i.registerMsgRemindersCountsHandler(getAuthentication(), EbayApiUtil.getApsApi(ebayContext), iupdatemsgreminderscounts, flag);
    }

    public final void registerSavedSearchHandler(IUpdateSavedSearch iupdatesavedsearch)
    {
        Object obj = getAuthentication();
        Internal internal = i;
        Context context1 = context;
        EbayContext ebaycontext = ebayContext;
        if (obj != null)
        {
            obj = ((Authentication) (obj)).iafToken;
        } else
        {
            obj = null;
        }
        internal.registerSavedSearchHandler(context1, ebaycontext, ((String) (obj)), iupdatesavedsearch);
    }

    public final void registerUserDetailsHandler(IUpdateUserDetails iupdateuserdetails)
    {
        i.registerUserDetailsHandler(ebayContext, getTradingApi(), iupdateuserdetails);
    }

    public final void registerUserProfileHandler(IUpdateUserProfile iupdateuserprofile)
    {
        Authentication authentication = getAuthentication();
        if (authentication != null)
        {
            i.registerUserProfileHandler(ebayContext, EbayApiUtil.getShoppingApi(context), authentication.user, iupdateuserprofile);
            return;
        } else
        {
            i.registerUserProfileHandler(ebayContext, null, null, iupdateuserprofile);
            return;
        }
    }

    public final void removeFavSeller(String s)
    {
        i.removeFavSeller(s);
    }

    public final void setPriceRevealed(String s)
    {
        i.setPriceRevealed(s);
    }

    public final void setShipped(String s, String s1, boolean flag)
    {
        i.setShipped(s, s1, flag);
    }

    public final void setUserDetails(UserDetail userdetail)
    {
        i.setUserDetails(userdetail);
    }

    public final void setUserProfile(UserProfile userprofile)
    {
        i.setUserProfile(userprofile);
    }

    public final void signIn(String s, String s1)
    {
        s = MyApp.getPrefs().signInHelper(s, s1);
        if (s != null)
        {
            i.refreshAll(s, context, ebayContext);
        }
    }

    public final void unregisterFavSellersHandler(IUpdateFavSellers iupdatefavsellers)
    {
        i.unregisterFavSellersHandler(iupdatefavsellers);
    }

    public final void unregisterMsgRemindersCountsHandler(IUpdateMsgRemindersCounts iupdatemsgreminderscounts)
    {
        i.unregisterMsgRemindersCountsHandler(iupdatemsgreminderscounts);
    }

    public final void unregisterSavedSearchHandler(IUpdateSavedSearch iupdatesavedsearch)
    {
        i.unregisterSavedSearchHandler(iupdatesavedsearch);
    }

    public final void unregisterUserDetailsHandler(IUpdateUserDetails iupdateuserdetails)
    {
        i.unregisterUserDetailsHandler(iupdateuserdetails);
    }

    public final void unregisterUserProfileHandler(IUpdateUserProfile iupdateuserprofile)
    {
        i.unregisterUserProfileHandler(iupdateuserprofile);
    }
}
