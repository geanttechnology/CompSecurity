.class Lcom/livemixtapes/Login$14;
.super Lcom/livemixtapes/User$UserCallback;
.source "Login.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/Login;->login()V
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
    iput-object p1, p0, Lcom/livemixtapes/Login$14;->this$0:Lcom/livemixtapes/Login;

    .line 327
    invoke-direct {p0}, Lcom/livemixtapes/User$UserCallback;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/livemixtapes/Login$14;)Lcom/livemixtapes/Login;
    .locals 1

    .prologue
    .line 327
    iget-object v0, p0, Lcom/livemixtapes/Login$14;->this$0:Lcom/livemixtapes/Login;

    return-object v0
.end method


# virtual methods
.method public always()V
    .locals 2

    .prologue
    .line 353
    iget-object v0, p0, Lcom/livemixtapes/Login$14;->this$0:Lcom/livemixtapes/Login;

    const/4 v1, 0x0

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/livemixtapes/Login;->access$14(Lcom/livemixtapes/Login;Ljava/lang/Boolean;)V

    .line 354
    iget-object v0, p0, Lcom/livemixtapes/Login$14;->this$0:Lcom/livemixtapes/Login;

    # getter for: Lcom/livemixtapes/Login;->loginLoading:Landroid/widget/ProgressBar;
    invoke-static {v0}, Lcom/livemixtapes/Login;->access$15(Lcom/livemixtapes/Login;)Landroid/widget/ProgressBar;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 355
    return-void
.end method

.method public failure(ILjava/lang/Exception;)V
    .locals 3
    .param p1, "code"    # I
    .param p2, "e"    # Ljava/lang/Exception;

    .prologue
    .line 335
    const/4 v0, 0x1

    if-ne p1, v0, :cond_0

    .line 336
    iget-object v0, p0, Lcom/livemixtapes/Login$14;->this$0:Lcom/livemixtapes/Login;

    iget-object v1, p0, Lcom/livemixtapes/Login$14;->this$0:Lcom/livemixtapes/Login;

    # getter for: Lcom/livemixtapes/Login;->username:Landroid/widget/EditText;
    invoke-static {v1}, Lcom/livemixtapes/Login;->access$3(Lcom/livemixtapes/Login;)Landroid/widget/EditText;

    move-result-object v1

    # invokes: Lcom/livemixtapes/Login;->shake(Landroid/view/View;)V
    invoke-static {v0, v1}, Lcom/livemixtapes/Login;->access$8(Lcom/livemixtapes/Login;Landroid/view/View;)V

    .line 337
    iget-object v0, p0, Lcom/livemixtapes/Login$14;->this$0:Lcom/livemixtapes/Login;

    iget-object v1, p0, Lcom/livemixtapes/Login$14;->this$0:Lcom/livemixtapes/Login;

    # getter for: Lcom/livemixtapes/Login;->password:Landroid/widget/EditText;
    invoke-static {v1}, Lcom/livemixtapes/Login;->access$5(Lcom/livemixtapes/Login;)Landroid/widget/EditText;

    move-result-object v1

    new-instance v2, Lcom/livemixtapes/Login$14$1;

    invoke-direct {v2, p0}, Lcom/livemixtapes/Login$14$1;-><init>(Lcom/livemixtapes/Login$14;)V

    # invokes: Lcom/livemixtapes/Login;->shake(Landroid/view/View;Ljava/lang/Runnable;)V
    invoke-static {v0, v1, v2}, Lcom/livemixtapes/Login;->access$17(Lcom/livemixtapes/Login;Landroid/view/View;Ljava/lang/Runnable;)V

    .line 349
    :goto_0
    return-void

    .line 346
    :cond_0
    iget-object v0, p0, Lcom/livemixtapes/Login$14;->this$0:Lcom/livemixtapes/Login;

    const-string v1, "Error"

    .line 347
    const-string v2, "There was an unknown error while logging in."

    .line 346
    # invokes: Lcom/livemixtapes/Login;->showDialog(Ljava/lang/String;Ljava/lang/String;)V
    invoke-static {v0, v1, v2}, Lcom/livemixtapes/Login;->access$16(Lcom/livemixtapes/Login;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public success(Lcom/livemixtapes/User$UserData;)V
    .locals 1
    .param p1, "user"    # Lcom/livemixtapes/User$UserData;

    .prologue
    .line 330
    iget-object v0, p0, Lcom/livemixtapes/Login$14;->this$0:Lcom/livemixtapes/Login;

    # invokes: Lcom/livemixtapes/Login;->openRadio()V
    invoke-static {v0}, Lcom/livemixtapes/Login;->access$12(Lcom/livemixtapes/Login;)V

    .line 331
    return-void
.end method
