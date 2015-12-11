.class public final enum Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;
.super Ljava/lang/Enum;
.source "ResultWrapper.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/search/viewit/ResultWrapper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "ResultType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;

.field public static final enum BARCODE:Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;

.field public static final enum IMAGE:Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;


# instance fields
.field private mTypeValue:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 12
    new-instance v0, Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;

    const-string/jumbo v1, "BARCODE"

    const-string/jumbo v2, "barcode:"

    invoke-direct {v0, v1, v3, v2}, Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;->BARCODE:Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;

    .line 13
    new-instance v0, Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;

    const-string/jumbo v1, "IMAGE"

    const-string/jumbo v2, "image:"

    invoke-direct {v0, v1, v4, v2}, Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;->IMAGE:Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;

    .line 11
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;

    sget-object v1, Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;->BARCODE:Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;->IMAGE:Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;

    aput-object v1, v0, v4

    sput-object v0, Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;->$VALUES:[Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 1
    .param p3, "value"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 16
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 15
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;->mTypeValue:Ljava/lang/String;

    .line 17
    iput-object p3, p0, Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;->mTypeValue:Ljava/lang/String;

    .line 18
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 11
    const-class v0, Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;

    return-object v0
.end method

.method public static values()[Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;
    .locals 1

    .prologue
    .line 11
    sget-object v0, Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;->$VALUES:[Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;

    invoke-virtual {v0}, [Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;

    return-object v0
.end method


# virtual methods
.method public getTypeValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;->mTypeValue:Ljava/lang/String;

    return-object v0
.end method
