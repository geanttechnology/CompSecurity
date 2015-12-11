.class public Lcom/amazon/rio/j2me/client/services/mShop/Notification;
.super Ljava/lang/Object;
.source "Notification.java"


# instance fields
.field private message:Ljava/lang/String;

.field private title:Ljava/lang/String;

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
.method public getMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/Notification;->message:Ljava/lang/String;

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/Notification;->title:Ljava/lang/String;

    return-object v0
.end method

.method public getType()I
    .locals 1

    .prologue
    .line 42
    iget v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/Notification;->type:I

    return v0
.end method

.method public setMessage(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 37
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Notification;->message:Ljava/lang/String;

    .line 38
    return-void
.end method

.method public setTitle(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 27
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Notification;->title:Ljava/lang/String;

    .line 28
    return-void
.end method

.method public setType(I)V
    .locals 0
    .param p1, "value_"    # I

    .prologue
    .line 47
    iput p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Notification;->type:I

    .line 48
    return-void
.end method
