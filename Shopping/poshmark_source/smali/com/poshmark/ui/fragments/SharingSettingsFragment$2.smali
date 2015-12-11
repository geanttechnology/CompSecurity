.class Lcom/poshmark/ui/fragments/SharingSettingsFragment$2;
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
    .line 170
    iput-object p1, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$2;->this$0:Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 8
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const v7, 0x7f0602a6

    const/16 v6, 0x8

    .line 173
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/application/PMApplicationSession;->getFacebookToken()Ljava/lang/String;

    move-result-object v3

    if-eqz v3, :cond_0

    .line 174
    new-instance v1, Landroid/app/AlertDialog$Builder;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$2;->this$0:Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-direct {v1, v3}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 175
    .local v1, "builder":Landroid/app/AlertDialog$Builder;
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$2;->this$0:Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    invoke-virtual {v4, v7}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "?"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 176
    iget-object v3, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$2;->this$0:Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    const v4, 0x7f0602a8

    invoke-virtual {v3, v4}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 177
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

    .line 178
    invoke-virtual {v1, v2}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 179
    const v3, 0x7f06006d

    new-instance v4, Lcom/poshmark/ui/fragments/SharingSettingsFragment$2$1;

    invoke-direct {v4, p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment$2$1;-><init>(Lcom/poshmark/ui/fragments/SharingSettingsFragment$2;)V

    invoke-virtual {v1, v3, v4}, Landroid/app/AlertDialog$Builder;->setNegativeButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 185
    new-instance v3, Lcom/poshmark/ui/fragments/SharingSettingsFragment$2$2;

    invoke-direct {v3, p0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment$2$2;-><init>(Lcom/poshmark/ui/fragments/SharingSettingsFragment$2;)V

    invoke-virtual {v1, v7, v3}, Landroid/app/AlertDialog$Builder;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 196
    invoke-virtual {v1}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    .line 197
    .local v0, "alert":Landroid/app/AlertDialog;
    invoke-virtual {v0}, Landroid/app/AlertDialog;->show()V

    .line 202
    .end local v0    # "alert":Landroid/app/AlertDialog;
    .end local v1    # "builder":Landroid/app/AlertDialog$Builder;
    .end local v2    # "msg":Ljava/lang/String;
    :goto_0
    return-void

    .line 200
    :cond_0
    invoke-static {}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->getInstance()Lcom/poshmark/fb_tmblr_twitter/FbHelper;

    move-result-object v3

    iget-object v4, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$2;->this$0:Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    sget v5, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->FB_CONNECT_PUBLISH_REQUEST:I

    invoke-virtual {v3, v4, v6, v6, v5}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->link(Lcom/poshmark/ui/fragments/PMFragment;III)V

    goto :goto_0
.end method
