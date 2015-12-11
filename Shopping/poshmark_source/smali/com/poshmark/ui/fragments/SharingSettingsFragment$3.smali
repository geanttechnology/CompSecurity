.class Lcom/poshmark/ui/fragments/SharingSettingsFragment$3;
.super Ljava/lang/Object;
.source "SharingSettingsFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/fragments/SharingSettingsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/SharingSettingsFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/SharingSettingsFragment;)V
    .locals 0

    .prologue
    .line 205
    iput-object p1, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$3;->this$0:Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "view"    # Landroid/view/View;

    .prologue
    const/4 v2, 0x0

    .line 208
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/application/PMApplicationSession;->getPinterestToken()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 209
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$3;->this$0:Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->getParentActivity()Lcom/poshmark/ui/PMActivity;

    move-result-object v0

    const-class v1, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;

    invoke-virtual {v0, v2, v1, v2}, Lcom/poshmark/ui/PMActivity;->launchFragment(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 213
    :goto_0
    return-void

    .line 211
    :cond_0
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$3;->this$0:Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    # invokes: Lcom/poshmark/ui/fragments/SharingSettingsFragment;->connectToPinterest()V
    invoke-static {v0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->access$400(Lcom/poshmark/ui/fragments/SharingSettingsFragment;)V

    goto :goto_0
.end method
