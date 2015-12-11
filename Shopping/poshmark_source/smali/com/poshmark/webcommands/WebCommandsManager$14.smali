.class Lcom/poshmark/webcommands/WebCommandsManager$14;
.super Ljava/lang/Object;
.source "WebCommandsManager.java"

# interfaces
.implements Lcom/poshmark/utils/UIThreadTask$Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/webcommands/WebCommandsManager;->editListing(Lcom/poshmark/webcommands/WebCommand;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/webcommands/WebCommandsManager;

.field final synthetic val$command:Lcom/poshmark/webcommands/WebCommand;


# direct methods
.method constructor <init>(Lcom/poshmark/webcommands/WebCommandsManager;Lcom/poshmark/webcommands/WebCommand;)V
    .locals 0

    .prologue
    .line 884
    iput-object p1, p0, Lcom/poshmark/webcommands/WebCommandsManager$14;->this$0:Lcom/poshmark/webcommands/WebCommandsManager;

    iput-object p2, p0, Lcom/poshmark/webcommands/WebCommandsManager$14;->val$command:Lcom/poshmark/webcommands/WebCommand;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public runOnUIThread(Ljava/lang/Object;)V
    .locals 3
    .param p1, "data"    # Ljava/lang/Object;

    .prologue
    .line 887
    iget-object v1, p0, Lcom/poshmark/webcommands/WebCommandsManager$14;->val$command:Lcom/poshmark/webcommands/WebCommand;

    iget-object v1, v1, Lcom/poshmark/webcommands/WebCommand;->parameters:Ljava/util/Map;

    const-string v2, "id"

    invoke-interface {v1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 888
    .local v0, "id":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 889
    iget-object v1, p0, Lcom/poshmark/webcommands/WebCommandsManager$14;->this$0:Lcom/poshmark/webcommands/WebCommandsManager;

    iget-object v1, v1, Lcom/poshmark/webcommands/WebCommandsManager;->fragment:Lcom/poshmark/ui/fragments/MappPageFragment;

    const-string v2, "Loading..."

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/fragments/MappPageFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 890
    new-instance v1, Lcom/poshmark/webcommands/WebCommandsManager$14$1;

    invoke-direct {v1, p0, v0}, Lcom/poshmark/webcommands/WebCommandsManager$14$1;-><init>(Lcom/poshmark/webcommands/WebCommandsManager$14;Ljava/lang/String;)V

    invoke-static {v0, v1}, Lcom/poshmark/http/api/PMApi;->getListingDetails(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 911
    :cond_0
    return-void
.end method
