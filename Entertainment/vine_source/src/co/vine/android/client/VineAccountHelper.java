// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.client;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerFuture;
import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Base64;
import co.vine.android.VineLoggingException;
import co.vine.android.api.VineLogin;
import co.vine.android.provider.SettingsManager;
import co.vine.android.util.BuildUtil;
import co.vine.android.util.CrashUtil;
import co.vine.android.util.SystemUtil;
import com.edisonwang.android.slog.SLog;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

// Referenced classes of package co.vine.android.client:
//            Session, AppController

public class VineAccountHelper
{

    public static final String ACCOUNT_TYPE = BuildUtil.getAuthority(".auth");
    public static final String KEY_ADD_WIDGET = "account_add_widget";
    public static final String KEY_DID_SHOW_STORE_CONTACTS_PROMPT = "account_did_show_store_contacts";
    public static final String KEY_DID_SHOW_VM_ONBOARD = "account_did_show_vm_onboard";
    public static final String KEY_LOGIN_TYPE = "account_login_type";
    public static final String KEY_NORMAL_VIDEO_PLAYABLE = "account_normal_video_playable";
    public static final String KEY_PASSWORD_ENCRYPTED = "account_password_encrypted";
    public static final String KEY_SETTINGS = "account_settings";
    public static final String KEY_TWITTER_SECRET = "account_t_secret";
    public static final String KEY_TWITTER_TOKEN = "account_t_token";
    public static final String KEY_TWITTER_USERNAME = "account_t_username";
    public static final String KEY_TWITTER_USER_ID = "account_t_id";
    public static final String KEY_USER_AVATAR = "account_user_avatar";
    public static final String KEY_USER_DATA = "account_user_data";
    public static final String KEY_USER_ID = "account_user_info";
    public static final String KEY_USER_NAME = "account_user_name";
    public static final int LOGIN_TYPE_EMAIL = 1;
    public static final int LOGIN_TYPE_TWITTER = 2;
    public static final String SESSION_TOKEN_KEY = "co.vine.android.basic_auth.token.secret";
    private static Session mActiveSession;

    public VineAccountHelper()
    {
    }

    public static Account createAccount(Context context, String s, VineLogin vinelogin, String s1, String s2, String s3)
        throws VineLoggingException
    {
        Account account;
        AccountManager accountmanager;
label0:
        {
            accountmanager = AccountManager.get(context);
            Account account1 = getAccount(context, s);
            account = account1;
            if (account1 != null)
            {
                break label0;
            }
            account = new Account(s, ACCOUNT_TYPE);
            if (accountmanager != null)
            {
                boolean flag;
                try
                {
                    flag = accountmanager.addAccountExplicitly(account, null, null);
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    throw new VineLoggingException(context);
                }
                if (flag)
                {
                    break label0;
                }
            }
            return null;
        }
        vinelogin.loginType;
        JVM INSTR tableswitch 1 2: default 96
    //                   1 150
    //                   2 212;
           goto _L1 _L2 _L3
_L1:
        accountmanager.setUserData(account, "account_user_name", s3);
        accountmanager.setUserData(account, "account_user_avatar", s2);
        accountmanager.setUserData(account, "account_user_info", String.valueOf(vinelogin.userId));
        accountmanager.setAuthToken(account, "co.vine.android.basic_auth.token.secret", vinelogin.key);
        return account;
_L2:
        try
        {
            accountmanager.setPassword(account, encrypt(getDeviceId(context), s1));
            accountmanager.setUserData(account, "account_password_encrypted", String.valueOf(true));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            SLog.e("Error encrypting password.", context);
            accountmanager.setPassword(account, s1);
        }
        accountmanager.setUserData(account, "account_login_type", String.valueOf(1));
        continue; /* Loop/switch isn't completed */
_L3:
        accountmanager.setUserData(account, "account_t_token", vinelogin.twitterToken);
        accountmanager.setUserData(account, "account_t_secret", vinelogin.twitterSecret);
        accountmanager.setUserData(account, "account_t_id", String.valueOf(vinelogin.twitterUserId));
        accountmanager.setUserData(account, "account_t_username", vinelogin.twitterUsername);
        accountmanager.setUserData(account, "account_login_type", String.valueOf(2));
        if (true) goto _L1; else goto _L4
_L4:
    }

