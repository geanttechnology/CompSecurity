.class Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity$1;
.super Ljava/lang/Object;
.source "CreditCardReaderActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->initCamera()V
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
    .line 353
    iput-object p1, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity$1;->this$0:Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 357
    iget-object v0, p0, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity$1;->this$0:Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;

    invoke-virtual {v0}, Lcom/a9/creditcardreaderlibrary/CreditCardReaderActivity;->handleClickOnCameraPreview()V

    .line 358
    return-void
.end method
