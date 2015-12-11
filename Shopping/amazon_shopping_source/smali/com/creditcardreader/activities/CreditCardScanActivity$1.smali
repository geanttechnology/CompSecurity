.class Lcom/creditcardreader/activities/CreditCardScanActivity$1;
.super Landroid/os/Handler;
.source "CreditCardScanActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/creditcardreader/activities/CreditCardScanActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/creditcardreader/activities/CreditCardScanActivity;


# direct methods
.method constructor <init>(Lcom/creditcardreader/activities/CreditCardScanActivity;Landroid/os/Looper;)V
    .locals 0
    .param p2, "x0"    # Landroid/os/Looper;

    .prologue
    .line 102
    iput-object p1, p0, Lcom/creditcardreader/activities/CreditCardScanActivity$1;->this$0:Lcom/creditcardreader/activities/CreditCardScanActivity;

    invoke-direct {p0, p2}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 4
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 105
    iget v0, p1, Landroid/os/Message;->what:I

    packed-switch v0, :pswitch_data_0

    .line 111
    :goto_0
    return-void

    .line 107
    :pswitch_0
    iget-object v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity$1;->this$0:Lcom/creditcardreader/activities/CreditCardScanActivity;

    # invokes: Lcom/creditcardreader/activities/CreditCardScanActivity;->checkForFocus()V
    invoke-static {v0}, Lcom/creditcardreader/activities/CreditCardScanActivity;->access$000(Lcom/creditcardreader/activities/CreditCardScanActivity;)V

    .line 108
    iget-object v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity$1;->this$0:Lcom/creditcardreader/activities/CreditCardScanActivity;

    # getter for: Lcom/creditcardreader/activities/CreditCardScanActivity;->m_handler:Landroid/os/Handler;
    invoke-static {v0}, Lcom/creditcardreader/activities/CreditCardScanActivity;->access$100(Lcom/creditcardreader/activities/CreditCardScanActivity;)Landroid/os/Handler;

    move-result-object v0

    iget-object v1, p0, Lcom/creditcardreader/activities/CreditCardScanActivity$1;->this$0:Lcom/creditcardreader/activities/CreditCardScanActivity;

    # getter for: Lcom/creditcardreader/activities/CreditCardScanActivity;->m_handler:Landroid/os/Handler;
    invoke-static {v1}, Lcom/creditcardreader/activities/CreditCardScanActivity;->access$100(Lcom/creditcardreader/activities/CreditCardScanActivity;)Landroid/os/Handler;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Landroid/os/Handler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v1

    const-wide/16 v2, 0xbb8

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->sendMessageDelayed(Landroid/os/Message;J)Z

    goto :goto_0

    .line 105
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method
