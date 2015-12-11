.class public Lcom/poshmark/http/PMHttpError;
.super Ljava/lang/Object;
.source "PMHttpError.java"


# instance fields
.field public final exception:Ljava/lang/Throwable;


# direct methods
.method public constructor <init>(Ljava/lang/Throwable;)V
    .locals 0
    .param p1, "exception"    # Ljava/lang/Throwable;

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 13
    iput-object p1, p0, Lcom/poshmark/http/PMHttpError;->exception:Ljava/lang/Throwable;

    .line 14
    return-void
.end method
