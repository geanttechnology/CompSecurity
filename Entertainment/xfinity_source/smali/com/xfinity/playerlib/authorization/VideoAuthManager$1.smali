.class Lcom/xfinity/playerlib/authorization/VideoAuthManager$1;
.super Ljava/lang/Object;
.source "VideoAuthManager.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/http/service/RetryingHttpService$RetryPredicate;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/authorization/VideoAuthManager;->performAMSAuth(Ljava/lang/String;Ljava/lang/String;Z)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/authorization/VideoAuthManager;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/authorization/VideoAuthManager;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/authorization/VideoAuthManager;

    .prologue
    .line 128
    .local p0, "this":Lcom/xfinity/playerlib/authorization/VideoAuthManager$1;, "Lcom/xfinity/playerlib/authorization/VideoAuthManager$1;"
    iput-object p1, p0, Lcom/xfinity/playerlib/authorization/VideoAuthManager$1;->this$0:Lcom/xfinity/playerlib/authorization/VideoAuthManager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public shouldRetry(Lcom/comcast/cim/cmasl/utils/exceptions/CimException;I)Z
    .locals 3
    .param p1, "exception"    # Lcom/comcast/cim/cmasl/utils/exceptions/CimException;
    .param p2, "retryCount"    # I

    .prologue
    .local p0, "this":Lcom/xfinity/playerlib/authorization/VideoAuthManager$1;, "Lcom/xfinity/playerlib/authorization/VideoAuthManager$1;"
    const/4 v1, 0x1

    .line 131
    invoke-virtual {p1}, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;->getCause()Ljava/lang/Throwable;

    move-result-object v0

    .line 132
    .local v0, "cause":Ljava/lang/Throwable;
    instance-of v2, v0, Ljava/net/SocketTimeoutException;

    if-nez v2, :cond_0

    instance-of v2, v0, Lcom/comcast/cim/httpcomponentsandroid/NoHttpResponseException;

    if-eqz v2, :cond_1

    :cond_0
    if-ge p2, v1, :cond_1

    :goto_0
    return v1

    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method
