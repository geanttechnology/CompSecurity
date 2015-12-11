.class Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall$1$2;
.super Ljava/lang/Object;
.source "AsyncAmazonWebserviceCall.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall$1;->onHeadersReceived(Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall$1;

.field final synthetic val$arg0:Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall$1;Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;)V
    .locals 0

    .prologue
    .line 81
    iput-object p1, p0, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall$1$2;->this$1:Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall$1;

    iput-object p2, p0, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall$1$2;->val$arg0:Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 85
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall$1$2;->this$1:Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall$1;

    iget-object v0, v0, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall$1;->val$callback:Lcom/amazon/identity/kcpsdk/auth/IAmazonWebServiceCallback;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall$1$2;->val$arg0:Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;

    invoke-interface {v0, v1}, Lcom/amazon/identity/kcpsdk/auth/IAmazonWebServiceCallback;->onHeadersReceived(Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;)V

    .line 86
    return-void
.end method
