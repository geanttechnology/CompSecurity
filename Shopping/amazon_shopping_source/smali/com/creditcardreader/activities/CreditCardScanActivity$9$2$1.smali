.class Lcom/creditcardreader/activities/CreditCardScanActivity$9$2$1;
.super Ljava/lang/Object;
.source "CreditCardScanActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/creditcardreader/activities/CreditCardScanActivity$9$2;->onClick(Landroid/content/DialogInterface;I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$2:Lcom/creditcardreader/activities/CreditCardScanActivity$9$2;


# direct methods
.method constructor <init>(Lcom/creditcardreader/activities/CreditCardScanActivity$9$2;)V
    .locals 0

    .prologue
    .line 509
    iput-object p1, p0, Lcom/creditcardreader/activities/CreditCardScanActivity$9$2$1;->this$2:Lcom/creditcardreader/activities/CreditCardScanActivity$9$2;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 512
    iget-object v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity$9$2$1;->this$2:Lcom/creditcardreader/activities/CreditCardScanActivity$9$2;

    iget-object v0, v0, Lcom/creditcardreader/activities/CreditCardScanActivity$9$2;->this$1:Lcom/creditcardreader/activities/CreditCardScanActivity$9;

    iget-object v0, v0, Lcom/creditcardreader/activities/CreditCardScanActivity$9;->this$0:Lcom/creditcardreader/activities/CreditCardScanActivity;

    const/4 v1, 0x0

    new-instance v2, Landroid/content/Intent;

    invoke-direct {v2}, Landroid/content/Intent;-><init>()V

    invoke-virtual {v0, v1, v2}, Lcom/creditcardreader/activities/CreditCardScanActivity;->setResult(ILandroid/content/Intent;)V

    .line 513
    iget-object v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity$9$2$1;->this$2:Lcom/creditcardreader/activities/CreditCardScanActivity$9$2;

    iget-object v0, v0, Lcom/creditcardreader/activities/CreditCardScanActivity$9$2;->this$1:Lcom/creditcardreader/activities/CreditCardScanActivity$9;

    iget-object v0, v0, Lcom/creditcardreader/activities/CreditCardScanActivity$9;->this$0:Lcom/creditcardreader/activities/CreditCardScanActivity;

    invoke-virtual {v0}, Lcom/creditcardreader/activities/CreditCardScanActivity;->finish()V

    .line 514
    return-void
.end method
