// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.authentication;

import android.content.Context;
import android.os.Bundle;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.api.MAPAccountManager;
import com.amazon.identity.auth.device.api.TokenKeys;
import com.amazon.identity.auth.device.api.TokenManagement;

public class BlockingTokenAccessor
{
    public class AuthErrorException extends NonRetryableIdentityException
    {

        private Bundle mBundle;
        final BlockingTokenAccessor this$0;

        public AuthErrorException(Bundle bundle)
        {
            this$0 = BlockingTokenAccessor.this;
            super();
            mBundle = bundle;
        }
    }

    public class BlockingMAPAccountManagerListener
        implements Callback
    {

        private ErrorType mErrorType;
        private boolean mResultDelivered;
        private Bundle mResults;
        final BlockingTokenAccessor this$0;

        private void notifyResultDelivered()
        {
            this;
            JVM INSTR monitorenter ;
            mResultDelivered = true;
            notify();
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            this;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public String getResult()
            throws IdentityException, InterruptedException
        {
_L2:
            if (mResultDelivered)
            {
                break MISSING_BLOCK_LABEL_42;
            }
            this;
            JVM INSTR monitorenter ;
            wait(10000L);
            this;
            JVM INSTR monitorexit ;
            if (mResultDelivered) goto _L2; else goto _L1
_L1:
            throw new RetryableIdentityException();
            Exception exception;
            exception;
            this;
            JVM INSTR monitorexit ;
            throw exception;
            String s = mResults.getString("value_key");
            static class _cls1
            {

                static final int $SwitchMap$com$amazon$gallery$thor$app$authentication$BlockingTokenAccessor$ErrorType[];
                static final int $SwitchMap$com$amazon$identity$auth$device$api$MAPAccountManager$RegistrationError[];

                static 
                {
                    $SwitchMap$com$amazon$identity$auth$device$api$MAPAccountManager$RegistrationError = new int[com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.values().length];
                    try
                    {
                        $SwitchMap$com$amazon$identity$auth$device$api$MAPAccountManager$RegistrationError[com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.NETWORK_FAILURE.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    $SwitchMap$com$amazon$gallery$thor$app$authentication$BlockingTokenAccessor$ErrorType = new int[ErrorType.values().length];
                    try
                    {
                        $SwitchMap$com$amazon$gallery$thor$app$authentication$BlockingTokenAccessor$ErrorType[ErrorType.AUTH_ERROR.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            switch (_cls1..SwitchMap.com.amazon.gallery.thor.app.authentication.BlockingTokenAccessor.ErrorType[mErrorType.ordinal()])
            {
            default:
                if (s == null || s.isEmpty())
                {
                    throw new AuthErrorException(mResults);
                } else
                {
                    return s;
                }

            case 1: // '\001'
                break;
            }
            if (isNetworkError(mResults))
            {
                throw new IdentityNetworkError();
            } else
            {
                throw new AuthErrorException(mResults);
            }
        }

        public void onError(Bundle bundle)
        {
            mErrorType = ErrorType.AUTH_ERROR;
            mResults = bundle;
            notifyResultDelivered();
        }

        public void onSuccess(Bundle bundle)
        {
            mResults = bundle;
            notifyResultDelivered();
        }

        public BlockingMAPAccountManagerListener()
        {
            this$0 = BlockingTokenAccessor.this;
            super();
            mErrorType = ErrorType.NONE;
        }
    }

    public static final class ErrorType extends Enum
    {

        private static final ErrorType $VALUES[];
        public static final ErrorType AUTH_ERROR;
        public static final ErrorType NONE;

        public static ErrorType valueOf(String s)
        {
            return (ErrorType)Enum.valueOf(com/amazon/gallery/thor/app/authentication/BlockingTokenAccessor$ErrorType, s);
        }

        public static ErrorType[] values()
        {
            return (ErrorType[])$VALUES.clone();
        }

        static 
        {
            AUTH_ERROR = new ErrorType("AUTH_ERROR", 0);
            NONE = new ErrorType("NONE", 1);
            $VALUES = (new ErrorType[] {
                AUTH_ERROR, NONE
            });
        }

        private ErrorType(String s, int i)
        {
            super(s, i);
        }
    }

    public class IdentityException extends Exception
    {

        final BlockingTokenAccessor this$0;

        public IdentityException()
        {
            this$0 = BlockingTokenAccessor.this;
            super();
        }
    }

    public class IdentityNetworkError extends RetryableIdentityException
    {

        final BlockingTokenAccessor this$0;

        public IdentityNetworkError()
        {
            this$0 = BlockingTokenAccessor.this;
            super();
        }
    }

    public class NonRetryableIdentityException extends IdentityException
    {

        final BlockingTokenAccessor this$0;

        public NonRetryableIdentityException()
        {
            this$0 = BlockingTokenAccessor.this;
            super();
        }
    }

    public class RetryableIdentityException extends IdentityException
    {

        final BlockingTokenAccessor this$0;

        public RetryableIdentityException()
        {
            this$0 = BlockingTokenAccessor.this;
            super();
        }
    }


    private final Context mContext;
    private final MAPAccountManager mMAPAccountManager;

    public BlockingTokenAccessor(Context context)
    {
        mContext = context;
        mMAPAccountManager = new MAPAccountManager(context);
    }

    private boolean isNetworkError(Bundle bundle)
    {
        bundle = com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.fromValue(bundle.getInt("com.amazon.dcp.sso.ErrorCode"));
        switch (_cls1..SwitchMap.com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError[bundle.ordinal()])
        {
        default:
            return false;

        case 1: // '\001'
            return true;
        }
    }

    public String getAccessToken()
        throws IdentityException, InterruptedException
    {
        com/amazon/gallery/thor/app/authentication/BlockingTokenAccessor;
        JVM INSTR monitorenter ;
        String s = mMAPAccountManager.getAccount();
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_20;
        }
        com/amazon/gallery/thor/app/authentication/BlockingTokenAccessor;
        JVM INSTR monitorexit ;
        return null;
        TokenManagement tokenmanagement = new TokenManagement(mContext);
        String s1 = TokenKeys.getAccessTokenKeyForPackage(mContext.getPackageName());
        BlockingMAPAccountManagerListener blockingmapaccountmanagerlistener = new BlockingMAPAccountManagerListener();
        tokenmanagement.getToken(s, s1, null, blockingmapaccountmanagerlistener);
        s = blockingmapaccountmanagerlistener.getResult();
        com/amazon/gallery/thor/app/authentication/BlockingTokenAccessor;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        com/amazon/gallery/thor/app/authentication/BlockingTokenAccessor;
        JVM INSTR monitorexit ;
        throw exception;
    }

}
