.class Lcom/livemixtapes/Login$6;
.super Ljava/lang/Object;
.source "Login.java"

# interfaces
.implements Landroid/text/TextWatcher;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/Login;->setListeners()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/Login;


# direct methods
.method constructor <init>(Lcom/livemixtapes/Login;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/Login$6;->this$0:Lcom/livemixtapes/Login;

    .line 162
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 2
    .param p1, "s"    # Landroid/text/Editable;

    .prologue
    .line 165
    iget-object v0, p0, Lcom/livemixtapes/Login$6;->this$0:Lcom/livemixtapes/Login;

    # getter for: Lcom/livemixtapes/Login;->password:Landroid/widget/EditText;
    invoke-static {v0}, Lcom/livemixtapes/Login;->access$5(Lcom/livemixtapes/Login;)Landroid/widget/EditText;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/EditText;->length()I

    move-result v0

    if-lez v0, :cond_0

    .line 166
    iget-object v0, p0, Lcom/livemixtapes/Login$6;->this$0:Lcom/livemixtapes/Login;

    # getter for: Lcom/livemixtapes/Login;->passwordClear:Landroid/widget/ImageButton;
    invoke-static {v0}, Lcom/livemixtapes/Login;->access$6(Lcom/livemixtapes/Login;)Landroid/widget/ImageButton;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 170
    :goto_0
    return-void

    .line 168
    :cond_0
    iget-object v0, p0, Lcom/livemixtapes/Login$6;->this$0:Lcom/livemixtapes/Login;

    # getter for: Lcom/livemixtapes/Login;->passwordClear:Landroid/widget/ImageButton;
    invoke-static {v0}, Lcom/livemixtapes/Login;->access$6(Lcom/livemixtapes/Login;)Landroid/widget/ImageButton;

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
    .line 175
    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0
    .param p1, "s"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I
    .param p3, "before"    # I
    .param p4, "count"    # I

    .prologue
    .line 180
    return-void
.end method
