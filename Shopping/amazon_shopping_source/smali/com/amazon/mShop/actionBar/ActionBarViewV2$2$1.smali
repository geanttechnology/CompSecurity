.class Lcom/amazon/mShop/actionBar/ActionBarViewV2$2$1;
.super Ljava/lang/Object;
.source "ActionBarViewV2.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/actionBar/ActionBarViewV2$2;->onClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/actionBar/ActionBarViewV2$2;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/actionBar/ActionBarViewV2$2;)V
    .locals 0

    .prologue
    .line 89
    iput-object p1, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2$2$1;->this$1:Lcom/amazon/mShop/actionBar/ActionBarViewV2$2;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 92
    iget-object v0, p0, Lcom/amazon/mShop/actionBar/ActionBarViewV2$2$1;->this$1:Lcom/amazon/mShop/actionBar/ActionBarViewV2$2;

    iget-object v0, v0, Lcom/amazon/mShop/actionBar/ActionBarViewV2$2;->this$0:Lcom/amazon/mShop/actionBar/ActionBarViewV2;

    # getter for: Lcom/amazon/mShop/actionBar/ActionBarViewV2;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v0}, Lcom/amazon/mShop/actionBar/ActionBarViewV2;->access$100(Lcom/amazon/mShop/actionBar/ActionBarViewV2;)Lcom/amazon/mShop/AmazonActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/util/ActivityUtils;->startHomeActivity(Landroid/content/Context;)Z

    .line 93
    const-string/jumbo v0, "gno_logo"

    invoke-static {v0}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 94
    return-void
.end method
