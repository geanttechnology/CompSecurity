.class Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;
.super Ljava/lang/Object;
.source "MAPWebViewHelper.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "Parameters"
.end annotation


# static fields
.field public static final KEY_ASSOCIATION_HANDLE:Ljava/lang/String; = "association_handle"

.field public static final KEY_AUTH_COOKIES:Ljava/lang/String; = "authCookies"

.field public static final KEY_CLAIMED_ID:Ljava/lang/String; = "claimed_id"

.field public static final KEY_CLIENT_CONTEXT:Ljava/lang/String; = "client_context"

.field public static final KEY_DOMAIN:Ljava/lang/String; = "domain"

.field public static final KEY_IDENTITY:Ljava/lang/String; = "identity"

.field public static final KEY_MAX_AUTH_AGE:Ljava/lang/String; = "max_auth_age"

.field public static final KEY_PAGE_ID:Ljava/lang/String; = "page_id"

.field public static final KEY_REQUEST_TYPE:Ljava/lang/String; = "request_type"

.field public static final KEY_RETURN_TO_URL:Ljava/lang/String; = "return_to_url"

.field public static final KEY_SITE_STATE:Ljava/lang/String; = "site_state"

.field public static final KEY_URL:Ljava/lang/String; = "url"

.field public static final KEY_USER_AGENT:Ljava/lang/String; = "user_agent"


# instance fields
.field public associationHandle:Ljava/lang/String;

.field public authCookies:Ljava/lang/String;

.field public claimedId:Ljava/lang/String;

.field public clientContext:Ljava/lang/String;

.field public domain:Ljava/lang/String;

.field public identity:Ljava/lang/String;

.field public maxAuthAge:Ljava/lang/String;

.field public pageId:Ljava/lang/String;

.field public requestType:Ljava/lang/String;

.field public returnToURL:Ljava/lang/String;

.field public siteState:Ljava/lang/String;

.field final synthetic this$0:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;

.field public url:Ljava/lang/String;

.field public userAgent:Ljava/lang/String;


# direct methods
.method private constructor <init>(Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;)V
    .locals 0

    .prologue
    .line 90
    iput-object p1, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->this$0:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;
    .param p2, "x1"    # Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$1;

    .prologue
    .line 90
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;-><init>(Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;)V

    return-void
.end method
