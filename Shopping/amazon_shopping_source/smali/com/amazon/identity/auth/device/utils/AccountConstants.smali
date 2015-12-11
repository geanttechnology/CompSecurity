.class public final Lcom/amazon/identity/auth/device/utils/AccountConstants;
.super Ljava/lang/Object;
.source "AccountConstants.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/device/utils/AccountConstants$CustomerAttributes;,
        Lcom/amazon/identity/auth/device/utils/AccountConstants$CorpusSigningConstants;,
        Lcom/amazon/identity/auth/device/utils/AccountConstants$AddAccountOptions;,
        Lcom/amazon/identity/auth/device/utils/AccountConstants$AmazonAccountInformation;,
        Lcom/amazon/identity/auth/device/utils/AccountConstants$SubAuthenticatorContracts;,
        Lcom/amazon/identity/auth/device/utils/AccountConstants$ConfirmCredentials;,
        Lcom/amazon/identity/auth/device/utils/AccountConstants$ExternalBroadcastsIntentActions;,
        Lcom/amazon/identity/auth/device/utils/AccountConstants$PublicUserData;,
        Lcom/amazon/identity/auth/device/utils/AccountConstants$PublicTokens;,
        Lcom/amazon/identity/auth/device/utils/AccountConstants$DeviceRenameError;
    }
.end annotation


# static fields
.field public static final ACCOUNT_USERDATA_KEY_PREFIX:Ljava/lang/String; = "com.amazon.dcp.sso.property.account"

.field public static final ACTION_ACCOUNT_ADD_INTENT:Ljava/lang/String; = "com.amazon.dcp.sso.AddAccount"

.field public static final ACTION_AMAZON_ACCOUNT_ADDED_INTENT:Ljava/lang/String; = "com.amazon.dcp.sso.action.account.added"

.field public static final ACTION_AMAZON_ACCOUNT_ADDED_ON_DEVICE_INTENT:Ljava/lang/String; = "com.amazon.identity.auth.account.added.on.device"

.field public static final ACTION_AMAZON_ACCOUNT_PROPERTY_CHANGED_INTENT:Ljava/lang/String; = "com.amazon.dcp.sso.action.AmazonAccountPropertyService.property.changed"

.field public static final ACTION_AMAZON_ACCOUNT_PROPERTY_INTENT:Ljava/lang/String; = "com.amazon.dcp.sso.action.AmazonAccountPropertyService"

.field public static final ACTION_AMAZON_ACCOUNT_REMOVED_INTENT:Ljava/lang/String; = "com.amazon.dcp.sso.action.account.removed"

.field public static final ACTION_AMAZON_ACCOUNT_REMOVED_ON_DEVICE_INTENT:Ljava/lang/String; = "com.amazon.identity.auth.account.removed.on.device"

.field public static final ACTION_AMAZON_CALL_ACCOUNT_REGISTRAR:Ljava/lang/String; = "com.amazon.dcp.sso.action.AmazonAccountRegistrar"

.field public static final ACTION_AMAZON_SECONDARY_ACCOUNT_ADDED_INTENT:Ljava/lang/String; = "com.amazon.dcp.sso.action.secondary.account.added"

.field public static final ACTION_AMAZON_SECONDARY_ACCOUNT_REMOVED_INTENT:Ljava/lang/String; = "com.amazon.dcp.sso.action.secondary.account.removed"

.field public static final ACTION_AMAZON_SSO_INFORMATION:Ljava/lang/String; = "com.amazon.dcp.sso.action.SSO_POST_SPLIT_INFORMATION"

.field public static final ACTION_CONFIRM_CREDENTIAL_INTENT:Ljava/lang/String; = "com.amazon.dcp.sso.ConfirmCredential"

.field public static final ACTION_SUB_AUTHENTICATOR_INTENT:Ljava/lang/String; = "com.amazon.dcp.sso.AccountSubAuthenticator"

