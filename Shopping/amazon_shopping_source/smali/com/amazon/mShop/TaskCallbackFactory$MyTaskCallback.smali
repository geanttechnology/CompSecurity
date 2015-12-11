.class Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;
.super Ljava/lang/Object;
.source "TaskCallbackFactory.java"

# interfaces
.implements Lcom/amazon/mShop/control/TaskCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/TaskCallbackFactory;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "MyTaskCallback"
.end annotation


# instance fields
.field private final amazonActivity:Lcom/amazon/mShop/AmazonActivity;

.field private final cancellable:Lcom/amazon/mShop/control/Cancellable;

.field private final finishActivityOnCancel:Z

.field final synthetic this$0:Lcom/amazon/mShop/TaskCallbackFactory;

.field private final title:Ljava/lang/String;


# direct methods
.method private constructor <init>(Lcom/amazon/mShop/TaskCallbackFactory;Lcom/amazon/mShop/control/Cancellable;Lcom/amazon/mShop/AmazonActivity;Z)V
    .locals 1
    .param p2, "cancellable"    # Lcom/amazon/mShop/control/Cancellable;
    .param p3, "amazonActivity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p4, "finishActivityOnCancel"    # Z

    .prologue
    .line 80
    iput-object p1, p0, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;->this$0:Lcom/amazon/mShop/TaskCallbackFactory;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 81
    iput-object p2, p0, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;->cancellable:Lcom/amazon/mShop/control/Cancellable;

    .line 82
    iput-object p3, p0, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;->amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    .line 83
    iput-boolean p4, p0, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;->finishActivityOnCancel:Z

    .line 84
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;->title:Ljava/lang/String;

    .line 85
    return-void
.end method

.method private constructor <init>(Lcom/amazon/mShop/TaskCallbackFactory;Lcom/amazon/mShop/control/Cancellable;Lcom/amazon/mShop/AmazonActivity;ZI)V
    .locals 1
    .param p2, "cancellable"    # Lcom/amazon/mShop/control/Cancellable;
    .param p3, "amazonActivity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p4, "finishActivityOnCancel"    # Z
    .param p5, "titleId"    # I

    .prologue
    .line 50
    iput-object p1, p0, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;->this$0:Lcom/amazon/mShop/TaskCallbackFactory;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 51
    iput-object p2, p0, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;->cancellable:Lcom/amazon/mShop/control/Cancellable;

    .line 52
    iput-object p3, p0, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;->amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    .line 53
    iput-boolean p4, p0, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;->finishActivityOnCancel:Z

    .line 54
    # getter for: Lcom/amazon/mShop/TaskCallbackFactory;->context:Landroid/content/Context;
    invoke-static {p1}, Lcom/amazon/mShop/TaskCallbackFactory;->access$000(Lcom/amazon/mShop/TaskCallbackFactory;)Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0, p5}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;->title:Ljava/lang/String;

    .line 55
    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/mShop/TaskCallbackFactory;Lcom/amazon/mShop/control/Cancellable;Lcom/amazon/mShop/AmazonActivity;ZILcom/amazon/mShop/TaskCallbackFactory$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/mShop/TaskCallbackFactory;
    .param p2, "x1"    # Lcom/amazon/mShop/control/Cancellable;
    .param p3, "x2"    # Lcom/amazon/mShop/AmazonActivity;
    .param p4, "x3"    # Z
    .param p5, "x4"    # I
    .param p6, "x5"    # Lcom/amazon/mShop/TaskCallbackFactory$1;

    .prologue
    .line 19
    invoke-direct/range {p0 .. p5}, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;-><init>(Lcom/amazon/mShop/TaskCallbackFactory;Lcom/amazon/mShop/control/Cancellable;Lcom/amazon/mShop/AmazonActivity;ZI)V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/mShop/TaskCallbackFactory;Lcom/amazon/mShop/control/Cancellable;Lcom/amazon/mShop/AmazonActivity;ZLcom/amazon/mShop/TaskCallbackFactory$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/mShop/TaskCallbackFactory;
    .param p2, "x1"    # Lcom/amazon/mShop/control/Cancellable;
    .param p3, "x2"    # Lcom/amazon/mShop/AmazonActivity;
    .param p4, "x3"    # Z
    .param p5, "x4"    # Lcom/amazon/mShop/TaskCallbackFactory$1;

    .prologue
    .line 19
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;-><init>(Lcom/amazon/mShop/TaskCallbackFactory;Lcom/amazon/mShop/control/Cancellable;Lcom/amazon/mShop/AmazonActivity;Z)V

    return-void
.end method

