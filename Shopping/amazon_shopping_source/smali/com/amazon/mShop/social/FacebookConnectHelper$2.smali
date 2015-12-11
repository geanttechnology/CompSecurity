.class Lcom/amazon/mShop/social/FacebookConnectHelper$2;
.super Ljava/lang/Object;
.source "FacebookConnectHelper.java"

# interfaces
.implements Lcom/facebook/Session$StatusCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/social/FacebookConnectHelper;->onSessionStateChange(Lcom/facebook/Session;Lcom/facebook/SessionState;Ljava/lang/Exception;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/social/FacebookConnectHelper;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/social/FacebookConnectHelper;)V
    .locals 0

    .prologue
    .line 128
    iput-object p1, p0, Lcom/amazon/mShop/social/FacebookConnectHelper$2;->this$0:Lcom/amazon/mShop/social/FacebookConnectHelper;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public call(Lcom/facebook/Session;Lcom/facebook/SessionState;Ljava/lang/Exception;)V
    .locals 1
    .param p1, "session"    # Lcom/facebook/Session;
    .param p2, "state"    # Lcom/facebook/SessionState;
    .param p3, "exception"    # Ljava/lang/Exception;

    .prologue
    .line 131
    iget-object v0, p0, Lcom/amazon/mShop/social/FacebookConnectHelper$2;->this$0:Lcom/amazon/mShop/social/FacebookConnectHelper;

    # invokes: Lcom/amazon/mShop/social/FacebookConnectHelper;->onSessionStateChange(Lcom/facebook/Session;Lcom/facebook/SessionState;Ljava/lang/Exception;)V
    invoke-static {v0, p1, p2, p3}, Lcom/amazon/mShop/social/FacebookConnectHelper;->access$000(Lcom/amazon/mShop/social/FacebookConnectHelper;Lcom/facebook/Session;Lcom/facebook/SessionState;Ljava/lang/Exception;)V

    .line 132
    return-void
.end method
