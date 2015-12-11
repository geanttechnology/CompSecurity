.class final Lcom/amazon/mShop/util/UIUtils$2;
.super Ljava/lang/Object;
.source "UIUtils.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/util/UIUtils;->alert(Landroid/content/Context;Ljava/lang/String;Landroid/content/DialogInterface$OnDismissListener;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$context:Landroid/content/Context;

.field final synthetic val$dismissListener:Landroid/content/DialogInterface$OnDismissListener;

.field final synthetic val$msg:Ljava/lang/String;


# direct methods
.method constructor <init>(Landroid/content/Context;Ljava/lang/String;Landroid/content/DialogInterface$OnDismissListener;)V
    .locals 0

    .prologue
    .line 429
    iput-object p1, p0, Lcom/amazon/mShop/util/UIUtils$2;->val$context:Landroid/content/Context;

    iput-object p2, p0, Lcom/amazon/mShop/util/UIUtils$2;->val$msg:Ljava/lang/String;

    iput-object p3, p0, Lcom/amazon/mShop/util/UIUtils$2;->val$dismissListener:Landroid/content/DialogInterface$OnDismissListener;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 433
    new-instance v0, Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    iget-object v2, p0, Lcom/amazon/mShop/util/UIUtils$2;->val$context:Landroid/content/Context;

    invoke-direct {v0, v2}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 434
    .local v0, "builder":Lcom/amazon/mShop/AmazonAlertDialog$Builder;
    iget-object v2, p0, Lcom/amazon/mShop/util/UIUtils$2;->val$msg:Ljava/lang/String;

    invoke-virtual {v0, v2}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    .line 435
    invoke-virtual {v0, v3}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setCancelable(Z)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    .line 436
    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->create()Lcom/amazon/mShop/AmazonAlertDialog;

    move-result-object v1

    .line 437
    .local v1, "dialog":Lcom/amazon/mShop/AmazonAlertDialog;
    iget-object v2, p0, Lcom/amazon/mShop/util/UIUtils$2;->val$dismissListener:Landroid/content/DialogInterface$OnDismissListener;

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/AmazonAlertDialog;->setOnDismissListener(Landroid/content/DialogInterface$OnDismissListener;)V

    .line 438
    invoke-virtual {v1, v3}, Lcom/amazon/mShop/AmazonAlertDialog;->setCanceledOnTouchOutside(Z)V

    .line 439
    invoke-virtual {v1, v3}, Lcom/amazon/mShop/AmazonAlertDialog;->setDismissedOnTrackBall(Z)V

    .line 440
    invoke-virtual {v1}, Lcom/amazon/mShop/AmazonAlertDialog;->show()V

    .line 441
    return-void
.end method