.method private constructor <init>(Lcom/amazon/mShop/TaskCallbackFactory;Lcom/amazon/mShop/control/Cancellable;Lcom/amazon/mShop/AmazonActivity;ZLjava/lang/String;)V
    .locals 0
    .param p2, "cancellable"    # Lcom/amazon/mShop/control/Cancellable;
    .param p3, "amazonActivity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p4, "finishActivityOnCancel"    # Z
    .param p5, "title"    # Ljava/lang/String;

    .prologue
    .line 66
    iput-object p1, p0, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;->this$0:Lcom/amazon/mShop/TaskCallbackFactory;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 67
    iput-object p2, p0, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;->cancellable:Lcom/amazon/mShop/control/Cancellable;

    .line 68
    iput-object p3, p0, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;->amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    .line 69
    iput-boolean p4, p0, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;->finishActivityOnCancel:Z

    .line 70
    iput-object p5, p0, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;->title:Ljava/lang/String;

    .line 71
    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/mShop/TaskCallbackFactory;Lcom/amazon/mShop/control/Cancellable;Lcom/amazon/mShop/AmazonActivity;ZLjava/lang/String;Lcom/amazon/mShop/TaskCallbackFactory$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/mShop/TaskCallbackFactory;
    .param p2, "x1"    # Lcom/amazon/mShop/control/Cancellable;
    .param p3, "x2"    # Lcom/amazon/mShop/AmazonActivity;
    .param p4, "x3"    # Z
    .param p5, "x4"    # Ljava/lang/String;
    .param p6, "x5"    # Lcom/amazon/mShop/TaskCallbackFactory$1;

    .prologue
    .line 19
    invoke-direct/range {p0 .. p5}, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;-><init>(Lcom/amazon/mShop/TaskCallbackFactory;Lcom/amazon/mShop/control/Cancellable;Lcom/amazon/mShop/AmazonActivity;ZLjava/lang/String;)V

    return-void
.end method

.method static synthetic access$300(Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;)Lcom/amazon/mShop/control/Cancellable;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;

    .prologue
    .line 19
    iget-object v0, p0, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;->cancellable:Lcom/amazon/mShop/control/Cancellable;

    return-object v0
.end method

.method static synthetic access$400(Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;)Lcom/amazon/mShop/AmazonActivity;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;

    .prologue
    .line 19
    iget-object v0, p0, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;->amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    return-object v0
.end method

