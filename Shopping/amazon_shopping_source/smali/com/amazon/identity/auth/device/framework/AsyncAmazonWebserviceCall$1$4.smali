.class Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall$1$4;
.super Ljava/lang/Object;
.source "AsyncAmazonWebserviceCall.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall$1;->onRequestComplete()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall$1;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall$1;)V
    .locals 0

    .prologue
    .line 107
    iput-object p1, p0, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall$1$4;->this$1:Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 111
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall$1$4;->this$1:Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall$1;

    iget-object v0, v0, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall$1;->val$callback:Lcom/amazon/identity/kcpsdk/auth/IAmazonWebServiceCallback;

    invoke-interface {v0}, Lcom/amazon/identity/kcpsdk/auth/IAmazonWebServiceCallback;->onRequestComplete()V

    .line 112
    return-void
.end method
