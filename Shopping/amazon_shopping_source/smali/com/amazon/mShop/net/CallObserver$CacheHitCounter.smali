.class Lcom/amazon/mShop/net/CallObserver$CacheHitCounter;
.super Ljava/lang/Object;
.source "CallObserver.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/net/CallObserver;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "CacheHitCounter"
.end annotation


# instance fields
.field hitCount:I

.field totalCount:I


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 112
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/mShop/net/CallObserver$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/mShop/net/CallObserver$1;

    .prologue
    .line 112
    invoke-direct {p0}, Lcom/amazon/mShop/net/CallObserver$CacheHitCounter;-><init>()V

    return-void
.end method
