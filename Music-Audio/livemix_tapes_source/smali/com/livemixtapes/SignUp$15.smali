.class Lcom/livemixtapes/SignUp$15;
.super Lcom/livemixtapes/User$UserCallback;
.source "SignUp.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/SignUp;->refresh()V
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
    iput-object p1, p0, Lcom/livemixtapes/SignUp$15;->this$0:Lcom/livemixtapes/SignUp;

    .line 556
    invoke-direct {p0}, Lcom/livemixtapes/User$UserCallback;-><init>()V

    return-void
.end method


# virtual methods
.method public always()V
    .locals 2

    .prologue
    .line 567
    iget-object v0, p0, Lcom/livemixtapes/SignUp$15;->this$0:Lcom/livemixtapes/SignUp;

    const/4 v1, 0x0

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/livemixtapes/SignUp;->access$40(Lcom/livemixtapes/SignUp;Ljava/lang/Boolean;)V

    .line 568
    iget-object v0, p0, Lcom/livemixtapes/SignUp$15;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->signupLoading:Landroid/widget/ProgressBar;
    invoke-static {v0}, Lcom/livemixtapes/SignUp;->access$41(Lcom/livemixtapes/SignUp;)Landroid/widget/ProgressBar;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 569
    return-void
.end method

.method public failure(ILjava/lang/Exception;)V
    .locals 0
    .param p1, "code"    # I
    .param p2, "e"    # Ljava/lang/Exception;

    .prologue
    .line 563
    return-void
.end method

.method public success(Lcom/livemixtapes/User$UserData;)V
    .locals 1
    .param p1, "user"    # Lcom/livemixtapes/User$UserData;

    .prologue
    .line 559
    iget-object v0, p0, Lcom/livemixtapes/SignUp$15;->this$0:Lcom/livemixtapes/SignUp;

    # invokes: Lcom/livemixtapes/SignUp;->openRadio()V
    invoke-static {v0}, Lcom/livemixtapes/SignUp;->access$39(Lcom/livemixtapes/SignUp;)V

    .line 560
    return-void
.end method
