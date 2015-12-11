.class final Lcom/amazon/mShop/actionBar/ActionBarHelper$1;
.super Ljava/lang/Object;
.source "ActionBarHelper.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/actionBar/ActionBarHelper;->applyWebGatewayCustomizedActionBar(Lcom/amazon/mShop/AmazonActivity;Landroid/view/View;Landroid/view/View;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$webGatewayBar:Landroid/view/View;


# direct methods
.method constructor <init>(Landroid/view/View;)V
    .locals 0

    .prologue
    .line 90
    iput-object p1, p0, Lcom/amazon/mShop/actionBar/ActionBarHelper$1;->val$webGatewayBar:Landroid/view/View;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 93
    iget-object v0, p0, Lcom/amazon/mShop/actionBar/ActionBarHelper$1;->val$webGatewayBar:Landroid/view/View;

    check-cast v0, Lcom/amazon/mShop/DelayedInitView;

    invoke-interface {v0}, Lcom/amazon/mShop/DelayedInitView;->onPushViewCompleted()V

    .line 94
    return-void
.end method
