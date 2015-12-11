.class Lcom/poshmark/webcommands/WebCommandsManager$12;
.super Ljava/lang/Object;
.source "WebCommandsManager.java"

# interfaces
.implements Lcom/poshmark/utils/UIThreadTask$Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/webcommands/WebCommandsManager;->checkoutOffer(Lcom/poshmark/webcommands/WebCommand;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/webcommands/WebCommandsManager;

.field final synthetic val$command:Lcom/poshmark/webcommands/WebCommand;

.field final synthetic val$offerId:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/poshmark/webcommands/WebCommandsManager;Ljava/lang/String;Lcom/poshmark/webcommands/WebCommand;)V
    .locals 0

    .prologue
    .line 720
    iput-object p1, p0, Lcom/poshmark/webcommands/WebCommandsManager$12;->this$0:Lcom/poshmark/webcommands/WebCommandsManager;

    iput-object p2, p0, Lcom/poshmark/webcommands/WebCommandsManager$12;->val$offerId:Ljava/lang/String;

    iput-object p3, p0, Lcom/poshmark/webcommands/WebCommandsManager$12;->val$command:Lcom/poshmark/webcommands/WebCommand;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public runOnUIThread(Ljava/lang/Object;)V
    .locals 3
    .param p1, "data"    # Ljava/lang/Object;

    .prologue
    .line 723
    iget-object v0, p0, Lcom/poshmark/webcommands/WebCommandsManager$12;->this$0:Lcom/poshmark/webcommands/WebCommandsManager;

    iget-object v0, v0, Lcom/poshmark/webcommands/WebCommandsManager;->fragment:Lcom/poshmark/ui/fragments/MappPageFragment;

    iget-object v1, p0, Lcom/poshmark/webcommands/WebCommandsManager$12;->this$0:Lcom/poshmark/webcommands/WebCommandsManager;

    iget-object v1, v1, Lcom/poshmark/webcommands/WebCommandsManager;->fragment:Lcom/poshmark/ui/fragments/MappPageFragment;

    const v2, 0x7f060191

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/fragments/MappPageFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/MappPageFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 724
    iget-object v0, p0, Lcom/poshmark/webcommands/WebCommandsManager$12;->val$offerId:Ljava/lang/String;

    const/4 v1, 0x0

    new-instance v2, Lcom/poshmark/webcommands/WebCommandsManager$12$1;

    invoke-direct {v2, p0}, Lcom/poshmark/webcommands/WebCommandsManager$12$1;-><init>(Lcom/poshmark/webcommands/WebCommandsManager$12;)V

    invoke-static {v0, v1, v2}, Lcom/poshmark/http/api/PMApi;->getOffer(Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 748
    return-void
.end method
