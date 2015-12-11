.class public Lcom/amazon/rio/j2me/client/services/mShop/PurchaseStatus;
.super Ljava/lang/Object;
.source "PurchaseStatus.java"


# instance fields
.field private gcRemainingBalance:Ljava/lang/String;

.field private message:Ljava/lang/String;

.field private nextStep:Ljava/lang/String;

.field private status:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
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
.method public getNextStep()Ljava/lang/String;
    .locals 1

    .prologue
    .line 23
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/PurchaseStatus;->nextStep:Ljava/lang/String;

    return-object v0
.end method

.method public setGcRemainingBalance(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 54
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PurchaseStatus;->gcRemainingBalance:Ljava/lang/String;

    .line 55
    return-void
.end method

.method public setMessage(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 67
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PurchaseStatus;->message:Ljava/lang/String;

    .line 68
    return-void
.end method

.method public setNextStep(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 28
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PurchaseStatus;->nextStep:Ljava/lang/String;

    .line 29
    return-void
.end method

.method public setStatus(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 41
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PurchaseStatus;->status:Ljava/util/List;

    .line 42
    return-void
.end method
