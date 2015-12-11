.class abstract Lcom/amazon/mShop/gno/GNOMenuItemController$CustomRunnable;
.super Ljava/lang/Object;
.source "GNOMenuItemController.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/gno/GNOMenuItemController;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x402
    name = "CustomRunnable"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/gno/GNOMenuItemController;


# direct methods
.method private constructor <init>(Lcom/amazon/mShop/gno/GNOMenuItemController;)V
    .locals 0

    .prologue
    .line 490
    iput-object p1, p0, Lcom/amazon/mShop/gno/GNOMenuItemController$CustomRunnable;->this$0:Lcom/amazon/mShop/gno/GNOMenuItemController;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/mShop/gno/GNOMenuItemController;Lcom/amazon/mShop/gno/GNOMenuItemController$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/mShop/gno/GNOMenuItemController;
    .param p2, "x1"    # Lcom/amazon/mShop/gno/GNOMenuItemController$1;

    .prologue
    .line 490
    invoke-direct {p0, p1}, Lcom/amazon/mShop/gno/GNOMenuItemController$CustomRunnable;-><init>(Lcom/amazon/mShop/gno/GNOMenuItemController;)V

    return-void
.end method


# virtual methods
.method public abstract run(Lcom/amazon/mShop/AmazonActivity;)V
.end method
