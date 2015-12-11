.class Lcom/creditcardreader/activities/CreditCardScanActivity$3;
.super Ljava/lang/Object;
.source "CreditCardScanActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/creditcardreader/activities/CreditCardScanActivity;->didRecognizeCreditCard(Lcom/a9/creditcardreaderlibrary/CreditCardResult;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/creditcardreader/activities/CreditCardScanActivity;

.field final synthetic val$result:Lcom/a9/creditcardreaderlibrary/CreditCardResult;


# direct methods
.method constructor <init>(Lcom/creditcardreader/activities/CreditCardScanActivity;Lcom/a9/creditcardreaderlibrary/CreditCardResult;)V
    .locals 0

    .prologue
    .line 313
    iput-object p1, p0, Lcom/creditcardreader/activities/CreditCardScanActivity$3;->this$0:Lcom/creditcardreader/activities/CreditCardScanActivity;

    iput-object p2, p0, Lcom/creditcardreader/activities/CreditCardScanActivity$3;->val$result:Lcom/a9/creditcardreaderlibrary/CreditCardResult;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 316
    iget-object v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity$3;->this$0:Lcom/creditcardreader/activities/CreditCardScanActivity;

    const/4 v1, 0x1

    # setter for: Lcom/creditcardreader/activities/CreditCardScanActivity;->mForegroundExit:Z
    invoke-static {v0, v1}, Lcom/creditcardreader/activities/CreditCardScanActivity;->access$302(Lcom/creditcardreader/activities/CreditCardScanActivity;Z)Z

    .line 317
    iget-object v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity$3;->this$0:Lcom/creditcardreader/activities/CreditCardScanActivity;

    const/4 v1, 0x0

    # setter for: Lcom/creditcardreader/activities/CreditCardScanActivity;->mCancelExit:Z
    invoke-static {v0, v1}, Lcom/creditcardreader/activities/CreditCardScanActivity;->access$402(Lcom/creditcardreader/activities/CreditCardScanActivity;Z)Z

    .line 318
    iget-object v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity$3;->this$0:Lcom/creditcardreader/activities/CreditCardScanActivity;

    const/4 v1, -0x1

    iget-object v2, p0, Lcom/creditcardreader/activities/CreditCardScanActivity$3;->val$result:Lcom/a9/creditcardreaderlibrary/CreditCardResult;

    invoke-static {v2}, Lcom/creditcardreader/utils/CreditCardUtils;->createSuccessIntent(Lcom/a9/creditcardreaderlibrary/CreditCardResult;)Landroid/content/Intent;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/creditcardreader/activities/CreditCardScanActivity;->setResult(ILandroid/content/Intent;)V

    .line 320
    iget-object v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity$3;->this$0:Lcom/creditcardreader/activities/CreditCardScanActivity;

    invoke-virtual {v0}, Lcom/creditcardreader/activities/CreditCardScanActivity;->finish()V

    .line 321
    return-void
.end method
