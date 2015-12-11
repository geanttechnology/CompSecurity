// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.core;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Patterns;
import android.view.View;
import com.groupon.db.models.DealType;
import com.groupon.models.billingrecord.BillingRecord;
import com.groupon.models.billingrecord.BillingRecordContainer;
import com.groupon.models.country.Country;
import com.groupon.models.order.OrderContainer;
import com.groupon.models.signup.CreditsAvailable;
import com.groupon.models.signup.Flags;
import com.groupon.models.signup.SignupResponse;
import com.groupon.models.signup.User;
import com.groupon.models.user.UserContainer;
import com.groupon.service.ApiServiceBase;
import com.groupon.service.LoginService;
import com.groupon.service.SignUpService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.sso.SSOHelper;
import com.groupon.sso.UserCredential;
import com.groupon.util.ArraySharedPreferences;
import com.groupon.util.BillingRecordExpiryChecker;
import com.groupon.util.Dates;
import com.groupon.util.Function0;
import com.groupon.util.Function1;
import com.groupon.util.ReturningFunction1;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.RequestBody;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import roboguice.inject.Lazy;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.service.core:
//            CoreService

public class UserManager extends CoreService
{

    public static final String BILLING_RECORD_ID = "billingRecordId";
    private static final String ID = "id";
    public static final String LEGAL_TERMS_ACCEPTED = "legalTermsAccepted";
    private static final String PREF_KEY_USER_MANAGER_SERVICE_TIMESTAMP = "UserManagerTimestamp";
    private static final String USER = "user";
    private BillingRecordExpiryChecker billingRecordExpiryChecker;
    private ApiServiceBase billingRecordsService;
    private Context context;
    private Lazy currentCountryManager;
    private HashSet faves;
    private ArraySharedPreferences loginPrefs;
    private Lazy loginService;
    private ApiServiceBase ordersService;
    private Lazy prefs;
    private ApiServiceBase userService;

    public UserManager()
    {
    }

