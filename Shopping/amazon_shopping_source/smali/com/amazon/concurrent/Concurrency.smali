.class public final Lcom/amazon/concurrent/Concurrency;
.super Ljava/lang/Object;
.source "Concurrency.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/concurrent/Concurrency$NamedThreadFactory;
    }
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 135
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static namedThreadFactory(Ljava/lang/String;)Ljava/util/concurrent/ThreadFactory;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 23
    if-nez p0, :cond_0

    .line 24
    invoke-static {}, Ljava/util/concurrent/Executors;->defaultThreadFactory()Ljava/util/concurrent/ThreadFactory;

    move-result-object v0

    .line 26
    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Lcom/amazon/concurrent/Concurrency$NamedThreadFactory;

    invoke-direct {v0, p0}, Lcom/amazon/concurrent/Concurrency$NamedThreadFactory;-><init>(Ljava/lang/String;)V

    goto :goto_0
.end method
