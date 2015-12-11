.class Lcom/amazon/mShop/aiv/LastAsinPlayHolder$SingletonHolder;
.super Ljava/lang/Object;
.source "LastAsinPlayHolder.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/aiv/LastAsinPlayHolder;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "SingletonHolder"
.end annotation


# static fields
.field private static final INSTANCE:Lcom/amazon/mShop/aiv/LastAsinPlayHolder;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 32
    new-instance v0, Lcom/amazon/mShop/aiv/LastAsinPlayHolder;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/amazon/mShop/aiv/LastAsinPlayHolder;-><init>(Lcom/amazon/mShop/aiv/LastAsinPlayHolder$1;)V

    sput-object v0, Lcom/amazon/mShop/aiv/LastAsinPlayHolder$SingletonHolder;->INSTANCE:Lcom/amazon/mShop/aiv/LastAsinPlayHolder;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 31
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$000()Lcom/amazon/mShop/aiv/LastAsinPlayHolder;
    .locals 1

    .prologue
    .line 31
    sget-object v0, Lcom/amazon/mShop/aiv/LastAsinPlayHolder$SingletonHolder;->INSTANCE:Lcom/amazon/mShop/aiv/LastAsinPlayHolder;

    return-object v0
.end method
