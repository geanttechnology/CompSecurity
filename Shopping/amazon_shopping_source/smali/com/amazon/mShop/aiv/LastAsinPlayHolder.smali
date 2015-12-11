.class public Lcom/amazon/mShop/aiv/LastAsinPlayHolder;
.super Ljava/lang/Object;
.source "LastAsinPlayHolder.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/aiv/LastAsinPlayHolder$1;,
        Lcom/amazon/mShop/aiv/LastAsinPlayHolder$SingletonHolder;
    }
.end annotation


# static fields
.field private static final VALID_DURATION:J


# instance fields
.field private volatile mAsin:Ljava/lang/String;

.field private volatile mStartTime:J


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 19
    sget-object v0, Ljava/util/concurrent/TimeUnit;->MINUTES:Ljava/util/concurrent/TimeUnit;

    const-wide/16 v1, 0xa

    invoke-virtual {v0, v1, v2}, Ljava/util/concurrent/TimeUnit;->toMillis(J)J

    move-result-wide v0

    sput-wide v0, Lcom/amazon/mShop/aiv/LastAsinPlayHolder;->VALID_DURATION:J

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 23
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/mShop/aiv/LastAsinPlayHolder$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/mShop/aiv/LastAsinPlayHolder$1;

    .prologue
    .line 17
    invoke-direct {p0}, Lcom/amazon/mShop/aiv/LastAsinPlayHolder;-><init>()V

    return-void
.end method

.method public static getInstance()Lcom/amazon/mShop/aiv/LastAsinPlayHolder;
    .locals 1

    .prologue
    .line 28
    # getter for: Lcom/amazon/mShop/aiv/LastAsinPlayHolder$SingletonHolder;->INSTANCE:Lcom/amazon/mShop/aiv/LastAsinPlayHolder;
    invoke-static {}, Lcom/amazon/mShop/aiv/LastAsinPlayHolder$SingletonHolder;->access$000()Lcom/amazon/mShop/aiv/LastAsinPlayHolder;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public reset()V
    .locals 2

    .prologue
    .line 67
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/aiv/LastAsinPlayHolder;->mAsin:Ljava/lang/String;

    .line 68
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lcom/amazon/mShop/aiv/LastAsinPlayHolder;->mStartTime:J

    .line 69
    return-void
.end method

.method public setAsin(Ljava/lang/String;)V
    .locals 2
    .param p1, "asin"    # Ljava/lang/String;

    .prologue
    .line 42
    if-nez p1, :cond_0

    .line 43
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "The ASIN has to be set explicitly."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 45
    :cond_0
    iput-object p1, p0, Lcom/amazon/mShop/aiv/LastAsinPlayHolder;->mAsin:Ljava/lang/String;

    .line 46
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/amazon/mShop/aiv/LastAsinPlayHolder;->mStartTime:J

    .line 47
    return-void
.end method

.method public takeAsin()Ljava/lang/String;
    .locals 8

    .prologue
    .line 57
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    .line 58
    .local v0, "currentTime":J
    iget-wide v4, p0, Lcom/amazon/mShop/aiv/LastAsinPlayHolder;->mStartTime:J

    sub-long v4, v0, v4

    sget-wide v6, Lcom/amazon/mShop/aiv/LastAsinPlayHolder;->VALID_DURATION:J

    cmp-long v4, v4, v6

    if-gtz v4, :cond_0

    const/4 v3, 0x1

    .line 59
    .local v3, "validTime":Z
    :goto_0
    if-eqz v3, :cond_1

    iget-object v2, p0, Lcom/amazon/mShop/aiv/LastAsinPlayHolder;->mAsin:Ljava/lang/String;

    .line 61
    .local v2, "result":Ljava/lang/String;
    :goto_1
    invoke-virtual {p0}, Lcom/amazon/mShop/aiv/LastAsinPlayHolder;->reset()V

    .line 63
    return-object v2

    .line 58
    .end local v2    # "result":Ljava/lang/String;
    .end local v3    # "validTime":Z
    :cond_0
    const/4 v3, 0x0

    goto :goto_0

    .line 59
    .restart local v3    # "validTime":Z
    :cond_1
    const/4 v2, 0x0

    goto :goto_1
.end method
