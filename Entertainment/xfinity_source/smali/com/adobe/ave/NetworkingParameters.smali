.class public Lcom/adobe/ave/NetworkingParameters;
.super Ljava/lang/Object;
.source "NetworkingParameters.java"


# instance fields
.field public cookieHeader:Ljava/lang/String;

.field public useCookieHeaderForAllRequests:Z


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 27
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 28
    const-string v0, ""

    iput-object v0, p0, Lcom/adobe/ave/NetworkingParameters;->cookieHeader:Ljava/lang/String;

    .line 29
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/adobe/ave/NetworkingParameters;->useCookieHeaderForAllRequests:Z

    .line 30
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Z)V
    .locals 0
    .param p1, "aCookieHeader"    # Ljava/lang/String;
    .param p2, "aUseCookieHeaderForAllRequests"    # Z

    .prologue
    .line 33
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 34
    iput-object p1, p0, Lcom/adobe/ave/NetworkingParameters;->cookieHeader:Ljava/lang/String;

    .line 35
    iput-boolean p2, p0, Lcom/adobe/ave/NetworkingParameters;->useCookieHeaderForAllRequests:Z

    .line 36
    return-void
.end method