.method static synthetic access$500(Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;

    .prologue
    .line 19
    iget-boolean v0, p0, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;->finishActivityOnCancel:Z

    return v0
.end method


# virtual methods
.method public beginTask()V
    .locals 1

    .prologue
    .line 90
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;->beginTaskProcessor(Z)V

    .line 91
    return-void
.end method

.method protected beginTaskProcessor(Z)V
    .locals 5
    .param p1, "reuseProgress"    # Z

    .prologue
    .line 94
    iget-object v2, p0, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;->this$0:Lcom/amazon/mShop/TaskCallbackFactory;

    # setter for: Lcom/amazon/mShop/TaskCallbackFactory;->currentTaskCallback:Lcom/amazon/mShop/control/TaskCallback;
    invoke-static {v2, p0}, Lcom/amazon/mShop/TaskCallbackFactory;->access$102(Lcom/amazon/mShop/TaskCallbackFactory;Lcom/amazon/mShop/control/TaskCallback;)Lcom/amazon/mShop/control/TaskCallback;

    .line 95
    iget-object v2, p0, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;->this$0:Lcom/amazon/mShop/TaskCallbackFactory;

    # getter for: Lcom/amazon/mShop/TaskCallbackFactory;->progressDialog:Lcom/amazon/mShop/AmazonProgressDialog;
    invoke-static {v2}, Lcom/amazon/mShop/TaskCallbackFactory;->access$200(Lcom/amazon/mShop/TaskCallbackFactory;)Lcom/amazon/mShop/AmazonProgressDialog;

    move-result-object v2

    if-eqz v2, :cond_0

    if-nez p1, :cond_0

    .line 97
    :try_start_0
    iget-object v2, p0, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;->this$0:Lcom/amazon/mShop/TaskCallbackFactory;

    # getter for: Lcom/amazon/mShop/TaskCallbackFactory;->progressDialog:Lcom/amazon/mShop/AmazonProgressDialog;
    invoke-static {v2}, Lcom/amazon/mShop/TaskCallbackFactory;->access$200(Lcom/amazon/mShop/TaskCallbackFactory;)Lcom/amazon/mShop/AmazonProgressDialog;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/AmazonProgressDialog;->dismiss()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 103
    :cond_0
    :goto_0
    const/4 v1, 0x0

    .line 104
    .local v1, "shouldShowDiag":Z
    if-eqz p1, :cond_1

    iget-object v2, p0, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;->this$0:Lcom/amazon/mShop/TaskCallbackFactory;

    # getter for: Lcom/amazon/mShop/TaskCallbackFactory;->progressDialog:Lcom/amazon/mShop/AmazonProgressDialog;
    invoke-static {v2}, Lcom/amazon/mShop/TaskCallbackFactory;->access$200(Lcom/amazon/mShop/TaskCallbackFactory;)Lcom/amazon/mShop/AmazonProgressDialog;

    move-result-object v2

    if-nez v2, :cond_2

    .line 105
    :cond_1
    const/4 v1, 0x1

    .line 106
    iget-object v2, p0, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;->this$0:Lcom/amazon/mShop/TaskCallbackFactory;

    new-instance v3, Lcom/amazon/mShop/AmazonProgressDialog;

    iget-object v4, p0, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;->this$0:Lcom/amazon/mShop/TaskCallbackFactory;

    # getter for: Lcom/amazon/mShop/TaskCallbackFactory;->context:Landroid/content/Context;
    invoke-static {v4}, Lcom/amazon/mShop/TaskCallbackFactory;->access$000(Lcom/amazon/mShop/TaskCallbackFactory;)Landroid/content/Context;

    move-result-object v4

    invoke-direct {v3, v4}, Lcom/amazon/mShop/AmazonProgressDialog;-><init>(Landroid/content/Context;)V

    # setter for: Lcom/amazon/mShop/TaskCallbackFactory;->progressDialog:Lcom/amazon/mShop/AmazonProgressDialog;
    invoke-static {v2, v3}, Lcom/amazon/mShop/TaskCallbackFactory;->access$202(Lcom/amazon/mShop/TaskCallbackFactory;Lcom/amazon/mShop/AmazonProgressDialog;)Lcom/amazon/mShop/AmazonProgressDialog;

    .line 108
    :cond_2
    iget-object v2, p0, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;->title:Ljava/lang/String;

    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_3

    .line 109
    iget-object v2, p0, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;->this$0:Lcom/amazon/mShop/TaskCallbackFactory;

    # getter for: Lcom/amazon/mShop/TaskCallbackFactory;->progressDialog:Lcom/amazon/mShop/AmazonProgressDialog;
    invoke-static {v2}, Lcom/amazon/mShop/TaskCallbackFactory;->access$200(Lcom/amazon/mShop/TaskCallbackFactory;)Lcom/amazon/mShop/AmazonProgressDialog;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;->title:Ljava/lang/String;

    invoke-virtual {v2, v3}, Lcom/amazon/mShop/AmazonProgressDialog;->setTitle(Ljava/lang/CharSequence;)V

    .line 111
    :cond_3
    iget-object v2, p0, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;->this$0:Lcom/amazon/mShop/TaskCallbackFactory;

    # getter for: Lcom/amazon/mShop/TaskCallbackFactory;->progressDialog:Lcom/amazon/mShop/AmazonProgressDialog;
    invoke-static {v2}, Lcom/amazon/mShop/TaskCallbackFactory;->access$200(Lcom/amazon/mShop/TaskCallbackFactory;)Lcom/amazon/mShop/AmazonProgressDialog;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Lcom/amazon/mShop/AmazonProgressDialog;->setCanceledOnTouchOutside(Z)V

    .line 113
    iget-object v2, p0, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;->this$0:Lcom/amazon/mShop/TaskCallbackFactory;

    # getter for: Lcom/amazon/mShop/TaskCallbackFactory;->progressDialog:Lcom/amazon/mShop/AmazonProgressDialog;
    invoke-static {v2}, Lcom/amazon/mShop/TaskCallbackFactory;->access$200(Lcom/amazon/mShop/TaskCallbackFactory;)Lcom/amazon/mShop/AmazonProgressDialog;

    move-result-object v2

    new-instance v3, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback$1;

    invoke-direct {v3, p0}, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback$1;-><init>(Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;)V

    invoke-virtual {v2, v3}, Lcom/amazon/mShop/AmazonProgressDialog;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)V

    .line 129
    if-eqz v1, :cond_4

    .line 131
    :try_start_1
    iget-object v2, p0, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;->this$0:Lcom/amazon/mShop/TaskCallbackFactory;

    # getter for: Lcom/amazon/mShop/TaskCallbackFactory;->progressDialog:Lcom/amazon/mShop/AmazonProgressDialog;
    invoke-static {v2}, Lcom/amazon/mShop/TaskCallbackFactory;->access$200(Lcom/amazon/mShop/TaskCallbackFactory;)Lcom/amazon/mShop/AmazonProgressDialog;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/AmazonProgressDialog;->show()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    .line 136
    :cond_4
    :goto_1
    return-void

    .line 98
    .end local v1    # "shouldShowDiag":Z
    :catch_0
    move-exception v0

    .line 99
    .local v0, "e":Ljava/lang/Exception;
    const-string/jumbo v2, "ProgressDialog"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 132
    .end local v0    # "e":Ljava/lang/Exception;
    .restart local v1    # "shouldShowDiag":Z
    :catch_1
    move-exception v0

    .line 133
    .restart local v0    # "e":Ljava/lang/Exception;
    const-string/jumbo v2, "ProgressDialog"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1
