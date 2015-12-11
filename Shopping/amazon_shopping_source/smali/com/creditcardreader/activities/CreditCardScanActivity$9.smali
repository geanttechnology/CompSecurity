.class Lcom/creditcardreader/activities/CreditCardScanActivity$9;
.super Ljava/lang/Object;
.source "CreditCardScanActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/creditcardreader/activities/CreditCardScanActivity;->showUnreadableDialog()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/creditcardreader/activities/CreditCardScanActivity;


# direct methods
.method constructor <init>(Lcom/creditcardreader/activities/CreditCardScanActivity;)V
    .locals 0

    .prologue
    .line 480
    iput-object p1, p0, Lcom/creditcardreader/activities/CreditCardScanActivity$9;->this$0:Lcom/creditcardreader/activities/CreditCardScanActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 483
    iget-object v3, p0, Lcom/creditcardreader/activities/CreditCardScanActivity$9;->this$0:Lcom/creditcardreader/activities/CreditCardScanActivity;

    # getter for: Lcom/creditcardreader/activities/CreditCardScanActivity;->mCameraPreview:Lcom/creditcardreader/camera/CreditCardCameraPreview;
    invoke-static {v3}, Lcom/creditcardreader/activities/CreditCardScanActivity;->access$200(Lcom/creditcardreader/activities/CreditCardScanActivity;)Lcom/creditcardreader/camera/CreditCardCameraPreview;

    move-result-object v3

    invoke-virtual {v3}, Lcom/creditcardreader/camera/CreditCardCameraPreview;->resetOverlay()V

    .line 484
    iget-object v3, p0, Lcom/creditcardreader/activities/CreditCardScanActivity$9;->this$0:Lcom/creditcardreader/activities/CreditCardScanActivity;

    # getter for: Lcom/creditcardreader/activities/CreditCardScanActivity;->mCameraPreview:Lcom/creditcardreader/camera/CreditCardCameraPreview;
    invoke-static {v3}, Lcom/creditcardreader/activities/CreditCardScanActivity;->access$200(Lcom/creditcardreader/activities/CreditCardScanActivity;)Lcom/creditcardreader/camera/CreditCardCameraPreview;

    move-result-object v3

    invoke-virtual {v3}, Lcom/creditcardreader/camera/CreditCardCameraPreview;->stopPreview()V

    .line 485
    new-instance v0, Landroid/app/AlertDialog$Builder;

    iget-object v3, p0, Lcom/creditcardreader/activities/CreditCardScanActivity$9;->this$0:Lcom/creditcardreader/activities/CreditCardScanActivity;

    invoke-direct {v0, v3}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 487
    .local v0, "builder":Landroid/app/AlertDialog$Builder;
    iget-object v3, p0, Lcom/creditcardreader/activities/CreditCardScanActivity$9;->this$0:Lcom/creditcardreader/activities/CreditCardScanActivity;

    invoke-virtual {v3}, Lcom/creditcardreader/activities/CreditCardScanActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/creditcardreader/R$string;->cc_scan_trouble:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 492
    iget-object v3, p0, Lcom/creditcardreader/activities/CreditCardScanActivity$9;->this$0:Lcom/creditcardreader/activities/CreditCardScanActivity;

    invoke-virtual {v3}, Lcom/creditcardreader/activities/CreditCardScanActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/creditcardreader/R$string;->cc_scan_rescan:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    new-instance v4, Lcom/creditcardreader/activities/CreditCardScanActivity$9$1;

    invoke-direct {v4, p0}, Lcom/creditcardreader/activities/CreditCardScanActivity$9$1;-><init>(Lcom/creditcardreader/activities/CreditCardScanActivity$9;)V

    invoke-virtual {v0, v3, v4}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 502
    iget-object v3, p0, Lcom/creditcardreader/activities/CreditCardScanActivity$9;->this$0:Lcom/creditcardreader/activities/CreditCardScanActivity;

    invoke-virtual {v3}, Lcom/creditcardreader/activities/CreditCardScanActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/creditcardreader/R$string;->cc_scan_manual:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    new-instance v4, Lcom/creditcardreader/activities/CreditCardScanActivity$9$2;

    invoke-direct {v4, p0}, Lcom/creditcardreader/activities/CreditCardScanActivity$9$2;-><init>(Lcom/creditcardreader/activities/CreditCardScanActivity$9;)V

    invoke-virtual {v0, v3, v4}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 520
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v1

    .line 521
    .local v1, "dialog":Landroid/app/AlertDialog;
    new-instance v3, Lcom/creditcardreader/activities/CreditCardScanActivity$9$3;

    invoke-direct {v3, p0}, Lcom/creditcardreader/activities/CreditCardScanActivity$9$3;-><init>(Lcom/creditcardreader/activities/CreditCardScanActivity$9;)V

    invoke-virtual {v1, v3}, Landroid/app/AlertDialog;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)V

    .line 527
    invoke-virtual {v1}, Landroid/app/AlertDialog;->show()V

    .line 530
    const v3, 0x102000b

    invoke-virtual {v1, v3}, Landroid/app/AlertDialog;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    .line 532
    .local v2, "messageView":Landroid/widget/TextView;
    const/16 v3, 0x11

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setGravity(I)V

    .line 533
    return-void
.end method
