.class Lcom/creditcardreader/activities/CreditCardScanActivity$9$2;
.super Ljava/lang/Object;
.source "CreditCardScanActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/creditcardreader/activities/CreditCardScanActivity$9;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/creditcardreader/activities/CreditCardScanActivity$9;


# direct methods
.method constructor <init>(Lcom/creditcardreader/activities/CreditCardScanActivity$9;)V
    .locals 0

    .prologue
    .line 504
    iput-object p1, p0, Lcom/creditcardreader/activities/CreditCardScanActivity$9$2;->this$1:Lcom/creditcardreader/activities/CreditCardScanActivity$9;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 2
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 506
    iget-object v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity$9$2;->this$1:Lcom/creditcardreader/activities/CreditCardScanActivity$9;

    iget-object v0, v0, Lcom/creditcardreader/activities/CreditCardScanActivity$9;->this$0:Lcom/creditcardreader/activities/CreditCardScanActivity;

    const/4 v1, 0x1

    # setter for: Lcom/creditcardreader/activities/CreditCardScanActivity;->mForegroundExit:Z
    invoke-static {v0, v1}, Lcom/creditcardreader/activities/CreditCardScanActivity;->access$302(Lcom/creditcardreader/activities/CreditCardScanActivity;Z)Z

    .line 507
    iget-object v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity$9$2;->this$1:Lcom/creditcardreader/activities/CreditCardScanActivity$9;

    iget-object v0, v0, Lcom/creditcardreader/activities/CreditCardScanActivity$9;->this$0:Lcom/creditcardreader/activities/CreditCardScanActivity;

    const/4 v1, 0x0

    # setter for: Lcom/creditcardreader/activities/CreditCardScanActivity;->mCancelExit:Z
    invoke-static {v0, v1}, Lcom/creditcardreader/activities/CreditCardScanActivity;->access$402(Lcom/creditcardreader/activities/CreditCardScanActivity;Z)Z

    .line 508
    iget-object v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity$9$2;->this$1:Lcom/creditcardreader/activities/CreditCardScanActivity$9;

    iget-object v0, v0, Lcom/creditcardreader/activities/CreditCardScanActivity$9;->this$0:Lcom/creditcardreader/activities/CreditCardScanActivity;

    # getter for: Lcom/creditcardreader/activities/CreditCardScanActivity;->mMetricsRecorder:Lcom/creditcardreader/metrics/CreditCardMetricsRecorder;
    invoke-static {v0}, Lcom/creditcardreader/activities/CreditCardScanActivity;->access$800(Lcom/creditcardreader/activities/CreditCardScanActivity;)Lcom/creditcardreader/metrics/CreditCardMetricsRecorder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/creditcardreader/metrics/CreditCardMetricsRecorder;->recordTimeoutCancel()V

    .line 509
    iget-object v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity$9$2;->this$1:Lcom/creditcardreader/activities/CreditCardScanActivity$9;

    iget-object v0, v0, Lcom/creditcardreader/activities/CreditCardScanActivity$9;->this$0:Lcom/creditcardreader/activities/CreditCardScanActivity;

    # getter for: Lcom/creditcardreader/activities/CreditCardScanActivity;->mHandler:Landroid/os/Handler;
    invoke-static {v0}, Lcom/creditcardreader/activities/CreditCardScanActivity;->access$1200(Lcom/creditcardreader/activities/CreditCardScanActivity;)Landroid/os/Handler;

    move-result-object v0

    new-instance v1, Lcom/creditcardreader/activities/CreditCardScanActivity$9$2$1;

    invoke-direct {v1, p0}, Lcom/creditcardreader/activities/CreditCardScanActivity$9$2$1;-><init>(Lcom/creditcardreader/activities/CreditCardScanActivity$9$2;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 516
    return-void
.end method
