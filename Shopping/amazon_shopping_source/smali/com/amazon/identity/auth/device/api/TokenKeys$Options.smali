.class public final Lcom/amazon/identity/auth/device/api/TokenKeys$Options;
.super Ljava/lang/Object;
.source "TokenKeys.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/api/TokenKeys;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Options"
.end annotation


# static fields
.field public static final KEY_FORCE_REFRESH_DMS_TO_OAUTH:Ljava/lang/String; = "com.amazon.identity.auth.device.api.TokenKeys.Options.ForceRefreshDMSTokenForOAuthToken"

.field public static final KEY_FORCE_REFRESH_OAUTH:Ljava/lang/String; = "com.amazon.identity.auth.device.api.TokenKeys.Options.ForceRefreshOAuthToken"

.field public static final KEY_OAUTH_TTL_MS_LONG:Ljava/lang/String; = "com.amazon.identity.auth.device.api.TokenKeys.Options.OAuthAccessTokenTTLInMilliSec"

.field public static final PREFIX:Ljava/lang/String; = "com.amazon.identity.auth.device.api.TokenKeys.Options."


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 52
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 54
    return-void
.end method
