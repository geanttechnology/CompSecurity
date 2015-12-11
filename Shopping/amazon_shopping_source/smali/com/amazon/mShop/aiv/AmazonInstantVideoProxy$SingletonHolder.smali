.class Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$SingletonHolder;
.super Ljava/lang/Object;
.source "AmazonInstantVideoProxy.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "SingletonHolder"
.end annotation


# static fields
.field private static final INSTANCE:Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 53
    new-instance v0, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;

    invoke-direct {v0}, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;-><init>()V

    sput-object v0, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$SingletonHolder;->INSTANCE:Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 52
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$000()Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;
    .locals 1

    .prologue
    .line 52
    sget-object v0, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$SingletonHolder;->INSTANCE:Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;

    return-object v0
.end method
