.class Lcom/poshmark/ui/fragments/SharingSettingsFragment$4;
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
    .line 217
    iput-object p1, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$4;->this$0:Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 7
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const v6, 0x7f0602a6

    .line 220
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/application/PMApplicationSession;->getTwitterToken()Ljava/lang/String;

    move-result-object v3

    if-eqz v3, :cond_0

    .line 221
    new-instance v1, Landroid/app/AlertDialog$Builder;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$4;->this$0:Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-direct {v1, v3}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 222
    .local v1, "builder":Landroid/app/AlertDialog$Builder;
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$4;->this$0:Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    invoke-virtual {v4, v6}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "?"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 223
    iget-object v3, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$4;->this$0:Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    const v4, 0x7f0602ac

    invoke-virtual {v3, v4}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 224
    .local v2, "msg":Ljava/lang/String;
    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getTwitterUsername()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    .line 225
    invoke-virtual {v1, v2}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 226
    const v3, 0x7f06006d

    new-instance v4, Lcom/poshmark/ui/fragments/SharingSettingsFragment$4$1;

    invoke-direct {v4, p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment$4$1;-><init>(Lcom/poshmark/ui/fragments/SharingSettingsFragment$4;)V

    invoke-virtual {v1, v3, v4}, Landroid/app/AlertDialog$Builder;->setNegativeButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 232
    new-instance v3, Lcom/poshmark/ui/fragments/SharingSettingsFragment$4$2;

    invoke-direct {v3, p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment$4$2;-><init>(Lcom/poshmark/ui/fragments/SharingSettingsFragment$4;)V

    invoke-virtual {v1, v6, v3}, Landroid/app/AlertDialog$Builder;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 241
    invoke-virtual {v1}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    .line 242
    .local v0, "alert":Landroid/app/AlertDialog;
    invoke-virtual {v0}, Landroid/app/AlertDialog;->show()V

    .line 266
    .end local v0    # "alert":Landroid/app/AlertDialog;
    .end local v1    # "builder":Landroid/app/AlertDialog$Builder;
    .end local v2    # "msg":Ljava/lang/String;
    :goto_0
    return-void

    .line 245
    :cond_0
    iget-object v3, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$4;->this$0:Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    iget-object v4, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$4;->this$0:Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    const v5, 0x7f060190

    invoke-virtual {v4, v5}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 246
    invoke-static {}, Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;->getGlobalConnectManager()Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;

    move-result-object v3

    iget-object v4, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$4;->this$0:Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    new-instance v5, Lcom/poshmark/ui/fragments/SharingSettingsFragment$4$3;

    invoke-direct {v5, p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment$4$3;-><init>(Lcom/poshmark/ui/fragments/SharingSettingsFragment$4;)V

    invoke-virtual {v3, v4, v5}, Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;->twitterLink(Ljava/lang/Object;Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;)V

    goto :goto_0
.end method
