.class public final Lcom/amazon/android/service/BackgroundPriorityThreadFactory;
.super Ljava/lang/Object;
.source "BackgroundPriorityThreadFactory.java"

# interfaces
.implements Ljava/util/concurrent/ThreadFactory;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/android/service/BackgroundPriorityThreadFactory$PriorityWrapper;
    }
.end annotation


# static fields
.field private static final LOG:Lcom/amazon/logging/Logger;


# instance fields
.field private final mCount:Ljava/util/concurrent/atomic/AtomicInteger;

.field private final prefix:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 16
    const-class v0, Lcom/amazon/android/service/BackgroundPriorityThreadFactory;

    invoke-static {v0}, Lcom/amazon/logging/Logger;->getLogger(Ljava/lang/Class;)Lcom/amazon/logging/Logger;

    move-result-object v0

    sput-object v0, Lcom/amazon/android/service/BackgroundPriorityThreadFactory;->LOG:Lcom/amazon/logging/Logger;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 2
    .param p1, "prefix"    # Ljava/lang/String;

    .prologue
    .line 37
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    new-instance v0, Ljava/util/concurrent/atomic/AtomicInteger;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>(I)V

    iput-object v0, p0, Lcom/amazon/android/service/BackgroundPriorityThreadFactory;->mCount:Ljava/util/concurrent/atomic/AtomicInteger;

    .line 38
    sget-object v0, Lcom/amazon/android/service/BackgroundPriorityThreadFactory;->LOG:Lcom/amazon/logging/Logger;

    const-string/jumbo v1, "BackgroundPriorityThreadFactory is created"

    invoke-virtual {v0, v1}, Lcom/amazon/logging/Logger;->d(Ljava/lang/String;)V

    .line 39
    iput-object p1, p0, Lcom/amazon/android/service/BackgroundPriorityThreadFactory;->prefix:Ljava/lang/String;

    .line 40
    return-void
.end method


# virtual methods
.method public newThread(Ljava/lang/Runnable;)Ljava/lang/Thread;
    .locals 4
    .param p1, "r"    # Ljava/lang/Runnable;

    .prologue
    .line 49
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/amazon/android/service/BackgroundPriorityThreadFactory;->prefix:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, " #"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/android/service/BackgroundPriorityThreadFactory;->mCount:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v2}, Ljava/util/concurrent/atomic/AtomicInteger;->getAndIncrement()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 50
    .local v0, "name":Ljava/lang/String;
    new-instance v1, Ljava/lang/Thread;

    new-instance v2, Lcom/amazon/android/service/BackgroundPriorityThreadFactory$PriorityWrapper;

    const/16 v3, 0xa

    invoke-direct {v2, p1, v3, v0}, Lcom/amazon/android/service/BackgroundPriorityThreadFactory$PriorityWrapper;-><init>(Ljava/lang/Runnable;ILjava/lang/String;)V

    invoke-direct {v1, v2, v0}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;Ljava/lang/String;)V

    return-object v1
.end method
