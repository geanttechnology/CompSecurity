.class Lcom/creditcardreader/activities/CreditCardScanActivity$2;
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


# direct methods
.method constructor <init>(Lcom/creditcardreader/activities/CreditCardScanActivity;)V
    .locals 0

    .prologue
    .line 305
    iput-object p1, p0, Lcom/creditcardreader/activities/CreditCardScanActivity$2;->this$0:Lcom/creditcardreader/activities/CreditCardScanActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 308
    iget-object v0, p0, Lcom/creditcardreader/activities/CreditCardScanActivity$2;->this$0:Lcom/creditcardreader/activities/CreditCardScanActivity;

    # getter for: Lcom/creditcardreader/activities/CreditCardScanActivity;->mCameraPreview:Lcom/creditcardreader/camera/CreditCardCameraPreview;
    invoke-static {v0}, Lcom/creditcardreader/activities/CreditCardScanActivity;->access$200(Lcom/creditcardreader/activities/CreditCardScanActivity;)Lcom/creditcardreader/camera/CreditCardCameraPreview;

    move-result-object v0

    invoke-virtual {v0}, Lcom/creditcardreader/camera/CreditCardCameraPreview;->showSuccess()V

    .line 309
    return-void
.end method
