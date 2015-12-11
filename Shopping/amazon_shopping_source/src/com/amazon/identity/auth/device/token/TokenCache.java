// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.token;

import android.accounts.Account;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.amazon.identity.auth.device.framework.AccountTokenEncryptor;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.utils.AccountManagerWrapper;
import com.amazon.identity.auth.device.utils.KeyFactoryUtils;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.ThreadUtils;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TokenCache
{
    public static interface Listener
    {

        public abstract void failure(String s, int i, String s1);

        public abstract void failure(String s, Bundle bundle);

        public abstract void success();
    }

    private class TokenInfo
    {

        private String mDecryptedToken;
        private String mEncryptedToken;
        private PrivateKey mRSAPrivateKey;
        final TokenCache this$0;

        public String getDecryptedToken()
        {
            return mDecryptedToken;
        }

        public String getEncryptedToken()
        {
            return mEncryptedToken;
        }

        public PrivateKey getTokenAsRSAPrivateKey()
            throws InvalidKeySpecException
        {
            if (mRSAPrivateKey == null)
            {
                mRSAPrivateKey = parseRSAPrivateKey(mDecryptedToken);
            }
            return mRSAPrivateKey;
        }

        public TokenInfo(String s)
        {
            this(s, decryptToken(s));
        }

        public TokenInfo(String s, String s1)
        {
            this$0 = TokenCache.this;
            super();
            mEncryptedToken = s;
            mDecryptedToken = s1;
        }
    }


    public static final String TAG = com/amazon/identity/auth/device/token/TokenCache.getName();
    private static ExecutorService sThreadQueue = Executors.newSingleThreadExecutor(ThreadUtils.getNamedThreadFactory("MAP-TokenCacheThread"));
    private Account mAccount;
    private AccountManagerWrapper mAccountManager;
    private Context mContext;
    private AccountTokenEncryptor mEncryptor;
    private String mPackageName;
    private HashMap mTokens;

    protected TokenCache()
    {
    }

    TokenCache(Account account)
    {
        mAccount = account;
        mPackageName = "test";
        mTokens = new HashMap();
    }

    public TokenCache(Context context, Account account)
    {
        if (context == null || account == null)
        {
            throw new IllegalArgumentException("One or more arguments are null");
        } else
        {
            mContext = ServiceWrappingContext.create(context);
            mPackageName = mContext.getPackageName();
            context = TAG;
            (new StringBuilder()).append(mPackageName).append(" created a new Token Cache").toString();
            mAccountManager = (AccountManagerWrapper)mContext.getSystemService("dcp_account_manager");
            mAccount = account;
            mEncryptor = new AccountTokenEncryptor(mContext, account);
            mTokens = new HashMap();
            return;
        }
    }

    private TokenInfo cacheToken(String s, String s1)
    {
        s1 = new TokenInfo(s1);
        mTokens.put(s, s1);
        return s1;
    }

    private String tryRetrievingTokenFromAccountManager(String s)
    {
        if (s == null)
        {
            return null;
        }
        if (s.startsWith("com.amazon.dcp.sso.property.account.extratokens"))
        {
            return getUserdata(mAccount, s);
        } else
        {
            return peekAuthToken(mAccount, s);
        }
    }

    private TokenInfo updateTokenCache(String s, String s1)
    {
        HashMap hashmap = mTokens;
        hashmap;
        JVM INSTR monitorenter ;
        if (s1 != null)
        {
            break MISSING_BLOCK_LABEL_24;
        }
        mTokens.remove(s);
        hashmap;
        JVM INSTR monitorexit ;
        return null;
        if (mTokens.containsKey(s))
        {
            break MISSING_BLOCK_LABEL_51;
        }
        s = cacheToken(s, s1);
        hashmap;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
        TokenInfo tokeninfo;
        tokeninfo = (TokenInfo)mTokens.get(s);
        if (s1.equals(tokeninfo.getEncryptedToken()))
        {
            break MISSING_BLOCK_LABEL_87;
        }
        s = cacheToken(s, s1);
        return s;
        hashmap;
        JVM INSTR monitorexit ;
        return tokeninfo;
    }

    public String blockingFetchToken(String s)
        throws OperationCanceledException, AuthenticatorException, IOException
    {
        MAPLog.i(TAG, (new StringBuilder()).append(mPackageName).append(": blockingFetchToken: ").append(s).toString());
        Bundle bundle = (Bundle)fetchToken(mAccount, s, null).getResult();
        if (bundle != null)
        {
            if ((s = updateTokenCache(s, bundle.getString("authtoken"))) != null)
            {
                return s.getDecryptedToken();
            }
        }
        return null;
    }

    protected String decryptToken(String s)
    {
        return mEncryptor.decryptToken(s);
    }

    protected String encryptToken(String s)
    {
        return mEncryptor.encryptToken(s);
    }

    protected AccountManagerFuture fetchToken(Account account, String s, final AccountManagerCallback callback)
    {
        account = null;
        if (callback != null)
        {
            account = new AccountManagerCallback() {

                final TokenCache this$0;
                final AccountManagerCallback val$callback;

                public void run(AccountManagerFuture accountmanagerfuture)
                {
                    TokenCache.sThreadQueue.execute(accountmanagerfuture. new Runnable() {

                        final _cls2 this$1;
                        final AccountManagerFuture val$future;

                        public void run()
                        {
                            callback.run(future);
                        }

            
            {
                this$1 = final__pcls2;
                future = AccountManagerFuture.this;
                super();
            }
                    });
                }

            
            {
                this$0 = TokenCache.this;
                callback = accountmanagercallback;
                super();
            }
            };
        }
        return mAccountManager.getAuthToken(mAccount, s, null, null, account, null);
    }

    public void fetchTokens(String as[], final Listener listener)
    {
        if (as == null || listener == null)
        {
            throw new IllegalArgumentException("One or more arguments are null");
        }
        MAPLog.i(TAG, (new StringBuilder()).append(mPackageName).append(": fetchTokens: ").append(TextUtils.join(",", as)).toString());
        if (as.length == 0)
        {
            listener.success();
            return;
        } else
        {
            final Stack tokenTypeStack = new Stack();
            tokenTypeStack.addAll(Arrays.asList(as));
            as = new AccountManagerCallback() {

                final TokenCache this$0;
                final Listener val$listener;
                final Stack val$tokenTypeStack;

                public void run(AccountManagerFuture accountmanagerfuture)
                {
                    String s = (String)tokenTypeStack.peek();
                    Bundle bundle;
                    bundle = (Bundle)accountmanagerfuture.getResult();
                    if (!bundle.containsKey("authtoken"))
                    {
                        listener.failure(s, bundle);
                        return;
                    }
                    synchronized (mTokens)
                    {
                        cacheToken(s, bundle.getString("authtoken"));
                    }
                    try
                    {
                        if (!pop(mAccount, tokenTypeStack, this))
                        {
                            listener.success();
                            return;
                        }
                    }
                    // Misplaced declaration of an exception variable
                    catch (AccountManagerFuture accountmanagerfuture)
                    {
                        listener.failure(s, 4, accountmanagerfuture.getMessage());
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (AccountManagerFuture accountmanagerfuture)
                    {
                        listener.failure(s, 5, accountmanagerfuture.getMessage());
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (AccountManagerFuture accountmanagerfuture)
                    {
                        accountmanagerfuture = accountmanagerfuture.getMessage();
                        KeyFactoryUtils.recordDMSCredentialErrorAndCallDeregisterIfNecessary(mContext, accountmanagerfuture);
                        listener.failure(s, 3, accountmanagerfuture);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (AccountManagerFuture accountmanagerfuture)
                    {
                        listener.failure(s, 7, accountmanagerfuture.getMessage());
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (AccountManagerFuture accountmanagerfuture)
                    {
                        MAPLog.e(TokenCache.TAG, "Generic error while fetching Tokens", accountmanagerfuture);
                        listener.failure(s, 1, accountmanagerfuture.getMessage());
                    }
                    break MISSING_BLOCK_LABEL_213;
                    exception;
                    accountmanagerfuture;
                    JVM INSTR monitorexit ;
                    throw exception;
                }

            
            {
                this$0 = TokenCache.this;
                tokenTypeStack = stack;
                listener = listener1;
                super();
            }
            };
            fetchToken(mAccount, (String)tokenTypeStack.peek(), as);
            return;
        }
    }

    public String getToken(String s)
    {
        HashMap hashmap = mTokens;
        hashmap;
        JVM INSTR monitorenter ;
        s = updateTokenCache(s, tryRetrievingTokenFromAccountManager(s));
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        s = s.getDecryptedToken();
_L1:
        hashmap;
        JVM INSTR monitorexit ;
        return s;
        s = null;
          goto _L1
        s;
        throw s;
    }

    public PrivateKey getTokenAsRSAPrivateKey(String s)
        throws InvalidKeySpecException
    {
        HashMap hashmap = mTokens;
        hashmap;
        JVM INSTR monitorenter ;
        s = updateTokenCache(s, tryRetrievingTokenFromAccountManager(s));
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        s = s.getTokenAsRSAPrivateKey();
_L1:
        hashmap;
        JVM INSTR monitorexit ;
        return s;
        s = null;
          goto _L1
        s;
        throw s;
    }

    protected String getUserdata(Account account, String s)
    {
        return mAccountManager.getUserData(account, s);
    }

    public void invalidateAuthToken(String s)
    {
        MAPLog.i(TAG, (new StringBuilder()).append(mPackageName).append(": invalidateAuthToken").toString());
        s = encryptToken(s);
        invalidateAuthTokenInAccountManager(mAccount, s);
    }

    public void invalidateAuthTokenByType(String s)
    {
        MAPLog.i(TAG, (new StringBuilder()).append(mPackageName).append(": invalidateAuthTokenByType: ").append(s).toString());
        s = tryRetrievingTokenFromAccountManager(s);
        invalidateAuthTokenInAccountManager(mAccount, s);
    }

    protected void invalidateAuthTokenInAccountManager(Account account, String s)
    {
        mAccountManager.invalidateAuthToken(account.type, s);
    }

    public PrivateKey parseRSAPrivateKey(String s)
        throws InvalidKeySpecException
    {
        s = new PKCS8EncodedKeySpec(Base64.decode(s, 0));
        KeyFactory keyfactory = KeyFactoryUtils.getKeyFactoryForAlgorithm("RSA");
        if (keyfactory == null)
        {
            throw new UnsupportedOperationException("Could not generate KeyFactory.");
        } else
        {
            return keyfactory.generatePrivate(s);
        }
    }

    protected String peekAuthToken(Account account, String s)
    {
        return mAccountManager.peekAuthToken(account, s);
    }

    public void setAuthToken(String s, String s1)
    {
        MAPLog.i(TAG, (new StringBuilder()).append(mPackageName).append(": setAuthToken: ").append(s).toString());
        synchronized (mTokens)
        {
            String s2 = encryptToken(s1);
            s1 = new TokenInfo(s2, s1);
            mTokens.put(s, s1);
            setAuthTokenInAccountManager(mAccount, s, s2);
        }
    }

    protected void setAuthTokenInAccountManager(Account account, String s, String s1)
    {
        mAccountManager.setAuthToken(account, s, s1);
    }






/*
    static boolean access$300(TokenCache tokencache, Account account, Stack stack, AccountManagerCallback accountmanagercallback)
    {
        stack.pop();
        if (stack.size() == 0)
        {
            return false;
        } else
        {
            tokencache.fetchToken(tokencache.mAccount, (String)stack.peek(), accountmanagercallback);
            return true;
        }
    }

*/


}
