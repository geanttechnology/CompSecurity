.class Lcom/creditcardreader/activities/CreditCardScanActivity$7;
.super Ljava/lang/Object;
.source "CreditCardScanActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/creditcardreader/activities/CreditCardScanActivity;->setHelpButton()V
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
    .line 429
    iput-object p1, p0, Lcom/creditcardreader/activities/CreditCardScanActivity$7;->this$0:Lcom/creditcardreader/activities/CreditCardScanActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 432
    iget-object v2, p0, Lcom/creditcardreader/activities/CreditCardScanActivity$7;->this$0:Lcom/creditcardreader/activities/CreditCardScanActivity;

    # getter for: Lcom/creditcardreader/activities/CreditCardScanActivity;->mMetricsRecorder:Lcom/creditcardreader/metrics/CreditCardMetricsRecorder;
    invoke-static {v2}, Lcom/creditcardreader/activities/CreditCardScanActivity;->access$800(Lcom/creditcardreader/activities/CreditCardScanActivity;)Lcom/creditcardreader/metrics/CreditCardMetricsRecorder;

    move-result-object v2

    invoke-virtual {v2}, Lcom/creditcardreader/metrics/CreditCardMetricsRecorder;->recordHelp()V

    .line 434
    iget-object v2, p0, Lcom/creditcardreader/activities/CreditCardScanActivity$7;->this$0:Lcom/creditcardreader/activities/CreditCardScanActivity;

    sget v3, Lcom/creditcardreader/R$string;->cc_scan_help_page_us:I

    invoke-virtual {v2, v3}, Lcom/creditcardreader/activities/CreditCardScanActivity;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 435
    .local v1, "uri":Landroid/net/Uri;
    new-instance v0, Landroid/content/Intent;

    const-string/jumbo v2, "android.intent.action.VIEW"

    invoke-direct {v0, v2, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 436
    .local v0, "intent":Landroid/content/Intent;
    iget-object v2, p0, Lcom/creditcardreader/activities/CreditCardScanActivity$7;->this$0:Lcom/creditcardreader/activities/CreditCardScanActivity;

    invoke-virtual {v2, v0}, Lcom/creditcardreader/activities/CreditCardScanActivity;->startActivity(Landroid/content/Intent;)V

    .line 437
    return-void
.end method
