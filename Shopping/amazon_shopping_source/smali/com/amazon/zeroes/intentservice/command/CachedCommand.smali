.class public Lcom/amazon/zeroes/intentservice/command/CachedCommand;
.super Ljava/lang/Object;
.source "CachedCommand.java"

# interfaces
.implements Lcom/amazon/zeroes/intentservice/command/ZeroesCommand;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/zeroes/intentservice/command/CachedCommand$ConversionException;,
        Lcom/amazon/zeroes/intentservice/command/CachedCommand$Converter;
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
.field private final cache:Lcom/amazon/zeroes/intentservice/persistence/ZeroesCache;

.field private final cacheItemAge:J

.field private final cacheItemName:Ljava/lang/String;

.field private final command:Lcom/amazon/zeroes/intentservice/command/ZeroesCommand;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/zeroes/intentservice/command/ZeroesCommand",
            "<TT;>;"
        }
    .end annotation
.end field

.field private final converter:Lcom/amazon/zeroes/intentservice/command/CachedCommand$Converter;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/zeroes/intentservice/command/CachedCommand$Converter",
            "<TT;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/lang/String;JLcom/amazon/zeroes/intentservice/persistence/ZeroesCache;Lcom/amazon/zeroes/intentservice/command/ZeroesCommand;Lcom/amazon/zeroes/intentservice/command/CachedCommand$Converter;)V
    .locals 2
    .param p1, "cacheItemName"    # Ljava/lang/String;
    .param p2, "cacheItemAge"    # J
    .param p4, "cache"    # Lcom/amazon/zeroes/intentservice/persistence/ZeroesCache;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "J",
            "Lcom/amazon/zeroes/intentservice/persistence/ZeroesCache;",
            "Lcom/amazon/zeroes/intentservice/command/ZeroesCommand",
            "<TT;>;",
            "Lcom/amazon/zeroes/intentservice/command/CachedCommand$Converter",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 44
    .local p0, "this":Lcom/amazon/zeroes/intentservice/command/CachedCommand;, "Lcom/amazon/zeroes/intentservice/command/CachedCommand<TT;>;"
    .local p5, "command":Lcom/amazon/zeroes/intentservice/command/ZeroesCommand;, "Lcom/amazon/zeroes/intentservice/command/ZeroesCommand<TT;>;"
    .local p6, "converter":Lcom/amazon/zeroes/intentservice/command/CachedCommand$Converter;, "Lcom/amazon/zeroes/intentservice/command/CachedCommand$Converter<TT;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 46
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 47
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string/jumbo v1, "cacheItemName must not be empty"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 50
    :cond_0
    if-nez p4, :cond_1

    .line 51
    new-instance v0, Ljava/lang/NullPointerException;

    const-string/jumbo v1, "cache must not be null"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 54
    :cond_1
    if-nez p5, :cond_2

    .line 55
    new-instance v0, Ljava/lang/NullPointerException;

    const-string/jumbo v1, "command must not be null"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 58
    :cond_2
    if-nez p6, :cond_3

    .line 59
    new-instance v0, Ljava/lang/NullPointerException;

    const-string/jumbo v1, "converter must not be null"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 62
    :cond_3
    iput-object p1, p0, Lcom/amazon/zeroes/intentservice/command/CachedCommand;->cacheItemName:Ljava/lang/String;

    .line 63
    iput-wide p2, p0, Lcom/amazon/zeroes/intentservice/command/CachedCommand;->cacheItemAge:J

    .line 64
    iput-object p4, p0, Lcom/amazon/zeroes/intentservice/command/CachedCommand;->cache:Lcom/amazon/zeroes/intentservice/persistence/ZeroesCache;

    .line 65
    iput-object p5, p0, Lcom/amazon/zeroes/intentservice/command/CachedCommand;->command:Lcom/amazon/zeroes/intentservice/command/ZeroesCommand;

    .line 66
    iput-object p6, p0, Lcom/amazon/zeroes/intentservice/command/CachedCommand;->converter:Lcom/amazon/zeroes/intentservice/command/CachedCommand$Converter;

    .line 67
    return-void
