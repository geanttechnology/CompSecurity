.class public Lcom/amazon/mShop/TaskCallbackFactory;
.super Ljava/lang/Object;
.source "TaskCallbackFactory.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/TaskCallbackFactory$1;,
        Lcom/amazon/mShop/TaskCallbackFactory$LocaleSwithchTaskCallback;,
        Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;
    }
.end annotation


# instance fields
.field private final context:Landroid/content/Context;

.field private currentTaskCallback:Lcom/amazon/mShop/control/TaskCallback;

.field private progressDialog:Lcom/amazon/mShop/AmazonProgressDialog;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 207
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 208
    iput-object p1, p0, Lcom/amazon/mShop/TaskCallbackFactory;->context:Landroid/content/Context;

    .line 209
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/TaskCallbackFactory;)Landroid/content/Context;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/TaskCallbackFactory;

    .prologue
    .line 18
    iget-object v0, p0, Lcom/amazon/mShop/TaskCallbackFactory;->context:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/mShop/TaskCallbackFactory;)Lcom/amazon/mShop/control/TaskCallback;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/TaskCallbackFactory;

    .prologue
    .line 18
    iget-object v0, p0, Lcom/amazon/mShop/TaskCallbackFactory;->currentTaskCallback:Lcom/amazon/mShop/control/TaskCallback;

    return-object v0
.end method

.method static synthetic access$102(Lcom/amazon/mShop/TaskCallbackFactory;Lcom/amazon/mShop/control/TaskCallback;)Lcom/amazon/mShop/control/TaskCallback;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/TaskCallbackFactory;
    .param p1, "x1"    # Lcom/amazon/mShop/control/TaskCallback;

    .prologue
    .line 18
    iput-object p1, p0, Lcom/amazon/mShop/TaskCallbackFactory;->currentTaskCallback:Lcom/amazon/mShop/control/TaskCallback;

    return-object p1
.end method

.method static synthetic access$200(Lcom/amazon/mShop/TaskCallbackFactory;)Lcom/amazon/mShop/AmazonProgressDialog;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/TaskCallbackFactory;

    .prologue
    .line 18
    iget-object v0, p0, Lcom/amazon/mShop/TaskCallbackFactory;->progressDialog:Lcom/amazon/mShop/AmazonProgressDialog;

    return-object v0
.end method

.method static synthetic access$202(Lcom/amazon/mShop/TaskCallbackFactory;Lcom/amazon/mShop/AmazonProgressDialog;)Lcom/amazon/mShop/AmazonProgressDialog;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/TaskCallbackFactory;
    .param p1, "x1"    # Lcom/amazon/mShop/AmazonProgressDialog;

    .prologue
    .line 18
    iput-object p1, p0, Lcom/amazon/mShop/TaskCallbackFactory;->progressDialog:Lcom/amazon/mShop/AmazonProgressDialog;

    return-object p1
.end method


# virtual methods
.method public getFinishTaskCallback(Lcom/amazon/mShop/control/Cancellable;Lcom/amazon/mShop/AmazonActivity;I)Lcom/amazon/mShop/control/TaskCallback;
    .locals 7
    .param p1, "cancellable"    # Lcom/amazon/mShop/control/Cancellable;
    .param p2, "amazonActivity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p3, "title"    # I

    .prologue
    .line 271
    new-instance v0, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;

    const/4 v4, 0x1

    const/4 v6, 0x0

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move v5, p3

    invoke-direct/range {v0 .. v6}, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;-><init>(Lcom/amazon/mShop/TaskCallbackFactory;Lcom/amazon/mShop/control/Cancellable;Lcom/amazon/mShop/AmazonActivity;ZILcom/amazon/mShop/TaskCallbackFactory$1;)V

    return-object v0
.end method

.method public getFinishTaskCallback(Lcom/amazon/mShop/control/Cancellable;Lcom/amazon/mShop/AmazonActivity;Ljava/lang/String;)Lcom/amazon/mShop/control/TaskCallback;
    .locals 7
    .param p1, "cancellable"    # Lcom/amazon/mShop/control/Cancellable;
    .param p2, "amazonActivity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p3, "title"    # Ljava/lang/String;

    .prologue
    .line 286
    new-instance v0, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;

    const/4 v4, 0x1

    const/4 v6, 0x0

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v5, p3

    invoke-direct/range {v0 .. v6}, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;-><init>(Lcom/amazon/mShop/TaskCallbackFactory;Lcom/amazon/mShop/control/Cancellable;Lcom/amazon/mShop/AmazonActivity;ZLjava/lang/String;Lcom/amazon/mShop/TaskCallbackFactory$1;)V

    return-object v0
.end method

