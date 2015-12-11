.class public Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;
.super Ljava/lang/Object;
.source "NotificationTarget.java"


# instance fields
.field private applicationId:Ljava/lang/String;

.field private destination:Ljava/lang/String;

.field private type:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getApplicationId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;->applicationId:Ljava/lang/String;

    return-object v0
.end method

.method public getDestination()Ljava/lang/String;
    .locals 1

    .prologue
    .line 19
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;->destination:Ljava/lang/String;

    return-object v0
.end method

.method public getType()I
    .locals 1

    .prologue
    .line 39
    iget v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;->type:I

    return v0
.end method

.method public setApplicationId(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 34
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;->applicationId:Ljava/lang/String;

    .line 35
    return-void
.end method

.method public setDestination(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 24
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;->destination:Ljava/lang/String;

    .line 25
    return-void
.end method

.method public setType(I)V
    .locals 0
    .param p1, "value_"    # I

    .prologue
    .line 44
    iput p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;->type:I

    .line 45
    return-void
.end method
