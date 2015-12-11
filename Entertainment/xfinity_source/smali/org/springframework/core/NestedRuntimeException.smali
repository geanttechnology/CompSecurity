.class public abstract Lorg/springframework/core/NestedRuntimeException;
.super Ljava/lang/RuntimeException;
.source "NestedRuntimeException.java"


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 46
    const-class v0, Lorg/springframework/core/NestedExceptionUtils;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    .line 47
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    .line 55
    invoke-direct {p0, p1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    .line 56
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 0
    .param p1, "msg"    # Ljava/lang/String;
    .param p2, "cause"    # Ljava/lang/Throwable;

    .prologue
    .line 65
    invoke-direct {p0, p1, p2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 66
    return-void
.end method


# virtual methods
.method public getMessage()Ljava/lang/String;
    .locals 2

    .prologue
    .line 75
    invoke-super {p0}, Ljava/lang/RuntimeException;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lorg/springframework/core/NestedRuntimeException;->getCause()Ljava/lang/Throwable;

    move-result-object v1

    invoke-static {v0, v1}, Lorg/springframework/core/NestedExceptionUtils;->buildMessage(Ljava/lang/String;Ljava/lang/Throwable;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
