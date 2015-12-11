.class public Lcom/amazon/zeroes/intentservice/command/RetryCommand;
.super Ljava/lang/Object;
.source "RetryCommand.java"

# interfaces
.implements Lcom/amazon/zeroes/intentservice/command/ZeroesCommand;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/zeroes/intentservice/command/RetryCommand$Validator;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/amazon/zeroes/intentservice/command/ZeroesCommand",
        "<TT;>;"
    }
.end annotation


# instance fields
.field private final command:Lcom/amazon/zeroes/intentservice/command/ZeroesCommand;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/zeroes/intentservice/command/ZeroesCommand",
            "<TT;>;"
        }
    .end annotation
.end field

.field private final retryCount:I

.field private final validator:Lcom/amazon/zeroes/intentservice/command/RetryCommand$Validator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/zeroes/intentservice/command/RetryCommand$Validator",
            "<TT;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(ILcom/amazon/zeroes/intentservice/command/ZeroesCommand;Lcom/amazon/zeroes/intentservice/command/RetryCommand$Validator;)V
    .locals 2
    .param p1, "retryCount"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Lcom/amazon/zeroes/intentservice/command/ZeroesCommand",
            "<TT;>;",
            "Lcom/amazon/zeroes/intentservice/command/RetryCommand$Validator",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 41
    .local p0, "this":Lcom/amazon/zeroes/intentservice/command/RetryCommand;, "Lcom/amazon/zeroes/intentservice/command/RetryCommand<TT;>;"
    .local p2, "command":Lcom/amazon/zeroes/intentservice/command/ZeroesCommand;, "Lcom/amazon/zeroes/intentservice/command/ZeroesCommand<TT;>;"
    .local p3, "validator":Lcom/amazon/zeroes/intentservice/command/RetryCommand$Validator;, "Lcom/amazon/zeroes/intentservice/command/RetryCommand$Validator<TT;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 42
    if-nez p2, :cond_0

    .line 43
    new-instance v0, Ljava/lang/NullPointerException;

    const-string/jumbo v1, "command must not be null"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 46
    :cond_0
    if-nez p3, :cond_1

    .line 47
    new-instance v0, Ljava/lang/NullPointerException;

    const-string/jumbo v1, "validator must not be null"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 50
    :cond_1
    iput-object p2, p0, Lcom/amazon/zeroes/intentservice/command/RetryCommand;->command:Lcom/amazon/zeroes/intentservice/command/ZeroesCommand;

    .line 51
    iput-object p3, p0, Lcom/amazon/zeroes/intentservice/command/RetryCommand;->validator:Lcom/amazon/zeroes/intentservice/command/RetryCommand$Validator;

    .line 52
    if-gez p1, :cond_2

    .line 53
    const/4 v0, 0x5

    iput v0, p0, Lcom/amazon/zeroes/intentservice/command/RetryCommand;->retryCount:I

    .line 57
    :goto_0
    return-void

    .line 55
    :cond_2
    iput p1, p0, Lcom/amazon/zeroes/intentservice/command/RetryCommand;->retryCount:I

    goto :goto_0
.end method


# virtual methods
.method public perform()Ljava/lang/Object;
    .locals 12
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .line 64
    .local p0, "this":Lcom/amazon/zeroes/intentservice/command/RetryCommand;, "Lcom/amazon/zeroes/intentservice/command/RetryCommand<TT;>;"
    const/4 v4, 0x0

    .line 65
    .local v4, "tries":I
    const/4 v1, 0x0

    .local v1, "result":Ljava/lang/Object;, "TT;"
    move v5, v4

    .line 67
    .end local v1    # "result":Ljava/lang/Object;, "TT;"
    .end local v4    # "tries":I
    .local v5, "tries":I
    :goto_0
    if-lez v5, :cond_0

    .line 69
    const-wide v6, 0x407f400000000000L    # 500.0

    int-to-double v8, v5

    const-wide/high16 v10, 0x3ff8000000000000L    # 1.5

    :try_start_0
    invoke-static {v8, v9, v10, v11}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v8

    mul-double v2, v6, v8

    .line 70
    .local v2, "sleepTime":D
    double-to-long v6, v2

    invoke-static {v6, v7}, Ljava/lang/Thread;->sleep(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 77
    .end local v2    # "sleepTime":D
    :cond_0
    iget-object v6, p0, Lcom/amazon/zeroes/intentservice/command/RetryCommand;->command:Lcom/amazon/zeroes/intentservice/command/ZeroesCommand;

    invoke-interface {v6}, Lcom/amazon/zeroes/intentservice/command/ZeroesCommand;->perform()Ljava/lang/Object;

    move-result-object v1

    .line 78
    .restart local v1    # "result":Ljava/lang/Object;, "TT;"
    if-nez v1, :cond_2

    .line 82
    :cond_1
    add-int/lit8 v4, v5, 0x1

    .end local v5    # "tries":I
    .restart local v4    # "tries":I
    iget v6, p0, Lcom/amazon/zeroes/intentservice/command/RetryCommand;->retryCount:I

    if-lt v5, v6, :cond_3

    .line 84
    .end local v1    # "result":Ljava/lang/Object;, "TT;"
    :goto_1
    return-object v1

    .line 71
    .end local v4    # "tries":I
    .restart local v5    # "tries":I
    :catch_0
    move-exception v0

    .line 72
    .local v0, "e":Ljava/lang/InterruptedException;
    invoke-static {v0}, Lcom/amazon/zeroes/intentservice/utils/ZeroesMeasurementUtils;->fromThrowable(Ljava/lang/Throwable;)Lcom/amazon/sdk/availability/Measurement;

    move-result-object v6

    invoke-static {v6}, Lcom/amazon/zeroes/intentservice/Metrics;->putMeasurement(Lcom/amazon/sdk/availability/Measurement;)V

    move v4, v5

    .line 73
    .end local v5    # "tries":I
    .restart local v4    # "tries":I
    goto :goto_1

    .line 79
    .end local v0    # "e":Ljava/lang/InterruptedException;
    .end local v4    # "tries":I
    .restart local v1    # "result":Ljava/lang/Object;, "TT;"
    .restart local v5    # "tries":I
    :cond_2
    iget-object v6, p0, Lcom/amazon/zeroes/intentservice/command/RetryCommand;->validator:Lcom/amazon/zeroes/intentservice/command/RetryCommand$Validator;

    invoke-interface {v6, v1}, Lcom/amazon/zeroes/intentservice/command/RetryCommand$Validator;->validate(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_1

    move v4, v5

    .line 80
    .end local v5    # "tries":I
    .restart local v4    # "tries":I
    goto :goto_1

    :cond_3
    move v5, v4

    .end local v4    # "tries":I
    .restart local v5    # "tries":I
    goto :goto_0
.end method
