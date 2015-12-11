.class Lcom/poshmark/webcommands/WebCommandsManager$8;
.super Ljava/lang/Object;
.source "WebCommandsManager.java"

# interfaces
.implements Lcom/poshmark/utils/UIThreadTask$Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/webcommands/WebCommandsManager;->getContacts(Lcom/poshmark/webcommands/WebCommand;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/webcommands/WebCommandsManager;

.field final synthetic val$command:Lcom/poshmark/webcommands/WebCommand;

.field final synthetic val$contactsJson:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/poshmark/webcommands/WebCommandsManager;Lcom/poshmark/webcommands/WebCommand;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 536
    iput-object p1, p0, Lcom/poshmark/webcommands/WebCommandsManager$8;->this$0:Lcom/poshmark/webcommands/WebCommandsManager;

    iput-object p2, p0, Lcom/poshmark/webcommands/WebCommandsManager$8;->val$command:Lcom/poshmark/webcommands/WebCommand;

    iput-object p3, p0, Lcom/poshmark/webcommands/WebCommandsManager$8;->val$contactsJson:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public runOnUIThread(Ljava/lang/Object;)V
    .locals 4
    .param p1, "data"    # Ljava/lang/Object;

    .prologue
    .line 539
    iget-object v0, p0, Lcom/poshmark/webcommands/WebCommandsManager$8;->this$0:Lcom/poshmark/webcommands/WebCommandsManager;

    iget-object v1, v0, Lcom/poshmark/webcommands/WebCommandsManager;->fragment:Lcom/poshmark/ui/fragments/MappPageFragment;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v0, p0, Lcom/poshmark/webcommands/WebCommandsManager$8;->val$command:Lcom/poshmark/webcommands/WebCommand;

    iget-object v0, v0, Lcom/poshmark/webcommands/WebCommand;->parameters:Ljava/util/Map;

    const-string v3, "callback"

    invoke-interface {v0, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "("

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v2, p0, Lcom/poshmark/webcommands/WebCommandsManager$8;->val$contactsJson:Ljava/lang/String;

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, ","

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v2, Lcom/poshmark/webcommands/WebCommandsManager;->JAVASCRIPT_NULL:Ljava/lang/String;

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, ")"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/poshmark/ui/fragments/MappPageFragment;->fireJSCallback(Ljava/lang/String;)V

    .line 540
    return-void
.end method
