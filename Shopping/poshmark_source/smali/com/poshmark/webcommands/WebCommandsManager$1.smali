.class Lcom/poshmark/webcommands/WebCommandsManager$1;
.super Ljava/lang/Object;
.source "WebCommandsManager.java"

# interfaces
.implements Lcom/poshmark/utils/UIThreadTask$Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/webcommands/WebCommandsManager;->closeNPages(Lcom/poshmark/webcommands/WebCommand;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/webcommands/WebCommandsManager;

.field final synthetic val$command:Lcom/poshmark/webcommands/WebCommand;

.field final synthetic val$pageCount:I


# direct methods
.method constructor <init>(Lcom/poshmark/webcommands/WebCommandsManager;ILcom/poshmark/webcommands/WebCommand;)V
    .locals 0

    .prologue
    .line 205
    iput-object p1, p0, Lcom/poshmark/webcommands/WebCommandsManager$1;->this$0:Lcom/poshmark/webcommands/WebCommandsManager;

    iput p2, p0, Lcom/poshmark/webcommands/WebCommandsManager$1;->val$pageCount:I

    iput-object p3, p0, Lcom/poshmark/webcommands/WebCommandsManager$1;->val$command:Lcom/poshmark/webcommands/WebCommand;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public runOnUIThread(Ljava/lang/Object;)V
    .locals 4
    .param p1, "data"    # Ljava/lang/Object;

    .prologue
    .line 208
    iget-object v1, p0, Lcom/poshmark/webcommands/WebCommandsManager$1;->this$0:Lcom/poshmark/webcommands/WebCommandsManager;

    iget-object v1, v1, Lcom/poshmark/webcommands/WebCommandsManager;->parentActivity:Lcom/poshmark/ui/PMActivity;

    iget v2, p0, Lcom/poshmark/webcommands/WebCommandsManager$1;->val$pageCount:I

    const/4 v3, 0x1

    invoke-virtual {v1, v2, v3}, Lcom/poshmark/ui/PMActivity;->popTopNFragments(IZ)V

    .line 209
    iget-object v1, p0, Lcom/poshmark/webcommands/WebCommandsManager$1;->this$0:Lcom/poshmark/webcommands/WebCommandsManager;

    # invokes: Lcom/poshmark/webcommands/WebCommandsManager;->getCurrentVisibleMappPageFragment()Lcom/poshmark/ui/fragments/MappPageFragment;
    invoke-static {v1}, Lcom/poshmark/webcommands/WebCommandsManager;->access$000(Lcom/poshmark/webcommands/WebCommandsManager;)Lcom/poshmark/ui/fragments/MappPageFragment;

    move-result-object v0

    .line 211
    .local v0, "topFragment":Lcom/poshmark/ui/fragments/MappPageFragment;
    if-eqz v0, :cond_0

    iget-object v1, p0, Lcom/poshmark/webcommands/WebCommandsManager$1;->val$command:Lcom/poshmark/webcommands/WebCommand;

    iget-object v1, v1, Lcom/poshmark/webcommands/WebCommand;->parameters:Ljava/util/Map;

    const-string v2, "callbackMethod"

    invoke-interface {v1, v2}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 212
    iget-object v1, p0, Lcom/poshmark/webcommands/WebCommandsManager$1;->val$command:Lcom/poshmark/webcommands/WebCommand;

    iget-object v1, v1, Lcom/poshmark/webcommands/WebCommand;->parameters:Ljava/util/Map;

    const-string v2, "callbackMethod"

    invoke-interface {v1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/MappPageFragment;->fireJSCallback(Ljava/lang/String;)V

    .line 215
    :cond_0
    return-void
.end method
