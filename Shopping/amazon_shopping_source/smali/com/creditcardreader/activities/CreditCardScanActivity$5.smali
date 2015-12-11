.class Lcom/creditcardreader/activities/CreditCardScanActivity$5;
.super Ljava/lang/Object;
.source "CreditCardScanActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/creditcardreader/activities/CreditCardScanActivity;->initCardDetectionRegion(Ljava/util/List;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/creditcardreader/activities/CreditCardScanActivity;

.field final synthetic val$bounds:Ljava/util/List;


# direct methods
.method constructor <init>(Lcom/creditcardreader/activities/CreditCardScanActivity;Ljava/util/List;)V
    .locals 0

    .prologue
    .line 369
    iput-object p1, p0, Lcom/creditcardreader/activities/CreditCardScanActivity$5;->this$0:Lcom/creditcardreader/activities/CreditCardScanActivity;

    iput-object p2, p0, Lcom/creditcardreader/activities/CreditCardScanActivity$5;->val$bounds:Ljava/util/List;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 372
    iget-object v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity$5;->this$0:Lcom/creditcardreader/activities/CreditCardScanActivity;

    # getter for: Lcom/creditcardreader/activities/CreditCardScanActivity;->mCameraPreview:Lcom/creditcardreader/camera/CreditCardCameraPreview;
    invoke-static {v0}, Lcom/creditcardreader/activities/CreditCardScanActivity;->access$200(Lcom/creditcardreader/activities/CreditCardScanActivity;)Lcom/creditcardreader/camera/CreditCardCameraPreview;

    move-result-object v0

    iget-object v1, p0, Lcom/creditcardreader/activities/CreditCardScanActivity$5;->val$bounds:Ljava/util/List;

    invoke-virtual {v0, v1}, Lcom/creditcardreader/camera/CreditCardCameraPreview;->setBounds(Ljava/util/List;)V

    .line 373
    return-void
.end method
