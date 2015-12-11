.class Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity$2;
.super Ljava/lang/Object;
.source "CreditCardReaderActivity.java"

# interfaces
.implements Lcom/a9/creditcardreaderlibrary/CreditCardDelegate$CreditCardCallbackInterface;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->initCreditCardReader()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;


# direct methods
.method constructor <init>(Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;)V
    .locals 0

    .prologue
    .line 394
    iput-object p1, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity$2;->this$0:Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onDetectedCardLines(I)V
    .locals 4
    .param p1, "detectedCardLines"    # I

    .prologue
    .line 404
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 405
    .local v0, "edges":Ljava/util/List;, "Ljava/util/List<Landroid/util/Pair<Landroid/graphics/Point;Landroid/graphics/Point;>;>;"
    and-int/lit8 v1, p1, 0x1

    if-lez v1, :cond_0

    .line 407
    new-instance v1, Landroid/util/Pair;

    iget-object v2, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity$2;->this$0:Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;

    # getter for: Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_topLeft:Landroid/graphics/Point;
    invoke-static {v2}, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->access$100(Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;)Landroid/graphics/Point;

    move-result-object v2

    iget-object v3, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity$2;->this$0:Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;

    # getter for: Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_topRight:Landroid/graphics/Point;
    invoke-static {v3}, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->access$200(Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;)Landroid/graphics/Point;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Landroid/util/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 409
    :cond_0
    and-int/lit8 v1, p1, 0x2

    if-lez v1, :cond_1

    .line 411
    new-instance v1, Landroid/util/Pair;

    iget-object v2, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity$2;->this$0:Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;

    # getter for: Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_bottomLeft:Landroid/graphics/Point;
    invoke-static {v2}, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->access$300(Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;)Landroid/graphics/Point;

    move-result-object v2

    iget-object v3, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity$2;->this$0:Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;

    # getter for: Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_topLeft:Landroid/graphics/Point;
    invoke-static {v3}, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->access$100(Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;)Landroid/graphics/Point;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Landroid/util/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 413
    :cond_1
    and-int/lit8 v1, p1, 0x4

    if-lez v1, :cond_2

    .line 415
    new-instance v1, Landroid/util/Pair;

    iget-object v2, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity$2;->this$0:Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;

    # getter for: Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_bottomRight:Landroid/graphics/Point;
    invoke-static {v2}, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->access$400(Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;)Landroid/graphics/Point;

    move-result-object v2

    iget-object v3, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity$2;->this$0:Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;

    # getter for: Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_bottomLeft:Landroid/graphics/Point;
    invoke-static {v3}, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->access$300(Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;)Landroid/graphics/Point;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Landroid/util/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 417
    :cond_2
    and-int/lit8 v1, p1, 0x8

    if-lez v1, :cond_3

    .line 419
    new-instance v1, Landroid/util/Pair;

    iget-object v2, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity$2;->this$0:Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;

    # getter for: Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_topRight:Landroid/graphics/Point;
    invoke-static {v2}, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->access$200(Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;)Landroid/graphics/Point;

    move-result-object v2

    iget-object v3, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity$2;->this$0:Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;

    # getter for: Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->m_bottomRight:Landroid/graphics/Point;
    invoke-static {v3}, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->access$400(Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;)Landroid/graphics/Point;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Landroid/util/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 421
    :cond_3
    iget-object v1, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity$2;->this$0:Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;

    invoke-virtual {v1, v0}, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->didDetectGoodEdges(Ljava/util/List;)V

    .line 422
    return-void
.end method

.method public onPromisingCardDetection()V
    .locals 1

    .prologue
    .line 431
    iget-object v0, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity$2;->this$0:Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;

    invoke-virtual {v0}, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->didPromisingCardRecognition()V

    .line 432
    return-void
.end method

.method public onRecognizedCreditCard(Lcom/a9/vs/mobile/library/impl/jni/CreditCardInfo;)V
    .locals 2
    .param p1, "result"    # Lcom/a9/vs/mobile/library/impl/jni/CreditCardInfo;

    .prologue
    .line 398
    iget-object v0, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity$2;->this$0:Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;

    # invokes: Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->setCreditCardRecognitionMetrics()V
    invoke-static {v0}, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->access$000(Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;)V

    .line 399
    iget-object v0, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity$2;->this$0:Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;

    new-instance v1, Lcom/a9/creditcardreaderlibrary/CreditCardResult;

    invoke-direct {v1, p1}, Lcom/a9/creditcardreaderlibrary/CreditCardResult;-><init>(Lcom/a9/vs/mobile/library/impl/jni/CreditCardInfo;)V

    invoke-virtual {v0, v1}, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->didRecognizeCreditCard(Lcom/a9/creditcardreaderlibrary/CreditCardResult;)V

    .line 400
    return-void
.end method

.method public onStabilizedCardDetection()V
    .locals 1

    .prologue
    .line 426
    iget-object v0, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity$2;->this$0:Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;

    invoke-virtual {v0}, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->didStableCardRecognition()V

    .line 427
    return-void
.end method
