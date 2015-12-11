.class Lcom/xfinity/playerlib/view/common/UpsellDialog$1;
.super Ljava/lang/Object;
.source "UpsellDialog.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/common/UpsellDialog;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/common/UpsellDialog;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/common/UpsellDialog;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/common/UpsellDialog;

    .prologue
    .line 93
    iput-object p1, p0, Lcom/xfinity/playerlib/view/common/UpsellDialog$1;->this$0:Lcom/xfinity/playerlib/view/common/UpsellDialog;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 3
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 96
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.VIEW"

    iget-object v2, p0, Lcom/xfinity/playerlib/view/common/UpsellDialog$1;->this$0:Lcom/xfinity/playerlib/view/common/UpsellDialog;

    # invokes: Lcom/xfinity/playerlib/view/common/UpsellDialog;->getUpsellUri()Landroid/net/Uri;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/common/UpsellDialog;->access$000(Lcom/xfinity/playerlib/view/common/UpsellDialog;)Landroid/net/Uri;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 97
    .local v0, "browserIntent":Landroid/content/Intent;
    iget-object v1, p0, Lcom/xfinity/playerlib/view/common/UpsellDialog$1;->this$0:Lcom/xfinity/playerlib/view/common/UpsellDialog;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/common/UpsellDialog;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    .line 98
    return-void
.end method
