.class Lcom/amazon/mShop/gno/GNODrawerItemSimple$ViewHolder;
.super Ljava/lang/Object;
.source "GNODrawerItemSimple.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/gno/GNODrawerItemSimple;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ViewHolder"
.end annotation


# instance fields
.field subViewId:I

.field subViewWrapper:Landroid/widget/FrameLayout;

.field text:Landroid/widget/TextView;

.field final synthetic this$0:Lcom/amazon/mShop/gno/GNODrawerItemSimple;


# direct methods
.method private constructor <init>(Lcom/amazon/mShop/gno/GNODrawerItemSimple;)V
    .locals 0

    .prologue
    .line 121
    iput-object p1, p0, Lcom/amazon/mShop/gno/GNODrawerItemSimple$ViewHolder;->this$0:Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/mShop/gno/GNODrawerItemSimple;Lcom/amazon/mShop/gno/GNODrawerItemSimple$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/mShop/gno/GNODrawerItemSimple;
    .param p2, "x1"    # Lcom/amazon/mShop/gno/GNODrawerItemSimple$1;

    .prologue
    .line 121
    invoke-direct {p0, p1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$ViewHolder;-><init>(Lcom/amazon/mShop/gno/GNODrawerItemSimple;)V

    return-void
.end method
