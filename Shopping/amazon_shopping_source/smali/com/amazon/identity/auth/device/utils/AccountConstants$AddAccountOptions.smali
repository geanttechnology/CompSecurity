.class public final Lcom/amazon/identity/auth/device/utils/AccountConstants$AddAccountOptions;
.super Ljava/lang/Object;
.source "AccountConstants.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/utils/AccountConstants;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "AddAccountOptions"
.end annotation


# static fields
.field public static final ADD_ACCOUNT_FROM_UPDATE_CREDENTIALS:Ljava/lang/String; = "com.amazon.dcp.sso.RegisterViaUpdateCreds"

.field public static final ADD_ACCOUNT_PARAMETERS:Ljava/lang/String; = "com.amazon.dcp.sso.addAccountParameters"

.field public static final ADD_ACCOUNT_USING_DEVICE_SECRET:Ljava/lang/String; = "com.amazon.dcp.sso.AddAccountUsingDeviceSecret"

.field public static final KEY_ADD_ACCOUNT_ACCESS_TOKEN:Ljava/lang/String; = "com.amazon.dcp.sso.AddAccount.options.AccessToken"

.field public static final KEY_ADD_ACCOUNT_ATMAIN:Ljava/lang/String; = "com.amazon.dcp.sso.AddAccount.options.ATMain"

.field public static final KEY_ADD_ACCOUNT_AUTHTOKENTYPE:Ljava/lang/String; = "com.amazon.dcp.sso.addAccountParameters.authTokenType"

.field public static final KEY_ADD_ACCOUNT_OPTIONS:Ljava/lang/String; = "com.amazon.dcp.sso.addAccountParameters.options"

.field public static final KEY_ADD_ACCOUNT_REQUIREDFEATURES:Ljava/lang/String; = "com.amazon.dcp.sso.addAccountParameters.requiredFeatures"

.field public static final KEY_ADD_ACCOUNT_URL:Ljava/lang/String; = "com.amazon.dcp.sso.AddAccount.options.URL"

.field public static final KEY_ADD_AS_SECONDARY_ACCOUNT:Ljava/lang/String; = "com.amazon.dcp.sso.AddAccount.options.AddAsSecondary"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 519
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 520
    return-void
.end method
