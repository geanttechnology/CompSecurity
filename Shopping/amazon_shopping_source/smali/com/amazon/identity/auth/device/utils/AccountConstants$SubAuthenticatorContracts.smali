.class public final Lcom/amazon/identity/auth/device/utils/AccountConstants$SubAuthenticatorContracts;
.super Ljava/lang/Object;
.source "AccountConstants.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/utils/AccountConstants;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "SubAuthenticatorContracts"
.end annotation


# static fields
.field public static final DEREGISTER_SUB_AUTH_ERROR_GET_AUTH_TOKEN_CALLED:I = 0x69

.field public static final DMS_EXCHANGE_ERROR_AUTHENTICATION_FAILED:I = 0x67

.field public static final DMS_EXCHANGE_ERROR_CUSTOMER_NOT_FOUND:I = 0x64

.field public static final DMS_EXCHANGE_ERROR_DEVICE_ALREADY_REGISTERED:I = 0x65

.field public static final DMS_EXCHANGE_ERROR_DUPLICATE_DEVICE_NAME:I = 0x66

.field public static final DMS_EXCHANGE_ERROR_UNKNOWN_FAILURE:I = 0x68

.field public static final DMS_SUB_AUTHENTICATOR_XML_FILE_NAME:Ljava/lang/String; = "dms_sub_authenticator"

.field public static final KEY_DMS_ERROR_CODE:Ljava/lang/String; = "com.amazon.dcp.sso.dms.ErrorCode"

.field public static final KEY_DMS_ERROR_MESSAGE:Ljava/lang/String; = "com.amazon.dcp.sso.dms.ErrorMessage"

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


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 445
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 446
    return-void
.end method
