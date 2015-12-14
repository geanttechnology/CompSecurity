.class Lcom/livemixtapes/SignUp$10;
.super Ljava/lang/Object;
.source "SignUp.java"

# interfaces
.implements Landroid/text/TextWatcher;


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
    iput-object p1, p0, Lcom/livemixtapes/SignUp$10;->this$0:Lcom/livemixtapes/SignUp;

    .line 311
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 2
    .param p1, "s"    # Landroid/text/Editable;

    .prologue
    .line 314
    iget-object v0, p0, Lcom/livemixtapes/SignUp$10;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->password:Landroid/widget/EditText;
    invoke-static {v0}, Lcom/livemixtapes/SignUp;->access$10(Lcom/livemixtapes/SignUp;)Landroid/widget/EditText;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/EditText;->length()I

    move-result v0

    if-lez v0, :cond_0

    .line 315
    iget-object v0, p0, Lcom/livemixtapes/SignUp$10;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->passwordClear:Landroid/widget/ImageButton;
    invoke-static {v0}, Lcom/livemixtapes/SignUp;->access$11(Lcom/livemixtapes/SignUp;)Landroid/widget/ImageButton;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 320
    :goto_0
    return-void

    .line 318
    :cond_0
    iget-object v0, p0, Lcom/livemixtapes/SignUp$10;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->passwordClear:Landroid/widget/ImageButton;
    invoke-static {v0}, Lcom/livemixtapes/SignUp;->access$11(Lcom/livemixtapes/SignUp;)Landroid/widget/ImageButton;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setVisibility(I)V

    goto :goto_0
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0
    .param p1, "s"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I
    .param p3, "count"    # I
    .param p4, "after"    # I

    .prologue
    .line 324
    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0
    .param p1, "s"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I
    .param p3, "before"    # I
    .param p4, "count"    # I

    .prologue
    .line 328
    return-void
.end method
