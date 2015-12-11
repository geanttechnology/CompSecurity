.class public final Lcom/amazon/identity/auth/device/endpoint/OpenIdResponse$Tags;
.super Ljava/lang/Object;
.source "OpenIdResponse.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/endpoint/OpenIdResponse;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Tags"
.end annotation


# static fields
.field public static final ACCESSTOKEN:Ljava/lang/String; = "openid.oa2.access_token"

.field public static final ACCESS_TOKEN_SCOPE:Ljava/lang/String; = "device_auth_access"

.field public static final DIRECTEDID:Ljava/lang/String; = "openid.identity"

.field public static final IDENTITY:Ljava/lang/String; = "openid.identity"

.field public static final NEWACCOUNT:Ljava/lang/String; = "new_account"

.field public static final REFRESHTOKEN:Ljava/lang/String; = "openid.oa2.refresh_token"

.field public static final REFRESH_TOKEN_SCOPE:Ljava/lang/String; = "device_auth_refresh"

.field public static final SCOPE:Ljava/lang/String; = "openid.oa2.scope"

.field public static final TOKEN:Ljava/lang/String; = "aToken"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 49
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 50
    return-void
.end method
