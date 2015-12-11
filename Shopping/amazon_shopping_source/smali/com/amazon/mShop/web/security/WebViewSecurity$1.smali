.class final Lcom/amazon/mShop/web/security/WebViewSecurity$1;
.super Ljava/lang/Object;
.source "WebViewSecurity.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/services/mShop/PostMetricsResponseListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/web/security/WebViewSecurity;->postMetrics(Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 87
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public cancelled(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 94
    # getter for: Lcom/amazon/mShop/web/security/WebViewSecurity;->DEBUG:Z
    invoke-static {}, Lcom/amazon/mShop/web/security/WebViewSecurity;->access$000()Z

    move-result v0

    if-eqz v0, :cond_0

    const-string/jumbo v0, "WebViewSecurity"

    const-string/jumbo v1, "post metrics cancelled"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 95
    :cond_0
    return-void
.end method

.method public completed(Lcom/amazon/rio/j2me/client/services/mShop/Null;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/Null;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 98
    # getter for: Lcom/amazon/mShop/web/security/WebViewSecurity;->DEBUG:Z
    invoke-static {}, Lcom/amazon/mShop/web/security/WebViewSecurity;->access$000()Z

    move-result v0

    if-eqz v0, :cond_0

    const-string/jumbo v0, "WebViewSecurity"

    const-string/jumbo v1, "post metrics completed"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 99
    :cond_0
    return-void
.end method

.method public error(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 3
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 90
    # getter for: Lcom/amazon/mShop/web/security/WebViewSecurity;->DEBUG:Z
    invoke-static {}, Lcom/amazon/mShop/web/security/WebViewSecurity;->access$000()Z

    move-result v0

    if-eqz v0, :cond_0

    const-string/jumbo v0, "WebViewSecurity"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "post metrics failed: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 91
    :cond_0
    return-void
.end method
