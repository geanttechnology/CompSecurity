.class Lcom/creditcardreader/activities/CreditCardScanActivity$6;
.super Ljava/lang/Object;
.source "CreditCardScanActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/creditcardreader/activities/CreditCardScanActivity;->didStableCardRecognition()V
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
    .line 392
    iput-object p1, p0, Lcom/creditcardreader/activities/CreditCardScanActivity$6;->this$0:Lcom/creditcardreader/activities/CreditCardScanActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 396
    :try_start_0
    iget-object v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity$6;->this$0:Lcom/creditcardreader/activities/CreditCardScanActivity;

    # getter for: Lcom/creditcardreader/activities/CreditCardScanActivity;->mTimeToScan:J
    invoke-static {v0}, Lcom/creditcardreader/activities/CreditCardScanActivity;->access$500(Lcom/creditcardreader/activities/CreditCardScanActivity;)J

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Thread;->sleep(J)V

    .line 400
    iget-object v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity$6;->this$0:Lcom/creditcardreader/activities/CreditCardScanActivity;

    # getter for: Lcom/creditcardreader/activities/CreditCardScanActivity;->mCameraPreview:Lcom/creditcardreader/camera/CreditCardCameraPreview;
    invoke-static {v0}, Lcom/creditcardreader/activities/CreditCardScanActivity;->access$200(Lcom/creditcardreader/activities/CreditCardScanActivity;)Lcom/creditcardreader/camera/CreditCardCameraPreview;

    move-result-object v0

    invoke-virtual {v0}, Lcom/creditcardreader/camera/CreditCardCameraPreview;->isScanning()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity$6;->this$0:Lcom/creditcardreader/activities/CreditCardScanActivity;

    # getter for: Lcom/creditcardreader/activities/CreditCardScanActivity;->mDialogShown:Z
    invoke-static {v0}, Lcom/creditcardreader/activities/CreditCardScanActivity;->access$600(Lcom/creditcardreader/activities/CreditCardScanActivity;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 401
    iget-object v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity$6;->this$0:Lcom/creditcardreader/activities/CreditCardScanActivity;

    # invokes: Lcom/creditcardreader/activities/CreditCardScanActivity;->showUnreadableDialog()V
    invoke-static {v0}, Lcom/creditcardreader/activities/CreditCardScanActivity;->access$700(Lcom/creditcardreader/activities/CreditCardScanActivity;)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 405
    :cond_0
    :goto_0
    return-void

    .line 403
    :catch_0
    move-exception v0

    goto :goto_0
.end method
