.class Lcom/livemixtapes/Login$8;
.super Ljava/lang/Object;
.source "Login.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


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
    iput-object p1, p0, Lcom/livemixtapes/Login$8;->this$0:Lcom/livemixtapes/Login;

    .line 191
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 194
    iget-object v0, p0, Lcom/livemixtapes/Login$8;->this$0:Lcom/livemixtapes/Login;

    # invokes: Lcom/livemixtapes/Login;->hideKeyboards()V
    invoke-static {v0}, Lcom/livemixtapes/Login;->access$0(Lcom/livemixtapes/Login;)V

    .line 196
    iget-object v0, p0, Lcom/livemixtapes/Login$8;->this$0:Lcom/livemixtapes/Login;

    # getter for: Lcom/livemixtapes/Login;->username:Landroid/widget/EditText;
    invoke-static {v0}, Lcom/livemixtapes/Login;->access$3(Lcom/livemixtapes/Login;)Landroid/widget/EditText;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/EditText;->length()I

    move-result v0

    if-nez v0, :cond_0

    .line 197
    iget-object v0, p0, Lcom/livemixtapes/Login$8;->this$0:Lcom/livemixtapes/Login;

    iget-object v1, p0, Lcom/livemixtapes/Login$8;->this$0:Lcom/livemixtapes/Login;

    # getter for: Lcom/livemixtapes/Login;->usernameBox:Landroid/widget/LinearLayout;
    invoke-static {v1}, Lcom/livemixtapes/Login;->access$7(Lcom/livemixtapes/Login;)Landroid/widget/LinearLayout;

    move-result-object v1

    # invokes: Lcom/livemixtapes/Login;->shake(Landroid/view/View;)V
    invoke-static {v0, v1}, Lcom/livemixtapes/Login;->access$8(Lcom/livemixtapes/Login;Landroid/view/View;)V

    .line 198
    iget-object v0, p0, Lcom/livemixtapes/Login$8;->this$0:Lcom/livemixtapes/Login;

    # getter for: Lcom/livemixtapes/Login;->username:Landroid/widget/EditText;
    invoke-static {v0}, Lcom/livemixtapes/Login;->access$3(Lcom/livemixtapes/Login;)Landroid/widget/EditText;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/EditText;->requestFocus()Z

    .line 207
    :goto_0
    return-void

    .line 200
    :cond_0
    iget-object v0, p0, Lcom/livemixtapes/Login$8;->this$0:Lcom/livemixtapes/Login;

    # getter for: Lcom/livemixtapes/Login;->password:Landroid/widget/EditText;
    invoke-static {v0}, Lcom/livemixtapes/Login;->access$5(Lcom/livemixtapes/Login;)Landroid/widget/EditText;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/EditText;->length()I

    move-result v0

    if-nez v0, :cond_1

    .line 201
    iget-object v0, p0, Lcom/livemixtapes/Login$8;->this$0:Lcom/livemixtapes/Login;

    iget-object v1, p0, Lcom/livemixtapes/Login$8;->this$0:Lcom/livemixtapes/Login;

    # getter for: Lcom/livemixtapes/Login;->passwordBox:Landroid/widget/LinearLayout;
    invoke-static {v1}, Lcom/livemixtapes/Login;->access$9(Lcom/livemixtapes/Login;)Landroid/widget/LinearLayout;

    move-result-object v1

    # invokes: Lcom/livemixtapes/Login;->shake(Landroid/view/View;)V
    invoke-static {v0, v1}, Lcom/livemixtapes/Login;->access$8(Lcom/livemixtapes/Login;Landroid/view/View;)V

    .line 202
    iget-object v0, p0, Lcom/livemixtapes/Login$8;->this$0:Lcom/livemixtapes/Login;

    # getter for: Lcom/livemixtapes/Login;->password:Landroid/widget/EditText;
    invoke-static {v0}, Lcom/livemixtapes/Login;->access$5(Lcom/livemixtapes/Login;)Landroid/widget/EditText;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/EditText;->requestFocus()Z

    goto :goto_0

    .line 206
    :cond_1
    iget-object v0, p0, Lcom/livemixtapes/Login$8;->this$0:Lcom/livemixtapes/Login;

    # invokes: Lcom/livemixtapes/Login;->login()V
    invoke-static {v0}, Lcom/livemixtapes/Login;->access$10(Lcom/livemixtapes/Login;)V

    goto :goto_0
.end method
