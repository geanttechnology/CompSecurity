.class final Lcom/a/b/ah;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic a:Ljava/lang/Exception;

.field final synthetic b:Lcom/a/b/ag;


# direct methods
.method constructor <init>(Lcom/a/b/ag;Ljava/lang/Exception;)V
    .locals 0

    .prologue
    .line 357
    iput-object p1, p0, Lcom/a/b/ah;->b:Lcom/a/b/ag;

    iput-object p2, p0, Lcom/a/b/ah;->a:Ljava/lang/Exception;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 2

    .prologue
    .line 359
    new-instance v0, Ljava/lang/RuntimeException;

    iget-object v1, p0, Lcom/a/b/ah;->a:Ljava/lang/Exception;

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v0
.end method