.field public static final ADD_ACCOUNT_FROM_UPDATE_CREDENTIALS:Ljava/lang/String; = "com.amazon.dcp.sso.RegisterViaUpdateCreds"

.field public static final ADD_ACCOUNT_PARAMETERS:Ljava/lang/String; = "com.amazon.dcp.sso.addAccountParameters"

.field public static final ADD_ACCOUNT_USING_DEVICE_SECRET:Ljava/lang/String; = "com.amazon.dcp.sso.AddAccountUsingDeviceSecret"

.field public static final AMAZON_ACCOUNT_TYPE:Ljava/lang/String; = "com.amazon.account"

.field public static final AP_OPTION_KEY_ASSOC_HANDLE:Ljava/lang/String; = "com.amazon.dcp.sso.ap.assoc_handle"

.field public static final AP_OPTION_KEY_PAGEID:Ljava/lang/String; = "com.amazon.dcp.sso.ap.pageid"

.field public static final AP_OPTION_KEY_PREFIX:Ljava/lang/String; = "com.amazon.dcp.sso.ap"

.field public static final AP_OPTION_KEY_SESSIONID:Ljava/lang/String; = "com.amazon.dcp.sso.ap.sessionid"

.field public static final AP_OPTION_KEY_UBID:Ljava/lang/String; = "com.amazon.dcp.sso.ap.ubid"

.field public static final COOKIE_TOKEN_TYPE_PREFIX:Ljava/lang/String; = "com.amazon.dcp.sso.token.cookie"

.field public static final DEREGISTER_SUB_AUTH_ERROR_GET_AUTH_TOKEN_CALLED:I = 0x69

.field public static final DEVICE_TOKEN_TYPE_PREFIX:Ljava/lang/String; = "com.amazon.dcp.sso.token.device"

.field public static final DEVICE_USERDATA_KEY_PREFIX:Ljava/lang/String; = "com.amazon.dcp.sso.property.device"

.field public static final DMS_EXCHANGE_ERROR_AUTHENTICATION_FAILED:I = 0x67

.field public static final DMS_EXCHANGE_ERROR_CUSTOMER_NOT_FOUND:I = 0x64

.field public static final DMS_EXCHANGE_ERROR_DEVICE_ALREADY_REGISTERED:I = 0x65

.field public static final DMS_EXCHANGE_ERROR_DUPLICATE_DEVICE_NAME:I = 0x66

.field public static final DMS_EXCHANGE_ERROR_UNKNOWN_FAILURE:I = 0x68

.field public static final DMS_SUB_AUTHENTICATOR_XML_FILE_NAME:Ljava/lang/String; = "dms_sub_authenticator"

.field public static final EXTRA_AMAZON_ACCOUNT_CHANGED_NAME:Ljava/lang/String; = "com.amazon.dcp.sso.extra.account.name"

.field public static final EXTRA_AMAZON_ACCOUNT_CHANGED_TYPE:Ljava/lang/String; = "com.amazon.dcp.sso.extra.account.type"

.field public static final EXTRA_TOKENS_KEY_PREFIX:Ljava/lang/String; = "com.amazon.dcp.sso.property.account.extratokens"

.field public static final INTENT_ACTION_GET_DEVICE_CREDENTIALS:Ljava/lang/String; = "com.amazon.dcp.sso.action.GET_DEVICE_CREDENTIALS"

.field public static final INTENT_ACTION_SESSION_USER_ADD_SERVICE:Ljava/lang/String; = "com.amazon.dcp.sso.action.central.session.user.add"

.field public static final INTENT_ACTION_SESSION_USER_CHANGE_SERVICE:Ljava/lang/String; = "com.amazon.dcp.sso.action.central.session.user.change"

.field public static final INTENT_ACTION_SESSION_USER_REMOVE_SERVICE:Ljava/lang/String; = "com.amazon.dcp.sso.action.central.session.user.remove"

