.class public Lcom/amazon/android/service/BackgroundPriorityThreadFactory$PriorityWrapper;
.super Ljava/lang/Object;
.source "BackgroundPriorityThreadFactory.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/android/service/BackgroundPriorityThreadFactory;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xc
    name = "PriorityWrapper"
.end annotation


# static fields
.field private static final LOG:Lcom/amazon/logging/Logger;


# instance fields
.field private final name:Ljava/lang/String;

.field private final priority:I

.field private final runnable:Ljava/lang/Runnable;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 59
    const-class v0, Lcom/amazon/android/service/BackgroundPriorityThreadFactory$PriorityWrapper;

    invoke-static {v0}, Lcom/amazon/logging/Logger;->getLogger(Ljava/lang/Class;)Lcom/amazon/logging/Logger;

    move-result-object v0

    sput-object v0, Lcom/amazon/android/service/BackgroundPriorityThreadFactory$PriorityWrapper;->LOG:Lcom/amazon/logging/Logger;

    return-void
.end method

.method protected constructor <init>(Ljava/lang/Runnable;ILjava/lang/String;)V
    .locals 0
    .param p1, "runnable"    # Ljava/lang/Runnable;
    .param p2, "priority"    # I
    .param p3, "name"    # Ljava/lang/String;

    .prologue
    .line 79
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 80
    iput-object p1, p0, Lcom/amazon/android/service/BackgroundPriorityThreadFactory$PriorityWrapper;->runnable:Ljava/lang/Runnable;

    .line 81
    iput p2, p0, Lcom/amazon/android/service/BackgroundPriorityThreadFactory$PriorityWrapper;->priority:I

    .line 82
    iput-object p3, p0, Lcom/amazon/android/service/BackgroundPriorityThreadFactory$PriorityWrapper;->name:Ljava/lang/String;

    .line 83
    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    const/16 v4, 0xa

    .line 88
    :try_start_0
    iget v1, p0, Lcom/amazon/android/service/BackgroundPriorityThreadFactory$PriorityWrapper;->priority:I

    invoke-static {v1}, Landroid/os/Process;->setThreadPriority(I)V

    .line 89
    sget-object v1, Lcom/amazon/android/service/BackgroundPriorityThreadFactory$PriorityWrapper;->LOG:Lcom/amazon/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/amazon/android/service/BackgroundPriorityThreadFactory$PriorityWrapper;->name:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, ": set thread priority to "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const/16 v3, 0xa

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/logging/Logger;->d(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_1

    .line 100
    :goto_0
    iget-object v1, p0, Lcom/amazon/android/service/BackgroundPriorityThreadFactory$PriorityWrapper;->runnable:Ljava/lang/Runnable;

    invoke-interface {v1}, Ljava/lang/Runnable;->run()V

    .line 101
    return-void

    .line 90
    :catch_0
    move-exception v0

    .line 91
    .local v0, "e":Ljava/lang/SecurityException;
    sget-object v1, Lcom/amazon/android/service/BackgroundPriorityThreadFactory$PriorityWrapper;->LOG:Lcom/amazon/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/amazon/android/service/BackgroundPriorityThreadFactory$PriorityWrapper;->name:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, ": SecurityException caught, could not set thread priority to "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2, v0}, Lcom/amazon/logging/Logger;->w(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 94
    .end local v0    # "e":Ljava/lang/SecurityException;
    :catch_1
    move-exception v0

    .line 95
    .local v0, "e":Ljava/lang/IllegalArgumentException;
    sget-object v1, Lcom/amazon/android/service/BackgroundPriorityThreadFactory$PriorityWrapper;->LOG:Lcom/amazon/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/amazon/android/service/BackgroundPriorityThreadFactory$PriorityWrapper;->name:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, ": IllegalArgumentException caught, could not set thread priority to "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2, v0}, Lcom/amazon/logging/Logger;->w(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method
