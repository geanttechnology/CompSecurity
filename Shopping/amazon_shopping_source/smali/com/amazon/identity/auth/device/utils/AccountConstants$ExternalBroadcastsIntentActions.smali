.class public final Lcom/amazon/identity/auth/device/utils/AccountConstants$ExternalBroadcastsIntentActions;
.super Ljava/lang/Object;
.source "AccountConstants.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/utils/AccountConstants;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "ExternalBroadcastsIntentActions"
.end annotation


# static fields
.field public static final ACTION_ACCOUNT_ADD_INTENT:Ljava/lang/String; = "com.amazon.dcp.sso.AddAccount"

.field public static final ACTION_ACCOUNT_FOR_APPLICATION_CHANGED_PREFIX:Ljava/lang/String; = "com.amazon.dcp.sso.broadcast.applicationforaccount.changed."

.field public static final ACTION_AMAZON_ACCOUNT_ADDED_INTENT:Ljava/lang/String; = "com.amazon.dcp.sso.action.account.added"

.field public static final ACTION_AMAZON_ACCOUNT_PROPERTY_CHANGED_INTENT:Ljava/lang/String; = "com.amazon.dcp.sso.action.AmazonAccountPropertyService.property.changed"

.field public static final ACTION_AMAZON_ACCOUNT_PROPERTY_INTENT:Ljava/lang/String; = "com.amazon.dcp.sso.action.AmazonAccountPropertyService"

.field public static final ACTION_AMAZON_ACCOUNT_REMOVED_INTENT:Ljava/lang/String; = "com.amazon.dcp.sso.action.account.removed"

.field public static final ACTION_AMAZON_CALL_ACCOUNT_REGISTRAR:Ljava/lang/String; = "com.amazon.dcp.sso.action.AmazonAccountRegistrar"

.field public static final ACTION_AMAZON_SECONDARY_ACCOUNT_ADDED_INTENT:Ljava/lang/String; = "com.amazon.dcp.sso.action.secondary.account.added"

.field public static final ACTION_AMAZON_SECONDARY_ACCOUNT_REMOVED_INTENT:Ljava/lang/String; = "com.amazon.dcp.sso.action.secondary.account.removed"

.field public static final ACTION_AMAZON_SSO_INFORMATION:Ljava/lang/String; = "com.amazon.dcp.sso.action.SSO_POST_SPLIT_INFORMATION"

.field public static final ACTION_CONFIRM_CREDENTIAL_INTENT:Ljava/lang/String; = "com.amazon.dcp.sso.ConfirmCredential"

.field public static final ACTION_SUB_AUTHENTICATOR_INTENT:Ljava/lang/String; = "com.amazon.dcp.sso.AccountSubAuthenticator"

.field public static final COR_PFM_HAS_CHANGED:Ljava/lang/String; = "com.amazon.dcp.sso.broadcast.CORPFMHasChanged"

.field public static final EXTRA_AMAZON_ACCOUNT_CHANGED_DIRECTED_ID:Ljava/lang/String; = "com.amazon.dcp.sso.extra.account.directed_id"

.field public static final EXTRA_AMAZON_ACCOUNT_CHANGED_NAME:Ljava/lang/String; = "com.amazon.dcp.sso.extra.account.name"

.field public static final EXTRA_AMAZON_ACCOUNT_CHANGED_TYPE:Ljava/lang/String; = "com.amazon.dcp.sso.extra.account.type"

.field public static final EXTRA_PROFILES_ACCOUNT_ADDED_OR_REMOVED_BELONG_TO:Ljava/lang/String; = "com.amazon.identity.auth.extra.account.profiles"

.field public static final KEY_ACCOUNT_PROPERTY:Ljava/lang/String; = "new.account.property.changed"

.field public static final KEY_ACCOUNT_PROPERTY_OLD:Ljava/lang/String; = "account.property.changed"

.field public static final KEY_DEVICE_DEVICE_EMAIL:Ljava/lang/String; = "com.amazon.dcp.sso.property.deviceemail"

.field public static final KEY_DEVICE_DEVICE_NAME:Ljava/lang/String; = "com.amazon.dcp.sso.property.devicename"

.field public static final PERMISSION_AMAZON_ACCOUNT_CHANGED:Ljava/lang/String; = "com.amazon.dcp.sso.permission.account.changed"

.field public static final PERMISSION_AMAZON_ACCOUNT_PROPERTY_CHANGED:Ljava/lang/String; = "com.amazon.dcp.sso.permission.AmazonAccountPropertyService.property.changed"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 285
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 286
    return-void
.end method
