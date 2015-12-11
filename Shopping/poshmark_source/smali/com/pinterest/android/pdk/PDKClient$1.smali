.class Lcom/pinterest/android/pdk/PDKClient$1;
.super Lcom/pinterest/android/pdk/PDKCallback;
.source "PDKClient.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/pinterest/android/pdk/PDKClient;->login(Landroid/content/Context;Ljava/util/List;Lcom/pinterest/android/pdk/PDKCallback;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/pinterest/android/pdk/PDKClient;

.field final synthetic val$context:Landroid/content/Context;

.field final synthetic val$permissions:Ljava/util/List;


# direct methods
.method constructor <init>(Lcom/pinterest/android/pdk/PDKClient;Landroid/content/Context;Ljava/util/List;)V
    .locals 0

    .prologue
    .line 171
    iput-object p1, p0, Lcom/pinterest/android/pdk/PDKClient$1;->this$0:Lcom/pinterest/android/pdk/PDKClient;

    iput-object p2, p0, Lcom/pinterest/android/pdk/PDKClient$1;->val$context:Landroid/content/Context;

    iput-object p3, p0, Lcom/pinterest/android/pdk/PDKClient$1;->val$permissions:Ljava/util/List;

    invoke-direct {p0}, Lcom/pinterest/android/pdk/PDKCallback;-><init>()V

    return-void
.end method


# virtual methods
.method public onFailure(Lcom/pinterest/android/pdk/PDKException;)V
    .locals 3
    .param p1, "exception"    # Lcom/pinterest/android/pdk/PDKException;

    .prologue
    .line 184
    iget-object v0, p0, Lcom/pinterest/android/pdk/PDKClient$1;->this$0:Lcom/pinterest/android/pdk/PDKClient;

    iget-object v1, p0, Lcom/pinterest/android/pdk/PDKClient$1;->val$context:Landroid/content/Context;

    iget-object v2, p0, Lcom/pinterest/android/pdk/PDKClient$1;->val$permissions:Ljava/util/List;

    # invokes: Lcom/pinterest/android/pdk/PDKClient;->initiateLogin(Landroid/content/Context;Ljava/util/List;)V
    invoke-static {v0, v1, v2}, Lcom/pinterest/android/pdk/PDKClient;->access$300(Lcom/pinterest/android/pdk/PDKClient;Landroid/content/Context;Ljava/util/List;)V

    .line 185
    return-void
.end method

.method public onSuccess(Lcom/pinterest/android/pdk/PDKResponse;)V
    .locals 3
    .param p1, "response"    # Lcom/pinterest/android/pdk/PDKResponse;

    .prologue
    .line 174
    iget-object v0, p0, Lcom/pinterest/android/pdk/PDKClient$1;->this$0:Lcom/pinterest/android/pdk/PDKClient;

    invoke-virtual {p1}, Lcom/pinterest/android/pdk/PDKResponse;->getData()Ljava/lang/Object;

    move-result-object v1

    # invokes: Lcom/pinterest/android/pdk/PDKClient;->verifyAccessToken(Ljava/lang/Object;)Z
    invoke-static {v0, v1}, Lcom/pinterest/android/pdk/PDKClient;->access$000(Lcom/pinterest/android/pdk/PDKClient;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 175
    const/4 v0, 0x1

    # setter for: Lcom/pinterest/android/pdk/PDKClient;->_isAuthenticated:Z
    invoke-static {v0}, Lcom/pinterest/android/pdk/PDKClient;->access$102(Z)Z

    .line 176
    invoke-static {}, Lcom/pinterest/android/pdk/PDKClient;->getInstance()Lcom/pinterest/android/pdk/PDKClient;

    move-result-object v0

    iget-object v1, p0, Lcom/pinterest/android/pdk/PDKClient$1;->this$0:Lcom/pinterest/android/pdk/PDKClient;

    # getter for: Lcom/pinterest/android/pdk/PDKClient;->_authCallback:Lcom/pinterest/android/pdk/PDKCallback;
    invoke-static {v1}, Lcom/pinterest/android/pdk/PDKClient;->access$200(Lcom/pinterest/android/pdk/PDKClient;)Lcom/pinterest/android/pdk/PDKCallback;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/pinterest/android/pdk/PDKClient;->getMe(Lcom/pinterest/android/pdk/PDKCallback;)V

    .line 180
    :goto_0
    return-void

    .line 178
    :cond_0
    iget-object v0, p0, Lcom/pinterest/android/pdk/PDKClient$1;->this$0:Lcom/pinterest/android/pdk/PDKClient;

    iget-object v1, p0, Lcom/pinterest/android/pdk/PDKClient$1;->val$context:Landroid/content/Context;

    iget-object v2, p0, Lcom/pinterest/android/pdk/PDKClient$1;->val$permissions:Ljava/util/List;

    # invokes: Lcom/pinterest/android/pdk/PDKClient;->initiateLogin(Landroid/content/Context;Ljava/util/List;)V
    invoke-static {v0, v1, v2}, Lcom/pinterest/android/pdk/PDKClient;->access$300(Lcom/pinterest/android/pdk/PDKClient;Landroid/content/Context;Ljava/util/List;)V

    goto :goto_0
.end method
