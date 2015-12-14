.class Lcom/livemixtapes/Login$5;
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
    iput-object p1, p0, Lcom/livemixtapes/Login$5;->this$0:Lcom/livemixtapes/Login;

    .line 154
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 157
    iget-object v0, p0, Lcom/livemixtapes/Login$5;->this$0:Lcom/livemixtapes/Login;

    # getter for: Lcom/livemixtapes/Login;->username:Landroid/widget/EditText;
    invoke-static {v0}, Lcom/livemixtapes/Login;->access$3(Lcom/livemixtapes/Login;)Landroid/widget/EditText;

    move-result-object v0

    const-string v1, ""

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 158
    iget-object v0, p0, Lcom/livemixtapes/Login$5;->this$0:Lcom/livemixtapes/Login;

    # getter for: Lcom/livemixtapes/Login;->username:Landroid/widget/EditText;
    invoke-static {v0}, Lcom/livemixtapes/Login;->access$3(Lcom/livemixtapes/Login;)Landroid/widget/EditText;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/EditText;->requestFocus()Z

    .line 159
    return-void
.end method
