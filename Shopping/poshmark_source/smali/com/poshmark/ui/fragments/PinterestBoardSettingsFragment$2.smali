.class Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment$2;
.super Ljava/lang/Object;
.source "PinterestBoardSettingsFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;)V
    .locals 0

    .prologue
    .line 160
    iput-object p1, p0, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment$2;->this$0:Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 10
    .param p1, "view"    # Landroid/view/View;

    .prologue
    const v4, 0x7f0602a6

    const/4 v9, 0x2

    const/4 v5, 0x1

    .line 164
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 210
    :goto_0
    return-void

    .line 166
    :pswitch_0
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 167
    .local v1, "b":Landroid/os/Bundle;
    const-string v0, "mode"

    invoke-virtual {v1, v0, v5}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 168
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment$2;->this$0:Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;->getParentActivity()Lcom/poshmark/ui/PMActivity;

    move-result-object v0

    const-class v2, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment$2;->this$0:Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;

    iget-object v3, v3, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;->pins:Lcom/poshmark/utils/meta_data/PinterestSettings;

    iget-object v4, p0, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment$2;->this$0:Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;

    invoke-virtual/range {v0 .. v5}, Lcom/poshmark/ui/PMActivity;->launchFragmentForResult(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;Lcom/poshmark/ui/fragments/PMFragment;I)V

    goto :goto_0

    .line 171
    .end local v1    # "b":Landroid/os/Bundle;
    :pswitch_1
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 172
    .restart local v1    # "b":Landroid/os/Bundle;
    const-string v0, "mode"

    invoke-virtual {v1, v0, v9}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 173
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment$2;->this$0:Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;->getParentActivity()Lcom/poshmark/ui/PMActivity;

    move-result-object v0

    const-class v2, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment$2;->this$0:Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;

    iget-object v3, v3, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;->pins:Lcom/poshmark/utils/meta_data/PinterestSettings;

    iget-object v4, p0, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment$2;->this$0:Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;

    move v5, v9

    invoke-virtual/range {v0 .. v5}, Lcom/poshmark/ui/PMActivity;->launchFragmentForResult(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;Lcom/poshmark/ui/fragments/PMFragment;I)V

    goto :goto_0

    .line 176
    .end local v1    # "b":Landroid/os/Bundle;
    :pswitch_2
    new-instance v7, Landroid/app/AlertDialog$Builder;

    iget-object v0, p0, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment$2;->this$0:Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-direct {v7, v0}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 177
    .local v7, "builder":Landroid/app/AlertDialog$Builder;
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment$2;->this$0:Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;

    invoke-virtual {v2, v4}, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "?"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v7, v0}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 178
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment$2;->this$0:Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;

    const v2, 0x7f0602aa

    invoke-virtual {v0, v2}, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v8

    .line 179
    .local v8, "msg":Ljava/lang/String;
    new-array v0, v5, [Ljava/lang/Object;

    const/4 v2, 0x0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/application/PMApplicationSession;->getTwitterUsername()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v0, v2

    invoke-static {v8, v0}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    .line 180
    invoke-virtual {v7, v8}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 181
    const v0, 0x7f06006d

    new-instance v2, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment$2$1;

    invoke-direct {v2, p0}, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment$2$1;-><init>(Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment$2;)V

    invoke-virtual {v7, v0, v2}, Landroid/app/AlertDialog$Builder;->setNegativeButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 187
    new-instance v0, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment$2$2;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment$2$2;-><init>(Lcom/poshmark/ui/fragments/PinterestBoardSettingsFragment$2;)V

    invoke-virtual {v7, v4, v0}, Landroid/app/AlertDialog$Builder;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 206
    invoke-virtual {v7}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v6

    .line 207
    .local v6, "alert":Landroid/app/AlertDialog;
    invoke-virtual {v6}, Landroid/app/AlertDialog;->show()V

    goto/16 :goto_0

    .line 164
    :pswitch_data_0
    .packed-switch 0x7f0c0264
        :pswitch_1
        :pswitch_0
        :pswitch_2
    .end packed-switch
.end method
