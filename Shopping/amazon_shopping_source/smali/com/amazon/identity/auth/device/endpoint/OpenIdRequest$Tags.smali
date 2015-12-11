.class public final Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$Tags;
.super Ljava/lang/Object;
.source "OpenIdRequest.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Tags"
.end annotation


# static fields
.field public static final ACCT_STATUS_POLICY:Ljava/lang/String; = "accountStatusPolicy"

.field public static final ASSOCIATION_HANDLE:Ljava/lang/String; = "openid.assoc_handle"

.field public static final AUTHCOOKIES:Ljava/lang/String; = "authCookies"

.field public static final CLAIMED_ID:Ljava/lang/String; = "openid.claimed_id"

.field public static final CLIENT_CONTEXT:Ljava/lang/String; = "clientContext"

.field public static final CLIENT_ID:Ljava/lang/String; = "openid.oa2.client_id"

.field public static final CLIENT_INFO:Ljava/lang/String; = "clientInfo"

.field public static final DISABLE_LOGIN_PREPOPULATE:Ljava/lang/String; = "disableLoginPrepopulate"

.field public static final IDENTITY:Ljava/lang/String; = "openid.identity"

.field public static final LANGUAGE_PARAMETER:Ljava/lang/String; = "language"

.field public static final MAX_AUTH_AGE:Ljava/lang/String; = "openid.pape.max_auth_age"

.field public static final MODE:Ljava/lang/String; = "openid.mode"

.field public static final NAMESPACE:Ljava/lang/String; = "openid.ns"

.field public static final OA2:Ljava/lang/String; = "openid.ns.oa2"

.field public static final PAGEID:Ljava/lang/String; = "pageId"

.field public static final PAPE_NAMESPACE:Ljava/lang/String; = "openid.ns.pape"

.field public static final RESPONSE_TYPE:Ljava/lang/String; = "openid.oa2.response_type"

.field public static final RETURN_TO:Ljava/lang/String; = "openid.return_to"

.field public static final SCOPE:Ljava/lang/String; = "openid.oa2.scope"

.field public static final SITE_STATE:Ljava/lang/String; = "siteState"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 67
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 68
    return-void
.end method