.end method


# virtual methods
.method public perform()Ljava/lang/Object;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .line 74
    .local p0, "this":Lcom/amazon/zeroes/intentservice/command/CachedCommand;, "Lcom/amazon/zeroes/intentservice/command/CachedCommand<TT;>;"
    iget-object v3, p0, Lcom/amazon/zeroes/intentservice/command/CachedCommand;->cache:Lcom/amazon/zeroes/intentservice/persistence/ZeroesCache;

    iget-object v4, p0, Lcom/amazon/zeroes/intentservice/command/CachedCommand;->cacheItemName:Ljava/lang/String;

    invoke-interface {v3, v4}, Lcom/amazon/zeroes/intentservice/persistence/ZeroesCache;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 75
    .local v0, "cachedValue":Ljava/lang/String;
    if-eqz v0, :cond_1

    .line 77
    :try_start_0
    iget-object v3, p0, Lcom/amazon/zeroes/intentservice/command/CachedCommand;->converter:Lcom/amazon/zeroes/intentservice/command/CachedCommand$Converter;

    invoke-interface {v3, v0}, Lcom/amazon/zeroes/intentservice/command/CachedCommand$Converter;->fromString(Ljava/lang/String;)Ljava/lang/Object;
    :try_end_0
    .catch Lcom/amazon/zeroes/intentservice/command/CachedCommand$ConversionException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 88
    :cond_0
    :goto_0
    return-object v2

    .line 78
    :catch_0
    move-exception v1

    .line 79
    .local v1, "e":Lcom/amazon/zeroes/intentservice/command/CachedCommand$ConversionException;
    iget-object v3, p0, Lcom/amazon/zeroes/intentservice/command/CachedCommand;->cache:Lcom/amazon/zeroes/intentservice/persistence/ZeroesCache;

    iget-object v4, p0, Lcom/amazon/zeroes/intentservice/command/CachedCommand;->cacheItemName:Ljava/lang/String;

    invoke-interface {v3, v4}, Lcom/amazon/zeroes/intentservice/persistence/ZeroesCache;->invalidate(Ljava/lang/String;)Z

    .line 83
    .end local v1    # "e":Lcom/amazon/zeroes/intentservice/command/CachedCommand$ConversionException;
    :cond_1
    iget-object v3, p0, Lcom/amazon/zeroes/intentservice/command/CachedCommand;->command:Lcom/amazon/zeroes/intentservice/command/ZeroesCommand;

    invoke-interface {v3}, Lcom/amazon/zeroes/intentservice/command/ZeroesCommand;->perform()Ljava/lang/Object;

    move-result-object v2

    .line 84
    .local v2, "newValue":Ljava/lang/Object;, "TT;"
    if-eqz v2, :cond_0

    .line 85
    iget-object v3, p0, Lcom/amazon/zeroes/intentservice/command/CachedCommand;->cache:Lcom/amazon/zeroes/intentservice/persistence/ZeroesCache;

    iget-object v4, p0, Lcom/amazon/zeroes/intentservice/command/CachedCommand;->cacheItemName:Ljava/lang/String;

    iget-object v5, p0, Lcom/amazon/zeroes/intentservice/command/CachedCommand;->converter:Lcom/amazon/zeroes/intentservice/command/CachedCommand$Converter;

    invoke-interface {v5, v2}, Lcom/amazon/zeroes/intentservice/command/CachedCommand$Converter;->toString(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    iget-wide v6, p0, Lcom/amazon/zeroes/intentservice/command/CachedCommand;->cacheItemAge:J

    invoke-interface {v3, v4, v5, v6, v7}, Lcom/amazon/zeroes/intentservice/persistence/ZeroesCache;->put(Ljava/lang/String;Ljava/lang/String;J)Z

    goto :goto_0
.end method
