.class Lcom/livemixtapes/SignUp$16;
.super Lcom/livemixtapes/User$SignupCallback;
.source "SignUp.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/SignUp;->signup()V
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
    iput-object p1, p0, Lcom/livemixtapes/SignUp$16;->this$0:Lcom/livemixtapes/SignUp;

    .line 628
    invoke-direct {p0}, Lcom/livemixtapes/User$SignupCallback;-><init>()V

    return-void
.end method


# virtual methods
.method public always()V
    .locals 2

    .prologue
    .line 676
    iget-object v0, p0, Lcom/livemixtapes/SignUp$16;->this$0:Lcom/livemixtapes/SignUp;

    const/4 v1, 0x0

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/livemixtapes/SignUp;->access$40(Lcom/livemixtapes/SignUp;Ljava/lang/Boolean;)V

    .line 677
    iget-object v0, p0, Lcom/livemixtapes/SignUp$16;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->signupLoading:Landroid/widget/ProgressBar;
    invoke-static {v0}, Lcom/livemixtapes/SignUp;->access$41(Lcom/livemixtapes/SignUp;)Landroid/widget/ProgressBar;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 678
    return-void
.end method

.method public failure(ILjava/lang/Exception;)V
    .locals 0
    .param p1, "code"    # I
    .param p2, "e"    # Ljava/lang/Exception;

    .prologue
    .line 639
    return-void
.end method

.method public signup_failure(Ljava/lang/String;)V
    .locals 8
    .param p1, "failure_reason"    # Ljava/lang/String;

    .prologue
    const/4 v7, 0x0

    .line 672
    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    .line 644
    aput-object p1, v3, v7

    invoke-static {v3}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    .line 646
    move-object v0, p1

    .line 649
    .local v0, "convert_reason":Ljava/lang/String;
    move-object v1, p1

    .line 651
    .local v1, "error_reason":Ljava/lang/String;
    const-string v3, "\\n"

    const-string v4, ""

    invoke-virtual {v1, v3, v4}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v1

    .line 653
    const-string v3, "\"error\""

    const-string v4, ""

    invoke-virtual {v1, v3, v4}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v1

    .line 654
    const-string v3, ":"

    const-string v4, ""

    invoke-virtual {v1, v3, v4}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v1

    .line 655
    const-string v3, "Array("

    const-string v4, ""

    invoke-virtual {v1, v3, v4}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v1

    .line 656
    const-string v3, "Validation failed"

    const-string v4, ""

    invoke-virtual {v1, v3, v4}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v1

    .line 657
    const-string v3, "Errors"

    const-string v4, ""

    invoke-virtual {v1, v3, v4}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v1

    .line 659
    const-string v3, "=>"

    const-string v4, ":"

    invoke-virtual {v1, v3, v4}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v1

    .line 660
    const-string v3, ")"

    const-string v4, ""

    invoke-virtual {v1, v3, v4}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v1

    .line 662
    const-string v3, "{"

    const-string v4, ""

    invoke-virtual {v1, v3, v4}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v1

    .line 663
    const-string v3, "}"

    const-string v4, ""

    invoke-virtual {v1, v3, v4}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v1

    .line 665
    const-string v3, "\""

    const-string v4, ""

    invoke-virtual {v1, v3, v4}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v1

    .line 667
    const-string v3, ","

    invoke-virtual {v1, v3}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v2

    .line 671
    .local v2, "error_split":[Ljava/lang/String;
    iget-object v3, p0, Lcom/livemixtapes/SignUp$16;->this$0:Lcom/livemixtapes/SignUp;

    const-string v4, "Signup Error"

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "Signup Failed for the given reason: "

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    aget-object v6, v2, v7

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    # invokes: Lcom/livemixtapes/SignUp;->showDialog(Ljava/lang/String;Ljava/lang/String;)V
    invoke-static {v3, v4, v5}, Lcom/livemixtapes/SignUp;->access$42(Lcom/livemixtapes/SignUp;Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public success()V
    .locals 4

    .prologue
    .line 631
    iget-object v0, p0, Lcom/livemixtapes/SignUp$16;->this$0:Lcom/livemixtapes/SignUp;

    const-string v1, "Signup Success"

    const-string v2, "Your account was successfully created and you can now log in!"

    # invokes: Lcom/livemixtapes/SignUp;->showDialog(Ljava/lang/String;Ljava/lang/String;)V
    invoke-static {v0, v1, v2}, Lcom/livemixtapes/SignUp;->access$42(Lcom/livemixtapes/SignUp;Ljava/lang/String;Ljava/lang/String;)V

    .line 632
    iget-object v0, p0, Lcom/livemixtapes/SignUp$16;->this$0:Lcom/livemixtapes/SignUp;

    new-instance v1, Landroid/content/Intent;

    iget-object v2, p0, Lcom/livemixtapes/SignUp$16;->this$0:Lcom/livemixtapes/SignUp;

    .line 633
    const-class v3, Lcom/livemixtapes/Login;

    invoke-direct {v1, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 632
    invoke-virtual {v0, v1}, Lcom/livemixtapes/SignUp;->startActivity(Landroid/content/Intent;)V

    .line 634
    return-void
.end method
