.class Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall$2;
.super Ljava/lang/Object;
.source "AsyncAmazonWebserviceCall.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall;->call()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall;)V
    .locals 0

    .prologue
    .line 125
    iput-object p1, p0, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall$2;->this$0:Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 129
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall$2;->this$0:Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall;

    # getter for: Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall;->mInner:Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;
    invoke-static {v0}, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall;->access$100(Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall;)Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCall;->call()V

    .line 130
    return-void
.end method
