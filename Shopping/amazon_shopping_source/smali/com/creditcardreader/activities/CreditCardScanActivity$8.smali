.class Lcom/creditcardreader/activities/CreditCardScanActivity$8;
.super Ljava/lang/Object;
.source "CreditCardScanActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/creditcardreader/activities/CreditCardScanActivity;->setTorchButton()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field flashOn:Z

.field final synthetic this$0:Lcom/creditcardreader/activities/CreditCardScanActivity;

.field final synthetic val$torchButton:Landroid/widget/ImageButton;


# direct methods
.method constructor <init>(Lcom/creditcardreader/activities/CreditCardScanActivity;Landroid/widget/ImageButton;)V
    .locals 1

    .prologue
    .line 451
    iput-object p1, p0, Lcom/creditcardreader/activities/CreditCardScanActivity$8;->this$0:Lcom/creditcardreader/activities/CreditCardScanActivity;

    iput-object p2, p0, Lcom/creditcardreader/activities/CreditCardScanActivity$8;->val$torchButton:Landroid/widget/ImageButton;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 452
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity$8;->flashOn:Z

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 455
    iget-boolean v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity$8;->flashOn:Z

    if-eqz v0, :cond_0

    .line 456
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity$8;->flashOn:Z

    .line 457
    iget-object v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity$8;->val$torchButton:Landroid/widget/ImageButton;

    sget v1, Lcom/creditcardreader/R$drawable;->cc_scan_flash:I

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setImageResource(I)V

    .line 458
    iget-object v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity$8;->this$0:Lcom/creditcardreader/activities/CreditCardScanActivity;

    # invokes: Lcom/creditcardreader/activities/CreditCardScanActivity;->handleTorchOff()V
    invoke-static {v0}, Lcom/creditcardreader/activities/CreditCardScanActivity;->access$900(Lcom/creditcardreader/activities/CreditCardScanActivity;)V

    .line 464
    :goto_0
    return-void

    .line 460
    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity$8;->flashOn:Z

    .line 461
    iget-object v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity$8;->val$torchButton:Landroid/widget/ImageButton;

    sget v1, Lcom/creditcardreader/R$drawable;->cc_scan_flash_on:I

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setImageResource(I)V

    .line 462
    iget-object v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity$8;->this$0:Lcom/creditcardreader/activities/CreditCardScanActivity;

    # invokes: Lcom/creditcardreader/activities/CreditCardScanActivity;->handleTorchOn()V
    invoke-static {v0}, Lcom/creditcardreader/activities/CreditCardScanActivity;->access$1000(Lcom/creditcardreader/activities/CreditCardScanActivity;)V

    goto :goto_0
.end method
