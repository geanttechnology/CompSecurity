.class Lcom/amazon/mShop/gno/GNOItemAdapter$DividerViewHolder;
.super Ljava/lang/Object;
.source "GNOItemAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/gno/GNOItemAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "DividerViewHolder"
.end annotation


# instance fields
.field dividerLine:Landroid/view/View;

.field final synthetic this$0:Lcom/amazon/mShop/gno/GNOItemAdapter;


# direct methods
.method private constructor <init>(Lcom/amazon/mShop/gno/GNOItemAdapter;)V
    .locals 0

    .prologue
    .line 539
    iput-object p1, p0, Lcom/amazon/mShop/gno/GNOItemAdapter$DividerViewHolder;->this$0:Lcom/amazon/mShop/gno/GNOItemAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/mShop/gno/GNOItemAdapter;Lcom/amazon/mShop/gno/GNOItemAdapter$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/mShop/gno/GNOItemAdapter;
    .param p2, "x1"    # Lcom/amazon/mShop/gno/GNOItemAdapter$1;

    .prologue
    .line 539
    invoke-direct {p0, p1}, Lcom/amazon/mShop/gno/GNOItemAdapter$DividerViewHolder;-><init>(Lcom/amazon/mShop/gno/GNOItemAdapter;)V

    return-void
.end method
