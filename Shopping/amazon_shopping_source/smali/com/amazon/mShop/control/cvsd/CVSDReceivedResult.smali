.class public Lcom/amazon/mShop/control/cvsd/CVSDReceivedResult;
.super Ljava/lang/Object;
.source "CVSDReceivedResult.java"


# static fields
.field public static message:Ljava/lang/String;

.field public static receivedAddresss:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/Address;",
            ">;"
        }
    .end annotation
.end field

.field public static receivedType:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 14
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    sput-object v0, Lcom/amazon/mShop/control/cvsd/CVSDReceivedResult;->receivedAddresss:Ljava/util/List;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 8
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static reset()V
    .locals 1

    .prologue
    .line 17
    const/4 v0, -0x1

    sput v0, Lcom/amazon/mShop/control/cvsd/CVSDReceivedResult;->receivedType:I

    .line 18
    const/4 v0, 0x0

    sput-object v0, Lcom/amazon/mShop/control/cvsd/CVSDReceivedResult;->message:Ljava/lang/String;

    .line 19
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    sput-object v0, Lcom/amazon/mShop/control/cvsd/CVSDReceivedResult;->receivedAddresss:Ljava/util/List;

    .line 20
    return-void
.end method
