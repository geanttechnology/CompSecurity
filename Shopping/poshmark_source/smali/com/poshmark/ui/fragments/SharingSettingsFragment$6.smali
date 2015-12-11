.class Lcom/poshmark/ui/fragments/SharingSettingsFragment$6;
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
    .line 321
    iput-object p1, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$6;->this$0:Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const v4, 0x7f0602a6

    .line 324
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/application/PMApplicationSession;->getGoogleToken()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 325
    new-instance v1, Landroid/app/AlertDialog$Builder;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$6;->this$0:Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-direct {v1, v2}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 326
    .local v1, "builder":Landroid/app/AlertDialog$Builder;
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$6;->this$0:Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    invoke-virtual {v3, v4}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "?"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 327
    iget-object v2, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$6;->this$0:Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    const v3, 0x7f0602a9

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 328
    const v2, 0x7f06006d

    new-instance v3, Lcom/poshmark/ui/fragments/SharingSettingsFragment$6$1;

    invoke-direct {v3, p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment$6$1;-><init>(Lcom/poshmark/ui/fragments/SharingSettingsFragment$6;)V

    invoke-virtual {v1, v2, v3}, Landroid/app/AlertDialog$Builder;->setNegativeButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 334
    new-instance v2, Lcom/poshmark/ui/fragments/SharingSettingsFragment$6$2;

    invoke-direct {v2, p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment$6$2;-><init>(Lcom/poshmark/ui/fragments/SharingSettingsFragment$6;)V

    invoke-virtual {v1, v4, v2}, Landroid/app/AlertDialog$Builder;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 351
    invoke-virtual {v1}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    .line 352
    .local v0, "alert":Landroid/app/AlertDialog;
    invoke-virtual {v0}, Landroid/app/AlertDialog;->show()V

    .line 376
    .end local v0    # "alert":Landroid/app/AlertDialog;
    .end local v1    # "builder":Landroid/app/AlertDialog$Builder;
    :goto_0
    return-void

    .line 354
    :cond_0
    iget-object v2, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$6;->this$0:Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$6;->this$0:Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    const v4, 0x7f060190

    invoke-virtual {v3, v4}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 355
    invoke-static {}, Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;->getGlobalConnectManager()Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$6;->this$0:Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    new-instance v4, Lcom/poshmark/ui/fragments/SharingSettingsFragment$6$3;

    invoke-direct {v4, p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment$6$3;-><init>(Lcom/poshmark/ui/fragments/SharingSettingsFragment$6;)V

    invoke-virtual {v2, v3, v4}, Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectManager;->tumblrLink(Ljava/lang/Object;Lcom/poshmark/fb_tmblr_twitter/ExtServiceConnectInterface;)V

    goto :goto_0
.end method
