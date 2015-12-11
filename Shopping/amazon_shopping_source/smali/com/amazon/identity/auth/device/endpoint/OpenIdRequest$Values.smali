.class public final Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$Values;
.super Ljava/lang/Object;
.source "OpenIdRequest.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Values"
.end annotation


# static fields
.field public static final ACCESS_TOKEN_SCOPE:Ljava/lang/String; = "device_auth_access"

.field public static final ACCT_STATUS_POLICY_P1:Ljava/lang/String; = "P1"

.field public static final ASSOCIATION_HANDLE_CN:Ljava/lang/String; = "amzn_device_cn"

.field public static final ASSOCIATION_HANDLE_JP:Ljava/lang/String; = "amzn_device_jp"

.field public static final ASSOCIATION_HANDLE_NA:Ljava/lang/String; = "amzn_device_na"

.field public static final DEFAULT_ASSOCIATION_HANDLE:Ljava/lang/String; = "amzn_device_na"

.field public static final ID_CONFIRM_CREDENTIALS:Ljava/lang/String; = "http://www.amazon.com/ap/specs/auth/confirm_credentials"

.field public static final ID_IDENTIFIER_SELECT:Ljava/lang/String; = "http://specs.openid.net/auth/2.0/identifier_select"

.field public static final MODE_CHECKID_SETUP:Ljava/lang/String; = "checkid_setup"

.field public static final OA2_NAMESPACE:Ljava/lang/String; = "http://www.amazon.com/ap/ext/oauth/2"

.field public static final OPENID_NAMESPACE:Ljava/lang/String; = "http://specs.openid.net/auth/2.0"

.field public static final PAPE_NAMESPACE:Ljava/lang/String; = "http://specs.openid.net/extensions/pape/1.0"

.field public static final REFRESH_TOKEN_SCOPE:Ljava/lang/String; = "device_auth_refresh"

.field public static final REQUEST_TYPE_PARAM_KEY:Ljava/lang/String; = "requestType"

.field public static final TOKEN_RESPONSE_TYPE:Ljava/lang/String; = "token"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 96
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 97
    return-void
.end method
