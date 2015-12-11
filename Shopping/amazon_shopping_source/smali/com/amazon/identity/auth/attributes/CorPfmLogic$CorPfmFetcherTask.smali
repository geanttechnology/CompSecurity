.class Lcom/amazon/identity/auth/attributes/CorPfmLogic$CorPfmFetcherTask;
.super Ljava/lang/Object;
.source "CorPfmLogic.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/attributes/CorPfmLogic;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "CorPfmFetcherTask"
.end annotation


# instance fields
.field final mLatch:Ljava/util/concurrent/CountDownLatch;

.field mResponse:Lcom/amazon/identity/auth/attributes/CORPFMResponse;


# direct methods
.method private constructor <init>()V
    .locals 2

    .prologue
    .line 394
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 396
    new-instance v0, Ljava/util/concurrent/CountDownLatch;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    iput-object v0, p0, Lcom/amazon/identity/auth/attributes/CorPfmLogic$CorPfmFetcherTask;->mLatch:Ljava/util/concurrent/CountDownLatch;

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/identity/auth/attributes/CorPfmLogic$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/identity/auth/attributes/CorPfmLogic$1;

    .prologue
    .line 394
    invoke-direct {p0}, Lcom/amazon/identity/auth/attributes/CorPfmLogic$CorPfmFetcherTask;-><init>()V

    return-void
.end method