    private String generateShowParameterValue(boolean flag, boolean flag1)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add("default");
        if (flag)
        {
            arraylist.add("shippingAddresses");
        }
        if (flag1)
        {
            arraylist.add("creditsAvailable");
        }
        return Strings.join(",", arraylist);
    }

    private String getUsersBillingRecordsIdUrl(String s)
    {
        return String.format("https:/users/%s/billing_records/%s", new Object[] {
            ((LoginService)loginService.get()).getUserId(), s
        });
    }

    private String getUsersBillingRecordsUrl()
    {
        return String.format("https:/users/%s/billing_records", new Object[] {
            ((LoginService)loginService.get()).getUserId()
        });
    }

    private String getUsersUrl()
    {
        return String.format("https:/users/%s", new Object[] {
            ((LoginService)loginService.get()).getUserId()
        });
    }

    private void init()
    {
        userService = new ApiServiceBase(context, com/groupon/models/user/UserContainer);
        billingRecordsService = new ApiServiceBase(context, com/groupon/models/billingrecord/BillingRecordContainer);
        ordersService = new ApiServiceBase(context, com/groupon/models/order/OrderContainer);
        loginService = new Lazy(context) {

            final UserManager this$0;

            
            {
                this$0 = UserManager.this;
                super(context1);
            }
        };
        currentCountryManager = new Lazy(context) {

            final UserManager this$0;

            
            {
                this$0 = UserManager.this;
                super(context1);
            }
        };
        prefs = new Lazy(context) {

            final UserManager this$0;

            
            {
                this$0 = UserManager.this;
                super(context1);
            }
        };
    }

    public void acceptLegalTerms(Function0 function0, Function1 function1, Function0 function0_1)
    {
        RequestBody requestbody = (new FormEncodingBuilder()).add("legalTermsAccepted", String.valueOf(true)).build();
        Ln.d((new StringBuilder()).append("put: ").append(requestbody).toString(), new Object[0]);
        function0 = new SignUpService(function0, function1, function0_1) {

            final UserManager this$0;
            final Function1 val$onExceptionListener;
            final Function0 val$onFinallyListener;
            final Function0 val$onSuccessListener;

            public void onException(Exception exception)
            {
                if (onExceptionListener != null)
                {
                    onExceptionListener.execute(exception);
                }
            }

            public void onFinally()
            {
                if (onFinallyListener != null)
                {
                    onFinallyListener.execute();
                }
            }

            protected void onSuccess(SignupResponse signupresponse)
                throws Exception
            {
                super.onSuccess(signupresponse);
                if (onSuccessListener != null)
                {
                    onSuccessListener.execute();
                }
            }

            
            {
                this$0 = UserManager.this;
                onSuccessListener = function0;
                onExceptionListener = function1;
                onFinallyListener = function0_1;
                super(final_context1, final_s, final_requestbody);
            }
        };
        function0.method("PUT");
        function0.execute();
_L1:
        return;
        function0;
        Ln.e(function0);
        if (function1 != null)
        {
            function1.execute(function0);
            return;
        }
          goto _L1
    }

    public void addFavoriteDealType(String s)
    {
        try
        {
            loginPrefs.edit().appendUniqueToList("dealTypes", s).apply();
            Ln.d("DEALTYPES: add deal tag: %s", new Object[] {
                s
            });
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Ln.e(s, "Impossible to append dealType.", new Object[0]);
        }
        try
        {
            faves = new HashSet(loginPrefs.getListString("dealTypes", new ArrayList()));
            Ln.d("DEALTYPES: new list = %s", new Object[] {
                faves.toString()
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Ln.e(s, "Impossible to append dealType.", new Object[0]);
        }
    }

    public int getDealTypeSuccessTooltipCount()
    {
        return loginPrefs.getInt("dealTypeSuccessTooltipCount", 0);
    }

    public BillingRecord getDefaultBillingRecord(List list)
    {
        Object obj = null;
        BillingRecord billingrecord = obj;
        if (list != null)
        {
            billingrecord = obj;
            if (!list.isEmpty())
            {
                list = list.iterator();
                do
                {
                    billingrecord = obj;
                    if (!list.hasNext())
                    {
                        break;
                    }
                    billingrecord = (BillingRecord)list.next();
                } while (billingRecordExpiryChecker.isBillingRecordExpired(billingrecord));
            }
        }
        return billingrecord;
    }

    public void getDefaultBillingRecord(final Function1 onSuccess, ReturningFunction1 returningfunction1, Function0 function0)
    {
        getUserData(false, false, new Function1() {

            final UserManager this$0;
            final Function1 val$onSuccess;

            public void execute(UserContainer usercontainer)
                throws RuntimeException
            {
                if (usercontainer != null)
                {
                    usercontainer = usercontainer.user.billingRecords;
                    onSuccess.execute(getDefaultBillingRecord(usercontainer));
                }
            }

            public volatile void execute(Object obj)
                throws Exception
            {
                execute((UserContainer)obj);
            }

            
            {
                this$0 = UserManager.this;
                onSuccess = function1;
                super();
            }
        }, returningfunction1, function0, null);
    }

    public List getDeviceAndGrouponEmailAccounts()
    {
        List list = getDeviceEmailAccounts();
        String s = ((SharedPreferences)prefs.get()).getString("emailPrefill", "");
        String s1 = loginPrefs.getString("email", "");
        if (Strings.notEmpty(s1) && !list.contains(s1))
        {
            list.add(s1);
        }
        if (Strings.notEmpty(s) && !list.contains(s))
        {
            list.add(s);
        }
        return list;
    }

    public List getDeviceEmailAccounts()
    {
        HashSet hashset = new HashSet();
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        Account aaccount[] = AccountManager.get(context).getAccounts();
        int j = aaccount.length;
        for (int i = 0; i < j; i++)
        {
            Account account = aaccount[i];
            if (pattern.matcher(account.name).matches())
            {
                hashset.add(account.name);
            }
        }

        return new ArrayList(hashset);
    }

    public String getDeviceFirstEmailAccount()
    {
        Pattern pattern = com.groupon.Constants.RegularExpressions.EMAIL_ADDRESS;
        Account aaccount[] = AccountManager.get(context).getAccounts();
        int j = aaccount.length;
        for (int i = 0; i < j; i++)
        {
            Account account = aaccount[i];
            if (pattern.matcher(account.name).matches())
            {
                return account.name;
            }
        }

        return "";
    }

    public Set getFavoriteDealTypes()
    {
        HashSet hashset;
        try
        {
            if (faves != null)
            {
                return faves;
            }
            hashset = new HashSet(loginPrefs.getListString("dealTypes", new ArrayList()));
        }
        catch (IOException ioexception)
        {
            Ln.e(ioexception, "Impossible to read favorite deal types.", new Object[0]);
            return new HashSet();
        }
        return hashset;
    }

    public String getPrimaryEmailAddress()
    {
        return loginPrefs.getString("primaryEmailAddress", "");
    }

    public void getUserData(boolean flag, boolean flag1, Function1 function1, ReturningFunction1 returningfunction1, Function0 function0, Function0 function0_1)
    {
        ArrayList arraylist = new ArrayList(Arrays.asList(new Object[] {
            "show", generateShowParameterValue(flag, flag1)
        }));
        userService.execute(function1, returningfunction1, function0, function0_1, getUsersUrl(), "GET", arraylist);
    }

    public int getValidBillingRecordCountAtInitialization()
    {
        return loginPrefs.getInt("billingRecordCountAtLogin", 0);
    }

    public boolean hasAcceptedLegalTerms()
    {
        return loginPrefs.getBoolean("legalTermsAccepted", false) || !((CurrentCountryManager)currentCountryManager.get()).getCurrentCountry().supportsIHQ();
    }

    public boolean hasSeenCouponsIntroScreen()
    {
        return ((SharedPreferences)prefs.get()).getBoolean("hasSeenCouponsIntroScreen", false);
    }

    public boolean isAutoRefundEnabled()
    {
        return loginPrefs.getBoolean("isAutoRefundEnabled", false);
    }

    public boolean isDownloadingDataFromNetwork()
    {
        return true;
    }

    protected boolean isUpToDate()
    {
        return !((LoginService)loginService.get()).isLoggedIn() || Dates.isToday(loginPrefs.getLong("UserManagerTimestamp", 0L));
    }

    public void refresh()
        throws Exception
    {
        if (!((LoginService)loginService.get()).isLoggedIn())
        {
            return;
        } else
        {
            SignupResponse signupresponse = (new SignUpService(context, String.format("https:/users/%s", new Object[] {
                ((LoginService)loginService.get()).getUserId()
            }), new Object[0])).callAndConvert();
            updateUserDetails(context, signupresponse.user);
            return;
        }
    }

    public void refreshWithConsumerId(String s)
        throws Exception
    {
        s = (new SignUpService(context, String.format("https:/users/%s", new Object[] {
            s
        }), new Object[0])).callAndConvert();
        updateUserDetails(context, ((SignupResponse) (s)).user);
    }

    public void removeFavoriteDealType(String s)
    {
        try
        {
            faves.remove(s);
            loginPrefs.edit().putListString("dealTypes", new ArrayList(faves)).apply();
            Ln.d((new StringBuilder()).append("DEALTYPES: remove deal tag: ").append(s).toString(), new Object[0]);
            Ln.d("DEALTYPES: new list = %s", new Object[] {
                getFavoriteDealTypes().toString()
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Ln.e(s, "", new Object[0]);
        }
    }

    public void resetToNotUpToDate()
    {
        loginPrefs.edit().remove("UserManagerTimestamp").apply();
    }

    public void saveBillingRecord(View view, List list, Function1 function1, ReturningFunction1 returningfunction1, Function0 function0, Function0 function0_1)
    {
        billingRecordsService.withProgress(view).execute(function1, returningfunction1, function0, function0_1, getUsersBillingRecordsUrl(), "POST", list);
    }

    public void saveOrderResult(List list, Function1 function1, ReturningFunction1 returningfunction1)
    {
        saveOrderResult(list, null, function1, returningfunction1);
    }

    public void saveOrderResult(List list, String s, final Function1 successCallback, ReturningFunction1 returningfunction1)
    {
        if (s == null)
        {
            s = String.format("https:/users/%s/orders", new Object[] {
                ((LoginService)loginService.get()).getUserId()
            });
        } else
        {
            s = String.format("https:/users/%s/orders?lang=%s", new Object[] {
                ((LoginService)loginService.get()).getUserId(), s
            });
        }
        ordersService.execute(new Function1() {

            final UserManager this$0;
            final Function1 val$successCallback;

            public void execute(OrderContainer ordercontainer)
                throws RuntimeException
            {
                if (successCallback != null)
                {
                    successCallback.execute(ordercontainer.order);
                }
            }

            public volatile void execute(Object obj)
                throws Exception
            {
                execute((OrderContainer)obj);
            }

            
            {
                this$0 = UserManager.this;
                successCallback = function1;
                super();
            }
        }, returningfunction1, null, null, s, "POST", list);
    }

    public void setDealTypeSuccessTooltipCount(int i)
    {
        loginPrefs.edit().putInt("dealTypeSuccessTooltipCount", i).apply();
    }

    public void setHasSeenCouponsIntroScreen()
    {
        ((SharedPreferences)prefs.get()).edit().putBoolean("hasSeenCouponsIntroScreen", true).apply();
    }

    public void updateBillingRecord(String s, View view, List list, Function1 function1, ReturningFunction1 returningfunction1, Function0 function0, Function0 function0_1)
    {
        billingRecordsService.withProgress(view).execute(function1, returningfunction1, function0, function0_1, getUsersBillingRecordsIdUrl(s), "PUT", list);
    }

    public void updateOrderResult(List list, final Function1 successCallback, ReturningFunction1 returningfunction1)
    {
        String s = String.format("https:/users/%s/orders", new Object[] {
            ((LoginService)loginService.get()).getUserId()
        });
        ordersService.execute(new Function1() {

            final UserManager this$0;
            final Function1 val$successCallback;

            public void execute(OrderContainer ordercontainer)
                throws RuntimeException
            {
                if (successCallback != null)
                {
                    successCallback.execute(ordercontainer.order);
                }
            }

            public volatile void execute(Object obj)
                throws Exception
            {
                execute((OrderContainer)obj);
            }

            
            {
                this$0 = UserManager.this;
                successCallback = function1;
                super();
            }
        }, returningfunction1, null, null, s, "PUT", list);
    }

    public void updateUserDetails(Context context1, User user)
    {
        DealType adealtype[] = user.dealTypes;
        ArrayList arraylist;
        boolean flag;
        if (adealtype != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Ln.d("DEALTYPES: has dealTypes = %s", new Object[] {
            Boolean.valueOf(flag)
        });
        arraylist = new ArrayList();
        if (adealtype != null)
        {
            int k = adealtype.length;
            for (int i = 0; i < k; i++)
            {
                String s1 = adealtype[i].remoteId;
                Ln.d("DEALTYPES: adding %s", new Object[] {
                    s1
                });
                arraylist.add(s1);
            }

        }
        if (!((CurrentCountryManager)currentCountryManager.get()).getCurrentCountry().isUSACompatible());
        int l = 0;
        int j = 0;
        if (user.billingRecords != null)
        {
            BillingRecord abillingrecord[] = user.billingRecords;
            int j1 = abillingrecord.length;
            int i1 = 0;
            do
            {
                l = j;
                if (i1 >= j1)
                {
                    break;
                }
                BillingRecord billingrecord = abillingrecord[i1];
                l = j;
                if (Strings.notEmpty(billingrecord.id))
                {
                    l = j;
                    if (Strings.notEmpty(billingrecord.cardNumber))
                    {
                        l = j + 1;
                    }
                }
                i1++;
                j = l;
            } while (true);
        }
        String s = user.id;
        UserCredential usercredential = SSOHelper.getAppAccount(context1, ((CurrentCountryManager)currentCountryManager.get()).getCurrentCountry().isoName);
        if (usercredential != null)
        {
            usercredential.setUserFullName(user.firstName);
            SSOHelper.addOrUpdateAccountForApp(context1, usercredential);
        }
        flag = user.flags.isFeedEnabled;
        if (user.creditsAvailable != null)
        {
            context1 = user.creditsAvailable.formattedAmount;
            j = user.creditsAvailable.amount;
        } else
        {
            context1 = "";
            j = 0;
        }
        try
        {
            loginPrefs.edit().putString("userId", s).putString("consumerId", user.consumerId).putString("firstName", user.firstName).putString("lastName", user.lastName).putString("referralCode", user.referralCode).putString("primaryEmailAddress", user.primaryEmailAddress).putBoolean("isFeedEnabled", flag).putListString("dealTypes", arraylist).putInt("billingRecordCountAtLogin", l).putBoolean("legalTermsAccepted", user.legalTermsAccepted).putLong("UserManagerTimestamp", System.currentTimeMillis()).putString("user", Strings.toString(user)).putString("formattedAmount", context1).putInt("amount", j).apply();
        }
        // Misplaced declaration of an exception variable
        catch (Context context1)
        {
            Ln.e(context1, "Impossible to save login prefs.", new Object[0]);
        }
        if (((SharedPreferences)prefs.get()).contains("inAppMessageForceUpdate"))
        {
            ((SharedPreferences)prefs.get()).edit().putBoolean("inAppMessageForceUpdate", true).apply();
        }
    }

    public void updateUserDetails(User user)
    {
        updateUserDetails(context, user);
    }

    public boolean userHasValidBillingRecord()
    {
        return loginPrefs.getString("currentBillingRecordId", null) != null;
    }
}
