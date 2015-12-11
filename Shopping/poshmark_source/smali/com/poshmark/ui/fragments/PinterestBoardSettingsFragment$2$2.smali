.class Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment$2$2;
.super Ljava/lang/Object;
.source "PinterestBoardSettingsFragment.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment$2;->onClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment$2;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment$2;)V
    .locals 0

    .prologue
    .line 187
    iput-object p1, p0, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment$2$2;->this$1:Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment$2;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 3
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 190
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment$2$2;->this$1:Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment$2;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment$2;->this$0:Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment$2$2;->this$1:Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment$2;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment$2;->this$0:Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;

    const v2, 0x7f060190

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 191
    const-string v0, "pn"

    new-instance v1, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment$2$2$1;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment$2$2$1;-><init>(Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment$2$2;)V

    invoke-static {v0, v1}, Lcom/poshmark/http/api/PMApi;->unlinkExternalService(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 204
    return-void
.end method
