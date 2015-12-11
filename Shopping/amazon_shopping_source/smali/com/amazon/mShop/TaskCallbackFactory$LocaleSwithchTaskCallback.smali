.class public Lcom/amazon/mShop/TaskCallbackFactory$LocaleSwithchTaskCallback;
.super Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;
.source "TaskCallbackFactory.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/TaskCallbackFactory;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "LocaleSwithchTaskCallback"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/TaskCallbackFactory;


# direct methods
.method private constructor <init>(Lcom/amazon/mShop/TaskCallbackFactory;Lcom/amazon/mShop/control/Cancellable;Lcom/amazon/mShop/AmazonActivity;ZLjava/lang/String;Lcom/amazon/mShop/AmazonProgressDialog;)V
    .locals 7
    .param p2, "cancellable"    # Lcom/amazon/mShop/control/Cancellable;
    .param p3, "amazonActivity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p4, "finishActivityOnCancel"    # Z
    .param p5, "title"    # Ljava/lang/String;
    .param p6, "progressDialog"    # Lcom/amazon/mShop/AmazonProgressDialog;

    .prologue
    .line 175
    iput-object p1, p0, Lcom/amazon/mShop/TaskCallbackFactory$LocaleSwithchTaskCallback;->this$0:Lcom/amazon/mShop/TaskCallbackFactory;

    .line 176
    const/4 v6, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move v4, p4

    move-object v5, p5

    invoke-direct/range {v0 .. v6}, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;-><init>(Lcom/amazon/mShop/TaskCallbackFactory;Lcom/amazon/mShop/control/Cancellable;Lcom/amazon/mShop/AmazonActivity;ZLjava/lang/String;Lcom/amazon/mShop/TaskCallbackFactory$1;)V

    .line 177
    invoke-virtual {p0, p6}, Lcom/amazon/mShop/TaskCallbackFactory$LocaleSwithchTaskCallback;->setProgressDialog(Lcom/amazon/mShop/AmazonProgressDialog;)V

    .line 178
    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/mShop/TaskCallbackFactory;Lcom/amazon/mShop/control/Cancellable;Lcom/amazon/mShop/AmazonActivity;ZLjava/lang/String;Lcom/amazon/mShop/AmazonProgressDialog;Lcom/amazon/mShop/TaskCallbackFactory$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/mShop/TaskCallbackFactory;
    .param p2, "x1"    # Lcom/amazon/mShop/control/Cancellable;
    .param p3, "x2"    # Lcom/amazon/mShop/AmazonActivity;
    .param p4, "x3"    # Z
    .param p5, "x4"    # Ljava/lang/String;
    .param p6, "x5"    # Lcom/amazon/mShop/AmazonProgressDialog;
    .param p7, "x6"    # Lcom/amazon/mShop/TaskCallbackFactory$1;

    .prologue
    .line 170
    invoke-direct/range {p0 .. p6}, Lcom/amazon/mShop/TaskCallbackFactory$LocaleSwithchTaskCallback;-><init>(Lcom/amazon/mShop/TaskCallbackFactory;Lcom/amazon/mShop/control/Cancellable;Lcom/amazon/mShop/AmazonActivity;ZLjava/lang/String;Lcom/amazon/mShop/AmazonProgressDialog;)V

    return-void
.end method


# virtual methods
.method public beginTask()V
    .locals 1

    .prologue
    .line 183
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/TaskCallbackFactory$LocaleSwithchTaskCallback;->beginTaskProcessor(Z)V

    .line 184
    return-void
.end method

.method public bridge synthetic endTask()V
    .locals 0

    .prologue
    .line 170
    invoke-super {p0}, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;->endTask()V

    return-void
.end method

.method public endTaskWithoutDismissProgDiag()V
    .locals 1

    .prologue
    .line 195
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/TaskCallbackFactory$LocaleSwithchTaskCallback;->endTaskProcessor(Z)V

    .line 196
    return-void
.end method

.method public getProgressDialog()Lcom/amazon/mShop/AmazonProgressDialog;
    .locals 1

    .prologue
    .line 187
    iget-object v0, p0, Lcom/amazon/mShop/TaskCallbackFactory$LocaleSwithchTaskCallback;->this$0:Lcom/amazon/mShop/TaskCallbackFactory;

    # getter for: Lcom/amazon/mShop/TaskCallbackFactory;->progressDialog:Lcom/amazon/mShop/AmazonProgressDialog;
    invoke-static {v0}, Lcom/amazon/mShop/TaskCallbackFactory;->access$200(Lcom/amazon/mShop/TaskCallbackFactory;)Lcom/amazon/mShop/AmazonProgressDialog;

    move-result-object v0

    return-object v0
.end method
