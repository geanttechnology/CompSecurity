.class public Lcom/comcast/cim/android/view/settings/ExternalLinkPromptActivity;
.super Lcom/comcast/cim/android/view/common/BaseActivity;
.source "ExternalLinkPromptActivity.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Lcom/comcast/cim/android/view/common/BaseActivity;-><init>()V

    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 8
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 21
    invoke-super {p0, p1}, Lcom/comcast/cim/android/view/common/BaseActivity;->onCreate(Landroid/os/Bundle;)V

    .line 23
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/settings/ExternalLinkPromptActivity;->getIntent()Landroid/content/Intent;

    move-result-object v5

    invoke-virtual {v5}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v5

    const-string v6, "url"

    invoke-virtual {v5, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 24
    .local v4, "url":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/settings/ExternalLinkPromptActivity;->getIntent()Landroid/content/Intent;

    move-result-object v5

    invoke-virtual {v5}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v5

    const-string v6, "title"

    invoke-virtual {v5, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 26
    .local v3, "title":Ljava/lang/String;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 27
    .local v0, "args":Landroid/os/Bundle;
    const-string v5, "title"

    invoke-virtual {v0, v5, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 28
    const-string v5, "description"

    sget v6, Lcom/comcast/cim/android/R$string;->alert_launch_another_application:I

    invoke-virtual {p0, v6}, Lcom/comcast/cim/android/view/settings/ExternalLinkPromptActivity;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v0, v5, v6}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 30
    const-string v5, "inputPromptDlg"

    invoke-static {v5}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->newInstance(Ljava/lang/String;)Lcom/comcast/cim/android/view/common/CALDialogFragment;

    move-result-object v2

    .line 31
    .local v2, "dialog":Lcom/comcast/cim/android/view/common/CALDialogFragment;
    invoke-virtual {v2, v0}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->addArguments(Landroid/os/Bundle;)V

    .line 33
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 34
    .local v1, "buttonList":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;>;"
    new-instance v5, Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;

    sget v6, Lcom/comcast/cim/android/R$string;->dlg_btn_ok:I

    invoke-virtual {p0, v6}, Lcom/comcast/cim/android/view/settings/ExternalLinkPromptActivity;->getString(I)Ljava/lang/String;

    move-result-object v6

    new-instance v7, Lcom/comcast/cim/android/view/settings/ExternalLinkPromptActivity$1;

    invoke-direct {v7, p0, v4}, Lcom/comcast/cim/android/view/settings/ExternalLinkPromptActivity$1;-><init>(Lcom/comcast/cim/android/view/settings/ExternalLinkPromptActivity;Ljava/lang/String;)V

    invoke-direct {v5, v6, v7}, Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;-><init>(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)V

    invoke-interface {v1, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 44
    new-instance v5, Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;

    invoke-virtual {p0}, Lcom/comcast/cim/android/view/settings/ExternalLinkPromptActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    sget v7, Lcom/comcast/cim/android/R$string;->dlg_btn_cancel:I

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v6

    new-instance v7, Lcom/comcast/cim/android/view/settings/ExternalLinkPromptActivity$2;

    invoke-direct {v7, p0}, Lcom/comcast/cim/android/view/settings/ExternalLinkPromptActivity$2;-><init>(Lcom/comcast/cim/android/view/settings/ExternalLinkPromptActivity;)V

    invoke-direct {v5, v6, v7}, Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;-><init>(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)V

    invoke-interface {v1, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 51
    invoke-virtual {v2, v1}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->setButtonList(Ljava/util/List;)V

    .line 52
    new-instance v5, Lcom/comcast/cim/android/view/settings/ExternalLinkPromptActivity$3;

    invoke-direct {v5, p0}, Lcom/comcast/cim/android/view/settings/ExternalLinkPromptActivity$3;-><init>(Lcom/comcast/cim/android/view/settings/ExternalLinkPromptActivity;)V

    invoke-virtual {v2, v5}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)V

    .line 58
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/settings/ExternalLinkPromptActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v5

    const-string v6, "caldialogfragment"

    invoke-virtual {v2, v5, v6}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->show(Landroid/app/FragmentManager;Ljava/lang/String;)V

    .line 59
    return-void
.end method
