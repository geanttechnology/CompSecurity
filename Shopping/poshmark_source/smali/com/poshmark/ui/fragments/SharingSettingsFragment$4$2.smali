.class Lcom/poshmark/ui/fragments/SharingSettingsFragment$4$2;
.super Ljava/lang/Object;
.source "SharingSettingsFragment.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/SharingSettingsFragment$4;->onClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/poshmark/ui/fragments/SharingSettingsFragment$4;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/SharingSettingsFragment$4;)V
    .locals 0

    .prologue
    .line 232
    iput-object p1, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$4$2;->this$1:Lcom/poshmark/ui/fragments/SharingSettingsFragment$4;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 2
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 235
    const-string v0, "tw"

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/poshmark/http/api/PMApi;->unlinkExternalService(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 236
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/application/PMApplicationSession;->clearTwitterInfo()V

    .line 237
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$4$2;->this$1:Lcom/poshmark/ui/fragments/SharingSettingsFragment$4;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$4;->this$0:Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    # invokes: Lcom/poshmark/ui/fragments/SharingSettingsFragment;->updateTwitterShareLayout()V
    invoke-static {v0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->access$500(Lcom/poshmark/ui/fragments/SharingSettingsFragment;)V

    .line 238
    return-void
.end method
