.class Lcom/poshmark/webcommands/WebCommandsManager$6;
.super Ljava/lang/Object;
.source "WebCommandsManager.java"

# interfaces
.implements Lcom/poshmark/utils/UIThreadTask$Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/webcommands/WebCommandsManager;->showHUDForWebView(Lcom/poshmark/webcommands/WebCommand;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/webcommands/WebCommandsManager;

.field final synthetic val$disableNavigation:Z

.field final synthetic val$message:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/poshmark/webcommands/WebCommandsManager;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 467
    iput-object p1, p0, Lcom/poshmark/webcommands/WebCommandsManager$6;->this$0:Lcom/poshmark/webcommands/WebCommandsManager;

    iput-object p2, p0, Lcom/poshmark/webcommands/WebCommandsManager$6;->val$message:Ljava/lang/String;

    iput-boolean p3, p0, Lcom/poshmark/webcommands/WebCommandsManager$6;->val$disableNavigation:Z

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public runOnUIThread(Ljava/lang/Object;)V
    .locals 3
    .param p1, "data"    # Ljava/lang/Object;

    .prologue
    .line 470
    iget-object v0, p0, Lcom/poshmark/webcommands/WebCommandsManager$6;->this$0:Lcom/poshmark/webcommands/WebCommandsManager;

    iget-object v0, v0, Lcom/poshmark/webcommands/WebCommandsManager;->fragment:Lcom/poshmark/ui/fragments/MappPageFragment;

    iget-object v1, p0, Lcom/poshmark/webcommands/WebCommandsManager$6;->val$message:Ljava/lang/String;

    iget-boolean v2, p0, Lcom/poshmark/webcommands/WebCommandsManager$6;->val$disableNavigation:Z

    invoke-virtual {v0, v1, v2}, Lcom/poshmark/ui/fragments/MappPageFragment;->showProgressDialogWithMessage(Ljava/lang/String;Z)V

    .line 471
    return-void
.end method