.end method

.method public endTask()V
    .locals 1

    .prologue
    .line 140
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;->endTaskProcessor(Z)V

    .line 141
    return-void
.end method

.method protected endTaskProcessor(Z)V
    .locals 4
    .param p1, "shouldDismissDialog"    # Z

    .prologue
    const/4 v3, 0x0

    .line 144
    iget-object v1, p0, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;->this$0:Lcom/amazon/mShop/TaskCallbackFactory;

    # getter for: Lcom/amazon/mShop/TaskCallbackFactory;->currentTaskCallback:Lcom/amazon/mShop/control/TaskCallback;
    invoke-static {v1}, Lcom/amazon/mShop/TaskCallbackFactory;->access$100(Lcom/amazon/mShop/TaskCallbackFactory;)Lcom/amazon/mShop/control/TaskCallback;

    move-result-object v1

    if-ne p0, v1, :cond_1

    .line 145
    if-eqz p1, :cond_0

    .line 147
    iget-object v1, p0, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;->this$0:Lcom/amazon/mShop/TaskCallbackFactory;

    # getter for: Lcom/amazon/mShop/TaskCallbackFactory;->progressDialog:Lcom/amazon/mShop/AmazonProgressDialog;
    invoke-static {v1}, Lcom/amazon/mShop/TaskCallbackFactory;->access$200(Lcom/amazon/mShop/TaskCallbackFactory;)Lcom/amazon/mShop/AmazonProgressDialog;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 149
    :try_start_0
    iget-object v1, p0, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;->this$0:Lcom/amazon/mShop/TaskCallbackFactory;

    # getter for: Lcom/amazon/mShop/TaskCallbackFactory;->progressDialog:Lcom/amazon/mShop/AmazonProgressDialog;
    invoke-static {v1}, Lcom/amazon/mShop/TaskCallbackFactory;->access$200(Lcom/amazon/mShop/TaskCallbackFactory;)Lcom/amazon/mShop/AmazonProgressDialog;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/AmazonProgressDialog;->dismiss()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 153
    :goto_0
    iget-object v1, p0, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;->this$0:Lcom/amazon/mShop/TaskCallbackFactory;

    # setter for: Lcom/amazon/mShop/TaskCallbackFactory;->progressDialog:Lcom/amazon/mShop/AmazonProgressDialog;
    invoke-static {v1, v3}, Lcom/amazon/mShop/TaskCallbackFactory;->access$202(Lcom/amazon/mShop/TaskCallbackFactory;Lcom/amazon/mShop/AmazonProgressDialog;)Lcom/amazon/mShop/AmazonProgressDialog;

    .line 156
    :cond_0
    iget-object v1, p0, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;->this$0:Lcom/amazon/mShop/TaskCallbackFactory;

    # setter for: Lcom/amazon/mShop/TaskCallbackFactory;->currentTaskCallback:Lcom/amazon/mShop/control/TaskCallback;
    invoke-static {v1, v3}, Lcom/amazon/mShop/TaskCallbackFactory;->access$102(Lcom/amazon/mShop/TaskCallbackFactory;Lcom/amazon/mShop/control/TaskCallback;)Lcom/amazon/mShop/control/TaskCallback;

    .line 158
    :cond_1
    return-void

    .line 150
    :catch_0
    move-exception v0

    .line 151
    .local v0, "e":Ljava/lang/Exception;
    const-string/jumbo v1, "ProgressDialog"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method protected setProgressDialog(Lcom/amazon/mShop/AmazonProgressDialog;)V
    .locals 1
    .param p1, "progDialog"    # Lcom/amazon/mShop/AmazonProgressDialog;

    .prologue
    .line 161
    if-nez p1, :cond_0

    .line 163
    :goto_0
    return-void

    .line 162
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;->this$0:Lcom/amazon/mShop/TaskCallbackFactory;

    # setter for: Lcom/amazon/mShop/TaskCallbackFactory;->progressDialog:Lcom/amazon/mShop/AmazonProgressDialog;
    invoke-static {v0, p1}, Lcom/amazon/mShop/TaskCallbackFactory;->access$202(Lcom/amazon/mShop/TaskCallbackFactory;Lcom/amazon/mShop/AmazonProgressDialog;)Lcom/amazon/mShop/AmazonProgressDialog;

    goto :goto_0
.end method
