.class final Lcom/amazon/mShop/util/AmazonErrorUtils$2;
.super Ljava/lang/Object;
.source "AmazonErrorUtils.java"

# interfaces
.implements Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/util/AmazonErrorUtils;->reportErrorWithGeneralErrorMessageAndGoToAmazonHome(Lcom/amazon/mShop/AmazonActivity;I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$amazonActivity:Lcom/amazon/mShop/AmazonActivity;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/AmazonActivity;)V
    .locals 0

    .prologue
    .line 76
    iput-object p1, p0, Lcom/amazon/mShop/util/AmazonErrorUtils$2;->val$amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onActionButtonClick(I)V
    .locals 1
    .param p1, "errorId"    # I

    .prologue
    .line 80
    iget-object v0, p0, Lcom/amazon/mShop/util/AmazonErrorUtils$2;->val$amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-static {v0}, Lcom/amazon/mShop/util/ActivityUtils;->startHomeActivity(Landroid/content/Context;)Z

    .line 81
    return-void
.end method
