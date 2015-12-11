.class public Lcom/poshmark/webcommands/StartListingFlowCompletionHandler;
.super Lcom/poshmark/webcommands/CommandCompletionHandler;
.source "StartListingFlowCompletionHandler.java"


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 15
    invoke-direct {p0}, Lcom/poshmark/webcommands/CommandCompletionHandler;-><init>()V

    .line 16
    sget-object v0, Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;->START_LISTINGS_FLOW:Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;

    iput-object v0, p0, Lcom/poshmark/webcommands/StartListingFlowCompletionHandler;->type:Lcom/poshmark/webcommands/CommandCompletionHandler$HandlerType;

    .line 17
    return-void
.end method


# virtual methods
.method public handleCommandResults(Lcom/poshmark/ui/fragments/MappPageFragment;Lcom/poshmark/webcommands/WebCommand;Landroid/content/Intent;)V
    .locals 3
    .param p1, "fragment"    # Lcom/poshmark/ui/fragments/MappPageFragment;
    .param p2, "command"    # Lcom/poshmark/webcommands/WebCommand;
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 20
    const/4 v0, 0x0

    .line 23
    .local v0, "b":Landroid/os/Bundle;
    invoke-virtual {p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 24
    const-string v2, "IMAGE_FILE_URI"

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v1

    check-cast v1, Landroid/net/Uri;

    .line 25
    .local v1, "imageFile":Landroid/net/Uri;
    return-void
.end method
