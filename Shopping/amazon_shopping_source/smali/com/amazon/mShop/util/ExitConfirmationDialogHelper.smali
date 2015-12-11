.class public Lcom/amazon/mShop/util/ExitConfirmationDialogHelper;
.super Ljava/lang/Object;
.source "ExitConfirmationDialogHelper.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static create(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/mShop/AmazonAlertDialog;
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "refMarkerOK"    # Ljava/lang/String;
    .param p2, "refMarkerCancel"    # Ljava/lang/String;

    .prologue
    .line 15
    new-instance v1, Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;-><init>(Landroid/content/Context;)V

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->exit_confirmation_dialog_title:I

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setTitle(I)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->exit_confirmation_dialog_message:I

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setMessage(I)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->alert_cancel_button:I

    new-instance v3, Lcom/amazon/mShop/util/ExitConfirmationDialogHelper$3;

    invoke-direct {v3, p2}, Lcom/amazon/mShop/util/ExitConfirmationDialogHelper$3;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v2, v3}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setNegativeButton(ILandroid/content/DialogInterface$OnClickListener;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->alert_ok_button:I

    new-instance v3, Lcom/amazon/mShop/util/ExitConfirmationDialogHelper$2;

    invoke-direct {v3, p1}, Lcom/amazon/mShop/util/ExitConfirmationDialogHelper$2;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v2, v3}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    move-result-object v1

    new-instance v2, Lcom/amazon/mShop/util/ExitConfirmationDialogHelper$1;

    invoke-direct {v2, p2}, Lcom/amazon/mShop/util/ExitConfirmationDialogHelper$1;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->create()Lcom/amazon/mShop/AmazonAlertDialog;

    move-result-object v0

    .line 48
    .local v0, "exitConfirmationDialog":Lcom/amazon/mShop/AmazonAlertDialog;
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/AmazonAlertDialog;->setCanceledOnTouchOutside(Z)V

    .line 49
    return-object v0
.end method
