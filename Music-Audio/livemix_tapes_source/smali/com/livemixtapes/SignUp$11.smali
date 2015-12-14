.class Lcom/livemixtapes/SignUp$11;
.super Ljava/lang/Object;
.source "SignUp.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/SignUp;->setListeners()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/SignUp;


# direct methods
.method constructor <init>(Lcom/livemixtapes/SignUp;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/SignUp$11;->this$0:Lcom/livemixtapes/SignUp;

    .line 331
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 334
    iget-object v0, p0, Lcom/livemixtapes/SignUp$11;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->password:Landroid/widget/EditText;
    invoke-static {v0}, Lcom/livemixtapes/SignUp;->access$10(Lcom/livemixtapes/SignUp;)Landroid/widget/EditText;

    move-result-object v0

    const-string v1, ""

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 335
    iget-object v0, p0, Lcom/livemixtapes/SignUp$11;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->password:Landroid/widget/EditText;
    invoke-static {v0}, Lcom/livemixtapes/SignUp;->access$10(Lcom/livemixtapes/SignUp;)Landroid/widget/EditText;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/EditText;->requestFocus()Z

    .line 336
    return-void
.end method