.method public getLocaleSwitchFinishTaskCallback(Lcom/amazon/mShop/control/Cancellable;Lcom/amazon/mShop/AmazonActivity;Ljava/lang/String;Lcom/amazon/mShop/AmazonProgressDialog;)Lcom/amazon/mShop/control/TaskCallback;
    .locals 8
    .param p1, "cancellable"    # Lcom/amazon/mShop/control/Cancellable;
    .param p2, "amazonActivity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p3, "title"    # Ljava/lang/String;
    .param p4, "progressDialog"    # Lcom/amazon/mShop/AmazonProgressDialog;

    .prologue
    .line 307
    new-instance v0, Lcom/amazon/mShop/TaskCallbackFactory$LocaleSwithchTaskCallback;

    const/4 v4, 0x1

    const/4 v7, 0x0

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v5, p3

    move-object v6, p4

    invoke-direct/range {v0 .. v7}, Lcom/amazon/mShop/TaskCallbackFactory$LocaleSwithchTaskCallback;-><init>(Lcom/amazon/mShop/TaskCallbackFactory;Lcom/amazon/mShop/control/Cancellable;Lcom/amazon/mShop/AmazonActivity;ZLjava/lang/String;Lcom/amazon/mShop/AmazonProgressDialog;Lcom/amazon/mShop/TaskCallbackFactory$1;)V

    return-object v0
.end method

.method public getPopViewTaskCallback(Lcom/amazon/mShop/control/Cancellable;Lcom/amazon/mShop/AmazonActivity;I)Lcom/amazon/mShop/control/TaskCallback;
    .locals 7
    .param p1, "cancellable"    # Lcom/amazon/mShop/control/Cancellable;
    .param p2, "amazonActivity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p3, "title"    # I

    .prologue
    .line 255
    new-instance v0, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;

    const/4 v4, 0x0

    const/4 v6, 0x0

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move v5, p3

    invoke-direct/range {v0 .. v6}, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;-><init>(Lcom/amazon/mShop/TaskCallbackFactory;Lcom/amazon/mShop/control/Cancellable;Lcom/amazon/mShop/AmazonActivity;ZILcom/amazon/mShop/TaskCallbackFactory$1;)V

    return-object v0
.end method

.method public getTaskCallback(Lcom/amazon/mShop/control/Cancellable;)Lcom/amazon/mShop/control/TaskCallback;
    .locals 6
    .param p1, "cancellable"    # Lcom/amazon/mShop/control/Cancellable;

    .prologue
    const/4 v3, 0x0

    .line 239
    new-instance v0, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;

    const/4 v4, 0x0

    move-object v1, p0

    move-object v2, p1

    move-object v5, v3

    invoke-direct/range {v0 .. v5}, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;-><init>(Lcom/amazon/mShop/TaskCallbackFactory;Lcom/amazon/mShop/control/Cancellable;Lcom/amazon/mShop/AmazonActivity;ZLcom/amazon/mShop/TaskCallbackFactory$1;)V

    return-object v0
.end method

.method public getTaskCallback(Lcom/amazon/mShop/control/Cancellable;I)Lcom/amazon/mShop/control/TaskCallback;
    .locals 7
    .param p1, "cancellable"    # Lcom/amazon/mShop/control/Cancellable;
    .param p2, "title"    # I

    .prologue
    const/4 v3, 0x0

    .line 220
    new-instance v0, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;

    const/4 v4, 0x0

    move-object v1, p0

    move-object v2, p1

    move v5, p2

    move-object v6, v3

    invoke-direct/range {v0 .. v6}, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;-><init>(Lcom/amazon/mShop/TaskCallbackFactory;Lcom/amazon/mShop/control/Cancellable;Lcom/amazon/mShop/AmazonActivity;ZILcom/amazon/mShop/TaskCallbackFactory$1;)V

    return-object v0
.end method

.method public getTaskCallback(Lcom/amazon/mShop/control/Cancellable;Ljava/lang/String;)Lcom/amazon/mShop/control/TaskCallback;
    .locals 7
    .param p1, "cancellable"    # Lcom/amazon/mShop/control/Cancellable;
    .param p2, "title"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x0

    .line 229
    new-instance v0, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;

    const/4 v4, 0x0

    move-object v1, p0

    move-object v2, p1

    move-object v5, p2

    move-object v6, v3

    invoke-direct/range {v0 .. v6}, Lcom/amazon/mShop/TaskCallbackFactory$MyTaskCallback;-><init>(Lcom/amazon/mShop/TaskCallbackFactory;Lcom/amazon/mShop/control/Cancellable;Lcom/amazon/mShop/AmazonActivity;ZLjava/lang/String;Lcom/amazon/mShop/TaskCallbackFactory$1;)V

    return-object v0
.end method
