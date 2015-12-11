.class Lio/branch/referral/ShareLinkManager$3;
.super Ljava/lang/Object;
.source "ShareLinkManager.java"

# interfaces
.implements Lio/branch/referral/Branch$BranchLinkCreateListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lio/branch/referral/ShareLinkManager;->invokeSharingClient(Landroid/content/pm/ResolveInfo;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lio/branch/referral/ShareLinkManager;

.field final synthetic val$channelName:Ljava/lang/String;

.field final synthetic val$selectedResolveInfo:Landroid/content/pm/ResolveInfo;


# direct methods
.method constructor <init>(Lio/branch/referral/ShareLinkManager;Landroid/content/pm/ResolveInfo;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 205
    iput-object p1, p0, Lio/branch/referral/ShareLinkManager$3;->this$0:Lio/branch/referral/ShareLinkManager;

    iput-object p2, p0, Lio/branch/referral/ShareLinkManager$3;->val$selectedResolveInfo:Landroid/content/pm/ResolveInfo;

    iput-object p3, p0, Lio/branch/referral/ShareLinkManager$3;->val$channelName:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onLinkCreate(Ljava/lang/String;Lio/branch/referral/BranchError;)V
    .locals 4
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "error"    # Lio/branch/referral/BranchError;

    .prologue
    .line 208
    if-nez p2, :cond_0

    .line 209
    iget-object v1, p0, Lio/branch/referral/ShareLinkManager$3;->this$0:Lio/branch/referral/ShareLinkManager;

    iget-object v2, p0, Lio/branch/referral/ShareLinkManager$3;->val$selectedResolveInfo:Landroid/content/pm/ResolveInfo;

    iget-object v3, p0, Lio/branch/referral/ShareLinkManager$3;->val$channelName:Ljava/lang/String;

    # invokes: Lio/branch/referral/ShareLinkManager;->shareWithClient(Landroid/content/pm/ResolveInfo;Ljava/lang/String;Ljava/lang/String;)V
    invoke-static {v1, v2, p1, v3}, Lio/branch/referral/ShareLinkManager;->access$700(Lio/branch/referral/ShareLinkManager;Landroid/content/pm/ResolveInfo;Ljava/lang/String;Ljava/lang/String;)V

    .line 223
    :goto_0
    iget-object v1, p0, Lio/branch/referral/ShareLinkManager$3;->this$0:Lio/branch/referral/ShareLinkManager;

    const/4 v2, 0x0

    # setter for: Lio/branch/referral/ShareLinkManager;->isShareInProgress_:Z
    invoke-static {v1, v2}, Lio/branch/referral/ShareLinkManager;->access$502(Lio/branch/referral/ShareLinkManager;Z)Z

    .line 224
    return-void

    .line 212
    :cond_0
    iget-object v1, p0, Lio/branch/referral/ShareLinkManager$3;->this$0:Lio/branch/referral/ShareLinkManager;

    # getter for: Lio/branch/referral/ShareLinkManager;->builder_:Lio/branch/referral/Branch$ShareLinkBuilder;
    invoke-static {v1}, Lio/branch/referral/ShareLinkManager;->access$600(Lio/branch/referral/ShareLinkManager;)Lio/branch/referral/Branch$ShareLinkBuilder;

    move-result-object v1

    invoke-virtual {v1}, Lio/branch/referral/Branch$ShareLinkBuilder;->getDefaultURL()Ljava/lang/String;

    move-result-object v0

    .line 213
    .local v0, "defaultUrl":Ljava/lang/String;
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-lez v1, :cond_1

    .line 214
    iget-object v1, p0, Lio/branch/referral/ShareLinkManager$3;->this$0:Lio/branch/referral/ShareLinkManager;

    iget-object v2, p0, Lio/branch/referral/ShareLinkManager$3;->val$selectedResolveInfo:Landroid/content/pm/ResolveInfo;

    iget-object v3, p0, Lio/branch/referral/ShareLinkManager$3;->val$channelName:Ljava/lang/String;

    # invokes: Lio/branch/referral/ShareLinkManager;->shareWithClient(Landroid/content/pm/ResolveInfo;Ljava/lang/String;Ljava/lang/String;)V
    invoke-static {v1, v2, v0, v3}, Lio/branch/referral/ShareLinkManager;->access$700(Lio/branch/referral/ShareLinkManager;Landroid/content/pm/ResolveInfo;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 216
    :cond_1
    iget-object v1, p0, Lio/branch/referral/ShareLinkManager$3;->this$0:Lio/branch/referral/ShareLinkManager;

    iget-object v1, v1, Lio/branch/referral/ShareLinkManager;->callback_:Lio/branch/referral/Branch$BranchLinkShareListener;

    if-eqz v1, :cond_2

    .line 217
    iget-object v1, p0, Lio/branch/referral/ShareLinkManager$3;->this$0:Lio/branch/referral/ShareLinkManager;

    iget-object v1, v1, Lio/branch/referral/ShareLinkManager;->callback_:Lio/branch/referral/Branch$BranchLinkShareListener;

    iget-object v2, p0, Lio/branch/referral/ShareLinkManager$3;->val$channelName:Ljava/lang/String;

    invoke-interface {v1, p1, v2, p2}, Lio/branch/referral/Branch$BranchLinkShareListener;->onLinkShareResponse(Ljava/lang/String;Ljava/lang/String;Lio/branch/referral/BranchError;)V

    goto :goto_0

    .line 219
    :cond_2
    const-string v1, "BranchSDK"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Unable to share link "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p2}, Lio/branch/referral/BranchError;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method