.field public static final INTENT_ACTION_SET_COR_PFM:Ljava/lang/String; = "com.amazon.dcp.sso.action.SET_COR_PFM"

.field public static final INTENT_EXTRA_SESSION_USER_ACCOUNTS:Ljava/lang/String; = "new.session.user.accounts"

.field public static final INTENT_EXTRA_SESSION_USER_ACCOUNTS_OLD:Ljava/lang/String; = "session.user.accounts"

.field public static final KEY_ACCOUNT_IDENTIFIER:Ljava/lang/String; = "com.amazon.dcp.sso.property.account.acctId"

.field public static final KEY_ACCOUNT_STATUS:Ljava/lang/String; = "com.amazon.dcp.sso.property.account.ACCOUNT_STATUS"

.field public static final KEY_ACCOUNT_UUID:Ljava/lang/String; = "com.amazon.dcp.sso.property.account.UUID"

.field public static final KEY_ADD_ACCOUNT_ACCESS_TOKEN:Ljava/lang/String; = "com.amazon.dcp.sso.AddAccount.options.AccessToken"

.field public static final KEY_ADD_ACCOUNT_ATMAIN:Ljava/lang/String; = "com.amazon.dcp.sso.AddAccount.options.ATMain"

.field public static final KEY_ADD_ACCOUNT_AUTHTOKENTYPE:Ljava/lang/String; = "com.amazon.dcp.sso.addAccountParameters.authTokenType"

.field public static final KEY_ADD_ACCOUNT_AUTH_TOKEN:Ljava/lang/String; = "com.amazon.dcp.sso.AddAccount.options.AuthToken"

.field public static final KEY_ADD_ACCOUNT_AUTH_TOKEN_CONTEXT:Ljava/lang/String; = "com.amazon.dcp.sso.AddAccount.options.AuthTokenClientContext"

.field public static final KEY_ADD_ACCOUNT_CALLER_INFORMATION:Ljava/lang/String; = "com.amazon.dcp.sso.addAccountParameters.caller"

.field public static final KEY_ADD_ACCOUNT_OPTIONS:Ljava/lang/String; = "com.amazon.dcp.sso.addAccountParameters.options"

.field public static final KEY_ADD_ACCOUNT_REQUIREDFEATURES:Ljava/lang/String; = "com.amazon.dcp.sso.addAccountParameters.requiredFeatures"

.field public static final KEY_ADD_ACCOUNT_URL:Ljava/lang/String; = "com.amazon.dcp.sso.AddAccount.options.URL"

.field public static final KEY_ADD_AS_SECONDARY_ACCOUNT:Ljava/lang/String; = "com.amazon.dcp.sso.AddAccount.options.AddAsSecondary"

.field public static final KEY_COR:Ljava/lang/String; = "com.amazon.dcp.sso.property.account.cor"

.field public static final KEY_COR_PFM_ACCOUNT:Ljava/lang/String; = "cor.pfm.account"

.field public static final KEY_COR_PFM_DIRECTED_ID:Ljava/lang/String; = "cor.pfm.directedid"

.field public static final KEY_COR_SOURCE:Ljava/lang/String; = "com.amazon.dcp.sso.property.account.sourceofcor"

.field public static final KEY_CUSTOMER_REGION:Ljava/lang/String; = "com.amazon.dcp.sso.property.account.customer_region"

.field public static final KEY_DELEGATEE_ACCOUNT:Ljava/lang/String; = "com.amazon.dcp.sso.property.account.delegateeaccount"

.field public static final KEY_DELEGATION_DOMAIN:Ljava/lang/String; = "com.amazon.dcp.sso.property.account.delegationDomain"

.field public static final KEY_DEVICE_CREDENTIALS:Ljava/lang/String; = "com.amazon.dcp.sso.token.device.credentialsmap"

