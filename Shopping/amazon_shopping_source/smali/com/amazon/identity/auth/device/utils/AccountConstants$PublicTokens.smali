.class public final Lcom/amazon/identity/auth/device/utils/AccountConstants$PublicTokens;
.super Ljava/lang/Object;
.source "AccountConstants.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/utils/AccountConstants;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "PublicTokens"
.end annotation


# static fields
.field public static final TOKEN_TYPE_AMAZON_COM_COOKIES_TOKEN:Ljava/lang/String; = "com.amazon.dcp.sso.token.cookie.amazonComCookies"

.field public static final TOKEN_TYPE_COOKIE_XMAIN_TOKEN:Ljava/lang/String; = "com.amazon.dcp.sso.token.cookie.xmain"

.field public static final TOKEN_TYPE_DEVICE_AMAZON_OAUTH_ACCESS_TOKEN:Ljava/lang/String; = "com.amazon.dcp.sso.token.oauth.amazon.access_token"

.field public static final TOKEN_TYPE_DEVICE_NAME:Ljava/lang/String; = "com.amazon.dcp.sso.token.device.devicename"

.field public static final TOKEN_TYPE_DEVICE_SERIAL_NUMBER:Ljava/lang/String; = "com.amazon.dcp.sso.token.device.deviceserialname"

.field public static final TOKEN_TYPE_DEVICE_TYPE:Ljava/lang/String; = "com.amazon.dcp.sso.token.devicedevicetype"

.field public static final TOKEN_TYPE_XMAIN_AND_XACB_COOKIES_TOKEN:Ljava/lang/String; = "com.amazon.dcp.sso.token.cookie.xmainAndXabcCookies"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 100
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 101
    return-void
.end method
