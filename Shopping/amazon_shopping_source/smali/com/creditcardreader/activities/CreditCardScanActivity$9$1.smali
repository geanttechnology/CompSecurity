.class Lcom/creditcardreader/activities/CreditCardScanActivity$9$1;
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
    .line 494
    iput-object p1, p0, Lcom/creditcardreader/activities/CreditCardScanActivity$9$1;->this$1:Lcom/creditcardreader/activities/CreditCardScanActivity$9;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 1
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 496
    iget-object v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity$9$1;->this$1:Lcom/creditcardreader/activities/CreditCardScanActivity$9;

    iget-object v0, v0, Lcom/creditcardreader/activities/CreditCardScanActivity$9;->this$0:Lcom/creditcardreader/activities/CreditCardScanActivity;

    # invokes: Lcom/creditcardreader/activities/CreditCardScanActivity;->setRescan()V
    invoke-static {v0}, Lcom/creditcardreader/activities/CreditCardScanActivity;->access$1100(Lcom/creditcardreader/activities/CreditCardScanActivity;)V

    .line 497
    return-void
.end method