    private static Session createSession()
    {
        return new Session(null, 0L, null, null, null);
    }

    public static Session createSession(Context context, Account account)
    {
        AccountManager accountmanager = AccountManager.get(context);
        long l = getUserId(accountmanager, account);
        context = SettingsManager.getEdition(context);
        return new Session(getSessionKey(accountmanager, account), l, getName(accountmanager, account), getAvatarUrl(accountmanager, account), context);
    }

    private static String decrypt(String s, String s1)
        throws Exception
    {
        s = new SecretKeySpec(getKeyDigest(s), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(2, s);
        return new String(cipher.doFinal(Base64.decode(s1, 0)), "UTF-8");
    }

    private static String encrypt(String s, String s1)
        throws Exception
    {
        s = new SecretKeySpec(getKeyDigest(s), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(1, s);
        return Base64.encodeToString(cipher.doFinal(s1.getBytes("UTF-8")), 0);
    }

    public static Account getAccount(Context context, String s)
    {
        context = AccountManager.get(context);
        if (context != null)
        {
            context = context.getAccountsByType(ACCOUNT_TYPE);
            if (context != null)
            {
                int j = context.length;
                for (int i = 0; i < j; i++)
                {
                    Account account = context[i];
                    if (account.name.equals(s))
                    {
                        return account;
                    }
                }

            }
        }
        return null;
    }

    public static int getAccountsCount(Context context)
    {
        return AccountManager.get(context).getAccountsByType(ACCOUNT_TYPE).length;
    }

    public static Account getActiveAccount(Context context)
    {
        return getAccount(context, AppController.getInstance(context).getActiveSession().getLoginEmail());
    }

    public static Account getActiveAccountReadOnly(Context context)
    {
        return getAccount(context, AppController.getInstance(context).getActiveSessionReadOnly().getLoginEmail());
    }

    public static Session getActiveSession(Context context, boolean flag)
    {
        if (mActiveSession == null)
        {
            Account aaccount[] = AccountManager.get(context).getAccountsByType(ACCOUNT_TYPE);
            if (aaccount.length > 0)
            {
                String s = SettingsManager.getCurrentAccount(context);
                int j = aaccount.length;
                for (int i = 0; i < j; i++)
                {
                    Account account = aaccount[i];
                    if (s == null || account.name.equals(s))
                    {
                        Session session1 = getSession(context, account.name);
                        session1.setLoginEmail(account.name);
                        session1.setLoginStatus(Session.LoginStatus.LOGGED_IN);
                        if (!flag)
                        {
                            setActiveSession(context, session1);
                        }
                        mActiveSession = session1;
                        return session1;
                    }
                }

            }
            Session session = createSession();
            if (!flag)
            {
                setActiveSession(context, session);
            }
            mActiveSession = session;
        }
        return mActiveSession;
    }

    public static String getAvatarUrl(AccountManager accountmanager, Account account)
    {
        return accountmanager.getUserData(account, "account_user_avatar");
    }

    public static Session getCachedActiveSession()
    {
        return mActiveSession;
    }

    private static String getDeviceId(Context context)
    {
        context = (TelephonyManager)context.getSystemService("phone");
        if (context != null && context.getDeviceId() != null)
        {
            return context.getDeviceId();
        } else
        {
            return Build.SERIAL;
        }
    }

    private static byte[] getKeyDigest(String s)
        throws Exception
    {
        MessageDigest messagedigest = MessageDigest.getInstance("SHA-256");
        messagedigest.update(s.getBytes("UTF-8"));
        return messagedigest.digest();
    }

    public static int getLoginType(AccountManager accountmanager, Account account)
    {
        return Integer.parseInt(accountmanager.getUserData(account, "account_login_type"));
    }

    public static String getName(AccountManager accountmanager, Account account)
    {
        return accountmanager.getUserData(account, "account_user_name");
    }

    public static String getPassword(AccountManager accountmanager, Account account, Context context)
    {
        String s;
        String s1;
        s1 = accountmanager.getPassword(account);
        s = accountmanager.getUserData(account, "account_password_encrypted");
        if (s == null || !Boolean.parseBoolean(s)) goto _L2; else goto _L1
_L1:
        try
        {
            s = decrypt(getDeviceId(context), s1);
        }
        // Misplaced declaration of an exception variable
        catch (AccountManager accountmanager)
        {
            SLog.e("Error decrypting password.", accountmanager);
            CrashUtil.logException(accountmanager);
            return null;
        }
_L4:
        return s;
_L2:
        s = s1;
        if (s1 != null)
        {
            migratePassword(accountmanager, account, context);
            s = s1;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static Session getSession(Context context, String s)
    {
        if (s == null)
        {
            return createSession();
        }
        if (mActiveSession == null)
        {
            s = getAccount(context, s);
            if (s == null)
            {
                mActiveSession = createSession();
            } else
            {
                mActiveSession = createSession(context, s);
            }
        }
        return mActiveSession;
    }

    public static String getSessionKey(AccountManager accountmanager, Account account)
    {
        return accountmanager.peekAuthToken(account, "co.vine.android.basic_auth.token.secret");
    }

    public static String getTwitterSecret(AccountManager accountmanager, Account account)
    {
        return accountmanager.getUserData(account, "account_t_secret");
    }

    public static String getTwitterToken(AccountManager accountmanager, Account account)
    {
        return accountmanager.getUserData(account, "account_t_token");
    }

    public static String getTwitterUsername(AccountManager accountmanager, Account account)
    {
        return accountmanager.getUserData(account, "account_t_username");
    }

    public static long getUserId(AccountManager accountmanager, Account account)
    {
        accountmanager = accountmanager.getUserData(account, "account_user_info");
        if (accountmanager != null)
        {
            return Long.parseLong(accountmanager);
        } else
        {
            return 0L;
        }
    }

    public static boolean isLoggedIn(Context context, boolean flag)
    {
        return getActiveSession(context, flag).isLoggedIn();
    }

    public static co.vine.android.util.SystemUtil.PrefBooleanState isNormalVideoPlayable(Context context)
    {
        AccountManager accountmanager = AccountManager.get(context);
        if (accountmanager == null)
        {
            return co.vine.android.util.SystemUtil.PrefBooleanState.UNKNOWN;
        }
        Account account = getActiveAccount(context);
        context = null;
        if (account != null)
        {
            context = accountmanager.getUserData(account, "account_normal_video_playable");
        }
        if (context != null)
        {
            return co.vine.android.util.SystemUtil.PrefBooleanState.valueOf(context);
        } else
        {
            return co.vine.android.util.SystemUtil.PrefBooleanState.UNKNOWN;
        }
    }

    public static void migratePassword(AccountManager accountmanager, Account account, Context context)
    {
        if (accountmanager == null || account == null)
        {
            SLog.i("Skipping migrate password check due to null AccountManager or Account");
        } else
        {
            String s = accountmanager.getUserData(account, "account_password_encrypted");
            if (s == null || !Boolean.parseBoolean(s))
            {
                String s1 = accountmanager.getPassword(account);
                if (s1 != null)
                {
                    try
                    {
                        accountmanager.setPassword(account, encrypt(getDeviceId(context), s1));
                        accountmanager.setUserData(account, "account_password_encrypted", String.valueOf(true));
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (AccountManager accountmanager)
                    {
                        SLog.e("Error migrating password.", accountmanager);
                    }
                    CrashUtil.logException(accountmanager);
                    return;
                }
            }
        }
    }

    public static boolean needsAddwidget(AccountManager accountmanager, Account account)
    {
        return accountmanager.getUserData(account, "account_add_widget") == null;
    }

    public static AccountManagerFuture removeAccount(Context context, String s)
    {
        Object obj = null;
        AccountManager accountmanager = AccountManager.get(context);
        Account aaccount[] = accountmanager.getAccountsByType(ACCOUNT_TYPE);
        int j = aaccount.length;
        int i = 0;
        do
        {
label0:
            {
                context = obj;
                if (i < j)
                {
                    context = aaccount[i];
                    if (!((Account) (context)).name.equals(s))
                    {
                        break label0;
                    }
                    context = accountmanager.removeAccount(context, null, null);
                }
                return context;
            }
            i++;
        } while (true);
    }

    public static void removeTwitterInfo(Context context, String s)
    {
        s = getAccount(context, s);
        if (s != null)
        {
            context = AccountManager.get(context);
            context.setUserData(s, "account_t_token", null);
            context.setUserData(s, "account_t_secret", null);
            context.setUserData(s, "account_t_id", null);
            context.setUserData(s, "account_t_username", null);
            context.setUserData(s, "account_login_type", String.valueOf(1));
        }
    }

    public static void resetActiveSession()
    {
        mActiveSession = null;
    }

    public static void saveTwitterInfo(Context context, String s, String s1, String s2, String s3, long l)
    {
        s = getAccount(context, s);
        if (s != null)
        {
            context = AccountManager.get(context);
            context.setUserData(s, "account_t_token", s2);
            context.setUserData(s, "account_t_secret", s3);
            context.setUserData(s, "account_t_id", String.valueOf(l));
            context.setUserData(s, "account_t_username", s1);
            context.setUserData(s, "account_login_type", String.valueOf(2));
        }
    }

    public static void saveUserId(Context context, String s, long l)
    {
        s = getAccount(context, s);
        if (s != null)
        {
            context = AccountManager.get(context);
            if (l > 0L)
            {
                context.setUserData(s, "account_user_info", String.valueOf(l));
            }
        }
    }

    public static void setActiveSession(Context context, Session session)
    {
        SettingsManager.setCurrentAccount(context, session.getLoginEmail(), session.getName(), session.getUserId());
    }

    public static void setDidShowAddWidget(AccountManager accountmanager, Account account)
    {
        accountmanager.setUserData(account, "account_add_widget", "YES");
    }

    public static void setDidShowStoreContactsPrompt(AccountManager accountmanager, Account account)
    {
        if (accountmanager != null && account != null)
        {
            accountmanager.setUserData(account, "account_did_show_store_contacts", "YES");
        }
    }

    public static void setDidShowVmOnboard(AccountManager accountmanager, Account account)
    {
        accountmanager.setUserData(account, "account_did_show_vm_onboard", "YES");
    }

    public static void setSessionKey(AccountManager accountmanager, Account account, String s)
    {
        accountmanager.setAuthToken(account, "co.vine.android.basic_auth.token.secret", s);
    }

    public static boolean shouldShowStoreContactsPrompt(AccountManager accountmanager, Account account)
    {
        return accountmanager == null || account == null || accountmanager.getUserData(account, "account_did_show_store_contacts") == null;
    }

    public static boolean shouldShowVmOnboard(AccountManager accountmanager, Account account)
    {
        return accountmanager.getUserData(account, "account_did_show_vm_onboard") == null;
    }

    public static void syncNormalVideoPlayable(Context context)
    {
        Object obj;
label0:
        {
            obj = isNormalVideoPlayable(context);
            co.vine.android.util.SystemUtil.PrefBooleanState prefbooleanstate = SystemUtil.isNormalVideoPlayable(context);
            if (obj != prefbooleanstate)
            {
                if (prefbooleanstate == co.vine.android.util.SystemUtil.PrefBooleanState.UNKNOWN)
                {
                    break label0;
                }
                obj = AccountManager.get(context);
                context = getActiveAccount(context);
                if (obj != null && context != null)
                {
                    ((AccountManager) (obj)).setUserData(context, "account_normal_video_playable", prefbooleanstate.name());
                }
            }
            return;
        }
        boolean flag;
        if (obj == co.vine.android.util.SystemUtil.PrefBooleanState.TRUE)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        SystemUtil.setNormalVideoPlayable(context, flag);
    }

}
