.class public Lcom/damnhandy/uri/template/impl/VariableExpansionException;
.super Ljava/lang/RuntimeException;
.source "VariableExpansionException.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 29
    invoke-direct {p0}, Ljava/lang/RuntimeException;-><init>()V

    .line 32
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 41
    invoke-direct {p0, p1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    .line 42
    return-void
.end method

.method public constructor <init>(Ljava/lang/Throwable;)V
    .locals 0
    .param p1, "cause"    # Ljava/lang/Throwable;

    .prologue
    .line 51
    invoke-direct {p0, p1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    .line 52
    return-void
.end method
