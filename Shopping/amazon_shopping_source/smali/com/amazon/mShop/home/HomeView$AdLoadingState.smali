.class final enum Lcom/amazon/mShop/home/HomeView$AdLoadingState;
.super Ljava/lang/Enum;
.source "HomeView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/home/HomeView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x401a
    name = "AdLoadingState"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/mShop/home/HomeView$AdLoadingState;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/mShop/home/HomeView$AdLoadingState;

.field public static final enum FAILURE:Lcom/amazon/mShop/home/HomeView$AdLoadingState;

.field public static final enum INIT:Lcom/amazon/mShop/home/HomeView$AdLoadingState;

.field public static final enum LOADING:Lcom/amazon/mShop/home/HomeView$AdLoadingState;

.field public static final enum SUCCESS:Lcom/amazon/mShop/home/HomeView$AdLoadingState;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 235
    new-instance v0, Lcom/amazon/mShop/home/HomeView$AdLoadingState;

    const-string/jumbo v1, "INIT"

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/home/HomeView$AdLoadingState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/home/HomeView$AdLoadingState;->INIT:Lcom/amazon/mShop/home/HomeView$AdLoadingState;

    new-instance v0, Lcom/amazon/mShop/home/HomeView$AdLoadingState;

    const-string/jumbo v1, "LOADING"

    invoke-direct {v0, v1, v3}, Lcom/amazon/mShop/home/HomeView$AdLoadingState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/home/HomeView$AdLoadingState;->LOADING:Lcom/amazon/mShop/home/HomeView$AdLoadingState;

    new-instance v0, Lcom/amazon/mShop/home/HomeView$AdLoadingState;

    const-string/jumbo v1, "SUCCESS"

    invoke-direct {v0, v1, v4}, Lcom/amazon/mShop/home/HomeView$AdLoadingState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/home/HomeView$AdLoadingState;->SUCCESS:Lcom/amazon/mShop/home/HomeView$AdLoadingState;

    new-instance v0, Lcom/amazon/mShop/home/HomeView$AdLoadingState;

    const-string/jumbo v1, "FAILURE"

    invoke-direct {v0, v1, v5}, Lcom/amazon/mShop/home/HomeView$AdLoadingState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/home/HomeView$AdLoadingState;->FAILURE:Lcom/amazon/mShop/home/HomeView$AdLoadingState;

    .line 234
    const/4 v0, 0x4

    new-array v0, v0, [Lcom/amazon/mShop/home/HomeView$AdLoadingState;

    sget-object v1, Lcom/amazon/mShop/home/HomeView$AdLoadingState;->INIT:Lcom/amazon/mShop/home/HomeView$AdLoadingState;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/mShop/home/HomeView$AdLoadingState;->LOADING:Lcom/amazon/mShop/home/HomeView$AdLoadingState;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/mShop/home/HomeView$AdLoadingState;->SUCCESS:Lcom/amazon/mShop/home/HomeView$AdLoadingState;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/mShop/home/HomeView$AdLoadingState;->FAILURE:Lcom/amazon/mShop/home/HomeView$AdLoadingState;

    aput-object v1, v0, v5

    sput-object v0, Lcom/amazon/mShop/home/HomeView$AdLoadingState;->$VALUES:[Lcom/amazon/mShop/home/HomeView$AdLoadingState;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 234
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/mShop/home/HomeView$AdLoadingState;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 234
    const-class v0, Lcom/amazon/mShop/home/HomeView$AdLoadingState;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/home/HomeView$AdLoadingState;

    return-object v0
.end method

.method public static values()[Lcom/amazon/mShop/home/HomeView$AdLoadingState;
    .locals 1

    .prologue
    .line 234
    sget-object v0, Lcom/amazon/mShop/home/HomeView$AdLoadingState;->$VALUES:[Lcom/amazon/mShop/home/HomeView$AdLoadingState;

    invoke-virtual {v0}, [Lcom/amazon/mShop/home/HomeView$AdLoadingState;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/mShop/home/HomeView$AdLoadingState;

    return-object v0
.end method
