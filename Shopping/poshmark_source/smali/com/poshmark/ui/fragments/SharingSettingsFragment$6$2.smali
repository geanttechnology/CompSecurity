.class Lcom/poshmark/ui/fragments/SharingSettingsFragment$6$2;
.super Ljava/lang/Object;
.source "SharingSettingsFragment.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/SharingSettingsFragment$6;->onClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/poshmark/ui/fragments/SharingSettingsFragment$6;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/SharingSettingsFragment$6;)V
    .locals 0

    .prologue
    .line 334
    iput-object p1, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$6$2;->this$1:Lcom/poshmark/ui/fragments/SharingSettingsFragment$6;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 3
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 337
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$6$2;->this$1:Lcom/poshmark/ui/fragments/SharingSettingsFragment$6;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$6;->this$0:Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$6$2;->this$1:Lcom/poshmark/ui/fragments/SharingSettingsFragment$6;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/SharingSettingsFragment$6;->this$0:Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    const v2, 0x7f0602ad

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 338
    const-string v0, "gp"

    new-instance v1, Lcom/poshmark/ui/fragments/SharingSettingsFragment$6$2$1;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment$6$2$1;-><init>(Lcom/poshmark/ui/fragments/SharingSettingsFragment$6$2;)V

    invoke-static {v0, v1}, Lcom/poshmark/http/api/PMApi;->unlinkExternalService(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 348
    return-void
.end method
