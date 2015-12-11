.class Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback$1;
.super Ljava/lang/Object;
.source "TaskCallbackFactory.java"

# interfaces
.implements Landroid/content/DialogInterface$OnCancelListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;->beginTaskProcessor(Z)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;)V
    .locals 0

    .prologue
    .line 113
    iput-object p1, p0, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback$1;->this$1:Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCancel(Landroid/content/DialogInterface;)V
    .locals 1
    .param p1, "dialog"    # Landroid/content/DialogInterface;

    .prologue
    .line 116
    iget-object v0, p0, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback$1;->this$1:Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;

    # getter for: Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;->cancellable:Lcom/amazon/mShop/control/Cancellable;
    invoke-static {v0}, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;->access$300(Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;)Lcom/amazon/mShop/control/Cancellable;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 117
    iget-object v0, p0, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback$1;->this$1:Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;

    # getter for: Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;->cancellable:Lcom/amazon/mShop/control/Cancellable;
    invoke-static {v0}, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;->access$300(Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;)Lcom/amazon/mShop/control/Cancellable;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/mShop/control/Cancellable;->cancel()V

    .line 119
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback$1;->this$1:Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;

    # getter for: Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;->amazonActivity:Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v0}, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;->access$400(Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;)Lcom/amazon/mShop/AmazonActivity;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 120
    iget-object v0, p0, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback$1;->this$1:Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;

    # getter for: Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;->finishActivityOnCancel:Z
    invoke-static {v0}, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;->access$500(Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 121
    iget-object v0, p0, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback$1;->this$1:Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;

    # getter for: Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;->amazonActivity:Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v0}, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;->access$400(Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;)Lcom/amazon/mShop/AmazonActivity;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonActivity;->finish()V

    .line 126
    :cond_1
    :goto_0
    return-void

    .line 123
    :cond_2
    iget-object v0, p0, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback$1;->this$1:Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;

    # getter for: Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;->amazonActivity:Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v0}, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;->access$400(Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;)Lcom/amazon/mShop/AmazonActivity;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonActivity;->popView()Z

    goto :goto_0
.end method
