.class Lcom/poshmark/webcommands/WebCommandsManager$2$1;
.super Ljava/lang/Object;
.source "WebCommandsManager.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/webcommands/WebCommandsManager$2;->runOnUIThread(Ljava/lang/Object;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/poshmark/webcommands/WebCommandsManager$2;

.field final synthetic val$okCallback:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/poshmark/webcommands/WebCommandsManager$2;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 314
    iput-object p1, p0, Lcom/poshmark/webcommands/WebCommandsManager$2$1;->this$1:Lcom/poshmark/webcommands/WebCommandsManager$2;

    iput-object p2, p0, Lcom/poshmark/webcommands/WebCommandsManager$2$1;->val$okCallback:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 3
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "id"    # I

    .prologue
    .line 316
    iget-object v0, p0, Lcom/poshmark/webcommands/WebCommandsManager$2$1;->this$1:Lcom/poshmark/webcommands/WebCommandsManager$2;

    iget-object v0, v0, Lcom/poshmark/webcommands/WebCommandsManager$2;->this$0:Lcom/poshmark/webcommands/WebCommandsManager;

    iget-object v0, v0, Lcom/poshmark/webcommands/WebCommandsManager;->fragment:Lcom/poshmark/ui/fragments/MappPageFragment;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/poshmark/webcommands/WebCommandsManager$2$1;->val$okCallback:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "()"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/MappPageFragment;->fireJSCallback(Ljava/lang/String;)V

    .line 317
    return-void
.end method