.field public static final KEY_DEVICE_DEVICE_EMAIL:Ljava/lang/String; = "com.amazon.dcp.sso.property.deviceemail"

.field public static final KEY_DEVICE_DEVICE_NAME:Ljava/lang/String; = "com.amazon.dcp.sso.property.devicename"

.field public static final KEY_DEVICE_USER_NAME:Ljava/lang/String; = "com.amazon.dcp.sso.property.username"

.field public static final KEY_DMS_ERROR_CODE:Ljava/lang/String; = "com.amazon.dcp.sso.dms.ErrorCode"

.field public static final KEY_DMS_ERROR_MESSAGE:Ljava/lang/String; = "com.amazon.dcp.sso.dms.ErrorMessage"

.field public static final KEY_PFM:Ljava/lang/String; = "com.amazon.dcp.sso.property.account.pfm"

.field public static final KEY_REGISTRATION_TYPE:Ljava/lang/String; = "registration_type"

.field public static final KEY_SECONDARY_AMAZON_ACCOUNT:Ljava/lang/String; = "com.amazon.dcp.sso.property.secondary"

.field public static final KEY_SESSION_USER_AMAZON_ACCOUNT:Ljava/lang/String; = "com.amazon.dcp.sso.property.sessionuser"

.field public static final KEY_TOKEN_ENCRYPT_KEY:Ljava/lang/String; = "com.amazon.dcp.sso.property.encryptKey"

.field public static final KEY_USER_EMAIL:Ljava/lang/String; = "com.amazon.dcp.sso.property.account.useremail"

.field public static final KEY_WEBSITE_COOKIES_JSON_ARRAY:Ljava/lang/String; = "website_cookies_json_array"

.field public static final PERMISSION_AMAZON_ACCOUNT_CHANGED:Ljava/lang/String; = "com.amazon.dcp.sso.permission.account.changed"

.field public static final PERMISSION_AMAZON_ACCOUNT_PROPERTY_CHANGED:Ljava/lang/String; = "com.amazon.dcp.sso.permission.AmazonAccountPropertyService.property.changed"

.field public static final PERMISSION_AMAZON_MULTIPLE_PROFILE_AWARE:Ljava/lang/String; = "com.amazon.identity.permission.MULTIPLE_PROFILE_AWARE"

.field public static final PERMISSION_APPLICATION_ACCOUNT_FOR_APPLICATION_CHANGED:Ljava/lang/String; = "com.amazon.dcp.sso.permission.applicationforaccount.changed"

.field public static final PERMISSION_MANAGE_COR_PFM:Ljava/lang/String; = "com.amazon.dcp.sso.permission.MANAGE_COR_PFM"

.field public static final SUB_AUTHENTICATOR_ACCOUNT_TYPE_ATTRIBUTE:Ljava/lang/String; = "accountType"

.field public static final SUB_AUTHENTICATOR_ATTRIBUTES_NAME:Ljava/lang/String; = "account-sub-authenticator"

.field public static final SUB_AUTHENTICATOR_DEVICE_TYPE_NAME:Ljava/lang/String; = "device-type"

.field public static final SUB_AUTHENTICATOR_DEVICE_TYPE_NAME_ATTRIBUTE:Ljava/lang/String; = "name"

.field public static final SUB_AUTHENTICATOR_METADATA_NAME:Ljava/lang/String; = "com.amazon.dcp.sso.AccountSubAuthenticator"

.field public static final SUB_AUTHENTICATOR_MULTIPLE_ACCOUNT_AWARE:Ljava/lang/String; = "multiple-account-aware"

.field public static final SUB_AUTHENTICATOR_SUB_AUTH_NAME:Ljava/lang/String; = "subAuth"

.field public static final SUB_AUTHENTICATOR_SUB_AUTH_NAME_ATTRIBUTE:Ljava/lang/String; = "name"

.field public static final SUB_AUTHENTICATOR_TOKEN_TYPES_NAME:Ljava/lang/String; = "token-types"

