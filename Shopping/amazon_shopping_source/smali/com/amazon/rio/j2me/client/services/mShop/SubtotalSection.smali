.class public Lcom/amazon/rio/j2me/client/services/mShop/SubtotalSection;
.super Ljava/lang/Object;
.source "SubtotalSection.java"


# instance fields
.field private subtotal:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/Subtotal;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public setSubtotal(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/Subtotal;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 22
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/Subtotal;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/SubtotalSection;->subtotal:Ljava/util/List;

    .line 23
    return-void
.end method
