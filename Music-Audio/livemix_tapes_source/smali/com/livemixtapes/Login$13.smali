.class Lcom/livemixtapes/Login$13;
.super Lcom/livemixtapes/User$UserCallback;
.source "Login.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/Login;->refresh()V
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
    iput-object p1, p0, Lcom/livemixtapes/Login$13;->this$0:Lcom/livemixtapes/Login;

    .line 299
    invoke-direct {p0}, Lcom/livemixtapes/User$UserCallback;-><init>()V

    return-void
.end method


# virtual methods
.method public always()V
    .locals 2

    .prologue
    .line 311
    iget-object v0, p0, Lcom/livemixtapes/Login$13;->this$0:Lcom/livemixtapes/Login;

    const/4 v1, 0x0

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/livemixtapes/Login;->access$14(Lcom/livemixtapes/Login;Ljava/lang/Boolean;)V

    .line 312
    iget-object v0, p0, Lcom/livemixtapes/Login$13;->this$0:Lcom/livemixtapes/Login;

    # getter for: Lcom/livemixtapes/Login;->loginLoading:Landroid/widget/ProgressBar;
    invoke-static {v0}, Lcom/livemixtapes/Login;->access$15(Lcom/livemixtapes/Login;)Landroid/widget/ProgressBar;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 313
    return-void
.end method

.method public failure(ILjava/lang/Exception;)V
    .locals 0
    .param p1, "code"    # I
    .param p2, "e"    # Ljava/lang/Exception;

    .prologue
    .line 307
    return-void
.end method

.method public success(Lcom/livemixtapes/User$UserData;)V
    .locals 1
    .param p1, "user"    # Lcom/livemixtapes/User$UserData;

    .prologue
    .line 302
    iget-object v0, p0, Lcom/livemixtapes/Login$13;->this$0:Lcom/livemixtapes/Login;

    # invokes: Lcom/livemixtapes/Login;->openRadio()V
    invoke-static {v0}, Lcom/livemixtapes/Login;->access$12(Lcom/livemixtapes/Login;)V

    .line 303
    return-void
.end method