.field public static final SUB_AUTHENTICATOR_TOKEN_TYPE_NAME:Ljava/lang/String; = "token-type"

.field public static final SUB_AUTHENTICATOR_TOKEN_TYPE_NAME_ATTRIBUTE:Ljava/lang/String; = "name"

.field public static final SUB_AUTHENTICATOR_TYPE_ATTRIBUTE:Ljava/lang/String; = "type"

.field public static final TOKEN_TYPE_ACCOUNT_POOL:Ljava/lang/String; = "com.amazon.dcp.sso.token.device.accountpool"

.field public static final TOKEN_TYPE_AMAZON_COM_COOKIES_TOKEN:Ljava/lang/String; = "com.amazon.dcp.sso.token.cookie.amazonComCookies"

.field public static final TOKEN_TYPE_COOKIES:Ljava/lang/String; = "com.amazon.dcp.sso.token.amazon.cookies"

.field public static final TOKEN_TYPE_COOKIE_ATMAIN_TOKEN:Ljava/lang/String; = "com.amazon.dcp.sso.token.cookie.atmain"

.field public static final TOKEN_TYPE_COOKIE_MFA_SID_TOKEN:Ljava/lang/String; = "com.amazon.dcp.sso.token.cookie.sid"

.field public static final TOKEN_TYPE_COOKIE_XFSN:Ljava/lang/String; = "com.amazon.identity.cookies.xfsn"

.field public static final TOKEN_TYPE_COOKIE_XMAIN_TOKEN:Ljava/lang/String; = "com.amazon.dcp.sso.token.cookie.xmain"

.field public static final TOKEN_TYPE_DEVICE_ADP_TOKEN:Ljava/lang/String; = "com.amazon.dcp.sso.token.device.adptoken"

.field public static final TOKEN_TYPE_DEVICE_AMAZON_OAUTH_ACCESS_TOKEN:Ljava/lang/String; = "com.amazon.dcp.sso.token.oauth.amazon.access_token"

.field public static final TOKEN_TYPE_DEVICE_AMAZON_OAUTH_ACCESS_TOKEN_EXPIRES_AT:Ljava/lang/String; = "com.amazon.dcp.sso.token.oauth.amazon.access_token.expires_at"

.field public static final TOKEN_TYPE_DEVICE_AMAZON_OAUTH_ACCESS_TOKEN_REFRESHED_AT:Ljava/lang/String; = "com.amazon.dcp.sso.token.oauth.amazon.access_token.refreshed_at"

.field public static final TOKEN_TYPE_DEVICE_AMAZON_OAUTH_REFRESH_TOKEN:Ljava/lang/String; = "com.amazon.dcp.sso.token.oauth.amazon.refresh_token"

.field public static final TOKEN_TYPE_DEVICE_NAME:Ljava/lang/String; = "com.amazon.dcp.sso.token.device.devicename"

.field public static final TOKEN_TYPE_DEVICE_PRIVATE_KEY:Ljava/lang/String; = "com.amazon.dcp.sso.token.device.privatekey"

.field public static final TOKEN_TYPE_DEVICE_SERIAL_NUMBER:Ljava/lang/String; = "com.amazon.dcp.sso.token.device.deviceserialname"

.field public static final TOKEN_TYPE_DEVICE_TYPE:Ljava/lang/String; = "com.amazon.dcp.sso.token.devicedevicetype"

.field public static final TOKEN_TYPE_PREFIX:Ljava/lang/String; = "com.amazon.dcp.sso.token"

.field public static final TOKEN_TYPE_XMAIN_AND_XACB_COOKIES_TOKEN:Ljava/lang/String; = "com.amazon.dcp.sso.token.cookie.xmainAndXabcCookies"

.field public static final USERDATA_KEY_PREFIX:Ljava/lang/String; = "com.amazon.dcp.sso.property"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 818
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 819
    return-void
.end method
