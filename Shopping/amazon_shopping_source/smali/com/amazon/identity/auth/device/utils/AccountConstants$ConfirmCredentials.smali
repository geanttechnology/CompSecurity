.class public final Lcom/amazon/identity/auth/device/utils/AccountConstants$ConfirmCredentials;
.super Ljava/lang/Object;
.source "AccountConstants.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/utils/AccountConstants;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "ConfirmCredentials"
.end annotation


# static fields
.field public static final AP_OPTION_KEY_ASSOC_HANDLE:Ljava/lang/String; = "com.amazon.dcp.sso.ap.assoc_handle"

.field public static final AP_OPTION_KEY_PAGEID:Ljava/lang/String; = "com.amazon.dcp.sso.ap.pageid"

.field public static final AP_OPTION_KEY_SESSIONID:Ljava/lang/String; = "com.amazon.dcp.sso.ap.sessionid"

.field public static final AP_OPTION_KEY_UBID:Ljava/lang/String; = "com.amazon.dcp.sso.ap.ubid"

.field public static final TOKEN_TYPE_COOKIE_ATMAIN_TOKEN:Ljava/lang/String; = "com.amazon.dcp.sso.token.cookie.atmain"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 325
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 327
    return-void
.end method
